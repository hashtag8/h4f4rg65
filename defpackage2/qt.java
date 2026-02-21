package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class qt {
    private static String b = null;
    static final HostnameVerifier a = new HostnameVerifier() { // from class: qt.1
        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    };

    public static String a(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        Iterator<String> it = bundle.keySet().iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return sb.toString();
            }
            String next = it.next();
            if (next != null && bundle.getString(next) != null) {
                if (z2) {
                    z2 = false;
                } else {
                    sb.append("&");
                }
                sb.append(URLEncoder.encode(next) + "=" + URLEncoder.encode(bundle.getString(next)));
            }
            z = z2;
        }
    }

    private static String a(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1000);
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            sb.append(line);
        }
        inputStream.close();
        return sb.toString();
    }

    public static String a(String str, String str2, Bundle bundle) {
        try {
            return a(str, str2, bundle, false);
        } catch (SSLException e) {
            TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: qt.2
                @Override // javax.net.ssl.X509TrustManager
                public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str3) {
                }

                @Override // javax.net.ssl.X509TrustManager
                public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str3) {
                }

                @Override // javax.net.ssl.X509TrustManager
                public final X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }};
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, trustManagerArr, new SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return a(str, str2, bundle, true);
        }
    }

    private static String a(String str, String str2, Bundle bundle, boolean z) throws ProtocolException {
        HttpURLConnection httpURLConnection;
        if (str2.equals("GET") || str2.equals("DELETE")) {
            str = str + "?" + a(bundle);
        }
        String str3 = str2 + " URL: " + str;
        if (z) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            httpsURLConnection.setHostnameVerifier(a);
            httpURLConnection = httpsURLConnection;
        } else {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        }
        if (str2.equals("POST")) {
            if (!bundle.containsKey("method")) {
                bundle.putString("method", str2);
            }
            if (bundle.containsKey("access_token")) {
                bundle.putString("access_token", URLDecoder.decode(bundle.getString("access_token")));
            }
            httpURLConnection.setRequestMethod(str2);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.connect();
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(httpURLConnection.getOutputStream()));
            try {
                printWriter.println(a(bundle));
                printWriter.flush();
            } catch (Exception e) {
            } finally {
                printWriter.close();
            }
        }
        try {
            return a(httpURLConnection.getInputStream());
        } catch (FileNotFoundException e2) {
            return a(httpURLConnection.getErrorStream());
        }
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                hexString = "0" + hexString;
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }

    public static void a(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
    }

    public static void a(String str) throws qk {
        try {
            if (str.trim().equals("false")) {
                throw new qk("request failed");
            }
            if (!str.trim().equals("true") && str.startsWith("{\"error\":")) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("error")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("error");
                    String string = jSONObject2.getString("type");
                    if (!"OAuthException".equals(string)) {
                        throw new qk(jSONObject2.getString("message"), string, 0);
                    }
                    throw new qm(jSONObject2.getString("message"));
                }
                if (jSONObject.has("error_code") && jSONObject.has("error_msg")) {
                    throw new qk(jSONObject.getString("error_msg"), "", Integer.parseInt(jSONObject.getString("error_code")));
                }
                if (jSONObject.has("error_code")) {
                    throw new qk("request failed", "", Integer.parseInt(jSONObject.getString("error_code")));
                }
                if (jSONObject.has("error_msg")) {
                    throw new qk(jSONObject.getString("error_msg"));
                }
                if (jSONObject.has("error_reason")) {
                    throw new qk(jSONObject.getString("error_reason"));
                }
            }
        } catch (NumberFormatException e) {
            throw new qk("Impossible to parse response :" + str, e);
        } catch (JSONException e2) {
            throw new qk("Impossible to parse response :" + str, e2);
        }
    }

    public static String b(Context context) {
        if (b == null) {
            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            b = deviceId;
            if (deviceId == null) {
                b = Settings.Secure.getString(context.getContentResolver(), "android_id");
            }
            if (b == null) {
                b = "0123456789123456";
            }
        }
        return b;
    }

    public static String b(String str) {
        return a(MessageDigest.getInstance("MD5").digest(str.getBytes("utf-8")));
    }
}
