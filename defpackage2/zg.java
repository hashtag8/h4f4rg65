package defpackage;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@yx
public class zg {

    static class a extends zg {
        a() {
            super();
        }

        @Override // defpackage.zg
        public int a() {
            return 6;
        }

        @Override // defpackage.zg
        public boolean a(DownloadManager.Request request) {
            request.setShowRunningNotification(true);
            return true;
        }

        @Override // defpackage.zg
        public int b() {
            return 7;
        }
    }

    static class b extends a {
        b() {
        }

        @Override // defpackage.zg
        public WebChromeClient a(zp zpVar) {
            return new zu(zpVar);
        }

        @Override // defpackage.zg
        public Set<String> a(Uri uri) {
            return uri.getQueryParameterNames();
        }

        @Override // defpackage.zg
        public zq a(zp zpVar, boolean z) {
            return new zv(zpVar, z);
        }

        @Override // zg.a, defpackage.zg
        public boolean a(DownloadManager.Request request) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            return true;
        }

        @Override // defpackage.zg
        public boolean a(Context context, WebSettings webSettings) {
            if (context.getCacheDir() != null) {
                webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
                webSettings.setAppCacheMaxSize(0L);
                webSettings.setAppCacheEnabled(true);
            }
            webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
            webSettings.setDatabaseEnabled(true);
            webSettings.setDomStorageEnabled(true);
            webSettings.setDisplayZoomControls(false);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setSupportZoom(true);
            return true;
        }

        @Override // defpackage.zg
        public boolean a(View view) {
            view.setLayerType(0, null);
            return true;
        }

        @Override // defpackage.zg
        public boolean a(Window window) {
            window.setFlags(16777216, 16777216);
            return true;
        }

        @Override // defpackage.zg
        public boolean a(WebView webView) {
            webView.onPause();
            return true;
        }

        @Override // defpackage.zg
        public boolean b(View view) {
            view.setLayerType(1, null);
            return true;
        }

        @Override // defpackage.zg
        public boolean b(WebView webView) {
            webView.onResume();
            return true;
        }
    }

    static class c extends b {
        c() {
        }

        @Override // zg.b, defpackage.zg
        public WebChromeClient a(zp zpVar) {
            return new zw(zpVar);
        }
    }

    static class d extends f {
        d() {
        }

        @Override // defpackage.zg
        public String a(Context context) {
            return WebSettings.getDefaultUserAgent(context);
        }

        @Override // zg.b, defpackage.zg
        public boolean a(Context context, WebSettings webSettings) {
            super.a(context, webSettings);
            webSettings.setMediaPlaybackRequiresUserGesture(false);
            return true;
        }
    }

    static class e extends d {
        e() {
        }

        @Override // defpackage.zg
        public int c() {
            return 14;
        }
    }

    static class f extends c {
        f() {
        }

        @Override // defpackage.zg
        public void a(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            Window window = activity.getWindow();
            if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
                return;
            }
            a(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
        }

        @Override // defpackage.zg
        public void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    static class g extends e {
        g() {
        }
    }

    private zg() {
    }

    public static zg a(int i) {
        return i >= 19 ? new g() : i >= 18 ? new e() : i >= 17 ? new d() : i >= 16 ? new f() : i >= 14 ? new c() : i >= 11 ? new b() : i >= 9 ? new a() : new zg();
    }

    public int a() {
        return 0;
    }

    public WebChromeClient a(zp zpVar) {
        return null;
    }

    public String a(Context context) {
        return "";
    }

    public Set<String> a(Uri uri) {
        String encodedQuery;
        if (!uri.isOpaque() && (encodedQuery = uri.getEncodedQuery()) != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i = 0;
            do {
                int iIndexOf = encodedQuery.indexOf(38, i);
                if (iIndexOf == -1) {
                    iIndexOf = encodedQuery.length();
                }
                int iIndexOf2 = encodedQuery.indexOf(61, i);
                if (iIndexOf2 > iIndexOf || iIndexOf2 == -1) {
                    iIndexOf2 = iIndexOf;
                }
                linkedHashSet.add(Uri.decode(encodedQuery.substring(i, iIndexOf2)));
                i = iIndexOf + 1;
            } while (i < encodedQuery.length());
            return Collections.unmodifiableSet(linkedHashSet);
        }
        return Collections.emptySet();
    }

    public zq a(zp zpVar, boolean z) {
        return new zq(zpVar, z);
    }

    public void a(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
            return;
        }
        a(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
    }

    public void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public boolean a(DownloadManager.Request request) {
        return false;
    }

    public boolean a(Context context, WebSettings webSettings) {
        return false;
    }

    public boolean a(View view) {
        return false;
    }

    public boolean a(Window window) {
        return false;
    }

    public boolean a(WebView webView) {
        return false;
    }

    public int b() {
        return 1;
    }

    public boolean b(View view) {
        return false;
    }

    public boolean b(WebView webView) {
        return false;
    }

    public int c() {
        return 5;
    }
}
