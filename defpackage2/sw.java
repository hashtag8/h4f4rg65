package defpackage;

/* JADX INFO: loaded from: classes.dex */
@yx
public class sw {
    private a a;
    private boolean b;
    private boolean c;

    public interface a {
        void a(String str);
    }

    public sw() {
        this.c = xb.g.c().booleanValue();
    }

    public sw(boolean z) {
        this.c = z;
    }

    public void a(String str) {
        su.a("Action was blocked because no click was detected.");
        if (this.a != null) {
            this.a.a(str);
        }
    }

    public boolean a() {
        return !this.c || this.b;
    }
}
