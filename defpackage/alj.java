package defpackage;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.harman.hkconnect.R;
import defpackage.ajv;
import defpackage.arm;

/* JADX INFO: loaded from: classes.dex */
public class alj extends ako {
    private arm c;
    protected MenuItem.OnMenuItemClickListener b = new MenuItem.OnMenuItemClickListener() { // from class: alj.1
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            alj.this.a.q().a(new aln(), new arc().c(R.id.menu_container));
            return true;
        }
    };
    private arm.a d = new arm.a() { // from class: alj.2
        @Override // arm.a
        public void a() {
            alq alqVar = new alq();
            alj.this.a.q().c();
            alj.this.a.q().a(alj.this.s(), alqVar, null, R.id.menu_container, true);
        }

        @Override // arm.a
        public void b() {
            alm almVar = new alm();
            alj.this.a.q().c();
            alj.this.a.q().a(alj.this.s(), almVar, null, R.id.menu_container, true);
        }

        @Override // arm.a
        public void c() {
            alk alkVar = new alk();
            Bundle bundle = new Bundle();
            bundle.putInt("index", 2);
            alkVar.g(bundle);
            alj.this.a.q().c();
            alj.this.a.q().a(alj.this.s(), alkVar, bundle, R.id.menu_container, true);
        }

        @Override // arm.a
        public void d() {
            alk alkVar = new alk();
            Bundle bundle = new Bundle();
            bundle.putInt("index", 0);
            alkVar.g(bundle);
            alj.this.a.q().c();
            alj.this.a.q().a(alj.this.s(), alkVar, bundle, R.id.menu_container, true);
        }

        @Override // arm.a
        public void e() {
            ali aliVar = new ali();
            alj.this.a.q().c();
            alj.this.a.q().a(alj.this.s(), aliVar, null, R.id.menu_container, true);
        }

        @Override // arm.a
        public void f() {
            alg algVar = new alg();
            alj.this.a.q().c();
            alj.this.a.q().a(alj.this.s(), algVar, null, R.id.menu_container, true);
        }

        @Override // arm.a
        public void g() {
            alf alfVar = new alf();
            alj.this.a.q().c();
            alj.this.a.q().a(alj.this.s(), alfVar, null, R.id.menu_container, true);
        }

        @Override // arm.a
        public void h() {
            alk alkVar = new alk();
            Bundle bundle = new Bundle();
            bundle.putInt("index", 1);
            alkVar.g(bundle);
            alj.this.a.q().c();
            alj.this.a.q().a(alj.this.s(), alkVar, bundle, R.id.menu_container, true);
        }

        @Override // arm.a
        public void i() {
            alk alkVar = new alk();
            Bundle bundle = new Bundle();
            bundle.putInt("index", 3);
            alkVar.g(bundle);
            alj.this.a.q().c();
            alj.this.a.q().a(alj.this.s(), alkVar, bundle, R.id.menu_container, true);
        }
    };

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        if (this.c == null) {
            this.c = new arm(this.a);
            this.c.setmOnDeezerListner(this.d);
        }
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        this.a.q().a(s(), new ali(), null, R.id.menu_container, true);
    }

    @Override // defpackage.ako
    public View c() {
        return this.c;
    }

    @Override // defpackage.ajj
    public ajv b() {
        return new ajv.a().a(this.b).c();
    }
}
