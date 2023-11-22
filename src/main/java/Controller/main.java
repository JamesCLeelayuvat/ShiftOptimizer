package main.java.Controller;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Security;
import javax.crypto.Cipher;


import static main.java.Controller.Security.BouncyCastle.*;

public class main {
    public static void initializeProvider() {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES", "BC");
        return keyGen.generateKey();
    }

    public static Cipher createCipher() throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        return cipher;
    }

    public static void main(String[] args) {
        String userPassword = "user123";
        String hashedPassword = hashPassword(userPassword);

        System.out.println("Original Password: " + userPassword);
        System.out.println("Hashed Password: " + hashedPassword);
    }
}
