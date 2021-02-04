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
	
	@Value("${aws.access.key}")
    private String awsAccessKey;
	
	@Value("${aws.secret.key}")
    private String awsSecretKey;
	
	@Value("${aws.region}")
    private String awsRegion;
	
	@Bean
	public BasicAWSCredentials basicAWSCredentials() {
		return new BasicAWSCredentials(awsAccessKey, awsSecretKey);
	}
	
	@Bean
	public AmazonS3 amazonS3() {
		return AmazonS3ClientBuilder
				.standard()
				.withRegion(awsRegion)
				.withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials()))
				.build();
	}

}
