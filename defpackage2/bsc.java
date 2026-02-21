package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class bsc {
    private static volatile bsd a = bsd.a;
    private final StringBuffer b;
    private final Object c;
    private final bsd d;

    public static bsd d() {
        return a;
    }

    public static String c(Object obj) {
        return bsa.a(obj);
    }

    public static String b(Object obj, bsd bsdVar) {
        return bsa.a(obj, bsdVar);
    }

    public bsc(Object obj, bsd bsdVar) {
        this(obj, bsdVar, null);
    }

    public bsc(Object obj, bsd bsdVar, StringBuffer stringBuffer) {
        bsdVar = bsdVar == null ? d() : bsdVar;
        stringBuffer = stringBuffer == null ? new StringBuffer(512) : stringBuffer;
        this.b = stringBuffer;
        this.d = bsdVar;
        this.c = obj;
        bsdVar.a(stringBuffer, obj);
    }

    public bsc a(String str, boolean z) {
        this.d.a(this.b, str, z);
        return this;
    }

    public bsc a(String str, byte b) {
        this.d.a(this.b, str, b);
        return this;
    }

    public bsc a(String str, int i) {
        this.d.a(this.b, str, i);
        return this;
    }

    public bsc a(String str, long j) {
        this.d.a(this.b, str, j);
        return this;
    }

    public bsc a(String str, Object obj) {
        this.d.a(this.b, str, obj, (Boolean) null);
        return this;
    }

    public bsc a(String str, short s) {
        this.d.a(this.b, str, s);
        return this;
    }

    public Object e() {
        return this.c;
    }

    public StringBuffer f() {
        return this.b;
    }

    public bsd g() {
        return this.d;
    }

    public String toString() {
        if (e() == null) {
            f().append(g().b());
        } else {
            this.d.b(f(), e());
        }
        return f().toString();
    }

    public String h() {
        return toString();
    }
}
