package defpackage;

import android.util.Log;
import android.util.Xml;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class bjl implements Serializable {
    private ArrayList<bjm> a = new ArrayList<>();
    private String b;
    private bjq c;
    private String d;

    public bjl(bjq bjqVar) {
        this.c = bjqVar;
    }

    public void a(String str) {
        this.b = str;
    }

    public String a() {
        return this.b;
    }

    public void a(ArrayList<bjm> arrayList) {
        this.a = arrayList;
    }

    public ArrayList<bjm> b() {
        return this.a;
    }

    public bjm b(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.a.size()) {
                if (!this.a.get(i2).a().equals(str)) {
                    i = i2 + 1;
                } else {
                    return this.a.get(i2);
                }
            } else {
                return null;
            }
        }
    }

    public bjq c() {
        return this.c;
    }

    public String d() {
        ArrayList<bjm> arrayListE = e();
        bkh bkhVar = new bkh();
        bkhVar.a(this, arrayListE);
        bki bkiVarA = bkhVar.a(bkhVar.w().toString(), "" + c().a() + "#" + a() + "");
        byte[] bArrH = bkiVarA.a().h();
        if (!bkiVarA.q()) {
            return a(bArrH);
        }
        try {
            a(bArrH, this);
        } catch (XmlPullParserException e) {
            Log.d("DLNA-LIB ", e.getMessage());
        }
        bkiVarA.a(this);
        return "";
    }

    private String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "Unknown Error";
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
            xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            xmlPullParserNewPullParser.setInput(byteArrayInputStream, null);
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                String name = xmlPullParserNewPullParser.getName();
                switch (eventType) {
                    case 3:
                        if (name.equals("u:errorDescription")) {
                            return this.d;
                        }
                        break;
                        break;
                    case 4:
                        this.d = xmlPullParserNewPullParser.getText();
                        break;
                }
            }
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            return "Unknown Error";
        } catch (IOException e) {
            return "Unknown Error" + e.getMessage();
        } catch (XmlPullParserException e2) {
            return "Unknown Error  " + e2.getMessage();
        }
    }

    private void a(byte[] bArr, bjl bjlVar) throws XmlPullParserException {
        if (bArr != null && bjlVar != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
            xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            xmlPullParserNewPullParser.setInput(byteArrayInputStream, null);
            int eventType = xmlPullParserNewPullParser.getEventType();
            while (eventType != 1) {
                String name = xmlPullParserNewPullParser.getName();
                switch (eventType) {
                    case 3:
                        if (name.equals("Result")) {
                            bjlVar.b("Result").d(this.d);
                        } else if (name.equals("NumberReturned")) {
                            bjlVar.b("NumberReturned").d(this.d);
                        } else if (name.equals("TotalMatches")) {
                            bjlVar.b("TotalMatches").d(this.d);
                        } else if (name.equals("UpdateID")) {
                            bjlVar.b("UpdateID").d(this.d);
                        }
                        break;
                    case 4:
                        this.d = xmlPullParserNewPullParser.getText();
                        break;
                }
                try {
                    eventType = xmlPullParserNewPullParser.next();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private ArrayList<bjm> e() {
        ArrayList<bjm> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.a.size()) {
                if (this.a.get(i2).d()) {
                    arrayList.add(this.a.get(i2));
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }
}
