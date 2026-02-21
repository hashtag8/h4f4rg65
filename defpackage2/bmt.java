package defpackage;

import defpackage.bms;
import defpackage.bmz;
import defpackage.bnc;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class bmt<E extends bms & bnc & bmz> extends PriorityBlockingQueue<E> {
    final Queue<E> a = new LinkedList();
    private final ReentrantLock b = new ReentrantLock();

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public E take() {
        return (E) b(0, null, null);
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public E peek() {
        try {
            return (E) b(1, null, null);
        } catch (InterruptedException e) {
            return null;
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public E poll(long j, TimeUnit timeUnit) {
        return (E) b(3, Long.valueOf(j), timeUnit);
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public E poll() {
        try {
            return (E) b(2, null, null);
        } catch (InterruptedException e) {
            return null;
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public int size() {
        try {
            this.b.lock();
            return this.a.size() + super.size();
        } finally {
            this.b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        try {
            this.b.lock();
            return (T[]) a(super.toArray(tArr), this.a.toArray(tArr));
        } finally {
            this.b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        try {
            this.b.lock();
            return a(super.toArray(), this.a.toArray());
        } finally {
            this.b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        try {
            this.b.lock();
            int iDrainTo = super.drainTo(collection) + this.a.size();
            while (!this.a.isEmpty()) {
                collection.add(this.a.poll());
            }
            return iDrainTo;
        } finally {
            this.b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        try {
            this.b.lock();
            int iDrainTo = super.drainTo(collection, i);
            while (!this.a.isEmpty() && iDrainTo <= i) {
                collection.add(this.a.poll());
                iDrainTo++;
            }
            return iDrainTo;
        } finally {
            this.b.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0013  */
    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean contains(java.lang.Object r3) {
        /*
            r2 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r2.b     // Catch: java.lang.Throwable -> L1c
            r0.lock()     // Catch: java.lang.Throwable -> L1c
            boolean r0 = super.contains(r3)     // Catch: java.lang.Throwable -> L1c
            if (r0 != 0) goto L13
            java.util.Queue<E extends bms & bnc & bmz> r0 = r2.a     // Catch: java.lang.Throwable -> L1c
            boolean r0 = r0.contains(r3)     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L1a
        L13:
            r0 = 1
        L14:
            java.util.concurrent.locks.ReentrantLock r1 = r2.b
            r1.unlock()
            return r0
        L1a:
            r0 = 0
            goto L14
        L1c:
            r0 = move-exception
            java.util.concurrent.locks.ReentrantLock r1 = r2.b
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bmt.contains(java.lang.Object):boolean");
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        try {
            this.b.lock();
            this.a.clear();
            super.clear();
        } finally {
            this.b.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0013  */
    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean remove(java.lang.Object r3) {
        /*
            r2 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r2.b     // Catch: java.lang.Throwable -> L1c
            r0.lock()     // Catch: java.lang.Throwable -> L1c
            boolean r0 = super.remove(r3)     // Catch: java.lang.Throwable -> L1c
            if (r0 != 0) goto L13
            java.util.Queue<E extends bms & bnc & bmz> r0 = r2.a     // Catch: java.lang.Throwable -> L1c
            boolean r0 = r0.remove(r3)     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L1a
        L13:
            r0 = 1
        L14:
            java.util.concurrent.locks.ReentrantLock r1 = r2.b
            r1.unlock()
            return r0
        L1a:
            r0 = 0
            goto L14
        L1c:
            r0 = move-exception
            java.util.concurrent.locks.ReentrantLock r1 = r2.b
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bmt.remove(java.lang.Object):boolean");
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        try {
            this.b.lock();
            return super.removeAll(collection) | this.a.removeAll(collection);
        } finally {
            this.b.unlock();
        }
    }

    E a(int i, Long l, TimeUnit timeUnit) {
        switch (i) {
            case 0:
                return (E) ((bms) super.take());
            case 1:
                return (E) ((bms) super.peek());
            case 2:
                return (E) ((bms) super.poll());
            case 3:
                return (E) ((bms) super.poll(l.longValue(), timeUnit));
            default:
                return null;
        }
    }

    boolean a(int i, E e) {
        try {
            this.b.lock();
            if (i == 1) {
                super.remove(e);
            }
            return this.a.offer(e);
        } finally {
            this.b.unlock();
        }
    }

    E b(int i, Long l, TimeUnit timeUnit) {
        E e;
        while (true) {
            e = (E) a(i, l, timeUnit);
            if (e == null || a(e)) {
                break;
            }
            a(i, e);
        }
        return e;
    }

    boolean a(E e) {
        return e.d();
    }

    public void d() {
        try {
            this.b.lock();
            Iterator<E> it = this.a.iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (a(next)) {
                    super.offer(next);
                    it.remove();
                }
            }
        } finally {
            this.b.unlock();
        }
    }

    <T> T[] a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2));
        System.arraycopy(tArr, 0, tArr3, 0, length);
        System.arraycopy(tArr2, 0, tArr3, length, length2);
        return tArr3;
    }
}
