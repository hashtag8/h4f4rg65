package defpackage;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.PlayListInfo;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.age;
import defpackage.aih;
import defpackage.ajv;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class anj extends amw implements anu<JSONObject> {
    private SearchView ah;
    private View c;
    private View d;
    private TextView e;
    private DashboardActivity f;
    private AnimationListView g;
    private aih<PlayListInfo> h;
    private anv i;
    private final int b = 5000;
    private ArrayList<PlayListInfo> ai = null;
    private SearchView.OnQueryTextListener aj = new SearchView.OnQueryTextListener() { // from class: anj.1
        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            new Handler().postDelayed(new Runnable() { // from class: anj.1.1
                @Override // java.lang.Runnable
                public void run() {
                    ahf.a((Activity) anj.this.f);
                }
            }, 200L);
            return true;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (TextUtils.isEmpty(str)) {
                anj.this.h.a(anj.this.ai);
                anj.this.d.findViewById(R.id.pro_bar).setVisibility(0);
                anj.this.d.setVisibility(8);
            } else {
                ArrayList<PlayListInfo> arrayListA = anj.this.a(anj.this.ai, str);
                if (arrayListA.size() > 0) {
                    anj.this.h.a(arrayListA);
                    anj.this.d.findViewById(R.id.pro_bar).setVisibility(0);
                    anj.this.d.setVisibility(8);
                } else {
                    anj.this.e.setText(anj.this.a(R.string.kQobuz_Filter_Empty_Str));
                    anj.this.d.findViewById(R.id.pro_bar).setVisibility(8);
                    anj.this.d.setVisibility(0);
                }
            }
            anj.this.h.notifyDataSetChanged();
            return true;
        }
    };
    private ajn ak = new ajn() { // from class: anj.2
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            final anw anwVar = new anw(((PlayListInfo) obj).a, false);
            anwVar.a(0, 100, new age.a() { // from class: anj.2.1
                @Override // age.a
                public void a(int i2, List<MusicData> list, JSONObject jSONObject) {
                    MusicPlaylistManager.a().h();
                    MusicPlaylistManager.a().a(list, anwVar);
                }

                @Override // age.a
                public void a(ErrorInfo errorInfo) {
                    anj.this.b(errorInfo.toString());
                }
            });
        }
    };
    private AdapterView.OnItemClickListener al = new AdapterView.OnItemClickListener() { // from class: anj.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            PlayListInfo playListInfo = (PlayListInfo) adapterView.getItemAtPosition(i);
            Bundle bundle = new Bundle();
            bundle.putParcelable("PLAYLISTINFO", playListInfo);
            bundle.putBoolean("isDiscovery", false);
            ani aniVar = new ani();
            aniVar.g(bundle);
            if (!ahn.a()) {
                anj.this.f.q().a(aniVar, (arc) null);
            } else {
                anj.this.f.q().a(aniVar, new arc().c(R.id.menu_container));
            }
        }
    };

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.f = (DashboardActivity) p();
        this.i = new anv(this);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = layoutInflater.inflate(R.layout.qobuz_playlists_fragment, (ViewGroup) null);
        this.g = (AnimationListView) this.c.findViewById(R.id.list_view);
        this.g.setOffsetFooterFlag(true);
        this.d = this.c.findViewById(R.id.loading);
        this.e = (TextView) this.c.findViewById(R.id.tips);
        this.e.setTextColor(q().getColor(R.color.black));
        this.ah = (SearchView) this.c.findViewById(R.id.search_view);
        this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return this.c;
    }

    @Override // defpackage.amw, defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        this.h = new aih<>(this.f, new a(), 5000, R.layout.qobuz_playlist_item, R.layout.harman_list_loading);
        this.g.setAdapter((ListAdapter) this.h);
        this.g.setOnItemClickListener(this.al);
        this.g.setOnItemChosenListener(this.ak);
        this.ah.setOnQueryTextListener(this.aj);
        c(l());
    }

    public ArrayList<PlayListInfo> a(ArrayList<PlayListInfo> arrayList, String str) {
        ArrayList<PlayListInfo> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            PlayListInfo playListInfo = arrayList.get(i);
            if (!TextUtils.isEmpty(playListInfo.b) && playListInfo.b.toLowerCase().contains(str.toLowerCase())) {
                arrayList2.add(playListInfo);
            }
        }
        return arrayList2;
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        if (this.h != null && this.h.getCount() == 0) {
            String str = "http://www.qobuz.com/api.json/0.2/playlist/getUserPlaylists?app_id=394304373&username=" + aho.d("qobuz_user_info").trim().split("&")[1] + "&user_auth_token=" + aho.d("qobuz_user_auth_token").trim();
            this.d.setVisibility(0);
            this.i.a(str, this);
        }
    }

    @Override // defpackage.amw, defpackage.ajj
    public ajv b() {
        ajv.a aVarA = new ajv.a(super.b()).a(a(R.string.kQobuz_Playlists_Str)).a(-9128246);
        if (ahn.a()) {
            aVarA.i(R.drawable.hamberger_white_icon);
        }
        return aVarA.c();
    }

    @Override // defpackage.anu
    public void a(JSONObject jSONObject) {
        this.ai = any.a(jSONObject);
        ArrayList arrayList = new ArrayList();
        for (PlayListInfo playListInfo : this.ai) {
            if (playListInfo.c != 0) {
                arrayList.add(playListInfo);
            }
        }
        this.h.a(arrayList);
        this.d.setVisibility(8);
        this.h.notifyDataSetChanged();
    }

    @Override // defpackage.anu
    public void b(String str) {
        if (str != null) {
            Toast.makeText(this.f, str, 0).show();
        }
        this.d.setVisibility(8);
    }

    @Override // defpackage.anu
    public void c() {
        this.d.setVisibility(8);
    }

    class a implements aih.a<PlayListInfo> {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, PlayListInfo playListInfo) {
            C0033a c0033a = (C0033a) view.getTag();
            if (c0033a == null) {
                C0033a c0033a2 = new C0033a();
                c0033a2.a = (TextView) view.findViewById(R.id.item_name);
                c0033a2.b = (TextView) view.findViewById(R.id.item_detail);
                c0033a2.c = (ImageView) view.findViewById(R.id.iv);
                c0033a2.c.setVisibility(0);
                view.setTag(c0033a2);
                c0033a = c0033a2;
            }
            c0033a.a.setText(playListInfo.b);
            c0033a.b.setText(String.format("%s %s - %s - %s's %s", Integer.valueOf(playListInfo.c), anj.this.a(R.string.kQobuz_Tracks_Str), ann.a(playListInfo.f * 1000), playListInfo.e, anj.this.a(R.string.kQobuz_Tab_Playlist_Str)));
            if (playListInfo.h != null) {
                agx.a().a(anj.this.f, playListInfo, c0033a.c).a(R.drawable.empty_cover_art_small).b();
            } else {
                c0033a.c.setImageResource(R.drawable.empty_cover_art_small);
            }
            return view;
        }

        /* JADX INFO: renamed from: anj$a$a, reason: collision with other inner class name */
        class C0033a {
            public TextView a;
            public TextView b;
            public ImageView c;

            C0033a() {
            }
        }
    }
}
