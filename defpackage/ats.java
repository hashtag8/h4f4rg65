package defpackage;

import java.net.URI;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class ats {
    private static String a;

    public static att a(String str) {
        a = b(str);
        att attVar = new att();
        if (a.length() > 0) {
            attVar.a = a();
            attVar.f = f();
            attVar.b = b();
            attVar.c = c();
            attVar.d = d();
            attVar.e = e();
        }
        return attVar;
    }

    private static String b(String str) {
        if (str.length() > 0) {
            try {
                return new String(((String) new DefaultHttpClient().execute(new HttpGet(new URI(str)), new BasicResponseHandler())).getBytes("ISO-8859-1"), HTTP.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    private static String a() {
        return c("friendlyName");
    }

    private static String b() {
        return c("manufacturer");
    }

    private static String c() {
        return c("manufacturerURL");
    }

    private static String d() {
        return c("modelDescription");
    }

    private static String e() {
        return c("modelName");
    }

    private static String f() {
        return c("area_code");
    }

    private static String c(String str) {
        String str2 = "<" + str + ">";
        int iIndexOf = a.indexOf(str2) + str2.length();
        int iIndexOf2 = a.indexOf("</" + str + ">");
        if (iIndexOf == -1 || iIndexOf2 == -1) {
            return null;
        }
        try {
            return a.substring(iIndexOf, iIndexOf2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
