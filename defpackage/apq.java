package defpackage;

import com.harman.hkconnect.setup.newpage.info.RoomItem;
import com.harman.hkconnect.ui.HarmanApplication;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
public class apq extends apt {
    @Override // defpackage.apt, defpackage.aoy
    public void a() {
        this.b.add((byte) 8);
        this.a = HarmanApplication.a().getResources();
    }

    @Override // defpackage.apt, defpackage.aoy
    public boolean b(List<adx> list) {
        if (list.size() == 0 || list == null) {
            return false;
        }
        Iterator<adx> it = list.iterator();
        while (it.hasNext()) {
            if (this.b.contains(Byte.valueOf(it.next().q()))) {
                mm.b("has enough-----", new Object[0]);
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.apt, defpackage.aoy
    public boolean a(List<adx> list) {
        return d(list) >= 1;
    }

    @Override // defpackage.apt, defpackage.aoy
    public String a(SortedSet<String> sortedSet, List<adx> list) {
        mm.b(sortedSet.contains(b().toLowerCase()) + "-----" + b(), new Object[0]);
        if (a(sortedSet)) {
            return null;
        }
        return "We detect you don't have: - \"Adapt\" / \"Omni bar\" for this type,\n        You need setup \"Adapt\" / \"Omni bar\" product at first only after this you can finish this type of setup. Please choose relevant setup configuration option and make sure plug power in all products.";
    }

    private boolean a(SortedSet<String> sortedSet) {
        Iterator<String> it = sortedSet.iterator();
        while (it.hasNext()) {
            if (it.next().toLowerCase().contains(b().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.apt, defpackage.aoy
    public String b() {
        return "omni_bar+_setup_";
    }

    @Override // defpackage.apt, defpackage.aoy
    public void a(RoomItem roomItem) {
        if (roomItem.n() == null) {
            mm.b("Cannot send command to empty devices %s", roomItem);
            return;
        }
        adx adxVarN = roomItem.n();
        adxVarN.R().setRole(12345678);
        adxVarN.c(roomItem.j());
        adxVarN.c((byte) 0);
        adxVarN.e(roomItem.f());
        adxVarN.f(roomItem.h());
        adxVarN.h(roomItem.l());
        adxVarN.d(adxVarN.r());
        adxVarN.f(0);
        adw.a().z(adxVarN);
        mm.b("TEST_SETUP_COMMAND channel = %s , color = %s , roomID = %s , RoomName = %s , IconIndex = %s , GroupId = %s , is Master = %s, role = %s", Byte.valueOf(adxVarN.u()), Integer.valueOf(adxVarN.p()), Integer.valueOf(adxVarN.s()), adxVarN.w(), Integer.valueOf(adxVarN.v()), Integer.valueOf(adxVarN.r()), Byte.valueOf(adxVarN.t()), Integer.valueOf(adxVarN.R().getRole()));
    }

    @Override // defpackage.apt, defpackage.aoy
    public void b(RoomItem roomItem) {
        if (roomItem.n() == null) {
            mm.b("Cannot send command to empty devices %s", roomItem);
            return;
        }
        adx adxVarN = roomItem.n();
        adxVarN.R().setRole(12345678);
        adxVarN.c(roomItem.j());
        adxVarN.c((byte) 0);
        adxVarN.f(roomItem.h());
        adxVarN.h(roomItem.l());
        adxVarN.f(0);
        adw.a().z(adxVarN);
        mm.b("Edit Room SendCommandOneByOne device=%s ", adxVarN);
    }
}
