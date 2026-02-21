package defpackage;

/* JADX INFO: loaded from: classes.dex */
public enum aza {
    ERdioSearchTypeAll("Albums, Artists, Playlists, Tracks"),
    ERdioSearchTypeAlbum("Albums"),
    ERdioSearchTypeArtist("Artists"),
    ERdioSearchTypePlaylist("Playlists"),
    ERdioSearchTypeTrack("Tracks");

    private String f;

    public String a() {
        return this.f;
    }

    aza(String str) {
        this.f = str;
    }
}
