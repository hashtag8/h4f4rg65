package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class azw extends azs implements azb.a {
    protected BaseAdapter a;
    private TextView aE;
    ImageView as;
    aza at;
    private View ax;
    private LayoutInflater ay;
    SharedPreferences b;
    TextView c;
    private azc aw = new azc();
    private ArrayList<azi> az = new ArrayList<>();
    String ar = "";
    private boolean aA = false;
    private boolean aB = false;
    private boolean aC = false;
    private int aD = 0;
    public MenuItem.OnMenuItemClickListener au = new MenuItem.OnMenuItemClickListener() { // from class: azw.2
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            azw.this.ae.l().a(azw.this.b());
            azw.this.ae.onBackPressed();
            return true;
        }
    };
    public ajs av = new ajs() { // from class: azw.3
        @Override // defpackage.ajs
        public void a(String str, ajw ajwVar) {
            azw.this.az = new ArrayList();
            azw.this.aA = false;
            azw.this.aD = 0;
            azw.this.a.notifyDataSetChanged();
            azw.this.ar = str;
            azw.this.c();
        }
    };

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ax = layoutInflater.inflate(R.layout.rdio_search_layout, (ViewGroup) null);
        this.i = (AnimationListView) this.ax.findViewById(R.id.rdio_list);
        this.i.setEmptyView(null);
        this.aE = (TextView) this.ax.findViewById(R.id.rdio_empty_list_view);
        this.aE.setText("");
        this.aE.setTypeface(ahu.a(this.ae));
        if (ahn.a()) {
            this.i.setLeftMargin((int) this.ae.getResources().getDimension(R.dimen.left_menu_width));
        }
        this.a = new a(this.ae);
        this.c = (TextView) this.ax.findViewById(R.id.rdio_search_header_text);
        this.c.setTypeface(ahu.a(this.ae));
        this.as = (ImageView) this.ax.findViewById(R.id.rdio_search_dropdown);
        this.at = aza.ERdioSearchTypeAll;
        this.c.setOnClickListener(d());
        this.as.setOnClickListener(d());
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: azw.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                azw.this.al();
            }
        });
        this.b = p().getApplicationContext().getSharedPreferences("", 0);
        this.i.setAdapter((ListAdapter) this.a);
        this.i.setOnItemChosenListener(this);
        return this.ax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        ahf.a((Activity) this.ae);
    }

    public void c() {
        al();
        if (this.ar.length() != 0) {
            al.a(al.a(this.at, this.ar, this.aD, azc.d), this);
        }
    }

    public View.OnClickListener d() {
        return new View.OnClickListener() { // from class: azw.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                azn aznVar = new azn(azw.this.ae);
                final ArrayList arrayList = new ArrayList();
                arrayList.add(azw.this.q().getString(R.string.RdioAll_Str));
                arrayList.add(azw.this.q().getString(R.string.RdioAlbums_Str));
                arrayList.add(azw.this.q().getString(R.string.RdioArtists_Str));
                arrayList.add(azw.this.q().getString(R.string.RdioPlaylists_Str));
                arrayList.add(azw.this.q().getString(R.string.RdioTracks_Str));
                aznVar.a(arrayList);
                aznVar.a(new asi() { // from class: azw.4.1
                    @Override // defpackage.asi
                    public void a(int i) {
                        switch (i) {
                            case 0:
                                azw.this.at = aza.ERdioSearchTypeAll;
                                break;
                            case 1:
                                azw.this.at = aza.ERdioSearchTypeAlbum;
                                break;
                            case 2:
                                azw.this.at = aza.ERdioSearchTypeArtist;
                                break;
                            case 3:
                                azw.this.at = aza.ERdioSearchTypePlaylist;
                                break;
                            case 4:
                                azw.this.at = aza.ERdioSearchTypeTrack;
                                break;
                        }
                        if (!azw.this.c.getText().equals(arrayList.get(i))) {
                            azw.this.c.setText((CharSequence) arrayList.get(i));
                            azw.this.az = new ArrayList();
                            azw.this.aA = false;
                            azw.this.aD = 0;
                            azw.this.a.notifyDataSetChanged();
                            azw.this.c();
                        }
                    }
                });
                aznVar.show();
                aznVar.a(azw.this.ae.getString(R.string.RdioSearchCategory_Str));
            }
        };
    }

    @Override // defpackage.azs, azb.a
    public void a(boolean z, String str) {
        this.aB = false;
        if (z) {
            JSONObject jSONObjectC = ayw.c(str);
            try {
                if (this.az == null) {
                    this.az = new ArrayList<>();
                }
                int size = this.az.size();
                this.az.addAll(ayw.a(jSONObjectC.getJSONArray("items")));
                this.aC = size == this.az.size();
                this.aD += azc.d;
            } catch (Exception e) {
            }
            this.a.notifyDataSetChanged();
        } else {
            azc azcVar = this.aw;
            azc.a(this.ae, this.ae.getResources().getString(R.string.RdioNoResults_Str));
        }
        a(this.az, this.i, this.aE);
    }

    class a extends BaseAdapter {
        public a(Context context) {
            azw.this.ay = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return azw.this.az.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return azw.this.az.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            boolean z = azw.this.az.get(i) instanceof azg;
            azw.this.at.equals(aza.ERdioSearchTypeAll);
            if (!azw.this.at.equals(aza.ERdioSearchTypeAll) || (azw.this.az.get(i) instanceof azg)) {
            }
            if (!azw.this.at.equals(aza.ERdioSearchTypeAll) || !azw.this.at.equals(aza.ERdioSearchTypeAll) || (azw.this.az.get(i) instanceof azg)) {
            }
            if (azw.this.at.equals(aza.ERdioSearchTypeTrack) || (azw.this.at.equals(aza.ERdioSearchTypeAll) && (azw.this.az.get(i) instanceof azm))) {
                return 1;
            }
            if (!azw.this.at.equals(aza.ERdioSearchTypeAll) || !azw.this.at.equals(aza.ERdioSearchTypeAll) || (azw.this.az.get(i) instanceof azj) || (azw.this.az.get(i) instanceof azf) || (azw.this.az.get(i) instanceof azg)) {
            }
            return 0;
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
                        ((azv) view.getTag()).a((azi) azw.this.az.get(i));
                        r7 = view;
                        break;
                    case 1:
                        ((azy) view.getTag()).a((azm) azw.this.az.get(i));
                        r7 = view;
                        break;
                }
            } else {
                switch (itemViewType) {
                    case 0:
                        ?? azvVar = new azv();
                        ?? Inflate = azw.this.ay.inflate(R.layout.rdio_playlist_cell, (ViewGroup) null);
                        ImageView imageView = (ImageView) Inflate.findViewById(R.id.rdio_playlist_more_options2);
                        ((ImageView) Inflate.findViewById(R.id.rdio_playlist_more_options)).setVisibility(4);
                        imageView.setVisibility(0);
                        azvVar.a(azw.this.ae);
                        azvVar.a(Inflate);
                        Inflate.setTag(azvVar);
                        azvVar.a((azi) azw.this.az.get(i));
                        r7 = Inflate;
                        break;
                    case 1:
                        ?? azyVar = new azy();
                        ?? Inflate2 = azw.this.ay.inflate(R.layout.rdio_track_cell, (ViewGroup) null);
                        ImageView imageView2 = (ImageView) Inflate2.findViewById(R.id.rdio_track_more_options2);
                        ((ImageView) Inflate2.findViewById(R.id.rdio_track_more_options)).setVisibility(8);
                        imageView2.setVisibility(0);
                        azyVar.a(azw.this.ae);
                        azyVar.a(Inflate2);
                        Inflate2.setTag(azyVar);
                        azyVar.a((azm) azw.this.az.get(i));
                        r7 = Inflate2;
                        break;
                }
            }
            if (i == azw.this.az.size() - 1 && !azw.this.aA) {
                a();
            }
            return r7;
        }

        public void a() {
            azw.this.aA = true;
            azw.this.i.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: azw.a.1
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (azw.this.aA && azw.this.i.getLastVisiblePosition() == azw.this.i.getAdapter().getCount() - 1 && azw.this.i.getChildAt(azw.this.i.getChildCount() - 1).getBottom() <= azw.this.i.getHeight() && !azw.this.aB && !azw.this.aC) {
                        azw.this.aB = true;
                        if (!ahh.e(azw.this.ae)) {
                            azc unused = azw.this.aw;
                            azc.a(azw.this.ae, azw.this.ae.getResources().getString(R.string.WifiNotReachableTip_Str));
                        } else {
                            azw.this.c();
                        }
                    }
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                    if (i != 0 && azw.this.aB) {
                        azw.this.aB = false;
                    }
                }
            });
        }
    }

    @Override // defpackage.ajj, defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        if (!z && this.aE != null) {
            this.aE.setText("");
        }
    }

    @Override // defpackage.azs, defpackage.ajj
    public ajv b() {
        return aq().c(true).m(q().getColor(R.color.white)).d(true).k(R.drawable.search_close_button).a(this.av).a(this.au).c();
    }
}
