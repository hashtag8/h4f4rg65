package defpackage;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.QobuzMusicData;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.age;
import defpackage.ahy;
import defpackage.aih;
import defpackage.ajv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ani extends amw {
    private aih<QobuzMusicData> ah;
    private b ai;
    private View ak;
    private String al;
    private ImageView am;
    private ImageView an;
    private TextView ao;
    private TextView ap;
    private TextView aq;
    private ImageView ar;
    private anw at;
    private DashboardActivity d;
    private anv e;
    private AnimationListView f;
    private View g;
    private View h;
    private TextView i;
    private final int b = 50;
    private int c = 0;
    private ProgressDialog aj = null;
    private PlayListInfo as = null;
    private ajn au = new ajn() { // from class: ani.4
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (aof.a().l()) {
                Toast.makeText(ani.this.d, ani.this.a(R.string.MusicServicePlayToMyPhoneTip_Str), 0).show();
                return;
            }
            if (!((MusicData) obj).isLegal) {
                Toast.makeText(ani.this.d, R.string.kQobuz_Not_Buy_Track_Str, 0).show();
                return;
            }
            if (!ani.this.aj.isShowing() && !ani.this.d.isFinishing() && MusicPlaylistManager.a().i().a() == 0) {
                ani.this.aj.show();
            }
            List<MusicData> listE = ani.this.at.e();
            MusicPlaylistManager.a().h();
            MusicPlaylistManager.a().a(listE, i, ani.this.at);
        }
    };
    private age.a av = new age.a() { // from class: ani.5
        @Override // age.a
        public void a(int i, List<MusicData> list, JSONObject jSONObject) {
            ArrayList arrayList = new ArrayList();
            Iterator<MusicData> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((QobuzMusicData) it.next());
            }
            if (ani.this.c == 0) {
                ani.this.ah.a(arrayList);
                ani.this.ah.notifyDataSetChanged();
            } else {
                ani.this.ah.b(arrayList);
            }
            ani.this.h.setVisibility(8);
            ani.this.ak.setVisibility(0);
        }

        @Override // age.a
        public void a(ErrorInfo errorInfo) {
            if (errorInfo != null) {
                if (errorInfo.a() == 401) {
                    ani.this.f.setEmptyView(ani.this.g.findViewById(R.id.qobuz_playlist_not_allowed));
                } else {
                    new ahy.a(ani.this.d).a().a(errorInfo);
                }
            }
            ani.this.h.setVisibility(8);
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
        this.ai = new b();
        this.d.registerReceiver(this.ai, intentFilter);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.g = layoutInflater.inflate(R.layout.qobuz_playlists_detail_fragment, (ViewGroup) null);
        this.f = (AnimationListView) this.g.findViewById(R.id.list_view);
        this.h = this.g.findViewById(R.id.loading);
        this.i = (TextView) this.g.findViewById(R.id.tips);
        this.i.setTextColor(q().getColor(R.color.black));
        this.ak = this.g.findViewById(R.id.top_layout);
        this.am = (ImageView) this.g.findViewById(R.id.albums_icon);
        this.an = (ImageView) this.g.findViewById(R.id.albums_bg);
        this.ao = (TextView) this.g.findViewById(R.id.art_name);
        this.aq = (TextView) this.g.findViewById(R.id.top_title);
        this.ap = (TextView) this.g.findViewById(R.id.tracks_count);
        this.ar = (ImageView) this.g.findViewById(R.id.blur_view);
        this.g.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return this.g;
    }

    @Override // defpackage.amw, defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
    }

    @Override // defpackage.amw, defpackage.ajj
    public ajv b() {
        return new ajv.a().a(this.al).a(-9128246).c();
    }

    @Override // android.support.v4.app.Fragment
    public View B() {
        return super.B();
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        this.as = (PlayListInfo) bundle.getParcelable("PLAYLISTINFO");
        if (this.as != null) {
            this.al = this.as.b;
            String str = this.as.a;
            this.at = new anw(str, bundle.getBoolean("isDiscovery"));
            this.ah = new aih<>(this.d, new a(str), 50, R.layout.qobuz_playlist_detail_item, R.layout.harman_list_loading);
            this.f.setAdapter((ListAdapter) this.ah);
            if (ahn.a()) {
                this.f.setLeftMargin((int) this.d.getResources().getDimension(R.dimen.left_menu_width));
                this.d.getResources().getDimension(R.dimen.right_panel_marginRight_no_handle);
            }
            this.at.a(0, 50, this.av);
            this.f.setOnItemChosenListener(this.au);
            if (this.aj == null) {
                this.aj = new ProgressDialog(this.d);
                this.aj.setProgressStyle(0);
                this.aj.setIndeterminate(false);
                this.aj.setCancelable(true);
                this.aj.setMessage(a(R.string.kAndroid_Loading));
                this.aj.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ani.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                    }
                });
            }
            this.ak.setVisibility(8);
            agx.a().a(this.d, this.as, this.am).a(new agw() { // from class: ani.2
                @Override // defpackage.agw
                public void a(Bitmap bitmap) {
                    ani.this.a(bitmap);
                }
            }).b();
            this.ao.setText(a(R.string.kQobuz_Playlists_Str) + " " + a(R.string.RdioBy_Str) + " " + this.as.e);
            this.aq.setVisibility(4);
            this.ap.setText(this.as.c + " " + a(R.string.kQobuz_Tracks_Str) + " - " + ann.a(this.as.f * 1000));
            this.h.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        agx.a().a(bitmap, 25.0f, 0.2f, false, new agw() { // from class: ani.3
            @Override // defpackage.agw
            public void a(Bitmap bitmap2) {
                ani.this.ar.setImageBitmap(bitmap2);
            }
        });
    }

    class a implements aih.a<QobuzMusicData>, View.OnClickListener {
        private String b;

        public a(String str) {
            this.b = str;
        }

        @Override // aih.a
        public void a(int i, int i2) {
            ani.this.c = i;
            ani.this.at.a(ani.this.c * i2, 50, ani.this.av);
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, QobuzMusicData qobuzMusicData) {
            C0031a c0031a = (C0031a) view.getTag();
            if (c0031a == null) {
                C0031a c0031a2 = new C0031a();
                c0031a2.a = (ImageView) view.findViewById(R.id.iv);
                c0031a2.b = (TextView) view.findViewById(R.id.song);
                c0031a2.c = (TextView) view.findViewById(R.id.album);
                c0031a2.d = (ImageView) view.findViewById(R.id.iv_more);
                view.setTag(c0031a2);
                c0031a = c0031a2;
            }
            c0031a.c.setVisibility(0);
            c0031a.d.setVisibility(0);
            c0031a.b.setText(qobuzMusicData.musicName + " - " + ann.b(qobuzMusicData.a * 1000));
            c0031a.c.setText(qobuzMusicData.album);
            new ahw().a(c0031a.a, qobuzMusicData.album_art);
            if (qobuzMusicData.a()) {
                c0031a.b.setTextColor(Color.parseColor("#000000"));
                c0031a.c.setTextColor(Color.parseColor("#666666"));
            } else {
                c0031a.b.setTextColor(Color.parseColor("#AAAAAA"));
                c0031a.c.setTextColor(Color.parseColor("#AAAAAA"));
            }
            c0031a.d.setTag(qobuzMusicData);
            c0031a.d.setOnClickListener(this);
            return view;
        }

        /* JADX INFO: renamed from: ani$a$a, reason: collision with other inner class name */
        class C0031a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public ImageView d;

            C0031a() {
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final QobuzMusicData qobuzMusicData = (QobuzMusicData) view.getTag();
            arz arzVar = new arz(ani.this.d);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(ani.this.d.getString(R.string.PlayTip_PlayNow_Str));
            arrayList.add(ani.this.d.getString(R.string.PlayTip_PlayNext_Str));
            arrayList.add(ani.this.d.getString(R.string.PlayTip_AddSongToQueue_Str));
            arrayList.add(ani.this.d.getString(R.string.PlayTip_ClearAll_Str));
            if (qobuzMusicData.songId != -1000) {
                arrayList.add(ani.this.d.getString(R.string.kQobuz_See_Artist_Str));
                if (!ani.this.a(qobuzMusicData)) {
                    arrayList.add(ani.this.q().getString(R.string.kQobuz_AddFavourite_Str));
                } else {
                    arrayList.add(ani.this.q().getString(R.string.kQobuz_DeleteFavourite_Str));
                }
            }
            arzVar.a(arrayList);
            arzVar.a(ani.this.d.getString(R.string.PlayTip_Title_Str));
            arzVar.a(new asi() { // from class: ani.a.1
                @Override // defpackage.asi
                public void a(int i) {
                    switch (i) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            ang.a(ani.this.d, i, qobuzMusicData, ani.this.at.e(), ani.this.aj);
                            break;
                        case 4:
                            a.this.a(qobuzMusicData);
                            break;
                        case 5:
                            if (((String) arrayList.get(i)).equals(ani.this.q().getString(R.string.kQobuz_AddFavourite_Str))) {
                                ani.this.d(qobuzMusicData);
                            } else {
                                ani.this.e(qobuzMusicData);
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
            ani.this.c = 0;
            if (!ahn.a()) {
                ani.this.d.q().a(ansVar, (arc) null);
            } else {
                ani.this.d.q().a(ansVar, new arc().c(R.id.menu_container));
            }
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void E() {
        super.E();
        this.d.unregisterReceiver(this.ai);
        if (this.aj != null && this.aj.isShowing()) {
            this.aj.dismiss();
            this.aj = null;
        }
    }

    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (ani.this.aj != null && ani.this.aj.isShowing()) {
                ani.this.aj.dismiss();
            }
        }
    }
}
