package defpackage;

/* JADX INFO: loaded from: classes.dex */
class gx {
    private static gx d;
    public long a;
    public long b;
    public int c;

    gx() {
    }

    static gx a() {
        if (d == null) {
            d = new gx();
        }
        return d;
    }

    public void a(long j, double d2, double d3) {
        float f = 6.24006f + (0.01720197f * ((j - 946728000000L) / 8.64E7f));
        double dSin = ((double) f) + (0.03341960161924362d * Math.sin(f)) + (3.4906598739326E-4d * Math.sin(2.0f * f)) + (5.236000106378924E-6d * Math.sin(3.0f * f)) + 1.796593063d + 3.141592653589793d;
        double dSin2 = (Math.sin(f) * 0.0053d) + ((-d3) / 360.0d) + ((double) (Math.round(((double) (r2 - 9.0E-4f)) - r6) + 9.0E-4f)) + ((-0.0069d) * Math.sin(2.0d * dSin));
        double dAsin = Math.asin(Math.sin(dSin) * Math.sin(0.4092797040939331d));
        double d4 = 0.01745329238474369d * d2;
        double dSin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(d4) * Math.sin(dAsin))) / (Math.cos(dAsin) * Math.cos(d4));
        if (dSin3 >= 1.0d) {
            this.c = 1;
            this.a = -1L;
            this.b = -1L;
        } else {
            if (dSin3 <= -1.0d) {
                this.c = 0;
                this.a = -1L;
                this.b = -1L;
                return;
            }
            float fAcos = (float) (Math.acos(dSin3) / 6.283185307179586d);
            this.a = Math.round((((double) fAcos) + dSin2) * 8.64E7d) + 946728000000L;
            this.b = Math.round((dSin2 - ((double) fAcos)) * 8.64E7d) + 946728000000L;
            if (this.b < j && this.a > j) {
                this.c = 0;
            } else {
                this.c = 1;
            }
        }
    }
}
