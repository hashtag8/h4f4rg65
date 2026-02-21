package defpackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.util.Timer;

/* JADX INFO: loaded from: classes.dex */
public class aet {
    public Handler a;
    private aew b;
    private Timer c;

    public aet(Handler handler, aew aewVar) {
        this.a = handler;
        this.b = aewVar;
    }

    public void a(final aed aedVar) {
        mq.b().b(new Runnable() { // from class: aet.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    aet.this.b.a(aedVar);
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    aet.this.b(aedVar);
                } catch (RuntimeException e2) {
                    aet.this.a(aedVar, e2);
                }
            }
        });
    }

    public void a() {
        this.b.a();
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(aed aedVar) {
        if (this.a != null && (this.b instanceof aev)) {
            this.a.removeMessages(3001);
            Message message = new Message();
            message.what = 2001;
            message.obj = aedVar;
            this.a.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(aed aedVar, RuntimeException runtimeException) {
        if (this.a != null) {
            this.a.removeMessages(3001);
            Message message = new Message();
            message.what = 113;
            message.obj = aedVar;
            Bundle bundle = new Bundle();
            bundle.putSerializable("exception", runtimeException);
            message.setData(bundle);
            this.a.sendMessage(message);
        }
    }
}
