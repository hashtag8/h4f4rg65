package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class kp extends ContextWrapper {
    private static final Object a = new Object();
    private static ArrayList<WeakReference<kp>> b;
    private final Resources c;
    private final Resources.Theme d;

    public static Context a(Context context) {
        if (b(context)) {
            synchronized (a) {
                if (b == null) {
                    b = new ArrayList<>();
                } else {
                    for (int size = b.size() - 1; size >= 0; size--) {
                        WeakReference<kp> weakReference = b.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            b.remove(size);
                        }
                    }
                    for (int size2 = b.size() - 1; size2 >= 0; size2--) {
                        WeakReference<kp> weakReference2 = b.get(size2);
                        kp kpVar = weakReference2 != null ? weakReference2.get() : null;
                        if (kpVar != null && kpVar.getBaseContext() == context) {
                            return kpVar;
                        }
                    }
                }
                kp kpVar2 = new kp(context);
                b.add(new WeakReference<>(kpVar2));
                return kpVar2;
            }
        }
        return context;
    }

    private static boolean b(Context context) {
        if ((context instanceof kp) || (context.getResources() instanceof kr) || (context.getResources() instanceof kx)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || kx.a();
    }

    private kp(Context context) {
        super(context);
        if (kx.a()) {
            this.c = new kx(this, context.getResources());
            this.d = this.c.newTheme();
            this.d.setTo(context.getTheme());
        } else {
            this.c = new kr(this, context.getResources());
            this.d = null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        return this.d == null ? super.getTheme() : this.d;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.d == null) {
            super.setTheme(i);
        } else {
            this.d.applyStyle(i, true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.c.getAssets();
    }
}
