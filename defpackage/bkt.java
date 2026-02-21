package defpackage;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes.dex */
public class bkt {
    private static Pattern d;
    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = false;
    private static String e = "";

    static {
        d = null;
        try {
            d = Pattern.compile("([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}", 2);
        } catch (PatternSyntaxException e2) {
            bkx.a("PaternMatch Exception" + e2.getStackTrace());
        }
    }

    public static boolean a(String str) {
        try {
            return InetAddress.getByName(str) instanceof Inet6Address;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean b(String str) {
        return d.matcher(str).matches();
    }
}
