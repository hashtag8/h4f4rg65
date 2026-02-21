package defpackage;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class bba extends bbc {
    private String a;
    private String b;

    public bba(String str, String str2) {
        super(afb.b(), "/radio/GetRadiosByStyle", afb.a());
        this.a = str;
        this.b = str2;
    }

    @Override // defpackage.ags
    protected Map<String, String> c() {
        Map<String, String> mapC = super.c();
        mapC.put("styleId", this.a);
        mapC.put("countryCode", this.b);
        mapC.put("skipItems", "0");
        mapC.put("takeItems", "500");
        return mapC;
    }
}
