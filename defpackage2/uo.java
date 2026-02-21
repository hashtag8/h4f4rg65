package defpackage;

/* JADX INFO: loaded from: classes.dex */
public enum uo {
    NONE,
    GZIP;

    public static uo a(String str) {
        return "GZIP".equalsIgnoreCase(str) ? GZIP : NONE;
    }
}
