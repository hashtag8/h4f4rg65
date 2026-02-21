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
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.bbi;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bbu extends bbt implements bbi.a {
    protected BaseAdapter a;
    private View ar;
    private LayoutInflater at;
    SharedPreferences b;
    bbi d;
    String[] e;
    private bbj aq = new bbj();
    private ArrayList<JSONObject> as = new ArrayList<>();
    private bbo au = new bbo();
    JSONArray c = new JSONArray();
    private int av = 0;
    private boolean aw = false;
    private boolean ax = false;
    private boolean ay = false;
    private ArrayList<JSONObject> az = new ArrayList<>();

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ar = layoutInflater.inflate(R.layout.soundcloud_playlist_layout, (ViewGroup) null);
        this.ar.setPadding(0, 0, q().getDimensionPixelOffset(R.dimen.right_panel_marginRight_no_handle), 0);
        this.ah = (AnimationListView) this.ar.findViewById(R.id.sc_playlist_list);
        if (ahn.a()) {
            this.ah.setLeftMargin((int) this.ae.getResources().getDimension(R.dimen.left_menu_width));
        }
        this.a = new a(this.ae);
        this.ah.setAdapter((ListAdapter) this.a);
        this.e = new String[]{"/me/playlists?"};
        this.d = new bbi();
        this.d.a(this);
        this.d.a(this.ae);
        this.aq.t.put("limit", "20");
        this.aq.t.put("offset", "0");
        this.d.a(this.aq.t);
        this.d.execute(this.e);
        this.b = p().getApplicationContext().getSharedPreferences("", 0);
        return this.ar;
    }

    @Override // bbi.a
    public void a(boolean z, String str) {
        if (z) {
            try {
                b(str);
                this.a.notifyDataSetChanged();
            } catch (Exception e) {
            }
            this.aq.s += 20;
        } else {
            this.aq.a(this.ae, this.ae.getResources().getString(R.string.SoundCloudNoResult_Str));
        }
        this.ah.setEmptyView(this.ar.findViewById(R.id.soundcloud_empty_list_view));
        this.ax = false;
    }

    public void b(String str) {
        try {
            if (!this.as.isEmpty()) {
                this.az = this.au.a(str);
                if (this.az.size() == 0) {
                    this.ay = true;
                }
                for (int i = 0; i < this.az.size(); i++) {
                    this.as.add(this.az.get(i));
                }
            } else {
                this.as = this.au.a(str);
            }
            this.av = this.as.size();
            a(new JSONArray((Collection) this.as));
        } catch (Exception e) {
        }
    }

    class a extends BaseAdapter {
        public a(Context context) {
            bbu.this.at = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (bbu.this.as.size() > 0) {
                try {
                    if ((bbu.this.as.get(0) instanceof JSONObject) && ((JSONObject) bbu.this.as.get(0)).has("collection")) {
                        bbu.this.c = ((JSONObject) bbu.this.as.get(0)).getJSONArray("collection");
                    } else {
                        bbu.this.c = new JSONArray((Collection) bbu.this.as);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            bbu.this.av = bbu.this.c.length();
            return bbu.this.av;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            bbv bbvVar;
            View view2;
            if (view == null) {
                View viewInflate = bbu.this.at.inflate(R.layout.soundcloud_playlist_cell, (ViewGroup) null);
                bbv bbvVar2 = new bbv();
                bbvVar2.a(bbu.this.ae);
                bbvVar2.a(viewInflate);
                viewInflate.setTag(bbvVar2);
                bbvVar = bbvVar2;
                view2 = viewInflate;
            } else {
                bbvVar = (bbv) view.getTag();
                view2 = view;
            }
            bbvVar.a(bbu.this.an.get(i));
            if (i == bbu.this.av - 1 && !bbu.this.aw) {
                a();
            }
            return view2;
        }

        public void a() {
            bbu.this.aw = true;
            bbu.this.ah.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: bbu.a.1
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (bbu.this.ah.getLastVisiblePosition() == bbu.this.ah.getAdapter().getCount() - 1 && bbu.this.ah.getChildAt(bbu.this.ah.getChildCount() - 1).getBottom() <= bbu.this.ah.getHeight() && !bbu.this.ax && !bbu.this.ay) {
                        bbu.this.ax = true;
                        if (!ahh.e(bbu.this.ae)) {
                            bbu.this.aq.a(bbu.this.ae, bbu.this.ae.getResources().getString(R.string.WifiNotReachableTip_Str));
                            return;
                        }
                        bbu.this.d = new bbi();
                        bbu.this.d.a(bbu.this.ae);
                        bbu.this.d.a(bbu.this);
                        bbu.this.aq.t.put("offset", bbu.this.aq.s + "");
                        bbu.this.d.a(bbu.this.aq.t);
                        bbu.this.d.execute(bbu.this.e);
                    }
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                    if (i != 0 && bbu.this.ax) {
                        bbu.this.ax = false;
                    }
                }
            });
        }
    }
}
