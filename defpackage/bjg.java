package defpackage;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bjg implements bji {
    protected String a;
    protected String b;
    protected String c;
    protected String d;
    protected String e;
    protected List<String> f;

    public bjg() {
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    public bjg(String str, int i, int i2, String str2, List<String> list) {
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.b = str;
        this.c = Integer.toString(i);
        this.e = Integer.toString(i2);
        this.d = str2;
        this.f = list;
    }

    public void a(String str) {
        this.a = str;
    }

    public String a() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.d = str;
    }

    public void d(String str) {
        this.e = str;
    }

    public String b() {
        return this.c;
    }

    public void e(String str) {
        this.c = str;
    }

    public void a(List<String> list) {
        this.f = list;
    }

    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        String strA = a();
        if (b() != null) {
            str = strA + ":" + b();
        } else {
            str = strA + ":1900";
        }
        stringBuffer.append("M-SEARCH * HTTP/1.1").append("\r\n");
        stringBuffer.append("HOST: " + str).append("\r\n");
        stringBuffer.append("MAN: \"ssdp:discover\"").append("\r\n");
        stringBuffer.append("MX: " + this.e).append("\r\n");
        stringBuffer.append("ST: " + this.d).append("\r\n");
        if (this.f != null && this.f.size() > 0) {
            Iterator<String> it = this.f.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next()).append("\r\n");
            }
        }
        stringBuffer.append("\r\n");
        return stringBuffer.toString();
    }
}
