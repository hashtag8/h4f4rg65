package defpackage;

import android.annotation.TargetApi;
import android.os.Build;
import android.text.TextUtils;
import java.io.IOException;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class nw implements bnj<nu> {
    nw() {
    }

    @Override // defpackage.bnj
    public byte[] a(nu nuVar) {
        return b(nuVar).toString().getBytes(HTTP.UTF_8);
    }

    @TargetApi(9)
    public JSONObject b(nu nuVar) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            nv nvVar = nuVar.a;
            jSONObject.put("appBundleId", nvVar.a);
            jSONObject.put("executionId", nvVar.b);
            jSONObject.put("installationId", nvVar.c);
            if (TextUtils.isEmpty(nvVar.e)) {
                jSONObject.put("androidId", nvVar.d);
            } else {
                jSONObject.put("advertisingId", nvVar.e);
            }
            jSONObject.put("limitAdTrackingEnabled", nvVar.f);
            jSONObject.put("betaDeviceToken", nvVar.g);
            jSONObject.put("buildId", nvVar.h);
            jSONObject.put("osVersion", nvVar.i);
            jSONObject.put("deviceModel", nvVar.j);
            jSONObject.put("appVersionCode", nvVar.k);
            jSONObject.put("appVersionName", nvVar.l);
            jSONObject.put("timestamp", nuVar.b);
            jSONObject.put("type", nuVar.c.toString());
            if (nuVar.d != null) {
                jSONObject.put("details", new JSONObject(nuVar.d));
            }
            jSONObject.put("customType", nuVar.e);
            if (nuVar.f != null) {
                jSONObject.put("customAttributes", new JSONObject(nuVar.f));
            }
            jSONObject.put("predefinedType", nuVar.g);
            if (nuVar.h != null) {
                jSONObject.put("predefinedAttributes", new JSONObject(nuVar.h));
            }
            return jSONObject;
        } catch (JSONException e) {
            if (Build.VERSION.SDK_INT >= 9) {
                throw new IOException(e.getMessage(), e);
            }
            throw new IOException(e.getMessage());
        }
    }
}
