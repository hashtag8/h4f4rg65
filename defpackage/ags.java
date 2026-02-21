package defpackage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import defpackage.lf;
import defpackage.ls;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public abstract class ags<T> {
    private final agn a;
    private final lr b;
    private final String c;
    private agi<T> d = new agi<>();
    private List<String> e = new ArrayList();
    private WeakReference<Fragment> f;

    protected abstract T b(String str);

    public ags(agn agnVar, String str, lr lrVar) {
        brw.a(agnVar, "baseUrl", new Object[0]);
        brw.a(lrVar, "queue", new Object[0]);
        this.a = agnVar;
        this.b = lrVar;
        this.c = str;
        mm.b("Radionomy_API_TESY mBaseUrl = %s , mQueue = %s , mPath = %s ", this.a.a(), this.c);
    }

    public boolean a(agh<? super T> aghVar) {
        return this.d.a(aghVar);
    }

    public void a(Fragment fragment) {
        this.f = new WeakReference<>(fragment);
    }

    protected String a(boolean z) {
        StringBuilder sb = new StringBuilder(this.a.a());
        if (this.c != null) {
            if (this.a.a().endsWith("/") && this.c.startsWith("/")) {
                sb.append(this.c.substring(1));
            } else {
                sb.append(this.c);
            }
        }
        if (z) {
            String strA = a(c());
            if (!bru.a((CharSequence) strA)) {
                sb.append('?' + strA);
                mm.b("Radionomy_API_TESY params = %s ", strA);
            }
        }
        mm.b("Radionomy_API_TESY geturl = %s ", sb.toString());
        return sb.toString();
    }

    public void a() {
        ls.a aVar = new ls.a() { // from class: ags.1
            @Override // ls.a
            public void a(lx lxVar) {
                if (ags.this.a(lxVar)) {
                    mm.e("%s url %s error", ags.this.getClass().getSimpleName(), bru.b(ags.this.a(true), 100), lxVar);
                }
                ags.this.b(lxVar);
            }
        };
        mm.b("Requesting method %s URL %s", Integer.valueOf(b()), a(true));
        lq<T> lqVar = new lq<T>(b(), a(b() == 0), aVar) { // from class: ags.2
            private byte[] b = null;

            @Override // defpackage.lq
            public Map<String, String> i() {
                return ags.this.d();
            }

            @Override // defpackage.lq
            public Map<String, String> n() {
                return ags.this.c();
            }

            @Override // defpackage.lq
            protected ls<T> a(ln lnVar) {
                if (Arrays.equals(this.b, lnVar.b)) {
                    return ls.a(new agp());
                }
                this.b = lnVar.b;
                return ags.this.b(lnVar);
            }

            @Override // defpackage.lq
            protected void a(T t) {
                try {
                    ags.this.b(t);
                } catch (Exception e) {
                    if (ags.this.e()) {
                        mm.b("Activity has already finished, not showing error", e);
                    } else {
                        ags.this.d.a((Object) this, new ErrorInfo.a().a(R.id.errorCode_onSuccessFailure).a((Throwable) e).a());
                    }
                }
            }

            @Override // defpackage.lq
            public String f() {
                return ags.this.a(true);
            }
        };
        if (this.a.d() == 0 || this.a.e() == 0) {
            lqVar.a(false);
        }
        this.b.a(lqVar);
    }

    protected boolean a(lx lxVar) {
        if (lxVar instanceof agp) {
            return false;
        }
        return ((lxVar instanceof agr) && ((agr) lxVar).a().a(R.id.errorCode_noData)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ls<T> b(ln lnVar) {
        String str;
        try {
            str = new String(lnVar.b, md.a(lnVar.c));
        } catch (UnsupportedEncodingException e) {
            str = new String(lnVar.b);
        }
        try {
            ErrorInfo errorInfoA = a(str);
            if (errorInfoA != null) {
                return ls.a(new agr(a(true), errorInfoA));
            }
            T tB = b(str);
            if (a(tB)) {
                return ls.a(new agr(a(true), new ErrorInfo.a().a((Serializable) str).a(R.id.errorCode_noData).a("No data").a()));
            }
            return ls.a(tB, a(lnVar));
        } catch (Exception e2) {
            return ls.a(new agr(a(true), e2));
        }
    }

    protected ErrorInfo a(String str) {
        return null;
    }

    protected boolean a(T t) {
        return t == null || ((t instanceof Collection) && ((Collection) t).isEmpty());
    }

    protected int b() {
        return 0;
    }

    protected void b(T t) {
        if (e()) {
            mm.b("Activity has already finished, not showing response", new Object[0]);
        } else {
            this.d.a(this, t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(lx lxVar) {
        ErrorInfo errorInfoC;
        if (!(lxVar instanceof agp)) {
            if (e()) {
                mm.b("Activity has already finished, not showing error", lxVar);
                return;
            }
            if (lxVar instanceof agr) {
                errorInfoC = ((agr) lxVar).a();
            } else {
                errorInfoC = c(lxVar);
            }
            try {
                this.d.a((Object) this, errorInfoC);
            } catch (RuntimeException e) {
                mm.e("Could not show error", errorInfoC, e);
            }
        }
    }

    private ErrorInfo c(lx lxVar) {
        ErrorInfo.a aVar = new ErrorInfo.a();
        Bundle bundle = new Bundle();
        if (lxVar.a != null) {
            aVar.a(R.id.errorCode_serverError);
            bundle.putInt("statusCode", lxVar.a.a);
            bundle.putByteArray("data", lxVar.a.b);
            if (lxVar.a.c != null) {
                bundle.putSerializable("headers", new HashMap(lxVar.a.c));
            }
            bundle.getBoolean("notModified", lxVar.a.d);
            bundle.putLong("networkTimeMs", lxVar.a.e);
        } else {
            aVar.a(R.id.errorCode_noConnection);
        }
        bundle.putSerializable("exceptionClass", lxVar.getClass());
        bundle.putString("stackTrace", bse.a(lxVar));
        bundle.putString("url", a(true));
        aVar.a(bundle);
        return aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        if (this.f == null) {
            return false;
        }
        Fragment fragment = this.f.get();
        if (fragment == null) {
            return true;
        }
        ba baVarP = fragment.p();
        return baVarP == null || baVarP.isFinishing();
    }

    protected Map<String, String> c() {
        HashMap map = new HashMap(this.a.b());
        if (!this.e.isEmpty()) {
            map.put("fields", bru.a(this.e, "|"));
        }
        return map;
    }

    protected Map<String, String> d() {
        HashMap map = new HashMap(this.a.c());
        if (b() == 1) {
            map.put("Content-Type", "application/x-www-form-urlencoded");
        }
        return map;
    }

    private String a(Map<String, String> map) {
        try {
            StringBuilder sb = new StringBuilder();
            TreeSet<Map.Entry> treeSet = new TreeSet(new Comparator<Map.Entry<String, String>>() { // from class: ags.3
                @Override // java.util.Comparator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
                    return brs.a(entry.getKey(), entry2.getKey());
                }
            });
            treeSet.addAll(map.entrySet());
            for (Map.Entry entry : treeSet) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode((String) entry.getKey(), HTTP.UTF_8));
                sb.append('=');
                sb.append(URLEncoder.encode((String) entry.getValue(), HTTP.UTF_8));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public lf.a a(ln lnVar) {
        long jA;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = lnVar.c;
        String str = map.get(HTTP.DATE_HEADER);
        if (str != null) {
            jA = md.a(str);
            if (jA == 0) {
                mm.b("Invalid Date from response header", str);
            }
        } else {
            jA = 0;
        }
        String str2 = map.get("ETag");
        long jE = this.a.e() + jCurrentTimeMillis;
        long jD = jCurrentTimeMillis + this.a.d();
        lf.a aVar = new lf.a();
        aVar.a = lnVar.b;
        aVar.b = str2;
        aVar.f = jE;
        aVar.e = jD;
        aVar.c = jA;
        aVar.g = map;
        return aVar;
    }
}
