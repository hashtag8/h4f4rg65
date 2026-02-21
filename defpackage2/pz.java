package defpackage;

import defpackage.pw;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class pz implements pw {
    private final File a;
    private final File[] b;
    private final Map<String, String> c;

    public pz(File file) {
        this(file, Collections.emptyMap());
    }

    public pz(File file, Map<String, String> map) {
        this.a = file;
        this.b = new File[]{file};
        this.c = new HashMap(map);
        if (this.a.length() == 0) {
            this.c.putAll(px.a);
        }
    }

    @Override // defpackage.pw
    public File c() {
        return this.a;
    }

    @Override // defpackage.pw
    public File[] d() {
        return this.b;
    }

    @Override // defpackage.pw
    public String a() {
        return c().getName();
    }

    @Override // defpackage.pw
    public String b() {
        String strA = a();
        return strA.substring(0, strA.lastIndexOf(46));
    }

    @Override // defpackage.pw
    public Map<String, String> e() {
        return Collections.unmodifiableMap(this.c);
    }

    @Override // defpackage.pw
    public void f() {
        blh.h().a("CrashlyticsCore", "Removing report at " + this.a.getPath());
        this.a.delete();
    }

    @Override // defpackage.pw
    public pw.a g() {
        return pw.a.JAVA;
    }
}
