package defpackage;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
@yx
public class xa {
    private final Object a = new Object();
    private boolean b = false;
    private SharedPreferences c = null;

    public <T> T a(wx<T> wxVar) {
        synchronized (this.a) {
            if (this.b) {
                return wxVar.a(this.c);
            }
            return wxVar.b();
        }
    }
}
