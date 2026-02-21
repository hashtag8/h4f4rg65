package defpackage;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class bbd extends bbc {
    private String a;

    public bbd(String str) {
        super(afb.b(), "/radio/GetTop25Radios", afb.a());
        this.a = str;
    }

    @Override // defpackage.ags
    protected Map<String, String> c() {
        Map<String, String> mapC = super.c();
        mapC.put("countrycode", this.a);
        return mapC;
    }
}
