package defpackage;

import defpackage.abn;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class bon implements bol {
    private final bln a;

    public bon(bln blnVar) {
        this.a = blnVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.bol
    public JSONObject a() throws Throwable {
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        abn.b bVar = 0;
        FileInputStream fileInputStream2 = null;
        blh.h().a("Fabric", "Reading cached settings...");
        try {
            try {
                File file = new File(new boc(this.a).a(), "com.crashlytics.settings.json");
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        jSONObject = new JSONObject(bme.a((InputStream) fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e) {
                        e = e;
                        blh.h().e("Fabric", "Failed to fetch cached settings", e);
                        bme.a((Closeable) fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    blh.h().a("Fabric", "No cached settings found.");
                    jSONObject = null;
                }
                bme.a((Closeable) fileInputStream2, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                bme.a((Closeable) bVar, "Error while closing settings cache file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bVar = "Fabric";
            bme.a((Closeable) bVar, "Error while closing settings cache file.");
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3 */
    @Override // defpackage.bol
    public void a(long j, JSONObject jSONObject) throws Throwable {
        FileWriter fileWriter;
        Object obj = "Fabric";
        blh.h().a("Fabric", "Writing settings to cache file...");
        if (jSONObject != null) {
            ?? r2 = 0;
            try {
                try {
                    jSONObject.put("expires_at", j);
                    fileWriter = new FileWriter(new File(new boc(this.a).a(), "com.crashlytics.settings.json"));
                } catch (Exception e) {
                    e = e;
                    fileWriter = null;
                } catch (Throwable th) {
                    th = th;
                    bme.a((Closeable) r2, "Failed to close settings writer.");
                    throw th;
                }
                try {
                    fileWriter.write(jSONObject.toString());
                    fileWriter.flush();
                    bme.a((Closeable) fileWriter, "Failed to close settings writer.");
                    obj = fileWriter;
                } catch (Exception e2) {
                    e = e2;
                    blh.h().e("Fabric", "Failed to cache settings", e);
                    bme.a((Closeable) fileWriter, "Failed to close settings writer.");
                    obj = fileWriter;
                }
            } catch (Throwable th2) {
                th = th2;
                r2 = obj;
                bme.a((Closeable) r2, "Failed to close settings writer.");
                throw th;
            }
        }
    }
}
