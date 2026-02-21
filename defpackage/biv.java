package defpackage;

import android.util.Log;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class biv implements biu {
    private static biv h;
    protected String a;
    protected int b;
    protected List<biw> c;
    protected bjw d;
    protected bjw e;
    protected bjc f;
    protected ExecutorService g;

    public static biv a() {
        if (h == null) {
            try {
                h = new biv();
            } catch (Exception e) {
            }
        }
        return h;
    }

    private biv() {
        this("239.255.255.250", 1900);
    }

    private biv(String str, int i) {
        this(str, i, Executors.newFixedThreadPool(5));
    }

    private biv(String str, int i, ExecutorService executorService) {
        this(str, i, null, Executors.newFixedThreadPool(5));
    }

    private biv(String str, int i, List<NetworkInterface> list, ExecutorService executorService) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = str;
        this.b = i;
        this.g = executorService;
        this.c = new ArrayList();
        this.d = new bjw(this, str, i, list);
        this.f = new bjc(str, i, list);
    }

    public void a(biw biwVar) {
        if (biwVar != null) {
            this.c.add(biwVar);
        }
    }

    public bjw b() {
        return this.d;
    }

    public bjc c() {
        return this.f;
    }

    public void d() {
        new Thread(this.d).start();
        new Thread(this.e).start();
        new Thread(this.f).start();
    }

    @Override // defpackage.biu
    public void a(String str, int i, bji bjiVar) {
        if (bjiVar instanceof bjg) {
            Iterator<biw> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().a(str, i, (bjg) bjiVar);
            }
            return;
        }
        if (bjiVar instanceof bjd) {
            bjd bjdVar = (bjd) bjiVar;
            if ("ssdp:alive".equals(bjdVar.e())) {
                Iterator<biw> it2 = this.c.iterator();
                while (it2.hasNext()) {
                    it2.next().a((bje) bjdVar);
                }
                return;
            } else if ("ssdp:update".equals(bjdVar.e())) {
                Iterator<biw> it3 = this.c.iterator();
                while (it3.hasNext()) {
                    it3.next().a((bjk) bjdVar);
                }
                return;
            } else {
                if ("ssdp:byebye".equals(bjdVar.e())) {
                    Iterator<biw> it4 = this.c.iterator();
                    while (it4.hasNext()) {
                        it4.next().a((bjf) bjdVar);
                        Log.d("DMS unavailable", "ByeByeMessage = " + bjdVar);
                    }
                    return;
                }
                return;
            }
        }
        if (bjiVar instanceof bjh) {
            Iterator<biw> it5 = this.c.iterator();
            while (it5.hasNext()) {
                it5.next().a((bjh) bjiVar);
            }
        }
    }
}
