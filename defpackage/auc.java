package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.Log;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class auc {
    private static final TimeUnit a = TimeUnit.SECONDS;
    private final String d;
    private final String f;
    private int g;
    private agh<Integer> h;
    private final Context c = HarmanApplication.a();
    private final WifiManager b = (WifiManager) this.c.getSystemService("wifi");
    private asl e = new asl(new ash() { // from class: auc.1
        @Override // defpackage.ash
        public void a(NetworkInfo networkInfo, WifiInfo wifiInfo) {
            mm.b("onNetworkChange %s %s", networkInfo, wifiInfo);
            if (networkInfo != null && wifiInfo != null) {
                if (networkInfo.isConnected() && ahx.a(wifiInfo.getSSID(), auc.this.f)) {
                    auc.this.b();
                }
                if (!networkInfo.isAvailable()) {
                    auc.this.a(new ErrorInfo.a().a("not available").a());
                }
            }
        }
    });

    public auc(String str, String str2, agh<Integer> aghVar) {
        this.h = aghVar;
        this.f = str;
        this.d = str2;
    }

    public void a() {
        mm.b("connectToWifi....", new Object[0]);
        if (!this.b.isWifiEnabled() && !ahh.a()) {
            this.b.setWifiEnabled(true);
        }
        this.c.registerReceiver(this.e, this.e.a());
        if (brs.a((Object) ahx.a().b(), (Object) this.f)) {
            b();
            return;
        }
        this.g = a(this.f);
        mm.b("connectToWifi....ssid=%s, networkId=%d", this.f, Integer.valueOf(this.g));
        if (this.g != -1) {
            mm.b("Enabling network %s %s", this.f, Integer.valueOf(this.g));
            if (a(this.g) == null) {
                Log.i("WifiConnectionManager", "connect wifi by enableNetwork method");
                if (!this.b.enableNetwork(this.g, true)) {
                    a(new ErrorInfo.a().a("Could not enable network " + this.g).a());
                    return;
                }
            }
            mq.c().schedule(new Runnable() { // from class: auc.2
                @Override // java.lang.Runnable
                public void run() {
                    auc.this.a(new ErrorInfo.a().a(R.string.speakerSetup_couldNotConnectToWifi, auc.this.f).a("timeout connecting to Wifi").a());
                }
            }, 45L, a);
            return;
        }
        a(new ErrorInfo.a().a("Could not get networkId for " + this.f).a());
    }

    @TargetApi(21)
    private int a(String str) {
        int iUpdateNetwork;
        if (!str.startsWith("\"")) {
            str = "\"" + str + "\"";
        }
        if (!bru.a((CharSequence) this.d)) {
            mm.b("This is Home WiFi, ssid=%s, we won't update WiFi configuration due to Not authorized", str);
            int iC = c(str);
            if (iC != -1) {
                return iC;
            }
        }
        WifiConfiguration wifiConfigurationB = b(str);
        int iC2 = c(str);
        if (iC2 == -1) {
            iUpdateNetwork = this.b.addNetwork(wifiConfigurationB);
        } else {
            mm.b("ssid exist, ssid=%s, networkid=%s, phone=%s", str, Integer.valueOf(iC2), Build.MODEL);
            wifiConfigurationB.networkId = iC2;
            iUpdateNetwork = this.b.updateNetwork(wifiConfigurationB);
            if (iUpdateNetwork == -1) {
                mm.b("Disabling %s before we try adding again.", Integer.valueOf(wifiConfigurationB.networkId));
                this.b.disableNetwork(iC2);
                this.b.removeNetwork(iC2);
                iUpdateNetwork = this.b.addNetwork(wifiConfigurationB);
            }
        }
        mm.b("Added %s for %s", Integer.valueOf(iUpdateNetwork), wifiConfigurationB);
        if (iUpdateNetwork == -1) {
            return c(str);
        }
        return iUpdateNetwork;
    }

    private WifiConfiguration b(String str) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.SSID = str;
        if (!bru.a((CharSequence) this.d)) {
            wifiConfiguration.preSharedKey = "\"" + this.d + "\"";
            wifiConfiguration.allowedGroupCiphers.set(2);
            wifiConfiguration.allowedGroupCiphers.set(3);
            wifiConfiguration.allowedKeyManagement.set(1);
            wifiConfiguration.allowedPairwiseCiphers.set(1);
            wifiConfiguration.allowedPairwiseCiphers.set(2);
            wifiConfiguration.allowedProtocols.set(1);
        } else {
            wifiConfiguration.allowedKeyManagement.set(0);
        }
        return wifiConfiguration;
    }

    private int c(String str) {
        if (this.b == null) {
            return -1;
        }
        if (this.b.getConfiguredNetworks() != null) {
            for (WifiConfiguration wifiConfiguration : this.b.getConfiguredNetworks()) {
                if (str.equals(wifiConfiguration.SSID)) {
                    return wifiConfiguration.networkId;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        if (this.h == null) {
            mm.b("Already notified error trying to connect to %s", this.f);
        } else {
            try {
                this.h.a(this.f, Integer.valueOf(this.g));
                this.h = null;
                this.c.unregisterReceiver(this.e);
            } catch (Throwable th) {
                a(new ErrorInfo.a().a(R.id.errorCode_onSuccessFailure).a(th).a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(ErrorInfo errorInfo) {
        try {
            if (this.h != null) {
                try {
                    this.h.a(this.f, errorInfo);
                    this.h = null;
                    this.c.unregisterReceiver(this.e);
                } catch (Throwable th) {
                    new ml().a("Error in onError", th);
                    this.h = null;
                    this.c.unregisterReceiver(this.e);
                }
            }
        } finally {
        }
    }

    private Method a(int i) {
        Method method;
        Class<?>[] parameterTypes;
        Class<?>[] parameterTypes2;
        if (Build.VERSION.SDK_INT >= 17) {
            Log.i("WifiConnectionManager", "connectWifiByReflectMethod road 1");
            Method[] declaredMethods = this.b.getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i2 = 0;
            method = null;
            while (i2 < length) {
                Method method2 = declaredMethods[i2];
                if (!"connect".equalsIgnoreCase(method2.getName()) || (parameterTypes2 = method2.getParameterTypes()) == null || parameterTypes2.length <= 0 || !"int".equalsIgnoreCase(parameterTypes2[0].getName())) {
                    method2 = method;
                }
                i2++;
                method = method2;
            }
            if (method != null) {
                try {
                    Log.i("WifiConnectionManager", "connectWifiByReflectMethod road 1,work well");
                    method.invoke(this.b, Integer.valueOf(i), null);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i("WifiConnectionManager", "connectWifiByReflectMethod Android " + Build.VERSION.SDK_INT + " error!");
                    return null;
                }
            } else {
                Log.i("WifiConnectionManager", "connectWifiByReflectMethod road 1,connectMethod == null");
            }
        } else if (Build.VERSION.SDK_INT == 16) {
            Log.i("WifiConnectionManager", "connectWifiByReflectMethod road 2");
            method = null;
        } else if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT < 16) {
            Log.i("WifiConnectionManager", "connectWifiByReflectMethod road 3");
            Method[] declaredMethods2 = this.b.getClass().getDeclaredMethods();
            int length2 = declaredMethods2.length;
            int i3 = 0;
            method = null;
            while (i3 < length2) {
                Method method3 = declaredMethods2[i3];
                if (!"connectNetwork".equalsIgnoreCase(method3.getName()) || (parameterTypes = method3.getParameterTypes()) == null || parameterTypes.length <= 0 || !"int".equalsIgnoreCase(parameterTypes[0].getName())) {
                    method3 = method;
                }
                i3++;
                method = method3;
            }
            if (method != null) {
                try {
                    Log.i("WifiConnectionManager", "connectWifiByReflectMethod road 3 work well");
                    method.invoke(this.b, Integer.valueOf(i));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    Log.i("WifiConnectionManager", "connectWifiByReflectMethod Android " + Build.VERSION.SDK_INT + " error!");
                    return null;
                }
            } else {
                Log.i("WifiConnectionManager", "connectWifiByReflectMethod road 3 connectMethod == null");
            }
        } else {
            Log.i("WifiConnectionManager", "connectWifiByReflectMethod road 4");
            return null;
        }
        return method;
    }
}
