package defpackage;

import android.app.Activity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class akr extends auz {
    public akr(int i, Activity activity) {
        this.a = i;
        this.b = activity;
    }

    @Override // defpackage.auz
    public boolean a() {
        String strTrim = aho.d("juke_access_token").trim();
        return ("".equals(strTrim) || strTrim == null) ? false : true;
    }

    @Override // defpackage.auz
    public void a(JSONObject jSONObject) {
        throw new IllegalStateException("This method shouldn't be called, use the other saveLogin method");
    }

    public void a(String str, String str2, String str3) {
        aho.a("juke_access_token", str);
        aho.a("juke_sts_access_token", str2);
        aho.a("juke_refresh_token", str3);
    }

    @Override // defpackage.auz
    public void b() {
        aho.a("juke_access_token", "");
        aho.a("juke_sts_access_token", "");
        aho.a("juke_refresh_token", "");
        d();
    }
}
