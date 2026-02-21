package defpackage;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bfrx.Device;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class adx extends aee implements Serializable {
    public static boolean a = true;
    public static boolean b = false;
    private String h;
    private boolean i;
    private byte[] j;
    private boolean k;
    private boolean l;
    private Device s;
    private aea t;
    private String f = null;
    private String g = null;
    private byte m = -1;
    private boolean n = false;
    private int o = 0;
    private String p = null;
    private short q = 2;
    private int r = -1;
    private aeb u = new aeb();
    private byte v = -1;
    private String w = "";
    private byte x = -1;
    private boolean y = false;
    private aec<Byte> z = new aec<>((byte) -1);
    private byte A = -1;
    private byte B = -1;
    private byte C = -1;
    private byte D = -1;
    private byte E = -1;
    private byte F = -1;
    private byte G = -1;
    private byte H = -1;
    private byte I = -1;
    private Set<Integer> J = Collections.synchronizedSet(new HashSet());
    private Set<Integer> K = Collections.synchronizedSet(new HashSet());
    private Set<Integer> L = Collections.synchronizedSet(new HashSet());
    private Set<Integer> M = Collections.synchronizedSet(new HashSet());
    private Set<String> N = Collections.synchronizedSet(new HashSet());
    private Set<String> O = Collections.synchronizedSet(new HashSet());
    private Set<Byte> P = Collections.synchronizedSet(new HashSet());
    private boolean Q = false;
    private boolean R = a;
    private Boolean S = null;
    private long T = 0;
    private short U = 0;
    private short V = 0;
    private boolean W = false;
    private boolean X = true;
    public boolean c = false;

    public String a() {
        return this.f;
    }

    public void a(String str) {
        this.f = str;
    }

    public String b() {
        return this.g;
    }

    public void b(String str) {
        this.g = str;
    }

    public String c() {
        return this.h;
    }

    public void c(String str) {
        this.h = str;
    }

    public void a(int i) {
        this.r = i;
    }

    public String d() {
        return this.p;
    }

    public String e() {
        if (TextUtils.isEmpty(d())) {
            return "";
        }
        if (d().length() < 4) {
            return d();
        }
        String strSubstring = d().substring(d().length() - 4, d().length());
        if (TextUtils.isEmpty(strSubstring)) {
            return d();
        }
        return strSubstring.replace("-", "");
    }

    public void d(String str) {
        this.p = str;
    }

    public adx(Device device) {
        device.volumeLevel = j(device.volumeLevel);
        this.s = device;
    }

    public adx(Device device, aea aeaVar) {
        device.volumeLevel = j(device.volumeLevel);
        this.t = aeaVar;
        this.s = device;
    }

    public short f() {
        return this.U;
    }

    public void a(short s) {
        this.U = s;
    }

    public short g() {
        return N() ? this.q : this.V;
    }

    public void b(short s) {
        this.V = s;
    }

    public void a(aea aeaVar) {
        this.t = aeaVar;
    }

    public aea h() {
        return this.t;
    }

    public String i() {
        return this.s.getMkGroupName();
    }

    public void e(String str) {
        this.W = true;
        this.N.add(x());
        this.N.remove(str);
        this.s.setMkGroupName(str);
    }

    public void a(byte b2) {
        this.E = b2;
    }

    public byte j() {
        return this.E;
    }

    public void b(byte b2) {
        this.D = b2;
    }

    public byte k() {
        return this.D;
    }

    public long l() {
        String str = new String(this.s.groupName);
        if (str.contains("#&#")) {
            return Long.parseLong(str.substring(0, 10));
        }
        return -1L;
    }

    public String m() {
        String str = new String(this.s.groupName);
        return str.contains("#&#") ? str.substring(13, str.indexOf(0)) : "";
    }

    public byte[] n() {
        return this.s.getMkVersion();
    }

    public byte[] o() {
        return this.s.getMkVersionOfPrivateC();
    }

    public int p() {
        return b(this.s.getMkColorIndex());
    }

    public int b(int i) {
        if (i < 0 || i >= ain.y.length) {
            return 0;
        }
        return i;
    }

    public void c(int i) {
        this.W = true;
        this.L.add(Integer.valueOf(p()));
        this.L.remove(Integer.valueOf(i));
        this.s.setMkColorIndex(i);
    }

    public byte q() {
        return this.s.getMkType();
    }

    public int r() {
        return this.s.getMkGroupId();
    }

    public void d(int i) {
        this.J.remove(Integer.valueOf(i));
        this.X = true;
        if (i != r()) {
            this.W = true;
            this.J.add(Integer.valueOf(r()));
            this.s.setMkGroupId(i);
        }
    }

    public int s() {
        return this.s.getMkRoomId();
    }

    public void e(int i) {
        this.W = true;
        this.K.add(Integer.valueOf(s()));
        this.K.remove(Integer.valueOf(i));
        this.s.setMkRoomId(i);
    }

    public byte t() {
        return this.s.getMkMaster();
    }

    public void f(int i) {
        this.W = true;
        this.s.setMkMaster(i);
    }

    public byte u() {
        return this.s.getMkChannelType();
    }

    public void c(byte b2) {
        this.W = true;
        this.P.add(Byte.valueOf(u()));
        this.P.remove(Byte.valueOf(b2));
        this.s.setMkChannelType(b2);
    }

    public int v() {
        return g(this.s.getMkIconIndex());
    }

    public int g(int i) {
        if (i < 0 || i >= ain.s.length) {
            return 0;
        }
        return i;
    }

    public void h(int i) {
        this.W = true;
        this.M.add(Integer.valueOf(g(this.s.getMkIconIndex())));
        this.M.remove(Integer.valueOf(i));
        this.s.setMkIconIndex(i);
    }

    public String w() {
        return this.s.getMkRoomName();
    }

    public void f(String str) {
        this.W = true;
        this.O.add(w());
        this.O.remove(str);
        this.s.setMkRoomName(str);
    }

    public String x() {
        switch (this.s.getMkType()) {
            case 1:
                return "Omni_MKI_10";
            case 2:
                return "Omni_MKI_20";
            case 3:
                return "Omni_MKI_Adapt";
            case 4:
                return "OMNI_10+";
            case 5:
                return "OMNI_20+";
            case 6:
                return "OMNI_50+";
            case 7:
                return " OMNI_ADAPT+";
            case 8:
                return "OMNI_BAR+";
            case 9:
                return "JBL Link 30";
            case 10:
                return "JBL Link 50";
            case 11:
                return "JBL Link Bar";
            case 12:
                return " OMNI_ADAPT+AMP";
            default:
                return "Unassigned Device Name";
        }
    }

    @Override // defpackage.aed
    public void a(Handler handler, int i) {
        super.a(handler, i);
    }

    public String toString() {
        return new bsc(this, new ahp()).a("uuid", P()).a("streamingStatus", T()).a("hashCode", hashCode()).a("room", w()).a("  device", this.s).a("channel", u()).a("type", q()).a("roomId", s()).a("groupId", r()).a("colorIndex", p()).a("roomIconIndex", v()).a("isDirty", X()).a("lastGroupIds", this.J).a("deviceSource", this.z).a("volume", B()).a("version", ahv.a(n())).a("RSSI", f()).a("isMaster", L()).a("isConnect", this.i).a("networkInterface", this.H).a("wifiBand", this.I).a("Device ip", z()).a("Wifi Channel", this.V).a("googlecast_tos_status", this.m).h();
    }

    public boolean y() {
        return this.A == 1;
    }

    @Override // defpackage.aed
    public void b(Handler handler, int i) {
        if (!this.Q) {
            aev aevVar = new aev();
            if (i == 6003) {
                if (this.d == null) {
                    this.d = new aet(handler, new aeu());
                }
                if (this.e == null) {
                    this.e = new aem(this, aevVar);
                    return;
                }
                return;
            }
            if (i == 6001) {
                this.d = new aet(handler, aevVar);
                this.e = new aen(this, aevVar);
            }
        }
    }

    @Override // defpackage.aed
    public String z() {
        return ahd.a(this.s.deviceIp);
    }

    public void a(aep aepVar) {
        if (this.e != null) {
            this.e.a(aepVar);
        }
    }

    public void a(Handler handler) {
        if (this.e != null) {
            this.e.a(handler);
        }
    }

    public void a(boolean z) {
        if (z) {
            adw.a().B(this);
        } else {
            adw.a().A(this);
        }
    }

    public int A() {
        return q() == 12 ? ain.r[9] : q() >= ain.r.length ? ain.r[ain.r.length - 2] : ain.r[q()];
    }

    public void i(int i) {
        this.W = true;
        this.s.volumeLevel = j(i);
    }

    public static int j(int i) {
        return Math.max(Math.min(i, 47), 0);
    }

    public int B() {
        return this.s.volumeLevel;
    }

    @Override // defpackage.aed
    public void C() {
        super.C();
        this.Q = false;
    }

    public byte D() {
        if (this.B == -1) {
            return (byte) 6;
        }
        return this.B;
    }

    public void b(boolean z) {
        this.y = z;
    }

    public boolean E() {
        boolean z = true;
        for (byte b2 : this.s.getMkVersion()) {
            if (b2 != 0) {
                z = false;
            }
        }
        if (M() == null) {
            mm.b("Upgrade version not set, cannot upgrade if required %s %s", Boolean.valueOf(z), this);
        }
        return z && M() != null;
    }

    public boolean F() {
        return q() == 1 || q() == 2 || q() == 4 || q() == 5;
    }

    public boolean G() {
        return q() == 2 || q() == 5;
    }

    public boolean H() {
        return q() == 3 || q() == 7 || q() == 12;
    }

    public boolean I() {
        return q() == 8;
    }

    public boolean J() {
        return q() == 1 || q() == 4;
    }

    public boolean K() {
        return q() == 6;
    }

    public boolean L() {
        return this.s.getMkMaster() != 1;
    }

    public asz M() {
        if (N()) {
            return atb.b.get("omni");
        }
        if (this.t != null) {
            return aea.h;
        }
        return null;
    }

    public boolean N() {
        return afc.b(this.s);
    }

    public boolean O() {
        return afc.c(this.s);
    }

    public long P() {
        return this.s.uniqueID;
    }

    public boolean a(Device device) {
        boolean z;
        if (this.J.contains(Integer.valueOf(device.getMkGroupId()))) {
            device.setMkGroupId(this.s.getMkGroupId());
        } else {
            this.J.clear();
        }
        if (this.K.contains(Integer.valueOf(device.getMkRoomId()))) {
            device.setMkRoomId(this.s.getMkRoomId());
        } else {
            this.K.clear();
        }
        if (this.L.contains(Integer.valueOf(b(device.getMkColorIndex())))) {
            device.setMkColorIndex(b(this.s.getMkColorIndex()));
        } else {
            this.L.clear();
        }
        if (this.N.contains(device.getMkGroupName())) {
            device.setMkGroupName(this.s.getMkGroupName());
        } else {
            this.N.clear();
        }
        if (this.O.contains(device.getMkRoomName())) {
            device.setMkRoomName(this.s.getMkRoomName());
        } else {
            this.O.clear();
        }
        if (this.M.contains(Integer.valueOf(g(device.getMkIconIndex())))) {
            device.setMkIconIndex(g(this.s.getMkIconIndex()));
        } else {
            this.M.clear();
        }
        if (this.P.contains(Byte.valueOf(device.getMkChannelType()))) {
            device.setMkChannelType(this.s.getMkChannelType());
        } else {
            this.P.clear();
        }
        if (Arrays.equals(device.copyGroupName(), this.s.copyGroupName())) {
            z = false;
        } else {
            if (device.getMkGroupId() != this.s.getMkGroupId()) {
                this.X = false;
            }
            mm.b("copyGroupName changed", new Object[0]);
            z = true;
        }
        if (!Arrays.equals(device.copyLabel(), this.s.copyLabel())) {
            mm.b("copyLabel changed", new Object[0]);
            z = true;
        }
        if (device.uniqueID != this.s.uniqueID) {
            mm.b("uniqueID changed", new Object[0]);
            z = true;
        }
        if (device.deviceIp != this.s.deviceIp) {
            mm.b("deviceIp changed", new Object[0]);
            z = true;
        }
        int i = this.s.volumeLevel;
        device.volumeLevel = j(device.volumeLevel);
        if (device.volumeLevel != this.s.volumeLevel) {
            mm.a((Object) ("jump volume lastvolume = " + i + "  currentvolume = " + device.volumeLevel));
        }
        this.s = device;
        if (ain.E) {
            this.s.volumeLevel = i;
        }
        if (z) {
            this.W = true;
        }
        return z;
    }

    public int hashCode() {
        return new bry(883471, 643).a(P()).b();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() == getClass()) {
            return new brx().a(P(), ((adx) obj).P()).a();
        }
        return false;
    }

    public void Q() {
        this.s.setRole(21);
        e(0);
        f("");
        d(ahk.a());
        e("");
        c((byte) -1);
        b(false);
        f(0);
        adw.a().z(this);
        this.B = (byte) 6;
        adw.a().v(this);
        a(false);
        this.W = true;
    }

    public Device R() {
        return this.s;
    }

    public byte S() {
        return this.z.a().byteValue();
    }

    public void d(byte b2) {
        this.z.a(Byte.valueOf(b2));
    }

    public void e(byte b2) {
        this.z.b(Byte.valueOf(b2));
    }

    public byte T() {
        return this.A;
    }

    public void f(byte b2) {
        if (b2 == 1) {
            mm.b("setStreamingStatus %s,%s", this.s, Byte.valueOf(b2));
            mm.c();
        }
        this.A = b2;
    }

    public void g(byte b2) {
        this.B = b2;
    }

    public byte U() {
        return this.C;
    }

    public void h(byte b2) {
        this.C = b2;
    }

    public boolean V() {
        return this.R;
    }

    public void c(boolean z) {
        this.R = z;
    }

    public boolean W() {
        return this.X;
    }

    public boolean X() {
        return this.W;
    }

    public void d(boolean z) {
        this.W = z;
    }

    public boolean Y() {
        return this.k;
    }

    public void e(boolean z) {
        this.k = z;
    }

    public boolean Z() {
        return this.l;
    }

    public void f(boolean z) {
        this.l = z;
    }

    public void g(boolean z) {
        this.S = Boolean.valueOf(z);
        this.T = SystemClock.elapsedRealtime();
    }

    public void h(boolean z) {
        this.n = z;
    }

    public adx aa() {
        adx adxVar = new adx(new Device(this.s));
        adxVar.D = this.D;
        adxVar.E = this.E;
        return adxVar;
    }

    public void a(adx adxVar) {
        f((int) adxVar.k());
        h((int) adxVar.j());
        e(((int) adxVar.l()) % 65536);
        f(adxVar.m());
        c(ahk.a(ain.y.length));
        mm.b("Test store gen1 UUID = %s ,MASTER = %s , IconIndex= %s , RoomId = %s ,RoomName = %s , colorIndex= %s ,role=%s", Long.valueOf(adxVar.P()), Byte.valueOf(adxVar.k()), Byte.valueOf(adxVar.j()), Integer.valueOf(((int) adxVar.l()) % 65536), adxVar.m(), Integer.valueOf(ahk.a(ain.y.length)), Integer.valueOf(adxVar.s.getRole()));
        if (adxVar.s.getRole() == 21) {
            c((byte) 0);
        } else {
            c((byte) 1);
        }
        adw.a().z(this);
    }

    public boolean ab() {
        return k() != -1;
    }

    public byte ac() {
        return this.H;
    }

    public boolean ad() {
        return ac() == 1 && ae() == 1;
    }

    public void i(byte b2) {
        this.H = b2;
    }

    public byte ae() {
        return this.I;
    }

    public void j(byte b2) {
        this.I = b2;
    }

    private String h(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str == null) {
            return "";
        }
        if (str.length() < 12) {
            for (int length = str.length(); length < 12; length++) {
                stringBuffer.append("0");
            }
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public void af() {
        String strH = h(Long.toHexString(this.s.uniqueID));
        if (strH.length() == 12) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 5; i > -1; i--) {
                stringBuffer.append(strH.substring(i * 2, (i * 2) + 2).toLowerCase());
                if (i != 0) {
                    stringBuffer.append("-");
                }
            }
            d(stringBuffer.toString());
            return;
        }
        mm.b("invalid uniqueID can't change to macAddress", new Object[0]);
    }

    public aeb ag() {
        return this.u;
    }

    public void a(aeb aebVar) {
        this.u = aebVar;
    }

    public void k(byte b2) {
        this.v = b2;
    }

    public void g(String str) {
        this.w = str;
    }

    public String ah() {
        return this.w;
    }

    public long ai() {
        double d = 180.0d;
        if (O() && this.t != null && this.t.c != -1) {
            d = (180.0d + ((this.t.c / 1048576) * 5)) / 60.0d;
            mm.b("UNIT_TEST firmware size = %s , spendTime = %s,download spend time", Long.valueOf(this.t.c), Double.valueOf(d), Long.valueOf((this.t.c / 1024) / 1024));
        }
        return (long) Math.ceil(d);
    }

    public void l(byte b2) {
        this.m = b2;
    }

    public byte aj() {
        return this.m;
    }

    public void a(byte[] bArr) {
        this.j = bArr;
    }

    public byte[] ak() {
        return this.j;
    }

    public int al() {
        return this.o;
    }

    public void k(int i) {
        this.o = i;
    }
}
