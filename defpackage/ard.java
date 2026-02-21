package defpackage;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.harman.hkconnect.R;
import defpackage.arw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ard {
    private final ask a;
    private Activity b;
    private boolean d;
    private boolean e;
    private final arw h;
    private boolean c = false;
    private boolean f = true;
    private List<Runnable> g = Collections.synchronizedList(new LinkedList());

    public ard(Activity activity, boolean z) {
        this.d = false;
        this.e = false;
        this.b = activity;
        this.d = z;
        this.e = false;
        this.h = b(z);
        this.h.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ard.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                mm.b("Showing dialog", new Object[0]);
                ard.this.c = false;
            }
        });
        this.h.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ard.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                mm.b("dismissing dialog", new Object[0]);
                ard.this.c = true;
                Iterator it = new ArrayList(ard.this.g).iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
            }
        });
        this.a = new ask(activity, new asj() { // from class: ard.4
            @Override // defpackage.asj
            public void a(String str) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ard.this.d();
            }
        });
    }

    private arw b(boolean z) {
        if (z) {
            return new arw.a(this.b).b(this.b.getString(R.string.kSetupSearching_NoWifiConnection_Str)).a(this.b.getString(R.string.WifiNotReachableTip_Str)).a(this.b.getString(R.string.OK_Str), new DialogInterface.OnClickListener() { // from class: ard.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    new asd(dialogInterface).a();
                }
            }).d(true).a(false).b();
        }
        return new arw.a(this.b).b(this.b.getString(R.string.kSetupSearching_NoWifiConnection_Str)).a(this.b.getResources().getString(R.string.turnOnWifi)).a(this.b.getResources().getString(R.string.OK_Str), new DialogInterface.OnClickListener() { // from class: ard.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ard.this.e();
            }
        }).d(false).b(false).a(false).a(new DialogInterface.OnCancelListener() { // from class: ard.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                ard.this.b.finish();
            }
        }).b();
    }

    public void a() {
        this.a.a();
    }

    public void b() {
        this.a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (ahh.b(this.b)) {
            if (ahh.a(this.b)) {
                this.e = false;
                new asd(this.h).a();
                return;
            }
            if (!this.e) {
                h();
                if (!this.h.isShowing()) {
                    if (!this.d || (!this.c && this.f)) {
                        new asc(this.h).a(null);
                        return;
                    } else {
                        mm.b("Not showing noWifiDialog because cancelled %s and enabled %s", Boolean.valueOf(this.c), Boolean.valueOf(this.f));
                        return;
                    }
                }
                return;
            }
            return;
        }
        f();
        if (!this.h.isShowing()) {
            new asc(this.h).a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ahh.c(this.b);
        g();
        this.e = true;
        mo.a.postDelayed(new Runnable() { // from class: ard.8
            @Override // java.lang.Runnable
            public void run() {
                ard.this.e = false;
                ard.this.d();
            }
        }, 10000L);
    }

    private void f() {
        this.h.a(this.b.getResources().getString(R.string.turnOnWifi));
        this.h.b(this.b.getResources().getString(R.string.OK_Str));
        this.h.a(new View.OnClickListener() { // from class: ard.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ard.this.e();
            }
        });
    }

    private void g() {
        this.h.b(this.b.getResources().getString(R.string.enablingWifi));
        this.h.a((View.OnClickListener) null);
    }

    private void h() {
        this.h.a(this.b.getResources().getString(R.string.Splash_No_Wifi));
        this.h.b(this.b.getResources().getString(R.string.Open_Wifi_Settings_Str));
        this.h.a(new View.OnClickListener() { // from class: ard.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent("android.settings.WIFI_SETTINGS");
                intent.setFlags(268435456);
                ard.this.b.startActivity(intent);
            }
        });
    }

    public void a(Runnable runnable) {
        this.g.add(runnable);
    }

    public void b(Runnable runnable) {
        this.g.remove(runnable);
    }

    public void a(boolean z) {
        this.f = z;
        if (z) {
            d();
        }
    }

    public boolean c() {
        return this.h.isShowing();
    }
}
