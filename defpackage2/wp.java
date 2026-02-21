package defpackage;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@yx
public class wp extends Thread {
    private boolean a;
    private boolean b;
    private final Object c;
    private final wo d;
    private final wn e;
    private final yw f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;

    @yx
    class a {
        final int a;
        final int b;

        a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    a a(View view, wm wmVar) {
        if (view == null) {
            return new a(0, 0);
        }
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new a(0, 0);
            }
            wmVar.b(text.toString());
            return new a(1, 0);
        }
        if ((view instanceof WebView) && !(view instanceof zp)) {
            wmVar.d();
            return a((WebView) view, wmVar) ? new a(0, 1) : new a(0, 0);
        }
        if (!(view instanceof ViewGroup)) {
            return new a(0, 0);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            a aVarA = a(viewGroup.getChildAt(i3), wmVar);
            i2 += aVarA.a;
            i += aVarA.b;
        }
        return new a(i2, i);
    }

    void a(Activity activity) {
        if (activity == null) {
            return;
        }
        View viewFindViewById = null;
        if (activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            viewFindViewById = activity.getWindow().getDecorView().findViewById(R.id.content);
        }
        if (viewFindViewById != null) {
            a(viewFindViewById);
        }
    }

    void a(wm wmVar, WebView webView, String str) {
        wmVar.c();
        try {
            if (!TextUtils.isEmpty(str)) {
                String strOptString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    wmVar.a(strOptString);
                } else {
                    wmVar.a(webView.getTitle() + "\n" + strOptString);
                }
            }
            if (wmVar.a()) {
                this.e.b(wmVar);
            }
        } catch (JSONException e) {
            su.a("Json string may be malformed.");
        } catch (Throwable th) {
            su.a("Failed to get webview content.", th);
            this.f.a(th, true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        if (a(r0) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        if (r1.inKeyguardRestrictedInputMode() != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
    
        if (a(r3) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean a() {
        /*
            r7 = this;
            r2 = 0
            wo r0 = r7.d     // Catch: java.lang.Throwable -> L57
            android.content.Context r3 = r0.b()     // Catch: java.lang.Throwable -> L57
            if (r3 != 0) goto Lb
            r0 = r2
        La:
            return r0
        Lb:
            java.lang.String r0 = "activity"
            java.lang.Object r0 = r3.getSystemService(r0)     // Catch: java.lang.Throwable -> L57
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0     // Catch: java.lang.Throwable -> L57
            java.lang.String r1 = "keyguard"
            java.lang.Object r1 = r3.getSystemService(r1)     // Catch: java.lang.Throwable -> L57
            android.app.KeyguardManager r1 = (android.app.KeyguardManager) r1     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L1f
            if (r1 != 0) goto L21
        L1f:
            r0 = r2
            goto La
        L21:
            java.util.List r0 = r0.getRunningAppProcesses()     // Catch: java.lang.Throwable -> L57
            if (r0 != 0) goto L29
            r0 = r2
            goto La
        L29:
            java.util.Iterator r4 = r0.iterator()     // Catch: java.lang.Throwable -> L57
        L2d:
            boolean r0 = r4.hasNext()     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L55
            java.lang.Object r0 = r4.next()     // Catch: java.lang.Throwable -> L57
            android.app.ActivityManager$RunningAppProcessInfo r0 = (android.app.ActivityManager.RunningAppProcessInfo) r0     // Catch: java.lang.Throwable -> L57
            int r5 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L57
            int r6 = r0.pid     // Catch: java.lang.Throwable -> L57
            if (r5 != r6) goto L2d
            boolean r0 = r7.a(r0)     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L55
            boolean r0 = r1.inKeyguardRestrictedInputMode()     // Catch: java.lang.Throwable -> L57
            if (r0 != 0) goto L55
            boolean r0 = r7.a(r3)     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L55
            r0 = 1
            goto La
        L55:
            r0 = r2
            goto La
        L57:
            r0 = move-exception
            r0 = r2
            goto La
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wp.a():boolean");
    }

    boolean a(ActivityManager.RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    boolean a(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        return powerManager.isScreenOn();
    }

    boolean a(final View view) {
        if (view == null) {
            return false;
        }
        view.post(new Runnable() { // from class: wp.1
            @Override // java.lang.Runnable
            public void run() {
                wp.this.b(view);
            }
        });
        return true;
    }

    boolean a(final WebView webView, final wm wmVar) {
        if (!aal.f()) {
            return false;
        }
        wmVar.d();
        webView.post(new Runnable() { // from class: wp.2
            ValueCallback<String> a = new ValueCallback<String>() { // from class: wp.2.1
                @Override // android.webkit.ValueCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(String str) {
                    wp.this.a(wmVar, webView, str);
                }
            };

            @Override // java.lang.Runnable
            public void run() {
                if (webView.getSettings().getJavaScriptEnabled()) {
                    try {
                        webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.a);
                    } catch (Throwable th) {
                        this.a.onReceiveValue("");
                    }
                }
            }
        });
        return true;
    }

    public void b() {
        synchronized (this.c) {
            this.a = true;
            su.a("ContentFetchThread: paused, mPause = " + this.a);
        }
    }

    void b(View view) {
        try {
            wm wmVar = new wm(this.h, this.i, this.j, this.k);
            a aVarA = a(view, wmVar);
            wmVar.e();
            if (aVarA.a == 0 && aVarA.b == 0) {
                return;
            }
            if (aVarA.b == 0 && wmVar.f() == 0) {
                return;
            }
            if (aVarA.b == 0 && this.e.a(wmVar)) {
                return;
            }
            this.e.c(wmVar);
        } catch (Exception e) {
            su.b("Exception in fetchContentOnUIThread", e);
            this.f.a(e, true);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!this.b) {
            try {
            } catch (Throwable th) {
                su.b("Error in ContentFetchTask", th);
                this.f.a(th, true);
            }
            if (a()) {
                Activity activityA = this.d.a();
                if (activityA == null) {
                    su.a("ContentFetchThread: no activity");
                } else {
                    a(activityA);
                }
            } else {
                su.a("ContentFetchTask: sleeping");
                b();
            }
            Thread.sleep(this.g * 1000);
            synchronized (this.c) {
                while (this.a) {
                    try {
                        su.a("ContentFetchTask: waiting");
                        this.c.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }
}
