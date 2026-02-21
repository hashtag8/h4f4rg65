package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import defpackage.bbi;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bbw extends bbt implements bbi.a {
    protected BaseAdapter a;
    private View aq;
    private LayoutInflater as;
    SharedPreferences b;
    String[] c;
    bbi d;
    private bbj e = new bbj();
    private ArrayList<JSONObject> ar = new ArrayList<>();
    private bbo at = new bbo();
    private int au = 0;
    private boolean av = false;
    private boolean aw = false;
    private boolean ax = false;
    private ArrayList<JSONObject> ay = new ArrayList<>();

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aq = layoutInflater.inflate(R.layout.soundcloud_music_list, (ViewGroup) null);
        this.i = (AnimationGridView) this.aq.findViewById(R.id.sc_explore_song_listview);
        this.i.setNumColumns(1);
        this.i.setPadding(0, 0, 0, 0);
        this.a = new a(this.ae);
        this.i.setAdapter((ListAdapter) this.a);
        Bundle bundleL = l();
        this.e.getClass();
        if (bundleL.getString("HK_SoundCloud_Search_JSON_String").length() == 0) {
            this.ar.clear();
            if (this.a != null) {
                this.a.notifyDataSetChanged();
            }
        } else {
            Bundle bundleL2 = l();
            this.e.getClass();
            String strReplace = bundleL2.getString("HK_SoundCloud_Search_JSON_String").replace(" ", "+").replace("%", "").replace("&", "%26");
            if (!strReplace.equals("")) {
                String[] strArr = new String[1];
                strArr[0] = String.format(l().getString("type").equals("TRACK") ? "/search/tracks?q=%s&" : "/search/playlists?q=%s&", strReplace);
                this.c = strArr;
                this.b = p().getApplicationContext().getSharedPreferences("", 0);
                this.d = new bbi();
                this.d.a(this.ae);
                this.d.a(this);
                this.e.t.put("limit", "20");
                this.e.t.put("offset", "0");
                this.d.a(this.e.t);
                this.d.execute(this.c);
                this.i.setOnItemChosenListener(this);
            }
        }
        return this.aq;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void f() {
        super.f();
    }

    @Override // bbi.a
    public void a(boolean z, String str) {
        if (z) {
            try {
                b(str);
                this.a.notifyDataSetChanged();
            } catch (Exception e) {
            }
            this.e.s += 20;
        } else {
            this.e.a(this.ae, this.ae.getResources().getString(R.string.SoundCloudNoResult_Str));
        }
        this.i.setEmptyView(this.aq.findViewById(R.id.soundcloud_empty_list_view));
        this.aw = false;
    }

    public void b(String str) {
        try {
            if (!this.ar.isEmpty()) {
                this.ay = this.at.a(str);
                if (this.ay.get(0).isNull("next_href")) {
                    this.ax = true;
                }
                for (int i = 0; i < this.ay.get(0).getJSONArray("collection").length(); i++) {
                    this.ar.get(0).getJSONArray("collection").put(this.ay.get(0).getJSONArray("collection").getJSONObject(i));
                }
            } else {
                this.ar = this.at.a(str);
            }
            this.au = this.ar.get(0).getJSONArray("collection").length();
            a(this.ar.get(0).getJSONArray("collection"));
        } catch (Exception e) {
        }
    }

    class a extends BaseAdapter {
        public a(Context context) {
            bbw.this.as = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return bbw.this.au;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return bbw.this.am.get(Integer.valueOf(i));
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            JSONObject jSONObject;
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject = ((JSONObject) bbw.this.ar.get(0)).getJSONArray("collection").getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = jSONObject2;
            }
            try {
                if (jSONObject.getString("kind").startsWith("track")) {
                    return 0;
                }
                if (jSONObject.getString("kind").startsWith("playlist")) {
                    return 1;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return 0;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v10, types: [bbv, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v11, types: [bbz, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v1, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r6v2, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r6v3, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r6v4 */
        /* JADX WARN: Type inference failed for: r6v5 */
        /* JADX WARN: Type inference failed for: r6v6 */
        /* JADX WARN: Type inference failed for: r6v7 */
        /* JADX WARN: Type inference failed for: r6v8 */
        /* JADX WARN: Type inference failed for: r6v9 */
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            ?? r6 = view;
            r6 = view;
            if (view == null) {
                switch (itemViewType) {
                    case 0:
                        ?? bbzVar = new bbz();
                        ?? Inflate = bbw.this.as.inflate(R.layout.soundcloud_track_cell, (ViewGroup) null);
                        bbzVar.a(bbw.this.ae);
                        bbzVar.a(Inflate);
                        Inflate.setTag(bbzVar);
                        bbzVar.a(bbw.this.an.get(i));
                        bbw.this.am.put(Integer.valueOf(i), bbzVar.j.r);
                        r6 = Inflate;
                        break;
                    case 1:
                        ?? bbvVar = new bbv();
                        ?? Inflate2 = bbw.this.as.inflate(R.layout.soundcloud_playlist_cell, (ViewGroup) null);
                        bbvVar.a(bbw.this.ae);
                        bbvVar.a(Inflate2);
                        Inflate2.setTag(bbvVar);
                        bbvVar.a(bbw.this.an.get(i));
                        r6 = Inflate2;
                        break;
                }
            } else {
                switch (itemViewType) {
                    case 0:
                        bbz bbzVar2 = (bbz) view.getTag();
                        bbzVar2.a(bbw.this.an.get(i));
                        bbw.this.am.put(Integer.valueOf(i), bbzVar2.j.r);
                        r6 = view;
                        break;
                    case 1:
                        ((bbv) view.getTag()).a(bbw.this.an.get(i));
                        r6 = view;
                        break;
                }
            }
            if (i == bbw.this.au - 1 && !bbw.this.av) {
                a();
            }
            return r6;
        }

        public void a() {
            bbw.this.av = true;
            bbw.this.i.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: bbw.a.1
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (bbw.this.i.getLastVisiblePosition() == bbw.this.i.getAdapter().getCount() - 1 && bbw.this.i.getChildAt(bbw.this.i.getChildCount() - 1).getBottom() <= bbw.this.i.getHeight() && !bbw.this.aw && !bbw.this.ax) {
                        bbw.this.aw = true;
                        if (!ahh.e(bbw.this.ae)) {
                            bbw.this.e.a(bbw.this.ae, bbw.this.ae.getResources().getString(R.string.WifiNotReachableTip_Str));
                            return;
                        }
                        bbw.this.d = new bbi();
                        bbw.this.d.a(bbw.this.ae);
                        bbw.this.d.a(bbw.this);
                        bbw.this.e.t.put("offset", bbw.this.e.s + "");
                        bbw.this.d.a(bbw.this.e.t);
                        bbw.this.d.execute(bbw.this.c);
                    }
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                    if (i != 0 && bbw.this.aw) {
                        bbw.this.aw = false;
                    }
                }
            });
        }
    }
}
