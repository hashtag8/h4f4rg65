package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import defpackage.bif;
import defpackage.bil;

/* JADX INFO: loaded from: classes.dex */
class bhn extends bil {
    private static final int a = "file:///android_asset/".length();
    private final AssetManager b;

    public bhn(Context context) {
        this.b = context.getAssets();
    }

    @Override // defpackage.bil
    public boolean a(bij bijVar) {
        Uri uri = bijVar.d;
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    @Override // defpackage.bil
    public bil.a a(bij bijVar, int i) {
        return new bil.a(this.b.open(b(bijVar)), bif.d.DISK);
    }

    static String b(bij bijVar) {
        return bijVar.d.toString().substring(a);
    }
}
