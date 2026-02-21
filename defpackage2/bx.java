package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v8.renderscript.Allocation;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import defpackage.bw;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class bx {
    private static Field b;
    private static boolean c;
    private static final Object a = new Object();
    private static final Object d = new Object();

    public static class a implements bp, bq {
        private Notification.Builder a;
        private final Bundle b;
        private List<Bundle> c = new ArrayList();
        private RemoteViews d;
        private RemoteViews e;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            this.a = new Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & Allocation.USAGE_SHARED) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            this.b = new Bundle();
            if (bundle != null) {
                this.b.putAll(bundle);
            }
            if (z3) {
                this.b.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.b.putString("android.support.groupKey", str);
                if (z4) {
                    this.b.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.b.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.b.putString("android.support.sortKey", str2);
            }
            this.d = remoteViews2;
            this.e = remoteViews3;
        }

        @Override // defpackage.bp
        public void a(bw.a aVar) {
            this.c.add(bx.a(this.a, aVar));
        }

        @Override // defpackage.bq
        public Notification a() {
            Notification notificationBuild = this.a.build();
            Bundle bundleA = bx.a(notificationBuild);
            Bundle bundle = new Bundle(this.b);
            for (String str : this.b.keySet()) {
                if (bundleA.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            bundleA.putAll(bundle);
            SparseArray<Bundle> sparseArrayA = bx.a(this.c);
            if (sparseArrayA != null) {
                bx.a(notificationBuild).putSparseParcelableArray("android.support.actionExtras", sparseArrayA);
            }
            if (this.d != null) {
                notificationBuild.contentView = this.d;
            }
            if (this.e != null) {
                notificationBuild.bigContentView = this.e;
            }
            return notificationBuild;
        }
    }

    public static SparseArray<Bundle> a(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle a(Notification notification) {
        synchronized (a) {
            if (c) {
                return null;
            }
            try {
                if (b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    b = declaredField;
                }
                Bundle bundle = (Bundle) b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                c = true;
                return null;
            }
        }
    }

    public static Bundle a(Notification.Builder builder, bw.a aVar) {
        builder.addAction(aVar.a(), aVar.b(), aVar.c());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.i() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", cd.a(aVar.i()));
        }
        if (aVar.h() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", cd.a(aVar.h()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e());
        return bundle;
    }
}
