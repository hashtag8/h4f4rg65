package defpackage;

import java.io.IOException;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public final class adc extends ack<BigDecimal> {
    @Override // defpackage.ack
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public BigDecimal b(adq adqVar) {
        if (adqVar.f() == ads.NULL) {
            adqVar.j();
            return null;
        }
        try {
            return new BigDecimal(adqVar.h());
        } catch (NumberFormatException e) {
            throw new aci(e);
        }
    }

    @Override // defpackage.ack
    public void a(adt adtVar, BigDecimal bigDecimal) throws IOException {
        adtVar.a(bigDecimal);
    }
}
