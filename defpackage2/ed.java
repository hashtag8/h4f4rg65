package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class ed<F, S> {
    public final F a;
    public final S b;

    public boolean equals(Object obj) {
        if (!(obj instanceof ed)) {
            return false;
        }
        ed edVar = (ed) obj;
        return a(edVar.a, this.a) && a(edVar.b, this.b);
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        return (this.a == null ? 0 : this.a.hashCode()) ^ (this.b != null ? this.b.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.a) + " " + String.valueOf(this.b) + "}";
    }
}
