package defpackage;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.Window;
import defpackage.gq;

/* JADX INFO: loaded from: classes.dex */
class gr extends gq {
    private final UiModeManager t;

    gr(Context context, Window window, gl glVar) {
        super(context, window, glVar);
        this.t = (UiModeManager) context.getSystemService("uimode");
    }

    @Override // defpackage.gq, defpackage.gn
    Window.Callback a(Window.Callback callback) {
        return new a(callback);
    }

    @Override // defpackage.gq
    int d(int i) {
        if (i == 0 && this.t.getNightMode() == 0) {
            return -1;
        }
        return super.d(i);
    }

    class a extends gq.a {
        a(Window.Callback callback) {
            super(callback);
        }

        @Override // defpackage.ho, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (gr.this.o()) {
                switch (i) {
                    case 0:
                        return a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }

        @Override // gq.a, defpackage.ho, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }
    }
}
