package defpackage;

import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class azf extends azi {
    private int a;
    private ArrayList<String> b;
    private String c;
    private String d;
    private String e;
    private String f;

    @Override // defpackage.azi
    public void a(JSONObject jSONObject) {
        this.a = b(jSONObject, "length");
        this.d = a(jSONObject, "artist");
        this.e = a(jSONObject, "icon");
        this.c = a(jSONObject, "name");
        this.f = a(jSONObject, "key");
        this.b = c(jSONObject, "trackKeys");
    }

    public int b() {
        return this.a;
    }

    public ArrayList<String> c() {
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

    public String f() {
        return this.f;
    }
}
