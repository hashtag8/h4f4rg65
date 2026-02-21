package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
class bhc {
    private final brb a;
    private int b;
    private final bqu c;

    public bhc(bqu bquVar) {
        this.a = new brb(new bqy(bquVar) { // from class: bhc.1
            @Override // defpackage.bqy, defpackage.bri
            public long a(bqs bqsVar, long j) {
                if (bhc.this.b == 0) {
                    return -1L;
                }
                long jA = super.a(bqsVar, Math.min(j, bhc.this.b));
                if (jA == -1) {
                    return -1L;
                }
                bhc.this.b = (int) (((long) bhc.this.b) - jA);
                return jA;
            }
        }, new Inflater() { // from class: bhc.2
            @Override // java.util.zip.Inflater
            public int inflate(byte[] bArr, int i, int i2) throws DataFormatException {
                int iInflate = super.inflate(bArr, i, i2);
                if (iInflate == 0 && needsDictionary()) {
                    setDictionary(bhg.a);
                    return super.inflate(bArr, i, i2);
                }
                return iInflate;
            }
        });
        this.c = brc.a(this.a);
    }

    public List<bgw> a(int i) throws IOException {
        this.b += i;
        int iK = this.c.k();
        if (iK < 0) {
            throw new IOException("numberOfPairs < 0: " + iK);
        }
        if (iK > 1024) {
            throw new IOException("numberOfPairs > 1024: " + iK);
        }
        ArrayList arrayList = new ArrayList(iK);
        for (int i2 = 0; i2 < iK; i2++) {
            bqv bqvVarE = b().e();
            bqv bqvVarB = b();
            if (bqvVarE.f() == 0) {
                throw new IOException("name.size == 0");
            }
            arrayList.add(new bgw(bqvVarE, bqvVarB));
        }
        c();
        return arrayList;
    }

    private bqv b() {
        return this.c.c(this.c.k());
    }

    private void c() throws IOException {
        if (this.b > 0) {
            this.a.b();
            if (this.b != 0) {
                throw new IOException("compressedLimit > 0: " + this.b);
            }
        }
    }

    public void a() {
        this.c.close();
    }
}
