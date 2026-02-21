package defpackage;

import android.content.Context;
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
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationListView;
import defpackage.azb;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class azq extends azs implements azb.a {
    protected BaseAdapter a;
    private TextView aB;
    private View ar;
    private LayoutInflater as;
    private String au;
    private String av;
    SharedPreferences b;
    private azc c = new azc();
    private ArrayList<azi> at = new ArrayList<>();
    private boolean aw = false;
    private boolean ax = false;
    private boolean ay = false;
    private int az = 0;
    private boolean aA = false;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ar = layoutInflater.inflate(R.layout.rdio_list_music_view, (ViewGroup) null);
        this.i = (AnimationListView) this.ar.findViewById(R.id.rdio_list);
        this.i.setEmptyView(null);
        if (ahn.a()) {
            this.i.setLeftMargin((int) this.ae.getResources().getDimension(R.dimen.left_menu_width));
        }
        this.aB = (TextView) this.ar.findViewById(R.id.rdio_empty_list_view);
        this.aB.setText("");
        this.aB.setTypeface(ahu.a(this.ae));
        this.a = new a(this.ae);
        this.b = p().getApplicationContext().getSharedPreferences("", 0);
        a(l().getString("HK_Rdio_Trending_Type_Prefs"), l().getString("HK_Rdio_Trending_Tag_Prefs"));
        this.i.setAdapter((ListAdapter) this.a);
        this.i.setOnItemChosenListener(this);
        return this.ar;
    }

    @Override // defpackage.azs, azb.a
    public void a(boolean z, String str) {
        this.ax = false;
        if (z) {
            try {
                ArrayList<azi> arrayListA = ayw.a(ayw.c(str).getJSONArray("items"));
                if (this.at == null) {
                    this.at = new ArrayList<>();
                }
                int size = this.at.size();
                this.at.addAll(arrayListA);
                this.ay = size == this.at.size();
                if (!this.aA && arrayListA.size() < azc.d) {
                    this.aA = true;
                    this.az += arrayListA.size();
                } else {
                    this.az += azc.d;
                }
            } catch (Exception e) {
            }
            this.a.notifyDataSetChanged();
        } else {
            azc azcVar = this.c;
            azc.a(this.ae, this.ae.getResources().getString(R.string.RdioNoResults_Str));
        }
        this.aB.setText(this.ae.getResources().getString(R.string.RdioNoResults_Str));
        this.i.setEmptyView(this.aB);
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        this.at = new ArrayList<>();
        this.az = 0;
        if (bundle != null) {
            super.c(bundle);
            this.au = bundle.getString("HK_Rdio_Trending_Type_Prefs");
            this.av = bundle.getString("HK_Rdio_Trending_Tag_Prefs");
            a(this.au, this.av);
        }
    }

    public void a(String str, String str2) {
        this.au = str;
        this.av = str2;
        if (str.equals(azz.b)) {
            if (str2.equals("everyone")) {
                al.a(al.a(ayx.EContentTypeArtist, ayy.EFollowTypeEveryone, this.az, azc.d), this);
                return;
            } else {
                if (str2.equals("follow")) {
                    al.a(al.a(ayx.EContentTypeArtist, ayy.EFollowTypeUser, this.az, azc.d), this);
                    return;
                }
                return;
            }
        }
        if (str.equals(azz.ar)) {
            if (str2.equals("everyone")) {
                al.a(al.a(ayx.EContentTypeTrack, ayy.EFollowTypeEveryone, this.az, azc.d), this);
            } else if (str2.equals("follow")) {
                al.a(al.a(ayx.EContentTypeTrack, ayy.EFollowTypeUser, this.az, azc.d), this);
            }
        }
    }

    class a extends BaseAdapter {
        public a(Context context) {
            azq.this.as = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return azq.this.at.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return azq.this.at.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (!azq.this.au.equals(azz.b) && azq.this.au.equals(azz.ar)) ? 1 : 0;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [azy, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v1, types: [azv, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v1, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r7v2, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r7v3, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARN: Type inference failed for: r7v9 */
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            ?? r7 = view;
            r7 = view;
            if (view != null) {
                switch (itemViewType) {
                    case 0:
                        ((azv) view.getTag()).a((azi) azq.this.at.get(i));
                        r7 = view;
                        break;
                    case 1:
                        ((azy) view.getTag()).a((azm) azq.this.at.get(i));
                        r7 = view;
                        break;
                }
            } else {
                switch (itemViewType) {
                    case 0:
                        ?? azvVar = new azv();
                        ?? Inflate = azq.this.as.inflate(R.layout.rdio_playlist_cell, (ViewGroup) null);
                        ImageView imageView = (ImageView) Inflate.findViewById(R.id.rdio_playlist_more_options2);
                        ((ImageView) Inflate.findViewById(R.id.rdio_playlist_more_options)).setVisibility(4);
                        imageView.setVisibility(0);
                        azvVar.a(azq.this.ae);
                        azvVar.a(Inflate);
                        Inflate.setTag(azvVar);
                        azvVar.a((azi) azq.this.at.get(i));
                        r7 = Inflate;
                        break;
                    case 1:
                        ?? azyVar = new azy();
                        ?? Inflate2 = azq.this.as.inflate(R.layout.rdio_track_cell, (ViewGroup) null);
                        ImageView imageView2 = (ImageView) Inflate2.findViewById(R.id.rdio_track_more_options2);
                        ((ImageView) Inflate2.findViewById(R.id.rdio_track_more_options)).setVisibility(8);
                        imageView2.setVisibility(0);
                        azyVar.a(azq.this.ae);
                        azyVar.a(Inflate2);
                        Inflate2.setTag(azyVar);
                        azyVar.a((azm) azq.this.at.get(i));
                        r7 = Inflate2;
                        break;
                }
            }
            if (i == azq.this.at.size() - 1 && !azq.this.aw) {
                a();
            }
            return r7;
        }

        public void a() {
            azq.this.aw = true;
            azq.this.i.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: azq.a.1
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (azq.this.aw && azq.this.i.getLastVisiblePosition() == azq.this.i.getAdapter().getCount() - 1 && azq.this.i.getChildAt(azq.this.i.getChildCount() - 1).getBottom() <= azq.this.i.getHeight() && !azq.this.ax && !azq.this.ay) {
                        azq.this.ax = true;
                        if (ahh.e(azq.this.ae)) {
                            azq.this.a(azq.this.au, azq.this.av);
                        } else {
                            azc unused = azq.this.c;
                            azc.a(azq.this.ae, azq.this.ae.getResources().getString(R.string.WifiNotReachableTip_Str));
                        }
                    }
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                    if (i != 0 && azq.this.ax) {
                        azq.this.ax = false;
                    }
                }
            });
        }
    }

    @Override // defpackage.ajj, defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        if (!z && this.aB != null) {
            this.aB.setText("");
        }
    }

    @Override // defpackage.azs, defpackage.ajj
    public ajv b() {
        return null;
    }
}
