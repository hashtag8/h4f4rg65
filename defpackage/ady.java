package defpackage;

import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ady implements Serializable {
    public static adx a = null;
    private final int c;
    private final CopyOnWriteArrayList<adz> b = new CopyOnWriteArrayList<>();
    private final UUID d = UUID.randomUUID();
    private long e = 0;
    private short f = 2;

    public enum a {
        PATH_AUX,
        PATH_BT,
        PATH_SPOTIFY,
        PATH_GOOGLE_CAST,
        PATH_AIRPLAY,
        PATH_OPTICAL,
        PATH_HDMI,
        PATH_FC_IS_STREAMING_TO_DEVICE,
        PATH_FC_NOT_STREAMING_TO_DEVICE_IS_STREAMING,
        PATH_FC_NOT_STREAMING_TO_DEVICE_NOT_STREAMING
    }

    public ady(int i) {
        this.c = i;
    }

    public String toString() {
        return new bsc(this, new ahp()).a("groupId", this.c).a("name", i()).a("rooms", this.b.size()).h();
    }

    public void a(long j) {
        this.e = j;
    }

    public long a() {
        return this.e;
    }

    public boolean b() {
        return d() == -1;
    }

    public int c() {
        return this.b.size();
    }

    public int d() {
        return this.c;
    }

    public int e() {
        Iterator<adz> it = f().iterator();
        if (it.hasNext()) {
            return it.next().q();
        }
        return 0;
    }

    private List<adz> y() {
        ArrayList arrayList = new ArrayList(this.b);
        Collections.sort(arrayList, new Comparator<adz>() { // from class: ady.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(adz adzVar, adz adzVar2) {
                if (adzVar.h() == null && adzVar2.h() == null) {
                    return 0;
                }
                if (adzVar.h() != null || adzVar2.h() == null) {
                    return ((adzVar.h() == null || adzVar2.h() != null) && adzVar.h().P() <= adzVar2.h().P()) ? -1 : 1;
                }
                return -1;
            }
        });
        return Collections.unmodifiableList(arrayList);
    }

    public List<adz> f() {
        ArrayList arrayList = new ArrayList(this.b);
        Collections.sort(arrayList, new Comparator<adz>() { // from class: ady.2
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(adz adzVar, adz adzVar2) {
                return String.CASE_INSENSITIVE_ORDER.compare(adzVar.l(), adzVar2.l());
            }
        });
        return Collections.unmodifiableList(arrayList);
    }

    public List<adz> g() {
        return new ArrayList(this.b);
    }

    public int h() {
        Iterator<adz> it = f().iterator();
        if (it.hasNext()) {
            return it.next().n();
        }
        return 0;
    }

    public String i() {
        List<adz> listF = f();
        if (listF == null || listF.isEmpty()) {
            return "";
        }
        String strL = listF.get(0).l();
        if (aho.a("KEY_SHOW_ROOM_TYPE_IN_ROOM_NAME")) {
            strL = listF.get(0).l() + "  " + listF.get(0).w();
        }
        if (listF.size() > 1) {
            String strA = a(listF);
            if (strA != null && strA.length() > 25) {
                String strL2 = listF.get(0).l();
                if (strL2.length() > 21) {
                    strL2 = a(strL2, 18);
                }
                return HarmanApplication.a().getString(R.string.linkedGroup_plusName, new Object[]{strL2, Integer.valueOf(this.b.size() - 1)});
            }
            return strA;
        }
        if (strL != null && strL.length() > 25) {
            return a(strL, 22);
        }
        return strL;
    }

    private String a(List<adz> list) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<adz> it = list.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().l());
            stringBuffer.append(" + ");
        }
        stringBuffer.setLength(stringBuffer.length() - 3);
        return stringBuffer.toString();
    }

    private String a(String str, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.substring(0, i));
        stringBuffer.append("...");
        return stringBuffer.toString();
    }

    public boolean j() {
        return aof.a().o() == this;
    }

    public boolean a(adz adzVar) {
        return this.b.addIfAbsent(adzVar);
    }

    public boolean k() {
        Iterator<adz> it = this.b.iterator();
        while (it.hasNext()) {
            if (it.next().u()) {
                return true;
            }
        }
        return false;
    }

    public void a(boolean z) {
        mm.c("setStreaming, state=%b, this=%s", toString());
        Iterator<adz> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().d(z);
        }
    }

    public boolean l() {
        Iterator<adz> it = this.b.iterator();
        if (it.hasNext()) {
            return it.next().y();
        }
        return false;
    }

    public byte m() {
        adx adxVarQ = q();
        if (adxVarQ != null) {
            return adxVarQ.S();
        }
        return (byte) 32;
    }

    public void b(boolean z) {
        Iterator<adz> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().b(z);
        }
    }

    public int n() {
        int iZ = 0;
        Iterator<adz> it = this.b.iterator();
        while (true) {
            int i = iZ;
            if (it.hasNext()) {
                iZ = it.next().z() + i;
            } else {
                return i;
            }
        }
    }

    public List<adx> o() {
        ArrayList arrayList = new ArrayList();
        Iterator<adz> it = this.b.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().k());
        }
        return arrayList;
    }

    public boolean b(adz adzVar) {
        return this.b.remove(adzVar);
    }

    public boolean c(adz adzVar) {
        Iterator<adz> it = this.b.iterator();
        while (it.hasNext()) {
            if (it.next().s() == adzVar.s()) {
                return true;
            }
        }
        return false;
    }

    public boolean a(adx adxVar) {
        Iterator<adz> it = this.b.iterator();
        while (it.hasNext()) {
            if (it.next().b(adxVar) && adxVar.r() == this.c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return new bry(71287, 1319).d(this.d).b();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() == getClass()) {
            return new brx().a(this.d, ((ady) obj).d).a();
        }
        return false;
    }

    public void p() {
        if (!a(a)) {
            List<adz> listY = y();
            if (listY != null && !listY.isEmpty()) {
                a = listY.get(0).h();
                adw.a().H(a);
                return;
            }
            return;
        }
        adw.a().H(a);
    }

    public adx q() {
        int i;
        int iA;
        int i2 = 0;
        adz adzVar = null;
        for (adz adzVar2 : this.b) {
            adx adxVarE = adzVar2.e();
            if (adxVarE == null || ((iA = adz.a(adxVarE)) <= i2 && adzVar != null)) {
                adzVar2 = adzVar;
                i = i2;
            } else {
                i = iA;
            }
            i2 = i;
            adzVar = adzVar2;
        }
        if (adzVar == null) {
            return null;
        }
        return adzVar.e();
    }

    public a r() {
        return m() == 3 ? a.PATH_AUX : m() == 2 ? a.PATH_BT : m() == 33 ? a.PATH_SPOTIFY : m() == 34 ? a.PATH_GOOGLE_CAST : m() == 1 ? a.PATH_AIRPLAY : m() == 4 ? a.PATH_OPTICAL : m() == 16 ? a.PATH_HDMI : j() ? a.PATH_FC_IS_STREAMING_TO_DEVICE : k() ? a.PATH_FC_NOT_STREAMING_TO_DEVICE_IS_STREAMING : a.PATH_FC_NOT_STREAMING_TO_DEVICE_NOT_STREAMING;
    }

    private List<adx> z() {
        ArrayList arrayList = new ArrayList();
        for (adx adxVar : o()) {
            if (adxVar.N()) {
                arrayList.add(adxVar);
            }
        }
        return arrayList;
    }

    private List<adx> A() {
        ArrayList arrayList = new ArrayList();
        for (adx adxVar : o()) {
            if (adxVar.O()) {
                arrayList.add(adxVar);
            }
        }
        return arrayList;
    }

    public int s() {
        List<adx> listZ = z();
        if (listZ == null || listZ.isEmpty()) {
            return 0;
        }
        return listZ.size();
    }

    public int t() {
        List<adx> listA = A();
        if (listA == null || listA.isEmpty()) {
            return 0;
        }
        return listA.size();
    }

    public boolean u() {
        return s() > 0 && s() == n();
    }

    public boolean v() {
        return t() > 0 && t() == n();
    }

    public short w() {
        short sG;
        if (o() == null || o().size() == 0) {
            return (short) 0;
        }
        mm.b("FcLinkedGroup ..", " List has values");
        try {
            if (u() || v()) {
                sG = o().get(0).g();
            } else {
                Iterator<adx> it = o().iterator();
                while (true) {
                    if (it.hasNext()) {
                        adx next = it.next();
                        if (next.O()) {
                            sG = next.g();
                            break;
                        }
                    } else {
                        mm.b("FcLinkedGroup ..", " returning.. ");
                        sG = o().get(0).g();
                        break;
                    }
                }
            }
            return sG;
        } catch (IndexOutOfBoundsException e) {
            mm.b("FcLinkedGroup ..", " IndexOutOfBoundsException returning 0 .. ");
            return (short) 0;
        } catch (Exception e2) {
            mm.b("FcLinkedGroup ..", " Exception returning 0 .. ");
            return (short) 0;
        }
    }

    public adx x() {
        for (adx adxVar : o()) {
            if (adxVar.L()) {
                return adxVar;
            }
        }
        return null;
    }
}
