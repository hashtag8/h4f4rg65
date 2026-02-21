package defpackage;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.musicservice.tidal.model.TidalMusicDataLocal;
import com.musicservice.tidal.model.TidalRadio;
import defpackage.ajv;
import defpackage.arw;
import defpackage.bcx;

/* JADX INFO: loaded from: classes.dex */
public class bcl extends ajj {
    private bcx b;
    private arw c = null;
    protected MenuItem.OnMenuItemClickListener a = new MenuItem.OnMenuItemClickListener() { // from class: bcl.2
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            bcl.this.ae.q().a(new bea(), (arc) null);
            return true;
        }
    };

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = new bcx(this.ae);
        this.b.setOnTidalListener(new bcx.a() { // from class: bcl.1
            @Override // bcx.a
            public void a() {
                bcl.this.c();
                bcl.this.ae.q().a(new bed(), (arc) null);
            }

            @Override // bcx.a
            public void b() {
                bcl.this.c();
                bcl.this.ae.q().a(new bdx(), (arc) null);
            }

            @Override // bcx.a
            public void c() {
                bcl.this.c();
                bcl.this.ae.q().a(new bdy(), (arc) null);
            }

            @Override // bcx.a
            public void d() {
                bcl.this.c();
                bdv bdvVar = new bdv();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("current_screen", 0);
                bdvVar.g(bundle2);
                bcl.this.ae.q().a(bdvVar, (arc) null);
            }

            @Override // bcx.a
            public void e() {
                if (bcl.this.c == null) {
                    bcl.this.c = new arw.a(bcl.this.ae).a(bcl.this.ae.getString(R.string.Tidal_LogoutTip_Str)).b(bcl.this.ae.getString(R.string.TidalLogout)).a(bcl.this.ae.getString(R.string.YES_Str), new DialogInterface.OnClickListener() { // from class: bcl.1.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            new ava().a(5, bcl.this.ae).b();
                            bcl.this.ae.a(TidalMusicDataLocal.class, TidalRadio.class);
                            Toast.makeText(bcl.this.ae, bcl.this.ae.getString(R.string.Tidal_LogoutSucceedTip_Str), 1).show();
                            bcw.a = 1;
                            bcl.this.b.a();
                        }
                    }).b(bcl.this.ae.getString(R.string.Cancel_Str), new DialogInterface.OnClickListener() { // from class: bcl.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            bcl.this.c.dismiss();
                        }
                    }).d(false).b();
                }
                if (!bcl.this.c.isShowing()) {
                    new asc(bcl.this.c).a(bcl.this.p());
                }
            }
        });
        this.b.setVisibility(0);
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
    }

    @Override // defpackage.ajj
    public ajv b() {
        return new ajv.a().h(R.drawable.tidal_nav_logo).d(R.color.logoview_bg).c(true).k(R.drawable.search).l(q().getColor(R.color.black_40)).a(this.a).c();
    }
}
