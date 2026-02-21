package defpackage;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.musicservice.tidal.model.TidalMusicDataLocal;
import com.musicservice.tidal.model.TidalRadio;
import defpackage.ajv;
import defpackage.arw;
import defpackage.bcx;

/* JADX INFO: loaded from: classes.dex */
public class bcu extends ako {
    private arw d;
    private bcx c = null;
    private boolean e = false;
    protected MenuItem.OnMenuItemClickListener b = new MenuItem.OnMenuItemClickListener() { // from class: bcu.1
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            bcu.this.a.q().a(new bea(), new arc().c(R.id.menu_container));
            return true;
        }
    };
    private bcx.a f = new bcx.a() { // from class: bcu.2
        @Override // bcx.a
        public void a() {
            bed bedVar = new bed();
            bcu.this.a.q().c();
            bcu.this.a.q().a(bcu.this.s(), bedVar, null, R.id.menu_container, true);
        }

        @Override // bcx.a
        public void b() {
            bdx bdxVar = new bdx();
            bcu.this.a.q().c();
            bcu.this.a.q().a(bcu.this.s(), bdxVar, null, R.id.menu_container, true);
        }

        @Override // bcx.a
        public void c() {
            bdy bdyVar = new bdy();
            bcu.this.a.q().c();
            bcu.this.a.q().a(bcu.this.s(), bdyVar, null, R.id.menu_container, true);
        }

        @Override // bcx.a
        public void d() {
            bdv bdvVar = new bdv();
            Bundle bundle = new Bundle();
            bundle.putInt("current_screen", 0);
            bdvVar.g(bundle);
            bcu.this.a.q().c();
            bcu.this.a.q().a(bcu.this.s(), bdvVar, bundle, R.id.menu_container, true);
        }

        @Override // bcx.a
        public void e() {
            if (bcu.this.d == null) {
                bcu.this.d = new arw.a(bcu.this.a).a(bcu.this.a.getString(R.string.Tidal_LogoutTip_Str)).b(bcu.this.a.getString(R.string.TidalLogout)).a(bcu.this.a.getString(R.string.YES_Str), new DialogInterface.OnClickListener() { // from class: bcu.2.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new ava().a(5, bcu.this.a).b();
                        bcu.this.a.a(TidalMusicDataLocal.class, TidalRadio.class);
                        Toast.makeText(bcu.this.a, bcu.this.a.getString(R.string.Tidal_LogoutSucceedTip_Str), 1).show();
                        bcw.a = 1;
                        if (bcu.this.c != null) {
                            bcu.this.c.a();
                        }
                    }
                }).b(bcu.this.a.getString(R.string.Cancel_Str), new DialogInterface.OnClickListener() { // from class: bcu.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        bcu.this.d.dismiss();
                    }
                }).d(false).b();
            }
            if (!bcu.this.d.isShowing()) {
                new asc(bcu.this.d).a(null);
            }
        }
    };

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        if (this.c == null) {
            this.c = new bcx(this.a);
            this.c.setOnTidalListener(this.f);
        }
    }

    @Override // defpackage.ako
    public View c() {
        return this.c;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        super.c(bundle);
        if (!this.e) {
            this.e = true;
            this.a.q().a(s(), new bed(), (Bundle) null, R.id.menu_container);
        }
    }

    @Override // defpackage.ajj
    public ajv b() {
        return new ajv.a().a(this.b).c();
    }
}
