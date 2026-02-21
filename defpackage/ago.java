package defpackage;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ago implements agn {
    private static long a = TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS);
    private static long b = TimeUnit.MILLISECONDS.convert(3, TimeUnit.MINUTES);
    private final String c;
    private final long d;
    private final long e;

    public ago(String str) {
        this(str, a, b);
    }

    public ago(String str, long j, long j2) {
        brw.a(str, "baseUrl", new Object[0]);
        this.c = str;
        this.d = j;
        this.e = j2;
    }

    @Override // defpackage.agn
    public String a() {
        return this.c;
    }

    @Override // defpackage.agn
    public Map<String, String> b() {
        return Collections.emptyMap();
    }

    @Override // defpackage.agn
    public Map<String, String> c() {
        return Collections.emptyMap();
    }

    @Override // defpackage.agn
    public long d() {
        return this.d;
    }

    @Override // defpackage.agn
    public long e() {
        return this.e;
    }
}
