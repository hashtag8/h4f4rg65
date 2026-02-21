package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class vp {

    public static final class a {
        private final List<String> a;
        private final Object b;

        private a(Object obj) {
            this.b = vq.a(obj);
            this.a = new ArrayList();
        }

        public a a(String str, Object obj) {
            this.a.add(((String) vq.a(str)) + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder sbAppend = new StringBuilder(100).append(this.b.getClass().getSimpleName()).append('{');
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                sbAppend.append(this.a.get(i));
                if (i < size - 1) {
                    sbAppend.append(", ");
                }
            }
            return sbAppend.append('}').toString();
        }
    }

    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a a(Object obj) {
        return new a(obj);
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
