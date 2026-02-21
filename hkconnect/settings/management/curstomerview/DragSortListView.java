package com.harman.hkconnect.settings.management.curstomerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.WrapperListAdapter;
import defpackage.aib;
import defpackage.aol;
import defpackage.aon;
import defpackage.aoo;
import defpackage.aoq;
import defpackage.aor;
import defpackage.aos;
import defpackage.mm;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class DragSortListView extends ListView {
    private int A;
    private int B;
    private int C;
    private b D;
    private h E;
    private o F;
    private boolean G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private View[] M;
    private d N;
    private float O;
    private float P;
    private int Q;
    private int R;
    private float S;
    private float T;
    private float U;
    private float V;
    private float W;
    private int a;
    private boolean aA;
    private c aa;
    private int ab;
    private int ac;
    private int ad;
    private int ae;
    private int af;
    private int ag;
    private boolean ah;
    private boolean ai;
    private i aj;
    private MotionEvent ak;
    private int al;
    private float am;
    private float an;
    private a ao;
    private boolean ap;
    private f aq;
    private boolean ar;
    private boolean as;
    private j at;
    private n au;
    private k av;
    private g aw;
    private boolean ax;
    private float ay;
    private boolean az;
    private int b;
    private float c;
    private float d;
    private int e;
    private int f;
    private aoq g;
    private m h;
    private aoo i;
    private l j;
    private Interpolator k;
    private Interpolator l;
    private View m;
    private Point n;
    private Point o;
    private int p;
    private boolean q;
    private DataSetObserver r;
    private float s;
    private float t;
    private int u;
    private int v;
    private int w;
    private boolean x;
    private int y;
    private int z;

    public interface b {
        void a(int i, int i2);
    }

    public interface c {
        float a(float f, long j);
    }

    public interface e extends b, h, o {
    }

    public interface h {
        void a_(int i, int i2);
    }

    public interface i {
        View a(int i);

        void a(View view);

        void a(View view, Point point, Point point2);
    }

    public interface l {
        void a(int i, aon aonVar, int i2);
    }

    public interface m {
        void a(int i);

        void b(int i);
    }

    public interface o {
        void a(int i);
    }

    public DragSortListView(Context context, AttributeSet attributeSet) {
        int i2;
        super(context, attributeSet);
        this.a = 5;
        this.b = 3;
        this.n = new Point();
        this.o = new Point();
        this.q = false;
        this.s = 1.0f;
        this.t = 1.0f;
        this.x = false;
        this.G = true;
        this.H = 0;
        this.I = 1;
        this.L = 0;
        this.M = new View[1];
        this.O = 0.33333334f;
        this.P = 0.33333334f;
        this.W = 0.5f;
        this.aa = new c() { // from class: com.harman.hkconnect.settings.management.curstomerview.DragSortListView.1
            @Override // com.harman.hkconnect.settings.management.curstomerview.DragSortListView.c
            public float a(float f2, long j2) {
                return DragSortListView.this.W * f2;
            }
        };
        this.ag = 0;
        this.ah = false;
        this.ai = false;
        this.aj = null;
        this.al = 0;
        this.am = 0.25f;
        this.an = 0.0f;
        this.ap = false;
        this.ar = false;
        this.as = false;
        this.at = new j(3);
        this.ay = 0.0f;
        this.az = false;
        this.aA = false;
        int i3 = 150;
        if (attributeSet == null) {
            i2 = 150;
        } else {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, aib.a.DragSortListView, 0, 0);
            this.I = Math.max(1, typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 1));
            this.ap = typedArrayObtainStyledAttributes.getBoolean(5, false);
            if (this.ap) {
                this.aq = new f();
            }
            this.s = typedArrayObtainStyledAttributes.getFloat(6, this.s);
            this.t = this.s;
            this.G = typedArrayObtainStyledAttributes.getBoolean(10, this.G);
            this.am = Math.max(0.0f, Math.min(1.0f, 1.0f - typedArrayObtainStyledAttributes.getFloat(7, 0.75f)));
            this.x = this.am > 0.0f;
            setDragScrollStart(typedArrayObtainStyledAttributes.getFloat(1, this.O));
            this.W = typedArrayObtainStyledAttributes.getFloat(2, this.W);
            int i4 = typedArrayObtainStyledAttributes.getInt(8, 150);
            int i5 = typedArrayObtainStyledAttributes.getInt(9, 150);
            if (typedArrayObtainStyledAttributes.getBoolean(17, true)) {
                boolean z = typedArrayObtainStyledAttributes.getBoolean(12, false);
                int i6 = typedArrayObtainStyledAttributes.getInt(4, 1);
                boolean z2 = typedArrayObtainStyledAttributes.getBoolean(11, true);
                int i7 = typedArrayObtainStyledAttributes.getInt(13, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(14, 0);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(15, 0);
                int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(16, 0);
                int color = typedArrayObtainStyledAttributes.getColor(3, -16777216);
                aol aolVar = new aol(this, resourceId, i7, i6, resourceId3, resourceId2);
                aolVar.b(z);
                aolVar.a(z2);
                aolVar.d(color);
                this.aj = aolVar;
                setOnTouchListener(aolVar);
            }
            typedArrayObtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.N = new d();
        if (i3 > 0) {
            this.au = new n(0.5f, i3);
        }
        if (i2 > 0) {
            this.aw = new g(0.5f, i2);
        }
        this.ak = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.r = new DataSetObserver() { // from class: com.harman.hkconnect.settings.management.curstomerview.DragSortListView.2
            private void a() {
                if (DragSortListView.this.H == 4) {
                    DragSortListView.this.a();
                }
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                a();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                a();
            }
        };
        this.b = e(this.b);
        this.a = e(this.a);
        this.e = 0;
    }

    public void setFloatAlpha(float f2) {
        this.t = f2;
    }

    public float getFloatAlpha() {
        return this.t;
    }

    public void setMaxScrollSpeed(float f2) {
        this.W = f2;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.ao = new a(listAdapter, getContext()) { // from class: com.harman.hkconnect.settings.management.curstomerview.DragSortListView.3
                @Override // com.harman.hkconnect.settings.management.curstomerview.DragSortListView.a
                public void a(aon aonVar) {
                    if (DragSortListView.this.i != null) {
                        DragSortListView.this.i.a(aonVar);
                    }
                }

                @Override // com.harman.hkconnect.settings.management.curstomerview.DragSortListView.a, aor.a
                public void a(aor aorVar, aon aonVar, int i2) {
                    if (DragSortListView.this.j != null) {
                        DragSortListView.this.j.a(aorVar.getPosition(), aonVar, i2);
                    }
                    if (DragSortListView.this.g != null) {
                        DragSortListView.this.g.c();
                    }
                }
            };
            listAdapter.registerDataSetObserver(this.r);
            if (listAdapter instanceof h) {
                setDropListener((h) listAdapter);
            }
            if (listAdapter instanceof b) {
                setDragListener((b) listAdapter);
            }
            if (listAdapter instanceof o) {
                setRemoveListener((o) listAdapter);
            }
        } else {
            this.ao = null;
        }
        super.setAdapter((ListAdapter) this.ao);
    }

    public ListAdapter getInputAdapter() {
        if (this.ao == null) {
            return null;
        }
        return this.ao.a();
    }

    class a extends BaseAdapter implements WrapperListAdapter, aor.a {
        private ListAdapter a;
        private l c;
        private Context d;

        public a(ListAdapter listAdapter, Context context) {
            this.a = listAdapter;
            this.d = context;
            this.a.registerDataSetObserver(new DataSetObserver() { // from class: com.harman.hkconnect.settings.management.curstomerview.DragSortListView.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    a.this.notifyDataSetInvalidated();
                }
            });
        }

        public ListAdapter a() {
            return this.a;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return this.a.getItemId(i);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.a.getItem(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.a.getCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return this.a.areAllItemsEnabled();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i) {
            return this.a.isEnabled(i);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return this.a.getItemViewType(i);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return this.a.getViewTypeCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return this.a.hasStableIds();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            aoq aoqVar;
            if (view == null) {
                View view2 = this.a.getView(i, view, viewGroup);
                aon aonVar = new aon(this.d);
                aonVar.a(this.a.getItemViewType(i));
                a(aonVar);
                aor aorVar = new aor(aonVar, (DragSortListView) viewGroup);
                aorVar.setOnSwipeItemClickListener(this);
                DragSortListView dragSortListView = (DragSortListView) viewGroup;
                aoqVar = new aoq(view2, aorVar, dragSortListView.getCloseInterpolator(), dragSortListView.getOpenInterpolator());
                aoqVar.setPosition(i);
                aoqVar.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            } else {
                aoqVar = (aoq) view;
                View childAt = aoqVar.getChildAt(0);
                View view3 = this.a.getView(i, childAt, DragSortListView.this);
                if (view3 != childAt) {
                    if (childAt != null) {
                        aoqVar.removeAllViews();
                    }
                    aoqVar.setContentView(view3);
                    aoqVar.setMenuView(aoqVar.getMenuView());
                    aoqVar.a();
                    aoqVar.postInvalidate();
                    aoqVar.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                }
                aoqVar.c();
                aoqVar.setPosition(i);
            }
            if (!((aos) this.a.getItem(i)).b.b()) {
                aoqVar.setSwipeEnabled(true);
            } else {
                aoqVar.setSwipeEnabled(false);
            }
            DragSortListView.this.a(DragSortListView.this.getHeaderViewsCount() + i, (View) aoqVar, true);
            return aoqVar;
        }

        @Override // android.widget.WrapperListAdapter
        public ListAdapter getWrappedAdapter() {
            return this.a;
        }

        public void a(aor aorVar, aon aonVar, int i) {
            if (this.c != null) {
                this.c.a(aorVar.getPosition(), aonVar, i);
            }
        }

        public void a(aon aonVar) {
        }
    }

    private void a(int i2, Canvas canvas) {
        ViewGroup viewGroup;
        int bottom;
        int top;
        Drawable divider = getDivider();
        int dividerHeight = getDividerHeight();
        if (divider != null && dividerHeight != 0 && (viewGroup = (ViewGroup) getChildAt(i2 - getFirstVisiblePosition())) != null) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int height = viewGroup.getChildAt(0).getHeight();
            if (i2 > this.y) {
                top = height + viewGroup.getTop();
                bottom = top + dividerHeight;
            } else {
                bottom = viewGroup.getBottom() - height;
                top = bottom - dividerHeight;
            }
            canvas.save();
            canvas.clipRect(paddingLeft, top, width, bottom);
            divider.setBounds(paddingLeft, top, width, bottom);
            divider.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float f2;
        super.dispatchDraw(canvas);
        if (this.H != 0) {
            if (this.v != this.y) {
                a(this.v, canvas);
            }
            if (this.w != this.v && this.w != this.y) {
                a(this.w, canvas);
            }
        }
        if (this.m != null) {
            int width = this.m.getWidth();
            int height = this.m.getHeight();
            int i2 = this.n.x;
            int width2 = getWidth();
            if (i2 < 0) {
                i2 = -i2;
            }
            if (i2 < width2) {
                float f3 = (width2 - i2) / width2;
                f2 = f3 * f3;
            } else {
                f2 = 0.0f;
            }
            int i3 = (int) (f2 * 255.0f * this.t);
            canvas.save();
            canvas.translate(this.n.x, this.n.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.m.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i2) {
        View childAt = getChildAt(i2 - getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : c(i2, d(i2));
    }

    class j {
        private SparseIntArray b;
        private ArrayList<Integer> c;
        private int d;

        public j(int i) {
            this.b = new SparseIntArray(i);
            this.c = new ArrayList<>(i);
            this.d = i;
        }

        public void a(int i, int i2) {
            int i3 = this.b.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.b.size() == this.d) {
                        this.b.delete(this.c.remove(0).intValue());
                    }
                } else {
                    this.c.remove(Integer.valueOf(i));
                }
                this.b.put(i, i2);
                this.c.add(Integer.valueOf(i));
            }
        }

        public int a(int i) {
            return this.b.get(i, -1);
        }

        public void a() {
            this.b.clear();
            this.c.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i2, int i3) {
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = getDividerHeight();
        int i4 = this.J - this.I;
        int iD = d(i2);
        int iB = b(i2);
        if (this.w <= this.y) {
            if (i2 == this.w && this.v != this.w) {
                if (i2 == this.y) {
                    i3 = (i3 + iB) - this.J;
                } else {
                    i3 = ((iB - iD) + i3) - i4;
                }
            } else if (i2 > this.w && i2 <= this.y) {
                i3 -= i4;
            }
        } else if (i2 > this.y && i2 <= this.v) {
            i3 += i4;
        } else if (i2 == this.w && this.v != this.w) {
            i3 += iB - iD;
        }
        if (i2 <= this.y) {
            return (((this.J - dividerHeight) - d(i2 - 1)) / 2) + i3;
        }
        return (((iD - dividerHeight) - this.J) / 2) + i3;
    }

    private boolean d() {
        int iA;
        int count;
        int i2;
        int firstVisiblePosition = getFirstVisiblePosition();
        int childCount = this.v;
        View childAt = getChildAt(childCount - firstVisiblePosition);
        if (childAt == null) {
            childCount = firstVisiblePosition + (getChildCount() / 2);
            childAt = getChildAt(childCount - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int iA2 = a(childCount, top);
        int dividerHeight = getDividerHeight();
        if (this.p >= iA2) {
            int count2 = getCount();
            int iB = height;
            int i3 = top;
            iA = iA2;
            count = childCount;
            i2 = iA2;
            while (true) {
                if (count < count2) {
                    if (count == count2 - 1) {
                        iA = i3 + dividerHeight + iB;
                        break;
                    }
                    i3 += dividerHeight + iB;
                    iB = b(count + 1);
                    iA = a(count + 1, i3);
                    if (this.p < iA) {
                        break;
                    }
                    count++;
                    i2 = iA;
                } else {
                    break;
                }
            }
        } else {
            int i4 = top;
            iA = iA2;
            count = childCount;
            i2 = iA2;
            while (true) {
                if (count < 0) {
                    break;
                }
                count--;
                int iB2 = b(count);
                if (count == 0) {
                    iA = (i4 - dividerHeight) - iB2;
                    break;
                }
                i4 -= iB2 + dividerHeight;
                iA = a(count, i4);
                if (this.p >= iA) {
                    break;
                }
                i2 = iA;
            }
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        int i5 = this.v;
        int i6 = this.w;
        float f2 = this.an;
        if (this.x) {
            int iAbs = Math.abs(iA - i2);
            if (this.p >= iA) {
                int i7 = i2;
                i2 = iA;
                iA = i7;
            }
            int i8 = (int) (iAbs * this.am * 0.5f);
            float f3 = i8;
            int i9 = i2 + i8;
            int i10 = iA - i8;
            if (this.p < i9) {
                this.v = count - 1;
                this.w = count;
                this.an = ((i9 - this.p) * 0.5f) / f3;
            } else if (this.p < i10) {
                this.v = count;
                this.w = count;
            } else {
                this.v = count;
                this.w = count + 1;
                this.an = (1.0f + ((iA - this.p) / f3)) * 0.5f;
            }
        } else {
            this.v = count;
            this.w = count;
        }
        if (this.v < headerViewsCount) {
            this.v = headerViewsCount;
            this.w = headerViewsCount;
            count = headerViewsCount;
        } else if (this.w >= getCount() - footerViewsCount) {
            count = (getCount() - footerViewsCount) - 1;
            this.v = count;
            this.w = count;
        }
        boolean z = (this.v == i5 && this.w == i6 && this.an == f2) ? false : true;
        if (count == this.u) {
            return z;
        }
        if (this.D != null) {
            this.D.a(this.u - headerViewsCount, count - headerViewsCount);
        }
        this.u = count;
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ap) {
            this.aq.b();
        }
    }

    class p implements Runnable {
        private float a;
        protected long b;
        private float d;
        private float e;
        private float f;
        private float g;
        private float h;
        private boolean i;

        public p(float f, int i) {
            this.d = f;
            this.a = i;
            float f2 = 1.0f / ((this.d * 2.0f) * (1.0f - this.d));
            this.h = f2;
            this.e = f2;
            this.f = this.d / ((this.d - 1.0f) * 2.0f);
            this.g = 1.0f / (1.0f - this.d);
        }

        public float a(float f) {
            if (f < this.d) {
                return this.e * f * f;
            }
            if (f < 1.0f - this.d) {
                return this.f + (this.g * f);
            }
            return 1.0f - ((this.h * (f - 1.0f)) * (f - 1.0f));
        }

        public void c() {
            this.b = SystemClock.uptimeMillis();
            this.i = false;
            a();
            DragSortListView.this.post(this);
        }

        public void d() {
            this.i = true;
        }

        public void a() {
        }

        public void a(float f, float f2) {
        }

        public void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.i) {
                float fUptimeMillis = (SystemClock.uptimeMillis() - this.b) / this.a;
                if (fUptimeMillis >= 1.0f) {
                    a(1.0f, 1.0f);
                    b();
                } else {
                    a(fUptimeMillis, a(fUptimeMillis));
                    DragSortListView.this.post(this);
                }
            }
        }
    }

    class k extends p {
        final /* synthetic */ DragSortListView a;
        private float d;
        private float e;

        @Override // com.harman.hkconnect.settings.management.curstomerview.DragSortListView.p
        public void a() {
            this.d = this.a.A;
            this.e = this.a.K;
        }

        @Override // com.harman.hkconnect.settings.management.curstomerview.DragSortListView.p
        public void a(float f, float f2) {
            if (this.a.H != 4) {
                d();
                return;
            }
            this.a.A = (int) ((this.e * f2) + ((1.0f - f2) * this.d));
            this.a.n.y = this.a.ac - this.a.A;
            this.a.b(true);
        }
    }

    class g extends p {
        private int d;
        private int e;
        private float f;
        private float g;

        public g(float f, int i) {
            super(f, i);
        }

        @Override // com.harman.hkconnect.settings.management.curstomerview.DragSortListView.p
        public void a() {
            this.d = DragSortListView.this.u;
            this.e = DragSortListView.this.y;
            DragSortListView.this.H = 2;
            this.f = DragSortListView.this.n.y - e();
            this.g = DragSortListView.this.n.x - DragSortListView.this.getPaddingLeft();
        }

        private int e() {
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            int dividerHeight = (DragSortListView.this.I + DragSortListView.this.getDividerHeight()) / 2;
            View childAt = DragSortListView.this.getChildAt(this.d - firstVisiblePosition);
            if (childAt != null) {
                if (this.d == this.e) {
                    return childAt.getTop();
                }
                if (this.d >= this.e) {
                    return (childAt.getBottom() + dividerHeight) - DragSortListView.this.J;
                }
                return childAt.getTop() - dividerHeight;
            }
            d();
            return -1;
        }

        @Override // com.harman.hkconnect.settings.management.curstomerview.DragSortListView.p
        public void a(float f, float f2) {
            int iE = e();
            int paddingLeft = DragSortListView.this.getPaddingLeft();
            float f3 = DragSortListView.this.n.y - iE;
            float f4 = DragSortListView.this.n.x - paddingLeft;
            float f5 = 1.0f - f2;
            if (f5 < Math.abs(f3 / this.f) || f5 < Math.abs(f4 / this.g)) {
                DragSortListView.this.n.y = iE + ((int) (this.f * f5));
                DragSortListView.this.n.x = DragSortListView.this.getPaddingLeft() + ((int) (this.g * f5));
                DragSortListView.this.b(true);
            }
        }

        @Override // com.harman.hkconnect.settings.management.curstomerview.DragSortListView.p
        public void b() {
            DragSortListView.this.f();
        }
    }

    class n extends p {
        private float d;
        private float e;
        private float f;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;

        public n(float f, int i) {
            super(f, i);
            this.g = -1;
            this.h = -1;
        }

        @Override // com.harman.hkconnect.settings.management.curstomerview.DragSortListView.p
        public void a() {
            this.g = -1;
            this.h = -1;
            this.i = DragSortListView.this.v;
            this.j = DragSortListView.this.w;
            this.k = DragSortListView.this.y;
            DragSortListView.this.H = 1;
            this.d = DragSortListView.this.n.x;
            if (!DragSortListView.this.ax) {
                DragSortListView.this.n();
                return;
            }
            float width = DragSortListView.this.getWidth() * 2.0f;
            if (DragSortListView.this.ay == 0.0f) {
                DragSortListView.this.ay = (this.d >= 0.0f ? 1 : -1) * width;
                return;
            }
            float f = width * 2.0f;
            if (DragSortListView.this.ay < 0.0f && DragSortListView.this.ay > (-f)) {
                DragSortListView.this.ay = -f;
            } else if (DragSortListView.this.ay > 0.0f && DragSortListView.this.ay < f) {
                DragSortListView.this.ay = f;
            }
        }

        @Override // com.harman.hkconnect.settings.management.curstomerview.DragSortListView.p
        public void a(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            View childAt2 = DragSortListView.this.getChildAt(this.i - firstVisiblePosition);
            if (DragSortListView.this.ax) {
                float fUptimeMillis = (SystemClock.uptimeMillis() - this.b) / 1000.0f;
                if (fUptimeMillis != 0.0f) {
                    float f4 = DragSortListView.this.ay * fUptimeMillis;
                    int width = DragSortListView.this.getWidth();
                    DragSortListView.this.ay = ((DragSortListView.this.ay > 0.0f ? 1 : -1) * fUptimeMillis * width) + DragSortListView.this.ay;
                    this.d += f4;
                    DragSortListView.this.n.x = (int) this.d;
                    if (this.d < width && this.d > (-width)) {
                        this.b = SystemClock.uptimeMillis();
                        DragSortListView.this.b(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.g == -1) {
                    this.g = DragSortListView.this.b(this.i, childAt2, false);
                    this.e = childAt2.getHeight() - this.g;
                }
                int iMax = Math.max((int) (this.e * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = iMax + this.g;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.j != this.i && (childAt = DragSortListView.this.getChildAt(this.j - firstVisiblePosition)) != null) {
                if (this.h == -1) {
                    this.h = DragSortListView.this.b(this.j, childAt, false);
                    this.f = childAt.getHeight() - this.h;
                }
                int iMax2 = Math.max((int) (this.f * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = iMax2 + this.h;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.harman.hkconnect.settings.management.curstomerview.DragSortListView.p
        public void b() {
            DragSortListView.this.g();
        }
    }

    public void a(int i2) {
        this.ax = false;
        a(i2, 0.0f);
    }

    public void a(int i2, float f2) {
        if (this.H == 0 || this.H == 4) {
            if (this.H == 0) {
                this.y = getHeaderViewsCount() + i2;
                this.v = this.y;
                this.w = this.y;
                this.u = this.y;
                View childAt = getChildAt(this.y - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.H = 1;
            this.ay = f2;
            if (this.ai) {
                switch (this.al) {
                    case 1:
                        super.onTouchEvent(this.ak);
                        break;
                    case 2:
                        super.onInterceptTouchEvent(this.ak);
                        break;
                }
            }
            if (this.au != null) {
                this.au.c();
            } else {
                c(i2);
            }
        }
    }

    public void a() {
        if (this.H == 4) {
            this.N.a(true);
            n();
            e();
            k();
            if (this.ai) {
                this.H = 3;
            } else {
                this.H = 0;
            }
        }
    }

    private void e() {
        this.y = -1;
        this.v = -1;
        this.w = -1;
        this.u = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.H = 2;
        if (this.E != null && this.u >= 0 && this.u < getCount()) {
            int headerViewsCount = getHeaderViewsCount();
            this.E.a_(this.y - headerViewsCount, this.u - headerViewsCount);
        }
        n();
        h();
        e();
        k();
        if (this.ai) {
            this.H = 3;
        } else {
            this.H = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        c(this.y - getHeaderViewsCount());
    }

    private void c(int i2) {
        this.H = 1;
        if (this.F != null) {
            this.F.a(i2);
        }
        n();
        h();
        e();
        if (this.ai) {
            this.H = 3;
        } else {
            this.H = 0;
        }
    }

    private void h() {
        int firstVisiblePosition = getFirstVisiblePosition();
        if (this.y < firstVisiblePosition) {
            View childAt = getChildAt(0);
            setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - getPaddingTop());
        }
    }

    public boolean a(boolean z) {
        this.ax = false;
        return b(z, 0.0f);
    }

    public boolean a(boolean z, float f2) {
        this.ax = true;
        return b(z, f2);
    }

    public boolean b(boolean z, float f2) {
        if (this.m != null) {
            this.N.a(true);
            if (z) {
                a(this.y - getHeaderViewsCount(), f2);
            } else if (this.aw != null) {
                this.aw.c();
            } else {
                f();
            }
            if (!this.ap) {
                return true;
            }
            this.aq.d();
            return true;
        }
        return false;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.as) {
            this.as = false;
            return false;
        }
        if (!this.G) {
            return super.onTouchEvent(motionEvent);
        }
        boolean z2 = this.ah;
        this.ah = false;
        if (!z2) {
            b(motionEvent);
        }
        if (this.H == 4) {
            a(motionEvent);
            z = true;
        } else {
            z = this.H == 0 && super.onTouchEvent(motionEvent);
            switch (motionEvent.getAction() & 255) {
                case 0:
                    int i2 = this.f;
                    this.c = motionEvent.getX();
                    this.d = motionEvent.getY();
                    this.e = 0;
                    this.f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (this.f == i2 && this.g != null && this.g.b()) {
                        this.e = 1;
                        this.g.a(motionEvent);
                        return true;
                    }
                    View childAt = getChildAt(this.f - getFirstVisiblePosition());
                    if (this.g != null && this.g.b()) {
                        this.g.c();
                        this.g = null;
                        return super.onTouchEvent(motionEvent);
                    }
                    if (childAt instanceof aoq) {
                        this.g = (aoq) childAt;
                    }
                    if (this.g != null) {
                        this.g.a(motionEvent);
                    }
                    break;
                    break;
                case 1:
                case 3:
                    i();
                    if (this.e == 1) {
                        if (this.g != null) {
                            this.g.a(motionEvent);
                            if (!this.g.b()) {
                                this.f = -1;
                                this.g = null;
                            }
                        }
                        if (this.h != null) {
                            this.h.b(this.f);
                        }
                        motionEvent.setAction(3);
                        super.onTouchEvent(motionEvent);
                        return true;
                    }
                    break;
                case 2:
                    float fAbs = Math.abs(motionEvent.getY() - this.d);
                    float fAbs2 = Math.abs(motionEvent.getX() - this.c);
                    if (this.e == 1) {
                        if (this.g != null) {
                            this.g.a(motionEvent);
                        }
                        getSelector().setState(new int[]{0});
                        motionEvent.setAction(3);
                        super.onTouchEvent(motionEvent);
                        return true;
                    }
                    if (this.e == 0) {
                        if (Math.abs(fAbs) > this.a) {
                            this.e = 2;
                        } else if (fAbs2 > this.b) {
                            this.e = 1;
                            if (this.h != null) {
                                this.h.a(this.f);
                            }
                        }
                    }
                    break;
                    break;
                default:
                    if (z) {
                        this.al = 1;
                    }
                    break;
            }
        }
        return z;
    }

    private void i() {
        this.al = 0;
        this.ai = false;
        if (this.H == 3) {
            this.H = 0;
        }
        this.t = this.s;
        this.az = false;
        this.at.a();
    }

    private void b(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.ad = this.ab;
            this.ae = this.ac;
        }
        this.ab = (int) motionEvent.getX();
        this.ac = (int) motionEvent.getY();
        if (action == 0) {
            this.ad = this.ab;
            this.ae = this.ac;
        }
        this.B = ((int) motionEvent.getRawX()) - this.ab;
        this.C = ((int) motionEvent.getRawY()) - this.ac;
    }

    public boolean b() {
        return this.az;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.G) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        b(motionEvent);
        this.ah = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.H != 0) {
                this.as = true;
                return true;
            }
            this.ai = true;
        }
        if (this.m == null) {
            if (super.onInterceptTouchEvent(motionEvent)) {
                this.az = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    i();
                    break;
                case 2:
                default:
                    if (z) {
                        this.al = 1;
                    } else {
                        this.al = 2;
                    }
                    break;
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.ai = false;
        }
        return z;
    }

    public void setDragScrollStart(float f2) {
        a(f2, f2);
    }

    public void a(float f2, float f3) {
        if (f3 > 0.5f) {
            this.P = 0.5f;
        } else {
            this.P = f3;
        }
        if (f2 > 0.5f) {
            this.O = 0.5f;
        } else {
            this.O = f2;
        }
        if (getHeight() != 0) {
            j();
        }
    }

    private void b(int i2, int i3) {
        this.n.x = i2 - this.z;
        this.n.y = i3 - this.A;
        b(true);
        int iMin = Math.min(i3, this.p + this.K);
        int iMax = Math.max(i3, this.p - this.K);
        int iB = this.N.b();
        if (iMin > this.ae && iMin > this.R && iB != 1) {
            if (iB != -1) {
                this.N.a(true);
            }
            this.N.a(1);
        } else if (iMax < this.ae && iMax < this.Q && iB != 0) {
            if (iB != -1) {
                this.N.a(true);
            }
            this.N.a(0);
        } else if (iMax >= this.Q && iMin <= this.R && this.N.a()) {
            this.N.a(true);
        }
    }

    private void j() {
        int paddingTop = getPaddingTop();
        float height = (getHeight() - paddingTop) - getPaddingBottom();
        this.T = paddingTop + (this.O * height);
        this.S = (height * (1.0f - this.P)) + paddingTop;
        this.Q = (int) this.T;
        this.R = (int) this.S;
        this.U = this.T - paddingTop;
        this.V = (paddingTop + r1) - this.S;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        j();
    }

    private void k() {
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        int iMin = Math.min(lastVisiblePosition - firstVisiblePosition, ((getCount() - 1) - getFooterViewsCount()) - firstVisiblePosition);
        for (int iMax = Math.max(0, getHeaderViewsCount() - firstVisiblePosition); iMax <= iMin; iMax++) {
            View childAt = getChildAt(iMax);
            if (childAt != null) {
                a(firstVisiblePosition + iMax, childAt, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, View view, boolean z) {
        int iC;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i2 != this.y && i2 != this.v && i2 != this.w) {
            iC = -2;
        } else {
            iC = c(i2, view, z);
        }
        if (iC != layoutParams.height) {
            layoutParams.height = iC;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.v || i2 == this.w) {
            if (i2 < this.y) {
                ((aoq) view).setGravity(80);
            } else if (i2 > this.y) {
                ((aoq) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.y && this.m != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(int i2) {
        View view;
        if (i2 == this.y) {
            return 0;
        }
        View childAt = getChildAt(i2 - getFirstVisiblePosition());
        if (childAt != null) {
            return b(i2, childAt, false);
        }
        int iA = this.at.a(i2);
        if (iA == -1) {
            ListAdapter adapter = getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.M.length) {
                this.M = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.M[itemViewType] == null) {
                    view = adapter.getView(i2, null, this);
                    this.M[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.M[itemViewType], this);
                }
            } else {
                view = adapter.getView(i2, null, this);
            }
            int iB = b(i2, view, true);
            this.at.a(i2, iB);
            return iB;
        }
        return iA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i2, View view, boolean z) {
        if (i2 == this.y) {
            return 0;
        }
        if (i2 >= getHeaderViewsCount() && i2 < getCount() - getFooterViewsCount()) {
            view = ((ViewGroup) view).getChildAt(0);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && layoutParams.height > 0) {
            return layoutParams.height;
        }
        int height = view.getHeight();
        if (height == 0 || z) {
            a(view);
            return view.getMeasuredHeight();
        }
        return height;
    }

    private int c(int i2, View view, boolean z) {
        return c(i2, b(i2, view, z));
    }

    private int c(int i2, int i3) {
        getDividerHeight();
        boolean z = this.x && this.v != this.w;
        int i4 = this.J - this.I;
        int i5 = (int) (this.an * i4);
        if (i2 == this.y) {
            if (this.y == this.v) {
                if (z) {
                    return i5 + this.I;
                }
                return this.J;
            }
            if (this.y == this.w) {
                return this.J - i5;
            }
            return this.I;
        }
        if (i2 == this.v) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        }
        if (i2 == this.w) {
            return (i3 + i4) - i5;
        }
        return i3;
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.ar) {
            super.requestLayout();
        }
    }

    private int a(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int iD = d(i2);
        int height = view.getHeight();
        int iC = c(i2, iD);
        if (i2 != this.y) {
            i6 = height - iD;
            i5 = iC - iD;
        } else {
            i5 = iC;
            i6 = height;
        }
        int i7 = this.J;
        if (this.y != this.v && this.y != this.w) {
            i7 -= this.I;
        }
        if (i2 <= i3) {
            if (i2 > this.v) {
                return (i7 - i5) + 0;
            }
        } else {
            if (i2 == i4) {
                if (i2 <= this.v) {
                    return (i6 - i7) + 0;
                }
                if (i2 == this.w) {
                    return (height - iC) + 0;
                }
                return 0 + i6;
            }
            if (i2 <= this.v) {
                return 0 - i7;
            }
            if (i2 == this.w) {
                return 0 - i5;
            }
        }
        return 0;
    }

    private void a(View view) {
        int iMakeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.L, getListPaddingLeft() + getListPaddingRight(), layoutParams.width);
        if (layoutParams.height > 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, iMakeMeasureSpec);
    }

    private void l() {
        if (this.m != null) {
            a(this.m);
            this.J = this.m.getMeasuredHeight();
            this.K = this.J / 2;
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.m != null) {
            if (this.m.isLayoutRequested()) {
                l();
            }
            this.q = true;
        }
        this.L = i2;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    protected void layoutChildren() {
        super.layoutChildren();
        if (this.m != null) {
            if (this.m.isLayoutRequested() && !this.q) {
                l();
            }
            this.m.layout(0, 0, this.m.getMeasuredWidth(), this.m.getMeasuredHeight());
            this.q = false;
        }
    }

    protected boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.H == 4) {
                    a(false);
                }
                i();
                if (this.g != null) {
                    this.g.e();
                }
                break;
            case 2:
                b((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
            case 3:
                if (this.H == 4) {
                    a();
                }
                i();
                break;
        }
        return true;
    }

    public boolean a(int i2, int i3, int i4, int i5) {
        View viewA;
        if (!this.ai || this.aj == null || (viewA = this.aj.a(i2)) == null) {
            return false;
        }
        return a(i2, viewA, i3, i4, i5);
    }

    public boolean a(int i2, View view, int i3, int i4, int i5) {
        if (this.H != 0 || !this.ai || this.m != null || view == null || !this.G) {
            return false;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        int headerViewsCount = getHeaderViewsCount() + i2;
        this.v = headerViewsCount;
        this.w = headerViewsCount;
        this.y = headerViewsCount;
        this.u = headerViewsCount;
        this.H = 4;
        this.ag = 0;
        this.ag |= i3;
        this.m = view;
        l();
        this.z = i4;
        this.A = i5;
        this.af = this.ac;
        this.n.x = this.ab - this.z;
        this.n.y = this.ac - this.A;
        View childAt = getChildAt(this.y - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setVisibility(4);
        }
        if (this.ap) {
            this.aq.a();
        }
        switch (this.al) {
            case 1:
                super.onTouchEvent(this.ak);
                break;
            case 2:
                super.onInterceptTouchEvent(this.ak);
                break;
        }
        requestLayout();
        if (this.av == null) {
            return true;
        }
        this.av.c();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        int firstVisiblePosition = getFirstVisiblePosition() + (getChildCount() / 2);
        View childAt = getChildAt(getChildCount() / 2);
        if (childAt != null) {
            d(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2, View view, boolean z) {
        this.ar = true;
        m();
        int i3 = this.v;
        int i4 = this.w;
        boolean zD = d();
        if (zD) {
            k();
            setSelectionFromTop(i2, (a(i2, view, i3, i4) + view.getTop()) - getPaddingTop());
            layoutChildren();
        }
        if (zD || z) {
            invalidate();
        }
        this.ar = false;
    }

    private void m() {
        if (this.aj != null) {
            this.o.set(this.ab, this.ac);
            this.aj.a(this.m, this.n, this.o);
        }
        int i2 = this.n.x;
        int i3 = this.n.y;
        int paddingLeft = getPaddingLeft();
        if ((this.ag & 1) == 0 && i2 > paddingLeft) {
            this.n.x = paddingLeft;
        } else if ((this.ag & 2) == 0 && i2 < paddingLeft) {
            this.n.x = paddingLeft;
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        int paddingTop = getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.ag & 8) == 0 && firstVisiblePosition <= this.y) {
            paddingTop = Math.max(getChildAt(this.y - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = getHeight() - getPaddingBottom();
        if (lastVisiblePosition >= (getCount() - footerViewsCount) - 1) {
            height = getChildAt(((getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.ag & 4) == 0 && lastVisiblePosition >= this.y) {
            height = Math.min(getChildAt(this.y - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.n.y = paddingTop;
        } else if (this.J + i3 > height) {
            this.n.y = height - this.J;
        }
        this.p = this.n.y + this.K;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.m != null) {
            this.m.setVisibility(8);
            if (this.aj != null) {
                this.aj.a(this.m);
            }
            this.m = null;
            invalidate();
        }
    }

    public void setFloatViewManager(i iVar) {
        this.aj = iVar;
    }

    public void setDragListener(b bVar) {
        this.D = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.G = z;
    }

    public boolean c() {
        return this.G;
    }

    public void setDropListener(h hVar) {
        this.E = hVar;
    }

    public void setRemoveListener(o oVar) {
        this.F = oVar;
    }

    public void setDragSortListener(e eVar) {
        setDropListener(eVar);
        setDragListener(eVar);
        setRemoveListener(eVar);
    }

    public void setDragScrollProfile(c cVar) {
        if (cVar != null) {
            this.aa = cVar;
        }
    }

    class d implements Runnable {
        private boolean b;
        private long c;
        private long d;
        private int e;
        private float f;
        private long g;
        private int h;
        private float i;
        private boolean j = false;

        public boolean a() {
            return this.j;
        }

        public int b() {
            if (this.j) {
                return this.h;
            }
            return -1;
        }

        public d() {
        }

        public void a(int i) {
            if (!this.j) {
                this.b = false;
                this.j = true;
                this.g = SystemClock.uptimeMillis();
                this.c = this.g;
                this.h = i;
                DragSortListView.this.post(this);
            }
        }

        public void a(boolean z) {
            if (z) {
                DragSortListView.this.removeCallbacks(this);
                this.j = false;
            } else {
                this.b = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b) {
                this.j = false;
                return;
            }
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            int lastVisiblePosition = DragSortListView.this.getLastVisiblePosition();
            int count = DragSortListView.this.getCount();
            int paddingTop = DragSortListView.this.getPaddingTop();
            int height = (DragSortListView.this.getHeight() - paddingTop) - DragSortListView.this.getPaddingBottom();
            int iMin = Math.min(DragSortListView.this.ac, DragSortListView.this.p + DragSortListView.this.K);
            int iMax = Math.max(DragSortListView.this.ac, DragSortListView.this.p - DragSortListView.this.K);
            if (this.h == 0) {
                View childAt = DragSortListView.this.getChildAt(0);
                if (childAt == null) {
                    this.j = false;
                    return;
                } else {
                    if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.j = false;
                        return;
                    }
                    this.i = DragSortListView.this.aa.a((DragSortListView.this.T - iMax) / DragSortListView.this.U, this.c);
                }
            } else {
                View childAt2 = DragSortListView.this.getChildAt(lastVisiblePosition - firstVisiblePosition);
                if (childAt2 == null) {
                    this.j = false;
                    return;
                } else {
                    if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.j = false;
                        return;
                    }
                    this.i = -DragSortListView.this.aa.a((iMin - DragSortListView.this.S) / DragSortListView.this.V, this.c);
                }
            }
            this.d = SystemClock.uptimeMillis();
            this.f = this.d - this.c;
            this.e = Math.round(this.i * this.f);
            if (this.e >= 0) {
                this.e = Math.min(height, this.e);
                lastVisiblePosition = firstVisiblePosition;
            } else {
                this.e = Math.max(-height, this.e);
            }
            View childAt3 = DragSortListView.this.getChildAt(lastVisiblePosition - firstVisiblePosition);
            int top = childAt3.getTop() + this.e;
            if (lastVisiblePosition == 0 && top > paddingTop) {
                top = paddingTop;
            }
            DragSortListView.this.ar = true;
            DragSortListView.this.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
            DragSortListView.this.layoutChildren();
            DragSortListView.this.invalidate();
            DragSortListView.this.ar = false;
            DragSortListView.this.d(lastVisiblePosition, childAt3, false);
            this.c = this.d;
            DragSortListView.this.post(this);
        }
    }

    class f {
        StringBuilder a = new StringBuilder();
        private int d = 0;
        private int e = 0;
        private boolean f = false;
        File b = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");

        public f() {
            if (!this.b.exists()) {
                try {
                    this.b.createNewFile();
                    mm.b("mobeta", "file created");
                } catch (IOException e) {
                    mm.b("mobeta", "Could not create dslv_state.txt");
                    mm.b("mobeta", e.getMessage());
                }
            }
        }

        public void a() {
            this.a.append("<DSLVStates>\n");
            this.e = 0;
            this.f = true;
        }

        public void b() {
            if (this.f) {
                this.a.append("<DSLVState>\n");
                int childCount = DragSortListView.this.getChildCount();
                int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
                this.a.append("    <Positions>");
                for (int i = 0; i < childCount; i++) {
                    this.a.append(firstVisiblePosition + i).append(",");
                }
                this.a.append("</Positions>\n");
                this.a.append("    <Tops>");
                for (int i2 = 0; i2 < childCount; i2++) {
                    this.a.append(DragSortListView.this.getChildAt(i2).getTop()).append(",");
                }
                this.a.append("</Tops>\n");
                this.a.append("    <Bottoms>");
                for (int i3 = 0; i3 < childCount; i3++) {
                    this.a.append(DragSortListView.this.getChildAt(i3).getBottom()).append(",");
                }
                this.a.append("</Bottoms>\n");
                this.a.append("    <FirstExpPos>").append(DragSortListView.this.v).append("</FirstExpPos>\n");
                this.a.append("    <FirstExpBlankHeight>").append(DragSortListView.this.b(DragSortListView.this.v) - DragSortListView.this.d(DragSortListView.this.v)).append("</FirstExpBlankHeight>\n");
                this.a.append("    <SecondExpPos>").append(DragSortListView.this.w).append("</SecondExpPos>\n");
                this.a.append("    <SecondExpBlankHeight>").append(DragSortListView.this.b(DragSortListView.this.w) - DragSortListView.this.d(DragSortListView.this.w)).append("</SecondExpBlankHeight>\n");
                this.a.append("    <SrcPos>").append(DragSortListView.this.y).append("</SrcPos>\n");
                this.a.append("    <SrcHeight>").append(DragSortListView.this.J + DragSortListView.this.getDividerHeight()).append("</SrcHeight>\n");
                this.a.append("    <ViewHeight>").append(DragSortListView.this.getHeight()).append("</ViewHeight>\n");
                this.a.append("    <LastY>").append(DragSortListView.this.ae).append("</LastY>\n");
                this.a.append("    <FloatY>").append(DragSortListView.this.p).append("</FloatY>\n");
                this.a.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.a.append(DragSortListView.this.a(firstVisiblePosition + i4, DragSortListView.this.getChildAt(i4).getTop())).append(",");
                }
                this.a.append("</ShuffleEdges>\n");
                this.a.append("</DSLVState>\n");
                this.d++;
                if (this.d > 1000) {
                    c();
                    this.d = 0;
                }
            }
        }

        public void c() {
            if (this.f) {
                try {
                    FileWriter fileWriter = new FileWriter(this.b, this.e != 0);
                    fileWriter.write(this.a.toString());
                    this.a.delete(0, this.a.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.e++;
                } catch (IOException e) {
                }
            }
        }

        public void d() {
            if (this.f) {
                this.a.append("</DSLVStates>\n");
                c();
                this.f = false;
            }
        }
    }

    public void setCloseInterpolator(Interpolator interpolator) {
        this.k = interpolator;
    }

    public void setOpenInterpolator(Interpolator interpolator) {
        this.l = interpolator;
    }

    public Interpolator getOpenInterpolator() {
        return this.l;
    }

    public Interpolator getCloseInterpolator() {
        return this.k;
    }

    private int e(int i2) {
        return (int) TypedValue.applyDimension(1, i2, getContext().getResources().getDisplayMetrics());
    }

    public void setMenuCreator(aoo aooVar) {
        this.i = aooVar;
    }

    public void setOnMenuItemClickListener(l lVar) {
        this.j = lVar;
    }

    public void setOnSwipeListener(m mVar) {
        this.h = mVar;
    }
}
