package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.hkconnect.R;
import defpackage.aih;
import defpackage.ayf;
import defpackage.ayg;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ayp extends ayi implements ayg.a, ayg.b, ayg.d {
    private ListView ah;
    private aih<String> am;
    private be an;
    private View g;
    private ImageView h;
    private SearchView i;
    private String ai = "tracks";
    private String aj = null;
    private ArrayList<String> ak = null;
    private ArrayList<String> al = null;
    private boolean ao = false;
    private boolean ap = false;
    private long aq = 0;
    private SearchView.OnCloseListener ar = new SearchView.OnCloseListener() { // from class: ayp.5
        @Override // android.widget.SearchView.OnCloseListener
        public boolean onClose() {
            return false;
        }
    };
    SearchView.OnQueryTextListener f = new SearchView.OnQueryTextListener() { // from class: ayp.6
        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            ayp.this.b(str);
            return false;
        }
    };

    @Override // defpackage.ayi
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.g = layoutInflater.inflate(R.layout.fragment_nokia_create_mix_search, (ViewGroup) null);
        this.ak = new ArrayList<>();
        this.al = new ArrayList<>();
        this.am = new aih<>(this.ae, new a(), 20, R.layout.nokia_listview_item, R.layout.harman_list_loading);
        this.an = r();
        an();
        ao();
        this.i.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() { // from class: ayp.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (view != null && z && ayp.this.z()) {
                    view.postDelayed(new Runnable() { // from class: ayp.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ahf.a((Context) ayp.this.ae);
                        }
                    }, 200L);
                }
            }
        });
        return this.g;
    }

    private void an() {
        this.h = (ImageView) this.g.findViewById(R.id.back);
        this.i = (SearchView) this.g.findViewById(R.id.search);
        this.ah = (ListView) this.g.findViewById(R.id.results_listview);
        this.ah.setEmptyView((ImageView) this.g.findViewById(R.id.empty));
        TextView textView = (TextView) this.i.findViewById(this.i.getContext().getResources().getIdentifier("android:id/search_src_text", null, null));
        textView.setTextColor(-1);
        textView.setHintTextColor(-1);
        this.ak.clear();
        this.al.clear();
        this.ah.setAdapter((ListAdapter) null);
        this.am.a(this.ak);
        this.am.notifyDataSetChanged();
        this.ah.setAdapter((ListAdapter) this.am);
        TextView textView2 = (TextView) this.i.findViewById(this.i.getContext().getResources().getIdentifier("android:id/search_src_text", null, null));
        textView2.setTextColor(-1);
        textView2.setHintTextColor(q().getColor(R.color.white_50));
        ((ImageView) this.i.findViewById(this.i.getContext().getResources().getIdentifier("android:id/search_mag_icon", null, null))).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        View viewFindViewById = this.i.findViewById(this.i.getContext().getResources().getIdentifier("android:id/search_plate", null, null));
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundColor(0);
        }
        ImageView imageView = (ImageView) this.i.findViewById(this.ae.getResources().getIdentifier("android:id/search_close_btn", null, null));
        imageView.setColorFilter(q().getColor(R.color.white), PorterDuff.Mode.MULTIPLY);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ayp.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((EditText) ayp.this.i.findViewById(ayp.this.ae.getResources().getIdentifier("android:id/search_src_text", null, null))).setText("");
                ayp.this.b("");
            }
        });
        this.h.setOnClickListener(new View.OnClickListener() { // from class: ayp.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ahf.a((Activity) ayp.this.ae);
                ayp.this.ae.ag();
            }
        });
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c(l());
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void C() {
        super.C();
    }

    @Override // defpackage.ayi, defpackage.ajk
    public void c(Bundle bundle) {
        this.ao = bundle.getBoolean("isTaste", false);
        bundle.getInt("pos", 0);
        if (bundle.getBoolean("new_mix", false)) {
            this.ap = true;
        }
        an();
        if (z()) {
            new Timer().schedule(new TimerTask() { // from class: ayp.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    ayp.this.ae.runOnUiThread(new Runnable() { // from class: ayp.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ayp.this.i != null) {
                                ayp.this.i.requestFocus();
                            }
                        }
                    });
                }
            }, 200L);
        }
        super.c(bundle);
    }

    @Override // defpackage.ayi
    boolean al() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            an();
            return;
        }
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
        } else if (!str.equals(this.aj)) {
            this.aj = str;
            try {
                this.aj = URLEncoder.encode(this.aj, "utf-8").replace("+", "%20");
            } catch (UnsupportedEncodingException e) {
            }
            ayf.a().a(ayf.a.ArtistSearch, this, this.aj);
        }
    }

    private void ao() {
        this.i.setOnCloseListener(this.ar);
        this.i.setOnQueryTextListener(this.f);
        this.ah.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: ayp.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                String str = (String) ayp.this.ak.get(i);
                String str2 = (String) ayp.this.al.get(i);
                ayp.this.aj = "";
                ayp.this.ak.clear();
                ayp.this.al.clear();
                ayp.this.am.notifyDataSetChanged();
                ayp.this.i.setQuery("", false);
                ahf.a((Activity) ayp.this.ae);
                ayp.this.ae.getFragmentManager().popBackStackImmediate();
                if (ayp.this.ao) {
                    ayq ayqVar = new ayq();
                    Bundle bundle = new Bundle();
                    ayd aydVar = new ayd();
                    aydVar.b = str2;
                    aydVar.a = str;
                    aydVar.c = "";
                    bundle.putSerializable("artist", aydVar);
                    ayqVar.g(bundle);
                    ayf.a().a(aydVar);
                    ayp.this.ae.ag();
                    return;
                }
                ajk ayjVar = new ayj();
                Bundle bundle2 = new Bundle();
                ayd aydVar2 = new ayd();
                aydVar2.b = str2;
                aydVar2.a = str;
                aydVar2.c = "";
                bundle2.putSerializable("artist", aydVar2);
                bundle2.putBoolean("new_mix", ayp.this.ap);
                ayjVar.g(bundle2);
                ayf.a().a(aydVar2);
                if (ayp.this.ap) {
                    ayp.this.ae.q().a(ayjVar, (arc) null);
                } else {
                    ayp.this.ae.ag();
                }
            }
        });
    }

    @Override // ayg.a
    public void a(boolean z) {
    }

    @Override // ayg.b
    public void a(ayf.a aVar, JSONObject jSONObject, String str) {
        if (aVar == ayf.a.ArtistSearch) {
            long jOptLong = jSONObject.optLong("time_sent", 0L);
            if (jOptLong > this.aq) {
                this.aq = jOptLong;
                if (this.ak == null) {
                    this.ak = new ArrayList<>();
                }
                if (this.al == null) {
                    this.al = new ArrayList<>();
                }
                this.ak.removeAll(this.ak);
                this.al.removeAll(this.al);
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("items");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getJSONObject(i).getString("name");
                        String string2 = jSONArray.getJSONObject(i).getString("id");
                        this.ak.add(string);
                        this.al.add(string2);
                    }
                } catch (Exception e) {
                    mm.e(e.toString(), new Object[0]);
                }
                this.ah.setAdapter((ListAdapter) null);
                this.am.a(this.ak);
                this.am.notifyDataSetChanged();
                this.ah.setAdapter((ListAdapter) this.am);
            }
        }
    }

    @Override // ayg.b
    public void a(ayf.a aVar, JSONArray jSONArray) {
    }

    @Override // ayg.b
    public void a(ayf.a aVar, String str) {
        d();
        Toast.makeText(this.ae, R.string.MixRadioApiReturnError_Str, 1).show();
    }

    @Override // ayg.d
    public void a(ayf.b bVar, MusicData musicData) {
    }

    class a implements aih.a<String> {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, String str) {
            C0092a c0092a = (C0092a) view.getTag();
            if (c0092a == null) {
                C0092a c0092a2 = new C0092a();
                c0092a2.a = (TextView) view.findViewById(R.id.tv);
                view.setTag(c0092a2);
                c0092a = c0092a2;
            }
            c0092a.a.setText(axz.a(str));
            c0092a.a.setTypeface(ahu.a(ayp.this.ae));
            return view;
        }

        /* JADX INFO: renamed from: ayp$a$a, reason: collision with other inner class name */
        class C0092a {
            public TextView a;

            C0092a() {
            }
        }
    }
}
