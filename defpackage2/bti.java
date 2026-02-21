package defpackage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: loaded from: classes.dex */
public class bti extends bsy {
    private boolean c;
    private static Log b = LogFactory.getLog(bti.class);
    static final btg a = new btg() { // from class: bti.1
        @Override // defpackage.btg
        public btl a(String str, String str2, bup bupVar) {
            return new bti(str, str2, bupVar);
        }
    };

    bti(String str, String str2, bup bupVar) {
        super(str, str2, bupVar);
        this.c = false;
    }
}
