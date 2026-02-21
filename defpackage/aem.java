package defpackage;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class aem extends aen {
    public aem(adx adxVar, aev aevVar) {
        super(adxVar, aevVar);
        this.g = false;
        this.a = new ael(this.f);
        this.b = new aej(this.f);
    }

    @Override // defpackage.aen, defpackage.aeh
    public void a(Handler handler) {
        this.c = handler;
        ((aej) this.b).a(handler);
        afc.a().a(this);
    }

    @Override // defpackage.aen, defpackage.aes
    public void a(long j, byte[] bArr) {
        if (j == this.f.P()) {
            super.a(j, bArr);
        }
    }
}
