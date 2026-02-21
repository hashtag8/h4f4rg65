package defpackage;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

/* JADX INFO: loaded from: classes.dex */
public final class ey {
    private Object a;

    private ey(Object obj) {
        this.a = obj;
    }

    public Object a() {
        return this.a;
    }

    public static ey a(Context context, int i) {
        return Build.VERSION.SDK_INT >= 24 ? new ey(PointerIcon.getSystemIcon(context, i)) : new ey(null);
    }
}
