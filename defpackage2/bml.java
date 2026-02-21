package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class bml {
    private static final Pattern e = Pattern.compile("[^\\p{Alnum}]");
    private static final String f = Pattern.quote("/");
    bly a;
    blx b;
    boolean c;
    bmk d;
    private final ReentrantLock g = new ReentrantLock();
    private final bmm h;
    private final boolean i;
    private final boolean j;
    private final Context k;
    private final String l;
    private final String m;
    private final Collection<bln> n;

    public enum a {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(101),
        ANDROID_SERIAL(102),
        ANDROID_ADVERTISING_ID(103);

        public final int h;

        a(int i2) {
            this.h = i2;
        }
    }

    public bml(Context context, String str, String str2, Collection<bln> collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        if (collection == null) {
            throw new IllegalArgumentException("kits must not be null");
        }
        this.k = context;
        this.l = str;
        this.m = str2;
        this.n = collection;
        this.h = new bmm();
        this.a = new bly(context);
        this.d = new bmk();
        this.i = bme.a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
        if (!this.i) {
            blh.h().a("Fabric", "Device ID collection disabled for " + context.getPackageName());
        }
        this.j = bme.a(context, "com.crashlytics.CollectUserIdentifiers", true);
        if (!this.j) {
            blh.h().a("Fabric", "User information collection disabled for " + context.getPackageName());
        }
    }

    public boolean a() {
        return this.j;
    }

    private String a(String str) {
        if (str == null) {
            return null;
        }
        return e.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public String b() {
        String str = this.m;
        if (str == null) {
            SharedPreferences sharedPreferencesA = bme.a(this.k);
            b(sharedPreferencesA);
            String string = sharedPreferencesA.getString("crashlytics.installation.id", null);
            if (string == null) {
                return a(sharedPreferencesA);
            }
            return string;
        }
        return str;
    }

    public String c() {
        return this.l;
    }

    public String d() {
        return e() + "/" + f();
    }

    public String e() {
        return b(Build.VERSION.RELEASE);
    }

    public String f() {
        return b(Build.VERSION.INCREMENTAL);
    }

    public String g() {
        return String.format(Locale.US, "%s/%s", b(Build.MANUFACTURER), b(Build.MODEL));
    }

    private String b(String str) {
        return str.replaceAll(f, "");
    }

    @SuppressLint({"CommitPrefEdits"})
    private String a(SharedPreferences sharedPreferences) {
        this.g.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string == null) {
                string = a(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            return string;
        } finally {
            this.g.unlock();
        }
    }

    private void b(SharedPreferences sharedPreferences) {
        blx blxVarN = n();
        if (blxVarN != null) {
            a(sharedPreferences, blxVarN.a);
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    private void a(SharedPreferences sharedPreferences, String str) {
        this.g.lock();
        try {
            if (!TextUtils.isEmpty(str)) {
                String string = sharedPreferences.getString("crashlytics.advertising.id", null);
                if (TextUtils.isEmpty(string)) {
                    sharedPreferences.edit().putString("crashlytics.advertising.id", str).commit();
                } else if (!string.equals(str)) {
                    sharedPreferences.edit().remove("crashlytics.installation.id").putString("crashlytics.advertising.id", str).commit();
                }
            }
        } finally {
            this.g.unlock();
        }
    }

    public Map<a, String> h() {
        HashMap map = new HashMap();
        for (Object obj : this.n) {
            if (obj instanceof bmi) {
                for (Map.Entry<a, String> entry : ((bmi) obj).e().entrySet()) {
                    a(map, entry.getKey(), entry.getValue());
                }
            }
        }
        String strK = k();
        if (TextUtils.isEmpty(strK)) {
            a(map, a.ANDROID_ID, l());
        } else {
            a(map, a.ANDROID_ADVERTISING_ID, strK);
        }
        return Collections.unmodifiableMap(map);
    }

    public String i() {
        return this.h.a(this.k);
    }

    public Boolean j() {
        if (!m()) {
            return null;
        }
        return o();
    }

    public String k() {
        blx blxVarN;
        if (!m() || (blxVarN = n()) == null || blxVarN.b) {
            return null;
        }
        return blxVarN.a;
    }

    private void a(Map<a, String> map, a aVar, String str) {
        if (str != null) {
            map.put(aVar, str);
        }
    }

    public String l() {
        boolean zEquals = Boolean.TRUE.equals(o());
        if (!m() || zEquals) {
            return null;
        }
        String string = Settings.Secure.getString(this.k.getContentResolver(), "android_id");
        if ("9774d56d682e549c".equals(string)) {
            return null;
        }
        return a(string);
    }

    protected boolean m() {
        return this.i && !this.d.b(this.k);
    }

    synchronized blx n() {
        if (!this.c) {
            this.b = this.a.a();
            this.c = true;
        }
        return this.b;
    }

    private Boolean o() {
        blx blxVarN = n();
        if (blxVarN != null) {
            return Boolean.valueOf(blxVarN.b);
        }
        return null;
    }
}
