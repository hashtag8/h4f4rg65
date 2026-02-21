package defpackage;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class aaa extends aas<aaa> {
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private String f;
    private boolean g;
    private double h;

    public String a() {
        return this.a;
    }

    public void a(double d) {
        vq.b(d >= 0.0d && d <= 100.0d, "Sample rate must be between 0% and 100%");
        this.h = d;
    }

    @Override // defpackage.aas
    public void a(aaa aaaVar) {
        if (!TextUtils.isEmpty(this.a)) {
            aaaVar.a(this.a);
        }
        if (!TextUtils.isEmpty(this.b)) {
            aaaVar.b(this.b);
        }
        if (!TextUtils.isEmpty(this.c)) {
            aaaVar.c(this.c);
        }
        if (!TextUtils.isEmpty(this.d)) {
            aaaVar.d(this.d);
        }
        if (this.e) {
            aaaVar.a(true);
        }
        if (!TextUtils.isEmpty(this.f)) {
            aaaVar.e(this.f);
        }
        if (this.g) {
            aaaVar.b(this.g);
        }
        if (this.h != 0.0d) {
            aaaVar.a(this.h);
        }
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public void b(boolean z) {
        this.g = z;
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

    public void e(String str) {
        this.f = str;
    }

    public boolean e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public boolean g() {
        return this.g;
    }

    public double h() {
        return this.h;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("hitType", this.a);
        map.put("clientId", this.b);
        map.put("userId", this.c);
        map.put("androidAdId", this.d);
        map.put("AdTargetingEnabled", Boolean.valueOf(this.e));
        map.put("sessionControl", this.f);
        map.put("nonInteraction", Boolean.valueOf(this.g));
        map.put("sampleRate", Double.valueOf(this.h));
        return a((Object) map);
    }
}
