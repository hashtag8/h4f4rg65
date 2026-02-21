package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class ee {

    public interface a<T> {
        T a();

        boolean a(T t);
    }

    public static class b<T> implements a<T> {
        private final Object[] a;
        private int b;

        public b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.a = new Object[i];
        }

        @Override // ee.a
        public T a() {
            if (this.b <= 0) {
                return null;
            }
            int i = this.b - 1;
            T t = (T) this.a[i];
            this.a[i] = null;
            this.b--;
            return t;
        }

        @Override // ee.a
        public boolean a(T t) {
            if (b(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            if (this.b >= this.a.length) {
                return false;
            }
            this.a[this.b] = t;
            this.b++;
            return true;
        }

        private boolean b(T t) {
            for (int i = 0; i < this.b; i++) {
                if (this.a[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class c<T> extends b<T> {
        private final Object a;

        public c(int i) {
            super(i);
            this.a = new Object();
        }

        @Override // ee.b, ee.a
        public T a() {
            T t;
            synchronized (this.a) {
                t = (T) super.a();
            }
            return t;
        }

        @Override // ee.b, ee.a
        public boolean a(T t) {
            boolean zA;
            synchronized (this.a) {
                zA = super.a(t);
            }
            return zA;
        }
    }
}
