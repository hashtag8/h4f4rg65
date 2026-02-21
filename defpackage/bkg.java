package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class bkg {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.String r8, boolean r9) {
        /*
            r1 = 0
            r0 = 0
            if (r8 != 0) goto L5
        L4:
            return r1
        L5:
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            r4.<init>()
            int r5 = r8.length()
            char[] r6 = new char[r5]
            r8.getChars(r0, r5, r6, r0)
            r3 = r0
            r2 = r0
            r0 = r1
        L16:
            if (r3 >= r5) goto L41
            char r7 = r6[r3]
            switch(r7) {
                case 34: goto L3c;
                case 38: goto L2e;
                case 39: goto L37;
                case 60: goto L31;
                case 62: goto L34;
                default: goto L1d;
            }
        L1d:
            if (r0 == 0) goto L2b
            int r7 = r3 - r2
            r4.append(r6, r2, r7)
            r4.append(r0)
            int r0 = r3 + 1
            r2 = r0
            r0 = r1
        L2b:
            int r3 = r3 + 1
            goto L16
        L2e:
            java.lang.String r0 = "&amp;"
            goto L1d
        L31:
            java.lang.String r0 = "&lt;"
            goto L1d
        L34:
            java.lang.String r0 = "&gt;"
            goto L1d
        L37:
            if (r9 == 0) goto L3c
            java.lang.String r0 = "&apos;"
            goto L1d
        L3c:
            if (r9 == 0) goto L1d
            java.lang.String r0 = "&quot;"
            goto L1d
        L41:
            if (r2 != 0) goto L45
            r1 = r8
            goto L4
        L45:
            int r0 = r5 - r2
            r4.append(r6, r2, r0)
            java.lang.String r1 = r4.toString()
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bkg.a(java.lang.String, boolean):java.lang.String");
    }

    public static String a(String str) {
        return a(str, true);
    }
}
