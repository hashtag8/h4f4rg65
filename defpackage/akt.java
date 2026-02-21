package defpackage;

import android.app.Activity;
import defpackage.ayg;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class akt extends auz {
    public akt(int i, Activity activity) {
        this.a = i;
        this.b = activity;
    }

    @Override // defpackage.auz
    public boolean a() {
        aho.a("mixradio_harman_ftu", false);
        String strD = aho.d("mixradio_refresh");
        mm.b("REFRESH_TOKEN", "" + strD);
        if (strD.compareTo("") == 0) {
            return false;
        }
        ayf.a().c = strD;
        return true;
    }

    @Override // defpackage.auz
    public void a(JSONObject jSONObject) {
        aho.a("mixradio_refresh", ayf.a().c);
        if (aho.d("mixradio_harman_ftu_artists") != null && aho.d("mixradio_harman_ftu_artists").compareTo("") != 0) {
            try {
                JSONArray jSONArray = new JSONArray(aho.d("mixradio_harman_ftu_artists"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    ayf.a().a(jSONArray.getJSONObject(i).optString("id"), (Boolean) true, (ayg.b) null);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            aho.a("mixradio_harman_ftu_artists", "");
            aho.a("mixradio_harman_ftu", false);
            aho.b("mixradio_ftu", true);
        }
    }

    @Override // defpackage.auz
    public void b() {
        aho.a("mixradio_refresh", "");
        aho.a("mixradio_country", "");
        ayf.a().c = "";
        ayf.a().e = "";
        ayf.a().d = "";
        ayf.a().a = "";
        d();
    }
}
