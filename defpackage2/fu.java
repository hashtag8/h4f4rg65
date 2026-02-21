package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class fu {
    private static final c a;

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            a = new b();
        } else if (Build.VERSION.SDK_INT >= 21) {
            a = new a();
        } else {
            a = new c();
        }
    }

    static class c {
        private static Field a;
        private static boolean b;

        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(CompoundButton compoundButton, ColorStateList colorStateList) {
            if (compoundButton instanceof gf) {
                ((gf) compoundButton).setSupportButtonTintList(colorStateList);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(CompoundButton compoundButton, PorterDuff.Mode mode) {
            if (compoundButton instanceof gf) {
                ((gf) compoundButton).setSupportButtonTintMode(mode);
            }
        }

        public Drawable a(CompoundButton compoundButton) {
            if (!b) {
                try {
                    a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                    a.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
                }
                b = true;
            }
            if (a != null) {
                try {
                    return (Drawable) a.get(compoundButton);
                } catch (IllegalAccessException e2) {
                    Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                    a = null;
                }
            }
            return null;
        }
    }

    static class a extends c {
        a() {
        }

        @Override // fu.c
        public void a(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        @Override // fu.c
        public void a(CompoundButton compoundButton, PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    static class b extends a {
        b() {
        }

        @Override // fu.c
        public Drawable a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    public static void a(CompoundButton compoundButton, ColorStateList colorStateList) {
        a.a(compoundButton, colorStateList);
    }

    public static void a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        a.a(compoundButton, mode);
    }

    public static Drawable a(CompoundButton compoundButton) {
        return a.a(compoundButton);
    }
}
