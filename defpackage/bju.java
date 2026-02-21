package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class bju {
    private static bjs a = null;

    public static bjs a() {
        if (a == null) {
            a = (bjs) Class.forName("bjv").newInstance();
        }
        return a;
    }
}
