package br.com.ithiago.smalltests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import redis.clients.jedis.Jedis;

@Testcontainers
public class AppTest {

    @Container
    public GenericContainer redis = new GenericContainer(DockerImageName.parse("redis:5.0.3-alpine")).withExposedPorts(6379);

    private Jedis jedis;

    @BeforeEach
    public void setUp() {
        this.jedis = new Jedis(this.redis.getHost(), this.redis.getFirstMappedPort());
    }

    @Test
    public void testMe() {
        String key = "user_name";
        String value = "Thiago Fonseca";
        this.jedis.set(key, value);

        String result = this.jedis.get(key);

        Assert.assertEquals(value, result);
    }
}
