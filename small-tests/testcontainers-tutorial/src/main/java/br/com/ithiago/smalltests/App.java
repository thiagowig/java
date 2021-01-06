package br.com.ithiago.smalltests;


import redis.clients.jedis.Jedis;

public class App {
    private Jedis jedis;

    public App(String host, int port) {
        this.jedis = new Jedis(host, port);
    }
}
