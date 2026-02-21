package defpackage;

import android.app.Activity;
import defpackage.bdi;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class akx extends auz {
    public akx(int i, Activity activity) {
        this.a = i;
        this.b = activity;
    }

    @Override // defpackage.auz
    public boolean a() {
        String strTrim = aho.d("tidal_session_auth_token").trim();
        if ("".equals(strTrim) || strTrim == null) {
            return false;
        }
        String strTrim2 = aho.d("tidal_country_code").trim();
        if (strTrim2.compareTo("") == 0) {
            return false;
        }
        bdh.a().a(strTrim2);
        String strTrim3 = aho.d("tidal_sound_quality").trim();
        if (strTrim2.compareTo("") == 0) {
            return false;
        }
        bdh.a().b(strTrim3);
        return true;
    }

    @Override // defpackage.auz
    public void a(JSONObject jSONObject) {
        throw new IllegalStateException("Shouldn't use this method, use the other saveLogin method");
    }

    public void a(String str, String str2, String str3, String str4) {
        aho.a("tidal_user_auth_token", str);
        aho.a("tidal_session_auth_token", str2);
        aho.a("tidal_country_code", str3);
        aho.a("tidal_sound_quality", str4);
    }

    @Override // defpackage.auz
    public void b() {
        bdh.a().a(aho.d("tidal_session_auth_token"), new bdi.a() { // from class: akx.1
            @Override // bdi.a
            public void a(boolean z, String str, String str2, String str3, String str4, int i) {
                aho.a("tidal_session_auth_token", "");
                aho.a("tidal_user_auth_token", "");
                aho.a("tidal_country_code", "");
                aho.a("tidal_sound_quality", "");
            }
        });
        aho.a("tidal_session_auth_token", "");
        aho.a("tidal_user_auth_token", "");
        aho.a("tidal_country_code", "");
        aho.a("tidal_sound_quality", "");
        d();
    }
}
