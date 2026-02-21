package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class brg {
    static brf a;
    static long b;

    private brg() {
    }

    static brf a() {
        synchronized (brg.class) {
            if (a != null) {
                brf brfVar = a;
                a = brfVar.f;
                brfVar.f = null;
                b -= 2048;
                return brfVar;
            }
            return new brf();
        }
    }

    static void a(brf brfVar) {
        if (brfVar.f != null || brfVar.g != null) {
            throw new IllegalArgumentException();
        }
        if (!brfVar.d) {
            synchronized (brg.class) {
                if (b + 2048 <= 65536) {
                    b += 2048;
                    brfVar.f = a;
                    brfVar.c = 0;
                    brfVar.b = 0;
                    a = brfVar;
                }
            }
        }
    }
}
