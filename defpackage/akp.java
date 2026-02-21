package defpackage;

import android.app.Activity;
import com.harman.hkconnect.ui.HarmanApplication;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class akp extends auz {
    private qi c;

    public akp(int i, Activity activity) {
        this.a = i;
        this.b = activity;
    }

    @Override // defpackage.auz
    public boolean a() {
        qo qoVar = new qo();
        this.c = new qj("135461");
        return qoVar.b(this.c, HarmanApplication.a());
    }

    @Override // defpackage.auz
    public void a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("access_token")) {
            aho.a("access_token", jSONObject.optString("access_token"));
        }
        if (jSONObject != null && jSONObject.has("expires")) {
            aho.a("expires", jSONObject.optString("expires"));
        }
    }

    @Override // defpackage.auz
    public void b() {
        new qo().a(HarmanApplication.a());
        aho.a("user_id", "");
        aho.a("user_name", "");
        aho.a("user_picture", "");
        aho.a("user_status", "");
        aho.a("access_token", "");
        if (this.c == null) {
            this.c = new qj("135461");
        }
        this.c.a(this.b);
        als.d = false;
        d();
    }
}
