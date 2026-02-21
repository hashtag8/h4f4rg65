package defpackage;

import android.content.Context;
import android.graphics.BitmapFactory;

/* JADX INFO: loaded from: classes.dex */
public class bos {
    public final String a;
    public final int b;
    public final int c;
    public final int d;

    public bos(String str, int i, int i2, int i3) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    public static bos a(Context context, String str) {
        if (str != null) {
            try {
                int iL = bme.l(context);
                blh.h().a("Fabric", "App icon resource ID is " + iL);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), iL, options);
                return new bos(str, iL, options.outWidth, options.outHeight);
            } catch (Exception e) {
                blh.h().e("Fabric", "Failed to load icon", e);
            }
        }
        return null;
    }
}
