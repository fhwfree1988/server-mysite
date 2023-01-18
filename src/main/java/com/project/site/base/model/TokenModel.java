package com.project.site.base.model;

public class TokenModel {
	private String tokenValue;
	private String serviceName;

	public TokenModel(String tokenValue, String serviceName) {
		this.tokenValue = tokenValue;
		this.serviceName = serviceName;
	}

	public String getTokenValue() {
		return tokenValue;
	}
	/*public void setTokenValue(String token) {
		this.tokenValue = token;
	}*/

	public String getServiceName() {
		return serviceName;
	}
	/*public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}*/
}
