package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import defpackage.blf;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class blh {
    static volatile blh a;
    static final blq b = new blg();
    final blq c;
    final boolean d;
    private final Context e;
    private final Map<Class<? extends bln>, bln> f;
    private final ExecutorService g;
    private final Handler h;
    private final blk<blh> i;
    private final blk<?> j;
    private final bml k;
    private blf l;
    private WeakReference<Activity> m;
    private AtomicBoolean n = new AtomicBoolean(false);

    public static class a {
        private final Context a;
        private bln[] b;
        private bnb c;
        private Handler d;
        private blq e;
        private boolean f;
        private String g;
        private String h;
        private blk<blh> i;

        public a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.a = context;
        }

        public a a(bln... blnVarArr) {
            if (this.b != null) {
                throw new IllegalStateException("Kits already set.");
            }
            this.b = blnVarArr;
            return this;
        }

        public blh a() {
            Map mapB;
            if (this.c == null) {
                this.c = bnb.a();
            }
            if (this.d == null) {
                this.d = new Handler(Looper.getMainLooper());
            }
            if (this.e == null) {
                if (this.f) {
                    this.e = new blg(3);
                } else {
                    this.e = new blg();
                }
            }
            if (this.h == null) {
                this.h = this.a.getPackageName();
            }
            if (this.i == null) {
                this.i = blk.d;
            }
            if (this.b != null) {
                mapB = blh.b(Arrays.asList(this.b));
            } else {
                mapB = new HashMap();
            }
            Context applicationContext = this.a.getApplicationContext();
            return new blh(applicationContext, mapB, this.c, this.d, this.e, this.f, this.i, new bml(applicationContext, this.h, this.g, mapB.values()), blh.d(this.a));
        }
    }

    static blh a() {
        if (a == null) {
            throw new IllegalStateException("Must Initialize Fabric before using singleton()");
        }
        return a;
    }

    blh(Context context, Map<Class<? extends bln>, bln> map, bnb bnbVar, Handler handler, blq blqVar, boolean z, blk blkVar, bml bmlVar, Activity activity) {
        this.e = context;
        this.f = map;
        this.g = bnbVar;
        this.h = handler;
        this.c = blqVar;
        this.d = z;
        this.i = blkVar;
        this.j = a(map.size());
        this.k = bmlVar;
        a(activity);
    }

    public static blh a(Context context, bln... blnVarArr) {
        if (a == null) {
            synchronized (blh.class) {
                if (a == null) {
                    c(new a(context).a(blnVarArr).a());
                }
            }
        }
        return a;
    }

    private static void c(blh blhVar) {
        a = blhVar;
        blhVar.j();
    }

    public blh a(Activity activity) {
        this.m = new WeakReference<>(activity);
        return this;
    }

    public Activity b() {
        if (this.m != null) {
            return this.m.get();
        }
        return null;
    }

    private void j() {
        this.l = new blf(this.e);
        this.l.a(new blf.b() { // from class: blh.1
            @Override // blf.b
            public void a(Activity activity, Bundle bundle) {
                blh.this.a(activity);
            }

            @Override // blf.b
            public void a(Activity activity) {
                blh.this.a(activity);
            }

            @Override // blf.b
            public void b(Activity activity) {
                blh.this.a(activity);
            }
        });
        a(this.e);
    }

    public String c() {
        return "1.4.2.22";
    }

    public String d() {
        return "io.fabric.sdk.android:fabric";
    }

    void a(Context context) {
        StringBuilder sbAppend;
        Future<Map<String, blp>> futureB = b(context);
        Collection<bln> collectionG = g();
        blr blrVar = new blr(futureB, collectionG);
        ArrayList<bln> arrayList = new ArrayList(collectionG);
        Collections.sort(arrayList);
        blrVar.a(context, this, blk.d, this.k);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((bln) it.next()).a(context, this, this.j, this.k);
        }
        blrVar.p();
        if (h().a("Fabric", 3)) {
            sbAppend = new StringBuilder("Initializing ").append(d()).append(" [Version: ").append(c()).append("], with the following kits:\n");
        } else {
            sbAppend = null;
        }
        for (bln blnVar : arrayList) {
            blnVar.f.c(blrVar.f);
            a(this.f, blnVar);
            blnVar.p();
            if (sbAppend != null) {
                sbAppend.append(blnVar.b()).append(" [Version: ").append(blnVar.a()).append("]\n");
            }
        }
        if (sbAppend != null) {
            h().a("Fabric", sbAppend.toString());
        }
    }

    void a(Map<Class<? extends bln>, bln> map, bln blnVar) {
        bmu bmuVar = blnVar.j;
        if (bmuVar != null) {
            for (Class<?> cls : bmuVar.a()) {
                if (cls.isInterface()) {
                    for (bln blnVar2 : map.values()) {
                        if (cls.isAssignableFrom(blnVar2.getClass())) {
                            blnVar.f.c(blnVar2.f);
                        }
                    }
                } else {
                    if (map.get(cls) == null) {
                        throw new bnd("Referenced Kit was null, does the kit exist?");
                    }
                    blnVar.f.c(map.get(cls).f);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Activity d(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public blf e() {
        return this.l;
    }

    public ExecutorService f() {
        return this.g;
    }

    public Collection<bln> g() {
        return this.f.values();
    }

    public static <T extends bln> T a(Class<T> cls) {
        return (T) a().f.get(cls);
    }

    public static blq h() {
        return a == null ? b : a.c;
    }

    public static boolean i() {
        if (a == null) {
            return false;
        }
        return a.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<Class<? extends bln>, bln> b(Collection<? extends bln> collection) {
        HashMap map = new HashMap(collection.size());
        a(map, collection);
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void a(Map<Class<? extends bln>, bln> map, Collection<? extends bln> collection) {
        for (Object obj : collection) {
            map.put(obj.getClass(), obj);
            if (obj instanceof blo) {
                a(map, ((blo) obj).c());
            }
        }
    }

    blk<?> a(final int i) {
        return new blk() { // from class: blh.2
            final CountDownLatch a;

            {
                this.a = new CountDownLatch(i);
            }

            @Override // defpackage.blk
            public void a(Object obj) {
                this.a.countDown();
                if (this.a.getCount() == 0) {
                    blh.this.n.set(true);
                    blh.this.i.a(blh.this);
                }
            }

            @Override // defpackage.blk
            public void a(Exception exc) {
                blh.this.i.a(exc);
            }
        };
    }

    Future<Map<String, blp>> b(Context context) {
        return f().submit(new blj(context.getPackageCodePath()));
    }
}
