package main.java.Controller.Security;

import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.encoders.Hex;

import static main.java.Controller.File.Jackson.getIndexFromUsername;
import static main.java.Controller.File.Jackson.getPasswordFromIndex;


public class BouncyCastle {
    public static String hashPassword(String plainTextPassword) {
        Digest digest = new SHA256Digest();
        byte[] data = plainTextPassword.getBytes();
        byte[] hash = new byte[digest.getDigestSize()];

        digest.update(data, 0, data.length);
        digest.doFinal(hash, 0);

        return new String(Hex.encode(hash));
    }

    public static boolean passwordMatches(String plainTextPassword, String hash){
        return hashPassword(plainTextPassword).equals(hash);
    }


    //THIS IS A TEST METHOD
    public static void loginTest(String username, String password){
        System.out.println(passwordMatches(password, getPasswordFromIndex(getIndexFromUsername(username))));
    }
}
