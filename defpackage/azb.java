package defpackage;

import android.os.AsyncTask;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: classes.dex */
public class azb extends AsyncTask<String, Void, String> {
    private Map<String, String> a;
    private a b;

    public interface a {
        void a(boolean z, String str);
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        if (!this.a.get("method").equals("getPlaybackInfo") && !this.a.get("method").equals("generateStation") && !this.a.get("method").startsWith("add")) {
            azc.a(this);
        }
        if (this.a.get("method").equals("generateStation") && azc.e) {
            azc.a(this);
            azc.e = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        a();
        if (str != null) {
            this.b.a(true, str);
        } else {
            a();
            this.b.a(false, str);
        }
    }

    protected void a() {
        azc.a();
    }

    public void a(Map<String, String> map) {
        this.a = new HashMap(map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) {
        String strA;
        try {
            HttpResponse httpResponseB = azs.ap.b(baj.a(strArr[0], new Object[0]).a(this.a));
            if (httpResponseB.getStatusLine().getStatusCode() == 200) {
                strA = bag.a(httpResponseB);
                mm.b("\n" + strA, new Object[0]);
            } else {
                System.err.println("Invalid status received: " + httpResponseB.getStatusLine());
                strA = null;
            }
            return strA;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
