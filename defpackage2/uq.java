package defpackage;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import defpackage.up;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
abstract class uq<T extends up> extends uc {
    a<T> a;

    public interface a<U extends up> {
        U a();

        void a(String str, int i);

        void a(String str, String str2);

        void a(String str, boolean z);

        void b(String str, String str2);
    }

    public uq(uf ufVar, a<T> aVar) {
        super(ufVar);
        this.a = aVar;
    }

    private T a(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String lowerCase = xmlResourceParser.getName().toLowerCase();
                    if (lowerCase.equals("screenname")) {
                        String attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        String strTrim = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(strTrim)) {
                            this.a.a(attributeValue, strTrim);
                        }
                    } else if (lowerCase.equals("string")) {
                        String attributeValue2 = xmlResourceParser.getAttributeValue(null, "name");
                        String strTrim2 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue2) && strTrim2 != null) {
                            this.a.b(attributeValue2, strTrim2);
                        }
                    } else if (lowerCase.equals("bool")) {
                        String attributeValue3 = xmlResourceParser.getAttributeValue(null, "name");
                        String strTrim3 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue3) && !TextUtils.isEmpty(strTrim3)) {
                            try {
                                this.a.a(attributeValue3, Boolean.parseBoolean(strTrim3));
                            } catch (NumberFormatException e) {
                                c("Error parsing bool configuration value", strTrim3, e);
                            }
                        }
                    } else if (lowerCase.equals("integer")) {
                        String attributeValue4 = xmlResourceParser.getAttributeValue(null, "name");
                        String strTrim4 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue4) && !TextUtils.isEmpty(strTrim4)) {
                            try {
                                this.a.a(attributeValue4, Integer.parseInt(strTrim4));
                            } catch (NumberFormatException e2) {
                                c("Error parsing int configuration value", strTrim4, e2);
                            }
                        }
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException e3) {
            e("Error parsing tracker configuration file", e3);
        } catch (XmlPullParserException e4) {
            e("Error parsing tracker configuration file", e4);
        }
        return (T) this.a.a();
    }

    public T a(int i) {
        try {
            return (T) a(k().c().getResources().getXml(i));
        } catch (Resources.NotFoundException e) {
            d("inflate() called with unknown resourceId", e);
            return null;
        }
    }
}
