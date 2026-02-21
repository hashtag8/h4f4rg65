package defpackage;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.ArtistsInfo;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.LinearLayoutManager;
import defpackage.ajv;
import defpackage.aqu;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class anm extends amw implements anu<JSONObject> {
    private anv ai;
    private TextView ao;
    private a ar;
    private View d;
    private DashboardActivity e;
    private anr f;
    private anp g;
    private ano h;
    private anq i;
    private final int b = 60;
    private int c = 0;
    private ajj ah = null;
    private Bundle aj = new Bundle();
    private Bundle ak = new Bundle();
    private Bundle al = new Bundle();
    private Bundle am = new Bundle();
    private String an = "";
    private int ap = 0;
    private boolean aq = false;
    private ajs as = new ajs() { // from class: anm.1
        @Override // defpackage.ajs
        public void a(String str, ajw ajwVar) {
            Bundle bundle = new Bundle();
            bundle.putString("SEARCH", str);
            if (anm.this.f != null) {
                anm.this.f.al();
                anm.this.f.d();
            }
            if (anm.this.g != null) {
                anm.this.g.al();
                anm.this.g.d();
            }
            if (anm.this.h != null) {
                anm.this.h.al();
                anm.this.h.d();
            }
            if (anm.this.i != null) {
                anm.this.i.al();
                anm.this.i.d();
            }
            anm.this.o(bundle);
        }
    };
    private MenuItem.OnMenuItemClickListener at = new MenuItem.OnMenuItemClickListener() { // from class: anm.2
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (!anm.this.aw()) {
                anm.this.p().onBackPressed();
                return true;
            }
            return true;
        }
    };

    public interface a {
        void d();
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.e = (DashboardActivity) p();
        this.ai = new anv(this);
    }

    public void a(a aVar) {
        this.ar = aVar;
    }

    @Override // defpackage.amw, defpackage.ajj
    public ajv b() {
        return new ajv.a().d(true).i(R.drawable.hamberger_white_icon).k(R.drawable.search_close_button).n(-9128246).b(this.an).a(-9128246).m(q().getColor(R.color.white)).c(true).a(true).a(this.as).a(this.at).c();
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.d = layoutInflater.inflate(R.layout.qobuz_search_fragment_detail, (ViewGroup) null);
        this.d.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        ((TextView) this.d.findViewById(R.id.tips)).setTextColor(q().getColor(R.color.black));
        ArrayList arrayList = new ArrayList();
        arrayList.add(q().getString(R.string.kQobuz_Tracks_Str));
        arrayList.add(q().getString(R.string.kQobuz_Artists_Str));
        arrayList.add(q().getString(R.string.kQobuz_Albums_Str));
        arrayList.add(q().getString(R.string.kQobuz_Tab_Playlist_Str));
        View viewInflate = layoutInflater.inflate(R.layout.qobuz_navigation, (ViewGroup) null);
        final RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.navigation_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.e);
        linearLayoutManager.b(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        final aqu aquVar = new aqu(arrayList, layoutInflater);
        recyclerView.setAdapter(aquVar);
        aquVar.a(new aqu.a() { // from class: anm.3
            @Override // aqu.a
            public void a(View view, int i) {
                aqu.b bVar;
                if (anm.this.ao != view.findViewById(R.id.navigation_item)) {
                    aquVar.f(i);
                    if (anm.this.ao == null && (bVar = (aqu.b) recyclerView.b(0)) != null) {
                        anm.this.ao = bVar.n;
                    }
                    anm.this.ap = i;
                    switch (i) {
                        case 0:
                            anm.this.d();
                            break;
                        case 1:
                            anm.this.al();
                            break;
                        case 2:
                            anm.this.am();
                            break;
                        case 3:
                            anm.this.an();
                            break;
                    }
                    anm.this.a(anm.this.ao, (TextView) view.findViewById(R.id.navigation_item));
                    anm.this.ao = (TextView) view.findViewById(R.id.navigation_item);
                }
            }
        });
        ((LinearLayout) this.d.findViewById(R.id.navigation)).addView(viewInflate, new RelativeLayout.LayoutParams(-1, -1));
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, TextView textView2) {
        if (textView != null) {
            DashboardActivity dashboardActivity = this.e;
            textView.setTextColor(Color.parseColor("#9A9A9A"));
            textView.setTypeface(ahu.a(this.e));
        }
        DashboardActivity dashboardActivity2 = this.e;
        textView2.setTextColor(Color.parseColor("#000000"));
        textView2.setTypeface(ahu.b(this.e));
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        this.af.post(new Runnable() { // from class: anm.4
            @Override // java.lang.Runnable
            public void run() {
                if (anm.this.aj.getParcelableArrayList("RESULT") != null) {
                    ahf.a((Activity) anm.this.e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Bundle bundle) {
        if (bundle != null && !bundle.getString("SEARCH").isEmpty()) {
            this.d.findViewById(R.id.loadingScreen).setVisibility(0);
            this.aj = new Bundle();
            this.an = bundle.getString("SEARCH");
            String strEncode = "";
            try {
                strEncode = URLEncoder.encode(this.an, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.ai.a("http://www.qobuz.com/api.json/0.2/catalog/search?app_id=394304373&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&query=" + strEncode + "&limit=60&offset=" + this.c, this);
        }
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void C() {
        super.C();
        this.aq = false;
    }

    @Override // android.support.v4.app.Fragment
    public void D() {
        super.D();
        this.aq = true;
        if (this.ar != null) {
            this.ar.d();
        }
    }

    @Override // defpackage.anu
    public void a(JSONObject jSONObject) {
        if (!this.aq) {
            this.d.findViewById(R.id.loadingScreen).setVisibility(8);
            this.aj.putParcelableArrayList("RESULT", any.b(jSONObject));
            this.aj.putString("SEARCH", this.an);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("artists");
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("items");
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                ArtistsInfo artistsInfo = new ArtistsInfo();
                artistsInfo.a = jSONObjectOptJSONObject2.optString("id");
                artistsInfo.b = jSONObjectOptJSONObject2.optString("name");
                artistsInfo.c = jSONObjectOptJSONObject2.optInt("albums_count");
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("image");
                if (jSONObjectOptJSONObject3 != null) {
                    artistsInfo.d = jSONObjectOptJSONObject3.optString("large");
                }
                arrayList.add(artistsInfo);
            }
            this.ak.putParcelableArrayList("RESULT", arrayList);
            this.ak.putString("SEARCH", this.an);
            this.al.putParcelableArrayList("RESULT", any.d(jSONObject.optJSONObject("albums")));
            this.al.putString("SEARCH", this.an);
            this.am.putParcelableArrayList("RESULT", any.a(jSONObject));
            this.am.putString("SEARCH", this.an);
            if (this.ap == 0) {
                d();
                if (this.f != null) {
                    this.f.al();
                    return;
                }
                return;
            }
            if (this.ap == 2) {
                am();
                this.h.al();
            } else if (this.ap == 1) {
                al();
                this.g.al();
            } else if (this.ap == 3) {
                an();
                this.i.al();
            }
        }
    }

    @Override // defpackage.anu
    public void b(String str) {
        if (str != null) {
            Toast.makeText(this.e, str, 0).show();
        }
        if (this.ah != null) {
            this.ah.e();
        }
    }

    @Override // defpackage.anu
    public void c() {
        if (this.ah != null) {
            this.ah.e();
        }
    }

    public void d() {
        if (this.f == null) {
            this.f = new anr();
        }
        this.f.o(this.aj);
        this.e.q().a(s(), this.f, this.aj, R.id.search_content);
        this.ah = this.f;
    }

    public void al() {
        if (this.g == null) {
            this.g = new anp();
        }
        this.g.o(this.ak);
        this.e.q().a(s(), this.g, this.ak, R.id.search_content);
        this.ah = this.g;
    }

    public void am() {
        if (this.h == null) {
            this.h = new ano();
        }
        this.h.o(this.al);
        this.e.q().a(s(), this.h, this.al, R.id.search_content);
        this.ah = this.h;
    }

    public void an() {
        if (this.i == null) {
            this.i = new anq();
        }
        this.i.o(this.am);
        this.e.q().a(s(), this.i, this.am, R.id.search_content);
        this.ah = this.i;
    }
}
