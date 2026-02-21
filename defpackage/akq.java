package defpackage;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.deezer.activity.OAuthV2WebViewActivity;
import com.harman.hkconnect.ui.DashboardActivity;
import org.apache.http.Header;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class akq extends avd {
    private ProgressDialog b;
    private Handler c;

    public akq(DashboardActivity dashboardActivity) {
        super(dashboardActivity, 1, new ava().a(1, dashboardActivity));
    }

    @Override // defpackage.avd, defpackage.avc
    public void c_() {
        qo qoVar = new qo();
        qj qjVar = new qj("135461");
        qjVar.a(g(), aho.d("access_token"));
        qoVar.a(qjVar, g());
        super.c_();
    }

    @Override // defpackage.avd
    public void b() {
        super.b();
        g().q().a(new alj(), this.a, (arc) null);
    }

    @Override // defpackage.avd
    public void a(boolean z) {
        super.a(z);
        g().q().a(new amg(), this.a, (arc) null);
    }

    @Override // defpackage.avd
    public void c() {
        aue aueVarA = agv.a(true);
        d();
        mm.b("https://api.deezer.com/infos", new Object[0]);
        aueVarA.a("https://api.deezer.com/infos", new aum() { // from class: akq.1
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                mm.b("statusCode = " + i + " ,response = " + jSONObject, new Object[0]);
                akq.this.e();
                if (jSONObject != null && jSONObject.has("open")) {
                    if (jSONObject.optBoolean("open")) {
                        akq.this.g().startActivityForResult(new Intent(akq.this.g(), (Class<?>) OAuthV2WebViewActivity.class), akq.this.a);
                        return;
                    } else {
                        Toast.makeText(akq.this.g(), R.string.kDeezer_CountryNotAvailable_Str, 0).show();
                        return;
                    }
                }
                Toast.makeText(akq.this.g(), R.string.kDeezer_CountryNotAvailable_Str, 0).show();
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                akq.this.e();
                Toast.makeText(akq.this.g(), R.string.kDeezer_ConnectToDeezzer_Failed_Str, 0).show();
            }
        });
    }

    public void b(boolean z) {
        this.c = new Handler();
        if (this.b == null) {
            this.b = new ProgressDialog(g());
            this.b.setCancelable(false);
            this.b.setMessage(g().getString(R.string.kAndroid_Loading));
        }
        if (!this.b.isShowing()) {
            new asc(this.b).a(null);
        }
        if (z) {
            this.c.sendEmptyMessageDelayed(1, 45000L);
        }
    }

    public void d() {
        b(true);
    }

    public void e() {
        if (this.b != null && this.b.isShowing()) {
            this.b.dismiss();
            this.b = null;
        }
    }
}
