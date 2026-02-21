package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
class ni {
    private final Context a;
    private final nk b;
    private nh c;

    public ni(Context context) {
        this(context, new nk());
    }

    public ni(Context context, nk nkVar) {
        this.a = context;
        this.b = nkVar;
    }

    public nh a() {
        if (this.c == null) {
            this.c = nc.a(this.a);
        }
        return this.c;
    }

    public void a(nu nuVar) {
        nh nhVarA = a();
        if (nhVarA == null) {
            blh.h().a("Answers", "Firebase analytics logging was enabled, but not available...");
            return;
        }
        nj njVarA = this.b.a(nuVar);
        if (njVarA == null) {
            blh.h().a("Answers", "Fabric event was not mappable to Firebase event: " + nuVar);
            return;
        }
        nhVarA.a(njVarA.a(), njVarA.b());
        if ("levelEnd".equals(nuVar.g)) {
            nhVarA.a("post_score", njVarA.b());
        }
    }
}
