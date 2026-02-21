package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.ajv;
import defpackage.als;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class alg extends ale {
    public static List<aki> a = null;
    private qn ah;
    private ImageView ai = null;
    private int aj = 0;
    private int ak = Integer.MAX_VALUE;
    private aki al = null;
    private boolean am = false;
    private ajn an = new ajn() { // from class: alg.3
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            mm.e(obj, new Object[0]);
            akg akgVar = (akg) obj;
            if (!ahh.e(alg.this.ae)) {
                Toast.makeText(alg.this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            } else {
                als.a(akgVar, alg.this.g, new als.a() { // from class: alg.3.1
                    @Override // als.a
                    public void a() {
                    }

                    @Override // als.a
                    public void a(JSONObject jSONObject) {
                        alg.this.a(jSONObject);
                    }
                });
            }
        }
    };
    private AdapterView.OnItemClickListener ao = new AdapterView.OnItemClickListener() { // from class: alg.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            akg akgVar = (akg) alg.this.ap.get(i);
            if (akgVar != null) {
                String strA = alg.this.a(R.string.kDeezerNav_Explore_Str);
                if (!akgVar.h()) {
                    if (akgVar.i() == null) {
                        Toast.makeText(alg.this.ae, R.string.kDeezer_CountryNotAvailable_Str, 0).show();
                        return;
                    }
                    akg akgVarI = akgVar.i();
                    ala alaVar = new ala();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("album", akgVarI);
                    bundle.putString("title", strA);
                    alaVar.g(bundle);
                    if (!ahn.a()) {
                        alg.this.ae.q().a(alaVar, (arc) null);
                        return;
                    } else {
                        alg.this.ae.q().a(alaVar, new arc().c(R.id.menu_container));
                        return;
                    }
                }
                ala alaVar2 = new ala();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("album", akgVar);
                bundle2.putString("title", strA);
                alaVar2.g(bundle2);
                if (!ahn.a()) {
                    alg.this.ae.q().a(alaVar2, (arc) null);
                } else {
                    alg.this.ae.q().a(alaVar2, new arc().c(R.id.menu_container));
                }
            }
        }
    };
    private List<akg> ap = new ArrayList();
    private alt aq = null;
    private TextView b;
    private AnimationListView c;
    private ListView d;
    private View e;
    private qn f;

    public alg() {
        this.f = new b();
        this.ah = new a();
    }

    @Override // defpackage.ale
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = layoutInflater.inflate(R.layout.fragment_deezer_explore, (ViewGroup) null);
        this.b = (TextView) this.e.findViewById(R.id.genres_tv);
        this.c = (AnimationListView) this.e.findViewById(R.id.albums_list);
        this.d = (ListView) this.e.findViewById(R.id.genres_list);
        this.e.findViewById(R.id.genres_tv_layout).setOnClickListener(new ahl(this) { // from class: alg.1
            @Override // defpackage.ahl
            public void a(View view) {
                if (alg.this.d.getVisibility() == 0) {
                    alg.this.d.setVisibility(8);
                    alg.this.c.setVisibility(0);
                    alg.this.ai.setImageResource(R.drawable.drop_down_list);
                } else {
                    alg.this.d.setVisibility(0);
                    alg.this.c.setVisibility(8);
                    alg.this.ai.setImageResource(R.drawable.drop_up_list);
                }
            }
        });
        this.d.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: alg.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                alx alxVar;
                alg.this.a((aki) adapterView.getItemAtPosition(i));
                if (adapterView.getAdapter() instanceof HeaderViewListAdapter) {
                    alxVar = (alx) ((HeaderViewListAdapter) adapterView.getAdapter()).getWrappedAdapter();
                } else {
                    alxVar = (alx) adapterView.getAdapter();
                }
                alxVar.a(i);
                alg.this.d.setVisibility(8);
                alg.this.c.setVisibility(0);
                alg.this.ai.setImageResource(R.drawable.drop_down_list);
                alg.this.aj = 0;
                if (alg.this.ap != null && !alg.this.ap.isEmpty()) {
                    alg.this.ap.clear();
                }
                alg.this.am = false;
            }
        });
        this.ai = (ImageView) this.e.findViewById(R.id.genres_imageview);
        this.aq = new alt(this.ae, this.ap, a(R.string.kDeezerNav_Explore_Str), this.g);
        arp arpVar = new arp(this.c);
        this.c.setAdapter((ListAdapter) this.aq);
        this.c.setOnItemClickListener(this.ao);
        this.c.setOnItemChosenListener(this.an);
        arpVar.a();
        this.e.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        return this.e;
    }

    @Override // defpackage.ale, defpackage.ajk
    public void c(Bundle bundle) {
        mm.b(this + "deezerConnect.isSessionValid() = " + (this.g != null ? Boolean.valueOf(this.g.a()) : null), new Object[0]);
        if (a == null) {
            am();
        } else {
            alx alxVar = new alx(this.ae, a);
            arp arpVar = new arp(this.d);
            this.d.setAdapter((ListAdapter) alxVar);
            arpVar.a();
            if (a != null && !a.isEmpty()) {
                a(a.get(0));
            }
        }
        super.c(bundle);
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c((Bundle) null);
    }

    private void am() {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
        } else {
            new aky(this.ae, this.g, this.f).execute(new ql("genre"));
        }
    }

    class b implements qn {
        private b() {
        }

        @Override // defpackage.qn
        public void a(String str, Object obj) {
            mm.b(str, new Object[0]);
            try {
                alg.a = new qv(aki.class).a(str);
                alg.this.d.setAdapter((ListAdapter) new alx(alg.this.ae, alg.a));
                if (alg.a != null && !alg.a.isEmpty()) {
                    alg.this.a(alg.a.get(0));
                }
            } catch (IllegalStateException e) {
            }
        }

        @Override // defpackage.qn
        public void a(IOException iOException, Object obj) {
        }

        @Override // defpackage.qn
        public void a(MalformedURLException malformedURLException, Object obj) {
        }

        @Override // defpackage.qn
        public void a(qm qmVar, Object obj) {
            alg.this.al();
        }

        @Override // defpackage.qn
        public void a(qk qkVar, Object obj) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(aki akiVar) {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiNotReachableTip_Str, 0).show();
            return;
        }
        this.al = akiVar;
        this.b.setText(akiVar.b());
        aky akyVar = new aky(this.ae, this.g, this.ah);
        ql qlVar = new ql("editorial/" + akiVar.a() + "/selection");
        qlVar.a(Long.valueOf(akiVar.a()));
        akyVar.execute(qlVar);
    }

    class a implements qn {
        private a() {
        }

        @Override // defpackage.qn
        public void a(String str, Object obj) {
            mm.b(str, new Object[0]);
            try {
                alg.this.a((List<akg>) new qv(akg.class).a(str));
            } catch (IllegalStateException e) {
            }
        }

        @Override // defpackage.qn
        public void a(IOException iOException, Object obj) {
        }

        @Override // defpackage.qn
        public void a(MalformedURLException malformedURLException, Object obj) {
        }

        @Override // defpackage.qn
        public void a(qm qmVar, Object obj) {
            alg.this.al();
        }

        @Override // defpackage.qn
        public void a(qk qkVar, Object obj) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<akg> list) {
        this.ap.clear();
        this.ap.addAll(list);
        this.aq.a(this.ap);
        if (list == null || list.isEmpty() || list.size() < this.ak) {
            this.am = true;
        }
    }

    @Override // defpackage.ald, defpackage.ajj
    public ajv b() {
        return new ajv.a(super.b()).a(-13487558).a(q().getString(R.string.kDeezerNav_Explore_Str)).c();
    }
}
