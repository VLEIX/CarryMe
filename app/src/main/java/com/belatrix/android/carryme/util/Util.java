package com.belatrix.android.carryme.util;

/**
 * Created by Flavio Franco Tunqui (VLEIX) on 1/30/17.
 * GOOODK
 */
public class Util {

    private Util() {
    }

    public static boolean isValidEmail(CharSequence target) {
        if (target == null)
            return false;

        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
