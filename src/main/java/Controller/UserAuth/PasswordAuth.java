package main.java.Controller.UserAuth;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.util.encoders.Hex;

public class PasswordAuth {
    public static boolean passwordMatches(String plainTextPassword, String hash){
        return hashPassword(plainTextPassword).equals(hash);
    }

    static String hashPassword(String plainTextPassword) {
        Digest digest = new SHA256Digest();
        byte[] data = plainTextPassword.getBytes();
        byte[] hash = new byte[digest.getDigestSize()];

        digest.update(data, 0, data.length);
        digest.doFinal(hash, 0);

        return new String(Hex.encode(hash));
    }

}
