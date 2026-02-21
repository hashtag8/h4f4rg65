package com.harman.hkconnect.musicservice.musicserver.nokia;

import com.harman.commom.music.player.service.RadioMusicData;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import defpackage.amk;

/* JADX INFO: loaded from: classes.dex */
public class NokiaMusicData extends RadioMusicData {
    private String a;

    @Override // com.harman.commom.music.player.service.MusicData
    public String getBitmapUrl() {
        return this.a;
    }

    @Override // com.harman.commom.music.player.service.RadioMusicData
    public boolean c() {
        int iB = b();
        amk.a().a(1, false, true);
        return b() > iB;
    }

    public void f() {
        MusicPlaylistManager.a().r();
    }
}
