package defpackage;

/* JADX INFO: loaded from: classes.dex */
public enum ayx {
    EContentTypeAlbum("albums"),
    EContentTypeArtist("artists"),
    EContentTypePlaylist("playlists"),
    EContentTypeTrack("tracks"),
    EContentTypeStation("stations"),
    EContentTypeERROR("ERROR");

    private String g;

    public String a() {
        return this.g;
    }

    ayx(String str) {
        this.g = str;
    }
}
