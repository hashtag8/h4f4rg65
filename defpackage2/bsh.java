package defpackage;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class bsh {
    public abstract int a(CharSequence charSequence, int i, Writer writer);

    public final String a(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(charSequence.length() * 2);
            a(charSequence, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public final void a(CharSequence charSequence, Writer writer) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        }
        if (charSequence != null) {
            int length = charSequence.length();
            int length2 = 0;
            while (length2 < length) {
                int iA = a(charSequence, length2, writer);
                if (iA == 0) {
                    char[] chars = Character.toChars(Character.codePointAt(charSequence, length2));
                    writer.write(chars);
                    length2 += chars.length;
                } else {
                    int iCharCount = length2;
                    for (int i = 0; i < iA; i++) {
                        iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                    }
                    length2 = iCharCount;
                }
            }
        }
    }

    public final bsh a(bsh... bshVarArr) {
        bsh[] bshVarArr2 = new bsh[bshVarArr.length + 1];
        bshVarArr2[0] = this;
        System.arraycopy(bshVarArr, 0, bshVarArr2, 1, bshVarArr.length);
        return new bsg(bshVarArr2);
    }

    public static String a(int i) {
        return Integer.toHexString(i).toUpperCase(Locale.ENGLISH);
    }
}
