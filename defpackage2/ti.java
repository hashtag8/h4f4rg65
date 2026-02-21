package defpackage;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ti {

    public static class a extends b<a> {
        public a() {
            a("&t", "event");
        }

        @Override // ti.b
        public /* bridge */ /* synthetic */ Map a() {
            return super.a();
        }

        public a a(long j) {
            a("&ev", Long.toString(j));
            return this;
        }

        public a a(String str) {
            a("&ec", str);
            return this;
        }

        public a b(String str) {
            a("&ea", str);
            return this;
        }

        public a c(String str) {
            a("&el", str);
            return this;
        }
    }

    public static class b<T extends b> {
        tm a;
        private Map<String, String> e = new HashMap();
        Map<String, List<tl>> b = new HashMap();
        List<tn> c = new ArrayList();
        List<tl> d = new ArrayList();

        protected b() {
        }

        public Map<String, String> a() {
            HashMap map = new HashMap(this.e);
            if (this.a != null) {
                map.putAll(this.a.a());
            }
            Iterator<tn> it = this.c.iterator();
            int i = 1;
            while (it.hasNext()) {
                map.putAll(it.next().a(vc.g(i)));
                i++;
            }
            Iterator<tl> it2 = this.d.iterator();
            int i2 = 1;
            while (it2.hasNext()) {
                map.putAll(it2.next().a(vc.e(i2)));
                i2++;
            }
            int i3 = 1;
            for (Map.Entry<String, List<tl>> entry : this.b.entrySet()) {
                List<tl> value = entry.getValue();
                String strJ = vc.j(i3);
                Iterator<tl> it3 = value.iterator();
                int i4 = 1;
                while (it3.hasNext()) {
                    map.putAll(it3.next().a(strJ + vc.i(i4)));
                    i4++;
                }
                if (!TextUtils.isEmpty(entry.getKey())) {
                    map.put(strJ + "nm", entry.getKey());
                }
                i3++;
            }
            return map;
        }

        public T a(int i, float f) {
            a(vc.c(i), Float.toString(f));
            return this;
        }

        public T a(int i, String str) {
            a(vc.a(i), str);
            return this;
        }

        public final T a(String str, String str2) {
            if (str != null) {
                this.e.put(str, str2);
            } else {
                tt.a(" HitBuilder.set() called with a null paramName.");
            }
            return this;
        }
    }

    public static class c extends b<c> {
        public c() {
            a("&t", "screenview");
        }

        @Override // ti.b
        public /* bridge */ /* synthetic */ Map a() {
            return super.a();
        }
    }
}
