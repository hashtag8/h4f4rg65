package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import defpackage.vj;

/* JADX INFO: loaded from: classes.dex */
public class sf implements Parcelable.Creator<GInAppPurchaseManagerInfoParcel> {
    public static void a(GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel, Parcel parcel, int i) {
        int iA = vk.a(parcel);
        vk.a(parcel, 1, gInAppPurchaseManagerInfoParcel.a);
        vk.a(parcel, 3, gInAppPurchaseManagerInfoParcel.b(), false);
        vk.a(parcel, 4, gInAppPurchaseManagerInfoParcel.c(), false);
        vk.a(parcel, 5, gInAppPurchaseManagerInfoParcel.d(), false);
        vk.a(parcel, 6, gInAppPurchaseManagerInfoParcel.a(), false);
        vk.a(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public GInAppPurchaseManagerInfoParcel createFromParcel(Parcel parcel) {
        IBinder iBinderG = null;
        int iB = vj.b(parcel);
        int iD = 0;
        IBinder iBinderG2 = null;
        IBinder iBinderG3 = null;
        IBinder iBinderG4 = null;
        while (parcel.dataPosition() < iB) {
            int iA = vj.a(parcel);
            switch (vj.a(iA)) {
                case 1:
                    iD = vj.d(parcel, iA);
                    break;
                case 2:
                default:
                    vj.b(parcel, iA);
                    break;
                case 3:
                    iBinderG4 = vj.g(parcel, iA);
                    break;
                case 4:
                    iBinderG3 = vj.g(parcel, iA);
                    break;
                case 5:
                    iBinderG2 = vj.g(parcel, iA);
                    break;
                case 6:
                    iBinderG = vj.g(parcel, iA);
                    break;
            }
        }
        if (parcel.dataPosition() != iB) {
            throw new vj.a("Overread allowed size end=" + iB, parcel);
        }
        return new GInAppPurchaseManagerInfoParcel(iD, iBinderG4, iBinderG3, iBinderG2, iBinderG);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public GInAppPurchaseManagerInfoParcel[] newArray(int i) {
        return new GInAppPurchaseManagerInfoParcel[i];
    }
}
