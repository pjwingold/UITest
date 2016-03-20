package com.inteliment.pjwin.uitest.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by hans on 19-Mar-16.
 */
public class L {
    public static void toastShort(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void toastShort(Context context, CharSequence message) {
        toastShort(context, message.toString());
    }
}
