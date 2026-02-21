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
public class ape extends aoy {
    private final int d = 5;

    @Override // defpackage.aoy
    public void a() {
        this.b.add((byte) 7);
        this.b.add((byte) 12);
        this.b.add((byte) 3);
        this.b.add((byte) 1);
        this.b.add((byte) 2);
        this.b.add((byte) 4);
        this.b.add((byte) 5);
        this.b.add((byte) 6);
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
        return "omni_adapt+_setup_";
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
            if (mapF.get(Byte.valueOf(bByteValue)).size() >= 5 && this.b.contains(Byte.valueOf(bByteValue))) {
                return true;
            }
        }
        return false;
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
            if (!this.b.contains(Byte.valueOf(it.next().getKey().byteValue()))) {
                it.remove();
            }
        }
        return mapF;
    }

    @Override // defpackage.aoy
    public void a(RoomItem roomItem) {
        if (roomItem.n() == null) {
            mm.b("Cannot send command to empty devices %s", roomItem);
            return;
        }
        int iA = ahk.a();
        Iterator<adx> it = roomItem.v().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            adx next = it.next();
            if (next.P() == roomItem.d()) {
                iA = next.r();
                break;
            }
        }
        List<adx> listV = roomItem.v();
        mm.b("sendCommand before setRole, devices=%s", listV);
        for (adx adxVar : listV) {
            adxVar.d(iA);
            adxVar.f(1);
            if (roomItem.o() == adxVar) {
                adxVar.R().setRole(1);
                mm.b("-----setRole 1 Front Left, " + adxVar, new Object[0]);
            } else if (roomItem.p() == adxVar) {
                adxVar.R().setRole(2);
                mm.b("-----setRole 2 Front Right, " + adxVar, new Object[0]);
            } else if (roomItem.q() == adxVar) {
                adxVar.R().setRole(3);
                mm.b("-----setRole 3 Center, " + adxVar, new Object[0]);
            } else if (roomItem.r() == adxVar) {
                adxVar.R().setRole(4);
                mm.b("-----setRole 4 Subwoofer, " + adxVar, new Object[0]);
            } else if (roomItem.s() == adxVar) {
                adxVar.R().setRole(5);
                mm.b("-----setRole 5 Rear Left, " + adxVar, new Object[0]);
            } else if (roomItem.t() == adxVar) {
                adxVar.R().setRole(6);
                mm.b("-----setRole 6 Rear Right, " + adxVar, new Object[0]);
            } else {
                mm.b("-----setRole error", new Object[0]);
            }
            a(adxVar, roomItem);
        }
        if (roomItem.n() != null) {
            adx adxVarN = roomItem.n();
            adxVarN.d(iA);
            adxVarN.R().setRole(4);
            adxVarN.R().setMkMaster(0);
            a(adxVarN, roomItem);
        } else {
            mm.b("sendCommand failed for master device", new Object[0]);
        }
        mm.b("sendCommand after setRole, devices=%s", listV);
    }

    private void a(adx adxVar, RoomItem roomItem) {
        if (roomItem.v().size() == 0) {
            adxVar.c((byte) 0);
        } else {
            adxVar.c(roomItem.e());
        }
        mm.b("sendCommandOneByOne roomItem.getSelectedChannel = %d, ", Byte.valueOf(roomItem.e()));
        adxVar.c(roomItem.j());
        adxVar.e(roomItem.f());
        adxVar.f(roomItem.h());
        adxVar.h(roomItem.l());
        adxVar.d(adxVar.r());
        adw.a().b(adxVar);
        adw.a().z(adxVar);
        mm.b("sendCommandOneByOne device = %s ", adxVar);
    }

    @Override // defpackage.aoy
    public void b(RoomItem roomItem) {
        List<adx> listV = roomItem.v();
        if (roomItem.n() == null) {
            mm.b("Cannot send command to empty devices %s", roomItem);
            return;
        }
        for (adx adxVar : listV) {
            adxVar.f(roomItem.n().P() == adxVar.P() ? 0 : 1);
            adxVar.c(roomItem.e());
            adxVar.c(roomItem.j());
            adxVar.f(roomItem.h());
            adxVar.h(roomItem.l());
            adw.a().b(adxVar);
            adw.a().z(adxVar);
            mm.b("Edit Room SendCommandOneByOne device=%s ", adxVar);
        }
    }
}
