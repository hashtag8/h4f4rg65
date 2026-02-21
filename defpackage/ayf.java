package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.musicservice.mixradio.model.MixRadioAdvertData;
import com.musicservice.mixradio.model.MixRadioMusicData;
import defpackage.ayg;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ayf implements ayg.a {
    private static ayf i;
    private static String j;
    private static String k;
    private long C;
    private MusicPlaylistManager D;
    private MixRadioMusicData I;
    private JSONObject J;
    ayd h;
    private Context r;
    private ayg.d s;
    private ayg.b w;
    private Context x;
    private ayg.d y;
    public String a = "";
    private String l = "1.x";
    public String b = "0221670922937fe58ebfd63d319fb05d";
    private String m = "wwS5/s7CzR49TmrPGbcXKiPI0kACy/1i0w21/48ZJPhg990eiAqL//U87RUxWjMK";
    public String c = "";
    public String d = "";
    public String e = "";
    private String n = "";
    private int o = -1;
    private boolean p = false;
    private boolean q = false;
    private boolean t = false;
    private String u = "";
    private Boolean v = false;
    private String z = "";
    private boolean A = true;
    private int B = 1;
    public int f = 5;
    private String E = "";
    private String F = "";
    public boolean g = false;
    private boolean G = true;
    private boolean H = true;

    public enum a {
        Availability,
        FeaturedMixes,
        MixGroupsByCategory,
        MixGroupsByGenre,
        MixesInGroup,
        GetMix,
        ArtistSearch,
        Search,
        SimilarArtists,
        GenreArtists,
        Favourite,
        CatArtists,
        RecentMixes,
        TasteGenre,
        FetchArtist,
        Me
    }

    public enum b {
        Suceeded,
        FailedInvalidPlayer,
        FailedNetworkError,
        SkipLimitReached
    }

    public static ayf a() {
        if (i == null) {
            i = new ayf();
        }
        return i;
    }

    private ayf() {
        mm.b("MixRadioMusicManager()", new Object[0]);
    }

    public void a(String str, String str2, Context context, ayg.d dVar) {
        j = str;
        k = str2;
        this.y = dVar;
        this.x = context;
        this.D = MusicPlaylistManager.a();
        this.g = false;
        if (this.a.compareTo("") == 0 && bru.b(aho.d("mixradio_country"))) {
            this.a = aho.d("mixradio_country");
        }
    }

    public void b() {
        a((ayg.a) this, "");
    }

    public void a(final ayg.a aVar, String str) {
        aus ausVar = new aus();
        ((WifiManager) this.x.getSystemService("wifi")).getConnectionInfo();
        if (this.c.compareTo("") != 0) {
            ausVar.a("grant_type", "refresh_token");
            ausVar.a("refresh_token", "" + this.c);
        } else {
            if (str.compareTo("") == 0 && this.x != null) {
                SharedPreferences sharedPreferences = this.x.getSharedPreferences("MixRadio", 0);
                if (sharedPreferences.getString("mixradio_auth", "").compareTo("") != 0) {
                    str = sharedPreferences.getString("mixradio_auth", "");
                }
            }
            ausVar.a("grant_type", "authorization_code");
            ausVar.a("code", str);
            ausVar.a("client_id", this.b);
            ausVar.a("client_secret", this.m);
        }
        ausVar.a("clientversion", k);
        ausVar.a("territory", this.a);
        aue aueVarA = agv.a(true);
        aueVarA.a("Content-Type", "application/x-www-form-urlencoded");
        aueVarA.b(ayg.a(ayg.c.Authenticate, ""), ausVar, new aum() { // from class: ayf.1
            @Override // defpackage.aum
            public void a(int i2, Header[] headerArr, JSONObject jSONObject) {
                try {
                    ayf.a().c = (String) jSONObject.get("refresh_token");
                    ayf.a().d = (String) jSONObject.get("access_token");
                    ayf.a().e = (String) jSONObject.get("userid");
                    if (jSONObject.has("territory") && ayf.a().a.compareTo("") == 0) {
                        ayf.a().a = jSONObject.optString("territory");
                        if (ayf.this.x != null) {
                            aho.a("mixradio_country", ayf.this.a);
                        }
                    }
                    aVar.a(true);
                } catch (Exception e) {
                    aVar.a(false);
                }
            }

            @Override // defpackage.aum
            public void a(int i2, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                if (jSONObject != null) {
                    mm.e("authenticate onFailure: " + th.getMessage() + " " + jSONObject.toString(), new Object[0]);
                } else {
                    mm.e("authenticate onFailure(null): " + th.getMessage(), new Object[0]);
                }
                aVar.a(false);
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i2, Header[] headerArr, String str2, Throwable th) {
                mm.e("authenticate onFailure s: " + th.getMessage() + " " + str2, new Object[0]);
                aVar.a(false);
            }
        });
    }

    public void a(a aVar, ayg.b bVar) {
        a(aVar, bVar, "");
    }

    public void a(a aVar, ayg.b bVar, String str) {
        a(aVar, bVar, str, -1, -1);
    }

    public void a(final a aVar, final ayg.b bVar, final String str, int i2, int i3) {
        ayg.c cVar;
        String str2;
        if (aVar == a.MixGroupsByCategory) {
            cVar = ayg.c.MixGroupsByCategory;
            str2 = str;
        } else if (aVar == a.MixGroupsByGenre) {
            cVar = ayg.c.MixGroupsByGenre;
            str2 = str;
        } else if (aVar == a.FeaturedMixes) {
            cVar = ayg.c.FeaturedMixes;
            str2 = str;
        } else if (aVar == a.MixesInGroup) {
            cVar = ayg.c.MixesInGroup;
            str2 = str;
        } else if (aVar == a.ArtistSearch) {
            cVar = ayg.c.ArtistSearch;
            str2 = str;
        } else if (aVar == a.Search) {
            cVar = ayg.c.Search;
            str2 = str;
        } else if (aVar == a.SimilarArtists) {
            cVar = ayg.c.SimilarArtists;
            str2 = str;
        } else if (aVar == a.GenreArtists) {
            cVar = ayg.c.GenreArtists;
            str2 = str;
        } else if (aVar == a.CatArtists) {
            cVar = ayg.c.CatArtists;
            str2 = str;
        } else if (aVar == a.RecentMixes) {
            ayg.c cVar2 = ayg.c.RecentMixes;
            str2 = this.e;
            cVar = cVar2;
        } else if (aVar == a.TasteGenre) {
            cVar = ayg.c.TasteGenre;
            str2 = str;
        } else if (aVar == a.FetchArtist) {
            cVar = ayg.c.FetchArtist;
            str2 = str;
        } else if (aVar == a.Me) {
            cVar = ayg.c.Me;
            str2 = str;
        } else {
            cVar = ayg.c.Status;
            str2 = str;
        }
        mm.b("QUERYMIXRADIO", "About to call " + cVar);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        ayg.a(cVar, str2, null, i2, i3, new aum() { // from class: ayf.4
            @Override // defpackage.aum
            public void a(int i4, Header[] headerArr, JSONObject jSONObject) {
                if (aVar == a.FeaturedMixes || aVar == a.MixesInGroup) {
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("skipsallowed");
                        ayf.this.B = ((Integer) jSONObject2.get("periodinhours")).intValue();
                        ayf.this.f = ((Integer) jSONObject2.get("maxskips")).intValue();
                        mm.b("SKIP", "SkipLimit: " + ayf.this.f);
                    } catch (Exception e) {
                        mm.b("SKIP", e.toString());
                    }
                }
                if (aVar == a.Search || aVar == a.SimilarArtists || aVar == a.ArtistSearch || aVar == a.GenreArtists || aVar == a.TasteGenre || aVar == a.FetchArtist) {
                    try {
                        jSONObject.put("time_sent", jCurrentTimeMillis);
                        mm.b("debugreponse", jSONObject.toString());
                        if (bVar != null) {
                            bVar.a(aVar, jSONObject, str);
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        mm.b("SEARCH", e2.toString());
                        return;
                    }
                }
                if (bVar != null) {
                    bVar.a(aVar, jSONObject, str);
                }
            }

            @Override // defpackage.aum
            public void a(int i4, Header[] headerArr, JSONArray jSONArray) {
                if (bVar != null) {
                    bVar.a(aVar, jSONArray);
                }
            }

            @Override // defpackage.aum
            public void a(int i4, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                if (aVar == a.Availability && jSONObject != null) {
                    if (bVar != null) {
                        bVar.a(aVar, jSONObject, str);
                        return;
                    }
                    return;
                }
                String str3 = "";
                if (jSONObject != null) {
                    str3 = "Error with JSONObject " + jSONObject.toString();
                    mm.e("response statuscode = " + i4 + "  " + jSONObject.toString(), new Object[0]);
                } else {
                    mm.e("response is null, statuscode = " + i4, new Object[0]);
                }
                if (bVar != null) {
                    bVar.a(aVar, str3);
                }
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i4, Header[] headerArr, String str3, Throwable th) {
                if (bVar != null) {
                    bVar.a(aVar, "Error with String " + i4);
                }
            }
        });
    }

    public void a(Context context, ayg.d dVar, String str) {
        this.E = str;
        JSONObject jSONObject = new JSONObject();
        try {
            String strC = c(str);
            this.E = str;
            if (strC.compareTo("") != 0) {
                this.z = strC;
                a(context);
                a(context, dVar, 0, false, false);
            } else {
                new JSONObject().put("id", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("mode", "preview");
                jSONObject2.put("manufacturer", "" + Build.MANUFACTURER);
                jSONObject2.put("platform", "android");
                jSONObject2.put("idfa", "" + Settings.Secure.getString(context.getContentResolver(), "android_id"));
                jSONObject.put("adparams", jSONObject2);
                jSONObject.put("id", str);
                this.t = false;
                b(context, dVar, jSONObject.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void a(Context context, ayg.d dVar, String[] strArr) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (String str : strArr) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", str);
                jSONObject2.put("type", "musicartist");
                jSONArray.put(jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        jSONObject.put("seeds", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("mode", "preview");
        jSONObject3.put("manufacturer", "" + Build.MANUFACTURER);
        jSONObject3.put("platform", "android");
        jSONObject3.put("idfa", "" + Settings.Secure.getString(context.getContentResolver(), "android_id"));
        jSONObject.put("adparams", jSONObject3);
        this.t = false;
        b(context, dVar, jSONObject.toString());
    }

    public void a(Context context, ayg.d dVar) {
        b(context, dVar, new String[]{this.e});
    }

    public void b(Context context, ayg.d dVar, String[] strArr) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (String str : strArr) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", str);
                jSONObject2.put("type", "user");
                jSONArray.put(jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        jSONObject.put("seeds", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("mode", "preview");
        jSONObject3.put("manufacturer", "" + Build.MANUFACTURER);
        jSONObject3.put("platform", "android");
        jSONObject3.put("idfa", "" + Settings.Secure.getString(context.getContentResolver(), "android_id"));
        jSONObject.put("adparams", jSONObject3);
        this.t = false;
        b(context, dVar, jSONObject.toString());
    }

    public void a(final ayg.b bVar) {
        agv.a(true).a("http://api.mixrad.io/1.x/?domain=music&usecallerip=true&client_id=" + this.b, new aum() { // from class: ayf.5
            @Override // defpackage.aum
            public void a(int i2, Header[] headerArr, JSONObject jSONObject) {
                mm.b("Got " + jSONObject, new Object[0]);
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("items");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() < 1) {
                    a(-1, (Header[]) null, (Throwable) null, jSONObject);
                    return;
                }
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
                if (jSONObjectOptJSONObject == null) {
                    a(-1, (Header[]) null, (Throwable) null, jSONObject);
                    return;
                }
                ayf.a().a = jSONObjectOptJSONObject.optString("territory");
                if (bVar != null) {
                    bVar.a(a.Availability, jSONObject, "");
                }
            }

            @Override // defpackage.aum
            public void a(int i2, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                if (bVar != null) {
                    bVar.a(a.Availability, "" + i2);
                }
                if (jSONObject != null) {
                    mm.e("Got onFailure: " + jSONObject.toString(), new Object[0]);
                } else {
                    mm.e("Got onFailure: ", new Object[0]);
                }
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i2, Header[] headerArr, String str, Throwable th) {
                mm.e("Got failure " + str, new Object[0]);
                if (bVar != null) {
                    bVar.a(a.Availability, "" + i2);
                }
            }
        });
    }

    public void b(final ayg.b bVar) {
        aue aueVarA = agv.a(true);
        aueVarA.a("Authorization", "Bearer " + this.d);
        aueVarA.a(ayg.a(ayg.c.Me, ""), new aum() { // from class: ayf.6
            @Override // defpackage.aum
            public void a(int i2, Header[] headerArr, JSONObject jSONObject) {
                mm.b("Got " + jSONObject, new Object[0]);
                if (bVar != null) {
                    bVar.a(a.Me, jSONObject, "");
                }
            }

            @Override // defpackage.aum
            public void a(int i2, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                if (bVar != null) {
                    bVar.a(a.Me, "" + i2);
                }
                if (jSONObject != null) {
                    mm.e("Got onFailure: " + jSONObject.toString(), new Object[0]);
                } else {
                    mm.e("Got onFailure: ", new Object[0]);
                }
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i2, Header[] headerArr, String str, Throwable th) {
                mm.e("Got failure " + str, new Object[0]);
                if (bVar != null) {
                    bVar.a(a.Me, "" + i2);
                }
            }
        });
    }

    public void a(String str, Boolean bool, final ayg.b bVar) {
        mm.b("favouriteArtist " + str, new Object[0]);
        if (this.e.compareTo("") == 0) {
            this.u = str;
            this.v = bool;
            this.w = bVar;
            a().b();
            return;
        }
        this.n = "";
        this.r = null;
        this.o = -1;
        this.p = false;
        this.s = null;
        this.u = "";
        this.v = false;
        this.w = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userid", this.e);
            jSONObject.put("artistid", str);
            jSONObject.put("relationtype", bool.booleanValue() ? "favourite" : "unfavourite");
            aue aueVarA = agv.a(true);
            aueVarA.a("Authorization", "Bearer " + this.d);
            aueVarA.a("Content-Type", "application/vnd.nokia.ent.playsessionseeds+json");
            aueVarA.b(ayg.a(ayg.c.FavouriteWrite, jSONObject.toString()), new aum() { // from class: ayf.7
                @Override // defpackage.aum
                public void a(int i2, Header[] headerArr, JSONObject jSONObject2) {
                    if (bVar != null) {
                        bVar.a(a.Favourite, jSONObject2, "");
                    }
                }

                @Override // defpackage.aum
                public void a(int i2, Header[] headerArr, Throwable th, JSONObject jSONObject2) {
                    if (bVar != null) {
                        bVar.a(a.Favourite, "Error with String");
                    }
                }

                @Override // defpackage.aum, defpackage.aux
                public void a(int i2, Header[] headerArr, String str2, Throwable th) {
                    if (bVar != null) {
                        bVar.a(a.Favourite, "Error with String");
                    }
                }
            });
        } catch (Exception e) {
            if (bVar != null) {
                bVar.a(a.Favourite, "Failed to map favourites to JSON");
            }
        }
    }

    public void c(final ayg.b bVar) {
        aue aueVarA = agv.a(true);
        aueVarA.a("Authorization", "Bearer " + this.d);
        aueVarA.a("Content-Type", "application/vnd.nokia.ent.playsessionseeds+json");
        aueVarA.a(ayg.a(ayg.c.FavouriteRead, this.e, 0, 20), new aum() { // from class: ayf.8
            @Override // defpackage.aum
            public void a(int i2, Header[] headerArr, JSONObject jSONObject) {
                if (bVar != null) {
                    bVar.a(a.Favourite, jSONObject, "");
                }
            }

            @Override // defpackage.aum
            public void a(int i2, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                if (bVar != null) {
                    bVar.a(a.Favourite, "Error with String " + i2);
                }
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i2, Header[] headerArr, String str, Throwable th) {
                if (bVar != null) {
                    bVar.a(a.Favourite, "Error with String" + i2);
                }
            }
        });
    }

    private void b(final Context context, final ayg.d dVar, final String str) {
        StringEntity stringEntity;
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("MixRadio", 0).edit();
        try {
            editorEdit.remove("skiphistory");
            editorEdit.commit();
        } catch (Exception e) {
            mm.e("Restting skip history", new Object[0]);
        }
        if (this.e.compareTo("") == 0) {
            this.n = str;
            this.r = context;
            this.o = -1;
            this.p = false;
            this.s = dVar;
            this.z = "";
            a().b();
            return;
        }
        this.n = "";
        this.r = null;
        this.o = -1;
        this.p = false;
        this.s = null;
        this.z = "";
        aue aueVar = new aue(true, 80, 443);
        aueVar.a(mq.b());
        aueVar.a("Authorization", "Bearer " + this.d);
        aueVar.a("Content-Type", "application/vnd.nokia.ent.playsessionseeds+json");
        String strA = ayg.a(ayg.c.StartPlay, this.e);
        if (this.A) {
            strA = strA + "?quality=high";
        }
        try {
            stringEntity = new StringEntity(str);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            stringEntity = null;
        }
        aueVar.a(context, strA, stringEntity, "application/vnd.nokia.ent.playsessionseeds+json", new aum() { // from class: ayf.9
            @Override // defpackage.aum
            public void a(int i2, Header[] headerArr, JSONObject jSONObject) {
                ayf.this.t = false;
                ayf.this.a(str, jSONObject);
                try {
                    ayf.this.a(new JSONObject(str.toString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                ayf.this.b(context, jSONObject, false, dVar);
            }

            @Override // defpackage.aum
            public void a(int i2, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                if (!ayf.this.t) {
                    ayf.this.n = str;
                    ayf.this.r = context;
                    ayf.this.s = dVar;
                    ayf.a().b();
                    return;
                }
                if (dVar != null) {
                    dVar.a(b.FailedNetworkError, null);
                }
            }
        });
    }

    public void a(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("MixRadio", 0).edit();
        try {
            editorEdit.remove("skiphistory");
            editorEdit.commit();
        } catch (Exception e) {
            mm.b("Skip", "Restting skip history");
        }
    }

    public boolean c() {
        JSONObject jSONObject;
        JSONArray jSONArrayOptJSONArray;
        try {
            jSONObject = new JSONObject(this.x.getSharedPreferences("MixRadio", 0).getString("skiphistory", ""));
        } catch (Exception e) {
            jSONObject = new JSONObject();
        }
        new JSONArray();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = 3600000 * this.B;
        if (!jSONObject.has("skiphistory") || (jSONArrayOptJSONArray = jSONObject.optJSONArray("skiphistory")) == null) {
            return true;
        }
        mm.b("SKIP", "skipHistory = " + jSONArrayOptJSONArray.length() + " limit=" + this.f);
        int i2 = 0;
        for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
            long jLongValue = ((Long) jSONArrayOptJSONArray.opt(i3)).longValue();
            if (jLongValue == 0) {
                return true;
            }
            if (jLongValue + j2 > jCurrentTimeMillis) {
                i2++;
            }
        }
        mm.b("Skip Count In Period: " + i2, new Object[0]);
        return i2 < this.f;
    }

    public void d() {
        Toast.makeText(this.x, String.format(this.x.getResources().getString(R.string.MixRadioSkipLimitTip_Str), Integer.valueOf(this.f)), 0).show();
    }

    public void a(int i2, boolean z, boolean z2) {
        a(this.x, this.y, i2, z, z2);
    }

    public void b(int i2, boolean z, boolean z2) {
        b(this.x, this.y, i2, z, z2);
    }

    public void a(final Context context, final ayg.d dVar, final int i2, final boolean z, final boolean z2) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        if (this.z.compareTo("") == 0) {
            mm.e("No session to continue", new Object[0]);
            return;
        }
        if (z) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("MixRadio", 0);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            try {
                try {
                    jSONObject = new JSONObject(sharedPreferences.getString("skiphistory", ""));
                } catch (Exception e) {
                    jSONObject = new JSONObject();
                }
                JSONArray jSONArray2 = new JSONArray();
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j2 = 3600000 * this.B;
                if (jSONObject.has("skiphistory")) {
                    JSONArray jSONArray3 = jSONObject.getJSONArray("skiphistory");
                    mm.b("skipHistory = " + jSONArray3.length() + " limit=" + this.f, new Object[0]);
                    int i3 = 0;
                    int i4 = 0;
                    while (i4 < jSONArray3.length()) {
                        int i5 = ((Long) jSONArray3.get(i4)).longValue() + j2 > jCurrentTimeMillis ? i3 + 1 : i3;
                        i4++;
                        i3 = i5;
                    }
                    mm.b("Skip Count In Period: " + i3, new Object[0]);
                    if (i3 == this.f - 2) {
                        Toast.makeText(context, String.format(this.x.getResources().getString(R.string.MixRadioSkipLimitOneLeft_Str), Integer.valueOf(this.f)), 1).show();
                    }
                    if (jSONArray3.length() < this.f) {
                        jSONArray3.put(jCurrentTimeMillis);
                        jSONArray = jSONArray3;
                    } else if (((Long) jSONArray3.get(0)).longValue() + j2 < jCurrentTimeMillis) {
                        for (int i6 = 1; i6 < jSONArray3.length(); i6++) {
                            jSONArray2.put(((Long) jSONArray3.get(i6)).longValue());
                        }
                        jSONArray2.put(jCurrentTimeMillis);
                        jSONArray = jSONArray2;
                    } else {
                        if (this.y != null) {
                            this.y.a(b.SkipLimitReached, null);
                            return;
                        }
                        return;
                    }
                } else {
                    jSONArray2.put(jCurrentTimeMillis);
                    jSONArray = jSONArray2;
                }
                jSONObject.put("skiphistory", jSONArray);
                editorEdit.putString("skiphistory", jSONObject.toString());
                editorEdit.commit();
            } catch (Exception e2) {
                mm.e(e2.toString(), new Object[0]);
            }
        }
        if (this.e.compareTo("") == 0) {
            this.n = "";
            this.r = context;
            this.o = i2;
            this.p = z;
            this.q = z2;
            this.s = dVar;
            a().b();
            return;
        }
        this.n = "";
        this.r = null;
        this.o = -1;
        this.p = false;
        this.q = false;
        this.s = null;
        aue aueVarA = agv.a(true);
        aueVarA.a("Authorization", "Bearer " + this.d);
        aueVarA.a("Content-Type", "application/vnd.nokia.ent.playsessionseeds+json");
        String str = ayg.a(ayg.c.StartPlay, this.e) + "" + this.z + "/";
        aueVarA.a(this.A ? str + "?quality=high&step=" + i2 : str, new aum() { // from class: ayf.10
            @Override // defpackage.aum
            public void a(int i7, Header[] headerArr, JSONObject jSONObject2) {
                ayf.this.b(context, jSONObject2, z2, dVar);
            }

            @Override // defpackage.aum
            public void a(int i7, Header[] headerArr, Throwable th, JSONObject jSONObject2) {
                if (jSONObject2 != null && jSONObject2.has("error")) {
                    try {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("error");
                        if (jSONObject3.has("message") && jSONObject3.getString("message").compareTo("Session id does not exist.") == 0) {
                            ayf.this.b(ayf.this.E);
                            ayf.this.a(context, dVar, ayf.this.E);
                            return;
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                if (!ayf.this.t) {
                    ayf.this.r = context;
                    ayf.this.o = i2;
                    ayf.this.p = z;
                    ayf.this.s = dVar;
                } else if (dVar != null) {
                    dVar.a(b.FailedNetworkError, null);
                }
                ayf.a().b();
            }
        });
    }

    public void b(final Context context, final ayg.d dVar, final int i2, final boolean z, final boolean z2) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        if (this.z.compareTo("") == 0) {
            mm.b("No session to continue", new Object[0]);
            return;
        }
        if (z) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("MixRadio", 0);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            try {
                try {
                    jSONObject = new JSONObject(sharedPreferences.getString("skiphistory", ""));
                } catch (Exception e) {
                    jSONObject = new JSONObject();
                }
                JSONArray jSONArray2 = new JSONArray();
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j2 = 3600000 * this.B;
                if (jSONObject.has("skiphistory")) {
                    JSONArray jSONArray3 = jSONObject.getJSONArray("skiphistory");
                    mm.e("skipHistory = " + jSONArray3.length() + " limit=" + this.f, new Object[0]);
                    int i3 = 0;
                    int i4 = 0;
                    while (i4 < jSONArray3.length()) {
                        int i5 = ((Long) jSONArray3.get(i4)).longValue() + j2 > jCurrentTimeMillis ? i3 + 1 : i3;
                        i4++;
                        i3 = i5;
                    }
                    mm.e("Skip Count In Period: " + i3, new Object[0]);
                    if (i3 == this.f - 2) {
                        Toast.makeText(context, String.format(this.x.getResources().getString(R.string.MixRadioSkipLimitOneLeftTip_Str), Integer.valueOf(this.f)), 1).show();
                    }
                    if (jSONArray3.length() < this.f) {
                        jSONArray3.put(jCurrentTimeMillis);
                        jSONArray = jSONArray3;
                    } else if (((Long) jSONArray3.get(0)).longValue() + j2 < jCurrentTimeMillis) {
                        for (int i6 = 1; i6 < jSONArray3.length(); i6++) {
                            jSONArray2.put(((Long) jSONArray3.get(i6)).longValue());
                        }
                        jSONArray2.put(jCurrentTimeMillis);
                        jSONArray = jSONArray2;
                    } else {
                        if (this.y != null) {
                            this.y.a(b.SkipLimitReached, null);
                            return;
                        }
                        return;
                    }
                } else {
                    jSONArray2.put(jCurrentTimeMillis);
                    jSONArray = jSONArray2;
                }
                jSONObject.put("skiphistory", jSONArray);
                editorEdit.putString("skiphistory", jSONObject.toString());
                editorEdit.commit();
            } catch (Exception e2) {
            }
        }
        if (this.e.compareTo("") == 0) {
            this.n = "";
            this.r = context;
            this.o = i2;
            this.p = z;
            this.q = z2;
            this.s = dVar;
            a().b();
            return;
        }
        this.n = "";
        this.r = null;
        this.o = -1;
        this.p = false;
        this.q = false;
        this.s = null;
        aue aueVarA = agv.a(true);
        aueVarA.a("Authorization", "Bearer " + this.d);
        aueVarA.a("Content-Type", "application/vnd.nokia.ent.playsessionseeds+json");
        String str = ayg.a(ayg.c.StartPlay, this.e) + "" + this.z + "/";
        aueVarA.a(this.A ? str + "?quality=high&step=" + i2 : str, new aum() { // from class: ayf.11
            @Override // defpackage.aum
            public void a(int i7, Header[] headerArr, JSONObject jSONObject2) {
                ayf.this.a(context, jSONObject2, z2, dVar);
            }

            @Override // defpackage.aum
            public void a(int i7, Header[] headerArr, Throwable th, JSONObject jSONObject2) {
                if (jSONObject2 != null && jSONObject2.has("error")) {
                    try {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("error");
                        if (jSONObject3.has("message") && jSONObject3.getString("message").compareTo("Session id does not exist.") == 0) {
                            ayf.this.b(ayf.this.E);
                            ayf.this.a(context, dVar, ayf.this.E);
                            return;
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                if (!ayf.this.t) {
                    ayf.this.r = context;
                    ayf.this.o = i2;
                    ayf.this.p = z;
                    ayf.this.s = dVar;
                    ayf.a().b();
                } else if (dVar != null) {
                    dVar.a(b.FailedNetworkError, null);
                }
                ayf.a().b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, JSONObject jSONObject, boolean z, ayg.d dVar) {
        boolean z2;
        try {
            if (jSONObject.has("items")) {
                JSONArray jSONArray = jSONObject.getJSONArray("items");
                if (!z) {
                    mm.b("MIXRADIO_DEBUG reset mixRadioMusicData", new Object[0]);
                    this.I = new MixRadioMusicData();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        MusicData musicDataA = axz.a((JSONObject) jSONArray.get(i2), "");
                        mm.b("Adding track " + i2 + " " + musicDataA.musicName + " " + musicDataA.songId, new Object[0]);
                        if (i2 == 0) {
                            this.C = musicDataA.songId;
                        }
                        this.I.a(musicDataA);
                    }
                    this.z = jSONObject.getString("id");
                    if (dVar != null) {
                        dVar.a(b.Suceeded, this.I);
                        return;
                    }
                    return;
                }
                boolean z3 = true;
                int i3 = 0;
                while (i3 < jSONArray.length()) {
                    MusicData musicDataA2 = axz.a((JSONObject) jSONArray.get(i3), "");
                    mm.b("MIXRADIO_DEBUG new track " + i3 + " is " + musicDataA2.musicName, new Object[0]);
                    boolean z4 = false;
                    for (int i4 = 0; i4 < this.I.b(); i4++) {
                        mm.b("MIXRADIO_DEBUG existing track " + i4 + " is " + this.I.a(i4).musicName, new Object[0]);
                        if (this.I.a(i4).songId == musicDataA2.songId) {
                            z4 = true;
                        }
                    }
                    if (i3 == 0 && (musicDataA2 instanceof MixRadioAdvertData)) {
                        this.I.a(this.I.e() + 1, musicDataA2);
                        z2 = false;
                    } else if (!z4) {
                        mm.b("not found track " + musicDataA2.musicName + " " + musicDataA2.songId, new Object[0]);
                        this.I.a(musicDataA2);
                        z2 = false;
                    } else {
                        mm.b("found track " + musicDataA2.musicName + " " + musicDataA2.songId, new Object[0]);
                        z2 = z3;
                    }
                    i3++;
                    z3 = z2;
                }
                this.I.f();
                if (z3) {
                    a(context, jSONObject, false, dVar);
                    return;
                }
                return;
            }
            mm.e("Playback failed", new Object[0]);
            if (dVar != null) {
                dVar.a(b.FailedNetworkError, null);
            }
        } catch (JSONException e) {
            if (dVar != null) {
                dVar.a(b.FailedNetworkError, null);
            }
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, JSONObject jSONObject, boolean z, ayg.d dVar) {
        boolean z2;
        try {
            if (jSONObject.has("items")) {
                JSONArray jSONArray = jSONObject.getJSONArray("items");
                if (!z) {
                    mm.b("MIXRADIO_DEBUG reset mixRadioMusicData", new Object[0]);
                    this.I = new MixRadioMusicData();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        MusicData musicDataA = axz.a((JSONObject) jSONArray.get(i2), "");
                        mm.b("Adding track " + i2 + " " + musicDataA.musicName + " " + musicDataA.songId, new Object[0]);
                        if (i2 == 0) {
                            this.C = musicDataA.songId;
                        }
                        this.I.a(musicDataA);
                    }
                    this.z = jSONObject.getString("id");
                    if (dVar != null) {
                        dVar.a(b.Suceeded, this.I);
                        return;
                    }
                    return;
                }
                boolean z3 = true;
                int i3 = 0;
                while (i3 < jSONArray.length()) {
                    MusicData musicDataA2 = axz.a((JSONObject) jSONArray.get(i3), "");
                    mm.b("MIXRADIO_DEBUG new track " + i3 + " is " + musicDataA2.musicName, new Object[0]);
                    boolean z4 = false;
                    for (int i4 = 0; i4 < this.I.b(); i4++) {
                        mm.b("MIXRADIO_DEBUG existing track " + i4 + " is " + this.I.a(i4).musicName, new Object[0]);
                        if (this.I.a(i4).songId == musicDataA2.songId) {
                            z4 = true;
                        }
                    }
                    if (i3 == 0 && (musicDataA2 instanceof MixRadioAdvertData)) {
                        this.I.a(this.I.e() + 1, musicDataA2);
                        z2 = false;
                    } else if (!z4) {
                        z2 = false;
                        mm.b("not found track " + musicDataA2.musicName + " " + musicDataA2.songId, new Object[0]);
                        this.I.a(musicDataA2);
                    } else {
                        mm.b("found track " + musicDataA2.musicName + " " + musicDataA2.songId, new Object[0]);
                        z2 = z3;
                    }
                    i3++;
                    z3 = z2;
                }
                if (z3) {
                    b(context, jSONObject, false, dVar);
                    return;
                }
                return;
            }
            mm.e("Playback failed", new Object[0]);
            if (dVar != null) {
                dVar.a(b.FailedNetworkError, null);
            }
        } catch (JSONException e) {
            if (dVar != null) {
                dVar.a(b.FailedNetworkError, null);
            }
            e.printStackTrace();
        }
    }

    protected void a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        if (jSONObject == null || !jSONObject.has("id")) {
            mm.e("bailing", new Object[0]);
            return;
        }
        this.F = jSONObject.optString("id", "");
        try {
            JSONObject jSONObject4 = new JSONObject(str);
            if (jSONObject4.has("id") && jSONObject.has("id")) {
                SharedPreferences sharedPreferences = this.x.getSharedPreferences("MixRadio", 0);
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
                mm.b("Stored Play Session: " + jSONObject2.toString(3), new Object[0]);
                editorEdit.putString("sessionhistory", jSONObject2.toString());
                editorEdit.commit();
            }
        } catch (Exception e) {
            mm.e(e.toString(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        try {
            SharedPreferences sharedPreferences = this.x.getSharedPreferences("MixRadio", 0);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            JSONObject jSONObject = new JSONObject(sharedPreferences.getString("sessionhistory", ""));
            JSONObject jSONObject2 = jSONObject.getJSONObject("sessionhistory");
            if (jSONObject2.has(str)) {
                jSONObject2.remove(str);
            }
            editorEdit.putString("sessionhistory", jSONObject.toString());
            editorEdit.commit();
        } catch (Exception e) {
        }
    }

    private String c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(this.x.getSharedPreferences("MixRadio", 0).getString("sessionhistory", "")).getJSONObject("sessionhistory");
            if (jSONObject.has(str)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                this.F = jSONObject2.optString("sessionID", "");
                return jSONObject2.getString("sessionID");
            }
        } catch (Exception e) {
            mm.e(e.toString(), new Object[0]);
        }
        return "";
    }

    @Override // ayg.a
    public void a(boolean z) {
        mm.b("Connection complete: " + z + " retry: " + this.n + " context: " + (this.r != null) + " step: " + this.o, new Object[0]);
        if (z) {
            this.t = true;
            if (this.n != "" && this.r != null) {
                mm.b("Connection complete: " + z + " startPlaySession", new Object[0]);
                b(this.r, this.s, this.n);
                return;
            } else {
                if (this.o != -1 && this.r != null) {
                    mm.b("Connection complete: " + z + " continuePlaySession", new Object[0]);
                    a(this.r, this.s, this.o, this.p, this.q);
                    return;
                }
                return;
            }
        }
        if (this.r != null && this.s != null) {
            this.s.a(b.FailedNetworkError, null);
        }
    }

    public JSONObject e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "userevent");
        jSONObject.put("clientversion", k);
        jSONObject.put("clienttype", "Android");
        jSONObject.put("deviceid", Settings.Secure.getString(this.x.getContentResolver(), "android_id"));
        jSONObject.put("datetime", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(Calendar.getInstance().getTime()));
        jSONObject.put("territory", this.a);
        return jSONObject;
    }

    public void a(String str, String str2, boolean z) {
        JSONObject jSONObjectE;
        JSONException e;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObjectE = e();
        } catch (JSONException e2) {
            jSONObjectE = jSONObject;
            e = e2;
        }
        try {
            jSONObjectE.put("action", str2);
            jSONObjectE.put("target", "track");
            float fT = MusicPlaylistManager.a().t();
            if (fT <= 0.0f) {
                fT = 0.0f;
            }
            jSONObjectE.put("offset", fT);
            jSONObjectE.put("mix", this.J);
            jSONObjectE.put("playsessionid", this.F);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str);
            jSONObjectE.put("product", jSONObject2);
        } catch (JSONException e3) {
            e = e3;
            mm.e(e.toString(), new Object[0]);
            e.printStackTrace();
        }
        a(jSONObjectE, z);
        mm.b("MIXRADIO_USEREVENT", "action is " + str2 + " display_like_popup=" + this.G + " and display_dislike_popup=" + this.H);
        if (str2.compareTo("like") == 0 && this.G) {
            this.G = aho.b("mixradio_display_like_popup", true);
            if (this.G) {
                Toast.makeText(this.x, this.x.getString(R.string.MixRadioAddLikePopupTitle) + " " + this.x.getString(R.string.MixRadioAddLikePopupBlurb), 1).show();
            }
            aho.a("mixradio_display_like_popup", false);
            return;
        }
        if (str2.compareTo("dislike") == 0 && this.H) {
            this.H = aho.b("mixradio_display_dislike_popup", true);
            if (this.H) {
                Toast.makeText(this.x, this.x.getString(R.string.MixRadioAddDisLikePopupTitle) + " " + this.x.getString(R.string.MixRadioAddDisLikePopupBlurb), 1).show();
            }
            aho.a("mixradio_display_dislike_popup", false);
        }
    }

    public void a(JSONObject jSONObject) {
        JSONObject jSONObjectE;
        JSONException e;
        JSONObject jSONObject2 = new JSONObject();
        this.J = jSONObject;
        try {
            mm.b("RECENTMIX", jSONObject.toString());
            jSONObjectE = e();
            try {
                jSONObjectE.put("action", "playsession");
                jSONObject.remove("adparams");
                jSONObjectE.put("mix", jSONObject);
                jSONObjectE.put("playsessionid", this.F);
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (JSONException e3) {
            jSONObjectE = jSONObject2;
            e = e3;
        }
        a(jSONObjectE, true);
    }

    public void f() {
        JSONObject jSONObjectE;
        JSONException e;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObjectE = e();
            try {
                jSONObjectE.put("action", "impression");
                jSONObjectE.put("target", "ad");
                jSONObjectE.put("adtype", "audio");
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (JSONException e3) {
            jSONObjectE = jSONObject;
            e = e3;
        }
        a(jSONObjectE, false);
    }

    public void a(JSONObject jSONObject, boolean z) {
        aue aueVarA;
        StringEntity stringEntity;
        if (!z) {
            aueVarA = agv.b(true);
        } else {
            aueVarA = agv.a(true);
        }
        aueVarA.a("Authorization", "Bearer " + this.d);
        aueVarA.a("Content-Type", "application/vnd.nokia.ent.usereventlist+json");
        String strA = ayg.a(ayg.c.UserEvent, this.e);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("type", "usereventlist");
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            jSONObject2.put("items", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            stringEntity = new StringEntity(jSONObject2.toString());
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            stringEntity = null;
        }
        aueVarA.a(this.x, strA, stringEntity, "application/vnd.nokia.ent.usereventlist+json", new aux() { // from class: ayf.2
            @Override // defpackage.aux
            public void a(int i2, Header[] headerArr, String str, Throwable th) {
                mm.e("on Failure " + i2, new Object[0]);
            }

            @Override // defpackage.aux
            public void a(int i2, Header[] headerArr, String str) {
                mm.b("on Success " + i2, new Object[0]);
            }
        });
    }

    public void a(String str) {
        agv.a(true).a(str, new aux() { // from class: ayf.3
            @Override // defpackage.aux
            public void a(int i2, Header[] headerArr, String str2, Throwable th) {
                mm.e("on Failure " + i2, new Object[0]);
                mm.e("on Failure " + str2, new Object[0]);
            }

            @Override // defpackage.aux
            public void a(int i2, Header[] headerArr, String str2) {
                mm.b("on success " + str2, new Object[0]);
            }
        });
    }

    public void a(ayd aydVar) {
        this.h = aydVar;
    }

    public ayd g() {
        return this.h;
    }
}
