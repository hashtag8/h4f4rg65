package defpackage;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import org.apache.http.Header;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public abstract class aux extends aug {
    public abstract void a(int i, Header[] headerArr, String str);

    public abstract void a(int i, Header[] headerArr, String str, Throwable th);

    public aux() {
        this(HTTP.UTF_8);
    }

    public aux(String str) {
        a(str);
    }

    @Override // defpackage.aug
    public void a(int i, Header[] headerArr, byte[] bArr) {
        a(i, headerArr, a(bArr, e()));
    }

    @Override // defpackage.aug
    public void a(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        a(i, headerArr, a(bArr, e()), th);
    }

    public static String a(byte[] bArr, String str) {
        String str2;
        String strSubstring = null;
        if (bArr == null) {
            str2 = null;
        } else {
            try {
                str2 = new String(bArr, str);
            } catch (UnsupportedEncodingException e) {
                Log.e("TextHttpResponseHandler", "Encoding response into string failed", e);
                return strSubstring;
            }
        }
        if (str2 == null || !str2.startsWith("\ufeff")) {
            return str2;
        }
        strSubstring = str2.substring(1);
        return strSubstring;
    }
}
