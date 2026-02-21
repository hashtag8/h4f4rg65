package com.harman.hkconnect.ui.slider;

import android.R;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import defpackage.ahu;
import defpackage.asu;
import defpackage.ex;

/* JADX INFO: loaded from: classes.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    View a;
    private int b;
    private int c;
    private int d;
    private ViewPager e;
    private ViewPager.f f;
    private final asu g;

    public interface c {
        int a(int i);

        int b(int i);
    }

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.b = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.g = new asu(context);
        addView(this.g, -1, -2);
    }

    public void setCustomTabColorizer(c cVar) {
        this.g.a(cVar);
    }

    public void setSelectedIndicatorColors(int... iArr) {
        this.g.a(iArr);
    }

    public void setDividerColors(int... iArr) {
        this.g.b(iArr);
    }

    public void setOnPageChangeListener(ViewPager.f fVar) {
        this.f = fVar;
    }

    public void a(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    public void setViewPager(ViewPager viewPager) {
        this.g.removeAllViews();
        this.e = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a());
            a();
        }
    }

    protected TextView a(Context context) {
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setTextSize(2, 12.0f);
        textView.setTypeface(ahu.b(context));
        if (Build.VERSION.SDK_INT >= 11) {
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
            textView.setBackgroundResource(typedValue.resourceId);
        }
        if (Build.VERSION.SDK_INT >= 14) {
            textView.setAllCaps(true);
        }
        int i = (int) (16.0f * getResources().getDisplayMetrics().density);
        textView.setPadding(i, i, i, i);
        return textView;
    }

    private void a() {
        TextView textView;
        View viewA;
        ex adapter = this.e.getAdapter();
        b bVar = new b();
        for (int i = 0; i < adapter.b(); i++) {
            if (this.c != 0) {
                viewA = LayoutInflater.from(getContext()).inflate(this.c, (ViewGroup) this.g, false);
                textView = (TextView) viewA.findViewById(this.d);
            } else {
                textView = null;
                viewA = null;
            }
            if (viewA == null) {
                viewA = a(getContext());
            }
            if (textView == null && TextView.class.isInstance(viewA)) {
                textView = (TextView) viewA;
            }
            textView.setText(adapter.c(i));
            viewA.setOnClickListener(bVar);
            this.g.addView(viewA);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.e != null) {
            b(this.e.getCurrentItem(), 0);
        }
    }

    private void b() {
        if (this.a != null) {
            this.a.setSelected(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        View childAt;
        int childCount = this.g.getChildCount();
        if (childCount != 0 && i >= 0 && i < childCount && (childAt = this.g.getChildAt(i)) != null) {
            if (i2 == 0 && childAt != this.a) {
                childAt.setSelected(true);
                b();
                this.a = childAt;
            }
            int left = childAt.getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.b;
            }
            scrollTo(left, 0);
        }
    }

    class a implements ViewPager.f {
        private int b;

        private a() {
        }

        @Override // android.support.v4.view.ViewPager.f
        public void a(int i, float f, int i2) {
            int childCount = SlidingTabLayout.this.g.getChildCount();
            if (childCount != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.g.a(i, f);
                SlidingTabLayout.this.b(i, SlidingTabLayout.this.g.getChildAt(i) != null ? (int) (r0.getWidth() * f) : 0);
                if (SlidingTabLayout.this.f != null) {
                    SlidingTabLayout.this.f.a(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.f
        public void a(int i) {
            this.b = i;
            if (SlidingTabLayout.this.f != null) {
                SlidingTabLayout.this.f.a(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.f
        public void b(int i) {
            if (this.b == 0) {
                SlidingTabLayout.this.g.a(i, 0.0f);
                SlidingTabLayout.this.b(i, 0);
            }
            if (SlidingTabLayout.this.f != null) {
                SlidingTabLayout.this.f.b(i);
            }
        }
    }

    class b implements View.OnClickListener {
        private b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (int i = 0; i < SlidingTabLayout.this.g.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.g.getChildAt(i)) {
                    SlidingTabLayout.this.e.setCurrentItem(i);
                    return;
                }
            }
        }
    }
}
