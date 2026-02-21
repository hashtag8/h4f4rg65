package defpackage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ActionMode;
import android.view.Window;
import defpackage.gn;
import defpackage.hl;

/* JADX INFO: loaded from: classes.dex */
class gq extends gp {
    private int t;
    private boolean u;
    private boolean v;
    private b w;

    gq(Context context, Window window, gl glVar) {
        super(context, window, glVar);
        this.t = -100;
        this.v = true;
    }

    @Override // defpackage.gs, defpackage.gm
    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle != null && this.t == -100) {
            this.t = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    @Override // defpackage.gn
    Window.Callback a(Window.Callback callback) {
        return new a(callback);
    }

    @Override // defpackage.gn
    public boolean o() {
        return this.v;
    }

    @Override // defpackage.gn, defpackage.gm
    public boolean i() {
        boolean zH = false;
        int iW = w();
        int iD = d(iW);
        if (iD != -1) {
            zH = h(iD);
        }
        if (iW == 0) {
            x();
            this.w.c();
        }
        this.u = true;
        return zH;
    }

    @Override // defpackage.gn, defpackage.gm
    public void c() {
        super.c();
        i();
    }

    @Override // defpackage.gs, defpackage.gn, defpackage.gm
    public void d() {
        super.d();
        if (this.w != null) {
            this.w.d();
        }
    }

    int d(int i) {
        switch (i) {
            case -100:
                return -1;
            case 0:
                x();
                return this.w.a();
            default:
                return i;
        }
    }

    private int w() {
        return this.t != -100 ? this.t : j();
    }

    @Override // defpackage.gn, defpackage.gm
    public void c(Bundle bundle) {
        super.c(bundle);
        if (this.t != -100) {
            bundle.putInt("appcompat:local_night_mode", this.t);
        }
    }

    @Override // defpackage.gs, defpackage.gn, defpackage.gm
    public void g() {
        super.g();
        if (this.w != null) {
            this.w.d();
        }
    }

    private boolean h(int i) {
        Resources resources = this.a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 != i3) {
            if (y()) {
                ((Activity) this.a).recreate();
            } else {
                Configuration configuration2 = new Configuration(configuration);
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
                resources.updateConfiguration(configuration2, displayMetrics);
                if (Build.VERSION.SDK_INT < 26) {
                    gv.a(resources);
                }
            }
            return true;
        }
        return false;
    }

    private void x() {
        if (this.w == null) {
            this.w = new b(gy.a(this.a));
        }
    }

    private boolean y() {
        if (!this.u || !(this.a instanceof Activity)) {
            return false;
        }
        try {
            return (this.a.getPackageManager().getActivityInfo(new ComponentName(this.a, this.a.getClass()), 0).configChanges & 512) == 0;
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
            return true;
        }
    }

    class a extends gn.a {
        a(Window.Callback callback) {
            super(callback);
        }

        @Override // defpackage.ho, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return gq.this.o() ? a(callback) : super.onWindowStartingActionMode(callback);
        }

        final ActionMode a(ActionMode.Callback callback) {
            hl.a aVar = new hl.a(gq.this.a, callback);
            hh hhVarB = gq.this.b(aVar);
            if (hhVarB != null) {
                return aVar.b(hhVarB);
            }
            return null;
        }
    }

    final class b {
        private gy b;
        private boolean c;
        private BroadcastReceiver d;
        private IntentFilter e;

        b(gy gyVar) {
            this.b = gyVar;
            this.c = gyVar.a();
        }

        final int a() {
            this.c = this.b.a();
            return this.c ? 2 : 1;
        }

        final void b() {
            boolean zA = this.b.a();
            if (zA != this.c) {
                this.c = zA;
                gq.this.i();
            }
        }

        final void c() {
            d();
            if (this.d == null) {
                this.d = new BroadcastReceiver() { // from class: gq.b.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        b.this.b();
                    }
                };
            }
            if (this.e == null) {
                this.e = new IntentFilter();
                this.e.addAction("android.intent.action.TIME_SET");
                this.e.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.e.addAction("android.intent.action.TIME_TICK");
            }
            gq.this.a.registerReceiver(this.d, this.e);
        }

        final void d() {
            if (this.d != null) {
                gq.this.a.unregisterReceiver(this.d);
                this.d = null;
            }
        }
    }
}
