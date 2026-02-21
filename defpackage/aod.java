package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class aod implements Serializable {
    private final Map<Long, adx> a;
    private final Map<Long, adz> b;
    private final Map<Integer, ady> c;
    private ady d;
    private ady e;

    public aod(Map<Long, adx> map) {
        this(map, Collections.emptyList(), Collections.emptyMap(), null, null);
    }

    public aod(Map<Long, adx> map, aod aodVar) {
        this(map, aodVar.b.values(), aodVar.c, aodVar.d, aodVar.e);
    }

    private aod(Map<Long, adx> map, Collection<adz> collection, Map<Integer, ady> map2, ady adyVar, ady adyVar2) {
        this.d = null;
        this.e = null;
        this.d = adyVar;
        this.e = adyVar2;
        this.a = Collections.unmodifiableMap(new HashMap(map));
        this.b = Collections.unmodifiableMap(a(this.a.values(), collection));
        this.c = Collections.unmodifiableMap(a(this.b.values(), map2));
        f();
    }

    public List<adx> a() {
        return Collections.unmodifiableList(new ArrayList(this.a.values()));
    }

    public List<adz> b() {
        ArrayList arrayList = new ArrayList(this.b.values());
        Collections.sort(arrayList, new Comparator<adz>() { // from class: aod.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(adz adzVar, adz adzVar2) {
                int iCompare = String.CASE_INSENSITIVE_ORDER.compare(adzVar.l(), adzVar2.l());
                if (iCompare == 0) {
                    int iCompareTo = Integer.valueOf(adzVar.q()).compareTo(Integer.valueOf(adzVar2.q()));
                    return iCompareTo == 0 ? Integer.valueOf(System.identityHashCode(adzVar)).compareTo(Integer.valueOf(System.identityHashCode(adzVar2))) : iCompareTo;
                }
                return iCompare;
            }
        });
        return Collections.unmodifiableList(arrayList);
    }

    public adx a(long j) {
        return this.a.get(Long.valueOf(j));
    }

    public List<ady> c() {
        ArrayList arrayList = new ArrayList(this.c.values());
        Collections.sort(arrayList, new Comparator<ady>() { // from class: aod.2
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(ady adyVar, ady adyVar2) {
                int iCompare = String.CASE_INSENSITIVE_ORDER.compare(adyVar.i(), adyVar2.i());
                if (iCompare == 0) {
                    int iCompareTo = new Integer(adyVar.e()).compareTo(Integer.valueOf(adyVar2.e()));
                    return iCompareTo == 0 ? new Integer(System.identityHashCode(adyVar)).compareTo(Integer.valueOf(System.identityHashCode(adyVar2))) : iCompareTo;
                }
                return iCompare;
            }
        });
        return Collections.unmodifiableList(arrayList);
    }

    public ady d() {
        return this.d;
    }

    public void a(ady adyVar) {
        if (adyVar == null) {
            this.d = null;
        } else {
            this.d = a(adyVar.d());
        }
    }

    public ady e() {
        return this.e;
    }

    public void b(ady adyVar) {
        if (adyVar == null) {
            this.e = null;
        } else {
            this.e = a(adyVar.d());
        }
    }

    public ady a(Collection<ady> collection, adz adzVar) {
        for (ady adyVar : collection) {
            if (adyVar.c(adzVar)) {
                return adyVar;
            }
        }
        return null;
    }

    public adz a(adx adxVar) {
        for (adz adzVar : this.b.values()) {
            if (adzVar.b(adxVar)) {
                return adzVar;
            }
        }
        return null;
    }

    private void f() {
        b(this.e);
        a(this.d);
        if (this.d == null) {
            Iterator<ady> it = c().iterator();
            if (it.hasNext()) {
                this.d = it.next();
            }
        }
    }

    private Map<Long, adz> a(Collection<adx> collection, Collection<adz> collection2) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        for (adx adxVar : collection) {
            if (adxVar.s() != 0) {
                List arrayList = (List) map2.get(Integer.valueOf(adxVar.s()));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map2.put(Integer.valueOf(adxVar.s()), arrayList);
                }
                arrayList.add(adxVar);
            } else {
                adxVar.a(false);
                mm.b("Device has no room %s", adxVar);
            }
        }
        Iterator it = map2.entrySet().iterator();
        while (it.hasNext()) {
            adz adzVarA = a(collection2, (List<adx>) ((Map.Entry) it.next()).getValue());
            if (b(adzVarA)) {
                if (a(adzVarA)) {
                    map.put(Long.valueOf(adzVarA.c()), adzVarA);
                }
            } else {
                map.put(Long.valueOf(adzVarA.c()), adzVarA);
            }
        }
        return map;
    }

    private boolean a(adz adzVar) {
        if (adzVar == null || adzVar.k().isEmpty()) {
            return false;
        }
        Iterator<adx> it = adzVar.k().iterator();
        while (it.hasNext()) {
            if (it.next().L()) {
                return true;
            }
        }
        return false;
    }

    private boolean b(adz adzVar) {
        return adzVar.d() == 2 || adzVar.d() == 4;
    }

    private Map<Integer, ady> a(Collection<adz> collection, Map<Integer, ady> map) {
        mm.e("Devices.roomsToLinkedGroups 1111", new Object[0]);
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        for (adz adzVar : collection) {
            List arrayList = (List) map3.get(Integer.valueOf(adzVar.x()));
            if (arrayList == null) {
                arrayList = new ArrayList();
                map3.put(Integer.valueOf(adzVar.x()), arrayList);
            }
            arrayList.add(adzVar);
        }
        for (Map.Entry entry : map3.entrySet()) {
            map2.put(entry.getKey(), a(map.get(entry.getKey()), (List<adz>) entry.getValue()));
        }
        return map2;
    }

    private adz a(Collection<adz> collection, List<adx> list) {
        boolean z;
        for (adz adzVar : collection) {
            if (adzVar.k().size() == list.size()) {
                Iterator<adx> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    if (!adzVar.b(it.next())) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    return adzVar;
                }
            }
        }
        adz adzVar2 = new adz();
        Iterator<adx> it2 = list.iterator();
        while (it2.hasNext()) {
            adzVar2.c(it2.next());
        }
        return adzVar2;
    }

    private ady a(ady adyVar, List<adz> list) {
        mm.c("Devices.createGroup 1111 OldGroup=%s,streamingGroup=%s", adyVar, this.e);
        int iX = list.get(0).x();
        mm.c("Devices.createGroup 222 GroupId=%d", Integer.valueOf(iX));
        if (adyVar != null) {
            mm.c("Devices.createGroup 3333 oldGroupById != null", new Object[0]);
            for (adz adzVar : adyVar.f()) {
                if (!list.contains(adzVar)) {
                    adyVar.b(adzVar);
                    mm.c("Devices.createGroup removeRoom=%s", adzVar);
                }
            }
        } else {
            adyVar = new ady(iX);
        }
        for (adz adzVar2 : list) {
            mm.e("Devices.createGroup 4444 Room=%s", adzVar2);
            if (adyVar.a(adzVar2)) {
                mm.c("Devices.createGroup 55555 If room already present=%s", Boolean.valueOf(adyVar.a(adzVar2)));
                if (this.e != null && adzVar2.x() == this.e.d()) {
                    mm.c("Devices.createGroup 6666 streamingGroup=%s", this.e);
                    adzVar2.b(true);
                }
            }
        }
        return adyVar;
    }

    public ady a(int i) {
        return this.c.get(Integer.valueOf(i));
    }

    public String toString() {
        return bsc.b(this, new ahp());
    }

    public boolean a(Collection<adz> collection) {
        if (collection != null) {
            for (adz adzVar : collection) {
                ady adyVar = this.e;
                if (this.b.containsKey(Long.valueOf(adzVar.c())) && (adyVar == null || !adyVar.c(adzVar))) {
                    Iterator<adx> it = adzVar.k().iterator();
                    while (it.hasNext()) {
                        if (!it.next().W()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
