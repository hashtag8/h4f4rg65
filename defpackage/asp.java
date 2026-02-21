package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class asp {
    private String a;
    private String b;
    private String c;
    private String d;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof asp) {
                asp aspVar = (asp) obj;
                if (!bpj.a((Object) this.a, (Object) aspVar.a) || !bpj.a((Object) this.b, (Object) aspVar.b) || !bpj.a((Object) this.c, (Object) aspVar.c) || !bpj.a((Object) this.d, (Object) aspVar.d)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int iHashCode2 = ((str2 != null ? str2.hashCode() : 0) + iHashCode) * 31;
        String str3 = this.c;
        int iHashCode3 = ((str3 != null ? str3.hashCode() : 0) + iHashCode2) * 31;
        String str4 = this.d;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "LegalData(name=" + this.a + ", version=" + this.b + ", url=" + this.c + ", file=" + this.d + ")";
    }

    public asp(String str, String str2, String str3, String str4) {
        bpj.b(str, "name");
        bpj.b(str2, "version");
        bpj.b(str3, "url");
        bpj.b(str4, "file");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        bpj.b(str, "<set-?>");
        this.a = str;
    }

    public final String b() {
        return this.b;
    }

    public final void b(String str) {
        bpj.b(str, "<set-?>");
        this.b = str;
    }

    public final String c() {
        return this.c;
    }

    public final void c(String str) {
        bpj.b(str, "<set-?>");
        this.c = str;
    }

    public final String d() {
        return this.d;
    }

    public final void d(String str) {
        bpj.b(str, "<set-?>");
        this.d = str;
    }
}
