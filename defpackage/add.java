package defpackage;

import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public final class add extends ack<BigInteger> {
    @Override // defpackage.ack
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public BigInteger b(adq adqVar) {
        if (adqVar.f() == ads.NULL) {
            adqVar.j();
            return null;
        }
        try {
            return new BigInteger(adqVar.h());
        } catch (NumberFormatException e) {
            throw new aci(e);
        }
    }

    @Override // defpackage.ack
    public void a(adt adtVar, BigInteger bigInteger) throws IOException {
        adtVar.a(bigInteger);
    }
}
