package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class brz {
    private final Object a;
    private final int b;

    public brz(Object obj) {
        this.b = System.identityHashCode(obj);
        this.a = obj;
    }

    public int hashCode() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof brz)) {
            return false;
        }
        brz brzVar = (brz) obj;
        return this.b == brzVar.b && this.a == brzVar.a;
    }
}
