package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.hkconnect.R;
import defpackage.aic;
import defpackage.ajv;
import defpackage.axd;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class axv extends axk implements axd.a, axd.b {
    private View ak;
    private aic<axa> al;
    private ListView an;
    private ImageView as;
    private TextView at;
    private ArrayList<axa> am = new ArrayList<>();
    private final int ao = 20;
    private int ap = 1;
    final int a = 1;
    final int b = 2;
    final int aj = 3;
    private long aq = 0;
    private String ar = null;
    private MenuItem.OnMenuItemClickListener au = new MenuItem.OnMenuItemClickListener() { // from class: axv.1
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            axv.this.ae.l().a(axv.this.b());
            axv.this.ae.onBackPressed();
            return true;
        }
    };
    private ajs av = new ajs() { // from class: axv.2
        @Override // defpackage.ajs
        public void a(String str, ajw ajwVar) {
            if (ajwVar != ajw.SEARCH_PRESSED) {
                axv.this.b(str);
                return;
            }
            axw axwVar = new axw();
            Bundle bundle = new Bundle();
            try {
                str = URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
            }
            bundle.putString("search_term", str);
            bundle.putInt("current_screen", 0);
            axwVar.g(bundle);
            axv.this.a((axj) axwVar);
        }
    };
    private AdapterView.OnItemClickListener aw = new AdapterView.OnItemClickListener() { // from class: axv.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < axv.this.am.size()) {
                axa axaVar = (axa) axv.this.am.get(i);
                axw axwVar = new axw();
                Bundle bundle = new Bundle();
                bundle.putString("search_term", axaVar.a);
                bundle.putInt("current_screen", 0);
                axwVar.g(bundle);
                axv.this.a((axj) axwVar);
            }
        }
    };

    static /* synthetic */ int d(axv axvVar) {
        int i = axvVar.ap;
        axvVar.ap = i + 1;
        return i;
    }

    @Override // axd.b
    public void a(String str, JSONObject jSONObject, String str2) {
        if (str.compareTo("catalog:auto-complete") == 0) {
            long jOptLong = jSONObject.optLong("time_sent", 0L);
            if (jOptLong > this.aq) {
                this.aq = jOptLong;
                this.am.clear();
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("suggestions");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        axa axaVar = new axa();
                        if (jSONObject2.has("type")) {
                            String string = jSONObject2.getString("type");
                            if (string.compareTo("artist") == 0) {
                                axaVar.b = 1;
                            } else if (string.compareTo("album") == 0) {
                                axaVar.b = 2;
                            } else if (string.compareTo("track") == 0) {
                                axaVar.b = 3;
                            }
                            axaVar.c = awp.a(jSONObject2);
                            axaVar.a = jSONObject2.getString("name");
                        }
                        this.am.add(axaVar);
                    }
                    mm.b("Juke", "getcount=" + this.al.getCount());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                this.al.a(this.am);
                this.al.notifyDataSetChanged();
                this.an.setAdapter((ListAdapter) this.al);
                return;
            }
            return;
        }
        if (str.compareTo("user:home") == 0) {
            axc.a().a(axc.a().e, "user:user", (axd.b) this, "", "", 0, 20, true);
        }
    }

    @Override // axd.b
    public void a(String str, JSONArray jSONArray) {
    }

    @Override // axd.a, axd.b
    public void a(String str, String str2) {
        al();
        Toast.makeText(this.ae, R.string.JukeApiReturnError_Str, 1).show();
    }

    @Override // defpackage.axk, axd.a
    public void a(boolean z, int i) {
        if (z) {
            axc.a().a(axc.a().e, "user:home", (axd.b) this, "", "", 0, 20, true);
        }
    }

    @Override // defpackage.axk
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ak = layoutInflater.inflate(R.layout.juke_search, (ViewGroup) null);
        this.an = (ListView) this.ak.findViewById(R.id.results_listview);
        this.as = (ImageView) this.ak.findViewById(R.id.listview_tips_icon);
        this.at = (TextView) this.ak.findViewById(R.id.search_no_results_found);
        this.al = new aic<>(this.ae, new a(), 20, R.layout.juke_search_result_item, R.layout.harman_list_loading);
        this.al.a(this.am);
        this.an.setAdapter((ListAdapter) this.al);
        this.ak.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        return this.ak;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.am.clear();
            this.al.a(this.am);
            this.al.notifyDataSetChanged();
        } else if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
        } else if (!str.equals(this.ar)) {
            try {
                this.ar = URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                this.ar = str;
            }
            axc.a().a("catalog:auto-complete", this, "{criterion}", this.ar);
        }
    }

    @Override // defpackage.axk
    void c() {
        this.an.setAdapter((ListAdapter) this.al);
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c(l());
    }

    @Override // defpackage.axj, defpackage.ajj
    public ajv b() {
        return new ajv.a().d(true).n(-16777216).a(-16777216).m(q().getColor(R.color.white)).a(this.av).e(true).c(true).k(R.drawable.search_close_button).a(true).a(this.au).c();
    }

    @Override // defpackage.axk, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiDisConnect_Str, 0).show();
            al();
            return;
        }
        this.am.clear();
        this.al.a(this.am);
        this.al.notifyDataSetChanged();
        if (this.am != null && this.am.size() > 0) {
            this.an.setVisibility(0);
            this.as.setVisibility(8);
            this.at.setVisibility(8);
        } else {
            this.an.setVisibility(8);
            this.as.setVisibility(0);
            this.at.setVisibility(0);
        }
        this.an.setOnItemClickListener(this.aw);
    }

    class a implements aic.a<axa> {
        a() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            axv.d(axv.this);
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, axa axaVar) {
            C0086a c0086a = (C0086a) view.getTag();
            if (c0086a == null) {
                C0086a c0086a2 = new C0086a();
                c0086a2.a = (ImageView) view.findViewById(R.id.iv);
                c0086a2.b = (TextView) view.findViewById(R.id.text1);
                view.setTag(c0086a2);
                c0086a = c0086a2;
            }
            c0086a.b.setText(axaVar.a);
            c0086a.a.setVisibility(8);
            return view;
        }

        /* JADX INFO: renamed from: axv$a$a, reason: collision with other inner class name */
        class C0086a {
            public ImageView a;
            public TextView b;

            C0086a() {
            }
        }
    }
}
