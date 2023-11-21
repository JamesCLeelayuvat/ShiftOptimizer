package Controller.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Security;
import javax.crypto.Cipher;


public class BouncyCastle {
    public static void initializeProvider(){
        Security.addProvider(new BouncyCastleProvider());
    }


    public static SecretKey generateKey(){
        KeyGenerator keyGen = KeyGenerator.getInstance("AES", "BC");

        return keyGen.generateKey();

    }

    public static Cipher createCipher(){
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        return cipher;
    }

    public static void createCipher(){


    }
}
