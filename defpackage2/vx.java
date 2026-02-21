package defpackage;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import defpackage.vj;

/* JADX INFO: loaded from: classes.dex */
public class vx implements Parcelable.Creator<ConnectionResult> {
    public static void a(ConnectionResult connectionResult, Parcel parcel, int i) {
        int iA = vk.a(parcel);
        vk.a(parcel, 1, connectionResult.b);
        vk.a(parcel, 2, connectionResult.a());
        vk.a(parcel, 3, (Parcelable) connectionResult.b(), i, false);
        vk.a(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConnectionResult createFromParcel(Parcel parcel) {
        int iD = 0;
        int iB = vj.b(parcel);
        PendingIntent pendingIntent = null;
        int iD2 = 0;
        while (parcel.dataPosition() < iB) {
            int iA = vj.a(parcel);
            switch (vj.a(iA)) {
                case 1:
                    iD2 = vj.d(parcel, iA);
                    break;
                case 2:
                    iD = vj.d(parcel, iA);
                    break;
                case 3:
                    pendingIntent = (PendingIntent) vj.a(parcel, iA, PendingIntent.CREATOR);
                    break;
                default:
                    vj.b(parcel, iA);
                    break;
            }
        }
        if (parcel.dataPosition() != iB) {
            throw new vj.a("Overread allowed size end=" + iB, parcel);
        }
        return new ConnectionResult(iD2, iD, pendingIntent);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConnectionResult[] newArray(int i) {
        return new ConnectionResult[i];
    }
}
