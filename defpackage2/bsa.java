package defpackage;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class bsa extends bsc {
    protected String[] a;
    private boolean b;
    private boolean c;
    private Class<?> d;

    public static String a(Object obj) {
        return a(obj, null, false, false, null);
    }

    public static String a(Object obj, bsd bsdVar) {
        return a(obj, bsdVar, false, false, null);
    }

    public static <T> String a(T t, bsd bsdVar, boolean z, boolean z2, Class<? super T> cls) {
        return new bsa(t, bsdVar, null, cls, z, z2).toString();
    }

    public <T> bsa(T t, bsd bsdVar, StringBuffer stringBuffer, Class<? super T> cls, boolean z, boolean z2) {
        super(t, bsdVar, stringBuffer);
        this.b = false;
        this.c = false;
        this.d = null;
        b((Class<?>) cls);
        b(z);
        a(z2);
    }

    protected boolean a(Field field) {
        if (field.getName().indexOf(36) != -1) {
            return false;
        }
        if (Modifier.isTransient(field.getModifiers()) && !c()) {
            return false;
        }
        if (!Modifier.isStatic(field.getModifiers()) || b()) {
            return this.a == null || Arrays.binarySearch(this.a, field.getName()) < 0;
        }
        return false;
    }

    protected void a(Class<?> cls) {
        if (cls.isArray()) {
            b(e());
            return;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        AccessibleObject.setAccessible(declaredFields, true);
        for (Field field : declaredFields) {
            String name = field.getName();
            if (a(field)) {
                try {
                    a(name, b(field));
                } catch (IllegalAccessException e) {
                    throw new InternalError("Unexpected IllegalAccessException: " + e.getMessage());
                }
            }
        }
    }

    public Class<?> a() {
        return this.d;
    }

    protected Object b(Field field) {
        return field.get(e());
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public bsa b(Object obj) {
        g().d(f(), null, obj);
        return this;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void b(boolean z) {
        this.c = z;
    }

    public void b(Class<?> cls) {
        Object objE;
        if (cls != null && (objE = e()) != null && !cls.isInstance(objE)) {
            throw new IllegalArgumentException("Specified class is not a superclass of the object");
        }
        this.d = cls;
    }

    @Override // defpackage.bsc
    public String toString() {
        if (e() == null) {
            return g().b();
        }
        Class<?> superclass = e().getClass();
        a(superclass);
        while (superclass.getSuperclass() != null && superclass != a()) {
            superclass = superclass.getSuperclass();
            a(superclass);
        }
        return super.toString();
    }
}
