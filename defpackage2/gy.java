package defpackage;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
class gy {
    private static gy a;
    private final Context b;
    private final LocationManager c;
    private final a d = new a();

    static gy a(Context context) {
        if (a == null) {
            Context applicationContext = context.getApplicationContext();
            a = new gy(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return a;
    }

    gy(Context context, LocationManager locationManager) {
        this.b = context;
        this.c = locationManager;
    }

    boolean a() {
        a aVar = this.d;
        if (c()) {
            return aVar.a;
        }
        Location locationB = b();
        if (locationB != null) {
            a(locationB);
            return aVar.a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    private Location b() {
        Location locationA = ck.a(this.b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a("network") : null;
        Location locationA2 = ck.a(this.b, "android.permission.ACCESS_FINE_LOCATION") == 0 ? a("gps") : null;
        if (locationA2 != null && locationA != null) {
            return locationA2.getTime() > locationA.getTime() ? locationA2 : locationA;
        }
        if (locationA2 == null) {
            locationA2 = locationA;
        }
        return locationA2;
    }

    private Location a(String str) {
        if (this.c != null) {
            try {
                if (this.c.isProviderEnabled(str)) {
                    return this.c.getLastKnownLocation(str);
                }
            } catch (Exception e) {
                Log.d("TwilightManager", "Failed to get last known location", e);
            }
        }
        return null;
    }

    private boolean c() {
        return this.d != null && this.d.f > System.currentTimeMillis();
    }

    private void a(Location location) {
        long j;
        long j2;
        a aVar = this.d;
        long jCurrentTimeMillis = System.currentTimeMillis();
        gx gxVarA = gx.a();
        gxVarA.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j3 = gxVarA.a;
        gxVarA.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = gxVarA.c == 1;
        long j4 = gxVarA.b;
        long j5 = gxVarA.a;
        gxVarA.a(86400000 + jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        long j6 = gxVarA.b;
        if (j4 == -1 || j5 == -1) {
            j = 43200000 + jCurrentTimeMillis;
        } else {
            if (jCurrentTimeMillis > j5) {
                j2 = 0 + j6;
            } else if (jCurrentTimeMillis > j4) {
                j2 = 0 + j5;
            } else {
                j2 = 0 + j4;
            }
            j = j2 + 60000;
        }
        aVar.a = z;
        aVar.b = j3;
        aVar.c = j4;
        aVar.d = j5;
        aVar.e = j6;
        aVar.f = j;
    }

    static class a {
        boolean a;
        long b;
        long c;
        long d;
        long e;
        long f;

        a() {
        }
    }
}
