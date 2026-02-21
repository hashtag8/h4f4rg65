package defpackage;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
class my {
    final Context a;
    final bob b;

    public my(Context context, bob bobVar) {
        this.a = context;
        this.b = bobVar;
    }

    public nq a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
        }
        return new nq(this.a, new nw(), new bmp(), new bnp(this.a, this.b.a(), "session_analytics.tap", "session_analytics_to_send"));
    }
}
