package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class bcs implements bir {
    private String a;

    public bcs(String str) {
        this.a = str;
    }

    @Override // defpackage.bir
    public Bitmap a(Bitmap bitmap) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight());
        if (bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    @Override // defpackage.bir
    public String a() {
        return "TidalGenreTransformation(" + this.a + ")";
    }
}
