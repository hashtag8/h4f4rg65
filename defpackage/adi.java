package defpackage;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class adi implements acl {
    private final acs a;
    private final boolean b;

    public adi(acs acsVar, boolean z) {
        this.a = acsVar;
        this.b = z;
    }

    @Override // defpackage.acl
    public <T> ack<T> a(abw abwVar, adp<T> adpVar) {
        Type typeB = adpVar.b();
        if (!Map.class.isAssignableFrom(adpVar.a())) {
            return null;
        }
        Type[] typeArrB = acr.b(typeB, acr.e(typeB));
        return new a(abwVar, typeArrB[0], a(abwVar, typeArrB[0]), typeArrB[1], abwVar.a((adp) adp.a(typeArrB[1])), this.a.a(adpVar));
    }

    private ack<?> a(abw abwVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? ado.f : abwVar.a((adp) adp.a(type));
    }

    final class a<K, V> extends ack<Map<K, V>> {
        private final ack<K> b;
        private final ack<V> c;
        private final acx<? extends Map<K, V>> d;

        public a(abw abwVar, Type type, ack<K> ackVar, Type type2, ack<V> ackVar2, acx<? extends Map<K, V>> acxVar) {
            this.b = new adn(abwVar, ackVar, type);
            this.c = new adn(abwVar, ackVar2, type2);
            this.d = acxVar;
        }

        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<K, V> b(adq adqVar) {
            ads adsVarF = adqVar.f();
            if (adsVarF == ads.NULL) {
                adqVar.j();
                return null;
            }
            Map<K, V> mapA = this.d.a();
            if (adsVarF == ads.BEGIN_ARRAY) {
                adqVar.a();
                while (adqVar.e()) {
                    adqVar.a();
                    K kB = this.b.b(adqVar);
                    if (mapA.put(kB, this.c.b(adqVar)) != null) {
                        throw new aci("duplicate key: " + kB);
                    }
                    adqVar.b();
                }
                adqVar.b();
                return mapA;
            }
            adqVar.c();
            while (adqVar.e()) {
                acv.a.a(adqVar);
                K kB2 = this.b.b(adqVar);
                if (mapA.put(kB2, this.c.b(adqVar)) != null) {
                    throw new aci("duplicate key: " + kB2);
                }
            }
            adqVar.d();
            return mapA;
        }

        @Override // defpackage.ack
        public void a(adt adtVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map != null) {
                if (!adi.this.b) {
                    adtVar.d();
                    for (Map.Entry<K, V> entry : map.entrySet()) {
                        adtVar.a(String.valueOf(entry.getKey()));
                        this.c.a(adtVar, entry.getValue());
                    }
                    adtVar.e();
                    return;
                }
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    aca acaVarB = adi.b(this.b, entry2.getKey());
                    arrayList.add(acaVarB);
                    arrayList2.add(entry2.getValue());
                    z = (acaVarB.h() || acaVarB.i()) | z;
                }
                if (z) {
                    adtVar.b();
                    while (i < arrayList.size()) {
                        adtVar.b();
                        acz.a((aca) arrayList.get(i), adtVar);
                        this.c.a(adtVar, arrayList2.get(i));
                        adtVar.c();
                        i++;
                    }
                    adtVar.c();
                    return;
                }
                adtVar.d();
                while (i < arrayList.size()) {
                    adtVar.a(a((aca) arrayList.get(i)));
                    this.c.a(adtVar, arrayList2.get(i));
                    i++;
                }
                adtVar.e();
                return;
            }
            adtVar.f();
        }

        private String a(aca acaVar) {
            if (acaVar.j()) {
                acg acgVarN = acaVar.n();
                if (acgVarN.p()) {
                    return String.valueOf(acgVarN.b());
                }
                if (acgVarN.a()) {
                    return Boolean.toString(acgVarN.g());
                }
                if (acgVarN.q()) {
                    return acgVarN.c();
                }
                throw new AssertionError();
            }
            if (acaVar.k()) {
                return "null";
            }
            throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> aca b(ack<T> ackVar, T t) {
        try {
            adh adhVar = new adh();
            adhVar.b(true);
            ackVar.a(adhVar, t);
            return adhVar.a();
        } catch (IOException e) {
            throw new acb(e);
        }
    }
}
