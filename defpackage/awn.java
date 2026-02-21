package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class awn implements bir {
    @Override // defpackage.bir
    public Bitmap a(Bitmap bitmap) {
        Bitmap bitmapA = a(Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true), 3.0d);
        if (bitmapA != bitmap) {
            bitmap.recycle();
        }
        return bitmapA;
    }

    @Override // defpackage.bir
    public String a() {
        return "JukeBlurTransformation";
    }

    public Bitmap a(Bitmap bitmap, double d) {
        awl awlVar = new awl(3);
        awlVar.a(1.0d);
        awlVar.a[1][1] = d;
        awlVar.b = 8.0d + d;
        awlVar.c = 1.0d;
        return awl.a(bitmap, awlVar);
    }
}
