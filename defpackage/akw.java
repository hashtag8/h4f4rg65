package defpackage;

import android.app.Activity;
import android.content.SharedPreferences;
import com.harman.hkconnect.ui.HarmanApplication;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class akw extends auz {
    private bak c;

    public akw(int i, Activity activity) {
        this.a = i;
        this.b = activity;
    }

    @Override // defpackage.auz
    public boolean a() {
        this.c = c();
        if (this.c != null) {
            azs.ap = new baa("wvr7o7tSFkQf6zNgw2D56Q", "oHBpsoA7kokZCltmA1X8xg", azc.c, this.c);
            mq.b().execute(new Runnable() { // from class: akw.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            akw.this.c = azs.ap.a();
                            akw.this.a("HK_Rdio_Token_Tag", akw.this.c.toString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            return true;
        }
        azs.ap = new baa("wvr7o7tSFkQf6zNgw2D56Q", "oHBpsoA7kokZCltmA1X8xg", azc.c, null);
        return false;
    }

    @Override // defpackage.auz
    public void a(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getJSONObject("result").getString("firstName");
        String string2 = jSONObject.getJSONObject("result").getString("lastName");
        String string3 = jSONObject.getJSONObject("result").getString("key");
        Boolean boolValueOf = Boolean.valueOf(jSONObject.getJSONObject("result").getBoolean("isSubscriber"));
        ayw.c().a(string3);
        ayw.c().a(boolValueOf);
        a("HK_Rdio_Username_Tag", string + " " + string2);
        a("HK_Rdio_User_Key", string3);
        a("HK_Rdio_User_Sub", boolValueOf);
    }

    @Override // defpackage.auz
    public void b() {
        try {
            azs.ap.b();
        } catch (NullPointerException e) {
        }
        azr.ao();
        d();
    }

    public bak c() {
        return a(ain.J.getSharedPreferences("", 0).getString("HK_Rdio_Token_Tag", null));
    }

    public void a(String str, Object obj) {
        SharedPreferences.Editor editorEdit = HarmanApplication.a().getSharedPreferences("", 0).edit();
        if (obj instanceof String) {
            editorEdit.putString(str, (String) obj);
        } else if (obj instanceof Boolean) {
            editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
        }
        editorEdit.apply();
    }

    protected bak a(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("'");
        bak bakVar = new bak(strArrSplit[1], strArrSplit[3], strArrSplit[5], strArrSplit[7], Long.parseLong(strArrSplit[9]));
        if (strArrSplit[1].equals("bearer")) {
            baa.b = "Bearer";
            return bakVar;
        }
        return bakVar;
    }
}
