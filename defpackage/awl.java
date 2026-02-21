package defpackage;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public class awl {
    public double[][] a;
    public double b = 1.0d;
    public double c = 1.0d;

    public awl(int i) {
        this.a = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i, i);
    }

    public void a(double d) {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.a[i][i2] = d;
            }
        }
    }

    public static Bitmap a(Bitmap bitmap, awl awlVar) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 3, 3);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < height - 2) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < width - 2) {
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= 3) {
                                break;
                            }
                            for (int i7 = 0; i7 < 3; i7++) {
                                iArr[i6][i7] = bitmap.getPixel(i4 + i6, i2 + i7);
                            }
                            i5 = i6 + 1;
                        }
                        int iAlpha = Color.alpha(iArr[1][1]);
                        int i8 = 0;
                        int i9 = 0;
                        int i10 = 0;
                        int iRed = 0;
                        while (i9 < 3) {
                            int i11 = i8;
                            int iGreen = i10;
                            int iBlue = i11;
                            for (int i12 = 0; i12 < 3; i12++) {
                                iRed = (int) (((double) iRed) + (((double) Color.red(iArr[i9][i12])) * awlVar.a[i9][i12]));
                                iGreen = (int) (((double) iGreen) + (((double) Color.green(iArr[i9][i12])) * awlVar.a[i9][i12]));
                                iBlue = (int) (((double) iBlue) + (((double) Color.blue(iArr[i9][i12])) * awlVar.a[i9][i12]));
                            }
                            i9++;
                            int i13 = iBlue;
                            i10 = iGreen;
                            i8 = i13;
                        }
                        int i14 = (int) ((((double) iRed) / awlVar.b) + awlVar.c);
                        if (i14 < 0) {
                            i14 = 0;
                        } else if (i14 > 255) {
                            i14 = 255;
                        }
                        int i15 = (int) ((((double) i10) / awlVar.b) + awlVar.c);
                        if (i15 < 0) {
                            i15 = 0;
                        } else if (i15 > 255) {
                            i15 = 255;
                        }
                        int i16 = (int) ((((double) i8) / awlVar.b) + awlVar.c);
                        if (i16 < 0) {
                            i16 = 0;
                        } else if (i16 > 255) {
                            i16 = 255;
                        }
                        bitmapCreateBitmap.setPixel(i4 + 1, i2 + 1, Color.argb(iAlpha, i14, i15, i16));
                        i3 = i4 + 1;
                    }
                }
                i = i2 + 1;
            } else {
                return bitmapCreateBitmap;
            }
        }
    }
}
