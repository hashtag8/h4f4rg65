package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
class bma implements bmb {
    private final Context a;

    public bma(Context context) {
        this.a = context.getApplicationContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [bma$1] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    @Override // defpackage.bmb
    public blx a() {
        blx blxVar = 0;
        blxVar = 0;
        blxVar = 0;
        blxVar = 0;
        blxVar = 0;
        blxVar = 0;
        blxVar = 0;
        blxVar = 0;
        blxVar = 0;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            blh.h().a("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
        } else {
            try {
                this.a.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
                a aVar = new a();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
                try {
                    try {
                    } catch (Exception e) {
                        blh.h().d("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", e);
                    } finally {
                        this.a.unbindService(aVar);
                    }
                    if (this.a.bindService(intent, aVar, 1)) {
                        b bVar = new b(aVar.a());
                        blxVar = new blx(bVar.a(), bVar.b());
                    } else {
                        blh.h().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
                    }
                } catch (Throwable th) {
                    blh.h().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", th);
                }
            } catch (PackageManager.NameNotFoundException e2) {
                blh.h().a("Fabric", "Unable to find Google Play Services package name");
            } catch (Exception e3) {
                blh.h().a("Fabric", "Unable to determine if Google Play Services is available", e3);
            }
        }
        return blxVar;
    }

    static final class a implements ServiceConnection {
        private boolean a;
        private final LinkedBlockingQueue<IBinder> b;

        private a() {
            this.a = false;
            this.b = new LinkedBlockingQueue<>(1);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.b.clear();
        }

        public IBinder a() {
            if (this.a) {
                blh.h().e("Fabric", "getBinder already called");
            }
            this.a = true;
            try {
                return this.b.poll(200L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                return null;
            }
        }
    }

    static final class b implements IInterface {
        private final IBinder a;

        public b(IBinder iBinder) {
            this.a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.a;
        }

        public String a() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            String string = null;
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string = parcelObtain2.readString();
            } catch (Exception e) {
                blh.h().a("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
            return string;
        }

        public boolean b() {
            boolean z;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    parcelObtain.writeInt(1);
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    z = parcelObtain2.readInt() != 0;
                } catch (Exception e) {
                    blh.h().a("Fabric", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    z = false;
                }
                return z;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}
