package defpackage;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import defpackage.ha;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class gu {
    private static final Class<?>[] a = {Context.class, AttributeSet.class};
    private static final int[] b = {R.attr.onClick};
    private static final String[] c = {"android.widget.", "android.view.", "android.webkit."};
    private static final Map<String, Constructor<? extends View>> d = new du();
    private final Object[] e = new Object[2];

    gu() {
    }

    public final View a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2;
        View jhVar;
        context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = kp.a(context2);
        }
        jhVar = null;
        switch (str) {
            case "TextView":
                jhVar = new jm(context2, attributeSet);
                break;
            case "ImageView":
                jhVar = new jb(context2, attributeSet);
                break;
            case "Button":
                jhVar = new it(context2, attributeSet);
                break;
            case "EditText":
                jhVar = new iy(context2, attributeSet);
                break;
            case "Spinner":
                jhVar = new jj(context2, attributeSet);
                break;
            case "ImageButton":
                jhVar = new iz(context2, attributeSet);
                break;
            case "CheckBox":
                jhVar = new iu(context2, attributeSet);
                break;
            case "RadioButton":
                jhVar = new jf(context2, attributeSet);
                break;
            case "CheckedTextView":
                jhVar = new iv(context2, attributeSet);
                break;
            case "AutoCompleteTextView":
                jhVar = new ir(context2, attributeSet);
                break;
            case "MultiAutoCompleteTextView":
                jhVar = new jc(context2, attributeSet);
                break;
            case "RatingBar":
                jhVar = new jg(context2, attributeSet);
                break;
            case "SeekBar":
                jhVar = new jh(context2, attributeSet);
                break;
        }
        View viewA = (jhVar != null || context == context2) ? jhVar : a(context2, str, attributeSet);
        if (viewA != null) {
            a(viewA, attributeSet);
        }
        return viewA;
    }

    private View a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.e[0] = context;
            this.e[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return a(context, str, (String) null);
            }
            for (int i = 0; i < c.length; i++) {
                View viewA = a(context, str, c[i]);
                if (viewA != null) {
                    return viewA;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        } finally {
            this.e[0] = null;
            this.e[1] = null;
        }
    }

    private void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT < 15 || fb.y(view)) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b);
                String string = typedArrayObtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new a(view, string));
                }
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    private View a(Context context, String str, String str2) {
        Constructor<? extends View> constructor = d.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(a);
                d.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.e);
    }

    private static Context a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ha.j.View, 0, 0);
        int resourceId = z ? typedArrayObtainStyledAttributes.getResourceId(ha.j.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(ha.j.View_theme, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        int i = resourceId;
        typedArrayObtainStyledAttributes.recycle();
        if (i != 0) {
            if (!(context instanceof hj) || ((hj) context).a() != i) {
                return new hj(context, i);
            }
            return context;
        }
        return context;
    }

    static class a implements View.OnClickListener {
        private final View a;
        private final String b;
        private Method c;
        private Context d;

        public a(View view, String str) {
            this.a = view;
            this.b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.c == null) {
                a(this.a.getContext(), this.b);
            }
            try {
                this.c.invoke(this.d, view);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }

        private void a(Context context, String str) {
            Method method;
            Context baseContext = context;
            while (baseContext != null) {
                try {
                    if (!baseContext.isRestricted() && (method = baseContext.getClass().getMethod(this.b, View.class)) != null) {
                        this.c = method;
                        this.d = baseContext;
                        return;
                    }
                } catch (NoSuchMethodException e) {
                }
                if (baseContext instanceof ContextWrapper) {
                    baseContext = ((ContextWrapper) baseContext).getBaseContext();
                } else {
                    baseContext = null;
                }
            }
            int id = this.a.getId();
            throw new IllegalStateException("Could not find method " + this.b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.a.getClass() + (id == -1 ? "" : " with id '" + this.a.getContext().getResources().getResourceEntryName(id) + "'"));
        }
    }
}
