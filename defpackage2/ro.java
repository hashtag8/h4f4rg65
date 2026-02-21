package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import defpackage.wa;
import defpackage.xy;

/* JADX INFO: loaded from: classes.dex */
public interface ro extends IInterface {

    public static abstract class a extends Binder implements ro {

        /* JADX INFO: renamed from: ro$a$a, reason: collision with other inner class name */
        static class C0154a implements ro {
            private IBinder a;

            C0154a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // defpackage.ro
            public IBinder a(wa waVar, AdSizeParcel adSizeParcel, String str, xy xyVar, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    parcelObtain.writeStrongBinder(waVar != null ? waVar.asBinder() : null);
                    if (adSizeParcel != null) {
                        parcelObtain.writeInt(1);
                        adSizeParcel.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(xyVar != null ? xyVar.asBinder() : null);
                    parcelObtain.writeInt(i);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readStrongBinder();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.ro
            public IBinder a(wa waVar, AdSizeParcel adSizeParcel, String str, xy xyVar, int i, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    parcelObtain.writeStrongBinder(waVar != null ? waVar.asBinder() : null);
                    if (adSizeParcel != null) {
                        parcelObtain.writeInt(1);
                        adSizeParcel.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(xyVar != null ? xyVar.asBinder() : null);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readStrongBinder();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static ro a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ro)) ? new C0154a(iBinder) : (ro) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    IBinder iBinderA = a(wa.a.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AdSizeParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), xy.a.a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iBinderA);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    IBinder iBinderA2 = a(wa.a.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AdSizeParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), xy.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iBinderA2);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IBinder a(wa waVar, AdSizeParcel adSizeParcel, String str, xy xyVar, int i);

    IBinder a(wa waVar, AdSizeParcel adSizeParcel, String str, xy xyVar, int i, int i2);
}
