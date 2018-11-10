package br.com.ithiago.camelresttest;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CamelRestApplication {

	@Value("${camel.api.path}")
	private String contextPath;

	public static void main(String[] args) {
		SpringApplication.run(CamelRestApplication.class, args);
	}

	@Bean
	ServletRegistrationBean servletRegistrationBean() {
		String fullContextPath = contextPath  + "/*";

		ServletRegistrationBean servlet = new ServletRegistrationBean(new CamelHttpTransportServlet(), fullContextPath);
		servlet.setName("CamelServlet");

		return servlet;
	}

}

