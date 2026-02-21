package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class abw {
    final abz a;
    final ach b;
    private final ThreadLocal<Map<adp<?>, a<?>>> c;
    private final Map<adp<?>, ack<?>> d;
    private final List<acl> e;
    private final acs f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;

    public abw() {
        this(act.a, abu.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, acj.DEFAULT, Collections.emptyList());
    }

    abw(act actVar, abv abvVar, Map<Type, abx<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, acj acjVar, List<acl> list) {
        this.c = new ThreadLocal<Map<adp<?>, a<?>>>() { // from class: abw.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map<adp<?>, a<?>> initialValue() {
                return new HashMap();
            }
        };
        this.d = Collections.synchronizedMap(new HashMap());
        this.a = new abz() { // from class: abw.2
        };
        this.b = new ach() { // from class: abw.3
        };
        this.f = new acs(map);
        this.g = z;
        this.i = z3;
        this.h = z4;
        this.j = z5;
        adk adkVar = new adk(this.f, abvVar, actVar);
        acs acsVar = new acs();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ado.v);
        arrayList.add(ado.m);
        arrayList.add(ado.g);
        arrayList.add(ado.i);
        arrayList.add(ado.k);
        arrayList.add(ado.a(Long.TYPE, Long.class, a(acjVar)));
        arrayList.add(ado.a(Double.TYPE, Double.class, a(z6)));
        arrayList.add(ado.a(Float.TYPE, Float.class, b(z6)));
        arrayList.add(actVar);
        arrayList.add(ado.r);
        arrayList.add(ado.t);
        arrayList.add(ado.x);
        arrayList.add(ado.z);
        arrayList.add(ado.a(BigDecimal.class, new adc()));
        arrayList.add(ado.a(BigInteger.class, new add()));
        arrayList.add(ado.O);
        arrayList.add(adj.a);
        arrayList.addAll(list);
        arrayList.add(new ade(acsVar));
        arrayList.add(ado.B);
        arrayList.add(ado.D);
        arrayList.add(ado.H);
        arrayList.add(ado.M);
        arrayList.add(ado.F);
        arrayList.add(ado.d);
        arrayList.add(adf.a);
        arrayList.add(ado.K);
        arrayList.add(adm.a);
        arrayList.add(adl.a);
        arrayList.add(ado.I);
        arrayList.add(new adi(acsVar, z2));
        arrayList.add(adb.a);
        arrayList.add(ado.P);
        arrayList.add(ado.b);
        arrayList.add(adkVar);
        this.e = Collections.unmodifiableList(arrayList);
    }

    private ack<Number> a(boolean z) {
        return z ? ado.p : new ack<Number>() { // from class: abw.4
            @Override // defpackage.ack
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Double b(adq adqVar) {
                if (adqVar.f() != ads.NULL) {
                    return Double.valueOf(adqVar.k());
                }
                adqVar.j();
                return null;
            }

            @Override // defpackage.ack
            public void a(adt adtVar, Number number) throws IOException {
                if (number == null) {
                    adtVar.f();
                    return;
                }
                abw.this.a(number.doubleValue());
                adtVar.a(number);
            }
        };
    }

    private ack<Number> b(boolean z) {
        return z ? ado.o : new ack<Number>() { // from class: abw.5
            @Override // defpackage.ack
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float b(adq adqVar) {
                if (adqVar.f() != ads.NULL) {
                    return Float.valueOf((float) adqVar.k());
                }
                adqVar.j();
                return null;
            }

            @Override // defpackage.ack
            public void a(adt adtVar, Number number) throws IOException {
                if (number == null) {
                    adtVar.f();
                    return;
                }
                abw.this.a(number.floatValue());
                adtVar.a(number);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialDoubleValues() method.");
        }
    }

    private ack<Number> a(acj acjVar) {
        return acjVar == acj.DEFAULT ? ado.n : new ack<Number>() { // from class: abw.6
            @Override // defpackage.ack
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Number b(adq adqVar) {
                if (adqVar.f() != ads.NULL) {
                    return Long.valueOf(adqVar.l());
                }
                adqVar.j();
                return null;
            }

            @Override // defpackage.ack
            public void a(adt adtVar, Number number) throws IOException {
                if (number == null) {
                    adtVar.f();
                } else {
                    adtVar.b(number.toString());
                }
            }
        };
    }

    public <T> ack<T> a(adp<T> adpVar) {
        ack<T> ackVar = (ack) this.d.get(adpVar);
        if (ackVar == null) {
            Map map = this.c.get();
            a aVar = (a) map.get(adpVar);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            map.put(adpVar, aVar2);
            try {
                Iterator<acl> it = this.e.iterator();
                while (it.hasNext()) {
                    ack<T> ackVarA = it.next().a(this, adpVar);
                    if (ackVarA != null) {
                        aVar2.a(ackVarA);
                        this.d.put(adpVar, ackVarA);
                        return ackVarA;
                    }
                }
                throw new IllegalArgumentException("GSON cannot handle " + adpVar);
            } finally {
                map.remove(adpVar);
            }
        }
        return ackVar;
    }

    static {
        acu.a = new acu() { // from class: abw.7
            @Override // defpackage.acu
            public <T> ack<T> a(abw abwVar, acl aclVar, adp<T> adpVar) {
                boolean z = false;
                for (acl aclVar2 : abwVar.e) {
                    if (!z) {
                        if (aclVar2 == aclVar) {
                            z = true;
                        }
                    } else {
                        ack<T> ackVarA = aclVar2.a(abwVar, adpVar);
                        if (ackVarA != null) {
                            return ackVarA;
                        }
                    }
                }
                throw new IllegalArgumentException("GSON cannot serialize " + adpVar);
            }
        };
    }

    public <T> ack<T> a(Class<T> cls) {
        return a((adp) adp.b(cls));
    }

    public String a(Object obj) {
        return obj == null ? a((aca) acc.a) : a(obj, obj.getClass());
    }

    public String a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void a(Object obj, Type type, Appendable appendable) {
        try {
            a(obj, type, a(acz.a(appendable)));
        } catch (IOException e) {
            throw new acb(e);
        }
    }

    public void a(Object obj, Type type, adt adtVar) {
        ack ackVarA = a((adp) adp.a(type));
        boolean zG = adtVar.g();
        adtVar.b(true);
        boolean zH = adtVar.h();
        adtVar.c(this.h);
        boolean zI = adtVar.i();
        adtVar.d(this.g);
        try {
            try {
                ackVarA.a(adtVar, obj);
            } catch (IOException e) {
                throw new acb(e);
            }
        } finally {
            adtVar.b(zG);
            adtVar.c(zH);
            adtVar.d(zI);
        }
    }

    public String a(aca acaVar) {
        StringWriter stringWriter = new StringWriter();
        a(acaVar, stringWriter);
        return stringWriter.toString();
    }

    public void a(aca acaVar, Appendable appendable) {
        try {
            a(acaVar, a(acz.a(appendable)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private adt a(Writer writer) throws IOException {
        if (this.i) {
            writer.write(")]}'\n");
        }
        adt adtVar = new adt(writer);
        if (this.j) {
            adtVar.c("  ");
        }
        adtVar.d(this.g);
        return adtVar;
    }

    public void a(aca acaVar, adt adtVar) {
        boolean zG = adtVar.g();
        adtVar.b(true);
        boolean zH = adtVar.h();
        adtVar.c(this.h);
        boolean zI = adtVar.i();
        adtVar.d(this.g);
        try {
            try {
                acz.a(acaVar, adtVar);
            } catch (IOException e) {
                throw new acb(e);
            }
        } finally {
            adtVar.b(zG);
            adtVar.c(zH);
            adtVar.d(zI);
        }
    }

    public <T> T a(String str, Class<T> cls) {
        return (T) acy.a((Class) cls).cast(a(str, (Type) cls));
    }

    public <T> T a(String str, Type type) {
        if (str == null) {
            return null;
        }
        return (T) a((Reader) new StringReader(str), type);
    }

    public <T> T a(Reader reader, Type type) {
        adq adqVar = new adq(reader);
        T t = (T) a(adqVar, type);
        a(t, adqVar);
        return t;
    }

    private static void a(Object obj, adq adqVar) {
        if (obj != null) {
            try {
                if (adqVar.f() != ads.END_DOCUMENT) {
                    throw new acb("JSON document was not fully consumed.");
                }
            } catch (adu e) {
                throw new aci(e);
            } catch (IOException e2) {
                throw new acb(e2);
            }
        }
    }

    public <T> T a(adq adqVar, Type type) {
        boolean z = true;
        boolean zP = adqVar.p();
        adqVar.a(true);
        try {
            try {
                adqVar.f();
                z = false;
                T tB = a((adp) adp.a(type)).b(adqVar);
                adqVar.a(zP);
                return tB;
            } catch (EOFException e) {
                if (!z) {
                    throw new aci(e);
                }
                adqVar.a(zP);
                return null;
            } catch (IOException e2) {
                throw new aci(e2);
            } catch (IllegalStateException e3) {
                throw new aci(e3);
            }
        } catch (Throwable th) {
            adqVar.a(zP);
            throw th;
        }
    }

    public <T> T a(aca acaVar, Class<T> cls) {
        return (T) acy.a((Class) cls).cast(a(acaVar, (Type) cls));
    }

    public <T> T a(aca acaVar, Type type) {
        if (acaVar == null) {
            return null;
        }
        return (T) a((adq) new adg(acaVar), type);
    }

    static class a<T> extends ack<T> {
        private ack<T> a;

        a() {
        }

        public void a(ack<T> ackVar) {
            if (this.a != null) {
                throw new AssertionError();
            }
            this.a = ackVar;
        }

        @Override // defpackage.ack
        public T b(adq adqVar) {
            if (this.a == null) {
                throw new IllegalStateException();
            }
            return this.a.b(adqVar);
        }

        @Override // defpackage.ack
        public void a(adt adtVar, T t) {
            if (this.a == null) {
                throw new IllegalStateException();
            }
            this.a.a(adtVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.g + "factories:" + this.e + ",instanceCreators:" + this.f + "}";
    }
}
