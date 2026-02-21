package defpackage;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class brx {
    private static final ThreadLocal<Set<Object<brz, brz>>> a = new ThreadLocal<>();
    private boolean b = true;

    public brx a(Object obj, Object obj2) {
        if (this.b && obj != obj2) {
            if (obj == null || obj2 == null) {
                a(false);
            } else if (!obj.getClass().isArray()) {
                this.b = obj.equals(obj2);
            } else if (obj.getClass() != obj2.getClass()) {
                a(false);
            } else if (obj instanceof long[]) {
                a((long[]) obj, (long[]) obj2);
            } else if (obj instanceof int[]) {
                a((int[]) obj, (int[]) obj2);
            } else if (obj instanceof short[]) {
                a((short[]) obj, (short[]) obj2);
            } else if (obj instanceof char[]) {
                a((char[]) obj, (char[]) obj2);
            } else if (obj instanceof byte[]) {
                a((byte[]) obj, (byte[]) obj2);
            } else if (obj instanceof double[]) {
                a((double[]) obj, (double[]) obj2);
            } else if (obj instanceof float[]) {
                a((float[]) obj, (float[]) obj2);
            } else if (obj instanceof boolean[]) {
                a((boolean[]) obj, (boolean[]) obj2);
            } else {
                a((Object[]) obj, (Object[]) obj2);
            }
        }
        return this;
    }

    public brx a(long j, long j2) {
        if (this.b) {
            this.b = j == j2;
        }
        return this;
    }

    public brx a(int i, int i2) {
        if (this.b) {
            this.b = i == i2;
        }
        return this;
    }

    public brx a(short s, short s2) {
        if (this.b) {
            this.b = s == s2;
        }
        return this;
    }

    public brx a(char c, char c2) {
        if (this.b) {
            this.b = c == c2;
        }
        return this;
    }

    public brx a(byte b, byte b2) {
        if (this.b) {
            this.b = b == b2;
        }
        return this;
    }

    public brx a(double d, double d2) {
        return !this.b ? this : a(Double.doubleToLongBits(d), Double.doubleToLongBits(d2));
    }

    public brx a(float f, float f2) {
        return !this.b ? this : a(Float.floatToIntBits(f), Float.floatToIntBits(f2));
    }

    public brx a(boolean z, boolean z2) {
        if (this.b) {
            this.b = z == z2;
        }
        return this;
    }

    public brx a(Object[] objArr, Object[] objArr2) {
        if (this.b && objArr != objArr2) {
            if (objArr == null || objArr2 == null || objArr.length != objArr2.length) {
                a(false);
            } else {
                for (int i = 0; i < objArr.length && this.b; i++) {
                    a(objArr[i], objArr2[i]);
                }
            }
        }
        return this;
    }

    public brx a(long[] jArr, long[] jArr2) {
        if (this.b && jArr != jArr2) {
            if (jArr == null || jArr2 == null || jArr.length != jArr2.length) {
                a(false);
            } else {
                for (int i = 0; i < jArr.length && this.b; i++) {
                    a(jArr[i], jArr2[i]);
                }
            }
        }
        return this;
    }

    public brx a(int[] iArr, int[] iArr2) {
        if (this.b && iArr != iArr2) {
            if (iArr == null || iArr2 == null || iArr.length != iArr2.length) {
                a(false);
            } else {
                for (int i = 0; i < iArr.length && this.b; i++) {
                    a(iArr[i], iArr2[i]);
                }
            }
        }
        return this;
    }

    public brx a(short[] sArr, short[] sArr2) {
        if (this.b && sArr != sArr2) {
            if (sArr == null || sArr2 == null || sArr.length != sArr2.length) {
                a(false);
            } else {
                for (int i = 0; i < sArr.length && this.b; i++) {
                    a(sArr[i], sArr2[i]);
                }
            }
        }
        return this;
    }

    public brx a(char[] cArr, char[] cArr2) {
        if (this.b && cArr != cArr2) {
            if (cArr == null || cArr2 == null || cArr.length != cArr2.length) {
                a(false);
            } else {
                for (int i = 0; i < cArr.length && this.b; i++) {
                    a(cArr[i], cArr2[i]);
                }
            }
        }
        return this;
    }

    public brx a(byte[] bArr, byte[] bArr2) {
        if (this.b && bArr != bArr2) {
            if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
                a(false);
            } else {
                for (int i = 0; i < bArr.length && this.b; i++) {
                    a(bArr[i], bArr2[i]);
                }
            }
        }
        return this;
    }

    public brx a(double[] dArr, double[] dArr2) {
        if (this.b && dArr != dArr2) {
            if (dArr == null || dArr2 == null || dArr.length != dArr2.length) {
                a(false);
            } else {
                for (int i = 0; i < dArr.length && this.b; i++) {
                    a(dArr[i], dArr2[i]);
                }
            }
        }
        return this;
    }

    public brx a(float[] fArr, float[] fArr2) {
        if (this.b && fArr != fArr2) {
            if (fArr == null || fArr2 == null || fArr.length != fArr2.length) {
                a(false);
            } else {
                for (int i = 0; i < fArr.length && this.b; i++) {
                    a(fArr[i], fArr2[i]);
                }
            }
        }
        return this;
    }

    public brx a(boolean[] zArr, boolean[] zArr2) {
        if (this.b && zArr != zArr2) {
            if (zArr == null || zArr2 == null || zArr.length != zArr2.length) {
                a(false);
            } else {
                for (int i = 0; i < zArr.length && this.b; i++) {
                    a(zArr[i], zArr2[i]);
                }
            }
        }
        return this;
    }

    public boolean a() {
        return this.b;
    }

    protected void a(boolean z) {
        this.b = z;
    }
}
