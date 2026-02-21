package defpackage;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class bht implements ViewTreeObserver.OnPreDrawListener {
    final bik a;
    final WeakReference<ImageView> b;
    bhq c;

    bht(bik bikVar, ImageView imageView, bhq bhqVar) {
        this.a = bikVar;
        this.b = new WeakReference<>(imageView);
        this.c = bhqVar;
        imageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        ImageView imageView = this.b.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                if (width > 0 && height > 0) {
                    viewTreeObserver.removeOnPreDrawListener(this);
                    this.a.b().b(width, height).a(imageView, this.c);
                }
            }
        }
        return true;
    }

    void a() {
        this.c = null;
        ImageView imageView = this.b.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
        }
    }
}
