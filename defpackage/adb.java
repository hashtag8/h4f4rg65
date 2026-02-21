package defpackage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class adb<E> extends ack<Object> {
    public static final acl a = new acl() { // from class: adb.1
        @Override // defpackage.acl
        public <T> ack<T> a(abw abwVar, adp<T> adpVar) {
            Type typeB = adpVar.b();
            if (!(typeB instanceof GenericArrayType) && (!(typeB instanceof Class) || !((Class) typeB).isArray())) {
                return null;
            }
            Type typeG = acr.g(typeB);
            return new adb(abwVar, abwVar.a((adp) adp.a(typeG)), acr.e(typeG));
        }
    };
    private final Class<E> b;
    private final ack<E> c;

    public adb(abw abwVar, ack<E> ackVar, Class<E> cls) {
        this.c = new adn(abwVar, ackVar, cls);
        this.b = cls;
    }

    @Override // defpackage.ack
    public Object b(adq adqVar) {
        if (adqVar.f() == ads.NULL) {
            adqVar.j();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        adqVar.a();
        while (adqVar.e()) {
            arrayList.add(this.c.b(adqVar));
        }
        adqVar.b();
        Object objNewInstance = Array.newInstance((Class<?>) this.b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(objNewInstance, i, arrayList.get(i));
        }
        return objNewInstance;
    }

    @Override // defpackage.ack
    public void a(adt adtVar, Object obj) throws IOException {
        if (obj == null) {
            adtVar.f();
            return;
        }
        adtVar.b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.c.a(adtVar, Array.get(obj, i));
        }
        adtVar.c();
    }
}
