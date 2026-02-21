package defpackage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: loaded from: classes.dex */
public class btd extends bsy {
    private boolean c;
    private static Log b = LogFactory.getLog(btd.class);
    static final btg a = new btg() { // from class: btd.1
        @Override // defpackage.btg
        public btl a(String str, String str2, bup bupVar) {
            return new btd(str, str2, bupVar);
        }
    };

    btd(String str, String str2, bup bupVar) {
        super(str, str2, bupVar);
        this.c = false;
    }
}
