package defpackage;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public final class acw extends Number {
    private final String a;

    public acw(String str) {
        this.a = str;
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            return Integer.parseInt(this.a);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.a);
            } catch (NumberFormatException e2) {
                return new BigInteger(this.a).intValue();
            }
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.a);
        } catch (NumberFormatException e) {
            return new BigInteger(this.a).longValue();
        }
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.a);
    }

    public String toString() {
        return this.a;
    }
}
