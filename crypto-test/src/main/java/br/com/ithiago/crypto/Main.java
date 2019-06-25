package br.com.ithiago.crypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws Exception {

        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        SecretKey secretKey = keyGenerator.generateKey();

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

        byte[] text = "Nobody can see me".getBytes();

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] textEncrypted = cipher.doFinal(text);

        System.out.println("Text encrypted [byte]: " + textEncrypted);
        System.out.println("Text encrypted : " + new String(textEncrypted));

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] textDecrypted = cipher.doFinal(textEncrypted);

        System.out.println("Text decrypted [byte]: " + textDecrypted);
        System.out.println("Text decrypted : " + new String(textDecrypted));

    }
}
