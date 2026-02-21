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
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.aih;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class amu extends amw implements anu<JSONObject> {
    private anv d;
    private LinearLayout e;
    private aih<QobuzMusicData> g;
    private b h;
    private final int b = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    private int c = 0;
    private ArrayList<QobuzMusicData> f = new ArrayList<>();
    private ProgressDialog i = null;
    private ajn ah = new ajn() { // from class: amu.2
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (aof.a().l()) {
                Toast.makeText(amu.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                return;
            }
            if (!((QobuzMusicData) obj).a()) {
                Toast.makeText(amu.this.ae, R.string.kQobuz_Not_Buy_Track_Str, 0).show();
                return;
            }
            if (!amu.this.i.isShowing() && !amu.this.ae.isFinishing() && MusicPlaylistManager.a().i().a() == 0) {
                amu.this.i.show();
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = amu.this.f.iterator();
            while (it.hasNext()) {
                arrayList.add((QobuzMusicData) it.next());
            }
            MusicPlaylistManager.a().h();
            MusicPlaylistManager.a().a(arrayList, i);
        }
    };

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.d = new anv(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.harman.hkconnect.android.music.ui.LOAD_URL_FINISHED");
        intentFilter.addAction("com.harman.hkconnect.android.music.ui.LOAD_URL_FINISHED");
        this.h = new b();
        this.ae.registerReceiver(this.h, intentFilter);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.qobuz_purchases_list_layout, (ViewGroup) null);
        AnimationListView animationListView = (AnimationListView) viewInflate.findViewById(R.id.purchases_list);
        this.e = (LinearLayout) viewInflate.findViewById(R.id.no_results);
        viewInflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.g = new aih<>(this.ae, new a(), HttpStatus.SC_INTERNAL_SERVER_ERROR, R.layout.qobuz_playlist_detail_item, R.layout.harman_list_loading);
        animationListView.setAdapter((ListAdapter) this.g);
        if (ahn.a()) {
            animationListView.setLeftMargin((int) this.ae.getResources().getDimension(R.dimen.left_menu_width));
            this.ae.getResources().getDimension(R.dimen.right_panel_marginRight_no_handle);
        }
        animationListView.setOnItemChosenListener(this.ah);
        if (this.i == null) {
            this.i = new ProgressDialog(this.ae);
            this.i.setProgressStyle(0);
            this.i.setIndeterminate(false);
            this.i.setCancelable(true);
            this.i.setMessage(a(R.string.kAndroid_Loading));
            this.i.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: amu.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                }
            });
        }
        o(l());
        return viewInflate;
    }

    public void o(Bundle bundle) {
        if (this.g != null && bundle != null) {
            this.f = bundle.getParcelableArrayList("RESULT");
            if (this.f == null || this.f.size() == 0) {
                this.e.setVisibility(0);
                return;
            }
            this.e.setVisibility(8);
            if (this.c == 0) {
                this.g.a(this.f);
            } else {
                this.g.b(this.f);
            }
            this.g.notifyDataSetChanged();
        }
    }

    @Override // defpackage.amw, defpackage.ajj
    public ajv b() {
        return null;
    }

    @Override // defpackage.anu
    public void a(JSONObject jSONObject) {
        this.f.addAll(any.b(jSONObject));
        if (this.c == 0) {
            this.g.a(this.f);
            this.g.notifyDataSetChanged();
        } else {
            this.g.b(this.f);
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

    class a implements aih.a<QobuzMusicData>, View.OnClickListener {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
            amu.this.c = i;
            int i3 = amu.this.c * i2;
            amu.this.d.a("http://www.qobuz.com/api.json/0.2/purchase/getUserPurchases?app_id=394304373&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&limit=" + HttpStatus.SC_INTERNAL_SERVER_ERROR + "&offset=" + amu.this.c, amu.this);
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, QobuzMusicData qobuzMusicData) {
            C0026a c0026a = (C0026a) view.getTag();
            if (c0026a == null) {
                C0026a c0026a2 = new C0026a();
                c0026a2.a = (ImageView) view.findViewById(R.id.iv);
                c0026a2.b = (TextView) view.findViewById(R.id.song);
                c0026a2.c = (TextView) view.findViewById(R.id.album);
                c0026a2.d = (ImageView) view.findViewById(R.id.iv_more);
                c0026a2.e = (TextView) view.findViewById(R.id.alphabet);
                c0026a2.f = (TextView) view.findViewById(R.id.extra_info);
                c0026a2.g = (ImageView) view.findViewById(R.id.hq_icon);
                view.setTag(c0026a2);
                c0026a = c0026a2;
            }
            if (qobuzMusicData.d) {
                c0026a.e.setText(qobuzMusicData.c);
                c0026a.e.setVisibility(0);
            } else {
                c0026a.e.setVisibility(8);
            }
            c0026a.b.setText(qobuzMusicData.musicName + " - " + ann.b(qobuzMusicData.a * 1000));
            c0026a.c.setText(qobuzMusicData.album);
            c0026a.f.setText(qobuzMusicData.e.toUpperCase());
            c0026a.f.setVisibility(0);
            if (qobuzMusicData.f) {
                c0026a.g.setVisibility(0);
            } else {
                c0026a.g.setVisibility(8);
            }
            if (qobuzMusicData.a()) {
                c0026a.b.setTextColor(Color.parseColor("#000000"));
                c0026a.c.setTextColor(Color.parseColor("#666666"));
            } else {
                c0026a.b.setTextColor(Color.parseColor("#AAAAAA"));
                c0026a.c.setTextColor(Color.parseColor("#AAAAAA"));
            }
            new ahw().a(c0026a.a, qobuzMusicData.album_art);
            c0026a.d.setTag(qobuzMusicData);
            c0026a.d.setOnClickListener(this);
            c0026a.c.setVisibility(0);
            c0026a.d.setVisibility(0);
            return view;
        }

        /* JADX INFO: renamed from: amu$a$a, reason: collision with other inner class name */
        class C0026a {
            public ImageView a;
            public TextView b;
            public TextView c;
            public ImageView d;
            public TextView e;
            public TextView f;
            public ImageView g;

            C0026a() {
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final QobuzMusicData qobuzMusicData = (QobuzMusicData) view.getTag();
            arz arzVar = new arz(amu.this.ae);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(amu.this.ae.getString(R.string.PlayTip_PlayNow_Str));
            arrayList.add(amu.this.ae.getString(R.string.PlayTip_PlayNext_Str));
            arrayList.add(amu.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str));
            arrayList.add(amu.this.ae.getString(R.string.PlayTip_ClearAll_Str));
            if (qobuzMusicData.songId != -1000) {
                arrayList.add(amu.this.ae.getString(R.string.kQobuz_See_Artist_Str));
                if (!amu.this.a((MusicData) qobuzMusicData)) {
                    arrayList.add(amu.this.q().getString(R.string.kQobuz_AddFavourite_Str));
                } else {
                    arrayList.add(amu.this.q().getString(R.string.kQobuz_DeleteFavourite_Str));
                }
            }
            arzVar.a(arrayList);
            arzVar.a(amu.this.ae.getString(R.string.PlayTip_Title_Str));
            arzVar.a(new asi() { // from class: amu.a.1
                @Override // defpackage.asi
                public void a(int i) {
                    switch (i) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            ang.a(amu.this.ae, i, qobuzMusicData, new ArrayList(amu.this.f), amu.this.i);
                            break;
                        case 4:
                            a.this.a(qobuzMusicData);
                            break;
                        case 5:
                            if (((String) arrayList.get(i)).equals(amu.this.q().getString(R.string.kQobuz_AddFavourite_Str))) {
                                amu.this.d(qobuzMusicData);
                            } else {
                                amu.this.e(qobuzMusicData);
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
                amu.this.ae.q().a(ansVar, (arc) null);
            } else {
                amu.this.ae.q().a(ansVar, new arc().c(R.id.menu_container));
            }
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void E() {
        super.E();
        this.ae.unregisterReceiver(this.h);
        if (this.i != null && this.i.isShowing()) {
            this.i.dismiss();
            this.i = null;
        }
    }

    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (amu.this.i != null && amu.this.i.isShowing()) {
                amu.this.i.dismiss();
            }
        }
    }
}
