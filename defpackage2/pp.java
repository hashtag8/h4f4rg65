package defpackage;

import defpackage.pw;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class pp implements pw {
    private final File a;

    public pp(File file) {
        this.a = file;
    }

    @Override // defpackage.pw
    public void f() {
        for (File file : d()) {
            blh.h().a("CrashlyticsCore", "Removing native report file at " + file.getPath());
            file.delete();
        }
        blh.h().a("CrashlyticsCore", "Removing native report directory at " + this.a);
        this.a.delete();
    }

    @Override // defpackage.pw
    public String a() {
        return null;
    }

    @Override // defpackage.pw
    public String b() {
        return this.a.getName();
    }

    @Override // defpackage.pw
    public File c() {
        return null;
    }

    @Override // defpackage.pw
    public File[] d() {
        return this.a.listFiles();
    }

    @Override // defpackage.pw
    public Map<String, String> e() {
        return null;
    }

    @Override // defpackage.pw
    public pw.a g() {
        return pw.a.NATIVE;
    }
}
