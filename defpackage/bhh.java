package defpackage;

import defpackage.bgu;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes.dex */
public final class bhh implements Closeable {
    static final /* synthetic */ boolean k;
    private static final ExecutorService l;
    final bff a;
    final boolean b;
    long c;
    long d;
    final bhf e;
    final bhf f;
    final bhj g;
    final Socket h;
    final bgv i;
    final b j;
    private final bhb m;
    private final Map<Integer, bhi> n;
    private final String o;
    private int p;
    private int q;
    private boolean r;
    private long s;
    private final ExecutorService t;
    private Map<Integer, bhd> u;
    private final bhe v;
    private int w;
    private boolean x;
    private final Set<Integer> y;

    static {
        k = !bhh.class.desiredAssertionStatus();
        l = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), bfw.a("OkHttp SpdyConnection", true));
    }

    private bhh(a aVar) {
        this.n = new HashMap();
        this.s = System.nanoTime();
        this.c = 0L;
        this.e = new bhf();
        this.f = new bhf();
        this.x = false;
        this.y = new LinkedHashSet();
        this.a = aVar.d;
        this.v = aVar.e;
        this.b = aVar.f;
        this.m = aVar.c;
        this.q = aVar.f ? 1 : 2;
        if (aVar.f && this.a == bff.HTTP_2) {
            this.q += 2;
        }
        this.w = aVar.f ? 1 : 2;
        if (aVar.f) {
            this.e.a(7, 0, 16777216);
        }
        this.o = aVar.a;
        if (this.a == bff.HTTP_2) {
            this.g = new bgz();
            this.t = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), bfw.a(String.format("OkHttp %s Push Observer", this.o), true));
            this.f.a(7, 0, 65535);
            this.f.a(5, 0, 16384);
        } else if (this.a == bff.SPDY_3) {
            this.g = new bhg();
            this.t = null;
        } else {
            throw new AssertionError(this.a);
        }
        this.d = this.f.e(65536);
        this.h = aVar.b;
        this.i = this.g.a(brc.a(brc.a(aVar.b)), this.b);
        this.j = new b();
        new Thread(this.j).start();
    }

    public bff a() {
        return this.a;
    }

    synchronized bhi a(int i) {
        return this.n.get(Integer.valueOf(i));
    }

    synchronized bhi b(int i) {
        bhi bhiVarRemove;
        bhiVarRemove = this.n.remove(Integer.valueOf(i));
        if (bhiVarRemove != null && this.n.isEmpty()) {
            a(true);
        }
        notifyAll();
        return bhiVarRemove;
    }

    private synchronized void a(boolean z) {
        this.s = z ? System.nanoTime() : Long.MAX_VALUE;
    }

    public synchronized boolean b() {
        return this.s != Long.MAX_VALUE;
    }

    public synchronized long c() {
        return this.s;
    }

    public bhi a(List<bgw> list, boolean z, boolean z2) {
        return a(0, list, z, z2);
    }

    private bhi a(int i, List<bgw> list, boolean z, boolean z2) {
        int i2;
        bhi bhiVar;
        boolean z3 = !z;
        boolean z4 = z2 ? false : true;
        synchronized (this.i) {
            synchronized (this) {
                if (this.r) {
                    throw new IOException("shutdown");
                }
                i2 = this.q;
                this.q += 2;
                bhiVar = new bhi(i2, this, z3, z4, list);
                if (bhiVar.b()) {
                    this.n.put(Integer.valueOf(i2), bhiVar);
                    a(false);
                }
            }
            if (i == 0) {
                this.i.a(z3, z4, i2, i, list);
            } else {
                if (this.b) {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
                this.i.a(i, i2, list);
            }
        }
        if (!z) {
            this.i.b();
        }
        return bhiVar;
    }

    public void a(int i, boolean z, bqs bqsVar, long j) {
        int iMin;
        if (j == 0) {
            this.i.a(z, i, bqsVar, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (this.d <= 0) {
                    try {
                        if (!this.n.containsKey(Integer.valueOf(i))) {
                            throw new IOException("stream closed");
                        }
                        wait();
                    } catch (InterruptedException e) {
                        throw new InterruptedIOException();
                    }
                }
                iMin = Math.min((int) Math.min(j, this.d), this.i.c());
                this.d -= (long) iMin;
            }
            j -= (long) iMin;
            this.i.a(z && j == 0, i, bqsVar, iMin);
        }
    }

    void a(long j) {
        this.d += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void a(final int i, final bgt bgtVar) {
        l.submit(new bfr("OkHttp %s stream %d", new Object[]{this.o, Integer.valueOf(i)}) { // from class: bhh.1
            @Override // defpackage.bfr
            public void a() {
                try {
                    bhh.this.b(i, bgtVar);
                } catch (IOException e) {
                }
            }
        });
    }

    void b(int i, bgt bgtVar) {
        this.i.a(i, bgtVar);
    }

    void a(final int i, final long j) {
        l.execute(new bfr("OkHttp Window Update %s stream %d", new Object[]{this.o, Integer.valueOf(i)}) { // from class: bhh.2
            @Override // defpackage.bfr
            public void a() {
                try {
                    bhh.this.i.a(i, j);
                } catch (IOException e) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final int i, final int i2, final bhd bhdVar) {
        l.execute(new bfr("OkHttp %s ping %08x%08x", new Object[]{this.o, Integer.valueOf(i), Integer.valueOf(i2)}) { // from class: bhh.3
            @Override // defpackage.bfr
            public void a() {
                try {
                    bhh.this.b(z, i, i2, bhdVar);
                } catch (IOException e) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, int i, int i2, bhd bhdVar) {
        synchronized (this.i) {
            if (bhdVar != null) {
                bhdVar.a();
                this.i.a(z, i, i2);
            } else {
                this.i.a(z, i, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized bhd c(int i) {
        return this.u != null ? this.u.remove(Integer.valueOf(i)) : null;
    }

    public void d() {
        this.i.b();
    }

    public void a(bgt bgtVar) {
        synchronized (this.i) {
            synchronized (this) {
                if (!this.r) {
                    this.r = true;
                    this.i.a(this.p, bgtVar, bfw.a);
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(bgt.NO_ERROR, bgt.CANCEL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bgt bgtVar, bgt bgtVar2) throws IOException {
        IOException iOException;
        bhi[] bhiVarArr;
        bhd[] bhdVarArr;
        if (!k && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        try {
            a(bgtVar);
            iOException = null;
        } catch (IOException e) {
            iOException = e;
        }
        synchronized (this) {
            if (this.n.isEmpty()) {
                bhiVarArr = null;
            } else {
                bhi[] bhiVarArr2 = (bhi[]) this.n.values().toArray(new bhi[this.n.size()]);
                this.n.clear();
                a(false);
                bhiVarArr = bhiVarArr2;
            }
            if (this.u != null) {
                bhd[] bhdVarArr2 = (bhd[]) this.u.values().toArray(new bhd[this.u.size()]);
                this.u = null;
                bhdVarArr = bhdVarArr2;
            } else {
                bhdVarArr = null;
            }
        }
        if (bhiVarArr != null) {
            IOException iOException2 = iOException;
            for (bhi bhiVar : bhiVarArr) {
                try {
                    bhiVar.a(bgtVar2);
                } catch (IOException e2) {
                    if (iOException2 != null) {
                        iOException2 = e2;
                    }
                }
            }
            iOException = iOException2;
        }
        if (bhdVarArr != null) {
            for (bhd bhdVar : bhdVarArr) {
                bhdVar.c();
            }
        }
        try {
            this.i.close();
            e = iOException;
        } catch (IOException e3) {
            e = e3;
            if (iOException != null) {
                e = iOException;
            }
        }
        try {
            this.h.close();
        } catch (IOException e4) {
            e = e4;
        }
        if (e != null) {
            throw e;
        }
    }

    public void e() {
        this.i.a();
        this.i.b(this.e);
        if (this.e.e(65536) != 65536) {
            this.i.a(0, r0 - 65536);
        }
    }

    public static class a {
        private String a;
        private Socket b;
        private bhb c = bhb.a;
        private bff d = bff.SPDY_3;
        private bhe e = bhe.a;
        private boolean f;

        public a(String str, boolean z, Socket socket) {
            this.a = str;
            this.f = z;
            this.b = socket;
        }

        public a a(bff bffVar) {
            this.d = bffVar;
            return this;
        }

        public bhh a() {
            return new bhh(this);
        }
    }

    class b extends bfr implements bgu.a {
        bgu b;

        private b() {
            super("OkHttp %s", bhh.this.o);
        }

        @Override // defpackage.bfr
        protected void a() throws Throwable {
            bgt bgtVar;
            bgt bgtVar2 = bgt.INTERNAL_ERROR;
            bgt bgtVar3 = bgt.INTERNAL_ERROR;
            try {
                try {
                    this.b = bhh.this.g.a(brc.a(brc.b(bhh.this.h)), bhh.this.b);
                    if (!bhh.this.b) {
                        this.b.a();
                    }
                    while (this.b.a(this)) {
                    }
                    bgtVar2 = bgt.NO_ERROR;
                    try {
                        bhh.this.a(bgtVar2, bgt.CANCEL);
                    } catch (IOException e) {
                    }
                    bfw.a(this.b);
                } catch (IOException e2) {
                    bgtVar = bgt.PROTOCOL_ERROR;
                    try {
                        try {
                            bhh.this.a(bgtVar, bgt.PROTOCOL_ERROR);
                        } catch (IOException e3) {
                        }
                        bfw.a(this.b);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            bhh.this.a(bgtVar, bgtVar3);
                        } catch (IOException e4) {
                        }
                        bfw.a(this.b);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                bgtVar = bgtVar2;
                th = th2;
                bhh.this.a(bgtVar, bgtVar3);
                bfw.a(this.b);
                throw th;
            }
        }

        @Override // bgu.a
        public void a(boolean z, int i, bqu bquVar, int i2) throws IOException {
            if (bhh.this.d(i)) {
                bhh.this.a(i, bquVar, i2, z);
                return;
            }
            bhi bhiVarA = bhh.this.a(i);
            if (bhiVarA == null) {
                bhh.this.a(i, bgt.INVALID_STREAM);
                bquVar.g(i2);
            } else {
                bhiVarA.a(bquVar, i2);
                if (z) {
                    bhiVarA.h();
                }
            }
        }

        @Override // bgu.a
        public void a(boolean z, boolean z2, int i, int i2, List<bgw> list, bgx bgxVar) {
            if (bhh.this.d(i)) {
                bhh.this.a(i, list, z2);
                return;
            }
            synchronized (bhh.this) {
                if (!bhh.this.r) {
                    bhi bhiVarA = bhh.this.a(i);
                    if (bhiVarA == null) {
                        if (!bgxVar.a()) {
                            if (i > bhh.this.p) {
                                if (i % 2 != bhh.this.q % 2) {
                                    final bhi bhiVar = new bhi(i, bhh.this, z, z2, list);
                                    bhh.this.p = i;
                                    bhh.this.n.put(Integer.valueOf(i), bhiVar);
                                    bhh.l.execute(new bfr("OkHttp %s stream %d", new Object[]{bhh.this.o, Integer.valueOf(i)}) { // from class: bhh.b.1
                                        @Override // defpackage.bfr
                                        public void a() {
                                            try {
                                                bhh.this.m.a(bhiVar);
                                            } catch (IOException e) {
                                                bfp.a.log(Level.INFO, "StreamHandler failure for " + bhh.this.o, (Throwable) e);
                                                try {
                                                    bhiVar.a(bgt.PROTOCOL_ERROR);
                                                } catch (IOException e2) {
                                                }
                                            }
                                        }
                                    });
                                }
                            }
                        } else {
                            bhh.this.a(i, bgt.INVALID_STREAM);
                        }
                    } else if (bgxVar.b()) {
                        bhiVarA.b(bgt.PROTOCOL_ERROR);
                        bhh.this.b(i);
                    } else {
                        bhiVarA.a(list, bgxVar);
                        if (z2) {
                            bhiVarA.h();
                        }
                    }
                }
            }
        }

        @Override // bgu.a
        public void a(int i, bgt bgtVar) {
            if (bhh.this.d(i)) {
                bhh.this.c(i, bgtVar);
                return;
            }
            bhi bhiVarB = bhh.this.b(i);
            if (bhiVarB != null) {
                bhiVarB.c(bgtVar);
            }
        }

        @Override // bgu.a
        public void a(boolean z, bhf bhfVar) {
            bhi[] bhiVarArr;
            long j;
            synchronized (bhh.this) {
                int iE = bhh.this.f.e(65536);
                if (z) {
                    bhh.this.f.a();
                }
                bhh.this.f.a(bhfVar);
                if (bhh.this.a() == bff.HTTP_2) {
                    a(bhfVar);
                }
                int iE2 = bhh.this.f.e(65536);
                if (iE2 == -1 || iE2 == iE) {
                    bhiVarArr = null;
                    j = 0;
                } else {
                    j = iE2 - iE;
                    if (!bhh.this.x) {
                        bhh.this.a(j);
                        bhh.this.x = true;
                    }
                    bhiVarArr = !bhh.this.n.isEmpty() ? (bhi[]) bhh.this.n.values().toArray(new bhi[bhh.this.n.size()]) : null;
                }
            }
            if (bhiVarArr != null && j != 0) {
                for (bhi bhiVar : bhiVarArr) {
                    synchronized (bhiVar) {
                        bhiVar.a(j);
                    }
                }
            }
        }

        private void a(final bhf bhfVar) {
            bhh.l.execute(new bfr("OkHttp %s ACK Settings", new Object[]{bhh.this.o}) { // from class: bhh.b.2
                @Override // defpackage.bfr
                public void a() {
                    try {
                        bhh.this.i.a(bhfVar);
                    } catch (IOException e) {
                    }
                }
            });
        }

        @Override // bgu.a
        public void b() {
        }

        @Override // bgu.a
        public void a(boolean z, int i, int i2) {
            if (z) {
                bhd bhdVarC = bhh.this.c(i);
                if (bhdVarC != null) {
                    bhdVarC.b();
                    return;
                }
                return;
            }
            bhh.this.a(true, i, i2, (bhd) null);
        }

        @Override // bgu.a
        public void a(int i, bgt bgtVar, bqv bqvVar) {
            bhi[] bhiVarArr;
            if (bqvVar.f() > 0) {
            }
            synchronized (bhh.this) {
                bhiVarArr = (bhi[]) bhh.this.n.values().toArray(new bhi[bhh.this.n.size()]);
                bhh.this.r = true;
            }
            for (bhi bhiVar : bhiVarArr) {
                if (bhiVar.a() > i && bhiVar.c()) {
                    bhiVar.c(bgt.REFUSED_STREAM);
                    bhh.this.b(bhiVar.a());
                }
            }
        }

        @Override // bgu.a
        public void a(int i, long j) {
            if (i == 0) {
                synchronized (bhh.this) {
                    bhh.this.d += j;
                    bhh.this.notifyAll();
                }
                return;
            }
            bhi bhiVarA = bhh.this.a(i);
            if (bhiVarA != null) {
                synchronized (bhiVarA) {
                    bhiVarA.a(j);
                }
            }
        }

        @Override // bgu.a
        public void a(int i, int i2, int i3, boolean z) {
        }

        @Override // bgu.a
        public void a(int i, int i2, List<bgw> list) {
            bhh.this.a(i2, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(int i) {
        return this.a == bff.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i, final List<bgw> list) {
        synchronized (this) {
            if (this.y.contains(Integer.valueOf(i))) {
                a(i, bgt.PROTOCOL_ERROR);
            } else {
                this.y.add(Integer.valueOf(i));
                this.t.execute(new bfr("OkHttp %s Push Request[%s]", new Object[]{this.o, Integer.valueOf(i)}) { // from class: bhh.4
                    @Override // defpackage.bfr
                    public void a() {
                        if (bhh.this.v.a(i, list)) {
                            try {
                                bhh.this.i.a(i, bgt.CANCEL);
                                synchronized (bhh.this) {
                                    bhh.this.y.remove(Integer.valueOf(i));
                                }
                            } catch (IOException e) {
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i, final List<bgw> list, final boolean z) {
        this.t.execute(new bfr("OkHttp %s Push Headers[%s]", new Object[]{this.o, Integer.valueOf(i)}) { // from class: bhh.5
            @Override // defpackage.bfr
            public void a() {
                boolean zA = bhh.this.v.a(i, list, z);
                if (zA) {
                    try {
                        bhh.this.i.a(i, bgt.CANCEL);
                    } catch (IOException e) {
                        return;
                    }
                }
                if (zA || z) {
                    synchronized (bhh.this) {
                        bhh.this.y.remove(Integer.valueOf(i));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i, bqu bquVar, final int i2, final boolean z) throws IOException {
        final bqs bqsVar = new bqs();
        bquVar.a(i2);
        bquVar.a(bqsVar, i2);
        if (bqsVar.b() != i2) {
            throw new IOException(bqsVar.b() + " != " + i2);
        }
        this.t.execute(new bfr("OkHttp %s Push Data[%s]", new Object[]{this.o, Integer.valueOf(i)}) { // from class: bhh.6
            @Override // defpackage.bfr
            public void a() {
                try {
                    boolean zA = bhh.this.v.a(i, bqsVar, i2, z);
                    if (zA) {
                        bhh.this.i.a(i, bgt.CANCEL);
                    }
                    if (zA || z) {
                        synchronized (bhh.this) {
                            bhh.this.y.remove(Integer.valueOf(i));
                        }
                    }
                } catch (IOException e) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final int i, final bgt bgtVar) {
        this.t.execute(new bfr("OkHttp %s Push Reset[%s]", new Object[]{this.o, Integer.valueOf(i)}) { // from class: bhh.7
            @Override // defpackage.bfr
            public void a() {
                bhh.this.v.a(i, bgtVar);
                synchronized (bhh.this) {
                    bhh.this.y.remove(Integer.valueOf(i));
                }
            }
        });
    }
}
