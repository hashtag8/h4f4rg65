package defpackage;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public final class fj {
    private static final c a;

    static class c {
        c() {
        }

        public void a(AccessibilityEvent accessibilityEvent, int i) {
        }

        public int a(AccessibilityEvent accessibilityEvent) {
            return 0;
        }
    }

    static class a extends c {
        a() {
        }
    }

    static class b extends a {
        b() {
        }

        @Override // fj.c
        public void a(AccessibilityEvent accessibilityEvent, int i) {
            accessibilityEvent.setContentChangeTypes(i);
        }

        @Override // fj.c
        public int a(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getContentChangeTypes();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            a = new b();
        } else if (Build.VERSION.SDK_INT >= 16) {
            a = new a();
        } else {
            a = new c();
        }
    }

    public static void a(AccessibilityEvent accessibilityEvent, int i) {
        a.a(accessibilityEvent, i);
    }

    public static int a(AccessibilityEvent accessibilityEvent) {
        return a.a(accessibilityEvent);
    }
}
