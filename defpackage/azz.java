package defpackage;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import com.harman.hkconnect.R;
import defpackage.azo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class azz extends azs implements TabHost.OnTabChangeListener {
    public static String a;
    public static String ar;
    public static String as;
    static final /* synthetic */ boolean at;
    public static String b;
    public static String c;
    private String aA;
    private SpannableStringBuilder aB;
    private View au;
    private TextView av;
    private TextView aw;
    private TabHost ax;
    private int ay;
    private String az;

    static {
        at = !azz.class.desiredAssertionStatus();
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        a = q().getString(R.string.RdioAlbums_Str);
        b = q().getString(R.string.RdioArtists_Str);
        c = q().getString(R.string.RdioPlaylists_Str);
        ar = q().getString(R.string.RdioTracks_Str);
        as = q().getString(R.string.RdioStations_Str);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.au = layoutInflater.inflate(R.layout.rdio_trending_layout, (ViewGroup) null);
        this.ax = (TabHost) this.au.findViewById(android.R.id.tabhost);
        d();
        this.aA = a;
        SpannableString spannableString = new SpannableString(this.ae.getResources().getString(R.string.RdioTrending_Str));
        spannableString.setSpan(new AbsoluteSizeSpan(ahn.a(this.ae, 18.0f)), 0, spannableString.length(), 18);
        SpannableString spannableString2 = new SpannableString("\n" + this.aA);
        spannableString2.setSpan(new AbsoluteSizeSpan(ahn.a(this.ae, 14.0f)), 0, spannableString2.length(), 18);
        this.aB = new SpannableStringBuilder();
        this.aB.append((CharSequence) spannableString).append((CharSequence) spannableString2);
        return this.au;
    }

    public MenuItem.OnMenuItemClickListener c() {
        return new MenuItem.OnMenuItemClickListener() { // from class: azz.1
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                azn aznVar = new azn(azz.this.ae);
                ArrayList arrayList = new ArrayList();
                arrayList.add(azz.a);
                arrayList.add(azz.b);
                arrayList.add(azz.c);
                arrayList.add(azz.ar);
                arrayList.add(azz.as);
                aznVar.a(arrayList);
                aznVar.a(new asi() { // from class: azz.1.1
                    @Override // defpackage.asi
                    public void a(int i) {
                        switch (i) {
                            case 0:
                                azz.this.aA = azz.a;
                                break;
                            case 1:
                                azz.this.aA = azz.b;
                                break;
                            case 2:
                                azz.this.aA = azz.c;
                                break;
                            case 3:
                                azz.this.aA = azz.ar;
                                break;
                            case 4:
                                azz.this.aA = azz.as;
                                break;
                        }
                        SpannableString spannableString = new SpannableString(azz.this.ae.getResources().getString(R.string.RdioTrending_Str));
                        spannableString.setSpan(new AbsoluteSizeSpan(ahn.a(azz.this.ae, 18.0f)), 0, spannableString.length(), 18);
                        SpannableString spannableString2 = new SpannableString("\n" + azz.this.aA);
                        spannableString2.setSpan(new AbsoluteSizeSpan(ahn.a(azz.this.ae, 14.0f)), 0, spannableString2.length(), 18);
                        azz.this.aB = new SpannableStringBuilder();
                        azz.this.aB.append((CharSequence) spannableString).append((CharSequence) spannableString2);
                        if (!azz.this.ae.l().a().t().equals(azz.this.aB)) {
                            azz.this.at();
                            azz.this.onTabChanged(azz.this.az);
                        }
                    }
                });
                aznVar.show();
                aznVar.a(azz.this.ae.getString(R.string.RdioTrending_Str));
                return true;
            }
        };
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        onTabChanged("everyone");
        this.ax.setOnTabChangedListener(this);
        this.ax.setCurrentTab(this.ay);
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        onTabChanged(this.az);
    }

    private void d() {
        this.ax.setup();
        this.ax.addTab(a("everyone", R.string.RdioEveryone_Str, R.id.tab_everyone));
        this.ax.addTab(a("follow", R.string.RdioFollow_Str, R.id.tab_follow));
    }

    private TabHost.TabSpec a(String str, int i, int i2) {
        View viewInflate = LayoutInflater.from(this.ax.getContext()).inflate(R.layout.rdio_trending_tabs, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.rdio_tab_layout);
        if ("everyone".equals(str)) {
            this.av = (TextView) viewInflate.findViewById(R.id.rdio_tab_text);
            this.av.setTypeface(ahu.a(this.ae));
            this.av.setText(i);
            this.av.setTextColor(Color.parseColor("#FFFFFF"));
            linearLayout.setBackgroundResource(R.drawable.rdio_tab_left);
        } else if ("follow".equals(str)) {
            this.aw = (TextView) viewInflate.findViewById(R.id.rdio_tab_text);
            this.aw.setTypeface(ahu.a(this.ae));
            this.aw.setText(i);
            this.aw.setTextColor(q().getColor(R.color.rdio_theme_colour));
            linearLayout.setBackgroundResource(R.drawable.rdio_tab_right);
        }
        TabHost.TabSpec tabSpecNewTabSpec = this.ax.newTabSpec(str);
        tabSpecNewTabSpec.setIndicator(viewInflate);
        tabSpecNewTabSpec.setContent(i2);
        return tabSpecNewTabSpec;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        if ("everyone".equals(str)) {
            this.ay = 0;
            this.az = "everyone";
            this.av.setTextColor(Color.parseColor("#FFFFFF"));
            this.aw.setTextColor(q().getColor(R.color.rdio_theme_colour));
            al();
            return;
        }
        if ("follow".equals(str)) {
            this.ay = 1;
            this.az = "follow";
            this.aw.setTextColor(Color.parseColor("#FFFFFF"));
            this.av.setTextColor(q().getColor(R.color.rdio_theme_colour));
            al();
        }
    }

    private void al() {
        ajk ajkVarD;
        Bundle bundle = new Bundle();
        bundle.putInt("HK_Rdio_GridVC_Type", azo.b.EGridTypeTrending.a());
        bundle.putString("HK_Rdio_Trending_Type_Prefs", this.aA);
        bundle.putString("HK_Rdio_Trending_Tag_Prefs", this.az);
        if (this.aA.equals(a) || this.aA.equals(c) || this.aA.equals(as)) {
            ajkVarD = azo.d(azo.b.EGridTypeTrending.a());
        } else {
            if (!at && !this.aA.equals(ar) && !this.aA.equals(b)) {
                throw new AssertionError();
            }
            ajkVarD = new azq();
        }
        this.ae.q().a(s(), ajkVarD, bundle, R.id.tab_content);
    }

    public static ayx c(String str) {
        if (str.equals(a)) {
            return ayx.EContentTypeAlbum;
        }
        if (str.equals(b)) {
            return ayx.EContentTypeArtist;
        }
        if (str.equals(c)) {
            return ayx.EContentTypePlaylist;
        }
        if (str.equals(ar)) {
            return ayx.EContentTypeTrack;
        }
        if (str.equals(as)) {
            return ayx.EContentTypeStation;
        }
        return ayx.EContentTypeERROR;
    }

    public static ayy d(String str) {
        if (str.equals("everyone")) {
            return ayy.EFollowTypeEveryone;
        }
        if (str.equals("follow")) {
            return ayy.EFollowTypeUser;
        }
        return ayy.EFollowTypeERROR;
    }

    @Override // defpackage.azs, defpackage.ajj
    public ajv b() {
        return aq().a(this.aB).k(R.drawable.rdio_icon_dropdown).c(true).a(c()).a().c();
    }
}
