package defpackage;

import android.support.v7.widget.RecyclerView;
import defpackage.ee;

/* JADX INFO: loaded from: classes.dex */
public class kz {
    final du<RecyclerView.v, a> a = new du<>();
    final dz<RecyclerView.v> b = new dz<>();

    public interface b {
        void a(RecyclerView.v vVar);

        void a(RecyclerView.v vVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2);

        void b(RecyclerView.v vVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2);

        void c(RecyclerView.v vVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2);
    }

    public void a() {
        this.a.clear();
        this.b.c();
    }

    public void a(RecyclerView.v vVar, RecyclerView.e.c cVar) {
        a aVarA = this.a.get(vVar);
        if (aVarA == null) {
            aVarA = a.a();
            this.a.put(vVar, aVarA);
        }
        aVarA.b = cVar;
        aVarA.a |= 4;
    }

    public boolean a(RecyclerView.v vVar) {
        a aVar = this.a.get(vVar);
        return (aVar == null || (aVar.a & 1) == 0) ? false : true;
    }

    public RecyclerView.e.c b(RecyclerView.v vVar) {
        return a(vVar, 4);
    }

    public RecyclerView.e.c c(RecyclerView.v vVar) {
        return a(vVar, 8);
    }

    private RecyclerView.e.c a(RecyclerView.v vVar, int i) {
        a aVarC;
        RecyclerView.e.c cVar = null;
        int iA = this.a.a(vVar);
        if (iA >= 0 && (aVarC = this.a.c(iA)) != null && (aVarC.a & i) != 0) {
            aVarC.a &= i ^ (-1);
            if (i == 4) {
                cVar = aVarC.b;
            } else if (i == 8) {
                cVar = aVarC.c;
            } else {
                throw new IllegalArgumentException("Must provide flag PRE or POST");
            }
            if ((aVarC.a & 12) == 0) {
                this.a.d(iA);
                a.a(aVarC);
            }
        }
        return cVar;
    }

    public void a(long j, RecyclerView.v vVar) {
        this.b.b(j, vVar);
    }

    public void b(RecyclerView.v vVar, RecyclerView.e.c cVar) {
        a aVarA = this.a.get(vVar);
        if (aVarA == null) {
            aVarA = a.a();
            this.a.put(vVar, aVarA);
        }
        aVarA.a |= 2;
        aVarA.b = cVar;
    }

    public boolean d(RecyclerView.v vVar) {
        a aVar = this.a.get(vVar);
        return (aVar == null || (aVar.a & 4) == 0) ? false : true;
    }

    public RecyclerView.v a(long j) {
        return this.b.a(j);
    }

    public void c(RecyclerView.v vVar, RecyclerView.e.c cVar) {
        a aVarA = this.a.get(vVar);
        if (aVarA == null) {
            aVarA = a.a();
            this.a.put(vVar, aVarA);
        }
        aVarA.c = cVar;
        aVarA.a |= 8;
    }

    public void e(RecyclerView.v vVar) {
        a aVarA = this.a.get(vVar);
        if (aVarA == null) {
            aVarA = a.a();
            this.a.put(vVar, aVarA);
        }
        aVarA.a |= 1;
    }

    public void f(RecyclerView.v vVar) {
        a aVar = this.a.get(vVar);
        if (aVar != null) {
            aVar.a &= -2;
        }
    }

    public void a(b bVar) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            RecyclerView.v vVarB = this.a.b(size);
            a aVarD = this.a.d(size);
            if ((aVarD.a & 3) == 3) {
                bVar.a(vVarB);
            } else if ((aVarD.a & 1) != 0) {
                if (aVarD.b == null) {
                    bVar.a(vVarB);
                } else {
                    bVar.a(vVarB, aVarD.b, aVarD.c);
                }
            } else if ((aVarD.a & 14) == 14) {
                bVar.b(vVarB, aVarD.b, aVarD.c);
            } else if ((aVarD.a & 12) == 12) {
                bVar.c(vVarB, aVarD.b, aVarD.c);
            } else if ((aVarD.a & 4) != 0) {
                bVar.a(vVarB, aVarD.b, null);
            } else if ((aVarD.a & 8) != 0) {
                bVar.b(vVarB, aVarD.b, aVarD.c);
            } else if ((aVarD.a & 2) != 0) {
            }
            a.a(aVarD);
        }
    }

    public void g(RecyclerView.v vVar) {
        int iB = this.b.b() - 1;
        while (true) {
            if (iB < 0) {
                break;
            }
            if (vVar != this.b.c(iB)) {
                iB--;
            } else {
                this.b.a(iB);
                break;
            }
        }
        a aVarRemove = this.a.remove(vVar);
        if (aVarRemove != null) {
            a.a(aVarRemove);
        }
    }

    public void b() {
        a.b();
    }

    public void h(RecyclerView.v vVar) {
        f(vVar);
    }

    static class a {
        static ee.a<a> d = new ee.b(20);
        int a;
        RecyclerView.e.c b;
        RecyclerView.e.c c;

        private a() {
        }

        static a a() {
            a aVarA = d.a();
            return aVarA == null ? new a() : aVarA;
        }

        static void a(a aVar) {
            aVar.a = 0;
            aVar.b = null;
            aVar.c = null;
            d.a(aVar);
        }

        static void b() {
            while (d.a() != null) {
            }
        }
    }
}
