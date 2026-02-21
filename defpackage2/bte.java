package defpackage;

import org.apache.http.entity.mime.MIME;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class bte extends btf {
    public bte() {
        a(MIME.CONTENT_TRANSFER_ENC, btb.a);
        a("Content-Type", btc.a);
        a(MIME.CONTENT_DISPOSITION, bta.a);
        btg btgVar = btd.a;
        a(HTTP.DATE_HEADER, btgVar);
        a("Resent-Date", btgVar);
        btg btgVar2 = btj.a;
        a("From", btgVar2);
        a("Resent-From", btgVar2);
        btg btgVar3 = bti.a;
        a("Sender", btgVar3);
        a("Resent-Sender", btgVar3);
        btg btgVar4 = bsz.a;
        a("To", btgVar4);
        a("Resent-To", btgVar4);
        a("Cc", btgVar4);
        a("Resent-Cc", btgVar4);
        a("Bcc", btgVar4);
        a("Resent-Bcc", btgVar4);
        a("Reply-To", btgVar4);
    }
}
