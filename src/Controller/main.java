package Controller;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.security.Security;

import static Controller.Security.BouncyCastle.*;

public class main {
    public static void main(String[] args) {
        initializeProvider();

        SecretKey secretKey = generateKey();
        Cipher cipher = createCipher();

    }
}
