package defpackage;

import android.widget.Toast;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;

/* JADX INFO: loaded from: classes.dex */
public abstract class avd extends avc {
    protected abstract void c();

    protected avd(DashboardActivity dashboardActivity, int i, auz auzVar) {
        super(dashboardActivity, i, auzVar);
    }

    @Override // defpackage.avc, defpackage.avb
    public boolean a() {
        if (ahn.a()) {
            if (i().a()) {
                b();
            } else {
                if (!ahh.e(g())) {
                    Toast.makeText(g(), R.string.WifiNotReachableTip_Str, 0).show();
                    return false;
                }
                c();
                return false;
            }
        } else if (i().a()) {
            a(false);
        } else {
            if (!ahh.e(g())) {
                Toast.makeText(g(), R.string.WifiNotReachableTip_Str, 0).show();
                return false;
            }
            c();
            return false;
        }
        return true;
    }

    protected void b() {
        d();
    }

    protected void a(boolean z) {
        d();
    }

    private void d() {
    }

    @Override // defpackage.avc
    public void c_() {
        if (ahn.a()) {
            b();
        } else {
            a(true);
        }
    }
}
