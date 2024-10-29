package org.vaadin.example;

import dev.restate.sdk.client.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestateConfig {

	@Bean
	public Client restateClient() {
		return Client.connect("http://localhost:8080");
	}
}