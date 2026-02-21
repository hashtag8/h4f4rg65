package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import defpackage.bid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
class bhu {
    final b a = new b();
    final Context b;
    final ExecutorService c;
    final bhv d;
    final Map<String, bho> e;
    final Map<Object, bhm> f;
    final Map<Object, bhm> g;
    final Set<Object> h;
    final Handler i;
    final Handler j;
    final bhp k;
    final bin l;
    final List<bho> m;
    final c n;
    final boolean o;
    boolean p;

    bhu(Context context, ExecutorService executorService, Handler handler, bhv bhvVar, bhp bhpVar, bin binVar) {
        this.a.start();
        bit.a(this.a.getLooper());
        this.b = context;
        this.c = executorService;
        this.e = new LinkedHashMap();
        this.f = new WeakHashMap();
        this.g = new WeakHashMap();
        this.h = new HashSet();
        this.i = new a(this.a.getLooper(), this);
        this.d = bhvVar;
        this.j = handler;
        this.k = bhpVar;
        this.l = binVar;
        this.m = new ArrayList(4);
        this.p = bit.d(this.b);
        this.o = bit.b(context, "android.permission.ACCESS_NETWORK_STATE");
        this.n = new c(this);
        this.n.a();
    }

    void a(bhm bhmVar) {
        this.i.sendMessage(this.i.obtainMessage(1, bhmVar));
    }

    void b(bhm bhmVar) {
        this.i.sendMessage(this.i.obtainMessage(2, bhmVar));
    }

    void a(Object obj) {
        this.i.sendMessage(this.i.obtainMessage(11, obj));
    }

    void b(Object obj) {
        this.i.sendMessage(this.i.obtainMessage(12, obj));
    }

    void a(bho bhoVar) {
        this.i.sendMessage(this.i.obtainMessage(4, bhoVar));
    }

    void b(bho bhoVar) {
        this.i.sendMessageDelayed(this.i.obtainMessage(5, bhoVar), 500L);
    }

    void c(bho bhoVar) {
        this.i.sendMessage(this.i.obtainMessage(6, bhoVar));
    }

    void a(NetworkInfo networkInfo) {
        this.i.sendMessage(this.i.obtainMessage(9, networkInfo));
    }

    void a(boolean z) {
        this.i.sendMessage(this.i.obtainMessage(10, z ? 1 : 0, 0));
    }

    void c(bhm bhmVar) {
        a(bhmVar, true);
    }

    void a(bhm bhmVar, boolean z) {
        if (this.h.contains(bhmVar.l())) {
            this.g.put(bhmVar.d(), bhmVar);
            if (bhmVar.j().l) {
                bit.a("Dispatcher", "paused", bhmVar.b.a(), "because tag '" + bhmVar.l() + "' is paused");
                return;
            }
            return;
        }
        bho bhoVar = this.e.get(bhmVar.e());
        if (bhoVar != null) {
            bhoVar.a(bhmVar);
            return;
        }
        if (this.c.isShutdown()) {
            if (bhmVar.j().l) {
                bit.a("Dispatcher", "ignored", bhmVar.b.a(), "because shut down");
                return;
            }
            return;
        }
        bho bhoVarA = bho.a(bhmVar.j(), this, this.k, this.l, bhmVar);
        bhoVarA.n = this.c.submit(bhoVarA);
        this.e.put(bhmVar.e(), bhoVarA);
        if (z) {
            this.f.remove(bhmVar.d());
        }
        if (bhmVar.j().l) {
            bit.a("Dispatcher", "enqueued", bhmVar.b.a());
        }
    }

    void d(bhm bhmVar) {
        String strE = bhmVar.e();
        bho bhoVar = this.e.get(strE);
        if (bhoVar != null) {
            bhoVar.b(bhmVar);
            if (bhoVar.b()) {
                this.e.remove(strE);
                if (bhmVar.j().l) {
                    bit.a("Dispatcher", "canceled", bhmVar.c().a());
                }
            }
        }
        if (this.h.contains(bhmVar.l())) {
            this.g.remove(bhmVar.d());
            if (bhmVar.j().l) {
                bit.a("Dispatcher", "canceled", bhmVar.c().a(), "because paused request got canceled");
            }
        }
        bhm bhmVarRemove = this.f.remove(bhmVar.d());
        if (bhmVarRemove != null && bhmVarRemove.j().l) {
            bit.a("Dispatcher", "canceled", bhmVarRemove.c().a(), "from replaying");
        }
    }

    void c(Object obj) {
        if (this.h.add(obj)) {
            Iterator<bho> it = this.e.values().iterator();
            while (it.hasNext()) {
                bho next = it.next();
                boolean z = next.j().l;
                bhm bhmVarI = next.i();
                List<bhm> listK = next.k();
                boolean z2 = (listK == null || listK.isEmpty()) ? false : true;
                if (bhmVarI != null || z2) {
                    if (bhmVarI != null && bhmVarI.l().equals(obj)) {
                        next.b(bhmVarI);
                        this.g.put(bhmVarI.d(), bhmVarI);
                        if (z) {
                            bit.a("Dispatcher", "paused", bhmVarI.b.a(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (z2) {
                        for (int size = listK.size() - 1; size >= 0; size--) {
                            bhm bhmVar = listK.get(size);
                            if (bhmVar.l().equals(obj)) {
                                next.b(bhmVar);
                                this.g.put(bhmVar.d(), bhmVar);
                                if (z) {
                                    bit.a("Dispatcher", "paused", bhmVar.b.a(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (next.b()) {
                        it.remove();
                        if (z) {
                            bit.a("Dispatcher", "canceled", bit.a(next), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    void d(Object obj) {
        if (this.h.remove(obj)) {
            ArrayList arrayList = null;
            Iterator<bhm> it = this.g.values().iterator();
            while (it.hasNext()) {
                bhm next = it.next();
                if (next.l().equals(obj)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                    it.remove();
                }
            }
            if (arrayList != null) {
                this.j.sendMessage(this.j.obtainMessage(13, arrayList));
            }
        }
    }

    void d(bho bhoVar) {
        NetworkInfo activeNetworkInfo;
        if (!bhoVar.c()) {
            if (this.c.isShutdown()) {
                a(bhoVar, false);
                return;
            }
            if (!this.o) {
                activeNetworkInfo = null;
            } else {
                activeNetworkInfo = ((ConnectivityManager) bit.a(this.b, "connectivity")).getActiveNetworkInfo();
            }
            boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            boolean zA = bhoVar.a(this.p, activeNetworkInfo);
            boolean zD = bhoVar.d();
            if (!zA) {
                boolean z2 = this.o && zD;
                a(bhoVar, z2);
                if (z2) {
                    f(bhoVar);
                    return;
                }
                return;
            }
            if (!this.o || z) {
                if (bhoVar.j().l) {
                    bit.a("Dispatcher", "retrying", bit.a(bhoVar));
                }
                if (bhoVar.l() instanceof bid.a) {
                    bhoVar.i |= bic.NO_CACHE.d;
                }
                bhoVar.n = this.c.submit(bhoVar);
                return;
            }
            a(bhoVar, zD);
            if (zD) {
                f(bhoVar);
            }
        }
    }

    void e(bho bhoVar) {
        if (bib.b(bhoVar.g())) {
            this.k.a(bhoVar.f(), bhoVar.e());
        }
        this.e.remove(bhoVar.f());
        g(bhoVar);
        if (bhoVar.j().l) {
            bit.a("Dispatcher", "batched", bit.a(bhoVar), "for completion");
        }
    }

    void a() {
        ArrayList arrayList = new ArrayList(this.m);
        this.m.clear();
        this.j.sendMessage(this.j.obtainMessage(8, arrayList));
        a((List<bho>) arrayList);
    }

    void a(bho bhoVar, boolean z) {
        if (bhoVar.j().l) {
            bit.a("Dispatcher", "batched", bit.a(bhoVar), "for error" + (z ? " (will replay)" : ""));
        }
        this.e.remove(bhoVar.f());
        g(bhoVar);
    }

    void b(boolean z) {
        this.p = z;
    }

    void b(NetworkInfo networkInfo) {
        if (this.c instanceof bih) {
            ((bih) this.c).a(networkInfo);
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            b();
        }
    }

    private void b() {
        if (!this.f.isEmpty()) {
            Iterator<bhm> it = this.f.values().iterator();
            while (it.hasNext()) {
                bhm next = it.next();
                it.remove();
                if (next.j().l) {
                    bit.a("Dispatcher", "replaying", next.c().a());
                }
                a(next, false);
            }
        }
    }

    private void f(bho bhoVar) {
        bhm bhmVarI = bhoVar.i();
        if (bhmVarI != null) {
            e(bhmVarI);
        }
        List<bhm> listK = bhoVar.k();
        if (listK != null) {
            int size = listK.size();
            for (int i = 0; i < size; i++) {
                e(listK.get(i));
            }
        }
    }

    private void e(bhm bhmVar) {
        Object objD = bhmVar.d();
        if (objD != null) {
            bhmVar.k = true;
            this.f.put(objD, bhmVar);
        }
    }

    private void g(bho bhoVar) {
        if (!bhoVar.c()) {
            this.m.add(bhoVar);
            if (!this.i.hasMessages(7)) {
                this.i.sendEmptyMessageDelayed(7, 200L);
            }
        }
    }

    private void a(List<bho> list) {
        if (list != null && !list.isEmpty() && list.get(0).j().l) {
            StringBuilder sb = new StringBuilder();
            for (bho bhoVar : list) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bit.a(bhoVar));
            }
            bit.a("Dispatcher", "delivered", sb.toString());
        }
    }

    static class a extends Handler {
        private final bhu a;

        public a(Looper looper, bhu bhuVar) {
            super(looper);
            this.a = bhuVar;
        }

        @Override // android.os.Handler
        public void handleMessage(final Message message) {
            switch (message.what) {
                case 1:
                    this.a.c((bhm) message.obj);
                    break;
                case 2:
                    this.a.d((bhm) message.obj);
                    break;
                case 3:
                case 8:
                default:
                    bif.a.post(new Runnable() { // from class: bhu.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new AssertionError("Unknown handler message received: " + message.what);
                        }
                    });
                    break;
                case 4:
                    this.a.e((bho) message.obj);
                    break;
                case 5:
                    this.a.d((bho) message.obj);
                    break;
                case 6:
                    this.a.a((bho) message.obj, false);
                    break;
                case 7:
                    this.a.a();
                    break;
                case 9:
                    this.a.b((NetworkInfo) message.obj);
                    break;
                case 10:
                    this.a.b(message.arg1 == 1);
                    break;
                case 11:
                    this.a.c(message.obj);
                    break;
                case 12:
                    this.a.d(message.obj);
                    break;
            }
        }
    }

    static class b extends HandlerThread {
        b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    static class c extends BroadcastReceiver {
        private final bhu a;

        c(bhu bhuVar) {
            this.a = bhuVar;
        }

        void a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.a.o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.a.b.registerReceiver(this, intentFilter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                    if (intent.hasExtra("state")) {
                        this.a.a(intent.getBooleanExtra("state", false));
                    }
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    this.a.a(((ConnectivityManager) bit.a(context, "connectivity")).getActiveNetworkInfo());
                }
            }
        }
    }
}
