package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.Toolbar;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import defpackage.gi;
import defpackage.hw;
import defpackage.id;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class gw extends gi {
    jq a;
    boolean b;
    Window.Callback c;
    private boolean d;
    private boolean e;
    private ArrayList<gi.b> f = new ArrayList<>();
    private final Runnable g = new Runnable() { // from class: gw.1
        @Override // java.lang.Runnable
        public void run() {
            gw.this.j();
        }
    };
    private final Toolbar.c h = new Toolbar.c() { // from class: gw.2
        @Override // android.support.v7.widget.Toolbar.c
        public boolean a(MenuItem menuItem) {
            return gw.this.c.onMenuItemSelected(0, menuItem);
        }
    };

    gw(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.a = new kt(toolbar, false);
        this.c = new c(callback);
        this.a.a(this.c);
        toolbar.setOnMenuItemClickListener(this.h);
        this.a.a(charSequence);
    }

    public Window.Callback i() {
        return this.c;
    }

    @Override // defpackage.gi
    public void d(boolean z) {
    }

    @Override // defpackage.gi
    public void a(float f) {
        fb.a(this.a.a(), f);
    }

    @Override // defpackage.gi
    public Context c() {
        return this.a.b();
    }

    @Override // defpackage.gi
    public void f(boolean z) {
    }

    @Override // defpackage.gi
    public void g(boolean z) {
    }

    @Override // defpackage.gi
    public void a(Configuration configuration) {
        super.a(configuration);
    }

    @Override // defpackage.gi
    public void a(CharSequence charSequence) {
        this.a.b(charSequence);
    }

    @Override // defpackage.gi
    public void b(CharSequence charSequence) {
        this.a.a(charSequence);
    }

    public void a(int i, int i2) {
        this.a.c((this.a.o() & (i2 ^ (-1))) | (i & i2));
    }

    @Override // defpackage.gi
    public void a(boolean z) {
        a(z ? 1 : 0, 1);
    }

    @Override // defpackage.gi
    public void b(boolean z) {
        a(z ? 8 : 0, 8);
    }

    @Override // defpackage.gi
    public void c(boolean z) {
        a(z ? 16 : 0, 16);
    }

    @Override // defpackage.gi
    public View a() {
        return this.a.q();
    }

    @Override // defpackage.gi
    public int b() {
        return this.a.o();
    }

    @Override // defpackage.gi
    public boolean d() {
        return this.a.k();
    }

    @Override // defpackage.gi
    public boolean e() {
        return this.a.l();
    }

    @Override // defpackage.gi
    public boolean f() {
        this.a.a().removeCallbacks(this.g);
        fb.a(this.a.a(), this.g);
        return true;
    }

    @Override // defpackage.gi
    public boolean g() {
        if (!this.a.c()) {
            return false;
        }
        this.a.d();
        return true;
    }

    void j() {
        Menu menuK = k();
        hw hwVar = menuK instanceof hw ? (hw) menuK : null;
        if (hwVar != null) {
            hwVar.g();
        }
        try {
            menuK.clear();
            if (!this.c.onCreatePanelMenu(0, menuK) || !this.c.onPreparePanel(0, null, menuK)) {
                menuK.clear();
            }
        } finally {
            if (hwVar != null) {
                hwVar.h();
            }
        }
    }

    @Override // defpackage.gi
    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            d();
        }
        return true;
    }

    @Override // defpackage.gi
    public boolean a(int i, KeyEvent keyEvent) {
        Menu menuK = k();
        if (menuK == null) {
            return false;
        }
        menuK.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuK.performShortcut(i, keyEvent, 0);
    }

    @Override // defpackage.gi
    void h() {
        this.a.a().removeCallbacks(this.g);
    }

    @Override // defpackage.gi
    public void h(boolean z) {
        if (z != this.e) {
            this.e = z;
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.get(i).a(z);
            }
        }
    }

    class c extends ho {
        public c(Window.Callback callback) {
            super(callback);
        }

        @Override // defpackage.ho, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean zOnPreparePanel = super.onPreparePanel(i, view, menu);
            if (zOnPreparePanel && !gw.this.b) {
                gw.this.a.m();
                gw.this.b = true;
            }
            return zOnPreparePanel;
        }

        @Override // defpackage.ho, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            return i == 0 ? new View(gw.this.a.b()) : super.onCreatePanelView(i);
        }
    }

    private Menu k() {
        if (!this.d) {
            this.a.a(new a(), new b());
            this.d = true;
        }
        return this.a.r();
    }

    final class a implements id.a {
        private boolean b;

        a() {
        }

        @Override // id.a
        public boolean a(hw hwVar) {
            if (gw.this.c == null) {
                return false;
            }
            gw.this.c.onMenuOpened(108, hwVar);
            return true;
        }

        @Override // id.a
        public void a(hw hwVar, boolean z) {
            if (!this.b) {
                this.b = true;
                gw.this.a.n();
                if (gw.this.c != null) {
                    gw.this.c.onPanelClosed(108, hwVar);
                }
                this.b = false;
            }
        }
    }

    final class b implements hw.a {
        b() {
        }

        @Override // hw.a
        public boolean a(hw hwVar, MenuItem menuItem) {
            return false;
        }

        @Override // hw.a
        public void a(hw hwVar) {
            if (gw.this.c != null) {
                if (gw.this.a.i()) {
                    gw.this.c.onPanelClosed(108, hwVar);
                } else if (gw.this.c.onPreparePanel(0, null, hwVar)) {
                    gw.this.c.onMenuOpened(108, hwVar);
                }
            }
        }
    }
}
