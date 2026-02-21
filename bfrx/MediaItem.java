package com.bfrx;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() { // from class: com.bfrx.MediaItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaItem createFromParcel(Parcel parcel) {
            MediaItem mediaItem = new MediaItem();
            mediaItem.readFromParcel(parcel);
            return mediaItem;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaItem[] newArray(int i) {
            return new MediaItem[i];
        }
    };
    private String title;
    private String url;
    private long id = 0;
    private String artist = "";
    private boolean isPlaying = false;

    public String toString() {
        return String.valueOf(this.title);
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setPlaying(boolean z) {
        this.isPlaying = z;
    }

    public String getTitle() {
        return this.title;
    }

    public void setID(long j) {
        this.id = j;
    }

    public long getId() {
        return this.id;
    }

    public void setArtist(String str) {
        this.artist = str;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.url);
        parcel.writeInt(this.isPlaying ? 0 : 1);
    }

    public void readFromParcel(Parcel parcel) {
        this.title = parcel.readString();
        this.url = parcel.readString();
        this.isPlaying = parcel.readInt() == 1;
    }
}
