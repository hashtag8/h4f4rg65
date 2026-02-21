package defpackage;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public class bjz<E> {
    private AtomicReference<E> a = new AtomicReference<>();
    private ReentrantReadWriteLock b = new ReentrantReadWriteLock();
    private List<bjx<E>> c;

    public bjz() {
        this.c = null;
        this.c = new LinkedList();
    }

    public E a() {
        this.b.readLock().lock();
        E e = this.a.get();
        this.b.readLock().unlock();
        return e;
    }

    public void a(E e) {
        this.b.writeLock().lock();
        this.a.set(e);
        this.b.readLock().lock();
        this.b.writeLock().unlock();
        b(e);
        this.b.readLock().unlock();
    }

    protected void b(E e) {
        Iterator<bjx<E>> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a(e);
        }
    }
}
