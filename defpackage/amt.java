package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.AlbumsInfo;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.aih;
import java.util.ArrayList;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class amt extends ajj implements anu<JSONObject> {
    private View c;
    private LinearLayout d;
    private AnimationListView e;
    private anv f;
    private aih<AlbumsInfo> g;
    private final int a = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    private int b = 0;
    private ArrayList<AlbumsInfo> h = new ArrayList<>();
    private ajn i = new ajn() { // from class: amt.1
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            amt.this.f.a("http://www.qobuz.com/api.json/0.2/album/get?app_id=394304373&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&album_id=" + ((AlbumsInfo) obj).a + "&limit=" + HttpStatus.SC_INTERNAL_SERVER_ERROR + "&offset=" + amt.this.b, amt.this);
        }
    };
    private AdapterView.OnItemClickListener ah = new AdapterView.OnItemClickListener() { // from class: amt.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AlbumsInfo albumsInfo = (AlbumsInfo) amt.this.g.getItem(i);
            Bundle bundle = new Bundle();
            bundle.putParcelable("ALBUMSINFO", albumsInfo);
            bundle.putString("FLAG", "DISCOG");
            amm ammVar = new amm();
            ammVar.g(bundle);
            if (!ahn.a()) {
                amt.this.ae.q().a(ammVar, (arc) null);
            } else {
                amt.this.ae.q().a(ammVar, new arc().c(R.id.menu_container));
            }
        }
    };

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.f = new anv(this);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = layoutInflater.inflate(R.layout.qobuz_purchases_list_layout, (ViewGroup) null);
        this.e = (AnimationListView) this.c.findViewById(R.id.purchases_list);
        this.d = (LinearLayout) this.c.findViewById(R.id.no_results);
        this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return this.c;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        this.g = new aih<>(this.ae, new a(), HttpStatus.SC_INTERNAL_SERVER_ERROR, R.layout.qobuz_purchases_albums_item, R.layout.harman_list_loading);
        this.e.setAdapter((ListAdapter) this.g);
        this.e.setOnItemClickListener(this.ah);
        this.e.setOnItemChosenListener(this.i);
    }

    public void o(Bundle bundle) {
        if (this.g != null && bundle != null) {
            this.h = bundle.getParcelableArrayList("RESULT");
            if (this.h == null || this.h.size() == 0) {
                this.d.setVisibility(0);
                return;
            }
            this.d.setVisibility(8);
            if (this.b == 0) {
                this.g.a(this.h);
            } else {
                this.g.b(this.h);
            }
            this.g.notifyDataSetChanged();
        }
    }

    @Override // defpackage.ajj
    public ajv b() {
        return null;
    }

    class a implements aih.a<AlbumsInfo> {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
            amt.this.b = i;
            int i3 = amt.this.b * i2;
            amt.this.f.a("http://www.qobuz.com/api.json/0.2/purchase/getUserPurchases?app_id=394304373&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&limit=" + HttpStatus.SC_INTERNAL_SERVER_ERROR + "&offset=" + amt.this.b, amt.this);
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, AlbumsInfo albumsInfo) {
            C0025a c0025a = (C0025a) view.getTag();
            if (c0025a == null) {
                C0025a c0025a2 = new C0025a();
                c0025a2.a = (ImageView) view.findViewById(R.id.iv);
                c0025a2.b = (TextView) view.findViewById(R.id.song);
                c0025a2.c = (TextView) view.findViewById(R.id.art);
                c0025a2.d = (TextView) view.findViewById(R.id.extra_info);
                c0025a2.e = (ImageView) view.findViewById(R.id.hq_icon);
                view.setTag(c0025a2);
                c0025a = c0025a2;
            }
            c0025a.b.setText(albumsInfo.b);
            c0025a.c.setText(albumsInfo.c);
            c0025a.d.setText(albumsInfo.i.toUpperCase());
            c0025a.d.setVisibility(0);
            if (albumsInfo.j) {
                c0025a.e.setVisibility(0);
            } else {
                c0025a.e.setVisibility(8);
            }
            new ahw().a(c0025a.a, albumsInfo.e);
            return view;
        }

        /* JADX INFO: renamed from: amt$a$a, reason: collision with other inner class name */
        class C0025a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public TextView d;
            public ImageView e;

            C0025a() {
            }
        }
    }

    @Override // defpackage.anu
    public void a(JSONObject jSONObject) {
        if (jSONObject.optJSONObject("artist") != null) {
            ArrayList<MusicData> arrayListC = any.c(jSONObject);
            MusicPlaylistManager.a().h();
            MusicPlaylistManager.a().b(arrayListC);
        }
    }

    @Override // defpackage.anu
    public void b(String str) {
        if (str != null) {
            Toast.makeText(this.ae, str, 0).show();
        }
    }

    @Override // defpackage.anu
    public void c() {
    }
}
