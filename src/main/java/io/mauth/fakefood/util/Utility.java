package io.mauth.fakefood.util;

import java.util.Random;

/**
 * Created by rahulb on 3/12/17.
 */
public class Utility {

    public static String getRandomName(){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr+".jpg";
    }

}
