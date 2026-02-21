package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class aaf {
    private AtomicInteger a;
    private final Map<String, Queue<aac<?>>> b;
    private final Set<aac<?>> c;
    private final PriorityBlockingQueue<aac<?>> d;
    private final PriorityBlockingQueue<aac<?>> e;
    private final wl f;
    private final ym g;
    private final aao h;
    private yv[] i;
    private xc j;
    private List<a> k;

    public interface a<T> {
        void a(aac<T> aacVar);
    }

    public aaf(wl wlVar, ym ymVar) {
        this(wlVar, ymVar, 4);
    }

    public aaf(wl wlVar, ym ymVar, int i) {
        this(wlVar, ymVar, i, new xw(new Handler(Looper.getMainLooper())));
    }

    public aaf(wl wlVar, ym ymVar, int i, aao aaoVar) {
        this.a = new AtomicInteger();
        this.b = new HashMap();
        this.c = new HashSet();
        this.d = new PriorityBlockingQueue<>();
        this.e = new PriorityBlockingQueue<>();
        this.k = new ArrayList();
        this.f = wlVar;
        this.g = ymVar;
        this.i = new yv[i];
        this.h = aaoVar;
    }

    public <T> aac<T> a(aac<T> aacVar) {
        aacVar.a(this);
        synchronized (this.c) {
            this.c.add(aacVar);
        }
        aacVar.a(c());
        aacVar.b("add-to-queue");
        if (aacVar.p()) {
            synchronized (this.b) {
                String strE = aacVar.e();
                if (this.b.containsKey(strE)) {
                    Queue<aac<?>> linkedList = this.b.get(strE);
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                    }
                    linkedList.add(aacVar);
                    this.b.put(strE, linkedList);
                    if (abk.b) {
                        abk.a("Request for cacheKey=%s is in flight, putting on hold.", strE);
                    }
                } else {
                    this.b.put(strE, null);
                    this.d.add(aacVar);
                }
            }
        } else {
            this.e.add(aacVar);
        }
        return aacVar;
    }

    public void a() {
        b();
        this.j = new xc(this.d, this.e, this.f, this.h);
        this.j.start();
        for (int i = 0; i < this.i.length; i++) {
            yv yvVar = new yv(this.e, this.g, this.f, this.h);
            this.i[i] = yvVar;
            yvVar.start();
        }
    }

    public void b() {
        if (this.j != null) {
            this.j.a();
        }
        for (int i = 0; i < this.i.length; i++) {
            if (this.i[i] != null) {
                this.i[i].a();
            }
        }
    }

    <T> void b(aac<T> aacVar) {
        synchronized (this.c) {
            this.c.remove(aacVar);
        }
        synchronized (this.k) {
            Iterator<a> it = this.k.iterator();
            while (it.hasNext()) {
                it.next().a(aacVar);
            }
        }
        if (aacVar.p()) {
            synchronized (this.b) {
                String strE = aacVar.e();
                Queue<aac<?>> queueRemove = this.b.remove(strE);
                if (queueRemove != null) {
                    if (abk.b) {
                        abk.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queueRemove.size()), strE);
                    }
                    this.d.addAll(queueRemove);
                }
            }
        }
    }

    public int c() {
        return this.a.incrementAndGet();
    }
}
