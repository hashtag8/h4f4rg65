package defpackage;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class lb {
    private static boolean a = false;

    public static long a() {
        return ((Runtime.getRuntime().maxMemory() - (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())) / 1024) / 1024;
    }

    public static boolean a(Context context) {
        try {
            System.loadLibrary("avutil");
            System.loadLibrary("avcodec");
            System.loadLibrary("avformat");
            a = true;
        } catch (UnsatisfiedLinkError e) {
            a = false;
        }
        try {
            System.loadLibrary("blackfire");
            return true;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            if (context == null) {
                return false;
            }
            String str = String.valueOf(context.getApplicationInfo().dataDir) + "/bfrx/debug/armeabi";
            try {
                ble.a(context.getAssets().open("armeabi.jar"), str);
                try {
                    System.load(String.valueOf(str) + "/libavutil.so");
                    System.load(String.valueOf(str) + "/libavcodec.so");
                    System.load(String.valueOf(str) + "/libavformat.so");
                    a = true;
                } catch (UnsatisfiedLinkError e3) {
                    a = false;
                }
                try {
                    System.load(String.valueOf(str) + "/libblackfire.so");
                    return true;
                } catch (UnsatisfiedLinkError e4) {
                    e4.printStackTrace();
                    return false;
                }
            } catch (IOException e5) {
                e5.getMessage();
                e5.printStackTrace();
                return false;
            }
        }
    }
}
