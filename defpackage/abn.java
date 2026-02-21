package defpackage;

import android.os.SystemClock;
import defpackage.wl;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class abn implements wl {
    private final Map<String, a> a;
    private long b;
    private final File c;
    private final int d;

    static class a {
        public long a;
        public String b;
        public String c;
        public long d;
        public long e;
        public long f;
        public long g;
        public Map<String, String> h;

        private a() {
        }

        public a(String str, wl.a aVar) {
            this.b = str;
            this.a = aVar.a.length;
            this.c = aVar.b;
            this.d = aVar.c;
            this.e = aVar.d;
            this.f = aVar.e;
            this.g = aVar.f;
            this.h = aVar.g;
        }

        public static a a(InputStream inputStream) throws IOException {
            a aVar = new a();
            if (abn.a(inputStream) != 538247942) {
                throw new IOException();
            }
            aVar.b = abn.c(inputStream);
            aVar.c = abn.c(inputStream);
            if (aVar.c.equals("")) {
                aVar.c = null;
            }
            aVar.d = abn.b(inputStream);
            aVar.e = abn.b(inputStream);
            aVar.f = abn.b(inputStream);
            aVar.g = abn.b(inputStream);
            aVar.h = abn.d(inputStream);
            return aVar;
        }

        public wl.a a(byte[] bArr) {
            wl.a aVar = new wl.a();
            aVar.a = bArr;
            aVar.b = this.c;
            aVar.c = this.d;
            aVar.d = this.e;
            aVar.e = this.f;
            aVar.f = this.g;
            aVar.g = this.h;
            return aVar;
        }

        public boolean a(OutputStream outputStream) {
            try {
                abn.a(outputStream, 538247942);
                abn.a(outputStream, this.b);
                abn.a(outputStream, this.c == null ? "" : this.c);
                abn.a(outputStream, this.d);
                abn.a(outputStream, this.e);
                abn.a(outputStream, this.f);
                abn.a(outputStream, this.g);
                abn.a(this.h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                abk.b("%s", e.toString());
                return false;
            }
        }
    }

    static class b extends FilterInputStream {
        private int a;

        private b(InputStream inputStream) {
            super(inputStream);
            this.a = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i = super.read();
            if (i != -1) {
                this.a++;
            }
            return i;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = super.read(bArr, i, i2);
            if (i3 != -1) {
                this.a += i3;
            }
            return i3;
        }
    }

    public abn(File file) {
        this(file, 5242880);
    }

    public abn(File file, int i) {
        this.a = new LinkedHashMap(16, 0.75f, true);
        this.b = 0L;
        this.c = file;
        this.d = i;
    }

    static int a(InputStream inputStream) {
        return 0 | (e(inputStream) << 0) | (e(inputStream) << 8) | (e(inputStream) << 16) | (e(inputStream) << 24);
    }

    private void a(int i) {
        int i2;
        if (this.b + ((long) i) < this.d) {
            return;
        }
        if (abk.b) {
            abk.a("Pruning old cache entries.", new Object[0]);
        }
        long j = this.b;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.a.entrySet().iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = i3;
                break;
            }
            a value = it.next().getValue();
            if (c(value.b).delete()) {
                this.b -= value.a;
            } else {
                abk.b("Could not delete cache entry for key=%s, filename=%s", value.b, d(value.b));
            }
            it.remove();
            i2 = i3 + 1;
            if (this.b + ((long) i) < this.d * 0.9f) {
                break;
            } else {
                i3 = i2;
            }
        }
        if (abk.b) {
            abk.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.b - j), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    static void a(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static void a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes(HTTP.UTF_8);
        a(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void a(String str, a aVar) {
        if (this.a.containsKey(str)) {
            this.b = (aVar.a - this.a.get(str).a) + this.b;
        } else {
            this.b += aVar.a;
        }
        this.a.put(str, aVar);
    }

    static void a(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map == null) {
            a(outputStream, 0);
            return;
        }
        a(outputStream, map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            a(outputStream, entry.getKey());
            a(outputStream, entry.getValue());
        }
    }

    private static byte[] a(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 == -1) {
                break;
            }
            i2 += i3;
        }
        if (i2 != i) {
            throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
        }
        return bArr;
    }

    static long b(InputStream inputStream) {
        return 0 | ((((long) e(inputStream)) & 255) << 0) | ((((long) e(inputStream)) & 255) << 8) | ((((long) e(inputStream)) & 255) << 16) | ((((long) e(inputStream)) & 255) << 24) | ((((long) e(inputStream)) & 255) << 32) | ((((long) e(inputStream)) & 255) << 40) | ((((long) e(inputStream)) & 255) << 48) | ((((long) e(inputStream)) & 255) << 56);
    }

    static String c(InputStream inputStream) {
        return new String(a(inputStream, (int) b(inputStream)), HTTP.UTF_8);
    }

    private String d(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    static Map<String, String> d(InputStream inputStream) {
        int iA = a(inputStream);
        Map<String, String> mapEmptyMap = iA == 0 ? Collections.emptyMap() : new HashMap<>(iA);
        for (int i = 0; i < iA; i++) {
            mapEmptyMap.put(c(inputStream).intern(), c(inputStream).intern());
        }
        return mapEmptyMap;
    }

    private static int e(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i == -1) {
            throw new EOFException();
        }
        return i;
    }

    private void e(String str) {
        a aVar = this.a.get(str);
        if (aVar != null) {
            this.b -= aVar.a;
            this.a.remove(str);
        }
    }

    @Override // defpackage.wl
    public synchronized wl.a a(String str) {
        b bVar;
        wl.a aVarA;
        a aVar = this.a.get(str);
        if (aVar == null) {
            aVarA = null;
        } else {
            try {
                File fileC = c(str);
                try {
                    bVar = new b(new FileInputStream(fileC));
                } catch (IOException e) {
                    e = e;
                    bVar = null;
                } catch (Throwable th) {
                    th = th;
                    bVar = null;
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (IOException e2) {
                            aVarA = null;
                        }
                    }
                    throw th;
                }
                try {
                    a.a(bVar);
                    aVarA = aVar.a(a(bVar, (int) (fileC.length() - ((long) bVar.a))));
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (IOException e3) {
                            aVarA = null;
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    abk.b("%s: %s", fileC.getAbsolutePath(), e.toString());
                    b(str);
                    if (bVar != null) {
                        try {
                            bVar.close();
                            aVarA = null;
                        } catch (IOException e5) {
                            aVarA = null;
                        }
                    } else {
                        aVarA = null;
                    }
                    return aVarA;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return aVarA;
    }

    @Override // defpackage.wl
    public synchronized void a() {
        BufferedInputStream bufferedInputStream;
        if (this.c.exists()) {
            File[] fileArrListFiles = this.c.listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    BufferedInputStream bufferedInputStream2 = null;
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    } catch (IOException e) {
                        bufferedInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        try {
                            a aVarA = a.a(bufferedInputStream);
                            aVarA.a = file.length();
                            a(aVarA.b, aVarA);
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e2) {
                                }
                            }
                        } catch (Throwable th2) {
                            bufferedInputStream2 = bufferedInputStream;
                            th = th2;
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e3) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e4) {
                        if (file != null) {
                            file.delete();
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                    }
                }
            }
        } else if (!this.c.mkdirs()) {
            abk.c("Unable to create cache dir %s", this.c.getAbsolutePath());
        }
    }

    @Override // defpackage.wl
    public synchronized void a(String str, wl.a aVar) {
        FileOutputStream fileOutputStream;
        a aVar2;
        a(aVar.a.length);
        File fileC = c(str);
        try {
            fileOutputStream = new FileOutputStream(fileC);
            aVar2 = new a(str, aVar);
        } catch (IOException e) {
            if (!fileC.delete()) {
                abk.b("Could not clean up file %s", fileC.getAbsolutePath());
            }
        }
        if (!aVar2.a(fileOutputStream)) {
            fileOutputStream.close();
            abk.b("Failed to write header for %s", fileC.getAbsolutePath());
            throw new IOException();
        }
        fileOutputStream.write(aVar.a);
        fileOutputStream.close();
        a(str, aVar2);
    }

    public synchronized void b(String str) {
        boolean zDelete = c(str).delete();
        e(str);
        if (!zDelete) {
            abk.b("Could not delete cache entry for key=%s, filename=%s", str, d(str));
        }
    }

    public File c(String str) {
        return new File(this.c, d(str));
    }
}
