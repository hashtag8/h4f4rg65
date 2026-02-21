package defpackage;

import com.harman.hkconnect.setup.newpage.info.RoomItem;
import com.harman.hkconnect.ui.HarmanApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
public class apr extends aoy {
    private final int d = 2;

    @Override // defpackage.aoy
    public void a() {
        this.b.add((byte) 1);
        this.b.add((byte) 2);
        this.b.add((byte) 4);
        this.b.add((byte) 5);
        this.b.add((byte) 6);
        this.b.add((byte) 8);
        this.c.add("omni10_setup_");
        this.c.add("omni20_setup_");
        this.c.add("hk_omni_10+_setup_");
        this.c.add("hk_omni_20+_setup_");
        this.c.add("hk_omni_50+_setup_");
        this.a = HarmanApplication.a().getResources();
    }

    @Override // defpackage.aoy
    public String a(SortedSet<String> sortedSet, List<adx> list) {
        return null;
    }

    @Override // defpackage.aoy
    public String b() {
        return "omni_bar+_setup_";
    }

    @Override // defpackage.aoy
    public boolean a(List<adx> list) {
        return true;
    }

    @Override // defpackage.aoy
    public boolean b(List<adx> list) {
        if (list == null) {
            return false;
        }
        HashMap<Byte, List<adx>> mapF = f(list);
        Iterator<Map.Entry<Byte, List<adx>>> it = mapF.entrySet().iterator();
        while (it.hasNext()) {
            byte bByteValue = it.next().getKey().byteValue();
            if (mapF.get(Byte.valueOf(bByteValue)).size() >= 2 && (bByteValue == 4 || bByteValue == 5 || bByteValue == 6)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.aoy
    public void a(RoomItem roomItem) {
        if (roomItem.n() == null) {
            mm.b("Cannot send command to empty devices %s", roomItem);
            return;
        }
        int iA = ahk.a();
        if (roomItem.n() != null) {
            adx adxVarN = roomItem.n();
            adxVarN.d(iA);
            adxVarN.R().setRole(12345678);
            adxVarN.R().setMkMaster(0);
            a(adxVarN, roomItem);
        } else {
            mm.b("sendCommand failed for master device", new Object[0]);
        }
        List<adx> listV = roomItem.v();
        mm.b("sendCommand before setRole, devices=%s", listV);
        for (adx adxVar : listV) {
            adxVar.d(iA);
            adxVar.f(1);
            if (roomItem.o() == adxVar) {
                adxVar.R().setRole(5);
                mm.b("-----setRole 5 Front Left, " + adxVar, new Object[0]);
            } else if (roomItem.p() == adxVar) {
                adxVar.R().setRole(6);
                mm.b("-----setRole 6 Front Right, " + adxVar, new Object[0]);
            } else if (roomItem.r() == adxVar) {
                adxVar.R().setRole(4);
                mm.b("-----setRole 4 subwoofer, " + adxVar, new Object[0]);
            } else {
                mm.b("-----setRole error", new Object[0]);
            }
            a(adxVar, roomItem);
        }
        mm.b("sendCommand after setRole, devices=%s", listV);
    }

    private void a(adx adxVar, RoomItem roomItem) {
        adxVar.c((byte) 2);
        adxVar.c(roomItem.j());
        adxVar.e(roomItem.f());
        adxVar.f(roomItem.h());
        adxVar.h(roomItem.l());
        adxVar.d(adxVar.r());
        adw.a().z(adxVar);
        adw.a().b(adxVar);
        mm.b("sendCommandOneByOne deviceFc=%s", adxVar);
    }

    private static HashMap<Byte, List<adx>> f(List<adx> list) {
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
        HashMap<Byte, List<adx>> mapF = f(list);
        Iterator<Map.Entry<Byte, List<adx>>> it = mapF.entrySet().iterator();
        while (it.hasNext()) {
            byte bByteValue = it.next().getKey().byteValue();
            mapF.get(Byte.valueOf(bByteValue));
            if (!this.b.contains(Byte.valueOf(bByteValue))) {
                it.remove();
            }
        }
        return mapF;
    }

    @Override // defpackage.aoy
    public void b(RoomItem roomItem) {
        if (roomItem.n() == null) {
            mm.b("Cannot send command to empty devices %s", roomItem);
            return;
        }
        List<adx> listV = roomItem.v();
        mm.b("sendCommand before setRole, devices=%s", listV);
        for (adx adxVar : listV) {
            adxVar.f(adxVar.P() == roomItem.n().P() ? 0 : 1);
            adxVar.c((byte) 2);
            adxVar.c(roomItem.j());
            adxVar.f(roomItem.h());
            adxVar.h(roomItem.l());
            adw.a().z(adxVar);
            adw.a().b(adxVar);
            mm.b("Edit Room SendCommandOneByOne:: deviceFc=%s", adxVar);
        }
        mm.b("sendCommand after setRole, devices=%s", listV);
    }
}
