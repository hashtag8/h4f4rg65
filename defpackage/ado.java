package defpackage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class ado {
    public static final ack<Class> a = new ack<Class>() { // from class: ado.1
        @Override // defpackage.ack
        public void a(adt adtVar, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Class b(adq adqVar) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    };
    public static final acl b = a(Class.class, a);
    public static final ack<BitSet> c = new ack<BitSet>() { // from class: ado.12
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BitSet b(adq adqVar) {
            boolean zI;
            if (adqVar.f() == ads.NULL) {
                adqVar.j();
                return null;
            }
            BitSet bitSet = new BitSet();
            adqVar.a();
            ads adsVarF = adqVar.f();
            int i2 = 0;
            while (adsVarF != ads.END_ARRAY) {
                switch (AnonymousClass23.a[adsVarF.ordinal()]) {
                    case 1:
                        zI = adqVar.m() != 0;
                        break;
                    case 2:
                        zI = adqVar.i();
                        break;
                    case 3:
                        String strH = adqVar.h();
                        try {
                            zI = Integer.parseInt(strH) != 0;
                        } catch (NumberFormatException e2) {
                            throw new aci("Error: Expecting: bitset number value (1, 0), Found: " + strH);
                        }
                        break;
                    default:
                        throw new aci("Invalid bitset value type: " + adsVarF);
                }
                if (zI) {
                    bitSet.set(i2);
                }
                i2++;
                adsVarF = adqVar.f();
            }
            adqVar.b();
            return bitSet;
        }

        @Override // defpackage.ack
        public void a(adt adtVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                adtVar.f();
                return;
            }
            adtVar.b();
            for (int i2 = 0; i2 < bitSet.length(); i2++) {
                adtVar.a(bitSet.get(i2) ? 1 : 0);
            }
            adtVar.c();
        }
    };
    public static final acl d = a(BitSet.class, c);
    public static final ack<Boolean> e = new ack<Boolean>() { // from class: ado.22
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean b(adq adqVar) {
            if (adqVar.f() == ads.NULL) {
                adqVar.j();
                return null;
            }
            if (adqVar.f() == ads.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(adqVar.h()));
            }
            return Boolean.valueOf(adqVar.i());
        }

        @Override // defpackage.ack
        public void a(adt adtVar, Boolean bool) throws IOException {
            if (bool == null) {
                adtVar.f();
            } else {
                adtVar.a(bool.booleanValue());
            }
        }
    };
    public static final ack<Boolean> f = new ack<Boolean>() { // from class: ado.24
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean b(adq adqVar) {
            if (adqVar.f() != ads.NULL) {
                return Boolean.valueOf(adqVar.h());
            }
            adqVar.j();
            return null;
        }

        @Override // defpackage.ack
        public void a(adt adtVar, Boolean bool) throws IOException {
            adtVar.b(bool == null ? "null" : bool.toString());
        }
    };
    public static final acl g = a(Boolean.TYPE, Boolean.class, e);
    public static final ack<Number> h = new ack<Number>() { // from class: ado.25
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number b(adq adqVar) {
            if (adqVar.f() == ads.NULL) {
                adqVar.j();
                return null;
            }
            try {
                return Byte.valueOf((byte) adqVar.m());
            } catch (NumberFormatException e2) {
                throw new aci(e2);
            }
        }

        @Override // defpackage.ack
        public void a(adt adtVar, Number number) throws IOException {
            adtVar.a(number);
        }
    };
    public static final acl i = a(Byte.TYPE, Byte.class, h);
    public static final ack<Number> j = new ack<Number>() { // from class: ado.26
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number b(adq adqVar) {
            if (adqVar.f() == ads.NULL) {
                adqVar.j();
                return null;
            }
            try {
                return Short.valueOf((short) adqVar.m());
            } catch (NumberFormatException e2) {
                throw new aci(e2);
            }
        }

        @Override // defpackage.ack
        public void a(adt adtVar, Number number) throws IOException {
            adtVar.a(number);
        }
    };
    public static final acl k = a(Short.TYPE, Short.class, j);
    public static final ack<Number> l = new ack<Number>() { // from class: ado.27
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number b(adq adqVar) {
            if (adqVar.f() == ads.NULL) {
                adqVar.j();
                return null;
            }
            try {
                return Integer.valueOf(adqVar.m());
            } catch (NumberFormatException e2) {
                throw new aci(e2);
            }
        }

        @Override // defpackage.ack
        public void a(adt adtVar, Number number) throws IOException {
            adtVar.a(number);
        }
    };
    public static final acl m = a(Integer.TYPE, Integer.class, l);
    public static final ack<Number> n = new ack<Number>() { // from class: ado.28
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number b(adq adqVar) {
            if (adqVar.f() == ads.NULL) {
                adqVar.j();
                return null;
            }
            try {
                return Long.valueOf(adqVar.l());
            } catch (NumberFormatException e2) {
                throw new aci(e2);
            }
        }

        @Override // defpackage.ack
        public void a(adt adtVar, Number number) throws IOException {
            adtVar.a(number);
        }
    };
    public static final ack<Number> o = new ack<Number>() { // from class: ado.29
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number b(adq adqVar) {
            if (adqVar.f() != ads.NULL) {
                return Float.valueOf((float) adqVar.k());
            }
            adqVar.j();
            return null;
        }

        @Override // defpackage.ack
        public void a(adt adtVar, Number number) throws IOException {
            adtVar.a(number);
        }
    };
    public static final ack<Number> p = new ack<Number>() { // from class: ado.2
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number b(adq adqVar) {
            if (adqVar.f() != ads.NULL) {
                return Double.valueOf(adqVar.k());
            }
            adqVar.j();
            return null;
        }

        @Override // defpackage.ack
        public void a(adt adtVar, Number number) throws IOException {
            adtVar.a(number);
        }
    };
    public static final ack<Number> q = new ack<Number>() { // from class: ado.3
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number b(adq adqVar) {
            ads adsVarF = adqVar.f();
            switch (adsVarF) {
                case NUMBER:
                    return new acw(adqVar.h());
                case BOOLEAN:
                case STRING:
                default:
                    throw new aci("Expecting number, got: " + adsVarF);
                case NULL:
                    adqVar.j();
                    return null;
            }
        }

        @Override // defpackage.ack
        public void a(adt adtVar, Number number) throws IOException {
            adtVar.a(number);
        }
    };
    public static final acl r = a(Number.class, q);
    public static final ack<Character> s = new ack<Character>() { // from class: ado.4
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Character b(adq adqVar) {
            if (adqVar.f() == ads.NULL) {
                adqVar.j();
                return null;
            }
            String strH = adqVar.h();
            if (strH.length() != 1) {
                throw new aci("Expecting character, got: " + strH);
            }
            return Character.valueOf(strH.charAt(0));
        }

        @Override // defpackage.ack
        public void a(adt adtVar, Character ch) throws IOException {
            adtVar.b(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final acl t = a(Character.TYPE, Character.class, s);
    public static final ack<String> u = new ack<String>() { // from class: ado.5
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String b(adq adqVar) {
            ads adsVarF = adqVar.f();
            if (adsVarF == ads.NULL) {
                adqVar.j();
                return null;
            }
            if (adsVarF == ads.BOOLEAN) {
                return Boolean.toString(adqVar.i());
            }
            return adqVar.h();
        }

        @Override // defpackage.ack
        public void a(adt adtVar, String str) throws IOException {
            adtVar.b(str);
        }
    };
    public static final acl v = a(String.class, u);
    public static final ack<StringBuilder> w = new ack<StringBuilder>() { // from class: ado.6
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder b(adq adqVar) {
            if (adqVar.f() != ads.NULL) {
                return new StringBuilder(adqVar.h());
            }
            adqVar.j();
            return null;
        }

        @Override // defpackage.ack
        public void a(adt adtVar, StringBuilder sb) throws IOException {
            adtVar.b(sb == null ? null : sb.toString());
        }
    };
    public static final acl x = a(StringBuilder.class, w);
    public static final ack<StringBuffer> y = new ack<StringBuffer>() { // from class: ado.7
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuffer b(adq adqVar) {
            if (adqVar.f() != ads.NULL) {
                return new StringBuffer(adqVar.h());
            }
            adqVar.j();
            return null;
        }

        @Override // defpackage.ack
        public void a(adt adtVar, StringBuffer stringBuffer) throws IOException {
            adtVar.b(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final acl z = a(StringBuffer.class, y);
    public static final ack<URL> A = new ack<URL>() { // from class: ado.8
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public URL b(adq adqVar) {
            if (adqVar.f() == ads.NULL) {
                adqVar.j();
                return null;
            }
            String strH = adqVar.h();
            if ("null".equals(strH)) {
                return null;
            }
            return new URL(strH);
        }

        @Override // defpackage.ack
        public void a(adt adtVar, URL url) throws IOException {
            adtVar.b(url == null ? null : url.toExternalForm());
        }
    };
    public static final acl B = a(URL.class, A);
    public static final ack<URI> C = new ack<URI>() { // from class: ado.9
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public URI b(adq adqVar) {
            if (adqVar.f() == ads.NULL) {
                adqVar.j();
                return null;
            }
            try {
                String strH = adqVar.h();
                if ("null".equals(strH)) {
                    return null;
                }
                return new URI(strH);
            } catch (URISyntaxException e2) {
                throw new acb(e2);
            }
        }

        @Override // defpackage.ack
        public void a(adt adtVar, URI uri) throws IOException {
            adtVar.b(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final acl D = a(URI.class, C);
    public static final ack<InetAddress> E = new ack<InetAddress>() { // from class: ado.10
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InetAddress b(adq adqVar) {
            if (adqVar.f() != ads.NULL) {
                return InetAddress.getByName(adqVar.h());
            }
            adqVar.j();
            return null;
        }

        @Override // defpackage.ack
        public void a(adt adtVar, InetAddress inetAddress) throws IOException {
            adtVar.b(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final acl F = b(InetAddress.class, E);
    public static final ack<UUID> G = new ack<UUID>() { // from class: ado.11
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UUID b(adq adqVar) {
            if (adqVar.f() != ads.NULL) {
                return UUID.fromString(adqVar.h());
            }
            adqVar.j();
            return null;
        }

        @Override // defpackage.ack
        public void a(adt adtVar, UUID uuid) throws IOException {
            adtVar.b(uuid == null ? null : uuid.toString());
        }
    };
    public static final acl H = a(UUID.class, G);
    public static final acl I = new acl() { // from class: ado.13
        @Override // defpackage.acl
        public <T> ack<T> a(abw abwVar, adp<T> adpVar) {
            if (adpVar.a() != Timestamp.class) {
                return null;
            }
            final ack<T> ackVarA = abwVar.a((Class) Date.class);
            return (ack<T>) new ack<Timestamp>() { // from class: ado.13.1
                @Override // defpackage.ack
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Timestamp b(adq adqVar) {
                    Date date = (Date) ackVarA.b(adqVar);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                @Override // defpackage.ack
                public void a(adt adtVar, Timestamp timestamp) {
                    ackVarA.a(adtVar, timestamp);
                }
            };
        }
    };
    public static final ack<Calendar> J = new ack<Calendar>() { // from class: ado.14
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Calendar b(adq adqVar) throws adu {
            int i2 = 0;
            if (adqVar.f() == ads.NULL) {
                adqVar.j();
                return null;
            }
            adqVar.c();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (adqVar.f() != ads.END_OBJECT) {
                String strG = adqVar.g();
                int iM = adqVar.m();
                if ("year".equals(strG)) {
                    i7 = iM;
                } else if ("month".equals(strG)) {
                    i6 = iM;
                } else if ("dayOfMonth".equals(strG)) {
                    i5 = iM;
                } else if ("hourOfDay".equals(strG)) {
                    i4 = iM;
                } else if ("minute".equals(strG)) {
                    i3 = iM;
                } else if ("second".equals(strG)) {
                    i2 = iM;
                }
            }
            adqVar.d();
            return new GregorianCalendar(i7, i6, i5, i4, i3, i2);
        }

        @Override // defpackage.ack
        public void a(adt adtVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                adtVar.f();
                return;
            }
            adtVar.d();
            adtVar.a("year");
            adtVar.a(calendar.get(1));
            adtVar.a("month");
            adtVar.a(calendar.get(2));
            adtVar.a("dayOfMonth");
            adtVar.a(calendar.get(5));
            adtVar.a("hourOfDay");
            adtVar.a(calendar.get(11));
            adtVar.a("minute");
            adtVar.a(calendar.get(12));
            adtVar.a("second");
            adtVar.a(calendar.get(13));
            adtVar.e();
        }
    };
    public static final acl K = b(Calendar.class, GregorianCalendar.class, J);
    public static final ack<Locale> L = new ack<Locale>() { // from class: ado.15
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Locale b(adq adqVar) {
            if (adqVar.f() == ads.NULL) {
                adqVar.j();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(adqVar.h(), "_");
            String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (strNextToken2 == null && strNextToken3 == null) {
                return new Locale(strNextToken);
            }
            if (strNextToken3 == null) {
                return new Locale(strNextToken, strNextToken2);
            }
            return new Locale(strNextToken, strNextToken2, strNextToken3);
        }

        @Override // defpackage.ack
        public void a(adt adtVar, Locale locale) throws IOException {
            adtVar.b(locale == null ? null : locale.toString());
        }
    };
    public static final acl M = a(Locale.class, L);
    public static final ack<aca> N = new ack<aca>() { // from class: ado.16
        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public aca b(adq adqVar) {
            switch (AnonymousClass23.a[adqVar.f().ordinal()]) {
                case 1:
                    return new acg(new acw(adqVar.h()));
                case 2:
                    return new acg(Boolean.valueOf(adqVar.i()));
                case 3:
                    return new acg(adqVar.h());
                case 4:
                    adqVar.j();
                    return acc.a;
                case 5:
                    aby abyVar = new aby();
                    adqVar.a();
                    while (adqVar.e()) {
                        abyVar.a(b(adqVar));
                    }
                    adqVar.b();
                    return abyVar;
                case 6:
                    acd acdVar = new acd();
                    adqVar.c();
                    while (adqVar.e()) {
                        acdVar.a(adqVar.g(), b(adqVar));
                    }
                    adqVar.d();
                    return acdVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // defpackage.ack
        public void a(adt adtVar, aca acaVar) throws IOException {
            if (acaVar == null || acaVar.k()) {
                adtVar.f();
                return;
            }
            if (acaVar.j()) {
                acg acgVarN = acaVar.n();
                if (acgVarN.p()) {
                    adtVar.a(acgVarN.b());
                    return;
                } else if (acgVarN.a()) {
                    adtVar.a(acgVarN.g());
                    return;
                } else {
                    adtVar.b(acgVarN.c());
                    return;
                }
            }
            if (acaVar.h()) {
                adtVar.b();
                Iterator<aca> it = acaVar.m().iterator();
                while (it.hasNext()) {
                    a(adtVar, it.next());
                }
                adtVar.c();
                return;
            }
            if (acaVar.i()) {
                adtVar.d();
                for (Map.Entry<String, aca> entry : acaVar.l().a()) {
                    adtVar.a(entry.getKey());
                    a(adtVar, entry.getValue());
                }
                adtVar.e();
                return;
            }
            throw new IllegalArgumentException("Couldn't write " + acaVar.getClass());
        }
    };
    public static final acl O = a(aca.class, N);
    public static final acl P = a();

    static final class a<T extends Enum<T>> extends ack<T> {
        private final Map<String, T> a = new HashMap();
        private final Map<T, String> b = new HashMap();

        public a(Class<T> cls) {
            try {
                for (T t : cls.getEnumConstants()) {
                    String strName = t.name();
                    acn acnVar = (acn) cls.getField(strName).getAnnotation(acn.class);
                    String strA = acnVar != null ? acnVar.a() : strName;
                    this.a.put(strA, t);
                    this.b.put(t, strA);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError();
            }
        }

        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public T b(adq adqVar) {
            if (adqVar.f() != ads.NULL) {
                return this.a.get(adqVar.h());
            }
            adqVar.j();
            return null;
        }

        @Override // defpackage.ack
        public void a(adt adtVar, T t) throws IOException {
            adtVar.b(t == null ? null : this.b.get(t));
        }
    }

    public static <TT> acl a() {
        return new acl() { // from class: ado.17
            @Override // defpackage.acl
            public <T> ack<T> a(abw abwVar, adp<T> adpVar) {
                Class<? super T> clsA = adpVar.a();
                if (!Enum.class.isAssignableFrom(clsA) || clsA == Enum.class) {
                    return null;
                }
                if (!clsA.isEnum()) {
                    clsA = clsA.getSuperclass();
                }
                return new a(clsA);
            }
        };
    }

    public static <TT> acl a(final Class<TT> cls, final ack<TT> ackVar) {
        return new acl() { // from class: ado.18
            @Override // defpackage.acl
            public <T> ack<T> a(abw abwVar, adp<T> adpVar) {
                if (adpVar.a() == cls) {
                    return ackVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + ackVar + "]";
            }
        };
    }

    public static <TT> acl a(final Class<TT> cls, final Class<TT> cls2, final ack<? super TT> ackVar) {
        return new acl() { // from class: ado.19
            @Override // defpackage.acl
            public <T> ack<T> a(abw abwVar, adp<T> adpVar) {
                Class<? super T> clsA = adpVar.a();
                if (clsA == cls || clsA == cls2) {
                    return ackVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + ackVar + "]";
            }
        };
    }

    public static <TT> acl b(final Class<TT> cls, final Class<? extends TT> cls2, final ack<? super TT> ackVar) {
        return new acl() { // from class: ado.20
            @Override // defpackage.acl
            public <T> ack<T> a(abw abwVar, adp<T> adpVar) {
                Class<? super T> clsA = adpVar.a();
                if (clsA == cls || clsA == cls2) {
                    return ackVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + ackVar + "]";
            }
        };
    }

    public static <TT> acl b(final Class<TT> cls, final ack<TT> ackVar) {
        return new acl() { // from class: ado.21
            @Override // defpackage.acl
            public <T> ack<T> a(abw abwVar, adp<T> adpVar) {
                if (cls.isAssignableFrom(adpVar.a())) {
                    return ackVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + ackVar + "]";
            }
        };
    }
}
