package defpackage;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.TouchDisableViewPager;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class aqh extends aix {
    private static int an = 5;
    View a;
    private ajg ah;
    private ajc ai;
    private aja aj;
    private ArrayList<aix> ak;
    private ArrayList<String> al;
    private TabLayout am;
    TouchDisableViewPager b;
    a g;
    private aiv h;
    private ait i;

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.ak = new ArrayList<>();
        this.al = new ArrayList<>();
        this.h = new aiv();
        this.i = new ait();
        this.ah = new ajg();
        this.ai = new ajc();
        this.aj = new aja();
        this.ak.add(this.h);
        this.ak.add(this.i);
        this.ak.add(this.ah);
        this.ak.add(this.ai);
        this.ak.add(this.aj);
        this.g = new a(s());
        this.al.add(q().getString(R.string.LibNav_Artist_Str).toUpperCase());
        this.al.add(q().getString(R.string.LibNav_Album_Str).toUpperCase());
        this.al.add(q().getString(R.string.LibNav_Song_Str).toUpperCase());
        this.al.add(q().getString(R.string.LibNav_Playlist_Str).toUpperCase());
        this.al.add(q().getString(R.string.LibNav_Genre_Str).toUpperCase());
    }

    @Override // defpackage.aix, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.dashboard_main_content_fragment, (ViewGroup) null);
        az();
        return this.a;
    }

    private void az() {
        this.b = (TouchDisableViewPager) this.a.findViewById(R.id.dashboard_content_view_pager);
        this.b.setOffscreenPageLimit(an);
        this.b.setAdapter(this.g);
        this.b.a(new ViewPager.f() { // from class: aqh.1
            @Override // android.support.v4.view.ViewPager.f
            public void a(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.f
            public void b(int i) {
                ((aix) aqh.this.ak.get(i)).b(aqh.this.ae.l().d());
            }

            @Override // android.support.v4.view.ViewPager.f
            public void a(int i) {
                if (i != 0) {
                    aqh.this.ax().al();
                }
            }
        });
        this.am = (TabLayout) this.a.findViewById(R.id.tab_header);
        this.am.setupWithViewPager(this.b);
    }

    public aix ax() {
        if (this.g == null) {
            this.g = new a(s());
            az();
        }
        return (aix) this.g.a(this.b.getCurrentItem());
    }

    @Override // defpackage.aix, defpackage.ajj, defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        if (z) {
            this.ah.d = null;
        } else {
            this.ae.a(this.b);
        }
    }

    @Override // defpackage.aix
    public void aq() {
        Iterator<aix> it = this.ak.iterator();
        while (it.hasNext()) {
            it.next().d = null;
        }
        super.aq();
    }

    @Override // defpackage.aix
    public void b(String str) {
        ax().b(str);
    }

    @Override // defpackage.aix
    public void c() {
        ax().c();
    }

    @Override // defpackage.aix
    public afq d() {
        return ax().d();
    }

    public class a extends bh {
        public a(be beVar) {
            super(beVar);
        }

        @Override // defpackage.ex
        public int b() {
            return aqh.an;
        }

        @Override // defpackage.bh
        public Fragment a(int i) {
            switch (i) {
                case 0:
                    return aqh.this.h;
                case 1:
                    return aqh.this.i;
                case 2:
                    return aqh.this.ah;
                case 3:
                    return aqh.this.ai;
                case 4:
                    return aqh.this.aj;
                default:
                    return null;
            }
        }

        @Override // defpackage.ex
        public CharSequence c(int i) {
            return (CharSequence) aqh.this.al.get(i);
        }
    }
}
