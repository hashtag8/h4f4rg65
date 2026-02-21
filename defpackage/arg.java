package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.view.WindowManager;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class arg extends Dialog {
    protected abstract void a();

    public arg(Context context, int i) {
        super(context, i);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 17;
        attributes.width = -1;
        getWindow().setAttributes(attributes);
        a();
        aob.h().f();
    }

    protected List<adz> c() {
        ady adyVarB = aof.a().b();
        if (adyVarB != null) {
            return adyVarB.f();
        }
        return null;
    }
}
