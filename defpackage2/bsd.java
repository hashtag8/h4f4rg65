package defpackage;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class bsd implements Serializable {
    public static final bsd a = new a();
    public static final bsd b = new b();
    public static final bsd c = new c();
    public static final bsd d = new d();
    public static final bsd e = new e();
    private static final ThreadLocal<WeakHashMap<Object, Object>> f = new ThreadLocal<>();
    private boolean g = true;
    private boolean h = true;
    private boolean i = false;
    private boolean j = true;
    private String k = "[";
    private String l = "]";
    private String m = "=";
    private boolean n = false;
    private boolean o = false;
    private String p = ",";
    private String q = "{";
    private String r = ",";
    private boolean s = true;
    private String t = "}";
    private boolean u = true;
    private String v = "<null>";
    private String w = "<size=";
    private String x = ">";
    private String y = "<";
    private String z = ">";

    static Map<Object, Object> c() {
        return f.get();
    }

    static boolean a(Object obj) {
        Map<Object, Object> mapC = c();
        return mapC != null && mapC.containsKey(obj);
    }

    static void b(Object obj) {
        if (obj != null) {
            if (c() == null) {
                f.set(new WeakHashMap<>());
            }
            c().put(obj, null);
        }
    }

    static void c(Object obj) {
        Map<Object, Object> mapC;
        if (obj != null && (mapC = c()) != null) {
            mapC.remove(obj);
            if (mapC.isEmpty()) {
                f.remove();
            }
        }
    }

    protected bsd() {
    }

    public void a(StringBuffer stringBuffer, Object obj) {
        if (obj != null) {
            c(stringBuffer, obj);
            d(stringBuffer, obj);
            b(stringBuffer);
            if (this.n) {
                d(stringBuffer);
            }
        }
    }

    public void b(StringBuffer stringBuffer, Object obj) {
        if (!this.o) {
            a(stringBuffer);
        }
        c(stringBuffer);
        c(obj);
    }

    protected void a(StringBuffer stringBuffer) {
        boolean z = false;
        int length = stringBuffer.length();
        int length2 = this.p.length();
        if (length > 0 && length2 > 0 && length >= length2) {
            int i = 0;
            while (true) {
                if (i >= length2) {
                    z = true;
                    break;
                } else if (stringBuffer.charAt((length - 1) - i) != this.p.charAt((length2 - 1) - i)) {
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                stringBuffer.setLength(length - length2);
            }
        }
    }

    public void a(StringBuffer stringBuffer, String str, Object obj, Boolean bool) {
        b(stringBuffer, str);
        if (obj == null) {
            a(stringBuffer, str);
        } else {
            a(stringBuffer, str, obj, a(bool));
        }
        c(stringBuffer, str);
    }

    protected void a(StringBuffer stringBuffer, String str, Object obj, boolean z) {
        if (a(obj) && !(obj instanceof Number) && !(obj instanceof Boolean) && !(obj instanceof Character)) {
            a(stringBuffer, str, obj);
            return;
        }
        b(obj);
        try {
            if (obj instanceof Collection) {
                if (z) {
                    a(stringBuffer, str, (Collection<?>) obj);
                } else {
                    c(stringBuffer, str, ((Collection) obj).size());
                }
            } else if (obj instanceof Map) {
                if (z) {
                    a(stringBuffer, str, (Map<?, ?>) obj);
                } else {
                    c(stringBuffer, str, ((Map) obj).size());
                }
            } else if (obj instanceof long[]) {
                if (z) {
                    a(stringBuffer, str, (long[]) obj);
                } else {
                    b(stringBuffer, str, (long[]) obj);
                }
            } else if (obj instanceof int[]) {
                if (z) {
                    a(stringBuffer, str, (int[]) obj);
                } else {
                    b(stringBuffer, str, (int[]) obj);
                }
            } else if (obj instanceof short[]) {
                if (z) {
                    a(stringBuffer, str, (short[]) obj);
                } else {
                    b(stringBuffer, str, (short[]) obj);
                }
            } else if (obj instanceof byte[]) {
                if (z) {
                    a(stringBuffer, str, (byte[]) obj);
                } else {
                    b(stringBuffer, str, (byte[]) obj);
                }
            } else if (obj instanceof char[]) {
                if (z) {
                    a(stringBuffer, str, (char[]) obj);
                } else {
                    b(stringBuffer, str, (char[]) obj);
                }
            } else if (obj instanceof double[]) {
                if (z) {
                    a(stringBuffer, str, (double[]) obj);
                } else {
                    b(stringBuffer, str, (double[]) obj);
                }
            } else if (obj instanceof float[]) {
                if (z) {
                    a(stringBuffer, str, (float[]) obj);
                } else {
                    b(stringBuffer, str, (float[]) obj);
                }
            } else if (obj instanceof boolean[]) {
                if (z) {
                    a(stringBuffer, str, (boolean[]) obj);
                } else {
                    b(stringBuffer, str, (boolean[]) obj);
                }
            } else if (obj.getClass().isArray()) {
                if (z) {
                    a(stringBuffer, str, (Object[]) obj);
                } else {
                    b(stringBuffer, str, (Object[]) obj);
                }
            } else if (z) {
                b(stringBuffer, str, obj);
            } else {
                c(stringBuffer, str, obj);
            }
        } finally {
            c(obj);
        }
    }

    protected void a(StringBuffer stringBuffer, String str, Object obj) {
        brs.a(stringBuffer, obj);
    }

    protected void b(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(obj);
    }

    protected void a(StringBuffer stringBuffer, String str, Collection<?> collection) {
        stringBuffer.append(collection);
    }

    protected void a(StringBuffer stringBuffer, String str, Map<?, ?> map) {
        stringBuffer.append(map);
    }

    protected void c(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.y);
        stringBuffer.append(a(obj.getClass()));
        stringBuffer.append(this.z);
    }

    public void a(StringBuffer stringBuffer, String str, long j) {
        b(stringBuffer, str);
        b(stringBuffer, str, j);
        c(stringBuffer, str);
    }

    protected void b(StringBuffer stringBuffer, String str, long j) {
        stringBuffer.append(j);
    }

    public void a(StringBuffer stringBuffer, String str, int i) {
        b(stringBuffer, str);
        b(stringBuffer, str, i);
        c(stringBuffer, str);
    }

    protected void b(StringBuffer stringBuffer, String str, int i) {
        stringBuffer.append(i);
    }

    public void a(StringBuffer stringBuffer, String str, short s) {
        b(stringBuffer, str);
        b(stringBuffer, str, s);
        c(stringBuffer, str);
    }

    protected void b(StringBuffer stringBuffer, String str, short s) {
        stringBuffer.append((int) s);
    }

    public void a(StringBuffer stringBuffer, String str, byte b2) {
        b(stringBuffer, str);
        b(stringBuffer, str, b2);
        c(stringBuffer, str);
    }

    protected void b(StringBuffer stringBuffer, String str, byte b2) {
        stringBuffer.append((int) b2);
    }

    protected void a(StringBuffer stringBuffer, String str, char c2) {
        stringBuffer.append(c2);
    }

    protected void a(StringBuffer stringBuffer, String str, double d2) {
        stringBuffer.append(d2);
    }

    protected void a(StringBuffer stringBuffer, String str, float f2) {
        stringBuffer.append(f2);
    }

    public void a(StringBuffer stringBuffer, String str, boolean z) {
        b(stringBuffer, str);
        b(stringBuffer, str, z);
        c(stringBuffer, str);
    }

    protected void b(StringBuffer stringBuffer, String str, boolean z) {
        stringBuffer.append(z);
    }

    protected void a(StringBuffer stringBuffer, String str, Object[] objArr) {
        stringBuffer.append(this.q);
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (i > 0) {
                stringBuffer.append(this.r);
            }
            if (obj == null) {
                a(stringBuffer, str);
            } else {
                a(stringBuffer, str, obj, this.s);
            }
        }
        stringBuffer.append(this.t);
    }

    protected void d(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.q);
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (i > 0) {
                stringBuffer.append(this.r);
            }
            if (obj2 == null) {
                a(stringBuffer, str);
            } else {
                a(stringBuffer, str, obj2, this.s);
            }
        }
        stringBuffer.append(this.t);
    }

    protected void b(StringBuffer stringBuffer, String str, Object[] objArr) {
        c(stringBuffer, str, objArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, long[] jArr) {
        stringBuffer.append(this.q);
        for (int i = 0; i < jArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.r);
            }
            b(stringBuffer, str, jArr[i]);
        }
        stringBuffer.append(this.t);
    }

    protected void b(StringBuffer stringBuffer, String str, long[] jArr) {
        c(stringBuffer, str, jArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, int[] iArr) {
        stringBuffer.append(this.q);
        for (int i = 0; i < iArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.r);
            }
            b(stringBuffer, str, iArr[i]);
        }
        stringBuffer.append(this.t);
    }

    protected void b(StringBuffer stringBuffer, String str, int[] iArr) {
        c(stringBuffer, str, iArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, short[] sArr) {
        stringBuffer.append(this.q);
        for (int i = 0; i < sArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.r);
            }
            b(stringBuffer, str, sArr[i]);
        }
        stringBuffer.append(this.t);
    }

    protected void b(StringBuffer stringBuffer, String str, short[] sArr) {
        c(stringBuffer, str, sArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, byte[] bArr) {
        stringBuffer.append(this.q);
        for (int i = 0; i < bArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.r);
            }
            b(stringBuffer, str, bArr[i]);
        }
        stringBuffer.append(this.t);
    }

    protected void b(StringBuffer stringBuffer, String str, byte[] bArr) {
        c(stringBuffer, str, bArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, char[] cArr) {
        stringBuffer.append(this.q);
        for (int i = 0; i < cArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.r);
            }
            a(stringBuffer, str, cArr[i]);
        }
        stringBuffer.append(this.t);
    }

    protected void b(StringBuffer stringBuffer, String str, char[] cArr) {
        c(stringBuffer, str, cArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, double[] dArr) {
        stringBuffer.append(this.q);
        for (int i = 0; i < dArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.r);
            }
            a(stringBuffer, str, dArr[i]);
        }
        stringBuffer.append(this.t);
    }

    protected void b(StringBuffer stringBuffer, String str, double[] dArr) {
        c(stringBuffer, str, dArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, float[] fArr) {
        stringBuffer.append(this.q);
        for (int i = 0; i < fArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.r);
            }
            a(stringBuffer, str, fArr[i]);
        }
        stringBuffer.append(this.t);
    }

    protected void b(StringBuffer stringBuffer, String str, float[] fArr) {
        c(stringBuffer, str, fArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, boolean[] zArr) {
        stringBuffer.append(this.q);
        for (int i = 0; i < zArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.r);
            }
            b(stringBuffer, str, zArr[i]);
        }
        stringBuffer.append(this.t);
    }

    protected void b(StringBuffer stringBuffer, String str, boolean[] zArr) {
        c(stringBuffer, str, zArr.length);
    }

    protected void c(StringBuffer stringBuffer, Object obj) {
        if (this.h && obj != null) {
            b(obj);
            if (this.i) {
                stringBuffer.append(a(obj.getClass()));
            } else {
                stringBuffer.append(obj.getClass().getName());
            }
        }
    }

    protected void d(StringBuffer stringBuffer, Object obj) {
        if (a() && obj != null) {
            b(obj);
            stringBuffer.append('@');
            stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    protected void b(StringBuffer stringBuffer) {
        stringBuffer.append(this.k);
    }

    protected void c(StringBuffer stringBuffer) {
        stringBuffer.append(this.l);
    }

    protected void a(StringBuffer stringBuffer, String str) {
        stringBuffer.append(this.v);
    }

    protected void d(StringBuffer stringBuffer) {
        stringBuffer.append(this.p);
    }

    protected void b(StringBuffer stringBuffer, String str) {
        if (this.g && str != null) {
            stringBuffer.append(str);
            stringBuffer.append(this.m);
        }
    }

    protected void c(StringBuffer stringBuffer, String str) {
        d(stringBuffer);
    }

    protected void c(StringBuffer stringBuffer, String str, int i) {
        stringBuffer.append(this.w);
        stringBuffer.append(i);
        stringBuffer.append(this.x);
    }

    protected boolean a(Boolean bool) {
        return bool == null ? this.u : bool.booleanValue();
    }

    protected String a(Class<?> cls) {
        return brq.a(cls);
    }

    protected void a(boolean z) {
        this.h = z;
    }

    protected void b(boolean z) {
        this.i = z;
    }

    protected boolean a() {
        return this.j;
    }

    protected void c(boolean z) {
        this.j = z;
    }

    protected void d(boolean z) {
        this.g = z;
    }

    protected void a(String str) {
        if (str == null) {
            str = "";
        }
        this.k = str;
    }

    protected void b(String str) {
        if (str == null) {
            str = "";
        }
        this.l = str;
    }

    protected void c(String str) {
        if (str == null) {
            str = "";
        }
        this.p = str;
    }

    protected void e(boolean z) {
        this.n = z;
    }

    protected String b() {
        return this.v;
    }

    static final class a extends bsd {
        a() {
        }
    }

    static final class c extends bsd {
        c() {
            d(false);
        }
    }

    static final class d extends bsd {
        d() {
            b(true);
            c(false);
        }
    }

    static final class e extends bsd {
        e() {
            a(false);
            c(false);
            d(false);
            a("");
            b("");
        }
    }

    static final class b extends bsd {
        b() {
            a("[");
            c(brv.F + "  ");
            e(true);
            b(brv.F + "]");
        }
    }
}
