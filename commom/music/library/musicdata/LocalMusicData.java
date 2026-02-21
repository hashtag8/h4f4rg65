package com.harman.commom.music.library.musicdata;

import android.content.Context;
import android.database.Cursor;
import com.harman.commom.music.player.service.MusicData;
import defpackage.afg;
import defpackage.afw;
import defpackage.ain;
import defpackage.mm;

/* JADX INFO: loaded from: classes.dex */
public class LocalMusicData extends MusicData {
    public LocalMusicData() {
        this.type = 1;
    }

    public LocalMusicData(int i, Cursor cursor) {
        if (i >= 0) {
            cursor.moveToPosition(i);
        }
        this.songId = cursor.getInt(cursor.getColumnIndex("_id"));
        this.path = cursor.getString(cursor.getColumnIndex("_data"));
        this.musicName = cursor.getString(cursor.getColumnIndex("title"));
        this.artist = cursor.getString(cursor.getColumnIndex("artist"));
        this.artist_id = cursor.getLong(cursor.getColumnIndex("artist_id"));
        this.album = cursor.getString(cursor.getColumnIndex("album"));
        this.album_id = cursor.getLong(cursor.getColumnIndex("album_id"));
        this.duration = cursor.getLong(cursor.getColumnIndex("duration"));
        if (this.duration <= 0) {
            long j = this.duration;
            this.duration = afw.a(this.path);
            mm.b("LocalMusicData", "duration is %d, try to use MediaPlay to get duration %d for %s", Long.valueOf(j), Long.valueOf(this.duration), this.path);
        }
        this.first_year = cursor.getInt(cursor.getColumnIndex("year"));
        this.type = 1;
        a();
    }

    public LocalMusicData(Cursor cursor) {
        this(-1, cursor);
    }

    public void a() {
        if (ain.P.contains(this.path.substring(this.path.lastIndexOf(".") + 1).toLowerCase())) {
            this.isLegal = false;
        }
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        return !ain.P.contains(str.substring(str.lastIndexOf(".") + 1).toLowerCase());
    }

    public LocalMusicData(int i, Cursor cursor, String str) {
        this(i, cursor);
        this.subtype = str;
    }

    @Override // com.harman.commom.music.player.service.MusicData
    public String getBitmapUrl() {
        return this.songBaseUrl + this.songId;
    }

    @Override // com.harman.commom.music.player.service.MusicData
    public void getBitmap(Context context, afg.c cVar) {
        afg.a().a(context, cVar, this);
    }
}
