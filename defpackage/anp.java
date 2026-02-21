package defpackage;

import android.os.Bundle;
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
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.ArtistsInfo;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.aih;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class anp extends ajj implements anu<JSONObject> {
    private TextView c;
    private AnimationListView d;
    private anv f;
    private aih<ArtistsInfo> g;
    private final int a = 60;
    private int b = 0;
    private String e = "";
    private ArrayList<ArtistsInfo> h = new ArrayList<>();
    private AdapterView.OnItemClickListener i = new AdapterView.OnItemClickListener() { // from class: anp.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ArtistsInfo artistsInfo = (ArtistsInfo) adapterView.getItemAtPosition(i);
            Bundle bundle = new Bundle();
            bundle.putString("ID", artistsInfo.a);
            bundle.putString("TITLE", artistsInfo.b);
            bundle.putInt("COUNT", artistsInfo.c);
            bundle.putString("IMAGEURL", artistsInfo.d);
            bundle.putBoolean("ADD", true);
            amo amoVar = new amo();
            if (ahn.a()) {
                amoVar.g(bundle);
                anp.this.ae.q().a(amoVar, new arc().c(R.id.menu_container));
            } else {
                amoVar.g(bundle);
                anp.this.ae.q().a(amoVar, (arc) null);
            }
        }
    };

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.f = new anv(this);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.qobuz_search_list_layout, (ViewGroup) null);
        this.d = (AnimationListView) viewInflate.findViewById(R.id.list_view);
        this.d.setAllowDrag(false);
        this.c = (TextView) viewInflate.findViewById(R.id.tips);
        viewInflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.g = new aih<>(this.ae, new a(), 60, R.layout.qobuz_favourites_artists_item, R.layout.harman_list_loading);
        this.d.setAdapter((ListAdapter) this.g);
        this.d.setOnItemClickListener(this.i);
        o(l());
        return viewInflate;
    }

    @Override // defpackage.ajj
    public ajv b() {
        return null;
    }

    @Override // defpackage.anu
    public void a(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONObject("artists").optJSONArray("items");
        int length = jSONArrayOptJSONArray.length();
        this.h = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            ArtistsInfo artistsInfo = new ArtistsInfo();
            artistsInfo.a = jSONObjectOptJSONObject.optString("id");
            artistsInfo.b = jSONObjectOptJSONObject.optString("name");
            artistsInfo.c = jSONObjectOptJSONObject.optInt("albums_count");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("image");
            if (jSONObjectOptJSONObject2 != null) {
                artistsInfo.d = jSONObjectOptJSONObject2.optString("large");
            }
            this.h.add(artistsInfo);
        }
        if (this.b == 0) {
            this.g.a(this.h);
            this.g.notifyDataSetChanged();
        } else {
            this.g.b(this.h);
        }
    }

    @Override // defpackage.anu
    public void b(String str) {
        if (str != null) {
            Toast.makeText(this.ae, str, 0).show();
        }
    }

    public void d() {
        if (this.g != null) {
            this.b = 0;
            this.g.a();
        }
    }

    @Override // defpackage.anu
    public void c() {
    }

    public void o(Bundle bundle) {
        if (this.g != null && bundle != null && this.b <= 0) {
            this.h = bundle.getParcelableArrayList("RESULT");
            if (this.h != null) {
                this.e = bundle.getString("SEARCH");
                if (this.h.size() == 0) {
                    this.c.setVisibility(0);
                    return;
                }
                this.g.a(this.h);
                this.c.setVisibility(8);
                this.g.notifyDataSetChanged();
            }
        }
    }

    public void al() {
        if (this.d != null) {
            this.d.setSelection(0);
        }
    }

    class a implements aih.a<ArtistsInfo> {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
            anp.this.b = i;
            int i3 = anp.this.b * i2;
            String strEncode = "";
            try {
                strEncode = URLEncoder.encode(anp.this.e, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String str = "http://www.qobuz.com/api.json/0.2/search/getResults?app_id=394304373&query=" + strEncode + "&type=artists&limit=60&offset=" + i3;
            mm.b("CLLOG url: " + str, new Object[0]);
            anp.this.f.a(str, anp.this);
            mm.b("CLLOG start: " + i + ", size: " + i2, new Object[0]);
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, ArtistsInfo artistsInfo) {
            C0035a c0035a = (C0035a) view.getTag();
            if (c0035a == null) {
                C0035a c0035a2 = new C0035a();
                c0035a2.a = (ImageView) view.findViewById(R.id.iv);
                c0035a2.b = (TextView) view.findViewById(R.id.song);
                c0035a2.c = (TextView) view.findViewById(R.id.count);
                c0035a2.d = (TextView) view.findViewById(R.id.alphabet);
                view.setTag(c0035a2);
                c0035a = c0035a2;
            }
            if (artistsInfo.f) {
                c0035a.d.setText(artistsInfo.e);
                c0035a.d.setVisibility(0);
            } else {
                c0035a.d.setVisibility(8);
            }
            c0035a.b.setText(artistsInfo.b);
            c0035a.c.setText(artistsInfo.c + " " + anp.this.ae.getResources().getString(R.string.kQobuz_Albums_Str));
            new ahw().a(c0035a.a, artistsInfo.d);
            return view;
        }

        /* JADX INFO: renamed from: anp$a$a, reason: collision with other inner class name */
        class C0035a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public TextView d;

            C0035a() {
            }
        }
    }
}
