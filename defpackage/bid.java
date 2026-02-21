package defpackage;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import defpackage.bhv;
import defpackage.bif;
import defpackage.bil;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes.dex */
class bid extends bil {
    private final bhv a;
    private final bin b;

    public bid(bhv bhvVar, bin binVar) {
        this.a = bhvVar;
        this.b = binVar;
    }

    @Override // defpackage.bil
    public boolean a(bij bijVar) {
        String scheme = bijVar.d.getScheme();
        return HttpHost.DEFAULT_SCHEME_NAME.equals(scheme) || "https".equals(scheme);
    }

    @Override // defpackage.bil
    public bil.a a(bij bijVar, int i) throws a {
        bhv.a aVarA = this.a.a(bijVar.d, bijVar.c);
        if (aVarA == null) {
            return null;
        }
        bif.d dVar = aVarA.c ? bif.d.DISK : bif.d.NETWORK;
        Bitmap bitmapB = aVarA.b();
        if (bitmapB != null) {
            return new bil.a(bitmapB, dVar);
        }
        InputStream inputStreamA = aVarA.a();
        if (inputStreamA == null) {
            return null;
        }
        if (dVar == bif.d.DISK && aVarA.c() == 0) {
            bit.a(inputStreamA);
            throw new a("Received response with 0 content-length header.");
        }
        if (dVar == bif.d.NETWORK && aVarA.c() > 0) {
            this.b.a(aVarA.c());
        }
        return new bil.a(inputStreamA, dVar);
    }

    @Override // defpackage.bil
    int a() {
        return 2;
    }

    @Override // defpackage.bil
    boolean a(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    @Override // defpackage.bil
    boolean b() {
        return true;
    }

    static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }
}
