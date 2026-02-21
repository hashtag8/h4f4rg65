package defpackage;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class ql {
    private String a;
    private Bundle b;
    private String c;
    private Object d;

    public ql(String str) {
        this(str, null, "GET");
    }

    public ql(String str, Bundle bundle, String str2) {
        this.d = this;
        if (!str2.equals("GET") && !str2.equals("POST") && !str2.equals("DELETE")) {
            throw new IllegalArgumentException("Http Method must match GET or POST or DELETE.");
        }
        this.a = str;
        this.b = bundle;
        if (this.b == null) {
            this.b = new Bundle();
        }
        this.c = str2;
        if ("POST".equals(this.c)) {
            bundle.putString("request_method", "POST");
        }
        if ("DELETE".equals(this.c)) {
            bundle.putString("request_method", "DELETE");
        }
        if (!"GET".equals(this.c) || bundle == null) {
            return;
        }
        bundle.putString("sdk", qr.a().d());
    }

    public String a() {
        return this.a;
    }

    public void a(Object obj) {
        this.d = obj;
    }

    public Bundle b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public Object d() {
        return this.d;
    }
}
