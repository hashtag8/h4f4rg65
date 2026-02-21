package defpackage;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class aaz extends aas<aaz> {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    private String f;

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    @Override // defpackage.aas
    public void a(aaz aazVar) {
        if (this.a != 0) {
            aazVar.a(this.a);
        }
        if (this.b != 0) {
            aazVar.b(this.b);
        }
        if (this.c != 0) {
            aazVar.c(this.c);
        }
        if (this.d != 0) {
            aazVar.d(this.d);
        }
        if (this.e != 0) {
            aazVar.e(this.e);
        }
        if (TextUtils.isEmpty(this.f)) {
            return;
        }
        aazVar.a(this.f);
    }

    public void a(String str) {
        this.f = str;
    }

    public int b() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    public int c() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }

    public int d() {
        return this.d;
    }

    public void d(int i) {
        this.d = i;
    }

    public int e() {
        return this.e;
    }

    public void e(int i) {
        this.e = i;
    }

    public String f() {
        return this.f;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("language", this.f);
        map.put("screenColors", Integer.valueOf(this.a));
        map.put("screenWidth", Integer.valueOf(this.b));
        map.put("screenHeight", Integer.valueOf(this.c));
        map.put("viewportWidth", Integer.valueOf(this.d));
        map.put("viewportHeight", Integer.valueOf(this.e));
        return a((Object) map);
    }
}
