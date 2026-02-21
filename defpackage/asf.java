package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.help.WelcomeActivity;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.NoRoomActivity;

/* JADX INFO: loaded from: classes.dex */
public class asf extends ase {
    private final ba a;
    private final ard b;
    private ImageView c;
    private DashboardActivity.a d;

    public asf(ba baVar, DashboardActivity.a aVar) {
        super(baVar, R.style.Dialog_Fullscreen);
        this.d = aVar;
        this.b = new ard(baVar, false);
        this.a = baVar;
        a();
    }

    private void a() {
        View viewInflate = this.a.getLayoutInflater().inflate(R.layout.splash_screen, (ViewGroup) null);
        a(viewInflate);
        setContentView(viewInflate);
        this.c = (ImageView) findViewById(R.id.splash_logo_iv);
    }

    @Override // defpackage.ase, android.app.Dialog
    public void onStart() {
        super.onStart();
        mo.a.post(new Runnable() { // from class: asf.1
            @Override // java.lang.Runnable
            public void run() {
                asf.this.b.a();
            }
        });
        mo.a.postDelayed(new Runnable() { // from class: asf.4
            @Override // java.lang.Runnable
            public void run() {
                asf.this.b();
            }
        }, 1400L);
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        this.b.b();
    }

    @Override // defpackage.ase, android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        this.a.finish();
    }

    @Override // defpackage.ase, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.b.c()) {
            this.b.a(new Runnable() { // from class: asf.5
                @Override // java.lang.Runnable
                public void run() {
                    asf.this.b.b(this);
                    asf.super.dismiss();
                }
            });
        } else {
            super.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (!this.a.isFinishing()) {
            if (this.b.c()) {
                this.b.a(new Runnable() { // from class: asf.6
                    @Override // java.lang.Runnable
                    public void run() {
                        mm.b("Dismissing now", new Object[0]);
                        asf.this.b.b(this);
                        asf.this.b();
                    }
                });
                return;
            }
            if (aim.b()) {
                d();
                return;
            }
            if (!aho.b("LEGAL_PERSIST", false)) {
                asn.a.a(this.a, new asm() { // from class: asf.7
                    @Override // defpackage.asm
                    public void a(int i) {
                        asf.this.b();
                    }
                });
            } else if (aof.a().d().isEmpty()) {
                e();
            } else {
                dismiss();
            }
        }
    }

    private void d() {
        mq.b().execute(new Runnable() { // from class: asf.8
            @Override // java.lang.Runnable
            public void run() {
                mm.a();
            }
        });
        this.a.startActivityForResult(new Intent(this.a, (Class<?>) WelcomeActivity.class), 1005);
    }

    private void e() {
        final arx arxVar = new arx(this.a);
        arxVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: asf.9
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                asf.this.hide();
            }
        });
        arxVar.a(new Runnable() { // from class: asf.10
            @Override // java.lang.Runnable
            public void run() {
                if (arxVar.c()) {
                    asf.this.a.finish();
                }
                if (!asf.this.a.isFinishing()) {
                    asf.this.f();
                } else {
                    asf.this.dismiss();
                }
            }
        });
        arxVar.show();
    }

    public void a(int i) {
        if (i == 1005 || i == 1006) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        boolean z = false;
        if (aof.a().d().isEmpty()) {
            if (this.b.c()) {
                this.b.a(new Runnable() { // from class: asf.11
                    @Override // java.lang.Runnable
                    public void run() {
                        asf.this.b.b(this);
                        asf.this.f();
                    }
                });
                return;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                this.a.startActivity(new Intent(this.a, (Class<?>) NoRoomActivity.class));
                if (isShowing()) {
                    dismiss();
                }
                this.a.finish();
            } else {
                final asa asaVar = new asa(this.a);
                asaVar.a(new Runnable() { // from class: asf.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (asaVar.c()) {
                            asf.this.a.finish();
                        }
                        asf.this.b();
                    }
                });
                asaVar.show();
            }
        } else {
            z = true;
        }
        mo.a.postDelayed(new Runnable() { // from class: asf.3
            @Override // java.lang.Runnable
            public void run() {
                asf.this.d.a();
            }
        }, 200L);
        if (z) {
            dismiss();
        }
    }
}
