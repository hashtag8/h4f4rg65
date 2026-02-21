package defpackage;

import defpackage.bdh;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bdi {

    public interface a {
        void a(boolean z, String str, String str2, String str3, String str4, int i);
    }

    public interface b {
        void a(bdh.a aVar, String str);

        void a(bdh.a aVar, JSONArray jSONArray);

        void a(bdh.a aVar, JSONObject jSONObject, String str);
    }

    public enum c {
        WhatsNew,
        EditorialAlbums,
        EditorialTracks,
        AlbumTracks,
        PlaylistTracks,
        PlaylistMoods,
        Playlists,
        PlaylistGenres,
        Promotional,
        Search,
        PlaylistMetaData,
        ArtistAlbums,
        AlbumMetaData,
        ArtistMetaData,
        ArtistTracks,
        FavouriteAlbums,
        FavouriteTracks,
        FavouritePlaylists,
        FavouriteArtists,
        SearchAlbums,
        SearchTracks,
        SearchPlaylists,
        SearchArtists,
        GenrePlaylists,
        GenreAlbums,
        GenreTracks,
        Genre,
        UserPlaylists,
        ForgotPassword,
        Radio,
        EditPlaylist,
        ShowProgress,
        Tracks
    }

    public static void a(c cVar, String str, String str2, aus ausVar, int i, int i2, aug augVar) {
        agv.a(true).a(a(cVar, str, str2, i, i2), ausVar, augVar);
    }

    public static String a(c cVar, String str, String str2, int i, int i2) {
        String str3 = i >= 0 ? "&offset=" + i : "";
        if (i2 >= 0) {
            str3 = str3 + "&limit=" + i2;
        }
        String str4 = "https://api.tidalhifi.com/v1/";
        mm.b("URLTYPE", "" + cVar.toString());
        if (cVar == c.WhatsNew) {
            str4 = str4 + "featured/" + str + "/" + str2 + "?token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        } else if (cVar == c.PlaylistTracks) {
            str4 = str4 + "playlists/" + str + "/tracks?token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        } else if (cVar == c.PlaylistMoods) {
            str4 = str4 + "moods?token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        } else if (cVar == c.Playlists) {
            str4 = str4 + str + "/" + str2 + "/playlists?token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        } else if (cVar == c.PlaylistGenres) {
            str4 = str4 + "genres?token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        } else if (cVar == c.Promotional) {
            str4 = str4 + "promotions?token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        } else if (cVar == c.Search) {
            str4 = str4 + "search/autocomplete?query=" + str + "&types=TRACK%2CALBUM%2CARTIST%2CPLAYLIST&group=false&token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        } else if (cVar == c.PlaylistMetaData) {
            str4 = str4 + "playlists/" + str + "?token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        } else if (cVar == c.AlbumTracks) {
            str4 = str4 + "albums/" + str + "/tracks?token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        } else if (cVar == c.ArtistAlbums) {
            str4 = str4 + "artists/" + str + "/albums?filter=" + str2 + "&token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        } else if (cVar == c.AlbumMetaData) {
            str4 = str4 + "albums/" + str + "?token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        } else if (cVar == c.ArtistMetaData) {
            str4 = str4 + "artists/" + str + "?token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        } else if (cVar == c.ArtistTracks) {
            str4 = str4 + "artists/" + str + "/toptracks?token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        } else if (cVar == c.FavouriteAlbums) {
            str4 = str4 + "users/" + str + "/favorites/albums?order=NAME&orderDirection=ASC&filter=ALL&token=" + bdh.a().d + "&countryCode=" + bdh.a().b + "&sessionId=" + str2;
        } else if (cVar == c.FavouriteArtists) {
            str4 = str4 + "users/" + str + "/favorites/artists?order=NAME&orderDirection=ASC&filter=ALL&token=" + bdh.a().d + "&countryCode=" + bdh.a().b + "&sessionId=" + str2;
        } else if (cVar == c.FavouriteTracks) {
            str4 = str4 + "users/" + str + "/favorites/tracks?order=NAME&orderDirection=ASC&filter=ALL&token=" + bdh.a().d + "&countryCode=" + bdh.a().b + "&sessionId=" + str2;
        } else if (cVar == c.FavouritePlaylists) {
            str4 = str4 + "users/" + str + "/favorites/playlists?order=NAME&orderDirection=ASC&filter=ALL&token=" + bdh.a().d + "&countryCode=" + bdh.a().b + "&sessionId=" + str2;
        } else if (cVar == c.SearchAlbums) {
            str4 = str4 + "search/albums?query=" + str + "&token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        } else if (cVar == c.SearchArtists) {
            str4 = str4 + "search/artists?query=" + str + "&token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        } else if (cVar == c.SearchTracks) {
            str4 = str4 + "search/tracks?query=" + str + "&token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        } else if (cVar == c.SearchPlaylists) {
            str4 = str4 + "search/playlists?query=" + str + "&token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        } else if (cVar == c.Genre) {
            str4 = str4 + "genres/" + str + "/" + str2 + "?token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        } else if (cVar == c.UserPlaylists) {
            str4 = str4 + "users/" + str + "/playlists?token=" + bdh.a().d + "&countryCode=" + bdh.a().b + "&sessionId=" + str2;
        } else if (cVar == c.ForgotPassword) {
            str4 = str4 + "users/" + str + "/recoverpassword?token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        } else if (cVar == c.Radio) {
            str4 = str4 + "tracks/" + str + "/radio?token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        } else if (cVar == c.Tracks) {
            str4 = str4 + "tracks/" + str + "?token=" + bdh.a().d + "&countryCode=" + bdh.a().b;
        }
        String str5 = str4 + str3;
        mm.b("URLSTRING", str5);
        return str5;
    }
}
