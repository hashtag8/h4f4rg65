package com.harman.hkconnect.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.TypefaceTextView;
import defpackage.ady;
import defpackage.adz;
import defpackage.agt;
import defpackage.ahu;
import defpackage.aof;
import defpackage.aqn;
import defpackage.brs;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class DragOverlayGrid extends RelativeLayout {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private Context e;
    private LinearLayout f;
    private LayoutInflater g;
    private ScrollView h;
    private View i;
    private int j;
    private int k;
    private ArrayList<View> l;
    private adz m;
    private List<adz> n;

    public DragOverlayGrid(Context context) {
        super(context);
        this.a = getResources().getDimensionPixelSize(R.dimen.room_overlay_large_background_size);
        this.b = getResources().getDimensionPixelSize(R.dimen.room_overlay_large_animation_size);
        this.c = getResources().getDimensionPixelSize(R.dimen.room_overlay_small_background_size);
        this.d = getResources().getDimensionPixelSize(R.dimen.room_overlay_small_animation_size);
        this.j = -1;
        this.k = -1;
        this.l = new ArrayList<>();
        this.m = null;
        this.e = context;
        g();
    }

    public DragOverlayGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = getResources().getDimensionPixelSize(R.dimen.room_overlay_large_background_size);
        this.b = getResources().getDimensionPixelSize(R.dimen.room_overlay_large_animation_size);
        this.c = getResources().getDimensionPixelSize(R.dimen.room_overlay_small_background_size);
        this.d = getResources().getDimensionPixelSize(R.dimen.room_overlay_small_animation_size);
        this.j = -1;
        this.k = -1;
        this.l = new ArrayList<>();
        this.m = null;
        this.e = context;
        g();
    }

    private void g() {
        this.g = LayoutInflater.from(this.e);
        this.i = this.g.inflate(R.layout.drag_overlay_grid, this);
        this.f = (LinearLayout) this.i.findViewById(R.id.overlay_drag_listview);
        this.h = (ScrollView) this.i.findViewById(R.id.rooms_scrollview);
        ((WindowManager) this.e.getSystemService("window")).getDefaultDisplay().getSize(new Point());
        setOnTouchListener(new View.OnTouchListener() { // from class: com.harman.hkconnect.ui.DragOverlayGrid.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    public void a() {
        this.l = new ArrayList<>();
        this.n = aof.a().d();
        h();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        startAnimation(alphaAnimation);
        setVisibility(0);
    }

    public void b() {
        e();
        this.l.clear();
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        startAnimation(alphaAnimation);
        setVisibility(8);
    }

    public boolean c() {
        return this.l.size() != 0;
    }

    public void d() {
        this.n = aof.a().d();
        h();
    }

    public adz getItemByIndex() {
        return this.m;
    }

    private void a(View view, int i) {
        aqn aqnVar = (aqn) view.getTag();
        aqnVar.e.setVisibility(0);
        aqnVar.g.setVisibility(0);
        aqnVar.f.setVisibility(0);
        aqnVar.e.clearAnimation();
        aqnVar.f.clearAnimation();
        agt.a(aqnVar.e, aqnVar.f, aqnVar.g, aqnVar.k, i);
    }

    private void a(View view) {
        aqn aqnVar = (aqn) view.getTag();
        aqnVar.e.clearAnimation();
        aqnVar.e.setVisibility(8);
        aqnVar.f.clearAnimation();
        aqnVar.f.setVisibility(8);
        aqnVar.g.clearAnimation();
    }

    public void e() {
        for (View view : this.l) {
            aqn aqnVar = (aqn) view.getTag();
            if (this.l.size() != 0) {
                aqnVar.l.setVisibility(4);
                a(view);
            } else {
                aqnVar.l.setVisibility(0);
            }
        }
        this.l.clear();
    }

    public Point a(int i, int i2) {
        View viewA;
        if (this.m == null || (viewA = a(this.m, this.f)) == null) {
            return null;
        }
        ImageView imageView = (ImageView) viewA.findViewById(R.id.current_track_image);
        int[] iArr = new int[2];
        imageView.getLocationOnScreen(iArr);
        imageView.getLocationInWindow(new int[2]);
        return new Point(iArr[0], iArr[1]);
    }

    private boolean a(int i, int i2, View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        return new Rect(i3, i4, view.getWidth() + i3, view.getHeight() + i4).contains(i, i2);
    }

    private adz c(int i, int i2) {
        int i3;
        int childCount = this.f.getChildCount() - 1;
        while (true) {
            if (childCount < 0) {
                i3 = -1;
                break;
            }
            View childAt = this.f.getChildAt(childCount);
            int top = 0;
            for (View view = this.f; view != this.i; view = (View) view.getParent()) {
                top += view.getTop();
            }
            if (childAt.getY() < (i2 - top) + this.h.getScrollY()) {
                i3 = childCount;
                break;
            }
            childCount--;
        }
        if (i3 != -1) {
            ViewGroup viewGroup = (ViewGroup) this.f.getChildAt(i3);
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                aqn aqnVar = (aqn) ((RelativeLayout) viewGroup.getChildAt(i4)).getTag();
                if (a(i, i2, aqnVar.d)) {
                    return aqnVar.a;
                }
            }
        }
        return null;
    }

    private adz d(int i, int i2) {
        adz adzVarC = c(i, i2);
        if (adzVarC == null) {
            e();
            return null;
        }
        return adzVarC;
    }

    public void b(int i, int i2) {
        this.m = d(i, i2);
        if (this.m != null) {
            if (!this.l.contains(a(this.m, this.f))) {
                e();
                ady adyVarC = aof.a().c(this.m.x());
                if (adyVarC != null) {
                    for (adz adzVar : adyVarC.f()) {
                        View viewA = a(adzVar, this.f);
                        if (viewA != null) {
                            this.l.add(viewA);
                            ImageView imageView = (ImageView) viewA.findViewById(R.id.overlay_grid_item_border);
                            int iQ = adzVar.q();
                            int iRgb = Color.rgb(Color.red(iQ), Color.green(iQ), Color.blue(iQ));
                            agt.a(viewA.findViewById(R.id.ripple_effect_view), R.drawable.circle_shape, HttpStatus.SC_BAD_REQUEST, iQ, 1.2f);
                            a(viewA, iRgb);
                            imageView.setVisibility(0);
                        }
                    }
                }
            }
        }
    }

    private void h() {
        for (int i = 0; i < f(); i++) {
            if (this.f.getChildCount() <= i) {
                this.f.addView(a(i, (View) null));
            } else {
                a(i, this.f.getChildAt(i));
            }
        }
        while (f() < this.f.getChildCount()) {
            this.f.removeViewAt(this.f.getChildCount() - 1);
        }
        b(this.j, this.k);
    }

    public int f() {
        int size = this.n.size();
        if (size == 0) {
            return 0;
        }
        return ((size - 1) / 3) + 1;
    }

    private void a(RelativeLayout relativeLayout, int i, int i2, RelativeLayout relativeLayout2) {
        aqn aqnVar = (aqn) relativeLayout2.getTag();
        if (aqnVar.b != i || aqnVar.c != i2) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
            Resources resources = getResources();
            if (i2 == 1) {
                layoutParams.setMargins(0, 0, 0, 0);
            } else if (i2 == 2) {
                layoutParams.setMargins(resources.getDimensionPixelSize(R.dimen.room_overlay_margin_two_speakers), 0, resources.getDimensionPixelSize(R.dimen.room_overlay_margin_two_speakers), 0);
            } else if (i2 == 3) {
                layoutParams.setMargins(resources.getDimensionPixelSize(R.dimen.room_overlay_margin_three_speakers), 0, resources.getDimensionPixelSize(R.dimen.room_overlay_margin_three_speakers), 0);
            } else if (i2 == 4) {
                layoutParams.setMargins(resources.getDimensionPixelSize(R.dimen.room_overlay_margin_four_speakers), 0, resources.getDimensionPixelSize(R.dimen.room_overlay_margin_four_speakers), 0);
            } else if (i2 == 5) {
                if (i == 1) {
                    layoutParams.setMargins(resources.getDimensionPixelSize(R.dimen.room_overlay_margin_five_speakers_first_row), 0, resources.getDimensionPixelSize(R.dimen.room_overlay_margin_five_speakers_first_row), 0);
                } else {
                    layoutParams.setMargins(resources.getDimensionPixelSize(R.dimen.room_overlay_margin_five_speakers_second_row), 0, resources.getDimensionPixelSize(R.dimen.room_overlay_margin_five_speakers_second_row), 0);
                }
            } else {
                layoutParams.setMargins(resources.getDimensionPixelSize(R.dimen.room_overlay_margin_full_grid), 0, resources.getDimensionPixelSize(R.dimen.room_overlay_margin_full_grid), 0);
            }
            if (i2 == 1 || i2 == 2 || i2 == 4) {
                a(relativeLayout);
            } else {
                b(relativeLayout);
            }
        }
    }

    private void a(RelativeLayout relativeLayout) {
        aqn aqnVar = (aqn) relativeLayout.getTag();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aqnVar.d.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aqnVar.e.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) aqnVar.f.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) aqnVar.g.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) aqnVar.h.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) aqnVar.i.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) aqnVar.l.getLayoutParams();
        int i = this.a;
        layoutParams.height = i;
        layoutParams.width = i;
        int i2 = this.b;
        layoutParams2.height = i2;
        layoutParams2.width = i2;
        int i3 = this.b;
        layoutParams3.height = i3;
        layoutParams3.width = i3;
        int i4 = this.b;
        layoutParams4.height = i4;
        layoutParams4.width = i4;
        int i5 = this.a;
        layoutParams5.height = i5;
        layoutParams5.width = i5;
        int i6 = this.b;
        layoutParams6.height = i6;
        layoutParams6.width = i6;
        int i7 = this.a;
        layoutParams7.height = i7;
        layoutParams7.width = i7;
    }

    private void b(RelativeLayout relativeLayout) {
        aqn aqnVar = (aqn) relativeLayout.getTag();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aqnVar.d.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aqnVar.e.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) aqnVar.f.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) aqnVar.g.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) aqnVar.h.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) aqnVar.i.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) aqnVar.l.getLayoutParams();
        int i = this.c;
        layoutParams.height = i;
        layoutParams.width = i;
        int i2 = this.d;
        layoutParams2.height = i2;
        layoutParams2.width = i2;
        int i3 = this.d;
        layoutParams3.height = i3;
        layoutParams3.width = i3;
        int i4 = this.d;
        layoutParams4.height = i4;
        layoutParams4.width = i4;
        int i5 = this.c;
        layoutParams5.height = i5;
        layoutParams5.width = i5;
        int i6 = this.d;
        layoutParams6.height = i6;
        layoutParams6.width = i6;
        int i7 = this.c;
        layoutParams7.height = i7;
        layoutParams7.width = i7;
    }

    private void a(RelativeLayout relativeLayout, int i) {
        aqn aqnVar = (aqn) relativeLayout.getTag();
        aqnVar.e.clearAnimation();
        aqnVar.k.setText(this.n.get(i).l());
        aqnVar.m.setImageResource(this.n.get(i).m());
        int iQ = this.n.get(i).q();
        int iRgb = Color.rgb(Color.red(iQ), Color.green(iQ), Color.blue(iQ));
        aqnVar.m.setColorFilter(iRgb, PorterDuff.Mode.MULTIPLY);
        aqnVar.l.setColorFilter(iRgb, PorterDuff.Mode.MULTIPLY);
        aqnVar.k.setTextColor(iRgb);
    }

    private int a(int i, int i2, int i3) {
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2 || i3 == 3) {
            return i2 - 1;
        }
        if (i3 == 4) {
            return ((i - 1) * 2) + (i2 - 1);
        }
        if (i3 == 5) {
            if (i == 1) {
                return i2 - 1;
            }
            return i2 + 2;
        }
        return ((i - 1) * 3) + (i2 - 1);
    }

    private int e(int i, int i2) {
        if (1 <= i2 && i2 <= 3) {
            return i2;
        }
        if (i2 == 4) {
            return 2;
        }
        if (i2 == 5) {
            return i != 1 ? 2 : 3;
        }
        if (i2 == 6 || i <= (i2 - 1) / 3 || i2 % 3 == 0) {
            return 3;
        }
        return i2 % 3;
    }

    public View a(int i, View view) {
        LinearLayout linearLayout;
        if (view == null) {
            linearLayout = new LinearLayout(this.e);
            linearLayout.setGravity(17);
        } else {
            linearLayout = (LinearLayout) view;
        }
        int childCount = linearLayout.getChildCount();
        int size = this.n.size();
        int i2 = i + 1;
        int iE = e(i2, size);
        if (childCount < iE) {
            for (int i3 = 0; i3 < iE - childCount; i3++) {
                View viewInflate = this.g.inflate(R.layout.overlay_grid_item, (ViewGroup) null);
                aqn aqnVar = new aqn();
                aqnVar.b = -1;
                aqnVar.c = -1;
                aqnVar.a = null;
                aqnVar.d = viewInflate.findViewById(R.id.animation_layout_container);
                aqnVar.e = viewInflate.findViewById(R.id.animation_background);
                aqnVar.f = viewInflate.findViewById(R.id.animation_smallCircle);
                aqnVar.g = viewInflate.findViewById(R.id.animation_bigCircle);
                aqnVar.h = viewInflate.findViewById(R.id.ripple_effect_layout);
                aqnVar.i = viewInflate.findViewById(R.id.ripple_effect_view);
                aqnVar.j = viewInflate.findViewById(R.id.overlay_grid_item_border);
                aqnVar.k = (TypefaceTextView) viewInflate.findViewById(R.id.overlay_icon_text);
                aqnVar.m = (ImageView) viewInflate.findViewById(R.id.overlay_icon_id);
                aqnVar.l = (ImageView) viewInflate.findViewById(R.id.overlay_grid_item_border);
                viewInflate.setTag(aqnVar);
                linearLayout.addView(viewInflate);
            }
        } else if (childCount > iE) {
            for (int i4 = 0; i4 < childCount - iE; i4++) {
                linearLayout.removeViewAt(0);
            }
        }
        for (int i5 = 0; i5 < iE; i5++) {
            RelativeLayout relativeLayout = (RelativeLayout) linearLayout.getChildAt(i5);
            int iA = a(i2, i5 + 1, size);
            a(relativeLayout, i2, size, relativeLayout);
            a(relativeLayout, iA);
            adz adzVar = this.n.get(iA);
            aqn aqnVar2 = (aqn) relativeLayout.getTag();
            aqnVar2.b = i2;
            aqnVar2.c = size;
            aqnVar2.a = adzVar;
            b((View) relativeLayout);
        }
        return linearLayout;
    }

    private void b(View view) {
        aqn aqnVar = (aqn) view.getTag();
        aqnVar.e.clearAnimation();
        aqnVar.e.setVisibility(8);
        aqnVar.f.clearAnimation();
        aqnVar.f.setVisibility(8);
        aqnVar.g.clearAnimation();
        aqnVar.l.setVisibility(4);
        aqnVar.k.setTypeface(ahu.a(this.e));
    }

    public View a(adz adzVar, LinearLayout linearLayout) {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            ViewGroup viewGroup = (ViewGroup) linearLayout.getChildAt(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (brs.a(((aqn) viewGroup.getChildAt(i2).getTag()).a, adzVar)) {
                    return viewGroup.getChildAt(i2);
                }
            }
        }
        return null;
    }
}
