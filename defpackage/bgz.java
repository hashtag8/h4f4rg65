package defpackage;

import defpackage.bgu;
import defpackage.bgy;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class bgz implements bhj {
    private static final Logger a = Logger.getLogger(b.class.getName());
    private static final bqv b = bqv.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    @Override // defpackage.bhj
    public bgu a(bqu bquVar, boolean z) {
        return new c(bquVar, 4096, z);
    }

    @Override // defpackage.bhj
    public bgv a(bqt bqtVar, boolean z) {
        return new d(bqtVar, z);
    }

    static final class c implements bgu {
        final bgy.a a;
        private final bqu b;
        private final a c;
        private final boolean d;

        c(bqu bquVar, int i, boolean z) {
            this.b = bquVar;
            this.d = z;
            this.c = new a(this.b);
            this.a = new bgy.a(i, this.c);
        }

        @Override // defpackage.bgu
        public void a() throws IOException {
            if (!this.d) {
                bqv bqvVarC = this.b.c(bgz.b.f());
                if (bgz.a.isLoggable(Level.FINE)) {
                    bgz.a.fine(String.format("<< CONNECTION %s", bqvVarC.d()));
                }
                if (!bgz.b.equals(bqvVarC)) {
                    throw bgz.d("Expected a connection header but was %s", bqvVarC.a());
                }
            }
        }

        @Override // defpackage.bgu
        public boolean a(bgu.a aVar) throws IOException {
            try {
                this.b.a(9L);
                int iB = bgz.b(this.b);
                if (iB < 0 || iB > 16384) {
                    throw bgz.d("FRAME_SIZE_ERROR: %s", Integer.valueOf(iB));
                }
                byte bI = (byte) (this.b.i() & 255);
                byte bI2 = (byte) (this.b.i() & 255);
                int iK = this.b.k() & Integer.MAX_VALUE;
                if (bgz.a.isLoggable(Level.FINE)) {
                    bgz.a.fine(b.a(true, iK, iB, bI, bI2));
                }
                switch (bI) {
                    case 0:
                        b(aVar, iB, bI2, iK);
                        return true;
                    case 1:
                        a(aVar, iB, bI2, iK);
                        return true;
                    case 2:
                        c(aVar, iB, bI2, iK);
                        return true;
                    case 3:
                        d(aVar, iB, bI2, iK);
                        return true;
                    case 4:
                        e(aVar, iB, bI2, iK);
                        return true;
                    case 5:
                        f(aVar, iB, bI2, iK);
                        return true;
                    case 6:
                        g(aVar, iB, bI2, iK);
                        return true;
                    case 7:
                        h(aVar, iB, bI2, iK);
                        return true;
                    case 8:
                        i(aVar, iB, bI2, iK);
                        return true;
                    default:
                        this.b.g(iB);
                        return true;
                }
            } catch (IOException e) {
                return false;
            }
        }

        private void a(bgu.a aVar, int i, byte b, int i2) throws IOException {
            if (i2 == 0) {
                throw bgz.d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            boolean z = (b & 1) != 0;
            short sI = (b & 8) != 0 ? (short) (this.b.i() & 255) : (short) 0;
            if ((b & 32) != 0) {
                a(aVar, i2);
                i -= 5;
            }
            aVar.a(false, z, i2, -1, a(bgz.b(i, b, sI), sI, b, i2), bgx.HTTP_20_HEADERS);
        }

        private List<bgw> a(int i, short s, byte b, int i2) throws IOException {
            a aVar = this.c;
            this.c.d = i;
            aVar.a = i;
            this.c.e = s;
            this.c.b = b;
            this.c.c = i2;
            this.a.a();
            return this.a.b();
        }

        private void b(bgu.a aVar, int i, byte b, int i2) throws IOException {
            boolean z = (b & 1) != 0;
            if ((b & 32) != 0) {
                throw bgz.d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            short sI = (b & 8) != 0 ? (short) (this.b.i() & 255) : (short) 0;
            aVar.a(z, i2, this.b, bgz.b(i, b, sI));
            this.b.g(sI);
        }

        private void c(bgu.a aVar, int i, byte b, int i2) throws IOException {
            if (i != 5) {
                throw bgz.d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
            }
            if (i2 == 0) {
                throw bgz.d("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
            a(aVar, i2);
        }

        private void a(bgu.a aVar, int i) {
            int iK = this.b.k();
            aVar.a(i, iK & Integer.MAX_VALUE, (this.b.i() & 255) + 1, (Integer.MIN_VALUE & iK) != 0);
        }

        private void d(bgu.a aVar, int i, byte b, int i2) throws IOException {
            if (i != 4) {
                throw bgz.d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
            }
            if (i2 == 0) {
                throw bgz.d("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            int iK = this.b.k();
            bgt bgtVarB = bgt.b(iK);
            if (bgtVarB == null) {
                throw bgz.d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iK));
            }
            aVar.a(i2, bgtVarB);
        }

        private void e(bgu.a aVar, int i, byte b, int i2) throws IOException {
            if (i2 != 0) {
                throw bgz.d("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            if ((b & 1) != 0) {
                if (i != 0) {
                    throw bgz.d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                }
                aVar.b();
                return;
            }
            if (i % 6 != 0) {
                throw bgz.d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            }
            bhf bhfVar = new bhf();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short sJ = this.b.j();
                int iK = this.b.k();
                switch (sJ) {
                    case 1:
                    case 6:
                        break;
                    case 2:
                        if (iK != 0 && iK != 1) {
                            throw bgz.d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                        break;
                        break;
                    case 3:
                        sJ = 4;
                        break;
                    case 4:
                        sJ = 7;
                        if (iK < 0) {
                            throw bgz.d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                        break;
                        break;
                    case 5:
                        if (iK < 16384 || iK > 16777215) {
                            throw bgz.d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(iK));
                        }
                        break;
                        break;
                    default:
                        throw bgz.d("PROTOCOL_ERROR invalid settings id: %s", Short.valueOf(sJ));
                }
                bhfVar.a(sJ, 0, iK);
            }
            aVar.a(false, bhfVar);
            if (bhfVar.c() >= 0) {
                this.a.a(bhfVar.c());
            }
        }

        private void f(bgu.a aVar, int i, byte b, int i2) throws IOException {
            if (i2 == 0) {
                throw bgz.d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            }
            short sI = (b & 8) != 0 ? (short) (this.b.i() & 255) : (short) 0;
            aVar.a(i2, this.b.k() & Integer.MAX_VALUE, a(bgz.b(i - 4, b, sI), sI, b, i2));
        }

        private void g(bgu.a aVar, int i, byte b, int i2) throws IOException {
            if (i != 8) {
                throw bgz.d("TYPE_PING length != 8: %s", Integer.valueOf(i));
            }
            if (i2 != 0) {
                throw bgz.d("TYPE_PING streamId != 0", new Object[0]);
            }
            aVar.a((b & 1) != 0, this.b.k(), this.b.k());
        }

        private void h(bgu.a aVar, int i, byte b, int i2) throws IOException {
            if (i < 8) {
                throw bgz.d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            }
            if (i2 != 0) {
                throw bgz.d("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
            int iK = this.b.k();
            int iK2 = this.b.k();
            int i3 = i - 8;
            bgt bgtVarB = bgt.b(iK2);
            if (bgtVarB == null) {
                throw bgz.d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iK2));
            }
            bqv bqvVarC = bqv.b;
            if (i3 > 0) {
                bqvVarC = this.b.c(i3);
            }
            aVar.a(iK, bgtVarB, bqvVarC);
        }

        private void i(bgu.a aVar, int i, byte b, int i2) throws IOException {
            if (i != 4) {
                throw bgz.d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
            }
            long jK = ((long) this.b.k()) & 2147483647L;
            if (jK == 0) {
                throw bgz.d("windowSizeIncrement was 0", Long.valueOf(jK));
            }
            aVar.a(i2, jK);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.b.close();
        }
    }

    static final class d implements bgv {
        private final bqt a;
        private final boolean b;
        private final bqs c = new bqs();
        private final bgy.b d = new bgy.b(this.c);
        private int e = 16384;
        private boolean f;

        d(bqt bqtVar, boolean z) {
            this.a = bqtVar;
            this.b = z;
        }

        @Override // defpackage.bgv
        public synchronized void b() {
            if (this.f) {
                throw new IOException("closed");
            }
            this.a.flush();
        }

        @Override // defpackage.bgv
        public synchronized void a(bhf bhfVar) {
            if (this.f) {
                throw new IOException("closed");
            }
            this.e = bhfVar.d(this.e);
            a(0, 0, (byte) 4, (byte) 1);
            this.a.flush();
        }

        @Override // defpackage.bgv
        public synchronized void a() {
            if (this.f) {
                throw new IOException("closed");
            }
            if (this.b) {
                if (bgz.a.isLoggable(Level.FINE)) {
                    bgz.a.fine(String.format(">> CONNECTION %s", bgz.b.d()));
                }
                this.a.c(bgz.b.g());
                this.a.flush();
            }
        }

        @Override // defpackage.bgv
        public synchronized void a(boolean z, boolean z2, int i, int i2, List<bgw> list) {
            if (z2) {
                throw new UnsupportedOperationException();
            }
            if (this.f) {
                throw new IOException("closed");
            }
            a(z, i, list);
        }

        @Override // defpackage.bgv
        public synchronized void a(int i, int i2, List<bgw> list) {
            if (this.f) {
                throw new IOException("closed");
            }
            if (this.c.b() != 0) {
                throw new IllegalStateException();
            }
            this.d.a(list);
            long jB = this.c.b();
            int iMin = (int) Math.min(this.e - 4, jB);
            a(i, iMin + 4, (byte) 5, jB == ((long) iMin) ? (byte) 4 : (byte) 0);
            this.a.f(Integer.MAX_VALUE & i2);
            this.a.a_(this.c, iMin);
            if (jB > iMin) {
                b(i, jB - ((long) iMin));
            }
        }

        void a(boolean z, int i, List<bgw> list) throws IOException {
            if (this.f) {
                throw new IOException("closed");
            }
            if (this.c.b() != 0) {
                throw new IllegalStateException();
            }
            this.d.a(list);
            long jB = this.c.b();
            int iMin = (int) Math.min(this.e, jB);
            byte b = jB == ((long) iMin) ? (byte) 4 : (byte) 0;
            if (z) {
                b = (byte) (b | 1);
            }
            a(i, iMin, (byte) 1, b);
            this.a.a_(this.c, iMin);
            if (jB > iMin) {
                b(i, jB - ((long) iMin));
            }
        }

        private void b(int i, long j) {
            while (j > 0) {
                int iMin = (int) Math.min(this.e, j);
                j -= (long) iMin;
                a(i, iMin, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
                this.a.a_(this.c, iMin);
            }
        }

        @Override // defpackage.bgv
        public synchronized void a(int i, bgt bgtVar) {
            if (this.f) {
                throw new IOException("closed");
            }
            if (bgtVar.t == -1) {
                throw new IllegalArgumentException();
            }
            a(i, 4, (byte) 3, (byte) 0);
            this.a.f(bgtVar.s);
            this.a.flush();
        }

        @Override // defpackage.bgv
        public int c() {
            return this.e;
        }

        @Override // defpackage.bgv
        public synchronized void a(boolean z, int i, bqs bqsVar, int i2) {
            if (this.f) {
                throw new IOException("closed");
            }
            a(i, z ? (byte) 1 : (byte) 0, bqsVar, i2);
        }

        void a(int i, byte b, bqs bqsVar, int i2) {
            a(i, i2, (byte) 0, b);
            if (i2 > 0) {
                this.a.a_(bqsVar, i2);
            }
        }

        @Override // defpackage.bgv
        public synchronized void b(bhf bhfVar) {
            int i;
            int i2 = 0;
            synchronized (this) {
                if (this.f) {
                    throw new IOException("closed");
                }
                a(0, bhfVar.b() * 6, (byte) 4, (byte) 0);
                while (i2 < 10) {
                    if (bhfVar.a(i2)) {
                        if (i2 == 4) {
                            i = 3;
                        } else {
                            i = i2 == 7 ? 4 : i2;
                        }
                        this.a.g(i);
                        this.a.f(bhfVar.b(i2));
                    }
                    i2++;
                }
                this.a.flush();
            }
        }

        @Override // defpackage.bgv
        public synchronized void a(boolean z, int i, int i2) {
            synchronized (this) {
                if (this.f) {
                    throw new IOException("closed");
                }
                a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
                this.a.f(i);
                this.a.f(i2);
                this.a.flush();
            }
        }

        @Override // defpackage.bgv
        public synchronized void a(int i, bgt bgtVar, byte[] bArr) {
            if (this.f) {
                throw new IOException("closed");
            }
            if (bgtVar.s == -1) {
                throw bgz.c("errorCode.httpCode == -1", new Object[0]);
            }
            a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.a.f(i);
            this.a.f(bgtVar.s);
            if (bArr.length > 0) {
                this.a.c(bArr);
            }
            this.a.flush();
        }

        @Override // defpackage.bgv
        public synchronized void a(int i, long j) {
            if (this.f) {
                throw new IOException("closed");
            }
            if (j == 0 || j > 2147483647L) {
                throw bgz.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            }
            a(i, 4, (byte) 8, (byte) 0);
            this.a.f((int) j);
            this.a.flush();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            this.f = true;
            this.a.close();
        }

        void a(int i, int i2, byte b, byte b2) {
            if (bgz.a.isLoggable(Level.FINE)) {
                bgz.a.fine(b.a(false, i, i2, b, b2));
            }
            if (i2 > this.e) {
                throw bgz.c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(this.e), Integer.valueOf(i2));
            }
            if ((Integer.MIN_VALUE & i) != 0) {
                throw bgz.c("reserved bit set: %s", Integer.valueOf(i));
            }
            bgz.b(this.a, i2);
            this.a.h(b & 255);
            this.a.h(b2 & 255);
            this.a.f(Integer.MAX_VALUE & i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IllegalArgumentException c(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IOException d(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(str, objArr));
    }

    static final class a implements bri {
        int a;
        byte b;
        int c;
        int d;
        short e;
        private final bqu f;

        public a(bqu bquVar) {
            this.f = bquVar;
        }

        @Override // defpackage.bri
        public long a(bqs bqsVar, long j) throws IOException {
            while (this.d == 0) {
                this.f.g(this.e);
                this.e = (short) 0;
                if ((this.b & 4) != 0) {
                    return -1L;
                }
                b();
            }
            long jA = this.f.a(bqsVar, Math.min(j, this.d));
            if (jA == -1) {
                return -1L;
            }
            this.d = (int) (((long) this.d) - jA);
            return jA;
        }

        @Override // defpackage.bri
        public brj a() {
            return this.f.a();
        }

        @Override // defpackage.bri, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        private void b() throws IOException {
            int i = this.c;
            int iB = bgz.b(this.f);
            this.d = iB;
            this.a = iB;
            byte bI = (byte) (this.f.i() & 255);
            this.b = (byte) (this.f.i() & 255);
            if (bgz.a.isLoggable(Level.FINE)) {
                bgz.a.fine(b.a(true, this.c, this.a, bI, this.b));
            }
            this.c = this.f.k() & Integer.MAX_VALUE;
            if (bI != 9) {
                throw bgz.d("%s != TYPE_CONTINUATION", Byte.valueOf(bI));
            }
            if (this.c != i) {
                throw bgz.d("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s > i) {
            throw d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        }
        return (short) (i - s);
    }

    static final class b {
        private static final String[] a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        private static final String[] b = new String[64];
        private static final String[] c = new String[256];

        b() {
        }

        static String a(boolean z, int i, int i2, byte b2, byte b3) {
            String str = b2 < a.length ? a[b2] : String.format("0x%02x", Byte.valueOf(b2));
            String strA = a(b2, b3);
            Object[] objArr = new Object[5];
            objArr[0] = z ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = str;
            objArr[4] = strA;
            return String.format("%s 0x%08x %5d %-13s %s", objArr);
        }

        static String a(byte b2, byte b3) {
            if (b3 == 0) {
                return "";
            }
            switch (b2) {
                case 2:
                case 3:
                case 7:
                case 8:
                    return c[b3];
                case 4:
                case 6:
                    return b3 == 1 ? "ACK" : c[b3];
                case 5:
                default:
                    String str = b3 < b.length ? b[b3] : c[b3];
                    if (b2 == 5 && (b3 & 4) != 0) {
                        return str.replace("HEADERS", "PUSH_PROMISE");
                    }
                    if (b2 == 0 && (b3 & 32) != 0) {
                        return str.replace("PRIORITY", "COMPRESSED");
                    }
                    return str;
            }
        }

        static {
            for (int i = 0; i < c.length; i++) {
                c[i] = String.format("%8s", Integer.toBinaryString(i)).replace(' ', '0');
            }
            b[0] = "";
            b[1] = "END_STREAM";
            int[] iArr = {1};
            b[8] = "PADDED";
            for (int i2 : iArr) {
                b[i2 | 8] = b[i2] + "|PADDED";
            }
            b[4] = "END_HEADERS";
            b[32] = "PRIORITY";
            b[36] = "END_HEADERS|PRIORITY";
            for (int i3 : new int[]{4, 32, 36}) {
                for (int i4 : iArr) {
                    b[i4 | i3] = b[i4] + '|' + b[i3];
                    b[i4 | i3 | 8] = b[i4] + '|' + b[i3] + "|PADDED";
                }
            }
            for (int i5 = 0; i5 < b.length; i5++) {
                if (b[i5] == null) {
                    b[i5] = c[i5];
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(bqu bquVar) {
        return ((bquVar.i() & 255) << 16) | ((bquVar.i() & 255) << 8) | (bquVar.i() & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(bqt bqtVar, int i) {
        bqtVar.h((i >>> 16) & 255);
        bqtVar.h((i >>> 8) & 255);
        bqtVar.h(i & 255);
    }
}
