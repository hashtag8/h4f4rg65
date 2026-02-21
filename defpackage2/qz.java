package defpackage;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public final class qz {
    public static final qz a = new qz(320, 50, "320x50_mb");
    public static final qz b = new qz(468, 60, "468x60_as");
    public static final qz c = new qz(320, 100, "320x100_as");
    public static final qz d = new qz(728, 90, "728x90_as");
    public static final qz e = new qz(HttpStatus.SC_MULTIPLE_CHOICES, 250, "300x250_as");
    public static final qz f = new qz(160, 600, "160x600_as");
    public static final qz g = new qz(-1, -2, "smart_banner");
    private final int h;
    private final int i;
    private final String j;

    public qz(int i, int i2) {
        this(i, i2, (i == -1 ? "FULL" : String.valueOf(i)) + "x" + (i2 == -2 ? "AUTO" : String.valueOf(i2)) + "_as");
    }

    qz(int i, int i2, String str) {
        if (i < 0 && i != -1) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i);
        }
        if (i2 < 0 && i2 != -2) {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i2);
        }
        this.h = i;
        this.i = i2;
        this.j = str;
    }

    public int a() {
        return this.i;
    }

    public int a(Context context) {
        return this.i == -2 ? AdSizeParcel.b(context.getResources().getDisplayMetrics()) : rj.a().a(context, this.i);
    }

    public int b() {
        return this.h;
    }

    public int b(Context context) {
        return this.h == -1 ? AdSizeParcel.a(context.getResources().getDisplayMetrics()) : rj.a().a(context, this.h);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof qz)) {
            return false;
        }
        qz qzVar = (qz) obj;
        return this.h == qzVar.h && this.i == qzVar.i && this.j.equals(qzVar.j);
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public String toString() {
        return this.j;
    }
}
