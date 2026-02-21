package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v8.renderscript.Allocation;
import android.widget.RemoteViews;
import defpackage.bw;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class bs {

    public static class a implements bp, bq {
        private Notification.Builder a;
        private Bundle b;
        private RemoteViews c;
        private RemoteViews d;
        private int e;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3, int i5) {
            this.a = new Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & Allocation.USAGE_SHARED) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str).setGroupSummary(z5).setSortKey(str2);
            this.b = new Bundle();
            if (bundle != null) {
                this.b.putAll(bundle);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                this.b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            this.c = remoteViews2;
            this.d = remoteViews3;
            this.e = i5;
        }

        @Override // defpackage.bp
        public void a(bw.a aVar) {
            bs.a(this.a, aVar);
        }

        @Override // defpackage.bq
        public Notification a() {
            this.a.setExtras(this.b);
            Notification notificationBuild = this.a.build();
            if (this.c != null) {
                notificationBuild.contentView = this.c;
            }
            if (this.d != null) {
                notificationBuild.bigContentView = this.d;
            }
            if (this.e != 0) {
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) != 0 && this.e == 2) {
                    a(notificationBuild);
                }
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) == 0 && this.e == 1) {
                    a(notificationBuild);
                }
            }
            return notificationBuild;
        }

        private void a(Notification notification) {
            notification.sound = null;
            notification.vibrate = null;
            notification.defaults &= -2;
            notification.defaults &= -3;
        }
    }

    public static void a(Notification.Builder builder, bw.a aVar) {
        Bundle bundle;
        Notification.Action.Builder builder2 = new Notification.Action.Builder(aVar.a(), aVar.b(), aVar.c());
        if (aVar.i() != null) {
            for (RemoteInput remoteInput : cb.a(aVar.i())) {
                builder2.addRemoteInput(remoteInput);
            }
        }
        if (aVar.d() != null) {
            bundle = new Bundle(aVar.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e());
        builder2.addExtras(bundle);
        builder.addAction(builder2.build());
    }
}
