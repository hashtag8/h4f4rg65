package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import defpackage.vj;

/* JADX INFO: loaded from: classes.dex */
public class ss implements Parcelable.Creator<RewardItemParcel> {
    public static void a(RewardItemParcel rewardItemParcel, Parcel parcel, int i) {
        int iA = vk.a(parcel);
        vk.a(parcel, 1, rewardItemParcel.a);
        vk.a(parcel, 2, rewardItemParcel.b, false);
        vk.a(parcel, 3, rewardItemParcel.c);
        vk.a(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RewardItemParcel createFromParcel(Parcel parcel) {
        int iD = 0;
        int iB = vj.b(parcel);
        String strF = null;
        int iD2 = 0;
        while (parcel.dataPosition() < iB) {
            int iA = vj.a(parcel);
            switch (vj.a(iA)) {
                case 1:
                    iD2 = vj.d(parcel, iA);
                    break;
                case 2:
                    strF = vj.f(parcel, iA);
                    break;
                case 3:
                    iD = vj.d(parcel, iA);
                    break;
                default:
                    vj.b(parcel, iA);
                    break;
            }
        }
        if (parcel.dataPosition() != iB) {
            throw new vj.a("Overread allowed size end=" + iB, parcel);
        }
        return new RewardItemParcel(iD2, strF, iD);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RewardItemParcel[] newArray(int i) {
        return new RewardItemParcel[i];
    }
}
