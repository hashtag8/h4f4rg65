package com.harman.hkconnect.musicservice.musicserver.qobuz.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ArtistsInfo implements Parcelable {
    public static final Parcelable.Creator<ArtistsInfo> CREATOR = new Parcelable.Creator<ArtistsInfo>() { // from class: com.harman.hkconnect.musicservice.musicserver.qobuz.model.ArtistsInfo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArtistsInfo[] newArray(int i) {
            return new ArtistsInfo[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArtistsInfo createFromParcel(Parcel parcel) {
            return new ArtistsInfo(parcel);
        }
    };
    public String a;
    public String b;
    public int c;
    public String d;
    public String e;
    public boolean f;

    public ArtistsInfo() {
        this.f = false;
    }

    public ArtistsInfo(Parcel parcel) {
        this.f = false;
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeByte((byte) (this.f ? 1 : 0));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
