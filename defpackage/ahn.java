package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;

/* JADX INFO: loaded from: classes.dex */
public class ahn {
    public static a a(Context context) {
        if (context == null) {
            context = HarmanApplication.a();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new a(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static class a {
        public int a;
        public int b;

        public a() {
        }

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public int a() {
            return Math.min(this.a, this.b);
        }

        public int b() {
            return Math.max(this.a, this.b);
        }

        public String toString() {
            return "(" + this.a + "," + this.b + ")";
        }
    }

    public static int b(Context context) {
        int iA = a(context).a();
        if (a()) {
            return iA - context.getResources().getDimensionPixelOffset(R.dimen.left_menu_width);
        }
        return iA;
    }

    public static int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static boolean a() {
        return HarmanApplication.a().getResources().getBoolean(R.bool.is_tablet);
    }

    public static int c(Context context) {
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int dimensionPixelSize = rect.top;
        if (dimensionPixelSize == 0) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                dimensionPixelSize = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!Build.MANUFACTURER.equals("Xiaomi")) {
            return dimensionPixelSize;
        }
        if (Build.MODEL.equals("MI 3W") || Build.MODEL.equals("MI 4W")) {
            return 75;
        }
        return dimensionPixelSize;
    }

    public static int a(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT < 17) {
            try {
                return ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception e) {
                return i;
            }
        }
        if (Build.VERSION.SDK_INT < 17) {
            return i;
        }
        try {
            Point point = new Point();
            Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
            return point.y;
        } catch (Exception e2) {
            return i;
        }
    }

    public static int d(Context context) {
        int identifier;
        Resources resources = context.getResources();
        int identifier2 = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier2 > 0) {
            mm.b("sam test", resources.getBoolean(identifier2) + "");
            if (resources.getBoolean(identifier2) && (identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android")) > 0) {
                int dimensionPixelSize = resources.getDimensionPixelSize(identifier);
                mm.b("sam test", resources.getDimensionPixelSize(identifier) + "");
                return dimensionPixelSize;
            }
        }
        return 0;
    }

    public static WindowManager.LayoutParams a(WindowManager.LayoutParams layoutParams, Context context) {
        layoutParams.width = -1;
        layoutParams.gravity = 80;
        if (a()) {
            a aVarA = a(context);
            int iMin = Math.min(aVarA.b, aVarA.a);
            layoutParams.width = iMin - (iMin / 5);
        }
        return layoutParams;
    }

    public static ViewGroup.LayoutParams a(ViewGroup.LayoutParams layoutParams, Context context) {
        if (a()) {
            a aVarA = a(context);
            int iMin = Math.min(aVarA.b, aVarA.a);
            layoutParams.width = iMin - (iMin / 5);
        }
        return layoutParams;
    }
}
