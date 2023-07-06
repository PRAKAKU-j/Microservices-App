 package com.nit.client;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WishClient {

	public String invokeWishApi() {
		String url="http://localhost:9090/wish";
		RestTemplate rt=new RestTemplate();
		rt.getInterceptors().add(new BasicAuthorizationInterceptor("krishan", "radha"));
		ResponseEntity<String> resEntity=rt.getForEntity(url,String.class);
		String body = resEntity.getBody();
		return body;
	}
}
