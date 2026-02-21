package defpackage;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public class bsn extends bsi {
    private final int a;
    private final int b;
    private final boolean c;

    public bsn() {
        this(0, Integer.MAX_VALUE, true);
    }

    private bsn(int i, int i2, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    public static bsn a(int i, int i2) {
        return new bsn(i, i2, false);
    }

    @Override // defpackage.bsi
    public boolean a(int i, Writer writer) throws IOException {
        if (this.c) {
            if (i < this.a || i > this.b) {
                return false;
            }
        } else if (i >= this.a && i <= this.b) {
            return false;
        }
        if (i > 65535 || i > 4095) {
            writer.write("\\u" + a(i));
        } else if (i > 255) {
            writer.write("\\u0" + a(i));
        } else if (i > 15) {
            writer.write("\\u00" + a(i));
        } else {
            writer.write("\\u000" + a(i));
        }
        return true;
    }
}
