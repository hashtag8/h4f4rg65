package defpackage;

import android.os.IBinder;
import defpackage.wa;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class wb<T> extends wa.a {
    private final T a;

    private wb(T t) {
        this.a = t;
    }

    public static <T> T a(wa waVar) {
        if (waVar instanceof wb) {
            return ((wb) waVar).a;
        }
        IBinder iBinderAsBinder = waVar.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        if (declaredFields.length != 1) {
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
        }
        Field field = declaredFields[0];
        if (field.isAccessible()) {
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
        }
        field.setAccessible(true);
        try {
            return (T) field.get(iBinderAsBinder);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
        } catch (NullPointerException e3) {
            throw new IllegalArgumentException("Binder object is null.", e3);
        }
    }

    public static <T> wa a(T t) {
        return new wb(t);
    }
}
