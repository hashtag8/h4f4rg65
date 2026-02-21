package defpackage;

/* JADX INFO: loaded from: classes.dex */
class blx {
    public final String a;
    public final boolean b;

    blx(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        blx blxVar = (blx) obj;
        if (this.b != blxVar.b) {
            return false;
        }
        if (this.a != null) {
            if (this.a.equals(blxVar.a)) {
                return true;
            }
        } else if (blxVar.a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.a != null ? this.a.hashCode() : 0) * 31) + (this.b ? 1 : 0);
    }
}
