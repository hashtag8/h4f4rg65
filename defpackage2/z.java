package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import defpackage.ha;

/* JADX INFO: loaded from: classes.dex */
public class z {
    private static final int[] a = {ha.a.colorPrimary};

    public static void a(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(a);
        boolean z = typedArrayObtainStyledAttributes.hasValue(0) ? false : true;
        typedArrayObtainStyledAttributes.recycle();
        if (z) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
