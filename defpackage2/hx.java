package defpackage;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import defpackage.gj;
import defpackage.ha;
import defpackage.id;

/* JADX INFO: loaded from: classes.dex */
class hx implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, id.a {
    hu a;
    private hw b;
    private gj c;
    private id.a d;

    public hx(hw hwVar) {
        this.b = hwVar;
    }

    public void a(IBinder iBinder) {
        hw hwVar = this.b;
        gj.a aVar = new gj.a(hwVar.e());
        this.a = new hu(aVar.a(), ha.g.abc_list_menu_item_layout);
        this.a.a(this);
        this.b.a(this.a);
        aVar.a(this.a.a(), this);
        View viewO = hwVar.o();
        if (viewO != null) {
            aVar.a(viewO);
        } else {
            aVar.a(hwVar.n()).a(hwVar.m());
        }
        aVar.a(this);
        this.c = aVar.b();
        this.c.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.c.show();
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.c.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.b.a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.b.performShortcut(i, keyEvent, 0);
    }

    public void a() {
        if (this.c != null) {
            this.c.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.a.a(this.b, true);
    }

    @Override // id.a
    public void a(hw hwVar, boolean z) {
        if (z || hwVar == this.b) {
            a();
        }
        if (this.d != null) {
            this.d.a(hwVar, z);
        }
    }

    @Override // id.a
    public boolean a(hw hwVar) {
        if (this.d != null) {
            return this.d.a(hwVar);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.b.a((hy) this.a.a().getItem(i), 0);
    }
}
