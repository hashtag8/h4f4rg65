package defpackage;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bfrx.Device;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.setup.newpage.info.RoomItem;
import com.harman.hkconnect.ui.RippleTextView;
import defpackage.ahy;
import defpackage.aih;
import defpackage.arw;
import defpackage.aub;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class apz extends aoj implements aih.a<String> {
    private ListView aB;
    private TreeSet<String> aC;
    private ArrayList<adx> aE;
    private ahm aG;
    private List<View> aI;
    private long aL;
    private ImageView ae;
    private ImageView af;
    private TextView ag;
    private String ah;
    private View ai;
    private BroadcastReceiver am;
    private TextView as;
    private ImageView at;
    private ProgressBar au;
    private RelativeLayout av;
    private ScheduledFuture<?> aw;
    private aez ax;
    private View ay;
    private int az;
    private WifiManager f;
    private View h;
    private ImageView i;
    private static final TimeUnit e = TimeUnit.SECONDS;
    public static ArrayList<Long> a = new ArrayList<>();
    private static boolean aK = false;
    private SortedSet<String> d = new TreeSet(String.CASE_INSENSITIVE_ORDER);
    private aih<String> g = null;
    private Map<String, List<adx>> aj = Collections.synchronizedMap(new HashMap());
    private Map<String, adx> ak = Collections.synchronizedMap(new HashMap());
    private Map<String, ErrorInfo> al = Collections.synchronizedMap(new HashMap());
    private SortedSet<String> an = null;
    private TreeMap<String, Integer> ao = null;
    private az ap = null;
    private String aq = "";
    private boolean ar = false;
    private int aA = 0;
    private List<Long> aD = new ArrayList();
    private List<ScanResult> aF = null;
    private Activity aH = null;
    private boolean aJ = true;
    private boolean aM = true;
    arw b = null;
    a c = null;

    private void am() {
        if (this.aw != null) {
            this.aw.cancel(true);
        }
    }

    @Override // defpackage.aoj, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        l();
        this.g = new aih<>(p(), this, HttpStatus.SC_INTERNAL_SERVER_ERROR, R.layout.device_source_list_item, R.layout.harman_list_loading);
        this.f = (WifiManager) p().getSystemService("wifi");
        this.am = new BroadcastReceiver() { // from class: apz.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                apz.this.b(apz.this.f.getScanResults());
                new Handler().postDelayed(new Runnable() { // from class: apz.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        apz.this.f.startScan();
                    }
                }, 8000L);
            }
        };
        this.aG = new ahm(p(), this.am);
        this.aI = new ArrayList();
        b(true);
        ain.m = true;
        if (Build.VERSION.SDK_INT >= 23 && !ax()) {
            at();
        } else {
            aM();
        }
    }

    private void at() {
        if (this.b == null) {
            this.b = new arw.a(p()).b(false).a(R.string.enable_location_service_text).b(R.string.enable_location_service_title).a(a(R.string.YES_Str), new DialogInterface.OnClickListener() { // from class: apz.9
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    apz.this.a(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 2019);
                }
            }).b(a(R.string.Cancel_Str), new DialogInterface.OnClickListener() { // from class: apz.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    apz.this.b.dismiss();
                    apz.this.aG();
                    apz.this.p().onBackPressed();
                }
            }).d(false).b();
        }
        if (!this.b.isShowing() && !p().isFinishing()) {
            new asc(this.b).a(p());
        }
    }

    private boolean ax() {
        return ((LocationManager) p().getSystemService("location")).isProviderEnabled("gps");
    }

    @Override // defpackage.aoj, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.aH = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<ScanResult> list) {
        this.aF = list;
        if (this.as != null && this.au != null) {
            this.au.setVisibility(8);
            this.at.setVisibility(0);
            this.as.setText(R.string.kFCDeviceManager_DeviceDisconnect_Str);
        }
        this.an = e(list);
        mm.a("5.1 system test", "swapp setup wifi wifilist size after filter = " + this.an.size());
        this.ao = f(list);
        if (this.an.size() == 0) {
            if (this.ap != null) {
                this.ap.c();
            }
        } else if (this.an.size() > 0 && this.ap != null && !this.ap.z() && r() != null) {
            this.ap.a(r(), this.aq);
        }
        this.g.a(this.an);
        this.g.notifyDataSetChanged();
        if (ao() && !this.an.isEmpty() && !this.ar) {
            ay();
        }
    }

    private void ay() {
        String strA = an().n().u().a(this.an, aoz.a(aof.a().f()));
        if (strA == null || strA.trim().equals("")) {
            if (!l().getBoolean("selectMultipleBarOrAdapt", false) && !l().getBoolean("isShowingAdaptBarReady") && aL()) {
                d(1);
                return;
            }
            return;
        }
        b(strA);
    }

    private void a(Collection<String> collection, String str, SortedSet<String> sortedSet) {
        for (String str2 : collection) {
            if (str2.toLowerCase().contains(str.toLowerCase())) {
                sortedSet.add(str2);
                this.az++;
                mm.b("the %s sound bar = ", Integer.valueOf(sortedSet.size()), sortedSet);
            }
        }
        if (sortedSet.size() > 1) {
            l().putBoolean("selectMultipleBarOrAdapt", true);
        } else {
            l().putBoolean("selectMultipleBarOrAdapt", false);
        }
    }

    private void a(String str, String str2, SortedSet<String> sortedSet) {
        if (str.toLowerCase().contains(str2.toLowerCase())) {
            sortedSet.add(str);
            this.az++;
            mm.b("the %s sound bar = ", Integer.valueOf(sortedSet.size()), sortedSet);
        }
        if (sortedSet.size() > 1) {
            l().putBoolean("selectMultipleBarOrAdapt", true);
        } else {
            l().putBoolean("selectMultipleBarOrAdapt", false);
        }
    }

    private void b(Collection<String> collection, String str, SortedSet<String> sortedSet) {
        boolean zContains;
        for (String str2 : collection) {
            if (an().n().e() == 5) {
                zContains = str2.toLowerCase().contains(str.toLowerCase()) || str2.toLowerCase().contains("omni_adapt+amp_setup_") || str2.toLowerCase().contains("adapt_setup_");
            } else {
                zContains = str2.toLowerCase().contains(str.toLowerCase());
            }
            if (zContains) {
                sortedSet.add(str2);
                this.aA++;
                mm.b("the %s Adapt = ", Integer.valueOf(sortedSet.size()), sortedSet);
            }
        }
        if (sortedSet.size() > 1) {
            l().putBoolean("selectMultipleBarOrAdapt", true);
        } else {
            l().putBoolean("selectMultipleBarOrAdapt", false);
        }
    }

    private void b(String str, String str2, SortedSet<String> sortedSet) {
        boolean zContains;
        if (an().n().e() == 5) {
            zContains = str.toLowerCase().contains(str2.toLowerCase()) || str.toLowerCase().contains("omni_adapt+amp_setup_") || str.toLowerCase().contains("adapt_setup_");
        } else {
            zContains = str.toLowerCase().contains(str2.toLowerCase());
        }
        if (zContains) {
            sortedSet.add(str);
            this.aA++;
            mm.b("the %s Adapt = ", Integer.valueOf(sortedSet.size()), sortedSet);
        }
        if (sortedSet.size() > 1) {
            l().putBoolean("selectMultipleBarOrAdapt", true);
        } else {
            l().putBoolean("selectMultipleBarOrAdapt", false);
        }
    }

    private void a(Collection<String> collection, SortedSet<String> sortedSet) {
        for (String str : collection) {
            if (str.toLowerCase().contains("omni10_setup_") || str.toLowerCase().contains("omni20_setup_") || str.toLowerCase().contains("hk_omni_20+_setup_") || str.toLowerCase().contains("hk_omni_10+_setup_") || str.toLowerCase().contains("hk_omni_50+_setup_")) {
                sortedSet.add(str);
            }
        }
        l().putBoolean("selectMultipleBarOrAdapt", false);
    }

    private void b(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("MESSAGE", str);
        an().a(aoi.SHOW_ERROR_MESSAGE, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (!ao() && p() != null) {
            mm.b("Not showing dialog %s because we are not visible", Integer.valueOf(i));
        }
        mm.b("Showing dialog %s", Integer.valueOf(i));
        if (p() != null) {
            FragmentTransaction fragmentTransactionBeginTransaction = p().getFragmentManager().beginTransaction();
            this.aq = av() + "-dialog";
            Fragment fragmentFindFragmentByTag = p().getFragmentManager().findFragmentByTag(this.aq);
            if (fragmentFindFragmentByTag != null) {
                fragmentTransactionBeginTransaction.remove(fragmentFindFragmentByTag);
            }
            fragmentTransactionBeginTransaction.addToBackStack(null);
            switch (i) {
                case 1:
                    this.ar = true;
                    this.ap = aub.al();
                    Bundle bundle = new Bundle();
                    if (this.ao != null) {
                        String strB = ahx.a().b();
                        mm.b("@@@@@@ ######developer sortMap = " + this.ao, new Object[0]);
                        mm.b("@@@@@@ ######developer ssid = " + strB, new Object[0]);
                        mm.b("@@@@@@ ######developer sortMap.containsKey(ssid) = " + this.ao.containsKey(strB), new Object[0]);
                        if (this.ao != null && strB != null && !strB.isEmpty() && !this.ao.containsKey(strB)) {
                            mm.b("@@@@@@ ######developer add factitiously the default ssid to list", new Object[0]);
                            this.ao.put(strB, Integer.valueOf(ahx.a().c()));
                        }
                        bundle.putStringArrayList(aub.a.WIFI_LIST.name(), new ArrayList<>(this.ao.keySet()));
                        bundle.putIntegerArrayList(aub.a.WIFI_LEVEL_LIST.name(), new ArrayList<>(this.ao.values()));
                    }
                    this.ap.g(bundle);
                    this.ap.a(this, 1);
                    try {
                        this.ap.a(r().a(), this.aq);
                    } catch (RuntimeException e2) {
                        return;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, String str2) {
        mo.a.a(new Runnable() { // from class: apz.10
            @Override // java.lang.Runnable
            public void run() {
                apz.this.an().e(false);
            }
        });
        aK = true;
        mm.b("5.1 system test", "ssid= " + str + "  password = " + str2 + "  isDeviceSetting =" + aK);
        a = new ArrayList<>();
        if (!aL() || (l().getBoolean("selectMultipleBarOrAdapt") && an().n().n() == null)) {
            this.an = this.d;
            mm.b("5.1 system test", "selectIds =" + this.d);
        }
        new atz(str, str2, this.an, new aua() { // from class: apz.11
            @Override // defpackage.aua
            public void a(String str3) {
                apz.this.n(true);
                apz.this.ah = str3;
                if (apz.this.p() != null) {
                    apz.this.ag.setText(apz.this.a(R.string.SpeakerSetupWifiScrollEnterWifiName_Str, str3, str));
                }
                apz.this.g.notifyDataSetChanged();
            }

            @Override // defpackage.aua
            public void a(String str3, List<adx> list) {
                mm.b("swapp setup wifi onSetupSuccess Setup device %s", str3);
                apz.this.aj.put(str3, list);
                apz.this.g.notifyDataSetChanged();
            }

            @Override // defpackage.aua
            public void a(String str3, ErrorInfo errorInfo) {
                mm.b("swapp setup wifi Failed to setup device %s device %s", str3, errorInfo);
                apz.this.al.put(str3, errorInfo);
                apz.this.g.notifyDataSetChanged();
            }

            @Override // defpackage.aua
            public void a() {
                apz.this.n(false);
                mm.b("5.1 system test", "swapp setup wifi Completed setup, waiting for devices to confirm %s", apz.this.aj);
                if (apz.this.aj.isEmpty()) {
                    apz.this.aA();
                    mm.b("5.1 system test", "onComplete");
                } else {
                    apz.this.az();
                }
            }

            @Override // defpackage.aua
            public void b() {
                apz.this.n(false);
                apz.this.aA();
                mm.b("5.1 system test", "onReconnectError");
            }
        }).a();
        this.an = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        this.aw = mq.c().schedule(new Runnable() { // from class: apz.12
            @Override // java.lang.Runnable
            public void run() {
                apz.this.aw = null;
                for (String str : new ArrayList(apz.this.aj.keySet())) {
                    if (!apz.this.ak.containsKey(apz.this.aj)) {
                        apz.this.al.put(str, new ErrorInfo.a().a(R.string.kRoomSetupWACJoinFail_Str, new Object[0]).a());
                    }
                }
                apz.this.a(new Runnable() { // from class: apz.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        apz.this.g.notifyDataSetChanged();
                        apz.this.aA();
                    }
                });
                aof.a().c().b(apz.this.ax);
            }
        }, 90L, e);
        this.aL = System.currentTimeMillis();
        mm.b("5.1 system test", "timeout task will go to setup failure page in 90 seconds,current time is ", Long.valueOf(this.aL));
        this.ax = new aez() { // from class: apz.13
            @Override // defpackage.aez, defpackage.aey
            public void a(List<adx> list) {
                mm.b("5.1 system test", "onDevicesConfirmed 1, devices = " + apz.this.d(list));
                apz.this.c(list);
            }
        };
        aof.a().c().a(this.ax);
        this.g.notifyDataSetChanged();
        mm.b("5.1 system test", "onDevicesConfirmed 2");
        c(aof.a().c().d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA() {
        mm.c();
        aK = false;
        mm.b("5.1 system test", "setupFail isDeviceSetting =" + aK);
        if (this.aH != null && !this.aH.isFinishing()) {
            try {
                this.aG.c();
            } catch (IllegalArgumentException e2) {
                mm.b("Receiver is not registred....", new Object[0]);
            }
        }
        an().a(aoi.SETUP_FAIL, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aB() {
        return an().n().e() == 0 && aoz.a(aof.a().f()).size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void c(List<adx> list) {
        List<adx> listD = aof.a().c().d();
        mm.b("5.1 system test", "online device =" + d(listD));
        if (an().n().e() == 1) {
            if (this.aD.size() > 0 && listD.size() <= this.aD.size()) {
                mm.b("wait previous online device come back, previousOnlineDevices=%s, onlineDevices=%s , previousOnlineDevice size= %s, onlineDevices size = %s", this.aD, listD, Integer.valueOf(this.aD.size()), Integer.valueOf(listD.size()));
                return;
            } else if (this.aD.size() > 0 && !g(listD)) {
                mm.b("wait previous online device come back 2, previousOnlineDevices=%s, onlineDevices=%s, previousOnlineDevice size= %s, onlineDevices size = %s", this.aD, listD, Integer.valueOf(this.aD.size()), Integer.valueOf(listD.size()));
                return;
            } else if (this.aD.size() > 0) {
                mm.b("wait previous finish, exit waiting for previous online device come back, previousOnlineDevices=%s, onlineDevices=%s, previousOnlineDevice size= %s , onlineDevices size = %s", this.aD, listD, Integer.valueOf(this.aD.size()), Integer.valueOf(listD.size()));
            }
        }
        for (adx adxVar : listD) {
            for (Map.Entry entry : new ArrayList(this.aj.entrySet())) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (adxVar.P() == ((adx) it.next()).P()) {
                        this.ak.put(entry.getKey(), adxVar);
                        a(new Runnable() { // from class: apz.14
                            @Override // java.lang.Runnable
                            public void run() {
                                if (!apz.this.aB()) {
                                    apz.this.g.notifyDataSetChanged();
                                }
                            }
                        });
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        Iterator<Map.Entry<String, adx>> it2 = this.ak.entrySet().iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().getValue());
        }
        Iterator<Map.Entry<String, List<adx>>> it3 = this.aj.entrySet().iterator();
        while (it3.hasNext()) {
            arrayList2.addAll(it3.next().getValue());
        }
        Object[] objArr = new Object[1];
        objArr[0] = "swapp setup wifi" + this.ak.size() + " devices confirmed, is confirmed devices = " + d(arrayList) + "  matching to setup devices =  " + d(arrayList2) + "?? " + (this.ak.size() == this.aj.size());
        mm.b("5.1 system test", objArr);
        if (this.ak.size() == this.aj.size() && this.aw != null && this.aw.cancel(false)) {
            aK = false;
            mm.b("5.1 system test", "timeout task cancel successfully", "isDeviceSetting=" + aK);
            this.aw = null;
            for (adx adxVar2 : this.ak.values()) {
                if (adxVar2.s() != 0) {
                    adxVar2.Q();
                }
                a.add(Long.valueOf(adxVar2.P()));
                if (adxVar2.s() != 0) {
                    adxVar2.Q();
                }
                this.aE = new ArrayList<>();
                this.aE.add(adxVar2);
            }
            aof.a().c().b(this.ax);
            mq.b().b(new Runnable() { // from class: apz.15
                @Override // java.lang.Runnable
                public void run() {
                    while (apz.this.aJ) {
                        apz.this.a(new Runnable() { // from class: apz.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (!apz.this.aB()) {
                                    apz.this.g.notifyDataSetChanged();
                                }
                                List<adx> listD2 = aof.a().c().d();
                                mm.b("5.1 system test", "online device = " + apz.this.d(listD2) + "  contains  setup device = " + apz.this.d(arrayList2));
                                if (listD2.containsAll(apz.this.aE)) {
                                    List<adx> listA = aoz.a(listD2, (byte) 7);
                                    List<adx> listA2 = aoz.a(listD2, (byte) 8);
                                    if (apz.this.an().n().e() != 2) {
                                        if (apz.this.an().n().e() == 4) {
                                            if (listA2.size() > 0) {
                                                mm.b("5.1 system test", "all device is online, go to next page");
                                                apz.this.a(listD2);
                                                apz.this.aJ = false;
                                                return;
                                            } else {
                                                mm.b("5.1 system test", "wait for bar go online...");
                                                if (apz.this.p() != null) {
                                                    Toast.makeText(apz.this.p(), R.string.kSetupRoomWaitingForBar_Str, 1).show();
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        mm.b("5.1 system test", "all device is online, go to next page");
                                        apz.this.a(listD2);
                                        apz.this.aJ = false;
                                        return;
                                    }
                                    if (listA.size() > 0) {
                                        mm.b("5.1 system test", "all device is online, go to next page");
                                        apz.this.a(listD2);
                                        apz.this.aJ = false;
                                        return;
                                    } else {
                                        mm.b("5.1 system test", "wait for adapt go online...");
                                        if (apz.this.p() != null) {
                                            Toast.makeText(apz.this.p(), R.string.kSetupRoomWaitingForAdapt_Str, 1).show();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                mm.b("5.1 system test", "waiting for confirm device go online for " + (90 - ((System.currentTimeMillis() - apz.this.aL) / 1000)) + " seconds......");
                            }
                        });
                        try {
                            Thread.sleep(4000L);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
            return;
        }
        mm.b("5.1 system test", "timeout task will go to setup failure page in " + (90 - ((System.currentTimeMillis() - this.aL) / 1000)) + " seconds ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(List<adx> list) {
        String str = "";
        Iterator<adx> it = list.iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                str = str2 + it.next().e() + " ";
            } else {
                return str2;
            }
        }
    }

    public void a(List<adx> list) {
        mm.b("5.1 system test", "goToChannelSetup");
        List<adx> listI = aoz.i(list);
        List<adx> listA = aoz.a(list, (byte) 8);
        mm.b("5.1 system test bar size =%s , adapt size =%s", Integer.valueOf(listA.size()), Integer.valueOf(listI.size()));
        if (!aE()) {
            if (an().n().e() == 5) {
                if (listI.size() != 0) {
                    aD();
                    an().n().w();
                    am();
                    mm.b("5.1 system test", "go directly to connecting to speaker as the adapt is online");
                    an().a(aoi.CONNECTING_TO_SPEAKER, (Bundle) null);
                    return;
                }
                return;
            }
            if (an().n().e() == 3) {
                if (listA.size() != 0) {
                    aC();
                    an().n().w();
                    am();
                    an().a(aoi.CONNECTING_TO_SPEAKER, (Bundle) null);
                    return;
                }
                return;
            }
            if (an().n().e() == 1 && an().n().m() != null) {
                if (((apv) an().n().u()).a(aoz.b(aof.a().f()), an().n().m())) {
                    an().n().b(true);
                    an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, (Bundle) null);
                    return;
                }
                return;
            }
            if (an().n().u().b(aoz.a(aof.a().f()))) {
                if (an().n().e() == 2) {
                    if (listI.size() != 0) {
                        aD();
                    } else {
                        return;
                    }
                } else if (an().n().e() == 4) {
                    if (listA.size() != 0) {
                        aC();
                    } else {
                        return;
                    }
                }
                am();
                an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, l());
                return;
            }
            Bundle bundleL = l();
            if (an().n().e() == 1) {
                if (!aoz.d(aoz.b(list))) {
                    an().a(aoi.CHANNEL_SETUP_TUTORIAL, bundleL);
                    return;
                } else {
                    an().a(aoi.ONLINE_PROGRESS, bundleL);
                    return;
                }
            }
            if (an().n().e() == 4) {
                if (listA.size() != 0) {
                    if (an().n().n() != null) {
                        if (an().n().n().I()) {
                            bundleL.putBoolean("AdaptBarFirstTimeSetup", false);
                            if (!aoz.d(aoz.b(list))) {
                                l().putBoolean("setup 51bar+", false);
                                an().a(aoi.CHANNEL_SETUP_TUTORIAL, bundleL);
                                return;
                            } else {
                                an().a(aoi.ONLINE_PROGRESS, bundleL);
                                return;
                            }
                        }
                        bundleL.putBoolean("AdaptBarFirstTimeSetup", true);
                        if (aoz.f(list)) {
                            aC();
                        }
                        an().a(aoi.ONLINE_PROGRESS, bundleL);
                        return;
                    }
                    bundleL.putBoolean("AdaptBarFirstTimeSetup", true);
                    if (aoz.f(list)) {
                        aC();
                    }
                    an().a(aoi.ONLINE_PROGRESS, bundleL);
                    return;
                }
                return;
            }
            if (an().n().e() == 2 && listI.size() != 0) {
                if (an().n().n() != null) {
                    if (an().n().n().H()) {
                        bundleL.putBoolean("AdaptBarFirstTimeSetup", false);
                        if (!aoz.d(aoz.b(list))) {
                            l().putBoolean("setup 51adapt+", false);
                            an().a(aoi.CHANNEL_SETUP_TUTORIAL, bundleL);
                            return;
                        } else {
                            an().a(aoi.ONLINE_PROGRESS, bundleL);
                            return;
                        }
                    }
                    bundleL.putBoolean("AdaptBarFirstTimeSetup", true);
                    if (aoz.e(list)) {
                        aD();
                    }
                    an().a(aoi.ONLINE_PROGRESS, bundleL);
                    return;
                }
                bundleL.putBoolean("AdaptBarFirstTimeSetup", true);
                if (aoz.e(list)) {
                    aD();
                }
                an().a(aoi.ONLINE_PROGRESS, bundleL);
            }
        }
    }

    private void aC() {
        if (an().n().n() == null) {
            for (adx adxVar : this.aE) {
                if (adxVar.I() && (adxVar.s() == 0 || adxVar.s() == 65535)) {
                    an().n().b(new adx(new Device(adxVar.R())));
                }
            }
        }
    }

    private void aD() {
        if (an().n().n() == null) {
            for (adx adxVar : this.aE) {
                if (adxVar.H() && (adxVar.s() == 0 || adxVar.s() == 65535)) {
                    an().n().b(new adx(new Device(adxVar.R())));
                }
            }
        }
    }

    private boolean aE() {
        RoomItem roomItemN = an().n();
        List<adx> listA = aoz.a(aof.a().f());
        if (roomItemN.e() != 0 || listA.size() != 1) {
            return false;
        }
        adx adxVar = listA.get(0);
        roomItemN.a((byte) 0);
        roomItemN.v().clear();
        roomItemN.v().add(adxVar);
        roomItemN.w();
        am();
        mm.a((Object) "setup room 1.0");
        new Handler().postDelayed(new Runnable() { // from class: apz.2
            @Override // java.lang.Runnable
            public void run() {
                mm.a((Object) "setup room 1.0");
                apz.this.g.notifyDataSetChanged();
                apz.this.an().a(aoi.CONNECTING_TO_SPEAKER, (Bundle) null);
            }
        }, 4000L);
        return true;
    }

    private void aF() {
        if (ao()) {
            n(false);
        }
        if (this.as != null && this.au != null) {
            this.au.setVisibility(0);
            this.at.setVisibility(8);
            this.as.setText(String.valueOf(q().getString(R.string.speakerSetup_scanningForSpeakers)));
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        this.aG.a(intentFilter);
        this.ar = false;
        mm.b("Enabling wifi so scan will work", new Object[0]);
        if (!this.f.isWifiEnabled() && !ahh.a()) {
            this.f.setWifiEnabled(true);
        }
        this.f.startScan();
    }

    private SortedSet<String> e(List<ScanResult> list) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        this.aC = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        String strB = an().n().u().b();
        for (ScanResult scanResult : list) {
            if (scanResult.SSID != null && scanResult.SSID.toLowerCase().contains("_setup_") && scanResult.level > -65 && !scanResult.SSID.toLowerCase().contains("jbl_")) {
                this.aC.add(scanResult.SSID);
                if (this.aC != null) {
                    mm.b(this.aC + "-------", new Object[0]);
                }
            }
        }
        List<adx> listF = aof.a().f();
        mm.b("5.1 system test, online device size =" + listF.size(), "device mac=" + d(listF), "is Device setting=" + aK);
        if (aK) {
            return treeSet;
        }
        List<adx> listA = aoz.a(listF);
        if (an().n().e() == 2 || an().n().e() == 5) {
            List<adx> listI = aoz.i(listA);
            if (an().n().n() == null) {
                if (listI.size() == 1) {
                    an().n().b(new adx(new Device(listI.get(0).R())));
                    if (an().n().e() == 2) {
                        if (an().n().n().q() == 7) {
                            Bundle bundleL = l();
                            bundleL.putBoolean("AdaptBarFirstTimeSetup", true);
                            l().putBoolean("isShowingAdaptBarReady", true);
                            an().a(aoi.ONLINE_PROGRESS, bundleL);
                        } else {
                            b(this.aC, strB, treeSet);
                        }
                    } else {
                        mm.b("5.1 system test", "go directly to connecting to speaker as the adapt is =" + d(listF));
                        an().n().w();
                        an().a(aoi.CONNECTING_TO_SPEAKER, (Bundle) null);
                    }
                    if (this.aH != null && !this.aH.isFinishing() && an().n().e() != 2) {
                        this.aG.c();
                    }
                }
                if (listI.size() > 1) {
                    for (adx adxVar : listI) {
                        if (adxVar != null && adxVar.d() != null && adxVar.x() != null && adxVar.d().length() >= 4) {
                            b("HK_" + adxVar.x() + "_Setup_" + adxVar.d().substring(adxVar.d().length() - 4, adxVar.d().length()).replace("-", ""), strB, treeSet);
                        }
                    }
                } else if (listI.size() == 0) {
                    l().putBoolean("isShowingAdaptBarReady", false);
                    b(this.aC, strB, treeSet);
                }
            } else {
                mm.b("getCallback().getRoomItem().getMainDevice()=" + an().n().n().z(), new Object[0]);
                if (an().n().e() == 5) {
                    if (listI.size() == 0) {
                        l().putBoolean("isShowingAdaptBarReady", false);
                        b(this.aC, strB, treeSet);
                    } else {
                        mm.b("5.1 system test", "go directly to connecting to speaker as the adapt is online ");
                        an().n().w();
                        an().a(aoi.CONNECTING_TO_SPEAKER, (Bundle) null);
                    }
                    if (this.aH != null && !this.aH.isFinishing()) {
                        this.aG.c();
                    }
                } else if (!an().n().u().b(aoz.a(aof.a().f())) || l().getBoolean("find the other spekaers")) {
                    a(this.aC, treeSet);
                } else {
                    an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, l());
                    if (this.aH != null && !this.aH.isFinishing()) {
                        this.aG.c();
                    }
                }
            }
        } else if (an().n().e() == 3 || an().n().e() == 4) {
            List<adx> listB = aoz.b(listA, (byte) 8);
            if (an().n().n() == null) {
                if (listB.size() == 1) {
                    an().n().b(new adx(new Device(listB.get(0).R())));
                    if (an().n().e() == 4) {
                        Bundle bundleL2 = l();
                        bundleL2.putBoolean("AdaptBarFirstTimeSetup", true);
                        l().putBoolean("isShowingAdaptBarReady", true);
                        an().a(aoi.ONLINE_PROGRESS, bundleL2);
                    } else {
                        an().n().w();
                        an().a(aoi.CONNECTING_TO_SPEAKER, (Bundle) null);
                    }
                    if (this.aH != null && !this.aH.isFinishing() && an().n().e() != 4) {
                        this.aG.c();
                    }
                }
                if (listB.size() > 1) {
                    for (adx adxVar2 : listB) {
                        if (adxVar2 != null && adxVar2.x() != null && adxVar2.d() != null && adxVar2.d().length() > 4) {
                            a("HK_" + adxVar2.x() + "_Setup_" + adxVar2.d().substring(adxVar2.d().length() - 4, adxVar2.d().length()).replace("-", ""), strB, treeSet);
                        }
                    }
                } else if (listB.size() == 0) {
                    l().putBoolean("isShowingAdaptBarReady", false);
                    a(this.aC, strB, treeSet);
                }
            } else {
                mm.b(aoz.a(aof.a().f()), new Object[0]);
                if (an().n().e() == 3) {
                    if (listB.size() == 0) {
                        l().putBoolean("isShowingAdaptBarReady", false);
                        a(this.aC, strB, treeSet);
                    } else {
                        an().n().w();
                        an().a(aoi.CONNECTING_TO_SPEAKER, (Bundle) null);
                    }
                    if (this.aH != null && !this.aH.isFinishing()) {
                        this.aG.c();
                    }
                } else if (!an().n().u().b(aoz.a(aof.a().f())) || l().getBoolean("find the other spekaers")) {
                    a(this.aC, treeSet);
                } else {
                    an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, l());
                    if (this.aH != null && !this.aH.isFinishing()) {
                        this.aG.c();
                    }
                }
            }
        } else {
            a(this.aC, treeSet);
        }
        return treeSet;
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void E() {
        super.E();
        if (this.aH != null && !this.aH.isFinishing()) {
            try {
                this.aG.c();
            } catch (Exception e2) {
                mm.b("test", "already unregistered,catch IllegalArgumentException");
            }
        }
    }

    private TreeMap<String, Integer> f(List<ScanResult> list) {
        HashMap map = new HashMap();
        for (ScanResult scanResult : list) {
            if (scanResult.SSID != null && !scanResult.SSID.toLowerCase().contains("_setup_")) {
                map.put(scanResult.SSID, Integer.valueOf(scanResult.level));
            }
        }
        TreeMap<String, Integer> treeMap = new TreeMap<>(new b(map));
        treeMap.putAll(map);
        return treeMap;
    }

    class b implements Comparator<String> {
        private Map<String, Integer> b;

        public b(Map<String, Integer> map) {
            this.b = map;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            if (this.b == null || this.b.get(str2) == null || this.b.get(str) == null) {
                return -1;
            }
            return this.b.get(str2).compareTo(this.b.get(str));
        }
    }

    @Override // defpackage.aoj
    protected void b() {
        super.b();
        aK = false;
        if (an().r()) {
            aH();
            an().h(false);
            aF();
        } else if (!this.ar && this.an != null && !this.an.isEmpty()) {
            ay();
        }
        an().c(a(R.string.kRoomSetupTutorialSetupProducts_Str));
        if (an().o() == 1) {
            an().d(0);
        }
        if (this.d != null) {
            this.d.clear();
        }
        aG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG() {
        if (this.aI != null) {
            for (View view : this.aI) {
                if (view != null) {
                    view.setAlpha(1.0f);
                    view.setClickable(true);
                }
            }
            this.aI.clear();
        }
    }

    private void aH() {
        this.aj = new HashMap();
        this.al = new HashMap();
        this.ak = new HashMap();
        this.an = null;
        this.ao = null;
        this.g.a(Collections.emptyList());
        this.g.notifyDataSetChanged();
    }

    @Override // defpackage.aoj
    public void e() {
        d(1);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ay = layoutInflater.inflate(R.layout.device_source_list, (ViewGroup) null);
        this.h = this.ay.findViewById(R.id.group_list_container);
        this.aB = (ListView) this.ay.findViewById(R.id.group_list);
        this.au = (ProgressBar) this.ay.findViewById(R.id.scanning_progress_bar);
        this.av = (RelativeLayout) this.ay.findViewById(R.id.empty_view_layout);
        this.as = (TextView) this.ay.findViewById(R.id.group_list_empty);
        this.at = (ImageView) this.ay.findViewById(R.id.dont_find_device);
        if (this.an == null) {
            this.au.setVisibility(0);
            this.at.setVisibility(8);
            this.as.setText(R.string.speakerSetup_scanningForSpeakers);
        } else {
            this.au.setVisibility(8);
            this.as.setText(R.string.kFCDeviceManager_DeviceDisconnect_Str);
            this.at.setVisibility(0);
        }
        this.aB.setEmptyView(this.av);
        this.aB.setAdapter((ListAdapter) this.g);
        m(false);
        aI();
        aJ();
        n(false);
        RippleTextView rippleTextView = (RippleTextView) this.ay.findViewById(R.id.setup_wifi);
        if (aL()) {
            rippleTextView.setVisibility(8);
        } else {
            rippleTextView.setVisibility(8);
        }
        rippleTextView.setOnClickListener(new View.OnClickListener() { // from class: apz.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                apz.this.d(1);
            }
        });
        return this.ay;
    }

    private void aI() {
        this.i = (ImageView) this.ay.findViewById(R.id.slash_link_icon_glow);
        this.ae = (ImageView) this.ay.findViewById(R.id.slash_link_icon_no_glow);
        this.ae.setVisibility(0);
        this.ae.setAlpha(0.3f);
        this.af = (ImageView) this.ay.findViewById(R.id.sample_icon);
        ((AnimationDrawable) this.af.getDrawable()).start();
        this.ag = (TextView) this.ay.findViewById(R.id.speakerSetup_speakerDescription);
        this.ai = this.ay.findViewById(R.id.speaker_connecting_layout);
    }

    private void aJ() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1200L);
        alphaAnimation.setRepeatCount(-1);
        alphaAnimation.setRepeatMode(2);
        this.i.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z) {
        this.ai.setVisibility(z ? 0 : 8);
        this.h.setVisibility(z ? 8 : 0);
    }

    @Override // aih.a
    public void a(int i, int i2) {
    }

    @Override // aih.a
    public View a(final int i, View view, final ViewGroup viewGroup, final String str) {
        this.c = (a) view.getTag();
        if (this.c == null) {
            this.c = new a();
            this.c.g = (RadioButton) view.findViewById(R.id.radio_button);
            this.c.a = (ImageView) view.findViewById(R.id.mIcon);
            this.c.b = (ProgressBar) view.findViewById(R.id.speakerSetup_waiting);
            this.c.d = (ImageView) view.findViewById(R.id.speakerSetup_successStatus);
            this.c.c = (TextView) view.findViewById(R.id.speakerSetup_textStatus);
            this.c.e = (TextView) view.findViewById(R.id.name);
            this.c.f = (CheckBox) view.findViewById(R.id.select_id);
            view.setTag(this.c);
        }
        if (aL() || l().getBoolean("selectMultipleBarOrAdapt")) {
            this.c.f.setVisibility(8);
        } else {
            this.c.f.setVisibility(0);
        }
        boolean z = l().getBoolean("selectMultipleBarOrAdapt", false);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: apz.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                apz.this.a(true);
                apz.this.an().c(true);
                List<adx> listA = aoz.a(aof.a().f());
                HashMap map = new HashMap();
                for (adx adxVar : listA) {
                    String strReplace = adxVar.d().toLowerCase().replace("-", "");
                    String strSubstring = strReplace.substring(strReplace.length() - 3, strReplace.length());
                    mm.b("deviceFcNameList = " + adxVar.x() + "_setup_" + strSubstring, adxVar + "------");
                    map.put("HK_" + adxVar.x() + "_Setup_" + strSubstring, adxVar);
                }
                mm.b("5.1 system test", "value = " + str);
                ba baVarP = apz.this.p();
                if (map.get(str) == null) {
                    apz.this.d(1);
                } else {
                    if (((adx) map.get(str)).R().getMkType() == 7 || ((adx) map.get(str)).R().getMkType() == 12 || ((adx) map.get(str)).R().getMkType() == 8 || ((adx) map.get(str)).R().getMkType() == 3) {
                        apz.this.an().n().b(new adx(new Device(((adx) map.get(str)).R())));
                    }
                    apz.this.an().n().b(true);
                    if (apz.this.an().n().e() != 5 && apz.this.an().n().e() != 3) {
                        if (!apz.this.an().n().u().b(aoz.a(aof.a().c().d()))) {
                            if (apz.this.an().n().e() == 2 || apz.this.an().n().e() == 4) {
                                Bundle bundleL = apz.this.l();
                                bundleL.putBoolean("AdaptBarFirstTimeSetup", true);
                                apz.this.an().a(aoi.ONLINE_PROGRESS, bundleL);
                                if (baVarP != null && !baVarP.isFinishing()) {
                                    apz.this.aG.c();
                                }
                            }
                        } else {
                            Bundle bundleL2 = apz.this.l();
                            bundleL2.putBoolean("AdaptBarFirstTimeSetup", true);
                            apz.this.an().a(aoi.DRAG_SPEAKERS_FOR_CHANNEL, bundleL2);
                            if (baVarP != null && !baVarP.isFinishing()) {
                                apz.this.aG.c();
                            }
                        }
                    } else {
                        mm.b("5.1 system test", "go directly to connecting to speaker as the adapt is online");
                        apz.this.an().n().w();
                        apz.this.an().a(aoi.CONNECTING_TO_SPEAKER, (Bundle) null);
                        if (baVarP != null && !baVarP.isFinishing()) {
                            apz.this.aG.c();
                        }
                    }
                }
                for (int i2 = 0; i2 < apz.this.g.getCount(); i2++) {
                    if (i2 == i) {
                        apz.this.d.add(str);
                    } else {
                        viewGroup.getChildAt(i2).setAlpha(0.3f);
                        viewGroup.getChildAt(i2).setClickable(false);
                        if (apz.this.aI != null) {
                            apz.this.aI.add(viewGroup.getChildAt(i2));
                        }
                    }
                }
            }
        };
        if (z) {
            view.setOnClickListener(onClickListener);
        } else {
            view.setOnClickListener(null);
        }
        this.c.f.setOnClickListener(new View.OnClickListener() { // from class: apz.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 instanceof CheckBox) {
                    CheckBox checkBox = (CheckBox) view2;
                    System.out.println("******1  select_id = " + checkBox + " ,selectIds = " + apz.this.d + " ,select_id.isChecked() = " + checkBox.isChecked());
                    if (checkBox.isChecked()) {
                        apz.this.d.add(str);
                    } else {
                        apz.this.d.remove(str);
                    }
                    if (apz.this.d == null || apz.this.d.isEmpty()) {
                        apz.this.a(false);
                        apz.this.an().c(false);
                    } else {
                        apz.this.a(true);
                        apz.this.an().c(true);
                    }
                    System.out.println("******2  select_id = " + checkBox + " ,selectIds = " + apz.this.d + " ,select_id.isChecked() = " + checkBox.isChecked());
                }
            }
        });
        this.c.f.setChecked(this.d.contains(str));
        this.c.b.setVisibility(8);
        this.c.d.setVisibility(8);
        this.c.c.setVisibility(8);
        List<adx> listD = aof.a().c().d();
        if (this.ak.containsKey(str) && listD.contains(this.ak.get(str))) {
            this.c.d.setVisibility(0);
        } else if (this.al.containsKey(str)) {
            this.c.c.setVisibility(0);
            this.c.c.setText(R.string.speakerSetup_failed);
            final ErrorInfo errorInfo = this.al.get(str);
            view.setOnClickListener(new View.OnClickListener() { // from class: apz.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    new ahy.a(apz.this.p()).a().a(errorInfo);
                }
            });
        } else if (this.aw == null) {
            if (str.equals(this.ah)) {
                this.c.b.setVisibility(0);
                if (l().getBoolean("selectMultipleBarOrAdapt") && !this.d.contains(str)) {
                    this.c.b.setVisibility(8);
                }
                if (!aL() && !this.d.contains(str)) {
                    this.c.b.setVisibility(8);
                }
            } else if (this.aj.containsKey(str)) {
                this.c.b.setVisibility(0);
            }
        } else {
            this.c.b.setVisibility(0);
            if (l().getBoolean("selectMultipleBarOrAdapt") && !this.d.contains(str)) {
                this.c.b.setVisibility(8);
            }
            if (!aL() && !this.d.contains(str)) {
                this.c.b.setVisibility(8);
            }
        }
        this.c.e.setTypeface(ahu.a(p()));
        this.c.e.setText(str);
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("omni10")) {
            this.c.a.setImageResource(R.drawable.speaker_fc1);
        } else if (lowerCase.contains("omni20")) {
            this.c.a.setImageResource(R.drawable.speaker_fc2);
        } else if (lowerCase.contains("omni_10+")) {
            this.c.a.setImageResource(R.drawable.onmi_10_illustration);
        } else if (lowerCase.contains("omni_20+")) {
            this.c.a.setImageResource(R.drawable.omni_20_illustration);
        } else if (lowerCase.contains("omni_50+")) {
            this.c.a.setImageResource(R.drawable.omni_50_illustration);
        } else if (lowerCase.contains("omni_adapt+amp")) {
            this.c.a.setImageResource(R.drawable.ic_adapt_amp);
        } else if (lowerCase.contains("omni_adapt+")) {
            this.c.a.setImageResource(R.drawable.adapt_icon);
        } else if (lowerCase.contains("adapt")) {
            this.c.a.setImageResource(R.drawable.speaker_fca10);
        } else if (lowerCase.contains("omni_bar+")) {
            this.c.a.setImageResource(R.drawable.soundbar_51);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK() {
        this.aD.clear();
        Iterator<adx> it = aof.a().c().d().iterator();
        while (it.hasNext()) {
            this.aD.add(Long.valueOf(it.next().P()));
        }
    }

    private boolean g(List<adx> list) {
        for (Long l : this.aD) {
            Device device = new Device();
            device.uniqueID = l.longValue();
            adx adxVar = new adx(device);
            if (!list.contains(adxVar)) {
                mm.b("wait previous device is disconnected, device id is =%s ", Long.valueOf(adxVar.P()));
                return false;
            }
        }
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i, int i2, final Intent intent) {
        mm.b("Dialog result", Integer.valueOf(i), Integer.valueOf(i2), intent);
        switch (i) {
            case 1:
                ba baVarP = p();
                if (baVarP != null && !baVarP.isFinishing()) {
                    if (i2 == -1) {
                        if (!aL()) {
                            a(false);
                            an().c(false);
                        }
                        if (l().getBoolean("selectMultipleBarOrAdapt", false)) {
                            a(false);
                            an().c(false);
                        }
                        mq.b().execute(new Runnable() { // from class: apz.7
                            @Override // java.lang.Runnable
                            public void run() {
                                String stringExtra = intent.getStringExtra(aub.b.SSID.name());
                                String stringExtra2 = intent.getStringExtra(aub.b.PASSWORD.name());
                                apz.this.aK();
                                apz.this.a(stringExtra, stringExtra2);
                            }
                        });
                    } else if (i2 == 0) {
                        aG();
                        baVarP.onBackPressed();
                    }
                    try {
                        this.aG.c();
                    } catch (Exception e2) {
                        return;
                    }
                    break;
                }
                break;
            case 2019:
                if (i2 == 0 && ax()) {
                    if (this.b != null) {
                        this.b.dismiss();
                    }
                    aM();
                    break;
                }
                break;
        }
    }

    static class a {
        public ImageView a;
        public ProgressBar b;
        public TextView c;
        public ImageView d;
        public TextView e;
        public CheckBox f;
        public RadioButton g;

        private a() {
        }
    }

    private boolean aL() {
        return aho.b("KEY_SETUP_ALL_SPEAKERS", true);
    }

    private void aM() {
        if (Build.VERSION.SDK_INT >= 23 && (ci.a(p(), "android.permission.ACCESS_COARSE_LOCATION") != 0 || ci.a(p(), "android.permission.ACCESS_FINE_LOCATION") != 0)) {
            if (at.a((Activity) p(), "android.permission.ACCESS_FINE_LOCATION")) {
                mm.b((Object) "shouldShowRequestPermissionRationale true");
            } else {
                mm.b((Object) "shouldShowRequestPermissionRationale false");
            }
            at.a(p(), new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 101);
            return;
        }
        aF();
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i, String[] strArr, int[] iArr) {
        super.a(i, strArr, iArr);
        switch (i) {
            case 101:
                if (iArr.length > 0 && iArr[0] == 0) {
                    aF();
                } else {
                    b(new ArrayList());
                }
                break;
        }
    }
}
