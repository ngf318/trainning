package com.amor.testaug.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

/**
 * Created by neil on  2021/9/11
 */
public class Utils {
    public static String getEmulatorInfo(Context context) {
        return "Build.FINGERPRINT:" + Build.FINGERPRINT
                + "\nBuild.MODEL:" + Build.MODEL
                + "\nBuild.SERIAL:" + Build.SERIAL
                + "\nBuild.MANUFACTURER:" + Build.MANUFACTURER
                + "\nBuild.BRAND:" + Build.BRAND
                + "\nBuild.DEVICE:" +  Build.DEVICE
                + "\nBuild.PRODUCT:" + Build.PRODUCT
                + "\nBuild.BOARD:" + Build.BOARD
                + "\nBuild.BOOTLOADER:" + Build.BOOTLOADER
                + "\nBuild.TYPE:" + Build.TYPE
                + "\naaa:" + context.getFilesDir().getAbsolutePath()
                + "\nIMEI:" + ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getNetworkOperatorName();
    }

    public static boolean isEmulator(Context context) {
        return Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.toLowerCase().contains("vbox")
                || Build.FINGERPRINT.toLowerCase().contains("test-keys")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.SERIAL.equalsIgnoreCase("unknown")
                || Build.SERIAL.equalsIgnoreCase("android")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                || "google_sdk".equals(Build.PRODUCT)
                || ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE))
                .getNetworkOperatorName().toLowerCase().equals("android");
    }
}
