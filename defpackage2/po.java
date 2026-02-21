package defpackage;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
final class po {
    static byte[] a(File file) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        byte[] bArrA = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            fileInputStream = null;
        } catch (IOException e2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
        }
        try {
            bArrA = a(fileInputStream);
            bme.a((Closeable) fileInputStream);
        } catch (FileNotFoundException e3) {
            bme.a((Closeable) fileInputStream);
        } catch (IOException e4) {
            bme.a((Closeable) fileInputStream);
        } catch (Throwable th3) {
            th = th3;
            bme.a((Closeable) fileInputStream);
            throw th;
        }
        return bArrA;
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private static File a(File file, String str) {
        for (File file2 : file.listFiles()) {
            if (file2.getName().endsWith(str)) {
                return file2;
            }
        }
        return null;
    }

    static byte[] b(File file) {
        File fileA = a(file, ".dmp");
        return fileA == null ? new byte[0] : d(fileA);
    }

    private static byte[] d(File file) {
        return a(file);
    }

    static byte[] a(File file, Context context) {
        File fileA = a(file, ".binary_libs");
        if (fileA == null) {
            return null;
        }
        return b(fileA, context);
    }

    private static byte[] b(File file, Context context) throws Throwable {
        byte[] bArrA = a(file);
        if (bArrA == null || bArrA.length == 0) {
            return null;
        }
        return a(context, new String(bArrA));
    }

    static byte[] c(File file) {
        File fileA = a(file, ".device_info");
        if (fileA == null) {
            return null;
        }
        return a(fileA);
    }

    private static byte[] a(Context context, String str) {
        return new ok(context, new qa()).a(str);
    }
}
