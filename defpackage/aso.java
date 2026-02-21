package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class aso {
    public static final aso a = new aso();

    private aso() {
    }

    public final String a() {
        if (aho.b("ConfigType", 0) == 0) {
            mm.c("return product url=http://storage.harman.com/LegalFiles/Android/Legal_Resource_Index.xml", new Object[0]);
            return "http://storage.harman.com/LegalFiles/Android/Legal_Resource_Index.xml";
        }
        mm.c("return test url=http://storage.harman.com/LegalFiles/Android/Legal_Resource_Index.xml", new Object[0]);
        return "http://storage.harman.com/Testing/LegalFiles/Android/Legal_Resource_Test_Index.xml";
    }
}
