package defpackage;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;

/* JADX INFO: loaded from: classes.dex */
public abstract class wc<T> {
    private final String a;
    private T b;

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected wc(String str) {
        this.a = str;
    }

    protected final T a(Context context) throws a {
        if (this.b == null) {
            vq.a(context);
            Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
            if (remoteContext == null) {
                throw new a("Could not get remote context.");
            }
            try {
                this.b = b((IBinder) remoteContext.getClassLoader().loadClass(this.a).newInstance());
            } catch (ClassNotFoundException e) {
                throw new a("Could not load creator class.", e);
            } catch (IllegalAccessException e2) {
                throw new a("Could not access creator.", e2);
            } catch (InstantiationException e3) {
                throw new a("Could not instantiate creator.", e3);
            }
        }
        return this.b;
    }

    protected abstract T b(IBinder iBinder);
}
