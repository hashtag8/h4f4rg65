package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v8.renderscript.Allocation;
import android.widget.RemoteViews;
import defpackage.bs;
import defpackage.bt;
import defpackage.bu;
import defpackage.bv;
import defpackage.bw;
import defpackage.bx;
import defpackage.by;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class br {
    static final k a;

    interface k {
        Notification a(b bVar, c cVar);
    }

    public static class c {
        protected c() {
        }

        public Notification a(b bVar, bq bqVar) {
            RemoteViews remoteViewsD;
            RemoteViews remoteViewsC;
            RemoteViews remoteViewsB = bVar.m != null ? bVar.m.b(bqVar) : null;
            Notification notificationA = bqVar.a();
            if (remoteViewsB != null) {
                notificationA.contentView = remoteViewsB;
            } else if (bVar.E != null) {
                notificationA.contentView = bVar.E;
            }
            if (Build.VERSION.SDK_INT >= 16 && bVar.m != null && (remoteViewsC = bVar.m.c(bqVar)) != null) {
                notificationA.bigContentView = remoteViewsC;
            }
            if (Build.VERSION.SDK_INT >= 21 && bVar.m != null && (remoteViewsD = bVar.m.d(bqVar)) != null) {
                notificationA.headsUpContentView = remoteViewsD;
            }
            return notificationA;
        }
    }

    static class j implements k {
        j() {
        }

        public static class a implements bq {
            private Notification.Builder a;

            a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z) {
                this.a = new Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & Allocation.USAGE_SHARED) != 0).setLargeIcon(bitmap).setNumber(i).setProgress(i2, i3, z);
            }

            @Override // defpackage.bq
            public Notification a() {
                return this.a.getNotification();
            }
        }

        @Override // br.k
        public Notification a(b bVar, c cVar) {
            return cVar.a(bVar, new a(bVar.a, bVar.L, bVar.b, bVar.c, bVar.h, bVar.f, bVar.i, bVar.d, bVar.e, bVar.g, bVar.p, bVar.q, bVar.r));
        }
    }

    static class d extends j {
        d() {
        }

        @Override // br.j, br.k
        public Notification a(b bVar, c cVar) {
            Bundle bundleA;
            bx.a aVar = new bx.a(bVar.a, bVar.L, bVar.b, bVar.c, bVar.h, bVar.f, bVar.i, bVar.d, bVar.e, bVar.g, bVar.p, bVar.q, bVar.r, bVar.l, bVar.j, bVar.n, bVar.w, bVar.A, bVar.s, bVar.t, bVar.u, bVar.E, bVar.F);
            br.a(aVar, bVar.v);
            if (bVar.m != null) {
                bVar.m.a(aVar);
            }
            Notification notificationA = cVar.a(bVar, aVar);
            if (bVar.m != null && (bundleA = br.a(notificationA)) != null) {
                bVar.m.a(bundleA);
            }
            return notificationA;
        }
    }

    static class e extends d {
        e() {
        }

        @Override // br.d, br.j, br.k
        public Notification a(b bVar, c cVar) {
            by.a aVar = new by.a(bVar.a, bVar.L, bVar.b, bVar.c, bVar.h, bVar.f, bVar.i, bVar.d, bVar.e, bVar.g, bVar.p, bVar.q, bVar.r, bVar.k, bVar.l, bVar.j, bVar.n, bVar.w, bVar.M, bVar.A, bVar.s, bVar.t, bVar.u, bVar.E, bVar.F);
            br.a(aVar, bVar.v);
            if (bVar.m != null) {
                bVar.m.a(aVar);
            }
            return cVar.a(bVar, aVar);
        }
    }

    static class f extends e {
        f() {
        }

        @Override // br.e, br.d, br.j, br.k
        public Notification a(b bVar, c cVar) {
            bs.a aVar = new bs.a(bVar.a, bVar.L, bVar.b, bVar.c, bVar.h, bVar.f, bVar.i, bVar.d, bVar.e, bVar.g, bVar.p, bVar.q, bVar.r, bVar.k, bVar.l, bVar.j, bVar.n, bVar.w, bVar.M, bVar.A, bVar.s, bVar.t, bVar.u, bVar.E, bVar.F, bVar.N);
            br.a(aVar, bVar.v);
            if (bVar.m != null) {
                bVar.m.a(aVar);
            }
            Notification notificationA = cVar.a(bVar, aVar);
            if (bVar.m != null) {
                bVar.m.a(br.a(notificationA));
            }
            return notificationA;
        }
    }

    static class g extends f {
        g() {
        }

        @Override // br.f, br.e, br.d, br.j, br.k
        public Notification a(b bVar, c cVar) {
            bt.a aVar = new bt.a(bVar.a, bVar.L, bVar.b, bVar.c, bVar.h, bVar.f, bVar.i, bVar.d, bVar.e, bVar.g, bVar.p, bVar.q, bVar.r, bVar.k, bVar.l, bVar.j, bVar.n, bVar.w, bVar.z, bVar.M, bVar.A, bVar.B, bVar.C, bVar.D, bVar.s, bVar.t, bVar.u, bVar.E, bVar.F, bVar.G, bVar.N);
            br.a(aVar, bVar.v);
            if (bVar.m != null) {
                bVar.m.a(aVar);
            }
            Notification notificationA = cVar.a(bVar, aVar);
            if (bVar.m != null) {
                bVar.m.a(br.a(notificationA));
            }
            return notificationA;
        }
    }

    static class h extends g {
        h() {
        }

        @Override // br.g, br.f, br.e, br.d, br.j, br.k
        public Notification a(b bVar, c cVar) {
            bu.a aVar = new bu.a(bVar.a, bVar.L, bVar.b, bVar.c, bVar.h, bVar.f, bVar.i, bVar.d, bVar.e, bVar.g, bVar.p, bVar.q, bVar.r, bVar.k, bVar.l, bVar.j, bVar.n, bVar.w, bVar.z, bVar.M, bVar.A, bVar.B, bVar.C, bVar.D, bVar.s, bVar.t, bVar.u, bVar.o, bVar.E, bVar.F, bVar.G, bVar.N);
            br.a(aVar, bVar.v);
            if (bVar.m != null) {
                bVar.m.a(aVar);
            }
            Notification notificationA = cVar.a(bVar, aVar);
            if (bVar.m != null) {
                bVar.m.a(br.a(notificationA));
            }
            return notificationA;
        }
    }

    static class i extends h {
        i() {
        }

        @Override // br.h, br.g, br.f, br.e, br.d, br.j, br.k
        public Notification a(b bVar, c cVar) {
            bv.a aVar = new bv.a(bVar.a, bVar.L, bVar.b, bVar.c, bVar.h, bVar.f, bVar.i, bVar.d, bVar.e, bVar.g, bVar.p, bVar.q, bVar.r, bVar.k, bVar.l, bVar.j, bVar.n, bVar.w, bVar.z, bVar.M, bVar.A, bVar.B, bVar.C, bVar.D, bVar.s, bVar.t, bVar.u, bVar.o, bVar.E, bVar.F, bVar.G, bVar.H, bVar.I, bVar.J, bVar.K, bVar.x, bVar.y, bVar.N);
            br.a(aVar, bVar.v);
            if (bVar.m != null) {
                bVar.m.a(aVar);
            }
            Notification notificationA = cVar.a(bVar, aVar);
            if (bVar.m != null) {
                bVar.m.a(br.a(notificationA));
            }
            return notificationA;
        }
    }

    static void a(bp bpVar, ArrayList<a> arrayList) {
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            bpVar.a(it.next());
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            a = new i();
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            a = new h();
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            a = new g();
            return;
        }
        if (Build.VERSION.SDK_INT >= 20) {
            a = new f();
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            a = new e();
        } else if (Build.VERSION.SDK_INT >= 16) {
            a = new d();
        } else {
            a = new j();
        }
    }

    public static class b {
        Bundle A;
        Notification D;
        RemoteViews E;
        RemoteViews F;
        RemoteViews G;
        String H;
        String J;
        long K;
        public ArrayList<String> M;
        public Context a;
        public CharSequence b;
        public CharSequence c;
        PendingIntent d;
        PendingIntent e;
        RemoteViews f;
        public Bitmap g;
        public CharSequence h;
        public int i;
        int j;
        public boolean l;
        public l m;
        public CharSequence n;
        public CharSequence[] o;
        int p;
        int q;
        boolean r;
        String s;
        boolean t;
        String u;
        boolean x;
        boolean y;
        String z;
        boolean k = true;
        public ArrayList<a> v = new ArrayList<>();
        boolean w = false;
        int B = 0;
        int C = 0;
        int I = 0;
        private int N = 0;
        public Notification L = new Notification();

        public b(Context context, String str) {
            this.a = context;
            this.H = str;
            this.L.when = System.currentTimeMillis();
            this.L.audioStreamType = -1;
            this.j = 0;
            this.M = new ArrayList<>();
        }

        public b a(long j) {
            this.L.when = j;
            return this;
        }

        public b a(int i) {
            this.L.icon = i;
            return this;
        }

        public b a(CharSequence charSequence) {
            this.b = c(charSequence);
            return this;
        }

        public b b(CharSequence charSequence) {
            this.c = c(charSequence);
            return this;
        }

        public b a(PendingIntent pendingIntent) {
            this.d = pendingIntent;
            return this;
        }

        public b a(boolean z) {
            a(16, z);
            return this;
        }

        private void a(int i, boolean z) {
            if (z) {
                this.L.flags |= i;
            } else {
                this.L.flags &= i ^ (-1);
            }
        }

        public b b(int i) {
            this.j = i;
            return this;
        }

        public b c(int i) {
            this.C = i;
            return this;
        }

        public b a(RemoteViews remoteViews) {
            this.E = remoteViews;
            return this;
        }

        public b b(RemoteViews remoteViews) {
            this.F = remoteViews;
            return this;
        }

        public Notification a() {
            return br.a.a(this, b());
        }

        protected c b() {
            return new c();
        }

        protected static CharSequence c(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }
    }

    public static abstract class l {
        public void a(bq bqVar) {
        }

        public RemoteViews b(bq bqVar) {
            return null;
        }

        public RemoteViews c(bq bqVar) {
            return null;
        }

        public RemoteViews d(bq bqVar) {
            return null;
        }

        public void a(Bundle bundle) {
        }
    }

    public static class a extends bw.a {
        public static final bw.a.InterfaceC0135a e = new bw.a.InterfaceC0135a() { // from class: br.a.1
        };
        final Bundle a;
        public int b;
        public CharSequence c;
        public PendingIntent d;
        private final ca[] f;
        private final ca[] g;
        private boolean h;

        @Override // bw.a
        public int a() {
            return this.b;
        }

        @Override // bw.a
        public CharSequence b() {
            return this.c;
        }

        @Override // bw.a
        public PendingIntent c() {
            return this.d;
        }

        @Override // bw.a
        public Bundle d() {
            return this.a;
        }

        @Override // bw.a
        public boolean e() {
            return this.h;
        }

        @Override // bw.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public ca[] i() {
            return this.f;
        }

        @Override // bw.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public ca[] h() {
            return this.g;
        }
    }

    public static Bundle a(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return bx.a(notification);
        }
        return null;
    }
}
