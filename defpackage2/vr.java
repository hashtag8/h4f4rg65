package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.stats.ConnectionEvent;
import defpackage.vj;

/* JADX INFO: loaded from: classes.dex */
public class vr implements Parcelable.Creator<ConnectionEvent> {
    public static void a(ConnectionEvent connectionEvent, Parcel parcel, int i) {
        int iA = vk.a(parcel);
        vk.a(parcel, 1, connectionEvent.a);
        vk.a(parcel, 2, connectionEvent.a());
        vk.a(parcel, 4, connectionEvent.c(), false);
        vk.a(parcel, 5, connectionEvent.d(), false);
        vk.a(parcel, 6, connectionEvent.e(), false);
        vk.a(parcel, 7, connectionEvent.f(), false);
        vk.a(parcel, 8, connectionEvent.g(), false);
        vk.a(parcel, 10, connectionEvent.j());
        vk.a(parcel, 11, connectionEvent.i());
        vk.a(parcel, 12, connectionEvent.b());
        vk.a(parcel, 13, connectionEvent.h(), false);
        vk.a(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConnectionEvent createFromParcel(Parcel parcel) {
        int iB = vj.b(parcel);
        int iD = 0;
        long jE = 0;
        int iD2 = 0;
        String strF = null;
        String strF2 = null;
        String strF3 = null;
        String strF4 = null;
        String strF5 = null;
        String strF6 = null;
        long jE2 = 0;
        long jE3 = 0;
        while (parcel.dataPosition() < iB) {
            int iA = vj.a(parcel);
            switch (vj.a(iA)) {
                case 1:
                    iD = vj.d(parcel, iA);
                    break;
                case 2:
                    jE = vj.e(parcel, iA);
                    break;
                case 3:
                case 9:
                default:
                    vj.b(parcel, iA);
                    break;
                case 4:
                    strF = vj.f(parcel, iA);
                    break;
                case 5:
                    strF2 = vj.f(parcel, iA);
                    break;
                case 6:
                    strF3 = vj.f(parcel, iA);
                    break;
                case 7:
                    strF4 = vj.f(parcel, iA);
                    break;
                case 8:
                    strF5 = vj.f(parcel, iA);
                    break;
                case 10:
                    jE2 = vj.e(parcel, iA);
                    break;
                case 11:
                    jE3 = vj.e(parcel, iA);
                    break;
                case 12:
                    iD2 = vj.d(parcel, iA);
                    break;
                case 13:
                    strF6 = vj.f(parcel, iA);
                    break;
            }
        }
        if (parcel.dataPosition() != iB) {
            throw new vj.a("Overread allowed size end=" + iB, parcel);
        }
        return new ConnectionEvent(iD, jE, iD2, strF, strF2, strF3, strF4, strF5, strF6, jE2, jE3);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConnectionEvent[] newArray(int i) {
        return new ConnectionEvent[i];
    }
}
