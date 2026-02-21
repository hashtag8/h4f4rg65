package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class axy implements bir {
    private static int b = 1;
    private static int c = 2;
    private static int d = 3;
    private static int e = 4;
    private static int f = 5;
    private static int g = 6;
    private static int h = 7;
    private static int i = 8;
    private static int j = 9;
    private int a;

    public axy(int i2) {
        this.a = i2;
    }

    @Override // defpackage.bir
    public Bitmap a(Bitmap bitmap) {
        int i2;
        int i3 = 0;
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        if (this.a == b) {
            i2 = 0;
        } else if (this.a == c) {
            i2 = width;
        } else if (this.a == e) {
            i3 = height;
            i2 = width;
        } else if (this.a == d) {
            i2 = 0;
            i3 = height;
        } else {
            i2 = 0;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i2, i3, width, height);
        if (bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    @Override // defpackage.bir
    public String a() {
        return "mixRadioTransformation(" + this.a + ")";
    }
}
