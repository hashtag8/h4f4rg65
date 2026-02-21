package defpackage;

import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class aca {
    public boolean h() {
        return this instanceof aby;
    }

    public boolean i() {
        return this instanceof acd;
    }

    public boolean j() {
        return this instanceof acg;
    }

    public boolean k() {
        return this instanceof acc;
    }

    public acd l() {
        if (i()) {
            return (acd) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public aby m() {
        if (h()) {
            return (aby) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public acg n() {
        if (j()) {
            return (acg) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public boolean g() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean o() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            adt adtVar = new adt(stringWriter);
            adtVar.b(true);
            acz.a(this, adtVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
