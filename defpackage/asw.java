package defpackage;

import com.harman.hkconnect.ui.HarmanApplication;

/* JADX INFO: loaded from: classes.dex */
public class asw {
    private static asw c;
    private String a = "";
    private int b = 0;

    public static asw a() {
        if (c == null) {
            c = new asw();
        }
        return c;
    }

    public String b() {
        try {
            return HarmanApplication.a().getPackageManager().getPackageInfo(HarmanApplication.a().getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String c() {
        int iB = aho.b("ConfigType", this.b);
        String str = "http://storage.harman.com/FC/40/config.data";
        switch (iB) {
            case 0:
                str = "http://storage.harman.com/FC/40/config.data";
                break;
            case 1:
                str = "http://storage.harman.com/Testing/FC/40/config_beta.data";
                break;
            case 2:
                str = "http://storage.harman.com/Testing/FCSQA/40/config_test.data";
                break;
        }
        mm.b("configUrl=" + str + ", configType=" + iB, new Object[0]);
        return str;
    }

    public String d() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }
}
