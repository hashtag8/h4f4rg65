package defpackage;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public final class acg extends aca {
    private static final Class<?>[] a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object b;

    public acg(Boolean bool) {
        a(bool);
    }

    public acg(Number number) {
        a(number);
    }

    public acg(String str) {
        a(str);
    }

    void a(Object obj) {
        if (obj instanceof Character) {
            this.b = String.valueOf(((Character) obj).charValue());
        } else {
            acq.a((obj instanceof Number) || b(obj));
            this.b = obj;
        }
    }

    public boolean a() {
        return this.b instanceof Boolean;
    }

    @Override // defpackage.aca
    Boolean o() {
        return (Boolean) this.b;
    }

    @Override // defpackage.aca
    public boolean g() {
        return a() ? o().booleanValue() : Boolean.parseBoolean(c());
    }

    public boolean p() {
        return this.b instanceof Number;
    }

    @Override // defpackage.aca
    public Number b() {
        return this.b instanceof String ? new acw((String) this.b) : (Number) this.b;
    }

    public boolean q() {
        return this.b instanceof String;
    }

    @Override // defpackage.aca
    public String c() {
        if (p()) {
            return b().toString();
        }
        if (a()) {
            return o().toString();
        }
        return (String) this.b;
    }

    @Override // defpackage.aca
    public double d() {
        return p() ? b().doubleValue() : Double.parseDouble(c());
    }

    @Override // defpackage.aca
    public long e() {
        return p() ? b().longValue() : Long.parseLong(c());
    }

    @Override // defpackage.aca
    public int f() {
        return p() ? b().intValue() : Integer.parseInt(c());
    }

    private static boolean b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : a) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.b == null) {
            return 31;
        }
        if (a(this)) {
            long jLongValue = b().longValue();
            return (int) (jLongValue ^ (jLongValue >>> 32));
        }
        if (this.b instanceof Number) {
            long jDoubleToLongBits = Double.doubleToLongBits(b().doubleValue());
            return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
        }
        return this.b.hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        acg acgVar = (acg) obj;
        if (this.b == null) {
            return acgVar.b == null;
        }
        if (a(this) && a(acgVar)) {
            return b().longValue() == acgVar.b().longValue();
        }
        if ((this.b instanceof Number) && (acgVar.b instanceof Number)) {
            double dDoubleValue = b().doubleValue();
            double dDoubleValue2 = acgVar.b().doubleValue();
            if (dDoubleValue == dDoubleValue2 || (Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2))) {
                z = true;
            }
            return z;
        }
        return this.b.equals(acgVar.b);
    }

    private static boolean a(acg acgVar) {
        if (!(acgVar.b instanceof Number)) {
            return false;
        }
        Number number = (Number) acgVar.b;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }
}
