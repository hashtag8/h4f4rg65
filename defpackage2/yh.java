package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@yx
public class yh {
    private final zp a;
    private final String b;

    public yh(zp zpVar) {
        this(zpVar, "");
    }

    public yh(zp zpVar, String str) {
        this.a = zpVar;
        this.b = str;
    }

    public void a(int i, int i2, int i3, int i4) {
        try {
            this.a.a("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            su.b("Error occured while dispatching size change.", e);
        }
    }

    public void a(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.a.a("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", f).put("rotation", i5));
        } catch (JSONException e) {
            su.b("Error occured while obtaining screen information.", e);
        }
    }

    public void b(int i, int i2, int i3, int i4) {
        try {
            this.a.a("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            su.b("Error occured while dispatching default position.", e);
        }
    }

    public void b(String str) {
        try {
            this.a.a("onError", new JSONObject().put("message", str).put("action", this.b));
        } catch (JSONException e) {
            su.b("Error occurred while dispatching error event.", e);
        }
    }

    public void c(String str) {
        try {
            this.a.a("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            su.b("Error occured while dispatching ready Event.", e);
        }
    }

    public void d(String str) {
        try {
            this.a.a("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            su.b("Error occured while dispatching state change.", e);
        }
    }
}
