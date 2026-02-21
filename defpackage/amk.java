package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.nokia.NokiaMusicData;
import defpackage.amj;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;
import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class amk implements amj.a {
    private static amk e;
    private static String f;
    private NokiaMusicData A;
    private Context p;
    private amj.c q;
    private Context s;
    private amj.c t;
    private long x;
    public String a = "gb";
    private String g = "1.x";
    public String b = "82ff8920fd0f4ba9e2291605040b5509";
    private String h = "m59mrpHTmAuJZ5E+ugpleEtTCsqXUB4WnUi1A1Ct+qJcAn07Ykr4L6FfOBtdzP6r";
    private String i = "";
    private String j = "";
    private String k = "";
    private String l = "";
    private int m = -1;
    private boolean n = false;
    private boolean o = false;
    private boolean r = false;
    private String u = "";
    private boolean v = true;
    private int w = 1;
    public int c = 5;
    private String y = "";
    private String z = "";
    public boolean d = false;

    public enum a {
        Suceeded,
        FailedInvalidPlayer,
        FailedNetworkError,
        SkipLimitReached
    }

    public static amk a() {
        if (e == null) {
            e = new amk();
        }
        return e;
    }

    private amk() {
        mm.b("\n\n\nNokiaMusicManager()", new Object[0]);
    }

    public void b() {
        a((amj.a) this);
    }

    public void a(final amj.a aVar) {
        String strReplace;
        String string = UUID.randomUUID().toString();
        aus ausVar = new aus();
        mm.b("REFRESHTOKEN", "temp = " + (this.i != "") + " should = " + (this.i.compareTo("") != 0));
        ausVar.a("grant_type", "urn:nokia:ent:oauth:grant-type:anonid");
        ausVar.a("scope", "play_mix");
        ausVar.a("partnerdeviceid", "004402137460337");
        ausVar.a("nonce", string);
        ausVar.a("clientversion", f);
        ausVar.a("territory", this.a);
        String strReplace2 = "clientversion=" + f + "&grant_type=urn:nokia:ent:oauth:grant-type:anonid&method=post&nonce=" + string + "&partnerdeviceid=004402137460337&scope=play_mix&territory=" + this.a;
        try {
            strReplace2 = URLEncoder.encode(strReplace2, HTTP.UTF_8).replace("*", "%2A").replace("~", "%7E").replace("+", "%20").replace("%3D", "=");
            strReplace = strReplace2.replace("%26", "&");
        } catch (UnsupportedEncodingException e2) {
            strReplace = strReplace2;
            e2.printStackTrace();
        }
        String strA = ami.a(strReplace, this.h, "HmacSHA1");
        try {
            strA = auh.a(brn.a(strA.toCharArray()), 2);
        } catch (brm e3) {
            e3.printStackTrace();
        }
        String strA2 = auh.a((this.b + ":" + strA).getBytes(), 2);
        mm.b("params: " + ausVar.toString(), new Object[0]);
        aue aueVarA = agv.a(true);
        aueVarA.a("Authorization", "Basic " + strA2);
        aueVarA.b(amj.a(amj.b.Authenticate, ""), ausVar, new aum() { // from class: amk.1
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                try {
                    jSONObject.get("expires_in");
                    amk.a().i = (String) jSONObject.get("refresh_token");
                    amk.a().j = (String) jSONObject.get("access_token");
                    amk.a().k = (String) jSONObject.get("userid");
                    mm.b(jSONObject.toString(), new Object[0]);
                    aVar.a(true);
                } catch (Exception e4) {
                    mm.b("catch " + jSONObject.toString(), new Object[0]);
                    aVar.a(false);
                }
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                if (jSONObject != null) {
                    mm.b("onFailure: " + th.getMessage() + " " + jSONObject.toString(), new Object[0]);
                } else {
                    mm.b("onFailure(null): " + th.getMessage(), new Object[0]);
                }
                aVar.a(false);
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i, Header[] headerArr, String str, Throwable th) {
                mm.b("onFailure s: " + th.getMessage() + " " + str, new Object[0]);
                aVar.a(false);
            }
        });
    }

    public void a(Context context, amj.c cVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strB = b(str);
            mm.b("SESSIONS", "prev session: '" + strB + "'");
            this.y = str;
            if (strB != "") {
                this.u = strB;
                a(context);
                a(context, cVar, 0, false, false);
            } else {
                jSONObject.put("id", str);
                this.r = false;
                b(context, cVar, jSONObject.toString());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void b(final Context context, final amj.c cVar, final String str) {
        StringEntity stringEntity;
        mm.b("startPlaySession(" + str + ")", new Object[0]);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("MixRadio", 0).edit();
        try {
            editorEdit.remove("skiphistory");
            editorEdit.commit();
        } catch (Exception e2) {
            mm.b("Skip", "Restting skip history");
        }
        if (this.k == "") {
            this.l = str;
            this.p = context;
            this.m = -1;
            this.n = false;
            this.q = cVar;
            this.u = "";
            a().b();
            return;
        }
        this.l = "";
        this.p = null;
        this.m = -1;
        this.n = false;
        this.q = null;
        this.u = "";
        aue aueVarA = agv.a(true);
        aueVarA.a("Authorization", "Bearer " + this.j);
        aueVarA.a("Content-Type", "application/vnd.nokia.ent.playsessionseeds+json");
        String strA = amj.a(amj.b.StartPlay, this.k);
        if (this.v) {
            strA = strA + "?quality=high";
        }
        try {
            stringEntity = new StringEntity(str);
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
            stringEntity = null;
        }
        aueVarA.a(context, strA, stringEntity, "application/vnd.nokia.ent.playsessionseeds+json", new aum() { // from class: amk.2
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                amk.this.r = false;
                mm.b("SESSIONS", "pre store");
                amk.this.a(str, jSONObject);
                amk.this.b(context, jSONObject, false, cVar);
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                if (jSONObject != null) {
                    mm.b("onFailure: " + jSONObject.toString(), new Object[0]);
                } else {
                    mm.b("onFailure: ", new Object[0]);
                }
                if (!amk.this.r) {
                    amk.this.l = str;
                    amk.this.p = context;
                    amk.this.q = cVar;
                    amk.a().b();
                    return;
                }
                cVar.a(a.FailedNetworkError, null);
            }
        });
    }

    public void a(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("MixRadio", 0).edit();
        try {
            editorEdit.remove("skiphistory");
            editorEdit.commit();
        } catch (Exception e2) {
            mm.b("Skip", "Restting skip history");
        }
    }

    public void a(int i, boolean z, boolean z2) {
        b(this.s, this.t, i, z, z2);
    }

    public void a(final Context context, final amj.c cVar, final int i, final boolean z, final boolean z2) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        mm.b("continuePlaySession", new Object[0]);
        if (this.u == "") {
            mm.b("No session to continue", new Object[0]);
            return;
        }
        if (z) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("MixRadio", 0);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            try {
                try {
                    jSONObject = new JSONObject(sharedPreferences.getString("skiphistory", ""));
                } catch (Exception e2) {
                    jSONObject = new JSONObject();
                }
                JSONArray jSONArray2 = new JSONArray();
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = 3600000 * this.w;
                if (jSONObject.has("skiphistory")) {
                    JSONArray jSONArray3 = jSONObject.getJSONArray("skiphistory");
                    mm.b("SKIP", "skipHistory = " + jSONArray3.length() + " limit=" + this.c);
                    int i2 = 0;
                    int i3 = 0;
                    while (i3 < jSONArray3.length()) {
                        int i4 = ((Long) jSONArray3.get(i3)).longValue() + j > jCurrentTimeMillis ? i2 + 1 : i2;
                        i3++;
                        i2 = i4;
                    }
                    mm.b("SKIPCOUNT", "Skip Count In Period: " + i2);
                    if (i2 == this.c - 2) {
                        Toast.makeText(context, context.getString(R.string.MixRadioSkipLimitOneLeft_Str) + "\n" + context.getString(R.string.MixRadioSkipLimitOneLeftTip_Str, Integer.valueOf(this.c)), 1).show();
                    }
                    if (jSONArray3.length() < this.c) {
                        jSONArray3.put(jCurrentTimeMillis);
                        jSONArray = jSONArray3;
                    } else if (((Long) jSONArray3.get(0)).longValue() + j < jCurrentTimeMillis) {
                        for (int i5 = 1; i5 < jSONArray3.length(); i5++) {
                            jSONArray2.put(((Long) jSONArray3.get(i5)).longValue());
                        }
                        jSONArray2.put(jCurrentTimeMillis);
                        jSONArray = jSONArray2;
                    } else {
                        this.t.a(a.SkipLimitReached, null);
                        return;
                    }
                } else {
                    jSONArray2.put(jCurrentTimeMillis);
                    jSONArray = jSONArray2;
                }
                jSONObject.put("skiphistory", jSONArray);
                editorEdit.putString("skiphistory", jSONObject.toString());
                editorEdit.commit();
            } catch (Exception e3) {
            }
        }
        if (this.k == "") {
            this.l = "";
            this.p = context;
            this.m = i;
            this.n = z;
            this.o = z2;
            this.q = cVar;
            a().b();
            return;
        }
        this.l = "";
        this.p = null;
        this.m = -1;
        this.n = false;
        this.o = false;
        this.q = null;
        aue aueVarA = agv.a(true);
        aueVarA.a("Authorization", "Bearer " + this.j);
        aueVarA.a("Content-Type", "application/vnd.nokia.ent.playsessionseeds+json");
        String str = amj.a(amj.b.StartPlay, this.k) + "" + this.u + "/";
        String str2 = this.v ? str + "?quality=high&step=" + i : str;
        mm.b("session: " + str2, new Object[0]);
        aueVarA.a(str2, new aum() { // from class: amk.3
            @Override // defpackage.aug
            public void a() {
                mm.b("PLAYLIST", "onStart");
                super.a();
            }

            @Override // defpackage.aug
            public void b() {
                mm.b("PLAYLIST", "onFinish");
                super.b();
            }

            @Override // defpackage.aug
            public void c() {
                mm.b("PLAYLIST", "onCancel");
                super.c();
            }

            @Override // defpackage.aug
            public void a(int i6) {
                mm.b("PLAYLIST", "onRetry");
                super.a(i6);
            }

            @Override // defpackage.aum
            public void a(int i6, Header[] headerArr, JSONArray jSONArray4) {
                mm.b("PLAYLIST", "onSuccess1");
                super.a(i6, headerArr, jSONArray4);
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i6, Header[] headerArr, String str3) {
                mm.b("PLAYLIST", "onSuccess2");
                super.a(i6, headerArr, str3);
            }

            @Override // defpackage.aum
            public void a(int i6, Header[] headerArr, JSONObject jSONObject2) {
                mm.b("PLAYLIST", "onSuccess3");
                amk.this.b(context, jSONObject2, z2, cVar);
            }

            @Override // defpackage.aum
            public void a(int i6, Header[] headerArr, Throwable th, JSONArray jSONArray4) {
                mm.b("PLAYLIST", "on failure1");
                super.a(i6, headerArr, th, jSONArray4);
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i6, Header[] headerArr, String str3, Throwable th) {
                mm.b("PLAYLIST", "on failure2");
                super.a(i6, headerArr, str3, th);
            }

            @Override // defpackage.aum
            public void a(int i6, Header[] headerArr, Throwable th, JSONObject jSONObject2) {
                mm.b("PLAYLIST", "on failure3 :" + i6);
                if (jSONObject2 != null) {
                    mm.b("onFailure: " + jSONObject2.toString(), new Object[0]);
                }
                if (jSONObject2 != null && jSONObject2.has("error")) {
                    try {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("error");
                        if (jSONObject3.has("message") && jSONObject3.getString("message").compareTo("Session id does not exist.") == 0) {
                            amk.this.a(amk.this.y);
                            amk.this.a(context, cVar, amk.this.y);
                            return;
                        }
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
                if (!amk.this.r) {
                    amk.this.p = context;
                    amk.this.m = i;
                    amk.this.n = z;
                    amk.this.q = cVar;
                    amk.a().b();
                } else {
                    mm.b("Playback failed", new Object[0]);
                    cVar.a(a.FailedNetworkError, null);
                }
                amk.a().b();
            }
        });
    }

    public void b(final Context context, final amj.c cVar, final int i, final boolean z, final boolean z2) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        mm.b("continuePlaySession", new Object[0]);
        if (this.u == "") {
            mm.b("No session to continue", new Object[0]);
            return;
        }
        if (z) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("MixRadio", 0);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            try {
                try {
                    jSONObject = new JSONObject(sharedPreferences.getString("skiphistory", ""));
                } catch (Exception e2) {
                    jSONObject = new JSONObject();
                }
                JSONArray jSONArray2 = new JSONArray();
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = 3600000 * this.w;
                if (jSONObject.has("skiphistory")) {
                    JSONArray jSONArray3 = jSONObject.getJSONArray("skiphistory");
                    mm.b("SKIP", "skipHistory = " + jSONArray3.length() + " limit=" + this.c);
                    int i2 = 0;
                    int i3 = 0;
                    while (i3 < jSONArray3.length()) {
                        int i4 = ((Long) jSONArray3.get(i3)).longValue() + j > jCurrentTimeMillis ? i2 + 1 : i2;
                        i3++;
                        i2 = i4;
                    }
                    mm.b("SKIPCOUNT", "Skip Count In Period: " + i2);
                    if (i2 == this.c - 2) {
                        Toast.makeText(context, context.getString(R.string.MixRadioSkipLimitOneLeft_Str) + "\n" + context.getString(R.string.MixRadioSkipLimitOneLeftTip_Str, Integer.valueOf(this.c)), 1).show();
                    }
                    if (jSONArray3.length() < this.c) {
                        jSONArray3.put(jCurrentTimeMillis);
                        jSONArray = jSONArray3;
                    } else if (((Long) jSONArray3.get(0)).longValue() + j < jCurrentTimeMillis) {
                        for (int i5 = 1; i5 < jSONArray3.length(); i5++) {
                            jSONArray2.put(((Long) jSONArray3.get(i5)).longValue());
                        }
                        jSONArray2.put(jCurrentTimeMillis);
                        jSONArray = jSONArray2;
                    } else {
                        this.t.a(a.SkipLimitReached, null);
                        return;
                    }
                } else {
                    jSONArray2.put(jCurrentTimeMillis);
                    jSONArray = jSONArray2;
                }
                jSONObject.put("skiphistory", jSONArray);
                editorEdit.putString("skiphistory", jSONObject.toString());
                editorEdit.commit();
            } catch (Exception e3) {
            }
        }
        if (this.k == "") {
            this.l = "";
            this.p = context;
            this.m = i;
            this.n = z;
            this.o = z2;
            this.q = cVar;
            a().b();
            return;
        }
        this.l = "";
        this.p = null;
        this.m = -1;
        this.n = false;
        this.o = false;
        this.q = null;
        aue aueVarA = agv.a(true);
        aueVarA.a("Authorization", "Bearer " + this.j);
        aueVarA.a("Content-Type", "application/vnd.nokia.ent.playsessionseeds+json");
        String str = amj.a(amj.b.StartPlay, this.k) + "" + this.u + "/";
        String str2 = this.v ? str + "?quality=high&step=" + i : str;
        mm.b("session: " + str2, new Object[0]);
        aueVarA.a(str2, new aum() { // from class: amk.4
            @Override // defpackage.aug
            public void a() {
                mm.b("PLAYLIST", "onStart");
                super.a();
            }

            @Override // defpackage.aug
            public void b() {
                mm.b("PLAYLIST", "onFinish");
                super.b();
            }

            @Override // defpackage.aug
            public void c() {
                mm.b("PLAYLIST", "onCancel");
                super.c();
            }

            @Override // defpackage.aug
            public void a(int i6) {
                mm.b("PLAYLIST", "onRetry");
                super.a(i6);
            }

            @Override // defpackage.aum
            public void a(int i6, Header[] headerArr, JSONArray jSONArray4) {
                mm.b("PLAYLIST", "onSuccess1");
                super.a(i6, headerArr, jSONArray4);
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i6, Header[] headerArr, String str3) {
                mm.b("PLAYLIST", "onSuccess2");
                super.a(i6, headerArr, str3);
            }

            @Override // defpackage.aum
            public void a(int i6, Header[] headerArr, JSONObject jSONObject2) {
                mm.b("PLAYLIST", "onSuccess3");
                amk.this.a(context, jSONObject2, z2, cVar);
            }

            @Override // defpackage.aum
            public void a(int i6, Header[] headerArr, Throwable th, JSONArray jSONArray4) {
                mm.b("PLAYLIST", "on failure1");
                super.a(i6, headerArr, th, jSONArray4);
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i6, Header[] headerArr, String str3, Throwable th) {
                mm.b("PLAYLIST", "on failure2");
                super.a(i6, headerArr, str3, th);
            }

            @Override // defpackage.aum
            public void a(int i6, Header[] headerArr, Throwable th, JSONObject jSONObject2) {
                mm.b("PLAYLIST", "on failure3 :" + i6);
                if (jSONObject2 != null) {
                    mm.b("onFailure: " + jSONObject2.toString(), new Object[0]);
                }
                if (jSONObject2 != null && jSONObject2.has("error")) {
                    try {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("error");
                        if (jSONObject3.has("message") && jSONObject3.getString("message").compareTo("Session id does not exist.") == 0) {
                            amk.this.a(amk.this.y);
                            amk.this.a(context, cVar, amk.this.y);
                            return;
                        }
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
                if (!amk.this.r) {
                    amk.this.p = context;
                    amk.this.m = i;
                    amk.this.n = z;
                    amk.this.q = cVar;
                    amk.a().b();
                } else {
                    mm.b("Playback failed", new Object[0]);
                    cVar.a(a.FailedNetworkError, null);
                }
                amk.a().b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, JSONObject jSONObject, boolean z, amj.c cVar) {
        mm.b("PLAYLIST", "processPlaylist " + z);
        try {
            mm.b("play: " + jSONObject.toString(3), new Object[0]);
            if (jSONObject.has("items")) {
                JSONArray jSONArray = jSONObject.getJSONArray("items");
                if (!z) {
                    this.A = new NokiaMusicData();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        MusicData musicDataA = aml.a((JSONObject) jSONArray.get(i), "");
                        mm.b("Adding track " + i + " " + musicDataA.musicName + " " + musicDataA.songId, new Object[0]);
                        if (i == 0) {
                            this.x = musicDataA.songId;
                        }
                        this.A.a(musicDataA);
                    }
                    this.u = jSONObject.getString("id");
                    cVar.a(a.Suceeded, this.A);
                    return;
                }
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    MusicData musicDataA2 = aml.a((JSONObject) jSONArray.get(i2), "");
                    boolean z2 = false;
                    for (int i3 = 0; i3 < this.A.b(); i3++) {
                        if (this.A.a(i3).songId == musicDataA2.songId) {
                            z2 = true;
                        }
                    }
                    if (!z2) {
                        mm.b("not found track " + musicDataA2.musicName + " " + musicDataA2.songId, new Object[0]);
                        this.A.a(musicDataA2);
                    } else {
                        mm.b("found track " + musicDataA2.musicName + " " + musicDataA2.songId, new Object[0]);
                    }
                }
                this.A.f();
                return;
            }
            mm.b("Playback failed", new Object[0]);
            cVar.a(a.FailedNetworkError, null);
        } catch (JSONException e2) {
            cVar.a(a.FailedNetworkError, null);
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, JSONObject jSONObject, boolean z, amj.c cVar) {
        mm.b("PLAYLIST", "processPlaylist " + z);
        try {
            mm.b("play: " + jSONObject.toString(3), new Object[0]);
            if (jSONObject.has("items")) {
                JSONArray jSONArray = jSONObject.getJSONArray("items");
                if (!z) {
                    this.A = new NokiaMusicData();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        MusicData musicDataA = aml.a((JSONObject) jSONArray.get(i), "");
                        mm.b("Adding track " + i + " " + musicDataA.musicName + " " + musicDataA.songId, new Object[0]);
                        if (i == 0) {
                            this.x = musicDataA.songId;
                        }
                        this.A.a(musicDataA);
                    }
                    MusicPlaylistManager.a().b(this.A);
                    this.u = jSONObject.getString("id");
                    cVar.a(a.Suceeded, this.A);
                    return;
                }
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    MusicData musicDataA2 = aml.a((JSONObject) jSONArray.get(i2), "");
                    boolean z2 = false;
                    for (int i3 = 0; i3 < this.A.b(); i3++) {
                        if (this.A.a(i3).songId == musicDataA2.songId) {
                            z2 = true;
                        }
                    }
                    if (!z2) {
                        mm.b("not found track " + musicDataA2.musicName + " " + musicDataA2.songId, new Object[0]);
                        this.A.a(musicDataA2);
                    } else {
                        mm.b("found track " + musicDataA2.musicName + " " + musicDataA2.songId, new Object[0]);
                    }
                }
                return;
            }
            mm.b("Playback failed", new Object[0]);
            cVar.a(a.FailedNetworkError, null);
        } catch (JSONException e2) {
            cVar.a(a.FailedNetworkError, null);
            e2.printStackTrace();
        }
    }

    protected void a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        mm.b("SESSIONS", "storeSessionID");
        if (jSONObject != null && jSONObject.has("id")) {
            try {
                JSONObject jSONObject4 = new JSONObject(str);
                if (jSONObject4.has("id") && jSONObject.has("id")) {
                    SharedPreferences sharedPreferences = this.s.getSharedPreferences("MixRadio", 0);
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    String string = sharedPreferences.getString("sessionhistory", "");
                    if (string != "") {
                        jSONObject2 = new JSONObject(string);
                    } else {
                        jSONObject2 = new JSONObject();
                    }
                    if (jSONObject2.has("sessionhistory")) {
                        jSONObject3 = jSONObject2.getJSONObject("sessionhistory");
                    } else {
                        jSONObject3 = new JSONObject();
                    }
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("timestamp", System.currentTimeMillis());
                    jSONObject5.put("sessionID", jSONObject.get("id"));
                    jSONObject3.put(jSONObject4.getString("id"), jSONObject5);
                    jSONObject2.put("sessionhistory", jSONObject3);
                    mm.b("SESSIONS", "Stored Play Session: " + jSONObject2.toString(3));
                    editorEdit.putString("sessionhistory", jSONObject2.toString());
                    editorEdit.commit();
                }
            } catch (Exception e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            SharedPreferences sharedPreferences = this.s.getSharedPreferences("MixRadio", 0);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            JSONObject jSONObject = new JSONObject(sharedPreferences.getString("sessionhistory", ""));
            JSONObject jSONObject2 = jSONObject.getJSONObject("sessionhistory");
            if (jSONObject2.has(str)) {
                jSONObject2.remove(str);
            }
            editorEdit.putString("sessionhistory", jSONObject.toString());
            editorEdit.commit();
        } catch (Exception e2) {
        }
    }

    private String b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(this.s.getSharedPreferences("MixRadio", 0).getString("sessionhistory", "")).getJSONObject("sessionhistory");
            if (jSONObject.has(str)) {
                return jSONObject.getJSONObject(str).getString("sessionID");
            }
        } catch (Exception e2) {
        }
        return "";
    }

    @Override // amj.a
    public void a(boolean z) {
        Object[] objArr = new Object[1];
        objArr[0] = "Connection complete: " + z + " retry: " + this.l + " context: " + (this.p != null) + " step: " + this.m;
        mm.b("ConnectionMM", objArr);
        if (z) {
            this.r = true;
            if (this.l != "" && this.p != null) {
                mm.b("ConnectionMM", "Connection complete: " + z + " startPlaySession");
                b(this.p, this.q, this.l);
                return;
            } else {
                if (this.m != -1 && this.p != null) {
                    mm.b("ConnectionMM", "Connection complete: " + z + " continuePlaySession");
                    a(this.p, this.q, this.m, this.n, this.o);
                    return;
                }
                return;
            }
        }
        if (this.p != null && this.q != null) {
            this.q.a(a.FailedNetworkError, null);
        }
    }
}
