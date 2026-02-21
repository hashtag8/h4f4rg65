package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;
import com.musicservice.tidal.model.TidalMusicDataLocal;
import defpackage.bdh;
import defpackage.bdi;
import defpackage.bdo;
import java.util.ArrayList;
import java.util.Hashtable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bcw {
    public static int a = 0;
    private static Hashtable<String, Typeface> b = new Hashtable<>();
    private static bdi.b c = new bdi.b() { // from class: bcw.3
        @Override // bdi.b
        public void a(bdh.a aVar, JSONObject jSONObject, String str) {
            ArrayList<bdg> arrayListA = bcv.a(jSONObject);
            HarmanApplication.a().sendBroadcast(new Intent("START_SHAKE_ANIMATION"));
            MusicPlaylistManager.a().h();
            MusicPlaylistManager.a().e(bdh.a(arrayListA));
        }

        @Override // bdi.b
        public void a(bdh.a aVar, JSONArray jSONArray) {
        }

        @Override // bdi.b
        public void a(bdh.a aVar, String str) {
        }
    };

    public static String a(int i) {
        String str;
        String str2;
        String str3;
        int iFloor = (int) Math.floor(i / 3600);
        int i2 = i % 3600;
        int iFloor2 = (int) Math.floor(i2 / 60);
        int iCeil = (int) Math.ceil(i2 % 60);
        if (iFloor2 < 10) {
            str = "0" + iFloor2;
        } else {
            str = iFloor2 + "";
        }
        if (iCeil < 10) {
            str2 = "0" + iCeil;
        } else {
            str2 = iCeil + "";
        }
        if (iFloor == 0) {
            str3 = "";
        } else if (iFloor < 10) {
            str3 = "0" + iFloor + ":";
        } else {
            str3 = iFloor + ":";
        }
        return str3 + str + ":" + str2;
    }

    public static TidalMusicDataLocal a(bdg bdgVar) {
        TidalMusicDataLocal tidalMusicDataLocal = new TidalMusicDataLocal();
        tidalMusicDataLocal.path = bdgVar.e;
        tidalMusicDataLocal.songId = Integer.parseInt(bdgVar.c);
        tidalMusicDataLocal.musicName = bdgVar.d;
        tidalMusicDataLocal.artist_id = Integer.parseInt(bdgVar.b);
        tidalMusicDataLocal.artist = bdgVar.a;
        tidalMusicDataLocal.album = bdgVar.h;
        tidalMusicDataLocal.album_id = Integer.parseInt(bdgVar.g);
        tidalMusicDataLocal.album_art = "http://resources.wimpmusic.com/images/" + bdgVar.i.replace("-", "/") + "/320x320.jpg";
        tidalMusicDataLocal.a = bdgVar.j;
        tidalMusicDataLocal.b = bdgVar.k;
        tidalMusicDataLocal.c = bdgVar.l;
        if (!bdgVar.j || !bdgVar.k) {
            tidalMusicDataLocal.isLegal = false;
        }
        tidalMusicDataLocal.duration = bdgVar.f * 1000;
        return tidalMusicDataLocal;
    }

    public static Typeface a(Context context) {
        Typeface typeface = b.get("Roboto-Bold.ttf");
        if (typeface == null) {
            try {
                Typeface typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), "Roboto-Bold.ttf");
                b.put("Roboto-Bold.ttf", typefaceCreateFromAsset);
                return typefaceCreateFromAsset;
            } catch (Exception e) {
                return null;
            }
        }
        return typeface;
    }

    public static Typeface b(Context context) {
        Typeface typeface = b.get("Roboto-Regular.ttf");
        if (typeface == null) {
            try {
                Typeface typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), "Roboto-Regular.ttf");
                b.put("Roboto-Regular.ttf", typefaceCreateFromAsset);
                return typefaceCreateFromAsset;
            } catch (Exception e) {
                return null;
            }
        }
        return typeface;
    }

    public static void a(final Context context, String str, String str2, String str3, final bdi.b bVar) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.tidal_create_playlist_dialog, (ViewGroup) null);
        final EditText editText = (EditText) viewInflate.findViewById(R.id.title_edit);
        editText.setText(str);
        final EditText editText2 = (EditText) viewInflate.findViewById(R.id.description_edit);
        editText2.setText(str2);
        new asc(new bdo.a(context).a(context.getResources().getString(R.string.TidalEditPlaylist)).a(viewInflate).a(context.getResources().getString(R.string.TidalSavePlaylist), new DialogInterface.OnClickListener() { // from class: bcw.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                mm.b("EDIT", "name=" + ((Object) editText.getText()) + " description=" + ((Object) editText2.getText()));
                if (editText.getText().toString().trim().compareTo("") == 0) {
                    Toast.makeText(context, context.getString(R.string.TidalPlaylistCreateErrorBlurb), 1).show();
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("title", editText.getText().toString());
                    jSONObject.put("description", editText2.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bVar.a(bdh.a.PreEditPlaylist, jSONObject, "");
                dialogInterface.dismiss();
            }
        }).a(true).a()).a(null);
    }

    public static void a(final Context context, String str, final ArrayList<bdc> arrayList, final String str2, final bdi.b bVar) {
        bdp bdpVar = new bdp(context, str);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(context.getResources().getString(R.string.TidalCreateNewPlaylist));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                arrayList2.add(arrayList.get(i2).a);
                i = i2 + 1;
            } else {
                bdpVar.a(arrayList2);
                bdpVar.a(str);
                bdpVar.a(new asi() { // from class: bcw.2
                    @Override // defpackage.asi
                    public void a(int i3) {
                        if (i3 == 0) {
                            View viewInflate = LayoutInflater.from(context).inflate(R.layout.tidal_create_playlist_dialog, (ViewGroup) null);
                            final EditText editText = (EditText) viewInflate.findViewById(R.id.title_edit);
                            final EditText editText2 = (EditText) viewInflate.findViewById(R.id.description_edit);
                            new asc(new bdo.a(context).a(context.getResources().getString(R.string.TidalCreateNewPlaylist)).a(viewInflate).a(context.getResources().getString(R.string.TidalCreate), new DialogInterface.OnClickListener() { // from class: bcw.2.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i4) {
                                    if (editText.getText().toString().trim().compareTo("") == 0) {
                                        Toast.makeText(context, context.getString(R.string.TidalPlaylistCreateErrorBlurb), 1).show();
                                        return;
                                    }
                                    mm.b("CREATE", "name=" + ((Object) editText.getText()) + " description=" + ((Object) editText2.getText()) + " TRACKS=" + str2);
                                    bdh.a().a(aho.d("tidal_user_auth_token").trim(), aho.d("tidal_session_auth_token").trim(), editText.getText().toString(), editText2.getText().toString(), str2, bVar);
                                    dialogInterface.dismiss();
                                    bVar.a(bdh.a.ShowProgress, null, "");
                                }
                            }).a(true).a()).a(null);
                            return;
                        }
                        mm.b("ADD TO PLAYLIST", "adding " + str2 + " to " + ((bdc) arrayList.get(i3 - 1)).b);
                        bdh.a().a(((bdc) arrayList.get(i3 - 1)).b, aho.d("tidal_session_auth_token").trim(), str2, bVar);
                    }
                });
                bdpVar.show();
                return;
            }
        }
    }

    public static void a(bda bdaVar) {
        bdh.a().a(bdh.a.AlbumTracks, c, bdaVar.a, "", -1, -1);
    }

    public static void a(bdb bdbVar) {
        bdh.a().a(bdh.a.ArtistTracks, c, bdbVar.b, "", -1, -1);
    }
}
