package defpackage;

/* JADX INFO: loaded from: classes.dex */
public enum bib {
    NO_CACHE(1),
    NO_STORE(2);

    final int c;

    static boolean a(int i) {
        return (NO_CACHE.c & i) == 0;
    }

    static boolean b(int i) {
        return (NO_STORE.c & i) == 0;
    }

    bib(int i) {
        this.c = i;
    }
}
