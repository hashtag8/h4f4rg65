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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import defpackage.bbi;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bbr extends bbt implements bbi.a {
    protected BaseAdapter a;
    private View aq;
    private RelativeLayout ar;
    private LayoutInflater au;
    private int aw;
    SharedPreferences b;
    String[] c;
    bbi d;
    private bbj e = new bbj();
    private ArrayList<JSONObject> as = new ArrayList<>();
    private ArrayList<JSONObject> at = new ArrayList<>();
    private bbo av = new bbo();
    private boolean ax = false;
    private boolean ay = false;
    private boolean az = false;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundleL = l();
        this.e.getClass();
        this.c = new String[]{String.format("/explore/%s?", bundleL.getString("HK_SoundCloud_Explore_Genre_JSON_String").replace(" ", "+").replace("&", "%26"))};
        this.aq = layoutInflater.inflate(R.layout.soundcloud_music_list, (ViewGroup) null);
        this.i = (AnimationGridView) this.aq.findViewById(R.id.sc_explore_song_listview);
        this.i.setNumColumns(q().getInteger(R.integer.SoundCloud_grid_columns));
        this.a = new a(this.ae);
        this.ar = (RelativeLayout) this.aq.findViewById(R.id.music_layout_header);
        if (!this.c[0].equals("/explore/Popular+Music?") && !this.c[0].equals("/explore/Popular+Audio?")) {
            this.ar.setVisibility(0);
            this.aq.setPadding(0, 0, q().getDimensionPixelOffset(R.dimen.right_panel_marginRight_no_handle), 0);
            TextView textView = (TextView) this.aq.findViewById(R.id.sc_music_textview);
            textView.setTypeface(ahu.a(this.ae));
            Bundle bundleL2 = l();
            this.e.getClass();
            textView.setText(bundleL2.getString("HK_SoundCloud_Explore_Genre_JSON_String"));
        }
        this.b = p().getApplicationContext().getSharedPreferences("", 0);
        this.d = new bbi();
        this.d.a(this);
        this.d.a(this.ae);
        this.e.t.put("limit", "20");
        this.e.t.put("offset", "0");
        this.d.a(this.e.t);
        this.d.execute(this.c);
        this.i.setAdapter((ListAdapter) this.a);
        this.i.setOnItemChosenListener(this);
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
        this.ay = false;
    }

    public void b(String str) {
        try {
            if (!this.as.isEmpty()) {
                this.at = this.av.a(str);
                if (this.at.get(0).isNull("next_href")) {
                    this.az = true;
                }
                for (int i = 0; i < this.at.get(0).getJSONArray("tracks").length(); i++) {
                    this.as.get(0).getJSONArray("tracks").put(this.at.get(0).getJSONArray("tracks").getJSONObject(i));
                }
            } else {
                this.as = this.av.a(str);
            }
            this.aw = this.as.get(0).getJSONArray("tracks").length();
            a(this.as.get(0).getJSONArray("tracks"));
        } catch (Exception e) {
        }
    }

    class a extends BaseAdapter {
        public a(Context context) {
            bbr.this.au = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return bbr.this.aw;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return bbr.this.am.get(Integer.valueOf(i));
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            bbs bbsVar;
            View view2;
            if (view == null) {
                View viewInflate = bbr.this.au.inflate(R.layout.soundcloud_music_cell, (ViewGroup) null);
                bbs bbsVar2 = new bbs();
                bbsVar2.a(bbr.this.ae);
                bbsVar2.a(viewInflate);
                viewInflate.setTag(bbsVar2);
                bbsVar = bbsVar2;
                view2 = viewInflate;
            } else {
                bbsVar = (bbs) view.getTag();
                view2 = view;
            }
            bbsVar.a(bbr.this.an.get(i));
            if (i == bbr.this.aw - 1 && !bbr.this.ax) {
                a();
            }
            bbr.this.am.put(Integer.valueOf(i), bbsVar.f.r);
            return view2;
        }

        public void a() {
            bbr.this.ax = true;
            bbr.this.i.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: bbr.a.1
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (bbr.this.i.getLastVisiblePosition() == bbr.this.i.getAdapter().getCount() - 1 && bbr.this.i.getChildAt(bbr.this.i.getChildCount() - 1).getBottom() <= bbr.this.i.getHeight() && !bbr.this.ay && !bbr.this.az) {
                        bbr.this.ay = true;
                        if (!ahh.e(bbr.this.ae)) {
                            bbr.this.e.a(bbr.this.ae, bbr.this.ae.getResources().getString(R.string.WifiNotReachableTip_Str));
                            return;
                        }
                        bbr.this.d = new bbi();
                        bbr.this.d.a(bbr.this);
                        bbr.this.d.a(bbr.this.ae);
                        bbr.this.e.t.put("offset", bbr.this.e.s + "");
                        bbr.this.d.a(bbr.this.e.t);
                        bbr.this.d.execute(bbr.this.c);
                    }
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                    if (i != 0 && bbr.this.ay) {
                        bbr.this.ay = false;
                    }
                }
            });
        }
    }
}
