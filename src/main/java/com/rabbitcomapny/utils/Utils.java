package com.rabbitcomapny.utils;

import com.rabbitcomapny.Passky;
import org.bukkit.ChatColor;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {

    public static String chat(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static String getConfig(String config){
        return chat(Passky.getInstance().getConf().getString(config));
    }

    public static String getMessages(String config){
        return chat(Passky.getInstance().getMess().getString(config));
    }

    public static String getPassword(String config){
        return chat(Passky.getInstance().getPass().getString(config));
    }

    public static String getHash(String password, String algorithm){
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance(algorithm);
            return bytesToHex(digest.digest(password.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            return password;
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
