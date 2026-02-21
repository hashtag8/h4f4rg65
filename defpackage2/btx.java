package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class btx extends btk {
    protected boolean a;
    public btz b;
    public int[][] c;
    public String[] d;
    protected String e;

    public btx(btz btzVar, int[][] iArr, String[] strArr) {
        super("");
        this.e = System.getProperty("line.separator", "\n");
        this.a = true;
        this.b = btzVar;
        this.c = iArr;
        this.d = strArr;
    }

    public btx() {
        super("Cannot parse field");
        this.e = System.getProperty("line.separator", "\n");
        this.a = false;
    }

    public btx(String str) {
        super(str);
        this.e = System.getProperty("line.separator", "\n");
        this.a = false;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str;
        if (!this.a) {
            return super.getMessage();
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = 0;
        for (int i = 0; i < this.c.length; i++) {
            if (length < this.c[i].length) {
                length = this.c[i].length;
            }
            for (int i2 = 0; i2 < this.c[i].length; i2++) {
                stringBuffer.append(this.d[this.c[i][i2]]).append(" ");
            }
            if (this.c[i][this.c[i].length - 1] != 0) {
                stringBuffer.append("...");
            }
            stringBuffer.append(this.e).append("    ");
        }
        btz btzVar = this.b.g;
        String str2 = "Encountered \"";
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (i3 != 0) {
                str2 = str2 + " ";
            }
            if (btzVar.a == 0) {
                str2 = str2 + this.d[0];
                break;
            }
            String str3 = str2 + a(btzVar.f);
            btzVar = btzVar.g;
            i3++;
            str2 = str3;
        }
        String str4 = (str2 + "\" at line " + this.b.g.b + ", column " + this.b.g.c) + "." + this.e;
        if (this.c.length == 1) {
            str = str4 + "Was expecting:" + this.e + "    ";
        } else {
            str = str4 + "Was expecting one of:" + this.e + "    ";
        }
        return str + stringBuffer.toString();
    }

    protected String a(String str) {
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
}
