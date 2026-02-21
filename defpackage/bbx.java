package defpackage;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class bbx extends bbt implements TabHost.OnTabChangeListener {
    LinearLayout a;
    private View aq;
    private TabHost ar;
    private int as;
    private be at;
    RelativeLayout b;
    EditText c;
    private bbj e = new bbj();
    String d = "";

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aq = layoutInflater.inflate(R.layout.soundcloud_search_layout, (ViewGroup) null);
        this.aq.setPadding(0, 0, q().getDimensionPixelOffset(R.dimen.right_panel_marginRight_no_handle), 0);
        this.ar = (TabHost) this.aq.findViewById(android.R.id.tabhost);
        this.b = (RelativeLayout) this.aq.findViewById(R.id.searchBtn);
        this.a = (LinearLayout) this.aq.findViewById(R.id.search_layout);
        this.c = (EditText) this.aq.findViewById(R.id.search_edit_text);
        this.c.setTypeface(ahu.a(this.ae));
        this.c.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: bbx.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 3) {
                    return false;
                }
                bbx.this.c();
                return true;
            }
        });
        this.c.addTextChangedListener(new TextWatcher() { // from class: bbx.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    bbx.this.d();
                    bbw bbwVar = new bbw();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("type", bbx.this.as == 0 ? "TRACK" : "PLAYLIST");
                    bbx.this.e.getClass();
                    bundle2.putString("HK_SoundCloud_Search_JSON_String", bbx.this.c.getText().toString());
                    bbx.this.d = bbx.this.c.getText().toString();
                    bbwVar.g(bundle2);
                    bbx.this.at.a().b(bbx.this.as == 0 ? R.id.tab_tracks : R.id.tab_playlists, bbwVar, bbx.this.as == 0 ? "TRACK" : "PLAYLIST").d();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: bbx.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bbx.this.am();
            }
        });
        this.a.setOnClickListener(new View.OnClickListener() { // from class: bbx.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bbx.this.am();
            }
        });
        this.at = p().f();
        al();
        this.b.setOnClickListener(new View.OnClickListener() { // from class: bbx.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bbx.this.c();
            }
        });
        return this.aq;
    }

    public void c() {
        am();
        if (this.c.getText().toString().length() != 0) {
            d();
            bbw bbwVar = new bbw();
            Bundle bundle = new Bundle();
            bundle.putString("type", this.as == 0 ? "TRACK" : "PLAYLIST");
            this.e.getClass();
            bundle.putString("HK_SoundCloud_Search_JSON_String", this.c.getText().toString());
            this.d = this.c.getText().toString();
            bbwVar.g(bundle);
            this.at.a().b(this.as == 0 ? R.id.tab_tracks : R.id.tab_playlists, bbwVar, this.as == 0 ? "TRACK" : "PLAYLIST").d();
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void f() {
        super.f();
        d();
    }

    public void d() {
        bbw bbwVar = (bbw) this.at.a("TRACK");
        bbw bbwVar2 = (bbw) this.at.a("PLAYLIST");
        if (bbwVar != null) {
            try {
                this.at.a().a(this.at.a("TRACK")).d();
            } catch (Exception e) {
                return;
            }
        }
        if (bbwVar2 != null) {
            this.at.a().a(this.at.a("PLAYLIST")).d();
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        this.ar.setOnTabChangedListener(this);
        this.ar.setCurrentTab(this.as);
        a("TRACK", R.id.tab_tracks);
    }

    private void al() {
        this.ar.setup();
        this.ar.addTab(a("TRACK", R.string.SoundCloudSearchTracks_Str, R.id.tab_tracks));
        this.ar.addTab(a("PLAYLIST", R.string.SoundCloudSearchPlaylists_Str, R.id.tab_playlists));
    }

    private TabHost.TabSpec a(String str, int i, int i2) {
        View viewInflate = LayoutInflater.from(this.ar.getContext()).inflate(R.layout.soundcloud_explore_tabs, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tab_text);
        textView.setTypeface(ahu.a(this.ae));
        textView.setText(i);
        TabHost.TabSpec tabSpecNewTabSpec = this.ar.newTabSpec(str);
        tabSpecNewTabSpec.setIndicator(viewInflate);
        tabSpecNewTabSpec.setContent(i2);
        return tabSpecNewTabSpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am() {
        ahf.a((Activity) this.ae);
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        am();
        if ("TRACK".equals(str)) {
            this.as = 0;
            a(str, R.id.tab_tracks);
        } else if ("PLAYLIST".equals(str)) {
            this.as = 1;
            a(str, R.id.tab_playlists);
        }
    }

    private void a(String str, int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.ar.getTabWidget().getChildCount()) {
                break;
            }
            ((TextView) this.ar.getTabWidget().getChildAt(i3).findViewById(R.id.tab_text)).setTextColor(-7829368);
            i2 = i3 + 1;
        }
        ((TextView) this.ar.getTabWidget().getChildAt(this.as).findViewById(R.id.tab_text)).setTextColor(Color.parseColor("#FC551F"));
        if (this.at.a(str) == null) {
            bbw bbwVar = new bbw();
            Bundle bundle = new Bundle();
            bundle.putString("type", str);
            this.e.getClass();
            bundle.putString("HK_SoundCloud_Search_JSON_String", this.d);
            bbwVar.g(bundle);
            this.at.a().b(i, bbwVar, str).d();
        }
    }
}
