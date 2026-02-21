package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class bgf {
    public static boolean a(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE");
    }

    public static boolean b(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH");
    }

    public static boolean c(String str) {
        return b(str) || str.equals("DELETE");
    }
}
