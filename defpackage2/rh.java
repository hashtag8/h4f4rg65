package defpackage;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import defpackage.vj;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class rh implements Parcelable.Creator<AdRequestParcel> {
    public static void a(AdRequestParcel adRequestParcel, Parcel parcel, int i) {
        int iA = vk.a(parcel);
        vk.a(parcel, 1, adRequestParcel.a);
        vk.a(parcel, 2, adRequestParcel.b);
        vk.a(parcel, 3, adRequestParcel.c, false);
        vk.a(parcel, 4, adRequestParcel.d);
        vk.a(parcel, 5, adRequestParcel.e, false);
        vk.a(parcel, 6, adRequestParcel.f);
        vk.a(parcel, 7, adRequestParcel.g);
        vk.a(parcel, 8, adRequestParcel.h);
        vk.a(parcel, 9, adRequestParcel.i, false);
        vk.a(parcel, 10, (Parcelable) adRequestParcel.j, i, false);
        vk.a(parcel, 11, (Parcelable) adRequestParcel.k, i, false);
        vk.a(parcel, 12, adRequestParcel.l, false);
        vk.a(parcel, 13, adRequestParcel.m, false);
        vk.a(parcel, 14, adRequestParcel.n, false);
        vk.a(parcel, 15, adRequestParcel.o, false);
        vk.a(parcel, 16, adRequestParcel.p, false);
        vk.a(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdRequestParcel createFromParcel(Parcel parcel) {
        int iB = vj.b(parcel);
        int iD = 0;
        long jE = 0;
        Bundle bundleH = null;
        int iD2 = 0;
        ArrayList<String> arrayListI = null;
        boolean zC = false;
        int iD3 = 0;
        boolean zC2 = false;
        String strF = null;
        SearchAdRequestParcel searchAdRequestParcel = null;
        Location location = null;
        String strF2 = null;
        Bundle bundleH2 = null;
        Bundle bundleH3 = null;
        ArrayList<String> arrayListI2 = null;
        String strF3 = null;
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
                    bundleH = vj.h(parcel, iA);
                    break;
                case 4:
                    iD2 = vj.d(parcel, iA);
                    break;
                case 5:
                    arrayListI = vj.i(parcel, iA);
                    break;
                case 6:
                    zC = vj.c(parcel, iA);
                    break;
                case 7:
                    iD3 = vj.d(parcel, iA);
                    break;
                case 8:
                    zC2 = vj.c(parcel, iA);
                    break;
                case 9:
                    strF = vj.f(parcel, iA);
                    break;
                case 10:
                    searchAdRequestParcel = (SearchAdRequestParcel) vj.a(parcel, iA, SearchAdRequestParcel.CREATOR);
                    break;
                case 11:
                    location = (Location) vj.a(parcel, iA, Location.CREATOR);
                    break;
                case 12:
                    strF2 = vj.f(parcel, iA);
                    break;
                case 13:
                    bundleH2 = vj.h(parcel, iA);
                    break;
                case 14:
                    bundleH3 = vj.h(parcel, iA);
                    break;
                case 15:
                    arrayListI2 = vj.i(parcel, iA);
                    break;
                case 16:
                    strF3 = vj.f(parcel, iA);
                    break;
                default:
                    vj.b(parcel, iA);
                    break;
            }
        }
        if (parcel.dataPosition() != iB) {
            throw new vj.a("Overread allowed size end=" + iB, parcel);
        }
        return new AdRequestParcel(iD, jE, bundleH, iD2, arrayListI, zC, iD3, zC2, strF, searchAdRequestParcel, location, strF2, bundleH2, bundleH3, arrayListI2, strF3);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdRequestParcel[] newArray(int i) {
        return new AdRequestParcel[i];
    }
}
