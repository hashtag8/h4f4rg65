package defpackage;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class boc implements bob {
    private final Context a;
    private final String b;
    private final String c;

    public boc(bln blnVar) {
        if (blnVar.r() == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.a = blnVar.r();
        this.b = blnVar.t();
        this.c = "Android/" + this.a.getPackageName();
    }

    @Override // defpackage.bob
    public File a() {
        return a(this.a.getFilesDir());
    }

    File a(File file) {
        if (file != null) {
            if (!file.exists() && !file.mkdirs()) {
                blh.h().d("Fabric", "Couldn't create file");
            } else {
                return file;
            }
        } else {
            blh.h().a("Fabric", "Null File");
        }
        return null;
    }
}
