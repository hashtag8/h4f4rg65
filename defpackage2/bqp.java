package defpackage;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
final class bqp {
    private static final int[] a = {R.attr.homeAsUpIndicator};

    public static void a(Object obj, Activity activity, Drawable drawable, int i) {
        a aVar = (a) obj;
        if (aVar.a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                aVar.a.invoke(actionBar, drawable);
                aVar.b.invoke(actionBar, Integer.valueOf(i));
                return;
            } catch (Throwable th) {
                return;
            }
        }
        if (aVar.c != null) {
            aVar.c.setImageDrawable(drawable);
        }
    }

    public static void a(Object obj, Activity activity, int i) {
        a aVar = (a) obj;
        if (aVar.a != null) {
            try {
                aVar.b.invoke(activity.getActionBar(), Integer.valueOf(i));
            } catch (Throwable th) {
            }
        }
    }

    public static Drawable a(Object obj, Activity activity) {
        TypedArray typedArrayObtainStyledAttributes = activity.obtainStyledAttributes(a);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        return drawable;
    }

    public static Object a(Activity activity) {
        return new a(activity);
    }

    public static void a(Activity activity, boolean z) {
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(z);
        }
    }

    static class a {
        public Method a;
        public Method b;
        public ImageView c;

        a(Activity activity) {
            try {
                this.a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
                this.b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
            } catch (Throwable th) {
                View viewFindViewById = activity.findViewById(R.id.home);
                if (viewFindViewById != null) {
                    ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
                    if (viewGroup.getChildCount() == 2) {
                        View childAt = viewGroup.getChildAt(0);
                        View childAt2 = childAt.getId() != 16908332 ? childAt : viewGroup.getChildAt(1);
                        if (childAt2 instanceof ImageView) {
                            this.c = (ImageView) childAt2;
                        }
                    }
                }
            }
        }
    }
}
