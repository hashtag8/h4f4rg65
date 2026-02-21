package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class atw {
    private int a;
    private String b;
    private String c;

    public atw(String str, String str2) {
        this.c = str2;
        a(str);
    }

    public void a(int i) {
        this.a = i;
    }

    private void a(String str) {
        if (str != null && str.length() != 0) {
            for (String str2 : str.split("\r\n")) {
                if ("location:".equals(str2.substring(0, str2.indexOf(":") + 1).toLowerCase().trim())) {
                    a(str2, str);
                }
            }
        }
    }

    private void a(String str, String str2) {
        if (str.length() > 0) {
            b(str.substring(str.indexOf(":") + 1).trim());
        }
    }

    private void b(String str) {
        if (str.length() > 0) {
            String strSubstring = str.substring(str.indexOf(":") + 1 + 2);
            this.b = strSubstring.substring(0, strSubstring.indexOf(":"));
        }
    }
}
