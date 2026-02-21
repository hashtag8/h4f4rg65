package defpackage;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.TouchDisableViewPager;
import com.viewpagerindicator.CirclePageIndicator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class amz extends amw {
    private View b;
    private TouchDisableViewPager c;
    private ArrayList<amw> d;
    private CirclePageIndicator e;
    private ajv f;

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // defpackage.amw, defpackage.ajj
    public ajv b() {
        return this.f == null ? super.b() : this.f;
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(R.layout.qobuz_discover_layout, (ViewGroup) null);
        d();
        c();
        return this.b;
    }

    private void c() {
        this.d = new ArrayList<>();
        this.d.add(new ana());
        this.c.setAdapter(new a(s()));
        this.c.a(new ViewPager.f() { // from class: amz.1
            @Override // android.support.v4.view.ViewPager.f
            public void a(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.f
            public void b(int i) {
                amz.this.f = ((amw) amz.this.d.get(i)).b();
                amz.this.ae.l().a(amz.this.f);
            }

            @Override // android.support.v4.view.ViewPager.f
            public void a(int i) {
            }
        });
        this.c.setCurrentItem(0);
        this.c.setOffscreenPageLimit(5);
        this.e.setViewPager(this.c);
        this.d.get(0).a(new anx() { // from class: amz.2
            @Override // defpackage.anx
            public void a(Fragment fragment) {
                amz.this.f = ((amw) amz.this.d.get(0)).b();
                amz.this.ae.l().a(amz.this.f);
                ((amw) fragment).a((anx) null);
            }
        });
    }

    private void d() {
        this.c = (TouchDisableViewPager) this.b.findViewById(R.id.qobuzDiscover_viewPager);
        this.e = (CirclePageIndicator) this.b.findViewById(R.id.circle_page_indicator);
    }

    @Override // defpackage.ajj
    public void ar() {
        super.ar();
        this.ae.a(this.c);
    }

    class a extends bi {
        public a(be beVar) {
            super(beVar);
        }

        @Override // defpackage.bi
        public Fragment a(int i) {
            switch (i) {
                case 1:
                    if (amz.this.d.size() == i) {
                        amz.this.d.add(new anb());
                    }
                    break;
                case 2:
                    if (amz.this.d.size() == i) {
                        amz.this.d.add(new ane());
                    }
                    break;
                case 3:
                    if (amz.this.d.size() == i) {
                        amz.this.d.add(new amx());
                    }
                    break;
                case 4:
                    if (amz.this.d.size() == i) {
                        amz.this.d.add(new and());
                    }
                    break;
                case 5:
                    if (amz.this.d.size() == i) {
                        amz.this.d.add(new anc());
                    }
                    break;
            }
            return (Fragment) amz.this.d.get(i);
        }

        @Override // defpackage.ex
        public int b() {
            return 6;
        }
    }
}
