package defpackage;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class ge {
    static final f a;

    static class f {
        private static Field a;
        private static boolean b;
        private static Field c;
        private static boolean d;

        f() {
        }

        public void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }

        private static Field a(String str) {
            Field declaredField = null;
            try {
                declaredField = TextView.class.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (NoSuchFieldException e) {
                Log.e("TextViewCompatBase", "Could not retrieve " + str + " field.");
                return declaredField;
            }
        }

        private static int a(Field field, TextView textView) {
            try {
                return field.getInt(textView);
            } catch (IllegalAccessException e) {
                Log.d("TextViewCompatBase", "Could not retrieve value of " + field.getName() + " field.");
                return -1;
            }
        }

        public int a(TextView textView) {
            if (!d) {
                c = a("mMaxMode");
                d = true;
            }
            if (c != null && a(c, textView) == 1) {
                if (!b) {
                    a = a("mMaximum");
                    b = true;
                }
                if (a != null) {
                    return a(a, textView);
                }
            }
            return -1;
        }

        public void a(TextView textView, int i) {
            textView.setTextAppearance(textView.getContext(), i);
        }
    }

    static class a extends f {
        a() {
        }

        @Override // ge.f
        public int a(TextView textView) {
            return textView.getMaxLines();
        }
    }

    static class b extends a {
        b() {
        }

        @Override // ge.f
        public void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            boolean z = textView.getLayoutDirection() == 1;
            Drawable drawable5 = z ? drawable3 : drawable;
            if (!z) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        }
    }

    static class c extends b {
        c() {
        }

        @Override // ge.b, ge.f
        public void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }
    }

    static class d extends c {
        d() {
        }

        @Override // ge.f
        public void a(TextView textView, int i) {
            textView.setTextAppearance(i);
        }
    }

    static class e extends d {
        e() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            a = new e();
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            a = new d();
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            a = new c();
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            a = new b();
        } else if (Build.VERSION.SDK_INT >= 16) {
            a = new a();
        } else {
            a = new f();
        }
    }

    public static void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        a.a(textView, drawable, drawable2, drawable3, drawable4);
    }

    public static int a(TextView textView) {
        return a.a(textView);
    }

    public static void a(TextView textView, int i) {
        a.a(textView, i);
    }
}
