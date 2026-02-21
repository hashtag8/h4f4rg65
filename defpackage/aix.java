package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;
import com.harman.hkconnect.ui.custom.StoredBitmapImageView;
import defpackage.ajv;
import defpackage.aqw;

/* JADX INFO: loaded from: classes.dex */
public abstract class aix extends ajj implements aqw.a {
    private View a;
    private View b;
    protected View c;
    public String d;
    public ajo e;
    protected MenuItem.OnMenuItemClickListener f = new MenuItem.OnMenuItemClickListener() { // from class: aix.1
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (aix.this.ae.q().a() != aix.this.ae.C()) {
                aix.this.ao();
                aix.this.am();
                aix.this.ae.q().a(aix.this.ae.C(), (arc) null);
                return true;
            }
            return true;
        }
    };
    private View g;
    private View h;

    public abstract void b(String str);

    public abstract void c();

    public abstract afq d();

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.h = layoutInflater.inflate(R.layout.dashboard_fragment, (ViewGroup) null);
        this.a = this.h.findViewById(R.id.gridview_layout);
        this.c = this.h.findViewById(R.id.listview_layout);
        this.b = this.h.findViewById(R.id.search_screen);
        this.g = this.h.findViewById(R.id.load_screen);
        this.h.findViewById(R.id.blur_background_tint).setVisibility(8);
        return this.h;
    }

    public void al() {
        if (this.e != null) {
            this.e.a();
        }
    }

    public void c(String str) {
        c();
        afq afqVarD = d();
        if (afqVarD != null) {
            a(afqVarD);
            b(str);
        }
    }

    @Override // aqw.a
    public void a(boolean z) {
        this.ae.b(z);
    }

    protected void d(int i) {
        if (this.h != null) {
            this.b.setVisibility(8);
            if (i == 1) {
                this.a.setVisibility(0);
                this.c.setVisibility(8);
            } else if (i == 2) {
                this.a.setVisibility(8);
                this.c.setVisibility(0);
            }
        }
    }

    public void am() {
        if (this.h != null) {
            this.a.setVisibility(8);
            this.c.setVisibility(8);
            this.b.setVisibility(0);
        }
    }

    public void an() {
        if (this.h != null) {
            this.a.setVisibility(8);
            this.c.setVisibility(8);
            this.b.setVisibility(8);
            this.g.setVisibility(0);
        }
    }

    public void ao() {
        if (this.h != null) {
            this.g.setVisibility(8);
        }
    }

    protected afj ap() {
        return afj.a(2001);
    }

    @Override // android.support.v4.app.Fragment
    public void i() {
        super.i();
        this.ae.ae();
        this.ae.af();
    }

    public class a {
        public StoredBitmapImageView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public ImageView e;
        public TextView f;
        public TextView g;

        public a() {
        }
    }

    @Override // defpackage.ajj, defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
    }

    @Override // defpackage.ajj
    public ajv b() {
        return new ajv.a().d(false).h(R.drawable.logo).a(q().getColor(R.color.black)).c(true).k(R.drawable.search).a(this.f).a().c();
    }

    public void aq() {
        c();
        b("");
        this.ae.l().a(new ajv.a().d(false).h(R.drawable.logo).a(q().getColor(R.color.black)).c(true).k(R.drawable.local_search_icon).a(this.f).c());
    }

    protected void a(final afq afqVar) {
        ap().a(afqVar);
        HarmanApplication.a().registerActivityLifecycleCallbacks(new are(p()) { // from class: aix.2
            @Override // defpackage.are
            public void a() {
                aix.this.ap().a(afqVar, 16777215);
            }
        });
    }
}
