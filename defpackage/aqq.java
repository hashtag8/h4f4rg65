package defpackage;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.harman.commom.music.library.musicdata.AlbumData;
import com.harman.commom.music.library.musicdata.ArtistData;
import com.harman.commom.music.library.musicdata.CatalogDataInf;
import com.harman.commom.music.library.musicdata.GenreData;
import com.harman.commom.music.library.musicdata.LocalMusicData;
import com.harman.commom.music.library.musicdata.PlayListData;
import com.harman.commom.music.player.service.MusicData;
import com.harman.hkconnect.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class aqq {
    public static String[] a = {"_id", "mime_type", "suggest_text_1", "suggest_intent_query", "suggest_intent_data", "suggest_text_2"};

    public static List<afr> a(Context context, String str) {
        MusicData musicData;
        Cursor cursorA = a(context, Uri.parse("content://media/external/audio/search/search_suggest_query/" + Uri.encode(str)), a, null, null, null);
        if (cursorA == null || cursorA.getCount() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursorA.moveToNext()) {
            String string = cursorA.getString(cursorA.getColumnIndex("mime_type"));
            if ("artist".equals(string)) {
                ArtistData artistData = new ArtistData();
                artistData.j = cursorA.getString(cursorA.getColumnIndex("suggest_text_1"));
                artistData.h = cursorA.getInt(cursorA.getColumnIndex("_id"));
                artistData.l = 2001;
                artistData.n = a(context, artistData);
                if (artistData.n != null && artistData.n.size() > 0 && (musicData = artistData.n.get(0)) != null) {
                    artistData.i = musicData.album_id;
                }
                artistData.setPictureUri(ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), artistData.i));
                arrayList.add(artistData);
            } else if ("album".equals(string)) {
                AlbumData albumData = new AlbumData();
                albumData.j = cursorA.getString(cursorA.getColumnIndex("suggest_text_1"));
                albumData.h = cursorA.getInt(cursorA.getColumnIndex("_id"));
                albumData.m = cursorA.getString(cursorA.getColumnIndex("suggest_text_2"));
                albumData.l = 2001;
                albumData.setPictureUri(ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), albumData.h));
                arrayList.add(albumData);
            } else if (string.startsWith("audio")) {
                MusicData musicData2 = new MusicData();
                musicData2.musicName = cursorA.getString(cursorA.getColumnIndex("suggest_text_1"));
                musicData2.songId = cursorA.getInt(cursorA.getColumnIndex("_id"));
                musicData2.path = a(context, musicData2.songId);
                String[] strArrSplit = cursorA.getString(cursorA.getColumnIndex("suggest_text_2")).split("-");
                if (strArrSplit != null) {
                    if (strArrSplit.length >= 2) {
                        musicData2.artist = strArrSplit[0];
                        musicData2.album = strArrSplit[1];
                    } else if (strArrSplit.length >= 1) {
                        musicData2.artist = null;
                        musicData2.album = "";
                    }
                }
                musicData2.setPictureUri(ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), musicData2.album_id));
                arrayList.add(musicData2);
            }
            String string2 = cursorA.getString(cursorA.getColumnIndex("suggest_text_1"));
            int i = cursorA.getInt(cursorA.getColumnIndex("_id"));
            String string3 = cursorA.getString(cursorA.getColumnIndex("suggest_text_1"));
            String string4 = cursorA.getString(cursorA.getColumnIndex("suggest_text_1"));
            mm.b("mime_type = " + cursorA.getString(cursorA.getColumnIndex("mime_type")) + ", title = " + string2 + ", song_id = " + i + ", artist = " + string3 + ", album = " + string4 + ", path = " + cursorA.getString(cursorA.getColumnIndex("suggest_intent_data")) + ", detail = " + cursorA.getString(cursorA.getColumnIndex("suggest_text_2")), new Object[0]);
        }
        return a(context, arrayList);
    }

    public static List<afr> a(Context context, List<afr> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (afr afrVar : list) {
            if (afrVar instanceof ArtistData) {
                arrayList2.add(afrVar);
            } else if (afrVar instanceof AlbumData) {
                arrayList.add(afrVar);
            } else if (afrVar instanceof MusicData) {
                arrayList3.add(afrVar);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        if (arrayList != null && !arrayList.isEmpty()) {
            afs afsVar = new afs();
            afsVar.a(context.getString(R.string.LibNav_Artist_Str));
            afsVar.a(arrayList.size());
            arrayList4.add(afsVar);
            arrayList4.addAll(arrayList);
        }
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            afs afsVar2 = new afs();
            afsVar2.a(context.getString(R.string.LibNav_Album_Str));
            afsVar2.a(arrayList2.size());
            arrayList4.add(afsVar2);
            arrayList4.addAll(arrayList2);
        }
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            afs afsVar3 = new afs();
            afsVar3.a(context.getString(R.string.LibNav_Song_Str));
            afsVar3.a(arrayList3.size());
            arrayList4.add(afsVar3);
            arrayList4.addAll(arrayList3);
            return arrayList4;
        }
        return arrayList4;
    }

    public static Cursor a(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2, int i) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                return null;
            }
            return new aii(contentResolver.query(i > 0 ? uri.buildUpon().appendQueryParameter("limit", "" + i).build() : uri, strArr, str, strArr2, str2));
        } catch (UnsupportedOperationException e) {
            return null;
        }
    }

    public static Cursor a(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return a(context, uri, strArr, str, strArr2, str2, 0);
    }

    public static List<MusicData> a(Context context, CatalogDataInf catalogDataInf) throws Throwable {
        Cursor cursor = null;
        try {
            Cursor cursorA = catalogDataInf instanceof ArtistData ? a(context, aff.c, aff.h, "artist_id = " + catalogDataInf.h, null, null, 0) : null;
            if (cursorA != null) {
                try {
                    if (cursorA.getCount() != 0) {
                        ArrayList arrayList = new ArrayList();
                        int count = cursorA.getCount();
                        cursorA.moveToFirst();
                        for (int i = 0; i < count; i++) {
                            arrayList.add(new LocalMusicData(cursorA));
                            cursorA.moveToNext();
                        }
                        if (cursorA == null) {
                            return arrayList;
                        }
                        cursorA.close();
                        return arrayList;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorA;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorA != null) {
                cursorA.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0064: MOVE (r6 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:21:0x0064 */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r7, long r8) throws java.lang.Throwable {
        /*
            r6 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            r0.<init>()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            java.lang.String r1 = "title != ''"
            r0.append(r1)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            java.lang.String r1 = " AND is_music=1"
            r0.append(r1)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            r1.<init>()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            java.lang.String r2 = " AND _id="
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            java.lang.StringBuilder r1 = r1.append(r8)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            r0.append(r1)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            android.net.Uri r1 = defpackage.aff.c     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            java.lang.String[] r2 = defpackage.aff.h     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            java.lang.String r3 = r0.toString()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            r4 = 0
            r5 = 0
            r0 = r7
            android.database.Cursor r1 = a(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            if (r1 == 0) goto L3d
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L66
            if (r0 != 0) goto L3d
        L3d:
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L66
            java.lang.String r0 = "_data"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L66
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L66
            if (r1 == 0) goto L4f
            r1.close()
        L4f:
            return r0
        L50:
            r0 = move-exception
            r1 = r6
        L52:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L63
            if (r1 == 0) goto L68
            r1.close()
            r0 = r6
            goto L4f
        L5c:
            r0 = move-exception
        L5d:
            if (r6 == 0) goto L62
            r6.close()
        L62:
            throw r0
        L63:
            r0 = move-exception
            r6 = r1
            goto L5d
        L66:
            r0 = move-exception
            goto L52
        L68:
            r0 = r6
            goto L4f
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.aqq.a(android.content.Context, long):java.lang.String");
    }

    public static List<MusicData> a(Context context, CatalogDataInf catalogDataInf, int i) {
        Cursor cursorA;
        ArrayList arrayList = null;
        if (catalogDataInf instanceof AlbumData) {
            cursorA = a(context, aff.c, aff.h, "album_id = " + catalogDataInf.h, null, null, i);
        } else if (catalogDataInf instanceof ArtistData) {
            cursorA = a(context, aff.c, aff.h, "artist_id = " + catalogDataInf.h, null, null, i);
        } else if (catalogDataInf instanceof GenreData) {
            cursorA = a(context, MediaStore.Audio.Genres.Members.getContentUri("external", catalogDataInf.h), aff.h, "is_music=1 AND title!=''", null, null, i);
        } else if (catalogDataInf instanceof PlayListData) {
            cursorA = a(context, MediaStore.Audio.Playlists.Members.getContentUri("external", Long.valueOf(catalogDataInf.h).longValue()), aff.h, "title != ''", null, "play_order", i);
        } else {
            cursorA = null;
        }
        if (cursorA != null && cursorA.getCount() != 0) {
            arrayList = new ArrayList();
            while (cursorA.moveToNext()) {
                arrayList.add(new LocalMusicData(cursorA));
            }
        }
        return arrayList;
    }
}
