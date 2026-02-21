package defpackage;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class bjn implements Serializable {
    public static String a = "serviceType";
    public static String b = "serviceId";
    public static String c = "SCPDURL";
    public static String d = "controlURL";
    public static String e = "eventSubURL";
    private static long g = 0;
    private static final String h = null;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private bjh v;
    private String i = "";
    private String o = "";
    private ArrayList<bjo> w = new ArrayList<>();
    public ArrayList<bjq> f = new ArrayList<>();

    public void a(String str) {
        this.k = str;
    }

    public void b(String str) {
        this.l = str;
    }

    public void c(String str) {
        this.o = str;
    }

    public void d(String str) {
        this.p = str;
    }

    public void e(String str) {
        this.q = str;
    }

    public void f(String str) {
        this.r = str;
    }

    public void g(String str) {
        this.s = str;
    }

    public void h(String str) {
        this.t = str;
    }

    public void i(String str) {
        this.u = str;
    }

    public void a(ArrayList<bjo> arrayList) {
        this.w = arrayList;
    }

    public void j(String str) {
        this.m = str;
    }

    public void k(String str) {
        this.n = str;
    }

    public void l(String str) {
        this.j = str;
    }

    public bjn() {
    }

    public bjn(bjh bjhVar) {
        this.v = bjhVar;
        n(this.v.b());
    }

    public String a() {
        return this.i;
    }

    public void m(String str) {
        this.i = str;
    }

    public String b() {
        return this.m;
    }

    public String c() {
        return this.n;
    }

    public String d() {
        return this.o;
    }

    public String e() {
        if (this.u == null || this.u.equals("")) {
            try {
                URL url = new URL(this.v.d());
                this.u = "http://" + url.getHost() + ":" + url.getPort();
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
        }
        return this.u;
    }

    public ArrayList<bjq> f() {
        return this.f;
    }

    public bjh g() {
        return this.v;
    }

    public String h() {
        if (this.w == null || this.w.size() <= 0) {
            return null;
        }
        bjo bjoVar = this.w.get(0);
        if (!bky.a(bjoVar.a())) {
            return bjoVar.a();
        }
        if (this.u == null || this.u == "") {
            try {
                URL url = new URL(this.v.d());
                this.u = "http://" + url.getHost() + ":" + url.getPort();
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
        }
        if (this.w == null || this.w.size() <= 0) {
            return null;
        }
        return this.u + bjoVar.a();
    }

    public String i() {
        try {
            URL url = new URL(this.v.d());
            return "http://" + url.getHost() + ":" + url.getPort();
        } catch (MalformedURLException e2) {
            return this.v.d();
        }
    }

    public void n(String str) {
        int i;
        if (str.contains("max-age=")) {
            try {
                i = Integer.parseInt(str.substring(str.indexOf("=") + 1, str.length()));
            } catch (Exception e2) {
                i = 900;
            }
            g = ((long) (i * 1000)) + System.currentTimeMillis();
        }
    }

    public boolean j() {
        return System.currentTimeMillis() > g;
    }
}
