package defpackage;

import android.database.Cursor;
import android.os.AsyncTask;
import android.widget.Toast;
import com.harman.commom.music.library.musicdata.LocalMusicData;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class aqg extends AsyncTask<String, Void, ArrayList> {
    ArrayList<MusicData> a;
    public String b;
    private int c;
    private Cursor d;
    private int e;
    private String f;
    private int g;
    private int h;

    public aqg(String str, int i, Cursor cursor, int i2, String str2) {
        this(i, cursor, i2, str2);
        this.b = str;
    }

    public aqg(int i, Cursor cursor, int i2, String str) {
        this.e = -1;
        this.g = 0;
        this.h = 0;
        this.a = new ArrayList<>(cursor.getCount());
        this.d = cursor;
        this.c = i;
        this.e = i2;
        this.f = str;
    }

    public aqg(int i, Cursor cursor, int i2) {
        this(i, cursor, i2, (String) null);
    }

    public aqg(String str, int i, Cursor cursor, int i2) {
        this(i, cursor, i2);
        this.b = str;
    }

    public aqg(int i, Cursor cursor) {
        this(i, cursor, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ArrayList doInBackground(String... strArr) {
        for (int i = 0; i < this.d.getCount(); i++) {
            mm.b("CLLOG positionToPlay " + this.e, new Object[0]);
            LocalMusicData localMusicData = new LocalMusicData(i, this.d, this.b);
            if (!localMusicData.isLegal && this.e > i) {
                this.h++;
            }
            if (this.f != null && this.e != -1) {
                if (a(i, this.f)) {
                    this.a.add(localMusicData);
                } else if (i < this.e) {
                    this.g++;
                }
            } else {
                this.a.add(localMusicData);
            }
        }
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(ArrayList arrayList) {
        int i = this.e - this.g;
        if (i < 0) {
            i = 0;
        }
        if (!((MusicData) arrayList.get(i)).isLegal) {
            Toast.makeText(ain.J, R.string.PlayErrorTip_Str, 0).show();
        }
        this.e -= this.h;
        switch (this.c) {
            case 1:
                MusicPlaylistManager.a().a(arrayList);
                break;
            case 2:
                MusicPlaylistManager.a().c(arrayList);
                break;
            case 3:
                MusicPlaylistManager.a().d(arrayList);
                break;
            case 4:
                MusicPlaylistManager.a().g();
                if (this.e != -1) {
                    MusicPlaylistManager.a().a(arrayList, this.e - this.g);
                } else {
                    MusicPlaylistManager.a().b(arrayList);
                }
                break;
            case 5:
                MusicPlaylistManager.a().h();
                if (this.e != -1) {
                    MusicPlaylistManager.a().a(arrayList, this.e - this.g);
                } else {
                    MusicPlaylistManager.a().b(arrayList);
                }
                break;
            case 6:
                MusicPlaylistManager.a().g();
                MusicPlaylistManager.a().c(1);
                if (this.e != -1) {
                    MusicPlaylistManager.a().a(arrayList, this.e - this.g);
                } else {
                    MusicPlaylistManager.a().b(arrayList);
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Void... voidArr) {
    }

    private boolean a(int i, String str) {
        boolean z;
        int position = this.d.getPosition();
        this.d.moveToPosition(i);
        if (this.d.getString(this.d.getColumnIndex("album")).equals(str)) {
            z = true;
        } else {
            z = false;
        }
        this.d.moveToPosition(position);
        return z;
    }
}
