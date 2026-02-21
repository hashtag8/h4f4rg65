package defpackage;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class baz extends baw {
    private String a;

    public baz(String str) {
        super(afb.b(), "/style/getstyles", afb.a());
        this.a = "";
        this.a = str;
    }

    @Override // defpackage.ags
    protected Map<String, String> c() {
        Map<String, String> mapC = super.c();
        mapC.put("parentid", this.a);
        mapC.put("language", "fr");
        return mapC;
    }
}
