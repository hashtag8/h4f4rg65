package com.harman.hkconnect.musicservice.musicserver.deezer;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.TypefaceTextView;
import defpackage.ahn;
import defpackage.ahu;
import defpackage.amd;
import defpackage.ame;
import defpackage.mm;

/* JADX INFO: loaded from: classes.dex */
public class TabPageIndicator extends HorizontalScrollView implements ame {
    private static final CharSequence a = "";
    private Runnable b;
    private final View.OnClickListener c;
    private final amd d;
    private ViewPager.f e;
    private int f;
    private int g;
    private a h;
    private CharSequence[] i;

    public interface a {
        void a(int i);
    }

    public TabPageIndicator(Context context) {
        this(context, null);
    }

    public TabPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new View.OnClickListener() { // from class: com.harman.hkconnect.musicservice.musicserver.deezer.TabPageIndicator.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int iA = ((b) view).a();
                TabPageIndicator.this.setCurrentItem(iA);
                mm.b("onClick  " + iA, new Object[0]);
                if (TabPageIndicator.this.h != null) {
                    TabPageIndicator.this.h.a(iA);
                }
            }
        };
        this.i = null;
        setHorizontalScrollBarEnabled(false);
        this.d = new amd(context, R.attr.vpiTabPageIndicatorStyle);
        addView(this.d, new ViewGroup.LayoutParams(-2, -1));
    }

    public void setOnTabReselectedListener(a aVar) {
        this.h = aVar;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.d.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.f = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.f = View.MeasureSpec.getSize(i) / 2;
            }
        } else {
            this.f = -1;
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, i2);
        int measuredWidth2 = getMeasuredWidth();
        if (z && measuredWidth != measuredWidth2) {
            setCurrentItem(this.g);
        }
    }

    private void c(int i) {
        final View childAt = this.d.getChildAt(i);
        if (this.b != null) {
            removeCallbacks(this.b);
        }
        this.b = new Runnable() { // from class: com.harman.hkconnect.musicservice.musicserver.deezer.TabPageIndicator.2
            @Override // java.lang.Runnable
            public void run() {
                TabPageIndicator.this.smoothScrollTo(childAt.getLeft() - ((TabPageIndicator.this.getWidth() - childAt.getWidth()) / 2), 0);
                TabPageIndicator.this.b = null;
            }
        };
        post(this.b);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b != null) {
            post(this.b);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b != null) {
            removeCallbacks(this.b);
        }
    }

    private void a(int i, CharSequence charSequence, int i2) {
        b bVar = new b(getContext());
        bVar.b = i;
        bVar.setFocusable(true);
        bVar.setOnClickListener(this.c);
        bVar.setText(charSequence);
        if (i2 != 0) {
            bVar.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        layoutParams.leftMargin = ahn.a(getContext(), 7.0f);
        layoutParams.rightMargin = ahn.a(getContext(), 7.0f);
        bVar.setTypeface(ahu.a(getContext()));
        this.d.addView(bVar, layoutParams);
    }

    @Override // android.support.v4.view.ViewPager.f
    public void a(int i) {
        if (this.e != null) {
            this.e.a(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.f
    public void a(int i, float f, int i2) {
        if (this.e != null) {
            this.e.a(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.f
    public void b(int i) {
        setCurrentItem(i);
        if (this.e != null) {
            this.e.b(i);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        a();
    }

    public void setTitles(CharSequence[] charSequenceArr) {
        this.i = charSequenceArr;
        a();
    }

    public void a() {
        this.d.removeAllViews();
        int length = this.i.length;
        for (int i = 0; i < length; i++) {
            CharSequence charSequence = this.i[i];
            if (charSequence == null) {
                charSequence = a;
            }
            a(i, charSequence, 0);
        }
        if (this.g > length) {
            this.g = length - 1;
        }
        setCurrentItem(this.g);
        requestLayout();
    }

    public void setCurrentItem(int i) {
        this.g = i;
        int childCount = this.d.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.d.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                c(i);
            }
            i2++;
        }
    }

    public void setOnPageChangeListener(ViewPager.f fVar) {
        this.e = fVar;
    }

    class b extends TypefaceTextView {
        private int b;

        public b(Context context) {
            super(context, null, R.attr.vpiTabPageIndicatorStyle);
        }

        @Override // com.harman.hkconnect.ui.custom.TypefaceTextView, android.widget.TextView, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
        }

        public int a() {
            return this.b;
        }
    }
}
