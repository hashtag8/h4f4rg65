package defpackage;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import defpackage.lf;
import defpackage.ls;
import defpackage.ly;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public abstract class lq<T> implements Comparable<lq<T>> {
    private static long o;
    private final ly.a a;
    private final int b;
    private final String c;
    private String d;
    private String e;
    private final int f;
    private ls.a g;
    private Integer h;
    private lr i;
    private boolean j;
    private boolean k;
    private boolean l;
    private lu m;
    private lf.a n;

    public enum a {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    protected abstract ls<T> a(ln lnVar);

    protected abstract void a(T t);

    public lq(int i, String str, ls.a aVar) {
        this.a = ly.a.a ? new ly.a() : null;
        this.j = true;
        this.k = false;
        this.l = false;
        this.n = null;
        this.b = i;
        this.c = str;
        this.e = a(i, str);
        this.g = aVar;
        a((lu) new lh());
        this.f = d(str);
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.f;
    }

    private static int d(String str) {
        Uri uri;
        String host;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null || (host = uri.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public lq<?> a(lu luVar) {
        this.m = luVar;
        return this;
    }

    public void a(String str) {
        if (ly.a.a) {
            this.a.a(str, Thread.currentThread().getId());
        }
    }

    void b(final String str) {
        if (this.i != null) {
            this.i.b(this);
            c();
        }
        if (ly.a.a) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: lq.1
                    @Override // java.lang.Runnable
                    public void run() {
                        lq.this.a.a(str, id);
                        lq.this.a.a(toString());
                    }
                });
            } else {
                this.a.a(str, id);
                this.a.a(toString());
            }
        }
    }

    protected void c() {
        this.g = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public lq<?> a(lr lrVar) {
        this.i = lrVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final lq<?> a(int i) {
        this.h = Integer.valueOf(i);
        return this;
    }

    public String d() {
        return this.d != null ? this.d : this.c;
    }

    public String e() {
        return this.c;
    }

    public void c(String str) {
        this.d = str;
    }

    public String f() {
        return this.b + ":" + this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public lq<?> a(lf.a aVar) {
        this.n = aVar;
        return this;
    }

    public lf.a g() {
        return this.n;
    }

    public boolean h() {
        return this.k;
    }

    public Map<String, String> i() {
        return Collections.emptyMap();
    }

    @Deprecated
    protected Map<String, String> j() {
        return n();
    }

    @Deprecated
    protected String k() {
        return o();
    }

    @Deprecated
    public String l() {
        return p();
    }

    @Deprecated
    public byte[] m() {
        Map<String, String> mapJ = j();
        if (mapJ == null || mapJ.size() <= 0) {
            return null;
        }
        return a(mapJ, k());
    }

    protected Map<String, String> n() {
        return null;
    }

    protected String o() {
        return HTTP.UTF_8;
    }

    public String p() {
        return "application/x-www-form-urlencoded; charset=" + o();
    }

    public byte[] q() {
        Map<String, String> mapN = n();
        if (mapN == null || mapN.size() <= 0) {
            return null;
        }
        return a(mapN, o());
    }

    private byte[] a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(URLEncoder.encode(entry.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final lq<?> a(boolean z) {
        this.j = z;
        return this;
    }

    public final boolean r() {
        return this.j;
    }

    public a s() {
        return a.NORMAL;
    }

    public final int t() {
        return this.m.a();
    }

    public lu u() {
        return this.m;
    }

    public void v() {
        this.l = true;
    }

    public boolean w() {
        return this.l;
    }

    protected lx a(lx lxVar) {
        return lxVar;
    }

    public void b(lx lxVar) {
        if (this.g != null) {
            this.g.a(lxVar);
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(lq<T> lqVar) {
        a aVarS = s();
        a aVarS2 = lqVar.s();
        return aVarS == aVarS2 ? this.h.intValue() - lqVar.h.intValue() : aVarS2.ordinal() - aVarS.ordinal();
    }

    public String toString() {
        return (this.k ? "[X] " : "[ ] ") + d() + " " + ("0x" + Integer.toHexString(b())) + " " + s() + " " + this.h;
    }

    private static String a(int i, String str) {
        StringBuilder sbAppend = new StringBuilder().append("Request:").append(i).append(":").append(str).append(":").append(System.currentTimeMillis()).append(":");
        long j = o;
        o = 1 + j;
        return lj.a(sbAppend.append(j).toString());
    }
}
