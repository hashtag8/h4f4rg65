package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.sv;
import defpackage.yx;

/* JADX INFO: loaded from: classes.dex */
@yx
public final class VersionInfoParcel implements SafeParcelable {
    public static final sv CREATOR = new sv();
    public final int a;
    public String b;
    public int c;
    public int d;
    public boolean e;

    public VersionInfoParcel(int i, String str, int i2, int i3, boolean z) {
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = i3;
        this.e = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        sv.a(this, parcel, i);
    }
}
