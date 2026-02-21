package defpackage;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import com.harman.commom.music.library.musicdata.AlbumData;
import com.harman.commom.music.library.musicdata.ArtistData;
import com.harman.commom.music.library.musicdata.CatalogDataInf;
import com.harman.commom.music.library.musicdata.LocalMusicData;
import com.harman.commom.music.player.service.MusicData;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class afn implements afo {
    private static afn q;
    public List<CatalogDataInf> a;
    private Context b;
    private a d;
    private volatile boolean f;
    private volatile boolean g;
    private volatile boolean h;
    private volatile boolean i;
    private volatile boolean j;
    private Cursor k;
    private Cursor l;
    private Cursor m;
    private Cursor n;
    private Cursor o;
    private Cursor p;
    private final HashSet<afq> c = new HashSet<>();
    private String e = "external";

    static class a extends Handler {
        private final WeakReference<afn> a;

        public a(afn afnVar, Looper looper) {
            super(looper);
            this.a = new WeakReference<>(afnVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            afn afnVar = this.a.get();
            if (afnVar != null) {
                switch (message.what) {
                    case 0:
                        synchronized (afnVar.c) {
                            for (afq afqVar : afnVar.c) {
                                if (afnVar.k != null) {
                                    afqVar.a(afnVar.k);
                                }
                            }
                            break;
                        }
                        return;
                    case 1:
                        synchronized (afnVar.c) {
                            for (afq afqVar2 : afnVar.c) {
                                if (afnVar.l != null) {
                                    afqVar2.b(afnVar.l);
                                }
                            }
                            break;
                        }
                        return;
                    case 2:
                        synchronized (afnVar.c) {
                            for (afq afqVar3 : afnVar.c) {
                                if (afnVar.m != null) {
                                    afqVar3.c(afnVar.m);
                                }
                            }
                            break;
                        }
                        return;
                    case 3:
                        synchronized (afnVar.c) {
                            for (afq afqVar4 : afnVar.c) {
                                if (afnVar.n != null) {
                                    afqVar4.d(afnVar.n);
                                }
                            }
                            break;
                        }
                        return;
                    case 4:
                        synchronized (afnVar.c) {
                            for (afq afqVar5 : afnVar.c) {
                                if (afnVar.o != null) {
                                    afqVar5.e(afnVar.o);
                                }
                            }
                            break;
                        }
                        return;
                    case 5:
                        synchronized (afnVar.c) {
                            for (afq afqVar6 : afnVar.c) {
                                if (afnVar.p != null) {
                                    afqVar6.a(afnVar.p);
                                }
                            }
                            break;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public ArrayList<Cursor> f() {
        ArrayList<Cursor> arrayList = new ArrayList<>();
        if (this.l == null || this.m == null || this.k == null || this.n == null || this.o == null) {
            return null;
        }
        arrayList.add(this.m);
        arrayList.add(this.l);
        arrayList.add(this.k);
        arrayList.add(this.n);
        arrayList.add(this.o);
        return arrayList;
    }

    public static afn g() {
        if (q == null) {
            q = new afn(HarmanApplication.a());
        }
        return q;
    }

    private afn(Context context) {
        HandlerThread handlerThread = new HandlerThread("music");
        handlerThread.start();
        this.d = new a(this, handlerThread.getLooper());
        this.b = context;
    }

    @Override // defpackage.afo
    public void a(final int i, final int i2, final String str) {
        this.i = false;
        a(new Runnable() { // from class: afn.1
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                String[] strArr = null;
                afn.this.a = new ArrayList();
                if (bru.a((CharSequence) str)) {
                    str2 = null;
                } else {
                    str2 = "artist LIKE ?";
                    strArr = new String[]{"%" + str + "%"};
                }
                afn.this.m = afm.a(aff.d, aff.i, str2, strArr, "artist_key", i, i2, afn.this.b);
                if (!afn.this.i) {
                    afn.this.d.obtainMessage(2).sendToTarget();
                }
            }
        });
    }

    @Override // defpackage.afo
    public void b(final int i, final int i2, final String str) {
        this.f = false;
        a(new Runnable() { // from class: afn.2
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                String[] strArr = null;
                afn.this.a = new ArrayList();
                if (bru.a((CharSequence) str)) {
                    str2 = null;
                } else {
                    str2 = "album LIKE ?";
                    strArr = new String[]{"%" + str + "%"};
                }
                afn.this.l = afm.a(aff.e, aff.j, str2, strArr, "album_key", i, i2, afn.this.b);
                if (!afn.this.f) {
                    afn.this.d.obtainMessage(1).sendToTarget();
                }
            }
        });
    }

    @Override // defpackage.afo
    public void e(final int i, final int i2, final String str) {
        this.h = false;
        a(new Runnable() { // from class: afn.3
            @Override // java.lang.Runnable
            public void run() {
                afn.this.a = new ArrayList();
                StringBuilder sb = new StringBuilder();
                String[] strArr = null;
                sb.append("name != ''");
                if (!bru.a((CharSequence) str)) {
                    sb.append(" AND name LIKE ?");
                    strArr = new String[]{"%" + str + "%"};
                }
                afn.this.n = afm.a(aff.g, aff.l, sb.toString(), strArr, "name", i, i2, afn.this.b);
                if (!afn.this.h) {
                    afn.this.d.obtainMessage(3).sendToTarget();
                }
            }
        });
    }

    @Override // defpackage.afo
    public void c(final int i, final int i2, final String str) {
        this.g = false;
        a(new Runnable() { // from class: afn.4
            @Override // java.lang.Runnable
            public void run() {
                afn.this.a = new ArrayList();
                StringBuilder sb = new StringBuilder();
                String[] strArr = null;
                sb.append("name!=''");
                if (!bru.a((CharSequence) str)) {
                    sb.append(" AND name LIKE ?");
                    strArr = new String[]{"%" + str + "%"};
                }
                afn.this.o = afm.a(aff.f, aff.k, sb.toString(), strArr, "name", i, i2, afn.this.b);
                if (!afn.this.g) {
                    afn.this.d.obtainMessage(4).sendToTarget();
                }
            }
        });
    }

    @Override // defpackage.afo
    public void d(final int i, final int i2, final String str) {
        this.j = false;
        a(new Runnable() { // from class: afn.5
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb = new StringBuilder();
                String[] strArr = null;
                sb.append("title != \"\" ");
                sb.append(" AND is_music=1 AND ( NOT(duration <= 10000 OR _size <= 500000 ))");
                if (!bru.a((CharSequence) str)) {
                    sb.append(" AND (title LIKE ? OR artist LIKE ? OR album LIKE ? )");
                    strArr = new String[]{"%" + str + "%", "%" + str + "%", "%" + str + "%"};
                }
                mm.b("LocalMusicLibraryImp Query string = ", sb.toString());
                afn.this.k = afm.a(aff.c, aff.h, sb.toString(), strArr, "title", i, i2, afn.this.b);
                if (!afn.this.j) {
                    afn.this.d.obtainMessage(0).sendToTarget();
                    mm.b("ryan", "=======getsoongs");
                }
            }
        });
    }

    @Override // defpackage.afo
    public void a(final long j, final int i, final int i2) {
        a(new Runnable() { // from class: afn.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    afn.this.p = afn.this.a(aff.c, aff.h, "artist_id = " + j, null, "album", i, i2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                afn.this.d.obtainMessage(5).sendToTarget();
            }
        });
    }

    @Override // defpackage.afo
    public void b(final long j, final int i, final int i2) {
        a(new Runnable() { // from class: afn.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    afn.this.p = afm.a(aff.c, aff.h, "album_id = " + j, null, null, i, i2, afn.this.b);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                afn.this.d.obtainMessage(5).sendToTarget();
            }
        });
    }

    @Override // defpackage.afo
    public void c(final long j, final int i, final int i2) {
        a(new Runnable() { // from class: afn.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Uri contentUri = MediaStore.Audio.Genres.Members.getContentUri(afn.this.e, j);
                    afn.this.p = afm.a(contentUri, aff.h, "is_music=1 AND title!=''", null, null, i, i2, afn.this.b);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                afn.this.d.obtainMessage(5).sendToTarget();
            }
        });
    }

    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, int i, int i2) {
        try {
            ContentResolver contentResolver = this.b.getContentResolver();
            if (contentResolver == null) {
                return null;
            }
            return new aii(contentResolver.query(i2 > 0 ? uri.buildUpon().appendQueryParameter("limit", (i * i2) + "," + i2).build() : uri, strArr, str, strArr2, str2));
        } catch (Exception e) {
            e.printStackTrace();
            return new aii(null);
        }
    }

    private void a(Runnable runnable) {
        this.d.post(runnable);
    }

    @Override // defpackage.afo
    public long a() {
        if (aff.a) {
            mm.b("LocalMusicLibraryImp", "getCountSongs()");
        }
        Cursor cursorA = afm.a(aff.c, new String[]{"count(0)"}, "is_music=1", null, null, 0, 0, this.b);
        if (cursorA == null) {
            return 0L;
        }
        try {
            cursorA.moveToNext();
            if (cursorA.getColumnCount() <= 0) {
                if (cursorA != null) {
                    cursorA.close();
                }
                return 0L;
            }
            long j = cursorA.getLong(0);
            if (cursorA != null) {
                cursorA.close();
                return j;
            }
            return j;
        } finally {
            if (cursorA != null) {
                cursorA.close();
            }
        }
    }

    @Override // defpackage.afo
    public long b() {
        long count;
        Cursor cursorA = afm.a(aff.e, aff.j, null, null, null, 0, 0, this.b);
        if (cursorA == null) {
            count = 0;
        } else {
            try {
                count = cursorA.getCount();
                if (cursorA != null) {
                    cursorA.close();
                }
            } finally {
                if (cursorA != null) {
                    cursorA.close();
                }
            }
        }
        return count;
    }

    @Override // defpackage.afo
    public long c() {
        long count;
        Cursor cursorA = afm.a(aff.d, aff.i, null, null, null, 0, 0, this.b);
        if (cursorA == null) {
            count = 0;
        } else {
            try {
                count = cursorA.getCount();
                if (cursorA != null) {
                    cursorA.close();
                }
            } finally {
                if (cursorA != null) {
                    cursorA.close();
                }
            }
        }
        return count;
    }

    @Override // defpackage.afo
    public long d() {
        long count;
        Cursor cursorA = afm.a(aff.f, aff.k, null, null, null, 0, 0, this.b);
        if (cursorA == null) {
            count = 0;
        } else {
            try {
                count = cursorA.getCount();
                if (cursorA != null) {
                    cursorA.close();
                }
            } finally {
                if (cursorA != null) {
                    cursorA.close();
                }
            }
        }
        return count;
    }

    @Override // defpackage.afo
    public long e() {
        long count;
        Cursor cursorA = afm.a(aff.g, aff.l, null, null, null, 0, 0, this.b);
        if (cursorA == null) {
            count = 0;
        } else {
            try {
                count = cursorA.getCount();
                if (cursorA != null) {
                    cursorA.close();
                }
            } finally {
                if (cursorA != null) {
                    cursorA.close();
                }
            }
        }
        return count;
    }

    @Override // defpackage.afo
    public void a(afq afqVar) {
        synchronized (this.c) {
            this.c.add(afqVar);
        }
    }

    @Override // defpackage.afo
    public void a(afq afqVar, int i) {
        synchronized (this.c) {
            this.c.remove(afqVar);
            if ((i & 4) == 4) {
                this.j = true;
            } else if ((i & 32) == 32) {
                this.f = true;
            } else if ((i & 8) == 8) {
                this.i = true;
            } else if ((i & 1) == 1) {
                this.h = true;
            } else if ((i & 16) == 16) {
                this.g = true;
            }
        }
    }

    @Override // defpackage.afo
    public void d(final long j, final int i, final int i2) {
        a(new Runnable() { // from class: afn.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Uri contentUri = MediaStore.Audio.Playlists.Members.getContentUri("external", j);
                    afn.this.p = afm.a(contentUri, aff.h, "title != ''", null, "play_order", i, i2, afn.this.b);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                afn.this.d.obtainMessage(5).sendToTarget();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(long r10) throws java.lang.Throwable {
        /*
            r9 = this;
            r1 = 0
            r7 = 0
            java.lang.String r6 = ""
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]
            java.lang.String r0 = "name"
            r2[r1] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "content://media/external/audio/media/"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r1 = "/genres"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r0.toString()
            aii r8 = new aii     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L62
            android.content.Context r0 = r9.b     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L62
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L62
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L62
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L62
            r8.<init>(r0)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L62
            if (r8 == 0) goto L42
            int r0 = r8.getCount()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            if (r0 != 0) goto L49
        L42:
            if (r8 == 0) goto L47
            r8.close()
        L47:
            r0 = r7
        L48:
            return r0
        L49:
            r8.moveToFirst()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r0 = 0
            java.lang.String r0 = r8.getString(r0)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            if (r8 == 0) goto L48
            r8.close()
            goto L48
        L57:
            r0 = move-exception
        L58:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L62
            if (r7 == 0) goto L6f
            r7.close()
            r0 = r6
            goto L48
        L62:
            r0 = move-exception
        L63:
            if (r7 == 0) goto L68
            r7.close()
        L68:
            throw r0
        L69:
            r0 = move-exception
            r7 = r8
            goto L63
        L6c:
            r0 = move-exception
            r7 = r8
            goto L58
        L6f:
            r0 = r6
            goto L48
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.afn.a(long):java.lang.String");
    }

    public List<afr> a(String str, int i, int i2) throws Throwable {
        Cursor cursorA;
        MusicData musicData;
        ArrayList arrayList = new ArrayList();
        try {
            cursorA = afm.a(aff.d, aff.i, "artist like '%" + str + "%'", null, "artist_key", i, i2, this.b);
            if (cursorA != null) {
                try {
                    if (cursorA.getCount() != 0) {
                        int count = cursorA.getCount();
                        cursorA.moveToFirst();
                        for (int i3 = 0; i3 < count; i3++) {
                            ArtistData artistData = new ArtistData();
                            artistData.h = cursorA.getInt(cursorA.getColumnIndex("_id"));
                            artistData.j = cursorA.getString(cursorA.getColumnIndex("artist"));
                            artistData.l = 2001;
                            artistData.n = afm.a(artistData, this.b);
                            if (artistData.n != null && artistData.n.size() > 0 && (musicData = artistData.n.get(0)) != null) {
                                artistData.i = musicData.album_id;
                            }
                            artistData.setPictureUri(ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), artistData.i));
                            arrayList.add(artistData);
                            cursorA.moveToNext();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    throw th;
                }
            }
            if (cursorA != null) {
                cursorA.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorA = null;
        }
    }

    public List<afr> b(String str, int i, int i2) throws Throwable {
        Cursor cursorA;
        ArrayList arrayList = new ArrayList();
        try {
            cursorA = afm.a(aff.e, aff.j, "album like '%" + str + "%'", null, null, i, i2, this.b);
            if (cursorA != null) {
                try {
                    if (cursorA.getCount() != 0) {
                        int count = cursorA.getCount();
                        cursorA.moveToFirst();
                        for (int i3 = 0; i3 < count; i3++) {
                            AlbumData albumData = new AlbumData();
                            albumData.h = cursorA.getInt(cursorA.getColumnIndex("_id"));
                            albumData.j = cursorA.getString(cursorA.getColumnIndex("album"));
                            albumData.m = cursorA.getString(cursorA.getColumnIndex("artist"));
                            albumData.l = 2001;
                            albumData.n = afm.a(albumData, this.b);
                            albumData.setPictureUri(ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), albumData.h));
                            arrayList.add(albumData);
                            cursorA.moveToNext();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    throw th;
                }
            }
            if (cursorA != null) {
                cursorA.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorA = null;
        }
    }

    public List<afr> c(String str, int i, int i2) throws Throwable {
        Cursor cursorA;
        ArrayList arrayList = new ArrayList();
        try {
            cursorA = afm.a(aff.c, aff.h, "title != '' AND (title like '%" + str + "%' or artist like '%" + str + "%') AND is_music=1", null, "title", i, i2, this.b);
            if (cursorA != null) {
                try {
                    if (cursorA.getCount() != 0) {
                        int count = cursorA.getCount();
                        cursorA.moveToFirst();
                        for (int i3 = 0; i3 < count; i3++) {
                            LocalMusicData localMusicData = new LocalMusicData(cursorA);
                            localMusicData.genre = a(localMusicData.songId);
                            localMusicData.setPictureUri(Uri.parse("content://media/external/audio/media/" + localMusicData.songId + "/albumart"));
                            arrayList.add(localMusicData);
                            cursorA.moveToNext();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    throw th;
                }
            }
            if (cursorA != null) {
                cursorA.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorA = null;
        }
    }

    public List<afr> d(String str, int i, int i2) throws Throwable {
        ArrayList arrayList = new ArrayList();
        List<afr> listA = a(str, i, i2);
        List<afr> listB = b(str, i, i2);
        List<afr> listC = c(str, i, i2);
        if (listA != null && !listA.isEmpty()) {
            afs afsVar = new afs();
            afsVar.a(this.b.getString(R.string.LibNav_Artist_Str));
            afsVar.a(listA.size());
            arrayList.add(afsVar);
            arrayList.addAll(listA);
        }
        if (listB != null && !listB.isEmpty()) {
            afs afsVar2 = new afs();
            afsVar2.a(this.b.getString(R.string.LibNav_Album_Str));
            afsVar2.a(listB.size());
            arrayList.add(afsVar2);
            arrayList.addAll(listB);
        }
        if (listC != null && !listC.isEmpty()) {
            afs afsVar3 = new afs();
            afsVar3.a(this.b.getString(R.string.LibNav_Song_Str));
            afsVar3.a(listC.size());
            arrayList.add(afsVar3);
            arrayList.addAll(listC);
        }
        return arrayList;
    }

    public List<afr> a(String str) {
        return d(str, 0, Integer.MAX_VALUE);
    }
}
