package defpackage;

import android.os.Bundle;
import android.support.v8.renderscript.Allocation;
import android.util.Log;
import defpackage.bm;
import defpackage.cj;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
public class bn extends bm {
    static boolean a = false;
    final eh<a> b = new eh<>();
    final eh<a> c = new eh<>();
    final String d;
    boolean e;
    boolean f;
    bd g;

    final class a implements cj.a<Object>, cj.b<Object> {
        final int a;
        final Bundle b;
        bm.a<Object> c;
        cj<Object> d;
        boolean e;
        boolean f;
        Object g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        a n;
        final /* synthetic */ bn o;

        void a() {
            if (this.i && this.j) {
                this.h = true;
                return;
            }
            if (!this.h) {
                this.h = true;
                if (bn.a) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.d == null && this.c != null) {
                    this.d = this.c.a(this.a, this.b);
                }
                if (this.d != null) {
                    if (this.d.getClass().isMemberClass() && !Modifier.isStatic(this.d.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.d);
                    }
                    if (!this.m) {
                        this.d.a(this.a, this);
                        this.d.a((cj.a<Object>) this);
                        this.m = true;
                    }
                    this.d.a();
                }
            }
        }

        void b() {
            if (bn.a) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.i = true;
            this.j = this.h;
            this.h = false;
            this.c = null;
        }

        void c() {
            if (this.i) {
                if (bn.a) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.i = false;
                if (this.h != this.j && !this.h) {
                    e();
                }
            }
            if (this.h && this.e && !this.k) {
                a(this.d, this.g);
            }
        }

        void d() {
            if (this.h && this.k) {
                this.k = false;
                if (this.e && !this.i) {
                    a(this.d, this.g);
                }
            }
        }

        void e() {
            if (bn.a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.h = false;
            if (!this.i && this.d != null && this.m) {
                this.m = false;
                this.d.a((cj.b<Object>) this);
                this.d.b(this);
                this.d.c();
            }
        }

        void f() {
            String str;
            if (bn.a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.l = true;
            boolean z = this.f;
            this.f = false;
            if (this.c != null && this.d != null && this.e && z) {
                if (bn.a) {
                    Log.v("LoaderManager", "  Resetting: " + this);
                }
                if (this.o.g != null) {
                    String str2 = this.o.g.d.u;
                    this.o.g.d.u = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.c.a(this.d);
                } finally {
                    if (this.o.g != null) {
                        this.o.g.d.u = str;
                    }
                }
            }
            this.c = null;
            this.g = null;
            this.e = false;
            if (this.d != null) {
                if (this.m) {
                    this.m = false;
                    this.d.a((cj.b<Object>) this);
                    this.d.b(this);
                }
                this.d.e();
            }
            if (this.n != null) {
                this.n.f();
            }
        }

        void a(cj<Object> cjVar, Object obj) {
            String str;
            if (this.c != null) {
                if (this.o.g == null) {
                    str = null;
                } else {
                    String str2 = this.o.g.d.u;
                    this.o.g.d.u = "onLoadFinished";
                    str = str2;
                }
                try {
                    if (bn.a) {
                        Log.v("LoaderManager", "  onLoadFinished in " + cjVar + ": " + cjVar.a(obj));
                    }
                    this.c.a(cjVar, obj);
                    this.f = true;
                } finally {
                    if (this.o.g != null) {
                        this.o.g.d.u = str;
                    }
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.a);
            sb.append(" : ");
            dx.a(this.d, sb);
            sb.append("}}");
            return sb.toString();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.a);
            printWriter.print(" mArgs=");
            printWriter.println(this.b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.d);
            if (this.d != null) {
                this.d.a(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.e || this.f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.m);
            if (this.n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.n);
                printWriter.println(":");
                this.n.a(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    bn(String str, bd bdVar, boolean z) {
        this.d = str;
        this.g = bdVar;
        this.e = z;
    }

    void a(bd bdVar) {
        this.g = bdVar;
    }

    public void b() {
        if (a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
        } else {
            this.e = true;
            for (int iB = this.b.b() - 1; iB >= 0; iB--) {
                this.b.e(iB).a();
            }
        }
    }

    public void c() {
        if (a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (!this.e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
        } else {
            for (int iB = this.b.b() - 1; iB >= 0; iB--) {
                this.b.e(iB).e();
            }
            this.e = false;
        }
    }

    public void d() {
        if (a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (!this.e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
        } else {
            this.f = true;
            this.e = false;
            for (int iB = this.b.b() - 1; iB >= 0; iB--) {
                this.b.e(iB).b();
            }
        }
    }

    void e() {
        if (this.f) {
            if (a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f = false;
            for (int iB = this.b.b() - 1; iB >= 0; iB--) {
                this.b.e(iB).c();
            }
        }
    }

    public void f() {
        for (int iB = this.b.b() - 1; iB >= 0; iB--) {
            this.b.e(iB).k = true;
        }
    }

    public void g() {
        for (int iB = this.b.b() - 1; iB >= 0; iB--) {
            this.b.e(iB).d();
        }
    }

    public void h() {
        if (!this.f) {
            if (a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int iB = this.b.b() - 1; iB >= 0; iB--) {
                this.b.e(iB).f();
            }
            this.b.c();
        }
        if (a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int iB2 = this.c.b() - 1; iB2 >= 0; iB2--) {
            this.c.e(iB2).f();
        }
        this.c.c();
        this.g = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(Allocation.USAGE_SHARED);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        dx.a(this.g, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.b.b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.b.b(); i++) {
                a aVarE = this.b.e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.b.d(i));
                printWriter.print(": ");
                printWriter.println(aVarE.toString());
                aVarE.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.c.b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.c.b(); i2++) {
                a aVarE2 = this.c.e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.c.d(i2));
                printWriter.print(": ");
                printWriter.println(aVarE2.toString());
                aVarE2.a(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // defpackage.bm
    public boolean a() {
        int iB = this.b.b();
        boolean z = false;
        for (int i = 0; i < iB; i++) {
            a aVarE = this.b.e(i);
            z |= aVarE.h && !aVarE.f;
        }
        return z;
    }
}
