package defpackage;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class asz {

    @acn(a = "module")
    private String a;

    @acn(a = "version")
    private String b;

    @acn(a = "md5")
    private String c;

    @acn(a = "url")
    private String d;

    public asz() {
    }

    public asz(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public String a() {
        if (!TextUtils.isEmpty(this.d)) {
            return Uri.parse(this.d).getLastPathSegment();
        }
        return "HK_Connectmk2.bin";
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return (ain.l && "omni".equals(this.a)) ? "0.1.6.8" : this.b;
    }

    public String d() {
        return (ain.l && "omni".equals(this.a)) ? "F187FA68FDFEDAB689DEE0B636B6DF01" : this.c;
    }

    public String e() {
        return (ain.l && "omni".equals(this.a)) ? "http://storage.harman.com/FC/HK_Connect.bin" : this.d;
    }

    public String toString() {
        return "DeviceVersion{module='" + this.a + "', version='" + this.b + "', md5='" + this.c + "', url='" + this.d + "'}";
    }
}
