package defpackage;

import com.harman.commom.music.player.service.MusicData;
import defpackage.ayf;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ayg {
    private static String a = "1.x";

    public interface a {
        void a(boolean z);
    }

    public interface b {
        void a(ayf.a aVar, String str);

        void a(ayf.a aVar, JSONArray jSONArray);

        void a(ayf.a aVar, JSONObject jSONObject, String str);
    }

    public enum c {
        Status,
        MixGroupsByCategory,
        MixGroupsByGenre,
        MixesInGroup,
        FeaturedMixes,
        Authenticate,
        Authorize,
        GetMix,
        StartPlay,
        ArtistSearch,
        Search,
        ArtistImage,
        ArtistImage_Large,
        ArtistImage_Random,
        ArtistImage_Medium,
        ArtistImage_Small,
        SimilarArtists,
        GenreArtists,
        FavouriteWrite,
        FavouriteRead,
        CatArtists,
        RecentMixes,
        TasteGenre,
        FetchArtist,
        UserEvent,
        Me
    }

    public interface d {
        void a(ayf.b bVar, MusicData musicData);
    }

    public static void a(c cVar, String str, aus ausVar, int i, int i2, aug augVar) {
        agv.a(true).a(a(cVar, str, i, i2), ausVar, augVar);
    }

    public static String a(c cVar, String str) {
        return a(cVar, str, -1, -1);
    }

    public static String a(c cVar, String str, int i, int i2) {
        String str2;
        String str3 = "http://api.mixrad.io/" + a;
        String str4 = i >= 0 ? "&startindex=" + i : "";
        String str5 = i2 >= 0 ? str4 + "&itemsperpage=" + i2 : str4;
        mm.b("URLTYPE", "" + cVar.toString());
        if (cVar == c.MixGroupsByCategory) {
            str3 = str3 + "/" + ayf.a().a + "/mixes/groups?client_id=" + ayf.a().b + "&domain=music&category=general";
        } else if (cVar == c.MixGroupsByGenre) {
            str3 = str3 + "/" + ayf.a().a + "/mixes/groups?client_id=" + ayf.a().b + "&domain=music&category=genre";
        } else if (cVar == c.TasteGenre) {
            str3 = str3 + "/" + ayf.a().a + "/genres?client_id=" + ayf.a().b + "&domain=music";
        } else if (cVar == c.MixesInGroup) {
            str3 = str3 + "/" + ayf.a().a + "/mixes/groups/" + str + "?client_id=" + ayf.a().b + "&domain=music";
        } else if (cVar == c.FeaturedMixes) {
            str3 = str3 + "/" + ayf.a().a + "/mixes/featured?client_id=" + ayf.a().b + "&domain=music";
        } else if (cVar != c.GetMix) {
            if (cVar == c.Authenticate) {
                if (str.compareTo("") == 0) {
                    str3 = "https://sapi.mixrad.io/" + a + "/token";
                } else {
                    str3 = "https://sapi.mixrad.io/" + a + "/token?authorization_code=" + str;
                }
            } else if (cVar == c.Authorize) {
                str3 = "https://sapi.mixrad.io/" + a + "/authorize/?response_type=code&client_id=" + ayf.a().b + "&scope=sign_in";
            } else if (cVar == c.StartPlay) {
                str3 = "https://sapi.mixrad.io/" + a + "/" + ayf.a().a + "/users/" + str + "/mix/sessions/";
            } else if (cVar == c.ArtistSearch) {
                str3 = str3 + "/" + ayf.a().a + "/suggestions/musicartist/?domain=music&q=" + str + "&client_id=" + ayf.a().b;
            } else if (cVar == c.ArtistImage) {
                str3 = str3 + "/" + ayf.a().a + "/creators/images/200x200/random/?domain=music&id=" + str + "&client_id=" + ayf.a().b;
            } else if (cVar == c.ArtistImage_Large) {
                str3 = str3 + "/" + ayf.a().a + "/creators/images/320x320/random/?domain=music&id=" + str + "&client_id=" + ayf.a().b;
            } else if (cVar == c.ArtistImage_Random) {
                str3 = str3 + "/" + ayf.a().a + "/creators/images/full/random/?domain=music&id=" + str + "&client_id=" + ayf.a().b;
            } else if (cVar == c.ArtistImage_Medium) {
                str3 = str3 + "/" + ayf.a().a + "/creators/images/100x100/random/?domain=music&id=" + str + "&client_id=" + ayf.a().b;
            } else if (cVar == c.ArtistImage_Small) {
                str3 = str3 + "/" + ayf.a().a + "/creators/images/50x50/random/?domain=music&id=" + str + "&client_id=" + ayf.a().b;
            } else if (cVar == c.Search) {
                str3 = str3 + "/" + ayf.a().a + "/?domain=music&client_id=" + ayf.a().b + "&q=" + str;
            } else if (cVar == c.FetchArtist) {
                str3 = str3 + "/" + ayf.a().a + "/?domain=music&client_id=" + ayf.a().b + "&category=artist&id=" + str;
            } else if (cVar == c.SimilarArtists) {
                str3 = str3 + "/" + ayf.a().a + "/creators/" + str + "/similar/?domain=music&client_id=" + ayf.a().b;
            } else if (cVar == c.GenreArtists) {
                str3 = str3 + "/" + ayf.a().a + "/?domain=music&client_id=" + ayf.a().b + "&category=artist&genre=" + str;
            } else if (cVar == c.CatArtists) {
                str3 = str3 + "/" + ayf.a().a + "/?domain=music&client_id=" + ayf.a().b + "&category=" + str;
            } else if (cVar == c.FavouriteWrite) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String str6 = (String) jSONObject.get("userid");
                    String str7 = (String) jSONObject.get("artistid");
                    String str8 = (String) jSONObject.get("relationtype");
                    mm.b("fav", str6 + ", " + str7 + ", " + str8);
                    str2 = "https://sapi.mixrad.io/" + a + "/" + ayf.a().a + "/users/" + str6 + "/relationships/" + str8 + "/" + str7 + "/";
                } catch (JSONException e) {
                    e.printStackTrace();
                    str2 = str3;
                }
                str3 = str2;
            } else if (cVar == c.FavouriteRead) {
                str3 = "https://sapi.mixrad.io/" + a + "/" + ayf.a().a + "/users/" + str + "/relationships/favourite/?domain=music";
            } else if (cVar == c.RecentMixes) {
                str3 = "https://sapi.mixrad.io/" + a + "/users/" + str + "/history/mixes?client_id=" + ayf.a().b + "&domain=music";
            } else if (cVar == c.UserEvent) {
                str3 = "https://sapi.mixrad.io/2.x/users/" + str + "/history/";
            } else if (cVar == c.Me) {
                str3 = "https://sapi.mixrad.io/1.x/me?client_id=" + ayf.a().b;
            } else {
                str3 = str3 + "?&countrycode=" + ayf.a().a + "&client_id=" + ayf.a().b + "&domain=music";
            }
        }
        String str9 = str3 + str5;
        mm.b(str9, new Object[0]);
        return str9;
    }
}
