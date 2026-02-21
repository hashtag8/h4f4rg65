package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import defpackage.cp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class an extends am {
    static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
    private f c;
    private PorterDuffColorFilter d;
    private ColorFilter e;
    private boolean f;
    private boolean g;
    private Drawable.ConstantState h;
    private final float[] i;
    private final Matrix j;
    private final Rect k;

    @Override // defpackage.am, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    an() {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.c = new f();
    }

    an(f fVar) {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.c = fVar;
        this.d = a(this.d, fVar.c, fVar.d);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.b != null) {
            this.b.mutate();
        } else if (!this.f && super.mutate() == this) {
            this.c = new f(this.c);
            this.f = true;
        }
        return this;
    }

    Object a(String str) {
        return this.c.b.h.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.b != null && Build.VERSION.SDK_INT >= 24) {
            return new g(this.b.getConstantState());
        }
        this.c.a = getChangingConfigurations();
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.b != null) {
            this.b.draw(canvas);
            return;
        }
        copyBounds(this.k);
        if (this.k.width() > 0 && this.k.height() > 0) {
            ColorFilter colorFilter = this.e == null ? this.d : this.e;
            canvas.getMatrix(this.j);
            this.j.getValues(this.i);
            float fAbs = Math.abs(this.i[0]);
            float fAbs2 = Math.abs(this.i[4]);
            float fAbs3 = Math.abs(this.i[1]);
            float fAbs4 = Math.abs(this.i[3]);
            if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
                fAbs2 = 1.0f;
                fAbs = 1.0f;
            }
            int iMin = Math.min(2048, (int) (fAbs * this.k.width()));
            int iMin2 = Math.min(2048, (int) (fAbs2 * this.k.height()));
            if (iMin > 0 && iMin2 > 0) {
                int iSave = canvas.save();
                canvas.translate(this.k.left, this.k.top);
                if (a()) {
                    canvas.translate(this.k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.k.offsetTo(0, 0);
                this.c.b(iMin, iMin2);
                if (!this.g) {
                    this.c.a(iMin, iMin2);
                } else if (!this.c.b()) {
                    this.c.a(iMin, iMin2);
                    this.c.c();
                }
                this.c.a(canvas, colorFilter, this.k);
                canvas.restoreToCount(iSave);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.b != null ? cw.c(this.b) : this.c.b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.b != null) {
            this.b.setAlpha(i);
        } else if (this.c.b.getRootAlpha() != i) {
            this.c.b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.b != null) {
            this.b.setColorFilter(colorFilter);
        } else {
            this.e = colorFilter;
            invalidateSelf();
        }
    }

    PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable, defpackage.db
    public void setTint(int i) {
        if (this.b != null) {
            cw.a(this.b, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable, defpackage.db
    public void setTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            cw.a(this.b, colorStateList);
            return;
        }
        f fVar = this.c;
        if (fVar.c != colorStateList) {
            fVar.c = colorStateList;
            this.d = a(this.d, colorStateList, fVar.d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, defpackage.db
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.b != null) {
            cw.a(this.b, mode);
            return;
        }
        f fVar = this.c;
        if (fVar.d != mode) {
            fVar.d = mode;
            this.d = a(this.d, fVar.c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.b != null) {
            return this.b.isStateful();
        }
        return super.isStateful() || !(this.c == null || this.c.c == null || !this.c.c.isStateful());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.b != null) {
            return this.b.setState(iArr);
        }
        f fVar = this.c;
        if (fVar.c != null && fVar.d != null) {
            this.d = a(this.d, fVar.c, fVar.d);
            invalidateSelf();
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.b != null) {
            return this.b.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.b != null ? this.b.getIntrinsicWidth() : (int) this.c.b.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.b != null ? this.b.getIntrinsicHeight() : (int) this.c.b.c;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.b != null) {
            cw.d(this.b);
            return false;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.b != null ? cw.b(this.b) : this.c.e;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.b != null) {
            cw.a(this.b, z);
        } else {
            this.c.e = z;
        }
    }

    public static an a(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            an anVar = new an();
            anVar.b = cm.a(resources, i, theme);
            anVar.h = new g(anVar.b.getConstantState());
            return anVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
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
            return a(resources, xml, attributeSetAsAttributeSet, theme);
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    public static an a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        an anVar = new an();
        anVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return anVar;
    }

    static int a(int i, float f2) {
        return (((int) (Color.alpha(i) * f2)) << 24) | (16777215 & i);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.b != null) {
            this.b.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.b != null) {
            cw.a(this.b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        f fVar = this.c;
        fVar.b = new e();
        TypedArray typedArrayA = cn.a(resources, theme, attributeSet, af.a);
        a(typedArrayA, xmlPullParser);
        typedArrayA.recycle();
        fVar.a = getChangingConfigurations();
        fVar.k = true;
        b(resources, xmlPullParser, attributeSet, theme);
        this.d = a(this.d, fVar.c, fVar.d);
    }

    private static PorterDuff.Mode a(int i, PorterDuff.Mode mode) {
        switch (i) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 4:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            default:
                return mode;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                if (Build.VERSION.SDK_INT >= 11) {
                    return PorterDuff.Mode.ADD;
                }
                return mode;
        }
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        f fVar = this.c;
        e eVar = fVar.b;
        fVar.d = a(cn.a(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            fVar.c = colorStateList;
        }
        fVar.e = cn.a(typedArray, xmlPullParser, "autoMirrored", 5, fVar.e);
        eVar.d = cn.a(typedArray, xmlPullParser, "viewportWidth", 7, eVar.d);
        eVar.e = cn.a(typedArray, xmlPullParser, "viewportHeight", 8, eVar.e);
        if (eVar.d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (eVar.e <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        eVar.b = typedArray.getDimension(3, eVar.b);
        eVar.c = typedArray.getDimension(2, eVar.c);
        if (eVar.b <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (eVar.c <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        eVar.setAlpha(cn.a(typedArray, xmlPullParser, "alpha", 4, eVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            eVar.g = string;
            eVar.h.put(string, eVar);
        }
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        boolean z;
        f fVar = this.c;
        e eVar = fVar.b;
        Stack stack = new Stack();
        stack.push(eVar.a);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z2 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) stack.peek();
                if ("path".equals(name)) {
                    b bVar = new b();
                    bVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.a.add(bVar);
                    if (bVar.getPathName() != null) {
                        eVar.h.put(bVar.getPathName(), bVar);
                    }
                    z = false;
                    fVar.a = bVar.o | fVar.a;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    aVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.a.add(aVar);
                    if (aVar.getPathName() != null) {
                        eVar.h.put(aVar.getPathName(), aVar);
                    }
                    fVar.a |= aVar.o;
                    z = z2;
                } else {
                    if ("group".equals(name)) {
                        c cVar2 = new c();
                        cVar2.a(resources, attributeSet, theme, xmlPullParser);
                        cVar.a.add(cVar2);
                        stack.push(cVar2);
                        if (cVar2.getGroupName() != null) {
                            eVar.h.put(cVar2.getGroupName(), cVar2);
                        }
                        fVar.a |= cVar2.c;
                    }
                    z = z2;
                }
                z2 = z;
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                stack.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z2) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + ((Object) stringBuffer) + " defined");
        }
    }

    void a(boolean z) {
        this.g = z;
    }

    private boolean a() {
        if (Build.VERSION.SDK_INT >= 17) {
            return isAutoMirrored() && cw.g(this) == 1;
        }
        return false;
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.b != null) {
            this.b.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.b != null ? this.b.getChangingConfigurations() : super.getChangingConfigurations() | this.c.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.b != null) {
            this.b.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        if (this.b != null) {
            this.b.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.b != null ? this.b.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        if (this.b != null) {
            this.b.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    static class g extends Drawable.ConstantState {
        private final Drawable.ConstantState a;

        public g(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            an anVar = new an();
            anVar.b = (VectorDrawable) this.a.newDrawable();
            return anVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            an anVar = new an();
            anVar.b = (VectorDrawable) this.a.newDrawable(resources);
            return anVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            an anVar = new an();
            anVar.b = (VectorDrawable) this.a.newDrawable(resources, theme);
            return anVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }
    }

    static class f extends Drawable.ConstantState {
        int a;
        e b;
        ColorStateList c;
        PorterDuff.Mode d;
        boolean e;
        Bitmap f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public f(f fVar) {
            this.c = null;
            this.d = an.a;
            if (fVar != null) {
                this.a = fVar.a;
                this.b = new e(fVar.b);
                if (fVar.b.n != null) {
                    this.b.n = new Paint(fVar.b.n);
                }
                if (fVar.b.m != null) {
                    this.b.m = new Paint(fVar.b.m);
                }
                this.c = fVar.c;
                this.d = fVar.d;
                this.e = fVar.e;
            }
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f, (Rect) null, rect, a(colorFilter));
        }

        public boolean a() {
            return this.b.getRootAlpha() < 255;
        }

        public Paint a(ColorFilter colorFilter) {
            if (!a() && colorFilter == null) {
                return null;
            }
            if (this.l == null) {
                this.l = new Paint();
                this.l.setFilterBitmap(true);
            }
            this.l.setAlpha(this.b.getRootAlpha());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        public void a(int i, int i2) {
            this.f.eraseColor(0);
            this.b.a(new Canvas(this.f), i, i2, (ColorFilter) null);
        }

        public void b(int i, int i2) {
            if (this.f == null || !c(i, i2)) {
                this.f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        public boolean c(int i, int i2) {
            return i == this.f.getWidth() && i2 == this.f.getHeight();
        }

        public boolean b() {
            return !this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.b.getRootAlpha();
        }

        public void c() {
            this.g = this.c;
            this.h = this.d;
            this.i = this.b.getRootAlpha();
            this.j = this.e;
            this.k = false;
        }

        public f() {
            this.c = null;
            this.d = an.a;
            this.b = new e();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new an(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new an(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }
    }

    static class e {
        private static final Matrix k = new Matrix();
        final c a;
        float b;
        float c;
        float d;
        float e;
        int f;
        String g;
        final du<String, Object> h;
        private final Path i;
        private final Path j;
        private final Matrix l;
        private Paint m;
        private Paint n;
        private PathMeasure o;
        private int p;

        public e() {
            this.l = new Matrix();
            this.b = 0.0f;
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 255;
            this.g = null;
            this.h = new du<>();
            this.a = new c();
            this.i = new Path();
            this.j = new Path();
        }

        public void setRootAlpha(int i) {
            this.f = i;
        }

        public int getRootAlpha() {
            return this.f;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (255.0f * f));
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public e(e eVar) {
            this.l = new Matrix();
            this.b = 0.0f;
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 255;
            this.g = null;
            this.h = new du<>();
            this.a = new c(eVar.a, this.h);
            this.i = new Path(eVar.i);
            this.j = new Path(eVar.j);
            this.b = eVar.b;
            this.c = eVar.c;
            this.d = eVar.d;
            this.e = eVar.e;
            this.p = eVar.p;
            this.f = eVar.f;
            this.g = eVar.g;
            if (eVar.g != null) {
                this.h.put(eVar.g, this);
            }
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.d.set(matrix);
            cVar.d.preConcat(cVar.k);
            canvas.save();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < cVar.a.size()) {
                    Object obj = cVar.a.get(i4);
                    if (!(obj instanceof c)) {
                        if (obj instanceof d) {
                            a(cVar, (d) obj, canvas, i, i2, colorFilter);
                        }
                    } else {
                        a((c) obj, cVar.d, canvas, i, i2, colorFilter);
                    }
                    i3 = i4 + 1;
                } else {
                    canvas.restore();
                    return;
                }
            }
        }

        public void a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            a(this.a, k, canvas, i, i2, colorFilter);
        }

        private void a(c cVar, d dVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = i / this.d;
            float f2 = i2 / this.e;
            float fMin = Math.min(f, f2);
            Matrix matrix = cVar.d;
            this.l.set(matrix);
            this.l.postScale(f, f2);
            float fA = a(matrix);
            if (fA != 0.0f) {
                dVar.a(this.i);
                Path path = this.i;
                this.j.reset();
                if (dVar.a()) {
                    this.j.addPath(path, this.l);
                    canvas.clipPath(this.j);
                    return;
                }
                b bVar = (b) dVar;
                if (bVar.g != 0.0f || bVar.h != 1.0f) {
                    float f3 = (bVar.g + bVar.i) % 1.0f;
                    float f4 = (bVar.h + bVar.i) % 1.0f;
                    if (this.o == null) {
                        this.o = new PathMeasure();
                    }
                    this.o.setPath(this.i, false);
                    float length = this.o.getLength();
                    float f5 = f3 * length;
                    float f6 = f4 * length;
                    path.reset();
                    if (f5 > f6) {
                        this.o.getSegment(f5, length, path, true);
                        this.o.getSegment(0.0f, f6, path, true);
                    } else {
                        this.o.getSegment(f5, f6, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.j.addPath(path, this.l);
                if (bVar.c != 0) {
                    if (this.n == null) {
                        this.n = new Paint();
                        this.n.setStyle(Paint.Style.FILL);
                        this.n.setAntiAlias(true);
                    }
                    Paint paint = this.n;
                    paint.setColor(an.a(bVar.c, bVar.f));
                    paint.setColorFilter(colorFilter);
                    this.j.setFillType(bVar.e == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    canvas.drawPath(this.j, paint);
                }
                if (bVar.a != 0) {
                    if (this.m == null) {
                        this.m = new Paint();
                        this.m.setStyle(Paint.Style.STROKE);
                        this.m.setAntiAlias(true);
                    }
                    Paint paint2 = this.m;
                    if (bVar.k != null) {
                        paint2.setStrokeJoin(bVar.k);
                    }
                    if (bVar.j != null) {
                        paint2.setStrokeCap(bVar.j);
                    }
                    paint2.setStrokeMiter(bVar.l);
                    paint2.setColor(an.a(bVar.a, bVar.d));
                    paint2.setColorFilter(colorFilter);
                    paint2.setStrokeWidth(fA * fMin * bVar.b);
                    canvas.drawPath(this.j, paint2);
                }
            }
        }

        private static float a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private float a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float fA = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = Math.max(fHypot, fHypot2);
            if (fMax > 0.0f) {
                return Math.abs(fA) / fMax;
            }
            return 0.0f;
        }
    }

    static class c {
        final ArrayList<Object> a;
        float b;
        int c;
        private final Matrix d;
        private float e;
        private float f;
        private float g;
        private float h;
        private float i;
        private float j;
        private final Matrix k;
        private int[] l;
        private String m;

        public c(c cVar, du<String, Object> duVar) {
            d aVar;
            this.d = new Matrix();
            this.a = new ArrayList<>();
            this.b = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 1.0f;
            this.h = 1.0f;
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = new Matrix();
            this.m = null;
            this.b = cVar.b;
            this.e = cVar.e;
            this.f = cVar.f;
            this.g = cVar.g;
            this.h = cVar.h;
            this.i = cVar.i;
            this.j = cVar.j;
            this.l = cVar.l;
            this.m = cVar.m;
            this.c = cVar.c;
            if (this.m != null) {
                duVar.put(this.m, this);
            }
            this.k.set(cVar.k);
            ArrayList<Object> arrayList = cVar.a;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    Object obj = arrayList.get(i2);
                    if (obj instanceof c) {
                        this.a.add(new c((c) obj, duVar));
                    } else {
                        if (obj instanceof b) {
                            aVar = new b((b) obj);
                        } else if (obj instanceof a) {
                            aVar = new a((a) obj);
                        } else {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        this.a.add(aVar);
                        if (aVar.n != null) {
                            duVar.put(aVar.n, aVar);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        public c() {
            this.d = new Matrix();
            this.a = new ArrayList<>();
            this.b = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 1.0f;
            this.h = 1.0f;
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = new Matrix();
            this.m = null;
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.k;
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayA = cn.a(resources, theme, attributeSet, af.b);
            a(typedArrayA, xmlPullParser);
            typedArrayA.recycle();
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.b = cn.a(typedArray, xmlPullParser, "rotation", 5, this.b);
            this.e = typedArray.getFloat(1, this.e);
            this.f = typedArray.getFloat(2, this.f);
            this.g = cn.a(typedArray, xmlPullParser, "scaleX", 3, this.g);
            this.h = cn.a(typedArray, xmlPullParser, "scaleY", 4, this.h);
            this.i = cn.a(typedArray, xmlPullParser, "translateX", 6, this.i);
            this.j = cn.a(typedArray, xmlPullParser, "translateY", 7, this.j);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            a();
        }

        private void a() {
            this.k.reset();
            this.k.postTranslate(-this.e, -this.f);
            this.k.postScale(this.g, this.h);
            this.k.postRotate(this.b, 0.0f, 0.0f);
            this.k.postTranslate(this.i + this.e, this.j + this.f);
        }

        public float getRotation() {
            return this.b;
        }

        public void setRotation(float f) {
            if (f != this.b) {
                this.b = f;
                a();
            }
        }

        public float getPivotX() {
            return this.e;
        }

        public void setPivotX(float f) {
            if (f != this.e) {
                this.e = f;
                a();
            }
        }

        public float getPivotY() {
            return this.f;
        }

        public void setPivotY(float f) {
            if (f != this.f) {
                this.f = f;
                a();
            }
        }

        public float getScaleX() {
            return this.g;
        }

        public void setScaleX(float f) {
            if (f != this.g) {
                this.g = f;
                a();
            }
        }

        public float getScaleY() {
            return this.h;
        }

        public void setScaleY(float f) {
            if (f != this.h) {
                this.h = f;
                a();
            }
        }

        public float getTranslateX() {
            return this.i;
        }

        public void setTranslateX(float f) {
            if (f != this.i) {
                this.i = f;
                a();
            }
        }

        public float getTranslateY() {
            return this.j;
        }

        public void setTranslateY(float f) {
            if (f != this.j) {
                this.j = f;
                a();
            }
        }
    }

    static class d {
        protected cp.b[] m;
        String n;
        int o;

        public d() {
            this.m = null;
        }

        public d(d dVar) {
            this.m = null;
            this.n = dVar.n;
            this.o = dVar.o;
            this.m = cp.a(dVar.m);
        }

        public void a(Path path) {
            path.reset();
            if (this.m != null) {
                cp.b.a(this.m, path);
            }
        }

        public String getPathName() {
            return this.n;
        }

        public boolean a() {
            return false;
        }

        public cp.b[] getPathData() {
            return this.m;
        }

        public void setPathData(cp.b[] bVarArr) {
            if (!cp.a(this.m, bVarArr)) {
                this.m = cp.a(bVarArr);
            } else {
                cp.b(this.m, bVarArr);
            }
        }
    }

    static class a extends d {
        public a() {
        }

        public a(a aVar) {
            super(aVar);
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (cn.a(xmlPullParser, "pathData")) {
                TypedArray typedArrayA = cn.a(resources, theme, attributeSet, af.d);
                a(typedArrayA);
                typedArrayA.recycle();
            }
        }

        private void a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.n = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.m = cp.b(string2);
            }
        }

        @Override // an.d
        public boolean a() {
            return true;
        }
    }

    static class b extends d {
        int a;
        float b;
        int c;
        float d;
        int e;
        float f;
        float g;
        float h;
        float i;
        Paint.Cap j;
        Paint.Join k;
        float l;
        private int[] p;

        public b() {
            this.a = 0;
            this.b = 0.0f;
            this.c = 0;
            this.d = 1.0f;
            this.e = 0;
            this.f = 1.0f;
            this.g = 0.0f;
            this.h = 1.0f;
            this.i = 0.0f;
            this.j = Paint.Cap.BUTT;
            this.k = Paint.Join.MITER;
            this.l = 4.0f;
        }

        public b(b bVar) {
            super(bVar);
            this.a = 0;
            this.b = 0.0f;
            this.c = 0;
            this.d = 1.0f;
            this.e = 0;
            this.f = 1.0f;
            this.g = 0.0f;
            this.h = 1.0f;
            this.i = 0.0f;
            this.j = Paint.Cap.BUTT;
            this.k = Paint.Join.MITER;
            this.l = 4.0f;
            this.p = bVar.p;
            this.a = bVar.a;
            this.b = bVar.b;
            this.d = bVar.d;
            this.c = bVar.c;
            this.e = bVar.e;
            this.f = bVar.f;
            this.g = bVar.g;
            this.h = bVar.h;
            this.i = bVar.i;
            this.j = bVar.j;
            this.k = bVar.k;
            this.l = bVar.l;
        }

        private Paint.Cap a(int i, Paint.Cap cap) {
            switch (i) {
                case 0:
                    return Paint.Cap.BUTT;
                case 1:
                    return Paint.Cap.ROUND;
                case 2:
                    return Paint.Cap.SQUARE;
                default:
                    return cap;
            }
        }

        private Paint.Join a(int i, Paint.Join join) {
            switch (i) {
                case 0:
                    return Paint.Join.MITER;
                case 1:
                    return Paint.Join.ROUND;
                case 2:
                    return Paint.Join.BEVEL;
                default:
                    return join;
            }
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayA = cn.a(resources, theme, attributeSet, af.c);
            a(typedArrayA, xmlPullParser);
            typedArrayA.recycle();
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.p = null;
            if (cn.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.n = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.m = cp.b(string2);
                }
                this.c = cn.b(typedArray, xmlPullParser, "fillColor", 1, this.c);
                this.f = cn.a(typedArray, xmlPullParser, "fillAlpha", 12, this.f);
                this.j = a(cn.a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.j);
                this.k = a(cn.a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.k);
                this.l = cn.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.l);
                this.a = cn.b(typedArray, xmlPullParser, "strokeColor", 3, this.a);
                this.d = cn.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.d);
                this.b = cn.a(typedArray, xmlPullParser, "strokeWidth", 4, this.b);
                this.h = cn.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.h);
                this.i = cn.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.i);
                this.g = cn.a(typedArray, xmlPullParser, "trimPathStart", 5, this.g);
                this.e = cn.a(typedArray, xmlPullParser, "fillType", 13, this.e);
            }
        }

        int getStrokeColor() {
            return this.a;
        }

        void setStrokeColor(int i) {
            this.a = i;
        }

        float getStrokeWidth() {
            return this.b;
        }

        void setStrokeWidth(float f) {
            this.b = f;
        }

        float getStrokeAlpha() {
            return this.d;
        }

        void setStrokeAlpha(float f) {
            this.d = f;
        }

        int getFillColor() {
            return this.c;
        }

        void setFillColor(int i) {
            this.c = i;
        }

        float getFillAlpha() {
            return this.f;
        }

        void setFillAlpha(float f) {
            this.f = f;
        }

        float getTrimPathStart() {
            return this.g;
        }

        void setTrimPathStart(float f) {
            this.g = f;
        }

        float getTrimPathEnd() {
            return this.h;
        }

        void setTrimPathEnd(float f) {
            this.h = f;
        }

        float getTrimPathOffset() {
            return this.i;
        }

        void setTrimPathOffset(float f) {
            this.i = f;
        }
    }
}
