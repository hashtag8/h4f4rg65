package defpackage;

import android.content.Context;
import android.os.AsyncTask;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: classes.dex */
public class bbi extends AsyncTask<String, Void, String> {
    private bbj a = new bbj();
    private Context b;
    private Map<String, String> c;
    private String d;
    private a e;

    public interface a {
        void a(boolean z, String str);
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public void a(Context context) {
        this.b = context;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.a.a(this.b, "Loading...", this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        a();
        if (str != null) {
            this.e.a(true, str);
        } else {
            a();
            this.e.a(false, str);
        }
    }

    protected void a() {
        this.a.a();
    }

    protected void b(String str) {
        if (str.contains("/stream?")) {
            this.a.getClass();
            this.d = "HK_SoundCloud_Stream_JSON_Shared_Prefs";
            return;
        }
        if (str.contains("https://api.soundcloud.com/playlists/") || str.contains("/me/favorites?")) {
            this.a.getClass();
            this.d = "HK_SoundCloud_Likes_JSON_Shared_Prefs";
            return;
        }
        if (str.contains("/explore/categories")) {
            this.a.getClass();
            this.d = "HK_SoundCloud_Explore_Genre_JSON_Shared_Prefs";
            return;
        }
        if (str.contains("/explore")) {
            this.a.getClass();
            this.d = "HK_SoundCloud_Explore_JSON_Shared_Prefs";
            return;
        }
        if (str.contains("/me/playlists?")) {
            this.a.getClass();
            this.d = "HK_SoundCloud_Playlist_Shared_Prefs";
        } else if (str.contains("search")) {
            this.a.getClass();
            this.d = "HK_SoundCloud_Search_JSON_Shared_Prefs";
        } else if (str.contains("/me")) {
            this.a.getClass();
            this.d = "HK_SoundCloud_Login_Prefs";
        }
    }

    protected void a(Map<String, String> map) {
        this.c = new HashMap(map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) {
        String strA;
        try {
            b(strArr[0]);
            HttpResponse httpResponseB = bbl.ak.b(bcj.a(strArr[0], new Object[0]).a(this.c));
            if (httpResponseB.getStatusLine().getStatusCode() == 200) {
                strA = bcg.a(httpResponseB);
                mm.b("\n" + strA, new Object[0]);
            } else {
                System.err.println("Invalid status received: " + httpResponseB.getStatusLine());
                strA = null;
            }
            return strA;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
