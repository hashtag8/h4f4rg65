package defpackage;

import defpackage.ee;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class p<T> {
    private final ee.a<ArrayList<T>> a = new ee.b(10);
    private final eg<T, ArrayList<T>> b = new eg<>();
    private final ArrayList<T> c = new ArrayList<>();
    private final HashSet<T> d = new HashSet<>();

    public void a(T t) {
        if (!this.b.containsKey(t)) {
            this.b.put(t, null);
        }
    }

    public boolean b(T t) {
        return this.b.containsKey(t);
    }

    public void a(T t, T t2) {
        if (!this.b.containsKey(t) || !this.b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayListC = this.b.get(t);
        if (arrayListC == null) {
            arrayListC = c();
            this.b.put(t, arrayListC);
        }
        arrayListC.add(t2);
    }

    public List c(T t) {
        return this.b.get(t);
    }

    public List<T> d(T t) {
        ArrayList arrayList = null;
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListC = this.b.c(i);
            if (arrayListC != null && arrayListC.contains(t)) {
                ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                arrayList2.add(this.b.b(i));
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    public boolean e(T t) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListC = this.b.c(i);
            if (arrayListC != null && arrayListC.contains(t)) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListC = this.b.c(i);
            if (arrayListC != null) {
                a((ArrayList) arrayListC);
            }
        }
        this.b.clear();
    }

    public ArrayList<T> b() {
        this.c.clear();
        this.d.clear();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            a(this.b.b(i), this.c, this.d);
        }
        return this.c;
    }

    private void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (hashSet.contains(t)) {
                throw new RuntimeException("This graph contains cyclic dependencies");
            }
            hashSet.add(t);
            ArrayList<T> arrayList2 = this.b.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    a(arrayList2.get(i), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
        }
    }

    private ArrayList<T> c() {
        ArrayList<T> arrayListA = this.a.a();
        if (arrayListA == null) {
            return new ArrayList<>();
        }
        return arrayListA;
    }

    private void a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.a.a(arrayList);
    }
}
