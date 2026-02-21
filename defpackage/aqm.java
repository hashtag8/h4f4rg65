package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.harman.hkconnect.ui.HarmanApplication;

/* JADX INFO: loaded from: classes.dex */
public class aqm {
    private int a;
    private String b;
    private String c;
    private String d;
    private boolean e = true;

    public void a(int i) {
        this.a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(String str) {
        this.c = str;
        this.e = a(HarmanApplication.a(), str);
        this.d = "https://play.google.com/store/apps/details?id=" + str;
    }

    public int a() {
        return this.a;
    }

    public boolean b() {
        return this.e;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.b;
    }

    private boolean a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        return packageInfo != null;
    }
}
