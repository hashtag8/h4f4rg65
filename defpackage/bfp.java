package defpackage;

import defpackage.bfa;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public abstract class bfp {
    public static final Logger a = Logger.getLogger(bfe.class.getName());
    public static bfp b;

    public abstract bfq a(bfe bfeVar);

    public abstract bgr a(beu beuVar, bge bgeVar);

    public abstract void a(beu beuVar, bff bffVar);

    public abstract void a(bev bevVar, beu beuVar);

    public abstract void a(bew bewVar, SSLSocket sSLSocket, boolean z);

    public abstract void a(bfa.a aVar, String str);

    public abstract void a(bfe bfeVar, beu beuVar, bge bgeVar, bfg bfgVar);

    public abstract boolean a(beu beuVar);

    public abstract int b(beu beuVar);

    public abstract bfv b(bfe bfeVar);

    public abstract void b(beu beuVar, bge bgeVar);

    public abstract bfs c(bfe bfeVar);

    public abstract boolean c(beu beuVar);
}
