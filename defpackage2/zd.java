package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
@yx
public class zd extends Handler {
    public zd(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Exception {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            sy.f().a((Throwable) e, false);
            throw e;
        }
    }
}
