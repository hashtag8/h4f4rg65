package defpackage;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class aax extends aas<aax> {
    private String a;
    private String b;
    private String c;
    private String d;

    public String a() {
        return this.a;
    }

    @Override // defpackage.aas
    public void a(aax aaxVar) {
        if (!TextUtils.isEmpty(this.a)) {
            aaxVar.a(this.a);
        }
        if (!TextUtils.isEmpty(this.b)) {
            aaxVar.b(this.b);
        }
        if (!TextUtils.isEmpty(this.c)) {
            aaxVar.c(this.c);
        }
        if (TextUtils.isEmpty(this.d)) {
            return;
        }
        aaxVar.d(this.d);
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

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("appName", this.a);
        map.put("appVersion", this.b);
        map.put("appId", this.c);
        map.put("appInstallerId", this.d);
        return a((Object) map);
    }
}
