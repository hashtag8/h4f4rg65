package defpackage;

import android.util.Log;
import android.util.Xml;
import android.webkit.URLUtil;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class bjq implements Serializable {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private Hashtable<String, bjl> f = new Hashtable<>();
    private bjn g;
    private String h;
    private boolean i;
    private boolean j;
    private ArrayList<bjm> k;
    private bjm l;
    private String m;
    private bjl n;

    public bjq(bjn bjnVar) {
        this.g = bjnVar;
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public String b() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public void e(String str) {
        this.e = str;
    }

    public Hashtable<String, bjl> c() {
        return this.f;
    }

    public void a(String str, String str2) {
        String str3;
        URL url;
        if (str != null) {
            if (str2 == null || str2 == "") {
                str3 = "";
            } else {
                str3 = "/" + str2.replace("uuid:", "");
            }
            try {
                if (URLUtil.isValidUrl(this.c)) {
                    url = new URL(this.c);
                } else if (this.c.charAt(0) == '/') {
                    url = new URL(str + this.c);
                } else {
                    url = new URL(str + str3 + "/" + this.c);
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openConnection().getInputStream());
                XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                xmlPullParserNewPullParser.setInput(bufferedInputStream, null);
                a(xmlPullParserNewPullParser);
                bkx.a("DLNA-LIB Service parsing ended ");
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
            } catch (Exception e) {
                bkx.a(Log.getStackTraceString(e));
            }
        }
    }

    public void a(XmlPullParser xmlPullParser) {
        if (xmlPullParser != null) {
            try {
                int eventType = xmlPullParser.getEventType();
                while (eventType != 1) {
                    String name = xmlPullParser.getName();
                    switch (eventType) {
                        case 2:
                            if (name.equals("action")) {
                                this.i = true;
                                this.n = new bjl(this);
                            } else if (name.equals("argumentList") && this.i) {
                                this.k = new ArrayList<>();
                            } else if (name.equals("argument") && this.i) {
                                this.l = new bjm();
                                this.j = true;
                            }
                            break;
                        case 3:
                            if (name.equals("action")) {
                                this.i = false;
                                this.n.a(this.m);
                                this.n.a(this.k);
                                this.f.put(this.m, this.n);
                            } else if (name.equals("name") && this.i && !this.j) {
                                this.m = this.h;
                            } else if (name.equals("name") && this.i && this.j) {
                                this.l.a(this.h);
                            } else if (name.equals("direction") && this.i && this.j) {
                                this.l.b(this.h);
                            } else if (name.equals("relatedStateVariable") && this.i && this.j) {
                                this.l.c(this.h);
                            } else if (name.equals("argument") && this.i && this.j) {
                                this.k.add(this.l);
                                this.j = false;
                            }
                            break;
                        case 4:
                            this.h = xmlPullParser.getText();
                            break;
                    }
                    eventType = xmlPullParser.next();
                }
            } catch (IOException e) {
                Log.d("DLNA-LIB ", e.getMessage());
            } catch (XmlPullParserException e2) {
                Log.d("DLNA-LIB ", e2.getMessage());
            }
        }
    }

    public bjl f(String str) {
        if (this.f == null || !this.f.containsKey(str)) {
            return null;
        }
        return this.f.get(str);
    }

    public bjn d() {
        return this.g;
    }
}
