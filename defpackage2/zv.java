package defpackage;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
@yx
public class zv extends zq {
    public zv(zp zpVar, boolean z) {
        super(zpVar, z);
    }

    protected WebResourceResponse a(Context context, String str, String str2) {
        HashMap map = new HashMap();
        map.put(HTTP.USER_AGENT, sy.c().a(context, str));
        map.put("Cache-Control", "max-stale=3600");
        String str3 = new zi(context).a(str2, map).get(60L, TimeUnit.SECONDS);
        if (str3 == null) {
            return null;
        }
        return new WebResourceResponse("application/javascript", HTTP.UTF_8, new ByteArrayInputStream(str3.getBytes(HTTP.UTF_8)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
                return super.shouldInterceptRequest(webView, str);
            }
            if (!(webView instanceof zp)) {
                su.e("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webView, str);
            }
            zp zpVar = (zp) webView;
            zpVar.h().g();
            String strC = zpVar.g().e ? xb.v.c() : zpVar.l() ? xb.u.c() : xb.t.c();
            su.d("shouldInterceptRequest(" + strC + ")");
            return a(zpVar.getContext(), this.a.k().b, strC);
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            su.e("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, str);
        }
    }
}
