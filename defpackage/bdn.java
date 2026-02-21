package defpackage;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class bdn extends bdm {
    private ProgressDialog a;
    public Bundle ao;
    bcx ap;
    int aq = bcw.a;

    abstract View c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    abstract void c();

    public void d() {
        if (this.a == null) {
            this.a = new ProgressDialog(p(), 4);
            this.a.setCancelable(true);
            this.a.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: bdn.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    agv.a(true).a(true);
                }
            });
            this.a.setMessage(this.ae.getString(R.string.kAndroid_Loading));
        }
        if (!this.a.isShowing()) {
            new asc(this.a).a(p());
        }
    }

    public boolean al() {
        if (this.a == null) {
            return false;
        }
        return this.a.isShowing();
    }

    public void am() {
        if (this.a != null && this.a.isShowing()) {
            this.a.dismiss();
            this.a = null;
        }
    }

    @Override // defpackage.bdm, defpackage.ajk
    public void c(Bundle bundle) {
        if (bundle != null) {
            this.ao = (Bundle) bundle.clone();
        } else {
            this.ao = null;
        }
        this.aq = bcw.a;
        if (!ahh.e(this.ae)) {
            Toast.makeText(this.ae, R.string.WifiDisConnect_Str, 0).show();
            am();
        } else {
            if (ahn.a()) {
                an();
            }
            super.c(bundle);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void i() {
        super.i();
        mm.b("LIFECYCLE", "in Destroyview");
        this.ae.ae();
        this.ae.af();
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void f() {
        super.f();
        mm.b("LIFECYCLE", "in onDetach");
    }

    @Override // defpackage.ajj, defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        mm.b("LIFECYCLE", "in onhidden changed");
        if (ahn.a() && !z) {
            an();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ViewGroup viewGroup = (ViewGroup) B();
        viewGroup.removeAllViewsInLayout();
        viewGroup.addView(a(p().getLayoutInflater(), viewGroup, (Bundle) null));
        c();
        c(this.ao);
    }

    @Override // defpackage.bdm, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return c(layoutInflater, viewGroup, bundle);
    }

    public void an() {
        if (this.ap != null) {
            bcw.a = this.aq;
            this.ap.setSelected(bcw.a);
        }
    }

    @Override // defpackage.bdm, age.a
    public void a(int i, List<MusicData> list, JSONObject jSONObject) {
        super.a(i, list, jSONObject);
        am();
    }

    @Override // defpackage.bdm, age.a
    public void a(ErrorInfo errorInfo) {
        super.a(errorInfo);
        am();
    }
}
