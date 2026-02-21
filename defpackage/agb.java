package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.harman.commom.music.player.service.MusicData;
import com.harman.commom.music.player.service.PlayList;

/* JADX INFO: loaded from: classes.dex */
public interface agb extends IInterface {
    PlayList a();

    void a(int i);

    void a(long j);

    void a(MusicData musicData);

    void a(PlayList playList);

    void a(boolean z);

    void b();

    void b(int i);

    boolean c();

    MusicData d();

    long e();

    void f();

    void g();

    void h();

    void i();

    void j();

    void k();

    long l();

    int m();

    int n();

    void o();

    int p();

    public static abstract class a extends Binder implements agb {
        public a() {
            attachInterface(this, "com.harman.commom.music.player.service.IMusicService");
        }

        public static agb a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.harman.commom.music.player.service.IMusicService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof agb)) {
                return (agb) iInterfaceQueryLocalInterface;
            }
            return new C0006a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    a(parcel.readInt() != 0 ? MusicData.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    a(parcel.readInt() != 0 ? PlayList.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    PlayList playListA = a();
                    parcel2.writeNoException();
                    if (playListA != null) {
                        parcel2.writeInt(1);
                        playListA.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    b();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    boolean zC = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(zC ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    MusicData musicDataD = d();
                    parcel2.writeNoException();
                    if (musicDataD != null) {
                        parcel2.writeInt(1);
                        musicDataD.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 7:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    long jE = e();
                    parcel2.writeNoException();
                    parcel2.writeLong(jE);
                    return true;
                case 8:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    f();
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    g();
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    h();
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    i();
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    j();
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    k();
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    long jL = l();
                    parcel2.writeNoException();
                    parcel2.writeLong(jL);
                    return true;
                case 15:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    a(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    int iM = m();
                    parcel2.writeNoException();
                    parcel2.writeInt(iM);
                    return true;
                case 18:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    b(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    int iN = n();
                    parcel2.writeNoException();
                    parcel2.writeInt(iN);
                    return true;
                case 20:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    o();
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IMusicService");
                    int iP = p();
                    parcel2.writeNoException();
                    parcel2.writeInt(iP);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.harman.commom.music.player.service.IMusicService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: agb$a$a, reason: collision with other inner class name */
        static class C0006a implements agb {
            private IBinder a;

            C0006a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.agb
            public void a(MusicData musicData) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    if (musicData != null) {
                        parcelObtain.writeInt(1);
                        musicData.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public void a(PlayList playList) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    if (playList != null) {
                        parcelObtain.writeInt(1);
                        playList.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public PlayList a() {
                PlayList playListCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    this.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        playListCreateFromParcel = PlayList.CREATOR.createFromParcel(parcelObtain2);
                    } else {
                        playListCreateFromParcel = null;
                    }
                    return playListCreateFromParcel;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public void b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    this.a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public boolean c() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    this.a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public MusicData d() {
                MusicData musicDataCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    this.a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        musicDataCreateFromParcel = MusicData.CREATOR.createFromParcel(parcelObtain2);
                    } else {
                        musicDataCreateFromParcel = null;
                    }
                    return musicDataCreateFromParcel;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public long e() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    this.a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public void f() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    this.a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public void g() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    this.a.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public void h() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    this.a.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public void i() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    this.a.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public void j() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    this.a.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public void k() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    this.a.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public long l() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    this.a.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public void a(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    parcelObtain.writeLong(j);
                    this.a.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public void a(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    parcelObtain.writeInt(i);
                    this.a.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public int m() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    this.a.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public void b(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    parcelObtain.writeInt(i);
                    this.a.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public int n() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    this.a.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public void o() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    this.a.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public void a(boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.a.transact(21, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.agb
            public int p() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IMusicService");
                    this.a.transact(22, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
