package defpackage;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class abd extends aas<abd> {
    public String a;
    public boolean b;

    public String a() {
        return this.a;
    }

    @Override // defpackage.aas
    public void a(abd abdVar) {
        if (!TextUtils.isEmpty(this.a)) {
            abdVar.a(this.a);
        }
        if (this.b) {
            abdVar.a(this.b);
        }
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public boolean b() {
        return this.b;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("description", this.a);
        map.put("fatal", Boolean.valueOf(this.b));
        return a((Object) map);
    }
}
