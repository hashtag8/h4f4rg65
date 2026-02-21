package defpackage;

import defpackage.bsl;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public class brt {
    public static final bsh a = new bsk(new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}).a(new bsk(bsj.i())).a(bsn.a(32, 127));
    public static final bsh b = new bsg(new bsk(new String[]{"'", "\\'"}, new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}, new String[]{"/", "\\/"}), new bsk(bsj.i()), bsn.a(32, 127));
    public static final bsh c = new bsg(new bsk(bsj.e()), new bsk(bsj.g()));
    public static final bsh d = new bsg(new bsk(bsj.e()), new bsk(bsj.a()));
    public static final bsh e = new bsg(new bsk(bsj.e()), new bsk(bsj.a()), new bsk(bsj.c()));
    public static final bsh f = new a();
    public static final bsh g = new bsg(new bsm(), new bso(), new bsk(bsj.j()), new bsk(new String[]{"\\\\", "\\"}, new String[]{"\\\"", "\""}, new String[]{"\\'", "'"}, new String[]{"\\", ""}));
    public static final bsh h = g;
    public static final bsh i = new bsg(new bsk(bsj.f()), new bsk(bsj.b()), new bsl(new bsl.a[0]));
    public static final bsh j = new bsg(new bsk(bsj.f()), new bsk(bsj.b()), new bsk(bsj.d()), new bsl(new bsl.a[0]));
    public static final bsh k = new bsg(new bsk(bsj.f()), new bsk(bsj.h()), new bsl(new bsl.a[0]));
    public static final bsh l = new b();

    static class a extends bsh {
        private static final String a = String.valueOf('\"');
        private static final char[] b = {',', '\"', '\r', '\n'};

        a() {
        }

        @Override // defpackage.bsh
        public int a(CharSequence charSequence, int i, Writer writer) throws IOException {
            if (i != 0) {
                throw new IllegalStateException("CsvEscaper should never reach the [1] index");
            }
            if (bru.b(charSequence.toString(), b)) {
                writer.write(charSequence.toString());
            } else {
                writer.write(34);
                writer.write(bru.a(charSequence.toString(), a, a + a));
                writer.write(34);
            }
            return charSequence.length();
        }
    }

    static class b extends bsh {
        private static final String a = String.valueOf('\"');
        private static final char[] b = {',', '\"', '\r', '\n'};

        b() {
        }

        @Override // defpackage.bsh
        public int a(CharSequence charSequence, int i, Writer writer) throws IOException {
            if (i != 0) {
                throw new IllegalStateException("CsvUnescaper should never reach the [1] index");
            }
            if (charSequence.charAt(0) != '\"' || charSequence.charAt(charSequence.length() - 1) != '\"') {
                writer.write(charSequence.toString());
                return charSequence.length();
            }
            String string = charSequence.subSequence(1, charSequence.length() - 1).toString();
            if (bru.a(string, b)) {
                writer.write(bru.a(string, a + a, a));
            } else {
                writer.write(charSequence.toString());
            }
            return charSequence.length();
        }
    }

    public static final String a(String str) {
        return j.a(str);
    }
}
