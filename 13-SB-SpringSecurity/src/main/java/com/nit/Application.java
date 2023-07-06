package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.client.WishClient;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		WishClient bean = ctx.getBean(WishClient.class);
		String invokeWishApi = bean.invokeWishApi();
		System.out.println("Response:::"+invokeWishApi);
	}

}
