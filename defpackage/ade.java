package defpackage;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class ade implements acl {
    private final acs a;

    public ade(acs acsVar) {
        this.a = acsVar;
    }

    @Override // defpackage.acl
    public <T> ack<T> a(abw abwVar, adp<T> adpVar) {
        Type typeB = adpVar.b();
        Class<? super T> clsA = adpVar.a();
        if (!Collection.class.isAssignableFrom(clsA)) {
            return null;
        }
        Type typeA = acr.a(typeB, (Class<?>) clsA);
        return new a(abwVar, typeA, abwVar.a((adp) adp.a(typeA)), this.a.a(adpVar));
    }

    final class a<E> extends ack<Collection<E>> {
        private final ack<E> b;
        private final acx<? extends Collection<E>> c;

        public a(abw abwVar, Type type, ack<E> ackVar, acx<? extends Collection<E>> acxVar) {
            this.b = new adn(abwVar, ackVar, type);
            this.c = acxVar;
        }

        @Override // defpackage.ack
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<E> b(adq adqVar) {
            if (adqVar.f() == ads.NULL) {
                adqVar.j();
                return null;
            }
            Collection<E> collectionA = this.c.a();
            adqVar.a();
            while (adqVar.e()) {
                collectionA.add(this.b.b(adqVar));
            }
            adqVar.b();
            return collectionA;
        }

        @Override // defpackage.ack
        public void a(adt adtVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                adtVar.f();
                return;
            }
            adtVar.b();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.b.a(adtVar, it.next());
            }
            adtVar.c();
        }
    }
}
