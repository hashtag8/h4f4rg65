package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class kx extends Resources {
    private final WeakReference<Context> a;

    public static boolean a() {
        return gm.k() && Build.VERSION.SDK_INT <= 20;
    }

    public kx(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.a = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        Context context = this.a.get();
        return context != null ? ix.a().a(context, this, i) : super.getDrawable(i);
    }

    final Drawable a(int i) {
        return super.getDrawable(i);
    }
}
