package defpackage;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.util.StringTokenizer;
import java.util.Vector;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class bko {
    private String a;
    private String b = "";
    private Vector c = new Vector();
    private byte[] d = new byte[0];
    private InputStream e = null;

    public bko() {
        a("1.1");
        a((InputStream) null);
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.a;
    }

    private String a(BufferedInputStream bufferedInputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1];
        try {
            int i = bufferedInputStream.read(bArr);
            while (i > 0) {
                if (bArr[0] == 10) {
                    break;
                }
                if (bArr[0] != 13) {
                    byteArrayOutputStream.write(bArr[0]);
                }
                i = bufferedInputStream.read(bArr);
            }
        } catch (InterruptedIOException e) {
        } catch (IOException e2) {
        }
        return byteArrayOutputStream.toString();
    }

    protected boolean a(InputStream inputStream, boolean z, HttpURLConnection httpURLConnection) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                j("HTTP/1.1 200 OK");
            }
            if (responseCode == 100) {
                String strA = a(bufferedInputStream);
                while (strA != null && strA.length() > 0) {
                    bkn bknVar = new bkn(strA);
                    if (bknVar.c()) {
                        b(bknVar);
                    }
                    strA = a(bufferedInputStream);
                }
                String headerField = httpURLConnection.getHeaderField(0);
                if (headerField != null && headerField.length() > 0) {
                    j(headerField);
                } else {
                    return true;
                }
            }
            int i = 0;
            String headerField2 = httpURLConnection.getHeaderField(0);
            while (headerField2 != null && headerField2.length() > 0) {
                i++;
                bkn bknVar2 = new bkn(headerField2);
                if (bknVar2.c()) {
                    b(bknVar2);
                }
                headerField2 = httpURLConnection.getHeaderField(i);
            }
            bkn bknVar3 = new bkn("Content-Length: " + httpURLConnection.getContentLength());
            if (bknVar3.c()) {
                b(bknVar3);
            }
            if (z) {
                a("", false);
                return true;
            }
            boolean zO = o();
            long jL = 0;
            if (zO) {
                try {
                    jL = Long.parseLong(new String(a(bufferedInputStream).getBytes(), 0, r4.length() - 2), 16);
                } catch (Exception e) {
                }
            } else {
                jL = l();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                long j = jL;
                if (0 < j) {
                    int iA = bkm.a();
                    byte[] bArr = new byte[iA];
                    long j2 = 0;
                    while (true) {
                        long j3 = j2;
                        if (j3 >= j) {
                            break;
                        }
                        long j4 = j - j3;
                        if (iA < j4) {
                            j4 = iA;
                        }
                        try {
                            int i2 = bufferedInputStream.read(bArr, 0, (int) j4);
                            if (i2 < 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i2);
                            j2 = ((long) i2) + j3;
                        } catch (Exception e2) {
                        }
                    }
                    if (zO) {
                        long j5 = 0;
                        try {
                            do {
                                long jSkip = bufferedInputStream.skip(((long) "\r\n".length()) - j5);
                                if (jSkip >= 0) {
                                    j5 += jSkip;
                                }
                                break;
                            } while (j5 < "\r\n".length());
                            break;
                            jL = Long.parseLong(new String(a(bufferedInputStream).getBytes(), 0, r2.length() - 2), 16);
                        } catch (Exception e3) {
                            jL = 0;
                        }
                    } else {
                        jL = 0;
                    }
                } else {
                    a(byteArrayOutputStream.toByteArray(), false);
                    return true;
                }
            }
        } catch (Exception e4) {
            return false;
        }
    }

    protected void a(bko bkoVar) {
        j(bkoVar.c());
        f();
        int iE = bkoVar.e();
        for (int i = 0; i < iE; i++) {
            a(bkoVar.b(i));
        }
        a(bkoVar.h());
    }

    private void j(String str) {
        this.b = str;
    }

    protected String c() {
        return this.b;
    }

    protected String a(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(this.b, " ");
        String strNextToken = "";
        int i2 = 0;
        while (i2 <= i) {
            if (stringTokenizer.hasMoreTokens()) {
                i2++;
                strNextToken = stringTokenizer.nextToken();
            } else {
                return "";
            }
        }
        return strNextToken;
    }

    public boolean d() {
        return this.b.length() > 0;
    }

    public int e() {
        return this.c.size();
    }

    public void a(bkn bknVar) {
        this.c.add(bknVar);
    }

    public void b(String str, String str2) {
        this.c.add(new bkn(str, str2));
    }

    public bkn b(int i) {
        return (bkn) this.c.get(i);
    }

    public bkn b(String str) {
        int iE = e();
        for (int i = 0; i < iE; i++) {
            bkn bknVarB = b(i);
            if (bknVarB.a().equalsIgnoreCase(str)) {
                return bknVarB;
            }
        }
        return null;
    }

    public void f() {
        this.c.clear();
        this.c = new Vector();
    }

    public boolean c(String str) {
        return b(str) != null;
    }

    public void c(String str, String str2) {
        bkn bknVarB = b(str);
        if (bknVarB != null) {
            bknVarB.b(str2);
        } else {
            b(str, str2);
        }
    }

    public void b(bkn bknVar) {
        c(bknVar.a(), bknVar.b());
    }

    public String d(String str) {
        bkn bknVarB = b(str);
        return bknVarB == null ? "" : bknVarB.b();
    }

    public void a(String str, String str2, String str3, String str4) {
        if (!str2.startsWith(str3)) {
            str2 = str3 + str2;
        }
        if (!str2.endsWith(str4)) {
            str2 = str2 + str4;
        }
        c(str, str2);
    }

    public void d(String str, String str2) {
        a(str, str2, "\"", "\"");
    }

    public void a(String str, long j) {
        c(str, Long.toString(j));
    }

    public long e(String str) {
        bkn bknVarB = b(str);
        if (bknVarB == null) {
            return 0L;
        }
        return bla.a(bknVarB.b());
    }

    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        int iE = e();
        for (int i = 0; i < iE; i++) {
            bkn bknVarB = b(i);
            stringBuffer.append(bknVarB.a() + ": " + bknVarB.b() + "\r\n");
        }
        return stringBuffer.toString();
    }

    public void a(byte[] bArr, boolean z) {
        this.d = bArr;
        if (z) {
            a(bArr.length);
        }
    }

    public void a(byte[] bArr) {
        a(bArr, true);
    }

    public void a(String str, boolean z) {
        a(str.getBytes(), z);
    }

    public void f(String str) {
        a(str, true);
    }

    public byte[] h() {
        return this.d;
    }

    public String i() {
        String strK = k();
        if (strK == null || strK.length() <= 0) {
            return new String(this.d);
        }
        try {
            return new String(this.d, strK);
        } catch (Exception e) {
            return new String(this.d);
        }
    }

    public void a(InputStream inputStream) {
        this.e = inputStream;
    }

    public void g(String str) {
        c("Content-Type", str);
    }

    public void h(String str) {
        c(HTTP.USER_AGENT, str);
    }

    public String j() {
        return d("Content-Type");
    }

    public String k() {
        String lowerCase;
        int iIndexOf;
        String strJ = j();
        if (strJ == null || (iIndexOf = (lowerCase = strJ.toLowerCase()).indexOf("charset")) < 0) {
            return "";
        }
        int length = iIndexOf + "charset".length() + 1;
        String str = new String(lowerCase.getBytes(), length, lowerCase.length() - length);
        if (str.length() < 0) {
            return "";
        }
        if (str.charAt(0) == '\"') {
            str = str.substring(1, str.length() - 1);
        }
        if (str.length() < 0) {
            return "";
        }
        if (str.charAt(str.length() - 1) == '\"') {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }

    public void a(long j) {
        a(HTTP.CONTENT_LEN, j);
    }

    public long l() {
        return e(HTTP.CONTENT_LEN);
    }

    public void i(String str) {
        c(HTTP.CONN_DIRECTIVE, str);
    }

    public void a(String str, int i) {
        if (bkt.a(str)) {
            str = "[" + str + "]";
        }
        c("HOST", str + ":" + Integer.toString(i));
    }

    public boolean m() {
        return c(HTTP.TRANSFER_ENCODING);
    }

    public String n() {
        return d(HTTP.TRANSFER_ENCODING);
    }

    public boolean o() {
        String strN;
        return m() && (strN = n()) != null && strN.equalsIgnoreCase("Chunked");
    }
}
