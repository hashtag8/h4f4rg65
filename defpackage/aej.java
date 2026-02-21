package defpackage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.harman.commom.device.process.communicate.imp.WifiMode;
import com.harman.hkconnect.ui.FOTAToolSetUrlActivity;
import com.harman.hkconnect.ui.HarmanApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class aej extends aeq {
    private a c;
    private int d;
    private HandlerThread e;
    private adx f;
    private long g;

    public aej(Handler handler, adx adxVar) {
        super(handler, adxVar);
        this.f = adxVar;
        a();
    }

    public aej(adx adxVar) {
        super(adxVar);
        this.f = adxVar;
    }

    public void a(Handler handler) {
        this.a = handler;
    }

    @Override // defpackage.aeq
    public void a(aep aepVar) {
        if (aepVar != null) {
            byte[] bArrB = ((aei) aepVar).b();
            switch (bArrB[2]) {
                case 2:
                case 8:
                    B(bArrB);
                    break;
                case 4:
                    if (bArrB[3] == 6) {
                        mm.b("sent volume %s", this.f);
                        v(bArrB);
                        break;
                    } else if (bArrB[3] == 8) {
                        mm.b("sent key event", this.f);
                        o(bArrB);
                        break;
                    } else if (bArrB[3] != 4 && bArrB[3] == 12) {
                        m(bArrB);
                        break;
                    }
                    break;
                case 5:
                    mm.b("sent upgrading %s", this.f);
                    if (bArrB[3] == 97) {
                        i(bArrB);
                    } else {
                        w(bArrB);
                    }
                    break;
                case 6:
                    d(bArrB);
                    break;
                case 7:
                    if (bArrB[3] == 10) {
                        A(bArrB);
                    } else if (bArrB[3] == 15) {
                        mm.b("berton receive 0x0F", "");
                        n(bArrB);
                    } else if (bArrB[3] == 18) {
                        C(bArrB);
                    } else if (bArrB[3] == 13) {
                        l(bArrB);
                        a(32);
                    } else if (bArrB[3] == 20) {
                        this.f.k(bArrB[8]);
                        mm.a("Test_GoogleCast_private", bArrB);
                    } else if (bArrB[3] == 27) {
                        j(bArrB);
                        a(32);
                    } else if (bArrB[3] == 22) {
                        k(bArrB);
                        mm.a("Test_GoogleCast_private", bArrB);
                    } else if (bArrB[3] == 29) {
                        g(bArrB);
                        mm.b("Test_Playback_Time_Version_private", bArrB);
                    } else if (bArrB[3] == 35) {
                        e(bArrB);
                        mm.b("parseGooglecast_tos_status", bArrB);
                    } else if (bArrB[3] == 34) {
                        h(bArrB);
                        mm.b("Test_Spotity_Shuffle_And_Repeat_Status", bArrB);
                    } else if (bArrB[3] == 38) {
                        c(bArrB);
                        mm.b("parseConnectStatus", Arrays.toString(bArrB));
                    } else if (bArrB[3] == 40) {
                        b(bArrB);
                        mm.b("parseSourceSetup", Arrays.toString(bArrB));
                    } else if (bArrB[3] == 49) {
                        a(bArrB);
                        mm.b("parseSubscribeEvent", Arrays.toString(bArrB));
                    } else if (bArrB[3] == 46) {
                        f(bArrB);
                        mm.b("parseNetworkMode", Arrays.toString(bArrB));
                    } else {
                        int iS = s(bArrB);
                        if (iS == 1) {
                            mm.b("parsePrivateData---->1", new Object[0]);
                        } else if (iS > 1) {
                            a(iS);
                        }
                    }
                    break;
            }
        }
    }

    private void a(byte[] bArr) {
        mm.b("SpotifySubscribe parseSubscribeEvent.. ", new Object[0]);
        byte b = bArr[8];
        mm.b("SpotifySubscribe parseSubscribeEvent..SubscribeResult = " + ((int) b), new Object[0]);
        Intent intent = new Intent("SpotifySubscriptionResponse");
        intent.putExtra("SubscribeResult", (int) b);
        HarmanApplication.a().sendBroadcast(intent);
    }

    private void b(byte[] bArr) {
        if (this.f != null) {
            mm.b("5.1 source content  ====", Arrays.toString(bArr), mk.b(bArr), this.f.d());
            try {
                char[] charArray = Integer.toBinaryString((bArr[8] & 255) + 256).substring(1).toCharArray();
                char[] charArray2 = Integer.toBinaryString((bArr[14] & 255) + 256).substring(1).toCharArray();
                mm.b("sourceChars[3]=  " + charArray[4] + "channelChars[3] = " + charArray2[4], new Object[0]);
                mm.b("sourceChars[4]=  " + charArray[3] + "channelChars[4] = " + charArray2[3], new Object[0]);
                if (charArray[4] == '1') {
                    if (charArray2[4] == '0') {
                        this.f.e(true);
                    } else if (charArray2[4] == '1') {
                        this.f.e(false);
                    }
                }
                if (charArray[3] == '1') {
                    if (charArray2[3] == '0') {
                        this.f.f(true);
                    } else if (charArray2[3] == '1') {
                        this.f.f(false);
                    }
                }
                this.f.a(bArr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void c(byte[] bArr) {
        long j = ((long) (bArr[8] & 255)) | (((long) (bArr[9] & 255)) << 8) | (((long) (bArr[10] & 255)) << 16) | (((long) (bArr[11] & 255)) << 24) | (((long) (bArr[12] & 255)) << 32) | (((long) (bArr[13] & 255)) << 40);
        adx adxVarA = aof.a().a(j);
        boolean z = bArr[16] == 0;
        if (adxVarA != null) {
            if (z) {
                ain.a(j);
            } else {
                mm.b("5.1 system test", "Removing UUID= %d from p2p list and isConnect=false", Long.valueOf(j));
                ain.d(j);
            }
        }
        mm.b("5.1 system test", "parseConnectStatus for p2p isConnect = " + z, adxVarA, adxVarA.d());
    }

    private void d(byte[] bArr) {
        mm.a("TEST_DEVICE_CURRENT_VERSION = %s", bArr);
        if (this.f != null) {
            byte[] bArr2 = {bArr[11], bArr[10], bArr[9], bArr[8]};
            mm.b("TEST_DEVICE_CURRENT_VERSION = %s", ahv.a(bArr2));
            this.f.R().setMkVersion(bArr2);
            if (bArr.length >= 14) {
                byte[] bArr3 = {bArr[12], bArr[13]};
                mm.b("Test_originalCode mDeviceFc mac = %s ,version = %s", this.f.d(), new String(bArr3));
                mm.a("Test_originalCode originalCode ", bArr3);
                this.f.c(new String(bArr3));
            }
        }
    }

    private void e(byte[] bArr) {
        if (this.f != null && bArr != null && bArr.length >= 9) {
            this.f.l(bArr[8]);
        }
    }

    private void f(byte[] bArr) {
        if (this.f != null && bArr != null && bArr.length >= 9) {
            mm.b("parseNetworkMode = %s", Byte.valueOf(bArr[8]));
            this.f.a((int) bArr[8]);
        }
    }

    private void g(byte[] bArr) {
        mm.b(bArr);
        aeb aebVarAg = this.f.ag();
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 8, bArr2, 0, 4);
        byte[] bArr3 = new byte[4];
        System.arraycopy(bArr, 12, bArr3, 0, 4);
        try {
            long jE = mk.e(bArr2);
            if (this.g != mk.e(bArr3)) {
                mm.b("alan test time change, send command to enquiry", Long.valueOf(this.g));
                this.g = mk.e(bArr3);
                adw.a().b();
            } else {
                mm.b("alan test time un change", Long.valueOf(this.g));
            }
            mm.a((Object) ("current_playback_time = " + jE));
            mm.a((Object) ("current_track_length = " + this.g));
            aebVarAg.b(jE);
            aebVarAg.a(this.g);
            HarmanApplication.a().sendBroadcast(new Intent("updateSpotifyTime"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void h(byte[] bArr) {
        byte[] bArr2 = new byte[1];
        System.arraycopy(bArr, 8, bArr2, 0, 1);
        byte[] bArr3 = new byte[1];
        System.arraycopy(bArr, 9, bArr3, 0, 1);
        mk.b(bArr2);
        try {
            short sA = mk.a(bArr2);
            short sA2 = mk.a(bArr3);
            mm.a((Object) ("repeatStatus = " + ((int) sA)));
            mm.a((Object) ("repeatStatus = " + ((int) sA2)));
            if (sA == 1) {
                e();
            } else if (sA == 2) {
                d();
            } else {
                c();
            }
            if (sA2 == 1) {
                i();
            } else {
                g();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void i(byte[] bArr) {
        mm.b(bArr);
        byte b = bArr[8];
        Intent intent = new Intent();
        intent.setAction(FOTAToolSetUrlActivity.a);
        intent.putExtra("TreeType", b);
        FOTAToolSetUrlActivity.i.sendBroadcast(intent);
    }

    private void j(byte[] bArr) {
        aeb aebVarAg = this.f.ag();
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 8, bArr2, 0, 4);
        int iD = mk.d(bArr2);
        mm.a((Object) ("length = " + iD));
        byte[] bArr3 = new byte[iD];
        System.arraycopy(bArr, 12, bArr3, 0, iD);
        try {
            String str = new String(bArr3, HTTP.UTF_8);
            mm.a((Object) ("url = " + str));
            aebVarAg.e(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void k(byte[] bArr) {
        byte[] bArr2 = new byte[bArr[8]];
        System.arraycopy(bArr, 9, bArr2, 0, bArr2.length);
        mm.b("Test_GoogleCast_private mDeviceFc mac = %s ,version = %s", this.f.d(), new String(bArr2));
        mm.a("Test_GoogleCast_private googleversion ", bArr2);
        this.f.g(new String(bArr2));
    }

    private void l(byte[] bArr) {
        aeb aebVarAg = this.f.ag();
        aebVarAg.c(mk.e(new byte[]{bArr[8], bArr[9], bArr[10], bArr[11]}));
        byte[] bArr2 = new byte[bArr[12]];
        System.arraycopy(bArr, 13, bArr2, 0, bArr2.length);
        aebVarAg.a(new String(bArr2));
        int length = bArr2.length + 12 + 1;
        byte[] bArr3 = new byte[bArr[length]];
        System.arraycopy(bArr, length + 1, bArr3, 0, bArr3.length);
        aebVarAg.c(new String(bArr3));
        int length2 = length + bArr3.length + 1;
        byte[] bArr4 = new byte[bArr[length2]];
        System.arraycopy(bArr, length2 + 1, bArr4, 0, bArr4.length);
        aebVarAg.b(new String(bArr4));
        int length3 = length2 + bArr4.length + 1;
        byte[] bArr5 = new byte[bArr[length3]];
        System.arraycopy(bArr, length3 + 1, bArr5, 0, bArr5.length);
        aebVarAg.d(new String(bArr5));
        this.f.a(aebVarAg);
        Intent intent = new Intent("updateUI");
        mm.b("alan test", "update spotify ui meta info =" + aebVarAg);
        HarmanApplication.a().sendBroadcast(intent);
        mm.a(aebVarAg);
    }

    private void m(byte[] bArr) {
        byte[] bArr2 = new byte[6];
        System.arraycopy(bArr, 8, bArr2, 0, bArr2.length);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; bArr2 != null && i < bArr2.length; i++) {
            String hexString = Integer.toHexString(bArr2[i] & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toLowerCase());
            if (i != bArr2.length - 1) {
                stringBuffer.append(":");
            }
        }
        this.f.d(stringBuffer.toString());
    }

    private void n(byte[] bArr) {
        byte b = bArr[10];
        byte b2 = bArr[11];
        byte b3 = bArr[12];
        Boolean boolValueOf = null;
        if (bArr.length >= 13) {
            boolValueOf = Boolean.valueOf(bArr[12] == 1);
            this.f.g(boolValueOf.booleanValue());
            q();
        }
        mm.b("Group feature groupId %s, listSize %s, groupSize %s, owner %s, streamingStatus %s, device %s", Byte.valueOf(b2), Byte.valueOf(b3), boolValueOf, Byte.valueOf(b), this.f);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void o(byte[] bArr) {
        switch (bArr[10]) {
            case 3:
                k();
                mm.b("sent add stream %s", this.f);
                s();
                break;
            case 4:
                o();
                k();
                mm.b("sent add stream %s", this.f);
                s();
                break;
            case 9:
                r(bArr);
                break;
            case 32:
                mm.b("sent add stream %s", this.f);
                s();
                break;
            case 33:
                mm.b("sent add party mode %s", this.f);
                r();
                break;
            case 36:
                p();
                break;
            case 37:
                j();
                break;
            case 38:
                q(bArr);
                break;
            case 39:
                p(bArr);
                break;
        }
    }

    private void p(byte[] bArr) {
        switch (bArr[11]) {
            case 0:
                h();
                break;
            case 1:
                i();
                break;
            case 2:
                g();
                break;
        }
    }

    private void q(byte[] bArr) {
        switch (bArr[11]) {
            case 0:
                f();
                break;
            case 1:
                e();
                break;
            case 2:
                d();
                break;
            case 3:
                c();
                break;
        }
    }

    private void c() {
        if (this.a != null) {
            Message message = new Message();
            message.what = 1114;
            message.obj = this.f;
            this.a.sendMessage(message);
        }
    }

    private void d() {
        if (this.a != null) {
            Message message = new Message();
            message.what = 1115;
            message.obj = this.f;
            this.a.sendMessage(message);
        }
    }

    private void e() {
        if (this.a != null) {
            Message message = new Message();
            message.what = 1116;
            message.obj = this.f;
            this.a.sendMessage(message);
        }
    }

    private void f() {
        if (this.a != null) {
            Message message = new Message();
            message.what = 1117;
            message.obj = this.f;
            this.a.sendMessage(message);
        }
    }

    private void g() {
        if (this.a != null) {
            Message message = new Message();
            message.what = 1118;
            message.obj = this.f;
            this.a.sendMessage(message);
        }
    }

    private void h() {
        if (this.a != null) {
            Message message = new Message();
            message.what = 1119;
            message.obj = this.f;
            this.a.sendMessage(message);
        }
    }

    private void i() {
        if (this.a != null) {
            Message message = new Message();
            message.what = 1120;
            message.obj = this.f;
            this.a.sendMessage(message);
        }
    }

    private void j() {
        if (this.a != null) {
            Message message = new Message();
            message.what = 1121;
            message.obj = this.f;
            this.a.sendMessage(message);
        }
    }

    private void k() {
        if (this.a != null) {
            Message message = new Message();
            message.what = 1112;
            message.obj = this.f;
            this.a.sendMessage(message);
        }
    }

    private void r(byte[] bArr) {
        if (this.f.N()) {
            mm.b("sent pause/play mDeviceFc.isMKI() %s", this.f);
            l();
        } else if (bArr[11] == 0) {
            m();
            mm.b("sent pause/play play %s", this.f);
        } else if (bArr[11] == 1) {
            mm.b("sent pause/play pause %s", this.f);
            n();
        }
    }

    private void l() {
        if (this.a != null) {
            Message message = new Message();
            message.what = 1107;
            message.obj = this.f;
            this.a.sendMessage(message);
        }
    }

    private void m() {
        if (this.a != null) {
            Message message = new Message();
            message.what = 1207;
            message.obj = this.f;
            this.a.sendMessage(message);
        }
    }

    private void n() {
        if (this.a != null) {
            Message message = new Message();
            message.what = 1208;
            message.obj = this.f;
            this.a.sendMessage(message);
        }
    }

    private void o() {
        if (this.a != null) {
            Message message = new Message();
            message.what = 1111;
            message.obj = this.f;
            this.a.sendMessage(message);
        }
    }

    private void p() {
    }

    private int s(byte[] bArr) {
        switch (bArr[3]) {
            case 2:
                mm.b((Object) "setDeviceMute to for02");
                return u(bArr);
            case 3:
            case 4:
            case 6:
            case 7:
            default:
                return 0;
            case 5:
                t(bArr);
                return 0;
            case 8:
                mm.b((Object) "setDeviceMute to for08");
                mm.b("sent device feature %s", this.f);
                return u(bArr);
        }
    }

    private void t(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        mm.b("device RSSI content = %s ,length = %s , device = ", Arrays.toString(bArr), Integer.valueOf(bArr.length), this.f.x());
        if (bArr.length < 11) {
            System.arraycopy(bArr, 8, bArr2, 0, 2);
        } else {
            System.arraycopy(bArr, 8, bArr2, 0, 3);
        }
        this.f.a((short) ((bArr2[0] & 65280) | (bArr2[1] & 255)));
        this.f.b((short) ((bArr2[2] & 128) + (bArr2[2] & 127)));
    }

    private int u(byte[] bArr) {
        adz adzVarA;
        adz adzVarA2;
        ady adyVarB;
        int i = 0;
        if (bArr.length < 12) {
            return 1;
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 8, bArr2, 0, 4);
        String strC = mk.c(bArr2);
        mm.b("indexString = " + strC, new Object[0]);
        int i2 = 12;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        byte b = -1;
        byte b2 = -1;
        for (int i3 = 0; i3 < strC.length(); i3++) {
            if (strC.charAt(i3) == '1') {
                int i4 = i2 + 1;
                byte b3 = bArr[i2];
                switch (i3) {
                    case 0:
                        i2 = i4;
                        continue;
                    case 1:
                        this.f.a(b3);
                        i2 = i4;
                        continue;
                    case 2:
                        i2 = i4;
                        continue;
                    case 3:
                        if (b3 == 0) {
                            i2 = i4;
                        } else if (this.f.S() != b3) {
                            mm.b("setDeviceSource to %s for %s", Byte.valueOf(b3), this.f);
                            if (b3 == 2 || b3 == 3) {
                                z = true;
                            }
                            this.f.e(b3);
                            i |= 2;
                            i2 = i4;
                        } else {
                            i2 = i4;
                        }
                        break;
                    case 4:
                        if (this.f.T() != b3) {
                            mm.b("fixlink setStreamingStatus to %s for %s", Byte.valueOf(b3), this.f);
                            i |= 4;
                            z2 = true;
                            this.f.f(b3);
                            b = b3;
                            i2 = i4;
                        } else {
                            i2 = i4;
                        }
                        break;
                    case 5:
                        i2 = i4;
                        continue;
                    case 6:
                        this.f.b(b3);
                        i2 = i4;
                        continue;
                    case 7:
                        if (this.f.D() != b3) {
                            mm.b("setBalance from %s to %s for %s", Byte.valueOf(this.f.D()), Byte.valueOf(b3), this.f);
                            this.f.g(b3);
                            i |= 8;
                            i2 = i4;
                        } else {
                            i2 = i4;
                        }
                        break;
                    case 8:
                        if (this.f.U() != b3) {
                            mm.b("setDeviceMute to for %s %s", Byte.valueOf(b3), this.f);
                            if (this.f.r() != 0 && this.f.L()) {
                                this.f.h(b3);
                                z3 = true;
                            }
                            i |= 16;
                            b2 = b3;
                            i2 = i4;
                        } else {
                            i2 = i4;
                        }
                        break;
                    case 9:
                        i2 = i4;
                        continue;
                    case 10:
                        i2 = i4;
                        continue;
                    default:
                        i2 = i4;
                        break;
                }
            }
        }
        if (z) {
            this.f.f((byte) 0);
            mq.c().schedule(new Runnable() { // from class: aej.1
                @Override // java.lang.Runnable
                public void run() {
                    adw.a().queryPrivateDataAll(aej.this.f);
                }
            }, 5000L, TimeUnit.MILLISECONDS);
        }
        if (z2) {
            if (!this.f.y() && this.f.S() == 33 && (adyVarB = aof.a().b()) != null && adyVarB.a(this.f)) {
                for (adz adzVar : adyVarB.f()) {
                    if (this.f.y() != adzVar.u()) {
                        adzVar.d(this.f.y());
                    }
                }
            }
            if (this.f.y() && (this.f.S() == 2 || this.f.S() == 3)) {
                ady adyVarO = aof.a().o();
                if (adyVarO != null && adyVarO.a(this.f)) {
                    aof.a().j();
                }
            } else if (this.f.u() == 2 && this.f.q() == 7 && (adzVarA2 = aof.a().a(this.f)) != null && adzVarA2.k() != null) {
                for (adx adxVar : adzVarA2.k()) {
                    if (b != adxVar.T()) {
                        adxVar.f(b);
                    }
                }
            }
        }
        if (z3) {
            if ((this.f.u() == 2 || this.f.u() == 4 || this.f.u() == 1) && (adzVarA = aof.a().a(this.f)) != null) {
                for (adx adxVar2 : adzVarA.k()) {
                    if (adxVar2.U() != b2) {
                        adxVar2.h(b2);
                    }
                }
                return i;
            }
            return i;
        }
        return i;
    }

    private void a(int i) {
        if (this.a != null) {
            Message message = new Message();
            message.what = 1103;
            HashMap map = new HashMap();
            map.put("TYPE", Integer.valueOf(i));
            map.put("DEVICE", this.f);
            message.obj = map;
            this.a.sendMessage(message);
        }
    }

    private void q() {
        if (this.a != null) {
            Message message = new Message();
            message.what = 1110;
            message.obj = this.f;
            this.a.sendMessage(message);
        }
    }

    private void r() {
        if (this.a != null) {
            Message message = new Message();
            message.what = 1104;
            message.obj = this.f;
            this.a.sendMessage(message);
        }
    }

    private void s() {
        if (this.a != null) {
            Message message = new Message();
            message.what = 1105;
            message.obj = this.f;
            this.a.sendMessage(message);
        }
    }

    private void v(byte[] bArr) {
    }

    private void w(byte[] bArr) {
        if (bArr[3] == 33) {
            x(bArr);
            return;
        }
        if (bArr[3] == 35) {
            z(bArr);
            return;
        }
        if (bArr[3] == 37) {
            y(bArr);
            return;
        }
        if (bArr[3] == 7) {
            mm.b("test upgrade step----> 0x07", new Object[0]);
            byte b = bArr[8];
            if (b == 0) {
                mm.b("sent device ready update %s", this.f);
                a(161, 0, null);
                if (this.c != null) {
                    this.c.sendEmptyMessage(0);
                    this.c.f = 0;
                    this.c.d = 0;
                    return;
                }
                return;
            }
            if (b == 1) {
                mm.b("sent device reject %s", this.f);
                a(151, 0, null);
                return;
            } else {
                if (b == 2) {
                }
                return;
            }
        }
        if (bArr[3] == 3) {
            mm.b("test upgrade step--testtimeout-start1> %02x %02x %02x", Byte.valueOf(bArr[5]), Byte.valueOf(bArr[6]), Byte.valueOf(bArr[12]));
            mm.b("test upgrade step----> 0x03 %s", this.f);
            if (this.c != null) {
                this.c.f = mk.d(new byte[]{bArr[8], bArr[9], bArr[10], bArr[11]});
                this.c.f++;
                this.c.d = this.c.f * 1024;
                this.c.sendEmptyMessage(1);
                mm.b("test upgrade step--testtimeout-end> num=%d, offset=%d", Integer.valueOf(this.c.f), Integer.valueOf(this.c.d));
                return;
            }
            return;
        }
        if (bArr[3] == 9) {
            mm.b("sent confirmed upgrade is finished %s", this.f);
            byte b2 = bArr[8];
            if (b2 == 0) {
                mm.b("sent upgrade failed %s", this.f);
                Bundle bundle = new Bundle();
                bundle.putSerializable("cause", "Status is 0");
                a(171, 0, bundle);
                return;
            }
            if (b2 == 1) {
                mm.b("sent upgrade success %s", this.f);
                a(170, 0, null);
            } else if (b2 == 2) {
                mm.b("sent upgrade timeout %s ", this.f);
                a(133, bArr[3], null);
            }
        }
    }

    private void x(byte[] bArr) {
        mm.a("TEST_DEVICE_FOTA_CHANGE CommandParser content = %s", bArr);
        aea aeaVar = new aea();
        aeaVar.a = bArr[8];
        aeaVar.b[0] = bArr[12];
        aeaVar.b[1] = bArr[11];
        aeaVar.b[2] = bArr[10];
        aeaVar.b[3] = bArr[9];
        aeaVar.c = mk.e(new byte[]{bArr[13], bArr[14], bArr[15], bArr[16]});
        this.f.a(aeaVar);
        aof.a().c().b();
        adw.a().D(this.f);
        adw.a().G(this.f);
        mm.b("TEST_DEVICE_FOTA_CHANGE parser fota status ---> 3  CommandParser firmware = %s , mac = %s , firmware_size = %s", Byte.valueOf(aeaVar.a), this.f.d(), Long.valueOf(aeaVar.c));
    }

    private void y(byte[] bArr) {
        mm.a("TEST_DEVICE_FOTA_CHANGE CommandParser content = %s", bArr);
        if (this.f.h() != null) {
            this.f.h().e = bArr[8];
            this.f.h().d = bArr[9];
            aof.a().c().b();
            mm.b("TEST_DEVICE_FOTA_CHANGE parser fota battery --->  mac  = %s , battery = %s , isplugAc = %s", this.f.d(), Long.valueOf(this.f.h().d), Byte.valueOf(this.f.h().e));
        }
    }

    private void z(byte[] bArr) {
        if (this.f.h() != null && this.f.h().g != 100) {
            this.f.h().g = bArr[8];
            this.a.sendMessage(this.a.obtainMessage(1113, this.f));
            mm.b("TEST_DEVICE_FOTA_CHANGE CommandParser value = %s , mac = %s", Byte.valueOf(bArr[8]), this.f.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, Bundle bundle) {
        if (this.a != null) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = this.f;
            messageObtain.what = i;
            messageObtain.setData(bundle);
            this.a.sendMessageDelayed(messageObtain, i2 * 1000);
        }
    }

    @SuppressLint({"HandlerLeak"})
    class a extends Handler {
        RandomAccessFile a;
        byte[] b;
        byte[] c;
        public int d;
        int e;
        public int f;
        byte[] g;
        byte[] h;

        a(Looper looper) {
            super(looper);
            this.a = null;
            this.b = null;
            this.c = new byte[2];
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = null;
            File fileStreamPath = HarmanApplication.a().getFileStreamPath(aho.d(ain.C));
            if (fileStreamPath != null) {
                try {
                    this.a = new RandomAccessFile(fileStreamPath, "rw");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    aej.this.t();
                    aej.this.c.sendEmptyMessage(1);
                    break;
                case 1:
                    a();
                    break;
            }
        }

        private void a() {
            try {
                this.b = new byte[1024];
                this.a.seek(this.d);
                this.e = this.a.read(this.b);
                this.h = mk.b(this.f);
                this.g = mk.c(this.e);
                if (this.e == -1) {
                    mm.b("TEST_GEN1_UPGRADE", "count == -1");
                    this.a.close();
                    return;
                }
                mm.b("TEST_GEN1_UPGRADE package number = %s , offset = %s , totalpackageNumber = %s", Integer.valueOf(this.f), Integer.valueOf(this.d), Integer.valueOf(aej.this.d));
                if (aej.this.d != 0) {
                    int i = ((this.f * 100) / aej.this.d) + 1;
                    Message messageObtainMessage = aej.this.a.obtainMessage(107, aej.this.f);
                    messageObtainMessage.arg1 = i;
                    aej.this.a.sendMessage(messageObtainMessage);
                    this.c[0] = 5;
                    this.c[1] = 2;
                    byte[] bArr = new byte[this.e + 6];
                    bArr[0] = this.h[0];
                    bArr[1] = this.h[1];
                    bArr[2] = this.h[2];
                    bArr[3] = this.h[3];
                    bArr[4] = this.g[0];
                    bArr[5] = this.g[1];
                    if (this.e < 1024) {
                        byte[] bArr2 = new byte[this.e];
                        System.arraycopy(this.b, 0, bArr2, 0, this.e);
                        this.b = bArr2;
                    }
                    for (int i2 = 0; i2 < this.b.length; i2++) {
                        bArr[i2 + 6] = this.b[i2];
                    }
                    aej.this.b(new aei(this.c, bArr));
                    mm.b("test upgrade step=" + this.f, new Object[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
                aej.this.a(133, 0, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        File fileStreamPath = HarmanApplication.a().getFileStreamPath(aho.d(ain.C));
        if (fileStreamPath != null) {
            long length = fileStreamPath.length();
            if (length % 1024 != 0) {
                this.d = ((int) (length / 1024)) + 1;
            } else {
                this.d = (int) (length / 1024);
            }
            byte[] bArr = new byte[(int) length];
            try {
                int[] iArrA = mk.a(this.d);
                int i = iArrA[0];
                int i2 = iArrA[1];
                int i3 = iArrA[2];
                int i4 = iArrA[3];
                int[] iArrA2 = mk.a((int) length);
                int i5 = iArrA2[0];
                int i6 = iArrA2[1];
                int i7 = iArrA2[2];
                int i8 = iArrA2[3];
                FileInputStream fileInputStream = new FileInputStream(fileStreamPath);
                fileInputStream.read(bArr);
                int[] iArrA3 = mk.a((int) mk.f(bArr));
                int i9 = iArrA3[0];
                aei aeiVar = new aei(new byte[]{5, 1}, new byte[]{(byte) i4, (byte) i3, (byte) i2, (byte) i, (byte) i8, (byte) i7, (byte) i6, (byte) i5, (byte) iArrA3[3], (byte) iArrA3[2], (byte) iArrA3[1], (byte) i9});
                b(aeiVar);
                fileInputStream.close();
                mm.b("test upgrade step=" + aeiVar.b(), new Object[0]);
            } catch (IOException e) {
                mm.b("test upgrade step=IOException", new Object[0]);
                e.printStackTrace();
                a(133, 0, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(aep aepVar) {
        mm.b("test upgrade step---->sendCommand %s %s", Arrays.toString(aepVar.b()), this.f);
        aepVar.d = 5002;
        this.f.a(aepVar);
    }

    public void a() {
        if (this.e == null) {
            this.e = new HandlerThread("update");
            this.e.start();
            this.c = new a(this.e.getLooper());
        }
    }

    @Override // defpackage.aeq
    public void b() {
        if (this.e != null) {
            this.e.quit();
        }
    }

    private void A(byte[] bArr) {
        byte[] bArr2 = new byte[33];
        byte b = bArr[8];
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (i2 == i + 9 && bArr.length - (i + 9) >= 33 && b > arrayList.size()) {
                System.arraycopy(bArr, i + 9, bArr2, 0, bArr2.length);
                i += 33;
                arrayList.add(WifiMode.a(bArr2));
            }
        }
        Message messageObtainMessage = this.a.obtainMessage(126);
        messageObtainMessage.obj = arrayList;
        this.a.sendMessage(messageObtainMessage);
    }

    private void B(byte[] bArr) {
        byte[] bArr2 = new byte[2];
        System.arraycopy(bArr, 8, bArr2, 0, 2);
        this.f.h(bArr2[0]);
        this.f.i((int) bArr2[1]);
    }

    private void C(byte[] bArr) {
        byte[] bArr2 = new byte[2];
        System.arraycopy(bArr, 8, bArr2, 0, 2);
        this.f.i(bArr2[0]);
        this.f.j(bArr2[1]);
        if (this.f != null) {
            if (bArr2[0] == 1 && bArr2[1] == 1) {
                ain.b(this.f.P());
            } else {
                mm.b("5.1 system test", "Removing UUID = %d from wifi 5G list", Long.valueOf(this.f.P()));
                ain.c(this.f.P());
            }
        }
        mm.b("5.1 system test", "parserNetworkInterface for wifi, networkInterface=%d, wifiBand=%d, device=%s", Byte.valueOf(bArr2[0]), Byte.valueOf(bArr2[1]), this.f.z() + "  " + this.f.d());
    }
}
