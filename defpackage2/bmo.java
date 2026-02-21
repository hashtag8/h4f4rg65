package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class bmo {
    public static int a(int i) {
        if (i >= 200 && i <= 299) {
            return 0;
        }
        if (i >= 300 && i <= 399) {
            return 1;
        }
        if (i < 400 || i > 499) {
            return i >= 500 ? 1 : 1;
        }
        return 0;
    }
}
