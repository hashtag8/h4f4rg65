package defpackage;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class pk {
    private static final Charset a = Charset.forName(HTTP.UTF_8);
    private final File b;

    public pk(File file) {
        this.b = file;
    }

    public qe a(String str) throws Throwable {
        FileInputStream fileInputStream;
        File fileB = b(str);
        if (!fileB.exists()) {
            return qe.a;
        }
        try {
            fileInputStream = new FileInputStream(fileB);
        } catch (Exception e) {
            e = e;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
            bme.a((Closeable) fileInputStream, "Failed to close user metadata file.");
            throw th;
        }
        try {
            try {
                qe qeVarD = d(bme.a((InputStream) fileInputStream));
                bme.a((Closeable) fileInputStream, "Failed to close user metadata file.");
                return qeVarD;
            } catch (Throwable th2) {
                th = th2;
                bme.a((Closeable) fileInputStream, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            blh.h().e("CrashlyticsCore", "Error deserializing user metadata.", e);
            bme.a((Closeable) fileInputStream, "Failed to close user metadata file.");
            return qe.a;
        }
    }

    public File b(String str) {
        return new File(this.b, str + "user.meta");
    }

    public File c(String str) {
        return new File(this.b, str + "keys.meta");
    }

    private static qe d(String str) {
        JSONObject jSONObject = new JSONObject(str);
        return new qe(a(jSONObject, "userId"), a(jSONObject, "userName"), a(jSONObject, "userEmail"));
    }

    private static String a(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, null);
    }
}
