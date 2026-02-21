package com.harman.hkconnect.musicservice.musicserver.qobuz.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PlayListInfo implements Parcelable {
    public static final Parcelable.Creator<PlayListInfo> CREATOR = new Parcelable.Creator<PlayListInfo>() { // from class: com.harman.hkconnect.musicservice.musicserver.qobuz.model.PlayListInfo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlayListInfo[] newArray(int i) {
            return new PlayListInfo[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlayListInfo createFromParcel(Parcel parcel) {
            return new PlayListInfo(parcel);
        }
    };
    public String a;
    public String b;
    public int c;
    public String d = "";
    public String e;
    public long f;
    public String g;
    public List<String> h;

    public PlayListInfo() {
    }

    public PlayListInfo(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.e = parcel.readString();
        this.g = parcel.readString();
        this.f = parcel.readLong();
        this.c = parcel.readInt();
        parcel.readStringList(this.h);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.e);
        parcel.writeString(this.g);
        parcel.writeLong(this.f);
        parcel.writeInt(this.c);
        parcel.writeStringList(this.h);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
