package defpackage;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public enum bqe {
    LEFT(0),
    TOP(1),
    RIGHT(2),
    BOTTOM(3),
    START(4),
    END(5);

    private static final SparseArray<bqe> h = new SparseArray<>();
    final int g;

    static {
        for (bqe bqeVar : values()) {
            h.put(bqeVar.g, bqeVar);
        }
    }

    bqe(int i2) {
        this.g = i2;
    }

    public static bqe a(int i2) {
        return h.get(i2);
    }
}
