package defpackage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.hkconnect.R;
import defpackage.ajv;
import defpackage.ayf;
import defpackage.ayg;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ayj extends ayi implements ayg.a, ayg.b, ayg.d {
    private ImageView ah;
    private ImageView ai;
    private ImageView aj;
    private ImageView ak;
    private String al;
    private String am;
    private String an;
    private String ao;
    private String ap;
    private String aq;
    private String ar;
    private String as;
    private String at;
    private String au;
    private TextView ax;
    private View f;
    private LayoutInflater h;
    private ImageView i;
    private ArrayList<String> g = null;
    private ArrayList<String> av = new ArrayList<>();
    private ArrayList<ayd> aw = new ArrayList<>();
    private MenuItem.OnMenuItemClickListener ay = new MenuItem.OnMenuItemClickListener() { // from class: ayj.6
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            ayp aypVar = new ayp();
            aypVar.g(new Bundle());
            ayj.this.ae.q().a(aypVar, (arc) null);
            return true;
        }
    };

    @Override // defpackage.ayi
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.h = layoutInflater;
        this.e = true;
        this.f = layoutInflater.inflate(R.layout.fragment_nokia_create_mix_artist, (ViewGroup) null);
        this.ax = (TextView) this.f.findViewById(R.id.mix_name);
        this.al = "";
        this.aq = "";
        this.am = "";
        this.ar = "";
        this.an = "";
        this.as = "";
        this.ao = "";
        this.at = "";
        this.ap = "";
        this.au = "";
        return this.f;
    }

    private void ao() {
        ((TextView) this.f.findViewById(R.id.tv1)).setTypeface(ahu.a(this.ae));
        ((TextView) this.f.findViewById(R.id.tv2)).setTypeface(ahu.a(this.ae));
        ((TextView) this.f.findViewById(R.id.tv3)).setTypeface(ahu.a(this.ae));
        this.i = (ImageView) this.f.findViewById(R.id.iv1);
        this.ah = (ImageView) this.f.findViewById(R.id.iv2);
        this.ai = (ImageView) this.f.findViewById(R.id.iv3);
        this.av = new ArrayList<>();
    }

    public void an() {
        String str = "";
        int i = 0;
        while (i < this.aw.size()) {
            String str2 = str + axz.a(this.aw.get(i).a);
            if (i != this.aw.size() - 1) {
                str2 = str2 + " & ";
            }
            i++;
            str = str2;
        }
        this.ax.setText(str);
    }

    private void ap() {
        ao();
        TextView textView = (TextView) this.f.findViewById(R.id.tv1);
        TextView textView2 = (TextView) this.f.findViewById(R.id.tv2);
        TextView textView3 = (TextView) this.f.findViewById(R.id.tv3);
        TextView textView4 = (TextView) this.f.findViewById(R.id.tv4);
        TextView textView5 = (TextView) this.f.findViewById(R.id.tv5);
        this.i = (ImageView) this.f.findViewById(R.id.iv1);
        this.ah = (ImageView) this.f.findViewById(R.id.iv2);
        this.ai = (ImageView) this.f.findViewById(R.id.iv3);
        this.aj = (ImageView) this.f.findViewById(R.id.iv4);
        this.ak = (ImageView) this.f.findViewById(R.id.iv5);
        if (this.aw.size() >= 1) {
            ayd aydVar = this.aw.get(0);
            textView.setText(axz.a(aydVar.a));
            this.i.setVisibility(0);
            this.av.add(this.aq);
            ayf.a().a(ayf.a.FetchArtist, this, aydVar.b);
        } else {
            textView.setText("");
            textView2.setText("");
            textView3.setText("");
            textView4.setText("");
            textView5.setText("");
        }
        if (this.aw.size() >= 2) {
            ayd aydVar2 = this.aw.get(1);
            textView2.setText(axz.a(aydVar2.a));
            this.ah.setVisibility(0);
            this.av.add(this.ar);
            ayf.a().a(ayf.a.FetchArtist, this, aydVar2.b);
        } else {
            textView2.setText("");
            textView3.setText("");
            textView4.setText("");
            textView5.setText("");
        }
        if (this.aw.size() >= 3) {
            ayd aydVar3 = this.aw.get(2);
            textView3.setText(axz.a(aydVar3.a));
            this.ai.setVisibility(0);
            this.av.add(this.as);
            ayf.a().a(ayf.a.FetchArtist, this, aydVar3.b);
        } else {
            textView3.setText("");
            textView4.setText("");
            textView5.setText("");
        }
        if (this.aw.size() >= 4) {
            ayd aydVar4 = this.aw.get(3);
            textView4.setText(axz.a(aydVar4.a));
            this.aj.setVisibility(0);
            this.av.add(this.at);
            ayf.a().a(ayf.a.FetchArtist, this, aydVar4.b);
        } else {
            textView4.setText("");
            textView5.setText("");
        }
        if (this.aw.size() >= 5) {
            ayd aydVar5 = this.aw.get(4);
            textView5.setText(axz.a(aydVar5.a));
            this.ak.setVisibility(0);
            this.av.add(this.au);
            ayf.a().a(ayf.a.FetchArtist, this, aydVar5.b);
        } else {
            textView5.setText("");
        }
        ((Button) this.f.findViewById(R.id.play_mix_button)).setOnClickListener(new View.OnClickListener() { // from class: ayj.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i = 0;
                if (aof.a().l()) {
                    Toast.makeText(ayj.this.p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                    return;
                }
                ayj.this.c();
                String[] strArr = new String[ayj.this.aw.size()];
                while (true) {
                    int i2 = i;
                    if (i2 < ayj.this.aw.size()) {
                        strArr[i2] = ((ayd) ayj.this.aw.get(i2)).b;
                        i = i2 + 1;
                    } else {
                        ayf.a().a(ayj.this.ae, ayj.this, strArr);
                        return;
                    }
                }
            }
        });
        ((Button) this.f.findViewById(R.id.add_artist_button)).setOnClickListener(new View.OnClickListener() { // from class: ayj.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ayp aypVar = new ayp();
                aypVar.g(new Bundle());
                ayj.this.ae.q().a(aypVar, (arc) null);
            }
        });
        ((ImageView) this.f.findViewById(R.id.search_button)).setOnClickListener(new View.OnClickListener() { // from class: ayj.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ayp aypVar = new ayp();
                aypVar.g(new Bundle());
                ayj.this.ae.q().a(aypVar, (arc) null);
            }
        });
        ((ImageView) this.f.findViewById(R.id.mixradio_back)).setOnClickListener(new View.OnClickListener() { // from class: ayj.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ayk aykVar = new ayk();
                ayj.this.aw = new ArrayList();
                ayj.this.av = new ArrayList();
                aykVar.g(new Bundle());
                ayj.this.ae.q().a(aykVar, (arc) null);
            }
        });
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void C() {
        super.C();
    }

    @Override // defpackage.ajj, defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        if (ayf.a().g() != null && !this.aw.contains(ayf.a().g())) {
            this.aw.add(ayf.a().g());
            ayf.a().a((ayd) null);
            ap();
            an();
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c(l());
    }

    @Override // defpackage.ayi
    boolean al() {
        return false;
    }

    @Override // defpackage.ayi, defpackage.ajk
    public void c(Bundle bundle) {
        ayd aydVar = (ayd) bundle.getSerializable("artist");
        if (aydVar != null && !this.aw.contains(aydVar)) {
            this.aw.add(aydVar);
        }
        ap();
        an();
        super.c(bundle);
    }

    @Override // ayg.a
    public void a(boolean z) {
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00f1  */
    @Override // ayg.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(ayf.a r9, org.json.JSONObject r10, java.lang.String r11) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ayj.a(ayf$a, org.json.JSONObject, java.lang.String):void");
    }

    @Override // ayg.b
    public void a(ayf.a aVar, JSONArray jSONArray) {
    }

    @Override // ayg.b
    public void a(ayf.a aVar, String str) {
        d();
        Toast.makeText(this.ae, R.string.MixRadioApiReturnError_Str, 1).show();
    }

    @Override // defpackage.ayi, defpackage.ayh, defpackage.ajj
    public ajv b() {
        ajv.a aVar = new ajv.a();
        aVar.a(this.ay);
        aVar.c(true);
        aVar.k(R.drawable.mixradio_search);
        return aVar.a(q().getColor(R.color.nokia_pink)).g(R.string.MixRadioCreateMix).c();
    }

    @Override // ayg.d
    public void a(ayf.b bVar, MusicData musicData) {
        if (bVar == ayf.b.Suceeded) {
            SharedPreferences sharedPreferences = this.ae.getSharedPreferences("MixRadio", 0);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            try {
                JSONArray jSONArray = new JSONArray();
                String string = this.ax.getText().toString();
                for (int i = 0; i < this.aw.size(); i++) {
                    jSONArray.put(this.aw.get(i).b);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mix_name", string);
                jSONObject.put("ids", jSONArray);
                if (this.aw.size() > 0) {
                    jSONObject.put("thumbnail", this.aw.get(0).b);
                }
                mm.b("MIX1", jSONObject.toString());
                JSONArray jSONArray2 = new JSONArray(sharedPreferences.getString("recent_mixes", new JSONArray().toString()));
                jSONArray2.put(jSONObject);
                mm.b("MIX", jSONArray2.toString());
                editorEdit.putString("recent_mixes", jSONArray2.toString());
                editorEdit.commit();
            } catch (JSONException e) {
                mm.b("MIX", "ERROR " + e.toString());
                e.printStackTrace();
            }
            d();
            if (bVar == ayf.b.FailedInvalidPlayer) {
                Toast.makeText(p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            } else if (bVar == ayf.b.SkipLimitReached) {
                Toast.makeText(p(), this.ae.getString(R.string.MixRadioSkipLimitTip_Str).replaceAll("%d", "" + ayf.a().f), 0).show();
            } else if (bVar == ayf.b.FailedNetworkError) {
                Toast.makeText(p(), R.string.MixRadioTimeOut_Str, 1).show();
            } else {
                if (aof.a().l()) {
                    Toast.makeText(p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                    return;
                }
                a(musicData);
            }
            this.al = "";
            this.aq = "";
            this.am = "";
            this.ar = "";
            this.an = "";
            this.as = "";
            this.av = new ArrayList<>();
            this.aw.clear();
            this.aw = new ArrayList<>();
            this.ae.q().a(new ayk(), (arc) null);
        }
    }
}
