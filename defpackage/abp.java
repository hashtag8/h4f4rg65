package defpackage;

import defpackage.wl;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class abp {
    public static long a(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException e) {
            return 0L;
        }
    }

    public static String a(Map<String, String> map) {
        return a(map, "ISO-8859-1");
    }

    public static String a(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 == null) {
            return str;
        }
        String[] strArrSplit = str2.split(";");
        for (int i = 1; i < strArrSplit.length; i++) {
            String[] strArrSplit2 = strArrSplit[i].trim().split("=");
            if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                return strArrSplit2[1];
            }
        }
        return str;
    }

    public static wl.a a(zo zoVar) {
        boolean z;
        boolean z2;
        long j;
        long j2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zoVar.c;
        long j3 = 0;
        long j4 = 0;
        String str = map.get(HTTP.DATE_HEADER);
        long jA = str != null ? a(str) : 0L;
        String str2 = map.get("Cache-Control");
        if (str2 != null) {
            String[] strArrSplit = str2.split(",");
            z = false;
            long j5 = 0;
            long j6 = 0;
            for (String str3 : strArrSplit) {
                String strTrim = str3.trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j6 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception e) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    try {
                        j5 = Long.parseLong(strTrim.substring(23));
                    } catch (Exception e2) {
                    }
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    z = true;
                }
            }
            j3 = j6;
            j4 = j5;
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        String str4 = map.get("Expires");
        long jA2 = str4 != null ? a(str4) : 0L;
        String str5 = map.get("Last-Modified");
        long jA3 = str5 != null ? a(str5) : 0L;
        String str6 = map.get("ETag");
        if (z2) {
            j2 = jCurrentTimeMillis + (1000 * j3);
            j = z ? j2 : (1000 * j4) + j2;
        } else if (jA <= 0 || jA2 < jA) {
            j = 0;
            j2 = 0;
        } else {
            j = (jA2 - jA) + jCurrentTimeMillis;
            j2 = j;
        }
        wl.a aVar = new wl.a();
        aVar.a = zoVar.b;
        aVar.b = str6;
        aVar.f = j2;
        aVar.e = j;
        aVar.c = jA;
        aVar.d = jA3;
        aVar.g = map;
        return aVar;
    }
}
