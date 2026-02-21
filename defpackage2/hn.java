package defpackage;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class hn {
    ff b;
    private Interpolator d;
    private boolean e;
    private long c = -1;
    private final fg f = new fg() { // from class: hn.1
        private boolean b = false;
        private int c = 0;

        @Override // defpackage.fg, defpackage.ff
        public void a(View view) {
            if (!this.b) {
                this.b = true;
                if (hn.this.b != null) {
                    hn.this.b.a(null);
                }
            }
        }

        void a() {
            this.c = 0;
            this.b = false;
            hn.this.b();
        }

        @Override // defpackage.fg, defpackage.ff
        public void b(View view) {
            int i = this.c + 1;
            this.c = i;
            if (i == hn.this.a.size()) {
                if (hn.this.b != null) {
                    hn.this.b.b(null);
                }
                a();
            }
        }
    };
    final ArrayList<fe> a = new ArrayList<>();

    public hn a(fe feVar) {
        if (!this.e) {
            this.a.add(feVar);
        }
        return this;
    }

    public hn a(fe feVar, fe feVar2) {
        this.a.add(feVar);
        feVar2.b(feVar.a());
        this.a.add(feVar2);
        return this;
    }

    public void a() {
        if (!this.e) {
            for (fe feVar : this.a) {
                if (this.c >= 0) {
                    feVar.a(this.c);
                }
                if (this.d != null) {
                    feVar.a(this.d);
                }
                if (this.b != null) {
                    feVar.a(this.f);
                }
                feVar.c();
            }
            this.e = true;
        }
    }

    void b() {
        this.e = false;
    }

    public void c() {
        if (this.e) {
            Iterator<fe> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.e = false;
        }
    }

    public hn a(long j) {
        if (!this.e) {
            this.c = j;
        }
        return this;
    }

    public hn a(Interpolator interpolator) {
        if (!this.e) {
            this.d = interpolator;
        }
        return this;
    }

    public hn a(ff ffVar) {
        if (!this.e) {
            this.b = ffVar;
        }
        return this;
    }
}
