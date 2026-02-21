package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import defpackage.vj;

/* JADX INFO: loaded from: classes.dex */
public class ri implements Parcelable.Creator<AdSizeParcel> {
    public static void a(AdSizeParcel adSizeParcel, Parcel parcel, int i) {
        int iA = vk.a(parcel);
        vk.a(parcel, 1, adSizeParcel.a);
        vk.a(parcel, 2, adSizeParcel.b, false);
        vk.a(parcel, 3, adSizeParcel.c);
        vk.a(parcel, 4, adSizeParcel.d);
        vk.a(parcel, 5, adSizeParcel.e);
        vk.a(parcel, 6, adSizeParcel.f);
        vk.a(parcel, 7, adSizeParcel.g);
        vk.a(parcel, 8, (Parcelable[]) adSizeParcel.h, i, false);
        vk.a(parcel, 9, adSizeParcel.i);
        vk.a(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdSizeParcel createFromParcel(Parcel parcel) {
        AdSizeParcel[] adSizeParcelArr = null;
        boolean zC = false;
        int iB = vj.b(parcel);
        int iD = 0;
        int iD2 = 0;
        boolean zC2 = false;
        int iD3 = 0;
        int iD4 = 0;
        String strF = null;
        int iD5 = 0;
        while (parcel.dataPosition() < iB) {
            int iA = vj.a(parcel);
            switch (vj.a(iA)) {
                case 1:
                    iD5 = vj.d(parcel, iA);
                    break;
                case 2:
                    strF = vj.f(parcel, iA);
                    break;
                case 3:
                    iD4 = vj.d(parcel, iA);
                    break;
                case 4:
                    iD3 = vj.d(parcel, iA);
                    break;
                case 5:
                    zC2 = vj.c(parcel, iA);
                    break;
                case 6:
                    iD2 = vj.d(parcel, iA);
                    break;
                case 7:
                    iD = vj.d(parcel, iA);
                    break;
                case 8:
                    adSizeParcelArr = (AdSizeParcel[]) vj.b(parcel, iA, AdSizeParcel.CREATOR);
                    break;
                case 9:
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
        return new AdSizeParcel(iD5, strF, iD4, iD3, zC2, iD2, iD, adSizeParcelArr, zC);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdSizeParcel[] newArray(int i) {
        return new AdSizeParcel[i];
    }
}
