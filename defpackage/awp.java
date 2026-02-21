package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import com.musicservice.juke.model.JukeMusicDataLocal;
import defpackage.arw;
import defpackage.axd;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class awp {
    public static int a = 0;

    public static boolean a(CharSequence charSequence) {
        return !TextUtils.isEmpty(charSequence) && Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }

    public static HashMap<String, String> a(JSONObject jSONObject) {
        HashMap<String, String> map = new HashMap<>();
        if (jSONObject == null) {
            return map;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("links");
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("linkTemplates");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                    map.put(jSONObject2.getString("rel"), jSONObject2.getString("href"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                try {
                    JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i2);
                    map.put(jSONObject3.getString("rel"), jSONObject3.getString("href"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return map;
    }

    public static String a(String str) {
        if (str == null || str.compareTo("") == 0) {
            return "";
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.'0000000Z'");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = simpleDateFormat.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return simpleDateFormat2.format(date);
    }

    public static String a(int i) {
        String str;
        String str2;
        String str3;
        int iFloor = (int) Math.floor(i / 3600);
        int i2 = i % 3600;
        int iFloor2 = (int) Math.floor(i2 / 60);
        int iCeil = (int) Math.ceil(i2 % 60);
        if (iFloor < 10) {
            str = "0" + iFloor;
        } else {
            str = iFloor + "";
        }
        if (iFloor2 < 10) {
            str2 = "0" + iFloor2;
        } else {
            str2 = iFloor2 + "";
        }
        if (iCeil < 10) {
            str3 = "0" + iCeil;
        } else {
            str3 = iCeil + "";
        }
        String str4 = str2 + ":" + str3;
        if (iFloor > 0) {
            return str + ":" + str4;
        }
        return str4;
    }

    public static JukeMusicDataLocal a(axb axbVar) {
        String str;
        JukeMusicDataLocal jukeMusicDataLocal = new JukeMusicDataLocal();
        jukeMusicDataLocal.path = "";
        jukeMusicDataLocal.a = axbVar.i;
        if (axbVar.a != null && axbVar.a.compareTo("") != 0) {
            try {
                jukeMusicDataLocal.songId = Integer.parseInt(axbVar.a);
            } catch (Exception e) {
                jukeMusicDataLocal.songId = 0L;
            }
        } else {
            jukeMusicDataLocal.songId = 0L;
        }
        jukeMusicDataLocal.musicName = axbVar.b;
        jukeMusicDataLocal.artist = axbVar.c;
        jukeMusicDataLocal.album = axbVar.d;
        if (axbVar.i.containsKey("catalog:image-1024x1024")) {
            str = axbVar.i.get("catalog:image-1024x1024");
        } else if (axbVar.i.containsKey("catalog:image-512x512")) {
            str = axbVar.i.get("catalog:image-512x512");
        } else {
            str = axbVar.i.containsKey("catalog:image-256x256") ? axbVar.i.get("catalog:image-256x256") : axbVar.i.get("catalog:image-128x128");
        }
        jukeMusicDataLocal.album_art = str;
        jukeMusicDataLocal.duration = axbVar.e * 1000;
        return jukeMusicDataLocal;
    }

    public static List<MusicData> a(List<axb> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                JukeMusicDataLocal jukeMusicDataLocalA = a(list.get(i2));
                if (jukeMusicDataLocalA != null) {
                    arrayList.add(jukeMusicDataLocalA);
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    public static ArrayList<axb> b(JSONObject jSONObject) {
        ArrayList<axb> arrayList = new ArrayList<>();
        JSONArray jSONArray = null;
        try {
            jSONArray = jSONObject.getJSONArray("entries");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                axb axbVar = new axb();
                axbVar.a = jSONObjectOptJSONObject.optString("id");
                axbVar.b = jSONObjectOptJSONObject.optString("name");
                axbVar.c = jSONObjectOptJSONObject.optString("artistName");
                axbVar.d = jSONObjectOptJSONObject.optString("albumName");
                axbVar.e = jSONObjectOptJSONObject.optInt("lengthInSeconds");
                axbVar.f = jSONObjectOptJSONObject.optString("genre");
                axbVar.g = jSONObjectOptJSONObject.optString("label");
                axbVar.h = jSONObjectOptJSONObject.optString("releaseYear");
                jSONObjectOptJSONObject.optJSONArray("links");
                axbVar.i = a(jSONObjectOptJSONObject);
                arrayList.add(axbVar);
            }
        }
        return arrayList;
    }

    public static void a(final Context context, String str, final ArrayList<awz> arrayList, final JSONArray jSONArray, final axd.b bVar) {
        arz arzVar = new arz(context);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(context.getResources().getString(R.string.JukeCreateNewPlaylist));
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(arrayList.get(i).b);
            mm.b("PLAYLIST", "adding " + arrayList.get(i).b);
        }
        arzVar.a(arrayList2);
        arzVar.a(str);
        arzVar.a(new asi() { // from class: awp.1
            @Override // defpackage.asi
            public void a(int i2) {
                if (i2 == 0) {
                    View viewInflate = LayoutInflater.from(context).inflate(R.layout.juke_create_playlist_dialog, (ViewGroup) null);
                    final EditText editText = (EditText) viewInflate.findViewById(R.id.title_edit);
                    final EditText editText2 = (EditText) viewInflate.findViewById(R.id.description_edit);
                    new asc(new arw.a(context).b(context.getResources().getString(R.string.JukeCreateNewPlaylist)).a(viewInflate).a(context.getResources().getString(R.string.JukeCreate), new DialogInterface.OnClickListener() { // from class: awp.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            if (editText.getText().toString().trim().compareTo("") == 0) {
                                Toast.makeText(context, context.getString(R.string.JukePlaylistCreateErrorBlurb), 1).show();
                            } else {
                                axc.a().a(axc.a().e, "user:playlists", bVar, editText.getText().toString(), editText.getText().toString(), editText2.getText().toString(), "private", jSONArray);
                            }
                        }
                    }).d(true).b()).a(null);
                    return;
                }
                axc.a().a(((awz) arrayList.get(i2 - 1)).c, "user:playlist-entries", bVar, 0, jSONArray);
            }
        });
        arzVar.show();
    }

    public static void a(final Context context, final axd.b bVar) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.juke_create_playlist_dialog, (ViewGroup) null);
        final EditText editText = (EditText) viewInflate.findViewById(R.id.title_edit);
        final EditText editText2 = (EditText) viewInflate.findViewById(R.id.description_edit);
        new asc(new arw.a(context).b(context.getResources().getString(R.string.JukeCreateNewPlaylist)).a(viewInflate).a(context.getResources().getString(R.string.JukeCreate), new DialogInterface.OnClickListener() { // from class: awp.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (editText.getText().toString().trim().compareTo("") == 0) {
                    Toast.makeText(context, context.getString(R.string.JukePlaylistCreateErrorBlurb), 1).show();
                } else {
                    axc.a().a(axc.a().e, "user:playlists", bVar, editText.getText().toString(), editText.getText().toString(), editText2.getText().toString(), "private", (JSONArray) null);
                }
            }
        }).d(true).b()).a(null);
    }

    public static void a(final Context context, final HashMap<String, String> map, final awz awzVar, final axd.b bVar, final boolean z) {
        awo awoVar = new awo(context, awzVar.b);
        ArrayList arrayList = new ArrayList();
        arrayList.add(context.getString(R.string.JukeRemove));
        arrayList.add(context.getString(R.string.JukeRename));
        awoVar.a(arrayList);
        awoVar.a(context.getString(R.string.JukePlaylists) + "-" + awzVar.b);
        awoVar.a(new asi() { // from class: awp.3
            @Override // defpackage.asi
            public void a(int i) {
                if (i == 1) {
                    View viewInflate = LayoutInflater.from(context).inflate(R.layout.juke_create_playlist_dialog, (ViewGroup) null);
                    final EditText editText = (EditText) viewInflate.findViewById(R.id.title_edit);
                    editText.setText(awzVar.b);
                    final EditText editText2 = (EditText) viewInflate.findViewById(R.id.description_edit);
                    editText2.setText(awzVar.d);
                    new asc(new arw.a(context).b(context.getString(R.string.JukePlaylists) + "-" + awzVar.b).a(viewInflate).a(context.getString(R.string.JukeOK), new DialogInterface.OnClickListener() { // from class: awp.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            mm.b("EDIT", "name=" + ((Object) editText.getText()) + " description=" + ((Object) editText2.getText()));
                            if (editText.getText().toString().trim().compareTo("") == 0) {
                                Toast.makeText(context, context.getString(R.string.JukePlaylistCreateErrorBlurb), 1).show();
                                return;
                            }
                            awzVar.b = editText.getText().toString();
                            awzVar.d = editText2.getText().toString();
                            axc.a().a(map, "user:playlist", bVar, awzVar.a, editText.getText().toString(), editText2.getText().toString(), "private");
                        }
                    }).d(true).b()).a(null);
                    return;
                }
                axc.a().b(map, "user:playlist", bVar);
                if (z) {
                    ((DashboardActivity) context).onBackPressed();
                }
            }
        });
        awoVar.show();
    }

    public static void a(aww awwVar) {
        axc.a().a(awwVar.i, "catalog:album", new axd.b() { // from class: awp.4
            @Override // axd.b
            public void a(String str, JSONObject jSONObject, String str2) {
                if (str.compareTo("catalog:album") == 0) {
                    mm.b("CATALOG", jSONObject.toString());
                    try {
                        aww awwVar2 = new aww();
                        awwVar2.a = jSONObject.optString("id");
                        awwVar2.b = jSONObject.optString("name");
                        awwVar2.c = jSONObject.optString("artistName");
                        awwVar2.f = jSONObject.optInt("trackCount");
                        awwVar2.d = jSONObject.optString("lengthInSeconds");
                        awwVar2.e = jSONObject.optString("genre");
                        awwVar2.g = jSONObject.optString("label");
                        awwVar2.h = jSONObject.optString("releaseYear");
                        awwVar2.i = awp.a(jSONObject);
                        if (awwVar2.i.containsKey("self")) {
                            awwVar2.i.put("catalog:album", awwVar2.i.get("self"));
                        }
                        awp.b(jSONObject.getJSONArray("tracks"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // axd.b
            public void a(String str, JSONArray jSONArray) {
            }

            @Override // axd.b
            public void a(String str, String str2) {
            }
        }, "", "", -1, -1);
    }

    public static void a(awx awxVar) {
        axc.a().a(awxVar.g, "catalog:artist-tracks", new axd.b() { // from class: awp.5
            @Override // axd.b
            public void a(String str, JSONObject jSONObject, String str2) {
                if (str.compareTo("catalog:artist-tracks") == 0) {
                    mm.b("CATALOG", jSONObject.toString());
                    try {
                        awp.b(jSONObject.getJSONArray("tracks"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // axd.b
            public void a(String str, JSONArray jSONArray) {
            }

            @Override // axd.b
            public void a(String str, String str2) {
            }
        }, "", "", -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                axb axbVar = new axb();
                axbVar.a = jSONObjectOptJSONObject.optString("id");
                axbVar.b = jSONObjectOptJSONObject.optString("name");
                axbVar.c = jSONObjectOptJSONObject.optString("artistName");
                axbVar.d = jSONObjectOptJSONObject.optString("albumName");
                axbVar.e = jSONObjectOptJSONObject.optInt("lengthInSeconds");
                axbVar.f = jSONObjectOptJSONObject.optString("genre");
                axbVar.g = jSONObjectOptJSONObject.optString("label");
                axbVar.h = jSONObjectOptJSONObject.optString("releaseYear");
                axbVar.i = a(jSONObjectOptJSONObject);
                JukeMusicDataLocal jukeMusicDataLocalA = a(axbVar);
                if (jukeMusicDataLocalA != null) {
                    arrayList.add(jukeMusicDataLocalA);
                }
            }
        }
        MusicPlaylistManager.a().h();
        MusicPlaylistManager.a().e(arrayList);
    }
}
