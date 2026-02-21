package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import defpackage.aic;
import defpackage.ajv;
import defpackage.axd;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class axp extends axk implements axd.a, axd.b {
    private View a;
    private GridView ak;
    private aic<awy> b;
    private ArrayList<awy> aj = new ArrayList<>();
    private final int al = 50;
    private int am = 0;
    private AdapterView.OnItemClickListener an = new AdapterView.OnItemClickListener() { // from class: axp.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            axo axoVar = new axo();
            Bundle bundle = new Bundle();
            bundle.putSerializable("genre", (Serializable) axp.this.aj.get(i));
            bundle.putInt("current_screen", 0);
            axoVar.g(bundle);
            axp.this.a((axj) axoVar);
        }
    };

    @Override // axd.b
    public void a(String str, JSONObject jSONObject, String str2) {
        if (str.compareTo("catalog:genres") == 0) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("genres");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    awy awyVar = new awy();
                    awyVar.a = jSONObject2.getString("name");
                    jSONObject2.optJSONArray("links");
                    awyVar.b = awp.a(jSONObject2);
                    arrayList.add(awyVar);
                }
                this.aj.clear();
                this.aj.addAll(this.aj.size(), (ArrayList) arrayList.clone());
                this.b.a(arrayList);
                mm.b("TIDAL", "" + this.b.getCount());
                this.b.notifyDataSetChanged();
                al();
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (str.compareTo("user:home") == 0) {
            axc.a().a(axc.a().e, "user:user", (axd.b) this, "", "", 0, 50, true);
        }
    }

    @Override // axd.b
    public void a(String str, JSONArray jSONArray) {
    }

    @Override // axd.a, axd.b
    public void a(String str, String str2) {
    }

    @Override // defpackage.axk, axd.a
    public void a(boolean z, int i) {
        mm.b("URLs", "" + z);
        if (z) {
            axc.a().a("catalog:genres", this, "", "", 0, 50);
            axc.a().a(axc.a().e, "user:home", (axd.b) this, "", "", 0, 50, true);
        }
    }

    @Override // defpackage.axk
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.juke_grid, (ViewGroup) null);
        this.ak = (GridView) this.a.findViewById(R.id.group_gridview);
        ((RelativeLayout) this.a.findViewById(R.id.info_header)).setVisibility(8);
        this.b = new aic<>(this.ae, new a(), 50, R.layout.juke_gridview_item, R.layout.juke_list_loading_invisible);
        try {
            this.b.a(this.aj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.ak.setAdapter((ListAdapter) this.b);
        return this.a;
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.ae = (DashboardActivity) p();
    }

    @Override // defpackage.axk
    void c() {
        Configuration configuration = q().getConfiguration();
        if (configuration.orientation == 2) {
            this.ak.setNumColumns(3);
        } else if (configuration.orientation == 1) {
            this.ak.setNumColumns(2);
        }
        this.b.notifyDataSetChanged();
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c(l());
    }

    @Override // defpackage.axj, defpackage.ajj
    public ajv b() {
        return new ajv.a(super.b()).h(0).g(R.string.JukeGenres).c();
    }

    @Override // defpackage.axk, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiDisConnect_Str, 0).show();
            al();
            return;
        }
        d();
        this.aj.clear();
        try {
            this.b.a(this.aj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.b.notifyDataSetChanged();
        this.ak.setOnItemClickListener(this.an);
        this.ak.setOnScrollListener(new awv(this.ae));
    }

    class a implements aic.a<awy> {
        a() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, awy awyVar) {
            C0078a c0078a;
            C0078a c0078a2 = (C0078a) view.getTag();
            if (c0078a2 == null) {
                c0078a = new C0078a();
                c0078a.a = (ImageView) view.findViewById(R.id.iv);
                c0078a.b = (TextView) view.findViewById(R.id.tv);
                view.setTag(c0078a);
            } else {
                c0078a = c0078a2;
            }
            c0078a.b.setText(awyVar.a);
            c0078a.a.setVisibility(0);
            bif.a((Context) axp.this.ae).a(awyVar.b.get("catalog:image-256x256")).a("juke").a(R.drawable.juke_placeholder_150x150).a(c0078a.a);
            return view;
        }

        /* JADX INFO: renamed from: axp$a$a, reason: collision with other inner class name */
        class C0078a {
            public ImageView a;
            public TextView b;

            C0078a() {
            }
        }
    }
}
