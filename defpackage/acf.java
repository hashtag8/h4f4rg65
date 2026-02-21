package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes.dex */
public final class acf {
    public aca a(String str) {
        return a(new StringReader(str));
    }

    public aca a(Reader reader) {
        try {
            adq adqVar = new adq(reader);
            aca acaVarA = a(adqVar);
            if (!acaVarA.k() && adqVar.f() != ads.END_DOCUMENT) {
                throw new aci("Did not consume the entire document.");
            }
            return acaVarA;
        } catch (adu e) {
            throw new aci(e);
        } catch (IOException e2) {
            throw new acb(e2);
        } catch (NumberFormatException e3) {
            throw new aci(e3);
        }
    }

    public aca a(adq adqVar) {
        aca acaVarA;
        boolean zP = adqVar.p();
        adqVar.a(true);
        try {
            try {
                try {
                    try {
                        acaVarA = acz.a(adqVar);
                        adqVar.a(zP);
                    } catch (ace e) {
                        if (e.getCause() instanceof EOFException) {
                            acaVarA = acc.a;
                            adqVar.a(zP);
                        } else {
                            throw e;
                        }
                    }
                    return acaVarA;
                } catch (StackOverflowError e2) {
                    throw new ace("Failed parsing JSON source: " + adqVar + " to Json", e2);
                }
            } catch (OutOfMemoryError e3) {
                throw new ace("Failed parsing JSON source: " + adqVar + " to Json", e3);
            }
        } catch (Throwable th) {
            adqVar.a(zP);
            throw th;
        }
    }
}
