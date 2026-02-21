package com.bfrx;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class MediaItemExtend extends MediaItem {
    public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() { // from class: com.bfrx.MediaItemExtend.1
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
    private long ownerId = 0;
    private String albumUrl = null;
    private boolean video = false;
    private Object reference = null;

    public long getOwnerId() {
        return this.ownerId;
    }

    public Object getReference() {
        return this.reference;
    }

    public void setReference(Object obj) {
        this.reference = obj;
    }

    public void setOwnerId(long j) {
        this.ownerId = j;
    }

    public String getAlbumUrl() {
        return this.albumUrl;
    }

    public void setAlbumUrl(String str) {
        this.albumUrl = str;
    }

    public boolean isVideo() {
        return this.video;
    }

    public void setVideo(boolean z) {
        this.video = z;
    }
}
