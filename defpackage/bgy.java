package defpackage;

import android.support.v8.renderscript.Allocation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes.dex */
final class bgy {
    private static final bgw[] a = {new bgw(bgw.e, ""), new bgw(bgw.b, "GET"), new bgw(bgw.b, "POST"), new bgw(bgw.c, "/"), new bgw(bgw.c, "/index.html"), new bgw(bgw.d, HttpHost.DEFAULT_SCHEME_NAME), new bgw(bgw.d, "https"), new bgw(bgw.a, "200"), new bgw(bgw.a, "204"), new bgw(bgw.a, "206"), new bgw(bgw.a, "304"), new bgw(bgw.a, "400"), new bgw(bgw.a, "404"), new bgw(bgw.a, "500"), new bgw("accept-charset", ""), new bgw("accept-encoding", "gzip, deflate"), new bgw("accept-language", ""), new bgw("accept-ranges", ""), new bgw("accept", ""), new bgw("access-control-allow-origin", ""), new bgw("age", ""), new bgw("allow", ""), new bgw("authorization", ""), new bgw("cache-control", ""), new bgw("content-disposition", ""), new bgw("content-encoding", ""), new bgw("content-language", ""), new bgw("content-length", ""), new bgw("content-location", ""), new bgw("content-range", ""), new bgw("content-type", ""), new bgw("cookie", ""), new bgw("date", ""), new bgw("etag", ""), new bgw("expect", ""), new bgw("expires", ""), new bgw("from", ""), new bgw("host", ""), new bgw("if-match", ""), new bgw("if-modified-since", ""), new bgw("if-none-match", ""), new bgw("if-range", ""), new bgw("if-unmodified-since", ""), new bgw("last-modified", ""), new bgw("link", ""), new bgw("location", ""), new bgw("max-forwards", ""), new bgw("proxy-authenticate", ""), new bgw("proxy-authorization", ""), new bgw("range", ""), new bgw("referer", ""), new bgw("refresh", ""), new bgw("retry-after", ""), new bgw("server", ""), new bgw("set-cookie", ""), new bgw("strict-transport-security", ""), new bgw("transfer-encoding", ""), new bgw("user-agent", ""), new bgw("vary", ""), new bgw("via", ""), new bgw("www-authenticate", "")};
    private static final Map<bqv, Integer> b = c();

    static final class a {
        private final bqu f;
        private int g;
        private int h;
        private final List<bgw> e = new ArrayList();
        bgw[] a = new bgw[8];
        int b = this.a.length - 1;
        int c = 0;
        int d = 0;

        a(int i, bri briVar) {
            this.g = i;
            this.h = i;
            this.f = brc.a(briVar);
        }

        void a(int i) {
            this.g = i;
            this.h = i;
            d();
        }

        private void d() {
            if (this.h < this.d) {
                if (this.h == 0) {
                    e();
                } else {
                    b(this.d - this.h);
                }
            }
        }

        private void e() {
            this.e.clear();
            Arrays.fill(this.a, (Object) null);
            this.b = this.a.length - 1;
            this.c = 0;
            this.d = 0;
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.a.length;
                while (true) {
                    length--;
                    if (length < this.b || i <= 0) {
                        break;
                    }
                    i -= this.a[length].j;
                    this.d -= this.a[length].j;
                    this.c--;
                    i2++;
                }
                System.arraycopy(this.a, this.b + 1, this.a, this.b + 1 + i2, this.c);
                this.b += i2;
            }
            return i2;
        }

        void a() throws IOException {
            while (!this.f.f()) {
                int i = this.f.i() & 255;
                if (i == 128) {
                    throw new IOException("index == 0");
                }
                if ((i & Allocation.USAGE_SHARED) == 128) {
                    c(a(i, 127) - 1);
                } else if (i == 64) {
                    g();
                } else if ((i & 64) == 64) {
                    f(a(i, 63) - 1);
                } else if ((i & 32) == 32) {
                    this.h = a(i, 31);
                    if (this.h < 0 || this.h > this.g) {
                        throw new IOException("Invalid dynamic table size update " + this.h);
                    }
                    d();
                } else if (i == 16 || i == 0) {
                    f();
                } else {
                    e(a(i, 15) - 1);
                }
            }
        }

        public List<bgw> b() {
            ArrayList arrayList = new ArrayList(this.e);
            this.e.clear();
            return arrayList;
        }

        private void c(int i) throws IOException {
            if (h(i)) {
                this.e.add(bgy.a[i]);
                return;
            }
            int iD = d(i - bgy.a.length);
            if (iD < 0 || iD > this.a.length - 1) {
                throw new IOException("Header index too large " + (i + 1));
            }
            this.e.add(this.a[iD]);
        }

        private int d(int i) {
            return this.b + 1 + i;
        }

        private void e(int i) {
            this.e.add(new bgw(g(i), c()));
        }

        private void f() throws IOException {
            this.e.add(new bgw(bgy.b(c()), c()));
        }

        private void f(int i) {
            a(-1, new bgw(g(i), c()));
        }

        private void g() {
            a(-1, new bgw(bgy.b(c()), c()));
        }

        private bqv g(int i) {
            return h(i) ? bgy.a[i].h : this.a[d(i - bgy.a.length)].h;
        }

        private boolean h(int i) {
            return i >= 0 && i <= bgy.a.length + (-1);
        }

        private void a(int i, bgw bgwVar) {
            this.e.add(bgwVar);
            int i2 = bgwVar.j;
            if (i != -1) {
                i2 -= this.a[d(i)].j;
            }
            if (i2 > this.h) {
                e();
                return;
            }
            int iB = b((this.d + i2) - this.h);
            if (i == -1) {
                if (this.c + 1 > this.a.length) {
                    bgw[] bgwVarArr = new bgw[this.a.length * 2];
                    System.arraycopy(this.a, 0, bgwVarArr, this.a.length, this.a.length);
                    this.b = this.a.length - 1;
                    this.a = bgwVarArr;
                }
                int i3 = this.b;
                this.b = i3 - 1;
                this.a[i3] = bgwVar;
                this.c++;
            } else {
                this.a[iB + d(i) + i] = bgwVar;
            }
            this.d = i2 + this.d;
        }

        private int h() {
            return this.f.i() & 255;
        }

        int a(int i, int i2) {
            int i3 = i & i2;
            if (i3 >= i2) {
                int i4 = 0;
                while (true) {
                    int iH = h();
                    if ((iH & Allocation.USAGE_SHARED) != 0) {
                        i2 += (iH & 127) << i4;
                        i4 += 7;
                    } else {
                        return (iH << i4) + i2;
                    }
                }
            } else {
                return i3;
            }
        }

        bqv c() {
            int iH = h();
            boolean z = (iH & Allocation.USAGE_SHARED) == 128;
            int iA = a(iH, 127);
            if (z) {
                return bqv.a(bha.a().a(this.f.f(iA)));
            }
            return this.f.c(iA);
        }
    }

    private static Map<bqv, Integer> c() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(a.length);
        for (int i = 0; i < a.length; i++) {
            if (!linkedHashMap.containsKey(a[i].h)) {
                linkedHashMap.put(a[i].h, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    static final class b {
        private final bqs a;

        b(bqs bqsVar) {
            this.a = bqsVar;
        }

        void a(List<bgw> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                bqv bqvVarE = list.get(i).h.e();
                Integer num = (Integer) bgy.b.get(bqvVarE);
                if (num != null) {
                    a(num.intValue() + 1, 15, 0);
                    a(list.get(i).i);
                } else {
                    this.a.h(0);
                    a(bqvVarE);
                    a(list.get(i).i);
                }
            }
        }

        void a(int i, int i2, int i3) {
            if (i < i2) {
                this.a.h(i3 | i);
                return;
            }
            this.a.h(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.a.h((i4 & 127) | Allocation.USAGE_SHARED);
                i4 >>>= 7;
            }
            this.a.h(i4);
        }

        void a(bqv bqvVar) {
            a(bqvVar.f(), 127, 0);
            this.a.b(bqvVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static bqv b(bqv bqvVar) throws IOException {
        int iF = bqvVar.f();
        for (int i = 0; i < iF; i++) {
            byte bA = bqvVar.a(i);
            if (bA >= 65 && bA <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + bqvVar.a());
            }
        }
        return bqvVar;
    }
}
