package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import defpackage.bhv;
import defpackage.bid;
import defpackage.bif;
import defpackage.bil;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
class bho implements Runnable {
    private static final Object t = new Object();
    private static final ThreadLocal<StringBuilder> u = new ThreadLocal<StringBuilder>() { // from class: bho.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    };
    private static final AtomicInteger v = new AtomicInteger();
    private static final bil w = new bil() { // from class: bho.2
        @Override // defpackage.bil
        public boolean a(bij bijVar) {
            return true;
        }

        @Override // defpackage.bil
        public bil.a a(bij bijVar, int i) {
            throw new IllegalStateException("Unrecognized type of request: " + bijVar);
        }
    };
    final int a = v.incrementAndGet();
    final bif b;
    final bhu c;
    final bhp d;
    final bin e;
    final String f;
    final bij g;
    final int h;
    int i;
    final bil j;
    bhm k;
    List<bhm> l;
    Bitmap m;
    Future<?> n;
    bif.d o;
    Exception p;
    int q;
    int r;
    bif.e s;

    bho(bif bifVar, bhu bhuVar, bhp bhpVar, bin binVar, bhm bhmVar, bil bilVar) {
        this.b = bifVar;
        this.c = bhuVar;
        this.d = bhpVar;
        this.e = binVar;
        this.k = bhmVar;
        this.f = bhmVar.e();
        this.g = bhmVar.c();
        this.s = bhmVar.k();
        this.h = bhmVar.h();
        this.i = bhmVar.i();
        this.j = bilVar;
        this.r = bilVar.a();
    }

    static Bitmap a(InputStream inputStream, bij bijVar) throws IOException {
        bhz bhzVar = new bhz(inputStream);
        long jA = bhzVar.a(65536);
        BitmapFactory.Options optionsC = bil.c(bijVar);
        boolean zA = bil.a(optionsC);
        boolean zC = bit.c(bhzVar);
        bhzVar.a(jA);
        if (zC) {
            byte[] bArrB = bit.b(bhzVar);
            if (zA) {
                BitmapFactory.decodeByteArray(bArrB, 0, bArrB.length, optionsC);
                bil.a(bijVar.h, bijVar.i, optionsC, bijVar);
            }
            return BitmapFactory.decodeByteArray(bArrB, 0, bArrB.length, optionsC);
        }
        if (zA) {
            BitmapFactory.decodeStream(bhzVar, null, optionsC);
            bil.a(bijVar.h, bijVar.i, optionsC, bijVar);
            bhzVar.a(jA);
        }
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(bhzVar, null, optionsC);
        if (bitmapDecodeStream == null) {
            throw new IOException("Failed to decode stream.");
        }
        return bitmapDecodeStream;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a(this.g);
            if (this.b.l) {
                bit.a("Hunter", "executing", bit.a(this));
            }
            this.m = a();
            if (this.m == null) {
                this.c.c(this);
            } else {
                this.c.a(this);
            }
        } catch (IOException e) {
            this.p = e;
            this.c.b(this);
        } catch (bid.a e2) {
            this.p = e2;
            this.c.b(this);
        } catch (Exception e3) {
            this.p = e3;
            this.c.c(this);
        } catch (bhv.b e4) {
            if (!e4.a || e4.b != 504) {
                this.p = e4;
            }
            this.c.c(this);
        } catch (OutOfMemoryError e5) {
            StringWriter stringWriter = new StringWriter();
            this.e.e().a(new PrintWriter(stringWriter));
            this.p = new RuntimeException(stringWriter.toString(), e5);
            this.c.c(this);
        } finally {
            Thread.currentThread().setName("Picasso-Idle");
        }
    }

    Bitmap a() {
        Bitmap bitmapA = null;
        if (bib.a(this.h) && (bitmapA = this.d.a(this.f)) != null) {
            this.e.a();
            this.o = bif.d.MEMORY;
            if (this.b.l) {
                bit.a("Hunter", "decoded", this.g.a(), "from cache");
            }
        } else {
            this.g.c = this.r == 0 ? bic.OFFLINE.d : this.i;
            bil.a aVarA = this.j.a(this.g, this.i);
            if (aVarA != null) {
                this.o = aVarA.c();
                this.q = aVarA.d();
                bitmapA = aVarA.a();
                if (bitmapA == null) {
                    InputStream inputStreamB = aVarA.b();
                    try {
                        bitmapA = a(inputStreamB, this.g);
                    } finally {
                        bit.a(inputStreamB);
                    }
                }
            }
            if (bitmapA != null) {
                if (this.b.l) {
                    bit.a("Hunter", "decoded", this.g.a());
                }
                this.e.a(bitmapA);
                if (this.g.e() || this.q != 0) {
                    synchronized (t) {
                        if (this.g.f() || this.q != 0) {
                            bitmapA = a(this.g, bitmapA, this.q);
                            if (this.b.l) {
                                bit.a("Hunter", "transformed", this.g.a());
                            }
                        }
                        if (this.g.g()) {
                            bitmapA = a(this.g.g, bitmapA);
                            if (this.b.l) {
                                bit.a("Hunter", "transformed", this.g.a(), "from custom transformations");
                            }
                        }
                    }
                    if (bitmapA != null) {
                        this.e.b(bitmapA);
                    }
                }
            }
        }
        return bitmapA;
    }

    void a(bhm bhmVar) {
        boolean z = this.b.l;
        bij bijVar = bhmVar.b;
        if (this.k == null) {
            this.k = bhmVar;
            if (z) {
                if (this.l == null || this.l.isEmpty()) {
                    bit.a("Hunter", "joined", bijVar.a(), "to empty hunter");
                    return;
                } else {
                    bit.a("Hunter", "joined", bijVar.a(), bit.a(this, "to "));
                    return;
                }
            }
            return;
        }
        if (this.l == null) {
            this.l = new ArrayList(3);
        }
        this.l.add(bhmVar);
        if (z) {
            bit.a("Hunter", "joined", bijVar.a(), bit.a(this, "to "));
        }
        bif.e eVarK = bhmVar.k();
        if (eVarK.ordinal() > this.s.ordinal()) {
            this.s = eVarK;
        }
    }

    void b(bhm bhmVar) {
        boolean zRemove = false;
        if (this.k == bhmVar) {
            this.k = null;
            zRemove = true;
        } else if (this.l != null) {
            zRemove = this.l.remove(bhmVar);
        }
        if (zRemove && bhmVar.k() == this.s) {
            this.s = o();
        }
        if (this.b.l) {
            bit.a("Hunter", "removed", bhmVar.b.a(), bit.a(this, "from "));
        }
    }

    private bif.e o() {
        boolean z = true;
        int i = 0;
        bif.e eVar = bif.e.LOW;
        boolean z2 = (this.l == null || this.l.isEmpty()) ? false : true;
        if (this.k == null && !z2) {
            z = false;
        }
        if (!z) {
            return eVar;
        }
        bif.e eVarK = this.k != null ? this.k.k() : eVar;
        if (z2) {
            int size = this.l.size();
            while (i < size) {
                bif.e eVarK2 = this.l.get(i).k();
                if (eVarK2.ordinal() <= eVarK.ordinal()) {
                    eVarK2 = eVarK;
                }
                i++;
                eVarK = eVarK2;
            }
            return eVarK;
        }
        return eVarK;
    }

    boolean b() {
        if (this.k == null) {
            return (this.l == null || this.l.isEmpty()) && this.n != null && this.n.cancel(false);
        }
        return false;
    }

    boolean c() {
        return this.n != null && this.n.isCancelled();
    }

    boolean a(boolean z, NetworkInfo networkInfo) {
        if (!(this.r > 0)) {
            return false;
        }
        this.r--;
        return this.j.a(z, networkInfo);
    }

    boolean d() {
        return this.j.b();
    }

    Bitmap e() {
        return this.m;
    }

    String f() {
        return this.f;
    }

    int g() {
        return this.h;
    }

    bij h() {
        return this.g;
    }

    bhm i() {
        return this.k;
    }

    bif j() {
        return this.b;
    }

    List<bhm> k() {
        return this.l;
    }

    Exception l() {
        return this.p;
    }

    bif.d m() {
        return this.o;
    }

    bif.e n() {
        return this.s;
    }

    static void a(bij bijVar) {
        String strC = bijVar.c();
        StringBuilder sb = u.get();
        sb.ensureCapacity("Picasso-".length() + strC.length());
        sb.replace("Picasso-".length(), sb.length(), strC);
        Thread.currentThread().setName(sb.toString());
    }

    static bho a(bif bifVar, bhu bhuVar, bhp bhpVar, bin binVar, bhm bhmVar) {
        bij bijVarC = bhmVar.c();
        List<bil> listB = bifVar.b();
        int size = listB.size();
        for (int i = 0; i < size; i++) {
            bil bilVar = listB.get(i);
            if (bilVar.a(bijVarC)) {
                return new bho(bifVar, bhuVar, bhpVar, binVar, bhmVar, bilVar);
            }
        }
        return new bho(bifVar, bhuVar, bhpVar, binVar, bhmVar, w);
    }

    static Bitmap a(List<bir> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        Bitmap bitmap2 = bitmap;
        while (i < size) {
            final bir birVar = list.get(i);
            try {
                Bitmap bitmapA = birVar.a(bitmap2);
                if (bitmapA == null) {
                    final StringBuilder sbAppend = new StringBuilder().append("Transformation ").append(birVar.a()).append(" returned null after ").append(i).append(" previous transformation(s).\n\nTransformation list:\n");
                    Iterator<bir> it = list.iterator();
                    while (it.hasNext()) {
                        sbAppend.append(it.next().a()).append('\n');
                    }
                    bif.a.post(new Runnable() { // from class: bho.4
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new NullPointerException(sbAppend.toString());
                        }
                    });
                    return null;
                }
                if (bitmapA == bitmap2 && bitmap2.isRecycled()) {
                    bif.a.post(new Runnable() { // from class: bho.5
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new IllegalStateException("Transformation " + birVar.a() + " returned input Bitmap but recycled it.");
                        }
                    });
                    return null;
                }
                if (bitmapA == bitmap2 || bitmap2.isRecycled()) {
                    i++;
                    bitmap2 = bitmapA;
                } else {
                    bif.a.post(new Runnable() { // from class: bho.6
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new IllegalStateException("Transformation " + birVar.a() + " mutated input Bitmap but failed to recycle the original.");
                        }
                    });
                    return null;
                }
            } catch (RuntimeException e) {
                bif.a.post(new Runnable() { // from class: bho.3
                    @Override // java.lang.Runnable
                    public void run() {
                        throw new RuntimeException("Transformation " + birVar.a() + " crashed with exception.", e);
                    }
                });
                return null;
            }
        }
        return bitmap2;
    }

    static Bitmap a(bij bijVar, Bitmap bitmap, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int iCeil;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        boolean z = bijVar.l;
        Matrix matrix = new Matrix();
        if (!bijVar.f()) {
            i2 = 0;
            i3 = 0;
            i4 = height;
            i5 = width;
        } else {
            int i9 = bijVar.h;
            int i10 = bijVar.i;
            float f = bijVar.m;
            if (f != 0.0f) {
                if (bijVar.p) {
                    matrix.setRotate(f, bijVar.n, bijVar.o);
                } else {
                    matrix.setRotate(f);
                }
            }
            if (bijVar.j) {
                float f2 = i9 / width;
                float f3 = i10 / height;
                if (f2 > f3) {
                    iCeil = (int) Math.ceil((f3 / f2) * height);
                    f3 = i10 / iCeil;
                    i6 = 0;
                    i7 = (height - iCeil) / 2;
                    i8 = width;
                } else {
                    int iCeil2 = (int) Math.ceil((f2 / f3) * width);
                    f2 = i9 / iCeil2;
                    i6 = (width - iCeil2) / 2;
                    i7 = 0;
                    i8 = iCeil2;
                    iCeil = height;
                }
                if (a(z, width, height, i9, i10)) {
                    matrix.preScale(f2, f3);
                }
                i5 = i8;
                i3 = i6;
                i4 = iCeil;
                i2 = i7;
            } else if (bijVar.k) {
                float f4 = i9 / width;
                float f5 = i10 / height;
                if (f4 >= f5) {
                    f4 = f5;
                }
                if (a(z, width, height, i9, i10)) {
                    matrix.preScale(f4, f4);
                }
                i2 = 0;
                i3 = 0;
                i4 = height;
                i5 = width;
            } else {
                if ((i9 != 0 || i10 != 0) && (i9 != width || i10 != height)) {
                    float f6 = i9 != 0 ? i9 / width : i10 / height;
                    float f7 = i10 != 0 ? i10 / height : i9 / width;
                    if (a(z, width, height, i9, i10)) {
                        matrix.preScale(f6, f7);
                    }
                }
                i2 = 0;
                i3 = 0;
                i4 = height;
                i5 = width;
            }
        }
        if (i != 0) {
            matrix.preRotate(i);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i3, i2, i5, i4, matrix, true);
        if (bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
            return bitmapCreateBitmap;
        }
        return bitmap;
    }

    private static boolean a(boolean z, int i, int i2, int i3, int i4) {
        return !z || i > i3 || i2 > i4;
    }
}
