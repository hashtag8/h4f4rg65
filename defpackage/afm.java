package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class afm {
    static HashMap<Long, Integer> a = new HashMap<>();
    static HashMap<Long, Integer> b = new HashMap<>();

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00c7: MOVE (r9 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:40:0x00c7 */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.harman.commom.music.player.service.MusicData> a(com.harman.commom.music.library.musicdata.CatalogDataInf r11, android.content.Context r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.afm.a(com.harman.commom.music.library.musicdata.CatalogDataInf, android.content.Context):java.util.List");
    }

    public static Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, int i, int i2, Context context) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                return null;
            }
            return new aii(contentResolver.query(i2 > 0 ? uri.buildUpon().appendQueryParameter("limit", (i * i2) + "," + i2).build() : uri, strArr, str, strArr2, a(a(a(str2, "A"), "An"), "The") + " COLLATE NOCASE ASC"));
        } catch (Exception e) {
            e.printStackTrace();
            return new aii(null);
        }
    }

    private static String a(String str, String str2) {
        return "REPLACE ('<BEGIN>' || " + str + ", '<BEGIN>" + str2 + " ', '<BEGIN>')";
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long b(com.harman.commom.music.library.musicdata.CatalogDataInf r14, android.content.Context r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.afm.b(com.harman.commom.music.library.musicdata.CatalogDataInf, android.content.Context):long");
    }
}
