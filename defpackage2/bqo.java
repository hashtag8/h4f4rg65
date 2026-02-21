package defpackage;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
final class bqo {
    public static void a(Object obj, Activity activity, Drawable drawable, int i) {
        a aVar = (a) obj;
        if (aVar.a != null) {
            aVar.a.setImageDrawable(drawable);
            aVar.a.setContentDescription(i == 0 ? null : activity.getString(i));
        }
    }

    public static void a(Object obj, Activity activity, int i) {
        a aVar = (a) obj;
        if (aVar.a != null) {
            aVar.a.setContentDescription(i == 0 ? null : activity.getString(i));
        }
    }

    public static Drawable a(Object obj) {
        a aVar = (a) obj;
        if (aVar.a != null) {
            return aVar.a.getDrawable();
        }
        return null;
    }

    public static Object a(Activity activity) {
        return new a(activity);
    }

    public static void a(Object obj, boolean z) {
        a aVar = (a) obj;
        if (aVar.c != null) {
            try {
                aVar.c.invoke(aVar.b, Boolean.valueOf(z));
            } catch (Throwable th) {
            }
        }
    }

    static class a {
        public ImageView a;
        public Object b;
        public Method c;

        a(Activity activity) {
            try {
                String packageName = activity.getPackageName();
                try {
                    this.a = (ImageView) ((ViewGroup) activity.findViewById(activity.getResources().getIdentifier("abs__home", "id", packageName)).getParent()).findViewById(activity.getResources().getIdentifier("abs__up", "id", packageName));
                } catch (Throwable th) {
                }
                if (this.a == null) {
                    this.a = (ImageView) ((ViewGroup) activity.findViewById(activity.getResources().getIdentifier("home", "id", packageName)).getParent()).findViewById(activity.getResources().getIdentifier("up", "id", packageName));
                }
                this.b = activity.getClass().getMethod("getSupportActionBar", new Class[0]).invoke(activity, null);
                this.c = this.b.getClass().getMethod("setDisplayHomeAsUpEnabled", Boolean.TYPE);
            } catch (Throwable th2) {
            }
        }
    }
}
