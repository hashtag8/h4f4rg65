package defpackage;

import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class jx implements Runnable {
    public static final ThreadLocal<jx> a = new ThreadLocal<>();
    static Comparator<b> e = new Comparator<b>() { // from class: jx.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            if ((bVar.d == null) != (bVar2.d == null)) {
                return bVar.d == null ? 1 : -1;
            }
            if (bVar.a != bVar2.a) {
                return bVar.a ? -1 : 1;
            }
            int i = bVar2.b - bVar.b;
            if (i == 0) {
                int i2 = bVar.c - bVar2.c;
                if (i2 == 0) {
                    return 0;
                }
                return i2;
            }
            return i;
        }
    };
    long c;
    public long d;
    ArrayList<RecyclerView> b = new ArrayList<>();
    private ArrayList<b> f = new ArrayList<>();

    static class b {
        public boolean a;
        public int b;
        public int c;
        public RecyclerView d;
        public int e;

        b() {
        }

        public void a() {
            this.a = false;
            this.b = 0;
            this.c = 0;
            this.d = null;
            this.e = 0;
        }
    }

    public static class a implements RecyclerView.h.a {
        int a;
        int b;
        int[] c;
        int d;

        void a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        void a(RecyclerView recyclerView, boolean z) {
            this.d = 0;
            if (this.c != null) {
                Arrays.fill(this.c, -1);
            }
            RecyclerView.h hVar = recyclerView.m;
            if (recyclerView.l != null && hVar != null && hVar.o()) {
                if (z) {
                    if (!recyclerView.e.d()) {
                        hVar.a(recyclerView.l.a(), this);
                    }
                } else if (!recyclerView.w()) {
                    hVar.a(this.a, this.b, recyclerView.B, this);
                }
                if (this.d > hVar.x) {
                    hVar.x = this.d;
                    hVar.y = z;
                    recyclerView.d.b();
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.h.a
        public void b(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.d * 2;
            if (this.c == null) {
                this.c = new int[4];
                Arrays.fill(this.c, -1);
            } else if (i3 >= this.c.length) {
                int[] iArr = this.c;
                this.c = new int[i3 * 2];
                System.arraycopy(iArr, 0, this.c, 0, iArr.length);
            }
            this.c[i3] = i;
            this.c[i3 + 1] = i2;
            this.d++;
        }

        public boolean a(int i) {
            if (this.c == null) {
                return false;
            }
            int i2 = this.d * 2;
            for (int i3 = 0; i3 < i2; i3 += 2) {
                if (this.c[i3] == i) {
                    return true;
                }
            }
            return false;
        }

        public void a() {
            if (this.c != null) {
                Arrays.fill(this.c, -1);
            }
            this.d = 0;
        }
    }

    public void a(RecyclerView recyclerView) {
        this.b.add(recyclerView);
    }

    public void b(RecyclerView recyclerView) {
        this.b.remove(recyclerView);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.c == 0) {
            this.c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.A.a(i, i2);
    }

    private void a() {
        b bVar;
        int i;
        int size = this.b.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            RecyclerView recyclerView = this.b.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.A.a(recyclerView, false);
                i = recyclerView.A.d + i3;
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        this.f.ensureCapacity(i3);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView2 = this.b.get(i5);
            if (recyclerView2.getWindowVisibility() == 0) {
                a aVar = recyclerView2.A;
                int iAbs = Math.abs(aVar.a) + Math.abs(aVar.b);
                int i6 = i4;
                for (int i7 = 0; i7 < aVar.d * 2; i7 += 2) {
                    if (i6 >= this.f.size()) {
                        bVar = new b();
                        this.f.add(bVar);
                    } else {
                        bVar = this.f.get(i6);
                    }
                    int i8 = aVar.c[i7 + 1];
                    bVar.a = i8 <= iAbs;
                    bVar.b = iAbs;
                    bVar.c = i8;
                    bVar.d = recyclerView2;
                    bVar.e = aVar.c[i7];
                    i6++;
                }
                i4 = i6;
            }
        }
        Collections.sort(this.f, e);
    }

    static boolean a(RecyclerView recyclerView, int i) {
        int iC = recyclerView.f.c();
        for (int i2 = 0; i2 < iC; i2++) {
            RecyclerView.v vVarE = RecyclerView.e(recyclerView.f.d(i2));
            if (vVarE.c == i && !vVarE.o()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.v a(RecyclerView recyclerView, int i, long j) {
        if (a(recyclerView, i)) {
            return null;
        }
        RecyclerView.o oVar = recyclerView.d;
        try {
            recyclerView.l();
            RecyclerView.v vVarA = oVar.a(i, false, j);
            if (vVarA != null) {
                if (vVarA.q() && !vVarA.o()) {
                    oVar.a(vVarA.a);
                } else {
                    oVar.a(vVarA, false);
                }
            }
            return vVarA;
        } finally {
            recyclerView.b(false);
        }
    }

    private void a(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.w && recyclerView.f.c() != 0) {
                recyclerView.c();
            }
            a aVar = recyclerView.A;
            aVar.a(recyclerView, true);
            if (aVar.d != 0) {
                try {
                    dq.a("RV Nested Prefetch");
                    recyclerView.B.a(recyclerView.l);
                    for (int i = 0; i < aVar.d * 2; i += 2) {
                        a(recyclerView, aVar.c[i], j);
                    }
                } finally {
                    dq.a();
                }
            }
        }
    }

    private void a(b bVar, long j) {
        RecyclerView.v vVarA = a(bVar.d, bVar.e, bVar.a ? Long.MAX_VALUE : j);
        if (vVarA != null && vVarA.b != null && vVarA.q() && !vVarA.o()) {
            a(vVarA.b.get(), j);
        }
    }

    private void b(long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f.size()) {
                b bVar = this.f.get(i2);
                if (bVar.d != null) {
                    a(bVar, j);
                    bVar.a();
                    i = i2 + 1;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    void a(long j) {
        a();
        b(j);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            dq.a("RV Prefetch");
            if (this.b.isEmpty()) {
                return;
            }
            int size = this.b.size();
            int i = 0;
            long jMax = 0;
            while (i < size) {
                RecyclerView recyclerView = this.b.get(i);
                i++;
                jMax = recyclerView.getWindowVisibility() == 0 ? Math.max(recyclerView.getDrawingTime(), jMax) : jMax;
            }
            if (jMax == 0) {
                return;
            }
            a(TimeUnit.MILLISECONDS.toNanos(jMax) + this.d);
        } finally {
            this.c = 0L;
            dq.a();
        }
    }
}
