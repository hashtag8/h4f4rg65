package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.ajv;
import org.apache.http.Header;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class alb extends ale {
    private View a;
    private AnimationListView b;
    private TextView c;
    private ImageView d;
    private ajn e = new ajn() { // from class: alb.3
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (!ahh.e(alb.this.ae)) {
                Toast.makeText(alb.this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            } else if (aof.a().l()) {
                Toast.makeText(alb.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            } else {
                als.b((akh) obj, alb.this.g, null);
            }
        }
    };
    private String f = null;
    private akh ah = null;

    @Override // defpackage.ale
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.fragment_deezer_artist_list, (ViewGroup) null);
        this.c = (TextView) this.a.findViewById(R.id.deezer_title);
        this.d = (ImageView) this.a.findViewById(R.id.deezer_back);
        this.d.setOnClickListener(new ahl(this) { // from class: alb.1
            @Override // defpackage.ahl
            public void a(View view) {
                alb.this.ae.ag();
            }
        });
        this.b = (AnimationListView) this.a.findViewById(R.id.artist_listview);
        this.b.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: alb.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                akh akhVar = (akh) adapterView.getItemAtPosition(i);
                alc alcVar = new alc();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("artist", akhVar);
                bundle2.putString("title", alb.this.f);
                alcVar.g(bundle2);
                if (!ahn.a()) {
                    alb.this.ae.q().a(alcVar, (arc) null);
                } else {
                    alb.this.ae.q().a(alcVar, new arc().c(R.id.menu_container));
                }
            }
        });
        this.b.setOnItemChosenListener(this.e);
        this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return this.a;
    }

    private void a(akh akhVar) {
        if (akhVar != null && !TextUtils.isEmpty(akhVar.b())) {
            this.c.setText(akhVar.b());
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c(l());
    }

    @Override // defpackage.ald, defpackage.ajj
    public ajv b() {
        if (TextUtils.isEmpty(this.f) && l() != null) {
            this.f = l().getString("title");
        }
        return new ajv.a().a(-13487558).a(this.f).c();
    }

    @Override // defpackage.ale, defpackage.ajk
    public void c(Bundle bundle) {
        this.ah = (akh) bundle.getSerializable("artist");
        this.f = bundle.getString("title");
        a(this.ah);
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        final String str = "https://api.deezer.com/artist/" + this.ah.a() + "/related?limit=2147483647&access_token=" + this.g.b() + "&limit=2147483647";
        c();
        agv.a(true).a(str, new aum() { // from class: alb.4
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                alb.this.d();
                mm.b(str, new Object[0]);
                mm.b(jSONObject, new Object[0]);
                alb.this.b.setAdapter((ListAdapter) new alv(alb.this.ae, new qv(akh.class).a(jSONObject.toString())));
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                alb.this.a(i, jSONObject);
                alb.this.d();
            }
        });
        super.c(bundle);
    }
}
