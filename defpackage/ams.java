package defpackage;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.qobuz.model.QobuzMusicData;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.aih;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ams extends amw implements anu<JSONObject> {
    private aih<QobuzMusicData> ai;
    private b aj;
    private SearchView al;
    private View am;
    private DashboardActivity d;
    private anv e;
    private AnimationListView f;
    private View g;
    private View h;
    private TextView i;
    private final int b = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    private int c = 0;
    private ArrayList<QobuzMusicData> ah = new ArrayList<>();
    private ProgressDialog ak = null;
    private SearchView.OnQueryTextListener an = new SearchView.OnQueryTextListener() { // from class: ams.2
        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (TextUtils.isEmpty(str)) {
                ams.this.ai.a(ams.this.ah);
                ams.this.h.findViewById(R.id.pro_bar).setVisibility(0);
                ams.this.h.setVisibility(8);
            } else {
                ArrayList<QobuzMusicData> arrayListA = ams.this.a(ams.this.ah, str);
                if (arrayListA.size() > 0) {
                    ams.this.ai.a(arrayListA);
                    ams.this.h.findViewById(R.id.pro_bar).setVisibility(0);
                    ams.this.h.setVisibility(8);
                } else {
                    ams.this.i.setText(ams.this.a(R.string.kQobuz_Filter_Empty_Str));
                    ams.this.h.findViewById(R.id.pro_bar).setVisibility(8);
                    ams.this.h.setVisibility(0);
                }
            }
            ams.this.ai.notifyDataSetChanged();
            return true;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            new Handler().postDelayed(new Runnable() { // from class: ams.2.1
                @Override // java.lang.Runnable
                public void run() {
                    ahf.a((Activity) ams.this.d);
                }
            }, 200L);
            return true;
        }
    };
    private ajn ao = new ajn() { // from class: ams.3
        @Override // defpackage.ajn
        public void a(View view, int i, Object obj) {
            if (aof.a().l()) {
                Toast.makeText(ams.this.d, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                return;
            }
            if (!((QobuzMusicData) obj).a()) {
                Toast.makeText(ams.this.d, R.string.kQobuz_Not_Buy_Track_Str, 0).show();
                return;
            }
            if (!ams.this.ak.isShowing() && !ams.this.d.isFinishing() && MusicPlaylistManager.a().i().a() == 0) {
                ams.this.ak.show();
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ams.this.ah.iterator();
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
        this.d = (DashboardActivity) p();
        this.e = new anv(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.harman.hkconnect.android.music.ui.LOAD_URL_FINISHED");
        intentFilter.addAction("com.harman.hkconnect.android.music.ui.LOAD_URL_FINISHED");
        this.aj = new b();
        this.d.registerReceiver(this.aj, intentFilter);
        d();
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.g = layoutInflater.inflate(R.layout.qobuz_favourites_list_layout, (ViewGroup) null);
        this.al = (SearchView) this.g.findViewById(R.id.search_view);
        this.al.setQueryHint(a(R.string.kQobuz_TrackName_Filter_Str));
        this.am = this.g.findViewById(R.id.notice);
        this.f = (AnimationListView) this.g.findViewById(R.id.list_view);
        this.h = this.g.findViewById(R.id.loading);
        this.i = (TextView) this.g.findViewById(R.id.tips);
        this.i.setTextColor(q().getColor(R.color.black));
        this.g.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return this.g;
    }

    @Override // defpackage.amw, defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        this.ai = new aih<>(this.d, new a(), HttpStatus.SC_INTERNAL_SERVER_ERROR, R.layout.qobuz_playlist_detail_item, R.layout.harman_list_loading);
        this.f.setAdapter((ListAdapter) this.ai);
        if (ahn.a()) {
            this.f.setLeftMargin((int) this.d.getResources().getDimension(R.dimen.left_menu_width));
        }
        this.f.setOnItemChosenListener(this.ao);
        this.al.setOnQueryTextListener(this.an);
        if (this.ak == null) {
            this.ak = new ProgressDialog(this.d);
            this.ak.setProgressStyle(0);
            this.ak.setIndeterminate(false);
            this.ak.setCancelable(true);
            this.ak.setMessage(a(R.string.kAndroid_Loading));
            this.ak.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ams.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                }
            });
        }
    }

    public void d() {
        this.e.a("http://www.qobuz.com/api.json/0.2/favorite/getUserFavorites?app_id=394304373&type=tracks&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&user_id=" + aho.d("qobuz_user_info").trim().split("&")[3] + "&limit=" + HttpStatus.SC_INTERNAL_SERVER_ERROR + "&offset=" + this.c, this);
    }

    @Override // defpackage.amw, defpackage.ajj
    public ajv b() {
        return null;
    }

    public ArrayList<QobuzMusicData> a(ArrayList<QobuzMusicData> arrayList, String str) {
        ArrayList<QobuzMusicData> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            QobuzMusicData qobuzMusicData = arrayList.get(i);
            if (!TextUtils.isEmpty(qobuzMusicData.musicName) && qobuzMusicData.musicName.toLowerCase().contains(str.toLowerCase())) {
                arrayList2.add(qobuzMusicData);
            }
        }
        return arrayList2;
    }

    @Override // defpackage.anu
    public void a(JSONObject jSONObject) {
        this.ah.addAll(any.b(jSONObject));
        a((List<QobuzMusicData>) this.ah);
        al();
        if (this.c == 0) {
            this.ai.a(this.ah);
            this.ai.notifyDataSetChanged();
        } else {
            this.ai.b(this.ah);
        }
        this.h.setVisibility(8);
        if (this.ah.size() == 0) {
            this.am.setVisibility(0);
        } else {
            this.am.setVisibility(8);
        }
    }

    public void a(List<QobuzMusicData> list) {
        Collections.sort(list, new Comparator<QobuzMusicData>() { // from class: ams.4
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(QobuzMusicData qobuzMusicData, QobuzMusicData qobuzMusicData2) {
                return qobuzMusicData.musicName.trim().substring(0, 1).compareToIgnoreCase(qobuzMusicData2.musicName.trim().substring(0, 1));
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

    class a implements aih.a<QobuzMusicData>, View.OnClickListener {
        a() {
        }

        @Override // aih.a
        public void a(int i, int i2) {
            ams.this.c = i;
            int i3 = ams.this.c * i2;
            ams.this.e.a("http://www.qobuz.com/api.json/0.2/favorite/getUserFavorites?app_id=394304373&type=tracks&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&user_id=" + aho.d("qobuz_user_info").trim().split("&")[3] + "&limit=" + HttpStatus.SC_INTERNAL_SERVER_ERROR + "&offset=" + i3, ams.this);
        }

        @Override // aih.a
        public View a(int i, View view, ViewGroup viewGroup, QobuzMusicData qobuzMusicData) {
            b bVar = (b) view.getTag();
            if (bVar == null) {
                b bVar2 = new b();
                bVar2.a = (ImageView) view.findViewById(R.id.iv);
                bVar2.b = (TextView) view.findViewById(R.id.song);
                bVar2.c = (TextView) view.findViewById(R.id.album);
                bVar2.d = (ImageView) view.findViewById(R.id.iv_more);
                bVar2.e = (TextView) view.findViewById(R.id.alphabet);
                bVar2.f = (TextView) view.findViewById(R.id.extra_info);
                bVar2.g = (ImageView) view.findViewById(R.id.hq_icon);
                view.setTag(bVar2);
                bVar = bVar2;
            }
            if (qobuzMusicData.d) {
                bVar.e.setText(qobuzMusicData.c);
                bVar.e.setVisibility(0);
            } else {
                bVar.e.setVisibility(8);
            }
            bVar.b.setText(qobuzMusicData.musicName + " - " + ann.b(qobuzMusicData.a * 1000));
            bVar.c.setText(qobuzMusicData.album);
            bVar.f.setText(qobuzMusicData.e.toUpperCase());
            bVar.f.setVisibility(0);
            if (qobuzMusicData.f) {
                bVar.g.setVisibility(0);
            } else {
                bVar.g.setVisibility(8);
            }
            if (qobuzMusicData.a()) {
                bVar.b.setTextColor(Color.parseColor("#000000"));
                bVar.c.setTextColor(Color.parseColor("#666666"));
            } else {
                bVar.b.setTextColor(Color.parseColor("#AAAAAA"));
                bVar.c.setTextColor(Color.parseColor("#AAAAAA"));
            }
            new ahw().a(bVar.a, qobuzMusicData.album_art);
            bVar.d.setTag(qobuzMusicData);
            bVar.d.setOnClickListener(this);
            bVar.c.setVisibility(0);
            bVar.d.setVisibility(0);
            return view;
        }

        class b {
            public ImageView a;
            public TextView b;
            public TextView c;
            public ImageView d;
            public TextView e;
            public TextView f;
            public ImageView g;

            b() {
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final QobuzMusicData qobuzMusicData = (QobuzMusicData) view.getTag();
            arz arzVar = new arz(ams.this.d);
            ArrayList arrayList = new ArrayList();
            arrayList.add(ams.this.d.getString(R.string.PlayTip_PlayNow_Str));
            arrayList.add(ams.this.d.getString(R.string.PlayTip_PlayNext_Str));
            arrayList.add(ams.this.d.getString(R.string.PlayTip_AddSongToQueue_Str));
            arrayList.add(ams.this.d.getString(R.string.PlayTip_ClearAll_Str));
            if (qobuzMusicData.songId != -1000) {
                arrayList.add(ams.this.d.getString(R.string.kQobuz_See_Artist_Str));
                arrayList.add(ams.this.d.getString(R.string.kQobuz_DeleteFavourite_Str));
            }
            arzVar.a(arrayList);
            arzVar.a(ams.this.d.getString(R.string.PlayTip_Title_Str));
            arzVar.a(new asi() { // from class: ams.a.1
                @Override // defpackage.asi
                public void a(int i) {
                    switch (i) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            ang.a(ams.this.d, i, qobuzMusicData, new ArrayList(ams.this.ah), ams.this.ak);
                            break;
                        case 4:
                            a.this.a(qobuzMusicData);
                            break;
                        case 5:
                            a.this.b(qobuzMusicData);
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
                ams.this.d.q().a(ansVar, (arc) null);
            } else {
                ams.this.d.q().a(ansVar, new arc().c(R.id.menu_container));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(MusicData musicData) {
            ams.this.e.a("http://www.qobuz.com/api.json/0.2/favorite/delete?app_id=394304373&user_auth_token=" + aho.d("qobuz_user_auth_token").trim() + "&track_ids=" + musicData.songId, new C0024a(musicData));
            if (!ams.this.ak.isShowing() && !ams.this.d.isFinishing()) {
                ams.this.ak.show();
            }
        }

        /* JADX INFO: renamed from: ams$a$a, reason: collision with other inner class name */
        class C0024a implements anu<JSONObject> {
            public MusicData a;

            public C0024a(MusicData musicData) {
                this.a = musicData;
            }

            @Override // defpackage.anu
            public void a(JSONObject jSONObject) {
                jSONObject.optString("status");
                if (ams.this.ak != null && ams.this.ak.isShowing()) {
                    ams.this.ak.dismiss();
                }
                ams.this.c(this.a);
                ams.this.ah.remove(this.a);
                ams.this.ai.b().remove(this.a);
                ams.this.al();
                ams.this.ai.notifyDataSetChanged();
            }

            @Override // defpackage.anu
            public void b(String str) {
                Toast.makeText(ams.this.d, "Delete failure!", 1).show();
                if (ams.this.ak != null && ams.this.ak.isShowing()) {
                    ams.this.ak.dismiss();
                }
            }

            @Override // defpackage.anu
            public void c() {
                if (ams.this.ak != null && ams.this.ak.isShowing()) {
                    ams.this.ak.dismiss();
                }
            }
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void E() {
        super.E();
        this.d.unregisterReceiver(this.aj);
        if (this.ak != null && this.ak.isShowing()) {
            this.ak.dismiss();
            this.ak = null;
        }
    }

    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (ams.this.ak != null && ams.this.ak.isShowing()) {
                ams.this.ak.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        String str;
        int size = this.ah.size();
        String str2 = "";
        List listAsList = Arrays.asList(this.d.getResources().getStringArray(R.array.alphabet_list));
        int i = 0;
        while (i < size) {
            QobuzMusicData qobuzMusicData = this.ah.get(i);
            String upperCase = qobuzMusicData.musicName.trim().substring(0, 1).toUpperCase();
            if (!listAsList.contains(upperCase)) {
                upperCase = "#";
            }
            if (upperCase.equalsIgnoreCase(str2)) {
                qobuzMusicData.d = false;
                str = str2;
            } else {
                qobuzMusicData.c = upperCase;
                qobuzMusicData.d = true;
                str = upperCase;
            }
            i++;
            str2 = str;
        }
    }
}
