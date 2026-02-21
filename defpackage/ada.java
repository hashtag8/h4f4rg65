package defpackage;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class ada {
    public abstract <T> T a(Class<T> cls);

    public static ada a() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            final Object obj = declaredField.get(null);
            final Method method = cls.getMethod("allocateInstance", Class.class);
            return new ada() { // from class: ada.1
                @Override // defpackage.ada
                public <T> T a(Class<T> cls2) {
                    return (T) method.invoke(obj, cls2);
                }
            };
        } catch (Exception e) {
            try {
                final Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod.setAccessible(true);
                return new ada() { // from class: ada.2
                    @Override // defpackage.ada
                    public <T> T a(Class<T> cls2) {
                        return (T) declaredMethod.invoke(null, cls2, Object.class);
                    }
                };
            } catch (Exception e2) {
                try {
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod2.setAccessible(true);
                    final int iIntValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
                    final Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod3.setAccessible(true);
                    return new ada() { // from class: ada.3
                        @Override // defpackage.ada
                        public <T> T a(Class<T> cls2) {
                            return (T) declaredMethod3.invoke(null, cls2, Integer.valueOf(iIntValue));
                        }
                    };
                } catch (Exception e3) {
                    return new ada() { // from class: ada.4
                        @Override // defpackage.ada
                        public <T> T a(Class<T> cls2) {
                            throw new UnsupportedOperationException("Cannot allocate " + cls2);
                        }
                    };
                }
            }
        }
    }
}
