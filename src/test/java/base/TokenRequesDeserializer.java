package base;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class TokenRequesDeserializer extends StdDeserializer<TokenModel> {

	public TokenRequesDeserializer() {
		super((Class<TokenModel>) null);
	}

	@Override
	public TokenModel deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
		TokenModel tokenModel = new TokenModel();
		JsonNode bodyDTO = jsonParser.getCodec().readTree(jsonParser);
        //requestFoadAppDTO.setServiceName(bodyDTO.get("serviceName").toString().replaceAll("\"", Matcher.quoteReplacement("")));
        //requestFoadAppDTO.setMethodType(bodyDTO.get("methodType").toString().replaceAll("\"", Matcher.quoteReplacement("")));
		tokenModel.setAccess_token(bodyDTO.get("access_token") != null ? bodyDTO.get("access_token").toString() : "");
		//tokenModel.setAccess_token(jsonParser.getCodec().readValues(TokenModel.class));

		return tokenModel;
	}

	/*@Override
	public void Deserialize(TokenModel tokenModel, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
		JsonNode productNode = new ObjectMapper().readTree(tokenModel.getParam());

		jsonGenerator.writeStartObject();
		jsonGenerator.writeObjectField("param", productNode);
		jsonGenerator.writeEndObject();
	}*/
}
