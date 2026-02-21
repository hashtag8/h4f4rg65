package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public final class acs {
    private final Map<Type, abx<?>> a;

    public acs(Map<Type, abx<?>> map) {
        this.a = map;
    }

    public acs() {
        this(Collections.emptyMap());
    }

    public <T> acx<T> a(adp<T> adpVar) {
        final Type typeB = adpVar.b();
        Class<? super T> clsA = adpVar.a();
        final abx<?> abxVar = this.a.get(typeB);
        if (abxVar != null) {
            return new acx<T>() { // from class: acs.1
                @Override // defpackage.acx
                public T a() {
                    return (T) abxVar.a(typeB);
                }
            };
        }
        acx<T> acxVarA = a(clsA);
        if (acxVarA == null) {
            acx<T> acxVarB = b(clsA);
            return acxVarB == null ? a(typeB, clsA) : acxVarB;
        }
        return acxVarA;
    }

    private <T> acx<T> a(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new acx<T>() { // from class: acs.2
                @Override // defpackage.acx
                public T a() {
                    try {
                        return (T) declaredConstructor.newInstance(null);
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    } catch (InstantiationException e2) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2);
                    } catch (InvocationTargetException e3) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e3.getTargetException());
                    }
                }
            };
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private <T> acx<T> b(Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new acx<T>() { // from class: acs.3
                    @Override // defpackage.acx
                    public T a() {
                        return (T) new TreeSet();
                    }
                };
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new acx<T>() { // from class: acs.4
                    @Override // defpackage.acx
                    public T a() {
                        return (T) new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new acx<T>() { // from class: acs.5
                    @Override // defpackage.acx
                    public T a() {
                        return (T) new LinkedList();
                    }
                };
            }
            return new acx<T>() { // from class: acs.6
                @Override // defpackage.acx
                public T a() {
                    return (T) new ArrayList();
                }
            };
        }
        if (Map.class.isAssignableFrom(cls)) {
            return new acx<T>() { // from class: acs.7
                @Override // defpackage.acx
                public T a() {
                    return (T) new LinkedHashMap();
                }
            };
        }
        return null;
    }

    private <T> acx<T> a(final Type type, final Class<? super T> cls) {
        return new acx<T>() { // from class: acs.8
            private final ada d = ada.a();

            @Override // defpackage.acx
            public T a() {
                try {
                    return (T) this.d.a(cls);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". Register an InstanceCreator with Gson for this type may fix this problem.", e);
                }
            }
        };
    }

    public String toString() {
        return this.a.toString();
    }
}
