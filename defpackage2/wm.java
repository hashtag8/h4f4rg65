package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
@yx
public class wm {
    private final int a;
    private final int b;
    private final int c;
    private final wr d;
    private int j;
    private final Object e = new Object();
    private ArrayList<String> f = new ArrayList<>();
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private String k = "";

    public wm(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = new wr(i4);
    }

    private String a(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            stringBuffer.append(' ');
            if (stringBuffer.length() > i) {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String string = stringBuffer.toString();
        return string.length() >= i ? string.substring(0, i) : string;
    }

    private void c(String str) {
        if (str == null || str.length() < this.c) {
            return;
        }
        synchronized (this.e) {
            this.f.add(str);
            this.g += str.length();
        }
    }

    int a(int i, int i2) {
        return (this.a * i) + (this.b * i2);
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(String str) {
        c(str);
        synchronized (this.e) {
            if (this.i < 0) {
                su.a("ActivityContent: negative number of WebViews.");
            }
            e();
        }
    }

    public boolean a() {
        boolean z;
        synchronized (this.e) {
            z = this.i == 0;
        }
        return z;
    }

    public String b() {
        return this.k;
    }

    public void b(String str) {
        c(str);
    }

    public void c() {
        synchronized (this.e) {
            this.i--;
        }
    }

    public void d() {
        synchronized (this.e) {
            this.i++;
        }
    }

    public void e() {
        synchronized (this.e) {
            int iA = a(this.g, this.h);
            if (iA > this.j) {
                this.j = iA;
                this.k = this.d.a(this.f);
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof wm)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        wm wmVar = (wm) obj;
        return wmVar.b() != null && wmVar.b().equals(b());
    }

    int f() {
        return this.g;
    }

    public int hashCode() {
        return b().hashCode();
    }

    public String toString() {
        return "ActivityContent fetchId: " + this.h + " score:" + this.j + " total_length:" + this.g + "\n text: " + a(this.f, HttpStatus.SC_OK) + "\n signture: " + this.k;
    }
}
