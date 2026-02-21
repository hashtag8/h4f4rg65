package defpackage;

import android.app.Activity;
import android.app.Dialog;

/* JADX INFO: loaded from: classes.dex */
public class asc {
    private Dialog a;

    public asc(Dialog dialog) {
        this.a = dialog;
    }

    public void a(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
            } catch (RuntimeException e) {
                mm.b("Activity already finished", e);
                return;
            }
        }
        this.a.show();
    }
}
