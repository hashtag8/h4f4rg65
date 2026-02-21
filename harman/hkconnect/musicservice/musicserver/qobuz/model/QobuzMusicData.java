package com.harman.hkconnect.musicservice.musicserver.qobuz.model;

import com.harman.commom.music.player.service.MusicData;
import com.harman.hkconnect.R;
import defpackage.agd;
import defpackage.agv;
import defpackage.aho;
import defpackage.aum;
import defpackage.aus;
import defpackage.mm;
import defpackage.qw;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class QobuzMusicData extends MusicData {
    public int a;
    public int b;
    public String c;
    public boolean d = false;
    public String e;
    public boolean f;
    public String g;
    public int h;
    private boolean i;

    public QobuzMusicData() {
        this.type = 4;
        setShouldReportStreaming(true);
    }

    @Override // com.harman.commom.music.player.service.MusicData
    public agd getPlayAbleUrl() {
        if (this.path == null || "".equals(this.path.trim())) {
            String strTrim = aho.d("format_id").trim();
            Date date = new Date();
            String strA = qw.a("http://www.qobuz.com/api.json/0.2/track/getFileUrl?app_id=394304373&track_id=" + this.songId + "&format_id=" + strTrim + "&request_ts=" + (date.getTime() / 1000) + "&request_sig=" + a(strTrim, Long.valueOf(this.songId), date, "b8b0e240b22d9d166266822453e903a0") + "&user_auth_token=" + aho.d("qobuz_user_auth_token").trim());
            mm.a((Object) ("------------Qobuz------response------------>" + strA));
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(strA);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (jSONObject != null) {
                mm.a((Object) ("------------Qobuz------url------------>" + jSONObject.optString("url") + "<--------format_id--------->" + strTrim));
            }
            this.path = jSONObject == null ? "" : jSONObject.optString("url");
            mm.b("Qobuz JSON response track format " + jSONObject, new Object[0]);
        }
        agd agdVar = new agd();
        if (this.path == null || this.path.length() == 0 || !a()) {
            agdVar.b.c = R.string.PlayErrorTip_Str;
        } else {
            agdVar.a = this.path;
        }
        return agdVar;
    }

    private String a(String str, Long l, Date date, String str2) {
        return a("trackgetFileUrlformat_id" + str + "track_id" + l + (date.getTime() / 1000) + str2);
    }

    public String a(String str) {
        try {
            return String.format("%032x", new BigInteger(1, MessageDigest.getInstance("MD5").digest(str.getBytes("UTF8"))));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean a() {
        return true;
    }

    public void a(boolean z) {
        this.i = z;
    }

    private void a(String str, long j) {
        int i;
        try {
            i = Integer.parseInt(aho.d("format_id"));
        } catch (Exception e) {
            i = 5;
        }
        aus ausVar = new aus();
        ausVar.a("app_id", 394304373);
        ausVar.a("user_auth_token", aho.d("qobuz_user_auth_token").trim());
        ausVar.a("events", a(aho.d("user_id").trim(), new Date().getTime() / 1000, j, true, "streaming", true, aho.d("device_id").trim(), this.songId + "", false, false, aho.d("credential_id").trim(), i));
        mm.b("reportStreaming requestParams " + ausVar.toString(), new Object[0]);
        agv.b(true).b(str, ausVar, new aum() { // from class: com.harman.hkconnect.musicservice.musicserver.qobuz.model.QobuzMusicData.1
            @Override // defpackage.aum
            public void a(int i2, Header[] headerArr, JSONObject jSONObject) {
                mm.b((Object) ("qobuz reportStreaming onSuccess response = " + jSONObject));
                super.a(i2, headerArr, jSONObject);
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i2, Header[] headerArr, String str2, Throwable th) {
                super.a(i2, headerArr, str2, th);
                mm.b((Object) ("qobuz reportStreaming1 statusCode = " + i2 + " , headers = " + headerArr + " , throwable = " + th + " , responseString = " + str2));
            }

            @Override // defpackage.aum
            public void a(int i2, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                super.a(i2, headerArr, th, jSONObject);
                mm.b((Object) ("qobuz reportStreaming2 statusCode = " + i2 + " , headers = " + headerArr + " , throwable = " + th + " , errorResponse = " + jSONObject));
            }

            @Override // defpackage.aum
            public void a(int i2, Header[] headerArr, Throwable th, JSONArray jSONArray) {
                super.a(i2, headerArr, th, jSONArray);
                mm.b((Object) ("qobuz reportStreaming3 statusCode = " + i2 + " , headers = " + headerArr + " , throwable = " + th + " , errorResponse = " + jSONArray));
            }
        });
    }

    @Override // com.harman.commom.music.player.service.MusicData
    public void reportStreamingStart() {
        mm.b((Object) "qobuz reportStreamingStart");
        a("http://www.qobuz.com/api.json/0.2/track/reportStreamingStart", 0L);
    }

    @Override // com.harman.commom.music.player.service.MusicData
    public void reportStreamingEnd(long j) {
        mm.b((Object) ("qobuz reportStreamingEnd duration = " + j));
        a("http://www.qobuz.com/api.json/0.2/track/reportStreamingEnd", j);
    }

    private String a(String str, long j, long j2, boolean z, String str2, boolean z2, String str3, String str4, boolean z3, boolean z4, String str5, int i) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", str);
            jSONObject.put("date", j);
            jSONObject.put("duration", j2);
            jSONObject.put("online", z);
            jSONObject.put("intent", str2);
            jSONObject.put("sample", z2);
            jSONObject.put("device_id", str3);
            jSONObject.put("track_id", str4);
            jSONObject.put("purchase", z3);
            jSONObject.put("local", z4);
            jSONObject.put("credential_id", str5);
            jSONObject.put("format_id", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        jSONArray.put(jSONObject);
        return jSONArray.toString();
    }
}
