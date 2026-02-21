package com.harman.commom.music.library.musicdata;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class PlayListData extends CatalogDataInf implements Parcelable {
    public static final Parcelable.Creator<PlayListData> CREATOR = new Parcelable.Creator<PlayListData>() { // from class: com.harman.commom.music.library.musicdata.PlayListData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlayListData[] newArray(int i) {
            return new PlayListData[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlayListData createFromParcel(Parcel parcel) {
            return new PlayListData(parcel);
        }
    };

    public PlayListData() {
    }

    public PlayListData(Parcel parcel) {
        this.h = parcel.readLong();
        this.j = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.h);
        parcel.writeString(this.j);
    }

    @Override // com.harman.commom.music.library.musicdata.CatalogDataInf
    public String a() {
        return this.g + this.h;
    }
}
