package defpackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class aen extends aeh implements aes {
    protected a d;
    protected final adx f;
    private final aev i;
    private ArrayList<aei> j = new ArrayList<>();
    private int k = 0;
    private byte l = 1;
    private boolean m = true;
    protected boolean g = true;
    boolean h = true;
    protected HandlerThread e = new HandlerThread("SendCommandHandlerThread");

    public aen(adx adxVar, aev aevVar) {
        this.f = adxVar;
        this.e.start();
        this.d = new a(this.e.getLooper());
        this.i = aevVar;
    }

    @Override // defpackage.aeh
    public void a(Handler handler) {
        this.c = handler;
        this.a = new aeo(this, handler, this.f, this.i);
        this.b = new aej(handler, this.f);
    }

    @Override // defpackage.aeh
    public void a(aep aepVar) {
        b((aei) aepVar);
        if (this.m) {
            c();
            this.m = false;
        }
    }

    protected void a(aei aeiVar) {
        try {
            byte b = this.l;
            this.l = (byte) (b + 1);
            aeiVar.a(b);
            this.a.a(aeiVar.b());
            mm.a("Private Command -- Sending %s to %s", aeiVar, this.f.R());
        } catch (Exception e) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("exception", e);
            a(bundle);
        }
    }

    public void a(long j, byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            mm.a("Private Command -- Receiving %s for %s", Long.valueOf(j), mm.a(bArr));
            a(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.d != null) {
            this.d.sendEmptyMessage(0);
        } else {
            mm.a((Object) "sendNextCommand====null");
        }
    }

    private void b(aei aeiVar) {
        d();
        if (!this.j.contains(aeiVar)) {
            this.j.add(aeiVar);
        }
    }

    private void d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.j.size() > 0) {
            try {
                this.j.remove(0);
            } catch (RuntimeException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public aei f() {
        if (this.j.size() == 0) {
            return null;
        }
        try {
            return this.j.get(0);
        } catch (RuntimeException e) {
            return null;
        }
    }

    private void a(Bundle bundle) {
        Message message = new Message();
        message.what = 171;
        message.obj = this.f;
        message.setData(bundle);
        if (this.c != null) {
            this.c.sendMessage(message);
        }
    }

    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            aei aeiVarF = aen.this.f();
            if (aeiVarF == null) {
                aen.this.m = true;
                return;
            }
            if (aeiVarF.d == 5002) {
                aen.this.a(aeiVarF);
                return;
            }
            if (aeiVarF.d == 5001) {
                aen.this.e();
                aen.this.a(aeiVarF);
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                aen.this.c();
            }
        }

        public void a() {
            if (getLooper() != null) {
                getLooper().quit();
            }
        }
    }

    private void a(byte[] bArr) {
        if (bArr.length >= 7) {
            if (bArr[0] == 104 && bArr[1] == 97) {
                byte[] bArr2 = new byte[8];
                System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
                c(bArr2);
                if (bArr.length > bArr2.length) {
                    byte[] bArr3 = new byte[bArr.length - bArr2.length];
                    System.arraycopy(bArr, bArr2.length, bArr3, 0, bArr3.length);
                    a(bArr3);
                    return;
                }
                return;
            }
            if (bArr[0] == 72 && bArr[1] == 65) {
                if (bArr[2] == 7 && bArr[3] == 10) {
                    b(bArr);
                    return;
                }
                if (bArr[2] == 7 && bArr[3] == 12) {
                    b(bArr);
                    return;
                }
                byte[] bArr4 = new byte[mk.d(new byte[]{bArr[5], bArr[6]}) + 8];
                System.arraycopy(bArr, 0, bArr4, 0, bArr4.length);
                b(bArr4);
                if (bArr.length > bArr4.length) {
                    byte[] bArr5 = new byte[bArr.length - bArr4.length];
                    System.arraycopy(bArr, bArr4.length, bArr5, 0, bArr5.length);
                    a(bArr5);
                }
            }
        }
    }

    private void b(byte[] bArr) {
        if (bArr[2] == 5) {
            if (bArr[3] == 7) {
                a((byte) 7);
                mm.a("", "---ack");
            } else if (bArr[3] == 9) {
                a((byte) 9);
                mm.a("", "---ack");
            }
        }
        aei aeiVar = new aei();
        aeiVar.b(bArr);
        this.b.a(aeiVar);
    }

    private void a(byte b) {
        try {
            this.a.a(new byte[]{104, 97, 5, b, 0, 0, 0, 0});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void c(byte[] bArr) {
        e();
        this.k = 0;
        c();
    }

    @Override // defpackage.aeh
    public void a() {
        if (this.j != null && !this.j.isEmpty()) {
            this.j.clear();
        }
        if (this.d != null) {
            this.d.a();
            this.d = null;
        }
        if (this.e != null) {
            this.e.quit();
            this.e = null;
        }
        if (this.b != null) {
            this.b.b();
        }
        if (this.a != null) {
            this.a.a();
        }
    }

    @Override // defpackage.aes
    public long b() {
        return this.f.P();
    }
}
