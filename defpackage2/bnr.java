package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class bnr implements Runnable {
    private final Context a;
    private final bnn b;

    public bnr(Context context, bnn bnnVar) {
        this.a = context;
        this.b = bnnVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            bme.a(this.a, "Performing time based file roll over.");
            if (!this.b.c()) {
                this.b.d();
            }
        } catch (Exception e) {
            bme.a(this.a, "Failed to roll over file", e);
        }
    }
}
