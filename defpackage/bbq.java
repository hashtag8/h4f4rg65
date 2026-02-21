package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.bbi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bbq extends bbt implements bbi.a {
    protected BaseAdapter a;
    private View ar;
    private TextView as;
    private TextView at;
    private ImageView au;
    private LayoutInflater aw;
    SharedPreferences b;
    String[] d;
    bbi e;
    private bbj aq = new bbj();
    private ArrayList<JSONObject> av = new ArrayList<>();
    private bbo ax = new bbo();
    JSONArray c = new JSONArray();
    private String ay = null;
    private int az = 0;
    private boolean aA = false;
    private boolean aB = false;
    private boolean aC = false;
    private ArrayList<JSONObject> aD = new ArrayList<>();
    private boolean aE = false;
    private boolean aF = false;
    private int aG = -1;

    @Override // defpackage.bbt, defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        this.ar = layoutInflater.inflate(R.layout.soundcloud_tracks_in_playlist_layout, (ViewGroup) null);
        this.ar.setPadding(0, 0, q().getDimensionPixelOffset(R.dimen.right_panel_marginRight_no_handle), 0);
        this.ah = (AnimationListView) this.ar.findViewById(R.id.sc_likes_list);
        if (ahn.a()) {
            this.ah.setLeftMargin((int) this.ae.getResources().getDimension(R.dimen.left_menu_width));
        }
        this.as = (TextView) this.ar.findViewById(R.id.sc_add_all_text);
        this.as.setTypeface(ahu.a(this.ae));
        this.at = (TextView) this.ar.findViewById(R.id.sc_like_tracks_textview);
        this.at.setTypeface(ahu.a(this.ae));
        this.au = (ImageView) this.ar.findViewById(R.id.sc_tracks_in_playlist_icon);
        this.a = new a(this.ae);
        this.ah.setAdapter((ListAdapter) this.a);
        this.ah.setOnItemChosenListener(this);
        try {
            if (l() != null) {
                this.au.setVisibility(8);
                Bundle bundleL = l();
                this.aq.getClass();
                this.at.setText(bundleL.getString("HK_SoundCloud_Likes_Title_JSON_String"));
                Bundle bundleL2 = l();
                this.aq.getClass();
                string = bundleL2.getString("HK_SoundCloud_Likes_JSON_String");
                Bundle bundleL3 = l();
                this.aq.getClass();
                this.ay = bundleL3.getString("HK_SoundCloud_Playlist_Count");
            } else {
                this.au.setVisibility(0);
                this.at.setText(q().getString(R.string.SoundCloudLikes_Str));
                string = null;
            }
        } catch (Exception e) {
            string = null;
        }
        this.ap = true;
        if (string != null) {
            if (string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.d = new String[]{string};
                this.e = new bbi();
                this.e.a(this);
                this.e.a(this.ae);
                this.aq.t.put("limit", "20");
                this.aq.t.put("offset", "0");
                this.e.a(this.aq.t);
                this.e.execute(this.d);
            } else {
                this.aF = true;
                this.av = this.ax.a(string);
                this.az = this.av.size();
                a(new JSONArray((Collection) this.av));
                this.a.notifyDataSetChanged();
            }
        } else {
            this.d = new String[]{"/me/favorites?"};
            this.ap = false;
            this.e = new bbi();
            this.e.a(this.ae);
            this.e.a(this);
            this.aq.t.put("limit", "20");
            this.aq.t.put("offset", "0");
            this.e.a(this.aq.t);
            this.e.execute(this.d);
        }
        this.b = p().getApplicationContext().getSharedPreferences("", 0);
        return this.ar;
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
    }

    public void b(String str) {
        try {
            if (!this.av.isEmpty()) {
                this.aD = this.ax.a(str);
                if (this.aD.size() == 0) {
                    this.aC = true;
                }
                for (int i = 0; i < this.aD.size(); i++) {
                    this.av.add(this.aD.get(i));
                }
            } else {
                this.av = this.ax.a(str);
            }
            this.az = this.av.size();
            a(new JSONArray((Collection) this.av));
            if (this.aE) {
                this.aC = true;
                c();
            }
        } catch (Exception e) {
            throw new RuntimeException("Cannot play song", e);
        }
    }

    public void c() {
        this.aC = true;
        switch (this.aG) {
            case 0:
                MusicPlaylistManager.a().e(this.ao);
                break;
            case 1:
                MusicPlaylistManager.a().c(this.ao);
                break;
            case 2:
                MusicPlaylistManager.a().d(this.ao);
                break;
            case 3:
                MusicPlaylistManager.a().g();
                MusicPlaylistManager.a().b(this.ao);
                break;
        }
        this.aG = -1;
        this.ae.sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
    }

    @Override // bbi.a
    public void a(boolean z, String str) {
        if (z) {
            try {
                b(str);
                this.a.notifyDataSetChanged();
                new Timer().schedule(new TimerTask() { // from class: bbq.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        bbq.this.ae.runOnUiThread(new Runnable() { // from class: bbq.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                bbq.this.at.setSelected(true);
                            }
                        });
                    }
                }, 1000L);
            } catch (Exception e) {
            }
            this.a.notifyDataSetChanged();
            this.aq.s += 20;
        } else {
            this.aq.a(this.ae, this.ae.getResources().getString(R.string.SoundCloudNoResult_Str));
        }
        this.ah.setEmptyView(this.ar.findViewById(R.id.soundcloud_empty_list_view));
        this.aB = false;
    }

    class a extends BaseAdapter {
        public a(Context context) {
            bbq.this.aw = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (bbq.this.av.size() > 0) {
                try {
                    if (((JSONObject) bbq.this.av.get(0)).has("collection")) {
                        bbq.this.c = ((JSONObject) bbq.this.av.get(0)).getJSONArray("collection");
                    } else {
                        bbq.this.c = new JSONArray((Collection) bbq.this.av);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            bbq.this.az = bbq.this.c.length();
            if (bbq.this.az < 1) {
                return 0;
            }
            return bbq.this.ap ? bbq.this.az + 1 : bbq.this.az;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (bbq.this.ap && i == 0) {
                return null;
            }
            return bbq.this.am.get(Integer.valueOf(i));
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (bbq.this.ap && i == 0) ? 0 : 1;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            new JSONObject();
            int itemViewType = getItemViewType(i);
            int i2 = bbq.this.ap ? i - 1 : i;
            if (view != null) {
                switch (itemViewType) {
                    case 0:
                        ((bbh) view.getTag()).a(bbq.this.ay);
                        break;
                    case 1:
                        bbz bbzVar = (bbz) view.getTag();
                        bbzVar.a(bbq.this.an.get(i2));
                        bbq.this.am.put(Integer.valueOf(i), bbzVar.j.r);
                        bbq.this.aj = bbzVar.e;
                        break;
                }
            } else {
                switch (itemViewType) {
                    case 0:
                        bbh bbhVar = new bbh();
                        view = bbq.this.aw.inflate(R.layout.soundcloud_add_all_cell, (ViewGroup) null);
                        bbhVar.a(bbq.this.ae);
                        bbhVar.a(view);
                        bbhVar.a(bbq.this.ay);
                        bbhVar.b.setOnClickListener(new View.OnClickListener() { // from class: bbq.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                arz arzVar = new arz(bbq.this.ae);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(bbq.this.ae.getString(R.string.PlayTip_PlayNow_Str));
                                arrayList.add(bbq.this.ae.getString(R.string.PlayTip_PlayNext_Str));
                                arrayList.add(bbq.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str));
                                arrayList.add(bbq.this.ae.getString(R.string.PlayTip_ClearAll_Str));
                                arzVar.a(arrayList);
                                arzVar.a(bbq.this.ae.getString(R.string.PlayTip_Title_Str));
                                arzVar.a(new asi() { // from class: bbq.a.1.1
                                    @Override // defpackage.asi
                                    public void a(int i3) {
                                        bbq.this.aG = i3;
                                        if (!aof.a().l() || ain.j) {
                                            bbq.this.aB = true;
                                            if (!ahh.e(bbq.this.ae)) {
                                                bbq.this.aq.a(bbq.this.ae, bbq.this.ae.getResources().getString(R.string.WifiNotReachableTip_Str));
                                                bbq.this.aB = false;
                                                return;
                                            }
                                            bbq.this.e = new bbi();
                                            bbq.this.e.a(bbq.this.ae);
                                            bbq.this.e.a(bbq.this);
                                            int i4 = bbq.this.aq.s;
                                            int i5 = Integer.parseInt(bbq.this.ay) - i4;
                                            if (i5 > 0 && !bbq.this.aF && !bbq.this.aC) {
                                                bbq.this.aE = true;
                                                bbq.this.aq.t.put("limit", i5 + "");
                                                bbq.this.aq.t.put("offset", i4 + "");
                                                bbq.this.e.a(bbq.this.aq.t);
                                                bbq.this.e.execute(bbq.this.d);
                                                return;
                                            }
                                            bbq.this.c();
                                            return;
                                        }
                                        Toast.makeText(bbq.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                                    }
                                });
                                arzVar.show();
                            }
                        });
                        view.setTag(bbhVar);
                        break;
                    case 1:
                        bbz bbzVar2 = new bbz();
                        view = bbq.this.aw.inflate(R.layout.soundcloud_track_cell, (ViewGroup) null);
                        bbzVar2.a(bbq.this.ae);
                        bbzVar2.a(view);
                        view.setTag(bbzVar2);
                        bbzVar2.a(bbq.this.an.get(i2));
                        bbq.this.am.put(Integer.valueOf(i), bbzVar2.j.r);
                        bbq.this.aj = bbzVar2.e;
                        break;
                }
            }
            if (bbq.this.d != null) {
                if (!bbq.this.ap && i == bbq.this.az - 1 && !bbq.this.aA) {
                    a();
                } else if (bbq.this.ap && i == bbq.this.az && !bbq.this.aA) {
                    a();
                }
            }
            return view;
        }

        public void a() {
            bbq.this.aA = true;
            bbq.this.ah.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: bbq.a.2
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (bbq.this.ah.getLastVisiblePosition() == bbq.this.ah.getAdapter().getCount() - 1 && bbq.this.ah.getChildAt(bbq.this.ah.getChildCount() - 1).getBottom() <= bbq.this.ah.getHeight() && !bbq.this.aB && !bbq.this.aC) {
                        bbq.this.aB = true;
                        if (!ahh.e(bbq.this.ae)) {
                            bbq.this.aq.a(bbq.this.ae, bbq.this.ae.getResources().getString(R.string.WifiNotReachableTip_Str));
                            return;
                        }
                        bbq.this.e = new bbi();
                        bbq.this.e.a(bbq.this.ae);
                        bbq.this.e.a(bbq.this);
                        bbq.this.aq.t.put("offset", bbq.this.aq.s + "");
                        bbq.this.e.a(bbq.this.aq.t);
                        bbq.this.e.execute(bbq.this.d);
                    }
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                    if (i != 0 && bbq.this.aB) {
                        bbq.this.aB = false;
                    }
                }
            });
        }
    }
}
