package defpackage;

import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class nc implements nh {
    private final Method a;
    private final Object b;

    public static nh a(Context context) {
        Object objA;
        Method methodB;
        Class clsB = b(context);
        if (clsB == null || (objA = a(context, clsB)) == null || (methodB = b(context, clsB)) == null) {
            return null;
        }
        return new nc(objA, methodB);
    }

    private static Class b(Context context) {
        try {
            return context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement");
        } catch (Exception e) {
            return null;
        }
    }

    private static Object a(Context context, Class cls) {
        try {
            return cls.getDeclaredMethod("getInstance", Context.class).invoke(cls, context);
        } catch (Exception e) {
            return null;
        }
    }

    private static Method b(Context context, Class cls) {
        try {
            return cls.getDeclaredMethod("logEventInternal", String.class, String.class, Bundle.class);
        } catch (Exception e) {
            return null;
        }
    }

    public nc(Object obj, Method method) {
        this.b = obj;
        this.a = method;
    }

    @Override // defpackage.nh
    public void a(String str, Bundle bundle) {
        a("fab", str, bundle);
    }

    @Override // defpackage.nh
    public void a(String str, String str2, Bundle bundle) {
        try {
            this.a.invoke(this.b, str, str2, bundle);
        } catch (Exception e) {
        }
    }
}
