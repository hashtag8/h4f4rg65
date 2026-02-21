package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.harman.hkconnect.R;
import defpackage.ajv;
import defpackage.arn;
import java.util.ArrayList;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class arq extends ajj {
    private arn a;
    private MenuItem.OnMenuItemClickListener b = new MenuItem.OnMenuItemClickListener() { // from class: arq.3
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            anm anmVar = new anm();
            Bundle bundle = new Bundle();
            bundle.putString("SEARCH", "");
            anmVar.g(bundle);
            arq.this.ae.q().a(anmVar, (arc) null);
            return true;
        }
    };
    private ajs c = new ajs() { // from class: arq.4
        @Override // defpackage.ajs
        public void a(String str, ajw ajwVar) {
            arq.this.ae.q().a(new anm(), (arc) null);
        }
    };

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = new arn(p());
        this.a.setOnQobuzListner(new arn.a() { // from class: arq.1
            @Override // arn.a
            public void a(View view) {
                arq.this.ae.q().a(new anm(), (arc) null);
            }

            @Override // arn.a
            public void b(View view) {
                arq.this.ae.q().a(new anl(), (arc) null);
            }

            @Override // arn.a
            public void c(View view) {
                arq.this.ae.q().a(new ank(), (arc) null);
            }

            @Override // arn.a
            public void d(View view) {
                arq.this.ae.q().a(new anj(), (arc) null);
            }

            @Override // arn.a
            public void e(View view) {
                arq.this.ae.q().a(new anf(), (arc) null);
            }

            @Override // arn.a
            public void f(View view) {
                arq.this.ae.q().a(new amz(), (arc) null);
            }
        });
        return this.a;
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void C() {
        super.C();
        this.a.a();
        c();
    }

    private void c() {
        new anv(this).a("http://www.qobuz.com/api.json/0.2/favorite/getUserFavorites?app_id=394304373&type=tracks&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&user_id=" + aho.d("qobuz_user_info").trim().split("&")[3] + "&limit=" + HttpStatus.SC_INTERNAL_SERVER_ERROR, new anu<JSONObject>() { // from class: arq.2
            @Override // defpackage.anu
            public void a(JSONObject jSONObject) {
                if (jSONObject.optJSONObject("tracks") != null) {
                    ArrayList arrayList = new ArrayList();
                    if (jSONObject.optJSONObject("tracks").optJSONArray("items") != null) {
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONObject("tracks").optJSONArray("items");
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            arrayList.add(Long.valueOf(jSONArrayOptJSONArray.optJSONObject(i).optInt("id")));
                        }
                        aho.a("qobuz_fav_tracks", new abw().a(arrayList));
                    }
                }
            }

            @Override // defpackage.anu
            public void b(String str) {
            }

            @Override // defpackage.anu
            public void c() {
            }
        });
    }

    @Override // defpackage.ajj
    public ajv b() {
        return new ajv.a().a(this.b).c(true).h(R.drawable.qobuz_logo).a(-9128246).i(R.drawable.hamberger_white_icon).c();
    }
}
