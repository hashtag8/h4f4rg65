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
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.AlbumsInfo;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.aih;
import defpackage.ajv;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class amy extends amw implements anu<JSONObject> {
    private aih<AlbumsInfo> ah;
    private AnimationListView ai;
    protected View b;
    protected View c;
    protected anv d;
    protected DashboardActivity e;
    protected String g;
    private TextView i;
    protected final int f = 50;
    protected int h = 0;
    private int aj = 0;
    private int ak = 0;
    private boolean al = false;
    private ajn am = new ajn() { // from class: amy.1
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            amy.this.d.a("http://www.qobuz.com/api.json/0.2/album/get?app_id=394304373&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&album_id=" + ((AlbumsInfo) obj).a + "&limit=50&offset=" + amy.this.h, amy.this);
        }
    };
    private AdapterView.OnItemClickListener an = new AdapterView.OnItemClickListener() { // from class: amy.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AlbumsInfo albumsInfo = (AlbumsInfo) amy.this.ah.getItem(i);
            Bundle bundle = new Bundle();
            bundle.putParcelable("ALBUMSINFO", albumsInfo);
            bundle.putString("FLAG", "DISCOG");
            amm ammVar = new amm();
            ammVar.g(bundle);
            if (ahn.a()) {
                amy.this.e.q().a(ammVar, new arc().c(R.id.menu_container));
            } else {
                amy.this.e.q().a(ammVar, (arc) null);
            }
        }
    };

    protected abstract void d();

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.e = (DashboardActivity) p();
        this.d = new anv(this);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.a(layoutInflater, viewGroup, bundle);
        this.b = layoutInflater.inflate(R.layout.discover_playlists_layout, (ViewGroup) null);
        this.ai = (AnimationListView) this.b.findViewById(R.id.list_view);
        this.c = this.b.findViewById(R.id.loading);
        this.i = (TextView) this.b.findViewById(R.id.tips);
        this.i.setTextColor(q().getColor(R.color.black));
        this.ak = ahn.a(p(), 80.0f);
        d();
        return this.b;
    }

    @Override // defpackage.amw, defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        this.ah = new aih<>(this.e, new a(), 50, R.layout.qobuz_discover_stream_item, R.layout.harman_list_loading);
        this.ai.setAdapter((ListAdapter) this.ah);
        this.ai.setOnItemClickListener(this.an);
        this.ai.setOnItemChosenListener(this.am);
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        al();
    }

    @Override // defpackage.amw, defpackage.ajj
    public ajv b() {
        ajv.a aVar = new ajv.a(super.b());
        if (ahn.a()) {
            aVar.i(R.drawable.hamberger_white_icon);
        }
        return aVar.c();
    }

    protected void al() {
        if (!this.al) {
            if (this.aj == 0) {
                this.c.setVisibility(0);
            }
            String str = this.g + "&username=" + aho.d("qobuz_user_info").trim().split("&")[1] + "&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&limit=50&offset=" + this.aj;
            this.al = false;
            this.d.a(str, this);
        }
    }

    @Override // defpackage.ajj
    public void at() {
    }

    @Override // defpackage.anu
    public void a(JSONObject jSONObject) {
        if (jSONObject.optJSONObject("artist") != null) {
            ArrayList<MusicData> arrayListC = any.c(jSONObject);
            MusicPlaylistManager.a().h();
            MusicPlaylistManager.a().b(arrayListC);
            return;
        }
        this.al = true;
        ArrayList<AlbumsInfo> arrayListD = any.d(jSONObject.optJSONObject("albums"));
        if (this.h == 0) {
            this.ah.a(arrayListD);
        } else {
            this.ah.b(arrayListD);
        }
        this.c.setVisibility(8);
        this.ah.notifyDataSetChanged();
    }

    @Override // defpackage.anu
    public void b(String str) {
        this.al = false;
        if (str != null) {
            Toast.makeText(this.e, str, 0).show();
        }
        this.c.setVisibility(8);
    }

    @Override // defpackage.anu
    public void c() {
        this.c.setVisibility(8);
    }

    class a implements aih.a<AlbumsInfo> {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
            amy.this.al = false;
            amy.this.h = i;
            amy.this.aj = amy.this.h * i2;
            amy.this.al();
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, AlbumsInfo albumsInfo) {
            C0027a c0027a = (C0027a) view.getTag();
            if (c0027a == null) {
                C0027a c0027a2 = new C0027a();
                c0027a2.a = (ImageView) view.findViewById(R.id.iv);
                c0027a2.b = (TextView) view.findViewById(R.id.artist);
                c0027a2.c = (TextView) view.findViewById(R.id.album);
                c0027a2.d = (TextView) view.findViewById(R.id.extra_info);
                c0027a2.e = (TextView) view.findViewById(R.id.awards_name);
                c0027a2.f = (ImageView) view.findViewById(R.id.hq_icon);
                view.setTag(c0027a2);
                c0027a = c0027a2;
            }
            if (albumsInfo.j) {
                c0027a.f.setVisibility(0);
            } else {
                c0027a.f.setVisibility(8);
            }
            c0027a.d.setText(albumsInfo.i.toUpperCase());
            if (albumsInfo.k != null) {
                c0027a.e.setVisibility(0);
                c0027a.e.setText(albumsInfo.k);
            } else {
                c0027a.e.setVisibility(8);
            }
            c0027a.c.setText(albumsInfo.b);
            c0027a.b.setText(albumsInfo.c);
            bif.a((Context) amy.this.e).a(albumsInfo.e).a(Bitmap.Config.RGB_565).a(R.drawable.empty_cover_art_small).b(amy.this.ak, amy.this.ak).e().c().a(c0027a.a);
            return view;
        }

        /* JADX INFO: renamed from: amy$a$a, reason: collision with other inner class name */
        class C0027a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public TextView d;
            public TextView e;
            public ImageView f;

            C0027a() {
            }
        }
    }
}
