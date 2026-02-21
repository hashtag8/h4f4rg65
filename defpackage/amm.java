package defpackage;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.AlbumsInfo;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.QobuzMusicData;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.AnimationListView;
import com.harman.hkconnect.ui.custom.AnimationView;
import defpackage.aih;
import defpackage.ajv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class amm extends amw implements anu<JSONObject> {
    private ImageView ah;
    private ImageView ai;
    private ImageView aj;
    private ImageView ak;
    private TextView al;
    private TextView am;
    private TextView an;
    private aih<QobuzMusicData> ap;
    private c aq;
    private ImageView at;
    private ImageView au;
    private Bitmap av;
    private AlbumsInfo ax;
    private DashboardActivity d;
    private anv e;
    private AnimationListView f;
    private View g;
    private View h;
    private TextView i;
    private final int b = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    private int c = 0;
    private List<MusicData> ao = new ArrayList();
    private ProgressDialog ar = null;
    private String as = "";
    private ArrayList<String> aw = new ArrayList<>();
    private View.OnClickListener ay = new ahl(this) { // from class: amm.2
        @Override // defpackage.ahl
        public void a(View view) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("AlbumsInfo", amm.this.ax);
            amv amvVar = new amv();
            amvVar.g(bundle);
            if (!ahn.a()) {
                amm.this.d.q().a(amvVar, (arc) null);
            } else {
                amm.this.d.q().a(amvVar, new arc().c(R.id.menu_container));
            }
        }
    };
    private View.OnClickListener az = new ahl(this) { // from class: amm.3
        @Override // defpackage.ahl
        public void a(View view) {
            boolean zBooleanValue = ((Boolean) amm.this.ah.getTag()).booleanValue();
            String strTrim = aho.d("qobuz_user_auth_token").trim();
            String str = "http://www.qobuz.com/api.json/0.2/favorite/delete?app_id=394304373&user_auth_token=" + strTrim + "&album_ids=" + amm.this.ax.a;
            amm.this.ah.setImageResource(R.drawable.qobuz_unfavourite);
            amm.this.ah.setTag(true);
            if (zBooleanValue) {
                str = "http://www.qobuz.com/api.json/0.2/favorite/create?app_id=394304373&user_auth_token=" + strTrim + "&album_ids=" + amm.this.ax.a;
                amm.this.ah.setImageResource(R.drawable.qobuz_favourite);
                amm.this.ah.setTag(false);
            }
            amm.this.e.a(str, amm.this.new a(amm.this.ah));
        }
    };
    private ajn aA = new ajn() { // from class: amm.7
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (aof.a().l()) {
                Toast.makeText(amm.this.d, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                return;
            }
            if (!((QobuzMusicData) obj).a()) {
                Toast.makeText(amm.this.d, R.string.kQobuz_Not_Buy_Track_Str, 0).show();
                return;
            }
            if (!amm.this.ar.isShowing() && !amm.this.d.isFinishing() && MusicPlaylistManager.a().i().a() == 0 && amm.this.ao.size() > 0) {
                amm.this.ar.show();
            }
            MusicPlaylistManager.a().h();
            MusicPlaylistManager.a().a(amm.this.ao, i);
        }
    };

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.d = (DashboardActivity) p();
        this.e = new anv(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.harman.hkconnect.android.music.ui.LOAD_URL_FINISHED");
        intentFilter.addAction("com.harman.hkconnect.android.music.ui.LOAD_URL_FINISHED");
        this.aq = new c();
        this.d.registerReceiver(this.aq, intentFilter);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.g = layoutInflater.inflate(R.layout.qobuz_detail_fragment, (ViewGroup) null);
        this.f = (AnimationListView) this.g.findViewById(R.id.list_view);
        this.h = this.g.findViewById(R.id.loading);
        this.i = (TextView) this.g.findViewById(R.id.tips);
        this.i.setTextColor(q().getColor(R.color.black));
        this.ah = (ImageView) this.g.findViewById(R.id.favourite);
        this.ah.setTag(false);
        this.ah.setOnClickListener(this.az);
        this.ah.setVisibility(4);
        this.ak = (ImageView) this.g.findViewById(R.id.read_icon);
        this.ak.setOnClickListener(this.ay);
        this.f.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: amm.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (amm.this.f.a()) {
                    amm.this.f.getParent().bringChildToFront(amm.this.f);
                } else {
                    amm.this.f.getParent().bringChildToFront(amm.this.g.findViewById(R.id.DetailHeader));
                }
            }
        });
        this.ai = (ImageView) this.g.findViewById(R.id.albums_icon);
        this.aj = (ImageView) this.g.findViewById(R.id.albums_bg);
        this.al = (TextView) this.g.findViewById(R.id.art_name);
        this.an = (TextView) this.g.findViewById(R.id.title);
        this.an.setVisibility(4);
        this.am = (TextView) this.g.findViewById(R.id.tracks_count);
        this.at = (ImageView) this.g.findViewById(R.id.blur_view);
        this.au = (ImageView) this.g.findViewById(R.id.hq_icon);
        this.g.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        agx.a().a(bitmap, 25.0f, 0.2f, false, new agw() { // from class: amm.4
            @Override // defpackage.agw
            public void a(Bitmap bitmap2) {
                amm.this.at.setImageBitmap(bitmap2);
            }
        });
    }

    @Override // defpackage.amw, defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        this.ax = (AlbumsInfo) bundle.getParcelable("ALBUMSINFO");
        this.as = bundle.getString("FLAG", "");
        this.ap = new aih<>(this.d, new b(), HttpStatus.SC_INTERNAL_SERVER_ERROR, R.layout.qobuz_albums_detail_item, R.layout.harman_list_loading);
        this.f.setAdapter((ListAdapter) this.ap);
        String strTrim = aho.d("qobuz_user_auth_token").trim();
        this.e.a("http://www.qobuz.com/api.json/0.2/album/get?app_id=394304373&user_auth_token=" + strTrim + "&album_id=" + this.ax.a + "&limit=" + HttpStatus.SC_INTERNAL_SERVER_ERROR + "&offset=" + this.c, this);
        this.e.a("http://www.qobuz.com/api.json/0.2/favorite/getUserFavorites?app_id=394304373&type=albums&user_auth_token=" + strTrim + "&user_id=" + aho.d("qobuz_user_info").trim().split("&")[3], this);
        this.h.setVisibility(0);
        if (ahn.a()) {
            this.f.setLeftMargin((int) this.d.getResources().getDimension(R.dimen.left_menu_width));
            this.d.getResources().getDimension(R.dimen.right_panel_marginRight_no_handle);
        }
        this.f.setOnItemChosenListener(this.aA);
        if (this.ar == null) {
            this.ar = new ProgressDialog(this.d);
            this.ar.setProgressStyle(0);
            this.ar.setIndeterminate(false);
            this.ar.setCancelable(true);
            this.ar.setMessage(a(R.string.kAndroid_Loading));
            this.ar.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: amm.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                }
            });
        }
        new ahw().a(this.ai, bif.a((Context) this.d).a(this.ax.e).a(R.drawable.empty_cover_art_small), new agw() { // from class: amm.6
            @Override // defpackage.agw
            public void a(Bitmap bitmap) {
                amm.this.av = bitmap;
                amm.this.a(bitmap);
            }
        });
        this.al.setText(this.ax.c);
        this.am.setText(this.ax.g + " " + a(R.string.kQobuz_Albums_Disc_Str) + " - " + this.ax.f + " " + a(R.string.kQobuz_Tracks_Str) + " - " + ann.a(this.ax.h * 1000));
        if (this.ax.j) {
            this.au.setVisibility(0);
        } else {
            this.au.setVisibility(8);
        }
    }

    @Override // defpackage.amw, defpackage.ajj
    public ajv b() {
        return new ajv.a().a(this.ax.b).e(q().getColor(R.color.white)).a(-9128246).c();
    }

    @Override // defpackage.anu
    public void a(JSONObject jSONObject) {
        if (jSONObject.optJSONObject("user") != null) {
            this.aw = any.e(jSONObject.optJSONObject("albums"));
            if (!this.aw.contains(this.ax.a)) {
                this.ah.setImageResource(R.drawable.qobuz_unfavourite);
                this.ah.setTag(true);
            }
            this.ah.setVisibility(0);
            return;
        }
        this.ax.m = jSONObject.optString("maximum_technical_specifications");
        if (this.ax.m.isEmpty()) {
            this.ax.m = this.d.getString(R.string.qobuz_quality_string, new Object[]{Integer.valueOf(jSONObject.optInt("maximum_bit_depth")), jSONObject.optString("maximum_sampling_rate")});
        }
        this.ax.n = Html.fromHtml(jSONObject.optString("description")).toString();
        this.ax.l = jSONObject.optJSONObject("label").optString("name");
        ArrayList<QobuzMusicData> arrayListB = any.b(jSONObject);
        int size = arrayListB.size();
        if (size < 500 || size == this.ax.f) {
            this.ap.a(true);
        }
        a((List<QobuzMusicData>) arrayListB);
        this.ao.addAll(arrayListB);
        if (this.c == 0) {
            this.ap.a(arrayListB);
            this.ap.notifyDataSetChanged();
        } else {
            this.ap.b(arrayListB);
        }
        this.h.setVisibility(8);
        this.ak.setVisibility(0);
    }

    public void a(List<QobuzMusicData> list) {
        Collections.sort(list, new Comparator<QobuzMusicData>() { // from class: amm.8
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(QobuzMusicData qobuzMusicData, QobuzMusicData qobuzMusicData2) {
                return qobuzMusicData.b - qobuzMusicData2.b;
            }
        });
    }

    @Override // defpackage.anu
    public void b(String str) {
        if (str != null) {
            Toast.makeText(this.d, str, 0).show();
        }
        this.h.setVisibility(8);
    }

    @Override // defpackage.anu
    public void c() {
        this.h.setVisibility(8);
    }

    class b implements aih.a<QobuzMusicData>, View.OnClickListener {
        private Paint b = new Paint();

        public b() {
            this.b.setFakeBoldText(false);
            this.b.setAntiAlias(true);
            this.b.setTextSize(amm.this.q().getDimension(R.dimen.qobuz_text_size));
            this.b.setStyle(Paint.Style.FILL);
            this.b.setColor(-16777216);
            this.b.setTextAlign(Paint.Align.CENTER);
        }

        @Override // aih.a
        public void a(int i, int i2) {
            if (amm.this.ap.a) {
                amm.this.c = i;
                amm.this.e.a("http://www.qobuz.com/api.json/0.2/playlist/get?app_id=394304373&playlist_id=" + amm.this.ax.a + "&extra=tracks&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&limit=" + HttpStatus.SC_INTERNAL_SERVER_ERROR + "&offset=" + (amm.this.c * i2), amm.this);
            }
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, QobuzMusicData qobuzMusicData) {
            a aVar = (a) view.getTag();
            if (aVar == null) {
                a aVar2 = new a();
                aVar2.a = (AnimationView) view.findViewById(R.id.iv);
                aVar2.b = (TextView) view.findViewById(R.id.song);
                aVar2.c = (TextView) view.findViewById(R.id.album);
                aVar2.d = (ImageView) view.findViewById(R.id.iv_more);
                view.setBackgroundColor(Color.parseColor("#ffffff"));
                view.setTag(aVar2);
                aVar = aVar2;
            }
            aVar.a.removeAllViews();
            aVar.c.setVisibility(8);
            aVar.d.setVisibility(0);
            aVar.b.setText(qobuzMusicData.musicName + " - " + ann.b(qobuzMusicData.a * 1000));
            aVar.c.setText(qobuzMusicData.album);
            aVar.a.setText(String.valueOf(qobuzMusicData.b));
            if (qobuzMusicData.a()) {
                aVar.b.setTextColor(Color.parseColor("#000000"));
                aVar.c.setTextColor(Color.parseColor("#666666"));
            } else {
                aVar.b.setTextColor(Color.parseColor("#AAAAAA"));
                aVar.c.setTextColor(Color.parseColor("#AAAAAA"));
            }
            aVar.a.setStoredBitmap(new Callable<Bitmap>() { // from class: amm.b.1
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Bitmap call() {
                    return amm.this.av;
                }
            });
            aVar.d.setTag(qobuzMusicData);
            aVar.d.setOnClickListener(this);
            return view;
        }

        class a {
            public AnimationView a;
            public TextView b;
            public TextView c;
            public ImageView d;

            a() {
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final QobuzMusicData qobuzMusicData = (QobuzMusicData) view.getTag();
            arz arzVar = new arz(amm.this.d);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(amm.this.d.getString(R.string.PlayTip_PlayNow_Str));
            arrayList.add(amm.this.d.getString(R.string.PlayTip_PlayNext_Str));
            arrayList.add(amm.this.d.getString(R.string.PlayTip_AddSongToQueue_Str));
            arrayList.add(amm.this.d.getString(R.string.PlayTip_ClearAll_Str));
            if (qobuzMusicData.songId != -1000) {
                arrayList.add(amm.this.d.getString(R.string.kQobuz_See_Artist_Str));
                if (!amm.this.a((MusicData) qobuzMusicData)) {
                    arrayList.add(amm.this.q().getString(R.string.kQobuz_AddFavourite_Str));
                } else {
                    arrayList.add(amm.this.q().getString(R.string.kQobuz_DeleteFavourite_Str));
                }
            }
            arzVar.a(arrayList);
            arzVar.a(amm.this.d.getString(R.string.PlayTip_Title_Str));
            arzVar.a(new asi() { // from class: amm.b.2
                @Override // defpackage.asi
                public void a(int i) {
                    switch (i) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            ang.a(amm.this.d, i, qobuzMusicData, amm.this.ao, amm.this.ar);
                            break;
                        case 4:
                            b.this.a(qobuzMusicData);
                            break;
                        case 5:
                            if (((String) arrayList.get(i)).equals(amm.this.q().getString(R.string.kQobuz_AddFavourite_Str))) {
                                amm.this.d(qobuzMusicData);
                            } else {
                                amm.this.e(qobuzMusicData);
                            }
                            break;
                    }
                }
            });
            arzVar.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(MusicData musicData) {
            Bundle bundle = new Bundle();
            bundle.putString("ID", String.valueOf(musicData.artist_id));
            bundle.putString("TITLE", musicData.musicName);
            bundle.putString("ARTISTNAME", musicData.artist);
            ans ansVar = new ans();
            ansVar.g(bundle);
            if (!ahn.a()) {
                amm.this.d.q().a(ansVar, (arc) null);
            } else {
                amm.this.d.q().a(ansVar, new arc().c(R.id.menu_container));
            }
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void E() {
        super.E();
        this.d.unregisterReceiver(this.aq);
        if (this.ar != null && this.ar.isShowing()) {
            this.ar.dismiss();
            this.ar = null;
        }
    }

    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (amm.this.ar != null && amm.this.ar.isShowing()) {
                amm.this.ar.dismiss();
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
            amm.this.d.sendStickyBroadcast(new Intent(anf.b));
        }

        @Override // defpackage.anu
        public void b(String str) {
            Toast.makeText(amm.this.d, "Delete failure!", 1).show();
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
