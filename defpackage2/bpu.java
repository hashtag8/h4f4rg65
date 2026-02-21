package defpackage;

/* JADX INFO: loaded from: classes.dex */
class bpu extends bpt {
    public static final boolean a(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        }
        if (!z) {
            return str.equals(str2);
        }
        return str.equalsIgnoreCase(str2);
    }
}
