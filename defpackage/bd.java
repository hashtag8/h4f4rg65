package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class bd<E> extends bb {
    private final Activity a;
    final Context b;
    final int c;
    public final bf d;
    private final Handler e;
    private eg<String, bm> f;
    private boolean g;
    private bn h;
    private boolean i;
    private boolean j;

    bd(ba baVar) {
        this(baVar, baVar, baVar.c, 0);
    }

    bd(Activity activity, Context context, Handler handler, int i) {
        this.d = new bf();
        this.a = activity;
        this.b = context;
        this.e = handler;
        this.c = i;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean a(Fragment fragment) {
        return true;
    }

    public LayoutInflater b() {
        return (LayoutInflater) this.b.getSystemService("layout_inflater");
    }

    public void c() {
    }

    public void a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.b.startActivity(intent);
    }

    public void a(Fragment fragment, String[] strArr, int i) {
    }

    public boolean d() {
        return true;
    }

    public int e() {
        return this.c;
    }

    @Override // defpackage.bb
    public View a(int i) {
        return null;
    }

    @Override // defpackage.bb
    public boolean a() {
        return true;
    }

    public Activity f() {
        return this.a;
    }

    public Context g() {
        return this.b;
    }

    public Handler h() {
        return this.e;
    }

    bf i() {
        return this.d;
    }

    void a(String str) {
        bn bnVar;
        if (this.f != null && (bnVar = (bn) this.f.get(str)) != null && !bnVar.f) {
            bnVar.h();
            this.f.remove(str);
        }
    }

    void b(Fragment fragment) {
    }

    public boolean j() {
        return this.g;
    }

    void k() {
        if (!this.j) {
            this.j = true;
            if (this.h != null) {
                this.h.b();
            } else if (!this.i) {
                this.h = a("(root)", this.j, false);
                if (this.h != null && !this.h.e) {
                    this.h.b();
                }
            }
            this.i = true;
        }
    }

    void a(boolean z) {
        this.g = z;
        if (this.h != null && this.j) {
            this.j = false;
            if (z) {
                this.h.d();
            } else {
                this.h.c();
            }
        }
    }

    void l() {
        if (this.h != null) {
            this.h.h();
        }
    }

    void m() {
        if (this.f != null) {
            int size = this.f.size();
            bn[] bnVarArr = new bn[size];
            for (int i = size - 1; i >= 0; i--) {
                bnVarArr[i] = (bn) this.f.c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                bn bnVar = bnVarArr[i2];
                bnVar.e();
                bnVar.g();
            }
        }
    }

    public bn a(String str, boolean z, boolean z2) {
        if (this.f == null) {
            this.f = new eg<>();
        }
        bn bnVar = (bn) this.f.get(str);
        if (bnVar == null && z2) {
            bn bnVar2 = new bn(str, this, z);
            this.f.put(str, bnVar2);
            return bnVar2;
        }
        if (z && bnVar != null && !bnVar.e) {
            bnVar.b();
            return bnVar;
        }
        return bnVar;
    }

    eg<String, bm> n() {
        boolean z;
        if (this.f != null) {
            int size = this.f.size();
            bn[] bnVarArr = new bn[size];
            for (int i = size - 1; i >= 0; i--) {
                bnVarArr[i] = (bn) this.f.c(i);
            }
            boolean zJ = j();
            z = false;
            for (int i2 = 0; i2 < size; i2++) {
                bn bnVar = bnVarArr[i2];
                if (!bnVar.f && zJ) {
                    if (!bnVar.e) {
                        bnVar.b();
                    }
                    bnVar.d();
                }
                if (bnVar.f) {
                    z = true;
                } else {
                    bnVar.h();
                    this.f.remove(bnVar.d);
                }
            }
        } else {
            z = false;
        }
        if (z) {
            return this.f;
        }
        return null;
    }

    void a(eg<String, bm> egVar) {
        if (egVar != null) {
            int size = egVar.size();
            for (int i = 0; i < size; i++) {
                ((bn) egVar.c(i)).a(this);
            }
        }
        this.f = egVar;
    }

    void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.j);
        if (this.h != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.h)));
            printWriter.println(":");
            this.h.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
