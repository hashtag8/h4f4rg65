package com.harman.hkconnect.musicservice.musicserver.deezer;

import com.harman.commom.music.player.service.RadioMusicData;

/* JADX INFO: loaded from: classes.dex */
public class DeezerStationMusicData extends RadioMusicData {
    public Runnable a;
    private String b = "";

    public DeezerStationMusicData(Runnable runnable) {
        this.a = runnable;
        this.type = 14;
    }

    @Override // com.harman.commom.music.player.service.RadioMusicData
    public boolean a() {
        if (((DeezerMusicData) d()) == ((DeezerMusicData) a(b() - 2))) {
            this.a.run();
        }
        return super.a();
    }
}
