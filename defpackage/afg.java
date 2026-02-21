package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import com.harman.commom.music.library.musicdata.AlbumData;
import com.harman.commom.music.library.musicdata.ArtistData;
import com.harman.commom.music.library.musicdata.CatalogDataInf;
import com.harman.commom.music.library.musicdata.GenreData;
import com.harman.commom.music.library.musicdata.LocalMusicData;
import com.harman.commom.music.library.musicdata.PlayListData;
import com.harman.hkconnect.R;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class afg {
    private static afg c;
    private a b;
    private Map<String, SoftReference<Bitmap>> a = new HashMap();
    private final b d = new b(this);

    public interface c {
        void a(Bitmap bitmap, String str);
    }

    private afg() {
    }

    public static afg a() {
        if (c == null) {
            c = new afg();
        }
        return c;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r6, afg.c r7, java.lang.Object r8) {
        /*
            r5 = this;
            r1 = 0
            boolean r0 = r8 instanceof com.harman.commom.music.library.musicdata.LocalMusicData
            if (r0 == 0) goto L33
            r0 = r8
            com.harman.commom.music.library.musicdata.LocalMusicData r0 = (com.harman.commom.music.library.musicdata.LocalMusicData) r0
            java.util.Map<java.lang.String, java.lang.ref.SoftReference<android.graphics.Bitmap>> r2 = r5.a
            java.lang.String r3 = r0.getBitmapUrl()
            boolean r2 = r2.containsKey(r3)
            if (r2 == 0) goto L73
            java.util.Map<java.lang.String, java.lang.ref.SoftReference<android.graphics.Bitmap>> r1 = r5.a
            java.lang.String r2 = r0.getBitmapUrl()
            java.lang.Object r1 = r1.get(r2)
            java.lang.ref.SoftReference r1 = (java.lang.ref.SoftReference) r1
            java.lang.Object r1 = r1.get()
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            java.lang.String r0 = r0.getBitmapUrl()
        L2a:
            r4 = r0
            r0 = r1
            r1 = r4
        L2d:
            if (r0 == 0) goto L60
            r5.a(r0, r6, r7, r1)
        L32:
            return
        L33:
            boolean r0 = r8 instanceof com.harman.commom.music.library.musicdata.CatalogDataInf
            if (r0 == 0) goto L71
            r0 = r8
            com.harman.commom.music.library.musicdata.CatalogDataInf r0 = (com.harman.commom.music.library.musicdata.CatalogDataInf) r0
            java.util.Map<java.lang.String, java.lang.ref.SoftReference<android.graphics.Bitmap>> r2 = r5.a
            java.lang.String r3 = r0.a()
            boolean r2 = r2.containsKey(r3)
            if (r2 == 0) goto L71
            java.util.Map<java.lang.String, java.lang.ref.SoftReference<android.graphics.Bitmap>> r1 = r5.a
            java.lang.String r2 = r0.a()
            java.lang.Object r1 = r1.get(r2)
            java.lang.ref.SoftReference r1 = (java.lang.ref.SoftReference) r1
            java.lang.Object r1 = r1.get()
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            java.lang.String r0 = r0.a()
            r4 = r0
            r0 = r1
            r1 = r4
            goto L2d
        L60:
            afg$a r0 = new afg$a
            r0.<init>(r7, r6, r8)
            r5.b = r0
            mq r0 = defpackage.mq.a()
            afg$a r1 = r5.b
            r0.a(r1)
            goto L32
        L71:
            r0 = r1
            goto L2d
        L73:
            r0 = r1
            goto L2a
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.afg.a(android.content.Context, afg$c, java.lang.Object):void");
    }

    static class b extends Handler {
        private final WeakReference<afg> a;

        public b(afg afgVar) {
            this.a = new WeakReference<>(afgVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.a.get() != null) {
                List list = (List) message.obj;
                ((c) list.get(1)).a((Bitmap) list.get(0), (String) list.get(2));
            }
        }
    }

    class a implements Runnable {
        private Object b;
        private Context c;
        private c d;

        public a(c cVar, Context context, Object obj) {
            this.b = obj;
            this.c = context;
            this.d = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmapA;
            Bitmap bitmapA2 = null;
            try {
                String str = "";
                if (this.b instanceof LocalMusicData) {
                    LocalMusicData localMusicData = (LocalMusicData) this.b;
                    String bitmapUrl = localMusicData.getBitmapUrl();
                    Bitmap bitmapA3 = afh.a(this.c, localMusicData.songId, -1L);
                    if (bitmapA3 != null) {
                        afg.this.a.put(localMusicData.getBitmapUrl(), new SoftReference(bitmapA3));
                        bitmapA = bitmapA3;
                    } else {
                        bitmapA = a(localMusicData.genre, 1);
                    }
                    bitmapA2 = bitmapA;
                    str = bitmapUrl;
                } else if (this.b instanceof AlbumData) {
                    CatalogDataInf catalogDataInf = (CatalogDataInf) this.b;
                    String strA = catalogDataInf.a();
                    Bitmap bitmapA4 = afh.a(this.c, catalogDataInf.h, afh.a(this.c));
                    if (bitmapA4 != null) {
                        afg.this.a.put(catalogDataInf.a(), new SoftReference(bitmapA4));
                        str = strA;
                        bitmapA2 = bitmapA4;
                    } else {
                        bitmapA2 = a(2);
                        str = strA;
                    }
                } else if ((this.b instanceof ArtistData) || (this.b instanceof PlayListData)) {
                    CatalogDataInf catalogDataInf2 = (CatalogDataInf) this.b;
                    String strA2 = catalogDataInf2.a();
                    Bitmap bitmapA5 = afh.a(this.c, catalogDataInf2.h, -1L);
                    if (bitmapA5 != null) {
                        afg.this.a.put(catalogDataInf2.a(), new SoftReference(bitmapA5));
                        str = strA2;
                        bitmapA2 = bitmapA5;
                    } else {
                        bitmapA2 = a(2);
                        str = strA2;
                    }
                } else if (this.b instanceof GenreData) {
                    CatalogDataInf catalogDataInf3 = (CatalogDataInf) this.b;
                    String strA3 = catalogDataInf3.a();
                    Bitmap bitmapA6 = a(catalogDataInf3.j, 2);
                    if (bitmapA6 != null) {
                        afg.this.a.put(catalogDataInf3.a(), new SoftReference(bitmapA6));
                    }
                    str = strA3;
                    bitmapA2 = bitmapA6;
                }
                afg.this.a(bitmapA2, this.c, this.d, str);
            } catch (Exception e) {
            }
        }

        private Bitmap a(String str, int i) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) this.c.getResources().getDrawable(afh.a(str, i));
            if (bitmapDrawable == null) {
                return null;
            }
            return bitmapDrawable.getBitmap();
        }

        private Bitmap a(int i) {
            BitmapDrawable bitmapDrawable;
            if (i == 2) {
                bitmapDrawable = (BitmapDrawable) this.c.getResources().getDrawable(R.drawable.empty_no_cover_art);
            } else {
                bitmapDrawable = (BitmapDrawable) this.c.getResources().getDrawable(R.drawable.empty_cover_art_small);
            }
            if (bitmapDrawable == null) {
                return null;
            }
            return bitmapDrawable.getBitmap();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, Context context, c cVar, String str) {
        Message messageObtain = Message.obtain();
        Vector vector = new Vector();
        vector.add(bitmap);
        vector.add(cVar);
        vector.add(str);
        messageObtain.what = 0;
        messageObtain.obj = vector;
        this.d.sendMessage(messageObtain);
    }
}
