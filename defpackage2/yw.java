package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
@yx
public class yw implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a;
    private Thread.UncaughtExceptionHandler b;
    private Context c;
    private VersionInfoParcel d;

    public yw(Context context, VersionInfoParcel versionInfoParcel, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread.UncaughtExceptionHandler uncaughtExceptionHandler2) {
        this.a = uncaughtExceptionHandler;
        this.b = uncaughtExceptionHandler2;
        this.c = context;
        this.d = versionInfoParcel;
    }

    private static boolean a(Context context) {
        return xb.e.c().booleanValue();
    }

    private Throwable b(Throwable th) {
        Throwable th2;
        if (xb.f.c().booleanValue()) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        Throwable th3 = null;
        while (!linkedList.isEmpty()) {
            Throwable th4 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th4.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th4.getClass().getName(), "<filtered>", "<filtered>", 1));
            boolean z = false;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (a(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    z = true;
                } else if (b(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                } else {
                    arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                }
            }
            if (z) {
                th2 = th3 == null ? new Throwable(th4.getMessage()) : new Throwable(th4.getMessage(), th3);
                th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            } else {
                th2 = th3;
            }
            th3 = th2;
        }
        return th3;
    }

    public void a(Throwable th, boolean z) {
        Throwable thB;
        if (a(this.c) && (thB = b(th)) != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(b(thB, z));
            sy.c().a(this.c, this.d.b, arrayList, sy.f().a());
        }
    }

    protected boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("com.google.android.gms.ads") && !str.startsWith("com.google.ads")) {
            try {
                return Class.forName(str).isAnnotationPresent(yx.class);
            } catch (Exception e) {
                su.a("Fail to check class type for class " + str, e);
                return false;
            }
        }
        return true;
    }

    protected boolean a(Throwable th) {
        if (th == null) {
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (a(stackTraceElement.getClassName())) {
                    z2 = true;
                }
                if (getClass().getName().equals(stackTraceElement.getClassName())) {
                    z = true;
                }
            }
            th = th.getCause();
        }
        return z2 && !z;
    }

    String b(Throwable th, boolean z) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter("device", sy.c().c()).appendQueryParameter("js", this.d.b).appendQueryParameter("appid", this.c.getApplicationContext().getPackageName()).appendQueryParameter("stacktrace", stringWriter.toString()).appendQueryParameter("eids", TextUtils.join(",", xb.a())).appendQueryParameter("trapped", String.valueOf(z)).toString();
    }

    protected boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("android.") || str.startsWith("java.");
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (a(th)) {
            if (Looper.getMainLooper().getThread() != thread) {
                a(th, true);
                return;
            }
            a(th, false);
        }
        if (this.a != null) {
            this.a.uncaughtException(thread, th);
        } else if (this.b != null) {
            this.b.uncaughtException(thread, th);
        }
    }
}
