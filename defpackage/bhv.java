package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public interface bhv {
    a a(Uri uri, int i);

    public static class b extends IOException {
        final boolean a;
        final int b;

        public b(String str, int i, int i2) {
            super(str);
            this.a = bic.c(i);
            this.b = i2;
        }
    }

    public static class a {
        final InputStream a;
        final Bitmap b;
        final boolean c;
        final long d;

        public a(InputStream inputStream, boolean z, long j) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Stream may not be null.");
            }
            this.a = inputStream;
            this.b = null;
            this.c = z;
            this.d = j;
        }

        public InputStream a() {
            return this.a;
        }

        @Deprecated
        public Bitmap b() {
            return this.b;
        }

        public long c() {
            return this.d;
        }
    }
}
