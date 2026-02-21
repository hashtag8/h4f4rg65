package defpackage;

import android.content.Intent;
import android.util.SparseArray;
import com.harman.hkconnect.ui.DashboardActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class avf {
    private DashboardActivity b;
    private SparseArray<avb> a = new SparseArray<>();
    private boolean d = false;
    private List<avb> c = new ArrayList();

    public avf(DashboardActivity dashboardActivity) {
        this.b = dashboardActivity;
    }

    public List<avb> a() {
        return this.c;
    }

    public void a(avb avbVar) {
        this.c.add(avbVar);
        this.a.put(avbVar.f(), avbVar);
    }

    public void b() {
        if (this.c != null) {
            this.c.clear();
        } else {
            this.c = new ArrayList();
        }
    }

    public void a(int i) {
        this.a.get(i).a();
        this.d = true;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.d) {
            if (i2 == -1) {
                if (this.a.get(i) != null) {
                    ((avc) this.a.get(i)).c_();
                    return;
                }
                return;
            }
            mm.b("resultCode != Activity.RESULT_OK", new Object[0]);
        }
    }

    public void b(int i) {
        auz auzVarA = new ava().a(i, this.b);
        if (!(auzVarA instanceof auy)) {
            try {
                if (auzVarA.a()) {
                    ((avc) this.a.get(i)).c_();
                    return;
                }
                return;
            } catch (Exception e) {
                new ml().a("The mMsHashMap should have MsControllerLoginMenu for service with HCConstant " + i);
                return;
            }
        }
        avb avbVar = this.a.get(i);
        if (avbVar != null) {
            avbVar.a();
        } else {
            mm.e("Unknown controller for service %s ", Integer.valueOf(i));
        }
    }
}
