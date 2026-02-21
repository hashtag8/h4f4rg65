package defpackage;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.musicservice.juke.model.JukeMusicDataLocal;
import defpackage.ajv;
import defpackage.arw;
import defpackage.aws;

/* JADX INFO: loaded from: classes.dex */
public class awr extends axj {
    private aws h;
    private arw b = null;
    protected MenuItem.OnMenuItemClickListener a = new MenuItem.OnMenuItemClickListener() { // from class: awr.2
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            awr.this.ae.q().a(new axv(), (arc) null);
            return true;
        }
    };

    @Override // defpackage.axj, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.h = new aws(p());
        this.h.setOnJukeListener(new aws.a() { // from class: awr.1
            @Override // aws.a
            public void a() {
                awr.this.ae.q().a(new axl(), (arc) null);
            }

            @Override // aws.a
            public void b() {
                awr.this.ae.q().a(new axu(), (arc) null);
            }

            @Override // aws.a
            public void c() {
                awr.this.ae.q().a(new axp(), (arc) null);
            }

            @Override // aws.a
            public void d() {
                awr.this.ae.q().a(new axt(), (arc) null);
            }

            @Override // aws.a
            public void e() {
                awr.this.ae.q().a(new axn(), (arc) null);
            }

            @Override // aws.a
            public void f() {
                awr.this.ae.q().a(new axr(), (arc) null);
            }

            @Override // aws.a
            public void g() {
                axq axqVar = new axq();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("current_screen", 0);
                axqVar.g(bundle2);
                awr.this.ae.q().a(axqVar, (arc) null);
            }

            @Override // aws.a
            public void h() {
                if (awr.this.b == null) {
                    awr.this.b = new arw.a(awr.this.p()).a(awr.this.p().getString(R.string.JukeLogoutBlurb)).b(awr.this.p().getString(R.string.JukeLogout)).a(awr.this.p().getString(R.string.YES_Str), new DialogInterface.OnClickListener() { // from class: awr.1.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            new ava().a(6, awr.this.ae).b();
                            awr.this.ae.a(JukeMusicDataLocal.class);
                            Toast.makeText(awr.this.p(), awr.this.p().getString(R.string.JukeLogoutConfirm), 1).show();
                            awp.a = 0;
                            awr.this.h.a();
                        }
                    }).b(awr.this.p().getString(R.string.Cancel_Str), new DialogInterface.OnClickListener() { // from class: awr.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            awr.this.b.dismiss();
                        }
                    }).d(false).b();
                }
                if (!awr.this.b.isShowing()) {
                    new asc(awr.this.b).a(awr.this.p());
                }
            }
        });
        return this.h;
    }

    @Override // defpackage.axj, defpackage.ajj
    public ajv b() {
        return new ajv.a().a(-16777216).j(R.color.logoview_bg).h(R.drawable.juke_nav_logo).c(true).k(R.drawable.search).a(this.a).c();
    }
}
