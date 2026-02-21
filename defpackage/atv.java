package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class atv {
    private static atv h;
    private Context f;
    private Handler g;
    private atx a = null;
    private b b = null;
    private c c = null;
    private HandlerThread d = null;
    private HandlerThread e = null;
    private int i = 0;
    private final a j = new a(this);

    static /* synthetic */ int a(atv atvVar) {
        int i = atvVar.i;
        atvVar.i = i + 1;
        return i;
    }

    private atv(Context context) {
        this.f = context;
    }

    public static atv a() {
        if (h == null) {
            h = new atv(HarmanApplication.a());
        }
        return h;
    }

    public void b() {
        c();
        this.i = 0;
        if (atu.a(this.f)) {
            e();
            d();
        } else {
            this.j.sendEmptyMessage(51);
        }
    }

    public void c() {
        f();
        g();
    }

    private void d() {
        if (this.a != null) {
            this.a.a();
        }
        if (this.a != null) {
            this.a.b();
        }
    }

    public void a(Handler handler) {
        this.g = handler;
    }

    private void e() {
        if (this.d == null) {
            this.d = new HandlerThread("receive_msg");
            this.d.start();
        }
        if (this.b == null) {
            this.b = new b(this, this.d.getLooper());
        }
        if (this.e == null) {
            this.e = new HandlerThread("search_msg");
            this.e.start();
        }
        if (this.c == null) {
            this.c = new c(this, this.e.getLooper());
        }
        if (this.a == null) {
            this.a = new atx(this.f, this.b, this.c);
        }
    }

    private void f() {
        this.i = 0;
        if (this.a != null) {
            this.a.c();
            this.a.d();
            this.a = null;
        }
    }

    private void g() {
        if (this.e != null) {
            this.e.quit();
            this.e = null;
        }
        if (this.d != null) {
            this.d.quit();
            this.d = null;
        }
        this.c = null;
        this.b = null;
    }

    static class c extends Handler {
        private final WeakReference<atv> a;

        public c(atv atvVar, Looper looper) {
            super(looper);
            this.a = new WeakReference<>(atvVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            atv atvVar = this.a.get();
            if (atvVar != null) {
                switch (message.what) {
                    case 1:
                        atv.a(atvVar);
                        if (atvVar.i > 6) {
                            atvVar.c();
                            atvVar.j.sendEmptyMessage(1001);
                        }
                        break;
                }
            }
        }
    }

    static class b extends Handler {
        private final WeakReference<atv> a;

        public b(atv atvVar, Looper looper) {
            super(looper);
            this.a = new WeakReference<>(atvVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            atv atvVar = this.a.get();
            if (atvVar != null) {
                switch (message.what) {
                    case 2:
                        if (atvVar.i <= 6) {
                            String string = message.obj.toString();
                            if (!string.contains("M-SEARCH * HTTP/1.1")) {
                                atvVar.a(string);
                            }
                        }
                        break;
                    case 7:
                        atvVar.j.sendEmptyMessage(51);
                        break;
                }
            }
        }
    }

    public void a(String str) {
        mm.b("receive device==================", str);
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("knos/3.2 upnp/1.0 dmp/3.5") && lowerCase.contains("8080/description.xml")) {
            b(str);
        } else {
            if (!lowerCase.contains("posix, upnp/1.0, intel microstack/1.0.2777") || lowerCase.contains("8080/dd.xml")) {
            }
        }
    }

    private void b(String str) {
        if (str != null && str.length() != 0) {
            Message messageObtainMessage = this.j.obtainMessage();
            for (String str2 : str.split("\r\n")) {
                if ("location:".equals(str2.substring(0, str2.indexOf(":") + 1).toLowerCase().trim()) && str2.length() > 0) {
                    String strTrim = str2.substring(str2.indexOf(":") + 1).trim();
                    if (strTrim.contains("description.xml") || strTrim.contains("dd.xml")) {
                        att attVarA = ats.a(strTrim);
                        String str3 = "";
                        if (attVarA.e.length() > 0 && !attVarA.e.toLowerCase().equals("none")) {
                            str3 = attVarA.e;
                        } else if (attVarA.a.length() > 0) {
                            str3 = attVarA.a;
                        }
                        if (str3.toLowerCase().contains("hk aura") || str3.toLowerCase().contains("hkaura") || str3.toLowerCase().contains("soundtube")) {
                            atw atwVar = new atw(str, attVarA.a);
                            atwVar.a(R.drawable.speaker_aura);
                            messageObtainMessage.what = 1004;
                            messageObtainMessage.obj = atwVar;
                            this.j.sendMessageDelayed(messageObtainMessage, 5000L);
                        }
                    }
                }
            }
        }
    }

    static class a extends Handler {
        private final WeakReference<atv> a;

        public a(atv atvVar) {
            this.a = new WeakReference<>(atvVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            atv atvVar = this.a.get();
            if (atvVar != null && atvVar.g != null) {
                switch (message.what) {
                    case 51:
                        atvVar.g.sendEmptyMessage(51);
                        break;
                    case 52:
                        atvVar.g.sendEmptyMessage(52);
                        break;
                    case 53:
                        atvVar.g.sendEmptyMessage(53);
                        break;
                    case 54:
                        atvVar.g.sendEmptyMessage(54);
                        break;
                    case 1001:
                        atvVar.g.sendEmptyMessage(1001);
                        break;
                    case 1004:
                        Message messageObtainMessage = obtainMessage();
                        messageObtainMessage.what = message.what;
                        messageObtainMessage.obj = message.obj;
                        atvVar.g.sendMessage(messageObtainMessage);
                        break;
                    case 131073:
                        atvVar.g.sendEmptyMessage(131073);
                        break;
                }
            }
        }
    }
}
