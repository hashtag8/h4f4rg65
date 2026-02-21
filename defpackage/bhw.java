package defpackage;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import defpackage.bif;
import defpackage.bil;

/* JADX INFO: loaded from: classes.dex */
class bhw extends bhs {
    bhw(Context context) {
        super(context);
    }

    @Override // defpackage.bhs, defpackage.bil
    public boolean a(bij bijVar) {
        return "file".equals(bijVar.d.getScheme());
    }

    @Override // defpackage.bhs, defpackage.bil
    public bil.a a(bij bijVar, int i) {
        return new bil.a(null, b(bijVar), bif.d.DISK, a(bijVar.d));
    }

    static int a(Uri uri) {
        switch (new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1)) {
            case 3:
                return 180;
            case 4:
            case 5:
            case 7:
            default:
                return 0;
            case 6:
                return 90;
            case 8:
                return 270;
        }
    }
}
