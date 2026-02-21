package defpackage;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import defpackage.bif;
import defpackage.bil;

/* JADX INFO: loaded from: classes.dex */
class bia extends bhs {
    private static final String[] b = {"orientation"};

    bia(Context context) {
        super(context);
    }

    @Override // defpackage.bhs, defpackage.bil
    public boolean a(bij bijVar) {
        Uri uri = bijVar.d;
        return "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    @Override // defpackage.bhs, defpackage.bil
    public bil.a a(bij bijVar, int i) throws Throwable {
        Bitmap thumbnail;
        ContentResolver contentResolver = this.a.getContentResolver();
        int iA = a(contentResolver, bijVar.d);
        String type = contentResolver.getType(bijVar.d);
        boolean z = type != null && type.startsWith("video/");
        if (bijVar.d()) {
            a aVarA = a(bijVar.h, bijVar.i);
            if (!z && aVarA == a.FULL) {
                return new bil.a(null, b(bijVar), bif.d.DISK, iA);
            }
            long id = ContentUris.parseId(bijVar.d);
            BitmapFactory.Options optionsC = c(bijVar);
            optionsC.inJustDecodeBounds = true;
            a(bijVar.h, bijVar.i, aVarA.e, aVarA.f, optionsC, bijVar);
            if (z) {
                thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, id, aVarA == a.FULL ? 1 : aVarA.d, optionsC);
            } else {
                thumbnail = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, id, aVarA.d, optionsC);
            }
            if (thumbnail != null) {
                return new bil.a(thumbnail, null, bif.d.DISK, iA);
            }
        }
        return new bil.a(null, b(bijVar), bif.d.DISK, iA);
    }

    static a a(int i, int i2) {
        if (i <= a.MICRO.e && i2 <= a.MICRO.f) {
            return a.MICRO;
        }
        if (i <= a.MINI.e && i2 <= a.MINI.f) {
            return a.MINI;
        }
        return a.FULL;
    }

    static int a(ContentResolver contentResolver, Uri uri) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor;
        try {
            cursorQuery = contentResolver.query(uri, b, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        int i = cursorQuery.getInt(0);
                        if (cursorQuery == null) {
                            return i;
                        }
                        cursorQuery.close();
                        return i;
                    }
                } catch (RuntimeException e) {
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return 0;
        } catch (RuntimeException e2) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    enum a {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);

        final int d;
        final int e;
        final int f;

        a(int i, int i2, int i3) {
            this.d = i;
            this.e = i2;
            this.f = i3;
        }
    }
}
