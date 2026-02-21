package defpackage;

import android.content.Context;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class aae {
    private static Pattern a = null;

    public static int a(int i) {
        return i / 1000;
    }

    public static boolean a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static int b(int i) {
        return (i % 1000) / 100;
    }

    public static boolean c(int i) {
        return b(i) == 3;
    }
}
