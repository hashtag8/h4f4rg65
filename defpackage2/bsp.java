package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class bsp {
    static final Object a = "y";
    static final Object b = "M";
    static final Object c = "d";
    static final Object d = "H";
    static final Object e = "m";
    static final Object f = "s";
    static final Object g = "S";

    public static String a(long j) {
        return a(j, "H:mm:ss.SSS");
    }

    public static String a(long j, String str) {
        return a(j, str, true);
    }

    public static String a(long j, String str, boolean z) {
        a[] aVarArrA = a(str);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        if (a.a(aVarArrA, c)) {
            i = (int) (j / 86400000);
            j -= ((long) i) * 86400000;
        }
        if (a.a(aVarArrA, d)) {
            i2 = (int) (j / 3600000);
            j -= ((long) i2) * 3600000;
        }
        if (a.a(aVarArrA, e)) {
            i3 = (int) (j / 60000);
            j -= ((long) i3) * 60000;
        }
        if (a.a(aVarArrA, f)) {
            i4 = (int) (j / 1000);
            j -= ((long) i4) * 1000;
        }
        if (a.a(aVarArrA, g)) {
            i5 = (int) j;
        }
        return a(aVarArrA, 0, 0, i, i2, i3, i4, i5, z);
    }

    static String a(a[] aVarArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        int i8;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z2 = false;
        int i9 = i7;
        for (a aVar : aVarArr) {
            Object objC = aVar.c();
            int iB = aVar.b();
            if (objC instanceof StringBuffer) {
                stringBuffer.append(objC.toString());
            } else if (objC == a) {
                stringBuffer.append(z ? bru.a(Integer.toString(i), iB, '0') : Integer.toString(i));
                z2 = false;
            } else if (objC == b) {
                stringBuffer.append(z ? bru.a(Integer.toString(i2), iB, '0') : Integer.toString(i2));
                z2 = false;
            } else if (objC == c) {
                stringBuffer.append(z ? bru.a(Integer.toString(i3), iB, '0') : Integer.toString(i3));
                z2 = false;
            } else if (objC == d) {
                stringBuffer.append(z ? bru.a(Integer.toString(i4), iB, '0') : Integer.toString(i4));
                z2 = false;
            } else if (objC == e) {
                stringBuffer.append(z ? bru.a(Integer.toString(i5), iB, '0') : Integer.toString(i5));
                z2 = false;
            } else if (objC == f) {
                stringBuffer.append(z ? bru.a(Integer.toString(i6), iB, '0') : Integer.toString(i6));
                z2 = true;
            } else if (objC == g) {
                if (z2) {
                    int i10 = i9 + 1000;
                    stringBuffer.append((z ? bru.a(Integer.toString(i10), iB, '0') : Integer.toString(i10)).substring(1));
                    i8 = i10;
                } else {
                    stringBuffer.append(z ? bru.a(Integer.toString(i9), iB, '0') : Integer.toString(i9));
                    i8 = i9;
                }
                i9 = i8;
                z2 = false;
            }
        }
        return stringBuffer.toString();
    }

    static a[] a(String str) {
        Object obj;
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList(charArray.length);
        a aVar = null;
        StringBuffer stringBuffer = null;
        boolean z = false;
        for (char c2 : charArray) {
            if (z && c2 != '\'') {
                stringBuffer.append(c2);
            } else {
                switch (c2) {
                    case '\'':
                        if (z) {
                            obj = null;
                            stringBuffer = null;
                            z = false;
                        } else {
                            stringBuffer = new StringBuffer();
                            arrayList.add(new a(stringBuffer));
                            z = true;
                            obj = null;
                        }
                        break;
                    case 'H':
                        obj = d;
                        break;
                    case 'M':
                        obj = b;
                        break;
                    case 'S':
                        obj = g;
                        break;
                    case 'd':
                        obj = c;
                        break;
                    case 'm':
                        obj = e;
                        break;
                    case 's':
                        obj = f;
                        break;
                    case 'y':
                        obj = a;
                        break;
                    default:
                        if (stringBuffer == null) {
                            stringBuffer = new StringBuffer();
                            arrayList.add(new a(stringBuffer));
                        }
                        stringBuffer.append(c2);
                        obj = null;
                        break;
                }
                if (obj != null) {
                    if (aVar != null && aVar.c() == obj) {
                        aVar.a();
                    } else {
                        aVar = new a(obj);
                        arrayList.add(aVar);
                    }
                    stringBuffer = null;
                }
            }
        }
        return (a[]) arrayList.toArray(new a[arrayList.size()]);
    }

    static class a {
        private final Object a;
        private int b = 1;

        static boolean a(a[] aVarArr, Object obj) {
            for (a aVar : aVarArr) {
                if (aVar.c() == obj) {
                    return true;
                }
            }
            return false;
        }

        a(Object obj) {
            this.a = obj;
        }

        void a() {
            this.b++;
        }

        int b() {
            return this.b;
        }

        Object c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.a.getClass() != aVar.a.getClass() || this.b != aVar.b) {
                return false;
            }
            if (this.a instanceof StringBuffer) {
                return this.a.toString().equals(aVar.a.toString());
            }
            if (this.a instanceof Number) {
                return this.a.equals(aVar.a);
            }
            return this.a == aVar.a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return bru.a(this.a.toString(), this.b);
        }
    }
}
