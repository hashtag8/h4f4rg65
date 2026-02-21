package defpackage;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class abg extends aas<abg> {
    public String a;
    public long b;
    public String c;
    public String d;

    public String a() {
        return this.a;
    }

    public void a(long j) {
        this.b = j;
    }

    @Override // defpackage.aas
    public void a(abg abgVar) {
        if (!TextUtils.isEmpty(this.a)) {
            abgVar.a(this.a);
        }
        if (this.b != 0) {
            abgVar.a(this.b);
        }
        if (!TextUtils.isEmpty(this.c)) {
            abgVar.b(this.c);
        }
        if (TextUtils.isEmpty(this.d)) {
            return;
        }
        abgVar.c(this.d);
    }

    public void a(String str) {
        this.a = str;
    }

    public long b() {
        return this.b;
    }

    public void b(String str) {
        this.c = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.d = str;
    }

    public String d() {
        return this.d;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("variableName", this.a);
        map.put("timeInMillis", Long.valueOf(this.b));
        map.put("category", this.c);
        map.put("label", this.d);
        return a((Object) map);
    }
}
