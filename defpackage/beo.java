package defpackage;

import defpackage.bfa;
import defpackage.bfg;
import defpackage.bfi;
import defpackage.bfn;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public final class beo {
    final bfq a = new bfq() { // from class: beo.1
        @Override // defpackage.bfq
        public bfi a(bfg bfgVar) {
            return beo.this.a(bfgVar);
        }

        @Override // defpackage.bfq
        public bfz a(bfi bfiVar) {
            return beo.this.a(bfiVar);
        }

        @Override // defpackage.bfq
        public void b(bfg bfgVar) {
            beo.this.c(bfgVar);
        }

        @Override // defpackage.bfq
        public void a(bfi bfiVar, bfi bfiVar2) {
            beo.this.a(bfiVar, bfiVar2);
        }

        @Override // defpackage.bfq
        public void a() {
            beo.this.a();
        }

        @Override // defpackage.bfq
        public void a(bga bgaVar) {
            beo.this.a(bgaVar);
        }
    };
    private final bfn b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;

    static /* synthetic */ int b(beo beoVar) {
        int i = beoVar.c;
        beoVar.c = i + 1;
        return i;
    }

    static /* synthetic */ int c(beo beoVar) {
        int i = beoVar.d;
        beoVar.d = i + 1;
        return i;
    }

    public beo(File file, long j) {
        this.b = bfn.a(bgs.a, file, 201105, 2, j);
    }

    private static String b(bfg bfgVar) {
        return bfw.b(bfgVar.c());
    }

    bfi a(bfg bfgVar) {
        try {
            bfn.c cVarA = this.b.a(b(bfgVar));
            if (cVarA == null) {
                return null;
            }
            try {
                c cVar = new c(cVarA.a(0));
                bfi bfiVarA = cVar.a(bfgVar, cVarA);
                if (cVar.a(bfgVar, bfiVarA)) {
                    return bfiVarA;
                }
                bfw.a(bfiVarA.g());
                return null;
            } catch (IOException e) {
                bfw.a(cVarA);
                return null;
            }
        } catch (IOException e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public bfz a(bfi bfiVar) {
        bfn.a aVar;
        String strD = bfiVar.a().d();
        if (bgf.a(bfiVar.a().d())) {
            try {
                c(bfiVar.a());
                return null;
            } catch (IOException e) {
                return null;
            }
        }
        if (!strD.equals("GET") || bgh.b(bfiVar)) {
            return null;
        }
        c cVar = new c(bfiVar);
        try {
            bfn.a aVarB = this.b.b(b(bfiVar.a()));
            if (aVarB == null) {
                return null;
            }
            try {
                cVar.a(aVarB);
                return new a(aVarB);
            } catch (IOException e2) {
                aVar = aVarB;
                a(aVar);
                return null;
            }
        } catch (IOException e3) {
            aVar = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(bfg bfgVar) {
        this.b.c(b(bfgVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bfi bfiVar, bfi bfiVar2) {
        c cVar = new c(bfiVar2);
        bfn.a aVarA = null;
        try {
            aVarA = ((b) bfiVar.g()).a.a();
            if (aVarA != null) {
                cVar.a(aVarA);
                aVarA.a();
            }
        } catch (IOException e) {
            a(aVarA);
        }
    }

    private void a(bfn.a aVar) {
        if (aVar != null) {
            try {
                aVar.b();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(bga bgaVar) {
        this.g++;
        if (bgaVar.a != null) {
            this.e++;
        } else if (bgaVar.b != null) {
            this.f++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f++;
    }

    final class a implements bfz {
        private final bfn.a b;
        private brh c;
        private boolean d;
        private brh e;

        public a(final bfn.a aVar) {
            this.b = aVar;
            this.c = aVar.a(1);
            this.e = new bqx(this.c) { // from class: beo.a.1
                @Override // defpackage.bqx, defpackage.brh, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    synchronized (beo.this) {
                        if (!a.this.d) {
                            a.this.d = true;
                            beo.b(beo.this);
                            super.close();
                            aVar.a();
                        }
                    }
                }
            };
        }

        @Override // defpackage.bfz
        public void a() {
            synchronized (beo.this) {
                if (!this.d) {
                    this.d = true;
                    beo.c(beo.this);
                    bfw.a(this.c);
                    try {
                        this.b.b();
                    } catch (IOException e) {
                    }
                }
            }
        }

        @Override // defpackage.bfz
        public brh b() {
            return this.e;
        }
    }

    static final class c {
        private final String a;
        private final bfa b;
        private final String c;
        private final bff d;
        private final int e;
        private final String f;
        private final bfa g;
        private final bez h;

        public c(bri briVar) {
            try {
                bqu bquVarA = brc.a(briVar);
                this.a = bquVarA.r();
                this.c = bquVarA.r();
                bfa.a aVar = new bfa.a();
                int iB = beo.b(bquVarA);
                for (int i = 0; i < iB; i++) {
                    aVar.a(bquVarA.r());
                }
                this.b = aVar.a();
                bgq bgqVarA = bgq.a(bquVarA.r());
                this.d = bgqVarA.a;
                this.e = bgqVarA.b;
                this.f = bgqVarA.c;
                bfa.a aVar2 = new bfa.a();
                int iB2 = beo.b(bquVarA);
                for (int i2 = 0; i2 < iB2; i2++) {
                    aVar2.a(bquVarA.r());
                }
                this.g = aVar2.a();
                if (a()) {
                    String strR = bquVarA.r();
                    if (strR.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + strR + "\"");
                    }
                    this.h = bez.a(bquVarA.r(), a(bquVarA), a(bquVarA));
                } else {
                    this.h = null;
                }
            } finally {
                briVar.close();
            }
        }

        public c(bfi bfiVar) {
            this.a = bfiVar.a().c();
            this.b = bgh.c(bfiVar);
            this.c = bfiVar.a().d();
            this.d = bfiVar.b();
            this.e = bfiVar.c();
            this.f = bfiVar.d();
            this.g = bfiVar.f();
            this.h = bfiVar.e();
        }

        public void a(bfn.a aVar) throws IOException {
            bqt bqtVarA = brc.a(aVar.a(0));
            bqtVarA.b(this.a);
            bqtVarA.h(10);
            bqtVarA.b(this.c);
            bqtVarA.h(10);
            bqtVarA.k(this.b.a());
            bqtVarA.h(10);
            int iA = this.b.a();
            for (int i = 0; i < iA; i++) {
                bqtVarA.b(this.b.a(i));
                bqtVarA.b(": ");
                bqtVarA.b(this.b.b(i));
                bqtVarA.h(10);
            }
            bqtVarA.b(new bgq(this.d, this.e, this.f).toString());
            bqtVarA.h(10);
            bqtVarA.k(this.g.a());
            bqtVarA.h(10);
            int iA2 = this.g.a();
            for (int i2 = 0; i2 < iA2; i2++) {
                bqtVarA.b(this.g.a(i2));
                bqtVarA.b(": ");
                bqtVarA.b(this.g.b(i2));
                bqtVarA.h(10);
            }
            if (a()) {
                bqtVarA.h(10);
                bqtVarA.b(this.h.a());
                bqtVarA.h(10);
                a(bqtVarA, this.h.b());
                a(bqtVarA, this.h.c());
            }
            bqtVarA.close();
        }

        private boolean a() {
            return this.a.startsWith("https://");
        }

        private List<Certificate> a(bqu bquVar) throws IOException {
            int iB = beo.b(bquVar);
            if (iB == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(iB);
                for (int i = 0; i < iB; i++) {
                    String strR = bquVar.r();
                    bqs bqsVar = new bqs();
                    bqsVar.b(bqv.b(strR));
                    arrayList.add(certificateFactory.generateCertificate(bqsVar.g()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private void a(bqt bqtVar, List<Certificate> list) throws IOException {
            try {
                bqtVar.k(list.size());
                bqtVar.h(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bqtVar.b(bqv.a(list.get(i).getEncoded()).b());
                    bqtVar.h(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public boolean a(bfg bfgVar, bfi bfiVar) {
            return this.a.equals(bfgVar.c()) && this.c.equals(bfgVar.d()) && bgh.a(bfiVar, this.b, bfgVar);
        }

        public bfi a(bfg bfgVar, bfn.c cVar) {
            String strA = this.g.a("Content-Type");
            String strA2 = this.g.a(HTTP.CONTENT_LEN);
            return new bfi.a().a(new bfg.a().a(this.a).a(this.c, (bfh) null).a(this.b).a()).a(this.d).a(this.e).a(this.f).a(this.g).a(new b(cVar, strA, strA2)).a(this.h).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(bqu bquVar) throws IOException {
        try {
            long jN = bquVar.n();
            String strR = bquVar.r();
            if (jN < 0 || jN > 2147483647L || !strR.isEmpty()) {
                throw new IOException("expected an int but was \"" + jN + strR + "\"");
            }
            return (int) jN;
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    static class b extends bfj {
        private final bfn.c a;
        private final bqu b;
        private final String c;
        private final String d;

        public b(final bfn.c cVar, String str, String str2) {
            this.a = cVar;
            this.c = str;
            this.d = str2;
            this.b = brc.a(new bqy(cVar.a(1)) { // from class: beo.b.1
                @Override // defpackage.bqy, defpackage.bri, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    cVar.close();
                    super.close();
                }
            });
        }

        @Override // defpackage.bfj
        public long a() {
            try {
                if (this.d != null) {
                    return Long.parseLong(this.d);
                }
                return -1L;
            } catch (NumberFormatException e) {
                return -1L;
            }
        }

        @Override // defpackage.bfj
        public bqu b() {
            return this.b;
        }
    }
}
