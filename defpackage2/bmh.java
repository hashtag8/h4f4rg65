package defpackage;

/* JADX INFO: loaded from: classes.dex */
public enum bmh {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);

    private final int e;

    bmh(int i) {
        this.e = i;
    }

    public int a() {
        return this.e;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.e);
    }

    public static bmh a(String str) {
        if ("io.crash.air".equals(str)) {
            return TEST_DISTRIBUTION;
        }
        if (str != null) {
            return APP_STORE;
        }
        return DEVELOPER;
    }
}
