package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class aoz {
    public static List<adx> a(List<adx> list) {
        ArrayList arrayList = new ArrayList();
        for (adx adxVar : list) {
            mm.b("FAKE_DATE_TEST, roomId = %s , the name = %s,uuid = %s", "" + adxVar.s(), adxVar.i(), Long.valueOf(adxVar.P()));
            mm.b(adxVar.d(), Byte.valueOf(adxVar.q()));
            if (adxVar.s() == 0 || adxVar.s() == 65535) {
                if (adxVar.N() || adxVar.O()) {
                    mm.c();
                }
                arrayList.add(adxVar);
            }
        }
        return arrayList;
    }

    public static List<adx> b(List<adx> list) {
        ArrayList arrayList = new ArrayList();
        for (adx adxVar : list) {
            mm.b("FAKE_DATE_TEST, roomId = %s , the name = %s", "" + adxVar.s(), adxVar.i());
            mm.b(adxVar.d(), Byte.valueOf(adxVar.q()));
            if (adxVar.s() == 0 || adxVar.s() == 65535) {
                if (!adxVar.H() && !adxVar.I()) {
                    arrayList.add(adxVar);
                }
            }
        }
        return arrayList;
    }

    public static List<adx> c(List<adx> list) {
        ArrayList arrayList = new ArrayList();
        for (adx adxVar : list) {
            mm.b("FAKE_DATE_TEST, roomId = %s , the name = %s", "" + adxVar.s(), adxVar.i());
            mm.b(adxVar.d(), Byte.valueOf(adxVar.q()));
            if (adxVar.s() == 0 || adxVar.s() == 65535) {
                if (adxVar.q() == 4 || adxVar.q() == 5 || adxVar.q() == 6) {
                    arrayList.add(adxVar);
                }
            }
        }
        return arrayList;
    }

    public static boolean d(List<adx> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i).q() != list.get(i2).q()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean e(List<adx> list) {
        Iterator<adx> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().H()) {
                return true;
            }
        }
        return false;
    }

    public static boolean f(List<adx> list) {
        Iterator<adx> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().I()) {
                return true;
            }
        }
        return false;
    }

    public static boolean g(List<adx> list) {
        for (adx adxVar : list) {
            mm.b("FAKE_DATE_TEST, roomId = %s , the name = %s", "" + adxVar.s(), adxVar.i());
            if (adxVar.s() == 0 || adxVar.s() == 65535) {
                return true;
            }
        }
        return false;
    }

    public static List<adx> h(List<adx> list) {
        ArrayList arrayList = new ArrayList();
        for (adx adxVar : list) {
            if (adxVar.s() == 0 || adxVar.s() == 65535 || adxVar.u() == -1) {
                if (adxVar.q() == 4 || adxVar.q() == 5 || adxVar.q() == 6 || adxVar.q() == 1 || adxVar.q() == 2) {
                    arrayList.add(adxVar);
                }
            }
        }
        return arrayList;
    }

    public static List<adx> a(List<adx> list, byte b) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (list.get(i2).q() == b) {
                    arrayList.add(list.get(i2));
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    public static List<adx> i(List<adx> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (list.get(i2).q() == 12 || list.get(i2).q() == 7 || list.get(i2).q() == 3) {
                    arrayList.add(list.get(i2));
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    public static List<adx> j(List<adx> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if ((list.get(i2).q() == 12 || list.get(i2).q() == 7 || list.get(i2).q() == 3) && (list.get(i2).s() == 0 || list.get(i2).s() == 65535)) {
                    arrayList.add(list.get(i2));
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    public static List<adx> b(List<adx> list, byte b) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (list.get(i2).q() == b && (list.get(i2).s() == 0 || list.get(i2).s() == 65535)) {
                    arrayList.add(list.get(i2));
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    public static List<adx> c(List<adx> list, byte b) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (list.get(i2).q() == b) {
                    list.remove(i2);
                    i2--;
                }
                i = i2 + 1;
            } else {
                return list;
            }
        }
    }

    public static boolean a(List<Long> list, List<adx> list2) {
        mm.a((Object) ("isSetupAllSpeakersSuccess uuids.size() = " + list.size() + ",uuids = " + list));
        mm.a((Object) ("isSetupAllSpeakersSuccess devices.size() = " + list2.size()));
        if (list == null || list.isEmpty()) {
            return false;
        }
        int i = 0;
        for (adx adxVar : list2) {
            mm.a((Object) ("isSetupAllSpeakersSuccess device.uuid = " + adxVar.P()));
            i = list.contains(Long.valueOf(adxVar.P())) ? i + 1 : i;
        }
        return i == list.size();
    }

    public static void a(adx adxVar) {
        if (!adxVar.Y() || !adxVar.Z()) {
            byte[] bArrAk = adxVar.ak();
            byte[] bArr = new byte[12];
            if (bArrAk == null || bArrAk.length < 12) {
                mm.b("content is null or content is not ok", new Object[0]);
                return;
            }
            System.arraycopy(bArrAk, 8, bArr, 0, 11);
            bArr[0] = -1;
            bArr[6] = 0;
            mm.b("5.1 source optical/aux Movie mode 111111 or Audio mode 0000000 ? is  " + Integer.toBinaryString((bArr[6] & 255) + 256).substring(1), new Object[0]);
            adw.a().a(adxVar, new aei(new byte[]{7, 41}, bArr));
        }
    }
}
