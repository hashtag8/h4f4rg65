package defpackage;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class bay extends bbc {
    private String a;

    public bay(String str) {
        super(afb.b(), "/radio/GetSimilarRadios", afb.a());
        this.a = str;
    }

    @Override // defpackage.ags
    protected Map<String, String> c() {
        Map<String, String> mapC = super.c();
        mapC.put("radiouid", this.a);
        return mapC;
    }
}
