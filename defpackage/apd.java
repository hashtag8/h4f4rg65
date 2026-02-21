package defpackage;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bfrx.Device;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.CustomDragSpeakerContianer;
import defpackage.agt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class apd extends aoj implements View.OnTouchListener {
    ViewConfiguration a;
    private View aA;
    private ImageView aB;
    private float aD;
    private float aE;
    private float aH;
    private float aI;
    private LayoutInflater ae;
    private RecyclerView af;
    private LinearLayout ag;
    private int ah;
    private int ai;
    private int aj;
    private int ak;
    private LinearLayout am;
    private adx an;
    private View as;
    private aez at;
    private Dialog au;
    private boolean av;
    private ImageView az;
    private RelativeLayout f;
    private ImageView g;
    private List<adx> h;
    private a i;
    public static int b = -1;
    private static b aN = b.NONE_SELECTED;
    private HashMap<String, CustomDragSpeakerContianer> al = new LinkedHashMap();
    private int ao = 0;
    private int ap = 0;
    private b aq = b.NONE_SELECTED;
    private boolean ar = true;
    private boolean aw = true;
    private boolean ax = false;
    private boolean ay = false;
    private int aC = -1;
    private boolean aF = false;
    private boolean aG = false;
    private int[] aJ = new int[2];
    private View.OnTouchListener aK = new View.OnTouchListener() { // from class: apd.12
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (view.getId()) {
                case R.id.speaker_one_drag_position /* 2131690121 */:
                    if (((CustomDragSpeakerContianer) apd.this.al.get(b.KEY_LEFT.name())).getRuleSpeaker() != null) {
                        apd.this.a(view, motionEvent, b.KEY_LEFT);
                    }
                    break;
                case R.id.speaker_two_drag_position /* 2131690122 */:
                    if (((CustomDragSpeakerContianer) apd.this.al.get(b.KEY_RIGHT.name())).getRuleSpeaker() != null) {
                        apd.this.a(view, motionEvent, b.KEY_RIGHT);
                    }
                    break;
                case R.id.speaker_center_drag_position /* 2131691195 */:
                    if (((CustomDragSpeakerContianer) apd.this.al.get(b.KEY_AROUND_CENTER.name())).getRuleSpeaker() != null) {
                        apd.this.a(view, motionEvent, b.KEY_AROUND_CENTER);
                    }
                    break;
                case R.id.speaker_rl_drag_position /* 2131691196 */:
                    if (((CustomDragSpeakerContianer) apd.this.al.get(b.KEY_AROUND_LEFT.name())).getRuleSpeaker() != null) {
                        apd.this.a(view, motionEvent, b.KEY_AROUND_LEFT);
                    }
                    break;
                case R.id.speaker_rr_drag_position /* 2131691198 */:
                    if (((CustomDragSpeakerContianer) apd.this.al.get(b.KEY_AROUND_RIGHT.name())).getRuleSpeaker() != null) {
                        apd.this.a(view, motionEvent, b.KEY_AROUND_RIGHT);
                    }
                    break;
            }
            return true;
        }
    };
    private int aL = 0;
    private int aM = -1;
    int[] c = new int[2];
    int[] d = new int[2];
    agt.c e = new agt.c() { // from class: apd.10
        @Override // agt.c
        public void a() {
            apd.this.ar = true;
        }
    };

    public enum b {
        KEY_LEFT,
        KEY_RIGHT,
        KEY_AROUND_LEFT,
        KEY_AROUND_RIGHT,
        KEY_AROUND_CENTER,
        NONE_SELECTED
    }

    static /* synthetic */ int g(apd apdVar) {
        int i = apdVar.aL;
        apdVar.aL = i + 1;
        return i;
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.au = b(p());
        super.a(layoutInflater, viewGroup, bundle);
        this.as = layoutInflater.inflate(R.layout.drag_speakers_for_channel, (ViewGroup) null);
        am();
        b(false);
        m(true);
        this.ae = layoutInflater;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(p());
        linearLayoutManager.b(0);
        this.af.setLayoutManager(linearLayoutManager);
        this.i = new a();
        this.a = ViewConfiguration.get(p());
        this.ak = this.a.getScaledTouchSlop();
        this.af.setOnTouchListener(this);
        this.ah = ahn.c(p());
        this.ai = ahn.a(p(), 52.0f);
        this.aj = ahn.a(p(), 47.0f);
        this.ao = ahn.a(p(), 5.0f);
        this.ap = ahn.a(p(), 7.0f);
        this.an = new adx(new Device());
        this.an.c = true;
        this.at = new aez() { // from class: apd.1
            @Override // defpackage.aez, defpackage.aey
            public void a(final List<adx> list) {
                mo.a.a(new Runnable() { // from class: apd.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        apd.this.a((List<adx>) list);
                    }
                });
            }
        };
        aof.a().c().a(this.at);
        return this.as;
    }

    private void am() {
        this.ag = (LinearLayout) this.as.findViewById(R.id.soundbar_main_container);
        this.f = (RelativeLayout) this.as.findViewById(R.id.drag_speakers_parent_layout);
        this.af = (RecyclerView) this.as.findViewById(R.id.drag_speaker_recycler_view);
        this.am = (LinearLayout) this.as.findViewById(R.id.draggable_speakers_layout);
        this.al.put(b.KEY_LEFT.name(), (CustomDragSpeakerContianer) this.as.findViewById(R.id.speaker_one_drag_position));
        this.al.put(b.KEY_RIGHT.name(), (CustomDragSpeakerContianer) this.as.findViewById(R.id.speaker_two_drag_position));
        this.g = (ImageView) this.as.findViewById(R.id.switch_button);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: apd.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                mm.b();
                apd.this.aS();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<adx> list) {
        if (this.h == null) {
            this.af.setAdapter(this.i);
            this.h = c(list);
            if (an().n().e() == 1) {
                ax();
            }
        } else {
            this.h = c(list);
            b(aM());
            aG();
        }
        at();
        aL();
        this.i.c();
    }

    private void at() {
        Iterator<adx> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().c(adx.a);
        }
        if (aM().size() > 0) {
            d(aM());
        } else {
            ay();
        }
    }

    private void ax() {
        if (an().n().m() != null) {
            an().n().m().c(adx.b);
            this.al.get(b.KEY_LEFT.name()).a(CustomDragSpeakerContianer.a.SELECT_SPEAKER, an().n().m());
            this.h.remove(an().n().m());
        }
    }

    private void b(List<CustomDragSpeakerContianer> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (this.h.contains(list.get(i2).getRuleSpeaker())) {
                    this.h.remove(list.get(i2).getRuleSpeaker());
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private List<adx> c(List<adx> list) {
        List<adx> listC;
        byte bE = an().n().e();
        if (bE == 1) {
            listC = aoz.h(list);
        } else if (bE == 2 || bE == 4) {
            listC = aoz.c(list);
        } else {
            listC = aoz.b(list);
        }
        an().n().u().c(listC);
        if (bE != 0) {
            listC = aoz.c(listC, (byte) 7);
        }
        return aoz.c(listC, (byte) 8);
    }

    private void ay() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (adx adxVar : this.h) {
            if (an().n().e() == 0) {
                adxVar.c(adx.a);
            } else if (an().n().e() == 1) {
                if (adxVar.J()) {
                    i3++;
                } else if (adxVar.G()) {
                    i2++;
                } else if (adxVar.K()) {
                    i++;
                }
            } else if (an().n().e() == 4) {
                if (adxVar.J()) {
                    i3++;
                } else if (adxVar.G()) {
                    i2++;
                } else if (adxVar.K()) {
                    i++;
                }
            } else if (an().n().e() == 2) {
                if (adxVar.J()) {
                    i3++;
                } else if (adxVar.G()) {
                    i2++;
                } else if (adxVar.K()) {
                    i++;
                }
            }
            i3 = i3;
            i2 = i2;
            i = i;
        }
        Iterator<Map.Entry<String, CustomDragSpeakerContianer>> it = this.al.entrySet().iterator();
        while (it.hasNext()) {
            CustomDragSpeakerContianer value = it.next().getValue();
            if (value.getVisibility() == 0 && value.getRuleSpeaker() != null) {
                if (value.getRuleSpeaker().J()) {
                    i3++;
                } else if (value.getRuleSpeaker().G()) {
                    i2++;
                } else if (value.getRuleSpeaker().K()) {
                    i++;
                }
            }
        }
        if (an().n().e() == 1 || an().n().e() == 4) {
            for (adx adxVar2 : this.h) {
                if (adxVar2.G()) {
                    if (i2 < 2) {
                        adxVar2.c(adx.b);
                    } else {
                        adxVar2.c(adx.a);
                    }
                }
                if (adxVar2.J()) {
                    if (i3 < 2) {
                        adxVar2.c(adx.b);
                    } else {
                        adxVar2.c(adx.a);
                    }
                }
                if (adxVar2.K()) {
                    if (i < 2) {
                        adxVar2.c(adx.b);
                    } else {
                        adxVar2.c(adx.a);
                    }
                }
            }
            return;
        }
        if (an().n().e() == 2) {
            for (adx adxVar3 : this.h) {
                if (adxVar3.G()) {
                    if (i2 < 5) {
                        adxVar3.c(adx.b);
                    } else {
                        adxVar3.c(adx.a);
                    }
                }
                if (adxVar3.J()) {
                    if (i3 < 5) {
                        adxVar3.c(adx.b);
                    } else {
                        adxVar3.c(adx.a);
                    }
                }
                if (adxVar3.K()) {
                    if (i < 5) {
                        adxVar3.c(adx.b);
                    } else {
                        adxVar3.c(adx.a);
                    }
                }
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.av) {
            return true;
        }
        return a(motionEvent);
    }

    private boolean az() {
        Iterator<Map.Entry<String, CustomDragSpeakerContianer>> it = this.al.entrySet().iterator();
        while (it.hasNext()) {
            CustomDragSpeakerContianer value = it.next().getValue();
            if (value.getVisibility() == 0 && value.getRuleSpeaker() == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, MotionEvent motionEvent, b bVar) {
        int action = motionEvent.getAction();
        if (this.av) {
            return true;
        }
        switch (action) {
            case 0:
                this.aG = false;
                this.aB = (ImageView) view.findViewById(R.id.speaker_one_drag_image_position);
                this.aB.getLocationOnScreen(this.aJ);
                this.aD = this.aB.getWidth();
                this.aE = this.aB.getHeight();
                this.aH = motionEvent.getRawX();
                this.aI = motionEvent.getRawY();
                break;
            case 1:
                if (!this.aG && this.ar) {
                    this.ar = false;
                    if (this.al.get(bVar.name()).getRuleSpeaker() != null) {
                        adw.a().a(this.al.get(bVar.name()).getRuleSpeaker());
                    }
                    a(this.al.get(bVar.name()).getSpeakerAnimationLayout(), 3);
                }
                if (aN != b.NONE_SELECTED) {
                    aE();
                    aJ();
                    aL();
                } else if (this.aM != -1) {
                    a(bVar);
                    aJ();
                    aL();
                    o(false);
                } else {
                    CustomDragSpeakerContianer customDragSpeakerContianer = this.al.get(this.aq.name());
                    if (customDragSpeakerContianer != null) {
                        customDragSpeakerContianer.setDragStatus(CustomDragSpeakerContianer.a.SELECT_SPEAKER);
                    }
                    aH();
                }
                this.aq = b.NONE_SELECTED;
                aG();
                break;
            case 2:
                if (!this.aG && (Math.abs(motionEvent.getRawX() - this.aH) > this.ak || Math.abs(motionEvent.getRawY() - this.aI) > this.ak)) {
                    this.aq = bVar;
                    a(this.al.get(this.aq.name()));
                }
                if (this.aG) {
                    b(motionEvent);
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // defpackage.aoj
    public void e() {
        super.e();
        aC();
    }

    private void aA() {
        int iAT = aT();
        mm.b("switch 5g wifi5gsize = " + iAT, new Object[0]);
        mm.b("switch 5g getCallback().getRoomItem().getSelectedDFs().size() = " + an().n().v().size(), new Object[0]);
        if (e(an().n().v())) {
            mm.b("Speaker is connected to ethernet...", new Object[0]);
            Bundle bundle = new Bundle();
            bundle.putString("DEVICE_TYPE", an().n().e() == 4 ? aoi.BAR_BAN_2_4G.toString() : aoi.ADAPT_BAN_2_4G.toString());
            an().a(aoi.BAR_BAN_2_4G, bundle);
            return;
        }
        if (iAT > an().n().v().size()) {
            aB();
            return;
        }
        ain.X.clear();
        a(new Runnable() { // from class: apd.13
            @Override // java.lang.Runnable
            public void run() {
                if (apd.this.au != null) {
                    apd.this.au.setCancelable(false);
                    apd.this.a(apd.this.au, apd.this.p());
                }
            }
        });
        mq.b().b(new Runnable() { // from class: apd.14
            @Override // java.lang.Runnable
            public void run() {
                adx adxVarN = apd.this.an().n().n();
                mm.b("switch 5g Main Device:: %s", adxVarN);
                if (adxVarN != null && !adxVarN.ad()) {
                    adw.a().a(adxVarN, (byte) 1, 3);
                }
                List<adx> listV = apd.this.an().n().v();
                mm.b("switch 5g Speaker list %s", listV);
                if (listV != null && !listV.isEmpty()) {
                    Iterator<adx> it = listV.iterator();
                    while (it.hasNext()) {
                        adx next = it.next();
                        Object[] objArr = new Object[2];
                        objArr[0] = next;
                        objArr[1] = next != null ? Boolean.valueOf(next.ad()) : null;
                        mm.b("switch 5g Speaker %s, is Connected To wifi 5G= %s", objArr);
                        if (next != null && !next.ad()) {
                            adw.a().a(next, (byte) 1, 3);
                        }
                    }
                }
                while (true) {
                    if (apd.this.aL >= 60) {
                        break;
                    }
                    mm.b("switch 5g index = " + apd.this.aL, new Object[0]);
                    apd.g(apd.this);
                    int iAT2 = apd.this.aT();
                    mm.b("switch 5g wifi5gsize = " + iAT2, new Object[0]);
                    mm.b("switch 5g getCallback().getRoomItem().getSelectedDFs().size() = " + apd.this.an().n().v().size(), new Object[0]);
                    if (iAT2 > apd.this.an().n().v().size()) {
                        apd.this.aB();
                        apd.this.aL = 0;
                        break;
                    } else {
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (apd.this.aL >= 60) {
                    mm.b("switch 5g fail", new Object[0]);
                    apd.this.aL = 0;
                    apd.this.a(new Runnable() { // from class: apd.14.1
                        @Override // java.lang.Runnable
                        public void run() {
                            apd.this.b(apd.this.au, apd.this.p());
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("DEVICE_TYPE", apd.this.an().n().e() == 4 ? aoi.BAR_BAN_2_4G.toString() : aoi.ADAPT_BAN_2_4G.toString());
                            apd.this.an().a(aoi.BAR_BAN_2_4G, bundle2);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB() {
        mm.b("switch 5g afterSwitch5GSuccess", new Object[0]);
        if (an().n().n() != null) {
            mm.b("switch 5g afterSwitch5GSuccess1 p2pQuerySourceSetup", new Object[0]);
            adw.a().h(an().n().n());
        }
        mm.b("switch 5g afterSwitch5GSuccess2", new Object[0]);
        if (!an().n().u().b(an().n().v())) {
            mm.c();
            mm.b("switch 5g afterSwitch5GSuccess3", new Object[0]);
            return;
        }
        mm.b("switch 5g afterSwitch5GSuccess4", new Object[0]);
        ain.a();
        mq.b().b(new Runnable() { // from class: apd.15
            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < 3; i++) {
                    mm.c("p2pQuerySourceSetup sendCommand %d times for setup 5.1", Integer.valueOf(i));
                    apd.this.an().n().w();
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        if (this.au != null) {
            this.au.setCancelable(false);
            a(this.au, p());
        }
        mq.c().schedule(new Runnable() { // from class: apd.16
            @Override // java.lang.Runnable
            public void run() {
                if (!apd.this.ax) {
                    apd.this.aw = false;
                    apd.this.a(new Runnable() { // from class: apd.16.1
                        @Override // java.lang.Runnable
                        public void run() {
                            mm.b("5.1 system test", "go to setup fail page");
                            if (apd.this.an().n() != null) {
                                adx adxVarN = apd.this.an().n().n();
                                apd.this.aD();
                                if (adxVarN != null && (adxVarN.I() || adxVarN.q() == 7)) {
                                    mm.b("5.1 source", "set main device to audio mode while ungroup speaker");
                                    aoz.a(adxVarN);
                                }
                                apd.this.b(apd.this.au, apd.this.p());
                                apd.this.an().a(aoi.SETUP_FAIL, (Bundle) null);
                            }
                        }
                    });
                }
            }
        }, 60L, TimeUnit.SECONDS);
        mq.c().schedule(new Runnable() { // from class: apd.17
            @Override // java.lang.Runnable
            public void run() {
                if (apd.this.ax && !apd.this.ay) {
                    apd.this.aw = false;
                    apd.this.a(new Runnable() { // from class: apd.17.1
                        @Override // java.lang.Runnable
                        public void run() {
                            mm.b("5.1 system test", "go to ban 2.4 page");
                            adx adxVarN = apd.this.an().n().n();
                            apd.this.aD();
                            if (adxVarN != null && (adxVarN.I() || adxVarN.q() == 7)) {
                                mm.b("5.1 source", "set main device to audio mode while ungroup speaker");
                                aoz.a(adxVarN);
                            }
                            apd.this.b(apd.this.au, apd.this.p());
                            Bundle bundle = new Bundle();
                            bundle.putString("DEVICE_TYPE", apd.this.an().n().e() == 4 ? aoi.BAR_BAN_2_4G.toString() : aoi.ADAPT_BAN_2_4G.toString());
                            apd.this.an().a(aoi.BAR_BAN_2_4G, bundle);
                        }
                    });
                }
            }
        }, 60L, TimeUnit.SECONDS);
        if (an().n().e() == 4 || an().n().e() == 2) {
            mq.b().b(new Runnable() { // from class: apd.2
                @Override // java.lang.Runnable
                public void run() {
                    while (apd.this.aw) {
                        if (apd.this.an().n().e() == 4 || apd.this.an().n().e() == 2) {
                            int iX = apd.this.an().n().x();
                            int size = ain.W.size();
                            int size2 = ain.X.size();
                            apd.this.ax = size >= iX;
                            mm.b("5.1 system test", "p2p success size = " + size, "speaker size = " + iX, "has enough p2p connection ? = " + apd.this.ax);
                            apd.this.ay = size2 >= iX + 1;
                            mm.b("5.1 system test", "wifi 5g success size = " + size2, "speakers & main device size  = " + (iX + 1), "has enough wifi 5g connection ? = " + apd.this.ay);
                            if (apd.this.ax && apd.this.ay) {
                                mm.b("5.1 system test", "go to connecting to speaker page");
                                apd.this.aw = false;
                                apd.this.a(new Runnable() { // from class: apd.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        apd.this.b(apd.this.au, apd.this.p());
                                        apd.this.an().a(aoi.CONNECTING_TO_SPEAKER, (Bundle) null);
                                    }
                                });
                                return;
                            }
                        } else {
                            mm.b(((int) apd.this.an().n().e()) + "------", new Object[0]);
                        }
                        try {
                            Thread.sleep(2000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    private void aC() {
        Iterator<Map.Entry<String, CustomDragSpeakerContianer>> it = this.al.entrySet().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            CustomDragSpeakerContianer value = it.next().getValue();
            if (value.getVisibility() == 0 && value.getRuleSpeaker() != null) {
                adx adxVar = new adx(new Device(value.getRuleSpeaker().R()));
                arrayList.add(adxVar);
                switch (value.getRoleCommand()) {
                    case 1:
                        an().n().c(adxVar);
                        break;
                    case 2:
                        an().n().d(adxVar);
                        break;
                    case 3:
                        an().n().e(adxVar);
                        break;
                    case 5:
                        an().n().f(adxVar);
                        break;
                    case 6:
                        an().n().g(adxVar);
                        break;
                }
                an().n().a(arrayList);
            }
        }
        aof.a().c().b(this.at);
        if (an().n().e() == 0 || an().n().e() == 3) {
            an().n().w();
            an().a(aoi.CONNECTING_TO_SPEAKER, (Bundle) null);
        } else if (an().n().e() == 4 || an().n().e() == 2) {
            aA();
        } else {
            an().a(aoi.SETUP_CHANNEL_MASTER, (Bundle) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        adx adxVarN = an().n().n();
        copyOnWriteArrayList.addAll(an().n().v());
        copyOnWriteArrayList.add(adxVarN);
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            ((adx) it.next()).Q();
        }
        aof.a().p();
    }

    private void a(b bVar) {
        adx ruleSpeaker = this.al.get(bVar.name()).getRuleSpeaker();
        this.al.get(bVar.name()).a(CustomDragSpeakerContianer.a.SELECT_NOTHING, (adx) null);
        int iIndexOf = this.h.indexOf(this.an);
        this.h.remove(this.an);
        this.h.add(iIndexOf, ruleSpeaker);
        this.i.c(iIndexOf);
        this.ar = true;
        this.aM = -1;
    }

    private void aE() {
        this.al.get(aN.name()).getSpeaker_drag_image().clearAnimation();
        adx ruleSpeaker = this.al.get(this.aq.name()).getRuleSpeaker();
        adx ruleSpeaker2 = this.al.get(aN.name()).getRuleSpeaker();
        this.al.get(aN.name()).a(CustomDragSpeakerContianer.a.SELECT_SPEAKER, ruleSpeaker);
        if (ruleSpeaker2 != null) {
            this.al.get(this.aq.name()).a(CustomDragSpeakerContianer.a.SELECT_SPEAKER, ruleSpeaker2);
        } else {
            this.al.get(this.aq.name()).a(CustomDragSpeakerContianer.a.SELECT_NOTHING, (adx) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF() {
        ImageView speaker_drag_image = this.al.get(b.KEY_LEFT.name()).getSpeaker_drag_image();
        ImageView speaker_drag_image2 = this.al.get(b.KEY_RIGHT.name()).getSpeaker_drag_image();
        speaker_drag_image.clearAnimation();
        speaker_drag_image2.clearAnimation();
        adx ruleSpeaker = this.al.get(b.KEY_LEFT.name()).getRuleSpeaker();
        adx ruleSpeaker2 = this.al.get(b.KEY_RIGHT.name()).getRuleSpeaker();
        this.al.get(b.KEY_RIGHT.name()).a(CustomDragSpeakerContianer.a.SELECT_SPEAKER, ruleSpeaker);
        this.al.get(b.KEY_LEFT.name()).a(CustomDragSpeakerContianer.a.SELECT_SPEAKER, ruleSpeaker2);
    }

    private boolean a(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aF = false;
                this.aG = false;
                this.aA = this.af.a(motionEvent.getX(), motionEvent.getY());
                if (this.aA != null) {
                    this.aA.getLocationOnScreen(this.aJ);
                    this.aC = this.af.f(this.aA);
                    if (this.h.get(this.aC).V() == adx.b) {
                        this.aC = -1;
                        this.aA = null;
                    } else {
                        this.aB = (ImageView) this.aA.findViewById(R.id.icon);
                        this.aD = this.aB.getWidth();
                        this.aE = this.aB.getHeight();
                        this.aH = motionEvent.getRawX();
                        this.aI = motionEvent.getRawY();
                    }
                }
                break;
            case 1:
                if (this.aA != null) {
                    if (!this.aG) {
                        if (this.aF) {
                            this.aC = -1;
                            this.aF = false;
                        } else if (this.ar && this.aC != b) {
                            this.ar = false;
                            RelativeLayout relativeLayout = (RelativeLayout) this.aA.findViewById(R.id.sound_animation_layout);
                            if (this.aC >= 0 && this.aC < this.h.size()) {
                                adw.a().a(this.h.get(this.aC));
                            }
                            agt.a(relativeLayout, 3, R.drawable.speaker_sound_animation_circle, this.e);
                        }
                    }
                    if (this.aC != -1 && aN != b.NONE_SELECTED) {
                        adx ruleSpeaker = this.al.get(aN.name()).getRuleSpeaker();
                        this.al.get(aN.name()).getSpeaker_drag_image().clearAnimation();
                        this.al.get(aN.name()).a(CustomDragSpeakerContianer.a.SELECT_SPEAKER, this.h.remove(this.aC));
                        if (ruleSpeaker != null) {
                            this.h.add(this.aC, ruleSpeaker);
                            this.i.c(this.aC);
                            this.ar = true;
                        } else {
                            this.i.e(this.aC);
                            this.ar = true;
                        }
                        aJ();
                        o(true);
                    } else {
                        aI();
                    }
                    aG();
                }
                break;
            case 2:
                if (this.aA != null) {
                    if (this.af.canScrollHorizontally(3) || this.aG || this.aF) {
                        if (!this.aG && !this.aF) {
                            if (Math.abs(motionEvent.getRawX() - this.aH) > this.ak) {
                                this.aC = -1;
                                this.aF = true;
                            } else if (Math.abs(motionEvent.getRawY() - this.aI) > this.ak) {
                                a((RelativeLayout) this.aA.findViewById(R.id.speaker_drag_bg_bin));
                            }
                        }
                    } else if (Math.abs(motionEvent.getRawX() - this.aH) > this.ak || Math.abs(motionEvent.getRawY() - this.aI) > this.ak) {
                        a((RelativeLayout) this.aA.findViewById(R.id.speaker_drag_bg_bin));
                    }
                    if (this.aG) {
                        c(motionEvent);
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    private void aG() {
        if (az()) {
            if (an().n().e() == 1 || an().n().e() == 4) {
                this.g.setVisibility(0);
            }
            an().b(a(R.string.Next_Str));
            an().c(true);
            an().d("");
            an().f(4);
            return;
        }
        if (an().n().e() == 1 || an().n().e() == 4) {
            this.g.setVisibility(8);
        }
        an().c(false);
        an().d(a(R.string.kRoomSetupTutorialCantFindProductBtt_Str));
    }

    private void aH() {
        n(false);
    }

    private void aI() {
        n(true);
    }

    private void n(boolean z) {
        if (this.az != null) {
            int[] iArr = new int[2];
            this.az.getLocationOnScreen(iArr);
            int i = this.aJ[0] - iArr[0];
            if (z) {
                i += this.ao;
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, i, 0.0f, this.aJ[1] - iArr[1]);
            translateAnimation.setDuration(180L);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: apd.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    apd.this.av = true;
                    if (apd.this.aA != null) {
                        apd.this.aA.setVisibility(0);
                    }
                    apd.this.aJ();
                    apd.this.aK();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    apd.this.av = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.az.startAnimation(translateAnimation);
        }
    }

    private void a(int i, int i2) {
        View viewA = this.af.a(i, ((i2 - this.am.getTop()) - this.af.getTop()) + this.ap);
        if (a(this.af, i, ((int) this.aE) + i2) && this.aM == -1 && viewA == null) {
            this.aM = this.h.size();
            this.h.add(this.h.size(), this.an);
            this.i.d(this.h.size());
            this.ar = true;
            return;
        }
        if (viewA != null) {
            int iF = this.af.f(viewA);
            if (iF != 0) {
                if (this.aM != -1 && iF > this.aM) {
                    iF--;
                }
                if (this.aM == -1 && iF != -1) {
                    this.aM = iF;
                    this.h.add(iF, this.an);
                    this.i.d(iF);
                    this.ar = true;
                    return;
                }
                if (this.aM != -1 && this.aM != iF && iF != -1) {
                    this.h.remove(this.an);
                    this.h.add(iF, this.an);
                    this.i.a(this.aM, iF);
                    this.ar = true;
                    this.aM = iF;
                    return;
                }
                return;
            }
            return;
        }
        if (!a(this.af, i, ((int) this.aE) + i2) && this.aM != -1) {
            this.aM = -1;
            a(this.an);
        }
    }

    private void a(adx adxVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.h.size()) {
                if (!this.h.get(i2).equals(adxVar)) {
                    i = i2 + 1;
                } else {
                    this.h.remove(adxVar);
                    this.i.e(i2);
                    this.ar = true;
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ() {
        this.aC = -1;
        aN = b.NONE_SELECTED;
        this.aG = false;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: apd.4
            @Override // java.lang.Runnable
            public void run() {
                apd.this.az.clearAnimation();
                apd.this.f.removeView(apd.this.az);
                apd.this.f.invalidate();
            }
        }, 50L);
    }

    private void a(ViewGroup viewGroup) {
        a(viewGroup, false);
    }

    private void a(ViewGroup viewGroup, boolean z) {
        this.aG = true;
        this.f.removeView(this.az);
        this.az = (ImageView) ahe.a(p(), this.aB);
        this.f.addView(this.az);
        this.aB.setVisibility(8);
        if (z) {
            viewGroup.setBackgroundResource(R.drawable.speaker_rectangular_drag_bg);
        } else {
            viewGroup.setBackgroundResource(R.drawable.speaker_circle_drag_bg);
        }
        viewGroup.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK() {
        this.aB.setVisibility(0);
        if (this.aA != null) {
            ((RelativeLayout) this.aA.findViewById(R.id.speaker_drag_bg_bin)).setBackgroundResource(R.drawable.speaker_bin);
        }
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void E() {
        super.E();
        aof.a().c().b(this.at);
        if (l() != null && l().getBoolean("AdaptBarFirstTimeSetup")) {
            an().n().b((adx) null);
        }
    }

    private void b(MotionEvent motionEvent) {
        a(motionEvent, true);
    }

    private void c(MotionEvent motionEvent) {
        a(motionEvent, false);
    }

    private void a(MotionEvent motionEvent, boolean z) {
        float rawX = motionEvent.getRawX() - (this.aD / 2.0f);
        float rawY = ((motionEvent.getRawY() - this.aE) - this.ah) - this.ai;
        int rawX2 = (int) motionEvent.getRawX();
        int rawY2 = (int) (motionEvent.getRawY() - (this.aE / 2.0f));
        c(rawX2, rawY2);
        if (z) {
            a(rawX2 + this.aj, (int) (rawY2 - this.aE));
        }
        this.az.setX(rawX);
        this.az.setY(rawY);
        this.az.setVisibility(0);
        this.f.invalidate();
    }

    private void c(int i, int i2) {
        for (Map.Entry<String, CustomDragSpeakerContianer> entry : this.al.entrySet()) {
            CustomDragSpeakerContianer value = entry.getValue();
            mm.b("TEST_DRAG  contianerSize = %s ,hashcode = %s , selected contianer = %s isVisible = %s , isViewContains = %s , X = %s , Y = %s", "" + this.al.size(), Integer.valueOf(entry.hashCode()), entry.getKey(), Integer.valueOf(value.getVisibility()), Boolean.valueOf(a(value, i, i2)), Integer.valueOf(i), Integer.valueOf(i2));
            if (value.getVisibility() == 0) {
                if (a(value, i, i2) && aN != b.valueOf(entry.getKey())) {
                    aN = b.valueOf(entry.getKey());
                    value.setDragStatus(CustomDragSpeakerContianer.a.SELECT_HIGHLIGHT);
                    CustomDragSpeakerContianer customDragSpeakerContianer = this.al.get(this.aq.name());
                    if (customDragSpeakerContianer != null) {
                        if (value.getRuleSpeaker() != null && aN != this.aq) {
                            a(value.getSpeaker_drag_image());
                        } else {
                            customDragSpeakerContianer.setDragStatus(CustomDragSpeakerContianer.a.SELECT_BING_SPEAKER);
                        }
                    } else {
                        a(value.getSpeaker_drag_image(), true);
                    }
                } else {
                    CustomDragSpeakerContianer customDragSpeakerContianer2 = this.al.get(aN.name());
                    if (customDragSpeakerContianer2 != null && !a(customDragSpeakerContianer2, i, i2)) {
                        if (aN != this.aq) {
                            if (customDragSpeakerContianer2.getRuleSpeaker() != null) {
                                customDragSpeakerContianer2.setDragStatus(CustomDragSpeakerContianer.a.SELECT_SPEAKER);
                                b(customDragSpeakerContianer2.getSpeaker_drag_image());
                            } else {
                                customDragSpeakerContianer2.a(CustomDragSpeakerContianer.a.SELECT_NOTHING, (adx) null);
                            }
                        }
                        aN = b.NONE_SELECTED;
                    }
                    CustomDragSpeakerContianer customDragSpeakerContianer3 = this.al.get(this.aq.name());
                    if (customDragSpeakerContianer3 != null && !a(customDragSpeakerContianer3, i, i2)) {
                        customDragSpeakerContianer3.setDragStatus(CustomDragSpeakerContianer.a.SELECT_BING_SPEAKER);
                    }
                }
            }
        }
    }

    private void a(ImageView imageView, boolean z) {
        TranslateAnimation translateAnimation;
        final CustomDragSpeakerContianer customDragSpeakerContianer = this.al.get(aN.name());
        if (customDragSpeakerContianer != null) {
            if (imageView.equals(customDragSpeakerContianer.getSpeaker_drag_image())) {
                imageView.getLocationOnScreen(this.d);
                if (z) {
                    this.d[0] = this.d[0] - this.ao;
                    this.d[1] = this.d[1];
                }
                translateAnimation = new TranslateAnimation(0.0f, this.aJ[0] - this.d[0], 0.0f, this.aJ[1] - this.d[1]);
                mm.b("TEST_DRAG startLoc[0] = %s , finalLocSpeaker1[0] = %s ,startLoc[1] = %s , finalLocSpeaker1[1] = %s", Integer.valueOf(this.aJ[0]), Integer.valueOf(this.d[0]), Integer.valueOf(this.aJ[1]), Integer.valueOf(this.d[1]));
            } else {
                imageView.getLocationOnScreen(this.c);
                translateAnimation = new TranslateAnimation(0.0f, this.aJ[0] - this.c[0], 0.0f, this.aJ[1] - this.c[1]);
            }
            translateAnimation.setDuration(150L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: apd.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    customDragSpeakerContianer.setDragStatus(CustomDragSpeakerContianer.a.SELECT_HIGHLIGHT_AFTER_ANIMATION);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            imageView.startAnimation(translateAnimation);
        }
    }

    private void a(ImageView imageView) {
        a(imageView, false);
    }

    private void b(final ImageView imageView) {
        TranslateAnimation translateAnimation;
        if (imageView.equals(this.al.get(aN.name()).getSpeaker_drag_image())) {
            translateAnimation = new TranslateAnimation(this.aJ[0] - this.d[0], 0.0f, this.aJ[1] - this.d[1], 0.0f);
        } else {
            translateAnimation = new TranslateAnimation(this.aJ[0] - this.c[0], 0.0f, this.aJ[1] - this.c[1], 0.0f);
        }
        translateAnimation.setDuration(150L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: apd.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                imageView.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        imageView.startAnimation(translateAnimation);
    }

    private void a(ViewGroup viewGroup, int i) {
        agt.a(viewGroup, i, R.drawable.speaker_sound_animation_circle, this.e);
    }

    private void aL() {
        Iterator<CustomDragSpeakerContianer> it = this.al.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    private void o(boolean z) {
        if (z) {
            d(HttpStatus.SC_BAD_REQUEST);
        } else {
            d(0);
        }
    }

    private void d(int i) {
        if (an().n().e() == 0) {
            Iterator<adx> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().c(adx.a);
            }
        } else if (aM().size() == 0 && an().n().e() == 1) {
            ay();
        } else if (aM().size() == 0 && an().n().e() == 4) {
            ay();
        } else if (aM().size() == 0 && an().n().e() == 2) {
            ay();
        } else if (aM().size() > 0) {
            d(aM());
        }
        aN();
        new Handler().postDelayed(new Runnable() { // from class: apd.7
            @Override // java.lang.Runnable
            public void run() {
                apd.this.i.c();
            }
        }, i);
    }

    private List<CustomDragSpeakerContianer> aM() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, CustomDragSpeakerContianer>> it = this.al.entrySet().iterator();
        while (it.hasNext()) {
            CustomDragSpeakerContianer value = it.next().getValue();
            if (value.getRuleSpeaker() != null) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    private void d(List<CustomDragSpeakerContianer> list) {
        byte bQ = list.get(0).getRuleSpeaker().q();
        for (adx adxVar : this.h) {
            if (adxVar.q() != bQ) {
                adxVar.c(adx.b);
            } else {
                adxVar.c(adx.a);
            }
        }
    }

    private void aN() {
        aO();
        aP();
    }

    private void aO() {
        if (an().n().e() == 0 || an().n().e() == 1) {
            for (adx adxVar : this.h) {
                if (adxVar.q() == 8) {
                    adxVar.c(adx.b);
                }
            }
        }
    }

    private void aP() {
        if (an().n().e() == 3) {
            for (adx adxVar : this.h) {
                if (adxVar.F()) {
                    adxVar.c(adx.b);
                }
            }
        }
    }

    class a extends RecyclerView.a<C0043a> {
        private a() {
        }

        @Override // android.support.v7.widget.RecyclerView.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public C0043a a(ViewGroup viewGroup, int i) {
            View viewInflate = apd.this.ae.inflate(R.layout.draggable_speakers_icon, viewGroup, false);
            C0043a c0043a = new C0043a(viewInflate);
            c0043a.n = (ImageView) viewInflate.findViewById(R.id.icon);
            c0043a.o = (RelativeLayout) viewInflate.findViewById(R.id.speaker_drag_bg_bin);
            c0043a.p = (TextView) viewInflate.findViewById(R.id.speaker_drag_name);
            return c0043a;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public void a(C0043a c0043a, int i) {
            adx adxVar = (adx) apd.this.h.get(i);
            if (adxVar != null && adxVar.c) {
                c0043a.n.setVisibility(4);
                c0043a.o.setBackgroundResource(R.drawable.speaker_circle_drag_bg);
                c0043a.p.setText("");
            } else {
                c0043a.n.setVisibility(0);
                c0043a.o.setBackgroundResource(R.drawable.speaker_bin);
                c0043a.n.setImageResource(adxVar.A());
                String strW = adxVar.w();
                if (strW == null || strW.isEmpty()) {
                    strW = adxVar.x();
                }
                if (strW.contains("HK ")) {
                    strW = strW.replace("HK ", "");
                }
                if (strW.contains("_")) {
                    strW = strW.replace("_", " ");
                }
                if (aho.a("KEY_SHOW_THE_DEVICE_INFO_IN_DASHBOARD")) {
                    c0043a.p.setHeight(ahn.a(apd.this.p(), 80.0f));
                    strW = strW + " " + adxVar.z().substring(8) + " " + adxVar.e();
                }
                c0043a.p.setText(strW);
            }
            if (adxVar.V() == adx.b) {
                c0043a.n.setImageAlpha(57);
            } else {
                c0043a.n.setImageAlpha(255);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public long b(int i) {
            return 0L;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public int a() {
            return apd.this.h.size();
        }

        /* JADX INFO: renamed from: apd$a$a, reason: collision with other inner class name */
        class C0043a extends RecyclerView.v {
            ImageView n;
            RelativeLayout o;
            TextView p;

            public C0043a(View view) {
                super(view);
            }
        }
    }

    private boolean a(View view, int i, int i2) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        return i >= i3 && i <= i3 + view.getWidth() && i2 >= i4 && i2 <= i4 + view.getHeight();
    }

    @Override // defpackage.aoj
    public void b() {
        super.b();
        if (!an().n().c() || an().n().a()) {
            mo.a.a(new Runnable() { // from class: apd.8
                @Override // java.lang.Runnable
                public void run() {
                    apd.this.an().e(true);
                }
            });
        }
        aR();
        aQ();
        a(aof.a().f());
        an().d(a(R.string.kRoomSetupTutorialCantFindProductBtt_Str));
        an().c(a(R.string.kSetupConfigureSpeakers_Str));
        aG();
    }

    private void aQ() {
        for (Map.Entry<String, CustomDragSpeakerContianer> entry : this.al.entrySet()) {
            String key = entry.getKey();
            mm.b("TEST_DRAG role = %s", key);
            CustomDragSpeakerContianer value = entry.getValue();
            value.setRoleType(b.valueOf(key));
            value.setChannelType(an().n().e());
            value.setOnTouchListener(this.aK);
            value.b();
            value.a();
        }
    }

    private void aR() {
        if (an().n().e() == 2) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ag.getLayoutParams();
            layoutParams.bottomMargin = ahn.a(p(), 5.0f);
            this.al.clear();
            this.ag.removeAllViews();
            View viewInflate = LayoutInflater.from(p()).inflate(R.layout.view_drag_speakers_for_channel_hometheater, (ViewGroup) null);
            this.al.put(b.KEY_LEFT.name(), (CustomDragSpeakerContianer) viewInflate.findViewById(R.id.speaker_one_drag_position));
            this.al.put(b.KEY_AROUND_CENTER.name(), (CustomDragSpeakerContianer) viewInflate.findViewById(R.id.speaker_center_drag_position));
            this.al.put(b.KEY_RIGHT.name(), (CustomDragSpeakerContianer) viewInflate.findViewById(R.id.speaker_two_drag_position));
            this.al.put(b.KEY_AROUND_LEFT.name(), (CustomDragSpeakerContianer) viewInflate.findViewById(R.id.speaker_rl_drag_position));
            this.al.put(b.KEY_AROUND_RIGHT.name(), (CustomDragSpeakerContianer) viewInflate.findViewById(R.id.speaker_rr_drag_position));
            this.ag.addView(viewInflate);
            this.ag.setLayoutParams(layoutParams);
            this.g.setVisibility(8);
            return;
        }
        if (an().n().e() == 0) {
            this.al.get(b.KEY_RIGHT.name()).setVisibility(8);
            this.al.get(b.KEY_LEFT.name()).setVisibility(0);
            this.g.setVisibility(8);
        } else if (an().n().e() == 1 || an().n().e() == 4) {
            this.al.get(b.KEY_LEFT.name()).setVisibility(0);
            this.al.get(b.KEY_RIGHT.name()).setVisibility(0);
            this.g.setVisibility(8);
        } else if (an().n().e() == 3) {
            this.al.get(b.KEY_LEFT.name()).setVisibility(8);
            this.al.get(b.KEY_RIGHT.name()).setVisibility(8);
            this.g.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS() {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (this.al.get(b.KEY_LEFT.name()).getRuleSpeaker() != null && this.al.get(b.KEY_RIGHT.name()).getRuleSpeaker() != null) {
            this.al.get(b.KEY_LEFT.name()).getSpeaker_drag_image().getLocationOnScreen(iArr);
            this.al.get(b.KEY_RIGHT.name()).getSpeaker_drag_image().getLocationOnScreen(iArr2);
            mm.b("TEST_ANIMATION one X =  %s Y = %s, two X = %s Y %s", "" + iArr[0], "" + iArr[1], "" + iArr2[0], "" + iArr2[1]);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, iArr2[0] - iArr[0], 0.0f, iArr[1] - iArr2[1]);
            translateAnimation.setDuration(350L);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, iArr[0] - iArr2[0], 0.0f, iArr[1] - iArr2[1]);
            translateAnimation2.setDuration(350L);
            translateAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: apd.9
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    apd.this.aF();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.al.get(b.KEY_LEFT.name()).getSpeaker_drag_image().startAnimation(translateAnimation);
            this.al.get(b.KEY_RIGHT.name()).getSpeaker_drag_image().startAnimation(translateAnimation2);
        }
    }

    @Override // defpackage.aoj
    public void ap() {
        if (ao()) {
        }
    }

    @Override // defpackage.aoj
    public void al() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("find the other spekaers", true);
        bundle.putBoolean("isFirstTime", false);
        an().a(aoi.CHANNEL_SETUP_TUTORIAL, bundle);
    }

    private boolean e(List<adx> list) {
        if (list == null) {
            return false;
        }
        for (adx adxVar : list) {
            mm.b("isSpeakerConnectedToEthernet Device =%s", adxVar);
            if (adxVar != null) {
                adx adxVarA = aof.a().a(adxVar.P());
                mm.b("isSpeakerConnectedToEthernet Updated Device =%s", adxVarA);
                boolean z = adxVarA != null && adxVarA.ac() == 2;
                mm.b("isSpeakerConnectedToEthernet =%b", Boolean.valueOf(z));
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aT() {
        int i;
        int i2 = 0;
        Iterator<adx> it = an().n().v().iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            adx next = it.next();
            if (next != null && ain.X.contains(Long.valueOf(next.P()))) {
                i++;
            }
            i2 = i;
        }
        adx adxVarN = an().n().n();
        return (adxVarN == null || !ain.X.contains(Long.valueOf(adxVarN.P()))) ? i : i + 1;
    }
}
