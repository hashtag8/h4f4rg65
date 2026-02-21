package defpackage;

import android.net.Uri;
import android.support.v8.renderscript.Allocation;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes.dex */
@yx
public class zq extends WebViewClient {
    protected final zp a;
    private final HashMap<String, List<xl>> b;
    private final Object c;
    private rb d;
    private rx e;
    private a f;
    private xj g;
    private boolean h;
    private xm i;
    private xo j;
    private boolean k;
    private sc l;
    private final yg m;
    private sw n;
    private yc o;
    private yi p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;

    public interface a {
        void a(zp zpVar, boolean z);
    }

    static class b implements rx {
        private zp a;
        private rx b;

        public b(zp zpVar, rx rxVar) {
            this.a = zpVar;
            this.b = rxVar;
        }

        @Override // defpackage.rx
        public void a() {
            this.b.a();
            this.a.a();
        }

        @Override // defpackage.rx
        public void b() {
            this.b.b();
            this.a.b();
        }
    }

    class c implements xl {
        private c() {
        }

        @Override // defpackage.xl
        public void a(zp zpVar, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                zq.this.h();
            } else if (map.keySet().contains("stop")) {
                zq.this.i();
            } else if (map.keySet().contains("cancel")) {
                zq.this.j();
            }
        }
    }

    public zq(zp zpVar, boolean z) {
        this(zpVar, z, new yg(zpVar, zpVar.d(), new wv(zpVar.getContext())), null);
    }

    zq(zp zpVar, boolean z, yg ygVar, yc ycVar) {
        this.b = new HashMap<>();
        this.c = new Object();
        this.h = false;
        this.a = zpVar;
        this.k = z;
        this.m = ygVar;
        this.o = ycVar;
    }

    private static boolean b(Uri uri) {
        String scheme = uri.getScheme();
        return HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.u++;
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.u--;
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.t = true;
        d();
    }

    public sw a() {
        return this.n;
    }

    public void a(int i, int i2) {
        if (this.o != null) {
            this.o.c(i, i2);
        }
    }

    public void a(Uri uri) {
        String path = uri.getPath();
        List<xl> list = this.b.get(path);
        if (list == null) {
            su.d("No GMSG handler found for GMSG: " + uri);
            return;
        }
        Map<String, String> mapA = sy.c().a(uri);
        if (su.a(2)) {
            su.d("Received GMSG: " + path);
            for (String str : mapA.keySet()) {
                su.d("  " + str + ": " + mapA.get(str));
            }
        }
        Iterator<xl> it = list.iterator();
        while (it.hasNext()) {
            it.next().a(this.a, mapA);
        }
    }

    public final void a(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel) {
        boolean zL = this.a.l();
        a(new AdOverlayInfoParcel(adLauncherIntentInfoParcel, (!zL || this.a.g().e) ? this.d : null, zL ? null : this.e, this.l, this.a.k()));
    }

    public void a(AdOverlayInfoParcel adOverlayInfoParcel) {
        sy.b().a(this.a.getContext(), adOverlayInfoParcel, this.o != null ? this.o.b() : false ? false : true);
    }

    public final void a(String str, xl xlVar) {
        synchronized (this.c) {
            List<xl> copyOnWriteArrayList = this.b.get(str);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                this.b.put(str, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(xlVar);
        }
    }

    public void a(rb rbVar, rx rxVar, xj xjVar, sc scVar, boolean z, xm xmVar, xo xoVar, sw swVar, yi yiVar) {
        if (swVar == null) {
            swVar = new sw(false);
        }
        this.o = new yc(this.a, yiVar);
        a("/appEvent", new xi(xjVar));
        a("/canOpenURLs", xk.b);
        a("/canOpenIntents", xk.c);
        a("/click", xk.d);
        a("/close", xk.e);
        a("/customClose", xk.f);
        a("/delayPageLoaded", new c());
        a("/httpTrack", xk.g);
        a("/log", xk.h);
        a("/mraid", new xp(swVar, this.o));
        a("/open", new xq(xmVar, swVar, this.o));
        a("/precache", xk.k);
        a("/touch", xk.i);
        a("/video", xk.j);
        if (xoVar != null) {
            a("/setInterstitialProperties", new xn(xoVar));
        }
        this.d = rbVar;
        this.e = rxVar;
        this.g = xjVar;
        this.i = xmVar;
        this.l = scVar;
        this.n = swVar;
        this.p = yiVar;
        this.j = xoVar;
        a(z);
        this.q = false;
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public final void a(boolean z, int i) {
        a(new AdOverlayInfoParcel((!this.a.l() || this.a.g().e) ? this.d : null, this.e, this.l, this.a, z, i, this.a.k()));
    }

    public final void a(boolean z, int i, String str) {
        boolean zL = this.a.l();
        a(new AdOverlayInfoParcel((!zL || this.a.g().e) ? this.d : null, zL ? null : new b(this.a, this.e), this.g, this.l, this.a, z, i, str, this.a.k(), this.i));
    }

    public final void a(boolean z, int i, String str, String str2) {
        boolean zL = this.a.l();
        a(new AdOverlayInfoParcel((!zL || this.a.g().e) ? this.d : null, zL ? null : new b(this.a, this.e), this.g, this.l, this.a, z, i, str, str2, this.a.k(), this.i));
    }

    public boolean b() {
        boolean z;
        synchronized (this.c) {
            z = this.k;
        }
        return z;
    }

    public void c() {
        synchronized (this.c) {
            su.d("Loading blank page in WebView, 2...");
            this.r = true;
            this.a.a("about:blank");
        }
    }

    public final void d() {
        if (this.f != null) {
            if ((!this.s || this.u > 0) && !this.t) {
                return;
            }
            this.f.a(this.a, !this.t);
            this.f = null;
        }
    }

    public void e() {
        if (b()) {
            this.m.c();
        }
    }

    public final void f() {
        synchronized (this.c) {
            this.b.clear();
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = false;
            this.k = false;
            this.i = null;
            this.l = null;
            if (this.o != null) {
                this.o.a(true);
                this.o = null;
            }
            this.q = false;
        }
    }

    public final void g() {
        synchronized (this.c) {
            this.h = false;
            this.k = true;
            this.a.o();
            final ru ruVarE = this.a.e();
            if (ruVarE != null) {
                if (rj.a().a()) {
                    ruVarE.m();
                } else {
                    zf.a.post(new Runnable() { // from class: zq.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ruVarE.m();
                        }
                    });
                }
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        su.d("Loading resource: " + str);
        Uri uri = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uri.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            a(uri);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.c) {
            if (this.r && "about:blank".equals(str)) {
                su.d("Blank page loaded, 1...");
                this.a.n();
            } else {
                this.s = true;
                d();
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 126:
            case 127:
            case Allocation.USAGE_SHARED /* 128 */:
            case 129:
            case 130:
            case 222:
                return true;
            default:
                return false;
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri uri;
        su.d("AdWebView shouldOverrideUrlLoading: " + str);
        Uri uriA = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uriA.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uriA.getHost())) {
            a(uriA);
        } else {
            if (this.h && webView == this.a && b(uriA)) {
                if (!this.q) {
                    this.q = true;
                    if (this.d != null && xb.J.c().booleanValue()) {
                        this.d.a();
                    }
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            if (this.a.willNotDraw()) {
                su.e("AdWebView unable to handle URL: " + str);
            } else {
                try {
                    wi wiVarJ = this.a.j();
                    if (wiVarJ != null && wiVarJ.b(uriA)) {
                        uriA = wiVarJ.a(uriA, this.a.getContext());
                    }
                    uri = uriA;
                } catch (wj e) {
                    su.e("Unable to append parameter to URL: " + str);
                    uri = uriA;
                }
                if (this.n == null || this.n.a()) {
                    a(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
                } else {
                    this.n.a(str);
                }
            }
        }
        return true;
    }
}
