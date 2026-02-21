package defpackage;

import android.database.Cursor;
import android.os.Handler;
import defpackage.afq;

/* JADX INFO: loaded from: classes.dex */
public class afp<T extends afq> extends afq {
    private final Handler a;
    private final T b;

    public afp(Handler handler, T t) {
        this.a = handler;
        this.b = t;
    }

    private void a(final Runnable runnable) {
        Runnable runnable2 = new Runnable() { // from class: afp.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    new ml().a("MusicUICallback error", th);
                }
            }
        };
        if (this.a == null) {
            runnable2.run();
        } else {
            this.a.post(runnable2);
        }
    }

    @Override // defpackage.afq
    public void a(final Cursor cursor) {
        a(new Runnable() { // from class: afp.2
            @Override // java.lang.Runnable
            public void run() {
                afp.this.b.a(cursor);
            }
        });
    }

    @Override // defpackage.afq
    public void b(final Cursor cursor) {
        a(new Runnable() { // from class: afp.3
            @Override // java.lang.Runnable
            public void run() {
                afp.this.b.b(cursor);
            }
        });
    }

    @Override // defpackage.afq
    public void c(final Cursor cursor) {
        a(new Runnable() { // from class: afp.4
            @Override // java.lang.Runnable
            public void run() {
                afp.this.b.c(cursor);
            }
        });
    }

    @Override // defpackage.afq
    public void d(final Cursor cursor) {
        a(new Runnable() { // from class: afp.5
            @Override // java.lang.Runnable
            public void run() {
                afp.this.b.d(cursor);
            }
        });
    }

    @Override // defpackage.afq
    public void e(final Cursor cursor) {
        a(new Runnable() { // from class: afp.6
            @Override // java.lang.Runnable
            public void run() {
                afp.this.b.e(cursor);
            }
        });
    }
}
