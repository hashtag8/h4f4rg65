package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.support.v8.renderscript.Allocation;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.stats.ConnectionEvent;
import defpackage.vt;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class vs {
    private static vs b;
    private final List<String> c;
    private final List<String> d;
    private final List<String> e;
    private final List<String> f;
    private vv h;
    private static final Object a = new Object();
    private static final ComponentName g = new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.common.stats.GmsCoreStatsService");

    private vs() {
        if (b() == vu.a) {
            this.c = Collections.EMPTY_LIST;
            this.d = Collections.EMPTY_LIST;
            this.e = Collections.EMPTY_LIST;
            this.f = Collections.EMPTY_LIST;
            return;
        }
        String strC = vt.a.b.c();
        this.c = strC == null ? Collections.EMPTY_LIST : Arrays.asList(strC.split(","));
        String strC2 = vt.a.c.c();
        this.d = strC2 == null ? Collections.EMPTY_LIST : Arrays.asList(strC2.split(","));
        String strC3 = vt.a.d.c();
        this.e = strC3 == null ? Collections.EMPTY_LIST : Arrays.asList(strC3.split(","));
        String strC4 = vt.a.e.c();
        this.f = strC4 == null ? Collections.EMPTY_LIST : Arrays.asList(strC4.split(","));
        this.h = new vv(1024, vt.a.f.c().longValue());
    }

    private String a(ServiceConnection serviceConnection) {
        return String.valueOf((Process.myPid() << 32) | System.identityHashCode(serviceConnection));
    }

    public static vs a() {
        synchronized (a) {
            if (b == null) {
                b = new vs();
            }
        }
        return b;
    }

    private void a(Context context, ServiceConnection serviceConnection, String str, Intent intent, int i) {
        ConnectionEvent connectionEvent;
        if (vl.a) {
            String strA = a(serviceConnection);
            if (a(context, str, intent, strA, i)) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strA2 = (b() & vu.e) != 0 ? aam.a(3, 5) : null;
                long nativeHeapAllocatedSize = (b() & vu.g) != 0 ? Debug.getNativeHeapAllocatedSize() : 0L;
                if (i == 1 || i == 4) {
                    connectionEvent = new ConnectionEvent(jCurrentTimeMillis, i, null, null, null, null, strA2, strA, SystemClock.elapsedRealtime(), nativeHeapAllocatedSize);
                } else {
                    ServiceInfo serviceInfoB = b(context, intent);
                    connectionEvent = new ConnectionEvent(jCurrentTimeMillis, i, aam.a(context), str, serviceInfoB.processName, serviceInfoB.name, strA2, strA, SystemClock.elapsedRealtime(), nativeHeapAllocatedSize);
                }
                context.startService(new Intent().setComponent(g).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
            }
        }
    }

    private boolean a(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null || (vl.a && GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE.equals(component.getPackageName()))) {
            return false;
        }
        return aag.a(context, component.getPackageName());
    }

    private boolean a(Context context, String str, Intent intent, String str2, int i) {
        int iB = b();
        if (iB == vu.a || this.h == null) {
            return false;
        }
        if (i == 4 || i == 1) {
            return this.h.b(str2);
        }
        ServiceInfo serviceInfoB = b(context, intent);
        if (serviceInfoB == null) {
            Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", str, intent.toUri(0)));
            return false;
        }
        String strA = aam.a(context);
        String str3 = serviceInfoB.processName;
        String str4 = serviceInfoB.name;
        if (this.c.contains(strA) || this.d.contains(str) || this.e.contains(str3) || this.f.contains(str4)) {
            return false;
        }
        if (str3.equals(strA) && (iB & vu.f) != 0) {
            return false;
        }
        this.h.a(str2);
        return true;
    }

    private int b() {
        try {
            return aag.a() ? vt.a.a.c().intValue() : vu.a;
        } catch (SecurityException e) {
            return vu.a;
        }
    }

    private static ServiceInfo b(Context context, Intent intent) {
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, Allocation.USAGE_SHARED);
        if (listQueryIntentServices == null || listQueryIntentServices.size() == 0) {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", intent.toUri(0), aam.a(3, 20)));
            return null;
        }
        if (listQueryIntentServices.size() > 1) {
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", intent.toUri(0), aam.a(3, 20)));
            Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
            if (it.hasNext()) {
                Log.w("ConnectionTracker", it.next().serviceInfo.name);
                return null;
            }
        }
        return listQueryIntentServices.get(0).serviceInfo;
    }

    public void a(Context context, ServiceConnection serviceConnection) {
        a(context, serviceConnection, (String) null, (Intent) null, 1);
        context.unbindService(serviceConnection);
    }

    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    public boolean a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (a(context, intent)) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        a(context, serviceConnection, str, intent, 2);
        return context.bindService(intent, serviceConnection, i);
    }
}
