package defpackage;

import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class btc extends bsy {
    private boolean c;
    private String d;
    private Map<String, String> e;
    private btx f;
    private static Log b = LogFactory.getLog(btc.class);
    static final btg a = new btg() { // from class: btc.1
        @Override // defpackage.btg
        public btl a(String str, String str2, bup bupVar) {
            return new btc(str, str2, bupVar);
        }
    };

    btc(String str, String str2, bup bupVar) {
        super(str, str2, bupVar);
        this.c = false;
        this.d = "";
        this.e = new HashMap();
    }

    public String a() {
        if (!this.c) {
            e();
        }
        return this.d;
    }

    public String a(String str) {
        if (!this.c) {
            e();
        }
        return this.e.get(str.toLowerCase());
    }

    public boolean b(String str) {
        if (!this.c) {
            e();
        }
        return this.d.equalsIgnoreCase(str);
    }

    public boolean b() {
        if (!this.c) {
            e();
        }
        return this.d.startsWith("multipart/");
    }

    public String c() {
        return a("boundary");
    }

    public String d() {
        return a("charset");
    }

    public static String a(btc btcVar, btc btcVar2) {
        if (btcVar == null || btcVar.a().length() == 0 || (btcVar.b() && btcVar.c() == null)) {
            if (btcVar2 != null && btcVar2.b("multipart/digest")) {
                return "message/rfc822";
            }
            return HTTP.PLAIN_TEXT_TYPE;
        }
        return btcVar.a();
    }

    public static String a(btc btcVar) {
        String strD;
        return (btcVar == null || (strD = btcVar.d()) == null || strD.length() <= 0) ? "us-ascii" : strD;
    }

    private void e() {
        String body = getBody();
        btu btuVar = new btu(new StringReader(body));
        try {
            btuVar.e();
        } catch (btx e) {
            if (b.isDebugEnabled()) {
                b.debug("Parsing value '" + body + "': " + e.getMessage());
            }
            this.f = e;
        } catch (bua e2) {
            if (b.isDebugEnabled()) {
                b.debug("Parsing value '" + body + "': " + e2.getMessage());
            }
            this.f = new btx(e2.getMessage());
        }
        String strA = btuVar.a();
        String strB = btuVar.b();
        if (strA != null && strB != null) {
            this.d = (strA + "/" + strB).toLowerCase();
            List<String> listC = btuVar.c();
            List<String> listD = btuVar.d();
            if (listC != null && listD != null) {
                int iMin = Math.min(listC.size(), listD.size());
                for (int i = 0; i < iMin; i++) {
                    this.e.put(listC.get(i).toLowerCase(), listD.get(i));
                }
            }
        }
        this.c = true;
    }
}
