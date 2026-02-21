package defpackage;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class bmn implements Closeable {
    private static final Logger b = Logger.getLogger(bmn.class.getName());
    int a;
    private final RandomAccessFile c;
    private int d;
    private a e;
    private a f;
    private final byte[] g = new byte[16];

    public interface c {
        void a(InputStream inputStream, int i);
    }

    public bmn(File file) throws IOException {
        if (!file.exists()) {
            a(file);
        }
        this.c = b(file);
        e();
    }

    private static void b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private static void a(byte[] bArr, int... iArr) {
        int i = 0;
        for (int i2 : iArr) {
            b(bArr, i, i2);
            i += 4;
        }
    }

    private static int a(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    private void e() throws IOException {
        this.c.seek(0L);
        this.c.readFully(this.g);
        this.a = a(this.g, 0);
        if (this.a > this.c.length()) {
            throw new IOException("File is truncated. Expected length: " + this.a + ", Actual length: " + this.c.length());
        }
        this.d = a(this.g, 4);
        int iA = a(this.g, 8);
        int iA2 = a(this.g, 12);
        this.e = a(iA);
        this.f = a(iA2);
    }

    private void a(int i, int i2, int i3, int i4) throws IOException {
        a(this.g, i, i2, i3, i4);
        this.c.seek(0L);
        this.c.write(this.g);
    }

    private a a(int i) throws IOException {
        if (i == 0) {
            return a.a;
        }
        this.c.seek(i);
        return new a(i, this.c.readInt());
    }

    private static void a(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile randomAccessFileB = b(file2);
        try {
            randomAccessFileB.setLength(4096L);
            randomAccessFileB.seek(0L);
            byte[] bArr = new byte[16];
            a(bArr, 4096, 0, 0, 0);
            randomAccessFileB.write(bArr);
            randomAccessFileB.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            randomAccessFileB.close();
            throw th;
        }
    }

    private static RandomAccessFile b(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i) {
        return i < this.a ? i : (i + 16) - this.a;
    }

    private void a(int i, byte[] bArr, int i2, int i3) throws IOException {
        int iB = b(i);
        if (iB + i3 <= this.a) {
            this.c.seek(iB);
            this.c.write(bArr, i2, i3);
            return;
        }
        int i4 = this.a - iB;
        this.c.seek(iB);
        this.c.write(bArr, i2, i4);
        this.c.seek(16L);
        this.c.write(bArr, i2 + i4, i3 - i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, byte[] bArr, int i2, int i3) throws IOException {
        int iB = b(i);
        if (iB + i3 <= this.a) {
            this.c.seek(iB);
            this.c.readFully(bArr, i2, i3);
            return;
        }
        int i4 = this.a - iB;
        this.c.seek(iB);
        this.c.readFully(bArr, i2, i4);
        this.c.seek(16L);
        this.c.readFully(bArr, i2 + i4, i3 - i4);
    }

    public void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    public synchronized void a(byte[] bArr, int i, int i2) {
        b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        c(i2);
        boolean zB = b();
        a aVar = new a(zB ? 16 : b(this.f.b + 4 + this.f.c), i2);
        b(this.g, 0, i2);
        a(aVar.b, this.g, 0, 4);
        a(aVar.b + 4, bArr, i, i2);
        a(this.a, this.d + 1, zB ? aVar.b : this.e.b, aVar.b);
        this.f = aVar;
        this.d++;
        if (zB) {
            this.e = this.f;
        }
    }

    public int a() {
        if (this.d == 0) {
            return 16;
        }
        if (this.f.b >= this.e.b) {
            return (this.f.b - this.e.b) + 4 + this.f.c + 16;
        }
        return (((this.f.b + 4) + this.f.c) + this.a) - this.e.b;
    }

    private int f() {
        return this.a - a();
    }

    public synchronized boolean b() {
        return this.d == 0;
    }

    private void c(int i) throws IOException {
        int i2 = i + 4;
        int iF = f();
        if (iF < i2) {
            int i3 = this.a;
            do {
                iF += i3;
                i3 <<= 1;
            } while (iF < i2);
            d(i3);
            int iB = b(this.f.b + 4 + this.f.c);
            if (iB < this.e.b) {
                FileChannel channel = this.c.getChannel();
                channel.position(this.a);
                int i4 = iB - 4;
                if (channel.transferTo(16L, i4, channel) != i4) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.f.b < this.e.b) {
                int i5 = (this.a + this.f.b) - 16;
                a(i3, this.d, this.e.b, i5);
                this.f = new a(i5, this.f.c);
            } else {
                a(i3, this.d, this.e.b, this.f.b);
            }
            this.a = i3;
        }
    }

    private void d(int i) throws IOException {
        this.c.setLength(i);
        this.c.getChannel().force(true);
    }

    public synchronized void a(c cVar) {
        int iB = this.e.b;
        for (int i = 0; i < this.d; i++) {
            a aVarA = a(iB);
            cVar.a(new b(aVarA), aVarA.c);
            iB = b(aVarA.c + aVarA.b + 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T b(T t, String str) {
        if (t == null) {
            throw new NullPointerException(str);
        }
        return t;
    }

    final class b extends InputStream {
        private int b;
        private int c;

        private b(a aVar) {
            this.b = bmn.this.b(aVar.b + 4);
            this.c = aVar.c;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            bmn.b(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (this.c <= 0) {
                return -1;
            }
            if (i2 > this.c) {
                i2 = this.c;
            }
            bmn.this.b(this.b, bArr, i, i2);
            this.b = bmn.this.b(this.b + i2);
            this.c -= i2;
            return i2;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.c != 0) {
                bmn.this.c.seek(this.b);
                int i = bmn.this.c.read();
                this.b = bmn.this.b(this.b + 1);
                this.c--;
                return i;
            }
            return -1;
        }
    }

    public synchronized void c() {
        if (b()) {
            throw new NoSuchElementException();
        }
        if (this.d == 1) {
            d();
        } else {
            int iB = b(this.e.b + 4 + this.e.c);
            b(iB, this.g, 0, 4);
            int iA = a(this.g, 0);
            a(this.a, this.d - 1, iB, this.f.b);
            this.d--;
            this.e = new a(iB, iA);
        }
    }

    public synchronized void d() {
        a(4096, 0, 0, 0);
        this.d = 0;
        this.e = a.a;
        this.f = a.a;
        if (this.a > 4096) {
            d(4096);
        }
        this.a = 4096;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.c.close();
    }

    public boolean a(int i, int i2) {
        return (a() + 4) + i <= i2;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append('[');
        sb.append("fileLength=").append(this.a);
        sb.append(", size=").append(this.d);
        sb.append(", first=").append(this.e);
        sb.append(", last=").append(this.f);
        sb.append(", element lengths=[");
        try {
            a(new c() { // from class: bmn.1
                boolean a = true;

                @Override // bmn.c
                public void a(InputStream inputStream, int i) {
                    if (this.a) {
                        this.a = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i);
                }
            });
        } catch (IOException e) {
            b.log(Level.WARNING, "read error", (Throwable) e);
        }
        sb.append("]]");
        return sb.toString();
    }

    static class a {
        static final a a = new a(0, 0);
        final int b;
        final int c;

        a(int i, int i2) {
            this.b = i;
            this.c = i2;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.b + ", length = " + this.c + "]";
        }
    }
}
