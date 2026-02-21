package defpackage;

import android.content.Context;
import com.harman.hkconnect.ui.HarmanApplication;

/* JADX INFO: loaded from: classes.dex */
public class afj {
    private static afj a;
    private static afo b;
    private static Context c;

    private afj(Context context) {
        c = context;
    }

    public static afj a(int i) {
        if (a == null) {
            a = new afj(HarmanApplication.a());
        }
        b = afi.a(i, c);
        return a;
    }

    public void a(afq afqVar) {
        b.a(afqVar);
    }

    public void a(afq afqVar, int i) {
        b.a(afqVar, i);
    }

    public void a(int i, int i2, String str) {
        b.d(i, i2, str);
    }

    public void b(int i, int i2, String str) {
        b.a(i, i2, str);
    }

    public void c(int i, int i2, String str) {
        b.b(i, i2, str);
    }

    public void d(int i, int i2, String str) {
        b.c(i, i2, str);
    }

    public void a(long j, int i, int i2) {
        b.b(j, i, i2);
    }

    public void b(long j, int i, int i2) {
        b.a(j, i, i2);
    }

    public void c(long j, int i, int i2) {
        b.c(j, i, i2);
    }

    public void d(long j, int i, int i2) {
        b.d(j, i, i2);
    }

    public long a() {
        return b.a();
    }

    public long b() {
        return b.b();
    }

    public long c() {
        return b.c();
    }

    public long d() {
        return b.e();
    }

    public long e() {
        return b.d();
    }

    public void e(int i, int i2, String str) {
        b.e(i, i2, str);
    }
}
