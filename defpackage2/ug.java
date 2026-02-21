package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class ug {
    private final Context a;
    private final Context b;

    public ug(Context context) {
        vq.a(context);
        Context applicationContext = context.getApplicationContext();
        vq.a(applicationContext, "Application context can't be null");
        this.a = applicationContext;
        this.b = applicationContext;
    }

    protected aau a(Context context) {
        return aau.a(context);
    }

    public Context a() {
        return this.a;
    }

    protected uu a(uf ufVar) {
        return new uu(ufVar);
    }

    public Context b() {
        return this.b;
    }

    protected uk b(uf ufVar) {
        return new uk(ufVar);
    }

    protected to c(uf ufVar) {
        return new to(ufVar);
    }

    protected un d(uf ufVar) {
        return new un(ufVar);
    }

    protected ua e(uf ufVar) {
        return new ua(ufVar);
    }

    protected tu f(uf ufVar) {
        return new tu(ufVar);
    }

    protected ur g(uf ufVar) {
        return new ur(ufVar);
    }

    protected aah h(uf ufVar) {
        return aai.c();
    }

    protected th i(uf ufVar) {
        return new th(ufVar);
    }

    ul j(uf ufVar) {
        return new ul(ufVar, this);
    }

    tv k(uf ufVar) {
        return new tv(ufVar);
    }

    protected ub l(uf ufVar) {
        return new ub(ufVar, this);
    }

    public uj m(uf ufVar) {
        return new uj(ufVar);
    }

    public tw n(uf ufVar) {
        return new tw(ufVar);
    }

    public ui o(uf ufVar) {
        return new ui(ufVar);
    }

    public uv p(uf ufVar) {
        return new uv(ufVar);
    }

    public tx q(uf ufVar) {
        return new tx(ufVar);
    }
}
