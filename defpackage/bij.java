package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import defpackage.bif;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class bij {
    private static final long s = TimeUnit.SECONDS.toNanos(5);
    int a;
    long b;
    int c;
    public final Uri d;
    public final int e;
    public final String f;
    public final List<bir> g;
    public final int h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final float m;
    public final float n;
    public final float o;
    public final boolean p;
    public final Bitmap.Config q;
    public final bif.e r;

    private bij(Uri uri, int i, String str, List<bir> list, int i2, int i3, boolean z, boolean z2, boolean z3, float f, float f2, float f3, boolean z4, Bitmap.Config config, bif.e eVar) {
        this.d = uri;
        this.e = i;
        this.f = str;
        if (list == null) {
            this.g = null;
        } else {
            this.g = Collections.unmodifiableList(list);
        }
        this.h = i2;
        this.i = i3;
        this.j = z;
        this.k = z2;
        this.l = z3;
        this.m = f;
        this.n = f2;
        this.o = f3;
        this.p = z4;
        this.q = config;
        this.r = eVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        if (this.e > 0) {
            sb.append(this.e);
        } else {
            sb.append(this.d);
        }
        if (this.g != null && !this.g.isEmpty()) {
            Iterator<bir> it = this.g.iterator();
            while (it.hasNext()) {
                sb.append(' ').append(it.next().a());
            }
        }
        if (this.f != null) {
            sb.append(" stableKey(").append(this.f).append(')');
        }
        if (this.h > 0) {
            sb.append(" resize(").append(this.h).append(',').append(this.i).append(')');
        }
        if (this.j) {
            sb.append(" centerCrop");
        }
        if (this.k) {
            sb.append(" centerInside");
        }
        if (this.m != 0.0f) {
            sb.append(" rotation(").append(this.m);
            if (this.p) {
                sb.append(" @ ").append(this.n).append(',').append(this.o);
            }
            sb.append(')');
        }
        if (this.q != null) {
            sb.append(' ').append(this.q);
        }
        sb.append('}');
        return sb.toString();
    }

    String a() {
        long jNanoTime = System.nanoTime() - this.b;
        return jNanoTime > s ? b() + '+' + TimeUnit.NANOSECONDS.toSeconds(jNanoTime) + 's' : b() + '+' + TimeUnit.NANOSECONDS.toMillis(jNanoTime) + "ms";
    }

    String b() {
        return "[R" + this.a + ']';
    }

    String c() {
        return this.d != null ? String.valueOf(this.d.getPath()) : Integer.toHexString(this.e);
    }

    public boolean d() {
        return (this.h == 0 && this.i == 0) ? false : true;
    }

    boolean e() {
        return f() || g();
    }

    boolean f() {
        return d() || this.m != 0.0f;
    }

    boolean g() {
        return this.g != null;
    }

    public static final class a {
        private Uri a;
        private int b;
        private String c;
        private int d;
        private int e;
        private boolean f;
        private boolean g;
        private boolean h;
        private float i;
        private float j;
        private float k;
        private boolean l;
        private List<bir> m;
        private Bitmap.Config n;
        private bif.e o;

        a(Uri uri, int i, Bitmap.Config config) {
            this.a = uri;
            this.b = i;
            this.n = config;
        }

        boolean a() {
            return (this.a == null && this.b == 0) ? false : true;
        }

        boolean b() {
            return (this.d == 0 && this.e == 0) ? false : true;
        }

        public a a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            }
            if (i2 == 0 && i == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            }
            this.d = i;
            this.e = i2;
            return this;
        }

        public a c() {
            if (this.g) {
                throw new IllegalStateException("Center crop can not be used after calling centerInside");
            }
            this.f = true;
            return this;
        }

        public a d() {
            if (this.f) {
                throw new IllegalStateException("Center inside can not be used after calling centerCrop");
            }
            this.g = true;
            return this;
        }

        public a e() {
            if (this.e == 0 && this.d == 0) {
                throw new IllegalStateException("onlyScaleDown can not be applied without resize");
            }
            this.h = true;
            return this;
        }

        public a a(Bitmap.Config config) {
            this.n = config;
            return this;
        }

        public a a(bir birVar) {
            if (birVar == null) {
                throw new IllegalArgumentException("Transformation must not be null.");
            }
            if (birVar.a() == null) {
                throw new IllegalArgumentException("Transformation key must not be null.");
            }
            if (this.m == null) {
                this.m = new ArrayList(2);
            }
            this.m.add(birVar);
            return this;
        }

        public bij f() {
            if (this.g && this.f) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            }
            if (this.f && this.d == 0 && this.e == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            }
            if (this.g && this.d == 0 && this.e == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            }
            if (this.o == null) {
                this.o = bif.e.NORMAL;
            }
            return new bij(this.a, this.b, this.c, this.m, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.n, this.o);
        }
    }
}
