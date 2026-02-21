package defpackage;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.ArtistsInfo;
import com.harman.hkconnect.ui.DashboardActivity;
import defpackage.aih;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class amr extends ajj implements anu<JSONObject> {
    private anv ah;
    private aih<ArtistsInfo> ai;
    private View c;
    private View d;
    private TextView e;
    private DashboardActivity f;
    private ListView g;
    private SearchView h;
    private View i;
    private final int a = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    private int b = 0;
    private ArrayList<ArtistsInfo> aj = new ArrayList<>();
    private ArtistsInfo ak = null;
    private AdapterView.OnItemClickListener al = new AdapterView.OnItemClickListener() { // from class: amr.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ArtistsInfo artistsInfo = (ArtistsInfo) adapterView.getItemAtPosition(i);
            amr.this.ak = artistsInfo;
            Bundle bundle = new Bundle();
            bundle.putString("ID", artistsInfo.a);
            bundle.putString("TITLE", artistsInfo.b);
            bundle.putInt("COUNT", artistsInfo.c);
            bundle.putString("IMAGEURL", artistsInfo.d);
            amo amoVar = new amo();
            amoVar.g(bundle);
            if (!ahn.a()) {
                amr.this.f.q().a(amoVar, (arc) null);
            } else {
                amr.this.f.q().a(amoVar, new arc().c(R.id.menu_container));
            }
        }
    };
    private SearchView.OnQueryTextListener am = new SearchView.OnQueryTextListener() { // from class: amr.2
        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (TextUtils.isEmpty(str)) {
                amr.this.ai.a(amr.this.aj);
                amr.this.d.findViewById(R.id.pro_bar).setVisibility(0);
                amr.this.d.setVisibility(8);
            } else {
                ArrayList<ArtistsInfo> arrayListA = amr.this.a(amr.this.aj, str);
                if (arrayListA.size() > 0) {
                    amr.this.ai.a(arrayListA);
                    amr.this.d.findViewById(R.id.pro_bar).setVisibility(0);
                    amr.this.d.setVisibility(8);
                } else {
                    amr.this.e.setText(amr.this.a(R.string.kQobuz_Filter_Empty_Str));
                    amr.this.d.findViewById(R.id.pro_bar).setVisibility(8);
                    amr.this.d.setVisibility(0);
                }
            }
            amr.this.ai.notifyDataSetChanged();
            return true;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            new Handler().postDelayed(new Runnable() { // from class: amr.2.1
                @Override // java.lang.Runnable
                public void run() {
                    ahf.a((Activity) amr.this.f);
                }
            }, 200L);
            return true;
        }
    };

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.f = (DashboardActivity) p();
        this.ah = new anv(this);
        d();
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = layoutInflater.inflate(R.layout.qobuz_favourites_list_layout, (ViewGroup) null);
        this.g = (ListView) this.c.findViewById(R.id.list_view);
        this.g.setOnTouchListener(null);
        this.d = this.c.findViewById(R.id.loading);
        this.e = (TextView) this.c.findViewById(R.id.tips);
        this.e.setTextColor(q().getColor(R.color.black));
        this.h = (SearchView) this.c.findViewById(R.id.search_view);
        this.h.setQueryHint(a(R.string.kQobuz_ArtistName_Filter_Str));
        this.i = this.c.findViewById(R.id.notice);
        this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return this.c;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        this.ai = new aih<>(this.f, new a(), HttpStatus.SC_INTERNAL_SERVER_ERROR, R.layout.qobuz_favourites_artists_item, R.layout.harman_list_loading);
        this.g.setAdapter((ListAdapter) this.ai);
        this.g.setOnItemClickListener(this.al);
        this.h.setOnQueryTextListener(this.am);
    }

    public void d() {
        this.ah.a("http://www.qobuz.com/api.json/0.2/favorite/getUserFavorites?app_id=394304373&types=artists&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&user_id=" + aho.d("qobuz_user_info").trim().split("&")[3] + "&limit=" + HttpStatus.SC_INTERNAL_SERVER_ERROR + "&offset=" + this.b, this);
    }

    @Override // defpackage.ajj
    public ajv b() {
        return null;
    }

    public ArrayList<ArtistsInfo> a(ArrayList<ArtistsInfo> arrayList, String str) {
        ArrayList<ArtistsInfo> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ArtistsInfo artistsInfo = arrayList.get(i);
            if (!TextUtils.isEmpty(artistsInfo.b) && artistsInfo.b.toLowerCase().contains(str.toLowerCase())) {
                arrayList2.add(artistsInfo);
            }
        }
        return arrayList2;
    }

    @Override // defpackage.anu
    public void a(JSONObject jSONObject) {
        String str;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONObject("artists").optJSONArray("items");
        int length = jSONArrayOptJSONArray.length();
        this.aj = new ArrayList<>();
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
            this.aj.add(artistsInfo);
        }
        a((List<ArtistsInfo>) this.aj);
        List listAsList = Arrays.asList(this.f.getResources().getStringArray(R.array.alphabet_list));
        String str2 = "";
        int size = this.aj.size();
        int i2 = 0;
        while (i2 < size) {
            ArtistsInfo artistsInfo2 = this.aj.get(i2);
            String upperCase = artistsInfo2.b.trim().substring(0, 1).toUpperCase();
            if (!listAsList.contains(upperCase)) {
                upperCase = "#";
            }
            if (upperCase.equalsIgnoreCase(str2)) {
                artistsInfo2.f = false;
                str = str2;
            } else {
                artistsInfo2.f = true;
                artistsInfo2.e = upperCase;
                str = upperCase;
            }
            i2++;
            str2 = str;
        }
        if (this.b == 0) {
            this.ai.a(this.aj);
            this.ai.notifyDataSetChanged();
        } else {
            this.ai.b(this.aj);
        }
        this.d.setVisibility(8);
        if (this.aj.size() == 0) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
    }

    public void a(List<ArtistsInfo> list) {
        Collections.sort(list, new Comparator<ArtistsInfo>() { // from class: amr.3
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(ArtistsInfo artistsInfo, ArtistsInfo artistsInfo2) {
                return artistsInfo.b.trim().substring(0, 1).compareToIgnoreCase(artistsInfo2.b.trim().substring(0, 1));
            }
        });
    }

    @Override // defpackage.anu
    public void b(String str) {
        if (str != null) {
            Toast.makeText(this.f, str, 0).show();
        }
        this.d.setVisibility(8);
    }

    @Override // defpackage.anu
    public void c() {
        this.d.setVisibility(8);
    }

    class a implements aih.a<ArtistsInfo> {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
            amr.this.b = i;
            int i3 = amr.this.b * i2;
            amr.this.ah.a("http://www.qobuz.com/api.json/0.2/favorite/getUserFavorites?app_id=394304373&types=artists&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&user_id=" + aho.d("qobuz_user_info").trim().split("&")[3] + "&limit=" + HttpStatus.SC_INTERNAL_SERVER_ERROR + "&offset=" + i3, amr.this);
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, ArtistsInfo artistsInfo) {
            C0023a c0023a = (C0023a) view.getTag();
            if (c0023a == null) {
                C0023a c0023a2 = new C0023a();
                c0023a2.a = (ImageView) view.findViewById(R.id.iv);
                c0023a2.b = (TextView) view.findViewById(R.id.song);
                c0023a2.c = (TextView) view.findViewById(R.id.count);
                c0023a2.d = (TextView) view.findViewById(R.id.alphabet);
                view.setTag(c0023a2);
                c0023a = c0023a2;
            }
            if (artistsInfo.f) {
                c0023a.d.setText(artistsInfo.e);
                c0023a.d.setVisibility(0);
            } else {
                c0023a.d.setVisibility(8);
            }
            c0023a.b.setText(artistsInfo.b);
            c0023a.c.setText(artistsInfo.c + " " + amr.this.q().getString(R.string.kQobuz_Albums_Num_Str));
            new ahw().a(c0023a.a, artistsInfo.d);
            return view;
        }

        /* JADX INFO: renamed from: amr$a$a, reason: collision with other inner class name */
        class C0023a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public TextView d;

            C0023a() {
            }
        }
    }
}
