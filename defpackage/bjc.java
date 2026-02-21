package defpackage;

import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bjc implements Runnable {
    protected bjz<bjy> a;
    protected int b;
    protected String c;
    protected int d;
    protected InetSocketAddress e;
    protected List<NetworkInterface> f;
    protected boolean g;
    private bix h;

    public bjc(String str, int i, List<NetworkInterface> list) {
        this(str, i, list, 3000, true);
    }

    public bjc(String str, int i, List<NetworkInterface> list, int i2, boolean z) {
        this.a = new bjz<>();
        this.b = 3000;
        this.c = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.g = false;
        this.c = str;
        this.d = i;
        this.f = list;
        this.b = i2;
        this.g = z;
        this.e = new InetSocketAddress(str, i);
        a(bjy.STOPPED);
    }

    public void a(bix bixVar) {
        this.h = bixVar;
    }

    public void a(bjy bjyVar) {
        this.a.a(bjyVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ee  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bjc.run():void");
    }
}
