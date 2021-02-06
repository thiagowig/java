package br.com.casadocodigo.loja.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

import redis.clients.jedis.JedisPoolConfig;

@EnableRedisHttpSession
@Configuration
public class RedisConfiguration extends AbstractHttpSessionApplicationInitializer {
	
	@Value("${redis.host}")
    private String redisHost;
	
	@Value("${redis.port}")
    private Integer redisPort;

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		System.out.println("############# : redisHost" + redisHost);
		System.out.println("############# : redisPort" + redisPort);
		
	    JedisPoolConfig pool = new JedisPoolConfig();
	    JedisConnectionFactory factory = new JedisConnectionFactory(pool);
	    factory.setHostName(redisHost);
	    factory.setPort(redisPort);
	    
	    return factory;
	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
	    RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    template.setKeySerializer(new StringRedisSerializer());
	    template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
	    
	    return template;
	}
	
	@Bean
	public ConfigureRedisAction configureRedisAction() {
	    return ConfigureRedisAction.NO_OP;
	}
	
}
