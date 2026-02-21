package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.apache.http.entity.mime.MIME;

/* JADX INFO: loaded from: classes.dex */
class blr extends bln<Boolean> {
    private final bnw a = new bnt();
    private PackageManager b;
    private String c;
    private PackageInfo d;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private final Future<Map<String, blp>> p;
    private final Collection<bln> q;

    public blr(Future<Map<String, blp>> future, Collection<bln> collection) {
        this.p = future;
        this.q = collection;
    }

    @Override // defpackage.bln
    public String a() {
        return "1.4.2.22";
    }

    @Override // defpackage.bln
    protected boolean b_() {
        boolean z = false;
        try {
            this.m = q().i();
            this.b = r().getPackageManager();
            this.c = r().getPackageName();
            this.d = this.b.getPackageInfo(this.c, 0);
            this.k = Integer.toString(this.d.versionCode);
            this.l = this.d.versionName == null ? "0.0" : this.d.versionName;
            this.n = this.b.getApplicationLabel(r().getApplicationInfo()).toString();
            this.o = Integer.toString(r().getApplicationInfo().targetSdkVersion);
            z = true;
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            blh.h().e("Fabric", "Failed init", e);
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.bln
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Boolean f() throws Throwable {
        Map<String, blp> map;
        boolean zA;
        String strK = bme.k(r());
        boy boyVarG = g();
        if (boyVarG == null) {
            zA = false;
        } else {
            try {
                if (this.p != null) {
                    map = this.p.get();
                } else {
                    map = new HashMap<>();
                }
                zA = a(strK, boyVarG.a, a(map, this.q).values());
            } catch (Exception e) {
                blh.h().e("Fabric", "Error performing auto configuration.", e);
                zA = false;
            }
        }
        return Boolean.valueOf(zA);
    }

    private boy g() {
        try {
            bov.a().a(this, this.i, this.a, this.k, this.l, e()).c();
            return bov.a().b();
        } catch (Exception e) {
            blh.h().e("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    Map<String, blp> a(Map<String, blp> map, Collection<bln> collection) {
        for (bln blnVar : collection) {
            if (!map.containsKey(blnVar.b())) {
                map.put(blnVar.b(), new blp(blnVar.b(), blnVar.a(), MIME.ENC_BINARY));
            }
        }
        return map;
    }

    @Override // defpackage.bln
    public String b() {
        return "io.fabric.sdk.android:fabric";
    }

    private boolean a(String str, boj bojVar, Collection<blp> collection) {
        if ("new".equals(bojVar.b)) {
            if (b(str, bojVar, collection)) {
                return bov.a().d();
            }
            blh.h().e("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        }
        if ("configured".equals(bojVar.b)) {
            return bov.a().d();
        }
        if (!bojVar.f) {
            return true;
        }
        blh.h().a("Fabric", "Server says an update is required - forcing a full App update.");
        c(str, bojVar, collection);
        return true;
    }

    private boolean b(String str, boj bojVar, Collection<blp> collection) {
        return new bom(this, e(), bojVar.c, this.a).a(a(bos.a(r(), str), collection));
    }

    private boolean c(String str, boj bojVar, Collection<blp> collection) {
        return a(bojVar, bos.a(r(), str), collection);
    }

    private boolean a(boj bojVar, bos bosVar, Collection<blp> collection) {
        return new bpd(this, e(), bojVar.c, this.a).a(a(bosVar, collection));
    }

    private boi a(bos bosVar, Collection<blp> collection) {
        Context contextR = r();
        return new boi(new bmc().a(contextR), q().c(), this.l, this.k, bme.a(bme.m(contextR)), this.n, bmh.a(this.m).a(), this.o, "0", bosVar, collection);
    }

    String e() {
        return bme.b(r(), "com.crashlytics.ApiEndpoint");
    }
}
