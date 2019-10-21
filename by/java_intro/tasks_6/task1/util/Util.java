package by.java_intro.tasks_6.task1.util;

import java.nio.charset.StandardCharsets;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {
    public static String getStringFromIntArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static String getHash(String pass) {
        byte[] encodedhash = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            encodedhash = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return bytesToHex(encodedhash);
    }

    public static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
        String hex = Integer.toHexString(0xff & hash[i]);
        if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}