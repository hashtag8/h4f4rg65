package defpackage;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@yx
public class zs extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zp {
    boolean a;
    private final zq b;
    private final a c;
    private final Object d;
    private final wi e;
    private final VersionInfoParcel f;
    private ru g;
    private AdSizeParcel h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private Boolean n;
    private int o;
    private ru p;
    private int q;
    private int r;
    private int s;
    private int t;
    private final WindowManager u;

    @yx
    public static class a extends MutableContextWrapper {
        private Activity a;
        private Context b;
        private Context c;

        public a(Context context) {
            super(context);
            setBaseContext(context);
        }

        public Activity a() {
            return this.a;
        }

        public Context b() {
            return this.c;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return this.c.getSystemService(str);
        }

        @Override // android.content.MutableContextWrapper
        public void setBaseContext(Context context) {
            this.b = context.getApplicationContext();
            this.a = context instanceof Activity ? (Activity) context : null;
            this.c = context;
            super.setBaseContext(this.b);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public void startActivity(Intent intent) {
            if (this.a != null && !aal.h()) {
                this.a.startActivity(intent);
            } else {
                intent.setFlags(268435456);
                this.b.startActivity(intent);
            }
        }
    }

    protected zs(a aVar, AdSizeParcel adSizeParcel, boolean z, boolean z2, wi wiVar, VersionInfoParcel versionInfoParcel) {
        super(aVar);
        this.d = new Object();
        this.q = -1;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.c = aVar;
        this.h = adSizeParcel;
        this.k = z;
        this.m = false;
        this.o = -1;
        this.e = wiVar;
        this.f = versionInfoParcel;
        this.u = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        sy.c().a(aVar, versionInfoParcel.b, settings);
        sy.e().a(getContext(), settings);
        setDownloadListener(this);
        this.b = sy.e().a(this, z2);
        setWebViewClient(this.b);
        setWebChromeClient(sy.e().a((zp) this));
        u();
        if (aal.e()) {
            addJavascriptInterface(new zt(this), "googleAdsJsInterface");
        }
    }

    static zs a(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, wi wiVar, VersionInfoParcel versionInfoParcel) {
        return new zs(new a(context), adSizeParcel, z, z2, wiVar, versionInfoParcel);
    }

    private void s() {
        synchronized (this.d) {
            this.n = sy.f().b();
            if (this.n == null) {
                try {
                    evaluateJavascript("(function(){})()", null);
                    a((Boolean) true);
                } catch (IllegalStateException e) {
                    a((Boolean) false);
                }
            }
        }
    }

    private void t() {
        Activity activityC = c();
        if (!this.m || activityC == null) {
            return;
        }
        sy.e().a(activityC, this);
        this.m = false;
    }

    private void u() {
        synchronized (this.d) {
            if (this.k || this.h.e) {
                if (Build.VERSION.SDK_INT < 14) {
                    su.a("Disabling hardware acceleration on an overlay.");
                    v();
                } else {
                    su.a("Enabling hardware acceleration on an overlay.");
                    w();
                }
            } else if (Build.VERSION.SDK_INT < 18) {
                su.a("Disabling hardware acceleration on an AdView.");
                v();
            } else {
                su.a("Enabling hardware acceleration on an AdView.");
                w();
            }
        }
    }

    private void v() {
        synchronized (this.d) {
            if (!this.l) {
                sy.e().b((View) this);
            }
            this.l = true;
        }
    }

    private void w() {
        synchronized (this.d) {
            if (this.l) {
                sy.e().a((View) this);
            }
            this.l = false;
        }
    }

    @Override // defpackage.zp
    public void a() {
        HashMap map = new HashMap(1);
        map.put("version", this.f.b);
        a("onhide", map);
    }

    @Override // defpackage.zp
    public void a(int i) {
        HashMap map = new HashMap(2);
        map.put("closetype", String.valueOf(i));
        map.put("version", this.f.b);
        a("onhide", map);
    }

    @Override // defpackage.zp
    public void a(AdSizeParcel adSizeParcel) {
        synchronized (this.d) {
            this.h = adSizeParcel;
            requestLayout();
        }
    }

    void a(Boolean bool) {
        this.n = bool;
        sy.f().a(bool);
    }

    @Override // defpackage.zp
    public void a(String str) {
        synchronized (this.d) {
            super.loadUrl(str);
        }
    }

    protected void a(String str, ValueCallback<String> valueCallback) {
        synchronized (this.d) {
            if (m()) {
                su.e("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else {
                evaluateJavascript(str, valueCallback);
            }
        }
    }

    @Override // defpackage.zp
    public void a(String str, Map<String, ?> map) {
        try {
            a(str, sy.c().a(map));
        } catch (JSONException e) {
            su.e("Could not convert parameters to JSON.");
        }
    }

    @Override // defpackage.zp
    public void a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("AFMA_ReceiveMessage('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(string);
        sb.append(");");
        su.d("Dispatching AFMA event: " + sb.toString());
        c(sb.toString());
    }

    @Override // defpackage.zp
    public void a(ru ruVar) {
        synchronized (this.d) {
            this.g = ruVar;
        }
    }

    @Override // defpackage.zp
    public void a(boolean z) {
        synchronized (this.d) {
            this.k = z;
            u();
        }
    }

    @Override // defpackage.zp
    public void b() {
        HashMap map = new HashMap(1);
        map.put("version", this.f.b);
        a("onshow", map);
    }

    protected void b(String str) {
        synchronized (this.d) {
            if (m()) {
                su.e("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    @Override // defpackage.zp
    public void b(ru ruVar) {
        synchronized (this.d) {
            this.p = ruVar;
        }
    }

    @Override // defpackage.zp
    public void b(boolean z) {
        synchronized (this.d) {
            if (this.g != null) {
                this.g.a(this.b.b(), z);
            } else {
                this.i = z;
            }
        }
    }

    @Override // defpackage.zp
    public Activity c() {
        return this.c.a();
    }

    protected void c(String str) {
        if (!aal.f()) {
            b("javascript:" + str);
            return;
        }
        if (q() == null) {
            s();
        }
        if (q().booleanValue()) {
            a(str, (ValueCallback<String>) null);
        } else {
            b("javascript:" + str);
        }
    }

    @Override // defpackage.zp
    public Context d() {
        return this.c.b();
    }

    @Override // android.webkit.WebView
    public void destroy() {
        synchronized (this.d) {
            t();
            if (this.g != null) {
                this.g.a();
                this.g.k();
                this.g = null;
            }
            this.b.f();
            if (this.j) {
                return;
            }
            sy.k().a(this);
            this.j = true;
            su.d("Initiating WebView self destruct sequence in 3...");
            this.b.c();
        }
    }

    @Override // defpackage.zp
    public ru e() {
        ru ruVar;
        synchronized (this.d) {
            ruVar = this.g;
        }
        return ruVar;
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        synchronized (this.d) {
            if (!m()) {
                super.evaluateJavascript(str, valueCallback);
                return;
            }
            su.e("The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
        }
    }

    @Override // defpackage.zp
    public ru f() {
        ru ruVar;
        synchronized (this.d) {
            ruVar = this.p;
        }
        return ruVar;
    }

    @Override // defpackage.zp
    public AdSizeParcel g() {
        AdSizeParcel adSizeParcel;
        synchronized (this.d) {
            adSizeParcel = this.h;
        }
        return adSizeParcel;
    }

    public int getRequestedOrientation() {
        int i;
        synchronized (this.d) {
            i = this.o;
        }
        return i;
    }

    @Override // defpackage.zp
    public WebView getWebView() {
        return this;
    }

    @Override // defpackage.zp
    public zq h() {
        return this.b;
    }

    @Override // defpackage.zp
    public boolean i() {
        return this.i;
    }

    @Override // defpackage.zp
    public wi j() {
        return this.e;
    }

    @Override // defpackage.zp
    public VersionInfoParcel k() {
        return this.f;
    }

    @Override // defpackage.zp
    public boolean l() {
        boolean z;
        synchronized (this.d) {
            z = this.k;
        }
        return z;
    }

    @Override // android.webkit.WebView
    public void loadData(String str, String str2, String str3) {
        synchronized (this.d) {
            if (m()) {
                su.e("The webview is destroyed. Ignoring action.");
            } else {
                super.loadData(str, str2, str3);
            }
        }
    }

    @Override // android.webkit.WebView, defpackage.zp
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        synchronized (this.d) {
            if (m()) {
                su.e("The webview is destroyed. Ignoring action.");
            } else {
                super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            }
        }
    }

    @Override // android.webkit.WebView, defpackage.zp
    public void loadUrl(String str) {
        synchronized (this.d) {
            if (m()) {
                su.e("The webview is destroyed. Ignoring action.");
            } else {
                super.loadUrl(str);
            }
        }
    }

    @Override // defpackage.zp
    public boolean m() {
        boolean z;
        synchronized (this.d) {
            z = this.j;
        }
        return z;
    }

    @Override // defpackage.zp
    public void n() {
        synchronized (this.d) {
            su.d("Destroying WebView!");
            super.destroy();
        }
    }

    @Override // defpackage.zp
    public void o() {
        synchronized (this.d) {
            r();
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        synchronized (this.d) {
            super.onAttachedToWindow();
            if (!m()) {
                this.a = true;
                if (this.b.b()) {
                    r();
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        synchronized (this.d) {
            if (!m()) {
                t();
                this.a = false;
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            su.a("Couldn't find an Activity to view url/mimetype: " + str + " / " + str4);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (m()) {
            return;
        }
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        boolean zP = p();
        ru ruVarE = e();
        if (ruVarE == null || !zP) {
            return;
        }
        ruVarE.o();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        synchronized (this.d) {
            if (m()) {
                setMeasuredDimension(0, 0);
                return;
            }
            if (isInEditMode() || this.k) {
                super.onMeasure(i, i2);
                return;
            }
            if (this.h.e) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                this.u.getDefaultDisplay().getMetrics(displayMetrics);
                setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
                return;
            }
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            int i3 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
            int i4 = (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) ? size2 : Integer.MAX_VALUE;
            if (this.h.g > i3 || this.h.d > i4) {
                float f = this.c.getResources().getDisplayMetrics().density;
                su.e("Not enough space to show ad. Needs " + ((int) (this.h.g / f)) + "x" + ((int) (this.h.d / f)) + " dp, but only has " + ((int) (size / f)) + "x" + ((int) (size2 / f)) + " dp.");
                if (getVisibility() != 8) {
                    setVisibility(4);
                }
                setMeasuredDimension(0, 0);
            } else {
                if (getVisibility() != 8) {
                    setVisibility(0);
                }
                setMeasuredDimension(this.h.g, this.h.d);
            }
        }
    }

    @Override // android.webkit.WebView
    public void onPause() {
        if (m()) {
            return;
        }
        try {
            super.onPause();
        } catch (Exception e) {
            su.b("Could not pause webview.", e);
        }
    }

    @Override // android.webkit.WebView
    public void onResume() {
        if (m()) {
            return;
        }
        try {
            super.onResume();
        } catch (Exception e) {
            su.b("Could not resume webview.", e);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.e != null) {
            this.e.a(motionEvent);
        }
        if (m()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean p() {
        int iB;
        int iB2;
        if (!h().b()) {
            return false;
        }
        DisplayMetrics displayMetricsA = sy.c().a(this.u);
        int iB3 = rj.a().b(displayMetricsA, displayMetricsA.widthPixels);
        int iB4 = rj.a().b(displayMetricsA, displayMetricsA.heightPixels);
        Activity activityC = c();
        if (activityC == null || activityC.getWindow() == null) {
            iB = iB4;
            iB2 = iB3;
        } else {
            int[] iArrA = sy.c().a(activityC);
            iB2 = rj.a().b(displayMetricsA, iArrA[0]);
            iB = rj.a().b(displayMetricsA, iArrA[1]);
        }
        if (this.r == iB3 && this.q == iB4 && this.s == iB2 && this.t == iB) {
            return false;
        }
        boolean z = (this.r == iB3 && this.q == iB4) ? false : true;
        this.r = iB3;
        this.q = iB4;
        this.s = iB2;
        this.t = iB;
        new yh(this).a(iB3, iB4, iB2, iB, displayMetricsA.density, this.u.getDefaultDisplay().getRotation());
        return z;
    }

    Boolean q() {
        Boolean bool;
        synchronized (this.d) {
            bool = this.n;
        }
        return bool;
    }

    void r() {
        Activity activityC = c();
        if (this.m || activityC == null || !this.a) {
            return;
        }
        sy.c().a(activityC, this);
        this.m = true;
    }

    @Override // defpackage.zp
    public void setContext(Context context) {
        this.c.setBaseContext(context);
    }

    @Override // defpackage.zp
    public void setRequestedOrientation(int i) {
        synchronized (this.d) {
            this.o = i;
            if (this.g != null) {
                this.g.a(this.o);
            }
        }
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        if (m()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e) {
            su.b("Could not stop loading webview.", e);
        }
    }
}
