package defpackage;

import defpackage.bmn;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
class pu implements pg {
    private final File a;
    private final int b;
    private bmn c;

    public class a {
        public final byte[] a;
        public final int b;

        public a(byte[] bArr, int i) {
            this.a = bArr;
            this.b = i;
        }
    }

    public pu(File file, int i) {
        this.a = file;
        this.b = i;
    }

    @Override // defpackage.pg
    public void a(long j, String str) {
        f();
        b(j, str);
    }

    @Override // defpackage.pg
    public ol a() {
        a aVarE = e();
        if (aVarE == null) {
            return null;
        }
        return ol.a(aVarE.a, 0, aVarE.b);
    }

    @Override // defpackage.pg
    public byte[] b() {
        a aVarE = e();
        if (aVarE == null) {
            return null;
        }
        return aVarE.a;
    }

    private a e() {
        if (!this.a.exists()) {
            return null;
        }
        f();
        if (this.c == null) {
            return null;
        }
        final int[] iArr = {0};
        final byte[] bArr = new byte[this.c.a()];
        try {
            this.c.a(new bmn.c() { // from class: pu.1
                @Override // bmn.c
                public void a(InputStream inputStream, int i) throws IOException {
                    try {
                        inputStream.read(bArr, iArr[0], i);
                        int[] iArr2 = iArr;
                        iArr2[0] = iArr2[0] + i;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (IOException e) {
            blh.h().e("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", e);
        }
        return new a(bArr, iArr[0]);
    }

    @Override // defpackage.pg
    public void c() {
        bme.a(this.c, "There was a problem closing the Crashlytics log file.");
        this.c = null;
    }

    @Override // defpackage.pg
    public void d() {
        c();
        this.a.delete();
    }

    private void f() {
        if (this.c == null) {
            try {
                this.c = new bmn(this.a);
            } catch (IOException e) {
                blh.h().e("CrashlyticsCore", "Could not open log file: " + this.a, e);
            }
        }
    }

    private void b(long j, String str) {
        if (this.c != null) {
            String str2 = str == null ? "null" : str;
            try {
                int i = this.b / 4;
                if (str2.length() > i) {
                    str2 = "..." + str2.substring(str2.length() - i);
                }
                this.c.a(String.format(Locale.US, "%d %s%n", Long.valueOf(j), str2.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(HTTP.UTF_8));
                while (!this.c.b() && this.c.a() > this.b) {
                    this.c.c();
                }
            } catch (IOException e) {
                blh.h().e("CrashlyticsCore", "There was a problem writing to the Crashlytics log.", e);
            }
        }
    }
}
