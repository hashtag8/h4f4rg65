package defpackage;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ku {
    private static final c a;

    interface c {
        void a(View view, CharSequence charSequence);
    }

    static class b implements c {
        private b() {
        }

        @Override // ku.c
        public void a(View view, CharSequence charSequence) {
            kv.a(view, charSequence);
        }
    }

    @TargetApi(26)
    static class a implements c {
        private a() {
        }

        @Override // ku.c
        public void a(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            a = new a();
        } else {
            a = new b();
        }
    }

    public static void a(View view, CharSequence charSequence) {
        a.a(view, charSequence);
    }
}
