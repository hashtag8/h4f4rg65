package defpackage;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class aur {
    private final WeakReference<auf> a;

    public aur(auf aufVar) {
        this.a = new WeakReference<>(aufVar);
    }

    public boolean a(boolean z) {
        auf aufVar = this.a.get();
        return aufVar == null || aufVar.a(z);
    }

    public boolean a() {
        auf aufVar = this.a.get();
        return aufVar == null || aufVar.b();
    }

    public boolean b() {
        auf aufVar = this.a.get();
        return aufVar == null || aufVar.a();
    }

    public boolean c() {
        boolean z = b() || a();
        if (z) {
            this.a.clear();
        }
        return z;
    }
}
