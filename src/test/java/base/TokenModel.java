package base;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonDeserialize(using = TokenRequesDeserializer.class)
public class TokenModel {
	private String access_token;
	private String token_type;
	private String expires_in;
	private String scope;
	private String jti;

}
