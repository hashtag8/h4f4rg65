package com.harman.commom.device.process.communicate.imp;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class WifiMode implements Parcelable {
    public static final Parcelable.Creator<WifiMode> CREATOR = new Parcelable.Creator<WifiMode>() { // from class: com.harman.commom.device.process.communicate.imp.WifiMode.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WifiMode createFromParcel(Parcel parcel) {
            WifiMode wifiMode = new WifiMode();
            wifiMode.a = parcel.readByte();
            wifiMode.b = parcel.readByte();
            wifiMode.c = parcel.createByteArray();
            wifiMode.d = parcel.readByte();
            wifiMode.e = parcel.readByte();
            wifiMode.f = parcel.readByte();
            wifiMode.g = parcel.readByte();
            wifiMode.h = parcel.createByteArray();
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WifiMode[] newArray(int i) {
            return new WifiMode[i];
        }
    };
    byte a;
    byte b;
    byte[] c;
    byte d;
    byte e;
    byte f;
    byte g;
    byte[] h;

    public static WifiMode a(byte[] bArr) {
        WifiMode wifiMode = new WifiMode();
        wifiMode.c = new byte[32];
        System.arraycopy(bArr, 0, wifiMode.c, 0, wifiMode.c.length);
        wifiMode.d = bArr[32];
        return wifiMode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.a);
        parcel.writeByte(this.b);
        parcel.writeByteArray(this.c);
        parcel.writeByte(this.d);
        parcel.writeByte(this.e);
        parcel.writeByte(this.f);
        parcel.writeByte(this.g);
        parcel.writeByteArray(this.h);
    }
}
