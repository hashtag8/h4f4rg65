package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class bes {
    private final String a;
    private final String b;

    public bes(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof bes) && bfw.a(this.a, ((bes) obj).a) && bfw.a(this.b, ((bes) obj).b);
    }

    public int hashCode() {
        return (((this.b != null ? this.b.hashCode() : 0) + 899) * 31) + (this.a != null ? this.a.hashCode() : 0);
    }

    public String toString() {
        return this.a + " realm=\"" + this.b + "\"";
    }
}
