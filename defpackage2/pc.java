package defpackage;

import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class pc implements oj {
    private final ot a;

    static oj a(ot otVar) {
        return new pc(otVar);
    }

    private pc(ot otVar) {
        this.a = otVar;
    }

    @Override // defpackage.oj
    public boolean a() {
        Class<?> clsA = a("com.google.android.gms.measurement.AppMeasurement");
        if (clsA == null) {
            blh.h().d("CrashlyticsCore", "Firebase Analytics is not present; you will not see automatic logging of events before a crash occurs.");
            return false;
        }
        Object objA = a(clsA);
        if (objA == null) {
            blh.h().d("CrashlyticsCore", "Could not create an instance of Firebase Analytics.");
            return false;
        }
        return a(clsA, objA, "registerOnMeasurementEventListener");
    }

    private Class<?> a(String str) {
        try {
            return this.a.r().getClassLoader().loadClass(str);
        } catch (Exception e) {
            return null;
        }
    }

    private Object a(Class<?> cls) {
        try {
            return cls.getDeclaredMethod("getInstance", Context.class).invoke(cls, this.a.r());
        } catch (Exception e) {
            return null;
        }
    }

    private boolean a(Class<?> cls, Object obj, String str) {
        Class<?> clsA = a("com.google.android.gms.measurement.AppMeasurement$OnEventListener");
        try {
            cls.getDeclaredMethod(str, clsA).invoke(obj, b(clsA));
            return true;
        } catch (IllegalAccessException e) {
            blh.h().d("CrashlyticsCore", "Cannot access method: " + str, e);
            return false;
        } catch (NoSuchMethodException e2) {
            blh.h().d("CrashlyticsCore", "Expected method missing: " + str, e2);
            return false;
        } catch (InvocationTargetException e3) {
            blh.h().d("CrashlyticsCore", "Cannot invoke method: " + str, e3);
            return false;
        }
    }

    private Object b(Class cls) {
        return Proxy.newProxyInstance(this.a.r().getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: pc.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) {
                if (objArr.length != 4) {
                    throw new RuntimeException("Unexpected AppMeasurement.OnEventListener signature");
                }
                String str = (String) objArr[0];
                String str2 = (String) objArr[1];
                Bundle bundle = (Bundle) objArr[2];
                if (str != null && !str.equals("crash")) {
                    pc.b(pc.this.a, str2, bundle);
                    return null;
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ot otVar, String str, Bundle bundle) {
        try {
            otVar.a("$A$:" + a(str, bundle));
        } catch (JSONException e) {
            blh.h().d("CrashlyticsCore", "Unable to serialize Firebase Analytics event; " + str);
        }
    }

    private static String a(String str, Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put("name", str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }
}
