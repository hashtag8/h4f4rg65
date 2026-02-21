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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bby extends bbt implements bbi.a {
    protected BaseAdapter a;
    private View aq;
    private LayoutInflater as;
    private String az;
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
        this.c = new String[]{"/stream?"};
        this.b = p().getApplicationContext().getSharedPreferences("", 0);
        this.d = new bbi();
        this.d.a(this.ae);
        this.d.a(this);
        this.e.t.put("limit", "20");
        this.d.a(this.e.t);
        this.d.execute(this.c);
        this.aq = layoutInflater.inflate(R.layout.soundcloud_stream_layout, (ViewGroup) null);
        this.aq.setPadding(0, 0, q().getDimensionPixelOffset(R.dimen.right_panel_marginRight_no_handle), 0);
        this.ah = (AnimationListView) this.aq.findViewById(R.id.sc_stream_listview);
        if (ahn.a()) {
            this.ah.setLeftMargin((int) this.ae.getResources().getDimension(R.dimen.left_menu_width));
        }
        this.a = new a(this.ae);
        this.ah.setAdapter((ListAdapter) this.a);
        this.ah.setOnItemChosenListener(this);
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
        } else {
            this.e.a(this.ae, this.ae.getResources().getString(R.string.SoundCloudNoResult_Str));
        }
        this.ah.setEmptyView(this.aq.findViewById(R.id.soundcloud_empty_list_view));
        this.aw = false;
    }

    public void b(String str) {
        try {
            if (!this.ar.isEmpty()) {
                this.ay = this.at.a(str);
                if (this.ay.get(0).isNull("next_href")) {
                    this.ax = true;
                } else {
                    this.az = this.ay.get(0).getString("next_href");
                }
                for (int i = 0; i < this.ay.get(0).getJSONArray("collection").length(); i++) {
                    this.ar.get(0).getJSONArray("collection").put(this.ay.get(0).getJSONArray("collection").getJSONObject(i));
                }
            } else {
                this.ar = this.at.a(str);
                if (this.ar.get(0).isNull("next_href")) {
                    this.ax = true;
                } else {
                    this.az = this.ar.get(0).getString("next_href");
                }
            }
            this.au = this.ar.get(0).getJSONArray("collection").length();
            a(this.ar.get(0).getJSONArray("collection"));
        } catch (Exception e) {
        }
    }

    class a extends BaseAdapter {
        public a(Context context) {
            bby.this.as = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            JSONArray jSONArray;
            JSONArray jSONArray2 = new JSONArray();
            if (bby.this.ar.size() > 0) {
                try {
                    jSONArray = ((JSONObject) bby.this.ar.get(0)).getJSONArray("collection");
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONArray = jSONArray2;
                }
            } else {
                jSONArray = jSONArray2;
            }
            return jSONArray.length();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return bby.this.am.get(Integer.valueOf(i));
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
                jSONObject = ((JSONObject) bby.this.ar.get(0)).getJSONArray("collection").getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = jSONObject2;
            }
            try {
                if (jSONObject.getString("type").startsWith("track")) {
                    return 0;
                }
                if (jSONObject.getString("type").startsWith("playlist")) {
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
                        ?? Inflate = bby.this.as.inflate(R.layout.soundcloud_track_cell, (ViewGroup) null);
                        bbzVar.a(bby.this.ae);
                        bbzVar.a(Inflate);
                        Inflate.setTag(bbzVar);
                        bbzVar.a(bby.this.an.get(i));
                        bby.this.am.put(Integer.valueOf(i), bbzVar.j.r);
                        r6 = Inflate;
                        break;
                    case 1:
                        ?? bbvVar = new bbv();
                        ?? Inflate2 = bby.this.as.inflate(R.layout.soundcloud_playlist_cell, (ViewGroup) null);
                        bbvVar.a(bby.this.ae);
                        bbvVar.a(Inflate2);
                        Inflate2.setTag(bbvVar);
                        bbvVar.a(bby.this.an.get(i));
                        r6 = Inflate2;
                        break;
                }
            } else {
                switch (itemViewType) {
                    case 0:
                        bbz bbzVar2 = (bbz) view.getTag();
                        bbzVar2.a(bby.this.an.get(i));
                        bby.this.am.put(Integer.valueOf(i), bbzVar2.j.r);
                        r6 = view;
                        break;
                    case 1:
                        ((bbv) view.getTag()).a(bby.this.an.get(i));
                        r6 = view;
                        break;
                }
            }
            if (i == bby.this.au - 1 && !bby.this.av) {
                a();
            }
            return r6;
        }

        public void a() {
            bby.this.av = true;
            bby.this.ah.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: bby.a.1
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (bby.this.ah.getLastVisiblePosition() == bby.this.ah.getAdapter().getCount() - 1 && bby.this.ah.getChildAt(bby.this.ah.getChildCount() - 1).getBottom() <= bby.this.ah.getHeight() && !bby.this.aw && !bby.this.ax) {
                        bby.this.aw = true;
                        if (!ahh.e(bby.this.ae)) {
                            bby.this.e.a(bby.this.ae, bby.this.ae.getResources().getString(R.string.WifiNotReachableTip_Str));
                            return;
                        }
                        bby.this.d = new bbi();
                        bby.this.d.a(bby.this.ae);
                        bby.this.d.a(bby.this);
                        String[] strArr = {bby.this.az};
                        bby.this.e.t.clear();
                        bby.this.d.a(bby.this.e.t);
                        bby.this.d.execute(strArr);
                    }
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                    if (i != 0 && bby.this.aw) {
                        bby.this.aw = false;
                    }
                }
            });
        }
    }
}
