package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class btb extends bsy {
    static final btg a = new btg() { // from class: btb.1
        @Override // defpackage.btg
        public btl a(String str, String str2, bup bupVar) {
            return new btb(str, str2, bupVar);
        }
    };
    private String b;

    btb(String str, String str2, bup bupVar) {
        super(str, str2, bupVar);
        this.b = str2.trim().toLowerCase();
    }

    public String a() {
        return this.b;
    }

    public static String a(btb btbVar) {
        return (btbVar == null || btbVar.a().length() == 0) ? "7bit" : btbVar.a();
    }
}
