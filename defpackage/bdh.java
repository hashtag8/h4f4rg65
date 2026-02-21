package defpackage;

import android.content.Context;
import com.harman.commom.music.player.service.MusicData;
import com.musicservice.tidal.model.TidalMusicDataLocal;
import defpackage.bdi;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bdh {
    public static int a = 20;
    private static bdh e;
    public String b = "US";
    public String c = "HIGH";
    public String d = "BWolOS6gvWJUjYse";

    public enum a {
        WhatsNewPlaylists,
        WhatsNewAlbums,
        WhatsNewTracks,
        AlbumTracks,
        PlaylistTracks,
        WhatsNew,
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
        ArtistOtherAlbums,
        ArtistSinglesAlbums,
        FavouriteAlbums,
        FavouriteTracks,
        FavouritePlaylists,
        FavouriteArtists,
        SearchAlbums,
        SearchTracks,
        SearchPlaylists,
        SearchArtists,
        GenreTracks,
        GenreAlbums,
        GenrePlaylists,
        Genre,
        UserPlaylists,
        ForgotPassword,
        Radio,
        EditPlaylist,
        DeletePlaylist,
        AddFavouriteTrack,
        RemoveFavouriteTrack,
        AddFavouriteAlbum,
        RemoveFavouriteAlbum,
        AddFavouriteArtist,
        RemoveFavouriteArtist,
        AddFavouritePlaylist,
        RemoveFavouritePlaylist,
        DeleteTrack,
        AddTrack,
        EditPlaylistTracks,
        CreatePlaylist,
        PreEditPlaylist,
        ShowProgress,
        Tracks
    }

    public static bdh a() {
        if (e == null) {
            e = new bdh();
        }
        return e;
    }

    private bdh() {
        mm.b("TidalMusicManager()", new Object[0]);
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(String str) {
        this.c = str;
    }

    public String a(String str, String str2) {
        if (this.c.compareTo("") == 0) {
            this.c = "LOW";
        }
        return "https://api.tidalhifi.com/v1/tracks/" + str + "/streamurl?soundQuality=" + this.c + "&sessionId=" + str2;
    }

    public void a(a aVar, bdi.b bVar, String str, String str2) {
        a(aVar, bVar, str, str2, -1, -1);
    }

    public void a(final a aVar, final bdi.b bVar, final String str, final String str2, int i, int i2) {
        bdi.c cVar = bdi.c.WhatsNew;
        if (aVar == a.WhatsNew || aVar == a.WhatsNewTracks || aVar == a.WhatsNewAlbums || aVar == a.WhatsNewPlaylists) {
            cVar = bdi.c.WhatsNew;
        } else if (aVar == a.Genre || aVar == a.GenreTracks || aVar == a.GenreAlbums || aVar == a.GenrePlaylists) {
            cVar = bdi.c.Genre;
        } else if (aVar == a.PlaylistTracks) {
            cVar = bdi.c.PlaylistTracks;
        } else if (aVar == a.PlaylistMoods) {
            cVar = bdi.c.PlaylistMoods;
        } else if (aVar == a.Playlists) {
            cVar = bdi.c.Playlists;
        } else if (aVar == a.PlaylistGenres) {
            cVar = bdi.c.PlaylistGenres;
        } else if (aVar == a.Promotional) {
            cVar = bdi.c.Promotional;
        } else if (aVar == a.Search) {
            cVar = bdi.c.Search;
        } else if (aVar == a.PlaylistMetaData) {
            cVar = bdi.c.PlaylistMetaData;
        } else if (aVar == a.AlbumTracks) {
            cVar = bdi.c.AlbumTracks;
        } else if (aVar == a.ArtistAlbums) {
            cVar = bdi.c.ArtistAlbums;
        } else if (aVar == a.AlbumMetaData) {
            cVar = bdi.c.AlbumMetaData;
        } else if (aVar == a.ArtistMetaData) {
            cVar = bdi.c.ArtistMetaData;
        } else if (aVar == a.ArtistTracks) {
            cVar = bdi.c.ArtistTracks;
        } else if (aVar == a.ArtistOtherAlbums || aVar == a.ArtistSinglesAlbums) {
            cVar = bdi.c.ArtistAlbums;
        } else if (aVar == a.FavouriteAlbums) {
            cVar = bdi.c.FavouriteAlbums;
        } else if (aVar == a.FavouriteArtists) {
            cVar = bdi.c.FavouriteArtists;
        } else if (aVar == a.FavouritePlaylists) {
            cVar = bdi.c.FavouritePlaylists;
        } else if (aVar == a.FavouriteTracks) {
            cVar = bdi.c.FavouriteTracks;
        } else if (aVar == a.SearchAlbums) {
            cVar = bdi.c.SearchAlbums;
        } else if (aVar == a.SearchArtists) {
            cVar = bdi.c.SearchArtists;
        } else if (aVar == a.SearchPlaylists) {
            cVar = bdi.c.SearchPlaylists;
        } else if (aVar == a.SearchTracks) {
            cVar = bdi.c.SearchTracks;
        } else if (aVar == a.UserPlaylists) {
            cVar = bdi.c.UserPlaylists;
        } else if (aVar == a.ForgotPassword) {
            cVar = bdi.c.ForgotPassword;
        } else if (aVar == a.Radio) {
            cVar = bdi.c.Radio;
        } else if (aVar == a.Tracks) {
            cVar = bdi.c.Tracks;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        bdi.a(cVar, str, str2, null, i, i2, new aum() { // from class: bdh.1
            @Override // defpackage.aum
            public void a(int i3, Header[] headerArr, JSONObject jSONObject) {
                try {
                    mm.b("debugreponse", jSONObject.toString());
                    String str3 = str;
                    if (aVar == a.PlaylistTracks || aVar == a.AlbumTracks || aVar == a.ArtistTracks || aVar == a.AlbumMetaData || aVar == a.PlaylistMetaData || aVar == a.ArtistMetaData) {
                        str3 = str2;
                    }
                    jSONObject.put("time_sent", jCurrentTimeMillis);
                    bVar.a(aVar, jSONObject, str3);
                } catch (Exception e2) {
                    mm.b("SEARCH", e2);
                    bVar.a(aVar, "error " + i3);
                }
            }

            @Override // defpackage.aum
            public void a(int i3, Header[] headerArr, JSONArray jSONArray) {
                mm.b("debugresponse", jSONArray.toString());
                bVar.a(aVar, jSONArray);
            }

            @Override // defpackage.aum
            public void a(int i3, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                mm.b("FAILURE", "error " + i3, th);
                bVar.a(aVar, "error " + i3);
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i3, Header[] headerArr, String str3, Throwable th) {
                mm.b("debugresponse", str3.toString());
                bVar.a(aVar, "Error with String");
            }
        });
    }

    public void a(final bdi.b bVar, String str, String str2, final String str3, int i, int i2) {
        bdi.a(bdi.c.UserPlaylists, str, str2, null, i, i2, new aum() { // from class: bdh.12
            @Override // defpackage.aum
            public void a(int i3, Header[] headerArr, JSONObject jSONObject) {
                try {
                    mm.b("debugreponse", jSONObject.toString());
                    bVar.a(a.UserPlaylists, jSONObject, str3);
                } catch (Exception e2) {
                    mm.b("SEARCH", e2.toString());
                }
            }

            @Override // defpackage.aum
            public void a(int i3, Header[] headerArr, JSONArray jSONArray) {
                mm.b("debugresponse", jSONArray.toString());
                bVar.a(a.UserPlaylists, jSONArray);
            }

            @Override // defpackage.aum
            public void a(int i3, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                bVar.a(a.UserPlaylists, jSONObject, str3);
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i3, Header[] headerArr, String str4, Throwable th) {
                bVar.a(a.UserPlaylists, "Error with String");
            }
        });
    }

    public void a(String str, String str2, final bdi.a aVar) {
        String str3 = "https://api.tidalhifi.com/v1/login/username?token=" + this.d;
        aus ausVar = new aus();
        ausVar.a("username", str);
        ausVar.a("password", str2);
        agv.a(true).b(str3, ausVar, new aum() { // from class: bdh.17
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                try {
                    mm.b(jSONObject.toString(), new Object[0]);
                    bdh.this.b = jSONObject.getString("countryCode");
                    bdh.this.a(jSONObject.getString("userId"), jSONObject.getString("sessionId"), jSONObject.getString("countryCode"), aVar);
                } catch (Exception e2) {
                    mm.b("authenticate catch " + jSONObject.toString(), new Object[0]);
                    aVar.a(false, "", "", "", "", i);
                }
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                int i2;
                if (jSONObject != null) {
                    mm.b("authenticate onFailure: " + th.getMessage() + " " + jSONObject.toString(), new Object[0]);
                    try {
                        if (jSONObject.getInt("subStatus") == 5001) {
                            i = 5001;
                        }
                        i2 = i;
                    } catch (JSONException e2) {
                        new ml().a("TIDAL Parse substatus", e2);
                        i2 = i;
                    }
                    aVar.a(false, "", "", "", "", i2);
                    return;
                }
                mm.b("authenticate onFailure(null): " + th.getMessage(), new Object[0]);
                aVar.a(false, "", "", "", "", i);
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i, Header[] headerArr, String str4, Throwable th) {
                mm.b("authenticate onFailure s: " + th.getMessage() + " " + str4, new Object[0]);
                aVar.a(false, "", "", "", "", i);
            }
        });
    }

    public void a(final String str, final String str2, final String str3, final bdi.a aVar) {
        agv.a(true).a("https://api.tidalhifi.com/v1/users/" + str + "/subscription?sessionId=" + str2, new aum() { // from class: bdh.18
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                try {
                    mm.b(jSONObject.toString(), new Object[0]);
                    bdh.this.c = jSONObject.optString("highestSoundQuality", "HIGH");
                    aVar.a(true, str, str2, str3, bdh.this.c, i);
                } catch (Exception e2) {
                    mm.b("authenticate catch " + jSONObject.toString(), new Object[0]);
                    aVar.a(false, "", "", "", "", i);
                }
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                if (jSONObject != null) {
                    mm.b("authenticate onFailure: " + th.getMessage() + " " + jSONObject.toString(), new Object[0]);
                } else {
                    mm.b("authenticate onFailure(null): " + th.getMessage(), new Object[0]);
                }
                aVar.a(false, "", "", "", "", i);
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i, Header[] headerArr, String str4, Throwable th) {
                mm.b("authenticate onFailure s: " + th.getMessage() + " " + str4, new Object[0]);
                aVar.a(false, "", "", "", "", i);
            }
        });
    }

    public void a(String str, final bdi.a aVar) {
        String str2 = "https://api.tidalhifi.com/v1/logout?token=" + this.d;
        aus ausVar = new aus();
        ausVar.a("sessionId", str);
        agv.a(true).b(str2, ausVar, new aum() { // from class: bdh.19
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                try {
                    mm.b(jSONObject.toString(), new Object[0]);
                    aVar.a(true, "", "", "", "", i);
                } catch (Exception e2) {
                    aVar.a(false, "", "", "", "", i);
                }
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                if (jSONObject != null) {
                    mm.b("authenticate onFailure: " + th.getMessage() + " " + jSONObject.toString(), new Object[0]);
                } else {
                    mm.b("authenticate onFailure(null): " + th.getMessage(), new Object[0]);
                }
                aVar.a(false, "", "", "", "", i);
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i, Header[] headerArr, String str3, Throwable th) {
                mm.b("authenticate onFailure s: " + th.getMessage() + " " + str3, new Object[0]);
                aVar.a(false, "", "", "", "", i);
            }
        });
    }

    public void a(String str, final String str2, String str3, String str4, final String str5, final bdi.b bVar) {
        String str6 = "https://api.tidalhifi.com/v1/users/" + str + "/playlists?token=" + this.d + "&countryCode=" + this.b + "&sessionId=" + str2;
        mm.b("FAV", str6);
        aus ausVar = new aus();
        ausVar.a("userId", Integer.parseInt(str));
        ausVar.a("title", str3);
        ausVar.a("description", str4);
        ausVar.a("sessionId", str2);
        agv.a(true).b(str6, ausVar, new aum() { // from class: bdh.20
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                String strOptString = jSONObject.optString("uuid");
                String value = "";
                for (int i2 = 0; i2 < headerArr.length; i2++) {
                    mm.b("PLAYLIST", headerArr[i2].getName());
                    if (headerArr[i2].getName().compareTo("ETag") == 0) {
                        value = headerArr[i2].getValue();
                    }
                }
                bdh.this.b(strOptString, str2, str5, value, bVar);
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i, Header[] headerArr, String str7, Throwable th) {
                mm.b("CREATEPLAYLIST", str7.toString());
                bVar.a(a.CreatePlaylist, "");
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i, Header[] headerArr, String str7) {
                try {
                    mm.b("CREATEPLAYLIST", str7.toString());
                } catch (Exception e2) {
                    mm.b("CREATEPLAYLIST", "authenticate catch " + str7.toString());
                    bVar.a(a.CreatePlaylist, "");
                }
            }
        });
    }

    public void a(String str, String str2, final String str3, final String str4, final bdi.b bVar) {
        String str5 = "https://api.tidalhifi.com/v1/playlists/" + str + "?token=" + this.d + "&countryCode=" + this.b + "&sessionId=" + str2;
        mm.b("FAV", str5);
        aus ausVar = new aus();
        ausVar.a("uuid", str);
        ausVar.a("title", str3);
        ausVar.a("description", str4);
        ausVar.a("sessionId", str2);
        agv.a(true).b(str5, ausVar, new aux() { // from class: bdh.21
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str6, Throwable th) {
                mm.b("FAV", str6.toString());
                bVar.a(a.FavouriteAlbums, "");
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str6) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("title", str3);
                    jSONObject.put("description", str4);
                    bVar.a(a.EditPlaylist, jSONObject, "");
                } catch (Exception e2) {
                    mm.b("EDITPLAYLIST", "authenticate catch " + str6.toString());
                    bVar.a(a.FavouriteAlbums, "");
                }
            }
        });
    }

    public void a(final String str, final String str2, final String str3, final int i, final bdi.b bVar) {
        agv.a(true).a("https://api.tidalhifi.com/v1/playlists/" + str + "?token=" + this.d + "&countryCode=" + this.b + "&sessionId=" + str2, (aus) null, new aum() { // from class: bdh.22
            @Override // defpackage.aum
            public void a(int i2, Header[] headerArr, JSONObject jSONObject) {
                String value = "";
                for (int i3 = 0; i3 < headerArr.length; i3++) {
                    mm.b("PLAYLIST", headerArr[i3].getName());
                    if (headerArr[i3].getName().compareTo("ETag") == 0) {
                        value = headerArr[i3].getValue();
                    }
                }
                bdh.this.a(str, str2, str3, i, value, bVar);
            }

            @Override // defpackage.aum
            public void a(int i2, Header[] headerArr, JSONArray jSONArray) {
                mm.b("debugresponse", jSONArray.toString());
                bVar.a(a.EditPlaylistTracks, jSONArray);
            }

            @Override // defpackage.aum
            public void a(int i2, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                bVar.a(a.EditPlaylistTracks, "error " + i2);
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i2, Header[] headerArr, String str4, Throwable th) {
                bVar.a(a.EditPlaylistTracks, "Error with String");
            }
        });
    }

    public void a(String str, String str2, String str3, int i, String str4, final bdi.b bVar) {
        String str5 = "https://api.tidalhifi.com/v1/playlists/" + str + "/tracks/" + str3 + "?token=" + this.d + "&countryCode=" + this.b + "&sessionId=" + str2;
        mm.b("FAV", str5);
        mm.b("ETAG", str4);
        aus ausVar = new aus();
        ausVar.a("uuid", str);
        ausVar.a("indices", str3);
        ausVar.a("toIndex", i);
        ausVar.a("sessionId", str2);
        aue aueVarA = agv.a(true);
        aueVarA.a("If-None-Match", str4);
        aueVarA.b(str5, ausVar, new aum() { // from class: bdh.2
            @Override // defpackage.aum
            public void a(int i2, Header[] headerArr, JSONObject jSONObject) {
                bVar.a(a.EditPlaylistTracks, jSONObject, "");
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i2, Header[] headerArr, String str6, Throwable th) {
                mm.b("FAV", str6.toString());
                bVar.a(a.EditPlaylistTracks, "");
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i2, Header[] headerArr, String str6) {
                try {
                    bVar.a(a.EditPlaylistTracks, null, "");
                } catch (Exception e2) {
                    mm.b("REORDER", "authenticate catch " + e2.toString());
                    bVar.a(a.EditPlaylistTracks, "");
                }
            }
        });
    }

    public void a(Context context, String str, String str2, final bdi.b bVar) {
        String str3 = "https://api.tidalhifi.com/v1/playlists/" + str + "?token=" + this.d + "&countryCode=" + this.b + "&sessionId=" + str2;
        mm.b("FAV", str3);
        aus ausVar = new aus();
        ausVar.a("uuid", str);
        ausVar.a("sessionId", str2);
        agv.a(true).a(context, str3, (Header[]) null, ausVar, new aux() { // from class: bdh.3
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str4, Throwable th) {
                bVar.a(a.DeletePlaylist, "");
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str4) {
                try {
                    bVar.a(a.DeletePlaylist, new JSONObject("{}"), "");
                } catch (Exception e2) {
                    mm.b("DELETEPLAYLIST", "authenticate catch " + e2.toString());
                    e2.printStackTrace();
                    bVar.a(a.DeletePlaylist, "");
                }
            }
        });
    }

    public void a(final String str, final String str2, final String str3, final bdi.b bVar) {
        aue aueVarA = agv.a(true);
        final a aVar = a.PlaylistMetaData;
        aueVarA.a(bdi.a(bdi.c.PlaylistMetaData, str, "", 0, 50), (aus) null, new aum() { // from class: bdh.4
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                String value = "";
                for (int i2 = 0; i2 < headerArr.length; i2++) {
                    mm.b("PLAYLIST", headerArr[i2].getName());
                    if (headerArr[i2].getName().compareTo("ETag") == 0) {
                        value = headerArr[i2].getValue();
                    }
                }
                try {
                    bdh.this.b(str, str2, str3, value, bVar);
                } catch (Exception e2) {
                    mm.b("SEARCH", e2.toString());
                }
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONArray jSONArray) {
                mm.b("debugresponse", jSONArray.toString());
                bVar.a(aVar, jSONArray);
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                bVar.a(aVar, "error " + i);
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i, Header[] headerArr, String str4, Throwable th) {
                bVar.a(aVar, "Error with String");
            }
        });
    }

    public void b(String str, String str2, final String str3, String str4, final bdi.b bVar) {
        String str5 = "https://api.tidalhifi.com/v1/playlists/" + str + "/tracks?token=" + this.d + "&countryCode=" + this.b + "&sessionId=" + str2;
        mm.b("FAV", str5 + " etag=" + str4);
        aus ausVar = new aus();
        ausVar.a("uuid", str);
        ausVar.a("trackIds", str3);
        ausVar.a("sessionId", str2);
        aue aueVarA = agv.a(true);
        aueVarA.a("If-None-Match", str4);
        aueVarA.a("Content-Type", "application/x-www-form-urlencoded");
        aueVarA.b(str5, ausVar, new aux() { // from class: bdh.5
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str6, Throwable th) {
                mm.b("FAV", str6.toString());
                bVar.a(a.AddTrack, "");
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str6) {
                try {
                    bVar.a(a.AddTrack, null, "");
                } catch (Exception e2) {
                    mm.b("ADD TRACKS TO PLAYLIST", "authenticate catch " + str3);
                    bVar.a(a.AddTrack, "");
                }
            }
        });
    }

    public void b(String str, String str2, String str3, final bdi.b bVar) {
        String str4 = "https://api.tidalhifi.com/v1/users/" + str + "/favorites/albums?token=" + this.d + "&countryCode=" + this.b + "&sessionId=" + str2;
        mm.b("FAV", str4);
        aus ausVar = new aus();
        ausVar.a("userId", Integer.parseInt(str));
        ausVar.a("albumId", str3);
        ausVar.a("sessionId", str2);
        agv.a(true).b(str4, ausVar, new aux() { // from class: bdh.6
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str5, Throwable th) {
                mm.b("FAV", str5.toString());
                bVar.a(a.AddFavouriteAlbum, "");
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str5) {
                try {
                    mm.b("FAV", str5.toString());
                    bVar.a(a.AddFavouriteAlbum, null, "");
                } catch (Exception e2) {
                    mm.b("FAV", "authenticate catch " + str5.toString());
                    bVar.a(a.AddFavouriteAlbum, "");
                }
            }
        });
    }

    public void a(Context context, String str, String str2, String str3, final bdi.b bVar) {
        String str4 = "https://api.tidalhifi.com/v1/users/" + str + "/favorites/albums/" + str3 + "?token=" + this.d + "&countryCode=" + this.b + "&sessionId=" + str2;
        mm.b("FAV", str4);
        aus ausVar = new aus();
        ausVar.a("userId", Integer.parseInt(str));
        ausVar.a("albumId", str3);
        ausVar.a("sessionId", str2);
        agv.a(true).a(context, str4, (Header[]) null, ausVar, new aux() { // from class: bdh.7
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str5, Throwable th) {
                mm.b("FAV", str5.toString());
                bVar.a(a.RemoveFavouriteAlbum, "");
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str5) {
                try {
                    mm.b("FAV", str5.toString());
                    bVar.a(a.RemoveFavouriteAlbum, null, "");
                } catch (Exception e2) {
                    mm.b("FAV", "authenticate catch " + str5.toString());
                    bVar.a(a.RemoveFavouriteAlbum, "");
                }
            }
        });
    }

    public void c(String str, String str2, String str3, final bdi.b bVar) {
        String str4 = "https://api.tidalhifi.com/v1/users/" + str + "/favorites/tracks?token=" + this.d + "&countryCode=" + this.b + "&sessionId=" + str2;
        mm.b("FAV", str4);
        aus ausVar = new aus();
        ausVar.a("userId", Integer.parseInt(str));
        ausVar.a("trackId", str3);
        ausVar.a("sessionId", str2);
        agv.a(true).b(str4, ausVar, new aux() { // from class: bdh.8
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str5, Throwable th) {
                mm.b("FAV", str5.toString());
                bVar.a(a.AddFavouriteTrack, "");
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str5) {
                try {
                    mm.b("FAV", str5.toString());
                    bVar.a(a.AddFavouriteTrack, null, "");
                } catch (Exception e2) {
                    mm.b("FAV", "authenticate catch " + str5.toString());
                    bVar.a(a.AddFavouriteTrack, "");
                }
            }
        });
    }

    public void b(Context context, String str, String str2, String str3, final bdi.b bVar) {
        String str4 = "https://api.tidalhifi.com/v1/users/" + str + "/favorites/tracks/" + str3 + "?token=" + this.d + "&countryCode=" + this.b + "&sessionId=" + str2;
        mm.b("FAV", str4);
        aus ausVar = new aus();
        ausVar.a("userId", Integer.parseInt(str));
        ausVar.a("trackId", str3);
        ausVar.a("sessionId", str2);
        agv.a(true).a(context, str4, (Header[]) null, ausVar, new aux() { // from class: bdh.9
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str5, Throwable th) {
                mm.b("FAV", str5.toString());
                bVar.a(a.RemoveFavouriteTrack, "");
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str5) {
                try {
                    mm.b("FAV", str5.toString());
                    bVar.a(a.RemoveFavouriteTrack, null, "");
                } catch (Exception e2) {
                    mm.b("FAV", "authenticate catch " + str5.toString());
                    bVar.a(a.RemoveFavouriteTrack, "");
                }
            }
        });
    }

    public void c(final Context context, final String str, final String str2, final String str3, final bdi.b bVar) {
        aue aueVarA = agv.a(true);
        final a aVar = a.PlaylistMetaData;
        aueVarA.a(bdi.a(bdi.c.PlaylistMetaData, str, "", 0, 50), (aus) null, new aum() { // from class: bdh.10
            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONObject jSONObject) {
                String value = "";
                for (int i2 = 0; i2 < headerArr.length; i2++) {
                    mm.b("PLAYLIST", headerArr[i2].getName());
                    if (headerArr[i2].getName().compareTo("ETag") == 0) {
                        value = headerArr[i2].getValue();
                    }
                }
                try {
                    bdh.this.a(context, str, str2, str3, value, bVar);
                } catch (Exception e2) {
                    mm.b("SEARCH", e2.toString());
                }
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, JSONArray jSONArray) {
                mm.b("debugresponse", jSONArray.toString());
                bVar.a(aVar, jSONArray);
            }

            @Override // defpackage.aum
            public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                bVar.a(aVar, "error " + i);
            }

            @Override // defpackage.aum, defpackage.aux
            public void a(int i, Header[] headerArr, String str4, Throwable th) {
                bVar.a(aVar, "Error with String");
            }
        });
    }

    public void a(Context context, String str, String str2, String str3, String str4, final bdi.b bVar) {
        String str5 = "https://api.tidalhifi.com/v1/playlists/" + str + "/tracks/" + str3 + "?token=" + this.d + "&countryCode=" + this.b + "&sessionId=" + str2;
        mm.b("FAV", str5);
        aus ausVar = new aus();
        ausVar.a("uuid", str);
        ausVar.a("indices", str3);
        ausVar.a("sessionId", str2);
        aue aueVarA = agv.a(true);
        aueVarA.a("If-None-Match", str4);
        aueVarA.a(context, str5, (Header[]) null, ausVar, new aux() { // from class: bdh.11
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str6, Throwable th) {
                mm.b("deleteTrack", "Fail");
                bVar.a(a.DeleteTrack, "");
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str6) {
                try {
                    mm.b("deleteTrack", "success");
                    bVar.a(a.DeleteTrack, null, "");
                } catch (Exception e2) {
                    mm.b("deleteTrack", "Fail");
                    bVar.a(a.DeleteTrack, "");
                }
            }
        });
    }

    public void d(String str, String str2, String str3, final bdi.b bVar) {
        String str4 = "https://api.tidalhifi.com/v1/users/" + str + "/favorites/playlists?token=" + this.d + "&countryCode=" + this.b + "&sessionId=" + str2;
        mm.b("FAV", str4);
        aus ausVar = new aus();
        ausVar.a("userId", Integer.parseInt(str));
        ausVar.a("uuid", str3);
        ausVar.a("sessionId", str2);
        agv.a(true).b(str4, ausVar, new aux() { // from class: bdh.13
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str5, Throwable th) {
                mm.b("FAV", str5.toString());
                bVar.a(a.AddFavouritePlaylist, "");
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str5) {
                try {
                    mm.b("FAV", str5.toString());
                    bVar.a(a.AddFavouritePlaylist, null, "");
                } catch (Exception e2) {
                    mm.b("FAV", "authenticate catch " + str5.toString());
                    bVar.a(a.AddFavouritePlaylist, "");
                }
            }
        });
    }

    public void d(Context context, String str, String str2, String str3, final bdi.b bVar) {
        String str4 = "https://api.tidalhifi.com/v1/users/" + str + "/favorites/playlists/" + str3 + "?token=" + this.d + "&countryCode=" + this.b + "&sessionId=" + str2;
        mm.b("FAV", str4);
        aus ausVar = new aus();
        ausVar.a("userId", Integer.parseInt(str));
        ausVar.a("uuid", str3);
        ausVar.a("sessionId", str2);
        agv.a(true).a(context, str4, (Header[]) null, ausVar, new aux() { // from class: bdh.14
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str5, Throwable th) {
                mm.b("FAV", str5.toString());
                bVar.a(a.RemoveFavouritePlaylist, "");
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str5) {
                try {
                    mm.b("FAV", str5.toString());
                    bVar.a(a.RemoveFavouritePlaylist, null, "");
                } catch (Exception e2) {
                    mm.b("FAV", "authenticate catch " + str5.toString());
                    bVar.a(a.RemoveFavouritePlaylist, "");
                }
            }
        });
    }

    public void e(String str, String str2, String str3, final bdi.b bVar) {
        String str4 = "https://api.tidalhifi.com/v1/users/" + str + "/favorites/artists?token=" + this.d + "&countryCode=" + this.b + "&sessionId=" + str2;
        mm.b("FAV", str4);
        aus ausVar = new aus();
        ausVar.a("userId", Integer.parseInt(str));
        ausVar.a("artistId", str3);
        ausVar.a("sessionId", str2);
        agv.a(true).b(str4, ausVar, new aux() { // from class: bdh.15
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str5, Throwable th) {
                mm.b("FAV", str5.toString());
                bVar.a(a.AddFavouriteArtist, "");
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str5) {
                try {
                    mm.b("FAV", str5.toString());
                    bVar.a(a.AddFavouriteArtist, null, "");
                } catch (Exception e2) {
                    mm.b("FAV", "authenticate catch " + str5.toString());
                    bVar.a(a.AddFavouriteArtist, "");
                }
            }
        });
    }

    public void e(Context context, String str, String str2, String str3, final bdi.b bVar) {
        String str4 = "https://api.tidalhifi.com/v1/users/" + str + "/favorites/artists/" + str3 + "?token=" + this.d + "&countryCode=" + this.b + "&sessionId=" + str2;
        mm.b("FAV", str4);
        aus ausVar = new aus();
        ausVar.a("userId", Integer.parseInt(str));
        ausVar.a("artistId", str3);
        ausVar.a("sessionId", str2);
        agv.a(true).a(context, str4, (Header[]) null, ausVar, new aux() { // from class: bdh.16
            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str5, Throwable th) {
                mm.b("FAV", str5.toString());
                bVar.a(a.RemoveFavouriteArtist, "");
            }

            @Override // defpackage.aux
            public void a(int i, Header[] headerArr, String str5) {
                try {
                    mm.b("FAV", str5.toString());
                    bVar.a(a.RemoveFavouriteArtist, null, "");
                } catch (Exception e2) {
                    mm.b("FAV", "authenticate catch " + str5.toString());
                    bVar.a(a.RemoveFavouriteArtist, "");
                }
            }
        });
    }

    public static TidalMusicDataLocal a(bdg bdgVar) {
        return bcw.a(bdgVar);
    }

    public static List<MusicData> a(List<bdg> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                TidalMusicDataLocal tidalMusicDataLocalA = a(list.get(i2));
                if (tidalMusicDataLocalA != null) {
                    arrayList.add(tidalMusicDataLocalA);
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }
}
