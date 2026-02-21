package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class bua extends Error {
    int a;

    protected static final String a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 0:
                    break;
                case '\b':
                    stringBuffer.append("\\b");
                    break;
                case '\t':
                    stringBuffer.append("\\t");
                    break;
                case '\n':
                    stringBuffer.append("\\n");
                    break;
                case '\f':
                    stringBuffer.append("\\f");
                    break;
                case '\r':
                    stringBuffer.append("\\r");
                    break;
                case '\"':
                    stringBuffer.append("\\\"");
                    break;
                case '\'':
                    stringBuffer.append("\\'");
                    break;
                case '\\':
                    stringBuffer.append("\\\\");
                    break;
                default:
                    char cCharAt = str.charAt(i);
                    if (cCharAt < ' ' || cCharAt > '~') {
                        String str2 = "0000" + Integer.toString(cCharAt, 16);
                        stringBuffer.append("\\u" + str2.substring(str2.length() - 4, str2.length()));
                    } else {
                        stringBuffer.append(cCharAt);
                    }
                    break;
            }
        }
        return stringBuffer.toString();
    }

    protected static String a(boolean z, int i, int i2, int i3, String str, char c) {
        return "Lexical error at line " + i2 + ", column " + i3 + ".  Encountered: " + (z ? "<EOF> " : "\"" + a(String.valueOf(c)) + "\" (" + ((int) c) + "), ") + "after : \"" + a(str) + "\"";
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage();
    }

    public bua() {
    }

    public bua(String str, int i) {
        super(str);
        this.a = i;
    }

    public bua(boolean z, int i, int i2, int i3, String str, char c, int i4) {
        this(a(z, i, i2, i3, str, c), i4);
    }
}
