package defpackage;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.QobuzMusicData;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.aih;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class anr extends amw implements anu<JSONObject> {
    protected anv b;
    private AnimationListView e;
    private TextView f;
    private aih<QobuzMusicData> h;
    private b i;
    private final int c = 60;
    private int d = 0;
    private ArrayList<QobuzMusicData> g = new ArrayList<>();
    private ProgressDialog ah = null;
    private String ai = "";
    private ajn aj = new ajn() { // from class: anr.2
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (aof.a().l()) {
                Toast.makeText(anr.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                return;
            }
            QobuzMusicData qobuzMusicData = (QobuzMusicData) obj;
            if (!qobuzMusicData.a()) {
                Toast.makeText(anr.this.ae, R.string.kQobuz_Not_Buy_Track_Str, 0).show();
                return;
            }
            if (!anr.this.ah.isShowing() && !anr.this.ae.isFinishing() && MusicPlaylistManager.a().i().a() == 0) {
                anr.this.ah.show();
            }
            MusicPlaylistManager.a().a(qobuzMusicData);
        }
    };

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.ae = (DashboardActivity) p();
        this.b = new anv(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.harman.hkconnect.android.music.ui.LOAD_URL_FINISHED");
        intentFilter.addAction("com.harman.hkconnect.android.music.ui.LOAD_URL_FINISHED");
        this.i = new b();
        this.ae.registerReceiver(this.i, intentFilter);
    }

    public void d() {
        if (this.h != null) {
            this.d = 0;
            this.h.a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.qobuz_search_list_layout, (ViewGroup) null);
        this.e = (AnimationListView) viewInflate.findViewById(R.id.list_view);
        this.f = (TextView) viewInflate.findViewById(R.id.tips);
        viewInflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.h = new aih<>(this.ae, new a(), 60, R.layout.qobuz_playlist_detail_item, R.layout.harman_list_loading);
        this.e.setAdapter((ListAdapter) this.h);
        if (ahn.a()) {
            this.e.setLeftMargin((int) this.ae.getResources().getDimension(R.dimen.left_menu_width));
        }
        this.e.setOnItemChosenListener(this.aj);
        if (this.ah == null) {
            this.ah = new ProgressDialog(this.ae);
            this.ah.setProgressStyle(0);
            this.ah.setIndeterminate(false);
            this.ah.setCancelable(true);
            this.ah.setMessage(a(R.string.kAndroid_Loading));
            this.ah.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: anr.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                }
            });
        }
        o(l());
        return viewInflate;
    }

    @Override // defpackage.amw, defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
    }

    @Override // defpackage.amw, defpackage.ajj
    public ajv b() {
        return null;
    }

    public void al() {
        if (this.e != null) {
            this.e.setSelection(0);
        }
    }

    @Override // defpackage.anu
    public void a(JSONObject jSONObject) {
        if (this.d != 0) {
            this.g = any.b(jSONObject);
            this.h.b(this.g);
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

    public void o(Bundle bundle) {
        if (this.h != null && bundle != null && this.d <= 0) {
            this.g = bundle.getParcelableArrayList("RESULT");
            if (this.g != null) {
                this.ai = bundle.getString("SEARCH");
                if (this.g.size() == 0) {
                    this.f.setVisibility(0);
                    return;
                }
                this.h.a(this.g);
                this.f.setVisibility(8);
                this.h.notifyDataSetChanged();
            }
        }
    }

    class a implements aih.a<QobuzMusicData>, View.OnClickListener {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
            anr.this.d = i;
            int i3 = anr.this.d * i2;
            String strEncode = "";
            try {
                strEncode = URLEncoder.encode(anr.this.ai, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            anr.this.b.a("http://www.qobuz.com/api.json/0.2/search/getResults?app_id=394304373&query=" + strEncode + "&type=tracks&limit=60&offset=" + i3, anr.this);
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, QobuzMusicData qobuzMusicData) {
            C0037a c0037a = (C0037a) view.getTag();
            if (c0037a == null) {
                C0037a c0037a2 = new C0037a();
                c0037a2.a = (ImageView) view.findViewById(R.id.iv);
                c0037a2.b = (TextView) view.findViewById(R.id.song);
                c0037a2.c = (TextView) view.findViewById(R.id.album);
                c0037a2.d = (ImageView) view.findViewById(R.id.iv_more);
                c0037a2.e = (TextView) view.findViewById(R.id.alphabet);
                c0037a2.f = (TextView) view.findViewById(R.id.extra_info);
                c0037a2.g = (ImageView) view.findViewById(R.id.hq_icon);
                view.setTag(c0037a2);
                c0037a = c0037a2;
            }
            if (qobuzMusicData.d) {
                c0037a.e.setText(qobuzMusicData.c);
                c0037a.e.setVisibility(0);
            } else {
                c0037a.e.setVisibility(8);
            }
            c0037a.f.setText(qobuzMusicData.e.toUpperCase());
            c0037a.f.setVisibility(0);
            if (qobuzMusicData.f) {
                c0037a.g.setVisibility(0);
            } else {
                c0037a.g.setVisibility(8);
            }
            c0037a.b.setText(qobuzMusicData.musicName + " - " + ann.b(qobuzMusicData.a * 1000));
            c0037a.c.setText(qobuzMusicData.album);
            if (qobuzMusicData.a()) {
                c0037a.b.setTextColor(Color.parseColor("#000000"));
                c0037a.c.setTextColor(Color.parseColor("#666666"));
            } else {
                c0037a.b.setTextColor(Color.parseColor("#AAAAAA"));
                c0037a.c.setTextColor(Color.parseColor("#AAAAAA"));
            }
            new ahw().a(c0037a.a, qobuzMusicData.album_art);
            c0037a.d.setTag(qobuzMusicData);
            c0037a.d.setOnClickListener(this);
            c0037a.c.setVisibility(0);
            c0037a.d.setVisibility(0);
            return view;
        }

        /* JADX INFO: renamed from: anr$a$a, reason: collision with other inner class name */
        class C0037a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public ImageView d;
            public TextView e;
            public TextView f;
            public ImageView g;

            C0037a() {
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final QobuzMusicData qobuzMusicData = (QobuzMusicData) view.getTag();
            arz arzVar = new arz(anr.this.ae);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(anr.this.ae.getString(R.string.PlayTip_PlayNow_Str));
            arrayList.add(anr.this.ae.getString(R.string.PlayTip_PlayNext_Str));
            arrayList.add(anr.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str));
            arrayList.add(anr.this.ae.getString(R.string.PlayTip_ClearAll_Str));
            if (qobuzMusicData.songId != -1000) {
                arrayList.add(anr.this.ae.getString(R.string.kQobuz_See_Artist_Str));
                if (!anr.this.a((MusicData) qobuzMusicData)) {
                    arrayList.add(anr.this.q().getString(R.string.kQobuz_AddFavourite_Str));
                } else {
                    arrayList.add(anr.this.q().getString(R.string.kQobuz_DeleteFavourite_Str));
                }
            }
            arzVar.a(arrayList);
            arzVar.a(anr.this.ae.getString(R.string.PlayTip_Title_Str));
            arzVar.a(new asi() { // from class: anr.a.1
                @Override // defpackage.asi
                public void a(int i) {
                    switch (i) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            ang.a(anr.this.ae, i, qobuzMusicData, new ArrayList(anr.this.g), anr.this.ah);
                            break;
                        case 4:
                            a.this.a(qobuzMusicData);
                            break;
                        case 5:
                            if (((String) arrayList.get(i)).equals(anr.this.q().getString(R.string.kQobuz_AddFavourite_Str))) {
                                anr.this.d(qobuzMusicData);
                            } else {
                                anr.this.e(qobuzMusicData);
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
                anr.this.ae.q().a(ansVar, (arc) null);
            } else {
                anr.this.ae.q().a(ansVar, new arc().c(R.id.menu_container));
            }
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void E() {
        super.E();
        this.ae.unregisterReceiver(this.i);
        if (this.ah != null && this.ah.isShowing()) {
            this.ah.dismiss();
            this.ah = null;
        }
    }

    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (anr.this.ah != null && anr.this.ah.isShowing()) {
                anr.this.ah.dismiss();
            }
        }
    }
}
