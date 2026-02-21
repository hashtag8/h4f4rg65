package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class vh extends az {
    private Dialog ae = null;
    private DialogInterface.OnCancelListener af = null;

    public static vh a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        vh vhVar = new vh();
        Dialog dialog2 = (Dialog) vq.a(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        vhVar.ae = dialog2;
        if (onCancelListener != null) {
            vhVar.af = onCancelListener;
        }
        return vhVar;
    }

    @Override // defpackage.az
    public void a(be beVar, String str) {
        super.a(beVar, str);
    }

    @Override // defpackage.az
    public Dialog c(Bundle bundle) {
        if (this.ae == null) {
            c(false);
        }
        return this.ae;
    }

    @Override // defpackage.az, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (this.af != null) {
            this.af.onCancel(dialogInterface);
        }
    }
}
