package com.harman.commom.music.library.musicdata;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class GenreData extends CatalogDataInf implements Parcelable {
    public static final Parcelable.Creator<GenreData> CREATOR = new Parcelable.Creator<GenreData>() { // from class: com.harman.commom.music.library.musicdata.GenreData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GenreData[] newArray(int i) {
            return new GenreData[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GenreData createFromParcel(Parcel parcel) {
            return new GenreData(parcel);
        }
    };

    public GenreData() {
    }

    public GenreData(Parcel parcel) {
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
        return this.f + this.h;
    }
}
