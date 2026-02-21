package defpackage;

import android.net.Uri;
import android.provider.MediaStore;
import com.harman.hkconnect.ui.HarmanApplication;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class aff {
    public static boolean a = true;
    public static int b = 2003;
    public static Uri c = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    public static Uri d = MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI;
    public static Uri e = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;
    public static Uri f = MediaStore.Audio.Genres.EXTERNAL_CONTENT_URI;
    public static Uri g = MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI;
    public static String[] h = {"audio._id AS _id", "_id", "_data", "_display_name", "_size", "duration", "title", "artist", "artist_id", "album", "album_id", "year"};
    public static String[] i = {"_id", "artist", "number_of_albums", "number_of_tracks"};
    public static String[] j = {"_id", "album", "artist", "album_art", "numsongs", "minyear"};
    public static String[] k = {"_id", "name"};
    public static String[] l = {"_id", "name"};
    public static String[] m = {"_id", "mime_type", "suggest_text_1", "suggest_intent_query", "suggest_intent_data", "suggest_text_2"};
    public static boolean n = false;
    public static boolean o = true;
    public static List<Integer> p = new ArrayList();
    public static String q = "HK_Connect.bin";
    public static int r = (int) (ahn.a(HarmanApplication.a().getApplicationContext()).a() * 0.8f);
    public static int s = (int) (ahn.a(HarmanApplication.a().getApplicationContext()).a() * 0.7f);
    public static int t = (int) (ahn.a(HarmanApplication.a().getApplicationContext()).a() * 0.6f);
    public static int u = (int) (ahn.a(HarmanApplication.a().getApplicationContext()).a() * 0.5f);
}
