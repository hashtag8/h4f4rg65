package com.harman.commom.music.library.musicdata;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class AlbumData extends CatalogDataInf implements Parcelable {
    public static final Parcelable.Creator<AlbumData> CREATOR = new Parcelable.Creator<AlbumData>() { // from class: com.harman.commom.music.library.musicdata.AlbumData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AlbumData[] newArray(int i) {
            return new AlbumData[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AlbumData createFromParcel(Parcel parcel) {
            return new AlbumData(parcel);
        }
    };
    public String a;
    public int b;
    public int c;

    public AlbumData() {
    }

    public AlbumData(Parcel parcel) {
        a(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void a(Parcel parcel) {
        this.h = parcel.readLong();
        this.j = parcel.readString();
        this.a = parcel.readString();
        this.m = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.h);
        parcel.writeString(this.j);
        parcel.writeString(this.a);
        parcel.writeString(this.m);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
    }

    @Override // com.harman.commom.music.library.musicdata.CatalogDataInf
    public String a() {
        return this.d + this.h;
    }
}
