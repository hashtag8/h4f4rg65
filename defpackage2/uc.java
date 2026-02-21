package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class uc {
    private final uf a;

    protected uc(uf ufVar) {
        vq.a(ufVar);
        this.a = ufVar;
    }

    private static String a(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Boolean) {
            return obj == Boolean.TRUE ? "true" : "false";
        }
        return obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
    }

    private void a(int i, String str, Object obj, Object obj2, Object obj3) {
        tu tuVarG = this.a != null ? this.a.g() : null;
        if (tuVarG != null) {
            tuVarG.a(i, str, obj, obj2, obj3);
            return;
        }
        String strA = uy.c.a();
        if (Log.isLoggable(strA, i)) {
            Log.println(i, strA, c(str, obj, obj2, obj3));
        }
    }

    protected static String c(String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        String strA = a(obj);
        String strA2 = a(obj2);
        String strA3 = a(obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(strA)) {
            sb.append(str2);
            sb.append(strA);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(strA2)) {
            sb.append(str2);
            sb.append(strA2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(strA3)) {
            sb.append(str2);
            sb.append(strA3);
        }
        return sb.toString();
    }

    protected uu A() {
        return this.a.r();
    }

    public boolean B() {
        return Log.isLoggable(uy.c.a(), 2);
    }

    public void a(String str, Object obj) {
        a(2, str, obj, null, null);
    }

    public void a(String str, Object obj, Object obj2) {
        a(2, str, obj, obj2, null);
    }

    public void a(String str, Object obj, Object obj2, Object obj3) {
        a(3, str, obj, obj2, obj3);
    }

    public void b(String str) {
        a(2, str, null, null, null);
    }

    public void b(String str, Object obj) {
        a(3, str, obj, null, null);
    }

    public void b(String str, Object obj, Object obj2) {
        a(3, str, obj, obj2, null);
    }

    public void b(String str, Object obj, Object obj2, Object obj3) {
        a(5, str, obj, obj2, obj3);
    }

    public void c(String str) {
        a(3, str, null, null, null);
    }

    public void c(String str, Object obj) {
        a(4, str, obj, null, null);
    }

    public void c(String str, Object obj, Object obj2) {
        a(5, str, obj, obj2, null);
    }

    public void d(String str) {
        a(4, str, null, null, null);
    }

    public void d(String str, Object obj) {
        a(5, str, obj, null, null);
    }

    public void d(String str, Object obj, Object obj2) {
        a(6, str, obj, obj2, null);
    }

    public void e(String str) {
        a(5, str, null, null, null);
    }

    public void e(String str, Object obj) {
        a(6, str, obj, null, null);
    }

    public void f(String str) {
        a(6, str, null, null, null);
    }

    public uf k() {
        return this.a;
    }

    protected void l() {
        if (q().a()) {
            throw new IllegalStateException("Call only supported on the client side");
        }
    }

    protected void m() {
        this.a.s();
    }

    protected aah n() {
        return this.a.d();
    }

    protected Context o() {
        return this.a.b();
    }

    protected tu p() {
        return this.a.f();
    }

    protected ur q() {
        return this.a.e();
    }

    protected aau r() {
        return this.a.h();
    }

    public th s() {
        return this.a.k();
    }

    protected ub t() {
        return this.a.i();
    }

    protected uv u() {
        return this.a.j();
    }

    protected ua v() {
        return this.a.l();
    }

    protected tx w() {
        return this.a.m();
    }

    protected un x() {
        return this.a.p();
    }

    protected to y() {
        return this.a.o();
    }

    protected uk z() {
        return this.a.q();
    }
}
