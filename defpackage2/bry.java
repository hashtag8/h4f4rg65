package defpackage;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class bry {
    private static final ThreadLocal<Set<brz>> a = new ThreadLocal<>();
    private final int b;
    private int c;

    static Set<brz> a() {
        return a.get();
    }

    static boolean a(Object obj) {
        Set<brz> setA = a();
        return setA != null && setA.contains(new brz(obj));
    }

    private static void a(Object obj, Class<?> cls, bry bryVar, boolean z, String[] strArr) {
        if (!a(obj)) {
            try {
                b(obj);
                Field[] declaredFields = cls.getDeclaredFields();
                AccessibleObject.setAccessible(declaredFields, true);
                for (Field field : declaredFields) {
                    if (!bro.b(strArr, field.getName()) && field.getName().indexOf(36) == -1 && ((z || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                        try {
                            bryVar.d(field.get(obj));
                        } catch (IllegalAccessException e) {
                            throw new InternalError("Unexpected IllegalAccessException");
                        }
                    }
                }
            } finally {
                c(obj);
            }
        }
    }

    public static <T> int a(int i, int i2, T t, boolean z, Class<? super T> cls, String... strArr) {
        if (t == null) {
            throw new IllegalArgumentException("The object to build a hash code for must not be null");
        }
        bry bryVar = new bry(i, i2);
        Class<?> superclass = t.getClass();
        a(t, superclass, bryVar, z, strArr);
        while (superclass.getSuperclass() != null && superclass != cls) {
            superclass = superclass.getSuperclass();
            a(t, superclass, bryVar, z, strArr);
        }
        return bryVar.b();
    }

    public static int a(Object obj, String... strArr) {
        return a(17, 37, obj, false, null, strArr);
    }

    static void b(Object obj) {
        synchronized (bry.class) {
            if (a() == null) {
                a.set(new HashSet());
            }
        }
        a().add(new brz(obj));
    }

    static void c(Object obj) {
        Set<brz> setA = a();
        if (setA != null) {
            setA.remove(new brz(obj));
            synchronized (bry.class) {
                Set<brz> setA2 = a();
                if (setA2 != null && setA2.isEmpty()) {
                    a.remove();
                }
            }
        }
    }

    public bry() {
        this.c = 0;
        this.b = 37;
        this.c = 17;
    }

    public bry(int i, int i2) {
        this.c = 0;
        if (i == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires a non zero initial value");
        }
        if (i % 2 == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires an odd initial value");
        }
        if (i2 == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires a non zero multiplier");
        }
        if (i2 % 2 == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires an odd multiplier");
        }
        this.b = i2;
        this.c = i;
    }

    public bry a(boolean z) {
        this.c = (z ? 0 : 1) + (this.b * this.c);
        return this;
    }

    public bry a(boolean[] zArr) {
        if (zArr == null) {
            this.c *= this.b;
        } else {
            for (boolean z : zArr) {
                a(z);
            }
        }
        return this;
    }

    public bry a(byte b) {
        this.c = (this.c * this.b) + b;
        return this;
    }

    public bry a(byte[] bArr) {
        if (bArr == null) {
            this.c *= this.b;
        } else {
            for (byte b : bArr) {
                a(b);
            }
        }
        return this;
    }

    public bry a(char c) {
        this.c = (this.c * this.b) + c;
        return this;
    }

    public bry a(char[] cArr) {
        if (cArr == null) {
            this.c *= this.b;
        } else {
            for (char c : cArr) {
                a(c);
            }
        }
        return this;
    }

    public bry a(double d) {
        return a(Double.doubleToLongBits(d));
    }

    public bry a(double[] dArr) {
        if (dArr == null) {
            this.c *= this.b;
        } else {
            for (double d : dArr) {
                a(d);
            }
        }
        return this;
    }

    public bry a(float f) {
        this.c = (this.c * this.b) + Float.floatToIntBits(f);
        return this;
    }

    public bry a(float[] fArr) {
        if (fArr == null) {
            this.c *= this.b;
        } else {
            for (float f : fArr) {
                a(f);
            }
        }
        return this;
    }

    public bry a(int i) {
        this.c = (this.c * this.b) + i;
        return this;
    }

    public bry a(int[] iArr) {
        if (iArr == null) {
            this.c *= this.b;
        } else {
            for (int i : iArr) {
                a(i);
            }
        }
        return this;
    }

    public bry a(long j) {
        this.c = (this.c * this.b) + ((int) ((j >> 32) ^ j));
        return this;
    }

    public bry a(long[] jArr) {
        if (jArr == null) {
            this.c *= this.b;
        } else {
            for (long j : jArr) {
                a(j);
            }
        }
        return this;
    }

    public bry d(Object obj) {
        if (obj == null) {
            this.c *= this.b;
        } else if (obj.getClass().isArray()) {
            if (obj instanceof long[]) {
                a((long[]) obj);
            } else if (obj instanceof int[]) {
                a((int[]) obj);
            } else if (obj instanceof short[]) {
                a((short[]) obj);
            } else if (obj instanceof char[]) {
                a((char[]) obj);
            } else if (obj instanceof byte[]) {
                a((byte[]) obj);
            } else if (obj instanceof double[]) {
                a((double[]) obj);
            } else if (obj instanceof float[]) {
                a((float[]) obj);
            } else if (obj instanceof boolean[]) {
                a((boolean[]) obj);
            } else {
                a((Object[]) obj);
            }
        } else {
            this.c = (this.c * this.b) + obj.hashCode();
        }
        return this;
    }

    public bry a(Object[] objArr) {
        if (objArr == null) {
            this.c *= this.b;
        } else {
            for (Object obj : objArr) {
                d(obj);
            }
        }
        return this;
    }

    public bry a(short s) {
        this.c = (this.c * this.b) + s;
        return this;
    }

    public bry a(short[] sArr) {
        if (sArr == null) {
            this.c *= this.b;
        } else {
            for (short s : sArr) {
                a(s);
            }
        }
        return this;
    }

    public int b() {
        return this.c;
    }

    public int hashCode() {
        return b();
    }
}
