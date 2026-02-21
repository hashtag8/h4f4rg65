package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import defpackage.age;
import defpackage.aic;
import defpackage.ajv;
import defpackage.axd;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class axr extends axk implements axd.a, axd.b {
    private View a;
    private AnimationGridView ak;
    private TextView an;
    private ImageView ao;
    private axe ap;
    private aic<awz> b;
    private ArrayList<awz> aj = new ArrayList<>();
    private final int al = 100;
    private int am = 0;
    private AdapterView.OnItemClickListener aq = new AdapterView.OnItemClickListener() { // from class: axr.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            axs axsVar = new axs();
            Bundle bundle = new Bundle();
            bundle.putSerializable("playlist", (Serializable) axr.this.aj.get(i));
            axsVar.g(bundle);
            axr.this.a((axj) axsVar);
        }
    };
    private ajn ar = new ajn() { // from class: axr.4
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (aof.a().l() && !ain.j) {
                Toast.makeText(axr.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                return;
            }
            axr.this.ap = new axe((awz) obj);
            axr.this.ap.a(0, 100, axr.this.as);
        }
    };
    private age.a as = new age.a() { // from class: axr.5
        @Override // age.a
        public void a(int i, List<MusicData> list, JSONObject jSONObject) {
            MusicPlaylistManager.a().h();
            MusicPlaylistManager.a().a(list, axr.this.ap);
        }

        @Override // age.a
        public void a(ErrorInfo errorInfo) {
        }
    };

    static /* synthetic */ int f(axr axrVar) {
        int i = axrVar.am;
        axrVar.am = i + 1;
        return i;
    }

    @Override // axd.b
    public void a(String str, JSONObject jSONObject, String str2) throws JSONException {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        int i = 0;
        if (str.compareTo("user:playlists") == 0) {
            ArrayList arrayList = new ArrayList();
            this.aj.clear();
            try {
                JSONArray jSONArray3 = jSONObject.getJSONArray("playlists");
                while (i < jSONArray3.length()) {
                    JSONObject jSONObject2 = jSONArray3.getJSONObject(i);
                    awz awzVar = new awz();
                    awzVar.a = jSONObject2.optString("id");
                    awzVar.b = jSONObject2.optString("name");
                    awzVar.d = jSONObject2.optString("description");
                    awzVar.e = jSONObject2.optString("createdAt");
                    awzVar.f = jSONObject2.optString("lastModified");
                    awzVar.g = jSONObject2.optString("visibility");
                    awzVar.c = awp.a(jSONObject2);
                    arrayList.add(awzVar);
                    axc.a().a(awzVar.c, "user:playlist", (axd.b) this, new abw().a(awzVar), "", 0, 100, true);
                    i++;
                }
                this.aj.addAll(this.aj.size(), (ArrayList) arrayList.clone());
                this.b.b(arrayList);
                this.b.notifyDataSetChanged();
                this.an.setText("" + this.aj.size() + " " + this.ae.getString(R.string.JukePlaylists));
                this.an.setTextColor(this.ae.getResources().getColor(R.color.white));
                al();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (str.compareTo("user:portal") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            this.aj.clear();
            try {
                this.b.a(this.aj);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.b.notifyDataSetChanged();
            axc.a().a(axc.a().e, "user:user", (axd.b) this, "", "", -1, -1, true);
            return;
        }
        if (str.compareTo("user:user") == 0) {
            mm.b("CATALOG", jSONObject.toString());
            this.aj.clear();
            try {
                this.b.a(this.aj);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.b.notifyDataSetChanged();
            axc.a().a(axc.a().e, "user:playlists", (axd.b) this, "", "", -1, -1, true);
            return;
        }
        if (str.compareTo("user:home") == 0) {
            axc.a().a(axc.a().e, "user:user", (axd.b) this, "", "", 0, 100, true);
            return;
        }
        if (str.compareTo("delete:playlist") == 0) {
            this.aj.clear();
            this.b.a(this.aj);
            this.b.notifyDataSetChanged();
            if (this.ae != null) {
                Toast.makeText(this.ae, a(R.string.juke_playlist_removed), 0).show();
            }
            axc.a().a(axc.a().e, "user:playlists", (axd.b) this, "", "", -1, -1, true);
            return;
        }
        if (str.compareTo("edit:playlist") == 0) {
            this.aj.clear();
            this.b.a(this.aj);
            this.b.notifyDataSetChanged();
            axc.a().a(axc.a().e, "user:playlists", (axd.b) this, "", "", -1, -1, true);
            return;
        }
        if (str.compareTo("user:playlist") == 0) {
            try {
                jSONArray = jSONObject.getJSONArray("entries");
            } catch (JSONException e4) {
                e4.printStackTrace();
                jSONArray = null;
            }
            awz awzVar2 = (awz) new abw().a(str2, new adp<awz>() { // from class: axr.1
            }.b());
            awzVar2.h = jSONArray.length();
            for (int i2 = 0; i2 < this.aj.size(); i2++) {
                awz awzVar3 = this.aj.get(i2);
                if (awzVar3.a.compareTo(awzVar2.a) == 0) {
                    awzVar3.h = awzVar2.h;
                }
            }
            try {
                this.b.a(this.aj);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            this.b.notifyDataSetChanged();
            return;
        }
        if (str.compareTo("user:playlist") == 0) {
            try {
                jSONArray2 = jSONObject.getJSONArray("entries");
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
            ArrayList arrayList2 = new ArrayList();
            while (i < jSONArray2.length()) {
                JSONObject jSONObjectOptJSONObject = jSONArray2.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    axb axbVar = new axb();
                    axbVar.a = jSONObjectOptJSONObject.optString("id");
                    axbVar.b = jSONObjectOptJSONObject.optString("name");
                    axbVar.c = jSONObjectOptJSONObject.optString("artistName");
                    axbVar.d = jSONObjectOptJSONObject.optString("albumName");
                    axbVar.e = jSONObjectOptJSONObject.optInt("lengthInSeconds");
                    axbVar.f = jSONObjectOptJSONObject.optString("genre");
                    axbVar.g = jSONObjectOptJSONObject.optString("label");
                    axbVar.h = jSONObjectOptJSONObject.optString("releaseYear");
                    jSONObjectOptJSONObject.optJSONArray("links");
                    axbVar.i = awp.a(jSONObjectOptJSONObject);
                    arrayList2.add(axbVar);
                }
                i++;
            }
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
        mm.b("URLs", "" + z);
        if (z) {
            axc.a().a(axc.a().e, "user:home", (axd.b) this, "", "", 0, 100, true);
        }
    }

    @Override // defpackage.axk
    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.juke_grid_animation_header, (ViewGroup) null);
        this.an = (TextView) this.a.findViewById(R.id.textView1);
        this.ao = (ImageView) this.a.findViewById(R.id.right_image);
        this.ak = (AnimationGridView) this.a.findViewById(R.id.group_gridview);
        ((RelativeLayout) this.a.findViewById(R.id.info_header)).setVisibility(0);
        this.b = new aic<>(this.ae, new a(), 100, R.layout.juke_gridview_item, R.layout.juke_gridview_item_empty);
        try {
            this.b.a(this.aj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.ak.setAdapter((ListAdapter) this.b);
        this.ak.setOnScrollListener(new awv(this.ae));
        return this.a;
    }

    @Override // defpackage.axk, defpackage.ajj, defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        if (!z && !am()) {
            c(l());
        }
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // defpackage.axk
    void c() {
        Configuration configuration = q().getConfiguration();
        if (configuration.orientation == 2 || configuration.orientation == 1) {
            this.ak.setNumColumns(this.ae.getResources().getInteger(R.integer.Juke_grid_columns));
        }
        this.ak.setAdapter((ListAdapter) this.b);
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c(l());
    }

    @Override // defpackage.axj, defpackage.ajj
    public ajv b() {
        return new ajv.a(super.b()).h(0).g(R.string.JukeMyPlaylists).c();
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
        this.an.setText("" + this.b.getCount() + " " + this.ae.getString(R.string.JukePlaylists));
        this.ao.setOnClickListener(new View.OnClickListener() { // from class: axr.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                awp.a(axr.this.ae, axr.this);
            }
        });
        this.ak.setOnItemClickListener(this.aq);
        this.ak.setOnItemChosenListener(this.ar);
    }

    class a implements aic.a<awz> {
        a() {
        }

        @Override // aic.a
        public void a(int i, int i2) {
            axr.f(axr.this);
        }

        @Override // aic.a
        public View a(int i, View view, ViewGroup viewGroup, final awz awzVar) {
            C0081a c0081a;
            C0081a c0081a2 = (C0081a) view.getTag();
            if (c0081a2 == null) {
                c0081a = new C0081a();
                c0081a.a = (ImageView) view.findViewById(R.id.iv);
                c0081a.b = (TextView) view.findViewById(R.id.tv);
                c0081a.c = (TextView) view.findViewById(R.id.tv_alt);
                c0081a.d = (RelativeLayout) view.findViewById(R.id.tv_details_holder);
                c0081a.e = (ImageView) view.findViewById(R.id.more_holder);
                view.setTag(c0081a);
            } else {
                c0081a = c0081a2;
            }
            c0081a.b.setText(awzVar.b);
            c0081a.c.setText("(" + awp.a(awzVar.e) + " - " + awzVar.h + " " + axr.this.ae.getString(R.string.JukeTracks) + ")");
            c0081a.a.setVisibility(0);
            c0081a.d.setVisibility(0);
            bif.a((Context) axr.this.ae).a(awzVar.c.get("catalog:image-256x256")).a("juke").a(R.drawable.juke_placeholder_150x150).a(c0081a.a);
            c0081a.e.setOnClickListener(new View.OnClickListener() { // from class: axr.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    awp.a((Context) axr.this.ae, awzVar.c, awzVar, (axd.b) axr.this, false);
                }
            });
            return view;
        }

        /* JADX INFO: renamed from: axr$a$a, reason: collision with other inner class name */
        class C0081a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public RelativeLayout d;
            public ImageView e;

            C0081a() {
            }
        }
    }
}
