package defpackage;

import java.io.Serializable;
import java.util.Map;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class ln implements Serializable {
    public final int a;
    public final byte[] b;
    public final Map<String, String> c;
    public final boolean d;
    public final long e;

    public ln(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this.a = i;
        this.b = bArr;
        this.c = map;
        this.d = z;
        this.e = j;
    }

    public ln(byte[] bArr, Map<String, String> map) {
        this(HttpStatus.SC_OK, bArr, map, false, 0L);
    }
}
