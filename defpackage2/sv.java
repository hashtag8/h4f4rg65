package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import defpackage.vj;

/* JADX INFO: loaded from: classes.dex */
public class sv implements Parcelable.Creator<VersionInfoParcel> {
    public static void a(VersionInfoParcel versionInfoParcel, Parcel parcel, int i) {
        int iA = vk.a(parcel);
        vk.a(parcel, 1, versionInfoParcel.a);
        vk.a(parcel, 2, versionInfoParcel.b, false);
        vk.a(parcel, 3, versionInfoParcel.c);
        vk.a(parcel, 4, versionInfoParcel.d);
        vk.a(parcel, 5, versionInfoParcel.e);
        vk.a(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public VersionInfoParcel createFromParcel(Parcel parcel) {
        boolean zC = false;
        int iB = vj.b(parcel);
        String strF = null;
        int iD = 0;
        int iD2 = 0;
        int iD3 = 0;
        while (parcel.dataPosition() < iB) {
            int iA = vj.a(parcel);
            switch (vj.a(iA)) {
                case 1:
                    iD3 = vj.d(parcel, iA);
                    break;
                case 2:
                    strF = vj.f(parcel, iA);
                    break;
                case 3:
                    iD2 = vj.d(parcel, iA);
                    break;
                case 4:
                    iD = vj.d(parcel, iA);
                    break;
                case 5:
                    zC = vj.c(parcel, iA);
                    break;
                default:
                    vj.b(parcel, iA);
                    break;
            }
        }
        if (parcel.dataPosition() != iB) {
            throw new vj.a("Overread allowed size end=" + iB, parcel);
        }
        return new VersionInfoParcel(iD3, strF, iD2, iD, zC);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public VersionInfoParcel[] newArray(int i) {
        return new VersionInfoParcel[i];
    }
}
