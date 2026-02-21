package com.harman.commom.music.library.musicdata;

import android.os.Parcelable;
import com.harman.commom.music.player.service.MusicData;
import defpackage.afr;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class CatalogDataInf extends afr implements Parcelable {
    public String d = "content://media/external/audio/media/ablum/";
    public String e = "content://media/external/audio/media/artist/";
    public String f = "content://media/external/audio/media/geren/";
    public String g = "content://media/external/audio/media/playlist/";
    public long h = -1;
    public long i = -1;
    public String j = "";
    public int k = -1;
    public int l = -1;
    public String m = null;
    public List<MusicData> n = null;
    public int o;
    public int p;

    public abstract String a();
}
