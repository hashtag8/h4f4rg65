package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ky {
    final b a;
    a b = new a();

    public interface b {
        int a();

        int a(View view);

        View a(int i);

        int b();

        int b(View view);
    }

    public ky(b bVar) {
        this.a = bVar;
    }

    static class a {
        int a = 0;
        int b;
        int c;
        int d;
        int e;

        a() {
        }

        void a(int i, int i2, int i3, int i4) {
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        void a(int i) {
            this.a |= i;
        }

        void a() {
            this.a = 0;
        }

        int a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            if (i == i2) {
                return 2;
            }
            return 4;
        }

        boolean b() {
            if ((this.a & 7) != 0 && (this.a & (a(this.d, this.b) << 0)) == 0) {
                return false;
            }
            if ((this.a & 112) != 0 && (this.a & (a(this.d, this.c) << 4)) == 0) {
                return false;
            }
            if ((this.a & 1792) == 0 || (this.a & (a(this.e, this.b) << 8)) != 0) {
                return (this.a & 28672) == 0 || (this.a & (a(this.e, this.c) << 12)) != 0;
            }
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View a(int r9, int r10, int r11, int r12) {
        /*
            r8 = this;
            ky$b r0 = r8.a
            int r3 = r0.a()
            ky$b r0 = r8.a
            int r4 = r0.b()
            if (r10 <= r9) goto L3e
            r0 = 1
        Lf:
            r2 = 0
        L10:
            if (r9 == r10) goto L57
            ky$b r1 = r8.a
            android.view.View r1 = r1.a(r9)
            ky$b r5 = r8.a
            int r5 = r5.a(r1)
            ky$b r6 = r8.a
            int r6 = r6.b(r1)
            ky$a r7 = r8.b
            r7.a(r3, r4, r5, r6)
            if (r11 == 0) goto L40
            ky$a r5 = r8.b
            r5.a()
            ky$a r5 = r8.b
            r5.a(r11)
            ky$a r5 = r8.b
            boolean r5 = r5.b()
            if (r5 == 0) goto L40
        L3d:
            return r1
        L3e:
            r0 = -1
            goto Lf
        L40:
            if (r12 == 0) goto L59
            ky$a r5 = r8.b
            r5.a()
            ky$a r5 = r8.b
            r5.a(r12)
            ky$a r5 = r8.b
            boolean r5 = r5.b()
            if (r5 == 0) goto L59
        L54:
            int r9 = r9 + r0
            r2 = r1
            goto L10
        L57:
            r1 = r2
            goto L3d
        L59:
            r1 = r2
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ky.a(int, int, int, int):android.view.View");
    }

    public boolean a(View view, int i) {
        this.b.a(this.a.a(), this.a.b(), this.a.a(view), this.a.b(view));
        if (i == 0) {
            return false;
        }
        this.b.a();
        this.b.a(i);
        return this.b.b();
    }
}
