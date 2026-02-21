package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class ah extends am implements ag {
    final Drawable.Callback a;
    private a c;
    private Context d;
    private ArgbEvaluator e;
    private Animator.AnimatorListener f;
    private ArrayList<Object> g;

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
    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    ah() {
        this(null, null, null);
    }

    private ah(Context context) {
        this(context, null, null);
    }

    private ah(Context context, a aVar, Resources resources) {
        this.e = null;
        this.f = null;
        this.g = null;
        this.a = new Drawable.Callback() { // from class: ah.1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                ah.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                ah.this.scheduleSelf(runnable, j);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                ah.this.unscheduleSelf(runnable);
            }
        };
        this.d = context;
        if (aVar != null) {
            this.c = aVar;
        } else {
            this.c = new a(context, aVar, this.a, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.b != null) {
            this.b.mutate();
        }
        return this;
    }

    public static ah a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        ah ahVar = new ah(context);
        ahVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return ahVar;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.b == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new b(this.b.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.b != null ? this.b.getChangingConfigurations() : super.getChangingConfigurations() | this.c.a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.b != null) {
            this.b.draw(canvas);
            return;
        }
        this.c.b.draw(canvas);
        if (this.c.c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.b != null) {
            this.b.setBounds(rect);
        } else {
            this.c.b.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return this.b != null ? this.b.setState(iArr) : this.c.b.setState(iArr);
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.b != null ? this.b.setLevel(i) : this.c.b.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.b != null ? cw.c(this.b) : this.c.b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.b != null) {
            this.b.setAlpha(i);
        } else {
            this.c.b.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.b != null) {
            this.b.setColorFilter(colorFilter);
        } else {
            this.c.b.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable, defpackage.db
    public void setTint(int i) {
        if (this.b != null) {
            cw.a(this.b, i);
        } else {
            this.c.b.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, defpackage.db
    public void setTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            cw.a(this.b, colorStateList);
        } else {
            this.c.b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, defpackage.db
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.b != null) {
            cw.a(this.b, mode);
        } else {
            this.c.b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.b != null) {
            return this.b.setVisible(z, z2);
        }
        this.c.b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.b != null ? this.b.isStateful() : this.c.b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.b != null ? this.b.getOpacity() : this.c.b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.b != null ? this.b.getIntrinsicWidth() : this.c.b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.b != null ? this.b.getIntrinsicHeight() : this.c.b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.b != null ? cw.b(this.b) : this.c.b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.b != null) {
            cw.a(this.b, z);
        } else {
            this.c.b.setAutoMirrored(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.b != null) {
            cw.a(this.b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray typedArrayA = cn.a(resources, theme, attributeSet, af.e);
                    int resourceId = typedArrayA.getResourceId(0, 0);
                    if (resourceId != 0) {
                        an anVarA = an.a(resources, resourceId, theme);
                        anVarA.a(false);
                        anVarA.setCallback(this.a);
                        if (this.c.b != null) {
                            this.c.b.setCallback(null);
                        }
                        this.c.b = anVarA;
                    }
                    typedArrayA.recycle();
                } else if ("target".equals(name)) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, af.f);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.d != null) {
                            a(string, aj.a(this.d, resourceId2));
                        } else {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    typedArrayObtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.c.a();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // defpackage.am, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        if (this.b != null) {
            cw.a(this.b, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.b != null) {
            return cw.d(this.b);
        }
        return false;
    }

    static class b extends Drawable.ConstantState {
        private final Drawable.ConstantState a;

        public b(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            ah ahVar = new ah();
            ahVar.b = this.a.newDrawable();
            ahVar.b.setCallback(ahVar.a);
            return ahVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            ah ahVar = new ah();
            ahVar.b = this.a.newDrawable(resources);
            ahVar.b.setCallback(ahVar.a);
            return ahVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            ah ahVar = new ah();
            ahVar.b = this.a.newDrawable(resources, theme);
            ahVar.b.setCallback(ahVar.a);
            return ahVar;
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

    static class a extends Drawable.ConstantState {
        int a;
        an b;
        AnimatorSet c;
        du<Animator, String> d;
        private ArrayList<Animator> e;

        public a(Context context, a aVar, Drawable.Callback callback, Resources resources) {
            if (aVar != null) {
                this.a = aVar.a;
                if (aVar.b != null) {
                    Drawable.ConstantState constantState = aVar.b.getConstantState();
                    if (resources != null) {
                        this.b = (an) constantState.newDrawable(resources);
                    } else {
                        this.b = (an) constantState.newDrawable();
                    }
                    this.b = (an) this.b.mutate();
                    this.b.setCallback(callback);
                    this.b.setBounds(aVar.b.getBounds());
                    this.b.a(false);
                }
                if (aVar.e != null) {
                    int size = aVar.e.size();
                    this.e = new ArrayList<>(size);
                    this.d = new du<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = aVar.e.get(i);
                        Animator animatorClone = animator.clone();
                        String str = aVar.d.get(animator);
                        animatorClone.setTarget(this.b.a(str));
                        this.e.add(animatorClone);
                        this.d.put(animatorClone, str);
                    }
                    a();
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        public void a() {
            if (this.c == null) {
                this.c = new AnimatorSet();
            }
            this.c.playTogether(this.e);
        }
    }

    private void a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childAnimations.size()) {
                    break;
                }
                a(childAnimations.get(i2));
                i = i2 + 1;
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.e == null) {
                    this.e = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.e);
            }
        }
    }

    private void a(String str, Animator animator) {
        animator.setTarget(this.c.b.a(str));
        if (Build.VERSION.SDK_INT < 21) {
            a(animator);
        }
        if (this.c.e == null) {
            this.c.e = new ArrayList();
            this.c.d = new du<>();
        }
        this.c.e.add(animator);
        this.c.d.put(animator, str);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.b != null ? ((AnimatedVectorDrawable) this.b).isRunning() : this.c.c.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.b != null) {
            ((AnimatedVectorDrawable) this.b).start();
        } else if (!this.c.c.isStarted()) {
            this.c.c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.b != null) {
            ((AnimatedVectorDrawable) this.b).stop();
        } else {
            this.c.c.end();
        }
    }
}
