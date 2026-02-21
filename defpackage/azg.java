package defpackage;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class azg extends azi {
    private int a;
    private int b;
    private String c;
    private String d;
    private String e;
    private String f;

    @Override // defpackage.azi
    public void a(JSONObject jSONObject) {
        this.b = b(jSONObject, "albumCount");
        this.a = b(jSONObject, "length");
        this.c = a(jSONObject, "key");
        this.f = a(jSONObject, "shortUrl");
        this.e = a(jSONObject, "icon");
        this.d = a(jSONObject, "name");
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.d;
    }

    @Override // defpackage.azi
    public String a() {
        return this.e;
    }
}
