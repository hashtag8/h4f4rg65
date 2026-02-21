package defpackage;

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
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.PlayListInfo;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import defpackage.age;
import defpackage.aih;
import defpackage.ajv;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class anb extends amw implements anu<JSONObject> {
    private AnimationGridView d;
    private aih<PlayListInfo> e;
    private anv f;
    private View g;
    private View h;
    private TextView i;
    private int b = 60;
    private int c = 0;
    private ArrayList<PlayListInfo> ah = null;
    private ajn ai = new ajn() { // from class: anb.1
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            final anw anwVar = new anw(((PlayListInfo) obj).a, true);
            anwVar.a(0, 100, new age.a() { // from class: anb.1.1
                @Override // age.a
                public void a(int i2, List<MusicData> list, JSONObject jSONObject) {
                    MusicPlaylistManager.a().h();
                    MusicPlaylistManager.a().a(list, anwVar);
                }

                @Override // age.a
                public void a(ErrorInfo errorInfo) {
                    anb.this.b(errorInfo.toString());
                }
            });
        }
    };
    private AdapterView.OnItemClickListener aj = new AdapterView.OnItemClickListener() { // from class: anb.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            PlayListInfo playListInfo = (PlayListInfo) anb.this.e.getItem(i);
            Bundle bundle = new Bundle();
            bundle.putParcelable("PLAYLISTINFO", playListInfo);
            bundle.putBoolean("isDiscovery", true);
            ani aniVar = new ani();
            aniVar.g(bundle);
            if (!ahn.a()) {
                anb.this.ae.q().a(aniVar, (arc) null);
            } else {
                anb.this.ae.q().a(aniVar, new arc().c(R.id.menu_container));
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.a(layoutInflater, viewGroup, bundle);
        this.f = new anv(this);
        this.g = layoutInflater.inflate(R.layout.qobuz_releases_layout, (ViewGroup) null);
        d();
        return this.g;
    }

    private void d() {
        this.d = (AnimationGridView) this.g.findViewById(R.id.grid_view);
        this.h = this.g.findViewById(R.id.loading);
        this.i = (TextView) this.g.findViewById(R.id.tips);
        this.i.setTextColor(q().getColor(R.color.black));
    }

    @Override // defpackage.amw, defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        this.e = new aih<>(this.ae, new a(), this.b, R.layout.qobuz_discover_release_item, R.layout.harman_list_loading);
        this.d.setAdapter((ListAdapter) this.e);
        this.d.setOnItemClickListener(this.aj);
        this.d.setOnItemChosenListener(this.ai);
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        if (this.ah == null || this.ah.size() == 0) {
            al();
        }
    }

    @Override // defpackage.ajj
    public void at() {
    }

    @Override // defpackage.amw, defpackage.ajj
    public ajv b() {
        ajv.a aVarA = new ajv.a(super.b()).a(a(R.string.kQobuz_QobuzPlaylists_Str)).a(-9128246);
        if (ahn.a()) {
            aVarA.i(R.drawable.hamberger_white_icon);
        }
        return aVarA.c();
    }

    @Override // android.support.v4.app.Fragment
    public void f(boolean z) {
        super.f(z);
        if (this.ag && z) {
            c(l());
        }
    }

    private void al() {
        this.h.setVisibility(0);
        this.f.a("http://www.qobuz.com/api.json/0.2/playlist/getFeatured?type=editor-picks&app_id=394304373&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&limit=" + this.b, this);
    }

    @Override // defpackage.anu
    public void a(JSONObject jSONObject) {
        this.ah = any.a(jSONObject);
        if (this.c == 0) {
            this.e.a(this.ah);
            this.e.notifyDataSetChanged();
        } else {
            this.e.b(this.ah);
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

    class a implements aih.a<PlayListInfo> {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
            anb.this.c = i;
            anb.this.f.a("http://www.qobuz.com/api.json/0.2/playlist/getFeatured?type=editor-picks&app_id=394304373&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&limit=" + anb.this.b + "&offset=" + (anb.this.c * i2), anb.this);
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, PlayListInfo playListInfo) {
            b bVar = (b) view.getTag();
            if (bVar == null) {
                b bVar2 = anb.this.new b();
                bVar2.a = (ImageView) view.findViewById(R.id.iv);
                bVar2.b = (TextView) view.findViewById(R.id.title);
                bVar2.c = (TextView) view.findViewById(R.id.art);
                bVar2.d = (TextView) view.findViewById(R.id.extra_info);
                bVar2.e = (ImageView) view.findViewById(R.id.hq_icon);
                view.setTag(bVar2);
                bVar = bVar2;
            }
            bVar.e.setVisibility(8);
            bVar.b.setText(playListInfo.b);
            bVar.c.setText(playListInfo.e);
            agx.a().a(anb.this.ae, playListInfo, bVar.a).b();
            bVar.d.setText(anb.this.ae.getString(R.string.TidalNumOfTracks, new Object[]{Integer.valueOf(playListInfo.c)}));
            bVar.d.setVisibility(0);
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
