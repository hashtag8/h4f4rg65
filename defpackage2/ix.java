package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import defpackage.ha;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class ix {
    private static ix b;
    private WeakHashMap<Context, eh<ColorStateList>> j;
    private du<String, c> k;
    private eh<String> l;
    private final Object m = new Object();
    private final WeakHashMap<Context, dz<WeakReference<Drawable.ConstantState>>> n = new WeakHashMap<>(0);
    private TypedValue o;
    private boolean p;
    private static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
    private static final b c = new b(6);
    private static final int[] d = {ha.e.abc_textfield_search_default_mtrl_alpha, ha.e.abc_textfield_default_mtrl_alpha, ha.e.abc_ab_share_pack_mtrl_alpha};
    private static final int[] e = {ha.e.abc_ic_commit_search_api_mtrl_alpha, ha.e.abc_seekbar_tick_mark_material, ha.e.abc_ic_menu_share_mtrl_alpha, ha.e.abc_ic_menu_copy_mtrl_am_alpha, ha.e.abc_ic_menu_cut_mtrl_alpha, ha.e.abc_ic_menu_selectall_mtrl_alpha, ha.e.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] f = {ha.e.abc_textfield_activated_mtrl_alpha, ha.e.abc_textfield_search_activated_mtrl_alpha, ha.e.abc_cab_background_top_mtrl_alpha, ha.e.abc_text_cursor_material, ha.e.abc_text_select_handle_left_mtrl_dark, ha.e.abc_text_select_handle_middle_mtrl_dark, ha.e.abc_text_select_handle_right_mtrl_dark, ha.e.abc_text_select_handle_left_mtrl_light, ha.e.abc_text_select_handle_middle_mtrl_light, ha.e.abc_text_select_handle_right_mtrl_light};
    private static final int[] g = {ha.e.abc_popup_background_mtrl_mult, ha.e.abc_cab_background_internal_bg, ha.e.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] h = {ha.e.abc_tab_indicator_material, ha.e.abc_textfield_search_material};
    private static final int[] i = {ha.e.abc_btn_check_material, ha.e.abc_btn_radio_material};

    interface c {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public static ix a() {
        if (b == null) {
            b = new ix();
            a(b);
        }
        return b;
    }

    private static void a(ix ixVar) {
        if (Build.VERSION.SDK_INT < 24) {
            ixVar.a("vector", new d());
            if (Build.VERSION.SDK_INT >= 11) {
                ixVar.a("animated-vector", new a());
            }
        }
    }

    public Drawable a(Context context, int i2) {
        return a(context, i2, false);
    }

    Drawable a(Context context, int i2, boolean z) {
        f(context);
        Drawable drawableD = d(context, i2);
        if (drawableD == null) {
            drawableD = c(context, i2);
        }
        if (drawableD == null) {
            drawableD = ci.a(context, i2);
        }
        if (drawableD != null) {
            drawableD = a(context, i2, z, drawableD);
        }
        if (drawableD != null) {
            js.a(drawableD);
        }
        return drawableD;
    }

    public void a(Context context) {
        synchronized (this.m) {
            dz<WeakReference<Drawable.ConstantState>> dzVar = this.n.get(context);
            if (dzVar != null) {
                dzVar.c();
            }
        }
    }

    private static long a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable c(Context context, int i2) {
        if (this.o == null) {
            this.o = new TypedValue();
        }
        TypedValue typedValue = this.o;
        context.getResources().getValue(i2, typedValue, true);
        long jA = a(typedValue);
        Drawable drawableA = a(context, jA);
        if (drawableA == null) {
            if (i2 == ha.e.abc_cab_background_top_material) {
                drawableA = new LayerDrawable(new Drawable[]{a(context, ha.e.abc_cab_background_internal_bg), a(context, ha.e.abc_cab_background_top_mtrl_alpha)});
            }
            if (drawableA != null) {
                drawableA.setChangingConfigurations(typedValue.changingConfigurations);
                a(context, jA, drawableA);
            }
        }
        return drawableA;
    }

    private Drawable a(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList colorStateListB = b(context, i2);
        if (colorStateListB != null) {
            if (js.b(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable drawableF = cw.f(drawable);
            cw.a(drawableF, colorStateListB);
            PorterDuff.Mode modeA = a(i2);
            if (modeA != null) {
                cw.a(drawableF, modeA);
                return drawableF;
            }
            return drawableF;
        }
        if (i2 == ha.e.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(R.id.background), kn.a(context, ha.a.colorControlNormal), a);
            a(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), kn.a(context, ha.a.colorControlNormal), a);
            a(layerDrawable.findDrawableByLayerId(R.id.progress), kn.a(context, ha.a.colorControlActivated), a);
            return drawable;
        }
        if (i2 == ha.e.abc_ratingbar_material || i2 == ha.e.abc_ratingbar_indicator_material || i2 == ha.e.abc_ratingbar_small_material) {
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            a(layerDrawable2.findDrawableByLayerId(R.id.background), kn.c(context, ha.a.colorControlNormal), a);
            a(layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress), kn.a(context, ha.a.colorControlActivated), a);
            a(layerDrawable2.findDrawableByLayerId(R.id.progress), kn.a(context, ha.a.colorControlActivated), a);
            return drawable;
        }
        if (!a(context, i2, drawable) && z) {
            return null;
        }
        return drawable;
    }

    private Drawable d(Context context, int i2) {
        Drawable drawable;
        int next;
        if (this.k == null || this.k.isEmpty()) {
            return null;
        }
        if (this.l != null) {
            String strA = this.l.a(i2);
            if ("appcompat_skip_skip".equals(strA) || (strA != null && this.k.get(strA) == null)) {
                return null;
            }
        } else {
            this.l = new eh<>();
        }
        if (this.o == null) {
            this.o = new TypedValue();
        }
        TypedValue typedValue = this.o;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long jA = a(typedValue);
        Drawable drawableA = a(context, jA);
        if (drawableA != null) {
            return drawableA;
        }
        if (typedValue.string == null || !typedValue.string.toString().endsWith(".xml")) {
            drawable = drawableA;
        } else {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.l.c(i2, name);
                c cVar = this.k.get(name);
                if (cVar != null) {
                    drawableA = cVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableA != null) {
                    drawableA.setChangingConfigurations(typedValue.changingConfigurations);
                    if (a(context, jA, drawableA)) {
                    }
                }
                drawable = drawableA;
            } catch (Exception e2) {
                Log.e("AppCompatDrawableManager", "Exception while inflating drawable", e2);
                drawable = drawableA;
            }
        }
        if (drawable == null) {
            this.l.c(i2, "appcompat_skip_skip");
            return drawable;
        }
        return drawable;
    }

    private Drawable a(Context context, long j) {
        synchronized (this.m) {
            dz<WeakReference<Drawable.ConstantState>> dzVar = this.n.get(context);
            if (dzVar == null) {
                return null;
            }
            WeakReference<Drawable.ConstantState> weakReferenceA = dzVar.a(j);
            if (weakReferenceA != null) {
                Drawable.ConstantState constantState = weakReferenceA.get();
                if (constantState != null) {
                    return constantState.newDrawable(context.getResources());
                }
                dzVar.b(j);
            }
            return null;
        }
    }

    private boolean a(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            synchronized (this.m) {
                dz<WeakReference<Drawable.ConstantState>> dzVar = this.n.get(context);
                if (dzVar == null) {
                    dzVar = new dz<>();
                    this.n.put(context, dzVar);
                }
                dzVar.b(j, new WeakReference<>(constantState));
            }
            return true;
        }
        return false;
    }

    Drawable a(Context context, kx kxVar, int i2) {
        Drawable drawableD = d(context, i2);
        if (drawableD == null) {
            drawableD = kxVar.a(i2);
        }
        if (drawableD != null) {
            return a(context, i2, false, drawableD);
        }
        return null;
    }

    static boolean a(Context context, int i2, Drawable drawable) {
        int iRound;
        int i3;
        PorterDuff.Mode mode;
        boolean z;
        PorterDuff.Mode mode2 = a;
        if (a(d, i2)) {
            i3 = ha.a.colorControlNormal;
            mode = mode2;
            z = true;
            iRound = -1;
        } else if (a(f, i2)) {
            i3 = ha.a.colorControlActivated;
            mode = mode2;
            z = true;
            iRound = -1;
        } else if (a(g, i2)) {
            z = true;
            mode = PorterDuff.Mode.MULTIPLY;
            i3 = 16842801;
            iRound = -1;
        } else if (i2 == ha.e.abc_list_divider_mtrl_alpha) {
            i3 = R.attr.colorForeground;
            iRound = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else if (i2 == ha.e.abc_dialog_material_background) {
            i3 = 16842801;
            mode = mode2;
            z = true;
            iRound = -1;
        } else {
            iRound = -1;
            i3 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (js.b(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(a(kn.a(context, i3), mode));
        if (iRound == -1) {
            return true;
        }
        drawable.setAlpha(iRound);
        return true;
    }

    private void a(String str, c cVar) {
        if (this.k == null) {
            this.k = new du<>();
        }
        this.k.put(str, cVar);
    }

    private static boolean a(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    static PorterDuff.Mode a(int i2) {
        if (i2 != ha.e.abc_switch_thumb_material) {
            return null;
        }
        return PorterDuff.Mode.MULTIPLY;
    }

    ColorStateList b(Context context, int i2) {
        ColorStateList colorStateListE = e(context, i2);
        if (colorStateListE == null) {
            if (i2 == ha.e.abc_edit_text_material) {
                colorStateListE = hc.a(context, ha.c.abc_tint_edittext);
            } else if (i2 == ha.e.abc_switch_track_mtrl_alpha) {
                colorStateListE = hc.a(context, ha.c.abc_tint_switch_track);
            } else if (i2 == ha.e.abc_switch_thumb_material) {
                colorStateListE = e(context);
            } else if (i2 == ha.e.abc_btn_default_mtrl_shape) {
                colorStateListE = b(context);
            } else if (i2 == ha.e.abc_btn_borderless_material) {
                colorStateListE = c(context);
            } else if (i2 == ha.e.abc_btn_colored_material) {
                colorStateListE = d(context);
            } else if (i2 == ha.e.abc_spinner_mtrl_am_alpha || i2 == ha.e.abc_spinner_textfield_background_material) {
                colorStateListE = hc.a(context, ha.c.abc_tint_spinner);
            } else if (a(e, i2)) {
                colorStateListE = kn.b(context, ha.a.colorControlNormal);
            } else if (a(h, i2)) {
                colorStateListE = hc.a(context, ha.c.abc_tint_default);
            } else if (a(i, i2)) {
                colorStateListE = hc.a(context, ha.c.abc_tint_btn_checkable);
            } else if (i2 == ha.e.abc_seekbar_thumb_material) {
                colorStateListE = hc.a(context, ha.c.abc_tint_seek_thumb);
            }
            if (colorStateListE != null) {
                a(context, i2, colorStateListE);
            }
        }
        return colorStateListE;
    }

    private ColorStateList e(Context context, int i2) {
        eh<ColorStateList> ehVar;
        if (this.j != null && (ehVar = this.j.get(context)) != null) {
            return ehVar.a(i2);
        }
        return null;
    }

    private void a(Context context, int i2, ColorStateList colorStateList) {
        if (this.j == null) {
            this.j = new WeakHashMap<>();
        }
        eh<ColorStateList> ehVar = this.j.get(context);
        if (ehVar == null) {
            ehVar = new eh<>();
            this.j.put(context, ehVar);
        }
        ehVar.c(i2, colorStateList);
    }

    private ColorStateList b(Context context) {
        return f(context, kn.a(context, ha.a.colorButtonNormal));
    }

    private ColorStateList c(Context context) {
        return f(context, 0);
    }

    private ColorStateList d(Context context) {
        return f(context, kn.a(context, ha.a.colorAccent));
    }

    private ColorStateList f(Context context, int i2) {
        int iA = kn.a(context, ha.a.colorControlHighlight);
        return new ColorStateList(new int[][]{kn.a, kn.d, kn.b, kn.h}, new int[]{kn.c(context, ha.a.colorButtonNormal), co.a(iA, i2), co.a(iA, i2), i2});
    }

    private ColorStateList e(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListB = kn.b(context, ha.a.colorSwitchThumbNormal);
        if (colorStateListB != null && colorStateListB.isStateful()) {
            iArr[0] = kn.a;
            iArr2[0] = colorStateListB.getColorForState(iArr[0], 0);
            iArr[1] = kn.e;
            iArr2[1] = kn.a(context, ha.a.colorControlActivated);
            iArr[2] = kn.h;
            iArr2[2] = colorStateListB.getDefaultColor();
        } else {
            iArr[0] = kn.a;
            iArr2[0] = kn.c(context, ha.a.colorSwitchThumbNormal);
            iArr[1] = kn.e;
            iArr2[1] = kn.a(context, ha.a.colorControlActivated);
            iArr[2] = kn.h;
            iArr2[2] = kn.a(context, ha.a.colorSwitchThumbNormal);
        }
        return new ColorStateList(iArr, iArr2);
    }

    static class b extends ea<Integer, PorterDuffColorFilter> {
        public b(int i) {
            super(i);
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
            return a(Integer.valueOf(b(i, mode)));
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return a(Integer.valueOf(b(i, mode)), porterDuffColorFilter);
        }

        private static int b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    static void a(Drawable drawable, kq kqVar, int[] iArr) {
        if (js.b(drawable) && drawable.mutate() != drawable) {
            Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (kqVar.d || kqVar.c) {
            drawable.setColorFilter(a(kqVar.d ? kqVar.a : null, kqVar.c ? kqVar.b : a, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return a(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterA = c.a(i2, mode);
        if (porterDuffColorFilterA == null) {
            PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i2, mode);
            c.a(i2, mode, porterDuffColorFilter);
            return porterDuffColorFilter;
        }
        return porterDuffColorFilterA;
    }

    private static void a(Drawable drawable, int i2, PorterDuff.Mode mode) {
        if (js.b(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = a;
        }
        drawable.setColorFilter(a(i2, mode));
    }

    private void f(Context context) {
        if (!this.p) {
            this.p = true;
            Drawable drawableA = a(context, ha.e.abc_vector_test);
            if (drawableA == null || !a(drawableA)) {
                this.p = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private static boolean a(Drawable drawable) {
        return (drawable instanceof an) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    static class d implements c {
        d() {
        }

        @Override // ix.c
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return an.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    static class a implements c {
        a() {
        }

        @Override // ix.c
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return ah.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }
}
