package defpackage;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bag {
    public static String a(HttpResponse httpResponse) throws IOException {
        int i;
        Header firstHeader = null;
        InputStream content = httpResponse.getEntity().getContent();
        if (content == null) {
            return null;
        }
        try {
            firstHeader = httpResponse.getFirstHeader(HTTP.CONTENT_LEN);
        } catch (UnsupportedOperationException e) {
        }
        if (firstHeader != null) {
            try {
                i = Integer.parseInt(firstHeader.getValue());
            } catch (NumberFormatException e2) {
                i = 8192;
            }
        } else {
            i = 8192;
        }
        StringBuilder sb = new StringBuilder(i);
        byte[] bArr = new byte[8192];
        while (true) {
            int i2 = content.read(bArr);
            if (i2 == -1) {
                return sb.toString();
            }
            sb.append(new String(bArr, 0, i2));
        }
    }

    public static JSONObject b(HttpResponse httpResponse) throws IOException {
        String strA = a(httpResponse);
        if (strA == null || strA.length() == 0) {
            throw new IOException("JSON response is empty");
        }
        try {
            return new JSONObject(strA);
        } catch (JSONException e) {
            StringBuilder sbAppend = new StringBuilder().append("could not parse JSON document: ").append(e.getMessage()).append(" ");
            if (strA.length() > 80) {
                strA = strA.substring(0, 79) + "...";
            }
            throw new IOException(sbAppend.append(strA).toString());
        }
    }
}
