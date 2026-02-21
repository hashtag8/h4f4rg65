package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;

/* JADX INFO: loaded from: classes.dex */
public final class eo {
    static final c a;

    interface c {
        void a(MenuItem menuItem, char c, int i);

        void a(MenuItem menuItem, ColorStateList colorStateList);

        void a(MenuItem menuItem, PorterDuff.Mode mode);

        void a(MenuItem menuItem, CharSequence charSequence);

        void b(MenuItem menuItem, char c, int i);

        void b(MenuItem menuItem, CharSequence charSequence);
    }

    static class b implements c {
        b() {
        }

        @Override // eo.c
        public void a(MenuItem menuItem, CharSequence charSequence) {
        }

        @Override // eo.c
        public void b(MenuItem menuItem, CharSequence charSequence) {
        }

        @Override // eo.c
        public void a(MenuItem menuItem, char c, int i) {
        }

        @Override // eo.c
        public void b(MenuItem menuItem, char c, int i) {
        }

        @Override // eo.c
        public void a(MenuItem menuItem, ColorStateList colorStateList) {
        }

        @Override // eo.c
        public void a(MenuItem menuItem, PorterDuff.Mode mode) {
        }
    }

    static class a extends b {
        a() {
        }

        @Override // eo.b, eo.c
        public void a(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setContentDescription(charSequence);
        }

        @Override // eo.b, eo.c
        public void b(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setTooltipText(charSequence);
        }

        @Override // eo.b, eo.c
        public void a(MenuItem menuItem, char c, int i) {
            menuItem.setAlphabeticShortcut(c, i);
        }

        @Override // eo.b, eo.c
        public void b(MenuItem menuItem, char c, int i) {
            menuItem.setNumericShortcut(c, i);
        }

        @Override // eo.b, eo.c
        public void a(MenuItem menuItem, ColorStateList colorStateList) {
            menuItem.setIconTintList(colorStateList);
        }

        @Override // eo.b, eo.c
        public void a(MenuItem menuItem, PorterDuff.Mode mode) {
            menuItem.setIconTintMode(mode);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            a = new a();
        } else {
            a = new b();
        }
    }

    public static MenuItem a(MenuItem menuItem, ej ejVar) {
        if (menuItem instanceof dd) {
            return ((dd) menuItem).a(ejVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof dd) {
            ((dd) menuItem).a(charSequence);
        } else {
            a.a(menuItem, charSequence);
        }
    }

    public static void b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof dd) {
            ((dd) menuItem).b(charSequence);
        } else {
            a.b(menuItem, charSequence);
        }
    }

    public static void a(MenuItem menuItem, char c2, int i) {
        if (menuItem instanceof dd) {
            ((dd) menuItem).setNumericShortcut(c2, i);
        } else {
            a.b(menuItem, c2, i);
        }
    }

    public static void b(MenuItem menuItem, char c2, int i) {
        if (menuItem instanceof dd) {
            ((dd) menuItem).setAlphabeticShortcut(c2, i);
        } else {
            a.a(menuItem, c2, i);
        }
    }

    public static void a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof dd) {
            ((dd) menuItem).setIconTintList(colorStateList);
        } else {
            a.a(menuItem, colorStateList);
        }
    }

    public static void a(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof dd) {
            ((dd) menuItem).setIconTintMode(mode);
        } else {
            a.a(menuItem, mode);
        }
    }
}
