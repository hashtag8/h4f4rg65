package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.hkconnect.R;
import defpackage.aic;
import defpackage.ajv;
import defpackage.ayf;
import defpackage.ayg;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class aym extends ayi implements ayg.a, ayg.b, ayg.d {
    private String ah;
    ArrayList<JSONObject> f;
    private View g;
    private GridView h;
    private aic<JSONObject> i = null;
    private ajn ai = new ajn() { // from class: aym.1
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            aym.this.d(i);
        }
    };
    private AdapterView.OnItemClickListener aj = new AdapterView.OnItemClickListener() { // from class: aym.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            aym.this.d(i);
        }
    };

    @Override // defpackage.ayi
    boolean al() {
        return true;
    }

    @Override // defpackage.ayi
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater;
        this.g = layoutInflater.inflate(R.layout.fragment_nokia_group_home, (ViewGroup) null);
        this.h = (GridView) this.g.findViewById(R.id.group_gridview);
        this.h.setOnScrollListener(new ayb(this.ae));
        c();
        this.f = new ArrayList<>();
        an();
        return this.g;
    }

    @Override // defpackage.ayi, defpackage.ayh, defpackage.ajj
    public ajv b() {
        return new ajv.a().a(q().getColor(R.color.nokia_pink)).a(this.ah).c();
    }

    private void an() {
        ajo ajoVar = new ajo(this.ae, this.h);
        ajoVar.a(this.ai);
        this.h.setOnItemClickListener(this.aj);
        this.h.setOnTouchListener(ajoVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        JSONObject jSONObject = (JSONObject) this.i.getItem(i);
        if (aof.a().l()) {
            Toast.makeText(p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
        } else {
            c();
            ayf.a().a(this.ae, this, jSONObject.optString("id"));
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
    }

    @Override // defpackage.ayi, defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        if (bundle != null) {
            String string = bundle.getString("id");
            this.ah = bundle.getString("name");
            ayf.a().a(ayf.a.MixesInGroup, this, string);
        }
    }

    @Override // ayg.b
    public void a(ayf.a aVar, JSONObject jSONObject, String str) {
        if (aVar == ayf.a.MixesInGroup) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("radiostations");
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.f.add(jSONArray.getJSONObject(i));
                }
                this.i = new aic<>(this.ae, new a(), this.f.size() + 1, R.layout.nokia_gridview_item, R.layout.nokia_gridview_item_empty);
                try {
                    this.i.a(this.f);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.h.setAdapter((ListAdapter) this.i);
                this.h.setVisibility(0);
                this.i.notifyDataSetChanged();
                d();
                return;
            } catch (Exception e2) {
                mm.e(e2.toString(), new Object[0]);
                return;
            }
        }
        if (aVar == ayf.a.MixGroupsByGenre || aVar == ayf.a.MixGroupsByCategory) {
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

    @Override // ayg.a
    public void a(boolean z) {
    }

    @Override // ayg.d
    public void a(ayf.b bVar, MusicData musicData) {
        d();
        if (bVar == ayf.b.FailedInvalidPlayer) {
            Toast.makeText(p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            return;
        }
        if (bVar == ayf.b.SkipLimitReached) {
            Toast.makeText(p(), this.ae.getString(R.string.MixRadioSkipLimitTip_Str).replaceAll("%d", "" + ayf.a().f), 0).show();
        } else if (bVar == ayf.b.FailedNetworkError) {
            Toast.makeText(p(), R.string.MixRadioTimeOut_Str, 1).show();
        } else {
            a(musicData);
        }
    }

    class a implements aic.a<JSONObject> {
        public a() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, JSONObject jSONObject) {
            b bVar = (b) view.getTag();
            if (bVar == null) {
                b bVar2 = aym.this.new b();
                bVar2.a = (ImageView) view.findViewById(R.id.iv);
                bVar2.b = (TextView) view.findViewById(R.id.tv);
                bVar2.b.setTypeface(ahu.a(aym.this.ae));
                view.setTag(bVar2);
                bVar = bVar2;
            }
            try {
                bVar.b.setText(jSONObject.optString("name"));
                final String string = jSONObject.getJSONObject("thumbnails").getString("200x200");
                new ahw().a(bVar.a, new ahq() { // from class: aym.a.1
                    @Override // defpackage.ahq
                    public void a(View view2) {
                        bif.a((Context) aym.this.ae).a(string).b(view2.getWidth(), view2.getHeight()).e().a((ImageView) view2);
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return view;
        }
    }

    class b {
        public ImageView a;
        public TextView b;

        b() {
        }
    }
}
