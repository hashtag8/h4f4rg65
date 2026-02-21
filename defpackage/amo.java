package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.AlbumsInfo;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.ControlInterceptTouchScrollView;
import defpackage.aid;
import defpackage.ajv;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class amo extends ajj implements anu<JSONObject> {
    private DashboardActivity a;
    private TextView ah;
    private GridView ai;
    private GridView aj;
    private View ak;
    private View al;
    private aid<AlbumsInfo> am;
    private aid<AlbumsInfo> an;
    private String ao;
    private String ar;
    private ajp at;
    private anv b;
    private View c;
    private View d;
    private ImageView e;
    private ImageView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private ArrayList<AlbumsInfo> ap = null;
    private ArrayList<AlbumsInfo> aq = null;
    private ArrayList<String> as = new ArrayList<>();
    private ajn au = new ajn() { // from class: amo.1
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            amo.this.b.a("http://www.qobuz.com/api.json/0.2/album/get?app_id=394304373&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&album_id=" + ((AlbumsInfo) view.getTag(R.id.view_tag_callback_item)).a, amo.this);
        }
    };
    private View.OnClickListener av = new ahl(this) { // from class: amo.2
        @Override // defpackage.ahl
        public void a(View view) {
            switch (view.getId()) {
                case R.id.unfavourite /* 2131690752 */:
                    boolean zBooleanValue = ((Boolean) view.getTag()).booleanValue();
                    String strTrim = aho.d("qobuz_user_auth_token").trim();
                    String str = "http://www.qobuz.com/api.json/0.2/favorite/delete?app_id=394304373&user_auth_token=" + strTrim + "&artist_ids=" + amo.this.ao;
                    amo.this.f.setImageResource(R.drawable.qobuz_unfavourite);
                    amo.this.f.setTag(true);
                    if (zBooleanValue) {
                        str = "http://www.qobuz.com/api.json/0.2/favorite/create?app_id=394304373&user_auth_token=" + strTrim + "&artist_ids=" + amo.this.ao;
                        amo.this.f.setImageResource(R.drawable.qobuz_favourite);
                        amo.this.f.setTag(false);
                    }
                    amo.this.b.a(str, amo.this.new a((ImageView) view));
                    break;
                case R.id.show_more /* 2131690756 */:
                    boolean zBooleanValue2 = ((Boolean) view.getTag()).booleanValue();
                    Bundle bundle = new Bundle();
                    bundle.putString("ID", amo.this.ao);
                    if (zBooleanValue2) {
                        bundle.putString("TITLE", "Albums");
                        bundle.putString("FLAG", "DISCOG");
                    } else {
                        bundle.putString("TITLE", "Musics");
                    }
                    amp ampVar = new amp();
                    ampVar.g(bundle);
                    if (!ahn.a()) {
                        amo.this.a.q().a(ampVar, (arc) null);
                    } else {
                        amo.this.a.q().a(ampVar, new arc().c(R.id.menu_container));
                    }
                    break;
            }
        }
    };

    @Override // defpackage.ajj
    public ajv b() {
        return new ajv.a().a(this.ar).e(q().getColor(R.color.white)).a(-9128246).c();
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.a = (DashboardActivity) p();
        this.b = new anv(this);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = layoutInflater.inflate(R.layout.qobuz_favourites_artists_detail_fragment, (ViewGroup) null);
        this.d = this.c.findViewById(R.id.loading);
        this.g = (TextView) this.c.findViewById(R.id.tips);
        this.g.setTextColor(q().getColor(R.color.black));
        this.f = (ImageView) this.c.findViewById(R.id.unfavourite);
        this.f.setTag(false);
        this.f.setOnClickListener(this.av);
        this.f.setVisibility(4);
        this.e = (ImageView) this.c.findViewById(R.id.albums_icon);
        this.h = (TextView) this.c.findViewById(R.id.tracks_count);
        View viewFindViewById = this.c.findViewById(R.id.my_music);
        this.i = (TextView) viewFindViewById.findViewById(R.id.title);
        this.i.setText(a(R.string.kQobuz_MyMusic_Str));
        this.ai = (GridView) viewFindViewById.findViewById(R.id.grid_view);
        this.ak = viewFindViewById.findViewById(R.id.show_more);
        ((TextView) this.ak.findViewById(R.id.show_content)).setText(a(R.string.kQobuz_ShowMoreMusic_Str));
        View viewFindViewById2 = this.c.findViewById(R.id.discography);
        this.ah = (TextView) viewFindViewById2.findViewById(R.id.title);
        this.ah.setText(a(R.string.kQobuz_Discography_Str));
        this.aj = (GridView) viewFindViewById2.findViewById(R.id.grid_view);
        this.al = viewFindViewById2.findViewById(R.id.show_more);
        ((TextView) this.al.findViewById(R.id.show_content)).setText(a(R.string.kQobuz_ShowMoreAlbum_Str));
        ControlInterceptTouchScrollView controlInterceptTouchScrollView = (ControlInterceptTouchScrollView) this.c.findViewById(R.id.grid_scroll_view);
        this.at = new ajp(this.a, controlInterceptTouchScrollView);
        controlInterceptTouchScrollView.setOnTouchListener(this.at);
        this.at.a(this.au);
        this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return this.c;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        this.am = new aid<>(this.a, new c(false), R.layout.qobuz_favourites_albums_item);
        this.ai.setAdapter((ListAdapter) this.am);
        this.an = new aid<>(this.a, new c(true), R.layout.qobuz_favourites_albums_item);
        this.aj.setAdapter((ListAdapter) this.an);
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        this.ar = bundle.getString("TITLE");
        this.ao = bundle.getString("ID");
        String strTrim = aho.d("qobuz_user_auth_token").trim();
        this.b.a("http://www.qobuz.com/api.json/0.2/collection/getAlbums?app_id=394304373&user_auth_token=" + strTrim + "&artist_id=" + this.ao + "&limit=100", this);
        this.b.a("http://www.qobuz.com/api.json/0.2/favorite/getUserFavorites?app_id=394304373&types=artists&user_auth_token=" + strTrim + "&user_id=" + aho.d("qobuz_user_info").trim().split("&")[3], this);
        new ahw().a(this.e, bundle.getString("IMAGEURL"));
        this.h.setText("0 " + a(R.string.kQobuz_Albums_Num_Str));
        this.b.a("http://www.qobuz.com/api.json/0.2/artist/get?app_id=394304373&artist_id=" + this.ao + "&extra=albums&limit=100&user_auth_token=" + strTrim, new b());
    }

    @Override // defpackage.anu
    public void a(JSONObject jSONObject) {
        if (jSONObject.optJSONObject("artist") != null) {
            ArrayList<MusicData> arrayListC = any.c(jSONObject);
            MusicPlaylistManager.a().h();
            MusicPlaylistManager.a().b(arrayListC);
            return;
        }
        if (jSONObject.optJSONObject("user") != null) {
            this.as = any.e(jSONObject.optJSONObject("artists"));
            if (!this.as.contains(this.ao)) {
                this.f.setImageResource(R.drawable.qobuz_unfavourite);
                this.f.setTag(true);
            }
            this.f.setVisibility(0);
            return;
        }
        this.ap = new ArrayList<>();
        int iOptInt = jSONObject.optInt("total");
        if (iOptInt == 0) {
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(0);
        }
        this.ap = any.d(jSONObject);
        try {
            this.am.a(this.ap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.am.notifyDataSetChanged();
        if (iOptInt >= 100) {
            this.ak.setVisibility(0);
            this.ak.setOnClickListener(this.av);
            this.ak.setTag(false);
            return;
        }
        this.ak.setVisibility(8);
    }

    @Override // defpackage.anu
    public void b(String str) {
        this.i.setVisibility(8);
    }

    @Override // defpackage.anu
    public void c() {
    }

    class b implements anu<JSONObject> {
        b() {
        }

        @Override // defpackage.anu
        public void a(JSONObject jSONObject) {
            amo.this.aq = new ArrayList();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("albums");
            int iOptInt = jSONObjectOptJSONObject.optInt("total");
            if (iOptInt == 0) {
                amo.this.ah.setVisibility(8);
            } else {
                amo.this.ah.setVisibility(0);
            }
            amo.this.h.setText(iOptInt + " " + amo.this.a(R.string.kQobuz_Albums_Num_Str));
            amo.this.aq = any.d(jSONObjectOptJSONObject);
            try {
                amo.this.an.a(amo.this.aq);
            } catch (Exception e) {
                e.printStackTrace();
            }
            amo.this.an.notifyDataSetChanged();
            if (iOptInt >= 100) {
                amo.this.al.setVisibility(0);
                amo.this.al.setOnClickListener(amo.this.av);
                amo.this.al.setTag(true);
            } else {
                amo.this.al.setVisibility(8);
            }
            amo.this.d.setVisibility(8);
        }

        @Override // defpackage.anu
        public void b(String str) {
            if (str != null) {
                Toast.makeText(amo.this.a, str, 0).show();
            }
            amo.this.d.setVisibility(8);
        }

        @Override // defpackage.anu
        public void c() {
            amo.this.d.setVisibility(8);
        }
    }

    class c implements aid.a<AlbumsInfo>, View.OnClickListener {
        private boolean b;

        public c(boolean z) {
            this.b = false;
            this.b = z;
        }

        @Override // aid.a
        public View a(int i, View view, ViewGroup viewGroup, AlbumsInfo albumsInfo) {
            a aVar = (a) view.getTag();
            if (aVar == null) {
                a aVar2 = new a();
                aVar2.a = (RelativeLayout) view.findViewById(R.id.item);
                aVar2.b = (ImageView) view.findViewById(R.id.iv);
                aVar2.c = (TextView) view.findViewById(R.id.item_title);
                aVar2.d = (TextView) view.findViewById(R.id.item_art);
                aVar2.e = (TextView) view.findViewById(R.id.item_year);
                aVar2.f = albumsInfo;
                view.setTag(aVar2);
                aVar = aVar2;
            }
            aVar.c.setText(albumsInfo.b);
            aVar.d.setText(albumsInfo.c);
            if (0 == albumsInfo.d) {
                aVar.e.setVisibility(8);
            } else {
                aVar.e.setText(ann.a(String.valueOf(albumsInfo.d), "dd/MM/yyyy"));
                aVar.e.setVisibility(0);
            }
            new ahw().a(aVar.b, albumsInfo.e);
            aVar.a.setTag(R.id.view_tag_callback_item, albumsInfo);
            aVar.a.setTag(R.id.view_tag_clicklistener, this);
            aVar.a.setOnTouchListener(amo.this.at);
            aVar.a.setVisibility(0);
            return view;
        }

        class a {
            public RelativeLayout a;
            public ImageView b;
            public TextView c;
            public TextView d;
            public TextView e;
            public AlbumsInfo f;

            a() {
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlbumsInfo albumsInfo = ((a) view.getTag()).f;
            Bundle bundle = new Bundle();
            bundle.putParcelable("ALBUMSINFO", albumsInfo);
            if (this.b) {
                bundle.putString("FLAG", "DISCOG");
            }
            amm ammVar = new amm();
            ammVar.g(bundle);
            if (!ahn.a()) {
                amo.this.a.q().a(ammVar, (arc) null);
            } else {
                amo.this.a.q().a(ammVar, new arc().c(R.id.menu_container));
            }
        }
    }

    class a implements anu<JSONObject> {
        public ImageView a;

        public a(ImageView imageView) {
            this.a = imageView;
        }

        @Override // defpackage.anu
        public void a(JSONObject jSONObject) {
            amo.this.a.sendStickyBroadcast(new Intent(anf.c));
        }

        @Override // defpackage.anu
        public void b(String str) {
            Toast.makeText(amo.this.a, "Delete failure!", 1).show();
            if (((Boolean) this.a.getTag()).booleanValue()) {
                this.a.setImageResource(R.drawable.qobuz_favourite);
                this.a.setTag(false);
            } else {
                this.a.setImageResource(R.drawable.qobuz_unfavourite);
                this.a.setTag(true);
            }
        }

        @Override // defpackage.anu
        public void c() {
        }
    }
}
