package defpackage;

import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class ou {
    private final String a;
    private final bob b;

    public ou(String str, bob bobVar) {
        this.a = str;
        this.b = bobVar;
    }

    public boolean a() {
        try {
            return d().createNewFile();
        } catch (IOException e) {
            blh.h().e("CrashlyticsCore", "Error creating marker: " + this.a, e);
            return false;
        }
    }

    public boolean b() {
        return d().exists();
    }

    public boolean c() {
        return d().delete();
    }

    private File d() {
        return new File(this.b.a(), this.a);
    }
}
