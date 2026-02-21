package defpackage;

import android.os.Build;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ec {
    private static final b a;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            a = new a();
        } else {
            a = new b();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return a.a(obj, obj2);
    }

    static class b {
        private b() {
        }

        public boolean a(Object obj, Object obj2) {
            return obj == obj2 || (obj != null && obj.equals(obj2));
        }
    }

    static class a extends b {
        private a() {
            super();
        }

        @Override // ec.b
        public boolean a(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }
    }
}
