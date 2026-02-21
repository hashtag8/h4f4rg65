package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class adt implements Closeable {
    private final Writer a;
    private final List<adr> b = new ArrayList();
    private String c;
    private String d;
    private boolean e;
    private boolean f;
    private String g;
    private boolean h;

    public adt(Writer writer) {
        this.b.add(adr.EMPTY_DOCUMENT);
        this.d = ":";
        this.h = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.a = writer;
    }

    public final void c(String str) {
        if (str.length() == 0) {
            this.c = null;
            this.d = ":";
        } else {
            this.c = str;
            this.d = ": ";
        }
    }

    public final void b(boolean z) {
        this.e = z;
    }

    public boolean g() {
        return this.e;
    }

    public final void c(boolean z) {
        this.f = z;
    }

    public final boolean h() {
        return this.f;
    }

    public final void d(boolean z) {
        this.h = z;
    }

    public final boolean i() {
        return this.h;
    }

    public adt b() throws IOException {
        j();
        return a(adr.EMPTY_ARRAY, "[");
    }

    public adt c() {
        return a(adr.EMPTY_ARRAY, adr.NONEMPTY_ARRAY, "]");
    }

    public adt d() throws IOException {
        j();
        return a(adr.EMPTY_OBJECT, "{");
    }

    public adt e() {
        return a(adr.EMPTY_OBJECT, adr.NONEMPTY_OBJECT, "}");
    }

    private adt a(adr adrVar, String str) throws IOException {
        e(true);
        this.b.add(adrVar);
        this.a.write(str);
        return this;
    }

    private adt a(adr adrVar, adr adrVar2, String str) throws IOException {
        adr adrVarA = a();
        if (adrVarA != adrVar2 && adrVarA != adrVar) {
            throw new IllegalStateException("Nesting problem: " + this.b);
        }
        if (this.g != null) {
            throw new IllegalStateException("Dangling name: " + this.g);
        }
        this.b.remove(this.b.size() - 1);
        if (adrVarA == adrVar2) {
            k();
        }
        this.a.write(str);
        return this;
    }

    private adr a() {
        return this.b.get(this.b.size() - 1);
    }

    private void a(adr adrVar) {
        this.b.set(this.b.size() - 1, adrVar);
    }

    public adt a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.g != null) {
            throw new IllegalStateException();
        }
        this.g = str;
        return this;
    }

    private void j() throws IOException {
        if (this.g != null) {
            l();
            d(this.g);
            this.g = null;
        }
    }

    public adt b(String str) throws IOException {
        if (str == null) {
            return f();
        }
        j();
        e(false);
        d(str);
        return this;
    }

    public adt f() throws IOException {
        if (this.g != null) {
            if (this.h) {
                j();
                e(false);
                this.a.write("null");
            } else {
                this.g = null;
            }
        } else {
            e(false);
            this.a.write("null");
        }
        return this;
    }

    public adt a(boolean z) throws IOException {
        j();
        e(false);
        this.a.write(z ? "true" : "false");
        return this;
    }

    public adt a(long j) throws IOException {
        j();
        e(false);
        this.a.write(Long.toString(j));
        return this;
    }

    public adt a(Number number) throws IOException {
        if (number == null) {
            return f();
        }
        j();
        String string = number.toString();
        if (!this.e && (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        e(false);
        this.a.append((CharSequence) string);
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
        if (a() != adr.NONEMPTY_DOCUMENT) {
            throw new IOException("Incomplete document");
        }
    }

    private void d(String str) throws IOException {
        this.a.write("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            switch (cCharAt) {
                case '\b':
                    this.a.write("\\b");
                    break;
                case '\t':
                    this.a.write("\\t");
                    break;
                case '\n':
                    this.a.write("\\n");
                    break;
                case '\f':
                    this.a.write("\\f");
                    break;
                case '\r':
                    this.a.write("\\r");
                    break;
                case '\"':
                case '\\':
                    this.a.write(92);
                    this.a.write(cCharAt);
                    break;
                case '&':
                case '\'':
                case '<':
                case '=':
                case '>':
                    if (this.f) {
                        this.a.write(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                    } else {
                        this.a.write(cCharAt);
                    }
                    break;
                case 8232:
                case 8233:
                    this.a.write(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                    break;
                default:
                    if (cCharAt <= 31) {
                        this.a.write(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                    } else {
                        this.a.write(cCharAt);
                    }
                    break;
            }
        }
        this.a.write("\"");
    }

    private void k() throws IOException {
        if (this.c != null) {
            this.a.write("\n");
            for (int i = 1; i < this.b.size(); i++) {
                this.a.write(this.c);
            }
        }
    }

    private void l() throws IOException {
        adr adrVarA = a();
        if (adrVarA == adr.NONEMPTY_OBJECT) {
            this.a.write(44);
        } else if (adrVarA != adr.EMPTY_OBJECT) {
            throw new IllegalStateException("Nesting problem: " + this.b);
        }
        k();
        a(adr.DANGLING_NAME);
    }

    private void e(boolean z) throws IOException {
        switch (a()) {
            case EMPTY_DOCUMENT:
                if (!this.e && !z) {
                    throw new IllegalStateException("JSON must start with an array or an object.");
                }
                a(adr.NONEMPTY_DOCUMENT);
                return;
            case EMPTY_ARRAY:
                a(adr.NONEMPTY_ARRAY);
                k();
                return;
            case NONEMPTY_ARRAY:
                this.a.append(',');
                k();
                return;
            case DANGLING_NAME:
                this.a.append((CharSequence) this.d);
                a(adr.NONEMPTY_OBJECT);
                return;
            case NONEMPTY_DOCUMENT:
                throw new IllegalStateException("JSON must have only one top-level value.");
            default:
                throw new IllegalStateException("Nesting problem: " + this.b);
        }
    }
}
