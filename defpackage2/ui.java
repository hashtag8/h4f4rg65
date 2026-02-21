package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import defpackage.tr;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class ui extends ud {
    private final a a;
    private tr b;
    private final ut c;
    private ty d;

    public class a implements ServiceConnection {
        private volatile tr b;
        private volatile boolean c;

        protected a() {
        }

        public tr a() {
            tr trVar = null;
            ui.this.m();
            Intent intent = new Intent("com.google.android.gms.analytics.service.START");
            intent.setComponent(new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.analytics.service.AnalyticsService"));
            Context contextO = ui.this.o();
            intent.putExtra("app_package_name", contextO.getPackageName());
            vs vsVarA = vs.a();
            synchronized (this) {
                this.b = null;
                this.c = true;
                boolean zA = vsVarA.a(contextO, intent, ui.this.a, 129);
                ui.this.a("Bind to service requested", Boolean.valueOf(zA));
                if (zA) {
                    try {
                        wait(ui.this.q().w());
                    } catch (InterruptedException e) {
                        ui.this.e("Wait for service connect was interrupted");
                    }
                    this.c = false;
                    trVar = this.b;
                    this.b = null;
                    if (trVar == null) {
                        ui.this.f("Successfully bound to service but never got onServiceConnected callback");
                    }
                } else {
                    this.c = false;
                }
            }
            return trVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            vq.b("AnalyticsServiceConnection.onServiceConnected");
            synchronized (this) {
                try {
                    if (iBinder == null) {
                        ui.this.f("Service connected with null binder");
                        return;
                    }
                    final tr trVarA = null;
                    try {
                        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                        if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(interfaceDescriptor)) {
                            trVarA = tr.a.a(iBinder);
                            ui.this.b("Bound to IAnalyticsService interface");
                        } else {
                            ui.this.e("Got binder with a wrong descriptor", interfaceDescriptor);
                        }
                    } catch (RemoteException e) {
                        ui.this.f("Service connect failed to get IAnalyticsService");
                    }
                    if (trVarA == null) {
                        try {
                            vs.a().a(ui.this.o(), ui.this.a);
                        } catch (IllegalArgumentException e2) {
                        }
                    } else if (this.c) {
                        this.b = trVarA;
                    } else {
                        ui.this.e("onServiceConnected received after the timeout limit");
                        ui.this.r().a(new Runnable() { // from class: ui.a.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ui.this.b()) {
                                    return;
                                }
                                ui.this.c("Connected to service after a timeout");
                                ui.this.a(trVarA);
                            }
                        });
                    }
                } finally {
                    notifyAll();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(final ComponentName componentName) {
            vq.b("AnalyticsServiceConnection.onServiceDisconnected");
            ui.this.r().a(new Runnable() { // from class: ui.a.2
                @Override // java.lang.Runnable
                public void run() {
                    ui.this.a(componentName);
                }
            });
        }
    }

    protected ui(uf ufVar) {
        super(ufVar);
        this.d = new ty(ufVar.d());
        this.a = new a();
        this.c = new ut(ufVar) { // from class: ui.1
            @Override // defpackage.ut
            public void a() {
                ui.this.f();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ComponentName componentName) {
        m();
        if (this.b != null) {
            this.b = null;
            a("Disconnected from device AnalyticsService", componentName);
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(tr trVar) {
        m();
        this.b = trVar;
        e();
        t().f();
    }

    private void e() {
        this.d.a();
        this.c.a(q().v());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        m();
        if (b()) {
            b("Inactivity, disconnecting from device AnalyticsService");
            d();
        }
    }

    private void g() {
        t().d();
    }

    @Override // defpackage.ud
    protected void a() {
    }

    public boolean a(tq tqVar) {
        vq.a(tqVar);
        m();
        D();
        tr trVar = this.b;
        if (trVar == null) {
            return false;
        }
        try {
            trVar.a(tqVar.b(), tqVar.d(), tqVar.f() ? q().o() : q().p(), Collections.emptyList());
            e();
            return true;
        } catch (RemoteException e) {
            b("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    public boolean b() {
        m();
        D();
        return this.b != null;
    }

    public boolean c() {
        m();
        D();
        if (this.b != null) {
            return true;
        }
        tr trVarA = this.a.a();
        if (trVarA == null) {
            return false;
        }
        this.b = trVarA;
        e();
        return true;
    }

    public void d() {
        m();
        D();
        try {
            vs.a().a(o(), this.a);
        } catch (IllegalArgumentException e) {
        } catch (IllegalStateException e2) {
        }
        if (this.b != null) {
            this.b = null;
            g();
        }
    }
}
