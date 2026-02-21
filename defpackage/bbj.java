package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import com.harman.hkconnect.R;
import com.musicservice.soundcloud.api.Stream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class bbj {
    public static ProgressDialog u;
    public final String c = "HK_SoundCloud_TAG";
    public final String d = "HK_SoundCloud_Token_Tag";
    public final String e = "HK_SoundCloud_Username_Tag";
    public final String f = "HK_SoundCloud_Shared_Prefs";
    public final String g = "HK_SoundCloud_Stream_JSON_Shared_Prefs";
    public final String h = "HK_SoundCloud_Likes_JSON_Shared_Prefs";
    public final String i = "HK_SoundCloud_Likes_JSON_String";
    public final String j = "HK_SoundCloud_Likes_Title_JSON_String";
    public final String k = "HK_SoundCloud_Explore_JSON_Shared_Prefs";
    public final String l = "HK_SoundCloud_Explore_Genre_JSON_Shared_Prefs";
    public final String m = "HK_SoundCloud_Explore_Genre_JSON_String";
    public final String n = "HK_SoundCloud_Playlist_Count";
    public final String o = "HK_SoundCloud_Playlist_Shared_Prefs";
    public final String p = "HK_SoundCloud_Search_JSON_Shared_Prefs";
    public final String q = "HK_SoundCloud_Search_JSON_String";
    public final String r = "HK_SoundCloud_Login_Prefs";
    public int s = 0;
    public Map<String, String> t = new HashMap();
    public static Stream a = null;
    public static final URI b = URI.create("http://www.harmankardon.com/wireless");
    public static String v = "SoundCloudUserName";

    public void a(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    public void a(final Context context, String str, final bbi bbiVar) {
        if (u == null || !u.isShowing()) {
            u = new ProgressDialog(ain.J);
            u.setCancelable(true);
            u.setCanceledOnTouchOutside(false);
            u.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: bbj.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    bbiVar.cancel(true);
                    bbj.this.a(ain.J, context.getResources().getString(R.string.RdioRequestCancelled_Str));
                }
            });
            u.setMessage(str);
            new asc(u).a(null);
        }
    }

    public void a() {
        if (u != null && u.isShowing()) {
            u.dismiss();
        }
    }
}
