package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public abstract class gm {
    private static int a = -1;
    private static boolean b = false;

    public abstract <T extends View> T a(int i);

    public abstract gi a();

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public abstract void a(Toolbar toolbar);

    public abstract void a(View view);

    public abstract void a(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void a(CharSequence charSequence);

    public abstract MenuInflater b();

    public abstract void b(int i);

    public abstract void b(Bundle bundle);

    public abstract void b(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void c();

    public abstract void c(Bundle bundle);

    public abstract boolean c(int i);

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract boolean i();

    public static gm a(Activity activity, gl glVar) {
        return a(activity, activity.getWindow(), glVar);
    }

    public static gm a(Dialog dialog, gl glVar) {
        return a(dialog.getContext(), dialog.getWindow(), glVar);
    }

    private static gm a(Context context, Window window, gl glVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new go(context, window, glVar);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return new gr(context, window, glVar);
        }
        if (Build.VERSION.SDK_INT >= 14) {
            return new gq(context, window, glVar);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new gp(context, window, glVar);
        }
        return new gs(context, window, glVar);
    }

    gm() {
    }

    public static int j() {
        return a;
    }

    public static boolean k() {
        return b;
    }
}
