package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class cw {
    static final e a;

    static class e {
        e() {
        }

        public void g(Drawable drawable) {
            drawable.jumpToCurrentState();
        }

        public void a(Drawable drawable, boolean z) {
        }

        public boolean b(Drawable drawable) {
            return false;
        }

        public void a(Drawable drawable, float f, float f2) {
        }

        public void a(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void b(Drawable drawable, int i) {
            if (drawable instanceof db) {
                ((db) drawable).setTint(i);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(Drawable drawable, ColorStateList colorStateList) {
            if (drawable instanceof db) {
                ((db) drawable).setTintList(colorStateList);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(Drawable drawable, PorterDuff.Mode mode) {
            if (drawable instanceof db) {
                ((db) drawable).setTintMode(mode);
            }
        }

        public Drawable c(Drawable drawable) {
            if (!(drawable instanceof db)) {
                return new cy(drawable);
            }
            return drawable;
        }

        public boolean a(Drawable drawable, int i) {
            return false;
        }

        public int a(Drawable drawable) {
            return 0;
        }

        public int d(Drawable drawable) {
            return 0;
        }

        public void a(Drawable drawable, Resources.Theme theme) {
        }

        public boolean e(Drawable drawable) {
            return false;
        }

        public ColorFilter f(Drawable drawable) {
            return null;
        }

        public void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    static class a extends e {
        private static Method a;
        private static boolean b;
        private static Method c;
        private static boolean d;

        a() {
        }

        @Override // cw.e
        public boolean a(Drawable drawable, int i) {
            if (!b) {
                try {
                    a = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                    a.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("DrawableCompatApi17", "Failed to retrieve setLayoutDirection(int) method", e);
                }
                b = true;
            }
            if (a != null) {
                try {
                    a.invoke(drawable, Integer.valueOf(i));
                    return true;
                } catch (Exception e2) {
                    Log.i("DrawableCompatApi17", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                    a = null;
                }
            }
            return false;
        }

        @Override // cw.e
        public int a(Drawable drawable) {
            if (!d) {
                try {
                    c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    c.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("DrawableCompatApi17", "Failed to retrieve getLayoutDirection() method", e);
                }
                d = true;
            }
            if (c != null) {
                try {
                    return ((Integer) c.invoke(drawable, new Object[0])).intValue();
                } catch (Exception e2) {
                    Log.i("DrawableCompatApi17", "Failed to invoke getLayoutDirection() via reflection", e2);
                    c = null;
                }
            }
            return 0;
        }
    }

    static class b extends a {
        b() {
        }

        @Override // cw.e
        public void a(Drawable drawable, boolean z) {
            drawable.setAutoMirrored(z);
        }

        @Override // cw.e
        public boolean b(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        @Override // cw.e
        public Drawable c(Drawable drawable) {
            if (!(drawable instanceof db)) {
                return new cz(drawable);
            }
            return drawable;
        }

        @Override // cw.e
        public int d(Drawable drawable) {
            return drawable.getAlpha();
        }
    }

    static class c extends b {
        c() {
        }

        @Override // cw.e
        public void a(Drawable drawable, float f, float f2) {
            drawable.setHotspot(f, f2);
        }

        @Override // cw.e
        public void a(Drawable drawable, int i, int i2, int i3, int i4) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }

        @Override // cw.e
        public void b(Drawable drawable, int i) {
            drawable.setTint(i);
        }

        @Override // cw.e
        public void a(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        @Override // cw.e
        public void a(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }

        @Override // cw.b, cw.e
        public Drawable c(Drawable drawable) {
            if (!(drawable instanceof db)) {
                return new da(drawable);
            }
            return drawable;
        }

        @Override // cw.e
        public void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        @Override // cw.e
        public boolean e(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        @Override // cw.e
        public ColorFilter f(Drawable drawable) {
            return drawable.getColorFilter();
        }

        @Override // cw.e
        public void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }
    }

    static class d extends c {
        d() {
        }

        @Override // cw.a, cw.e
        public boolean a(Drawable drawable, int i) {
            return drawable.setLayoutDirection(i);
        }

        @Override // cw.a, cw.e
        public int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        @Override // cw.c, cw.b, cw.e
        public Drawable c(Drawable drawable) {
            return drawable;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            a = new d();
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            a = new c();
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            a = new b();
        } else if (Build.VERSION.SDK_INT >= 17) {
            a = new a();
        } else {
            a = new e();
        }
    }

    public static void a(Drawable drawable) {
        a.g(drawable);
    }

    public static void a(Drawable drawable, boolean z) {
        a.a(drawable, z);
    }

    public static boolean b(Drawable drawable) {
        return a.b(drawable);
    }

    public static void a(Drawable drawable, float f, float f2) {
        a.a(drawable, f, f2);
    }

    public static void a(Drawable drawable, int i, int i2, int i3, int i4) {
        a.a(drawable, i, i2, i3, i4);
    }

    public static void a(Drawable drawable, int i) {
        a.b(drawable, i);
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        a.a(drawable, colorStateList);
    }

    public static void a(Drawable drawable, PorterDuff.Mode mode) {
        a.a(drawable, mode);
    }

    public static int c(Drawable drawable) {
        return a.d(drawable);
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        a.a(drawable, theme);
    }

    public static boolean d(Drawable drawable) {
        return a.e(drawable);
    }

    public static ColorFilter e(Drawable drawable) {
        return a.f(drawable);
    }

    public static void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        a.a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static Drawable f(Drawable drawable) {
        return a.c(drawable);
    }

    public static boolean b(Drawable drawable, int i) {
        return a.a(drawable, i);
    }

    public static int g(Drawable drawable) {
        return a.a(drawable);
    }
}
