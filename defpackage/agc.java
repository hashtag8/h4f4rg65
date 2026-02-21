package defpackage;

import com.harman.commom.music.player.service.MusicData;

/* JADX INFO: loaded from: classes.dex */
public class agc {
    public static boolean a(MusicData musicData) {
        return musicData == null || !(musicData.type == 7 || musicData.type == 2 || musicData.type == 8 || musicData.type == 12 || musicData.type == 13 || musicData.type == 14);
    }

    public static boolean b(MusicData musicData) {
        return musicData == null || musicData.type != 8;
    }

    public static boolean c(MusicData musicData) {
        return !a(musicData);
    }

    public static boolean d(MusicData musicData) {
        return musicData != null && musicData.type == 8;
    }

    public static boolean e(MusicData musicData) {
        return musicData != null && (musicData.type == 7 || musicData.type == 2 || musicData.type == 12 || musicData.type == 13 || musicData.type == 14);
    }

    public static boolean f(MusicData musicData) {
        return musicData != null && musicData.type == 4;
    }
}
