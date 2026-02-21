package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class btf implements btg {
    private Map<String, btg> a = new HashMap();
    private btg b = btm.a;

    public void a(String str, btg btgVar) {
        this.a.put(str.toLowerCase(), btgVar);
    }

    public btg a(String str) {
        btg btgVar = this.a.get(str.toLowerCase());
        if (btgVar == null) {
            return this.b;
        }
        return btgVar;
    }

    @Override // defpackage.btg
    public btl a(String str, String str2, bup bupVar) {
        return a(str).a(str, str2, bupVar);
    }
}
