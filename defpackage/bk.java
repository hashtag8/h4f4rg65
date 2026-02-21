package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import defpackage.av;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class bk {
    private static final int[] a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};

    static void a(bf bfVar, ArrayList<av> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (bfVar.l >= 1 && Build.VERSION.SDK_INT >= 21) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                av avVar = arrayList.get(i3);
                if (arrayList2.get(i3).booleanValue()) {
                    b(avVar, (SparseArray<a>) sparseArray, z);
                } else {
                    a(avVar, (SparseArray<a>) sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(bfVar.m.g());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int iKeyAt = sparseArray.keyAt(i4);
                    du<String, String> duVarA = a(iKeyAt, arrayList, arrayList2, i, i2);
                    a aVar = (a) sparseArray.valueAt(i4);
                    if (z) {
                        a(bfVar, iKeyAt, aVar, view, duVarA);
                    } else {
                        b(bfVar, iKeyAt, aVar, view, duVarA);
                    }
                }
            }
        }
    }

    private static du<String, String> a(int i, ArrayList<av> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        du<String, String> duVar = new du<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            av avVar = arrayList.get(i4);
            if (avVar.b(i)) {
                boolean zBooleanValue = arrayList2.get(i4).booleanValue();
                if (avVar.s != null) {
                    int size = avVar.s.size();
                    if (zBooleanValue) {
                        arrayList3 = avVar.s;
                        arrayList4 = avVar.t;
                    } else {
                        ArrayList<String> arrayList5 = avVar.s;
                        arrayList3 = avVar.t;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String strRemove = duVar.remove(str2);
                        if (strRemove != null) {
                            duVar.put(str, strRemove);
                        } else {
                            duVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return duVar;
    }

    private static void a(bf bfVar, int i, a aVar, View view, du<String, String> duVar) {
        ViewGroup viewGroup = null;
        if (bfVar.n.a()) {
            viewGroup = (ViewGroup) bfVar.n.a(i);
        }
        if (viewGroup != null) {
            Fragment fragment = aVar.a;
            Fragment fragment2 = aVar.d;
            boolean z = aVar.b;
            boolean z2 = aVar.e;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object objA = a(fragment, z);
            Object objB = b(fragment2, z2);
            Object objA2 = a(viewGroup, view, duVar, aVar, (ArrayList<View>) arrayList2, (ArrayList<View>) arrayList, objA, objB);
            if (objA != null || objA2 != null || objB != null) {
                ArrayList<View> arrayListB = b(objB, fragment2, (ArrayList<View>) arrayList2, view);
                ArrayList<View> arrayListB2 = b(objA, fragment, (ArrayList<View>) arrayList, view);
                b(arrayListB2, 4);
                Object objA3 = a(objA, objB, objA2, fragment, z);
                if (objA3 != null) {
                    a(objB, fragment2, arrayListB);
                    ArrayList<String> arrayListA = bl.a((ArrayList<View>) arrayList);
                    bl.a(objA3, objA, arrayListB2, objB, arrayListB, objA2, arrayList);
                    bl.a(viewGroup, objA3);
                    bl.a(viewGroup, arrayList2, arrayList, arrayListA, duVar);
                    b(arrayListB2, 0);
                    bl.a(objA2, (ArrayList<View>) arrayList2, (ArrayList<View>) arrayList);
                }
            }
        }
    }

    private static void a(Object obj, Fragment fragment, final ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.t && fragment.I && fragment.Z) {
            fragment.k(true);
            bl.b(obj, fragment.B(), arrayList);
            bz.a(fragment.P, new Runnable() { // from class: bk.1
                @Override // java.lang.Runnable
                public void run() {
                    bk.b((ArrayList<View>) arrayList, 4);
                }
            });
        }
    }

    private static void b(bf bfVar, int i, a aVar, View view, du<String, String> duVar) {
        ViewGroup viewGroup = null;
        if (bfVar.n.a()) {
            viewGroup = (ViewGroup) bfVar.n.a(i);
        }
        if (viewGroup != null) {
            Fragment fragment = aVar.a;
            Fragment fragment2 = aVar.d;
            boolean z = aVar.b;
            boolean z2 = aVar.e;
            Object objA = a(fragment, z);
            Object objB = b(fragment2, z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object objB2 = b(viewGroup, view, duVar, aVar, arrayList, arrayList2, objA, objB);
            if (objA != null || objB2 != null || objB != null) {
                ArrayList<View> arrayListB = b(objB, fragment2, (ArrayList<View>) arrayList, view);
                Object obj = (arrayListB == null || arrayListB.isEmpty()) ? null : objB;
                bl.b(objA, view);
                Object objA2 = a(objA, obj, objB2, fragment, aVar.b);
                if (objA2 != null) {
                    ArrayList arrayList3 = new ArrayList();
                    bl.a(objA2, objA, arrayList3, obj, arrayListB, objB2, arrayList2);
                    a(viewGroup, fragment, view, (ArrayList<View>) arrayList2, objA, (ArrayList<View>) arrayList3, obj, arrayListB);
                    bl.a((View) viewGroup, (ArrayList<View>) arrayList2, (Map<String, String>) duVar);
                    bl.a(viewGroup, objA2);
                    bl.a(viewGroup, (ArrayList<View>) arrayList2, (Map<String, String>) duVar);
                }
            }
        }
    }

    private static void a(ViewGroup viewGroup, final Fragment fragment, final View view, final ArrayList<View> arrayList, final Object obj, final ArrayList<View> arrayList2, final Object obj2, final ArrayList<View> arrayList3) {
        bz.a(viewGroup, new Runnable() { // from class: bk.2
            @Override // java.lang.Runnable
            public void run() {
                if (obj != null) {
                    bl.c(obj, view);
                    arrayList2.addAll(bk.b(obj, fragment, (ArrayList<View>) arrayList, view));
                }
                if (arrayList3 != null) {
                    if (obj2 != null) {
                        ArrayList arrayList4 = new ArrayList();
                        arrayList4.add(view);
                        bl.b(obj2, (ArrayList<View>) arrayList3, (ArrayList<View>) arrayList4);
                    }
                    arrayList3.clear();
                    arrayList3.add(view);
                }
            }
        });
    }

    private static Object a(Fragment fragment, Fragment fragment2, boolean z) {
        Object objL;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            objL = fragment2.M();
        } else {
            objL = fragment.L();
        }
        return bl.b(bl.a(objL));
    }

    private static Object a(Fragment fragment, boolean z) {
        Object objH;
        if (fragment == null) {
            return null;
        }
        if (z) {
            objH = fragment.K();
        } else {
            objH = fragment.H();
        }
        return bl.a(objH);
    }

    private static Object b(Fragment fragment, boolean z) {
        Object objJ;
        if (fragment == null) {
            return null;
        }
        if (z) {
            objJ = fragment.I();
        } else {
            objJ = fragment.J();
        }
        return bl.a(objJ);
    }

    private static Object a(ViewGroup viewGroup, View view, du<String, String> duVar, a aVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        final Rect rect;
        final View viewB = null;
        final Fragment fragment = aVar.a;
        final Fragment fragment2 = aVar.d;
        if (fragment != null) {
            fragment.B().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z = aVar.b;
        Object objA = duVar.isEmpty() ? null : a(fragment, fragment2, z);
        du<String, View> duVarB = b(duVar, objA, aVar);
        final du<String, View> duVarC = c(duVar, objA, aVar);
        if (duVar.isEmpty()) {
            if (duVarB != null) {
                duVarB.clear();
            }
            if (duVarC != null) {
                duVarC.clear();
                obj3 = null;
            } else {
                obj3 = null;
            }
        } else {
            a(arrayList, duVarB, duVar.keySet());
            a(arrayList2, duVarC, duVar.values());
            obj3 = objA;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        b(fragment, fragment2, z, duVarB, true);
        if (obj3 != null) {
            arrayList2.add(view);
            bl.a(obj3, view, arrayList);
            a(obj3, obj2, duVarB, aVar.e, aVar.f);
            rect = new Rect();
            viewB = b(duVarC, aVar, obj, z);
            if (viewB != null) {
                bl.a(obj, rect);
            }
        } else {
            rect = null;
        }
        bz.a(viewGroup, new Runnable() { // from class: bk.3
            @Override // java.lang.Runnable
            public void run() {
                bk.b(fragment, fragment2, z, (du<String, View>) duVarC, false);
                if (viewB != null) {
                    bl.a(viewB, rect);
                }
            }
        });
        return obj3;
    }

    private static void a(ArrayList<View> arrayList, du<String, View> duVar, Collection<String> collection) {
        for (int size = duVar.size() - 1; size >= 0; size--) {
            View viewC = duVar.c(size);
            if (collection.contains(fb.l(viewC))) {
                arrayList.add(viewC);
            }
        }
    }

    private static Object b(ViewGroup viewGroup, final View view, final du<String, String> duVar, final a aVar, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final Object obj, Object obj2) {
        final Object obj3;
        final Rect rect;
        final Fragment fragment = aVar.a;
        final Fragment fragment2 = aVar.d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z = aVar.b;
        Object objA = duVar.isEmpty() ? null : a(fragment, fragment2, z);
        du<String, View> duVarB = b(duVar, objA, aVar);
        if (duVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(duVarB.values());
            obj3 = objA;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        b(fragment, fragment2, z, duVarB, true);
        if (obj3 != null) {
            rect = new Rect();
            bl.a(obj3, view, arrayList);
            a(obj3, obj2, duVarB, aVar.e, aVar.f);
            if (obj != null) {
                bl.a(obj, rect);
            }
        } else {
            rect = null;
        }
        bz.a(viewGroup, new Runnable() { // from class: bk.4
            @Override // java.lang.Runnable
            public void run() {
                du duVarC = bk.c(duVar, obj3, aVar);
                if (duVarC != null) {
                    arrayList2.addAll(duVarC.values());
                    arrayList2.add(view);
                }
                bk.b(fragment, fragment2, z, (du<String, View>) duVarC, false);
                if (obj3 != null) {
                    bl.a(obj3, (ArrayList<View>) arrayList, (ArrayList<View>) arrayList2);
                    View viewB = bk.b((du<String, View>) duVarC, aVar, obj, z);
                    if (viewB != null) {
                        bl.a(viewB, rect);
                    }
                }
            }
        });
        return obj3;
    }

    private static du<String, View> b(du<String, String> duVar, Object obj, a aVar) {
        ArrayList<String> arrayList;
        ce ceVar;
        if (duVar.isEmpty() || obj == null) {
            duVar.clear();
            return null;
        }
        Fragment fragment = aVar.d;
        du<String, View> duVar2 = new du<>();
        bl.a((Map<String, View>) duVar2, fragment.B());
        av avVar = aVar.f;
        if (aVar.e) {
            ce ceVarAe = fragment.ae();
            arrayList = avVar.t;
            ceVar = ceVarAe;
        } else {
            ce ceVarAf = fragment.af();
            arrayList = avVar.s;
            ceVar = ceVarAf;
        }
        duVar2.a((Collection<?>) arrayList);
        if (ceVar != null) {
            ceVar.a(arrayList, duVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = duVar2.get(str);
                if (view == null) {
                    duVar.remove(str);
                } else if (!str.equals(fb.l(view))) {
                    duVar.put(fb.l(view), duVar.remove(str));
                }
            }
        } else {
            duVar.a((Collection<?>) duVar2.keySet());
        }
        return duVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static du<String, View> c(du<String, String> duVar, Object obj, a aVar) {
        ArrayList<String> arrayList;
        ce ceVar;
        String strA;
        Fragment fragment = aVar.a;
        View viewB = fragment.B();
        if (duVar.isEmpty() || obj == null || viewB == null) {
            duVar.clear();
            return null;
        }
        du<String, View> duVar2 = new du<>();
        bl.a((Map<String, View>) duVar2, viewB);
        av avVar = aVar.c;
        if (aVar.b) {
            ce ceVarAf = fragment.af();
            arrayList = avVar.s;
            ceVar = ceVarAf;
        } else {
            ce ceVarAe = fragment.ae();
            arrayList = avVar.t;
            ceVar = ceVarAe;
        }
        if (arrayList != null) {
            duVar2.a((Collection<?>) arrayList);
        }
        if (ceVar != null) {
            ceVar.a(arrayList, duVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = duVar2.get(str);
                if (view == null) {
                    String strA2 = a(duVar, str);
                    if (strA2 != null) {
                        duVar.remove(strA2);
                    }
                } else if (!str.equals(fb.l(view)) && (strA = a(duVar, str)) != null) {
                    duVar.put(strA, fb.l(view));
                }
            }
        } else {
            a(duVar, duVar2);
        }
        return duVar2;
    }

    private static String a(du<String, String> duVar, String str) {
        int size = duVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(duVar.c(i))) {
                return duVar.b(i);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static View b(du<String, View> duVar, a aVar, Object obj, boolean z) {
        String str;
        av avVar = aVar.c;
        if (obj != null && duVar != null && avVar.s != null && !avVar.s.isEmpty()) {
            if (z) {
                str = avVar.s.get(0);
            } else {
                str = avVar.t.get(0);
            }
            return duVar.get(str);
        }
        return null;
    }

    private static void a(Object obj, Object obj2, du<String, View> duVar, boolean z, av avVar) {
        String str;
        if (avVar.s != null && !avVar.s.isEmpty()) {
            if (z) {
                str = avVar.t.get(0);
            } else {
                str = avVar.s.get(0);
            }
            View view = duVar.get(str);
            bl.a(obj, view);
            if (obj2 != null) {
                bl.a(obj2, view);
            }
        }
    }

    private static void a(du<String, String> duVar, du<String, View> duVar2) {
        for (int size = duVar.size() - 1; size >= 0; size--) {
            if (!duVar2.containsKey(duVar.c(size))) {
                duVar.d(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Fragment fragment, Fragment fragment2, boolean z, du<String, View> duVar, boolean z2) {
        ce ceVarAe;
        if (z) {
            ceVarAe = fragment2.ae();
        } else {
            ceVarAe = fragment.ae();
        }
        if (ceVarAe != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = duVar == null ? 0 : duVar.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(duVar.b(i));
                arrayList.add(duVar.c(i));
            }
            if (z2) {
                ceVarAe.a(arrayList2, arrayList, null);
            } else {
                ceVarAe.b(arrayList2, arrayList, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<View> b(Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        ArrayList<View> arrayList2 = null;
        if (obj != null) {
            arrayList2 = new ArrayList<>();
            View viewB = fragment.B();
            if (viewB != null) {
                bl.a(arrayList2, viewB);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (!arrayList2.isEmpty()) {
                arrayList2.add(view);
                bl.a(obj, arrayList2);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    private static Object a(Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean zO = true;
        if (obj != null && obj2 != null && fragment != null) {
            zO = z ? fragment.O() : fragment.N();
        }
        if (zO) {
            return bl.a(obj2, obj, obj3);
        }
        return bl.b(obj2, obj, obj3);
    }

    public static void a(av avVar, SparseArray<a> sparseArray, boolean z) {
        int size = avVar.c.size();
        for (int i = 0; i < size; i++) {
            a(avVar, avVar.c.get(i), sparseArray, false, z);
        }
    }

    public static void b(av avVar, SparseArray<a> sparseArray, boolean z) {
        if (avVar.b.n.a()) {
            for (int size = avVar.c.size() - 1; size >= 0; size--) {
                a(avVar, avVar.c.get(size), sparseArray, true, z);
            }
        }
    }

    private static void a(av avVar, av.a aVar, SparseArray<a> sparseArray, boolean z, boolean z2) {
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        a aVarA;
        a aVarA2;
        Fragment fragment = aVar.b;
        if (fragment != null && (i = fragment.G) != 0) {
            switch (z ? a[aVar.a] : aVar.a) {
                case 1:
                case 7:
                    if (z2) {
                        z9 = fragment.Y;
                    } else {
                        z9 = (fragment.t || fragment.I) ? false : true;
                    }
                    z4 = true;
                    z5 = false;
                    z6 = false;
                    z7 = z9;
                    break;
                case 2:
                default:
                    z4 = false;
                    z5 = false;
                    z6 = false;
                    z7 = false;
                    break;
                case 3:
                case 6:
                    if (z2) {
                        z3 = !fragment.t && fragment.Q != null && fragment.Q.getVisibility() == 0 && fragment.aa >= 0.0f;
                    } else {
                        z3 = fragment.t && !fragment.I;
                    }
                    z4 = false;
                    z5 = z3;
                    z6 = true;
                    z7 = false;
                    break;
                case 4:
                    if (z2) {
                        z8 = fragment.Z && fragment.t && fragment.I;
                    } else {
                        z8 = fragment.t && !fragment.I;
                    }
                    z4 = false;
                    z5 = z8;
                    z6 = true;
                    z7 = false;
                    break;
                case 5:
                    if (z2) {
                        z10 = fragment.Z && !fragment.I && fragment.t;
                    } else {
                        z10 = fragment.I;
                    }
                    z4 = true;
                    z5 = false;
                    z6 = false;
                    z7 = z10;
                    break;
            }
            a aVar2 = sparseArray.get(i);
            if (z7) {
                aVarA = a(aVar2, sparseArray, i);
                aVarA.a = fragment;
                aVarA.b = z;
                aVarA.c = avVar;
            } else {
                aVarA = aVar2;
            }
            if (!z2 && z4) {
                if (aVarA != null && aVarA.d == fragment) {
                    aVarA.d = null;
                }
                bf bfVar = avVar.b;
                if (fragment.k < 1 && bfVar.l >= 1 && !avVar.u) {
                    bfVar.g(fragment);
                    bfVar.a(fragment, 1, 0, 0, false);
                }
            }
            if (z5 && (aVarA == null || aVarA.d == null)) {
                aVarA2 = a(aVarA, sparseArray, i);
                aVarA2.d = fragment;
                aVarA2.e = z;
                aVarA2.f = avVar;
            } else {
                aVarA2 = aVarA;
            }
            if (!z2 && z6 && aVarA2 != null && aVarA2.a == fragment) {
                aVarA2.a = null;
            }
        }
    }

    private static a a(a aVar, SparseArray<a> sparseArray, int i) {
        if (aVar == null) {
            a aVar2 = new a();
            sparseArray.put(i, aVar2);
            return aVar2;
        }
        return aVar;
    }

    static class a {
        public Fragment a;
        public boolean b;
        public av c;
        public Fragment d;
        public boolean e;
        public av f;

        a() {
        }
    }
}
