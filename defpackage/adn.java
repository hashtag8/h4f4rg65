package defpackage;

import defpackage.adk;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes.dex */
final class adn<T> extends ack<T> {
    private final abw a;
    private final ack<T> b;
    private final Type c;

    adn(abw abwVar, ack<T> ackVar, Type type) {
        this.a = abwVar;
        this.b = ackVar;
        this.c = type;
    }

    @Override // defpackage.ack
    public T b(adq adqVar) {
        return this.b.b(adqVar);
    }

    @Override // defpackage.ack
    public void a(adt adtVar, T t) {
        ack<T> ackVarA = this.b;
        Type typeA = a(this.c, t);
        if (typeA != this.c) {
            ackVarA = this.a.a((adp) adp.a(typeA));
            if ((ackVarA instanceof adk.a) && !(this.b instanceof adk.a)) {
                ackVarA = this.b;
            }
        }
        ackVarA.a(adtVar, t);
    }

    private Type a(Type type, Object obj) {
        if (obj == null) {
            return type;
        }
        if (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) {
            return obj.getClass();
        }
        return type;
    }
}
