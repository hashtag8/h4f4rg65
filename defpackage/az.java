package defpackage;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class az extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    int a = 0;
    int b = 0;
    boolean c = true;
    boolean d = true;
    int e = -1;
    Dialog f;
    boolean g;
    boolean h;
    boolean i;

    public void a(int i, int i2) {
        this.a = i;
        if (this.a == 2 || this.a == 3) {
            this.b = R.style.Theme.Panel;
        }
        if (i2 != 0) {
            this.b = i2;
        }
    }

    public void a(be beVar, String str) {
        this.h = false;
        this.i = true;
        bj bjVarA = beVar.a();
        bjVarA.a(this, str);
        bjVarA.d();
    }

    public int a(bj bjVar, String str) {
        this.h = false;
        this.i = true;
        bjVar.a(this, str);
        this.g = false;
        this.e = bjVar.d();
        return this.e;
    }

    public void b() {
        a(false);
    }

    public void c() {
        a(true);
    }

    void a(boolean z) {
        if (!this.h) {
            this.h = true;
            this.i = false;
            if (this.f != null) {
                this.f.dismiss();
                this.f = null;
            }
            this.g = true;
            if (this.e >= 0) {
                r().a(this.e, 1);
                this.e = -1;
                return;
            }
            bj bjVarA = r().a();
            bjVarA.a(this);
            if (z) {
                bjVarA.e();
            } else {
                bjVarA.d();
            }
        }
    }

    public Dialog d() {
        return this.f;
    }

    public int e() {
        return this.b;
    }

    public void b(boolean z) {
        this.c = z;
        if (this.f != null) {
            this.f.setCancelable(z);
        }
    }

    public void c(boolean z) {
        this.d = z;
    }

    @Override // android.support.v4.app.Fragment
    public void a(Context context) {
        super.a(context);
        if (!this.i) {
            this.h = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void f() {
        super.f();
        if (!this.i && !this.h) {
            this.h = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.d = this.G == 0;
        if (bundle != null) {
            this.a = bundle.getInt("android:style", 0);
            this.b = bundle.getInt("android:theme", 0);
            this.c = bundle.getBoolean("android:cancelable", true);
            this.d = bundle.getBoolean("android:showsDialog", this.d);
            this.e = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public LayoutInflater b(Bundle bundle) {
        if (!this.d) {
            return super.b(bundle);
        }
        this.f = c(bundle);
        if (this.f != null) {
            a(this.f, this.a);
            return (LayoutInflater) this.f.getContext().getSystemService("layout_inflater");
        }
        return (LayoutInflater) this.B.g().getSystemService("layout_inflater");
    }

    public void a(Dialog dialog, int i) {
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                dialog.getWindow().addFlags(24);
                break;
            default:
                return;
        }
        dialog.requestWindowFeature(1);
    }

    public Dialog c(Bundle bundle) {
        return new Dialog(p(), e());
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.g) {
            a(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        Bundle bundle2;
        super.d(bundle);
        if (this.d) {
            View viewB = B();
            if (viewB != null) {
                if (viewB.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f.setContentView(viewB);
            }
            ba baVarP = p();
            if (baVarP != null) {
                this.f.setOwnerActivity(baVarP);
            }
            this.f.setCancelable(this.c);
            this.f.setOnCancelListener(this);
            this.f.setOnDismissListener(this);
            if (bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
                this.f.onRestoreInstanceState(bundle2);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void g() {
        super.g();
        if (this.f != null) {
            this.g = false;
            this.f.show();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void e(Bundle bundle) {
        Bundle bundleOnSaveInstanceState;
        super.e(bundle);
        if (this.f != null && (bundleOnSaveInstanceState = this.f.onSaveInstanceState()) != null) {
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        if (this.a != 0) {
            bundle.putInt("android:style", this.a);
        }
        if (this.b != 0) {
            bundle.putInt("android:theme", this.b);
        }
        if (!this.c) {
            bundle.putBoolean("android:cancelable", this.c);
        }
        if (!this.d) {
            bundle.putBoolean("android:showsDialog", this.d);
        }
        if (this.e != -1) {
            bundle.putInt("android:backStackId", this.e);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void h() {
        super.h();
        if (this.f != null) {
            this.f.hide();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void i() {
        super.i();
        if (this.f != null) {
            this.g = true;
            this.f.dismiss();
            this.f = null;
        }
    }
}
