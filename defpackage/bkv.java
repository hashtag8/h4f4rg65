package defpackage;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class bkv extends bkp {
    private bkc a;

    public bkv() {
        g("text/xml; charset=\"utf-8\"");
        j("POST");
        h("Android/5.0 UPnP/1.1 HKController/ DLNADOC/1.50");
    }

    public void m(String str) {
        d("SOAPACTION", str);
    }

    public bkw b(String str, int i, String str2, String str3) {
        bkw bkwVar = new bkw(a(str, i, str2, str3));
        bkwVar.s();
        if (bkwVar.h().length <= 0) {
        }
        return bkwVar;
    }

    private void c(bkc bkcVar) {
        this.a = bkcVar;
    }

    private synchronized bkc y() {
        bkc bkcVar;
        if (this.a != null) {
            bkcVar = this.a;
        } else {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(h());
                this.a = bku.b().a(byteArrayInputStream);
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
            } catch (bkf e) {
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            bkcVar = this.a;
        }
        return bkcVar;
    }

    public void a(bkc bkcVar) {
        c(bkcVar);
    }

    public bkc w() {
        return y();
    }

    public bkc x() {
        bkc bkcVarW = w();
        if (bkcVarW != null && bkcVarW.e()) {
            return bkcVarW.b(0);
        }
        return null;
    }

    public void b(bkc bkcVar) {
        f((("<?xml version=\"1.0\" encoding=\"utf-8\"?>") + "\n") + bkcVar.toString());
    }
}
