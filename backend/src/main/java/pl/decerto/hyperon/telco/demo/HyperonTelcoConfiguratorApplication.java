package pl.decerto.hyperon.telco.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HyperonTelcoConfiguratorApplication extends SpringBootServletInitializer {

	@Override protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(HyperonTelcoConfiguratorApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(HyperonTelcoConfiguratorApplication.class, args);
	}

}
