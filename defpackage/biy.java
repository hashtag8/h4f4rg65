package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class biy implements bix {
    protected biu a;

    public biy(biu biuVar) {
        this.a = null;
        this.a = biuVar;
    }

    @Override // defpackage.bix
    public void a(String str, int i, String str2) {
        bji bjiVarA = bjj.a(str2);
        if (bjiVarA != null && this.a != null) {
            this.a.a(str, i, bjiVarA);
        }
    }
}
