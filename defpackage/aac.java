package defpackage;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import defpackage.aan;
import defpackage.abk;
import defpackage.wl;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public abstract class aac<T> implements Comparable<aac<T>> {
    private final abk.a a;
    private final int b;
    private final String c;
    private final int d;
    private final aan.a e;
    private Integer f;
    private aaf g;
    private boolean h;
    private boolean i;
    private boolean j;
    private long k;
    private aba l;
    private wl.a m;

    public enum a {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public aac(int i, String str, aan.a aVar) {
        this.a = abk.a.a ? new abk.a() : null;
        this.h = true;
        this.i = false;
        this.j = false;
        this.k = 0L;
        this.m = null;
        this.b = i;
        this.c = str;
        this.e = aVar;
        a((aba) new xh());
        this.d = a(str);
    }

    private static int a(String str) {
        Uri uri;
        String host;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null || (host = uri.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
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

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(aac<T> aacVar) {
        a aVarQ = q();
        a aVarQ2 = aacVar.q();
        return aVarQ == aVarQ2 ? this.f.intValue() - aacVar.f.intValue() : aVarQ2.ordinal() - aVarQ.ordinal();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final aac<?> a(int i) {
        this.f = Integer.valueOf(i);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public aac<?> a(aaf aafVar) {
        this.g = aafVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public aac<?> a(aba abaVar) {
        this.l = abaVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public aac<?> a(wl.a aVar) {
        this.m = aVar;
        return this;
    }

    protected abstract aan<T> a(zo zoVar);

    protected abj a(abj abjVar) {
        return abjVar;
    }

    public Map<String, String> a() {
        return Collections.emptyMap();
    }

    protected abstract void a(T t);

    public int b() {
        return this.b;
    }

    public void b(abj abjVar) {
        if (this.e != null) {
            this.e.a(abjVar);
        }
    }

    public void b(String str) {
        if (abk.a.a) {
            this.a.a(str, Thread.currentThread().getId());
        } else if (this.k == 0) {
            this.k = SystemClock.elapsedRealtime();
        }
    }

    public int c() {
        return this.d;
    }

    void c(final String str) {
        if (this.g != null) {
            this.g.b(this);
        }
        if (!abk.a.a) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.k;
            if (jElapsedRealtime >= 3000) {
                abk.b("%d ms: %s", Long.valueOf(jElapsedRealtime), toString());
                return;
            }
            return;
        }
        final long id = Thread.currentThread().getId();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: aac.1
                @Override // java.lang.Runnable
                public void run() {
                    aac.this.a.a(str, id);
                    aac.this.a.a(toString());
                }
            });
        } else {
            this.a.a(str, id);
            this.a.a(toString());
        }
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return d();
    }

    public wl.a f() {
        return this.m;
    }

    public boolean g() {
        return this.i;
    }

    @Deprecated
    protected Map<String, String> h() {
        return l();
    }

    @Deprecated
    protected String i() {
        return m();
    }

    @Deprecated
    public String j() {
        return n();
    }

    @Deprecated
    public byte[] k() {
        Map<String, String> mapH = h();
        if (mapH == null || mapH.size() <= 0) {
            return null;
        }
        return a(mapH, i());
    }

    protected Map<String, String> l() {
        return null;
    }

    protected String m() {
        return HTTP.UTF_8;
    }

    public String n() {
        return "application/x-www-form-urlencoded; charset=" + m();
    }

    public byte[] o() {
        Map<String, String> mapL = l();
        if (mapL == null || mapL.size() <= 0) {
            return null;
        }
        return a(mapL, m());
    }

    public final boolean p() {
        return this.h;
    }

    public a q() {
        return a.NORMAL;
    }

    public final int r() {
        return this.l.a();
    }

    public aba s() {
        return this.l;
    }

    public void t() {
        this.j = true;
    }

    public String toString() {
        return (this.i ? "[X] " : "[ ] ") + d() + " " + ("0x" + Integer.toHexString(c())) + " " + q() + " " + this.f;
    }

    public boolean u() {
        return this.j;
    }
}
