package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class vj {

    public static class a extends RuntimeException {
        public a(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static int a(int i) {
        return 65535 & i;
    }

    public static int a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int a(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static <T extends Parcelable> T a(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int iA = a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        T tCreateFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(iA + iDataPosition);
        return tCreateFromParcel;
    }

    private static void a(Parcel parcel, int i, int i2) {
        int iA = a(parcel, i);
        if (iA != i2) {
            throw new a("Expected size " + i2 + " got " + iA + " (0x" + Integer.toHexString(iA) + ")", parcel);
        }
    }

    public static int b(Parcel parcel) {
        int iA = a(parcel);
        int iA2 = a(parcel, iA);
        int iDataPosition = parcel.dataPosition();
        if (a(iA) != 20293) {
            throw new a("Expected object header. Got 0x" + Integer.toHexString(iA), parcel);
        }
        int i = iDataPosition + iA2;
        if (i < iDataPosition || i > parcel.dataSize()) {
            throw new a("Size read is invalid start=" + iDataPosition + " end=" + i, parcel);
        }
        return i;
    }

    public static void b(Parcel parcel, int i) {
        parcel.setDataPosition(a(parcel, i) + parcel.dataPosition());
    }

    public static <T> T[] b(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int iA = a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(iA + iDataPosition);
        return tArr;
    }

    public static boolean c(Parcel parcel, int i) {
        a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static int d(Parcel parcel, int i) {
        a(parcel, i, 4);
        return parcel.readInt();
    }

    public static long e(Parcel parcel, int i) {
        a(parcel, i, 8);
        return parcel.readLong();
    }

    public static String f(Parcel parcel, int i) {
        int iA = a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iA + iDataPosition);
        return string;
    }

    public static IBinder g(Parcel parcel, int i) {
        int iA = a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iA + iDataPosition);
        return strongBinder;
    }

    public static Bundle h(Parcel parcel, int i) {
        int iA = a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iA + iDataPosition);
        return bundle;
    }

    public static ArrayList<String> i(Parcel parcel, int i) {
        int iA = a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iA + iDataPosition);
        return arrayListCreateStringArrayList;
    }
}
