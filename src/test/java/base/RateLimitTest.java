package base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.site.base.model.UserPostDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

//----SpringBoot
/*@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ir.jame.numbering.NumberingInitializer.class})
@TestPropertySource("classpath:/application.properties")*/
//------

//----Without SpringBoot
//@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RateLimitTest {

	private final int CALL_SERVICE_LIMITATION = 5;

	private final String SERVICE_URL = "http://127.0.0.1:8080/numbering/plt-key-dana-demo/";
	private final String TOKEN_URL = "http://127.0.0.1/portal/oauth/token";
	private final String CLIENT_ID = "numbering";
	private final String CLIENT_SECRET = "numbering-changeitinportal";
	private final String USERNAME = "root";
	private final String PASSWORD = "root";
	private final String GRANT_TYPE = "password";
	private TokenModel TOKEN = null;

	private RestTemplate restTemplate;
	private ObjectMapper objectMapper;
	private HttpHeaders commonHeaders;

	@Before()
	public void init(){
		restTemplate = new RestTemplate();
		objectMapper = new ObjectMapper();
		commonHeaders = new HttpHeaders();

		TOKEN = getToken();
	}

	@Test
	public void LoadTest(){
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
		parameters.set("name","تست دانا");

		for(int i = 0 ; i<=10 ; i++) {
			if(i <= CALL_SERVICE_LIMITATION) {
				try {
					sendGETRequest(SERVICE_URL, parameters);
				} catch (HttpClientErrorException e) {
					if(e.getStatusCode().value() == 429) {  // 429 = TOO_MANY_REQUESTS
						Assert.assertTrue(true); // Test is done
						return;
					}
					else
						Assert.assertTrue(false);// Test is failed

					e.printStackTrace();
					break;
				} catch (Exception e){
					Assert.assertTrue(false);// Test is failed
					e.printStackTrace();
					break;
				}
			}else {
				Assert.assertTrue(false);// Test is failed
				break;
			}
		}

	}

	private HttpHeaders getTokenHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
		headers.addAll(commonHeaders);
		return headers;
	}

	private TokenModel getToken() {
		TokenModel Token = null;
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
		parameters.add("client_id",CLIENT_ID);
		parameters.add("client_secret",CLIENT_SECRET);
		parameters.add("username",USERNAME);
		parameters.add("password",PASSWORD);
		parameters.add("grant_type",GRANT_TYPE);

		try {
			HttpEntity<UserPostDto> request = new HttpEntity(parameters, this.getTokenHeader());
			ResponseEntity<String> response = restTemplate.exchange(TOKEN_URL , HttpMethod.POST, request, String.class);
			if (HttpStatus.OK.equals(response.getStatusCode())) {
				String body = response.getBody();
				return convertResponseToTokenModel(body);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	private HttpHeaders getHeaders(boolean hasToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
		if(hasToken)
			headers.add("Authorization", "Bearer " + TOKEN.getAccess_token());
		headers.add("Content-Type", "application/json");
		headers.addAll(commonHeaders);
		return headers;
	}

	private void sendGETRequest(String URL ,MultiValueMap<String, String> parameters) throws Exception{

		HttpEntity<UserPostDto> request = new HttpEntity(parameters, this.getHeaders(true));
		ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, request, String.class);
		if (HttpStatus.OK.equals(response.getStatusCode())) {
			response.getBody();
		}
	}

	private TokenModel convertResponseToTokenModel(String responseBody) {
		JavaType type = objectMapper.getTypeFactory().constructType(TokenModel.class);
		try {
			TokenModel res = objectMapper.readValue(responseBody, type);
			return res;
		} catch (JsonProcessingException e) {
			e.printStackTrace();

		}
		return null;
	}
}
