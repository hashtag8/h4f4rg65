package com.harman.commom.music.player.service;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.aff;
import defpackage.afg;
import defpackage.afr;
import defpackage.afu;
import defpackage.afw;
import defpackage.afx;
import defpackage.agd;
import defpackage.ahp;
import defpackage.bry;
import defpackage.bsc;

/* JADX INFO: loaded from: classes.dex */
public class MusicData extends afr implements Parcelable {
    public static final Parcelable.Creator<MusicData> CREATOR = new Parcelable.Creator<MusicData>() { // from class: com.harman.commom.music.player.service.MusicData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MusicData[] newArray(int i) {
            return new MusicData[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MusicData createFromParcel(Parcel parcel) {
            return new MusicData(parcel);
        }
    };
    public static final int TYPE_DEEZER = 3;
    public static final int TYPE_DEEZER_RADIO = 14;
    public static final int TYPE_DLNA = 9;
    public static final int TYPE_JUKE = 11;
    public static final int TYPE_JUKE_RADIO = 12;
    public static final int TYPE_LOCAL = 1;
    public static final int TYPE_MIX = 2;
    public static final int TYPE_QOBUZ = 4;
    public static final int TYPE_RDIO = 6;
    public static final int TYPE_RDIO_STATION = 7;
    public static final int TYPE_SHOUTCAST_STATION = 8;
    public static final int TYPE_SOUNDCLOUD = 5;
    public static final int TYPE_TIDAL = 10;
    public static final int TYPE_TIDAL_RADIO = 13;
    public String album;
    public String album_art;
    public long album_id;
    public String artist;
    public long artist_id;
    private String childCount;
    private String containerID;
    public long duration;
    public String durations;
    public int first_year;
    public String genre;
    public long genre_id;
    private String iconUrl;
    private int id;
    private boolean isCurated;
    public boolean isLegal;
    private boolean isPlaying;
    public String musicName;
    private String objectClass;
    public String path;
    public int queue_source;
    private boolean shouldReportStreaming;
    public String songBaseUrl;
    public long songId;
    public String subtype;
    private boolean tag;
    private String title;
    public int type;

    public boolean isShouldReportStreaming() {
        return this.shouldReportStreaming;
    }

    public void setShouldReportStreaming(boolean z) {
        this.shouldReportStreaming = z;
    }

    public static String getPlayType(int i) {
        switch (i) {
            case 1:
                return "Local Library";
            case 2:
                return "MixRadio";
            case 3:
                return "Deezer";
            case 4:
                return "Qobuz";
            case 5:
                return "SoundCloud";
            case 6:
                return "Rdio";
            case 7:
                return "RdioStation";
            case 8:
                return "SHOUTcast";
            case 9:
                return "DLNA";
            case 10:
                return "Tidal";
            case 11:
                return "Juke";
            case 12:
                return "JukeRadio";
            default:
                return "OtherService";
        }
    }

    public static int getTypeFromHCConstantValue(int i) {
        switch (i) {
            case 0:
                return 2;
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
            default:
                return -1;
            case 4:
                return 6;
            case 5:
                return 10;
            case 6:
                return 11;
            case 7:
                return 8;
            case 8:
                return 9;
        }
    }

    public boolean getIsPlaying() {
        return this.isPlaying;
    }

    public static boolean isRadioType(int i) {
        return i == 7 || i == 12 || i == 2 || i == 8 || i == 13 || i == 14;
    }

    public void setIsPlaying(boolean z) {
        this.isPlaying = z;
    }

    public MusicData(int i, String str, String str2, String str3, String str4) {
        this.isLegal = true;
        this.songBaseUrl = "content://media/external/audio/media/";
        this.genre_id = -1L;
        this.iconUrl = "";
        this.childCount = "-1";
        this.isPlaying = false;
        this.isCurated = false;
        this.queue_source = 0;
        this.shouldReportStreaming = false;
        this.id = i;
        this.title = str;
        this.artist = str2;
        this.album = str3;
        this.objectClass = str4;
    }

    public MusicData() {
        this.isLegal = true;
        this.songBaseUrl = "content://media/external/audio/media/";
        this.genre_id = -1L;
        this.iconUrl = "";
        this.childCount = "-1";
        this.isPlaying = false;
        this.isCurated = false;
        this.queue_source = 0;
        this.shouldReportStreaming = false;
    }

    public String getArtist() {
        return this.artist;
    }

    public agd getPlayAbleUrl() {
        return new agd(this.path);
    }

    public String getChildCount() {
        return this.childCount;
    }

    public void setChildCount(String str) {
        this.childCount = str;
    }

    public void setContainerID(String str) {
        this.containerID = str;
    }

    public String getContainerID() {
        return this.containerID;
    }

    public void setDuration(String str) {
        this.durations = str;
    }

    public String getDurations() {
        return this.durations;
    }

    public void setObjectClass(String str) {
        this.objectClass = str;
    }

    public String getObjectClass() {
        return this.objectClass;
    }

    public String getTitle() {
        return this.title;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public boolean isCurated() {
        return this.isCurated;
    }

    public void setCurated(boolean z) {
        this.isCurated = z;
    }

    public MusicData(Parcel parcel) {
        this.isLegal = true;
        this.songBaseUrl = "content://media/external/audio/media/";
        this.genre_id = -1L;
        this.iconUrl = "";
        this.childCount = "-1";
        this.isPlaying = false;
        this.isCurated = false;
        this.queue_source = 0;
        this.shouldReportStreaming = false;
        this.songId = parcel.readLong();
        this.musicName = parcel.readString();
        this.duration = parcel.readLong();
        this.album_id = parcel.readLong();
        this.album = parcel.readString();
        this.album_art = parcel.readString();
        this.artist_id = parcel.readLong();
        this.artist = parcel.readString();
        this.genre_id = parcel.readLong();
        this.genre = parcel.readString();
        this.path = parcel.readString();
        this.type = parcel.readInt();
        this.first_year = parcel.readInt();
        this.queue_source = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.songId);
        parcel.writeString(this.musicName);
        parcel.writeLong(this.duration);
        parcel.writeLong(this.album_id);
        parcel.writeString(this.album);
        parcel.writeString(this.album_art);
        parcel.writeLong(this.artist_id);
        parcel.writeString(this.artist);
        parcel.writeLong(this.genre_id);
        parcel.writeString(this.genre);
        parcel.writeString(this.path);
        parcel.writeInt(this.type);
        parcel.writeInt(this.first_year);
        parcel.writeInt(this.queue_source);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final afx getMusicPlayer(MusicService musicService) {
        if (aff.b == 2003) {
            return new afw(musicService);
        }
        if (aff.b != 2004) {
            return null;
        }
        return afu.a();
    }

    public String getBitmapUrl() {
        return null;
    }

    public void getBitmap(Context context, afg.c cVar) {
    }

    public String toString() {
        return bsc.b(this, new ahp());
    }

    public boolean equals(Object obj) {
        return obj != null && bry.a(this, new String[0]) == bry.a(obj, new String[0]);
    }

    public void reportStreamingStart() {
    }

    public void reportStreamingEnd(long j) {
    }
}
