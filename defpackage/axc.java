package defpackage;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import defpackage.axd;
import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class axc {
    private static axc m;
    public String f;
    public String g;
    public String h;
    private DashboardActivity n;
    public String a = "US";
    public String b = "f65a35b5c58143139891e714858e5dd2";
    public String c = "harman-kardon-juke.de-01:";
    public String d = "https://portal.api.247e.com/portals/1740/";
    public HashMap<String, String> e = new HashMap<>();
    int i = 0;
    public boolean j = false;
    boolean k = false;
    Runnable l = new Runnable() { // from class: axc.1
        @Override // java.lang.Runnable
        public void run() {
            axc.this.k = true;
            mm.b("Timer", "Timer running now");
            axc.this.a((axd.a) null);
        }
    };
    private Handler o = new Handler();

    private axc() {
    }

    public static axc a() {
        if (m == null) {
            m = new axc();
        }
        return m;
    }

    public void b() {
        if (!this.j) {
            this.n.runOnUiThread(new Runnable() { // from class: axc.11
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(axc.this.n, R.string.JukeLoggedTrackSample, 1).show();
                }
            });
        }
    }

    public void a(final axd.a aVar) {
        StringEntity stringEntity;
        aue aueVarA = agv.a(true);
        aueVarA.a("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("grant_type", "refresh_token");
            jSONObject.put("refresh_token", this.g);
            mm.b("REFRESH_TOKEN", "" + this.g);
            stringEntity = new StringEntity(jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
            stringEntity = null;
        }
        if (this.o == null) {
            this.o = new Handler();
        }
        aueVarA.a("Authorization", "Basic " + auh.a((this.c + this.b).getBytes(), 2));
        String str = this.e.get("portal:token");
        if (str == null || str.length() == 0) {
            mm.b("getAccessToken url is null", new Object[0]);
            if (aVar != null) {
                aVar.a(false, -1);
                return;
            }
            return;
        }
        aueVarA.a(this.n, str, stringEntity, "application/json", new aum() { // from class: axc.12
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject2) {
                String strOptString = jSONObject2.optString("access_token");
                String strOptString2 = jSONObject2.optString("refresh_token");
                if (strOptString != null) {
                    axc.this.f = strOptString;
                }
                if (strOptString2 != null) {
                    axc.this.g = strOptString2;
                }
                axc.this.a(axc.this.f, axc.this.g, aVar);
                axc.this.o.postDelayed(axc.this.l, 180000L);
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject2) {
                mm.b("getAccessToken.onFailure 1 --- statusCode=%d response=%s ", Integer.valueOf(i), jSONObject2);
                if (jSONObject2 != null) {
                    mm.b("onFailure", "" + i + " " + jSONObject2.toString() + " " + axc.this.g);
                }
                if (aVar != null) {
                    aVar.a(false, i);
                }
                axc.this.d();
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i, Header[] headerArr, String str2, Throwable th) {
                mm.b("getAccessToken.onFailure 2 --- statusCode=%d String=%s ", Integer.valueOf(i), str2);
                mm.b("onFailure", "" + i + " " + str2 + " " + axc.this.g);
                if (aVar != null) {
                    aVar.a(false, i);
                }
                axc.this.d();
            }
        });
    }

    public void c() {
        if (!this.k) {
            this.l.run();
        } else {
            mm.b("TIMER", "Timer is currently running");
        }
    }

    void d() {
        mm.b("STOP", "stopping the repeating task");
        this.o.removeCallbacks(this.l);
        this.k = false;
    }

    public void a(final DashboardActivity dashboardActivity, String str, final String str2, final boolean z, final axd.a aVar) {
        if (dashboardActivity != null) {
            this.n = dashboardActivity;
        }
        mm.b("REFRESH_TOKEN1 " + z, "" + this.g);
        this.g = str;
        mm.b("REFRESH_TOKEN2 " + z, "" + this.g);
        aue aueVarA = agv.a(true);
        aueVarA.a("Content-Type", "application/json");
        aueVarA.a(str2, new aum() { // from class: axc.13
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                mm.b("fetchURLs.onSuccess --- statusCode=%d response=%s ", Integer.valueOf(i), jSONObject);
                mm.c();
                if (jSONObject != null) {
                    mm.b("URLS", jSONObject.toString());
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("links");
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("linkTemplates");
                axc.this.a(jSONArrayOptJSONArray);
                axc.this.a(jSONArrayOptJSONArray2);
                if (str2.compareTo(axc.this.e.get("catalog:home")) != 0) {
                    axc.this.a(dashboardActivity, axc.this.g, axc.this.e.get("catalog:home"), z, aVar);
                    return;
                }
                if (z) {
                    axc.this.a(aVar);
                } else {
                    aVar.a(true, i);
                }
                axc.this.c();
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                mm.b("fetchURLs.onFailure 1 --- statusCode=%d response=%s ", Integer.valueOf(i), jSONObject);
                if (jSONObject != null) {
                    mm.b("URLS", "on Failure " + jSONObject.toString());
                    aVar.a("", jSONObject.toString());
                } else {
                    aVar.a("", "");
                }
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i, Header[] headerArr, String str3, Throwable th) {
                mm.b("fetchURLs.onFailure 2 --- statusCode=%d String=%s ", Integer.valueOf(i), str3);
                mm.b("URLS", "on Failure " + str3);
            }
        });
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject.getString("rel").compareTo("user:playlists") == 0 && this.e.containsKey("user:playlists")) {
                        jSONObject.put("user:playlists", this.e.get("user:playlists"));
                    } else {
                        this.e.put(jSONObject.getString("rel"), jSONObject.getString("href"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void a(String str, axd.b bVar, String str2, String str3) {
        a(str, bVar, str2, str3, -1, -1);
    }

    public void a(String str, axd.b bVar, String str2, String str3, int i, int i2) {
        a(this.e, str, bVar, str2, str3, i, i2, false);
    }

    public void a(HashMap<String, String> map, String str, axd.b bVar, String str2, String str3, int i, int i2) {
        a(map, str, bVar, str2, str3, i, i2, false);
    }

    public void a(final HashMap<String, String> map, final String str, final axd.b bVar, final String str2, String str3, int i, int i2, boolean z) {
        mm.b("URLS", "key = " + str + " value =" + map.get(str));
        if (!map.containsKey(str)) {
            mm.c();
            mm.b("JukeMusicManager.queryJuke Map does not contain key=%s ", str);
            bVar.a(str, "no value");
        } else {
            c();
            final long jCurrentTimeMillis = System.currentTimeMillis();
            axd.a(map.get(str), str2, str3, null, new aum() { // from class: axc.14
                @Override // defpackage.aum
                public void a(int i3, Header[] headerArr, JSONObject jSONObject) {
                    try {
                        mm.b("debugreponse", jSONObject.toString());
                        if (jSONObject.has("links")) {
                            axc.this.a(jSONObject.getJSONArray("links"));
                        }
                        jSONObject.put("time_sent", jCurrentTimeMillis);
                        bVar.a(str, jSONObject, str2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override // defpackage.aum
                public void a(int i3, Header[] headerArr, JSONArray jSONArray) {
                    if (jSONArray != null) {
                        mm.b("debugresponse", jSONArray.toString());
                    }
                    bVar.a(str, jSONArray);
                }

                @Override // defpackage.aum
                public void a(int i3, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                    mm.b("JukeMusicManager.queryJukeo nFailure 1 statusCode=%d, response=%s ", Integer.valueOf(i3), jSONObject);
                    if (jSONObject != null) {
                        mm.b("debugfailureresponse", "statusCode = " + i3 + " " + jSONObject.toString() + " " + str + " " + ((String) map.get(str)));
                    }
                    bVar.a(str, "error " + i3);
                }

                @Override // defpackage.aum
                public void a(int i3, Header[] headerArr, Throwable th, JSONArray jSONArray) {
                    mm.b("JukeMusicManager.queryJuke onFailure 2 statusCode=%d, response=%s ", Integer.valueOf(i3), jSONArray);
                    if (jSONArray != null) {
                        mm.b("URLS", "on Failure " + jSONArray.toString());
                    }
                    bVar.a(str, "error " + i3);
                    super.a(i3, headerArr, th, jSONArray);
                }

                @Override // defpackage.aum, defpackage.aux
                public void a(int i3, Header[] headerArr, String str4) {
                    mm.b("debugresponse", str4);
                    super.a(i3, headerArr, str4);
                }

                @Override // defpackage.aum, defpackage.aux
                public void a(int i3, Header[] headerArr, String str4, Throwable th) {
                    mm.b("JukeMusicManager.queryJukeonFailure 1 statusCode=%d, String=%s ", Integer.valueOf(i3), str4);
                    mm.b("debugfailureresponse", "statuscode = " + i3 + " " + str4 + " " + str + " " + ((String) map.get(str)));
                    bVar.a(str, "Error with String");
                }
            }, z);
        }
    }

    public void a(HashMap<String, String> map, final String str, final axd.b bVar) {
        aue aueVarA = agv.a(true);
        aueVarA.a("Content-Type", "application/json");
        aueVarA.a("Authorization", "Bearer " + this.h);
        mm.b("FAV HEADER", "Bearer " + this.h);
        mm.b("FAV", "About to post to " + map.get(str));
        if (map.get(str) != null) {
            aueVarA.a(this.n, map.get(str), (HttpEntity) null, "application/json", new aux() { // from class: axc.15
                @Override // defpackage.aux
                public void a(int i, Header[] headerArr, String str2, Throwable th) {
                    mm.b("URLSs", "on Failure " + str2 + " " + i);
                    if (bVar != null) {
                        bVar.a(str, "");
                    }
                }

                @Override // defpackage.aux
                public void a(int i, Header[] headerArr, String str2) {
                }
            });
        }
    }

    public void a(HashMap<String, String> map, final String str, final axd.b bVar, final String str2) {
        aue aueVarA = agv.a(true);
        aueVarA.a("Content-Type", "application/json");
        aueVarA.a("Authorization", "Bearer " + this.h);
        mm.b("FAV HEADER", "Bearer " + this.h);
        mm.b("FAV", "About to post to " + map.get(str));
        if (map.get(str) != null) {
            aueVarA.a(this.n, map.get(str), (Header[]) null, (aus) null, new aux() { // from class: axc.16
                @Override // defpackage.aux
                public void a(int i, Header[] headerArr, String str3, Throwable th) {
                    mm.b("URLSs", "on Failure " + str3 + " " + i);
                    if ((i == 200 || i == 0) && bVar != null) {
                        bVar.a(str, null, str2);
                    } else if (bVar != null) {
                        bVar.a(str, "");
                    }
                }

                @Override // defpackage.aux
                public void a(int i, Header[] headerArr, String str3) {
                    if (bVar != null) {
                        bVar.a(str, null, str2);
                    }
                }
            });
        }
    }

    public void a(HashMap<String, String> map, final String str, final axd.b bVar, String str2, String str3, String str4, String str5, JSONArray jSONArray) {
        StringEntity stringEntity;
        aue aueVarA = agv.a(true);
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray2 = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("position", 0);
            jSONObject2.put("links", jSONArray);
            jSONArray2.put(jSONObject2);
            if (jSONArray != null) {
                jSONObject.put("entries", jSONArray2);
            }
            jSONObject.put("id", str2);
            jSONObject.put("name", str3);
            jSONObject.put("description", str4);
            jSONObject.put("visibility", str5);
            stringEntity = new StringEntity(jSONObject.toString(), HTTP.UTF_8);
            try {
                stringEntity.setContentType("application/json");
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e = e2;
            stringEntity = null;
        }
        aueVarA.a("Content-Type", "application/json");
        aueVarA.a("Authorization", "Bearer " + this.h);
        mm.b("FAV HEADER", "Bearer " + this.h);
        mm.b("FAV", "About to post to " + map.get(str));
        mm.b("FAV", "params = " + jSONObject.toString());
        aueVarA.a(this.n, map.get(str), stringEntity, "application/json", new aux() { // from class: axc.17
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str6, Throwable th) {
                mm.b("JukeMusicManager.onFailure String=%s StatusCode=%d ", str6, Integer.valueOf(i));
                mm.c();
                if (bVar != null) {
                    bVar.a(str, "");
                }
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str6) {
                mm.b("FAV", str6);
                bVar.a("user:portal", new JSONObject(), "");
            }
        });
    }

    public void a(final HashMap<String, String> map, final String str, final axd.b bVar, final String str2, final String str3, final String str4, final String str5) {
        axd.a(map.get(str), "", "", null, new aum() { // from class: axc.18
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                String value = "";
                for (Header header : headerArr) {
                    mm.b("PLAYLIST", header.getName());
                    if (header.getName().compareTo("ETag") == 0) {
                        value = header.getValue();
                    }
                }
                axc.this.a(map, str, bVar, str2, str3, str4, str5, value);
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                if (jSONObject != null) {
                    mm.b("URLS", "on Failure " + jSONObject.toString());
                }
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i, Header[] headerArr, String str6, Throwable th) {
                mm.b("EDIT", "" + i + " Failure " + str6);
            }
        }, true);
    }

    public void a(HashMap<String, String> map, final String str, final axd.b bVar, String str2, final String str3, String str4, String str5, String str6) {
        StringEntity stringEntity;
        aue aueVarA = agv.a(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", str2);
            jSONObject.put("name", str3);
            jSONObject.put("description", str4);
            jSONObject.put("visibility", str5);
            mm.b("Sending entity " + jSONObject, new Object[0]);
            stringEntity = new StringEntity(jSONObject.toString(), HTTP.UTF_8);
        } catch (Exception e) {
            e = e;
            stringEntity = null;
        }
        try {
            stringEntity.setContentType("application/json");
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
        }
        aueVarA.a("Content-Type", "application/json");
        aueVarA.a("If-Match", str6);
        aueVarA.a("Authorization", "Bearer " + this.h);
        mm.b("FAV HEADER", "Bearer " + this.h);
        mm.b("FAV", "About to post to " + map.get(str));
        aueVarA.b(this.n, map.get(str), stringEntity, "application/json", new aum() { // from class: axc.2
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject2) {
                if (jSONObject2 != null) {
                    mm.b("FAV", jSONObject2.toString());
                }
                bVar.a("edit:playlist", new JSONObject(), str3);
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject2) {
                if (jSONObject2 != null) {
                    mm.b("URLS", "on Failure " + jSONObject2.toString());
                }
                if (bVar != null) {
                    bVar.a(str, "");
                }
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i, Header[] headerArr, String str7, Throwable th) {
                mm.b("URLSs", "on Failure " + str7 + " " + i);
                if (bVar != null) {
                    bVar.a(str, "");
                }
            }
        });
    }

    public void b(HashMap<String, String> map, final String str, final axd.b bVar) {
        aue aueVarA = agv.a(true);
        aueVarA.a("Content-Type", "application/json");
        aueVarA.a("Authorization", "Bearer " + this.h);
        mm.b("FAV HEADER", "Bearer " + this.h);
        mm.b("FAV", "About to post to " + map.get(str));
        aueVarA.a(this.n, map.get(str), (Header[]) null, new aus(), new aum() { // from class: axc.3
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                if (jSONObject != null) {
                    mm.b("FAV", jSONObject.toString());
                }
                bVar.a("delete:playlist", new JSONObject(), "");
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                if (jSONObject != null) {
                    mm.b("URLS", "on Failure " + jSONObject.toString());
                }
                if (bVar != null) {
                    bVar.a(str, "");
                }
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i, Header[] headerArr, String str2, Throwable th) {
                mm.b("URLSs", "on Failure " + str2 + " " + i);
                if (bVar != null) {
                    bVar.a(str, "");
                }
            }
        });
    }

    public void a(HashMap<String, String> map, String str, axd.b bVar, int i, JSONArray jSONArray) {
        a(map, str, bVar, i, jSONArray, 1);
    }

    public void a(final HashMap<String, String> map, final String str, final axd.b bVar, final int i, final JSONArray jSONArray, final int i2) {
        StringEntity stringEntity;
        aue aueVarA = agv.a(true);
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray2 = new JSONArray();
        try {
            jSONArray2.put(jSONArray.optJSONObject(jSONArray.length() - i2));
            jSONObject.put("position", i);
            jSONObject.put("links", jSONArray2);
            stringEntity = new StringEntity(jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
            stringEntity = null;
        }
        aueVarA.a("Content-Type", "application/json");
        aueVarA.a("Authorization", "Bearer " + this.h);
        mm.b("FAV HEADER", "Bearer " + this.h);
        mm.b("FAV", "About to post to " + map.get(str));
        mm.b("FAV", "params = " + jSONObject.toString());
        aueVarA.a(this.n, map.get(str), stringEntity, "application/json", new aux() { // from class: axc.4
            @Override // defpackage.aux
            public void a(int i3, Header[] headerArr, String str2, Throwable th) {
                mm.b("URLSs", "on Failure " + str2 + " " + i3);
                if (bVar != null) {
                    bVar.a(str, "");
                }
            }

            @Override // defpackage.aux
            public void a(int i3, Header[] headerArr, String str2) {
                mm.b("FAV", str2);
                int i4 = i2 + 1;
                if (i4 <= jSONArray.length()) {
                    axc.this.a(map, str, bVar, i, jSONArray, i4);
                }
            }
        });
    }

    public void c(HashMap<String, String> map, final String str, final axd.b bVar) {
        aue aueVarA = agv.a(true);
        aueVarA.a("Content-Type", "application/json");
        aueVarA.a("Authorization", "Bearer " + this.h);
        mm.b("FAV HEADER", "Bearer " + this.h);
        mm.b("FAV", "About to post to " + map.get(str));
        aueVarA.a(this.n, map.get(str), (Header[]) null, (aus) null, new aux() { // from class: axc.5
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str2, Throwable th) {
                mm.b("URLSs", "on Failure " + str2 + " " + i);
                if (bVar != null) {
                    bVar.a(str, "");
                }
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str2) {
                bVar.a(str, null, "");
            }
        });
    }

    public void a(final Context context, final String str, final String str2, final axd.a aVar) {
        final aue aueVarA = agv.a(true);
        aueVarA.a("Content-Type", "application/json");
        aueVarA.a(this.d, new aum() { // from class: axc.6
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                JSONArray jSONArray;
                if (jSONObject != null) {
                    mm.b("URLS", jSONObject.toString());
                }
                try {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("links");
                    mm.b("URLs2", jSONArray2.toString());
                    axc.this.a(jSONArray2);
                    try {
                        jSONArray = jSONObject.getJSONArray("linkTemplates");
                    } catch (JSONException e) {
                        e.printStackTrace();
                        jSONArray = null;
                    }
                    mm.b("URLs2", jSONArray.toString());
                    axc.this.a(jSONArray);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("grant_type", "password");
                    jSONObject2.put("username", str);
                    jSONObject2.put("password", str2);
                    StringEntity stringEntity = new StringEntity(jSONObject2.toString());
                    String strA = auh.a((axc.this.c + axc.this.b).getBytes(), 2);
                    mm.b("HEADER64", strA);
                    mm.b("PARAMS", jSONObject2.toString());
                    aueVarA.a("Authorization", "Basic " + strA);
                    aueVarA.a(context, axc.this.e.get("portal:token"), stringEntity, "application/json", new aum() { // from class: axc.6.1
                        @Override // defpackage.aum
                        public void a(int i2, Header[] headerArr2, JSONObject jSONObject3) {
                            if (jSONObject3 != null) {
                                mm.b("LOGIN", jSONObject3.toString());
                            }
                            axc.this.a(jSONObject3.optString("access_token"), jSONObject3.optString("refresh_token"), aVar);
                        }

                        @Override // defpackage.aum
                        public void a(int i2, Header[] headerArr2, Throwable th, JSONObject jSONObject3) {
                            mm.b("getSTSTokens.onFailure 1 --- statusCode=%d response=%s ", Integer.valueOf(i2), jSONObject3);
                            mm.b("URLS", "on Failure " + jSONObject3);
                            aVar.a(false, i2);
                        }

                        @Override // defpackage.aum, defpackage.aux
                        public void a(int i2, Header[] headerArr2, String str3, Throwable th) {
                            mm.b("getSTSTokens.onFailure 2 --- statusCode=%d String=%s ", Integer.valueOf(i2), str3);
                            mm.b("URLS", "on Failure " + str3);
                            aVar.a(false, i2);
                        }
                    });
                } catch (Exception e2) {
                    mm.b("URLs", e2.toString());
                    e2.printStackTrace();
                }
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                if (jSONObject != null) {
                    mm.b("URLS", "on Failure " + jSONObject.toString());
                }
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i, Header[] headerArr, String str3, Throwable th) {
                mm.b("URLS", "on Failure " + str3);
            }
        });
    }

    public boolean e() {
        if (this.i == 0) {
            return true;
        }
        if (this.i <= ((int) System.currentTimeMillis()) / 1000) {
            mm.b("EXPIRE", "is expired");
            return true;
        }
        mm.b("EXPIRE", "is not expired");
        return false;
    }

    public void a(final String str, final String str2, final axd.a aVar) {
        StringEntity stringEntity;
        aue aueVarA = agv.a(true);
        aueVarA.a("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("grant_type", "urn:ietf:params:oauth:grant-type:swt-bearer");
            jSONObject.put("assertion", str);
            stringEntity = new StringEntity(jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
            stringEntity = null;
        }
        String strA = auh.a((this.c + this.b).getBytes(), 2);
        mm.b("HEADER64", strA);
        mm.b("PARAMS", jSONObject.toString());
        aueVarA.a("Authorization", "Basic " + strA);
        aueVarA.a(this.n, this.e.get("sts:token"), stringEntity, "application/json", new aum() { // from class: axc.7
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject2) {
                mm.b("getSTSTokens.onSuccess --- statusCode=%d response=%s ", Integer.valueOf(i), jSONObject2);
                if (jSONObject2 != null) {
                    mm.b("LOGIN", jSONObject2.toString());
                }
                try {
                    jSONObject2.put("msh_access_token", str);
                    jSONObject2.put("refresh_token", str2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                axc.this.h = jSONObject2.optString("access_token");
                axc.this.f = str;
                axc.this.g = str2;
                axc.this.i = ((int) System.currentTimeMillis()) / 1000;
                axc.this.i += jSONObject2.optInt("expires_in");
                if (aVar != null) {
                    aVar.a(true, i);
                }
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject2) {
                mm.b("getSTSTokens.onFailure 1 --- statusCode=%d response=%s ", Integer.valueOf(i), jSONObject2);
                if (aVar != null) {
                    aVar.a(false, i);
                }
                axc.this.d();
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i, Header[] headerArr, String str3, Throwable th) {
                mm.b("getSTSTokens.onFailure 2 --- statusCode=%d string=%s ", Integer.valueOf(i), str3);
                mm.c();
                mm.b("URLS", "on Failure " + str3);
                if (aVar != null) {
                    aVar.a(false, i);
                }
                axc.this.d();
            }
        });
    }

    public void a(String str, axd.b bVar) {
        aue aueVarA = agv.a(true);
        aueVarA.a("Content-Type", "application/json");
        aueVarA.a(this.d, new AnonymousClass8(aueVarA, str, bVar));
    }

    /* JADX INFO: renamed from: axc$8, reason: invalid class name */
    class AnonymousClass8 extends aum {
        final /* synthetic */ aue a;
        final /* synthetic */ String b;
        final /* synthetic */ axd.b c;

        AnonymousClass8(aue aueVar, String str, axd.b bVar) {
            this.a = aueVar;
            this.b = str;
            this.c = bVar;
        }

        @Override // defpackage.aum
        public void a(int i, Header[] headerArr, JSONObject jSONObject) {
            if (jSONObject != null) {
                mm.b("URLS", jSONObject.toString());
            }
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("links");
                mm.b("URLs2", jSONArray.toString());
                axc.this.a(jSONArray);
                try {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("linkTemplates");
                    if (jSONArray2 != null) {
                        mm.b("URLs2", jSONArray2.toString());
                        axc.this.a(jSONArray2);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                this.a.a("Content-Type", "application/json");
                this.a.a(axc.this.e.get("web:home"), new AnonymousClass1());
            } catch (Exception e2) {
                mm.b("URLs", e2.toString());
                e2.printStackTrace();
            }
        }

        /* JADX INFO: renamed from: axc$8$1, reason: invalid class name */
        class AnonymousClass1 extends aum {
            AnonymousClass1() {
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                super.a(i, headerArr, jSONObject);
                if (jSONObject != null) {
                    mm.b("URLS", jSONObject.toString());
                }
                try {
                    try {
                        JSONArray jSONArray = jSONObject.getJSONArray("links");
                        mm.b("URLs2", jSONArray.toString());
                        axc.this.a(jSONArray);
                        try {
                            JSONArray jSONArray2 = jSONObject.getJSONArray("linkTemplates");
                            if (jSONArray2 != null) {
                                mm.b("URLs2", jSONArray2.toString());
                                axc.this.a(jSONArray2);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        AnonymousClass8.this.a.a("Content-Type", "application/json");
                        AnonymousClass8.this.a.a(axc.this.e.get("web:pages"), new aum() { // from class: axc.8.1.1
                            @Override // defpackage.aum
                            public void a(int i2, Header[] headerArr2, JSONObject jSONObject2) {
                                JSONArray jSONArray3;
                                StringEntity stringEntity;
                                super.a(i2, headerArr2, jSONObject2);
                                if (jSONObject2 != null) {
                                    try {
                                        JSONArray jSONArray4 = jSONObject2.getJSONArray("pages");
                                        for (int i3 = 0; i3 < jSONArray4.length(); i3++) {
                                            JSONObject jSONObject3 = (JSONObject) jSONArray4.get(i3);
                                            JSONArray jSONArray5 = jSONObject3.getJSONArray("tags");
                                            if (jSONArray5 != null && jSONArray5.length() > 0 && "forgotpassword-landing".equalsIgnoreCase((String) jSONArray5.get(0)) && (jSONArray3 = jSONObject3.getJSONArray("links")) != null && jSONArray3.length() > 0) {
                                                JSONObject jSONObject4 = (JSONObject) jSONArray3.get(0);
                                                JSONObject jSONObject5 = new JSONObject();
                                                try {
                                                    jSONObject5.put("emailAddress", AnonymousClass8.this.b);
                                                    jSONObject5.put("clientUri", jSONObject4.optString("href") + "token={token}");
                                                    stringEntity = new StringEntity(jSONObject5.toString());
                                                } catch (Exception e2) {
                                                    e2.printStackTrace();
                                                    stringEntity = null;
                                                }
                                                AnonymousClass8.this.a.a("Authorization", "Basic " + auh.a((axc.this.c + axc.this.b).getBytes(), 2));
                                                AnonymousClass8.this.a.a("Content-Type", "application/vnd.247e.request-password-reset+json");
                                                AnonymousClass8.this.a.a(axc.this.n, axc.this.e.get("portal:user-request-reset-password"), stringEntity, "application/json", new aux() { // from class: axc.8.1.1.1
                                                    @Override // defpackage.aux
                                                    public void a(int i4, Header[] headerArr3, String str, Throwable th) {
                                                        mm.b("URLSs", "on Failure " + str + " " + i4);
                                                        if (AnonymousClass8.this.c != null) {
                                                            AnonymousClass8.this.c.a("msh:request-reset-user-password", "");
                                                        }
                                                    }

                                                    @Override // defpackage.aux
                                                    public void a(int i4, Header[] headerArr3, String str) {
                                                        AnonymousClass8.this.c.a("msh:request-reset-user-password", null, "");
                                                    }
                                                });
                                            }
                                        }
                                    } catch (JSONException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                            }

                            @Override // defpackage.aum, defpackage.aux
                            public void a(int i2, Header[] headerArr2, String str, Throwable th) {
                                super.a(i2, headerArr2, str, th);
                            }
                        });
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i, Header[] headerArr, String str, Throwable th) {
                super.a(i, headerArr, str, th);
            }
        }

        @Override // defpackage.aum
        public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
            if (jSONObject != null) {
                mm.b("URLS", "on Failure " + jSONObject.toString());
            }
        }

        @Override // defpackage.aum, defpackage.aux
        public void a(int i, Header[] headerArr, String str, Throwable th) {
            mm.b("URLS", "on Failure " + str);
        }
    }

    public void a(final axd.b bVar) {
        if (TextUtils.isEmpty(this.e.get("purchase:user-subscriptions"))) {
            b(bVar);
            return;
        }
        final aue aueVarA = agv.a(true);
        aueVarA.a("Content-Type", "application/json");
        aueVarA.a("Authorization", "Bearer " + this.h);
        aueVarA.a(this.e.get("purchase:user-subscriptions"), new aum() { // from class: axc.9
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                super.a(i, headerArr, jSONObject);
                if (jSONObject != null) {
                    mm.b("SUBS", jSONObject.toString());
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("subscriptions");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
                    if (jSONObjectOptJSONObject != null) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("links");
                        JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("linkTemplates");
                        axc.this.a(jSONArrayOptJSONArray2);
                        axc.this.a(jSONArrayOptJSONArray3);
                        aueVarA.a(axc.this.e.get("purchase:user-subscription-status"), new aum() { // from class: axc.9.1
                            @Override // defpackage.aum
                            public void a(int i2, Header[] headerArr2, JSONObject jSONObject2) {
                                super.a(i2, headerArr2, jSONObject2);
                                bVar.a("purchase:user-subscription-status", jSONObject2, "");
                            }

                            @Override // defpackage.aum, defpackage.aux
                            public void a(int i2, Header[] headerArr2, String str) {
                                super.a(i2, headerArr2, str);
                                bVar.a("purchase:user-subscription-status", "");
                            }
                        });
                        return;
                    }
                    return;
                }
                bVar.a("purchase:user-subscriptions", jSONObject, "");
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i, Header[] headerArr, String str, Throwable th) {
                super.a(i, headerArr, str, th);
                bVar.a("purchase:user-subscriptions", "");
            }
        });
    }

    public void b(final axd.b bVar) {
        aue aueVarA = agv.a(true);
        aueVarA.a("Content-Type", "application/vnd.247e.purchase-home+json");
        aueVarA.a("Authorization", "Basic " + auh.a((this.c + this.b).getBytes(), 2));
        aueVarA.a(this.e.get("purchase:home"), new aum() { // from class: axc.10
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                JSONArray jSONArray;
                super.a(i, headerArr, jSONObject);
                if (jSONObject != null) {
                    try {
                        try {
                            mm.b("Purchase Links", jSONObject.toString());
                            JSONArray jSONArray2 = jSONObject.getJSONArray("links");
                            mm.b("URLs2", jSONArray2.toString());
                            axc.this.a(jSONArray2);
                            try {
                                jSONArray = jSONObject.getJSONArray("linkTemplates");
                            } catch (JSONException e) {
                                e.printStackTrace();
                                jSONArray = null;
                            }
                            mm.b("URLs2", jSONArray.toString());
                            axc.this.a(jSONArray);
                            axc.this.a(bVar);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i, Header[] headerArr, String str, Throwable th) {
                super.a(i, headerArr, str, th);
                bVar.a("purchase:user-subscriptions", "");
            }
        });
    }
}
