package ua.nure.hliebov.practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("Part4");
        System.out.println("============================");
        System.out.println(hash("password", "SHA-256"));
        System.out.println(hash("passwort", "SHA-256"));
        System.out.println("============================");
        System.out.println();
    }
    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        byte[] hashBytes = digest.digest(input.getBytes());

        StringBuilder result = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                result.append("0");
            }
            result.append(hex);
        }

        return result.toString();
    }
}
