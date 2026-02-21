package defpackage;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.http.entity.mime.MIME;

/* JADX INFO: loaded from: classes.dex */
class blj implements Callable<Map<String, blp>> {
    final String a;

    blj(String str) {
        this.a = str;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map<String, blp> call() {
        HashMap map = new HashMap();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        map.putAll(c());
        map.putAll(d());
        blh.h().b("Fabric", "finish scanning in " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        return map;
    }

    private Map<String, blp> c() {
        HashMap map = new HashMap();
        try {
            Class.forName("ra");
            blp blpVar = new blp("com.google.firebase.firebase-ads", "0.0.0", MIME.ENC_BINARY);
            map.put(blpVar.a(), blpVar);
            blh.h().b("Fabric", "Found kit: com.google.firebase.firebase-ads");
        } catch (Exception e) {
        }
        return map;
    }

    private Map<String, blp> d() {
        blp blpVarA;
        HashMap map = new HashMap();
        ZipFile zipFileB = b();
        Enumeration<? extends ZipEntry> enumerationEntries = zipFileB.entries();
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (zipEntryNextElement.getName().startsWith("fabric/") && zipEntryNextElement.getName().length() > "fabric/".length() && (blpVarA = a(zipEntryNextElement, zipFileB)) != null) {
                map.put(blpVarA.a(), blpVarA);
                blh.h().b("Fabric", String.format("Found kit:[%s] version:[%s]", blpVarA.a(), blpVarA.b()));
            }
        }
        if (zipFileB != null) {
            try {
                zipFileB.close();
            } catch (IOException e) {
            }
        }
        return map;
    }

    private blp a(ZipEntry zipEntry, ZipFile zipFile) throws Throwable {
        InputStream inputStream;
        try {
            try {
                inputStream = zipFile.getInputStream(zipEntry);
            } catch (IOException e) {
                e = e;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                bme.a((Closeable) null);
                throw th;
            }
            try {
                Properties properties = new Properties();
                properties.load(inputStream);
                String property = properties.getProperty("fabric-identifier");
                String property2 = properties.getProperty("fabric-version");
                String property3 = properties.getProperty("fabric-build-type");
                if (TextUtils.isEmpty(property) || TextUtils.isEmpty(property2)) {
                    throw new IllegalStateException("Invalid format of fabric file," + zipEntry.getName());
                }
                blp blpVar = new blp(property, property2, property3);
                bme.a((Closeable) inputStream);
                return blpVar;
            } catch (IOException e2) {
                e = e2;
                blh.h().e("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
                bme.a((Closeable) inputStream);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            bme.a((Closeable) null);
            throw th;
        }
    }

    protected ZipFile b() {
        return new ZipFile(this.a);
    }
}
