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
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.PlayListInfo;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.age;
import defpackage.aih;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class anq extends ajj implements anu<JSONObject> {
    private TextView c;
    private DashboardActivity d;
    private AnimationListView e;
    private aih<PlayListInfo> f;
    private anv g;
    private final int a = 60;
    private int b = 0;
    private String h = "";
    private ArrayList<PlayListInfo> i = new ArrayList<>();
    private AdapterView.OnItemClickListener ah = new AdapterView.OnItemClickListener() { // from class: anq.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            PlayListInfo playListInfo = (PlayListInfo) adapterView.getItemAtPosition(i);
            Bundle bundle = new Bundle();
            bundle.putParcelable("PLAYLISTINFO", playListInfo);
            bundle.putBoolean("isDiscovery", false);
            ani aniVar = new ani();
            if (ahn.a()) {
                aniVar.g(bundle);
                anq.this.d.q().a(aniVar, new arc().c(R.id.menu_container));
            } else {
                aniVar.g(bundle);
                anq.this.d.q().a(aniVar, (arc) null);
            }
        }
    };
    private ajn ai = new ajn() { // from class: anq.2
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            final anw anwVar = new anw(((PlayListInfo) obj).a, false);
            anwVar.a(0, 100, new age.a() { // from class: anq.2.1
                @Override // age.a
                public void a(int i2, List<MusicData> list, JSONObject jSONObject) {
                    MusicPlaylistManager.a().h();
                    MusicPlaylistManager.a().a(list, anwVar);
                }

                @Override // age.a
                public void a(ErrorInfo errorInfo) {
                    anq.this.b(errorInfo.toString());
                }
            });
        }
    };

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.d = (DashboardActivity) p();
        this.g = new anv(this);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.qobuz_search_list_layout, (ViewGroup) null);
        this.e = (AnimationListView) viewInflate.findViewById(R.id.list_view);
        this.c = (TextView) viewInflate.findViewById(R.id.tips);
        viewInflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f = new aih<>(this.d, new a(), 60, R.layout.qobuz_playlist_item, R.layout.harman_list_loading);
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setOnItemClickListener(this.ah);
        this.e.setOnItemChosenListener(this.ai);
        o(l());
        return viewInflate;
    }

    @Override // defpackage.ajj
    public ajv b() {
        return null;
    }

    public void d() {
        if (this.f != null) {
            this.b = 0;
            this.f.a();
        }
    }

    public void al() {
        if (this.e != null) {
            this.e.setSelection(0);
        }
    }

    @Override // defpackage.anu
    public void a(JSONObject jSONObject) {
        this.i = any.a(jSONObject);
        this.f.b(this.i);
    }

    @Override // defpackage.anu
    public void b(String str) {
        if (str != null) {
            Toast.makeText(this.d, str, 0).show();
        }
    }

    @Override // defpackage.anu
    public void c() {
    }

    public void o(Bundle bundle) {
        if (this.f != null && bundle != null && this.b <= 0) {
            this.i = bundle.getParcelableArrayList("RESULT");
            if (this.i != null) {
                this.h = bundle.getString("SEARCH");
                if (this.i.size() == 0) {
                    this.c.setVisibility(0);
                    return;
                }
                this.f.a(this.i);
                this.c.setVisibility(8);
                this.f.notifyDataSetChanged();
            }
        }
    }

    class a implements aih.a<PlayListInfo> {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
            anq.this.b = i;
            int i3 = anq.this.b * i2;
            String strEncode = "";
            try {
                strEncode = URLEncoder.encode(anq.this.h, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            anq.this.g.a("http://www.qobuz.com/api.json/0.2/search/getResults?app_id=394304373&query=" + strEncode + "&type=playlists&limit=60&offset=" + i3, anq.this);
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, PlayListInfo playListInfo) {
            C0036a c0036a = (C0036a) view.getTag();
            if (c0036a == null) {
                C0036a c0036a2 = new C0036a();
                c0036a2.a = (TextView) view.findViewById(R.id.item_name);
                c0036a2.b = (TextView) view.findViewById(R.id.item_detail);
                c0036a2.c = (ImageView) view.findViewById(R.id.iv);
                c0036a2.c.setVisibility(0);
                view.setTag(c0036a2);
                c0036a = c0036a2;
            }
            c0036a.a.setText(playListInfo.b);
            c0036a.b.setText(anq.this.d.getResources().getString(R.string.qobuz_search_playlist_details, Integer.valueOf(playListInfo.c), awp.a((int) playListInfo.f), playListInfo.e));
            new ahw().a(c0036a.c, playListInfo.g);
            return view;
        }

        /* JADX INFO: renamed from: anq$a$a, reason: collision with other inner class name */
        class C0036a {
            public TextView a;
            public TextView b;
            public ImageView c;

            C0036a() {
            }
        }
    }
}
