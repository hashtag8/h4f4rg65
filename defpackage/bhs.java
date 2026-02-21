package defpackage;

import android.content.Context;
import defpackage.bif;
import defpackage.bil;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
class bhs extends bil {
    final Context a;

    bhs(Context context) {
        this.a = context;
    }

    @Override // defpackage.bil
    public boolean a(bij bijVar) {
        return "content".equals(bijVar.d.getScheme());
    }

    @Override // defpackage.bil
    public bil.a a(bij bijVar, int i) {
        return new bil.a(b(bijVar), bif.d.DISK);
    }

    InputStream b(bij bijVar) {
        return this.a.getContentResolver().openInputStream(bijVar.d);
    }
}
