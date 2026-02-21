package defpackage;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class atd implements Comparator<adx> {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(adx adxVar, adx adxVar2) {
        if (adxVar == null || adxVar2 == null || adxVar.x() == null || adxVar2.x() == null) {
            return 0;
        }
        return adxVar.x().compareToIgnoreCase(adxVar2.x());
    }
}
