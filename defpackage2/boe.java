package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class boe implements bod {
    private final SharedPreferences a;
    private final String b;
    private final Context c;

    public boe(Context context, String str) {
        if (context == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.c = context;
        this.b = str;
        this.a = this.c.getSharedPreferences(this.b, 0);
    }

    @Deprecated
    public boe(bln blnVar) {
        this(blnVar.r(), blnVar.getClass().getName());
    }

    @Override // defpackage.bod
    public SharedPreferences a() {
        return this.a;
    }

    @Override // defpackage.bod
    public SharedPreferences.Editor b() {
        return this.a.edit();
    }

    @Override // defpackage.bod
    @TargetApi(9)
    public boolean a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT < 9) {
            return editor.commit();
        }
        editor.apply();
        return true;
    }
}
