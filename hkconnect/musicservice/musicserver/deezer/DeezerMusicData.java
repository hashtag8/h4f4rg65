package com.harman.hkconnect.musicservice.musicserver.deezer;

import android.content.Context;
import android.text.TextUtils;
import com.harman.commom.music.player.service.MusicData;
import defpackage.afg;
import defpackage.agd;
import defpackage.ain;
import defpackage.alh;
import defpackage.als;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes.dex */
public class DeezerMusicData extends MusicData {
    public static final alh a = new alh();
    private String b;

    public DeezerMusicData() {
        this.type = 3;
    }

    @Override // com.harman.commom.music.player.service.MusicData
    public void getBitmap(Context context, afg.c cVar) {
        super.getBitmap(context, cVar);
    }

    @Override // com.harman.commom.music.player.service.MusicData
    public String getBitmapUrl() {
        return this.b;
    }

    @Override // com.harman.commom.music.player.service.MusicData
    public agd getPlayAbleUrl() {
        String str = a.get(Long.valueOf(this.songId));
        if (!TextUtils.isEmpty(str) && str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            return new agd(str);
        }
        String strA = als.a(ain.J, Long.valueOf(this.songId));
        a.put(Long.valueOf(this.songId), strA);
        return new agd(strA);
    }
}
