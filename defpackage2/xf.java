package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.wa;

/* JADX INFO: loaded from: classes.dex */
public interface xf extends IInterface {

    public static abstract class a extends Binder implements xf {

        /* JADX INFO: renamed from: xf$a$a, reason: collision with other inner class name */
        static class C0162a implements xf {
            private IBinder a;

            C0162a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // defpackage.xf
            public IBinder a(wa waVar, wa waVar2, wa waVar3, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                    parcelObtain.writeStrongBinder(waVar != null ? waVar.asBinder() : null);
                    parcelObtain.writeStrongBinder(waVar2 != null ? waVar2.asBinder() : null);
                    parcelObtain.writeStrongBinder(waVar3 != null ? waVar3.asBinder() : null);
                    parcelObtain.writeInt(i);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
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

        public static xf a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof xf)) ? new C0162a(iBinder) : (xf) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                    IBinder iBinderA = a(wa.a.a(parcel.readStrongBinder()), wa.a.a(parcel.readStrongBinder()), wa.a.a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iBinderA);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IBinder a(wa waVar, wa waVar2, wa waVar3, int i);
}
