package defpackage;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.harman.hkconnect.ui.HarmanApplication;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class afa implements aey {
    public static Map<Long, Long> a = new HashMap();
    private aex b;
    private Handler c;
    private Map<Long, Boolean> d = new HashMap();

    public void a(aex aexVar) {
        this.b = aexVar;
        this.b.a(this);
    }

    public void a(Handler handler) {
        this.c = handler;
    }

    @Override // defpackage.aey
    public void a(ahz ahzVar) {
        Message message = new Message();
        message.what = 1002;
        message.obj = ahzVar;
        this.c.sendMessage(message);
    }

    @Override // defpackage.aey
    public void b(adx adxVar) {
        if (adxVar != null) {
            Message message = new Message();
            message.what = 1004;
            message.obj = adxVar;
            this.c.sendMessage(message);
            b();
        }
    }

    @Override // defpackage.aey
    public void a(List<adx> list) {
        b();
    }

    @Override // defpackage.aey
    public void a(adx adxVar) {
    }

    public void b() {
        Message message = new Message();
        message.what = 1003;
        message.obj = this.b.d();
        this.c.sendMessage(message);
    }

    @Override // defpackage.aey
    public void a() {
        Message message = new Message();
        message.what = 1005;
        this.c.sendMessage(message);
        b();
    }

    @Override // defpackage.aey
    public void a(long j, Object obj) {
        adx adxVarA = aof.a().a(j);
        mm.a((Object) "fixrecovery");
        if (adxVarA != null && !Boolean.TRUE.equals(this.d.get(Long.valueOf(j))) && ahh.a(HarmanApplication.a())) {
            mm.a((Object) "fixrecovery");
            this.d.put(Long.valueOf(adxVarA.P()), true);
            adxVarA.h(true);
            Intent intent = new Intent("ACTION_START_RECOVERY");
            intent.putExtra("deviceid", j);
            HarmanApplication.a().sendBroadcast(intent);
        }
    }

    @Override // defpackage.aey
    public void a(long j) {
        mm.b("SearchMgr.OnDevicePlayStarted....... RecoveryFlag=%s", this.d);
        if (Boolean.TRUE.equals(this.d.get(Long.valueOf(j))) && ahh.a(HarmanApplication.a())) {
            mm.b("SearchMgr.OnDevicePlayStarted.... deviceId=%d ", Long.valueOf(j));
            this.d.remove(Long.valueOf(j));
            mm.b("start auto-recovery: deviceid: %s", Long.valueOf(j));
            Intent intent = new Intent("ACTION_FINISH_RECOVERY");
            intent.putExtra("deviceid", j);
            HarmanApplication.a().sendBroadcast(intent);
        }
    }
}
