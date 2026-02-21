package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.harman.commom.util.error.ErrorInfo;

/* JADX INFO: loaded from: classes.dex */
public interface afy extends IInterface {
    void a();

    void a(ErrorInfo errorInfo);

    public static abstract class a extends Binder implements afy {
        public a() {
            attachInterface(this, "com.harman.commom.music.player.service.IFcLibraryListener");
        }

        public static afy a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.harman.commom.music.player.service.IFcLibraryListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof afy)) {
                return (afy) iInterfaceQueryLocalInterface;
            }
            return new C0003a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            ErrorInfo errorInfoCreateFromParcel;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcLibraryListener");
                    a();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.harman.commom.music.player.service.IFcLibraryListener");
                    if (parcel.readInt() != 0) {
                        errorInfoCreateFromParcel = ErrorInfo.CREATOR.createFromParcel(parcel);
                    } else {
                        errorInfoCreateFromParcel = null;
                    }
                    a(errorInfoCreateFromParcel);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.harman.commom.music.player.service.IFcLibraryListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: afy$a$a, reason: collision with other inner class name */
        static class C0003a implements afy {
            private IBinder a;

            C0003a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.afy
            public void a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcLibraryListener");
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.afy
            public void a(ErrorInfo errorInfo) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.harman.commom.music.player.service.IFcLibraryListener");
                    if (errorInfo != null) {
                        parcelObtain.writeInt(1);
                        errorInfo.writeToParcel(parcelObtain, 0);
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
        }
    }
}
