package com.harman.commom.music.library.musicdata;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ArtistData extends CatalogDataInf implements Parcelable {
    public static final Parcelable.Creator<ArtistData> CREATOR = new Parcelable.Creator<ArtistData>() { // from class: com.harman.commom.music.library.musicdata.ArtistData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArtistData[] newArray(int i) {
            return new ArtistData[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArtistData createFromParcel(Parcel parcel) {
            return new ArtistData(parcel);
        }
    };

    public ArtistData() {
    }

    public ArtistData(Parcel parcel) {
        a(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void a(Parcel parcel) {
        this.h = parcel.readLong();
        this.j = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.h);
        parcel.writeString(this.j);
    }

    @Override // com.harman.commom.music.library.musicdata.CatalogDataInf
    public String a() {
        return this.e + this.h;
    }
}
