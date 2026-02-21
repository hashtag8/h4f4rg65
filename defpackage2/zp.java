package defpackage;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@yx
public interface zp {
    void a();

    void a(int i);

    void a(AdSizeParcel adSizeParcel);

    void a(String str);

    void a(String str, Map<String, ?> map);

    void a(String str, JSONObject jSONObject);

    void a(ru ruVar);

    void a(boolean z);

    void b();

    void b(ru ruVar);

    void b(boolean z);

    Activity c();

    Context d();

    ru e();

    ru f();

    AdSizeParcel g();

    Context getContext();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    WebView getWebView();

    zq h();

    boolean i();

    wi j();

    VersionInfoParcel k();

    boolean l();

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    boolean m();

    void measure(int i, int i2);

    void n();

    void o();

    void setBackgroundColor(int i);

    void setContext(Context context);

    void setRequestedOrientation(int i);

    boolean willNotDraw();
}
