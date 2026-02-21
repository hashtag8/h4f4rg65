package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class adj extends ack<Object> {
    public static final acl a = new acl() { // from class: adj.1
        @Override // defpackage.acl
        public <T> ack<T> a(abw abwVar, adp<T> adpVar) {
            if (adpVar.a() == Object.class) {
                return new adj(abwVar);
            }
            return null;
        }
    };
    private final abw b;

    private adj(abw abwVar) {
        this.b = abwVar;
    }

    @Override // defpackage.ack
    public Object b(adq adqVar) {
        switch (adqVar.f()) {
            case BEGIN_ARRAY:
                ArrayList arrayList = new ArrayList();
                adqVar.a();
                while (adqVar.e()) {
                    arrayList.add(b(adqVar));
                }
                adqVar.b();
                return arrayList;
            case BEGIN_OBJECT:
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                adqVar.c();
                while (adqVar.e()) {
                    linkedHashMap.put(adqVar.g(), b(adqVar));
                }
                adqVar.d();
                return linkedHashMap;
            case STRING:
                return adqVar.h();
            case NUMBER:
                return Double.valueOf(adqVar.k());
            case BOOLEAN:
                return Boolean.valueOf(adqVar.i());
            case NULL:
                adqVar.j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // defpackage.ack
    public void a(adt adtVar, Object obj) throws IOException {
        if (obj == null) {
            adtVar.f();
            return;
        }
        ack ackVarA = this.b.a((Class) obj.getClass());
        if (ackVarA instanceof adj) {
            adtVar.d();
            adtVar.e();
        } else {
            ackVarA.a(adtVar, obj);
        }
    }
}
