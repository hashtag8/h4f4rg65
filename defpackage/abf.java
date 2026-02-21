package defpackage;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class abf extends aas<abf> {
    public String a;
    public String b;
    public String c;

    public String a() {
        return this.a;
    }

    @Override // defpackage.aas
    public void a(abf abfVar) {
        if (!TextUtils.isEmpty(this.a)) {
            abfVar.a(this.a);
        }
        if (!TextUtils.isEmpty(this.b)) {
            abfVar.b(this.b);
        }
        if (TextUtils.isEmpty(this.c)) {
            return;
        }
        abfVar.c(this.c);
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

    public String toString() {
        HashMap map = new HashMap();
        map.put("network", this.a);
        map.put("action", this.b);
        map.put("target", this.c);
        return a((Object) map);
    }
}
