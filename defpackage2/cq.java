package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.widget.TextView;
import defpackage.cl;
import defpackage.ds;

/* JADX INFO: loaded from: classes.dex */
public class cq {
    private static final a a;
    private static final ea<String, Typeface> b;

    interface a {
        Typeface a(Context context, Resources resources, int i, String str, int i2);

        Typeface a(Context context, CancellationSignal cancellationSignal, ds.b[] bVarArr, int i);

        Typeface a(Context context, cl.b bVar, Resources resources, int i);
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            a = new ct();
        } else if (Build.VERSION.SDK_INT >= 24 && cs.a()) {
            a = new cs();
        } else if (Build.VERSION.SDK_INT >= 21) {
            a = new cr();
        } else {
            a = new cu();
        }
        b = new ea<>(16);
    }

    public static Typeface a(Resources resources, int i, int i2) {
        return b.a(b(resources, i, i2));
    }

    private static String b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface a(Context context, cl.a aVar, Resources resources, int i, int i2, TextView textView) {
        Typeface typefaceA;
        if (aVar instanceof cl.d) {
            cl.d dVar = (cl.d) aVar;
            typefaceA = ds.a(context, dVar.a(), textView, dVar.b(), dVar.c(), i2);
        } else {
            typefaceA = a.a(context, (cl.b) aVar, resources, i2);
        }
        if (typefaceA != null) {
            b.a(b(resources, i, i2), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface typefaceA = a.a(context, resources, i, str, i2);
        if (typefaceA != null) {
            b.a(b(resources, i, i2), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, ds.b[] bVarArr, int i) {
        return a.a(context, cancellationSignal, bVarArr, i);
    }
}
