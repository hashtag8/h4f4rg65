package defpackage;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import defpackage.hh;
import java.lang.Thread;

/* JADX INFO: loaded from: classes.dex */
abstract class gn extends gm {
    private static boolean m;
    private static final boolean n;
    private static final int[] o;
    final Context a;
    final Window b;
    final Window.Callback c;
    final Window.Callback d;
    final gl e;
    gi f;
    MenuInflater g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    private CharSequence p;
    private boolean q;
    private boolean r;

    abstract hh a(hh.a aVar);

    abstract void a(int i, Menu menu);

    abstract boolean a(int i, KeyEvent keyEvent);

    abstract boolean a(KeyEvent keyEvent);

    abstract void b(CharSequence charSequence);

    abstract boolean b(int i, Menu menu);

    abstract void l();

    static {
        n = Build.VERSION.SDK_INT < 21;
        if (n && !m) {
            final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: gn.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    if (a(th)) {
                        Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }

                private boolean a(Throwable th) {
                    String message;
                    if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                        return false;
                    }
                    return message.contains("drawable") || message.contains("Drawable");
                }
            });
            m = true;
        }
        o = new int[]{R.attr.windowBackground};
    }

    gn(Context context, Window window, gl glVar) {
        this.a = context;
        this.b = window;
        this.e = glVar;
        this.c = this.b.getCallback();
        if (this.c instanceof a) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.d = a(this.c);
        this.b.setCallback(this.d);
        ks ksVarA = ks.a(context, (AttributeSet) null, o);
        Drawable drawableB = ksVarA.b(0);
        if (drawableB != null) {
            this.b.setBackgroundDrawable(drawableB);
        }
        ksVarA.a();
    }

    Window.Callback a(Window.Callback callback) {
        return new a(callback);
    }

    @Override // defpackage.gm
    public gi a() {
        l();
        return this.f;
    }

    final gi m() {
        return this.f;
    }

    @Override // defpackage.gm
    public MenuInflater b() {
        if (this.g == null) {
            l();
            this.g = new hm(this.f != null ? this.f.c() : this.a);
        }
        return this.g;
    }

    final Context n() {
        Context contextC = null;
        gi giVarA = a();
        if (giVarA != null) {
            contextC = giVarA.c();
        }
        if (contextC == null) {
            return this.a;
        }
        return contextC;
    }

    @Override // defpackage.gm
    public void c() {
        this.q = true;
    }

    @Override // defpackage.gm
    public void d() {
        this.q = false;
    }

    @Override // defpackage.gm
    public void g() {
        this.r = true;
    }

    public boolean o() {
        return false;
    }

    @Override // defpackage.gm
    public boolean i() {
        return false;
    }

    final boolean p() {
        return this.r;
    }

    final Window.Callback q() {
        return this.b.getCallback();
    }

    @Override // defpackage.gm
    public final void a(CharSequence charSequence) {
        this.p = charSequence;
        b(charSequence);
    }

    @Override // defpackage.gm
    public void c(Bundle bundle) {
    }

    final CharSequence r() {
        return this.c instanceof Activity ? ((Activity) this.c).getTitle() : this.p;
    }

    class a extends ho {
        a(Window.Callback callback) {
            super(callback);
        }

        @Override // defpackage.ho, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return gn.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // defpackage.ho, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || gn.this.a(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // defpackage.ho, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof hw)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // defpackage.ho, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // defpackage.ho, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            hw hwVar = menu instanceof hw ? (hw) menu : null;
            if (i == 0 && hwVar == null) {
                return false;
            }
            if (hwVar != null) {
                hwVar.c(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(i, view, menu);
            if (hwVar != null) {
                hwVar.c(false);
                return zOnPreparePanel;
            }
            return zOnPreparePanel;
        }

        @Override // defpackage.ho, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            gn.this.b(i, menu);
            return true;
        }

        @Override // defpackage.ho, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            gn.this.a(i, menu);
        }
    }
}
