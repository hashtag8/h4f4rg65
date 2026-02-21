package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.support.v8.renderscript.Allocation;

/* JADX INFO: loaded from: classes.dex */
public class mj extends ap {
    private static mj a;

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        a = this;
    }

    @Override // defpackage.ap, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        try {
            super.attachBaseContext(context);
        } catch (RuntimeException e) {
        }
    }

    public static mj a() {
        return a;
    }

    public static boolean b() {
        ApplicationInfo applicationInfo;
        String string;
        int iMyPid = Process.myPid();
        String str = "";
        ActivityManager activityManager = (ActivityManager) a().getSystemService("activity");
        PackageManager packageManager = a().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(a.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        String str2 = (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "(unknown)");
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            try {
                string = runningAppProcessInfo.pid == iMyPid ? packageManager.getApplicationLabel(packageManager.getApplicationInfo(runningAppProcessInfo.processName, Allocation.USAGE_SHARED)).toString() : str;
            } catch (Exception e2) {
                string = str;
            }
            str = string;
        }
        return bru.a(str, str2);
    }
}
