package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import defpackage.blf;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(14)
class nz extends ny {
    private final blf.b a = new blf.b() { // from class: nz.1
        @Override // blf.b
        public void a(Activity activity) {
            if (nz.this.a()) {
                nz.this.b.submit(new Runnable() { // from class: nz.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        nz.this.c();
                    }
                });
            }
        }
    };
    private final ExecutorService b;

    public nz(blf blfVar, ExecutorService executorService) {
        this.b = executorService;
        blfVar.a(this.a);
    }
}
