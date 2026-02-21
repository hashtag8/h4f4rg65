package defpackage;

import android.util.Xml;

/* JADX INFO: loaded from: classes.dex */
public class bku {
    public static bkc a() {
        bkc bkcVar = new bkc("s:Envelope");
        bkcVar.b("xmlns:s", "http://schemas.xmlsoap.org/soap/envelope/");
        bkcVar.b("s:encodingStyle", "http://schemas.xmlsoap.org/soap/encoding/");
        bkcVar.b(new bkc("s:Body"));
        return bkcVar;
    }

    public static bke b() {
        return (bke) Xml.newPullParser();
    }
}
