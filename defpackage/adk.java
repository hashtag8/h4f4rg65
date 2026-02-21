package defpackage;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class adk implements acl {
    private final acs a;
    private final abv b;
    private final act c;

    public adk(acs acsVar, abv abvVar, act actVar) {
        this.a = acsVar;
        this.b = abvVar;
        this.c = actVar;
    }

    public boolean a(Field field, boolean z) {
        return (this.c.a(field.getType(), z) || this.c.a(field, z)) ? false : true;
    }

    private String a(Field field) {
        acn acnVar = (acn) field.getAnnotation(acn.class);
        return acnVar == null ? this.b.a(field) : acnVar.a();
    }

    @Override // defpackage.acl
    public <T> ack<T> a(abw abwVar, adp<T> adpVar) {
        Class<? super T> clsA = adpVar.a();
        if (Object.class.isAssignableFrom(clsA)) {
            return new a(this.a.a(adpVar), a(abwVar, adpVar, clsA));
        }
        return null;
    }

    private b a(final abw abwVar, final Field field, String str, final adp<?> adpVar, boolean z, boolean z2) {
        final boolean zA = acy.a((Type) adpVar.a());
        return new b(str, z, z2) { // from class: adk.1
            final ack<?> a;

            {
                this.a = abwVar.a(adpVar);
            }

            @Override // adk.b
            void a(adt adtVar, Object obj) throws IllegalAccessException {
                new adn(abwVar, this.a, adpVar.b()).a(adtVar, field.get(obj));
            }

            @Override // adk.b
            void a(adq adqVar, Object obj) throws IllegalAccessException {
                Object objB = this.a.b(adqVar);
                if (objB != null || !zA) {
                    field.set(obj, objB);
                }
            }
        };
    }

    private Map<String, b> a(abw abwVar, adp<?> adpVar, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type typeB = adpVar.b();
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                boolean zA = a(field, true);
                boolean zA2 = a(field, false);
                if (zA || zA2) {
                    field.setAccessible(true);
                    b bVarA = a(abwVar, field, a(field), adp.a(acr.a(adpVar.b(), cls, field.getGenericType())), zA, zA2);
                    b bVar = (b) linkedHashMap.put(bVarA.g, bVarA);
                    if (bVar != null) {
                        throw new IllegalArgumentException(typeB + " declares multiple JSON fields named " + bVar.g);
                    }
                }
            }
            adpVar = adp.a(acr.a(adpVar.b(), cls, cls.getGenericSuperclass()));
            cls = adpVar.a();
        }
        return linkedHashMap;
    }

    static abstract class b {
        final String g;
        final boolean h;
        final boolean i;

        abstract void a(adq adqVar, Object obj);

        abstract void a(adt adtVar, Object obj);

        protected b(String str, boolean z, boolean z2) {
            this.g = str;
            this.h = z;
            this.i = z2;
        }
    }

    public final class a<T> extends ack<T> {
        private final acx<T> b;
        private final Map<String, b> c;

        private a(acx<T> acxVar, Map<String, b> map) {
            this.b = acxVar;
            this.c = map;
        }

        @Override // defpackage.ack
        public T b(adq adqVar) {
            if (adqVar.f() == ads.NULL) {
                adqVar.j();
                return null;
            }
            T tA = this.b.a();
            try {
                adqVar.c();
                while (adqVar.e()) {
                    b bVar = this.c.get(adqVar.g());
                    if (bVar == null || !bVar.i) {
                        adqVar.n();
                    } else {
                        bVar.a(adqVar, tA);
                    }
                }
                adqVar.d();
                return tA;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new aci(e2);
            }
        }

        @Override // defpackage.ack
        public void a(adt adtVar, T t) throws IOException {
            if (t == null) {
                adtVar.f();
                return;
            }
            adtVar.d();
            try {
                for (b bVar : this.c.values()) {
                    if (bVar.h) {
                        adtVar.a(bVar.g);
                        bVar.a(adtVar, t);
                    }
                }
                adtVar.e();
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            }
        }
    }
}
