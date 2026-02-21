package defpackage;

import defpackage.rp;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class rk extends rp.a {
    private long b;
    private Object c = new Object();
    private final Random a = new Random();

    public rk() {
        a();
    }

    public void a() {
        synchronized (this.c) {
            int i = 3;
            long jNextInt = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                jNextInt = ((long) this.a.nextInt()) + 2147483648L;
                if (jNextInt != this.b && jNextInt != 0) {
                    break;
                }
            }
            this.b = jNextInt;
        }
    }

    @Override // defpackage.rp
    public long b() {
        return this.b;
    }
}
