package defpackage;

import android.content.Intent;
import com.harman.hkconnect.ui.DashboardActivity;

/* JADX INFO: loaded from: classes.dex */
public abstract class avb {
    protected int a;
    private final DashboardActivity b;
    private ave c;

    public avb(DashboardActivity dashboardActivity, int i) {
        this.b = dashboardActivity;
        this.a = i;
    }

    public boolean a() {
        return true;
    }

    public int f() {
        return this.a;
    }

    public DashboardActivity g() {
        return this.b;
    }

    public ave h() {
        return this.c;
    }

    public void a(ave aveVar) {
        this.c = aveVar;
    }

    public void a(Class cls) {
        this.b.startActivityForResult(new Intent(this.b, (Class<?>) cls), this.a);
    }
}
