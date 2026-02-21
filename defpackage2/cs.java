package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import defpackage.cl;
import defpackage.ds;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class cs extends cu {
    private static final Class a;
    private static final Constructor b;
    private static final Method c;
    private static final Method d;

    cs() {
    }

    static {
        Method method;
        Constructor<?> constructor;
        Class<?> cls;
        Method method2 = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls2.getConstructor(new Class[0]);
            Method method3 = cls2.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls2, 1).getClass());
            method2 = method3;
            constructor = constructor2;
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            method = null;
            constructor = null;
            cls = null;
        }
        b = constructor;
        a = cls;
        c = method2;
        d = method;
    }

    public static boolean a() {
        if (c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return c != null;
    }

    private static Object b() {
        try {
            return b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) c.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static Typeface a(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) a, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) d.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // defpackage.cu, cq.a
    public Typeface a(Context context, CancellationSignal cancellationSignal, ds.b[] bVarArr, int i) throws Throwable {
        Object objB = b();
        eg egVar = new eg();
        for (ds.b bVar : bVarArr) {
            Uri uriA = bVar.a();
            ByteBuffer byteBufferA = (ByteBuffer) egVar.get(uriA);
            if (byteBufferA == null) {
                byteBufferA = cv.a(context, cancellationSignal, uriA);
                egVar.put(uriA, byteBufferA);
            }
            if (!a(objB, byteBufferA, bVar.b(), bVar.c(), bVar.d())) {
                return null;
            }
        }
        return a(objB);
    }

    @Override // defpackage.cu, cq.a
    public Typeface a(Context context, cl.b bVar, Resources resources, int i) {
        Object objB = b();
        for (cl.c cVar : bVar.a()) {
            if (!a(objB, cv.a(context, resources, cVar.d()), 0, cVar.b(), cVar.c())) {
                return null;
            }
        }
        return a(objB);
    }
}
