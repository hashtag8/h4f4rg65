package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
class bly {
    private final Context a;
    private final bod b;

    public bly(Context context) {
        this.a = context.getApplicationContext();
        this.b = new boe(context, "TwitterAdvertisingInfoPreferences");
    }

    public blx a() {
        blx blxVarB = b();
        if (c(blxVarB)) {
            blh.h().a("Fabric", "Using AdvertisingInfo from Preference Store");
            a(blxVarB);
            return blxVarB;
        }
        blx blxVarE = e();
        b(blxVarE);
        return blxVarE;
    }

    private void a(final blx blxVar) {
        new Thread(new bmd() { // from class: bly.1
            @Override // defpackage.bmd
            public void a() {
                blx blxVarE = bly.this.e();
                if (!blxVar.equals(blxVarE)) {
                    blh.h().a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                    bly.this.b(blxVarE);
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    public void b(blx blxVar) {
        if (c(blxVar)) {
            this.b.a(this.b.b().putString("advertising_id", blxVar.a).putBoolean("limit_ad_tracking_enabled", blxVar.b));
        } else {
            this.b.a(this.b.b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
        }
    }

    protected blx b() {
        return new blx(this.b.a().getString("advertising_id", ""), this.b.a().getBoolean("limit_ad_tracking_enabled", false));
    }

    public bmb c() {
        return new blz(this.a);
    }

    public bmb d() {
        return new bma(this.a);
    }

    private boolean c(blx blxVar) {
        return (blxVar == null || TextUtils.isEmpty(blxVar.a)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public blx e() {
        blx blxVarA = c().a();
        if (!c(blxVarA)) {
            blxVarA = d().a();
            if (!c(blxVarA)) {
                blh.h().a("Fabric", "AdvertisingInfo not present");
            } else {
                blh.h().a("Fabric", "Using AdvertisingInfo from Service Provider");
            }
        } else {
            blh.h().a("Fabric", "Using AdvertisingInfo from Reflection Provider");
        }
        return blxVarA;
    }
}
