package br.com.ithiago.sprinbootjwt.controller;

import org.apache.tomcat.util.codec.binary.Base64;

public class ENCODE {

    public static void main(String[] args) {
        byte[] encodedBytes = Base64.encodeBase64("ithiago".getBytes());
        System.out.println("encodedBytes " + new String(encodedBytes));
        byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
        System.out.println("decodedBytes " + new String(decodedBytes));
    }
}
