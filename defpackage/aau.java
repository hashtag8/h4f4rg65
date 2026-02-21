package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class aau {
    private static volatile aau a;
    private final Context b;
    private final List<aav> c;
    private final aap d;
    private final a e;
    private volatile aax f;
    private Thread.UncaughtExceptionHandler g;

    class a extends ThreadPoolExecutor {
        public a() {
            super(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            setThreadFactory(new b());
        }

        @Override // java.util.concurrent.AbstractExecutorService
        protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return new FutureTask<T>(runnable, t) { // from class: aau.a.1
                @Override // java.util.concurrent.FutureTask
                protected void setException(Throwable th) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = aau.this.g;
                    if (uncaughtExceptionHandler != null) {
                        uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
                    } else if (Log.isLoggable("GAv4", 6)) {
                        Log.e("GAv4", "MeasurementExecutor: job failed with " + th);
                    }
                    super.setException(th);
                }
            };
        }
    }

    static class b implements ThreadFactory {
        private static final AtomicInteger a = new AtomicInteger();

        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new c(runnable, "measurement-" + a.incrementAndGet());
        }
    }

    static class c extends Thread {
        c(Runnable runnable, String str) {
            super(runnable, str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    aau(Context context) {
        Context applicationContext = context.getApplicationContext();
        vq.a(applicationContext);
        this.b = applicationContext;
        this.e = new a();
        this.c = new CopyOnWriteArrayList();
        this.d = new aap();
    }

    public static aau a(Context context) {
        vq.a(context);
        if (a == null) {
            synchronized (aau.class) {
                if (a == null) {
                    a = new aau(context);
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(aaq aaqVar) {
        vq.c("deliver should be called from worker thread");
        vq.b(aaqVar.f(), "Measurement must be submitted");
        List<aaw> listC = aaqVar.c();
        if (listC.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (aaw aawVar : listC) {
            Uri uriA = aawVar.a();
            if (!hashSet.contains(uriA)) {
                hashSet.add(uriA);
                aawVar.a(aaqVar);
            }
        }
    }

    public static void d() {
        if (!(Thread.currentThread() instanceof c)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public aax a() {
        if (this.f == null) {
            synchronized (this) {
                if (this.f == null) {
                    aax aaxVar = new aax();
                    PackageManager packageManager = this.b.getPackageManager();
                    String packageName = this.b.getPackageName();
                    aaxVar.c(packageName);
                    aaxVar.d(packageManager.getInstallerPackageName(packageName));
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.b.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        Log.e("GAv4", "Error retrieving package info: appName set to " + packageName);
                    }
                    aaxVar.a(packageName);
                    aaxVar.b(str);
                    this.f = aaxVar;
                }
            }
        }
        return this.f;
    }

    public <V> Future<V> a(Callable<V> callable) {
        vq.a(callable);
        if (!(Thread.currentThread() instanceof c)) {
            return this.e.submit(callable);
        }
        FutureTask futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    void a(aaq aaqVar) {
        if (aaqVar.j()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        }
        if (aaqVar.f()) {
            throw new IllegalStateException("Measurement can only be submitted once");
        }
        final aaq aaqVarA = aaqVar.a();
        aaqVarA.g();
        this.e.execute(new Runnable() { // from class: aau.1
            @Override // java.lang.Runnable
            public void run() {
                aaqVarA.h().a(aaqVarA);
                Iterator it = aau.this.c.iterator();
                while (it.hasNext()) {
                    ((aav) it.next()).a(aaqVarA);
                }
                aau.this.b(aaqVarA);
            }
        });
    }

    public void a(Runnable runnable) {
        vq.a(runnable);
        this.e.submit(runnable);
    }

    public void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.g = uncaughtExceptionHandler;
    }

    public aaz b() {
        DisplayMetrics displayMetrics = this.b.getResources().getDisplayMetrics();
        aaz aazVar = new aaz();
        aazVar.a(tz.a(Locale.getDefault()));
        aazVar.b(displayMetrics.widthPixels);
        aazVar.c(displayMetrics.heightPixels);
        return aazVar;
    }

    public Context c() {
        return this.b;
    }
}
