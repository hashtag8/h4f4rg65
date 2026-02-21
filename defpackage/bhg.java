package defpackage;

import defpackage.bgu;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.List;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes.dex */
public final class bhg implements bhj {
    static final byte[] a;

    static {
        try {
            a = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(bfw.c.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError();
        }
    }

    @Override // defpackage.bhj
    public bgu a(bqu bquVar, boolean z) {
        return new a(bquVar, z);
    }

    @Override // defpackage.bhj
    public bgv a(bqt bqtVar, boolean z) {
        return new b(bqtVar, z);
    }

    static final class a implements bgu {
        private final bqu a;
        private final boolean b;
        private final bhc c;

        a(bqu bquVar, boolean z) {
            this.a = bquVar;
            this.c = new bhc(this.a);
            this.b = z;
        }

        @Override // defpackage.bgu
        public void a() {
        }

        @Override // defpackage.bgu
        public boolean a(bgu.a aVar) throws IOException {
            try {
                int iK = this.a.k();
                int iK2 = this.a.k();
                int i = ((-16777216) & iK2) >>> 24;
                int i2 = iK2 & 16777215;
                if ((Integer.MIN_VALUE & iK) != 0) {
                    int i3 = (2147418112 & iK) >>> 16;
                    int i4 = 65535 & iK;
                    if (i3 != 3) {
                        throw new ProtocolException("version != 3: " + i3);
                    }
                    switch (i4) {
                        case 1:
                            a(aVar, i, i2);
                            return true;
                        case 2:
                            b(aVar, i, i2);
                            return true;
                        case 3:
                            c(aVar, i, i2);
                            return true;
                        case 4:
                            h(aVar, i, i2);
                            return true;
                        case 5:
                        default:
                            this.a.g(i2);
                            return true;
                        case 6:
                            f(aVar, i, i2);
                            return true;
                        case 7:
                            g(aVar, i, i2);
                            return true;
                        case 8:
                            d(aVar, i, i2);
                            return true;
                        case 9:
                            e(aVar, i, i2);
                            return true;
                    }
                }
                aVar.a((i & 1) != 0, Integer.MAX_VALUE & iK, this.a, i2);
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        private void a(bgu.a aVar, int i, int i2) throws IOException {
            int iK = this.a.k() & Integer.MAX_VALUE;
            int iK2 = this.a.k() & Integer.MAX_VALUE;
            this.a.j();
            aVar.a((i & 2) != 0, (i & 1) != 0, iK, iK2, this.c.a(i2 - 10), bgx.SPDY_SYN_STREAM);
        }

        private void b(bgu.a aVar, int i, int i2) throws IOException {
            aVar.a(false, (i & 1) != 0, this.a.k() & Integer.MAX_VALUE, -1, this.c.a(i2 - 4), bgx.SPDY_REPLY);
        }

        private void c(bgu.a aVar, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw a("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i2));
            }
            int iK = this.a.k() & Integer.MAX_VALUE;
            int iK2 = this.a.k();
            bgt bgtVarA = bgt.a(iK2);
            if (bgtVarA == null) {
                throw a("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iK2));
            }
            aVar.a(iK, bgtVarA);
        }

        private void d(bgu.a aVar, int i, int i2) {
            aVar.a(false, false, this.a.k() & Integer.MAX_VALUE, -1, this.c.a(i2 - 4), bgx.SPDY_HEADERS);
        }

        private void e(bgu.a aVar, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw a("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i2));
            }
            int iK = this.a.k() & Integer.MAX_VALUE;
            long jK = this.a.k() & Integer.MAX_VALUE;
            if (jK == 0) {
                throw a("windowSizeIncrement was 0", Long.valueOf(jK));
            }
            aVar.a(iK, jK);
        }

        private void f(bgu.a aVar, int i, int i2) throws IOException {
            if (i2 != 4) {
                throw a("TYPE_PING length: %d != 4", Integer.valueOf(i2));
            }
            int iK = this.a.k();
            aVar.a(this.b == ((iK & 1) == 1), iK, 0);
        }

        private void g(bgu.a aVar, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw a("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i2));
            }
            int iK = this.a.k() & Integer.MAX_VALUE;
            int iK2 = this.a.k();
            bgt bgtVarC = bgt.c(iK2);
            if (bgtVarC == null) {
                throw a("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iK2));
            }
            aVar.a(iK, bgtVarC, bqv.b);
        }

        private void h(bgu.a aVar, int i, int i2) throws IOException {
            int iK = this.a.k();
            if (i2 != (iK * 8) + 4) {
                throw a("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i2), Integer.valueOf(iK));
            }
            bhf bhfVar = new bhf();
            for (int i3 = 0; i3 < iK; i3++) {
                int iK2 = this.a.k();
                bhfVar.a(iK2 & 16777215, ((-16777216) & iK2) >>> 24, this.a.k());
            }
            aVar.a((i & 1) != 0, bhfVar);
        }

        private static IOException a(String str, Object... objArr) throws IOException {
            throw new IOException(String.format(str, objArr));
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.c.a();
        }
    }

    static final class b implements bgv {
        private final bqt a;
        private final bqs b;
        private final bqt c;
        private final boolean d;
        private boolean e;

        b(bqt bqtVar, boolean z) {
            this.a = bqtVar;
            this.d = z;
            Deflater deflater = new Deflater();
            deflater.setDictionary(bhg.a);
            this.b = new bqs();
            this.c = brc.a(new bqw((brh) this.b, deflater));
        }

        @Override // defpackage.bgv
        public void a(bhf bhfVar) {
        }

        @Override // defpackage.bgv
        public void a(int i, int i2, List<bgw> list) {
        }

        @Override // defpackage.bgv
        public synchronized void a() {
        }

        @Override // defpackage.bgv
        public synchronized void b() {
            if (this.e) {
                throw new IOException("closed");
            }
            this.a.flush();
        }

        @Override // defpackage.bgv
        public synchronized void a(boolean z, boolean z2, int i, int i2, List<bgw> list) {
            synchronized (this) {
                if (this.e) {
                    throw new IOException("closed");
                }
                a(list);
                int iB = (int) (10 + this.b.b());
                int i3 = (z2 ? 2 : 0) | (z ? 1 : 0);
                this.a.f(-2147287039);
                this.a.f(((i3 & 255) << 24) | (iB & 16777215));
                this.a.f(i & Integer.MAX_VALUE);
                this.a.f(i2 & Integer.MAX_VALUE);
                this.a.g(0);
                this.a.a(this.b);
                this.a.flush();
            }
        }

        @Override // defpackage.bgv
        public synchronized void a(int i, bgt bgtVar) {
            if (this.e) {
                throw new IOException("closed");
            }
            if (bgtVar.t == -1) {
                throw new IllegalArgumentException();
            }
            this.a.f(-2147287037);
            this.a.f(8);
            this.a.f(Integer.MAX_VALUE & i);
            this.a.f(bgtVar.t);
            this.a.flush();
        }

        @Override // defpackage.bgv
        public int c() {
            return 16383;
        }

        @Override // defpackage.bgv
        public synchronized void a(boolean z, int i, bqs bqsVar, int i2) {
            a(i, z ? 1 : 0, bqsVar, i2);
        }

        void a(int i, int i2, bqs bqsVar, int i3) throws IOException {
            if (this.e) {
                throw new IOException("closed");
            }
            if (i3 > 16777215) {
                throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + i3);
            }
            this.a.f(Integer.MAX_VALUE & i);
            this.a.f(((i2 & 255) << 24) | (16777215 & i3));
            if (i3 > 0) {
                this.a.a_(bqsVar, i3);
            }
        }

        private void a(List<bgw> list) {
            if (this.b.b() != 0) {
                throw new IllegalStateException();
            }
            this.c.f(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                bqv bqvVar = list.get(i).h;
                this.c.f(bqvVar.f());
                this.c.b(bqvVar);
                bqv bqvVar2 = list.get(i).i;
                this.c.f(bqvVar2.f());
                this.c.b(bqvVar2);
            }
            this.c.flush();
        }

        @Override // defpackage.bgv
        public synchronized void b(bhf bhfVar) {
            if (this.e) {
                throw new IOException("closed");
            }
            int iB = bhfVar.b();
            this.a.f(-2147287036);
            this.a.f((((iB * 8) + 4) & 16777215) | 0);
            this.a.f(iB);
            for (int i = 0; i <= 10; i++) {
                if (bhfVar.a(i)) {
                    this.a.f(((bhfVar.c(i) & 255) << 24) | (i & 16777215));
                    this.a.f(bhfVar.b(i));
                }
            }
            this.a.flush();
        }

        @Override // defpackage.bgv
        public synchronized void a(boolean z, int i, int i2) {
            synchronized (this) {
                if (this.e) {
                    throw new IOException("closed");
                }
                if (z != (this.d != ((i & 1) == 1))) {
                    throw new IllegalArgumentException("payload != reply");
                }
                this.a.f(-2147287034);
                this.a.f(4);
                this.a.f(i);
                this.a.flush();
            }
        }

        @Override // defpackage.bgv
        public synchronized void a(int i, bgt bgtVar, byte[] bArr) {
            if (this.e) {
                throw new IOException("closed");
            }
            if (bgtVar.u == -1) {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            }
            this.a.f(-2147287033);
            this.a.f(8);
            this.a.f(i);
            this.a.f(bgtVar.u);
            this.a.flush();
        }

        @Override // defpackage.bgv
        public synchronized void a(int i, long j) {
            if (this.e) {
                throw new IOException("closed");
            }
            if (j == 0 || j > 2147483647L) {
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + j);
            }
            this.a.f(-2147287031);
            this.a.f(8);
            this.a.f(i);
            this.a.f((int) j);
            this.a.flush();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            this.e = true;
            bfw.a((Closeable) this.a, (Closeable) this.c);
        }
    }
}
