package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v8.renderscript.Allocation;
import android.widget.RemoteViews;
import defpackage.bw;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class bt {

    public static class a implements bp, bq {
        private Notification.Builder a;
        private Bundle b;
        private RemoteViews c;
        private RemoteViews d;
        private RemoteViews e;
        private int f;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i5, int i6, Notification notification2, String str2, boolean z5, String str3, RemoteViews remoteViews2, RemoteViews remoteViews3, RemoteViews remoteViews4, int i7) {
            this.a = new Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & Allocation.USAGE_SHARED) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2);
            this.b = new Bundle();
            if (bundle != null) {
                this.b.putAll(bundle);
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.a.addPerson(it.next());
            }
            this.c = remoteViews2;
            this.d = remoteViews3;
            this.e = remoteViews4;
            this.f = i7;
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
            if (this.e != null) {
                notificationBuild.headsUpContentView = this.e;
            }
            if (this.f != 0) {
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) != 0 && this.f == 2) {
                    a(notificationBuild);
                }
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) == 0 && this.f == 1) {
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
}
