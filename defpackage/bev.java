package defpackage;

import java.net.SocketException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class bev {
    private static final bev a;
    private final int b;
    private final long c;
    private final LinkedList<beu> d = new LinkedList<>();
    private Executor e = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), bfw.a("OkHttp ConnectionPool", true));
    private final Runnable f = new Runnable() { // from class: bev.1
        @Override // java.lang.Runnable
        public void run() {
            bev.this.c();
        }
    };

    static {
        String property = System.getProperty("http.keepAlive");
        String property2 = System.getProperty("http.keepAliveDuration");
        String property3 = System.getProperty("http.maxConnections");
        long j = property2 != null ? Long.parseLong(property2) : 300000L;
        if (property != null && !Boolean.parseBoolean(property)) {
            a = new bev(0, j);
        } else if (property3 != null) {
            a = new bev(Integer.parseInt(property3), j);
        } else {
            a = new bev(5, j);
        }
    }

    public bev(int i, long j) {
        this.b = i;
        this.c = j * 1000 * 1000;
    }

    public static bev a() {
        return a;
    }

    public synchronized beu a(bem bemVar) {
        beu beuVarPrevious;
        ListIterator<beu> listIterator = this.d.listIterator(this.d.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                beuVarPrevious = null;
                break;
            }
            beuVarPrevious = listIterator.previous();
            if (beuVarPrevious.c().a().equals(bemVar) && beuVarPrevious.e() && System.nanoTime() - beuVarPrevious.i() < this.c) {
                listIterator.remove();
                if (beuVarPrevious.k()) {
                    break;
                }
                try {
                    bfu.a().a(beuVarPrevious.d());
                    break;
                } catch (SocketException e) {
                    bfw.a(beuVarPrevious.d());
                    bfu.a().a("Unable to tagSocket(): " + e);
                }
            }
        }
        if (beuVarPrevious != null && beuVarPrevious.k()) {
            this.d.addFirst(beuVarPrevious);
        }
        return beuVarPrevious;
    }

    void a(beu beuVar) {
        if (!beuVar.k() && beuVar.a()) {
            if (!beuVar.e()) {
                bfw.a(beuVar.d());
                return;
            }
            try {
                bfu.a().b(beuVar.d());
                synchronized (this) {
                    c(beuVar);
                    beuVar.m();
                    beuVar.g();
                }
            } catch (SocketException e) {
                bfu.a().a("Unable to untagSocket(): " + e);
                bfw.a(beuVar.d());
            }
        }
    }

    private void c(beu beuVar) {
        boolean zIsEmpty = this.d.isEmpty();
        this.d.addFirst(beuVar);
        if (zIsEmpty) {
            this.e.execute(this.f);
        } else {
            notifyAll();
        }
    }

    void b(beu beuVar) {
        if (!beuVar.k()) {
            throw new IllegalArgumentException();
        }
        if (beuVar.e()) {
            synchronized (this) {
                c(beuVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        while (b()) {
        }
    }

    boolean b() {
        int i;
        int i2;
        long jMin;
        synchronized (this) {
            if (this.d.isEmpty()) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            long jNanoTime = System.nanoTime();
            long j = this.c;
            ListIterator<beu> listIterator = this.d.listIterator(this.d.size());
            while (listIterator.hasPrevious()) {
                beu beuVarPrevious = listIterator.previous();
                long jI = (beuVarPrevious.i() + this.c) - jNanoTime;
                if (jI <= 0 || !beuVarPrevious.e()) {
                    listIterator.remove();
                    arrayList.add(beuVarPrevious);
                    long j2 = j;
                    i2 = i3;
                    jMin = j2;
                } else if (beuVarPrevious.h()) {
                    jMin = Math.min(j, jI);
                    i2 = i3 + 1;
                } else {
                    long j3 = j;
                    i2 = i3;
                    jMin = j3;
                }
                i3 = i2;
                j = jMin;
            }
            ListIterator<beu> listIterator2 = this.d.listIterator(this.d.size());
            while (listIterator2.hasPrevious() && i3 > this.b) {
                beu beuVarPrevious2 = listIterator2.previous();
                if (beuVarPrevious2.h()) {
                    arrayList.add(beuVarPrevious2);
                    listIterator2.remove();
                    i = i3 - 1;
                } else {
                    i = i3;
                }
                i3 = i;
            }
            if (arrayList.isEmpty()) {
                try {
                    long j4 = j / 1000000;
                    wait(j4, (int) (j - (1000000 * j4)));
                    return true;
                } catch (InterruptedException e) {
                }
            }
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                bfw.a(((beu) arrayList.get(i4)).d());
            }
            return true;
        }
    }
}
