package defpackage;

import android.content.Context;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class bov {
    private final AtomicReference<boy> a;
    private final CountDownLatch b;
    private box c;
    private boolean d;

    static class a {
        private static final bov a = new bov();
    }

    public static bov a() {
        return a.a;
    }

    private bov() {
        this.a = new AtomicReference<>();
        this.b = new CountDownLatch(1);
        this.d = false;
    }

    public synchronized bov a(bln blnVar, bml bmlVar, bnw bnwVar, String str, String str2, String str3) {
        bov bovVar;
        if (this.d) {
            bovVar = this;
        } else {
            if (this.c == null) {
                Context contextR = blnVar.r();
                String strC = bmlVar.c();
                String strA = new bmc().a(contextR);
                String strI = bmlVar.i();
                this.c = new boo(blnVar, new bpb(strA, bmlVar.g(), bmlVar.f(), bmlVar.e(), bmlVar.k(), bmlVar.b(), bmlVar.l(), bme.a(bme.m(contextR)), str2, str, bmh.a(strI).a(), bme.k(contextR)), new bmp(), new bop(), new bon(blnVar), new boq(blnVar, str3, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", strC), bnwVar));
            }
            this.d = true;
            bovVar = this;
        }
        return bovVar;
    }

    public boy b() {
        try {
            this.b.await();
            return this.a.get();
        } catch (InterruptedException e) {
            blh.h().e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    public synchronized boolean c() {
        boy boyVarA;
        boyVarA = this.c.a();
        a(boyVarA);
        return boyVarA != null;
    }

    public synchronized boolean d() {
        boy boyVarA;
        boyVarA = this.c.a(bow.SKIP_CACHE_LOOKUP);
        a(boyVarA);
        if (boyVarA == null) {
            blh.h().e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return boyVarA != null;
    }

    private void a(boy boyVar) {
        this.a.set(boyVar);
        this.b.countDown();
    }
}
