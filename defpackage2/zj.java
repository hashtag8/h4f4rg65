package defpackage;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
@yx
public final class zj extends zc {
    private final String a;
    private final Context b;
    private final String c;
    private String d;

    public zj(Context context, String str, String str2) {
        this.d = null;
        this.b = context;
        this.a = str;
        this.c = str2;
    }

    public zj(Context context, String str, String str2, String str3) {
        this.d = null;
        this.b = context;
        this.a = str;
        this.c = str2;
        this.d = str3;
    }

    @Override // defpackage.zc
    public void a() {
        try {
            su.d("Pinging URL: " + this.c);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.c).openConnection();
            try {
                if (TextUtils.isEmpty(this.d)) {
                    sy.c().a(this.b, this.a, true, httpURLConnection);
                } else {
                    sy.c().a(this.b, this.a, true, httpURLConnection, this.d);
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 200 || responseCode >= 300) {
                    su.e("Received non-success response code " + responseCode + " from pinging URL: " + this.c);
                }
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (IOException e) {
            su.e("Error while pinging URL: " + this.c + ". " + e.getMessage());
        } catch (IndexOutOfBoundsException e2) {
            su.e("Error while parsing ping URL: " + this.c + ". " + e2.getMessage());
        } catch (RuntimeException e3) {
            su.e("Error while pinging URL: " + this.c + ". " + e3.getMessage());
        }
    }
}
