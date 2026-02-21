package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import defpackage.bif;
import defpackage.bil;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
class bim extends bil {
    private final Context a;

    bim(Context context) {
        this.a = context;
    }

    @Override // defpackage.bil
    public boolean a(bij bijVar) {
        if (bijVar.e != 0) {
            return true;
        }
        return "android.resource".equals(bijVar.d.getScheme());
    }

    @Override // defpackage.bil
    public bil.a a(bij bijVar, int i) throws FileNotFoundException {
        Resources resourcesA = bit.a(this.a, bijVar);
        return new bil.a(a(resourcesA, bit.a(resourcesA, bijVar), bijVar), bif.d.DISK);
    }

    private static Bitmap a(Resources resources, int i, bij bijVar) {
        BitmapFactory.Options optionsC = c(bijVar);
        if (a(optionsC)) {
            BitmapFactory.decodeResource(resources, i, optionsC);
            a(bijVar.h, bijVar.i, optionsC, bijVar);
        }
        return BitmapFactory.decodeResource(resources, i, optionsC);
    }
}
