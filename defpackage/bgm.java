package defpackage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class bgm extends Exception {
    private static final Method a;
    private IOException b;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception e) {
            declaredMethod = null;
        }
        a = declaredMethod;
    }

    public bgm(IOException iOException) {
        super(iOException);
        this.b = iOException;
    }

    public IOException a() {
        return this.b;
    }

    public void a(IOException iOException) {
        a(iOException, this.b);
        this.b = iOException;
    }

    private void a(IOException iOException, IOException iOException2) {
        if (a != null) {
            try {
                a.invoke(iOException, iOException2);
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
            }
        }
    }
}
