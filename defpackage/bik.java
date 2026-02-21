package defpackage;

import android.app.Notification;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.RemoteViews;
import defpackage.bif;
import defpackage.bii;
import defpackage.bij;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class bik {
    private static final AtomicInteger a = new AtomicInteger();
    private final bif b;
    private final bij.a c;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private int j;
    private Drawable k;
    private Drawable l;
    private Object m;

    bik(bif bifVar, Uri uri, int i) {
        this.f = true;
        if (bifVar.m) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.b = bifVar;
        this.c = new bij.a(uri, i, bifVar.j);
    }

    bik() {
        this.f = true;
        this.b = null;
        this.c = new bij.a(null, 0, null);
    }

    public bik a(int i) {
        if (!this.f) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        }
        if (i == 0) {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        }
        if (this.k != null) {
            throw new IllegalStateException("Placeholder image already set.");
        }
        this.g = i;
        return this;
    }

    public bik b(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Error image resource invalid.");
        }
        if (this.l != null) {
            throw new IllegalStateException("Error image already set.");
        }
        this.h = i;
        return this;
    }

    public bik a(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Tag invalid.");
        }
        if (this.m != null) {
            throw new IllegalStateException("Tag already set.");
        }
        this.m = obj;
        return this;
    }

    public bik a() {
        this.e = true;
        return this;
    }

    bik b() {
        this.e = false;
        return this;
    }

    public bik a(int i, int i2) {
        Resources resources = this.b.c.getResources();
        return b(resources.getDimensionPixelSize(i), resources.getDimensionPixelSize(i2));
    }

    public bik b(int i, int i2) {
        this.c.a(i, i2);
        return this;
    }

    public bik c() {
        this.c.c();
        return this;
    }

    public bik d() {
        this.c.d();
        return this;
    }

    public bik e() {
        this.c.e();
        return this;
    }

    public bik a(Bitmap.Config config) {
        this.c.a(config);
        return this;
    }

    public bik a(bir birVar) {
        this.c.a(birVar);
        return this;
    }

    public bik a(bib bibVar, bib... bibVarArr) {
        if (bibVar == null) {
            throw new IllegalArgumentException("Memory policy cannot be null.");
        }
        this.i |= bibVar.c;
        if (bibVarArr == null) {
            throw new IllegalArgumentException("Memory policy cannot be null.");
        }
        if (bibVarArr.length > 0) {
            for (bib bibVar2 : bibVarArr) {
                if (bibVar2 == null) {
                    throw new IllegalArgumentException("Memory policy cannot be null.");
                }
                this.i = bibVar2.c | this.i;
            }
        }
        return this;
    }

    public bik f() {
        this.d = true;
        return this;
    }

    public void a(bip bipVar) {
        Bitmap bitmapB;
        long jNanoTime = System.nanoTime();
        bit.a();
        if (bipVar == null) {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (this.e) {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
        if (!this.c.a()) {
            this.b.a(bipVar);
            bipVar.b(this.f ? g() : null);
            return;
        }
        bij bijVarA = a(jNanoTime);
        String strA = bit.a(bijVarA);
        if (bib.a(this.i) && (bitmapB = this.b.b(strA)) != null) {
            this.b.a(bipVar);
            bipVar.a(bitmapB, bif.d.MEMORY);
        } else {
            bipVar.b(this.f ? g() : null);
            this.b.a((bhm) new biq(this.b, bipVar, bijVarA, this.i, this.j, this.l, strA, this.m, this.h));
        }
    }

    public void a(RemoteViews remoteViews, int i, int i2, Notification notification) {
        long jNanoTime = System.nanoTime();
        if (remoteViews == null) {
            throw new IllegalArgumentException("RemoteViews must not be null.");
        }
        if (notification == null) {
            throw new IllegalArgumentException("Notification must not be null.");
        }
        if (this.e) {
            throw new IllegalStateException("Fit cannot be used with RemoteViews.");
        }
        if (this.k != null || this.g != 0 || this.l != null) {
            throw new IllegalArgumentException("Cannot use placeholder or error drawables with remote views.");
        }
        bij bijVarA = a(jNanoTime);
        a((bii) new bii.a(this.b, bijVarA, remoteViews, i, i2, notification, this.i, this.j, bit.a(bijVarA, new StringBuilder()), this.m, this.h));
    }

    public void a(ImageView imageView) {
        a(imageView, (bhq) null);
    }

    public void a(ImageView imageView, bhq bhqVar) {
        Bitmap bitmapB;
        long jNanoTime = System.nanoTime();
        bit.a();
        if (imageView == null) {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (!this.c.a()) {
            this.b.a(imageView);
            if (this.f) {
                big.a(imageView, g());
                return;
            }
            return;
        }
        if (this.e) {
            if (this.c.b()) {
                throw new IllegalStateException("Fit cannot be used with resize.");
            }
            int width = imageView.getWidth();
            int height = imageView.getHeight();
            if (width == 0 || height == 0) {
                if (this.f) {
                    big.a(imageView, g());
                }
                this.b.a(imageView, new bht(this, imageView, bhqVar));
                return;
            }
            this.c.a(width, height);
        }
        bij bijVarA = a(jNanoTime);
        String strA = bit.a(bijVarA);
        if (bib.a(this.i) && (bitmapB = this.b.b(strA)) != null) {
            this.b.a(imageView);
            big.a(imageView, this.b.c, bitmapB, bif.d.MEMORY, this.d, this.b.k);
            if (this.b.l) {
                bit.a("Main", "completed", bijVarA.b(), "from " + bif.d.MEMORY);
            }
            if (bhqVar != null) {
                bhqVar.a();
                return;
            }
            return;
        }
        if (this.f) {
            big.a(imageView, g());
        }
        this.b.a((bhm) new bhx(this.b, imageView, bijVarA, this.i, this.j, this.h, this.l, strA, this.m, bhqVar, this.d));
    }

    private Drawable g() {
        return this.g != 0 ? this.b.c.getResources().getDrawable(this.g) : this.k;
    }

    private bij a(long j) {
        int andIncrement = a.getAndIncrement();
        bij bijVarF = this.c.f();
        bijVarF.a = andIncrement;
        bijVarF.b = j;
        boolean z = this.b.l;
        if (z) {
            bit.a("Main", "created", bijVarF.b(), bijVarF.toString());
        }
        bij bijVarA = this.b.a(bijVarF);
        if (bijVarA != bijVarF) {
            bijVarA.a = andIncrement;
            bijVarA.b = j;
            if (z) {
                bit.a("Main", "changed", bijVarA.a(), "into " + bijVarA);
            }
        }
        return bijVarA;
    }

    private void a(bii biiVar) {
        Bitmap bitmapB;
        if (bib.a(this.i) && (bitmapB = this.b.b(biiVar.e())) != null) {
            biiVar.a(bitmapB, bif.d.MEMORY);
            return;
        }
        if (this.g != 0) {
            biiVar.a(this.g);
        }
        this.b.a((bhm) biiVar);
    }
}
