package defpackage;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* JADX INFO: loaded from: classes.dex */
public class adq implements Closeable {
    private static final char[] a = ")]}'\n".toCharArray();
    private final Reader c;
    private ads l;
    private String m;
    private String n;
    private int o;
    private int p;
    private boolean q;
    private final adv b = new adv();
    private boolean d = false;
    private final char[] e = new char[1024];
    private int f = 0;
    private int g = 0;
    private int h = 1;
    private int i = 1;
    private adr[] j = new adr[32];
    private int k = 0;

    static {
        acv.a = new acv() { // from class: adq.1
            @Override // defpackage.acv
            public void a(adq adqVar) {
                if (adqVar instanceof adg) {
                    ((adg) adqVar).o();
                    return;
                }
                adqVar.f();
                if (adqVar.l == ads.NAME) {
                    adqVar.n = adqVar.m;
                    adqVar.m = null;
                    adqVar.l = ads.STRING;
                    return;
                }
                throw new IllegalStateException("Expected a name but was " + adqVar.f() + "  at line " + adqVar.t() + " column " + adqVar.u());
            }
        };
    }

    public adq(Reader reader) {
        a(adr.EMPTY_DOCUMENT);
        this.q = false;
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.c = reader;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public final boolean p() {
        return this.d;
    }

    public void a() {
        a(ads.BEGIN_ARRAY);
    }

    public void b() {
        a(ads.END_ARRAY);
    }

    public void c() {
        a(ads.BEGIN_OBJECT);
    }

    public void d() {
        a(ads.END_OBJECT);
    }

    private void a(ads adsVar) {
        f();
        if (this.l != adsVar) {
            throw new IllegalStateException("Expected " + adsVar + " but was " + f() + " at line " + t() + " column " + u());
        }
        q();
    }

    public boolean e() {
        f();
        return (this.l == ads.END_OBJECT || this.l == ads.END_ARRAY) ? false : true;
    }

    public ads f() {
        if (this.l != null) {
            return this.l;
        }
        switch (this.j[this.k - 1]) {
            case EMPTY_DOCUMENT:
                if (this.d) {
                    o();
                }
                this.j[this.k - 1] = adr.NONEMPTY_DOCUMENT;
                ads adsVarS = s();
                if (!this.d && this.l != ads.BEGIN_ARRAY && this.l != ads.BEGIN_OBJECT) {
                    throw new IOException("Expected JSON document to start with '[' or '{' but was " + this.l + " at line " + t() + " column " + u());
                }
                return adsVarS;
            case EMPTY_ARRAY:
                return b(true);
            case NONEMPTY_ARRAY:
                return b(false);
            case EMPTY_OBJECT:
                return c(true);
            case DANGLING_NAME:
                return r();
            case NONEMPTY_OBJECT:
                return c(false);
            case NONEMPTY_DOCUMENT:
                if (d(false) == -1) {
                    return ads.END_DOCUMENT;
                }
                this.f--;
                if (!this.d) {
                    throw b("Expected EOF");
                }
                return s();
            case CLOSED:
                throw new IllegalStateException("JsonReader is closed");
            default:
                throw new AssertionError();
        }
    }

    private void o() throws IOException {
        d(true);
        this.f--;
        if (this.f + a.length <= this.g || a(a.length)) {
            for (int i = 0; i < a.length; i++) {
                if (this.e[this.f + i] != a[i]) {
                    return;
                }
            }
            this.f += a.length;
        }
    }

    private ads q() {
        f();
        ads adsVar = this.l;
        this.l = null;
        this.n = null;
        this.m = null;
        return adsVar;
    }

    public String g() {
        f();
        if (this.l != ads.NAME) {
            throw new IllegalStateException("Expected a name but was " + f() + " at line " + t() + " column " + u());
        }
        String str = this.m;
        q();
        return str;
    }

    public String h() {
        f();
        if (this.l != ads.STRING && this.l != ads.NUMBER) {
            throw new IllegalStateException("Expected a string but was " + f() + " at line " + t() + " column " + u());
        }
        String str = this.n;
        q();
        return str;
    }

    public boolean i() {
        f();
        if (this.l != ads.BOOLEAN) {
            throw new IllegalStateException("Expected a boolean but was " + this.l + " at line " + t() + " column " + u());
        }
        boolean z = this.n == "true";
        q();
        return z;
    }

    public void j() {
        f();
        if (this.l != ads.NULL) {
            throw new IllegalStateException("Expected null but was " + this.l + " at line " + t() + " column " + u());
        }
        q();
    }

    public double k() throws adu {
        f();
        if (this.l != ads.STRING && this.l != ads.NUMBER) {
            throw new IllegalStateException("Expected a double but was " + this.l + " at line " + t() + " column " + u());
        }
        double d = Double.parseDouble(this.n);
        if (d >= 1.0d && this.n.startsWith("0")) {
            throw new adu("JSON forbids octal prefixes: " + this.n + " at line " + t() + " column " + u());
        }
        if (!this.d && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new adu("JSON forbids NaN and infinities: " + this.n + " at line " + t() + " column " + u());
        }
        q();
        return d;
    }

    public long l() throws adu {
        long j;
        f();
        if (this.l != ads.STRING && this.l != ads.NUMBER) {
            throw new IllegalStateException("Expected a long but was " + this.l + " at line " + t() + " column " + u());
        }
        try {
            j = Long.parseLong(this.n);
        } catch (NumberFormatException e) {
            double d = Double.parseDouble(this.n);
            j = (long) d;
            if (j != d) {
                throw new NumberFormatException("Expected a long but was " + this.n + " at line " + t() + " column " + u());
            }
        }
        if (j >= 1 && this.n.startsWith("0")) {
            throw new adu("JSON forbids octal prefixes: " + this.n + " at line " + t() + " column " + u());
        }
        q();
        return j;
    }

    public int m() throws adu {
        int i;
        f();
        if (this.l != ads.STRING && this.l != ads.NUMBER) {
            throw new IllegalStateException("Expected an int but was " + this.l + " at line " + t() + " column " + u());
        }
        try {
            i = Integer.parseInt(this.n);
        } catch (NumberFormatException e) {
            double d = Double.parseDouble(this.n);
            i = (int) d;
            if (i != d) {
                throw new NumberFormatException("Expected an int but was " + this.n + " at line " + t() + " column " + u());
            }
        }
        if (i >= 1 && this.n.startsWith("0")) {
            throw new adu("JSON forbids octal prefixes: " + this.n + " at line " + t() + " column " + u());
        }
        q();
        return i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.n = null;
        this.l = null;
        this.j[0] = adr.CLOSED;
        this.k = 1;
        this.c.close();
    }

    public void n() {
        this.q = true;
        int i = 0;
        do {
            try {
                ads adsVarQ = q();
                if (adsVarQ == ads.BEGIN_ARRAY || adsVarQ == ads.BEGIN_OBJECT) {
                    i++;
                } else if (adsVarQ == ads.END_ARRAY || adsVarQ == ads.END_OBJECT) {
                    i--;
                }
            } finally {
                this.q = false;
            }
        } while (i != 0);
    }

    private void a(adr adrVar) {
        if (this.k == this.j.length) {
            adr[] adrVarArr = new adr[this.k * 2];
            System.arraycopy(this.j, 0, adrVarArr, 0, this.k);
            this.j = adrVarArr;
        }
        adr[] adrVarArr2 = this.j;
        int i = this.k;
        this.k = i + 1;
        adrVarArr2[i] = adrVar;
    }

    private ads b(boolean z) throws IOException {
        if (z) {
            this.j[this.k - 1] = adr.NONEMPTY_ARRAY;
        } else {
            switch (d(true)) {
                case 44:
                    break;
                case 59:
                    v();
                    break;
                case 93:
                    this.k--;
                    ads adsVar = ads.END_ARRAY;
                    this.l = adsVar;
                    return adsVar;
                default:
                    throw b("Unterminated array");
            }
        }
        switch (d(true)) {
            case 44:
            case 59:
                break;
            case 93:
                if (z) {
                    this.k--;
                    ads adsVar2 = ads.END_ARRAY;
                    this.l = adsVar2;
                    return adsVar2;
                }
                break;
            default:
                this.f--;
                return s();
        }
        v();
        this.f--;
        this.n = "null";
        ads adsVar3 = ads.NULL;
        this.l = adsVar3;
        return adsVar3;
    }

    private ads c(boolean z) throws IOException {
        if (z) {
            switch (d(true)) {
                case 125:
                    this.k--;
                    ads adsVar = ads.END_OBJECT;
                    this.l = adsVar;
                    return adsVar;
                default:
                    this.f--;
                    break;
            }
        } else {
            switch (d(true)) {
                case 44:
                case 59:
                    break;
                case 125:
                    this.k--;
                    ads adsVar2 = ads.END_OBJECT;
                    this.l = adsVar2;
                    return adsVar2;
                default:
                    throw b("Unterminated object");
            }
        }
        int iD = d(true);
        switch (iD) {
            case 39:
                v();
            case 34:
                this.m = a((char) iD);
                this.j[this.k - 1] = adr.DANGLING_NAME;
                ads adsVar3 = ads.NAME;
                this.l = adsVar3;
                return adsVar3;
            default:
                v();
                this.f--;
                this.m = e(false);
                if (this.m.length() == 0) {
                    throw b("Expected name");
                }
                this.j[this.k - 1] = adr.DANGLING_NAME;
                ads adsVar32 = ads.NAME;
                this.l = adsVar32;
                return adsVar32;
        }
    }

    private ads r() throws IOException {
        switch (d(true)) {
            case 58:
                break;
            case 59:
            case 60:
            default:
                throw b("Expected ':'");
            case 61:
                v();
                if ((this.f < this.g || a(1)) && this.e[this.f] == '>') {
                    this.f++;
                }
                break;
        }
        this.j[this.k - 1] = adr.NONEMPTY_OBJECT;
        return s();
    }

    private ads s() throws IOException {
        int iD = d(true);
        switch (iD) {
            case 34:
                break;
            case 39:
                v();
                break;
            case 91:
                a(adr.EMPTY_ARRAY);
                ads adsVar = ads.BEGIN_ARRAY;
                this.l = adsVar;
                return adsVar;
            case 123:
                a(adr.EMPTY_OBJECT);
                ads adsVar2 = ads.BEGIN_OBJECT;
                this.l = adsVar2;
                return adsVar2;
            default:
                this.f--;
                return y();
        }
        this.n = a((char) iD);
        ads adsVar3 = ads.STRING;
        this.l = adsVar3;
        return adsVar3;
    }

    private boolean a(int i) throws IOException {
        char[] cArr = this.e;
        int i2 = this.h;
        int i3 = this.i;
        int i4 = this.f;
        for (int i5 = 0; i5 < i4; i5++) {
            if (cArr[i5] == '\n') {
                i2++;
                i3 = 1;
            } else {
                i3++;
            }
        }
        this.h = i2;
        this.i = i3;
        if (this.g != this.f) {
            this.g -= this.f;
            System.arraycopy(cArr, this.f, cArr, 0, this.g);
        } else {
            this.g = 0;
        }
        this.f = 0;
        do {
            int i6 = this.c.read(cArr, this.g, cArr.length - this.g);
            if (i6 == -1) {
                return false;
            }
            this.g = i6 + this.g;
            if (this.h == 1 && this.i == 1 && this.g > 0 && cArr[0] == 65279) {
                this.f++;
                this.i--;
            }
        } while (this.g < i);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int t() {
        int i = this.h;
        for (int i2 = 0; i2 < this.f; i2++) {
            if (this.e[i2] == '\n') {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u() {
        int i = this.i;
        for (int i2 = 0; i2 < this.f; i2++) {
            if (this.e[i2] == '\n') {
                i = 1;
            } else {
                i++;
            }
        }
        return i;
    }

    private int d(boolean z) throws IOException {
        char[] cArr = this.e;
        int i = this.f;
        int i2 = this.g;
        while (true) {
            if (i == i2) {
                this.f = i;
                if (a(1)) {
                    i = this.f;
                    i2 = this.g;
                } else {
                    if (z) {
                        throw new EOFException("End of input at line " + t() + " column " + u());
                    }
                    return -1;
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            switch (c) {
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    i = i3;
                    break;
                case '#':
                    this.f = i3;
                    v();
                    w();
                    i = this.f;
                    i2 = this.g;
                    break;
                case '/':
                    this.f = i3;
                    if (i3 == i2 && !a(1)) {
                        return c;
                    }
                    v();
                    switch (cArr[this.f]) {
                        case '*':
                            this.f++;
                            if (!a("*/")) {
                                throw b("Unterminated comment");
                            }
                            i = this.f + 2;
                            i2 = this.g;
                            break;
                            break;
                        case '/':
                            this.f++;
                            w();
                            i = this.f;
                            i2 = this.g;
                            break;
                        default:
                            return c;
                    }
                    break;
                default:
                    this.f = i3;
                    return c;
            }
        }
    }

    private void v() throws IOException {
        if (!this.d) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void w() {
        char c;
        do {
            if (this.f < this.g || a(1)) {
                char[] cArr = this.e;
                int i = this.f;
                this.f = i + 1;
                c = cArr[i];
                if (c == '\r') {
                    return;
                }
            } else {
                return;
            }
        } while (c != '\n');
    }

    private boolean a(String str) {
        while (true) {
            if (this.f + str.length() > this.g && !a(str.length())) {
                return false;
            }
            for (int i = 0; i < str.length(); i++) {
                if (this.e[this.f + i] != str.charAt(i)) {
                    break;
                }
            }
            return true;
            this.f++;
        }
    }

    private String a(char c) throws IOException {
        int i;
        int i2;
        StringBuilder sb;
        int i3;
        char[] cArr = this.e;
        StringBuilder sb2 = null;
        do {
            int i4 = this.f;
            int i5 = this.g;
            int i6 = i4;
            while (i6 < i5) {
                int i7 = i6 + 1;
                char c2 = cArr[i6];
                if (c2 == c) {
                    this.f = i7;
                    if (this.q) {
                        return "skipped!";
                    }
                    if (sb2 == null) {
                        return this.b.a(cArr, i4, (i7 - i4) - 1);
                    }
                    sb2.append(cArr, i4, (i7 - i4) - 1);
                    return sb2.toString();
                }
                if (c2 == '\\') {
                    this.f = i7;
                    if (sb2 == null) {
                        sb2 = new StringBuilder();
                    }
                    sb2.append(cArr, i4, (i7 - i4) - 1);
                    sb2.append(x());
                    int i8 = this.f;
                    sb = sb2;
                    i3 = i8;
                    i = this.g;
                    i2 = i8;
                } else {
                    int i9 = i4;
                    i = i5;
                    i2 = i7;
                    sb = sb2;
                    i3 = i9;
                }
                i6 = i2;
                i5 = i;
                i4 = i3;
                sb2 = sb;
            }
            if (sb2 == null) {
                sb2 = new StringBuilder();
            }
            sb2.append(cArr, i4, i6 - i4);
            this.f = i6;
        } while (a(1));
        throw b("Unterminated string");
    }

    private String e(boolean z) throws IOException {
        String string = null;
        this.o = -1;
        this.p = 0;
        int i = 0;
        StringBuilder sb = null;
        while (true) {
            if (this.f + i < this.g) {
                switch (this.e[this.f + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        v();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i < this.e.length) {
                if (!a(i + 1)) {
                    this.e[this.g] = 0;
                }
            } else {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.e, this.f, i);
                this.p += i;
                this.f = i + this.f;
                if (a(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            }
        }
        if (z && sb == null) {
            this.o = this.f;
        } else if (this.q) {
            string = "skipped!";
        } else if (sb == null) {
            string = this.b.a(this.e, this.f, i);
        } else {
            sb.append(this.e, this.f, i);
            string = sb.toString();
        }
        this.p += i;
        this.f += i;
        return string;
    }

    public String toString() {
        return getClass().getSimpleName() + " near " + ((Object) A());
    }

    private char x() throws IOException {
        int i;
        if (this.f == this.g && !a(1)) {
            throw b("Unterminated escape sequence");
        }
        char[] cArr = this.e;
        int i2 = this.f;
        this.f = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case 'b':
                return '\b';
            case 'f':
                return '\f';
            case 'n':
                return '\n';
            case 'r':
                return '\r';
            case 't':
                return '\t';
            case 'u':
                if (this.f + 4 > this.g && !a(4)) {
                    throw b("Unterminated escape sequence");
                }
                int i3 = this.f;
                int i4 = i3 + 4;
                char c2 = 0;
                for (int i5 = i3; i5 < i4; i5++) {
                    char c3 = this.e[i5];
                    char c4 = (char) (c2 << 4);
                    if (c3 >= '0' && c3 <= '9') {
                        i = c3 - '0';
                    } else if (c3 >= 'a' && c3 <= 'f') {
                        i = (c3 - 'a') + 10;
                    } else if (c3 >= 'A' && c3 <= 'F') {
                        i = (c3 - 'A') + 10;
                    } else {
                        throw new NumberFormatException("\\u" + this.b.a(this.e, this.f, 4));
                    }
                    c2 = (char) (c4 + i);
                }
                this.f += 4;
                return c2;
            default:
                return c;
        }
    }

    private ads y() throws IOException {
        this.n = e(true);
        if (this.p == 0) {
            throw b("Expected literal value");
        }
        this.l = z();
        if (this.l == ads.STRING) {
            v();
        }
        return this.l;
    }

    private ads z() {
        if (this.o == -1) {
            return ads.STRING;
        }
        if (this.p == 4 && (('n' == this.e[this.o] || 'N' == this.e[this.o]) && (('u' == this.e[this.o + 1] || 'U' == this.e[this.o + 1]) && (('l' == this.e[this.o + 2] || 'L' == this.e[this.o + 2]) && ('l' == this.e[this.o + 3] || 'L' == this.e[this.o + 3]))))) {
            this.n = "null";
            return ads.NULL;
        }
        if (this.p == 4 && (('t' == this.e[this.o] || 'T' == this.e[this.o]) && (('r' == this.e[this.o + 1] || 'R' == this.e[this.o + 1]) && (('u' == this.e[this.o + 2] || 'U' == this.e[this.o + 2]) && ('e' == this.e[this.o + 3] || 'E' == this.e[this.o + 3]))))) {
            this.n = "true";
            return ads.BOOLEAN;
        }
        if (this.p == 5 && (('f' == this.e[this.o] || 'F' == this.e[this.o]) && (('a' == this.e[this.o + 1] || 'A' == this.e[this.o + 1]) && (('l' == this.e[this.o + 2] || 'L' == this.e[this.o + 2]) && (('s' == this.e[this.o + 3] || 'S' == this.e[this.o + 3]) && ('e' == this.e[this.o + 4] || 'E' == this.e[this.o + 4])))))) {
            this.n = "false";
            return ads.BOOLEAN;
        }
        this.n = this.b.a(this.e, this.o, this.p);
        return a(this.e, this.o, this.p);
    }

    private ads a(char[] cArr, int i, int i2) {
        int i3;
        int i4;
        char c;
        char c2 = cArr[i];
        if (c2 == '-') {
            i3 = i + 1;
            c2 = cArr[i3];
        } else {
            i3 = i;
        }
        if (c2 == '0') {
            i4 = i3 + 1;
            c = cArr[i4];
        } else if (c2 >= '1' && c2 <= '9') {
            i4 = i3 + 1;
            c = cArr[i4];
            while (c >= '0' && c <= '9') {
                i4++;
                c = cArr[i4];
            }
        } else {
            return ads.STRING;
        }
        if (c == '.') {
            i4++;
            c = cArr[i4];
            while (c >= '0' && c <= '9') {
                i4++;
                c = cArr[i4];
            }
        }
        char c3 = c;
        int i5 = i4;
        if (c3 == 'e' || c3 == 'E') {
            int i6 = i5 + 1;
            char c4 = cArr[i6];
            if (c4 == '+' || c4 == '-') {
                i6++;
                c4 = cArr[i6];
            }
            if (c4 >= '0' && c4 <= '9') {
                int i7 = i6 + 1;
                i5 = i7;
                char c5 = cArr[i7];
                while (c5 >= '0' && c5 <= '9') {
                    int i8 = i5 + 1;
                    i5 = i8;
                    c5 = cArr[i8];
                }
            } else {
                return ads.STRING;
            }
        }
        if (i5 == i + i2) {
            return ads.NUMBER;
        }
        return ads.STRING;
    }

    private IOException b(String str) throws adu {
        throw new adu(str + " at line " + t() + " column " + u());
    }

    private CharSequence A() {
        StringBuilder sb = new StringBuilder();
        int iMin = Math.min(this.f, 20);
        sb.append(this.e, this.f - iMin, iMin);
        sb.append(this.e, this.f, Math.min(this.g - this.f, 20));
        return sb;
    }
}
