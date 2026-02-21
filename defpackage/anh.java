package defpackage;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.harman.hkconnect.R;
import defpackage.ajv;
import defpackage.anm;
import defpackage.arn;

/* JADX INFO: loaded from: classes.dex */
public class anh extends ako implements anm.a {
    private arn b = null;
    private arn.a c = new arn.a() { // from class: anh.2
        @Override // arn.a
        public void a(View view) {
            anm anmVar = new anm();
            anmVar.a((anm.a) anh.this);
            anh.this.a.q().a(anmVar, new arc().c(R.id.menu_container));
        }

        @Override // arn.a
        public void b(View view) {
            anh.this.a((amw) new anl());
        }

        @Override // arn.a
        public void c(View view) {
            anh.this.a((amw) new ank());
        }

        @Override // arn.a
        public void d(View view) {
            anh.this.a((amw) new anj());
        }

        @Override // arn.a
        public void e(View view) {
            anh.this.a((amw) new anf());
        }

        @Override // arn.a
        public void f(View view) {
            anh.this.a((amw) new amz());
        }
    };

    @Override // anm.a
    public void d() {
    }

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        if (this.b == null) {
            this.b = new arn(this.a);
            this.b.setOnQobuzListner(this.c);
        }
        this.b.a();
    }

    @Override // defpackage.ako
    public View c() {
        return this.b;
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        this.b.a();
        if (this.b.b()) {
            a((amw) new amz());
        }
    }

    @Override // defpackage.ajj
    public ajv b() {
        return new ajv.a().a(new MenuItem.OnMenuItemClickListener() { // from class: anh.1
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                anh.this.c.a(null);
                return true;
            }
        }).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(amw amwVar) {
        this.a.q().c();
        this.a.q().a(s(), amwVar, null, R.id.menu_container, true);
    }
}
