package defpackage;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: loaded from: classes.dex */
class kv implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {
    private static kv i;
    private final View a;
    private final CharSequence b;
    private final Runnable c = new Runnable() { // from class: kv.1
        @Override // java.lang.Runnable
        public void run() {
            kv.this.a(false);
        }
    };
    private final Runnable d = new Runnable() { // from class: kv.2
        @Override // java.lang.Runnable
        public void run() {
            kv.this.a();
        }
    };
    private int e;
    private int f;
    private kw g;
    private boolean h;

    public static void a(View view, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (i != null && i.a == view) {
                i.a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new kv(view, charSequence);
    }

    private kv(View view, CharSequence charSequence) {
        this.a = view;
        this.b = charSequence;
        this.a.setOnLongClickListener(this);
        this.a.setOnHoverListener(this);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.e = view.getWidth() / 2;
        this.f = view.getHeight() / 2;
        a(true);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.g == null || !this.h) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.a.getContext().getSystemService("accessibility");
            if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
                switch (motionEvent.getAction()) {
                    case 7:
                        if (this.a.isEnabled() && this.g == null) {
                            this.e = (int) motionEvent.getX();
                            this.f = (int) motionEvent.getY();
                            this.a.removeCallbacks(this.c);
                            this.a.postDelayed(this.c, ViewConfiguration.getLongPressTimeout());
                        }
                        break;
                    case 10:
                        a();
                        break;
                }
            }
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        long longPressTimeout;
        if (fb.x(this.a)) {
            if (i != null) {
                i.a();
            }
            i = this;
            this.h = z;
            this.g = new kw(this.a.getContext());
            this.g.a(this.a, this.e, this.f, this.h, this.b);
            this.a.addOnAttachStateChangeListener(this);
            if (this.h) {
                longPressTimeout = 2500;
            } else if ((fb.m(this.a) & 1) == 1) {
                longPressTimeout = 3000 - ((long) ViewConfiguration.getLongPressTimeout());
            } else {
                longPressTimeout = 15000 - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.a.removeCallbacks(this.d);
            this.a.postDelayed(this.d, longPressTimeout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (i == this) {
            i = null;
            if (this.g != null) {
                this.g.a();
                this.g = null;
                this.a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        this.a.removeCallbacks(this.c);
        this.a.removeCallbacks(this.d);
    }
}
