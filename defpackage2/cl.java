package defpackage;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import defpackage.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.HttpStatus;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class cl {

    public interface a {
    }

    public static final class d implements a {
        private final dr a;
        private final int b;
        private final int c;

        public d(dr drVar, int i, int i2) {
            this.a = drVar;
            this.c = i;
            this.b = i2;
        }

        public dr a() {
            return this.a;
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.b;
        }
    }

    public static final class c {
        private final String a;
        private int b;
        private boolean c;
        private int d;

        public c(String str, int i, boolean z, int i2) {
            this.a = str;
            this.b = i;
            this.c = z;
            this.d = i2;
        }

        public String a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public boolean c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }
    }

    public static final class b implements a {
        private final c[] a;

        public b(c[] cVarArr) {
            this.a = cVarArr;
        }

        public c[] a() {
            return this.a;
        }
    }

    public static a a(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        return b(xmlPullParser, resources);
    }

    private static a b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return c(xmlPullParser, resources);
        }
        a(xmlPullParser);
        return null;
    }

    private static a c(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), j.a.FontFamily);
        String string = typedArrayObtainAttributes.getString(j.a.FontFamily_fontProviderAuthority);
        String string2 = typedArrayObtainAttributes.getString(j.a.FontFamily_fontProviderPackage);
        String string3 = typedArrayObtainAttributes.getString(j.a.FontFamily_fontProviderQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(j.a.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(j.a.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(j.a.FontFamily_fontProviderFetchTimeout, HttpStatus.SC_INTERNAL_SERVER_ERROR);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                a(xmlPullParser);
            }
            return new d(new dr(string, string2, string3, a(resources, resourceId)), integer, integer2);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(d(xmlPullParser, resources));
                } else {
                    a(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b((c[]) arrayList.toArray(new c[arrayList.size()]));
    }

    public static List<List<byte[]>> a(Resources resources, int i) {
        ArrayList arrayList = null;
        if (i != 0) {
            TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i);
            if (typedArrayObtainTypedArray.length() > 0) {
                ArrayList arrayList2 = new ArrayList();
                if (typedArrayObtainTypedArray.getResourceId(0, 0) != 0) {
                    for (int i2 = 0; i2 < typedArrayObtainTypedArray.length(); i2++) {
                        arrayList2.add(a(resources.getStringArray(typedArrayObtainTypedArray.getResourceId(i2, 0))));
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList2.add(a(resources.getStringArray(i)));
                    arrayList = arrayList2;
                }
            }
            typedArrayObtainTypedArray.recycle();
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }

    private static List<byte[]> a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    private static c d(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), j.a.FontFamilyFont);
        int i = typedArrayObtainAttributes.getInt(j.a.FontFamilyFont_fontWeight, HttpStatus.SC_BAD_REQUEST);
        boolean z = 1 == typedArrayObtainAttributes.getInt(j.a.FontFamilyFont_fontStyle, 0);
        int resourceId = typedArrayObtainAttributes.getResourceId(j.a.FontFamilyFont_font, 0);
        String string = typedArrayObtainAttributes.getString(j.a.FontFamilyFont_font);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new c(string, i, z, resourceId);
    }

    private static void a(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
            }
        }
    }
}
