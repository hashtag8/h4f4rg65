package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.harman.hkconnect.R;
import com.harman.hkconnect.setup.newpage.info.RoomItem;

/* JADX INFO: loaded from: classes.dex */
public class aoj extends ajk {
    private aoi a;
    private aoi b;
    private b d;
    private boolean c = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = true;
    private boolean h = true;
    private boolean i = false;

    public enum a {
        PAGE_TYPE,
        FIRST_PAGE
    }

    public interface b {
        Animation a(aoi aoiVar, boolean z);

        void a(adz adzVar);

        void a(Animation animation, aoi aoiVar, boolean z);

        void a(ImageView imageView);

        void a(ImageView imageView, RelativeLayout.LayoutParams layoutParams);

        void a(aoi aoiVar, Bundle bundle);

        void a(aoi aoiVar, aoi aoiVar2, boolean z);

        void a(RoomItem roomItem);

        void b(Animation animation, aoi aoiVar, boolean z);

        void b(String str);

        void b(boolean z);

        void c(String str);

        void c(boolean z);

        void d(int i);

        void d(String str);

        void d(boolean z);

        void e(int i);

        void e(boolean z);

        void f(int i);

        void f(boolean z);

        void g(int i);

        void g(boolean z);

        void h(boolean z);

        void i(boolean z);

        void l();

        adz m();

        RoomItem n();

        int o();

        int p();

        boolean q();

        boolean r();

        boolean s();
    }

    protected b an() {
        return this.d;
    }

    public boolean ao() {
        return this.c;
    }

    public void ap() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.d = (b) activity;
    }

    @Override // android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        brw.a(l(), "arguments %s", this);
        this.a = (aoi) l().getSerializable(a.FIRST_PAGE.name());
        this.b = (aoi) l().getSerializable(a.PAGE_TYPE.name());
    }

    @Override // android.support.v4.app.Fragment
    public void a(View view, Bundle bundle) {
        super.a(view, bundle);
    }

    @Override // defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        if (!z) {
            this.d.b(this.f);
            this.d.c(this.e);
            this.d.e(this.g);
            this.d.f(this.h);
            this.d.g(this.i);
            b();
            return;
        }
        c();
    }

    protected void b() {
        this.c = true;
        mm.b();
    }

    protected void c() {
        this.c = false;
        mm.b();
    }

    public void aq() {
    }

    protected void a(boolean z) {
        this.e = z;
        this.d.c(z);
    }

    protected void b(boolean z) {
        this.g = z;
    }

    protected void c(boolean z) {
        this.h = z;
    }

    protected void l(boolean z) {
        this.i = z;
    }

    protected void m(boolean z) {
        this.f = z;
    }

    public void e() {
    }

    public void d() {
    }

    public void al() {
    }

    @Override // defpackage.ajk
    public String av() {
        return getClass().getName();
    }

    public aoi ar() {
        return this.a;
    }

    public aoi as() {
        return this.b;
    }

    @Override // android.support.v4.app.Fragment
    public Animation a(int i, final boolean z, int i2) {
        if (i2 == 0) {
            return null;
        }
        Animation animationA = this.d.a(as(), z);
        if (animationA == null) {
            animationA = AnimationUtils.loadAnimation(p(), i2);
        }
        animationA.setAnimationListener(new Animation.AnimationListener() { // from class: aoj.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                aoj.this.d.a(animation, aoj.this.b, z);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                aoj.this.d.b(animation, aoj.this.b, z);
                if (z) {
                    aoj.this.aq();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        return animationA;
    }

    protected Dialog b(Context context) {
        Dialog dialog = new Dialog(context, R.style.CustomDialogTheme);
        dialog.setContentView(R.layout.dialog_loader);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().gravity = 17;
        return dialog;
    }

    protected void a(Dialog dialog, Context context) {
        if (dialog != null && !dialog.isShowing() && context != null) {
            dialog.show();
        }
    }

    protected void b(Dialog dialog, Context context) {
        if (dialog != null && dialog.isShowing() && context != null) {
            dialog.dismiss();
        }
    }
}
