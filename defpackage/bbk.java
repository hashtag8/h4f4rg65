package defpackage;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class bbk extends bbt implements TabHost.OnTabChangeListener {
    private bbj a = new bbj();
    private View b;
    private TabHost c;
    private int d;
    private be e;

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(R.layout.soundcloud_explore_layout, (ViewGroup) null);
        this.b.setPadding(0, 0, q().getDimensionPixelOffset(R.dimen.right_panel_marginRight_no_handle), 0);
        this.c = (TabHost) this.b.findViewById(android.R.id.tabhost);
        this.d = 1;
        this.e = p().f();
        d();
        return this.b;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        this.c.setOnTabChangedListener(this);
        this.c.setCurrentTab(this.d);
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void f() {
        super.f();
        c();
    }

    public void c() {
        bbm bbmVar = (bbm) this.e.a("genres");
        bbr bbrVar = (bbr) this.e.a("music");
        bbr bbrVar2 = (bbr) this.e.a("audio");
        if (bbmVar != null) {
            try {
                this.e.a().a(this.e.a("genres")).d();
            } catch (Exception e) {
                return;
            }
        }
        if (bbrVar != null) {
            this.e.a().a(this.e.a("music")).d();
        }
        if (bbrVar2 != null) {
            this.e.a().a(this.e.a("audio")).d();
        }
    }

    private void d() {
        this.c.setup();
        this.c.addTab(a("genres", R.string.SoundCloudExploreGenres_Str, R.id.tab_genres));
        this.c.addTab(a("music", R.string.SoundCloudExploreMusic_Str, R.id.tab_music));
        this.c.addTab(a("audio", R.string.SoundCloudExploreAudio_Str, R.id.tab_audio));
    }

    private TabHost.TabSpec a(String str, int i, int i2) {
        View viewInflate = LayoutInflater.from(this.c.getContext()).inflate(R.layout.soundcloud_explore_tabs, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tab_text);
        textView.setTypeface(ahu.a(this.ae));
        textView.setText(i);
        TabHost.TabSpec tabSpecNewTabSpec = this.c.newTabSpec(str);
        tabSpecNewTabSpec.setIndicator(viewInflate);
        tabSpecNewTabSpec.setContent(i2);
        return tabSpecNewTabSpec;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        if ("genres".equals(str)) {
            this.d = 0;
            a(str, R.id.tab_genres);
        } else if ("music".equals(str)) {
            this.d = 1;
            a(str, R.id.tab_music);
        } else if ("audio".equals(str)) {
            this.d = 2;
            a(str, R.id.tab_audio);
        }
    }

    private void a(String str, int i) {
        Fragment bbmVar;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.c.getTabWidget().getChildCount()) {
                break;
            }
            ((TextView) this.c.getTabWidget().getChildAt(i3).findViewById(R.id.tab_text)).setTextColor(-7829368);
            i2 = i3 + 1;
        }
        ((TextView) this.c.getTabWidget().getChildAt(this.d).findViewById(R.id.tab_text)).setTextColor(Color.parseColor("#FC551F"));
        if (!"genres".equals(str)) {
            bbmVar = new bbr();
            Bundle bundle = new Bundle();
            if ("music".equals(str)) {
                this.a.getClass();
                bundle.putString("HK_SoundCloud_Explore_Genre_JSON_String", "Popular Music");
            } else {
                this.a.getClass();
                bundle.putString("HK_SoundCloud_Explore_Genre_JSON_String", "Popular Audio");
            }
            bbmVar.g(bundle);
        } else {
            bbmVar = new bbm();
        }
        if (this.e.a(str) == null) {
            this.e.a().b(i, bbmVar, str).d();
        }
    }
}
