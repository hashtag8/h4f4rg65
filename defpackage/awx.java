package defpackage;

import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class awx implements Serializable {

    @acn(a = "id")
    public String a;

    @acn(a = "name")
    public String b;

    @acn(a = "userFavAlbums")
    public int c;

    @acn(a = "userFavTracks")
    public int d;

    @acn(a = "userFavTrackDuration")
    public int e;

    @acn(a = "hasLoaded")
    public boolean f;

    @acn(a = "artistURLs")
    public HashMap<String, String> g;
}
