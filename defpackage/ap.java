package defpackage;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class ap extends Application {
    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        ao.a(this);
    }
}
