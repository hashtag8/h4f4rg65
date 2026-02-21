package defpackage;

import com.harman.commom.music.player.service.MusicData;
import defpackage.amk;

/* JADX INFO: loaded from: classes.dex */
public class amj {
    private static String a = "1.x";

    public interface a {
        void a(boolean z);
    }

    public enum b {
        Status,
        MixGroupsByCategory,
        MixGroupsByGenre,
        MixesInGroup,
        FeaturedMixes,
        Authenticate,
        Authorize,
        GetMix,
        StartPlay,
        Territory
    }

    public interface c {
        void a(amk.a aVar, MusicData musicData);
    }

    public static String a(b bVar, String str) {
        String str2 = "http://api.mixrad.io/" + a;
        mm.b("URLTYPE", "" + bVar.toString());
        if (bVar == b.MixGroupsByCategory) {
            return str2 + "/" + amk.a().a + "/mixes/groups?client_id=" + amk.a().b + "&domain=music&category=general";
        }
        if (bVar == b.MixGroupsByGenre) {
            return str2 + "/" + amk.a().a + "/mixes/groups?client_id=" + amk.a().b + "&domain=music&category=genre";
        }
        if (bVar == b.MixesInGroup) {
            return str2 + "/" + amk.a().a + "/mixes/groups/" + str + "?client_id=" + amk.a().b + "&domain=music";
        }
        if (bVar == b.FeaturedMixes) {
            return str2 + "/" + amk.a().a + "/mixes/featured?client_id=" + amk.a().b + "&domain=music";
        }
        if (bVar != b.GetMix) {
            if (bVar == b.Authenticate) {
                return "https://sapi.mixrad.io/" + a + "/token";
            }
            if (bVar == b.Authorize) {
                return "https://sapi.mixrad.io/" + a + "/authorize/?response_type=code&client_id=" + amk.a().b + "&scope=sign_in";
            }
            if (bVar == b.StartPlay) {
                return "https://sapi.mixrad.io/" + a + "/" + amk.a().a + "/users/" + str + "/mix/sessions/";
            }
            if (bVar == b.Territory) {
                return str2 + "?&client_id=" + amk.a().b + "&domain=music";
            }
            return str2 + "?&countrycode=" + amk.a().a + "&client_id=" + amk.a().b + "&domain=music";
        }
        return str2;
    }
}
