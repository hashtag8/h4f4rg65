package defpackage;

import java.net.IDN;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentLengthStrategy;

/* JADX INFO: loaded from: classes.dex */
public final class bfb {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final List<String> g;
    private final List<String> h;
    private final String i;
    private final String j;

    private bfb(a aVar) {
        this.b = aVar.a;
        this.c = d(aVar.b);
        this.d = d(aVar.c);
        this.e = aVar.d;
        this.f = aVar.a();
        this.g = a(aVar.f);
        this.h = aVar.g != null ? a(aVar.g) : null;
        this.i = aVar.h != null ? d(aVar.h) : null;
        this.j = aVar.toString();
    }

    public URL a() {
        try {
            return new URL(this.j);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public URI b() {
        try {
            return new URI(this.j);
        } catch (URISyntaxException e) {
            throw new IllegalStateException("not valid as a java.net.URI: " + this.j);
        }
    }

    public boolean c() {
        return this.b.equals("https");
    }

    public String d() {
        if (this.c.isEmpty()) {
            return "";
        }
        int length = this.b.length() + 3;
        return this.j.substring(length, b(this.j, length, this.j.length(), ":@"));
    }

    public String e() {
        if (this.d.isEmpty()) {
            return "";
        }
        return this.j.substring(this.j.indexOf(58, this.b.length() + 3) + 1, this.j.indexOf(64));
    }

    public static int a(String str) {
        if (str.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
            return 80;
        }
        if (str.equals("https")) {
            return 443;
        }
        return -1;
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public List<String> f() {
        int iIndexOf = this.j.indexOf(47, this.b.length() + 3);
        int iB = b(this.j, iIndexOf, this.j.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iB) {
            int i = iIndexOf + 1;
            iIndexOf = b(this.j, i, iB, "/");
            arrayList.add(this.j.substring(i, iIndexOf));
        }
        return arrayList;
    }

    public String g() {
        if (this.h == null) {
            return null;
        }
        int iIndexOf = this.j.indexOf(63) + 1;
        return this.j.substring(iIndexOf, b(this.j, iIndexOf + 1, this.j.length(), "#"));
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf = str.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i = iIndexOf + 1;
        }
        return arrayList;
    }

    public static bfb c(String str) {
        return new a().a(null, str);
    }

    public static bfb a(URL url) {
        return c(url.toString());
    }

    public boolean equals(Object obj) {
        return (obj instanceof bfb) && ((bfb) obj).j.equals(this.j);
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public String toString() {
        return this.j;
    }

    public static final class a {
        String a;
        String d;
        List<String> g;
        String h;
        String b = "";
        String c = "";
        int e = -1;
        final List<String> f = new ArrayList();

        public a() {
            this.f.add("");
        }

        int a() {
            return this.e != -1 ? this.e : bfb.a(this.a);
        }

        public a a(String str) {
            this.g = str != null ? bfb.b(bfb.a(str, " \"'<>#", true, true)) : null;
            return this;
        }

        public bfb b() {
            if (this.a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.d == null) {
                throw new IllegalStateException("host == null");
            }
            return new bfb(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("://");
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                sb.append(this.b);
                if (!this.c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.c);
                }
                sb.append('@');
            }
            if (this.d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.d);
                sb.append(']');
            } else {
                sb.append(this.d);
            }
            int iA = a();
            if (iA != bfb.a(this.a)) {
                sb.append(':');
                sb.append(iA);
            }
            bfb.a(sb, this.f);
            if (this.g != null) {
                sb.append('?');
                bfb.b(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }

        bfb a(bfb bfbVar, String str) {
            int iB;
            int iB2 = b(str, 0, str.length());
            int iC = c(str, iB2, str.length());
            if (d(str, iB2, iC) != -1) {
                if (str.regionMatches(true, iB2, "https:", 0, 6)) {
                    this.a = "https";
                    iB2 += "https:".length();
                } else if (str.regionMatches(true, iB2, "http:", 0, 5)) {
                    this.a = HttpHost.DEFAULT_SCHEME_NAME;
                    iB2 += "http:".length();
                } else {
                    return null;
                }
            } else if (bfbVar != null) {
                this.a = bfbVar.b;
            } else {
                return null;
            }
            boolean z = false;
            boolean z2 = false;
            int iE = e(str, iB2, iC);
            if (iE >= 2 || bfbVar == null || !bfbVar.b.equals(this.a)) {
                int i = iB2 + iE;
                while (true) {
                    boolean z3 = z2;
                    boolean z4 = z;
                    int i2 = i;
                    int iB3 = bfb.b(str, i2, iC, "@/\\?#");
                    switch (iB3 != iC ? str.charAt(iB3) : (byte) -1) {
                        case ContentLengthStrategy.IDENTITY /* -1 */:
                        case 35:
                        case 47:
                        case 63:
                        case 92:
                            int iF = f(str, i2, iB3);
                            if (iF + 1 < iB3) {
                                this.d = g(str, i2, iF);
                                this.e = i(str, iF + 1, iB3);
                                if (this.e == -1) {
                                    return null;
                                }
                            } else {
                                this.d = g(str, i2, iF);
                                this.e = bfb.a(this.a);
                            }
                            if (this.d == null) {
                                return null;
                            }
                            iB2 = iB3;
                            break;
                        case 64:
                            if (z3) {
                                this.c += "%40" + bfb.a(str, i2, iB3, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                            } else {
                                int iB4 = bfb.b(str, i2, iB3, ":");
                                String strA = bfb.a(str, i2, iB4, " \"':;<=>@[]^`{}|/\\?#", true, false);
                                if (z4) {
                                    strA = this.b + "%40" + strA;
                                }
                                this.b = strA;
                                if (iB4 != iB3) {
                                    z3 = true;
                                    this.c = bfb.a(str, iB4 + 1, iB3, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                                }
                                z4 = true;
                            }
                            i = iB3 + 1;
                            z2 = z3;
                            continue;
                            z = z4;
                            break;
                        default:
                            z2 = z3;
                            i = i2;
                            continue;
                            z = z4;
                            break;
                    }
                }
            } else {
                this.b = bfbVar.d();
                this.c = bfbVar.e();
                this.d = bfbVar.e;
                this.e = bfbVar.f;
                this.f.clear();
                this.f.addAll(bfbVar.f());
                if (iB2 == iC || str.charAt(iB2) == '#') {
                    a(bfbVar.g());
                }
            }
            int iB5 = bfb.b(str, iB2, iC, "?#");
            a(str, iB2, iB5);
            if (iB5 >= iC || str.charAt(iB5) != '?') {
                iB = iB5;
            } else {
                iB = bfb.b(str, iB5, iC, "#");
                this.g = bfb.b(bfb.a(str, iB5 + 1, iB, " \"'<>#", true, true));
            }
            if (iB < iC && str.charAt(iB) == '#') {
                this.h = bfb.a(str, iB + 1, iC, "", true, false);
            }
            return b();
        }

        private void a(String str, int i, int i2) {
            if (i != i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt == '/' || cCharAt == '\\') {
                    this.f.clear();
                    this.f.add("");
                    i++;
                } else {
                    this.f.set(this.f.size() - 1, "");
                }
                int i3 = i;
                while (i3 < i2) {
                    int iB = bfb.b(str, i3, i2, "/\\");
                    boolean z = iB < i2;
                    a(str, i3, iB, z, true);
                    if (z) {
                        iB++;
                    }
                    i3 = iB;
                }
            }
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String strA = bfb.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false);
            if (!b(strA)) {
                if (c(strA)) {
                    c();
                    return;
                }
                if (this.f.get(this.f.size() - 1).isEmpty()) {
                    this.f.set(this.f.size() - 1, strA);
                } else {
                    this.f.add(strA);
                }
                if (z) {
                    this.f.add("");
                }
            }
        }

        private boolean b(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean c(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void c() {
            if (this.f.remove(this.f.size() - 1).isEmpty() && !this.f.isEmpty()) {
                this.f.set(this.f.size() - 1, "");
            } else {
                this.f.add("");
            }
        }

        private int b(String str, int i, int i2) {
            for (int i3 = i; i3 < i2; i3++) {
                switch (str.charAt(i3)) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        break;
                    default:
                        return i3;
                }
            }
            return i2;
        }

        private int c(String str, int i, int i2) {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                switch (str.charAt(i3)) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        break;
                    default:
                        return i3 + 1;
                }
            }
            return i;
        }

        private static int d(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt < 'a' || cCharAt > 'z') && (cCharAt < 'A' || cCharAt > 'Z')) {
                return -1;
            }
            for (int i3 = i + 1; i3 < i2; i3++) {
                char cCharAt2 = str.charAt(i3);
                if ((cCharAt2 < 'a' || cCharAt2 > 'z') && ((cCharAt2 < 'A' || cCharAt2 > 'Z') && cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.')) {
                    if (cCharAt2 == ':') {
                        return i3;
                    }
                    return -1;
                }
            }
            return -1;
        }

        private static int e(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static int f(String str, int i, int i2) {
            int i3 = i;
            while (i3 < i2) {
                switch (str.charAt(i3)) {
                    case ':':
                        return i3;
                    case '[':
                        do {
                            i3++;
                            if (i3 < i2) {
                            }
                            i3++;
                            break;
                        } while (str.charAt(i3) != ']');
                        i3++;
                        break;
                    default:
                        i3++;
                        break;
                }
            }
            return i2;
        }

        private static String g(String str, int i, int i2) {
            int length;
            String strA = bfb.a(str, i, i2);
            if (strA.startsWith("[") && strA.endsWith("]")) {
                InetAddress inetAddressH = h(strA, 1, strA.length() - 1);
                if (inetAddressH != null) {
                    return inetAddressH.getHostAddress();
                }
                return null;
            }
            String strD = d(strA);
            if (strD == null || bfb.b(strD, 0, length, "\u0000\t\n\r #%/:?@[\\]") != (length = strD.length())) {
                return null;
            }
            return strD;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
        
            if (r2 == r8.length) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
        
            if (r1 != (-1)) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0085, code lost:
        
            java.lang.System.arraycopy(r8, r1, r8, r8.length - (r2 - r1), r2 - r1);
            java.util.Arrays.fill(r8, r1, (r8.length - r2) + r1, (byte) 0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00a0, code lost:
        
            throw new java.lang.AssertionError();
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
        
            return java.net.InetAddress.getByAddress(r8);
         */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static java.net.InetAddress h(java.lang.String r12, int r13, int r14) {
            /*
                r11 = 1
                r7 = -1
                r3 = 0
                r5 = 0
                r0 = 16
                byte[] r8 = new byte[r0]
                r0 = r13
                r4 = r7
                r1 = r7
                r2 = r5
            Lc:
                if (r0 >= r14) goto L2b
                int r6 = r8.length
                if (r2 != r6) goto L13
                r0 = r3
            L12:
                return r0
            L13:
                int r6 = r0 + 2
                if (r6 > r14) goto L32
                java.lang.String r6 = "::"
                r9 = 2
                boolean r6 = r12.regionMatches(r0, r6, r5, r9)
                if (r6 == 0) goto L32
                if (r1 == r7) goto L24
                r0 = r3
                goto L12
            L24:
                int r0 = r0 + 2
                int r1 = r2 + 2
                if (r0 != r14) goto La1
                r2 = r1
            L2b:
                int r0 = r8.length
                if (r2 == r0) goto L94
                if (r1 != r7) goto L85
                r0 = r3
                goto L12
            L32:
                if (r2 == 0) goto L3e
                java.lang.String r6 = ":"
                boolean r6 = r12.regionMatches(r0, r6, r5, r11)
                if (r6 == 0) goto L55
                int r0 = r0 + 1
            L3e:
                r4 = r5
                r6 = r0
            L40:
                if (r6 >= r14) goto L4c
                char r9 = r12.charAt(r6)
                int r9 = defpackage.bfb.a(r9)
                if (r9 != r7) goto L6c
            L4c:
                int r9 = r6 - r0
                if (r9 == 0) goto L53
                r10 = 4
                if (r9 <= r10) goto L72
            L53:
                r0 = r3
                goto L12
            L55:
                java.lang.String r6 = "."
                boolean r0 = r12.regionMatches(r0, r6, r5, r11)
                if (r0 == 0) goto L6a
                int r0 = r2 + (-2)
                boolean r0 = a(r12, r4, r14, r8, r0)
                if (r0 != 0) goto L67
                r0 = r3
                goto L12
            L67:
                int r2 = r2 + 2
                goto L2b
            L6a:
                r0 = r3
                goto L12
            L6c:
                int r4 = r4 << 4
                int r4 = r4 + r9
                int r6 = r6 + 1
                goto L40
            L72:
                int r9 = r2 + 1
                int r10 = r4 >>> 8
                r10 = r10 & 255(0xff, float:3.57E-43)
                byte r10 = (byte) r10
                r8[r2] = r10
                int r2 = r9 + 1
                r4 = r4 & 255(0xff, float:3.57E-43)
                byte r4 = (byte) r4
                r8[r9] = r4
                r4 = r0
                r0 = r6
                goto Lc
            L85:
                int r0 = r8.length
                int r3 = r2 - r1
                int r0 = r0 - r3
                int r3 = r2 - r1
                java.lang.System.arraycopy(r8, r1, r8, r0, r3)
                int r0 = r8.length
                int r0 = r0 - r2
                int r0 = r0 + r1
                java.util.Arrays.fill(r8, r1, r0, r5)
            L94:
                java.net.InetAddress r0 = java.net.InetAddress.getByAddress(r8)     // Catch: java.net.UnknownHostException -> L9a
                goto L12
            L9a:
                r0 = move-exception
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            La1:
                r2 = r1
                goto L3e
            */
            throw new UnsupportedOperationException("Method not decompiled: bfb.a.h(java.lang.String, int, int):java.net.InetAddress");
        }

        private static boolean a(String str, int i, int i2, byte[] bArr, int i3) {
            int i4 = i;
            int i5 = i3;
            while (i4 < i2) {
                if (i5 == bArr.length) {
                    return false;
                }
                if (i5 != i3) {
                    if (str.charAt(i4) != '.') {
                        return false;
                    }
                    i4++;
                }
                int i6 = 0;
                int i7 = i4;
                while (i7 < i2) {
                    char cCharAt = str.charAt(i7);
                    if (cCharAt < '0' || cCharAt > '9') {
                        break;
                    }
                    if ((i6 != 0 || i4 == i7) && ((i6 * 10) + cCharAt) - 48 <= 255) {
                        i7++;
                    }
                    return false;
                }
                if (i7 - i4 == 0) {
                    return false;
                }
                bArr[i5] = (byte) i6;
                i5++;
                i4 = i7;
            }
            return i5 == i3 + 4;
        }

        private static String d(String str) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException e) {
                return null;
            }
        }

        private static int i(String str, int i, int i2) {
            try {
                int i3 = Integer.parseInt(bfb.a(str, i, i2, "", false, false));
                if (i3 <= 0 || i3 > 65535) {
                    return -1;
                }
                return i3;
            } catch (NumberFormatException e) {
                return -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(String str, int i, int i2, String str2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str2.indexOf(str.charAt(i3)) != -1) {
                return i3;
            }
        }
        return i2;
    }

    static String d(String str) {
        return a(str, 0, str.length());
    }

    private List<String> a(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            arrayList.add(next != null ? d(next) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String a(String str, int i, int i2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str.charAt(i3) == '%') {
                bqs bqsVar = new bqs();
                bqsVar.a(str, i, i3);
                a(bqsVar, str, i3, i2);
                return bqsVar.q();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(defpackage.bqs r5, java.lang.String r6, int r7, int r8) {
        /*
            r4 = -1
            r0 = r7
        L2:
            if (r0 >= r8) goto L3a
            int r1 = r6.codePointAt(r0)
            r2 = 37
            if (r1 != r2) goto L36
            int r2 = r0 + 2
            if (r2 >= r8) goto L36
            int r2 = r0 + 1
            char r2 = r6.charAt(r2)
            int r2 = a(r2)
            int r3 = r0 + 2
            char r3 = r6.charAt(r3)
            int r3 = a(r3)
            if (r2 == r4) goto L36
            if (r3 == r4) goto L36
            int r2 = r2 << 4
            int r2 = r2 + r3
            r5.h(r2)
            int r0 = r0 + 2
        L30:
            int r1 = java.lang.Character.charCount(r1)
            int r0 = r0 + r1
            goto L2
        L36:
            r5.a(r1)
            goto L30
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bfb.a(bqs, java.lang.String, int, int):void");
    }

    static int a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c < 'A' || c > 'F') {
            return -1;
        }
        return (c - 'A') + 10;
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt < 127 && str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || z) && (!z2 || iCodePointAt != 43))) {
                iCharCount += Character.charCount(iCodePointAt);
            } else {
                bqs bqsVar = new bqs();
                bqsVar.a(str, i, iCharCount);
                a(bqsVar, str, iCharCount, i2, str2, z, z2);
                return bqsVar.q();
            }
        }
        return str.substring(i, i2);
    }

    static void a(bqs bqsVar, String str, int i, int i2, String str2, boolean z, boolean z2) {
        bqs bqsVar2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (z2 && iCodePointAt == 43) {
                    bqsVar.b(z ? "%20" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt >= 127 || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && !z)) {
                    if (bqsVar2 == null) {
                        bqsVar2 = new bqs();
                    }
                    bqsVar2.a(iCodePointAt);
                    while (!bqsVar2.f()) {
                        int i3 = bqsVar2.i() & 255;
                        bqsVar.h(37);
                        bqsVar.h((int) a[(i3 >> 4) & 15]);
                        bqsVar.h((int) a[i3 & 15]);
                    }
                } else {
                    bqsVar.a(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    static String a(String str, String str2, boolean z, boolean z2) {
        return a(str, 0, str.length(), str2, z, z2);
    }
}
