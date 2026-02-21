package defpackage;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.apache.http.entity.mime.MIME;

/* JADX INFO: loaded from: classes.dex */
public class bth {
    private static final Pattern a = Pattern.compile("[\\x21-\\x39\\x3b-\\x7e]+");

    public static btc a(String str) {
        return (btc) a(btc.a, "Content-Type", str);
    }

    public static btc a(String str, Map<String, String> map) {
        if (!d(str)) {
            throw new IllegalArgumentException();
        }
        if (map == null || map.isEmpty()) {
            return (btc) a(btc.a, "Content-Type", str);
        }
        StringBuilder sb = new StringBuilder(str);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append("; ");
            sb.append(bsu.a(entry.getKey(), entry.getValue()));
        }
        return a(sb.toString());
    }

    public static btb b(String str) {
        return (btb) a(btb.a, MIME.CONTENT_TRANSFER_ENC, str);
    }

    public static bta c(String str) {
        return (bta) a(bta.a, MIME.CONTENT_DISPOSITION, str);
    }

    public static bta b(String str, Map<String, String> map) {
        if (!e(str)) {
            throw new IllegalArgumentException();
        }
        if (map == null || map.isEmpty()) {
            return (bta) a(bta.a, MIME.CONTENT_DISPOSITION, str);
        }
        StringBuilder sb = new StringBuilder(str);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append("; ");
            sb.append(bsu.a(entry.getKey(), entry.getValue()));
        }
        return c(sb.toString());
    }

    public static bta a(String str, String str2, long j, Date date, Date date2, Date date3) {
        HashMap map = new HashMap();
        if (str2 != null) {
            map.put("filename", str2);
        }
        if (j >= 0) {
            map.put("size", Long.toString(j));
        }
        if (date != null) {
            map.put("creation-date", but.a(date, (TimeZone) null));
        }
        if (date2 != null) {
            map.put("modification-date", but.a(date2, (TimeZone) null));
        }
        if (date3 != null) {
            map.put("read-date", but.a(date3, (TimeZone) null));
        }
        return b(str, map);
    }

    private static boolean d(String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return false;
        }
        return bsu.a(str.substring(0, iIndexOf)) && bsu.a(str.substring(iIndexOf + 1));
    }

    private static boolean e(String str) {
        if (str == null) {
            return false;
        }
        return bsu.a(str);
    }

    private static <F extends bun> F a(btg btgVar, String str, String str2) {
        return btgVar.a(str, str2, bur.a(but.a(str + ": " + str2, 0)));
    }
}
