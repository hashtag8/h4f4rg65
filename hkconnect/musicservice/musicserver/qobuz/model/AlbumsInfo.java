package com.harman.hkconnect.musicservice.musicserver.qobuz.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AlbumsInfo implements Parcelable {
    public static final Parcelable.Creator<AlbumsInfo> CREATOR = new Parcelable.Creator<AlbumsInfo>() { // from class: com.harman.hkconnect.musicservice.musicserver.qobuz.model.AlbumsInfo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AlbumsInfo[] newArray(int i) {
            return new AlbumsInfo[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AlbumsInfo createFromParcel(Parcel parcel) {
            return new AlbumsInfo(parcel);
        }
    };
    public String a;
    public String b;
    public String c;
    public long d;
    public String e;
    public int f;
    public int g;
    public int h;
    public String i;
    public boolean j;
    public String k;
    public String l;
    public String m;
    public String n;

    public AlbumsInfo() {
        this.l = "";
        this.m = "";
        this.n = "";
    }

    public String a(List<String> list) {
        String strTrim = this.b.trim();
        try {
            if (this.b.trim().length() > 0) {
                strTrim = this.b.trim().substring(0, 1).toUpperCase();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.contains(strTrim.toUpperCase()) ? strTrim : "#";
    }

    public AlbumsInfo(Parcel parcel) {
        this.l = "";
        this.m = "";
        this.n = "";
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readLong();
        this.e = parcel.readString();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readString();
        this.j = parcel.readByte() != 0;
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readString();
        this.n = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeLong(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeString(this.i);
        parcel.writeByte((byte) (this.j ? 1 : 0));
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
