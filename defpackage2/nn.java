package defpackage;

import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
class nn implements bne {
    final bne a;
    final Random b;
    final double c;

    public nn(bne bneVar, double d) {
        this(bneVar, d, new Random());
    }

    public nn(bne bneVar, double d, Random random) {
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        }
        if (bneVar == null) {
            throw new NullPointerException("backoff must not be null");
        }
        if (random == null) {
            throw new NullPointerException("random must not be null");
        }
        this.a = bneVar;
        this.c = d;
        this.b = random;
    }

    @Override // defpackage.bne
    public long a(int i) {
        return (long) (a() * this.a.a(i));
    }

    double a() {
        double d = 1.0d - this.c;
        return d + (((this.c + 1.0d) - d) * this.b.nextDouble());
    }
}
