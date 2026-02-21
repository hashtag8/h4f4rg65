package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
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
import com.harman.hkconnect.ui.HarmanApplication;
import com.harman.hkconnect.ui.custom.HRScrollView;
import defpackage.aid;
import defpackage.ajv;
import defpackage.bif;
import java.util.ArrayList;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ans extends ajj implements anu<JSONObject> {
    private TextView ah;
    private ImageView ai;
    private ImageView aj;
    private TextView ak;
    private GridView al;
    private View am;
    private aid<AlbumsInfo> an;
    private TextView aq;
    private HRScrollView as;
    private Bitmap au;
    private ajp av;
    private anv b;
    private View c;
    private View d;
    private View e;
    private String f;
    private String g;
    private TextView h;
    private TextView i;
    private ProgressDialog ao = null;
    private ArrayList<AlbumsInfo> ap = null;
    private a ar = null;
    private String at = "";
    private ajn aw = new ajn() { // from class: ans.3
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            ans.this.b.a("http://www.qobuz.com/api.json/0.2/album/get?app_id=394304373&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&album_id=" + ((AlbumsInfo) view.getTag(R.id.view_tag_callback_item)).a, ans.this);
        }
    };
    bip a = new bip() { // from class: ans.4
        @Override // defpackage.bip
        public void a(Bitmap bitmap, bif.d dVar) {
            ans.this.ai.setImageBitmap(bitmap);
            agx.a().a(bitmap, 25.0f, 0.2f, false, new agw() { // from class: ans.4.1
                @Override // defpackage.agw
                public void a(Bitmap bitmap2) {
                    ans.this.au = bitmap2;
                    ans.this.aj.setImageBitmap(bitmap2);
                }
            });
        }

        @Override // defpackage.bip
        public void a(Drawable drawable) {
        }

        @Override // defpackage.bip
        public void b(Drawable drawable) {
        }
    };
    private View.OnClickListener ax = new ahl(this) { // from class: ans.5
        @Override // defpackage.ahl
        public void a(View view) {
            switch (view.getId()) {
                case R.id.show_more /* 2131690756 */:
                    boolean zBooleanValue = ((Boolean) view.getTag()).booleanValue();
                    Bundle bundle = new Bundle();
                    bundle.putString("ID", ans.this.f);
                    if (zBooleanValue) {
                        bundle.putString("TITLE", "Albums");
                        bundle.putString("FLAG", "DISCOG");
                    } else {
                        bundle.putString("TITLE", "Musics");
                    }
                    amp ampVar = new amp();
                    ampVar.g(bundle);
                    if (!ahn.a()) {
                        ans.this.ae.q().a(ampVar, (arc) null);
                    } else {
                        ans.this.ae.q().a(ampVar, new arc().c(R.id.menu_container));
                    }
                    break;
                case R.id.read_more /* 2131690866 */:
                    if (ans.this.ar != null) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("TITLE", ans.this.at);
                        bundle2.putString("CONTENT", ans.this.ar.b);
                        if (ans.this.au != null) {
                            bundle2.putParcelable("BLURBACKGROUND", ans.this.au);
                        }
                        amn amnVar = new amn();
                        amnVar.g(bundle2);
                        if (!ahn.a()) {
                            ans.this.ae.q().a(amnVar, (arc) null);
                        } else {
                            ans.this.ae.q().a(amnVar, new arc().c(R.id.menu_container));
                        }
                    }
                    break;
            }
        }
    };

    class a {

        @acn(a = "summary")
        public String a;

        @acn(a = "content")
        public String b;
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.ae = (DashboardActivity) p();
        this.b = new anv(this);
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        this.an = new aid<>(this.ae, new b(), R.layout.qobuz_favourites_albums_item);
        this.al.setAdapter((ListAdapter) this.an);
        if (this.ao == null) {
            this.ao = new ProgressDialog(this.ae);
            this.ao.setProgressStyle(0);
            this.ao.setIndeterminate(false);
            this.ao.setCancelable(true);
            this.ao.setMessage(a(R.string.kAndroid_Loading));
            this.ao.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ans.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                }
            });
        }
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = layoutInflater.inflate(R.layout.see_artist_fragment, (ViewGroup) null);
        this.d = this.c.findViewById(R.id.loading);
        this.e = this.c.findViewById(R.id.DetailHeader);
        this.as = (HRScrollView) this.c.findViewById(R.id.DetailContext);
        this.ah = (TextView) this.c.findViewById(R.id.tips);
        this.ah.setTextColor(q().getColor(R.color.black));
        this.ai = (ImageView) this.c.findViewById(R.id.albums_icon);
        this.aq = (TextView) this.c.findViewById(R.id.read_more);
        this.aq.setVisibility(8);
        this.aj = (ImageView) this.c.findViewById(R.id.blur_see_artist_background);
        this.aq.setOnClickListener(this.ax);
        View viewFindViewById = this.c.findViewById(R.id.discography);
        this.ak = (TextView) viewFindViewById.findViewById(R.id.title);
        this.ak.setText(a(R.string.kQobuz_Discography_Str));
        this.al = (GridView) viewFindViewById.findViewById(R.id.grid_view);
        this.am = viewFindViewById.findViewById(R.id.show_more);
        ((TextView) this.am.findViewById(R.id.show_content)).setText(a(R.string.kQobuz_ShowMoreAlbum_Str));
        this.i = (TextView) this.c.findViewById(R.id.tracks_count);
        this.h = (TextView) this.c.findViewById(R.id.art_name);
        this.as.setOnScrollListener(new HRScrollView.a() { // from class: ans.2
            @Override // com.harman.hkconnect.ui.custom.HRScrollView.a
            public void a(int i) {
                if (i == 0) {
                    ans.this.as.getParent().bringChildToFront(ans.this.c.findViewById(R.id.DetailHeader));
                } else {
                    ans.this.as.getParent().bringChildToFront(ans.this.as);
                }
            }
        });
        this.av = new ajp(this.ae, this.as);
        this.as.setOnTouchListener(this.av);
        this.av.a(this.aw);
        this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return this.c;
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        this.g = bundle.getString("TITLE");
        this.at = bundle.getString("ARTISTNAME");
        this.f = bundle.getString("ID");
        this.b.a("http://www.qobuz.com/api.json/0.2/artist/get?app_id=394304373&artist_id=" + this.f + "&extra=albums&limit=" + HttpStatus.SC_INTERNAL_SERVER_ERROR + "&user_auth_token=" + aho.d("qobuz_user_auth_token").trim(), this);
    }

    @Override // defpackage.anu
    public void a(JSONObject jSONObject) {
        if (jSONObject.optJSONObject("artist") != null) {
            HarmanApplication.a().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
            ArrayList<MusicData> arrayListC = any.c(jSONObject);
            MusicPlaylistManager.a().h();
            MusicPlaylistManager.a().b(arrayListC);
            return;
        }
        this.ap = new ArrayList<>();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("biography");
        if (jSONObjectOptJSONObject != null) {
            this.ar = (a) new abw().a(jSONObjectOptJSONObject.toString(), a.class);
            this.h.setText(this.ar.a);
            if (this.ar.b != null) {
                this.aq.setVisibility(0);
            } else {
                this.aq.setVisibility(8);
            }
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("image");
        if (jSONObjectOptJSONObject2 != null) {
            bif.a((Context) this.ae).a(jSONObjectOptJSONObject2.optString("medium")).a(this.a);
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("albums");
        int iOptInt = jSONObjectOptJSONObject3.optInt("total");
        if (iOptInt == 0) {
            this.ak.setVisibility(8);
        } else {
            this.ak.setVisibility(0);
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray("items");
        int length = jSONArrayOptJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i);
            AlbumsInfo albumsInfo = new AlbumsInfo();
            albumsInfo.a = jSONObjectOptJSONObject4.optString("id");
            albumsInfo.f = jSONObjectOptJSONObject4.optInt("tracks_count");
            albumsInfo.g = jSONObjectOptJSONObject4.optInt("media_count");
            albumsInfo.b = jSONObjectOptJSONObject4.optString("title");
            albumsInfo.h = jSONObjectOptJSONObject4.optInt("duration");
            albumsInfo.d = jSONObjectOptJSONObject4.optLong("released_at");
            albumsInfo.e = jSONObjectOptJSONObject4.optJSONObject("image").optString("large");
            albumsInfo.c = jSONObjectOptJSONObject4.optJSONObject("artist").optString("name");
            albumsInfo.j = jSONObjectOptJSONObject4.optBoolean("hires");
            this.ap.add(albumsInfo);
        }
        try {
            this.an.a(this.ap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.an.notifyDataSetChanged();
        if (iOptInt >= 500) {
            this.am.setVisibility(0);
            this.am.setOnClickListener(this.ax);
            this.am.setTag(true);
        } else {
            this.am.setVisibility(8);
        }
        this.d.setVisibility(8);
        this.e.setVisibility(0);
        this.as.setVisibility(0);
    }

    @Override // defpackage.anu
    public void b(String str) {
        if (str != null) {
            Toast.makeText(this.ae, str, 0).show();
        }
        this.d.setVisibility(8);
        this.e.setVisibility(0);
        this.as.setVisibility(0);
    }

    @Override // defpackage.anu
    public void c() {
        this.d.setVisibility(8);
        this.e.setVisibility(0);
        this.as.setVisibility(0);
    }

    @Override // defpackage.ajj
    public ajv b() {
        return new ajv.a().a(this.at).e(q().getColor(R.color.white)).a(-9128246).c();
    }

    class b implements aid.a<AlbumsInfo> {
        View.OnClickListener a = new View.OnClickListener() { // from class: ans.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlbumsInfo albumsInfo = (AlbumsInfo) view.getTag(R.id.view_tag_callback_item);
                Bundle bundle = new Bundle();
                bundle.putParcelable("ALBUMSINFO", albumsInfo);
                bundle.putString("FLAG", "DISCOG");
                amm ammVar = new amm();
                ammVar.g(bundle);
                if (!ahn.a()) {
                    ans.this.ae.q().a(ammVar, (arc) null);
                } else {
                    ans.this.ae.q().a(ammVar, new arc().c(R.id.menu_container));
                }
            }
        };

        b() {
        }

        @Override // aid.a
        public View a(int i, View view, ViewGroup viewGroup, AlbumsInfo albumsInfo) {
            a aVar = (a) view.getTag(R.id.viewholder);
            if (aVar == null) {
                a aVar2 = new a();
                aVar2.a = (RelativeLayout) view.findViewById(R.id.item);
                aVar2.b = (ImageView) view.findViewById(R.id.iv);
                aVar2.c = (TextView) view.findViewById(R.id.item_title);
                aVar2.d = (TextView) view.findViewById(R.id.item_art);
                aVar2.e = (TextView) view.findViewById(R.id.item_year);
                aVar2.f = (ImageView) view.findViewById(R.id.hq_icon);
                view.setTag(R.id.viewholder, aVar2);
                aVar = aVar2;
            }
            aVar.c.setText(albumsInfo.b);
            aVar.d.setText(albumsInfo.c);
            if (albumsInfo.j) {
                aVar.f.setVisibility(0);
            } else {
                aVar.f.setVisibility(4);
            }
            if (0 == albumsInfo.d) {
                aVar.e.setVisibility(8);
            } else {
                aVar.e.setText(ann.a(String.valueOf(albumsInfo.d), "dd/MM/yyyy"));
                aVar.e.setVisibility(0);
            }
            bif.a((Context) ans.this.ae).a(albumsInfo.e).a(R.drawable.empty_cover_art_small).a(aVar.b);
            aVar.a.setOnTouchListener(ans.this.av);
            aVar.a.setTag(R.id.view_tag_callback_item, albumsInfo);
            aVar.a.setTag(R.id.view_tag_clicklistener, this.a);
            aVar.a.setVisibility(0);
            return view;
        }

        class a {
            public RelativeLayout a;
            public ImageView b;
            public TextView c;
            public TextView d;
            public TextView e;
            public ImageView f;

            a() {
            }
        }
    }
}
