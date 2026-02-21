package defpackage;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.musicservice.juke.model.JukeMusicDataLocal;
import defpackage.ajv;
import defpackage.arw;
import defpackage.aws;

/* JADX INFO: loaded from: classes.dex */
public class awu extends ako {
    private arw d;
    private aws c = null;
    protected MenuItem.OnMenuItemClickListener b = new MenuItem.OnMenuItemClickListener() { // from class: awu.1
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            awu.this.a.q().a(new axv(), new arc().c(R.id.menu_container));
            return true;
        }
    };
    private aws.a e = new aws.a() { // from class: awu.2
        @Override // aws.a
        public void a() {
            awu.this.a.q().c();
            awu.this.a.q().a(awu.this.s(), new axl(), null, R.id.menu_container, true);
        }

        @Override // aws.a
        public void b() {
            awu.this.a.q().c();
            awu.this.a.q().a(awu.this.s(), new axu(), null, R.id.menu_container, true);
        }

        @Override // aws.a
        public void c() {
            awu.this.a.q().c();
            awu.this.a.q().a(awu.this.s(), new axp(), null, R.id.menu_container, true);
        }

        @Override // aws.a
        public void d() {
            awu.this.a.q().c();
            awu.this.a.q().a(awu.this.s(), new axt(), null, R.id.menu_container, true);
        }

        @Override // aws.a
        public void e() {
            awu.this.a.q().c();
            awu.this.a.q().a(awu.this.s(), new axn(), null, R.id.menu_container, true);
        }

        @Override // aws.a
        public void f() {
            awu.this.a.q().c();
            awu.this.a.q().a(awu.this.s(), new axr(), null, R.id.menu_container, true);
        }

        @Override // aws.a
        public void g() {
            awu.this.a.q().c();
            Bundle bundle = new Bundle();
            bundle.putInt("current_screen", 0);
            awu.this.a.q().a(awu.this.s(), new axq(), bundle, R.id.menu_container, true);
        }

        @Override // aws.a
        public void h() {
            awu.this.d = new arw.a(awu.this.p()).a(awu.this.p().getString(R.string.JukeLogoutBlurb)).b(awu.this.p().getString(R.string.JukeLogout)).a(awu.this.p().getString(R.string.YES_Str), new DialogInterface.OnClickListener() { // from class: awu.2.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    new ava().a(6, awu.this.a).b();
                    awu.this.a.a(JukeMusicDataLocal.class);
                    ba baVarP = awu.this.p();
                    if (baVarP != null) {
                        Toast.makeText(baVarP, baVarP.getString(R.string.JukeLogoutConfirm), 1).show();
                        awp.a = 0;
                        awu.this.c.a();
                    }
                }
            }).b(awu.this.p().getString(R.string.Cancel_Str), new DialogInterface.OnClickListener() { // from class: awu.2.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    awu.this.d.dismiss();
                }
            }).d(false).b();
            if (!awu.this.d.isShowing()) {
                new asc(awu.this.d).a(null);
            }
        }
    };

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        if (this.c == null) {
            this.c = new aws(this.a);
            this.c.setOnJukeListener(this.e);
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
        awp.a = 0;
        this.a.q().a(s(), new axn(), null, R.id.menu_container, true);
    }

    @Override // defpackage.ajj
    public ajv b() {
        return new ajv.a().a(this.b).c();
    }
}
