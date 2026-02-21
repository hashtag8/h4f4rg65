package defpackage;

import com.harman.hkconnect.R;
import defpackage.ajv;

/* JADX INFO: loaded from: classes.dex */
public class anc extends amy {
    @Override // defpackage.amy
    protected void d() {
        this.g = "http://www.qobuz.com/api.json/0.2/album/getFeatured?type=press-awards&app_id=394304373";
    }

    @Override // defpackage.amy, defpackage.amw, defpackage.ajj
    public ajv b() {
        return new ajv.a(super.b()).a(a(R.string.kQobuz_SelectedByMedia_Str)).a(-9128246).c();
    }

    @Override // android.support.v4.app.Fragment
    public void f(boolean z) {
        super.f(z);
        if (this.ag && z) {
            c(l());
        }
    }
}
