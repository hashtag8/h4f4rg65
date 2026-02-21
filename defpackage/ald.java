package defpackage;

import android.app.Activity;
import android.widget.Toast;
import com.harman.hkconnect.R;
import defpackage.ajv;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ald extends ajj {
    protected qi g = null;

    @Override // defpackage.ajj, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.g = new qj("135461");
        new qo().b(this.g, this.ae);
    }

    public void a(int i, JSONObject jSONObject) {
        ba baVarP = p();
        if (baVarP != null) {
            Toast.makeText(baVarP, R.string.kDeezer_ConnectToDeezzer_Failed_Str, 0).show();
        }
        mm.b("onFailure statusCode = " + i + ", errorResponse = " + jSONObject, new Object[0]);
    }

    @Override // defpackage.ajj
    public ajv b() {
        ajv.a aVar = new ajv.a();
        aVar.a(-13487558);
        if (!ahn.a()) {
            return aVar.c();
        }
        ajj ajjVar = (ajj) u();
        if (ajjVar == null) {
            return aVar.c();
        }
        return aVar.c(true).k(R.drawable.search).a(ajjVar.b().p()).c();
    }

    @Override // defpackage.ajj, defpackage.ajk, android.support.v4.app.Fragment
    public void d(boolean z) {
        this.ae.ab();
        if (z) {
            e();
        } else {
            ar();
            at();
        }
    }
}
