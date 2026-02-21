package defpackage;

import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class bkk extends bkv {
    protected void a(bjq bjqVar) {
        String strB = bjqVar.b();
        String strE = bjqVar.d().e();
        if (strE != null && strE.length() > 0) {
            try {
                String path = new URL(strE).getPath();
                int length = path.length();
                if (length > 0 && (1 < length || path.charAt(0) != '/')) {
                    strB = path + strB;
                }
            } catch (MalformedURLException e) {
            }
        }
        b(strB, true);
        if (bky.a(strB)) {
            strB = "";
        }
        if (strB == null || strB.length() <= 0) {
            strB = bjqVar.d().e();
        }
        String strA = bkm.a(strB);
        int iB = bkm.b(strB);
        a(strA, iB);
        l(strA);
        c(iB);
    }
}
