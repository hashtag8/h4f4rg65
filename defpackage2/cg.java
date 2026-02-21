package defpackage;

import android.app.Activity;
import android.os.Bundle;
import defpackage.d;

/* JADX INFO: loaded from: classes.dex */
public class cg extends Activity implements e {
    private eg<Class<? extends Object>, Object> a = new eg<>();
    private f b = new f(this);

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i.a(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.b.a(d.b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    public d d_() {
        return this.b;
    }
}
