package defpackage;

import defpackage.ok;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;

/* JADX INFO: loaded from: classes.dex */
class qa implements ok.a {
    qa() {
    }

    @Override // ok.a
    public String a(File file) {
        return a(file.getPath());
    }

    private static String a(String str) throws Throwable {
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            try {
                String strB = bme.b(bufferedInputStream);
                bme.a((Closeable) bufferedInputStream);
                return strB;
            } catch (Throwable th) {
                th = th;
                bme.a((Closeable) bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
    }
}
