package defpackage;

import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: loaded from: classes.dex */
public final class bey {
    private int a = 64;
    private int b = 5;
    private final Deque<Object> c = new ArrayDeque();
    private final Deque<Object> d = new ArrayDeque();
    private final Deque<beq> e = new ArrayDeque();

    synchronized void a(beq beqVar) {
        this.e.add(beqVar);
    }

    synchronized void b(beq beqVar) {
        if (!this.e.remove(beqVar)) {
            throw new AssertionError("Call wasn't in-flight!");
        }
    }
}
