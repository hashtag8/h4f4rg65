package com.harman.commom.music.playlist;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.design.widget.CoordinatorLayout;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.player.service.MusicService;
import com.harman.commom.music.player.service.PlayList;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;
import defpackage.ady;
import defpackage.aff;
import defpackage.agb;
import defpackage.age;
import defpackage.ain;
import defpackage.aof;
import defpackage.arw;
import defpackage.mm;
import defpackage.mo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MusicPlaylistManager {
    private static MusicPlaylistManager b;
    private static int f = -5;
    private agb d;
    private age h;
    private PlayList c = new PlayList();
    private List<MusicData> e = new ArrayList();
    ServiceConnection a = new ServiceConnection() { // from class: com.harman.commom.music.playlist.MusicPlaylistManager.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mm.b("Bound service %s", componentName);
            MusicPlaylistManager.this.d = agb.a.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            mm.b("Service disconnected %s", componentName);
            MusicPlaylistManager.this.d = null;
        }
    };
    private Map<String, Integer> i = new HashMap();
    private Map<String, Integer> j = new HashMap();
    private int g = f;

    private MusicPlaylistManager() {
    }

    public static MusicPlaylistManager a() {
        if (b == null) {
            b = new MusicPlaylistManager();
        }
        return b;
    }

    public int b() {
        return this.g;
    }

    public void a(long j) {
        if (z()) {
            try {
                this.d.a(j);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(Context context) {
        mm.b("Starting MusicService", new Object[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(new Intent(context, (Class<?>) MusicService.class));
        } else {
            context.startService(new Intent(context, (Class<?>) MusicService.class));
        }
        context.bindService(new Intent(context, (Class<?>) MusicService.class), this.a, 1);
    }

    public void b(Context context) {
        context.unbindService(this.a);
        context.stopService(new Intent(context, (Class<?>) MusicService.class));
    }

    private boolean z() {
        return this.d != null;
    }

    public long c() {
        MusicData musicDataS = s();
        if (musicDataS == null) {
            return -1L;
        }
        return musicDataS.duration;
    }

    private void A() {
        Toast.makeText(HarmanApplication.a().getApplicationContext(), R.string.PlayErrorTip_Str, 0).show();
    }

    public void a(List<MusicData> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (!list.get(i2).isLegal) {
                    list.remove(i2);
                    i2--;
                }
                i = i2 + 1;
            } else {
                Message message = new Message();
                message.what = 14;
                message.obj = list;
                o(message);
                return;
            }
        }
    }

    public void a(Message message) {
        if (z()) {
            C();
            List<MusicData> list = (List) message.obj;
            f(list);
            try {
                if (this.c.a() > 0) {
                    this.c.a(this.c.f() + 1, list);
                    j();
                    this.c.e(this.c.f() + 1);
                } else {
                    this.c.b(list);
                    this.c.e(0);
                    j();
                }
                if (z()) {
                    this.d.h();
                }
            } catch (RemoteException e) {
                mm.e("Could not playNow", e);
            }
        }
    }

    public void a(MusicData musicData) {
        if (!musicData.isLegal) {
            A();
            return;
        }
        Message message = new Message();
        message.what = 3;
        message.obj = musicData;
        o(message);
    }

    private void e(Message message) {
        if (z()) {
            C();
            try {
                MusicData musicData = (MusicData) message.obj;
                ArrayList arrayList = new ArrayList();
                arrayList.add(musicData);
                f(arrayList);
                if (this.c.a() > 0) {
                    int iE = e(musicData);
                    if (iE >= 0) {
                        this.c.e(iE);
                    } else {
                        this.c.a(this.c.f() + 1, musicData);
                        j();
                        this.c.e(this.c.f() + 1);
                    }
                } else {
                    this.c.a(musicData);
                    this.c.e(0);
                    j();
                }
                if (z()) {
                    this.d.h();
                }
            } catch (RemoteException e) {
                mm.e("Could not playNow", e);
            }
        }
    }

    private int e(MusicData musicData) {
        List<MusicData> listC = this.c.c();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < listC.size()) {
                MusicData musicData2 = listC.get(i2);
                if (musicData2.songId != musicData.songId || ((musicData2.musicName != null && !musicData2.musicName.equals(musicData.musicName)) || ((musicData2.album != null && !musicData2.album.equals(musicData.album)) || (musicData2.artist != null && !musicData2.artist.equals(musicData.artist))))) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return -1;
            }
        }
    }

    public void b(MusicData musicData) {
        if (!musicData.isLegal) {
            A();
            return;
        }
        Message message = new Message();
        message.what = 4;
        message.obj = musicData;
        o(message);
    }

    private void f(Message message) {
        C();
        MusicData musicData = (MusicData) message.obj;
        ArrayList arrayList = new ArrayList();
        arrayList.add(musicData);
        f(arrayList);
        this.c.a(musicData);
        j();
        if (z()) {
            try {
                this.c.e(this.c.a() - 1);
                this.d.h();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void b(List<MusicData> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (!list.get(i2).isLegal) {
                    list.remove(i2);
                    i2--;
                }
                i = i2 + 1;
            } else {
                Message message = new Message();
                message.what = 6;
                message.obj = list;
                o(message);
                return;
            }
        }
    }

    public void a(List<MusicData> list, age ageVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                list.get(i2).queue_source = 1;
                i = i2 + 1;
            } else {
                b(list);
                a(ageVar);
                return;
            }
        }
    }

    public void a(List<MusicData> list, int i, age ageVar) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                list.get(i3).queue_source = 1;
                i2 = i3 + 1;
            } else {
                a(list, i);
                a(ageVar);
                return;
            }
        }
    }

    public void a(List<MusicData> list, int i) {
        int i2 = 0;
        while (i2 < list.size()) {
            if (!list.get(i2).isLegal) {
                if (i == i2) {
                    A();
                    if (i2 == list.size() - 1) {
                        i = 0;
                    }
                } else if (i > i2) {
                    i--;
                }
                list.remove(i2);
                i2--;
            }
            i2++;
        }
        Message message = new Message();
        message.what = 13;
        message.obj = list;
        message.arg1 = i;
        o(message);
        B();
    }

    private void a(age ageVar) {
        if (this.h != null) {
            this.h.a();
        }
        this.h = ageVar;
        this.h.a(this.c);
    }

    private void B() {
        if (!this.e.isEmpty()) {
            d(this.e);
            this.e.clear();
        }
    }

    private void g(Message message) {
        int i = message.arg1;
        List<MusicData> list = (List) message.obj;
        if (list != null && list.size() != 0) {
            f(list);
            C();
            int iMin = Math.min(i, list.size() - 1);
            MusicData musicData = list.get(iMin);
            this.c.a(0, list, iMin);
            j();
            if (this.c.a() == list.size() && z()) {
                try {
                    this.c.e(this.c.b(musicData));
                    this.d.h();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void h(Message message) {
        List<MusicData> list = (List) message.obj;
        if (list != null && list.size() != 0) {
            C();
            f(list);
            this.c.b(list);
            j();
            if (this.c.a() == list.size() && z()) {
                try {
                    this.c.e(0);
                    this.d.h();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            B();
        }
    }

    public void c(MusicData musicData) {
        if (!musicData.isLegal) {
            A();
            return;
        }
        musicData.setCurated(true);
        Message message = new Message();
        message.what = 7;
        message.obj = musicData;
        o(message);
    }

    private void i(Message message) {
        if (z()) {
            if (!aof.a().n()) {
                e(message);
                return;
            }
            C();
            MusicData musicData = (MusicData) message.obj;
            ArrayList arrayList = new ArrayList();
            arrayList.add(musicData);
            f(arrayList);
            if (this.c.a() > 0) {
                this.c.a(this.c.f() + 1, musicData);
                j();
            } else {
                this.c.a(musicData);
                this.c.e(0);
                j();
                F();
            }
        }
    }

    public void c(List<MusicData> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (!list.get(i2).isLegal) {
                    list.remove(i2);
                    i2--;
                } else {
                    list.get(i2).setCurated(true);
                }
                i = i2 + 1;
            } else {
                Message message = new Message();
                message.what = 11;
                message.obj = list;
                o(message);
                return;
            }
        }
    }

    public void b(Message message) {
        if (z()) {
            List<MusicData> list = (List) message.obj;
            if (!aof.a().n()) {
                k(message);
                return;
            }
            C();
            f(list);
            if (this.c.a() > 0) {
                this.c.a(this.c.f() + 1, list);
                j();
            } else {
                this.c.b(list);
                this.c.e(0);
                j();
                F();
            }
        }
    }

    public void d(MusicData musicData) {
        if (!musicData.isLegal) {
            A();
            return;
        }
        Message message = new Message();
        message.what = 12;
        message.obj = musicData;
        o(message);
    }

    public void c(Message message) {
        MusicData musicData = (MusicData) message.obj;
        musicData.setCurated(true);
        if (!aof.a().n()) {
            e(message);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(musicData);
        f(arrayList);
        this.c.a(musicData);
        j();
        if (this.c.a() == 1 && z()) {
            try {
                C();
                this.c.e(0);
                this.d.h();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void d(List<MusicData> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (!list.get(i2).isLegal) {
                    list.remove(i2);
                    i2--;
                } else {
                    list.get(i2).setCurated(true);
                }
                i = i2 + 1;
            } else {
                Message message = new Message();
                message.what = 2;
                message.obj = list;
                o(message);
                return;
            }
        }
    }

    private void j(Message message) {
        if (z()) {
            try {
                List<MusicData> list = (List) message.obj;
                if (!aof.a().n()) {
                    k(message);
                } else {
                    f(list);
                    this.c.b(list);
                    this.d.a(this.c);
                    if (this.c.a() == list.size() && z()) {
                        try {
                            this.c.e(0);
                            this.d.h();
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e(List<MusicData> list) {
        int i = 0;
        while (i < list.size()) {
            if (!list.get(i).isLegal) {
                list.remove(i);
                i--;
            }
            i++;
        }
        Message message = new Message();
        message.what = 0;
        message.obj = list;
        o(message);
    }

    public void a(int i) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        switch (i) {
            case 2:
                arrayList.add(2);
                break;
            case 3:
                arrayList.add(3);
                arrayList.add(14);
                break;
            case 4:
                arrayList.add(4);
                break;
            case 8:
                arrayList.add(8);
                break;
            case 9:
                arrayList.add(9);
                break;
            case 10:
                arrayList.add(10);
                arrayList.add(13);
                break;
            case 11:
                arrayList.add(11);
                arrayList.add(12);
                break;
        }
        this.c.a(arrayList);
        j();
    }

    private void f(List<MusicData> list) {
        if (!list.isEmpty()) {
            int i = list.get(0).type;
            if (this.g == f) {
                this.g = i;
                return;
            }
            if (MusicData.isRadioType(this.g)) {
                E();
            }
            this.g = i;
        }
    }

    private void k(Message message) {
        if (z()) {
            try {
                List<MusicData> list = (List) message.obj;
                if (list != null && list.size() != 0) {
                    f(list);
                    C();
                    this.c.b(list);
                    this.d.a(this.c);
                    this.c.e(this.c.a() - list.size());
                    this.d.h();
                    try {
                        Thread.sleep(200L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    B();
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void l(Message message) {
        if (z()) {
            if (!aof.a().n()) {
                k(message);
                return;
            }
            List<MusicData> list = (List) message.obj;
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        C();
                        f(list);
                        this.c.b(list);
                        this.d.a(this.c);
                        this.c.e(this.c.a() - list.size());
                        this.d.h();
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void a(int i, int i2) {
        this.c.a(i, i2);
    }

    private void C() {
        if (aof.a().l()) {
            aff.b = 2003;
        } else {
            aff.b = 2004;
        }
        PlayList.a = 0;
        aof.a().m();
    }

    public void b(int i) {
        try {
            if (z()) {
                this.d.a(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int d() {
        try {
            if (z()) {
                return this.d.m();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return 2;
    }

    public void c(int i) {
        try {
            if (z()) {
                this.d.b(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int e() {
        try {
            if (z()) {
                return this.d.n();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void f() {
        d(this.c.f());
    }

    public void d(int i) {
        a(i, (CoordinatorLayout) null);
    }

    public void a(int i, CoordinatorLayout coordinatorLayout) {
        if (z()) {
            try {
                int iF = this.c.f();
                if (i < iF) {
                    this.c.e(iF - 1);
                } else if (i == iF) {
                    if (i != this.c.a() - 1) {
                        mo.a.postDelayed(new Runnable() { // from class: com.harman.commom.music.playlist.MusicPlaylistManager.2
                            @Override // java.lang.Runnable
                            public void run() {
                                MusicData musicDataD;
                                try {
                                    if (MusicPlaylistManager.this.d.a().a() != 0 && (musicDataD = MusicPlaylistManager.this.d.d()) != null) {
                                        MusicPlaylistManager.this.d.a(musicDataD);
                                    }
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, 500L);
                    } else if (i == this.c.a() - 1 && this.c.a() > 0) {
                        this.d.g();
                        this.c.e(iF - 1);
                        MusicData musicDataD = this.d.d();
                        if (musicDataD != null) {
                            this.d.a(musicDataD);
                        }
                    }
                }
                if (coordinatorLayout != null) {
                }
                this.c.c(i);
                if (this.c.a() == 1) {
                    HarmanApplication.a().sendBroadcast(new Intent("updateUI"));
                }
                j();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void g() {
        this.e.clear();
        List<MusicData> listC = this.c.c();
        for (int i = 0; i < listC.size(); i++) {
            listC.get(i).setCurated(false);
        }
        h();
    }

    private void D() {
        if (this.c.a() != 0) {
            List<MusicData> listC = this.c.c();
            this.e.clear();
            int iF = this.c.f() + 1;
            while (true) {
                int i = iF;
                if (i < listC.size()) {
                    if (listC.get(i).isCurated()) {
                        this.e.add(listC.get(i));
                    }
                    iF = i + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void h() {
        D();
        try {
            E();
            if (z()) {
                this.d.f();
                this.d.b();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void E() {
        this.g = f;
        a(false);
        if (this.c != null) {
            this.c.b();
        }
    }

    public PlayList i() {
        if (this.c == null) {
            this.c = new PlayList();
        }
        return this.c;
    }

    public void j() {
        try {
            if (z() && this.c != null && this.c.a() > 0) {
                this.d.a(this.c);
            }
        } catch (RemoteException e) {
            mm.e("Could not set playlist", e);
        }
    }

    public void k() {
        Message message = new Message();
        message.what = 10;
        o(message);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x003c -> B:25:0x0006). Please report as a decompilation issue!!! */
    public void d(Message message) {
        if (z()) {
            if (!aof.a().n() && aof.a().o() != null) {
                e(u());
                return;
            }
            try {
                if ((s() != null && s().type == 1) || !aof.a().l() || ain.j) {
                    C();
                    this.d.i();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void e(int i) {
        Message message = new Message();
        message.what = 8;
        message.obj = Integer.valueOf(i);
        o(message);
    }

    private void m(Message message) {
        this.c.e(((Integer) message.obj).intValue());
        MusicData musicDataS = s();
        if (musicDataS != null) {
            if (musicDataS.type == 1) {
                C();
                F();
            } else {
                if (aof.a().l()) {
                    if (ain.j) {
                        C();
                        F();
                        return;
                    }
                    return;
                }
                C();
                F();
            }
        }
    }

    private void F() {
        if (z()) {
            try {
                this.d.h();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void l() {
        Message message = new Message();
        message.what = 9;
        o(message);
    }

    private void n(Message message) {
        if (z()) {
            if (!aof.a().n()) {
                e(u());
                return;
            }
            try {
                this.d.g();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void m() {
        if (z()) {
            try {
                if (!i().d()) {
                    if (this.d.c()) {
                        this.d.g();
                    } else {
                        this.d.i();
                    }
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void n() {
        mm.b("Who's calling stop?", new Exception("stacktrace"));
        if (z()) {
            try {
                this.d.f();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void o() {
        if (z()) {
            try {
                this.d.f();
                this.d.o();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void p() {
        if (v()) {
            m();
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            m();
        }
    }

    public void q() {
        if (z()) {
            try {
                C();
                this.d.j();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void r() {
        if (z()) {
            try {
                C();
                this.d.k();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0055 -> B:20:0x002e). Please report as a decompilation issue!!! */
    public MusicData s() {
        MusicData nonStreamingMusicData;
        try {
        } catch (RemoteException e) {
            mm.b("Service communication error", e);
        }
        if (z() && aof.a().o() != null) {
            switch (aof.a().o().r()) {
                case PATH_OPTICAL:
                case PATH_HDMI:
                case PATH_AUX:
                case PATH_BT:
                case PATH_FC_NOT_STREAMING_TO_DEVICE_IS_STREAMING:
                    nonStreamingMusicData = this.d.d() == null ? null : new NonStreamingMusicData(aof.a().o().r());
                    break;
                case PATH_FC_NOT_STREAMING_TO_DEVICE_NOT_STREAMING:
                    nonStreamingMusicData = null;
                    break;
                default:
                    nonStreamingMusicData = this.d.d();
                    break;
            }
        } else {
            nonStreamingMusicData = null;
        }
        return nonStreamingMusicData;
    }

    public long t() {
        try {
            if (z()) {
                return this.d.e();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    public int u() {
        return this.c.f();
    }

    public boolean v() {
        try {
            if (z()) {
                return this.d.c();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean w() {
        return i().a() > 0;
    }

    public boolean x() {
        return i().a() == 1;
    }

    private void o(final Message message) {
        if (aof.a().d().size() > 0) {
            if (aof.a().r()) {
                new arw.a(ain.J).b(R.string.Warning_Str).a(R.string.kSameQueue_BreakIn_Str).a(ain.J.getString(R.string.OK_Str), new DialogInterface.OnClickListener() { // from class: com.harman.commom.music.playlist.MusicPlaylistManager.5
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MusicPlaylistManager.this.a(message, true);
                    }
                }).b(ain.J.getString(R.string.Cancel_Str), new DialogInterface.OnClickListener() { // from class: com.harman.commom.music.playlist.MusicPlaylistManager.4
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).d(false).a(new DialogInterface.OnCancelListener() { // from class: com.harman.commom.music.playlist.MusicPlaylistManager.3
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                    }
                }).b().show();
            } else {
                a(message, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message, boolean z) {
        a(true);
        switch (message.what) {
            case 0:
                k(message);
                break;
            case 1:
                if (z) {
                    k(message);
                } else {
                    l(message);
                }
                break;
            case 2:
                if (z) {
                    k(message);
                } else {
                    j(message);
                }
                break;
            case 3:
                e(message);
                break;
            case 4:
                f(message);
                break;
            case 6:
                h(message);
                break;
            case 7:
                if (z) {
                    e(message);
                } else {
                    try {
                        i(message);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                break;
            case 8:
                m(message);
                break;
            case 9:
                if (z) {
                    Message message2 = new Message();
                    message2.what = 8;
                    message2.obj = Integer.valueOf(u());
                    m(message2);
                } else {
                    n(message);
                }
                break;
            case 10:
                if (z) {
                    Message message3 = new Message();
                    message3.what = 8;
                    message3.obj = Integer.valueOf(u());
                    m(message3);
                } else {
                    d(message);
                }
                break;
            case 11:
                if (z) {
                    k(message);
                } else {
                    try {
                        b(message);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                break;
            case 12:
                if (z) {
                    f(message);
                } else {
                    c(message);
                }
                break;
            case 13:
                g(message);
                break;
            case 14:
                a(message);
                break;
        }
    }

    public void a(boolean z) {
        if (z()) {
            try {
                this.d.a(z);
            } catch (RemoteException e) {
                mm.e("MusicService communication error", e);
            }
        }
    }

    public int y() {
        try {
            return this.d.p();
        } catch (RemoteException e) {
            mm.e("MusicService communication error", e);
            return 3;
        }
    }

    public static class NonStreamingMusicData extends MusicData {
        private ady.a a;

        public NonStreamingMusicData(ady.a aVar) {
            this.a = aVar;
            this.songId = -1L;
            this.path = "";
            this.musicName = "";
            this.artist = "";
            this.artist_id = -1L;
            this.album = "";
            this.album_id = -1L;
            this.duration = 0L;
            this.type = 1;
        }
    }

    public void b(int i, int i2) {
        this.i.put(String.valueOf(i), Integer.valueOf(i2));
    }

    public int f(int i) {
        Integer num = this.i.get(String.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void c(int i, int i2) {
        this.j.put(String.valueOf(i), Integer.valueOf(i2));
    }

    public int g(int i) {
        Integer num = this.j.get(String.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
