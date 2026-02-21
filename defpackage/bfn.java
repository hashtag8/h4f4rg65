package defpackage;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class bfn implements Closeable {
    static final Pattern a;
    static final /* synthetic */ boolean b;
    private static final brh u;
    private final bgs c;
    private final File d;
    private final File e;
    private final File f;
    private final File g;
    private final int h;
    private long i;
    private final int j;
    private bqt l;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private final Executor s;
    private long k = 0;
    private final LinkedHashMap<String, b> m = new LinkedHashMap<>(0, 0.75f, true);
    private long r = 0;
    private final Runnable t = new Runnable() { // from class: bfn.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (bfn.this) {
                if (!((bfn.this.p ? false : true) | bfn.this.q)) {
                    try {
                        bfn.this.k();
                        if (bfn.this.i()) {
                            bfn.this.h();
                            bfn.this.n = 0;
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    };

    static {
        b = !bfn.class.desiredAssertionStatus();
        a = Pattern.compile("[a-z0-9_-]{1,120}");
        u = new brh() { // from class: bfn.3
            @Override // defpackage.brh
            public void a_(bqs bqsVar, long j) throws EOFException {
                bqsVar.g(j);
            }

            @Override // defpackage.brh, java.io.Flushable
            public void flush() {
            }

            @Override // defpackage.brh
            public brj a() {
                return brj.b;
            }

            @Override // defpackage.brh, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        };
    }

    bfn(bgs bgsVar, File file, int i, int i2, long j, Executor executor) {
        this.c = bgsVar;
        this.d = file;
        this.h = i;
        this.e = new File(file, "journal");
        this.f = new File(file, "journal.tmp");
        this.g = new File(file, "journal.bkp");
        this.j = i2;
        this.i = j;
        this.s = executor;
    }

    void a() {
        if (!b && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.p) {
            if (this.c.e(this.g)) {
                if (this.c.e(this.e)) {
                    this.c.d(this.g);
                } else {
                    this.c.a(this.g, this.e);
                }
            }
            if (this.c.e(this.e)) {
                try {
                    e();
                    g();
                    this.p = true;
                    return;
                } catch (IOException e) {
                    bfu.a().a("DiskLruCache " + this.d + " is corrupt: " + e.getMessage() + ", removing");
                    c();
                    this.q = false;
                }
            }
            h();
            this.p = true;
        }
    }

    public static bfn a(bgs bgsVar, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        return new bfn(bgsVar, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), bfw.a("OkHttp DiskLruCache", true)));
    }

    private void e() {
        bqu bquVarA = brc.a(this.c.a(this.e));
        try {
            String strR = bquVarA.r();
            String strR2 = bquVarA.r();
            String strR3 = bquVarA.r();
            String strR4 = bquVarA.r();
            String strR5 = bquVarA.r();
            if (!"libcore.io.DiskLruCache".equals(strR) || !"1".equals(strR2) || !Integer.toString(this.h).equals(strR3) || !Integer.toString(this.j).equals(strR4) || !"".equals(strR5)) {
                throw new IOException("unexpected journal header: [" + strR + ", " + strR2 + ", " + strR4 + ", " + strR5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    d(bquVarA.r());
                    i++;
                } catch (EOFException e) {
                    this.n = i - this.m.size();
                    if (!bquVarA.f()) {
                        h();
                    } else {
                        this.l = f();
                    }
                    bfw.a(bquVarA);
                    return;
                }
            }
        } catch (Throwable th) {
            bfw.a(bquVarA);
            throw th;
        }
    }

    private bqt f() {
        return brc.a(new bfo(this.c.c(this.e)) { // from class: bfn.2
            static final /* synthetic */ boolean a;

            static {
                a = !bfn.class.desiredAssertionStatus();
            }

            @Override // defpackage.bfo
            protected void a(IOException iOException) {
                if (!a && !Thread.holdsLock(bfn.this)) {
                    throw new AssertionError();
                }
                bfn.this.o = true;
            }
        });
    }

    private void d(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            String strSubstring2 = str.substring(i);
            if (iIndexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.m.remove(strSubstring2);
                return;
            }
            strSubstring = strSubstring2;
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        b bVar = this.m.get(strSubstring);
        if (bVar == null) {
            bVar = new b(strSubstring);
            this.m.put(strSubstring, bVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            bVar.f = true;
            bVar.g = null;
            bVar.a(strArrSplit);
            return;
        }
        if (iIndexOf2 != -1 || iIndexOf != "DIRTY".length() || !str.startsWith("DIRTY")) {
            if (iIndexOf2 != -1 || iIndexOf != "READ".length() || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
            return;
        }
        bVar.g = new a(bVar);
    }

    private void g() {
        this.c.d(this.f);
        Iterator<b> it = this.m.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.g == null) {
                for (int i = 0; i < this.j; i++) {
                    this.k += next.c[i];
                }
            } else {
                next.g = null;
                for (int i2 = 0; i2 < this.j; i2++) {
                    this.c.d(next.d[i2]);
                    this.c.d(next.e[i2]);
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h() {
        if (this.l != null) {
            this.l.close();
        }
        bqt bqtVarA = brc.a(this.c.b(this.f));
        try {
            bqtVarA.b("libcore.io.DiskLruCache").h(10);
            bqtVarA.b("1").h(10);
            bqtVarA.k(this.h).h(10);
            bqtVarA.k(this.j).h(10);
            bqtVarA.h(10);
            for (b bVar : this.m.values()) {
                if (bVar.g != null) {
                    bqtVarA.b("DIRTY").h(32);
                    bqtVarA.b(bVar.b);
                    bqtVarA.h(10);
                } else {
                    bqtVarA.b("CLEAN").h(32);
                    bqtVarA.b(bVar.b);
                    bVar.a(bqtVarA);
                    bqtVarA.h(10);
                }
            }
            bqtVarA.close();
            if (this.c.e(this.e)) {
                this.c.a(this.e, this.g);
            }
            this.c.a(this.f, this.e);
            this.c.d(this.g);
            this.l = f();
            this.o = false;
        } catch (Throwable th) {
            bqtVarA.close();
            throw th;
        }
    }

    public synchronized c a(String str) {
        c cVarA;
        a();
        j();
        e(str);
        b bVar = this.m.get(str);
        if (bVar == null || !bVar.f || (cVarA = bVar.a()) == null) {
            cVarA = null;
        } else {
            this.n++;
            this.l.b("READ").h(32).b(str).h(10);
            if (i()) {
                this.s.execute(this.t);
            }
        }
        return cVarA;
    }

    public a b(String str) {
        return a(str, -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized a a(String str, long j) {
        b bVar;
        a aVar;
        a();
        j();
        e(str);
        b bVar2 = this.m.get(str);
        if (j != -1 && (bVar2 == null || bVar2.h != j)) {
            aVar = null;
        } else if (bVar2 == null || bVar2.g == null) {
            this.l.b("DIRTY").h(32).b(str).h(10);
            this.l.flush();
            if (this.o) {
                aVar = null;
            } else {
                if (bVar2 == null) {
                    b bVar3 = new b(str);
                    this.m.put(str, bVar3);
                    bVar = bVar3;
                } else {
                    bVar = bVar2;
                }
                aVar = new a(bVar);
                bVar.g = aVar;
            }
        } else {
            aVar = null;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0060 A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0054, B:27:0x005c, B:29:0x0060, B:31:0x0068, B:33:0x0070, B:34:0x0094, B:35:0x0097, B:36:0x009d, B:38:0x00ae, B:40:0x00d6, B:41:0x00e0, B:43:0x00ed, B:45:0x00f3, B:46:0x00fc), top: B:48:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ae A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0054, B:27:0x005c, B:29:0x0060, B:31:0x0068, B:33:0x0070, B:34:0x0094, B:35:0x0097, B:36:0x009d, B:38:0x00ae, B:40:0x00d6, B:41:0x00e0, B:43:0x00ed, B:45:0x00f3, B:46:0x00fc), top: B:48:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f3 A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0054, B:27:0x005c, B:29:0x0060, B:31:0x0068, B:33:0x0070, B:34:0x0094, B:35:0x0097, B:36:0x009d, B:38:0x00ae, B:40:0x00d6, B:41:0x00e0, B:43:0x00ed, B:45:0x00f3, B:46:0x00fc), top: B:48:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fc A[Catch: all -> 0x0012, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0054, B:27:0x005c, B:29:0x0060, B:31:0x0068, B:33:0x0070, B:34:0x0094, B:35:0x0097, B:36:0x009d, B:38:0x00ae, B:40:0x00d6, B:41:0x00e0, B:43:0x00ed, B:45:0x00f3, B:46:0x00fc), top: B:48:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(bfn.a r11, boolean r12) {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bfn.a(bfn$a, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        return this.n >= 2000 && this.n >= this.m.size();
    }

    public synchronized boolean c(String str) {
        b bVar;
        a();
        j();
        e(str);
        bVar = this.m.get(str);
        return bVar == null ? false : a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b bVar) {
        if (bVar.g != null) {
            bVar.g.d = true;
        }
        for (int i = 0; i < this.j; i++) {
            this.c.d(bVar.d[i]);
            this.k -= bVar.c[i];
            bVar.c[i] = 0;
        }
        this.n++;
        this.l.b("REMOVE").h(32).b(bVar.b).h(10);
        this.m.remove(bVar.b);
        if (i()) {
            this.s.execute(this.t);
        }
        return true;
    }

    public synchronized boolean b() {
        return this.q;
    }

    private synchronized void j() {
        if (b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.p || this.q) {
            this.q = true;
        } else {
            for (b bVar : (b[]) this.m.values().toArray(new b[this.m.size()])) {
                if (bVar.g != null) {
                    bVar.g.b();
                }
            }
            k();
            this.l.close();
            this.l = null;
            this.q = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        while (this.k > this.i) {
            a(this.m.values().iterator().next());
        }
    }

    public void c() {
        close();
        this.c.g(this.d);
    }

    private void e(String str) {
        if (!a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public final class c implements Closeable {
        private final String b;
        private final long c;
        private final bri[] d;
        private final long[] e;

        private c(String str, long j, bri[] briVarArr, long[] jArr) {
            this.b = str;
            this.c = j;
            this.d = briVarArr;
            this.e = jArr;
        }

        public a a() {
            return bfn.this.a(this.b, this.c);
        }

        public bri a(int i) {
            return this.d[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (bri briVar : this.d) {
                bfw.a(briVar);
            }
        }
    }

    public final class a {
        private final b b;
        private final boolean[] c;
        private boolean d;
        private boolean e;

        private a(b bVar) {
            this.b = bVar;
            this.c = bVar.f ? null : new boolean[bfn.this.j];
        }

        public brh a(int i) {
            brh brhVar;
            synchronized (bfn.this) {
                if (this.b.g != this) {
                    throw new IllegalStateException();
                }
                if (!this.b.f) {
                    this.c[i] = true;
                }
                try {
                    brhVar = new bfo(bfn.this.c.b(this.b.e[i])) { // from class: bfn.a.1
                        @Override // defpackage.bfo
                        protected void a(IOException iOException) {
                            synchronized (bfn.this) {
                                a.this.d = true;
                            }
                        }
                    };
                } catch (FileNotFoundException e) {
                    brhVar = bfn.u;
                }
            }
            return brhVar;
        }

        public void a() {
            synchronized (bfn.this) {
                if (this.d) {
                    bfn.this.a(this, false);
                    bfn.this.a(this.b);
                } else {
                    bfn.this.a(this, true);
                }
                this.e = true;
            }
        }

        public void b() {
            synchronized (bfn.this) {
                bfn.this.a(this, false);
            }
        }
    }

    final class b {
        private final String b;
        private final long[] c;
        private final File[] d;
        private final File[] e;
        private boolean f;
        private a g;
        private long h;

        private b(String str) {
            this.b = str;
            this.c = new long[bfn.this.j];
            this.d = new File[bfn.this.j];
            this.e = new File[bfn.this.j];
            StringBuilder sbAppend = new StringBuilder(str).append('.');
            int length = sbAppend.length();
            for (int i = 0; i < bfn.this.j; i++) {
                sbAppend.append(i);
                this.d[i] = new File(bfn.this.d, sbAppend.toString());
                sbAppend.append(".tmp");
                this.e[i] = new File(bfn.this.d, sbAppend.toString());
                sbAppend.setLength(length);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) throws IOException {
            if (strArr.length != bfn.this.j) {
                throw b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.c[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException e) {
                    throw b(strArr);
                }
            }
        }

        void a(bqt bqtVar) {
            for (long j : this.c) {
                bqtVar.h(32).k(j);
            }
        }

        private IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        c a() {
            if (!Thread.holdsLock(bfn.this)) {
                throw new AssertionError();
            }
            bri[] briVarArr = new bri[bfn.this.j];
            long[] jArr = (long[]) this.c.clone();
            for (int i = 0; i < bfn.this.j; i++) {
                try {
                    briVarArr[i] = bfn.this.c.a(this.d[i]);
                } catch (FileNotFoundException e) {
                    for (int i2 = 0; i2 < bfn.this.j && briVarArr[i2] != null; i2++) {
                        bfw.a(briVarArr[i2]);
                    }
                    return null;
                }
            }
            return new c(this.b, this.h, briVarArr, jArr);
        }
    }
}
