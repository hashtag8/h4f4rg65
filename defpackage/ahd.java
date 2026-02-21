package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class ahd {
    public static String a(int i) {
        return new StringBuilder().append(i & 255).append('.').append((i >> 8) & 255).append('.').append((i >> 16) & 255).append('.').append((i >> 24) & 255).toString();
    }
}
