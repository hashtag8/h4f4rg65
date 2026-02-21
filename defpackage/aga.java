package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bfrx.MediaItem;

/* JADX INFO: loaded from: classes.dex */
public interface aga extends IInterface {
    int a(MediaItem mediaItem);

    void a();

    void a(int i, String str);

    void a(long j);

    void a(long j, String str, long j2);

    void a(String str, String str2);

    void a(boolean z);

    void b();

    void b(MediaItem mediaItem);

    boolean b(boolean z);

    void c();

    void c(MediaItem mediaItem);

    void c(boolean z);

    void d();

    void e();

    void f();

    void g();

    void h();

    void i();

    public static abstract class a extends Binder implements aga {
        public a() {
            attachInterface(this, "com.harman.commom.music.player.service.IFcPlayStateListener");
        }

        public static aga a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.harman.commom.music.player.service.IFcPlayStateListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof aga)) {
                return (aga) iInterfaceQueryLocalInterface;
            }
            return new C0005a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            MediaItem mediaItemCreateFromParcel;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcPlayStateListener");
                    a(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcPlayStateListener");
                    a();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcPlayStateListener");
                    a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcPlayStateListener");
                    b();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcPlayStateListener");
                    a(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcPlayStateListener");
                    mediaItemCreateFromParcel = parcel.readInt() != 0 ? MediaItem.CREATOR.createFromParcel(parcel) : null;
                    int iA = a(mediaItemCreateFromParcel);
                    parcel2.writeNoException();
                    parcel2.writeInt(iA);
                    if (mediaItemCreateFromParcel != null) {
                        parcel2.writeInt(1);
                        mediaItemCreateFromParcel.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 7:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcPlayStateListener");
                    boolean zB = b(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(zB ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcPlayStateListener");
                    c();
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcPlayStateListener");
                    c(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcPlayStateListener");
                    d();
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcPlayStateListener");
                    e();
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcPlayStateListener");
                    f();
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcPlayStateListener");
                    g();
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcPlayStateListener");
                    a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcPlayStateListener");
                    h();
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcPlayStateListener");
                    mediaItemCreateFromParcel = parcel.readInt() != 0 ? MediaItem.CREATOR.createFromParcel(parcel) : null;
                    b(mediaItemCreateFromParcel);
                    parcel2.writeNoException();
                    if (mediaItemCreateFromParcel != null) {
                        parcel2.writeInt(1);
                        mediaItemCreateFromParcel.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 17:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcPlayStateListener");
                    mediaItemCreateFromParcel = parcel.readInt() != 0 ? MediaItem.CREATOR.createFromParcel(parcel) : null;
                    c(mediaItemCreateFromParcel);
                    parcel2.writeNoException();
                    if (mediaItemCreateFromParcel != null) {
                        parcel2.writeInt(1);
                        mediaItemCreateFromParcel.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 18:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcPlayStateListener");
                    i();
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcPlayStateListener");
                    a(parcel.readLong(), parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.harman.commom.music.player.service.IFcPlayStateListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: aga$a$a, reason: collision with other inner class name */
        static class C0005a implements aga {
            private IBinder a;

            C0005a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.aga
            public void a(int i, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcPlayStateListener");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.aga
            public void a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcPlayStateListener");
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.aga
            public void a(boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcPlayStateListener");
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.aga
            public void b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcPlayStateListener");
                    this.a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.aga
            public void a(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcPlayStateListener");
                    parcelObtain.writeLong(j);
                    this.a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.aga
            public int a(MediaItem mediaItem) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcPlayStateListener");
                    if (mediaItem != null) {
                        parcelObtain.writeInt(1);
                        mediaItem.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    int i = parcelObtain2.readInt();
                    if (parcelObtain2.readInt() != 0) {
                        mediaItem.readFromParcel(parcelObtain2);
                    }
                    return i;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.aga
            public boolean b(boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcPlayStateListener");
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.aga
            public void c() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcPlayStateListener");
                    this.a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.aga
            public void c(boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcPlayStateListener");
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.a.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.aga
            public void d() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcPlayStateListener");
                    this.a.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.aga
            public void e() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcPlayStateListener");
                    this.a.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.aga
            public void f() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcPlayStateListener");
                    this.a.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.aga
            public void g() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcPlayStateListener");
                    this.a.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.aga
            public void a(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcPlayStateListener");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.a.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.aga
            public void h() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcPlayStateListener");
                    this.a.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.aga
            public void b(MediaItem mediaItem) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcPlayStateListener");
                    if (mediaItem != null) {
                        parcelObtain.writeInt(1);
                        mediaItem.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
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

            @Override // defpackage.aga
            public void c(MediaItem mediaItem) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcPlayStateListener");
                    if (mediaItem != null) {
                        parcelObtain.writeInt(1);
                        mediaItem.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        mediaItem.readFromParcel(parcelObtain2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.aga
            public void i() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcPlayStateListener");
                    this.a.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.aga
            public void a(long j, String str, long j2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcPlayStateListener");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j2);
                    this.a.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
