package defpackage;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bak implements Serializable {
    public long a;
    public final Map<String, String> b;
    private String c;
    private String d;
    private String e;
    private String f;

    public bak(String str, String str2, String str3) {
        this(str, str2, str3, null, 0L);
    }

    public bak(String str, String str2, String str3, String str4, long j) {
        this.b = new HashMap();
        this.c = str == null ? "OAuth" : str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.a = j;
    }

    public bak(JSONObject jSONObject) throws IOException {
        this.b = new HashMap();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String string = itKeys.next().toString();
                if ("token_type".equals(string)) {
                    this.c = jSONObject.getString(string);
                } else if ("access_token".equals(string)) {
                    this.d = jSONObject.getString(string);
                } else if ("refresh_token".equals(string)) {
                    this.e = jSONObject.getString(string);
                } else if ("expires_in".equals(string)) {
                    this.a = System.currentTimeMillis() + (jSONObject.getLong(string) * 1000);
                } else if ("scope".equals(string)) {
                    this.f = jSONObject.getString(string);
                } else {
                    this.b.put(string, jSONObject.get(string).toString());
                }
            }
            this.c = this.c == null ? "OAuth" : this.c;
        } catch (JSONException e) {
            throw new IOException(e.getMessage());
        }
    }

    public void a() {
        this.d = null;
    }

    public boolean a(String str) {
        if (this.f == null) {
            return false;
        }
        for (String str2 : this.f.split(" ")) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean b() {
        return this.d != null && (a("non-expiring") || this.e != null);
    }

    public String toString() {
        return "Token{token_type='" + this.c + "', access='" + this.d + "', refresh='" + this.e + "', scope='" + this.f + "', expires='" + this.a + "'}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof bak) {
            bak bakVar = (bak) obj;
            if (this.c == null ? bakVar.c != null : !this.c.equals(bakVar.c)) {
                return false;
            }
            if (this.d == null ? bakVar.d != null : !this.d.equals(bakVar.d)) {
                return false;
            }
            if (this.e == null ? bakVar.e != null : !this.e.equals(bakVar.e)) {
                return false;
            }
            if (this.f == null ? bakVar.f != null : !this.f.equals(bakVar.f)) {
                return false;
            }
            if (this.a != 0) {
                if (this.a == bakVar.a) {
                    return true;
                }
            } else if (bakVar.a == 0) {
                return true;
            }
            return false;
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return (((this.e != null ? this.e.hashCode() : 0) + ((this.d != null ? this.d.hashCode() : 0) * 31)) * 31) + (this.f != null ? this.f.hashCode() : 0);
    }

    public String c() {
        return this.c == null ? "OAuth" : this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }
}
