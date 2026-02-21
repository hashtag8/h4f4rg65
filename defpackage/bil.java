package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import defpackage.bif;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class bil {
    public abstract a a(bij bijVar, int i);

    public abstract boolean a(bij bijVar);

    public static final class a {
        private final bif.d a;
        private final Bitmap b;
        private final InputStream c;
        private final int d;

        public a(Bitmap bitmap, bif.d dVar) {
            this((Bitmap) bit.a(bitmap, "bitmap == null"), null, dVar, 0);
        }

        public a(InputStream inputStream, bif.d dVar) {
            this(null, (InputStream) bit.a(inputStream, "stream == null"), dVar, 0);
        }

        a(Bitmap bitmap, InputStream inputStream, bif.d dVar, int i) {
            if (!((inputStream != null) ^ (bitmap != null))) {
                throw new AssertionError();
            }
            this.b = bitmap;
            this.c = inputStream;
            this.a = (bif.d) bit.a(dVar, "loadedFrom == null");
            this.d = i;
        }

        public Bitmap a() {
            return this.b;
        }

        public InputStream b() {
            return this.c;
        }

        public bif.d c() {
            return this.a;
        }

        int d() {
            return this.d;
        }
    }

    int a() {
        return 0;
    }

    boolean a(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    boolean b() {
        return false;
    }

    static BitmapFactory.Options c(bij bijVar) {
        boolean zD = bijVar.d();
        boolean z = bijVar.q != null;
        BitmapFactory.Options options = null;
        if (zD || z) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = zD;
            if (z) {
                options.inPreferredConfig = bijVar.q;
            }
        }
        return options;
    }

    static boolean a(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    static void a(int i, int i2, BitmapFactory.Options options, bij bijVar) {
        a(i, i2, options.outWidth, options.outHeight, options, bijVar);
    }

    static void a(int i, int i2, int i3, int i4, BitmapFactory.Options options, bij bijVar) {
        int iMin = 1;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                iMin = (int) Math.floor(i3 / i);
            } else if (i == 0) {
                iMin = (int) Math.floor(i4 / i2);
            } else {
                int iFloor = (int) Math.floor(i4 / i2);
                int iFloor2 = (int) Math.floor(i3 / i);
                if (bijVar.k) {
                    iMin = Math.max(iFloor, iFloor2);
                } else {
                    iMin = Math.min(iFloor, iFloor2);
                }
            }
        }
        options.inSampleSize = iMin;
        options.inJustDecodeBounds = false;
    }
}
