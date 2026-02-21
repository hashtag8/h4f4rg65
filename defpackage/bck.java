package defpackage;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bck implements Serializable {
    public String a;
    public String b;
    public String c;
    public long d;
    public final Map<String, String> e;

    public bck(String str, String str2) {
        this(str, str2, null);
    }

    public bck(String str, String str2, String str3) {
        this.e = new HashMap();
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public bck(JSONObject jSONObject) throws IOException {
        this.e = new HashMap();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String string = itKeys.next().toString();
                if ("access_token".equals(string)) {
                    this.a = jSONObject.getString(string);
                } else if ("refresh_token".equals(string)) {
                    this.b = jSONObject.getString(string);
                } else if ("expires_in".equals(string)) {
                    this.d = System.currentTimeMillis() + (jSONObject.getLong(string) * 1000);
                } else if ("scope".equals(string)) {
                    this.c = jSONObject.getString(string);
                } else {
                    this.e.put(string, jSONObject.get(string).toString());
                }
            }
        } catch (JSONException e) {
            throw new IOException(e.getMessage());
        }
    }

    public void a() {
        this.a = null;
    }

    public Date b() {
        if (this.d == 0) {
            return null;
        }
        return new Date(this.d);
    }

    public boolean a(String str) {
        if (this.c == null) {
            return false;
        }
        for (String str2 : this.c.split(" ")) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean c() {
        return this.a != null && (a("non-expiring") || this.b != null);
    }

    public String toString() {
        return "Token{access='" + this.a + "', refresh='" + this.b + "', scope='" + this.c + "', expires=" + b() + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof bck) {
            bck bckVar = (bck) obj;
            if (this.a == null ? bckVar.a != null : !this.a.equals(bckVar.a)) {
                return false;
            }
            if (this.b == null ? bckVar.b != null : !this.b.equals(bckVar.b)) {
                return false;
            }
            if (this.c != null) {
                if (this.c.equals(bckVar.c)) {
                    return true;
                }
            } else if (bckVar.c == null) {
                return true;
            }
            return false;
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return (((this.b != null ? this.b.hashCode() : 0) + ((this.a != null ? this.a.hashCode() : 0) * 31)) * 31) + (this.c != null ? this.c.hashCode() : 0);
    }
}
