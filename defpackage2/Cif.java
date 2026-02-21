package defpackage;

import android.content.Context;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: renamed from: if, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public final class Cif {
    public static Menu a(Context context, dc dcVar) {
        return new ig(context, dcVar);
    }

    public static MenuItem a(Context context, dd ddVar) {
        return Build.VERSION.SDK_INT >= 16 ? new ia(context, ddVar) : new hz(context, ddVar);
    }

    public static SubMenu a(Context context, de deVar) {
        return new ik(context, deVar);
    }
}
