package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class bpg {

    public static final class a extends Thread {
        final /* synthetic */ bph a;

        a(bph bphVar) {
            this.a = bphVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.a.a();
        }
    }

    public static final Thread a(boolean z, boolean z2, ClassLoader classLoader, String str, int i, bph<bpf> bphVar) {
        bpj.b(bphVar, "block");
        a aVar = new a(bphVar);
        if (z2) {
            aVar.setDaemon(true);
        }
        if (i > 0) {
            aVar.setPriority(i);
        }
        if (str != null) {
            aVar.setName(str);
        }
        if (classLoader != null) {
            aVar.setContextClassLoader(classLoader);
        }
        if (z) {
            aVar.start();
        }
        return aVar;
    }
}
