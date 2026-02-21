package defpackage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: loaded from: classes.dex */
public class btj extends bsy {
    private boolean c;
    private static Log b = LogFactory.getLog(btj.class);
    static final btg a = new btg() { // from class: btj.1
        @Override // defpackage.btg
        public btl a(String str, String str2, bup bupVar) {
            return new btj(str, str2, bupVar);
        }
    };

    btj(String str, String str2, bup bupVar) {
        super(str, str2, bupVar);
        this.c = false;
    }
}
