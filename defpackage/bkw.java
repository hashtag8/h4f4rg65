package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class bkw extends bkq {
    private bkc a;

    public bkw() {
        c(bku.a());
        g("text/xml; charset=\"utf-8\"");
    }

    public bkw(bkq bkqVar) {
        super(bkqVar);
        c(bku.a());
        g("text/xml; charset=\"utf-8\"");
    }

    public bkw(bkw bkwVar) {
        super(bkwVar);
        a(bkwVar.t());
        g("text/xml; charset=\"utf-8\"");
    }

    private void c(bkc bkcVar) {
        this.a = bkcVar;
    }

    private bkc a() {
        return this.a;
    }

    public void a(bkc bkcVar) {
        c(bkcVar);
    }

    public bkc t() {
        return a();
    }

    public bkc u() {
        bkc bkcVarT = t();
        if (bkcVarT == null) {
            return null;
        }
        return bkcVarT.d("Body");
    }

    public void b(bkc bkcVar) {
        f((("<?xml version=\"1.0\" encoding=\"utf-8\"?>") + "\n") + bkcVar.toString());
    }
}
