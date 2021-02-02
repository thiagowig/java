package br.com.casadocodigo.loja.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonConfiguration {
	
    private static final String aws_access_key;
	
    private static final String aws_secret_key;
	
    private static final String aws_region;
    
    static {
    	aws_access_key = System.getenv("aws_access_key");
    	aws_secret_key = System.getenv("aws_secret_key");
    	aws_region = System.getenv("aws_region");
    }
	
	@Bean
	public BasicAWSCredentials basicAWSCredentials() {
		return new BasicAWSCredentials(aws_access_key, aws_secret_key);
	}
	
	@Bean
	public AmazonS3 amazonS3() {
		return AmazonS3ClientBuilder
				.standard()
				.withRegion(aws_region)
				.withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials()))
				.build();
	}

}
