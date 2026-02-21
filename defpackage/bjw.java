package defpackage;

import android.util.Log;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class bjw implements Runnable {
    protected bjz<bjy> a;
    protected int b;
    protected String c;
    protected int d;
    protected biu e;
    protected InetSocketAddress f;
    protected List<NetworkInterface> g;
    protected ExecutorService h;
    private bix i;
    private int j;
    private Timer k;
    private int l;

    public bjw(biu biuVar, String str, int i, int i2, ExecutorService executorService) {
        this(biuVar, str, i, null, i2, executorService);
    }

    public bjw(biu biuVar, String str, int i, List<NetworkInterface> list) {
        this(biuVar, str, i, 2000, Executors.newFixedThreadPool(5));
    }

    public bjw(biu biuVar, String str, int i, List<NetworkInterface> list, int i2, ExecutorService executorService) {
        this.a = new bjz<>();
        this.i = null;
        this.b = 5000;
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.j = 3;
        this.l = 0;
        this.e = biuVar;
        this.c = str;
        this.d = i;
        this.g = list;
        this.b = i2;
        this.f = new InetSocketAddress(this.c, this.d);
        a(bjy.STOPPED);
        this.h = executorService;
    }

    public void a(bjy bjyVar) {
        this.a.a(bjyVar);
    }

    public void a(final String str) {
        if (str != null) {
            this.h.submit(new Callable<Boolean>() { // from class: bjw.1
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean call() {
                    if (bjw.this.g == null || bjw.this.g.isEmpty()) {
                        bju.a().a(str, InetAddress.getByName(bjw.this.c), bjw.this.d, bjw.this.i, bjw.this.j);
                    } else {
                        Iterator<NetworkInterface> it = bjw.this.g.iterator();
                        while (it.hasNext()) {
                            bju.a().a(str, bjw.this.f, it.next());
                        }
                    }
                    return Boolean.TRUE;
                }
            });
        }
    }

    public void a(bix bixVar) {
        this.i = bixVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.l = 0;
        if (this.k != null) {
            this.k.cancel();
        }
        this.k = new Timer();
        this.k.schedule(new TimerTask() { // from class: bjw.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bjw.this.l > 3) {
                    bjw.this.k.cancel();
                    return;
                }
                bjg bjgVar = new bjg("239.255.255.250", 1900, bjw.this.j, "upnp:rootdevice", null);
                try {
                    bjw.this.l++;
                    bjw.this.a(bjgVar.toString());
                } catch (Exception e) {
                    bkx.a(Log.getStackTraceString(e));
                }
            }
        }, 1L, 5000L);
    }
}
