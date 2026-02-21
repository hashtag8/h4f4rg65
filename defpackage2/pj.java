package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.support.v8.renderscript.Allocation;

/* JADX INFO: loaded from: classes.dex */
class pj implements qd {
    private final Context a;
    private final String b;

    public pj(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    @Override // defpackage.qd
    public String a() {
        try {
            Bundle bundle = this.a.getPackageManager().getApplicationInfo(this.b, Allocation.USAGE_SHARED).metaData;
            if (bundle == null) {
                return null;
            }
            return bundle.getString("io.fabric.unity.crashlytics.version");
        } catch (Exception e) {
            return null;
        }
    }
}
