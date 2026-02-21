package defpackage;

import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class bkm {
    private static int a = 524288;

    public static String a(String str) {
        try {
            URL url = new URL(str);
            bkx.a("Url is " + url);
            return url.getHost();
        } catch (Exception e) {
            return "";
        }
    }

    public static int b(String str) {
        try {
            int port = new URL(str).getPort();
            if (port <= 0) {
                return 80;
            }
            return port;
        } catch (Exception e) {
            return 80;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r3, boolean r4) {
        /*
            r1 = 0
            boolean r0 = defpackage.bky.a(r3)
            if (r0 == 0) goto L29
            int r0 = r3.length()
            if (r0 <= 0) goto L28
            char r0 = r3.charAt(r1)
            r1 = 47
            if (r0 == r1) goto L28
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "/"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r3 = r0.toString()
        L28:
            return r3
        L29:
            java.net.URL r0 = new java.net.URL     // Catch: java.lang.Exception -> L6d
            r0.<init>(r3)     // Catch: java.lang.Exception -> L6d
            java.lang.String r3 = r0.getPath()     // Catch: java.lang.Exception -> L6d
            if (r4 == 0) goto L72
            java.lang.String r0 = r0.getQuery()     // Catch: java.lang.Exception -> L6d
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)     // Catch: java.lang.Exception -> L6d
            if (r1 != 0) goto L72
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L6d
            r1.<init>()     // Catch: java.lang.Exception -> L6d
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Exception -> L6d
            java.lang.String r2 = "?"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Exception -> L6d
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch: java.lang.Exception -> L6d
            java.lang.String r3 = r0.toString()     // Catch: java.lang.Exception -> L6d
            r0 = r3
        L58:
            java.lang.String r1 = "/"
            boolean r1 = r0.endsWith(r1)     // Catch: java.lang.Exception -> L6f
            if (r1 == 0) goto L6b
            r1 = 0
            int r2 = r0.length()     // Catch: java.lang.Exception -> L6f
            int r2 = r2 + (-1)
            java.lang.String r0 = r0.substring(r1, r2)     // Catch: java.lang.Exception -> L6f
        L6b:
            r3 = r0
            goto L28
        L6d:
            r0 = move-exception
            goto L28
        L6f:
            r1 = move-exception
            r3 = r0
            goto L28
        L72:
            r0 = r3
            goto L58
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bkm.a(java.lang.String, boolean):java.lang.String");
    }

    public static String c(String str) {
        return a(str, true);
    }

    public static int a() {
        return a;
    }
}
