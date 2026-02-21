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
public class lr {
    private AtomicInteger a;
    private final Map<String, Queue<lq<?>>> b;
    private final Set<lq<?>> c;
    private final PriorityBlockingQueue<lq<?>> d;
    private final PriorityBlockingQueue<lq<?>> e;
    private final lf f;
    private final lk g;
    private final lt h;
    private ll[] i;
    private lg j;
    private List<a> k;

    public interface a<T> {
        void a(lq<T> lqVar);
    }

    public lr(lf lfVar, lk lkVar, int i, lt ltVar) {
        this.a = new AtomicInteger();
        this.b = new HashMap();
        this.c = new HashSet();
        this.d = new PriorityBlockingQueue<>();
        this.e = new PriorityBlockingQueue<>();
        this.k = new ArrayList();
        this.f = lfVar;
        this.g = lkVar;
        this.i = new ll[i];
        this.h = ltVar;
    }

    public lr(lf lfVar, lk lkVar, int i) {
        this(lfVar, lkVar, i, new li(new Handler(Looper.getMainLooper())));
    }

    public lr(lf lfVar, lk lkVar) {
        this(lfVar, lkVar, 4);
    }

    public void a() {
        b();
        this.j = new lg(this.d, this.e, this.f, this.h);
        this.j.start();
        for (int i = 0; i < this.i.length; i++) {
            ll llVar = new ll(this.e, this.g, this.f, this.h);
            this.i[i] = llVar;
            llVar.start();
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

    public int c() {
        return this.a.incrementAndGet();
    }

    public <T> lq<T> a(lq<T> lqVar) {
        lqVar.a(this);
        synchronized (this.c) {
            this.c.add(lqVar);
        }
        lqVar.a(c());
        lqVar.a("add-to-queue");
        if (!lqVar.r()) {
            this.e.add(lqVar);
        } else {
            synchronized (this.b) {
                String strF = lqVar.f();
                if (this.b.containsKey(strF)) {
                    Queue<lq<?>> linkedList = this.b.get(strF);
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                    }
                    linkedList.add(lqVar);
                    this.b.put(strF, linkedList);
                    if (ly.b) {
                        ly.a("Request for cacheKey=%s is in flight, putting on hold.", strF);
                    }
                } else {
                    this.b.put(strF, null);
                    this.d.add(lqVar);
                }
            }
        }
        return lqVar;
    }

    <T> void b(lq<T> lqVar) {
        synchronized (this.c) {
            this.c.remove(lqVar);
        }
        synchronized (this.k) {
            Iterator<a> it = this.k.iterator();
            while (it.hasNext()) {
                it.next().a(lqVar);
            }
        }
        if (lqVar.r()) {
            synchronized (this.b) {
                String strF = lqVar.f();
                Queue<lq<?>> queueRemove = this.b.remove(strF);
                if (queueRemove != null) {
                    if (ly.b) {
                        ly.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queueRemove.size()), strF);
                    }
                    this.d.addAll(queueRemove);
                }
            }
        }
    }
}
