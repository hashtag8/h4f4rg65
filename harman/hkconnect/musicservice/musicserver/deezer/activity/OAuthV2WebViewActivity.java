package com.harman.hkconnect.musicservice.musicserver.deezer.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.harman.hkconnect.R;
import defpackage.aho;
import defpackage.mm;

/* JADX INFO: loaded from: classes.dex */
public class OAuthV2WebViewActivity extends Activity {
    private View a;
    private WebView b;
    private WebViewClient c;
    private ImageView d;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.webview_layout);
        a();
        b();
    }

    private void a() {
        this.b = (WebView) findViewById(R.id.webview);
        this.b.setVerticalScrollBarEnabled(false);
        this.b.setHorizontalScrollBarEnabled(false);
        this.b.requestFocus();
        WebSettings settings = this.b.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setCacheMode(2);
        this.d = (ImageView) findViewById(R.id.deezer_login_close);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.harman.hkconnect.musicservice.musicserver.deezer.activity.OAuthV2WebViewActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OAuthV2WebViewActivity.this.finish();
            }
        });
        this.a = findViewById(R.id.show_request_progress_bar);
    }

    private void b() {
        this.c = new a();
        this.b.setWebViewClient(this.c);
        CookieSyncManager.createInstance(this);
        this.b.loadUrl("https://connect.deezer.com/oauth/auth.php?app_id=135461&redirect_uri=http://www.harmankardon.com/privacy-policy.html&perms=basic_access,offline_access,manage_library,delete_library,listening_history,email&response_type=token");
        c();
        mm.b("urlStr = https://connect.deezer.com/oauth/auth.php?app_id=135461&redirect_uri=http://www.harmankardon.com/privacy-policy.html&perms=basic_access,offline_access,manage_library,delete_library,listening_history,email&response_type=token", new Object[0]);
    }

    private void c() {
        runOnUiThread(new Runnable() { // from class: com.harman.hkconnect.musicservice.musicserver.deezer.activity.OAuthV2WebViewActivity.2
            @Override // java.lang.Runnable
            public void run() {
                OAuthV2WebViewActivity.this.a.setVisibility(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        runOnUiThread(new Runnable() { // from class: com.harman.hkconnect.musicservice.musicserver.deezer.activity.OAuthV2WebViewActivity.3
            @Override // java.lang.Runnable
            public void run() {
                OAuthV2WebViewActivity.this.a.setVisibility(8);
            }
        });
    }

    class a extends WebViewClient {
        private a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            mm.b("deezer", "onPageStarted  " + str);
            int iIndexOf = str.indexOf("access_token");
            if (iIndexOf != -1) {
                String strSubstring = str.substring(iIndexOf);
                mm.b("substring", strSubstring);
                String[] strArrSplit = strSubstring.split("&");
                for (String str2 : strArrSplit) {
                    String[] strArrSplit2 = str2.split("=");
                    if (strArrSplit2[0].equalsIgnoreCase("access_token")) {
                        aho.a("access_token", strArrSplit2[1]);
                        mm.b("deezer shouldOverrideUrlLoading, access_token=%s", strArrSplit2[1]);
                    } else if (strArrSplit2[0].equalsIgnoreCase("expires")) {
                        aho.a("expires", strArrSplit2[1]);
                        mm.b("deezer shouldOverrideUrlLoading, expires=%s", strArrSplit2[1]);
                    }
                }
                OAuthV2WebViewActivity.this.setResult(-1);
                OAuthV2WebViewActivity.this.finish();
                webView.destroyDrawingCache();
                webView.destroy();
            } else {
                webView.loadUrl(str);
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            mm.b("deezer", "onPageFinished  " + str);
            if (str.contains("login.php") && !str.endsWith("login.php")) {
                mm.b("deezer", "hideProgress()");
                OAuthV2WebViewActivity.this.d();
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
            mm.b("deezer", "onReceivedSslError  " + sslError.toString());
            AlertDialog.Builder builder = new AlertDialog.Builder(OAuthV2WebViewActivity.this);
            String str = "SSL Certificate error.";
            switch (sslError.getPrimaryError()) {
                case 0:
                    str = "The certificate is not yet valid.";
                    break;
                case 1:
                    str = "The certificate has expired.";
                    break;
                case 2:
                    str = "The certificate Hostname mismatch.";
                    break;
                case 3:
                    str = "The certificate authority is not trusted.";
                    break;
            }
            builder.setTitle("SSL Certificate Error");
            builder.setMessage(str + " Do you want to continue anyway?");
            builder.setPositiveButton("continue", new DialogInterface.OnClickListener() { // from class: com.harman.hkconnect.musicservice.musicserver.deezer.activity.OAuthV2WebViewActivity.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.proceed();
                }
            });
            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() { // from class: com.harman.hkconnect.musicservice.musicserver.deezer.activity.OAuthV2WebViewActivity.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.cancel();
                }
            });
            builder.create().show();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        ((ViewGroup) getWindow().getDecorView()).removeAllViews();
        super.finish();
    }
}
