package defpackage;

import android.util.Log;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;

/* JADX INFO: loaded from: classes.dex */
public abstract class auk extends aug {
    private String[] a;

    public String[] i() {
        return this.a;
    }

    public auk(String[] strArr) {
        this.a = new String[]{"application/octet-stream", "image/jpeg", "image/png", "image/gif"};
        if (strArr != null) {
            this.a = strArr;
        } else {
            Log.e("BinaryHttpResponseHandler", "Constructor passed allowedContentTypes was null !");
        }
    }

    @Override // defpackage.aug, defpackage.aut
    public final void a(HttpResponse httpResponse) throws IOException {
        boolean z = false;
        StatusLine statusLine = httpResponse.getStatusLine();
        Header[] headers = httpResponse.getHeaders("Content-Type");
        if (headers.length != 1) {
            b(statusLine.getStatusCode(), httpResponse.getAllHeaders(), null, new HttpResponseException(statusLine.getStatusCode(), "None, or more than one, Content-Type Header found!"));
            return;
        }
        Header header = headers[0];
        for (String str : i()) {
            try {
                if (Pattern.matches(str, header.getValue())) {
                    z = true;
                }
            } catch (PatternSyntaxException e) {
                Log.e("BinaryHttpResponseHandler", "Given pattern is not valid: " + str, e);
            }
        }
        if (!z) {
            b(statusLine.getStatusCode(), httpResponse.getAllHeaders(), null, new HttpResponseException(statusLine.getStatusCode(), "Content-Type not allowed!"));
        } else {
            super.a(httpResponse);
        }
    }
}
