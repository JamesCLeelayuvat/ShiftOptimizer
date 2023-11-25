package main.java.Controller.Security;

import io.jsonwebtoken.Claims;

import main.java.Controller.Security.BouncyCastle;
import java.util.UUID;

import main.java.Model.Token;
public class AuthToken {
    private static String decryptedCode;

    public static Token buildToken(String username){
        decryptedCode = generateRandomCode(10);
        return new Token(username, BouncyCastle.hashPassword(decryptedCode));
    }

    public static String verifyToken(Token token){
        if(token.getEncryptedPassword().equals(BouncyCastle.hashPassword(decryptedCode))){
            return token.getUsername();
        }
        else return null;
    }

    public static String generateRandomCode(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }

        // Generate a random UUID
        UUID uuid = UUID.randomUUID();

        // Convert the UUID to a string and remove hyphens
        String alphanumericCode = uuid.toString().replace("-", "");

        // Take the first 'length' characters
        return alphanumericCode.substring(0, Math.min(length, alphanumericCode.length()));
    }
}
