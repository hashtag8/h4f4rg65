package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import com.harman.commom.music.library.musicdata.AlbumData;
import com.harman.commom.music.library.musicdata.ArtistData;
import com.harman.commom.music.library.musicdata.GenreData;
import com.harman.commom.music.library.musicdata.LocalMusicData;
import com.harman.commom.music.library.musicdata.PlayListData;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class aif<T> extends BaseAdapter implements SectionIndexer {
    public static int i = -1;
    public static boolean j = false;
    public static boolean k = true;
    public boolean a;
    public Cursor b;
    protected HashMap<String, Integer> c;
    protected Context d;
    protected LayoutInflater e;
    protected int f;
    protected a<T> g;
    protected int h;
    private String[] l;
    private final String[] m;
    private b n;
    private int o;
    private boolean p;

    public interface a<T> {
        View a(int i, View view, ViewGroup viewGroup, T t);
    }

    public aif(Context context, a<T> aVar, int i2) {
        this(context, aVar, i2, i, k);
    }

    public aif(Context context, a<T> aVar, int i2, int i3, boolean z) {
        this.a = true;
        this.b = null;
        this.c = new HashMap<>();
        this.d = null;
        this.h = 0;
        this.l = new String[]{"#", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        this.m = new String[]{"a ", "A ", "an ", "An ", "the ", "The "};
        this.n = b.NONE;
        this.o = i;
        this.p = k;
        this.d = context;
        this.e = LayoutInflater.from(this.d);
        this.g = aVar;
        this.f = i2;
        this.a = true;
        this.o = i3;
        this.p = z;
    }

    public void a(Cursor cursor, b bVar) {
        if (cursor != null && bVar != b.NONE) {
            this.b = new aii(cursor);
            this.n = bVar;
            if (this.p != j) {
                for (int i2 = 0; i2 < this.b.getCount(); i2++) {
                    this.b.moveToPosition(i2);
                    String string = this.b.getString(this.b.getColumnIndex(bVar.a()));
                    if (string != null && string.length() != 0) {
                        String[] strArr = this.m;
                        int length = strArr.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                break;
                            }
                            String str = strArr[i3];
                            if (!string.startsWith(str)) {
                                i3++;
                            } else {
                                string = string.substring(str.length());
                                break;
                            }
                        }
                        String upperCase = string.substring(0, 1).toUpperCase();
                        if (!this.c.containsKey(upperCase)) {
                            this.c.put(upperCase, Integer.valueOf(i2));
                        }
                    }
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        int count = this.b.getCount();
        if (this.o != i && count > this.o) {
            return this.o;
        }
        return count;
    }

    public int a() {
        if (this.b != null) {
            return this.b.getCount();
        }
        return 0;
    }

    private LocalMusicData c() {
        LocalMusicData localMusicData = new LocalMusicData();
        localMusicData.path = this.b.getString(this.b.getColumnIndex("_data"));
        if (LocalMusicData.a(localMusicData.path)) {
            localMusicData.isLegal = true;
        } else {
            localMusicData.isLegal = false;
        }
        localMusicData.songId = this.b.getInt(this.b.getColumnIndex("_id"));
        localMusicData.musicName = this.b.getString(this.b.getColumnIndex("title"));
        localMusicData.artist = this.b.getString(this.b.getColumnIndex("artist"));
        localMusicData.artist_id = this.b.getLong(this.b.getColumnIndex("artist_id"));
        localMusicData.album = this.b.getString(this.b.getColumnIndex("album"));
        localMusicData.album_id = this.b.getLong(this.b.getColumnIndex("album_id"));
        localMusicData.duration = this.b.getLong(this.b.getColumnIndex("duration"));
        localMusicData.first_year = this.b.getInt(this.b.getColumnIndex("year"));
        localMusicData.type = 1;
        return localMusicData;
    }

    private AlbumData d() {
        AlbumData albumData = new AlbumData();
        albumData.h = this.b.getInt(this.b.getColumnIndex("_id"));
        albumData.j = this.b.getString(this.b.getColumnIndex("album"));
        albumData.m = this.b.getString(this.b.getColumnIndex("artist"));
        albumData.l = 2001;
        albumData.p = this.b.getInt(this.b.getColumnIndex("minyear"));
        albumData.o = this.b.getInt(this.b.getColumnIndex("numsongs"));
        return albumData;
    }

    private ArtistData e() {
        ArtistData artistData = new ArtistData();
        artistData.h = this.b.getInt(this.b.getColumnIndex("_id"));
        artistData.j = this.b.getString(this.b.getColumnIndex("artist"));
        artistData.l = 2001;
        artistData.o = this.b.getInt(this.b.getColumnIndex("number_of_tracks"));
        artistData.k = this.b.getInt(this.b.getColumnIndex("number_of_albums"));
        artistData.m = this.b.getString(this.b.getColumnIndex("artist"));
        artistData.i = afm.b(artistData, this.d);
        return artistData;
    }

    private GenreData f() {
        GenreData genreData = new GenreData();
        genreData.h = this.b.getInt(this.b.getColumnIndex("_id"));
        genreData.j = this.b.getString(this.b.getColumnIndex("name"));
        genreData.l = 2001;
        return genreData;
    }

    private PlayListData g() {
        PlayListData playListData = new PlayListData();
        playListData.h = this.b.getInt(this.b.getColumnIndex("_id"));
        playListData.j = this.b.getString(this.b.getColumnIndex("name"));
        playListData.l = 2001;
        playListData.i = afm.b(playListData, this.d);
        return playListData;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        if (this.b == null) {
            return null;
        }
        this.b.moveToPosition(i2);
        switch (this.n) {
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (this.b != null) {
            if (view == null || view.getTag() == null) {
                view = this.e.inflate(this.f, viewGroup, false);
            }
            return this.g.a(i2, view, viewGroup, getItem(i2));
        }
        return view;
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return this.l;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i2) {
        while (i2 >= 0) {
            if (!this.c.containsKey(this.l[i2])) {
                i2--;
            } else {
                return this.c.get(this.l[i2]).intValue();
            }
        }
        return 0;
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i2) {
        return 0;
    }

    public void b() {
        if (this.b != null) {
            this.b.close();
            this.b = null;
        }
        notifyDataSetChanged();
    }

    public enum b {
        NONE("none"),
        SONG("title"),
        ALBUM("album"),
        ARTIST("artist"),
        GENRE("name"),
        PLAYLIST("name");

        private String g;

        b(String str) {
            this.g = str;
        }

        public String a() {
            return this.g;
        }
    }
}
