package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.harman.hkconnect.R;
import defpackage.ajv;
import defpackage.arm;

/* JADX INFO: loaded from: classes.dex */
public class amg extends ajj {
    arm a;
    protected MenuItem.OnMenuItemClickListener b = new MenuItem.OnMenuItemClickListener() { // from class: amg.2
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            amg.this.ae.q().a(new aln(), (arc) null);
            return true;
        }
    };

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = new arm(this.ae);
        this.a.setmOnDeezerListner(new arm.a() { // from class: amg.1
            @Override // arm.a
            public void a() {
                amg.this.ae.q().a(new alq(), (arc) null);
            }

            @Override // arm.a
            public void b() {
                amg.this.ae.q().a(new alm(), (arc) null);
            }

            @Override // arm.a
            public void c() {
                alk alkVar = new alk();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("index", 2);
                alkVar.g(bundle2);
                amg.this.ae.q().a(alkVar, (arc) null);
            }

            @Override // arm.a
            public void d() {
                alk alkVar = new alk();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("index", 0);
                alkVar.g(bundle2);
                amg.this.ae.q().a(alkVar, (arc) null);
            }

            @Override // arm.a
            public void e() {
                amg.this.ae.q().a(new ali(), (arc) null);
            }

            @Override // arm.a
            public void f() {
                amg.this.ae.q().a(new alg(), (arc) null);
            }

            @Override // arm.a
            public void g() {
                amg.this.ae.q().a(new alf(), (arc) null);
            }

            @Override // arm.a
            public void h() {
                alk alkVar = new alk();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("index", 1);
                alkVar.g(bundle2);
                amg.this.ae.q().a(alkVar, (arc) null);
            }

            @Override // arm.a
            public void i() {
                alk alkVar = new alk();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("index", 3);
                alkVar.g(bundle2);
                amg.this.ae.q().a(alkVar, (arc) null);
            }
        });
        return this.a;
    }

    @Override // defpackage.ajj
    public ajv b() {
        return new ajv.a().h(R.drawable.deezer_icon_active2x).a(-13487558).c(true).k(R.drawable.search).a(this.b).c();
    }
}
