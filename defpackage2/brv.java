package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class brv {
    public static final String K;
    public static final String L;
    public static final String M;
    public static final String N;
    public static final String O;
    public static final String P;
    public static final boolean Q;
    public static final boolean R;
    public static final boolean S;
    public static final boolean T;
    public static final boolean U;
    public static final boolean V;
    public static final boolean W;
    public static final boolean X;
    public static final boolean Y;
    public static final boolean Z;
    public static final boolean aa;
    public static final boolean ab;
    public static final boolean ac;
    public static final boolean ad;
    public static final boolean ae;
    public static final boolean af;
    public static final boolean ag;
    public static final boolean ah;
    public static final boolean ai;
    public static final boolean aj;
    public static final boolean ak;
    public static final boolean al;
    public static final boolean am;
    public static final boolean an;
    public static final boolean ao;
    public static final boolean ap;
    public static final boolean aq;
    public static final boolean ar;
    public static final boolean as;
    public static final boolean at;
    public static final boolean au;
    public static final String a = c("awt.toolkit");
    public static final String b = c("file.encoding");
    public static final String c = c("file.separator");
    public static final String d = c("java.awt.fonts");
    public static final String e = c("java.awt.graphicsenv");
    public static final String f = c("java.awt.headless");
    public static final String g = c("java.awt.printerjob");
    public static final String h = c("java.class.path");
    public static final String i = c("java.class.version");
    public static final String j = c("java.compiler");
    public static final String k = c("java.endorsed.dirs");
    public static final String l = c("java.ext.dirs");
    public static final String m = c("java.home");
    public static final String n = c("java.io.tmpdir");
    public static final String o = c("java.library.path");
    public static final String p = c("java.runtime.name");
    public static final String q = c("java.runtime.version");
    public static final String r = c("java.specification.name");
    public static final String s = c("java.specification.vendor");
    public static final String t = c("java.specification.version");
    private static final brr av = brr.a(t);
    public static final String u = c("java.util.prefs.PreferencesFactory");
    public static final String v = c("java.vendor");
    public static final String w = c("java.vendor.url");
    public static final String x = c("java.version");
    public static final String y = c("java.vm.info");
    public static final String z = c("java.vm.name");
    public static final String A = c("java.vm.specification.name");
    public static final String B = c("java.vm.specification.vendor");
    public static final String C = c("java.vm.specification.version");
    public static final String D = c("java.vm.vendor");
    public static final String E = c("java.vm.version");
    public static final String F = c("line.separator");
    public static final String G = c("os.arch");
    public static final String H = c("os.name");
    public static final String I = c("os.version");
    public static final String J = c("path.separator");

    static {
        K = c("user.country") == null ? c("user.region") : c("user.country");
        L = c("user.dir");
        M = c("user.home");
        N = c("user.language");
        O = c("user.name");
        P = c("user.timezone");
        Q = a("1.1");
        R = a("1.2");
        S = a("1.3");
        T = a("1.4");
        U = a("1.5");
        V = a("1.6");
        W = a("1.7");
        X = b("AIX");
        Y = b("HP-UX");
        Z = b("Irix");
        aa = b("Linux") || b("LINUX");
        ab = b("Mac");
        ac = b("Mac OS X");
        ad = b("FreeBSD");
        ae = b("OpenBSD");
        af = b("NetBSD");
        ag = b("OS/2");
        ah = b("Solaris");
        ai = b("SunOS");
        aj = X || Y || Z || aa || ac || ah || ai || ad || ae || af;
        ak = b("Windows");
        al = c("Windows", "5.0");
        am = c("Windows", "5.2");
        an = c("Windows Server 2008", "6.1");
        ao = c("Windows 9", "4.0");
        ap = c("Windows 9", "4.1");
        aq = c("Windows", "4.9");
        ar = b("Windows NT");
        as = c("Windows", "5.1");
        at = c("Windows", "6.0");
        au = c("Windows", "6.1");
    }

    private static boolean a(String str) {
        return a(t, str);
    }

    private static boolean c(String str, String str2) {
        return a(H, I, str, str2);
    }

    private static boolean b(String str) {
        return b(H, str);
    }

    private static String c(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException e2) {
            System.err.println("Caught a SecurityException reading the system property '" + str + "'; the SystemUtils property value will default to null.");
            return null;
        }
    }

    static boolean a(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.startsWith(str2);
    }

    static boolean a(String str, String str2, String str3, String str4) {
        return str != null && str2 != null && str.startsWith(str3) && str2.startsWith(str4);
    }

    static boolean b(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.startsWith(str2);
    }
}
