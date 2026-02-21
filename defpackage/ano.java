package defpackage;

import android.content.res.Configuration;
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
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import defpackage.aih;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ano extends ajj implements anu<JSONObject> {
    protected anv a;
    protected AnimationGridView b;
    private TextView e;
    private aih<AlbumsInfo> g;
    private final int c = 60;
    private int d = 0;
    private String f = "";
    private ArrayList<AlbumsInfo> h = new ArrayList<>();
    private ajn i = new ajn() { // from class: ano.2
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            ano.this.a.a("http://www.qobuz.com/api.json/0.2/album/get?app_id=394304373&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&album_id=" + ((AlbumsInfo) obj).a + "&limit=60&offset=" + ano.this.d, ano.this);
        }
    };

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.ae = (DashboardActivity) p();
        this.a = new anv(this);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.qobuz_search_grid_layout, (ViewGroup) null);
        this.b = (AnimationGridView) viewInflate.findViewById(R.id.grid_view);
        this.e = (TextView) viewInflate.findViewById(R.id.tips);
        this.g = new aih<>(this.ae, new a(), 60 / am(), R.layout.qobuz_discover_release_item, R.layout.harman_list_loading);
        this.b.setAdapter((ListAdapter) this.g);
        this.b.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: ano.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AlbumsInfo albumsInfo = (AlbumsInfo) adapterView.getAdapter().getItem(i);
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("ALBUMSINFO", albumsInfo);
                bundle2.putString("FLAG", "DISCOG");
                amm ammVar = new amm();
                if (ahn.a()) {
                    ammVar.g(bundle2);
                    ano.this.ae.q().a(ammVar, new arc().c(R.id.menu_container));
                } else {
                    ammVar.g(bundle2);
                    ano.this.ae.q().a(ammVar, (arc) null);
                }
            }
        });
        this.b.setOnItemChosenListener(this.i);
        viewInflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        o(l());
        return viewInflate;
    }

    public void d() {
        if (this.g != null) {
            this.d = 0;
            this.g.a();
        }
    }

    @Override // defpackage.ajj
    public ajv b() {
        return null;
    }

    public void al() {
        if (this.b != null) {
            this.b.setSelection(0);
        }
    }

    public void o(Bundle bundle) {
        if (this.g != null && bundle != null && this.d <= 0) {
            this.h = bundle.getParcelableArrayList("RESULT");
            if (this.h != null) {
                this.f = bundle.getString("SEARCH");
                if (this.h.size() == 0) {
                    this.e.setVisibility(0);
                } else if (this.g != null && this.h != null) {
                    this.g.a(this.h);
                    this.e.setVisibility(8);
                    this.g.notifyDataSetChanged();
                }
            }
        }
    }

    class a implements aih.a<AlbumsInfo> {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
            ano.this.d = i;
            int i3 = ano.this.d * i2;
            String strEncode = "";
            try {
                strEncode = URLEncoder.encode(ano.this.f, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            ano.this.a.a("http://www.qobuz.com/api.json/0.2/search/getResults?app_id=394304373&query=" + strEncode + "&type=albums&limit=60&offset=" + i3, ano.this);
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, AlbumsInfo albumsInfo) {
            C0034a c0034a = (C0034a) view.getTag();
            if (c0034a == null) {
                C0034a c0034a2 = new C0034a();
                c0034a2.a = (ImageView) view.findViewById(R.id.iv);
                c0034a2.b = (TextView) view.findViewById(R.id.title);
                c0034a2.c = (TextView) view.findViewById(R.id.art);
                c0034a2.d = (TextView) view.findViewById(R.id.extra_info);
                c0034a2.e = (ImageView) view.findViewById(R.id.hq_icon);
                view.setTag(c0034a2);
                c0034a = c0034a2;
            }
            c0034a.b.setText(albumsInfo.b);
            c0034a.c.setText(albumsInfo.c);
            c0034a.d.setText(albumsInfo.i.toUpperCase());
            c0034a.d.setVisibility(0);
            if (albumsInfo.j) {
                c0034a.e.setVisibility(0);
            } else {
                c0034a.e.setVisibility(8);
            }
            new ahw().a(c0034a.a, albumsInfo.e);
            return view;
        }

        /* JADX INFO: renamed from: ano$a$a, reason: collision with other inner class name */
        class C0034a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public TextView d;
            public ImageView e;

            C0034a() {
            }
        }
    }

    @Override // defpackage.anu
    public void a(JSONObject jSONObject) {
        if (jSONObject.optJSONObject("artist") != null) {
            ArrayList<MusicData> arrayListC = any.c(jSONObject);
            MusicPlaylistManager.a().h();
            MusicPlaylistManager.a().b(arrayListC);
            return;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONObject("albums").optJSONArray("items");
        int length = jSONArrayOptJSONArray.length();
        this.h = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            AlbumsInfo albumsInfo = new AlbumsInfo();
            albumsInfo.a = jSONObjectOptJSONObject.optString("id");
            albumsInfo.f = jSONObjectOptJSONObject.optInt("tracks_count");
            albumsInfo.g = jSONObjectOptJSONObject.optInt("media_count");
            albumsInfo.b = jSONObjectOptJSONObject.optString("title");
            albumsInfo.h = jSONObjectOptJSONObject.optInt("duration");
            albumsInfo.d = jSONObjectOptJSONObject.optLong("released_at");
            albumsInfo.i = jSONObjectOptJSONObject.optJSONObject("genre").optString("name");
            albumsInfo.e = jSONObjectOptJSONObject.optJSONObject("image").optString("large");
            albumsInfo.c = jSONObjectOptJSONObject.optJSONObject("artist").optString("name");
            albumsInfo.j = jSONObjectOptJSONObject.optBoolean("hires");
            this.h.add(albumsInfo);
        }
        this.g.b(this.h);
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

    private int am() {
        return (ahn.a() && q().getConfiguration().orientation == 2) ? 4 : 2;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.g.a(this.h);
        this.g.notifyDataSetChanged();
    }
}
