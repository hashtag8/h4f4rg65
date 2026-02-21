package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.AlbumsInfo;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import defpackage.aih;
import defpackage.ajv;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ana extends amw implements anu<JSONObject> {
    private ProgressBar ah;
    private AnimationGridView d;
    private aih<AlbumsInfo> e;
    private View g;
    private View h;
    private TextView i;
    private final int b = 60;
    private int c = 0;
    private anv f = new anv(this);
    private ArrayList<AlbumsInfo> ai = null;
    private ajn aj = new ajn() { // from class: ana.1
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            ana.this.f.a("http://www.qobuz.com/api.json/0.2/album/get?app_id=394304373&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&album_id=" + ((AlbumsInfo) obj).a + "&limit=60&offset=" + ana.this.c, ana.this);
        }
    };
    private AdapterView.OnItemClickListener ak = new AdapterView.OnItemClickListener() { // from class: ana.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AlbumsInfo albumsInfo = (AlbumsInfo) ana.this.e.getItem(i);
            Bundle bundle = new Bundle();
            bundle.putParcelable("ALBUMSINFO", albumsInfo);
            bundle.putString("FLAG", "DISCOG");
            amm ammVar = new amm();
            ammVar.g(bundle);
            if (!ahn.a()) {
                ana.this.ae.q().a(ammVar, (arc) null);
            } else {
                ana.this.ae.q().a(ammVar, new arc().c(R.id.menu_container));
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.a(layoutInflater, viewGroup, bundle);
        this.g = layoutInflater.inflate(R.layout.qobuz_releases_layout, (ViewGroup) null);
        d();
        this.e = new aih<>(this.ae, new a(), 60, R.layout.qobuz_discover_release_item, R.layout.harman_list_loading);
        this.d.setAdapter((ListAdapter) this.e);
        this.d.setOnItemClickListener(this.ak);
        this.d.setOnItemChosenListener(this.aj);
        al();
        return this.g;
    }

    private void d() {
        this.d = (AnimationGridView) this.g.findViewById(R.id.grid_view);
        this.h = this.g.findViewById(R.id.loading);
        this.i = (TextView) this.g.findViewById(R.id.tips);
        this.i.setTextColor(q().getColor(R.color.black));
        this.ah = (ProgressBar) this.g.findViewById(R.id.pro_bar);
    }

    @Override // defpackage.amw, defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
    }

    private void al() {
        this.f.a("http://www.qobuz.com/api.json/0.2/catalog/getFeatured?type=albums&app_id=394304373&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&limit=60", this);
    }

    @Override // defpackage.anu
    public void a(JSONObject jSONObject) {
        if (jSONObject.optJSONObject("artist") != null) {
            ArrayList<MusicData> arrayListC = any.c(jSONObject);
            MusicPlaylistManager.a().h();
            MusicPlaylistManager.a().b(arrayListC);
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("albums");
        if (jSONObjectOptJSONObject.optInt("total") == 0) {
            this.h.setVisibility(8);
        } else {
            this.h.setVisibility(0);
        }
        this.ai = any.d(jSONObjectOptJSONObject);
        if (this.c == 0) {
            this.e.a(this.ai);
            this.e.notifyDataSetChanged();
        } else {
            this.e.b(this.ai);
        }
        this.h.setVisibility(8);
    }

    @Override // defpackage.anu
    public void b(String str) {
        if (str != null) {
            Toast.makeText(this.ae, str, 0).show();
        }
        this.h.setVisibility(8);
    }

    @Override // defpackage.anu
    public void c() {
        this.h.setVisibility(8);
    }

    @Override // defpackage.amw, defpackage.ajj
    public ajv b() {
        ajv.a aVarA = new ajv.a(super.b()).a(a(R.string.kQobuz_NewRelease_Str)).a(-9128246);
        if (ahn.a()) {
            aVarA.i(R.drawable.hamberger_white_icon);
        }
        return aVarA.c();
    }

    @Override // defpackage.ajj
    public void at() {
    }

    @Override // android.support.v4.app.Fragment
    public void f(boolean z) {
        super.f(z);
        if (this.ag && z) {
            c(l());
        }
    }

    class a implements aih.a<AlbumsInfo> {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
            ana.this.c = i;
            ana.this.f.a("http://www.qobuz.com/api.json/0.2/catalog/getFeatured?type=albums&app_id=394304373&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&limit=60&offset=" + (ana.this.c * i2), ana.this);
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, AlbumsInfo albumsInfo) {
            b bVar = (b) view.getTag();
            if (bVar == null) {
                b bVar2 = ana.this.new b();
                bVar2.a = (ImageView) view.findViewById(R.id.iv);
                bVar2.b = (TextView) view.findViewById(R.id.title);
                bVar2.c = (TextView) view.findViewById(R.id.art);
                bVar2.d = (TextView) view.findViewById(R.id.extra_info);
                bVar2.e = (ImageView) view.findViewById(R.id.hq_icon);
                view.setTag(bVar2);
                bVar = bVar2;
            }
            bVar.b.setText(albumsInfo.b);
            bVar.c.setText(albumsInfo.c);
            bif.a((Context) ana.this.ae).a(albumsInfo.e).a(Bitmap.Config.RGB_565).a(R.drawable.empty_cover_art_small).a(R.dimen.gridview_item_iconSize, R.dimen.gridview_item_iconSize).e().c().a(bVar.a);
            bVar.d.setText(albumsInfo.i.toUpperCase());
            bVar.d.setVisibility(0);
            if (albumsInfo.j) {
                bVar.e.setVisibility(0);
            } else {
                bVar.e.setVisibility(8);
            }
            return view;
        }
    }

    class b {
        public ImageView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public ImageView e;

        b() {
        }
    }
}
