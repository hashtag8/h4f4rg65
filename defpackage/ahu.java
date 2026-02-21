package defpackage;

import android.content.Context;
import android.graphics.Typeface;

/* JADX INFO: loaded from: classes.dex */
public class ahu {
    private static Typeface a = null;
    private static Typeface b = null;

    public static Typeface a(Context context) {
        if (a == null) {
            a = Typeface.createFromAsset(context.getAssets(), "Roboto-Regular.ttf");
        }
        return a;
    }

    public static Typeface b(Context context) {
        if (b == null) {
            b = Typeface.createFromAsset(context.getAssets(), "Roboto-Bold.ttf");
        }
        return b;
    }
}
