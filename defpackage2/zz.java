package defpackage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zz extends aas<zz> {
    private final Map<String, Object> a = new HashMap();

    private String a(String str) {
        vq.a(str);
        if (str != null && str.startsWith("&")) {
            str = str.substring(1);
        }
        vq.a(str, (Object) "Name can not be empty or \"&\"");
        return str;
    }

    public Map<String, Object> a() {
        return Collections.unmodifiableMap(this.a);
    }

    public void a(String str, String str2) {
        this.a.put(a(str), str2);
    }

    @Override // defpackage.aas
    public void a(zz zzVar) {
        vq.a(zzVar);
        zzVar.a.putAll(this.a);
    }

    public String toString() {
        return a((Object) this.a);
    }
}
