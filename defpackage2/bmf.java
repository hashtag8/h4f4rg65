package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class bmf {
    private final String a;
    private final String b;

    public bmf(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public static class a extends bmf {
        public a(String str, String str2) {
            super(str, str2);
        }
    }
}
