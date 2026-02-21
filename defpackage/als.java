package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.commom.util.error.ErrorInfo;
import com.harman.hkconnect.R;
import com.harman.hkconnect.musicservice.musicserver.deezer.DeezerMusicData;
import defpackage.age;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class als {
    public static String a = "HAS_SHOW_NOTICE_DIALOG";
    public static String b = "http://www.deezer.com/premium/harman";
    public static List<akm> c = null;
    public static boolean d = false;

    public interface a {
        void a();

        void a(JSONObject jSONObject);
    }

    public static String a(String str) {
        try {
            byte[] bArrB = b(str);
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(2, new SecretKeySpec("bf3365a54b158ebb33e226c51745533d".getBytes("UTF8"), "AES"));
            return new String(cipher.doFinal(bArrB), "UTF8").trim();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return null;
        } catch (BadPaddingException e4) {
            e4.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e5) {
            e5.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private static byte[] b(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i * 2, (i * 2) + 1), 16) * 16) + Integer.parseInt(str.substring((i * 2) + 1, (i * 2) + 2), 16));
        }
        return bArr;
    }

    public static MusicData a(akm akmVar) {
        DeezerMusicData deezerMusicData = new DeezerMusicData();
        deezerMusicData.songId = akmVar.a();
        deezerMusicData.artist = akmVar.d().b();
        deezerMusicData.musicName = akmVar.b();
        deezerMusicData.album = akmVar.e().c();
        deezerMusicData.album_art = akmVar.e().e();
        deezerMusicData.path = "https://api.deezer.com/" + akmVar.a();
        deezerMusicData.duration = akmVar.c() * 1000;
        mm.b("deezerTrackToMusicData musicName=%s,songId=%l, duration=%d", deezerMusicData.musicName, Long.valueOf(deezerMusicData.songId), Integer.valueOf(akmVar.c()));
        return deezerMusicData;
    }

    public static String a(String str, Long l) {
        String string;
        String strA = null;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str2 = "https://api.deezer.com/streaming_url.php?access_token=" + str + "&track_id=" + l;
        String strA2 = qw.a(str2);
        mm.b("Deezer song's request url = " + str2, new Object[0]);
        try {
            JSONObject jSONObject = new JSONObject(strA2);
            if (jSONObject.has("url")) {
                string = jSONObject.getString("url");
            } else {
                string = jSONObject.has("url_320") ? jSONObject.getString("url_320") : null;
            }
        } catch (JSONException e) {
            e = e;
        }
        if (string != null) {
            try {
            } catch (JSONException e2) {
                strA = string;
                e = e2;
                e.printStackTrace();
                mm.b("Parse Deezer response failed, apiUrl=%s, response=%s", str2, strA2);
            }
            if (!TextUtils.isEmpty(string)) {
                mm.b("before url = " + string, new Object[0]);
                strA = a(string);
                mm.b("after url = " + strA, new Object[0]);
                mm.b("getPlayUrl() take time = " + ((System.currentTimeMillis() - jCurrentTimeMillis) / 1000) + " seconds", new Object[0]);
                return strA;
            }
        }
        mm.b("Deezer url is null, apiUrl=%s, response=%s", str2, strA2);
        return strA;
    }

    public static String a(Context context, Long l) {
        if (context == null) {
            return null;
        }
        qj qjVar = new qj("135461");
        new qo().b(qjVar, context);
        return a(qjVar.b(), l);
    }

    private static boolean a(Context context) {
        return "2".equals(aho.d("user_status"));
    }

    public static boolean a(MusicData musicData, Context context) {
        return (d || a(context) || !a(musicData)) ? false : true;
    }

    public static boolean a() {
        return true;
    }

    private static boolean a(MusicData musicData) {
        if (musicData != null) {
            String str = musicData.path;
            if (!TextUtils.isEmpty(str) && str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) && str.contains("deezer.com")) {
                return true;
            }
        }
        return false;
    }

    public static String a(Long l, Context context) {
        Long lValueOf = Long.valueOf(System.currentTimeMillis() / 1000);
        if (l == null) {
            l = 0L;
        }
        Long lValueOf2 = Long.valueOf(lValueOf.longValue() - l.longValue());
        Long l2 = 60L;
        Long lValueOf3 = Long.valueOf(l2.longValue() * 60);
        Long lValueOf4 = Long.valueOf(lValueOf3.longValue() * 24);
        Long lValueOf5 = Long.valueOf(lValueOf4.longValue() * 7);
        Long lValueOf6 = Long.valueOf(lValueOf4.longValue() * 30);
        Long lValueOf7 = Long.valueOf(lValueOf2.longValue() / Long.valueOf(lValueOf4.longValue() * 365).longValue());
        if (lValueOf7.longValue() > 0) {
            return lValueOf7 + " " + context.getString(R.string.kDeezer_years_ago_Str);
        }
        Long lValueOf8 = Long.valueOf(lValueOf2.longValue() / lValueOf6.longValue());
        if (lValueOf8.longValue() > 0) {
            return lValueOf8 + " " + context.getString(R.string.kDeezer_months_ago_Str);
        }
        Long lValueOf9 = Long.valueOf(lValueOf2.longValue() / lValueOf5.longValue());
        if (lValueOf9.longValue() > 0) {
            return lValueOf9 + " " + context.getString(R.string.kDeezer_weeks_ago_Str);
        }
        Long lValueOf10 = Long.valueOf(lValueOf2.longValue() / lValueOf4.longValue());
        if (lValueOf10.longValue() > 0) {
            return lValueOf10 + " " + context.getString(R.string.kDeezer_days_ago_Str);
        }
        Long lValueOf11 = Long.valueOf(lValueOf2.longValue() / lValueOf3.longValue());
        if (lValueOf11.longValue() > 0) {
            return lValueOf11 + " " + context.getString(R.string.kDeezer_hours_ago_Str);
        }
        return "1 " + context.getString(R.string.kDeezer_hours_ago_Str);
    }

    public static void a(List<akm> list) {
        MusicData musicDataA;
        ArrayList arrayList = new ArrayList();
        for (akm akmVar : list) {
            if (akmVar.f() && (musicDataA = a(akmVar)) != null) {
                arrayList.add(musicDataA);
            }
        }
        MusicPlaylistManager.a().e(arrayList);
    }

    public static void a(akj akjVar, qi qiVar, final a aVar) {
        final amh amhVar = new amh(akjVar.e(), qiVar);
        amhVar.a(0, akjVar.c() != null ? Math.min(100, Integer.parseInt(akjVar.c())) : 100, new age.a() { // from class: als.1
            @Override // age.a
            public void a(int i, List<MusicData> list, JSONObject jSONObject) {
                MusicPlaylistManager.a().h();
                MusicPlaylistManager.a().a(list, amhVar);
                if (aVar != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: als.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a();
                        }
                    });
                }
            }

            @Override // age.a
            public void a(ErrorInfo errorInfo) {
                if (aVar != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: als.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a(null);
                        }
                    });
                }
            }
        });
    }

    public static void a(final akg akgVar, qi qiVar, final a aVar) {
        aue aueVarA = agv.a(true);
        String str = "https://api.deezer.com/album/" + akgVar.b() + "/tracks?limit=2147483647&access_token=" + qiVar.b();
        mm.b(str, new Object[0]);
        aueVarA.a(str, new aum() { // from class: als.2
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                mm.b(jSONObject, new Object[0]);
                List<akm> listA = new qv(akm.class).a(jSONObject.toString());
                if (listA != null && !listA.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (akm akmVar : listA) {
                        if (akmVar.f()) {
                            akmVar.a(akgVar);
                            MusicData musicDataA = als.a(akmVar);
                            if (musicDataA != null) {
                                arrayList.add(musicDataA);
                            }
                        }
                    }
                    MusicPlaylistManager.a().h();
                    MusicPlaylistManager.a().e(arrayList);
                    if (aVar != null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: als.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                aVar.a();
                            }
                        });
                    }
                }
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, final JSONObject jSONObject) {
                if (aVar != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: als.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a(jSONObject);
                        }
                    });
                }
                mm.b("onFailure statusCode = " + i + ", errorResponse = " + jSONObject, new Object[0]);
            }
        });
    }

    public static void b(akm akmVar) {
        MusicData musicDataA;
        if (akmVar.f() && (musicDataA = a(akmVar)) != null) {
            MusicPlaylistManager.a().b(musicDataA);
        }
    }

    public static void a(List<akm> list, int i) {
        if (list.get(i).f()) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    akm akmVar = list.get(i3);
                    if (akmVar.f()) {
                        arrayList.add(a(akmVar));
                    } else if (i3 < i) {
                        i--;
                    }
                    i2 = i3 + 1;
                } else {
                    MusicPlaylistManager.a().h();
                    MusicPlaylistManager.a().a(arrayList, i);
                    return;
                }
            }
        }
    }

    public static void a(List<akm> list, int i, amh amhVar) {
        if (list.get(i).f()) {
            ArrayList arrayList = new ArrayList();
            int i2 = i;
            for (int i3 = 0; i3 < list.size(); i3++) {
                akm akmVar = list.get(i3);
                if (akmVar.f()) {
                    arrayList.add(a(akmVar));
                } else if (i3 < i) {
                    i2--;
                }
            }
            MusicPlaylistManager.a().h();
            MusicPlaylistManager.a().a(arrayList, i2, amhVar);
        }
    }

    public static void a(akk akkVar, qi qiVar, a aVar) {
        String str = "https://api.deezer.com/radio/" + akkVar.b() + "/tracks?limit=2147483647&access_token=" + qiVar.b();
        mm.b(str, new Object[0]);
        new alr(aVar, str).a();
    }

    public static void a(akh akhVar, qi qiVar, a aVar) {
        new alr(aVar, "https://api.deezer.com/artist/" + akhVar.a() + "/radio?access_token=" + qiVar.b()).a();
    }

    public static void b(final akh akhVar, qi qiVar, final a aVar) {
        aue aueVarA = agv.a(true);
        String str = "https://api.deezer.com/artist/" + akhVar.a() + "/top?access_token=" + qiVar.b();
        mm.b("playArtistTopTracks------------  " + str, new Object[0]);
        aueVarA.a(str, new aum() { // from class: als.3
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                mm.b(jSONObject, new Object[0]);
                List<akm> listA = new qv(akm.class).a(jSONObject.toString());
                if (listA != null && !listA.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (akm akmVar : listA) {
                        if (akmVar.f()) {
                            akmVar.a(akhVar);
                            MusicData musicDataA = als.a(akmVar);
                            if (musicDataA != null) {
                                arrayList.add(musicDataA);
                            }
                        }
                    }
                    MusicPlaylistManager.a().h();
                    MusicPlaylistManager.a().e(arrayList);
                    if (aVar != null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: als.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                aVar.a();
                            }
                        });
                    }
                }
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, final JSONObject jSONObject) {
                if (aVar != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: als.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a(jSONObject);
                        }
                    });
                }
                mm.b("onFailure statusCode = " + i + ", errorResponse = " + jSONObject, new Object[0]);
            }
        });
    }

    public static void a(Context context, asi asiVar) {
        arz arzVar = new arz(context);
        ArrayList arrayList = new ArrayList();
        arrayList.add(context.getString(R.string.PlayTip_PlayNow_Str));
        arrayList.add(context.getString(R.string.PlayTip_PlayNext_Str));
        arrayList.add(context.getString(R.string.PlayTip_AddSongToQueue_Str));
        arrayList.add(context.getString(R.string.PlayTip_ClearAll_Str));
        arzVar.a(arrayList);
        arzVar.a(context.getString(R.string.PlayTip_Title_Str));
        arzVar.a(asiVar);
        arzVar.show();
    }

    public static void b(List<MusicData> list, int i) {
        switch (i) {
            case 0:
                MusicPlaylistManager.a().a(list);
                break;
            case 1:
                MusicPlaylistManager.a().c(list);
                break;
            case 2:
                MusicPlaylistManager.a().d(list);
                break;
            case 3:
                MusicPlaylistManager.a().g();
                MusicPlaylistManager.a().e(list);
                break;
        }
    }
}
