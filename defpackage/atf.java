package defpackage;

import android.text.TextUtils;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class atf {
    private String a;
    private int[] b;

    public String a(int i, int i2) {
        String str = "";
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, i2);
        if (this.b == null) {
            this.b = new int[2];
        }
        this.b[0] = i;
        this.b[1] = i2;
        d();
        String str2 = i2 < 10 ? "0" + i2 : "" + i2;
        mm.b("TEST_DATE  hour = %s , minute = %s , am_pm = %s ", Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(9)));
        if (calendar.get(9) == 0) {
            str = "AM";
        } else if (calendar.get(9) == 1) {
            str = "PM";
            if (i > 12) {
                i -= 12;
            }
        }
        return i + ":" + str2 + " " + str;
    }

    public void a(String str) {
        this.a = str;
        aho.a("FOTA_UPDATE_TIMEZONE_SETUP", str);
        e();
    }

    public String a() {
        if (TextUtils.isEmpty(this.a)) {
            String strD = aho.d("FOTA_UPDATE_TIMEZONE_SETUP");
            if (TextUtils.isEmpty(strD)) {
                strD = aht.b();
            }
            this.a = strD;
        }
        return this.a;
    }

    public String b() {
        if (this.b == null) {
            this.b = new int[2];
            this.b[0] = aho.b("FOTA_UPDATE_TIME_SETUP_FROM_HOUR", 3);
            this.b[1] = aho.b("FOTA_UPDATE_TIME_SETUP_FROM_MINUTE", 0);
        }
        return a(this.b[0], this.b[1]);
    }

    public int[] c() {
        if (this.b == null) {
            this.b = new int[2];
            this.b[0] = aho.b("FOTA_UPDATE_TIME_SETUP_FROM_HOUR", 3);
            this.b[1] = aho.b("FOTA_UPDATE_TIME_SETUP_FROM_MINUTE", 0);
        }
        return this.b;
    }

    public void d() {
        if (this.b != null) {
            aho.a("FOTA_UPDATE_TIME_SETUP_FROM_HOUR", this.b[0]);
            aho.a("FOTA_UPDATE_TIME_SETUP_FROM_MINUTE", this.b[1]);
        }
    }

    public void e() {
        if (!TextUtils.isEmpty(this.a)) {
            aho.a("FOTA_UPDATE_TIMEZONE_SETUP", this.a);
        }
    }

    public void a(int[] iArr) {
        this.b = iArr;
    }
}
