package defpackage;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class abc extends aas<abc> {
    private String a;
    private String b;
    private String c;
    private long d;

    public String a() {
        return this.a;
    }

    public void a(long j) {
        this.d = j;
    }

    @Override // defpackage.aas
    public void a(abc abcVar) {
        if (!TextUtils.isEmpty(this.a)) {
            abcVar.a(this.a);
        }
        if (!TextUtils.isEmpty(this.b)) {
            abcVar.b(this.b);
        }
        if (!TextUtils.isEmpty(this.c)) {
            abcVar.c(this.c);
        }
        if (this.d != 0) {
            abcVar.a(this.d);
        }
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public long d() {
        return this.d;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("category", this.a);
        map.put("action", this.b);
        map.put("label", this.c);
        map.put("value", Long.valueOf(this.d));
        return a((Object) map);
    }
}
