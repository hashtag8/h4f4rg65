package defpackage;

import android.content.Context;
import android.content.Intent;
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
import defpackage.ajv;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class azu extends azs {
    protected BaseAdapter a;
    private ImageView aD;
    private TextView aG;
    private ArrayList<String> at;
    private String au;
    private String av;
    private String aw;
    private String ax;
    private b ay;
    private View b;
    private LayoutInflater c;
    private int ar = 0;
    private ArrayList<azi> as = new ArrayList<>();
    private boolean az = false;
    private boolean aA = false;
    private boolean aB = false;
    private int aC = 0;
    private boolean aE = false;
    private int aF = -1;
    private String aH = "";

    @Override // defpackage.azs, defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(R.layout.rdio_inner_playlist_layout, (ViewGroup) null);
        this.b.setPadding(0, 0, q().getDimensionPixelOffset(R.dimen.right_panel_marginRight_no_handle), 0);
        this.i = (AnimationListView) this.b.findViewById(R.id.rdio_inner_list);
        this.i.setEmptyView(null);
        this.aG = (TextView) this.b.findViewById(R.id.rdio_empty_list_view);
        this.aG.setText("");
        this.aG.setTypeface(ahu.a(this.ae));
        if (ahn.a()) {
            this.i.setLeftMargin((int) this.ae.getResources().getDimension(R.dimen.left_menu_width));
        }
        this.aD = (ImageView) this.b.findViewById(R.id.rdio_add_all_button);
        Bundle bundleL = l();
        this.ay = b.a(bundleL.getInt("HK_Rdio_ListVC_Type"));
        this.au = bundleL.getString("HK_Rdio_Playlist_Title");
        this.av = bundleL.getString("HK_Rdio_Playlist_User");
        this.aw = bundleL.getString("HK_Rdio_Playlist_Track_Count");
        this.ax = bundleL.getString("HK_Rdio_Playlist_Artwork");
        this.at = bundleL.getStringArrayList("HK_Rdio_Playlist_Keys");
        this.aH = bundleL.getString("HK_Rdio_Source_Key");
        if (this.aH == null) {
            this.aH = "";
        }
        this.a = new a(this.ae);
        this.i.setAdapter((ListAdapter) this.a);
        this.ao = true;
        this.i.setOnItemChosenListener(this);
        return this.b;
    }

    @Override // defpackage.azs, azb.a
    public void a(boolean z, String str) {
        JSONArray jSONArray;
        this.aA = false;
        if (z) {
            JSONObject jSONObjectC = ayw.c(str);
            try {
                if (this.as == null) {
                    this.as = new ArrayList<>();
                }
                JSONArray jSONArray2 = new JSONArray();
                if (jSONObjectC.has("items")) {
                    jSONArray = jSONObjectC.getJSONArray("items");
                } else {
                    for (int i = 0; i < this.at.size(); i++) {
                        if (jSONObjectC.has(this.at.get(i))) {
                            jSONArray2.put(jSONObjectC.get(this.at.get(i)));
                        }
                    }
                    jSONArray = jSONArray2;
                }
                int size = this.as.size();
                this.as.addAll(ayw.a(jSONArray, this.aH));
                this.aB = size == this.as.size();
                this.aC += azc.d;
            } catch (Exception e) {
            }
            if (this.aE) {
                d();
                this.aE = false;
            }
            this.a.notifyDataSetChanged();
        } else {
            azc azcVar = this.am;
            azc.a(this.ae, this.ae.getResources().getString(R.string.RdioNoResults_Str));
        }
        this.aG.setText(this.ae.getResources().getString(R.string.RdioNoResults_Str));
        this.i.setEmptyView(this.aG);
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        c();
    }

    public void c() {
        if (this.aC < this.at.size()) {
            al.a(al.a(this.at, this.aC, azc.d), this);
        } else {
            this.aB = true;
        }
    }

    public void d(int i) {
        this.aB = true;
        if (this.aC < this.at.size()) {
            al.a(al.a(this.at, this.aC, i), this);
            this.aC += i;
        }
    }

    public void d() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.as.size()) {
                break;
            }
            if (this.as.get(i2) instanceof azm) {
                arrayList.add(((azm) this.as.get(i2)).e());
            }
            i = i2 + 1;
        }
        switch (this.aF) {
            case 0:
                MusicPlaylistManager.a().e(arrayList);
                break;
            case 1:
                MusicPlaylistManager.a().c(arrayList);
                break;
            case 2:
                MusicPlaylistManager.a().d(arrayList);
                break;
            case 3:
                MusicPlaylistManager.a().h();
                MusicPlaylistManager.a().b(arrayList);
                break;
        }
        this.aF = -1;
        this.ae.sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
    }

    class a extends BaseAdapter {
        public a(Context context) {
            azu.this.c = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (azu.this.at.size() > 0) {
                return azu.this.as.size() + 1;
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (azu.this.ao && i == 0) {
                return null;
            }
            return azu.this.ao ? azu.this.as.get(i - 1) : azu.this.as.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (azu.this.ao && i == 0) ? 0 : 1;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v24, types: [ays, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v21, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r8v0, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r8v1, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r8v2 */
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            ?? r1;
            int itemViewType = getItemViewType(i);
            int i2 = azu.this.ao ? i - 1 : i;
            if (view != 0) {
                switch (itemViewType) {
                    case 0:
                        ((ays) view.getTag()).a(azu.this.au, azu.this.av, azu.this.aw, azu.this.ax);
                        break;
                    case 1:
                        ((azx) view.getTag()).a((azm) azu.this.as.get(i2), i2, azu.this.ay);
                        break;
                }
            } else {
                switch (itemViewType) {
                    case 0:
                        ?? aysVar = new ays();
                        ?? Inflate = azu.this.c.inflate(R.layout.rdio_add_all_cell, (ViewGroup) null);
                        aysVar.a(azu.this.ae);
                        aysVar.a(Inflate);
                        aysVar.e.setOnClickListener(new View.OnClickListener() { // from class: azu.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                arz arzVar = new arz(azu.this.ae);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(azu.this.ae.getString(R.string.PlayTip_PlayNow_Str));
                                arrayList.add(azu.this.ae.getString(R.string.PlayTip_PlayNext_Str));
                                arrayList.add(azu.this.ae.getString(R.string.PlayTip_AddSongToQueue_Str));
                                arrayList.add(azu.this.ae.getString(R.string.PlayTip_ClearAll_Str));
                                arzVar.a(arrayList);
                                arzVar.a(azu.this.ae.getString(R.string.PlayTip_Title_Str));
                                arzVar.a(new asi() { // from class: azu.a.1.1
                                    @Override // defpackage.asi
                                    public void a(int i3) {
                                        azu.this.aF = i3;
                                        if (!aof.a().l() || ain.j) {
                                            int iIntValue = Integer.valueOf(azu.this.aw.replace("Songs: ", "")).intValue() - azu.this.as.size();
                                            if (iIntValue > 0) {
                                                azu.this.d(iIntValue);
                                                azu.this.aE = true;
                                                return;
                                            } else {
                                                azu.this.d();
                                                return;
                                            }
                                        }
                                        Toast.makeText(azu.this.ae, R.string.MusicServicePlayToMyPhoneTip_Str, 0).show();
                                    }
                                });
                                arzVar.show();
                            }
                        });
                        Inflate.setOnClickListener(new View.OnClickListener() { // from class: azu.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                            }
                        });
                        Inflate.setTag(aysVar);
                        aysVar.a(azu.this.au, azu.this.av, azu.this.aw, azu.this.ax);
                        r1 = Inflate;
                        break;
                    case 1:
                        azx azxVar = new azx();
                        if (azu.this.ay == b.EListTypeAlbums) {
                            View viewInflate = azu.this.c.inflate(R.layout.rdio_simple_track_album_cell, (ViewGroup) null);
                            azxVar.a(azu.this.ae);
                            azxVar.a(viewInflate, true);
                            view2 = viewInflate;
                        } else {
                            View viewInflate2 = azu.this.c.inflate(R.layout.rdio_simple_track_cell, (ViewGroup) null);
                            azxVar.a(azu.this.ae);
                            azxVar.a(viewInflate2, false);
                            view2 = viewInflate2;
                        }
                        view2.setTag(azxVar);
                        azxVar.a((azm) azu.this.as.get(i2), i2, azu.this.ay);
                        r1 = view2;
                        break;
                    default:
                        r1 = view;
                        break;
                }
                view = r1;
            }
            if (i == azu.this.as.size() - 1 && !azu.this.az) {
                a();
            }
            return view;
        }

        public void a() {
            azu.this.az = true;
            azu.this.i.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: azu.a.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (azu.this.az && azu.this.i.getLastVisiblePosition() == azu.this.i.getAdapter().getCount() - 1 && azu.this.i.getChildAt(azu.this.i.getChildCount() - 1).getBottom() <= azu.this.i.getHeight() && !azu.this.aA && !azu.this.aB) {
                        azu.this.aA = true;
                        if (ahh.e(azu.this.ae)) {
                            azu.this.c();
                        } else {
                            azc azcVar = azu.this.am;
                            azc.a(azu.this.ae, azu.this.ae.getResources().getString(R.string.WifiNotReachableTip_Str));
                        }
                    }
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                    if (i != 0 && azu.this.aA) {
                        azu.this.aA = false;
                    }
                }
            });
        }
    }

    public enum b {
        EListTypePlaylists(0),
        EListTypeAlbums(1),
        EListTypeCount(2);

        int d;

        b(int i) {
            this.d = i;
        }

        public int a() {
            return this.d;
        }

        public static b a(int i) {
            for (b bVar : values()) {
                if (bVar.a() == i) {
                    return bVar;
                }
            }
            return EListTypeCount;
        }
    }

    @Override // defpackage.ajj, defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        if (!z && this.aG != null) {
            this.aG.setText("");
        }
    }

    @Override // defpackage.azs, defpackage.ajj
    public ajv b() {
        ajv.a aVarAq = aq();
        aVarAq.a(this.au).c(false).a();
        return aVarAq.c();
    }
}
