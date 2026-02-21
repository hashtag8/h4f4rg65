package defpackage;

import defpackage.pw;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class ph implements pw {
    private final File[] a;
    private final Map<String, String> b = new HashMap(px.a);
    private final String c;

    public ph(String str, File[] fileArr) {
        this.a = fileArr;
        this.c = str;
    }

    @Override // defpackage.pw
    public String a() {
        return this.a[0].getName();
    }

    @Override // defpackage.pw
    public String b() {
        return this.c;
    }

    @Override // defpackage.pw
    public File c() {
        return this.a[0];
    }

    @Override // defpackage.pw
    public File[] d() {
        return this.a;
    }

    @Override // defpackage.pw
    public Map<String, String> e() {
        return Collections.unmodifiableMap(this.b);
    }

    @Override // defpackage.pw
    public void f() {
        for (File file : this.a) {
            blh.h().a("CrashlyticsCore", "Removing invalid report file at " + file.getPath());
            file.delete();
        }
    }

    @Override // defpackage.pw
    public pw.a g() {
        return pw.a.JAVA;
    }
}
