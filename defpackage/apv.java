package defpackage;

import com.harman.hkconnect.setup.newpage.info.RoomItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
public class apv extends aoy {
    @Override // defpackage.aoy
    public void a() {
        this.b.add((byte) 1);
        this.b.add((byte) 2);
        this.b.add((byte) 4);
        this.b.add((byte) 5);
        this.b.add((byte) 6);
    }

    @Override // defpackage.aoy
    public String a(SortedSet<String> sortedSet, List<adx> list) {
        return null;
    }

    @Override // defpackage.aoy
    public String b() {
        return aty.a((byte) 1) + aty.a((byte) 2) + aty.a((byte) 4) + aty.a((byte) 5) + aty.a((byte) 6);
    }

    @Override // defpackage.aoy
    public boolean a(List<adx> list) {
        return true;
    }

    public boolean a(List<adx> list, adx adxVar) {
        HashMap<Byte, List<adx>> mapG = g(list);
        Iterator<Map.Entry<Byte, List<adx>>> it = mapG.entrySet().iterator();
        while (it.hasNext()) {
            byte bByteValue = it.next().getKey().byteValue();
            if (adxVar != null && adxVar.q() == bByteValue && f(mapG.get(Byte.valueOf(bByteValue))).size() > 0 && this.b.contains(Byte.valueOf(bByteValue))) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.aoy
    public boolean b(List<adx> list) {
        if (list.size() >= 2) {
            HashMap<Byte, List<adx>> mapG = g(list);
            Iterator<Map.Entry<Byte, List<adx>>> it = mapG.entrySet().iterator();
            while (it.hasNext()) {
                byte bByteValue = it.next().getKey().byteValue();
                if (f(mapG.get(Byte.valueOf(bByteValue))).size() >= 2 && this.b.contains(Byte.valueOf(bByteValue))) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<adx> f(List<adx> list) {
        Iterator<adx> it = list.iterator();
        while (it.hasNext()) {
            adx next = it.next();
            if (next.u() == 1 || next.u() == 4 || next.u() == 2) {
                it.remove();
            }
        }
        return list;
    }

    private static HashMap<Byte, List<adx>> g(List<adx> list) {
        HashMap<Byte, List<adx>> map = new HashMap<>();
        for (adx adxVar : list) {
            List<adx> list2 = map.get(Byte.valueOf(adxVar.q()));
            if (list2 == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(adxVar);
                map.put(Byte.valueOf(adxVar.q()), arrayList);
            } else {
                list2.add(adxVar);
            }
        }
        return map;
    }

    public HashMap<Byte, List<adx>> e(List<adx> list) {
        HashMap<Byte, List<adx>> mapG = g(list);
        Iterator<Map.Entry<Byte, List<adx>>> it = mapG.entrySet().iterator();
        while (it.hasNext()) {
            if (!this.b.contains(Byte.valueOf(it.next().getKey().byteValue()))) {
                it.remove();
            }
        }
        return mapG;
    }

    @Override // defpackage.aoy
    public void a(RoomItem roomItem) {
        int iA = ahk.a();
        int iR = iA;
        int i = 0;
        for (adx adxVar : roomItem.v()) {
            if (!roomItem.b()) {
                iR = adxVar.r();
            }
            adxVar.d(iR);
            i++;
            adxVar.R().setRole(i);
            a(adxVar, roomItem);
        }
    }

    private void a(adx adxVar, RoomItem roomItem) {
        adxVar.c(roomItem.e());
        adxVar.c(roomItem.j());
        adxVar.e(roomItem.f());
        adxVar.f(roomItem.h());
        adxVar.h(roomItem.l());
        if (adxVar.P() != roomItem.d()) {
            adxVar.f(1);
        } else {
            adxVar.f(0);
        }
        adxVar.d(adxVar.r());
        adw.a().z(adxVar);
        adxVar.g((byte) 6);
        adw.a().v(adxVar);
        mm.b(adxVar.R() + "  TEST_SETUP_COMMAND setRole channel = %s , color = %s , roomID = %s , RoomName = %s , IconIndex = %s , GroupId = %s , is Master = %s, role = %s", Byte.valueOf(adxVar.u()), Integer.valueOf(adxVar.p()), Integer.valueOf(adxVar.s()), adxVar.w(), Integer.valueOf(adxVar.v()), Integer.valueOf(adxVar.r()), Byte.valueOf(adxVar.t()), Integer.valueOf(adxVar.R().getRole()));
    }

    @Override // defpackage.aoy
    public void b(RoomItem roomItem) {
        for (adx adxVar : roomItem.v()) {
            adxVar.c(roomItem.e());
            adxVar.c(roomItem.j());
            adxVar.f(roomItem.h());
            adxVar.h(roomItem.l());
            adxVar.f(adxVar.P() != roomItem.d() ? 1 : 0);
            adw.a().z(adxVar);
            adxVar.g((byte) 6);
            adw.a().v(adxVar);
        }
    }
}
