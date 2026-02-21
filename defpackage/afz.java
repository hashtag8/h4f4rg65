package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface afz extends IInterface {
    void a();

    void a(int i);

    void a(long j);

    void a(long j, int i);

    void a(long j, int i, String str);

    void a(long j, String str);

    void a(long j, byte[] bArr, byte[] bArr2);

    void a(Bundle bundle);

    void b(long j);

    void b(long j, int i, String str);

    public static abstract class a extends Binder implements afz {
        public a() {
            attachInterface(this, "com.harman.commom.music.player.service.IFcListener");
        }

        public static afz a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.harman.commom.music.player.service.IFcListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof afz)) {
                return (afz) iInterfaceQueryLocalInterface;
            }
            return new C0004a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            Bundle bundle;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcListener");
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    a(bundle);
                    parcel2.writeNoException();
                    if (bundle != null) {
                        parcel2.writeInt(1);
                        bundle.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcListener");
                    a(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcListener");
                    a();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcListener");
                    a(parcel.readLong(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcListener");
                    a(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcListener");
                    b(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcListener");
                    long j = parcel.readLong();
                    byte[] bArrCreateByteArray = parcel.createByteArray();
                    byte[] bArrCreateByteArray2 = parcel.createByteArray();
                    a(j, bArrCreateByteArray, bArrCreateByteArray2);
                    parcel2.writeNoException();
                    parcel2.writeByteArray(bArrCreateByteArray);
                    parcel2.writeByteArray(bArrCreateByteArray2);
                    return true;
                case 8:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcListener");
                    a(parcel.readLong(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcListener");
                    a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcListener");
                    b(parcel.readLong(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.harman.commom.music.player.service.IFcListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: afz$a$a, reason: collision with other inner class name */
        static class C0004a implements afz {
            private IBinder a;

            C0004a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.afz
            public void a(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcListener");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        bundle.readFromParcel(parcelObtain2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afz
            public void a(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcListener");
                    parcelObtain.writeLong(j);
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afz
            public void a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcListener");
                    this.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afz
            public void a(long j, int i, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcListener");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    this.a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afz
            public void a(long j, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcListener");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    this.a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afz
            public void b(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcListener");
                    parcelObtain.writeLong(j);
                    this.a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afz
            public void a(long j, byte[] bArr, byte[] bArr2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcListener");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeByteArray(bArr2);
                    this.a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.readByteArray(bArr);
                    parcelObtain2.readByteArray(bArr2);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afz
            public void a(long j, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcListener");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(i);
                    this.a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afz
            public void a(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcListener");
                    parcelObtain.writeInt(i);
                    this.a.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afz
            public void b(long j, int i, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcListener");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    this.a.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
