package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import defpackage.vj;

/* JADX INFO: loaded from: classes.dex */
public class sx implements Parcelable.Creator<InterstitialAdParameterParcel> {
    public static void a(InterstitialAdParameterParcel interstitialAdParameterParcel, Parcel parcel, int i) {
        int iA = vk.a(parcel);
        vk.a(parcel, 1, interstitialAdParameterParcel.a);
        vk.a(parcel, 2, interstitialAdParameterParcel.b);
        vk.a(parcel, 3, interstitialAdParameterParcel.c);
        vk.a(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterstitialAdParameterParcel createFromParcel(Parcel parcel) {
        boolean zC = false;
        int iB = vj.b(parcel);
        boolean zC2 = false;
        int iD = 0;
        while (parcel.dataPosition() < iB) {
            int iA = vj.a(parcel);
            switch (vj.a(iA)) {
                case 1:
                    iD = vj.d(parcel, iA);
                    break;
                case 2:
                    zC2 = vj.c(parcel, iA);
                    break;
                case 3:
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
        return new InterstitialAdParameterParcel(iD, zC2, zC);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterstitialAdParameterParcel[] newArray(int i) {
        return new InterstitialAdParameterParcel[i];
    }
}
