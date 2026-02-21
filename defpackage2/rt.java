package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import defpackage.vj;

/* JADX INFO: loaded from: classes.dex */
public class rt implements Parcelable.Creator<AdLauncherIntentInfoParcel> {
    public static void a(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, Parcel parcel, int i) {
        int iA = vk.a(parcel);
        vk.a(parcel, 1, adLauncherIntentInfoParcel.a);
        vk.a(parcel, 2, adLauncherIntentInfoParcel.b, false);
        vk.a(parcel, 3, adLauncherIntentInfoParcel.c, false);
        vk.a(parcel, 4, adLauncherIntentInfoParcel.d, false);
        vk.a(parcel, 5, adLauncherIntentInfoParcel.e, false);
        vk.a(parcel, 6, adLauncherIntentInfoParcel.f, false);
        vk.a(parcel, 7, adLauncherIntentInfoParcel.g, false);
        vk.a(parcel, 8, adLauncherIntentInfoParcel.h, false);
        vk.a(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdLauncherIntentInfoParcel createFromParcel(Parcel parcel) {
        String strF = null;
        int iB = vj.b(parcel);
        int iD = 0;
        String strF2 = null;
        String strF3 = null;
        String strF4 = null;
        String strF5 = null;
        String strF6 = null;
        String strF7 = null;
        while (parcel.dataPosition() < iB) {
            int iA = vj.a(parcel);
            switch (vj.a(iA)) {
                case 1:
                    iD = vj.d(parcel, iA);
                    break;
                case 2:
                    strF7 = vj.f(parcel, iA);
                    break;
                case 3:
                    strF6 = vj.f(parcel, iA);
                    break;
                case 4:
                    strF5 = vj.f(parcel, iA);
                    break;
                case 5:
                    strF4 = vj.f(parcel, iA);
                    break;
                case 6:
                    strF3 = vj.f(parcel, iA);
                    break;
                case 7:
                    strF2 = vj.f(parcel, iA);
                    break;
                case 8:
                    strF = vj.f(parcel, iA);
                    break;
                default:
                    vj.b(parcel, iA);
                    break;
            }
        }
        if (parcel.dataPosition() != iB) {
            throw new vj.a("Overread allowed size end=" + iB, parcel);
        }
        return new AdLauncherIntentInfoParcel(iD, strF7, strF6, strF5, strF4, strF3, strF2, strF);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdLauncherIntentInfoParcel[] newArray(int i) {
        return new AdLauncherIntentInfoParcel[i];
    }
}
