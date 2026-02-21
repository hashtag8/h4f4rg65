package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class jr extends kl {
    private static TimeInterpolator i;
    private ArrayList<RecyclerView.v> j = new ArrayList<>();
    private ArrayList<RecyclerView.v> k = new ArrayList<>();
    private ArrayList<b> l = new ArrayList<>();
    private ArrayList<a> m = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.v>> a = new ArrayList<>();
    ArrayList<ArrayList<b>> b = new ArrayList<>();
    ArrayList<ArrayList<a>> c = new ArrayList<>();
    ArrayList<RecyclerView.v> d = new ArrayList<>();
    ArrayList<RecyclerView.v> e = new ArrayList<>();
    ArrayList<RecyclerView.v> f = new ArrayList<>();
    ArrayList<RecyclerView.v> g = new ArrayList<>();

    static class b {
        public RecyclerView.v a;
        public int b;
        public int c;
        public int d;
        public int e;

        b(RecyclerView.v vVar, int i, int i2, int i3, int i4) {
            this.a = vVar;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    static class a {
        public RecyclerView.v a;
        public RecyclerView.v b;
        public int c;
        public int d;
        public int e;
        public int f;

        private a(RecyclerView.v vVar, RecyclerView.v vVar2) {
            this.a = vVar;
            this.b = vVar2;
        }

        a(RecyclerView.v vVar, RecyclerView.v vVar2, int i, int i2, int i3, int i4) {
            this(vVar, vVar2);
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
        }
    }

    @Override // android.support.v7.widget.RecyclerView.e
    public void a() {
        boolean z = !this.j.isEmpty();
        boolean z2 = !this.l.isEmpty();
        boolean z3 = !this.m.isEmpty();
        boolean z4 = !this.k.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.v> it = this.j.iterator();
            while (it.hasNext()) {
                u(it.next());
            }
            this.j.clear();
            if (z2) {
                final ArrayList<b> arrayList = new ArrayList<>();
                arrayList.addAll(this.l);
                this.b.add(arrayList);
                this.l.clear();
                Runnable runnable = new Runnable() { // from class: jr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (b bVar : arrayList) {
                            jr.this.b(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e);
                        }
                        arrayList.clear();
                        jr.this.b.remove(arrayList);
                    }
                };
                if (z) {
                    fb.a(arrayList.get(0).a.a, runnable, g());
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final ArrayList<a> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.m);
                this.c.add(arrayList2);
                this.m.clear();
                Runnable runnable2 = new Runnable() { // from class: jr.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            jr.this.a((a) it2.next());
                        }
                        arrayList2.clear();
                        jr.this.c.remove(arrayList2);
                    }
                };
                if (z) {
                    fb.a(arrayList2.get(0).a.a, runnable2, g());
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                final ArrayList<RecyclerView.v> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.k);
                this.a.add(arrayList3);
                this.k.clear();
                Runnable runnable3 = new Runnable() { // from class: jr.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            jr.this.c((RecyclerView.v) it2.next());
                        }
                        arrayList3.clear();
                        jr.this.a.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    fb.a(arrayList3.get(0).a, runnable3, (z ? g() : 0L) + Math.max(z2 ? e() : 0L, z3 ? h() : 0L));
                } else {
                    runnable3.run();
                }
            }
        }
    }

    @Override // defpackage.kl
    public boolean a(RecyclerView.v vVar) {
        v(vVar);
        this.j.add(vVar);
        return true;
    }

    private void u(final RecyclerView.v vVar) {
        final View view = vVar.a;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f.add(vVar);
        viewPropertyAnimatorAnimate.setDuration(g()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: jr.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                jr.this.l(vVar);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                view.setAlpha(1.0f);
                jr.this.i(vVar);
                jr.this.f.remove(vVar);
                jr.this.c();
            }
        }).start();
    }

    @Override // defpackage.kl
    public boolean b(RecyclerView.v vVar) {
        v(vVar);
        vVar.a.setAlpha(0.0f);
        this.k.add(vVar);
        return true;
    }

    void c(final RecyclerView.v vVar) {
        final View view = vVar.a;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.d.add(vVar);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(f()).setListener(new AnimatorListenerAdapter() { // from class: jr.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                jr.this.n(vVar);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                jr.this.k(vVar);
                jr.this.d.remove(vVar);
                jr.this.c();
            }
        }).start();
    }

    @Override // defpackage.kl
    public boolean a(RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
        View view = vVar.a;
        int translationX = i2 + ((int) vVar.a.getTranslationX());
        int translationY = i3 + ((int) vVar.a.getTranslationY());
        v(vVar);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            j(vVar);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.l.add(new b(vVar, translationX, translationY, i4, i5));
        return true;
    }

    void b(final RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
        final View view = vVar.a;
        final int i6 = i4 - i2;
        final int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.e.add(vVar);
        viewPropertyAnimatorAnimate.setDuration(e()).setListener(new AnimatorListenerAdapter() { // from class: jr.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                jr.this.m(vVar);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i6 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i7 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                jr.this.j(vVar);
                jr.this.e.remove(vVar);
                jr.this.c();
            }
        }).start();
    }

    @Override // defpackage.kl
    public boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4, int i5) {
        if (vVar == vVar2) {
            return a(vVar, i2, i3, i4, i5);
        }
        float translationX = vVar.a.getTranslationX();
        float translationY = vVar.a.getTranslationY();
        float alpha = vVar.a.getAlpha();
        v(vVar);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        vVar.a.setTranslationX(translationX);
        vVar.a.setTranslationY(translationY);
        vVar.a.setAlpha(alpha);
        if (vVar2 != null) {
            v(vVar2);
            vVar2.a.setTranslationX(-i6);
            vVar2.a.setTranslationY(-i7);
            vVar2.a.setAlpha(0.0f);
        }
        this.m.add(new a(vVar, vVar2, i2, i3, i4, i5));
        return true;
    }

    void a(final a aVar) {
        RecyclerView.v vVar = aVar.a;
        final View view = vVar == null ? null : vVar.a;
        RecyclerView.v vVar2 = aVar.b;
        final View view2 = vVar2 != null ? vVar2.a : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(h());
            this.g.add(aVar.a);
            duration.translationX(aVar.e - aVar.c);
            duration.translationY(aVar.f - aVar.d);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: jr.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    jr.this.b(aVar.a, true);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    jr.this.a(aVar.a, true);
                    jr.this.g.remove(aVar.a);
                    jr.this.c();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.g.add(aVar.b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(h()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: jr.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    jr.this.b(aVar.b, false);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorAnimate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    jr.this.a(aVar.b, false);
                    jr.this.g.remove(aVar.b);
                    jr.this.c();
                }
            }).start();
        }
    }

    private void a(List<a> list, RecyclerView.v vVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            if (a(aVar, vVar) && aVar.a == null && aVar.b == null) {
                list.remove(aVar);
            }
        }
    }

    private void b(a aVar) {
        if (aVar.a != null) {
            a(aVar, aVar.a);
        }
        if (aVar.b != null) {
            a(aVar, aVar.b);
        }
    }

    private boolean a(a aVar, RecyclerView.v vVar) {
        boolean z = false;
        if (aVar.b == vVar) {
            aVar.b = null;
        } else {
            if (aVar.a != vVar) {
                return false;
            }
            aVar.a = null;
            z = true;
        }
        vVar.a.setAlpha(1.0f);
        vVar.a.setTranslationX(0.0f);
        vVar.a.setTranslationY(0.0f);
        a(vVar, z);
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.e
    public void d(RecyclerView.v vVar) {
        View view = vVar.a;
        view.animate().cancel();
        for (int size = this.l.size() - 1; size >= 0; size--) {
            if (this.l.get(size).a == vVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                j(vVar);
                this.l.remove(size);
            }
        }
        a(this.m, vVar);
        if (this.j.remove(vVar)) {
            view.setAlpha(1.0f);
            i(vVar);
        }
        if (this.k.remove(vVar)) {
            view.setAlpha(1.0f);
            k(vVar);
        }
        for (int size2 = this.c.size() - 1; size2 >= 0; size2--) {
            ArrayList<a> arrayList = this.c.get(size2);
            a(arrayList, vVar);
            if (arrayList.isEmpty()) {
                this.c.remove(size2);
            }
        }
        for (int size3 = this.b.size() - 1; size3 >= 0; size3--) {
            ArrayList<b> arrayList2 = this.b.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).a != vVar) {
                    size4--;
                } else {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    j(vVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.b.remove(size3);
                    }
                }
            }
        }
        for (int size5 = this.a.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.v> arrayList3 = this.a.get(size5);
            if (arrayList3.remove(vVar)) {
                view.setAlpha(1.0f);
                k(vVar);
                if (arrayList3.isEmpty()) {
                    this.a.remove(size5);
                }
            }
        }
        if (this.f.remove(vVar)) {
        }
        if (this.d.remove(vVar)) {
        }
        if (this.g.remove(vVar)) {
        }
        if (this.e.remove(vVar)) {
        }
        c();
    }

    private void v(RecyclerView.v vVar) {
        if (i == null) {
            i = new ValueAnimator().getInterpolator();
        }
        vVar.a.animate().setInterpolator(i);
        d(vVar);
    }

    @Override // android.support.v7.widget.RecyclerView.e
    public boolean b() {
        return (this.k.isEmpty() && this.m.isEmpty() && this.l.isEmpty() && this.j.isEmpty() && this.e.isEmpty() && this.f.isEmpty() && this.d.isEmpty() && this.g.isEmpty() && this.b.isEmpty() && this.a.isEmpty() && this.c.isEmpty()) ? false : true;
    }

    void c() {
        if (!b()) {
            i();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.e
    public void d() {
        for (int size = this.l.size() - 1; size >= 0; size--) {
            b bVar = this.l.get(size);
            View view = bVar.a.a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            j(bVar.a);
            this.l.remove(size);
        }
        for (int size2 = this.j.size() - 1; size2 >= 0; size2--) {
            i(this.j.get(size2));
            this.j.remove(size2);
        }
        for (int size3 = this.k.size() - 1; size3 >= 0; size3--) {
            RecyclerView.v vVar = this.k.get(size3);
            vVar.a.setAlpha(1.0f);
            k(vVar);
            this.k.remove(size3);
        }
        for (int size4 = this.m.size() - 1; size4 >= 0; size4--) {
            b(this.m.get(size4));
        }
        this.m.clear();
        if (b()) {
            for (int size5 = this.b.size() - 1; size5 >= 0; size5--) {
                ArrayList<b> arrayList = this.b.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    b bVar2 = arrayList.get(size6);
                    View view2 = bVar2.a.a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    j(bVar2.a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.b.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.a.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.v> arrayList2 = this.a.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.v vVar2 = arrayList2.get(size8);
                    vVar2.a.setAlpha(1.0f);
                    k(vVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.a.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.c.size() - 1; size9 >= 0; size9--) {
                ArrayList<a> arrayList3 = this.c.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    b(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.c.remove(arrayList3);
                    }
                }
            }
            a(this.f);
            a(this.e);
            a(this.d);
            a(this.g);
            i();
        }
    }

    void a(List<RecyclerView.v> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).a.animate().cancel();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.e
    public boolean a(RecyclerView.v vVar, List<Object> list) {
        return !list.isEmpty() || super.a(vVar, list);
    }
}
