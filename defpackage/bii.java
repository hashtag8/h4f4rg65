package defpackage;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import defpackage.bif;

/* JADX INFO: loaded from: classes.dex */
abstract class bii extends bhm<b> {
    final RemoteViews m;
    final int n;
    private b o;

    abstract void n();

    bii(bif bifVar, bij bijVar, RemoteViews remoteViews, int i, int i2, int i3, int i4, Object obj, String str) {
        super(bifVar, null, bijVar, i3, i4, i2, null, str, obj, false);
        this.m = remoteViews;
        this.n = i;
    }

    @Override // defpackage.bhm
    void a(Bitmap bitmap, bif.d dVar) {
        this.m.setImageViewBitmap(this.n, bitmap);
        n();
    }

    @Override // defpackage.bhm
    public void a() {
        if (this.g != 0) {
            a(this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.bhm
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public b d() {
        if (this.o == null) {
            this.o = new b(this.m, this.n);
        }
        return this.o;
    }

    void a(int i) {
        this.m.setImageViewResource(this.n, i);
        n();
    }

    static class b {
        final RemoteViews a;
        final int b;

        b(RemoteViews remoteViews, int i) {
            this.a = remoteViews;
            this.b = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && this.a.equals(bVar.a);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }
    }

    static class a extends bii {
        private final int o;
        private final Notification p;

        @Override // defpackage.bii, defpackage.bhm
        /* synthetic */ b d() {
            return super.d();
        }

        a(bif bifVar, bij bijVar, RemoteViews remoteViews, int i, int i2, Notification notification, int i3, int i4, String str, Object obj, int i5) {
            super(bifVar, bijVar, remoteViews, i, i5, i3, i4, obj, str);
            this.o = i2;
            this.p = notification;
        }

        @Override // defpackage.bii
        void n() {
            ((NotificationManager) bit.a(this.a.c, "notification")).notify(this.o, this.p);
        }
    }
}
