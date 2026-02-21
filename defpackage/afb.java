package defpackage;

import com.harman.hkconnect.ui.HarmanApplication;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class afb {
    private static lr a = null;
    private static mp b = new mp(3, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue());

    public static synchronized lr a() {
        if (a == null) {
            a = agq.a(HarmanApplication.a(), null);
        }
        return a;
    }

    public static synchronized agn b() {
        return new ago("https://hk.radionomy.com/api");
    }
}
