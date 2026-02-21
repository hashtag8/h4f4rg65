package defpackage;

import android.content.Context;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import defpackage.gr;
import defpackage.gs;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class go extends gr {
    go(Context context, Window window, gl glVar) {
        super(context, window, glVar);
    }

    @Override // defpackage.gr, defpackage.gq, defpackage.gn
    Window.Callback a(Window.Callback callback) {
        return new a(callback);
    }

    class a extends gr.a {
        a(Window.Callback callback) {
            super(callback);
        }

        @Override // defpackage.ho, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            gs.d dVarA = go.this.a(0, true);
            if (dVarA != null && dVarA.j != null) {
                super.onProvideKeyboardShortcuts(list, dVarA.j, i);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i);
            }
        }
    }
}
