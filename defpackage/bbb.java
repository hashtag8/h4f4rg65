package defpackage;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class bbb extends bbc {
    private String a;

    public bbb(String str) {
        super(afb.b(), "/radio/SearchRadios", afb.a());
        this.a = str;
    }

    @Override // defpackage.ags
    protected Map<String, String> c() {
        Map<String, String> mapC = super.c();
        mapC.put("q", this.a);
        mapC.put("language", "fr");
        return mapC;
    }
}
