package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class qk extends Exception {
    private int a;
    private String b;

    public qk(String str) {
        this(str, "", 0);
    }

    public qk(String str, String str2, int i) {
        this(str, str2, i, null);
    }

    public qk(String str, String str2, int i, Throwable th) {
        super(str, th);
        this.a = 0;
        this.b = str2;
        this.a = i;
    }

    public qk(String str, Throwable th) {
        this(str, "", 0, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        qk qkVar = (qk) obj;
        if (this.a != qkVar.a) {
            return false;
        }
        if (this.b == null) {
            if (qkVar.b != null) {
                return false;
            }
        } else if (!this.b.equals(qkVar.b)) {
            return false;
        }
        return getMessage() == null ? qkVar.getMessage() == null : getMessage().equals(qkVar.getMessage());
    }

    public int hashCode() {
        return (((this.b == null ? 0 : this.b.hashCode()) + ((this.a + 31) * 31)) * 31) + (getMessage() != null ? getMessage().hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getClass().getName() + ": msg=" + getMessage() + ", type=" + this.b + ", code=" + this.a;
    }
}
