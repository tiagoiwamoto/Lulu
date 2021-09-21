package br.com.tiagoiwamoto.iwtlulu.util;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 21/09/2021 | 07:39
 */

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class EncryptUtil {

    /**
     * This class convert value to MD5
     * @param value
     * @return
     */
    public static String toMd5(String value) {
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(value.getBytes(StandardCharsets.UTF_8), 0, value.length());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        }catch (Exception e){
            return null;
        }
    }

}
