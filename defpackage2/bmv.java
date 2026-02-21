package defpackage;

/* JADX INFO: loaded from: classes.dex */
public enum bmv {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    static <Y> int a(bmz bmzVar, Y y) {
        bmv bmvVarB;
        if (y instanceof bmz) {
            bmvVarB = ((bmz) y).b();
        } else {
            bmvVarB = NORMAL;
        }
        return bmvVarB.ordinal() - bmzVar.b().ordinal();
    }
}
