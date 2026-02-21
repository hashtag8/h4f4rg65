package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import defpackage.bif;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
abstract class bhm<T> {
    final bif a;
    final bij b;
    final WeakReference<T> c;
    final boolean d;
    final int e;
    final int f;
    final int g;
    final Drawable h;
    final String i;
    final Object j;
    boolean k;
    boolean l;

    abstract void a();

    abstract void a(Bitmap bitmap, bif.d dVar);

    static class a<M> extends WeakReference<M> {
        final bhm a;

        public a(bhm bhmVar, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.a = bhmVar;
        }
    }

    bhm(bif bifVar, T t, bij bijVar, int i, int i2, int i3, Drawable drawable, String str, Object obj, boolean z) {
        this.a = bifVar;
        this.b = bijVar;
        this.c = t == null ? null : new a(this, t, bifVar.i);
        this.e = i;
        this.f = i2;
        this.d = z;
        this.g = i3;
        this.h = drawable;
        this.i = str;
        this.j = obj == null ? this : obj;
    }

    void b() {
        this.l = true;
    }

    bij c() {
        return this.b;
    }

    T d() {
        if (this.c == null) {
            return null;
        }
        return this.c.get();
    }

    String e() {
        return this.i;
    }

    boolean f() {
        return this.l;
    }

    boolean g() {
        return this.k;
    }

    int h() {
        return this.e;
    }

    int i() {
        return this.f;
    }

    bif j() {
        return this.a;
    }

    bif.e k() {
        return this.b.r;
    }

    Object l() {
        return this.j;
    }
}
