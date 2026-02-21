package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bfrx.MediaItem;
import defpackage.afy;
import defpackage.afz;
import defpackage.aga;

/* JADX INFO: loaded from: classes.dex */
public interface afd extends IInterface {
    void a();

    void a(long j, int i);

    void a(afz afzVar);

    void a(aga agaVar);

    void a(MediaItem mediaItem, boolean z);

    void a(boolean z, afy afyVar, int i);

    boolean a(int i);

    boolean a(int i, long j, long j2);

    boolean a(long j);

    boolean a(long j, byte[] bArr);

    boolean a(Bundle bundle);

    boolean a(MediaItem mediaItem, long j);

    void b();

    void b(int i);

    boolean b(long j);

    void c();

    boolean c(int i);

    boolean c(long j);

    void d();

    void d(int i);

    void e();

    void f();

    int g();

    MediaItem h();

    boolean i();

    boolean j();

    public static abstract class a extends Binder implements afd {
        public a() {
            attachInterface(this, "com.harman.commom.lib.fc.IFcService");
        }

        public static afd a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.harman.commom.lib.fc.IFcService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof afd)) {
                return (afd) iInterfaceQueryLocalInterface;
            }
            return new C0002a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    a(parcel.readInt() != 0, afy.a.a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    a();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    boolean zA = a(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zA ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    b();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    c();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    d();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    b(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    a(parcel.readLong(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    boolean zA2 = a(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zA2 ? 1 : 0);
                    return true;
                case 10:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    boolean zB = b(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zB ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    boolean zC = c(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zC ? 1 : 0);
                    return true;
                case 12:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    boolean zC2 = c(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zC2 ? 1 : 0);
                    return true;
                case 13:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    d(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    e();
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    f();
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    MediaItem mediaItemCreateFromParcel = parcel.readInt() != 0 ? MediaItem.CREATOR.createFromParcel(parcel) : null;
                    a(mediaItemCreateFromParcel, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    if (mediaItemCreateFromParcel != null) {
                        parcel2.writeInt(1);
                        mediaItemCreateFromParcel.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 17:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    MediaItem mediaItemCreateFromParcel2 = parcel.readInt() != 0 ? MediaItem.CREATOR.createFromParcel(parcel) : null;
                    boolean zA3 = a(mediaItemCreateFromParcel2, parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zA3 ? 1 : 0);
                    if (mediaItemCreateFromParcel2 != null) {
                        parcel2.writeInt(1);
                        mediaItemCreateFromParcel2.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 18:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    int iG = g();
                    parcel2.writeNoException();
                    parcel2.writeInt(iG);
                    return true;
                case 19:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    boolean zA4 = a(bundle);
                    parcel2.writeNoException();
                    parcel2.writeInt(zA4 ? 1 : 0);
                    if (bundle != null) {
                        parcel2.writeInt(1);
                        bundle.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 20:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    a(afz.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    a(aga.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    long j = parcel.readLong();
                    byte[] bArrCreateByteArray = parcel.createByteArray();
                    boolean zA5 = a(j, bArrCreateByteArray);
                    parcel2.writeNoException();
                    parcel2.writeInt(zA5 ? 1 : 0);
                    parcel2.writeByteArray(bArrCreateByteArray);
                    return true;
                case 23:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    boolean zA6 = a(parcel.readInt(), parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zA6 ? 1 : 0);
                    return true;
                case 24:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    MediaItem mediaItemH = h();
                    parcel2.writeNoException();
                    if (mediaItemH != null) {
                        parcel2.writeInt(1);
                        mediaItemH.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 25:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    boolean zI = i();
                    parcel2.writeNoException();
                    parcel2.writeInt(zI ? 1 : 0);
                    return true;
                case 26:
                    parcel.enforceInterface("com.harman.commom.lib.fc.IFcService");
                    boolean zJ = j();
                    parcel2.writeNoException();
                    parcel2.writeInt(zJ ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.harman.commom.lib.fc.IFcService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: afd$a$a, reason: collision with other inner class name */
        static class C0002a implements afd {
            private IBinder a;

            C0002a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.afd
            public void a(boolean z, afy afyVar, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeStrongBinder(afyVar != null ? afyVar.asBinder() : null);
                    parcelObtain.writeInt(i);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public void a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public boolean a(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    parcelObtain.writeInt(i);
                    this.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public void b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    this.a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public void c() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    this.a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public void d() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    this.a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public void b(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    parcelObtain.writeInt(i);
                    this.a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public void a(long j, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(i);
                    this.a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public boolean a(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    parcelObtain.writeLong(j);
                    this.a.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public boolean b(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    parcelObtain.writeLong(j);
                    this.a.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public boolean c(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    parcelObtain.writeInt(i);
                    this.a.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public boolean c(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    parcelObtain.writeLong(j);
                    this.a.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public void d(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    parcelObtain.writeInt(i);
                    this.a.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public void e() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    this.a.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public void f() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    this.a.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public void a(MediaItem mediaItem, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    if (mediaItem != null) {
                        parcelObtain.writeInt(1);
                        mediaItem.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.a.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        mediaItem.readFromParcel(parcelObtain2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public boolean a(MediaItem mediaItem, long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    if (mediaItem != null) {
                        parcelObtain.writeInt(1);
                        mediaItem.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeLong(j);
                    this.a.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    boolean z = parcelObtain2.readInt() != 0;
                    if (parcelObtain2.readInt() != 0) {
                        mediaItem.readFromParcel(parcelObtain2);
                    }
                    return z;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public int g() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    this.a.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public boolean a(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    boolean z = parcelObtain2.readInt() != 0;
                    if (parcelObtain2.readInt() != 0) {
                        bundle.readFromParcel(parcelObtain2);
                    }
                    return z;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public void a(afz afzVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    parcelObtain.writeStrongBinder(afzVar != null ? afzVar.asBinder() : null);
                    this.a.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public void a(aga agaVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    parcelObtain.writeStrongBinder(agaVar != null ? agaVar.asBinder() : null);
                    this.a.transact(21, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public boolean a(long j, byte[] bArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeByteArray(bArr);
                    this.a.transact(22, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    boolean z = parcelObtain2.readInt() != 0;
                    parcelObtain2.readByteArray(bArr);
                    return z;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public boolean a(int i, long j, long j2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    this.a.transact(23, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public MediaItem h() {
                MediaItem mediaItemCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    this.a.transact(24, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        mediaItemCreateFromParcel = MediaItem.CREATOR.createFromParcel(parcelObtain2);
                    } else {
                        mediaItemCreateFromParcel = null;
                    }
                    return mediaItemCreateFromParcel;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public boolean i() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    this.a.transact(25, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afd
            public boolean j() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.lib.fc.IFcService");
                    this.a.transact(26, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
