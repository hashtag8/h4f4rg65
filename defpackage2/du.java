package defpackage;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class du<K, V> extends eg<K, V> implements Map<K, V> {
    eb<K, V> a;

    public du() {
    }

    public du(int i) {
        super(i);
    }

    private eb<K, V> b() {
        if (this.a == null) {
            this.a = new eb<K, V>() { // from class: du.1
                @Override // defpackage.eb
                protected int a() {
                    return du.this.h;
                }

                @Override // defpackage.eb
                protected Object a(int i, int i2) {
                    return du.this.g[(i << 1) + i2];
                }

                @Override // defpackage.eb
                protected int a(Object obj) {
                    return du.this.a(obj);
                }

                @Override // defpackage.eb
                protected int b(Object obj) {
                    return du.this.b(obj);
                }

                @Override // defpackage.eb
                protected Map<K, V> b() {
                    return du.this;
                }

                @Override // defpackage.eb
                protected void a(K k, V v) {
                    du.this.put(k, v);
                }

                @Override // defpackage.eb
                protected V a(int i, V v) {
                    return du.this.a(i, v);
                }

                @Override // defpackage.eb
                protected void a(int i) {
                    du.this.d(i);
                }

                @Override // defpackage.eb
                protected void c() {
                    du.this.clear();
                }
            };
        }
        return this.a;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        a(this.h + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean a(Collection<?> collection) {
        return eb.c(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return b().d();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return b().e();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return b().f();
    }
}
