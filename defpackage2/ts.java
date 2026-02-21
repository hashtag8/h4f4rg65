package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class ts {
    private final long a;
    private final int b;
    private double c;
    private long d;
    private final Object e;
    private final String f;

    public ts(int i, long j, String str) {
        this.e = new Object();
        this.b = i;
        this.c = this.b;
        this.a = j;
        this.f = str;
    }

    public ts(String str) {
        this(60, 2000L, str);
    }

    public boolean a() {
        boolean z;
        synchronized (this.e) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.c < this.b) {
                double d = (jCurrentTimeMillis - this.d) / this.a;
                if (d > 0.0d) {
                    this.c = Math.min(this.b, d + this.c);
                }
            }
            this.d = jCurrentTimeMillis;
            if (this.c >= 1.0d) {
                this.c -= 1.0d;
                z = true;
            } else {
                tt.a("Excessive " + this.f + " detected; call ignored.");
                z = false;
            }
        }
        return z;
    }
}
