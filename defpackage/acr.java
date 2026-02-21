package defpackage;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public final class acr {
    static final Type[] a = new Type[0];

    public static ParameterizedType a(Type type, Type type2, Type... typeArr) {
        return new b(type, type2, typeArr);
    }

    public static GenericArrayType a(Type type) {
        return new a(type);
    }

    public static WildcardType b(Type type) {
        return new c(new Type[]{type}, a);
    }

    public static WildcardType c(Type type) {
        return new c(new Type[]{Object.class}, new Type[]{type});
    }

    public static Type d(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new a(d(cls.getComponentType())) : cls;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new a(((GenericArrayType) type).getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
        return type;
    }

    public static Class<?> e(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            acq.a(rawType instanceof Class);
            return (Class) rawType;
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(e(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return e(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean a(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            return a((Object) parameterizedType.getOwnerType(), (Object) parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static String f(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    static Type a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 != cls) {
            if (cls2.isInterface()) {
                Class<?>[] interfaces = cls.getInterfaces();
                int length = interfaces.length;
                for (int i = 0; i < length; i++) {
                    if (interfaces[i] == cls2) {
                        return cls.getGenericInterfaces()[i];
                    }
                    if (cls2.isAssignableFrom(interfaces[i])) {
                        return a(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                    }
                }
            }
            if (!cls.isInterface()) {
                while (cls != Object.class) {
                    Class<? super Object> superclass = cls.getSuperclass();
                    if (superclass == cls2) {
                        return cls.getGenericSuperclass();
                    }
                    if (cls2.isAssignableFrom(superclass)) {
                        return a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                    }
                    cls = superclass;
                }
            }
            return cls2;
        }
        return type;
    }

    static Type b(Type type, Class<?> cls, Class<?> cls2) {
        acq.a(cls2.isAssignableFrom(cls));
        return a(type, cls, a(type, cls, cls2));
    }

    public static Type g(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    public static Type a(Type type, Class<?> cls) {
        Type typeB = b(type, cls, Collection.class);
        if (typeB instanceof WildcardType) {
            typeB = ((WildcardType) typeB).getUpperBounds()[0];
        }
        return typeB instanceof ParameterizedType ? ((ParameterizedType) typeB).getActualTypeArguments()[0] : Object.class;
    }

    public static Type[] b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type typeB = b(type, cls, Map.class);
        if (typeB instanceof ParameterizedType) {
            return ((ParameterizedType) typeB).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    public static Type a(Type type, Class<?> cls, Type type2) {
        Type typeA;
        TypeVariable typeVariable;
        do {
            Type type3 = type2;
            if (!(type3 instanceof TypeVariable)) {
                if ((type3 instanceof Class) && ((Class) type3).isArray()) {
                    Class cls2 = (Class) type3;
                    Class<?> componentType = cls2.getComponentType();
                    Type typeA2 = a(type, cls, (Type) componentType);
                    return componentType != typeA2 ? a(typeA2) : cls2;
                }
                if (type3 instanceof GenericArrayType) {
                    GenericArrayType genericArrayType = (GenericArrayType) type3;
                    Type genericComponentType = genericArrayType.getGenericComponentType();
                    Type typeA3 = a(type, cls, genericComponentType);
                    return genericComponentType != typeA3 ? a(typeA3) : genericArrayType;
                }
                if (type3 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type3;
                    Type ownerType = parameterizedType.getOwnerType();
                    Type typeA4 = a(type, cls, ownerType);
                    boolean z = typeA4 != ownerType;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    int length = actualTypeArguments.length;
                    boolean z2 = z;
                    Type[] typeArr = actualTypeArguments;
                    for (int i = 0; i < length; i++) {
                        Type typeA5 = a(type, cls, typeArr[i]);
                        if (typeA5 != typeArr[i]) {
                            if (!z2) {
                                typeArr = (Type[]) typeArr.clone();
                                z2 = true;
                            }
                            typeArr[i] = typeA5;
                        }
                    }
                    return z2 ? a(typeA4, parameterizedType.getRawType(), typeArr) : parameterizedType;
                }
                if (type3 instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type3;
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    if (lowerBounds.length == 1) {
                        Type typeA6 = a(type, cls, lowerBounds[0]);
                        if (typeA6 != lowerBounds[0]) {
                            return c(typeA6);
                        }
                        return wildcardType;
                    }
                    if (upperBounds.length == 1 && (typeA = a(type, cls, upperBounds[0])) != upperBounds[0]) {
                        return b(typeA);
                    }
                    return wildcardType;
                }
                return type3;
            }
            typeVariable = (TypeVariable) type3;
            type2 = a(type, cls, (TypeVariable<?>) typeVariable);
        } while (type2 != typeVariable);
        return type2;
    }

    static Type a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> clsA = a(typeVariable);
        if (clsA != null) {
            Type typeA = a(type, cls, clsA);
            if (typeA instanceof ParameterizedType) {
                return ((ParameterizedType) typeA).getActualTypeArguments()[a((Object[]) clsA.getTypeParameters(), (Object) typeVariable)];
            }
            return typeVariable;
        }
        return typeVariable;
    }

    private static int a(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    private static Class<?> a(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(Type type) {
        acq.a(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }

    static final class b implements Serializable, ParameterizedType {
        private final Type a;
        private final Type b;
        private final Type[] c;

        public b(Type type, Type type2, Type... typeArr) {
            boolean z = true;
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                acq.a(type != null || cls.getEnclosingClass() == null);
                if (type != null && cls.getEnclosingClass() == null) {
                    z = false;
                }
                acq.a(z);
            }
            this.a = type == null ? null : acr.d(type);
            this.b = acr.d(type2);
            this.c = (Type[]) typeArr.clone();
            for (int i = 0; i < this.c.length; i++) {
                acq.a(this.c[i]);
                acr.i(this.c[i]);
                this.c[i] = acr.d(this.c[i]);
            }
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && acr.a((Type) this, (Type) obj);
        }

        public int hashCode() {
            return (Arrays.hashCode(this.c) ^ this.b.hashCode()) ^ acr.b((Object) this.a);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((this.c.length + 1) * 30);
            sb.append(acr.f(this.b));
            if (this.c.length == 0) {
                return sb.toString();
            }
            sb.append("<").append(acr.f(this.c[0]));
            for (int i = 1; i < this.c.length; i++) {
                sb.append(", ").append(acr.f(this.c[i]));
            }
            return sb.append(">").toString();
        }
    }

    static final class a implements Serializable, GenericArrayType {
        private final Type a;

        public a(Type type) {
            this.a = acr.d(type);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && acr.a((Type) this, (Type) obj);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return acr.f(this.a) + "[]";
        }
    }

    static final class c implements Serializable, WildcardType {
        private final Type a;
        private final Type b;

        public c(Type[] typeArr, Type[] typeArr2) {
            acq.a(typeArr2.length <= 1);
            acq.a(typeArr.length == 1);
            if (typeArr2.length == 1) {
                acq.a(typeArr2[0]);
                acr.i(typeArr2[0]);
                acq.a(typeArr[0] == Object.class);
                this.b = acr.d(typeArr2[0]);
                this.a = Object.class;
                return;
            }
            acq.a(typeArr[0]);
            acr.i(typeArr[0]);
            this.b = null;
            this.a = acr.d(typeArr[0]);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.a};
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return this.b != null ? new Type[]{this.b} : acr.a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && acr.a((Type) this, (Type) obj);
        }

        public int hashCode() {
            return (this.b != null ? this.b.hashCode() + 31 : 1) ^ (this.a.hashCode() + 31);
        }

        public String toString() {
            if (this.b != null) {
                return "? super " + acr.f(this.b);
            }
            if (this.a == Object.class) {
                return "?";
            }
            return "? extends " + acr.f(this.a);
        }
    }
}
