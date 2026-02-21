package defpackage;

import java.io.IOException;
import java.net.MalformedURLException;

/* JADX INFO: loaded from: classes.dex */
public class akz implements qn {
    @Override // defpackage.qn
    public void a(String str, Object obj) {
        mm.b("onComplete() response = " + str + ", state = " + obj, new Object[0]);
    }

    @Override // defpackage.qn
    public void a(IOException iOException, Object obj) {
        a((Exception) iOException, obj);
    }

    @Override // defpackage.qn
    public void a(MalformedURLException malformedURLException, Object obj) {
        a((Exception) malformedURLException, obj);
    }

    @Override // defpackage.qn
    public void a(qm qmVar, Object obj) {
        a((Exception) qmVar, obj);
    }

    @Override // defpackage.qn
    public void a(qk qkVar, Object obj) {
        a((Exception) qkVar, obj);
    }

    public void a(Exception exc, Object obj) {
        mm.b("onError this = " + exc + " ,state = " + obj, new Object[0]);
        exc.printStackTrace();
    }
}
