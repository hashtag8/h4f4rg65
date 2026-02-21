package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.hkconnect.R;
import com.musicservice.mixradio.model.MixRadioAdvertData;
import com.musicservice.mixradio.model.MixRadioMusicData;
import com.musicservice.mixradio.model.MixRadioTrackData;
import defpackage.aic;
import defpackage.ajv;
import defpackage.arw;
import defpackage.ayf;
import defpackage.ayg;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ayk extends ayi implements ayg.a, ayg.b, ayg.d {
    private JSONArray aj;
    private GridView am;
    private View an;
    private View ao;
    private View ap;
    ArrayList<JSONObject> g;
    private View h;
    private arw i;
    String f = "MixRadio User";
    private ArrayList<String> ah = null;
    private boolean ai = true;
    private aic<JSONObject> ak = null;
    private final int al = 20;
    private MenuItem.OnMenuItemClickListener aq = new MenuItem.OnMenuItemClickListener() { // from class: ayk.1
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (ayk.this.i == null) {
                ayk.this.i = new arw.a(ayk.this.ae).a(ayk.this.ae.getString(R.string.MixradioLogoutBody, new Object[]{ayk.this.f})).a(ayk.this.ae.getString(R.string.MixRadioSignOut), new DialogInterface.OnClickListener() { // from class: ayk.1.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new ava().a(0, ayk.this.ae).b();
                        ayk.this.ae.a(MixRadioAdvertData.class, MixRadioMusicData.class, MixRadioTrackData.class);
                        Toast.makeText(ayk.this.ae, ayk.this.ae.getString(R.string.MixRadioLogoutSucceedTip), 1).show();
                        aho.a("mixradio_refresh", "");
                    }
                }).b(ayk.this.ae.getString(R.string.Cancel_Str), new DialogInterface.OnClickListener() { // from class: ayk.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ayk.this.i.dismiss();
                    }
                }).d(false).b();
            }
            if (!ayk.this.i.isShowing()) {
                new asc(ayk.this.i).a(ayk.this.p());
            }
            return true;
        }
    };
    private ajn ar = new ajn() { // from class: ayk.2
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            ayk.this.d(i);
        }
    };
    private AdapterView.OnItemClickListener as = new AdapterView.OnItemClickListener() { // from class: ayk.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ayk.this.d(i);
        }
    };

    private void ao() {
        ajo ajoVar = new ajo(this.ae, this.am);
        ajoVar.a(this.ar);
        this.am.setOnItemClickListener(this.as);
        this.am.setOnTouchListener(ajoVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        JSONObject jSONObject = (JSONObject) this.ak.getItem(i);
        if (aof.a().l()) {
            Toast.makeText(p(), R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
            return;
        }
        c();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ids");
        String[] strArr = new String[jSONArrayOptJSONArray.length()];
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            strArr[i2] = jSONArrayOptJSONArray.optString(i2);
        }
        ayf.a().a(this.ae, this, strArr);
    }

    @Override // defpackage.ayi, defpackage.ajk
    public void c(Bundle bundle) {
        axz.a = 2;
        super.c(bundle);
        c();
        a(ayf.a.RecentMixes, (JSONObject) null, "");
    }

    @Override // defpackage.ayi
    public View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.h = layoutInflater.inflate(R.layout.fragment_nokia_create_mix, (ViewGroup) null);
        this.b = layoutInflater;
        this.an = this.h.findViewById(R.id.mixradio_recent);
        this.ap = this.h.findViewById(R.id.mixradio_empty);
        this.ap.setOnClickListener(new View.OnClickListener() { // from class: ayk.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ayk.this.an();
            }
        });
        this.f = aho.d("mixradio_username");
        ((Button) this.h.findViewById(R.id.new_mix_button)).setOnClickListener(new View.OnClickListener() { // from class: ayk.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ayk.this.an();
            }
        });
        this.ao = this.h.findViewById(R.id.new_mix_image);
        this.ao.setOnClickListener(new View.OnClickListener() { // from class: ayk.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ayk.this.an();
            }
        });
        this.am = (GridView) this.h.findViewById(R.id.gridview2);
        c();
        this.an.setVisibility(8);
        this.ap.setVisibility(8);
        ap();
        if (this.g != null && this.g.size() > 0) {
            this.an.setVisibility(0);
            this.ap.setVisibility(8);
        }
        try {
            PackageInfo packageInfo = this.ae.getPackageManager().getPackageInfo(this.ae.getPackageName(), 0);
            ayf.a().a(packageInfo.packageName, packageInfo.versionName, this.ae, this);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        this.ak = new aic<>(this.ae, new a(), 20, R.layout.nokia_gridview_item, R.layout.nokia_gridview_item_empty);
        ao();
        return this.h;
    }

    private void ap() {
        try {
            this.aj = new JSONArray(this.ae.getSharedPreferences("MixRadio", 0).getString("recent_mixes", new JSONArray().toString()));
            this.g = new ArrayList<>();
            if (this.aj.length() != 0) {
                this.ai = false;
            }
            for (int i = 0; i < this.aj.length(); i++) {
                this.g.add(this.aj.getJSONObject(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void an() {
        ayp aypVar = new ayp();
        Bundle bundle = new Bundle();
        bundle.putInt("pos", 0);
        bundle.putBoolean("isTaste", false);
        bundle.putBoolean("new_mix", true);
        aypVar.g(bundle);
        this.ae.q().a(aypVar, (arc) null);
    }

    @Override // ayg.a
    public void a(boolean z) {
        if (z) {
            a(ayf.a.RecentMixes, (JSONObject) null, "");
        } else {
            d();
        }
    }

    @Override // defpackage.ayi, defpackage.ayh, defpackage.ajj
    public ajv b() {
        ajv.a aVar = new ajv.a();
        aVar.a(this.aq);
        aVar.i(R.drawable.hamberger_white_icon);
        aVar.c(true);
        aVar.k(R.drawable.mixradio_settings2x);
        return aVar.a(q().getColor(R.color.nokia_pink)).h(R.drawable.mixradio_nav_logo2x).c();
    }

    @Override // ayg.b
    public void a(ayf.a aVar, JSONObject jSONObject, String str) {
        if (aVar == ayf.a.RecentMixes) {
            this.g = new ArrayList<>();
            this.ai = true;
            if (this.g.size() == 0) {
                ap();
            } else {
                this.ai = false;
            }
            if (this.ai) {
                this.an.setVisibility(8);
                this.ap.setVisibility(0);
            } else {
                this.an.setVisibility(0);
                this.ap.setVisibility(8);
            }
            try {
                Collections.reverse(this.g);
                int size = this.g.size();
                this.g = new ArrayList<>(this.g.subList(0, size < 6 ? size : 6));
                this.ak.a(this.g);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.am.setAdapter((ListAdapter) this.ak);
            this.ak.notifyDataSetChanged();
            d();
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

    @Override // defpackage.ayi
    boolean al() {
        return true;
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
                b bVar2 = ayk.this.new b();
                bVar2.a = (ImageView) view.findViewById(R.id.iv);
                bVar2.b = (TextView) view.findViewById(R.id.tv);
                bVar2.b.setTypeface(ahu.a(ayk.this.ae));
                view.setTag(bVar2);
                bVar = bVar2;
            }
            String strOptString = jSONObject.optString("mix_name");
            bVar.b.setText(axz.a(strOptString));
            bVar.a.setTag(strOptString);
            final String strReplace = ayg.a(ayg.c.ArtistImage, "" + jSONObject.optString("thumbnail", "")).replace("http://", "https://");
            new ahw().a(bVar.a, new ahq() { // from class: ayk.a.1
                @Override // defpackage.ahq
                public void a(View view2) {
                    bif.a((Context) ayk.this.ae).a(strReplace).b(R.drawable.mixradio_missing_artist).b(view2.getWidth(), view2.getHeight()).e().a((ImageView) view2);
                }
            });
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
