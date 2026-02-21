package defpackage;

import android.content.Context;
import defpackage.aan;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@yx
public class zi {
    private static aaf b;
    private static final Object c = new Object();
    public static final a<Void> a = new a() { // from class: zi.1
    };

    public interface a<T> {
    }

    class b<T> extends zl<T> implements aan.b<T> {
        private b() {
        }

        @Override // aan.b
        public void a(T t) {
            super.b(t);
        }
    }

    public zi(Context context) {
        b = a(context);
    }

    private static aaf a(Context context) {
        aaf aafVar;
        synchronized (c) {
            if (b == null) {
                b = wg.a(context.getApplicationContext());
            }
            aafVar = b;
        }
        return aafVar;
    }

    public zm<String> a(final String str, final Map<String, String> map) {
        final b bVar = new b();
        b.a(new wf(str, bVar, new aan.a() { // from class: zi.2
            @Override // aan.a
            public void a(abj abjVar) {
                su.e("Failed to load URL: " + str + "\n" + abjVar.toString());
                bVar.a(null);
            }
        }) { // from class: zi.3
            @Override // defpackage.aac
            public Map<String, String> a() {
                return map == null ? super.a() : map;
            }
        });
        return bVar;
    }
}
