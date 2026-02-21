package defpackage;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class bqn {
    private Activity a;
    private Object b;
    private boolean c;

    public bqn(Activity activity) {
        this.a = activity;
        try {
            activity.getClass().getMethod("getSupportActionBar", new Class[0]);
            this.c = true;
        } catch (NoSuchMethodException e) {
        }
        this.b = b();
    }

    private Object b() {
        if (this.c && Build.VERSION.SDK_INT < 14) {
            return bqo.a(this.a);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return bqp.a(this.a);
        }
        return null;
    }

    public void a(Drawable drawable, int i) {
        if (this.c && Build.VERSION.SDK_INT < 14) {
            bqo.a(this.b, this.a, drawable, i);
        } else if (Build.VERSION.SDK_INT >= 11) {
            bqp.a(this.b, this.a, drawable, i);
        }
    }

    public void a(int i) {
        if (this.c && Build.VERSION.SDK_INT < 14) {
            bqo.a(this.b, this.a, i);
        } else if (Build.VERSION.SDK_INT >= 11) {
            bqp.a(this.b, this.a, i);
        }
    }

    public Drawable a() {
        if (this.c && Build.VERSION.SDK_INT < 14) {
            return bqo.a(this.b);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return bqp.a(this.b, this.a);
        }
        return null;
    }

    public void a(boolean z) {
        if (this.c && Build.VERSION.SDK_INT < 14) {
            bqo.a(this.b, z);
        } else if (Build.VERSION.SDK_INT >= 11) {
            bqp.a(this.a, z);
        }
    }
}
