package defpackage;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.harman.hkconnect.R;
import defpackage.axd;

/* JADX INFO: loaded from: classes.dex */
public abstract class axk extends axj implements axd.a {
    private ProgressDialog a;
    int ah = awp.a;
    arw ai = null;
    public Bundle h;
    aws i;

    abstract View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    abstract void c();

    public void d() {
        if (this.a == null) {
            this.a = new ProgressDialog(this.ae, 4);
            this.a.setCancelable(true);
            this.a.setCanceledOnTouchOutside(false);
            this.a.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: axk.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    axk.this.a.dismiss();
                    axk.this.ae.ag();
                }
            });
            this.a.setMessage(this.ae.getString(R.string.kAndroid_Loading));
        }
        if (!this.a.isShowing()) {
            new asc(this.a).a(p());
        }
    }

    public void al() {
        if (this.a != null && this.a.isShowing()) {
            this.a.dismiss();
            this.a = null;
        }
    }

    public boolean am() {
        if (this.a == null) {
            return false;
        }
        return this.a.isShowing();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c();
    }

    @Override // defpackage.ajk
    public void c(Bundle bundle) {
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiDisConnect_Str, 0).show();
            al();
            return;
        }
        this.ah = awp.a;
        if (axc.a().e()) {
            axc.a().a(this.ae, aho.d("juke_refresh_token"), axc.a().d, true, (axd.a) this);
        } else {
            axc.a().a(this.ae, aho.d("juke_refresh_token"), axc.a().d, false, (axd.a) this);
        }
        if (ahn.a()) {
            an();
        }
        if (bundle != null) {
            this.h = (Bundle) bundle.clone();
        } else {
            this.h = null;
        }
        super.c(bundle);
    }

    @Override // defpackage.ajj, defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        if (ahn.a() && !z) {
            an();
        }
    }

    @Override // defpackage.axj, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return c(layoutInflater, viewGroup, bundle);
    }

    public void an() {
        if (this.i != null) {
            awp.a = this.ah;
            this.i.setSelected(awp.a);
        }
    }

    public void a(boolean z, int i) {
    }
}
