package defpackage;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
public class asd {
    private final DialogInterface a;

    public asd(DialogInterface dialogInterface) {
        this.a = dialogInterface;
    }

    public void a() {
        mo.a.a(new Runnable() { // from class: asd.1
            @Override // java.lang.Runnable
            public void run() {
                asd.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            this.a.dismiss();
        } catch (RuntimeException e) {
            mm.b("Suppressing error on dismiss, has the activity finished?", e);
        }
    }
}
