package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class blg implements blq {
    private int a;

    public blg(int i) {
        this.a = i;
    }

    public blg() {
        this.a = 4;
    }

    @Override // defpackage.blq
    public boolean a(String str, int i) {
        return this.a <= i;
    }

    @Override // defpackage.blq
    public void a(String str, String str2, Throwable th) {
        if (a(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    public void b(String str, String str2, Throwable th) {
        if (a(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    public void c(String str, String str2, Throwable th) {
        if (a(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    @Override // defpackage.blq
    public void d(String str, String str2, Throwable th) {
        if (a(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    @Override // defpackage.blq
    public void e(String str, String str2, Throwable th) {
        if (a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    @Override // defpackage.blq
    public void a(String str, String str2) {
        a(str, str2, (Throwable) null);
    }

    @Override // defpackage.blq
    public void b(String str, String str2) {
        b(str, str2, null);
    }

    @Override // defpackage.blq
    public void c(String str, String str2) {
        c(str, str2, null);
    }

    @Override // defpackage.blq
    public void d(String str, String str2) {
        d(str, str2, null);
    }

    @Override // defpackage.blq
    public void e(String str, String str2) {
        e(str, str2, null);
    }

    @Override // defpackage.blq
    public void a(int i, String str, String str2) {
        a(i, str, str2, false);
    }

    @Override // defpackage.blq
    public void a(int i, String str, String str2, boolean z) {
        if (z || a(str, i)) {
            Log.println(i, str, str2);
        }
    }
}
