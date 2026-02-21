package defpackage;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.PopupWindow;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@yx
public class zf {
    public static final Handler a = new zd(Looper.getMainLooper());
    private String d;
    private final Object b = new Object();
    private boolean c = true;
    private boolean e = false;

    private JSONArray a(Collection<?> collection) {
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            a(jSONArray, it.next());
        }
        return jSONArray;
    }

    private JSONObject a(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    private void a(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            jSONArray.put(a((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONArray.put(a((Map<String, ?>) obj));
            return;
        }
        if (obj instanceof Collection) {
            jSONArray.put(a((Collection<?>) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(a((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private void a(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, a((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONObject.put(str, a((Map<String, ?>) obj));
            return;
        }
        if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, a((Collection<?>) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, a(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    public int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            su.e("Could not parse value:" + e);
            return 0;
        }
    }

    public Bitmap a(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return bitmapCreateBitmap;
    }

    public DisplayMetrics a(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public PopupWindow a(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, z);
    }

    String a() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (Build.VERSION.RELEASE != null) {
            stringBuffer.append(" ").append(Build.VERSION.RELEASE);
        }
        stringBuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    protected String a(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    public String a(final Context context, String str) {
        String str2;
        synchronized (this.b) {
            if (this.d != null) {
                str2 = this.d;
            } else {
                try {
                    this.d = sy.e().a(context);
                } catch (Exception e) {
                }
                if (TextUtils.isEmpty(this.d)) {
                    if (rj.a().a()) {
                        try {
                            this.d = a(context);
                        } catch (Exception e2) {
                            this.d = a();
                        }
                    } else {
                        this.d = null;
                        a.post(new Runnable() { // from class: zf.1
                            @Override // java.lang.Runnable
                            public void run() {
                                synchronized (zf.this.b) {
                                    zf.this.d = zf.this.a(context);
                                    zf.this.b.notifyAll();
                                }
                            }
                        });
                        while (this.d == null) {
                            try {
                                this.b.wait();
                            } catch (InterruptedException e3) {
                                this.d = a();
                                su.e("Interrupted, use default user agent: " + this.d);
                            }
                        }
                    }
                }
                this.d += " (Mobile; " + str + ")";
                str2 = this.d;
            }
        }
        return str2;
    }

    public String a(Context context, wi wiVar, String str) {
        if (wiVar == null) {
            return str;
        }
        try {
            Uri uriA = Uri.parse(str);
            if (wiVar.c(uriA)) {
                uriA = wiVar.a(uriA, context);
            }
            return uriA.toString();
        } catch (Exception e) {
            return str;
        }
    }

    public String a(zp zpVar, String str) {
        return a(zpVar.getContext(), zpVar.j(), str);
    }

    public Map<String, String> a(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (String str : sy.e().a(uri)) {
            map.put(str, uri.getQueryParameter(str));
        }
        return map;
    }

    JSONArray a(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        for (Object obj : objArr) {
            a(jSONArray, obj);
        }
        return jSONArray;
    }

    public JSONObject a(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                a(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: " + e.getMessage());
        }
    }

    public void a(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
            return;
        }
        window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public void a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(a(context, str));
    }

    public void a(Context context, String str, List<String> list, String str2) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            new zj(context, str, it.next(), str2).b();
        }
    }

    public void a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        a(context, str, z, httpURLConnection, false);
    }

    public void a(Context context, String str, boolean z, HttpURLConnection httpURLConnection, String str2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty(HTTP.USER_AGENT, str2);
        httpURLConnection.setUseCaches(false);
    }

    public void a(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty(HTTP.USER_AGENT, a(context, str));
        httpURLConnection.setUseCaches(z2);
    }

    public boolean a(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    public int[] a(Activity activity) {
        View viewFindViewById;
        Window window = activity.getWindow();
        return (window == null || (viewFindViewById = window.findViewById(R.id.content)) == null) ? d() : new int[]{viewFindViewById.getWidth(), viewFindViewById.getHeight()};
    }

    public AlertDialog.Builder b(Context context) {
        return new AlertDialog.Builder(context);
    }

    public String b() {
        UUID uuidRandomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(uuidRandomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(uuidRandomUUID.getMostSignificantBits()).toByteArray();
        String string = new BigInteger(1, byteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(byteArray);
                messageDigest.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(messageDigest.digest(), 0, bArr, 0, 8);
                string = new BigInteger(1, bArr).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return string;
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public int[] b(Activity activity) {
        int[] iArrA = a(activity);
        return new int[]{rj.a().b(activity, iArrA[0]), rj.a().b(activity, iArrA[1])};
    }

    public String c() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : str + " " + str2;
    }

    public wv c(Context context) {
        return new wv(context);
    }

    public int[] c(Activity activity) {
        View viewFindViewById;
        Window window = activity.getWindow();
        return (window == null || (viewFindViewById = window.findViewById(R.id.content)) == null) ? d() : new int[]{viewFindViewById.getTop(), viewFindViewById.getBottom()};
    }

    protected int[] d() {
        return new int[]{0, 0};
    }

    public int[] d(Activity activity) {
        int[] iArrC = c(activity);
        return new int[]{rj.a().b(activity, iArrC[0]), rj.a().b(activity, iArrC[1])};
    }
}
