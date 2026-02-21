package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import com.musicservice.rdio.RdioDataTypes.RdioMusicData;
import com.musicservice.rdio.RdioDataTypes.RdioStationMusicData;
import defpackage.ajv;
import defpackage.azb;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class azo extends azs implements azb.a {
    protected BaseAdapter a;
    private TextView aB;
    private SpannableStringBuilder aC;
    private ayz aD;
    private ayz aE;
    private String aF;
    private String aG;
    private String aH;
    private String aI;
    private String aJ;
    private String aK;
    private View ar;
    private LayoutInflater as;
    private SharedPreferences at;
    private int av;
    private b b;
    private azc c = new azc();
    private ArrayList<azi> au = new ArrayList<>();
    private boolean aw = false;
    private boolean ax = false;
    private boolean ay = false;
    private int az = 0;
    private boolean aA = false;

    public static azo d(int i) {
        azo azoVar = new azo();
        azoVar.av = i;
        return azoVar;
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ar = layoutInflater.inflate(R.layout.rdio_grid_music_view, (ViewGroup) null);
        this.h = (AnimationGridView) this.ar.findViewById(R.id.rdio_grid);
        this.h.setAllowDrag(false);
        this.h.setEmptyView(null);
        this.aB = (TextView) this.ar.findViewById(R.id.rdio_empty_list_view);
        this.aB.setText("");
        this.aB.setTypeface(ahu.a(this.ae));
        this.a = new a(this.ae);
        this.at = p().getApplicationContext().getSharedPreferences("", 0);
        int i = l().getInt("HK_Rdio_GridVC_Type");
        this.av = i;
        this.b = b.a(i);
        int iA = ahn.a(this.ae, 10.0f);
        switch (this.b) {
            case EGridTypeTrending:
                this.h.setPadding(iA, iA, iA, 0);
                this.aF = l().getString("HK_Rdio_Trending_Type_Prefs");
                this.aG = l().getString("HK_Rdio_Trending_Tag_Prefs");
                if (this.aF.equals(azz.as)) {
                    this.h.setAllowDrag(true);
                }
                break;
            case EGridTypeBrowse:
                this.h.setPadding(iA + 5, iA, iA + 5, 0);
                this.aB.setPadding(iA, iA, iA, 0);
                this.aJ = l().getString("HK_Rdio_Browse_Url");
                this.aK = l().getString("HK_Rdio_Browse_Name");
                this.h.setAllowDrag(true);
                break;
            case EGridTypeAlbums:
                this.h.setPadding(iA + 5, iA, iA + 5, 0);
                this.aB.setPadding(iA, iA, iA, 0);
                this.aH = l().getString("HK_Rdio_Album_Artist_Key");
                this.aI = l().getString("HK_Rdio_Album_Artist_Name");
                break;
            case EGridTypeReleases:
                this.h.setPadding(iA + 5, iA, iA + 5, 0);
                this.aB.setPadding(iA, iA, iA, 0);
                this.aE = ayz.EHistoryOverview;
                SpannableString spannableString = new SpannableString(this.ae.getResources().getString(R.string.RdioNewReleases_Str));
                spannableString.setSpan(new AbsoluteSizeSpan(ahn.a(this.ae, 18.0f)), 0, spannableString.length(), 18);
                SpannableString spannableString2 = new SpannableString("\n" + this.ae.getResources().getString(R.string.RdioOverview_Str));
                spannableString2.setSpan(new AbsoluteSizeSpan(ahn.a(this.ae, 14.0f)), 0, spannableString2.length(), 18);
                this.aC = new SpannableStringBuilder();
                this.aC.append((CharSequence) spannableString).append((CharSequence) spannableString2);
                break;
            case EGridTypePlaylists:
                this.h.setPadding(iA + 5, iA, iA + 5, 0);
                this.aB.setPadding(iA, iA, iA, 0);
                break;
            case EGridTypeFavourites:
                this.h.setAllowDrag(true);
                this.h.setPadding(iA + 5, iA, iA + 5, 0);
                this.aB.setPadding(iA, iA, iA, 0);
                break;
        }
        d();
        this.h.setAdapter((ListAdapter) this.a);
        this.h.setOnItemChosenListener(this);
        return this.ar;
    }

    public MenuItem.OnMenuItemClickListener c() {
        return new MenuItem.OnMenuItemClickListener() { // from class: azo.1
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                azn aznVar = new azn(azo.this.ae);
                final ArrayList arrayList = new ArrayList();
                arrayList.add(azo.this.q().getString(R.string.RdioOverview_Str));
                arrayList.add(azo.this.q().getString(R.string.RdioThisWeek_Str));
                arrayList.add(azo.this.q().getString(R.string.RdioLastWeek_Str));
                arrayList.add(azo.this.q().getString(R.string.RdioTwoWeeks_Str));
                aznVar.a(arrayList);
                aznVar.a(new asi() { // from class: azo.1.1
                    @Override // defpackage.asi
                    public void a(int i) {
                        azo.this.aD = azo.this.aE;
                        switch (i) {
                            case 0:
                                azo.this.aE = ayz.EHistoryOverview;
                                break;
                            case 1:
                                azo.this.aE = ayz.EHistoryThisWeek;
                                break;
                            case 2:
                                azo.this.aE = ayz.EHistoryLastWeek;
                                break;
                            case 3:
                                azo.this.aE = ayz.EHistoryTwoWeek;
                                break;
                        }
                        if (azo.this.aD != azo.this.aE) {
                            SpannableString spannableString = new SpannableString(azo.this.ae.getResources().getString(R.string.RdioNewReleases_Str));
                            spannableString.setSpan(new AbsoluteSizeSpan(ahn.a(azo.this.ae, 18.0f)), 0, spannableString.length(), 18);
                            SpannableString spannableString2 = new SpannableString("\n" + ((String) arrayList.get(i)));
                            spannableString2.setSpan(new AbsoluteSizeSpan(ahn.a(azo.this.ae, 14.0f)), 0, spannableString2.length(), 18);
                            azo.this.aC = new SpannableStringBuilder();
                            azo.this.aC.append((CharSequence) spannableString).append((CharSequence) spannableString2);
                            azo.this.au = new ArrayList();
                            azo.this.az = 0;
                            azo.this.aw = false;
                            if (azo.this.aB != null) {
                                azo.this.aB.setText("");
                            }
                            azo.this.a.notifyDataSetChanged();
                            azo.this.at();
                            azo.this.d();
                        }
                    }
                });
                aznVar.show();
                aznVar.a(azo.this.ae.getString(R.string.RdioHistory_Str));
                return true;
            }
        };
    }

    @Override // defpackage.azs, azb.a
    public void a(boolean z, String str) {
        JSONArray jSONArray;
        this.ax = false;
        if (z) {
            JSONObject jSONObjectC = ayw.c(str);
            try {
                if (this.au == null) {
                    this.au = new ArrayList<>();
                }
                JSONArray jSONArray2 = new JSONArray();
                switch (this.b) {
                    case EGridTypeTrending:
                        if (this.ai) {
                            jSONArray = jSONObjectC.getJSONObject("tracks").getJSONArray("items");
                        } else {
                            jSONArray = jSONObjectC.getJSONArray("items");
                        }
                        break;
                    case EGridTypeBrowse:
                        if (this.ai) {
                            jSONArray = jSONObjectC.getJSONObject("tracks").getJSONArray("items");
                        } else {
                            JSONArray jSONArray3 = jSONObjectC.getJSONObject("contents").getJSONArray("items");
                            for (int i = 0; i < jSONArray3.length(); i++) {
                                jSONArray2.put(jSONArray3.getJSONObject(i).get("content"));
                            }
                            jSONArray = jSONArray2;
                        }
                        break;
                    case EGridTypeAlbums:
                    case EGridTypeReleases:
                    default:
                        jSONArray = jSONObjectC.getJSONArray("items");
                        break;
                    case EGridTypePlaylists:
                        HashSet hashSet = new HashSet();
                        Iterator<String> itKeys = jSONObjectC.keys();
                        while (itKeys.hasNext()) {
                            JSONArray jSONArray4 = jSONObjectC.getJSONObject(itKeys.next()).getJSONArray("items");
                            for (int i2 = 0; i2 < jSONArray4.length(); i2++) {
                                JSONObject jSONObject = jSONArray4.getJSONObject(i2);
                                String string = jSONObject.getString("key");
                                if (!hashSet.contains(string)) {
                                    hashSet.add(string);
                                    jSONArray2.put(jSONObject);
                                }
                            }
                        }
                        jSONArray = jSONArray2;
                        break;
                    case EGridTypeFavourites:
                        if (this.ai) {
                            jSONArray = jSONObjectC.getJSONObject("tracks").getJSONArray("items");
                        } else {
                            jSONArray = jSONObjectC.getJSONArray("items");
                        }
                        break;
                }
                if (this.ai) {
                    new ArrayList();
                    String string2 = jSONObjectC.getString("key");
                    ArrayList<azi> arrayListA = ayw.a(jSONArray, string2);
                    azd azdVarA = azd.a();
                    azdVarA.b();
                    RdioStationMusicData rdioStationMusicData = new RdioStationMusicData();
                    this.ai = false;
                    for (int i3 = 0; i3 < arrayListA.size(); i3++) {
                        if (arrayListA.get(i3) instanceof azm) {
                            RdioMusicData rdioMusicDataE = ((azm) arrayListA.get(i3)).e();
                            rdioMusicDataE.type = 7;
                            rdioStationMusicData.a(rdioMusicDataE);
                        }
                    }
                    azdVarA.a(rdioStationMusicData);
                    if (!string2.equals("")) {
                        azdVarA.a(string2);
                        azdVarA.e();
                        ap();
                    }
                } else {
                    int size = this.au.size();
                    this.au.addAll(ayw.a(jSONArray));
                    this.ay = size == this.au.size();
                    this.az = this.au.size();
                    if (this.b.equals(b.EGridTypeTrending) && this.au.size() % azc.d != 0 && !this.aA) {
                        this.aA = true;
                        d();
                    }
                }
            } catch (Exception e) {
                mm.e("Cannot get update skip status", e);
            }
            this.a.notifyDataSetChanged();
        } else {
            azc azcVar = this.c;
            azc.a(this.ae, this.ae.getResources().getString(R.string.RdioNoResults_Str));
        }
        this.aB.setText(this.ae.getResources().getString(R.string.RdioNoResults_Str));
        this.h.setEmptyView(this.aB);
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        this.au = new ArrayList<>();
        this.az = 0;
        super.c(bundle);
        o(bundle);
        d();
    }

    public void o(Bundle bundle) {
        this.av = bundle.getInt("HK_Rdio_GridVC_Type");
        this.aF = bundle.getString("HK_Rdio_Trending_Type_Prefs");
        this.aG = bundle.getString("HK_Rdio_Trending_Tag_Prefs");
        this.aJ = bundle.getString("HK_Rdio_Browse_Url");
        this.aK = bundle.getString("HK_Rdio_Browse_Name");
        this.aH = bundle.getString("HK_Rdio_Album_Artist_Key");
        this.aI = bundle.getString("HK_Rdio_Album_Artist_Name");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int size = azc.d - (this.au.size() % azc.d);
        switch (this.b) {
            case EGridTypeTrending:
                al.a(al.a(azz.c(this.aF), azz.d(this.aG), this.az, size), this);
                break;
            case EGridTypeBrowse:
                al.a(al.b(this.aJ), this);
                break;
            case EGridTypeAlbums:
                al.a(al.a(this.aH, this.az, azc.d), this);
                break;
            case EGridTypeReleases:
                al.a(al.a(this.aE, this.az, azc.d), this);
                break;
            case EGridTypePlaylists:
                al.a(al.b(this.az, azc.d), this);
                break;
            case EGridTypeFavourites:
                al.a(al.a(this.az, azc.d), this);
                break;
        }
    }

    class a extends BaseAdapter {
        public a(Context context) {
            azo.this.as = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return azo.this.au.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return azo.this.au.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return ((azo.this.au.get(i) instanceof azm) || (azo.this.au.get(i) instanceof azk)) ? 0 : 1;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v11, types: [azp, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v12, types: [azp, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r5v2, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r5v3, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r5v4 */
        /* JADX WARN: Type inference failed for: r5v5 */
        /* JADX WARN: Type inference failed for: r5v6 */
        /* JADX WARN: Type inference failed for: r5v7 */
        /* JADX WARN: Type inference failed for: r5v8 */
        /* JADX WARN: Type inference failed for: r5v9 */
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            ?? r5 = view;
            r5 = view;
            if (view == null) {
                switch (itemViewType) {
                    case 0:
                        ?? Inflate = azo.this.as.inflate(R.layout.rdio_grid_cell, (ViewGroup) null);
                        ?? azpVar = new azp();
                        azpVar.a(azo.this.ae);
                        azpVar.a(Inflate);
                        Inflate.setTag(azpVar);
                        azpVar.a((azi) azo.this.au.get(i));
                        r5 = Inflate;
                        break;
                    case 1:
                        ?? Inflate2 = azo.this.as.inflate(R.layout.rdio_grid_cell, (ViewGroup) null);
                        ?? azpVar2 = new azp();
                        azpVar2.a(azo.this.ae);
                        azpVar2.a(Inflate2);
                        Inflate2.setTag(azpVar2);
                        azpVar2.a((azi) azo.this.au.get(i));
                        r5 = Inflate2;
                        break;
                }
            } else {
                switch (itemViewType) {
                    case 0:
                        ((azp) view.getTag()).a((azi) azo.this.au.get(i));
                        r5 = view;
                        break;
                    case 1:
                        ((azp) view.getTag()).a((azi) azo.this.au.get(i));
                        r5 = view;
                        break;
                }
            }
            if (azo.this.b != b.EGridTypePlaylists && azo.this.b != b.EGridTypeBrowse && i == azo.this.au.size() - 1 && !azo.this.aw) {
                a();
            }
            return r5;
        }

        public void a() {
            azo.this.aw = true;
            azo.this.h.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: azo.a.1
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    View childAt = azo.this.h.getChildAt(azo.this.h.getChildCount() - 1);
                    if (azo.this.aw && azo.this.h.getLastVisiblePosition() == azo.this.h.getAdapter().getCount() - 1 && childAt != null && childAt.getBottom() <= azo.this.h.getHeight() && !azo.this.ax && !azo.this.ay) {
                        azo.this.ax = true;
                        if (ahh.e(azo.this.ae)) {
                            azo.this.d();
                        } else {
                            azc unused = azo.this.c;
                            azc.a(azo.this.ae, azo.this.ae.getResources().getString(R.string.WifiNotReachableTip_Str));
                        }
                    }
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                    if (i != 0 && azo.this.ax) {
                        azo.this.ax = false;
                    }
                }
            });
        }
    }

    public enum b {
        EGridTypeTrending(0),
        EGridTypeReleases(1),
        EGridTypeFavourites(2),
        EGridTypePlaylists(3),
        EGridTypeBrowse(4),
        EGridTypeAlbums(5),
        EGridTypeCount(6);

        int h;

        b(int i2) {
            this.h = i2;
        }

        public int a() {
            return this.h;
        }

        public static b a(int i2) {
            for (b bVar : values()) {
                if (bVar.a() == i2) {
                    return bVar;
                }
            }
            return EGridTypeCount;
        }
    }

    @Override // defpackage.ajj, defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        if (!z && this.aB != null) {
            this.aB.setText("");
        }
    }

    @Override // defpackage.ajk
    public String av() {
        return getClass().getName() + this.av;
    }

    @Override // defpackage.azs, defpackage.ajj
    public ajv b() {
        ajv.a aVarAq = aq();
        switch (this.b) {
            case EGridTypeTrending:
                return null;
            case EGridTypeBrowse:
                return aVarAq.a(this.aK).b().c();
            case EGridTypeAlbums:
                return aVarAq.a(this.aI).b().c();
            case EGridTypeReleases:
                return aVarAq.k(R.drawable.rdio_icon_dropdown).c(true).a(c()).a().a(this.aC).c();
            case EGridTypePlaylists:
                return aVarAq.a(q().getString(R.string.RdioPlaylists_Str)).b().c();
            case EGridTypeFavourites:
                return aVarAq.a(q().getString(R.string.RdioFavourites_Str)).b().c();
            default:
                return aVarAq.c();
        }
    }
}
