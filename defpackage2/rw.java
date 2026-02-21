package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import defpackage.vj;

/* JADX INFO: loaded from: classes.dex */
public class rw implements Parcelable.Creator<AdOverlayInfoParcel> {
    public static void a(AdOverlayInfoParcel adOverlayInfoParcel, Parcel parcel, int i) {
        int iA = vk.a(parcel);
        vk.a(parcel, 1, adOverlayInfoParcel.a);
        vk.a(parcel, 2, (Parcelable) adOverlayInfoParcel.b, i, false);
        vk.a(parcel, 3, adOverlayInfoParcel.a(), false);
        vk.a(parcel, 4, adOverlayInfoParcel.b(), false);
        vk.a(parcel, 5, adOverlayInfoParcel.c(), false);
        vk.a(parcel, 6, adOverlayInfoParcel.d(), false);
        vk.a(parcel, 7, adOverlayInfoParcel.g, false);
        vk.a(parcel, 8, adOverlayInfoParcel.h);
        vk.a(parcel, 9, adOverlayInfoParcel.i, false);
        vk.a(parcel, 10, adOverlayInfoParcel.f(), false);
        vk.a(parcel, 11, adOverlayInfoParcel.k);
        vk.a(parcel, 12, adOverlayInfoParcel.l);
        vk.a(parcel, 13, adOverlayInfoParcel.m, false);
        vk.a(parcel, 14, (Parcelable) adOverlayInfoParcel.n, i, false);
        vk.a(parcel, 15, adOverlayInfoParcel.e(), false);
        vk.a(parcel, 17, (Parcelable) adOverlayInfoParcel.q, i, false);
        vk.a(parcel, 16, adOverlayInfoParcel.p, false);
        vk.a(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdOverlayInfoParcel createFromParcel(Parcel parcel) {
        int iB = vj.b(parcel);
        int iD = 0;
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel = null;
        IBinder iBinderG = null;
        IBinder iBinderG2 = null;
        IBinder iBinderG3 = null;
        IBinder iBinderG4 = null;
        String strF = null;
        boolean zC = false;
        String strF2 = null;
        IBinder iBinderG5 = null;
        int iD2 = 0;
        int iD3 = 0;
        String strF3 = null;
        VersionInfoParcel versionInfoParcel = null;
        IBinder iBinderG6 = null;
        String strF4 = null;
        InterstitialAdParameterParcel interstitialAdParameterParcel = null;
        while (parcel.dataPosition() < iB) {
            int iA = vj.a(parcel);
            switch (vj.a(iA)) {
                case 1:
                    iD = vj.d(parcel, iA);
                    break;
                case 2:
                    adLauncherIntentInfoParcel = (AdLauncherIntentInfoParcel) vj.a(parcel, iA, AdLauncherIntentInfoParcel.CREATOR);
                    break;
                case 3:
                    iBinderG = vj.g(parcel, iA);
                    break;
                case 4:
                    iBinderG2 = vj.g(parcel, iA);
                    break;
                case 5:
                    iBinderG3 = vj.g(parcel, iA);
                    break;
                case 6:
                    iBinderG4 = vj.g(parcel, iA);
                    break;
                case 7:
                    strF = vj.f(parcel, iA);
                    break;
                case 8:
                    zC = vj.c(parcel, iA);
                    break;
                case 9:
                    strF2 = vj.f(parcel, iA);
                    break;
                case 10:
                    iBinderG5 = vj.g(parcel, iA);
                    break;
                case 11:
                    iD2 = vj.d(parcel, iA);
                    break;
                case 12:
                    iD3 = vj.d(parcel, iA);
                    break;
                case 13:
                    strF3 = vj.f(parcel, iA);
                    break;
                case 14:
                    versionInfoParcel = (VersionInfoParcel) vj.a(parcel, iA, VersionInfoParcel.CREATOR);
                    break;
                case 15:
                    iBinderG6 = vj.g(parcel, iA);
                    break;
                case 16:
                    strF4 = vj.f(parcel, iA);
                    break;
                case 17:
                    interstitialAdParameterParcel = (InterstitialAdParameterParcel) vj.a(parcel, iA, InterstitialAdParameterParcel.CREATOR);
                    break;
                default:
                    vj.b(parcel, iA);
                    break;
            }
        }
        if (parcel.dataPosition() != iB) {
            throw new vj.a("Overread allowed size end=" + iB, parcel);
        }
        return new AdOverlayInfoParcel(iD, adLauncherIntentInfoParcel, iBinderG, iBinderG2, iBinderG3, iBinderG4, strF, zC, strF2, iBinderG5, iD2, iD3, strF3, versionInfoParcel, iBinderG6, strF4, interstitialAdParameterParcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdOverlayInfoParcel[] newArray(int i) {
        return new AdOverlayInfoParcel[i];
    }
}
