package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public final class acz {
    public static aca a(adq adqVar) {
        boolean z = true;
        try {
            adqVar.f();
            z = false;
            return ado.N.b(adqVar);
        } catch (adu e) {
            throw new aci(e);
        } catch (EOFException e2) {
            if (z) {
                return acc.a;
            }
            throw new acb(e2);
        } catch (IOException e3) {
            throw new acb(e3);
        } catch (NumberFormatException e4) {
            throw new aci(e4);
        }
    }

    public static void a(aca acaVar, adt adtVar) {
        ado.N.a(adtVar, acaVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    static class a extends Writer {
        private final Appendable a;
        private final C0001a b;

        private a(Appendable appendable) {
            this.b = new C0001a();
            this.a = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            this.b.a = cArr;
            this.a.append(this.b, i, i + i2);
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.a.append((char) i);
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        /* JADX INFO: renamed from: acz$a$a, reason: collision with other inner class name */
        static class C0001a implements CharSequence {
            char[] a;

            C0001a() {
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.a.length;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.a[i];
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.a, i, i2 - i);
            }
        }
    }
}
