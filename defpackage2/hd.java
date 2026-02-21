package defpackage;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
final class hd {
    static final /* synthetic */ boolean a;

    static {
        a = !hd.class.desiredAssertionStatus();
    }

    public static <T> T[] a(T[] tArr, int i, T t) {
        T[] tArr2;
        if (!a && i > tArr.length) {
            throw new AssertionError();
        }
        if (i + 1 > tArr.length) {
            tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), a(i)));
            System.arraycopy(tArr, 0, tArr2, 0, i);
        } else {
            tArr2 = tArr;
        }
        tArr2[i] = t;
        return tArr2;
    }

    public static int[] a(int[] iArr, int i, int i2) {
        if (!a && i > iArr.length) {
            throw new AssertionError();
        }
        if (i + 1 > iArr.length) {
            int[] iArr2 = new int[a(i)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr = iArr2;
        }
        iArr[i] = i2;
        return iArr;
    }

    public static int a(int i) {
        if (i <= 4) {
            return 8;
        }
        return i * 2;
    }

    private hd() {
    }
}
