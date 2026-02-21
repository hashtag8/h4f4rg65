package defpackage;

import android.content.Context;
import android.os.Message;
import defpackage.atv;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/* JADX INFO: loaded from: classes.dex */
public class atx {
    private MulticastSocket a;
    private DatagramPacket k;
    private DatagramPacket l;
    private DatagramPacket m;
    private DatagramPacket n;
    private DatagramPacket o;
    private DatagramPacket p;
    private InetAddress q;
    private atv.b s;
    private atv.c t;
    private Context u;
    private String b = "239.255.255.250";
    private int c = 1900;
    private int d = 12580;
    private String e = "M-SEARCH * HTTP/1.1\r\nHOST: 239.255.255.250:1900\r\nMAN: \"ssdp:discover\"\r\nMX: 3\r\nST: upnp:all\r\n\r\n";
    private String f = "M-SEARCH * HTTP/1.1\r\nMX: 1\r\nHOST: 239.255.255.250:1900\r\nMAN: \"ssdp:discover\"\r\nST: upnp:rootdevice\r\n\r\n";
    private String g = "M-SEARCH * HTTP/1.1\r\nMX: 3\r\nHOST: 239.255.255.250:1900\r\nMAN: \"ssdp:discover\"\r\nST: upnp:rootdevice\r\n\r\n";
    private String h = "M-SEARCH * HTTP/1.1\r\nHOST: 239.255.255.250:1900\r\nMAN: \"ssdp:discover\"\r\nMX: 3\r\nST: harman-com:service:remote-controller:1\r\n\r\n";
    private String i = "M-SEARCH * HTTP/1.1\r\nMX: 3\r\nHOST: \"239.255.255.250:1900\"\r\nMAN: \"ssdp:discover\"\r\nST: \"upnp:rootdevice\"\r\n\r\n";
    private byte[] j = new byte[5120];
    private boolean r = true;
    private Runnable v = new Runnable() { // from class: atx.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (atx.this.a != null && !atx.this.a.isClosed()) {
                    atx.this.a.receive(atx.this.k);
                    Message messageObtainMessage = atx.this.s.obtainMessage(2);
                    messageObtainMessage.obj = new String(atx.this.k.getData(), 0, atx.this.k.getLength());
                    atx.this.s.sendMessage(messageObtainMessage);
                }
            } catch (Exception e) {
                if (atx.this.r) {
                    atx.this.s.sendMessage(atx.this.s.obtainMessage(6));
                }
            }
            if (atx.this.r) {
                atx.this.s.post(atx.this.v);
            }
        }
    };
    private Runnable w = new Runnable() { // from class: atx.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    if (atx.this.a != null && !atx.this.a.isClosed()) {
                        atx.this.a.send(atx.this.l);
                        atx.this.a.send(atx.this.m);
                        atx.this.a.send(atx.this.n);
                        atx.this.a.send(atx.this.o);
                        atx.this.a.send(atx.this.p);
                    }
                    if (!atu.a(atx.this.u)) {
                        atx.this.s.sendEmptyMessage(7);
                    } else {
                        atx.this.t.sendEmptyMessage(1);
                        atx.this.t.postDelayed(atx.this.w, 1000L);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    if (!atu.a(atx.this.u)) {
                        atx.this.s.sendEmptyMessage(7);
                    } else {
                        atx.this.t.sendEmptyMessage(1);
                        atx.this.t.postDelayed(atx.this.w, 1000L);
                    }
                }
            } catch (Throwable th) {
                if (atu.a(atx.this.u)) {
                    atx.this.t.sendEmptyMessage(1);
                    atx.this.t.postDelayed(atx.this.w, 1000L);
                } else {
                    atx.this.s.sendEmptyMessage(7);
                }
                throw th;
            }
        }
    };

    public atx(Context context, atv.b bVar, atv.c cVar) {
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.u = context;
        this.s = bVar;
        this.t = cVar;
        this.k = new DatagramPacket(this.j, this.j.length);
        try {
            this.q = InetAddress.getByName(this.b);
            this.a = new MulticastSocket(this.d);
            this.a.setSoTimeout(6000);
            this.a.setTimeToLive(4);
            this.m = new DatagramPacket(this.f.getBytes(), this.f.length(), this.q, this.c);
            this.n = new DatagramPacket(this.e.getBytes(), this.e.length(), this.q, this.c);
            this.l = new DatagramPacket(this.h.getBytes(), this.h.length(), this.q, this.c);
            this.o = new DatagramPacket(this.g.getBytes(), this.g.length(), this.q, this.c);
            this.p = new DatagramPacket(this.i.getBytes(), this.i.length(), this.q, this.c);
            this.a.joinGroup(this.q);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a() {
        if (this.t != null) {
            this.t.post(this.w);
        }
    }

    public void b() {
        if (this.s != null) {
            this.s.post(this.v);
        }
    }

    public void c() {
        if (this.t != null) {
            this.t.removeCallbacks(this.w);
            this.w = null;
        }
        if (this.s != null) {
            this.s.removeCallbacks(this.v);
            this.v = null;
            this.r = false;
        }
    }

    public void d() {
        if (this.a != null) {
            try {
                this.a.leaveGroup(this.q);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                this.a.disconnect();
                this.a.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.a = null;
        }
    }
}
