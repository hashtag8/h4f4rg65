package defpackage;

/* JADX INFO: loaded from: classes.dex */
public enum bic {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);

    final int d;

    public static boolean a(int i) {
        return (NO_CACHE.d & i) == 0;
    }

    public static boolean b(int i) {
        return (NO_STORE.d & i) == 0;
    }

    public static boolean c(int i) {
        return (OFFLINE.d & i) != 0;
    }

    bic(int i) {
        this.d = i;
    }
}
