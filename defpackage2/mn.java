package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class mn {
    public static void a() {
        long jMaxMemory = Runtime.getRuntime().maxMemory();
        long j = Runtime.getRuntime().totalMemory();
        mm.b(String.format("%s ===>Memory INFO: max= %d MB, total= %d MB, free= %d MB", Thread.currentThread().getStackTrace()[3], Long.valueOf((jMaxMemory / 1024) / 1024), Long.valueOf((j / 1024) / 1024), Long.valueOf(((jMaxMemory - (j - Runtime.getRuntime().freeMemory())) / 1024) / 1024)), new Object[0]);
    }
}
