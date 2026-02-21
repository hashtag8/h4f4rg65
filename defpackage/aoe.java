package defpackage;

import com.harman.hkconnect.ui.HarmanApplication;

/* JADX INFO: loaded from: classes.dex */
public class aoe {
    public void a(afy afyVar) {
        mm.b("start to init FC", new Object[0]);
        if (!afc.a().h()) {
            afc.a().a(HarmanApplication.a(), afyVar, 0);
            if (afc.a().f() == 0) {
                mm.b("Probing for 1st available group", new Object[0]);
                afc.a().g();
            }
        }
    }
}
