package defpackage;

import defpackage.b;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class a<K, V> extends b<K, V> {
    private HashMap<K, b.c<K, V>> a = new HashMap<>();

    public boolean a(K k) {
        return this.a.containsKey(k);
    }
}
