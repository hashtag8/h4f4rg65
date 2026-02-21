package defpackage;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class gb {
    static final d a;

    static class d {
        private static Method a;
        private static boolean b;

        d() {
        }

        public void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            if ((el.a(i3, fb.f(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }

        public void a(PopupWindow popupWindow, boolean z) {
        }

        public void a(PopupWindow popupWindow, int i) {
            if (!b) {
                try {
                    a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                    a.setAccessible(true);
                } catch (Exception e) {
                }
                b = true;
            }
            if (a != null) {
                try {
                    a.invoke(popupWindow, Integer.valueOf(i));
                } catch (Exception e2) {
                }
            }
        }
    }

    static class a extends d {
        a() {
        }

        @Override // gb.d
        public void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2, i3);
        }
    }

    static class b extends a {
        private static Field a;

        b() {
        }

        static {
            try {
                a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
            }
        }

        @Override // gb.d
        public void a(PopupWindow popupWindow, boolean z) {
            if (a != null) {
                try {
                    a.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
                }
            }
        }
    }

    static class c extends b {
        c() {
        }

        @Override // gb.b, gb.d
        public void a(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }

        @Override // gb.d
        public void a(PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            a = new c();
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            a = new b();
        } else if (Build.VERSION.SDK_INT >= 19) {
            a = new a();
        } else {
            a = new d();
        }
    }

    public static void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        a.a(popupWindow, view, i, i2, i3);
    }

    public static void a(PopupWindow popupWindow, boolean z) {
        a.a(popupWindow, z);
    }

    public static void a(PopupWindow popupWindow, int i) {
        a.a(popupWindow, i);
    }
}
