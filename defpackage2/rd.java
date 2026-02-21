package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import defpackage.vj;

/* JADX INFO: loaded from: classes.dex */
public class rd implements Parcelable.Creator<SearchAdRequestParcel> {
    public static void a(SearchAdRequestParcel searchAdRequestParcel, Parcel parcel, int i) {
        int iA = vk.a(parcel);
        vk.a(parcel, 1, searchAdRequestParcel.a);
        vk.a(parcel, 2, searchAdRequestParcel.b);
        vk.a(parcel, 3, searchAdRequestParcel.c);
        vk.a(parcel, 4, searchAdRequestParcel.d);
        vk.a(parcel, 5, searchAdRequestParcel.e);
        vk.a(parcel, 6, searchAdRequestParcel.f);
        vk.a(parcel, 7, searchAdRequestParcel.g);
        vk.a(parcel, 8, searchAdRequestParcel.h);
        vk.a(parcel, 9, searchAdRequestParcel.i);
        vk.a(parcel, 10, searchAdRequestParcel.j, false);
        vk.a(parcel, 11, searchAdRequestParcel.k);
        vk.a(parcel, 12, searchAdRequestParcel.l, false);
        vk.a(parcel, 13, searchAdRequestParcel.m);
        vk.a(parcel, 14, searchAdRequestParcel.n);
        vk.a(parcel, 15, searchAdRequestParcel.o, false);
        vk.a(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SearchAdRequestParcel createFromParcel(Parcel parcel) {
        int iB = vj.b(parcel);
        int iD = 0;
        int iD2 = 0;
        int iD3 = 0;
        int iD4 = 0;
        int iD5 = 0;
        int iD6 = 0;
        int iD7 = 0;
        int iD8 = 0;
        int iD9 = 0;
        String strF = null;
        int iD10 = 0;
        String strF2 = null;
        int iD11 = 0;
        int iD12 = 0;
        String strF3 = null;
        while (parcel.dataPosition() < iB) {
            int iA = vj.a(parcel);
            switch (vj.a(iA)) {
                case 1:
                    iD = vj.d(parcel, iA);
                    break;
                case 2:
                    iD2 = vj.d(parcel, iA);
                    break;
                case 3:
                    iD3 = vj.d(parcel, iA);
                    break;
                case 4:
                    iD4 = vj.d(parcel, iA);
                    break;
                case 5:
                    iD5 = vj.d(parcel, iA);
                    break;
                case 6:
                    iD6 = vj.d(parcel, iA);
                    break;
                case 7:
                    iD7 = vj.d(parcel, iA);
                    break;
                case 8:
                    iD8 = vj.d(parcel, iA);
                    break;
                case 9:
                    iD9 = vj.d(parcel, iA);
                    break;
                case 10:
                    strF = vj.f(parcel, iA);
                    break;
                case 11:
                    iD10 = vj.d(parcel, iA);
                    break;
                case 12:
                    strF2 = vj.f(parcel, iA);
                    break;
                case 13:
                    iD11 = vj.d(parcel, iA);
                    break;
                case 14:
                    iD12 = vj.d(parcel, iA);
                    break;
                case 15:
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
        return new SearchAdRequestParcel(iD, iD2, iD3, iD4, iD5, iD6, iD7, iD8, iD9, strF, iD10, strF2, iD11, iD12, strF3);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SearchAdRequestParcel[] newArray(int i) {
        return new SearchAdRequestParcel[i];
    }
}
