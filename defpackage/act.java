package defpackage;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class act implements acl, Cloneable {
    public static final act a = new act();
    private boolean e;
    private double b = -1.0d;
    private int c = 136;
    private boolean d = true;
    private List<abs> f = Collections.emptyList();
    private List<abs> g = Collections.emptyList();

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public act clone() {
        try {
            return (act) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override // defpackage.acl
    public <T> ack<T> a(final abw abwVar, final adp<T> adpVar) {
        Class<? super T> clsA = adpVar.a();
        final boolean zA = a((Class<?>) clsA, true);
        final boolean zA2 = a((Class<?>) clsA, false);
        if (zA || zA2) {
            return new ack<T>() { // from class: act.1
                private ack<T> f;

                @Override // defpackage.ack
                public T b(adq adqVar) {
                    if (!zA2) {
                        return a().b(adqVar);
                    }
                    adqVar.n();
                    return null;
                }

                @Override // defpackage.ack
                public void a(adt adtVar, T t) throws IOException {
                    if (zA) {
                        adtVar.f();
                    } else {
                        a().a(adtVar, t);
                    }
                }

                private ack<T> a() {
                    ack<T> ackVar = this.f;
                    if (ackVar != null) {
                        return ackVar;
                    }
                    ack<T> ackVarA = acu.a.a(abwVar, act.this, adpVar);
                    this.f = ackVarA;
                    return ackVarA;
                }
            };
        }
        return null;
    }

    public boolean a(Field field, boolean z) {
        acm acmVar;
        if ((this.c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.b == -1.0d || a((aco) field.getAnnotation(aco.class), (acp) field.getAnnotation(acp.class))) && !field.isSynthetic()) {
            if (this.e && ((acmVar = (acm) field.getAnnotation(acm.class)) == null || (!z ? acmVar.b() : acmVar.a()))) {
                return true;
            }
            if ((this.d || !b(field.getType())) && !a(field.getType())) {
                List<abs> list = z ? this.f : this.g;
                if (!list.isEmpty()) {
                    abt abtVar = new abt(field);
                    Iterator<abs> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next().a(abtVar)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean a(Class<?> cls, boolean z) {
        if (this.b != -1.0d && !a((aco) cls.getAnnotation(aco.class), (acp) cls.getAnnotation(acp.class))) {
            return true;
        }
        if ((this.d || !b(cls)) && !a(cls)) {
            Iterator<abs> it = (z ? this.f : this.g).iterator();
            while (it.hasNext()) {
                if (it.next().a(cls)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private boolean a(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean b(Class<?> cls) {
        return cls.isMemberClass() && !c(cls);
    }

    private boolean c(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean a(aco acoVar, acp acpVar) {
        return a(acoVar) && a(acpVar);
    }

    private boolean a(aco acoVar) {
        return acoVar == null || acoVar.a() <= this.b;
    }

    private boolean a(acp acpVar) {
        return acpVar == null || acpVar.a() > this.b;
    }
}
