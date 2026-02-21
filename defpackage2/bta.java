package defpackage;

import java.io.StringReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: loaded from: classes.dex */
public class bta extends bsy {
    private boolean c;
    private String d;
    private Map<String, String> e;
    private btk f;
    private static Log b = LogFactory.getLog(bta.class);
    static final btg a = new btg() { // from class: bta.1
        @Override // defpackage.btg
        public btl a(String str, String str2, bup bupVar) {
            return new bta(str, str2, bupVar);
        }
    };

    bta(String str, String str2, bup bupVar) {
        super(str, str2, bupVar);
        this.c = false;
        this.d = "";
        this.e = new HashMap();
    }

    public String a() {
        if (!this.c) {
            d();
        }
        return this.d;
    }

    public String a(String str) {
        if (!this.c) {
            d();
        }
        return this.e.get(str.toLowerCase());
    }

    public Map<String, String> b() {
        if (!this.c) {
            d();
        }
        return Collections.unmodifiableMap(this.e);
    }

    public String c() {
        return a("filename");
    }

    private void d() {
        String body = getBody();
        btn btnVar = new btn(new StringReader(body));
        try {
            btnVar.d();
        } catch (btk e) {
            if (b.isDebugEnabled()) {
                b.debug("Parsing value '" + body + "': " + e.getMessage());
            }
            this.f = e;
        } catch (btt e2) {
            if (b.isDebugEnabled()) {
                b.debug("Parsing value '" + body + "': " + e2.getMessage());
            }
            this.f = new btk(e2.getMessage());
        }
        String strA = btnVar.a();
        if (strA != null) {
            this.d = strA.toLowerCase(Locale.US);
            List<String> listB = btnVar.b();
            List<String> listC = btnVar.c();
            if (listB != null && listC != null) {
                int iMin = Math.min(listB.size(), listC.size());
                for (int i = 0; i < iMin; i++) {
                    this.e.put(listB.get(i).toLowerCase(Locale.US), listC.get(i));
                }
            }
        }
        this.c = true;
    }
}
