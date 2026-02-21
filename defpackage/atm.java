package defpackage;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class atm extends ajk {
    private a a;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;

    public interface a {
        void a(atf atfVar);

        void a(atl atlVar, Bundle bundle);

        void b(String str);

        void b(boolean z);

        void c(boolean z);

        void d(boolean z);

        void k();

        atf l();
    }

    public a e() {
        return this.a;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        if (!z) {
            this.a.b(this.b);
            this.a.c(this.c);
            this.a.d(this.d);
            b();
            return;
        }
        c();
    }

    protected void b() {
    }

    protected void c() {
    }

    protected void a(boolean z) {
        this.b = z;
        this.a.b(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.a = (a) activity;
    }

    public void d() {
        mm.b("TEST_DEVICE_FOTA_CHANGE ---> nextButtonClicked", new Object[0]);
    }
}
