package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.TouchDisableViewPager;
import defpackage.ajv;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class anf extends amw {
    public static String b = "QOBUZ_FAV_ACTION_CHANGE_ALBUM";
    public static String c = "QOBUZ_FAV_ACTION_CHANGE_ARTIST";
    private amr d;
    private amq e;
    private ams f;
    private TouchDisableViewPager h;
    private ArrayList<String> g = new ArrayList<>();
    private BroadcastReceiver i = new BroadcastReceiver() { // from class: anf.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            mm.b("收到改变my lib改变的广播  " + action, new Object[0]);
            if (anf.c.equals(action)) {
                anf.this.d.d();
            } else if (anf.b.equals(action)) {
                anf.this.e.d();
            }
            anf.this.ae.removeStickyBroadcast(intent);
        }
    };

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.ae = (DashboardActivity) p();
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.qobuz_tabbed_viewpager_layout, (ViewGroup) null);
        viewInflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        viewInflate.findViewById(R.id.loading).setVisibility(8);
        a aVar = new a(s());
        this.h = (TouchDisableViewPager) viewInflate.findViewById(R.id.favourites_content);
        this.h.setAdapter(aVar);
        this.h.setOffscreenPageLimit(3);
        this.g.add(a(R.string.kQobuz_Artists_Str));
        this.g.add(a(R.string.kQobuz_Albums_Str));
        this.g.add(a(R.string.kQobuz_Tracks_Str));
        ((TabLayout) viewInflate.findViewById(R.id.tab_header)).setupWithViewPager(this.h);
        return viewInflate;
    }

    @Override // defpackage.amw, defpackage.ajj
    public ajv b() {
        ajv.a aVarA = new ajv.a(super.b()).a(a(R.string.kQobuz_Favourites_Str)).a(-9128246);
        if (ahn.a()) {
            aVarA.i(R.drawable.hamberger_white_icon);
        }
        return aVarA.c();
    }

    @Override // defpackage.ajj
    public void ar() {
        super.ar();
        this.ae.a(this.h);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(c);
        intentFilter.addAction(b);
        this.ae.registerReceiver(this.i, intentFilter);
    }

    @Override // defpackage.ajj
    public void e() {
        super.e();
        this.ae.unregisterReceiver(this.i);
    }

    public class a extends bh {
        public a(be beVar) {
            super(beVar);
        }

        @Override // defpackage.ex
        public int b() {
            return 3;
        }

        @Override // defpackage.bh
        public Fragment a(int i) {
            switch (i) {
                case 0:
                    if (anf.this.d == null) {
                        anf.this.d = new amr();
                    }
                    return anf.this.d;
                case 1:
                    if (anf.this.e == null) {
                        anf.this.e = new amq();
                    }
                    return anf.this.e;
                case 2:
                    if (anf.this.f == null) {
                        anf.this.f = new ams();
                    }
                    return anf.this.f;
                default:
                    return null;
            }
        }

        @Override // defpackage.ex
        public CharSequence c(int i) {
            return (CharSequence) anf.this.g.get(i);
        }
    }
}
