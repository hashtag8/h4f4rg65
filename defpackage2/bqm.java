package defpackage;

import android.os.Build;
import android.view.View;
import net.simonvt.menudrawer.MenuDrawer;

/* JADX INFO: loaded from: classes.dex */
public final class bqm {
    public static int a(View view) {
        return MenuDrawer.q ? (int) (view.getLeft() + view.getTranslationX()) : view.getLeft();
    }

    public static int b(View view) {
        return MenuDrawer.q ? (int) (view.getTop() + view.getTranslationY()) : view.getTop();
    }

    public static int c(View view) {
        return MenuDrawer.q ? (int) (view.getRight() + view.getTranslationX()) : view.getRight();
    }

    public static int d(View view) {
        return MenuDrawer.q ? (int) (view.getBottom() + view.getTranslationY()) : view.getBottom();
    }

    public static int e(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }
}
