package defpackage;

import com.harman.hkconnect.setup.newpage.info.RoomItem;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
public class apt extends aoy {
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
        return null;
    }

    @Override // defpackage.aoy
    public boolean a(List<adx> list) {
        return d(list) > 1;
    }

    @Override // defpackage.aoy
    public boolean b(List<adx> list) {
        Iterator<adx> it = list.iterator();
        while (it.hasNext()) {
            if (this.b.contains(Byte.valueOf(it.next().q()))) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.aoy
    public void a(RoomItem roomItem) {
        if (roomItem.v().isEmpty()) {
            mm.b("Cannot send command to empty devices %s", roomItem);
            return;
        }
        adx adxVar = roomItem.v().get(0);
        adxVar.R().setRole(21);
        adxVar.c(roomItem.j());
        adxVar.c((byte) 0);
        adxVar.e(roomItem.f());
        adxVar.f(roomItem.h());
        adxVar.h(roomItem.l());
        int iA = ahk.a();
        if (!roomItem.b()) {
            iA = adxVar.r();
        }
        adxVar.d(iA);
        adxVar.f(0);
        adw.a().z(adxVar);
        mm.b("TEST_SETUP_COMMAND channel = %s , color = %s , roomID = %s , RoomName = %s , IconIndex = %s , GroupId = %s , is Master = %s, role = %s", Byte.valueOf(adxVar.u()), Integer.valueOf(adxVar.p()), Integer.valueOf(adxVar.s()), adxVar.w(), Integer.valueOf(adxVar.v()), Integer.valueOf(adxVar.r()), Byte.valueOf(adxVar.t()), Integer.valueOf(adxVar.R().getRole()));
    }

    @Override // defpackage.aoy
    public void b(RoomItem roomItem) {
        if (roomItem.v().isEmpty()) {
            mm.b("Cannot send command to empty devices %s", roomItem);
            return;
        }
        adx adxVar = roomItem.v().get(0);
        adxVar.R().setRole(21);
        adxVar.c(roomItem.j());
        adxVar.c((byte) 0);
        adxVar.f(roomItem.h());
        adxVar.h(roomItem.l());
        adxVar.f(0);
        adw.a().z(adxVar);
        mm.b("Edit Room SendCommandOneByOne device=%s ", adxVar);
    }
}
