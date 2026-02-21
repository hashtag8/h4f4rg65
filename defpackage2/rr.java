package defpackage;

import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.AdSizeParcel;

/* JADX INFO: loaded from: classes.dex */
public class rr {
    private qy a;
    private rb b;
    private rn c;
    private qz[] d;
    private String e;
    private ViewGroup f;
    private ta g;
    private tb h;

    public qy a() {
        return this.a;
    }

    public void a(String str) {
        if (this.e != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.e = str;
    }

    public void a(qy qyVar) {
        try {
            this.a = qyVar;
            if (this.c != null) {
                this.c.a(qyVar != null ? new rf(qyVar) : null);
            }
        } catch (RemoteException e) {
            su.c("Failed to set the AdListener.", e);
        }
    }

    public void a(rb rbVar) {
        try {
            this.b = rbVar;
            if (this.c != null) {
                this.c.a(rbVar != null ? new re(rbVar) : null);
            }
        } catch (RemoteException e) {
            su.c("Failed to set the AdClickListener.", e);
        }
    }

    public void a(ta taVar) {
        if (this.h != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.g = taVar;
            if (this.c != null) {
                this.c.a(taVar != null ? new yr(taVar) : null);
            }
        } catch (RemoteException e) {
            su.c("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void a(qz... qzVarArr) {
        if (this.d != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        b(qzVarArr);
    }

    public qz b() {
        AdSizeParcel adSizeParcelA;
        try {
            if (this.c != null && (adSizeParcelA = this.c.a()) != null) {
                return adSizeParcelA.a();
            }
        } catch (RemoteException e) {
            su.c("Failed to get the current AdSize.", e);
        }
        if (this.d != null) {
            return this.d[0];
        }
        return null;
    }

    public void b(qz... qzVarArr) {
        this.d = qzVarArr;
        try {
            if (this.c != null) {
                this.c.a(new AdSizeParcel(this.f.getContext(), this.d));
            }
        } catch (RemoteException e) {
            su.c("Failed to set the ad size.", e);
        }
        this.f.requestLayout();
    }

    public String c() {
        return this.e;
    }

    public ta d() {
        return this.g;
    }

    public String e() {
        try {
            if (this.c != null) {
                return this.c.b();
            }
        } catch (RemoteException e) {
            su.c("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }
}
