package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ViewConfiguration;
import defpackage.ha;

/* JADX INFO: loaded from: classes.dex */
public class hg {
    private Context a;

    public static hg a(Context context) {
        return new hg(context);
    }

    private hg(Context context) {
        this.a = context;
    }

    public int a() {
        Configuration configuration = this.a.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600 || ((i > 960 && i2 > 720) || (i > 720 && i2 > 960))) {
            return 5;
        }
        if (i >= 500 || ((i > 640 && i2 > 480) || (i > 480 && i2 > 640))) {
            return 4;
        }
        if (i >= 360) {
            return 3;
        }
        return 2;
    }

    public boolean b() {
        return Build.VERSION.SDK_INT >= 19 || !ViewConfiguration.get(this.a).hasPermanentMenuKey();
    }

    public int c() {
        return this.a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean d() {
        return this.a.getResources().getBoolean(ha.b.abc_action_bar_embed_tabs);
    }

    public int e() {
        TypedArray typedArrayObtainStyledAttributes = this.a.obtainStyledAttributes(null, ha.j.ActionBar, ha.a.actionBarStyle, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(ha.j.ActionBar_height, 0);
        Resources resources = this.a.getResources();
        if (!d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(ha.d.abc_action_bar_stacked_max_height));
        }
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean f() {
        return this.a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int g() {
        return this.a.getResources().getDimensionPixelSize(ha.d.abc_action_bar_stacked_tab_max_width);
    }
}
