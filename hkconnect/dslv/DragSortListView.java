package com.harman.hkconnect.dslv;

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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import defpackage.aib;
import defpackage.aio;
import defpackage.aip;
import defpackage.aiq;
import defpackage.arr;
import defpackage.mm;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class DragSortListView extends ListView {
    private View[] A;
    private d B;
    private float C;
    private float D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private float J;
    private float K;
    private c L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private boolean T;
    private i U;
    private MotionEvent V;
    private int W;
    private View a;
    private float aa;
    private float ab;
    private a ac;
    private boolean ad;
    private f ae;
    private boolean af;
    private boolean ag;
    private j ah;
    private boolean ai;
    private l aj;
    private k ak;
    private g al;
    private boolean am;
    private float an;
    private MusicPlaylistManager ao;
    private float ap;
    private boolean aq;
    private boolean ar;
    private Point b;
    private Point c;
    private int d;
    private boolean e;
    private DataSetObserver f;
    private float g;
    private float h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private b r;
    private h s;
    private m t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public interface b {
        void a(int i, int i2);
    }

    public interface c {
        float a(float f, long j);
    }

    public interface e extends b, h, m {
    }

    public interface h {
        void b(int i, int i2);
    }

    public interface i {
        void a(View view);

        void a(View view, Point point, Point point2);

        View e(int i);
    }

    public interface m {
        void a(int i);
    }

    public DragSortListView(Context context, AttributeSet attributeSet) {
        int i2;
        super(context, attributeSet);
        this.b = new Point();
        this.c = new Point();
        this.e = false;
        this.g = 1.0f;
        this.h = 1.0f;
        this.l = false;
        this.u = true;
        this.v = 0;
        this.w = 1;
        this.z = 0;
        this.A = new View[1];
        this.C = 0.33333334f;
        this.D = 0.33333334f;
        this.K = 0.5f;
        this.L = new c() { // from class: com.harman.hkconnect.dslv.DragSortListView.1
            @Override // com.harman.hkconnect.dslv.DragSortListView.c
            public float a(float f2, long j2) {
                return DragSortListView.this.K * f2;
            }
        };
        this.R = 0;
        this.S = false;
        this.T = false;
        this.U = null;
        this.W = 0;
        this.aa = 0.25f;
        this.ab = 0.0f;
        this.ad = false;
        this.af = false;
        this.ag = false;
        this.ah = new j(3);
        this.ai = false;
        this.an = 0.0f;
        this.ap = 0.0f;
        this.aq = false;
        this.ar = false;
        int i3 = 150;
        if (attributeSet == null) {
            i2 = 150;
        } else {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, aib.a.DragSortListView, 0, 0);
            this.w = Math.max(1, typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 1));
            this.ad = typedArrayObtainStyledAttributes.getBoolean(5, false);
            if (this.ad) {
                this.ae = new f();
            }
            this.g = typedArrayObtainStyledAttributes.getFloat(6, this.g);
            this.h = this.g;
            this.u = typedArrayObtainStyledAttributes.getBoolean(10, this.u);
            this.aa = Math.max(0.0f, Math.min(1.0f, 1.0f - typedArrayObtainStyledAttributes.getFloat(7, 0.75f)));
            this.l = this.aa > 0.0f;
            setDragScrollStart(typedArrayObtainStyledAttributes.getFloat(1, this.C));
            this.K = typedArrayObtainStyledAttributes.getFloat(2, this.K);
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
                aio aioVar = new aio(this, resourceId, i7, i6, resourceId3, resourceId2);
                aioVar.b(z);
                aioVar.a(z2);
                aioVar.f(color);
                this.U = aioVar;
                setOnTouchListener(aioVar);
            }
            typedArrayObtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.ao = MusicPlaylistManager.a();
        this.B = new d();
        if (i3 > 0) {
            this.aj = new l(0.5f, i3);
        }
        if (i2 > 0) {
            this.al = new g(0.5f, i2);
        }
        this.V = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.f = new DataSetObserver() { // from class: com.harman.hkconnect.dslv.DragSortListView.2
            private void a() {
                if (DragSortListView.this.v == 4) {
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
    }

    public void setFloatAlpha(float f2) {
        this.h = f2;
    }

    public float getFloatAlpha() {
        return this.h;
    }

    public void setMaxScrollSpeed(float f2) {
        this.K = f2;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.ac = new a(listAdapter);
            listAdapter.registerDataSetObserver(this.f);
            if (listAdapter instanceof h) {
                setDropListener((h) listAdapter);
            }
            if (listAdapter instanceof b) {
                setDragListener((b) listAdapter);
            }
            if (listAdapter instanceof m) {
                setRemoveListener((m) listAdapter);
            }
        } else {
            this.ac = null;
        }
        super.setAdapter((ListAdapter) this.ac);
    }

    public void setIsRemoving(boolean z) {
        this.ai = z;
    }

    public ListAdapter getInputAdapter() {
        if (this.ac == null) {
            return null;
        }
        return this.ac.a();
    }

    class a extends BaseAdapter {
        private ListAdapter b;

        public a(ListAdapter listAdapter) {
            this.b = listAdapter;
            this.b.registerDataSetObserver(new DataSetObserver() { // from class: com.harman.hkconnect.dslv.DragSortListView.a.1
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
            return this.b;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return this.b.getItemId(i);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.b.getItem(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.b.getCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return this.b.areAllItemsEnabled();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i) {
            return this.b.isEnabled(i);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return this.b.getItemViewType(i);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return this.b.getViewTypeCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return this.b.hasStableIds();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean isEmpty() {
            return this.b.isEmpty();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            aip aipVar;
            aip aipVar2;
            if (view != null) {
                aipVar2 = (aip) view;
                View childAt = aipVar2.getChildAt(0);
                View view2 = this.b.getView(i, childAt, DragSortListView.this);
                if (view2 != childAt) {
                    if (childAt != null) {
                        aipVar2.removeViewAt(0);
                    }
                    aipVar2.addView(view2);
                }
            } else {
                View view3 = this.b.getView(i, null, DragSortListView.this);
                if (view3 instanceof Checkable) {
                    aipVar = new aiq(DragSortListView.this.getContext());
                } else {
                    aipVar = new aip(DragSortListView.this.getContext());
                }
                aipVar.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                aipVar.addView(view3);
                aipVar2 = aipVar;
            }
            DragSortListView.this.a(DragSortListView.this.getHeaderViewsCount() + i, (View) aipVar2, true);
            return aipVar2;
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
            if (i2 > this.m) {
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
        if (this.v != 0) {
            if (this.j != this.m) {
                a(this.j, canvas);
            }
            if (this.k != this.j && this.k != this.m) {
                a(this.k, canvas);
            }
        }
        if (this.a != null) {
            int width = this.a.getWidth();
            int height = this.a.getHeight();
            int i2 = this.b.x;
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
            int i3 = (int) (f2 * 255.0f * this.h);
            canvas.save();
            canvas.translate(this.b.x, this.b.y);
            if (b(this.m)) {
                new arr(canvas, width2).a(width, height, this.b.x);
            }
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.a.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    private boolean b(int i2) {
        if (this.ao.u() != i2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i2) {
        View childAt = getChildAt(i2 - getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : c(i2, e(i2));
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
        int i4 = this.x - this.w;
        int iE = e(i2);
        int iC = c(i2);
        if (this.k <= this.m) {
            if (i2 == this.k && this.j != this.k) {
                if (i2 == this.m) {
                    i3 = (i3 + iC) - this.x;
                } else {
                    i3 = ((iC - iE) + i3) - i4;
                }
            } else if (i2 > this.k && i2 <= this.m) {
                i3 -= i4;
            }
        } else if (i2 > this.m && i2 <= this.j) {
            i3 += i4;
        } else if (i2 == this.k && this.j != this.k) {
            i3 += iC - iE;
        }
        if (i2 <= this.m) {
            return (((this.x - dividerHeight) - e(i2 - 1)) / 2) + i3;
        }
        return (((iE - dividerHeight) - this.x) / 2) + i3;
    }

    private boolean d() {
        int iA;
        int count;
        int i2;
        int firstVisiblePosition = getFirstVisiblePosition();
        int childCount = this.j;
        View childAt = getChildAt(childCount - firstVisiblePosition);
        if (childAt == null) {
            childCount = firstVisiblePosition + (getChildCount() / 2);
            childAt = getChildAt(childCount - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int iA2 = a(childCount, top);
        int dividerHeight = getDividerHeight();
        if (this.d >= iA2) {
            int count2 = getCount();
            int iC = height;
            int i3 = top;
            iA = iA2;
            count = childCount;
            i2 = iA2;
            while (true) {
                if (count < count2) {
                    if (count == count2 - 1) {
                        iA = i3 + dividerHeight + iC;
                        break;
                    }
                    i3 += dividerHeight + iC;
                    iC = c(count + 1);
                    iA = a(count + 1, i3);
                    if (this.d < iA) {
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
                int iC2 = c(count);
                if (count == 0) {
                    iA = (i4 - dividerHeight) - iC2;
                    break;
                }
                i4 -= iC2 + dividerHeight;
                iA = a(count, i4);
                if (this.d >= iA) {
                    break;
                }
                i2 = iA;
            }
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        int i5 = this.j;
        int i6 = this.k;
        float f2 = this.ab;
        if (this.l) {
            int iAbs = Math.abs(iA - i2);
            if (this.d >= iA) {
                int i7 = i2;
                i2 = iA;
                iA = i7;
            }
            int i8 = (int) (iAbs * this.aa * 0.5f);
            float f3 = i8;
            int i9 = i2 + i8;
            int i10 = iA - i8;
            if (this.d < i9) {
                this.j = count - 1;
                this.k = count;
                this.ab = ((i9 - this.d) * 0.5f) / f3;
            } else if (this.d < i10) {
                this.j = count;
                this.k = count;
            } else {
                this.j = count;
                this.k = count + 1;
                this.ab = (1.0f + ((iA - this.d) / f3)) * 0.5f;
            }
        } else {
            this.j = count;
            this.k = count;
        }
        if (this.j < headerViewsCount) {
            this.j = headerViewsCount;
            this.k = headerViewsCount;
            count = headerViewsCount;
        } else if (this.k >= getCount() - footerViewsCount) {
            count = (getCount() - footerViewsCount) - 1;
            this.j = count;
            this.k = count;
        }
        boolean z = (this.j == i5 && this.k == i6 && this.ab == f2) ? false : true;
        if (count == this.i) {
            return z;
        }
        if (this.r != null) {
            this.r.a(this.i - headerViewsCount, count - headerViewsCount);
        }
        this.i = count;
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ad) {
            this.ae.b();
        }
    }

    class n implements Runnable {
        private float a;
        protected long b;
        private float d;
        private float e;
        private float f;
        private float g;
        private float h;
        private boolean i;

        public n(float f, int i) {
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

    class k extends n {
        final /* synthetic */ DragSortListView a;
        private float d;
        private float e;

        @Override // com.harman.hkconnect.dslv.DragSortListView.n
        public void a() {
            this.d = this.a.o;
            this.e = this.a.y;
        }

        @Override // com.harman.hkconnect.dslv.DragSortListView.n
        public void a(float f, float f2) {
            if (this.a.v != 4) {
                d();
                return;
            }
            this.a.o = (int) ((this.e * f2) + ((1.0f - f2) * this.d));
            this.a.b.y = this.a.N - this.a.o;
            this.a.b(true);
        }
    }

    class g extends n {
        private int d;
        private int e;
        private float f;
        private float g;

        public g(float f, int i) {
            super(f, i);
        }

        @Override // com.harman.hkconnect.dslv.DragSortListView.n
        public void a() {
            this.d = DragSortListView.this.i;
            this.e = DragSortListView.this.m;
            DragSortListView.this.v = 2;
            this.f = DragSortListView.this.b.y - e();
            this.g = DragSortListView.this.b.x - DragSortListView.this.getPaddingLeft();
        }

        private int e() {
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            int dividerHeight = (DragSortListView.this.w + DragSortListView.this.getDividerHeight()) / 2;
            View childAt = DragSortListView.this.getChildAt(this.d - firstVisiblePosition);
            if (childAt != null) {
                if (this.d == this.e) {
                    return childAt.getTop();
                }
                if (this.d >= this.e) {
                    return (childAt.getBottom() + dividerHeight) - DragSortListView.this.x;
                }
                return childAt.getTop() - dividerHeight;
            }
            d();
            return -1;
        }

        @Override // com.harman.hkconnect.dslv.DragSortListView.n
        public void a(float f, float f2) {
            int iE = e();
            int paddingLeft = DragSortListView.this.getPaddingLeft();
            float f3 = DragSortListView.this.b.y - iE;
            float f4 = DragSortListView.this.b.x - paddingLeft;
            float f5 = 1.0f - f2;
            if (f5 < Math.abs(f3 / this.f) || f5 < Math.abs(f4 / this.g)) {
                DragSortListView.this.b.y = iE + ((int) (this.f * f5));
                DragSortListView.this.b.x = DragSortListView.this.getPaddingLeft() + ((int) (this.g * f5));
                DragSortListView.this.b(true);
            }
        }

        @Override // com.harman.hkconnect.dslv.DragSortListView.n
        public void b() {
            DragSortListView.this.f();
        }
    }

    class l extends n {
        private float d;
        private float e;
        private float f;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;

        public l(float f, int i) {
            super(f, i);
            this.g = -1;
            this.h = -1;
        }

        @Override // com.harman.hkconnect.dslv.DragSortListView.n
        public void a() {
            this.g = -1;
            this.h = -1;
            this.i = DragSortListView.this.j;
            this.j = DragSortListView.this.k;
            this.k = DragSortListView.this.m;
            DragSortListView.this.v = 1;
            this.d = DragSortListView.this.b.x;
            if (!DragSortListView.this.am) {
                DragSortListView.this.n();
                return;
            }
            float width = DragSortListView.this.getWidth() * 2.0f;
            if (DragSortListView.this.an == 0.0f) {
                DragSortListView.this.an = (this.d >= 0.0f ? 1 : -1) * width;
                return;
            }
            float f = width * 2.0f;
            if (DragSortListView.this.an < 0.0f && DragSortListView.this.an > (-f)) {
                DragSortListView.this.an = -f;
            } else if (DragSortListView.this.an > 0.0f && DragSortListView.this.an < f) {
                DragSortListView.this.an = f;
            }
        }

        @Override // com.harman.hkconnect.dslv.DragSortListView.n
        public void a(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            View childAt2 = DragSortListView.this.getChildAt(this.i - firstVisiblePosition);
            if (DragSortListView.this.am) {
                float fUptimeMillis = (SystemClock.uptimeMillis() - this.b) / 1000.0f;
                if (fUptimeMillis != 0.0f) {
                    float f4 = DragSortListView.this.an * fUptimeMillis;
                    int width = DragSortListView.this.getWidth();
                    DragSortListView.this.an = ((DragSortListView.this.an > 0.0f ? 1 : -1) * fUptimeMillis * width) + DragSortListView.this.an;
                    this.d += f4;
                    DragSortListView.this.b.x = (int) this.d;
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

        @Override // com.harman.hkconnect.dslv.DragSortListView.n
        public void b() {
            DragSortListView.this.g();
        }
    }

    public void a(int i2) {
        this.am = false;
        a(i2, 0.0f);
    }

    public void a(int i2, float f2) {
        if (this.v == 0 || this.v == 4) {
            if (this.v == 0) {
                this.m = getHeaderViewsCount() + i2;
                this.j = this.m;
                this.k = this.m;
                this.i = this.m;
                View childAt = getChildAt(this.m - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.v = 1;
            this.an = f2;
            if (this.T) {
                switch (this.W) {
                    case 1:
                        super.onTouchEvent(this.V);
                        break;
                    case 2:
                        super.onInterceptTouchEvent(this.V);
                        break;
                }
            }
            if (this.aj != null) {
                this.aj.c();
            } else {
                d(i2);
            }
        }
    }

    public void a() {
        if (this.v == 4) {
            this.B.a(true);
            n();
            e();
            k();
            if (this.T) {
                this.v = 3;
            } else {
                this.v = 0;
            }
        }
    }

    private void e() {
        this.m = -1;
        this.j = -1;
        this.k = -1;
        this.i = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.v = 2;
        if (this.s != null && this.i >= 0 && this.i < getCount()) {
            int headerViewsCount = getHeaderViewsCount();
            this.s.b(this.m - headerViewsCount, this.i - headerViewsCount);
        }
        n();
        h();
        e();
        k();
        if (this.T) {
            this.v = 3;
        } else {
            this.v = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        d(this.m - getHeaderViewsCount());
    }

    private void d(int i2) {
        this.v = 1;
        if (this.t != null) {
            this.t.a(i2);
        }
        n();
        h();
        e();
        if (this.T) {
            this.v = 3;
        } else {
            this.v = 0;
        }
    }

    private void h() {
        int firstVisiblePosition = getFirstVisiblePosition();
        if (this.m < firstVisiblePosition) {
            View childAt = getChildAt(0);
            setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - getPaddingTop());
        }
    }

    public boolean a(boolean z) {
        this.am = false;
        return b(z, 0.0f);
    }

    public boolean a(boolean z, float f2) {
        this.am = true;
        return b(z, f2);
    }

    public boolean b(boolean z, float f2) {
        if (this.a != null) {
            this.B.a(true);
            if (z) {
                a(this.m - getHeaderViewsCount(), f2);
            } else if (this.al != null) {
                this.al.c();
            } else {
                f();
            }
            if (!this.ad) {
                return true;
            }
            this.ae.d();
            return true;
        }
        return false;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.ag) {
            this.ag = false;
            return false;
        }
        if (!this.u) {
            return super.onTouchEvent(motionEvent);
        }
        boolean z2 = this.S;
        this.S = false;
        if (!z2) {
            b(motionEvent);
        }
        if (this.v == 4) {
            a(motionEvent);
            z = true;
        } else {
            z = this.v == 0 && super.onTouchEvent(motionEvent);
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.ap = motionEvent.getRawY();
                    break;
                case 1:
                    i();
                    break;
                case 2:
                    if (motionEvent.getRawY() > this.ap && a((ListView) this)) {
                        return true;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                    break;
                case 3:
                    return false;
                default:
                    if (z) {
                        this.W = 1;
                    }
                    break;
            }
        }
        return z;
    }

    private boolean a(ListView listView) {
        return listView.getChildCount() == 0 || listView.getChildAt(0).getTop() == 0;
    }

    private void i() {
        this.W = 0;
        this.T = false;
        if (this.v == 3) {
            this.v = 0;
        }
        this.h = this.g;
        this.aq = false;
        this.ah.a();
    }

    private void b(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.O = this.M;
            this.P = this.N;
        }
        this.M = (int) motionEvent.getX();
        this.N = (int) motionEvent.getY();
        if (action == 0) {
            this.O = this.M;
            this.P = this.N;
        }
        this.p = ((int) motionEvent.getRawX()) - this.M;
        this.q = ((int) motionEvent.getRawY()) - this.N;
    }

    public boolean b() {
        return this.aq;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.u) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        b(motionEvent);
        this.S = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.v != 0) {
                this.ag = true;
                return true;
            }
            this.T = true;
        }
        if (this.a == null) {
            if (super.onInterceptTouchEvent(motionEvent)) {
                this.aq = true;
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
                        this.W = 1;
                    } else {
                        this.W = 2;
                    }
                    break;
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.T = false;
        }
        return z;
    }

    public void setDragScrollStart(float f2) {
        a(f2, f2);
    }

    public void a(float f2, float f3) {
        if (f3 > 0.5f) {
            this.D = 0.5f;
        } else {
            this.D = f3;
        }
        if (f2 > 0.5f) {
            this.C = 0.5f;
        } else {
            this.C = f2;
        }
        if (getHeight() != 0) {
            j();
        }
    }

    private void b(int i2, int i3) {
        this.b.x = i2 - this.n;
        this.b.y = i3 - this.o;
        b(true);
        int iMin = Math.min(i3, this.d + this.y);
        int iMax = Math.max(i3, this.d - this.y);
        int iB = this.B.b();
        if (iMin > this.P && iMin > this.F && iB != 1) {
            if (iB != -1) {
                this.B.a(true);
            }
            this.B.a(1);
        } else if (iMax < this.P && iMax < this.E && iB != 0) {
            if (iB != -1) {
                this.B.a(true);
            }
            this.B.a(0);
        } else if (iMax >= this.E && iMin <= this.F && this.B.a()) {
            this.B.a(true);
        }
    }

    private void j() {
        int paddingTop = getPaddingTop();
        float height = (getHeight() - paddingTop) - getPaddingBottom();
        this.H = paddingTop + (this.C * height);
        this.G = (height * (1.0f - this.D)) + paddingTop;
        this.E = (int) this.H;
        this.F = (int) this.G;
        this.I = this.H - paddingTop;
        this.J = (paddingTop + r1) - this.G;
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
        if (i2 != this.m && i2 != this.j && i2 != this.k) {
            iC = -2;
        } else {
            iC = c(i2, view, z);
        }
        if (iC != layoutParams.height) {
            layoutParams.height = iC;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.j || i2 == this.k) {
            if (i2 < this.m) {
                ((aip) view).setGravity(80);
            } else if (i2 > this.m) {
                ((aip) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.m && this.a != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(int i2) {
        View view;
        if (i2 == this.m) {
            return 0;
        }
        View childAt = getChildAt(i2 - getFirstVisiblePosition());
        if (childAt != null) {
            return b(i2, childAt, false);
        }
        int iA = this.ah.a(i2);
        if (iA == -1) {
            ListAdapter adapter = getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.A.length) {
                this.A = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.A[itemViewType] == null) {
                    view = adapter.getView(i2, null, this);
                    this.A[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.A[itemViewType], this);
                }
            } else {
                view = adapter.getView(i2, null, this);
            }
            int iB = b(i2, view, true);
            this.ah.a(i2, iB);
            return iB;
        }
        return iA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i2, View view, boolean z) {
        if (i2 == this.m) {
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
        boolean z = this.l && this.j != this.k;
        int i4 = this.x - this.w;
        int i5 = (int) (this.ab * i4);
        if (i2 == this.m) {
            if (this.m == this.j) {
                if (z) {
                    return i5 + this.w;
                }
                return this.x;
            }
            if (this.m == this.k) {
                return this.x - i5;
            }
            return this.w;
        }
        if (i2 == this.j) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        }
        if (i2 == this.k) {
            return (i3 + i4) - i5;
        }
        return i3;
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.af) {
            super.requestLayout();
        }
    }

    private int a(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int iE = e(i2);
        int height = view.getHeight();
        int iC = c(i2, iE);
        if (i2 != this.m) {
            i6 = height - iE;
            i5 = iC - iE;
        } else {
            i5 = iC;
            i6 = height;
        }
        int i7 = this.x;
        if (this.m != this.j && this.m != this.k) {
            i7 -= this.w;
        }
        if (i2 <= i3) {
            if (i2 > this.j) {
                return (i7 - i5) + 0;
            }
        } else {
            if (i2 == i4) {
                if (i2 <= this.j) {
                    return (i6 - i7) + 0;
                }
                if (i2 == this.k) {
                    return (height - iC) + 0;
                }
                return 0 + i6;
            }
            if (i2 <= this.j) {
                return 0 - i7;
            }
            if (i2 == this.k) {
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
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.z, getListPaddingLeft() + getListPaddingRight(), layoutParams.width);
        if (layoutParams.height > 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, iMakeMeasureSpec);
    }

    private void l() {
        if (this.a != null) {
            a(this.a);
            this.x = this.a.getMeasuredHeight();
            this.y = this.x / 2;
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.a != null) {
            if (this.a.isLayoutRequested()) {
                l();
            }
            this.e = true;
        }
        this.z = i2;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    protected void layoutChildren() {
        super.layoutChildren();
        if (this.a != null) {
            if (this.a.isLayoutRequested() && !this.e) {
                l();
            }
            this.a.layout(0, 0, this.a.getMeasuredWidth(), this.a.getMeasuredHeight());
            this.e = false;
        }
    }

    protected boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.v == 4) {
                    a(false);
                }
                i();
                break;
            case 2:
                b((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
            case 3:
                if (this.v == 4) {
                    a();
                }
                i();
                break;
        }
        return true;
    }

    public boolean a(int i2, int i3, int i4, int i5) {
        View viewE;
        if (!this.T || this.U == null || (viewE = this.U.e(i2)) == null) {
            return false;
        }
        return a(i2, viewE, i3, i4, i5);
    }

    public boolean a(int i2, View view, int i3, int i4, int i5) {
        if (this.v != 0 || !this.T || this.a != null || view == null || !this.u) {
            return false;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        int headerViewsCount = getHeaderViewsCount() + i2;
        this.j = headerViewsCount;
        this.k = headerViewsCount;
        this.m = headerViewsCount;
        this.i = headerViewsCount;
        this.v = 4;
        this.R = 0;
        this.R |= i3;
        this.a = view;
        l();
        this.n = i4;
        this.o = i5;
        this.Q = this.N;
        this.b.x = this.M - this.n;
        this.b.y = this.N - this.o;
        View childAt = getChildAt(this.m - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setVisibility(4);
        }
        if (this.ad) {
            this.ae.a();
        }
        switch (this.W) {
            case 1:
                super.onTouchEvent(this.V);
                break;
            case 2:
                super.onInterceptTouchEvent(this.V);
                break;
        }
        requestLayout();
        if (this.ak == null) {
            return true;
        }
        this.ak.c();
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
        this.af = true;
        m();
        int i3 = this.j;
        int i4 = this.k;
        boolean zD = d();
        if (zD) {
            k();
            setSelectionFromTop(i2, (a(i2, view, i3, i4) + view.getTop()) - getPaddingTop());
            layoutChildren();
        }
        if (zD || z) {
            invalidate();
        }
        this.af = false;
    }

    private void m() {
        View childAt;
        if (this.U != null) {
            this.c.set(this.M, this.N);
            this.U.a(this.a, this.b, this.c);
        }
        int i2 = this.b.x;
        int i3 = this.b.y;
        int paddingLeft = getPaddingLeft();
        if ((this.R & 1) == 0 && i2 > paddingLeft) {
            this.b.x = paddingLeft;
        } else if ((this.R & 2) == 0 && i2 < paddingLeft) {
            this.b.x = paddingLeft;
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        int paddingTop = getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.R & 8) == 0 && firstVisiblePosition <= this.m && (childAt = getChildAt(this.m - firstVisiblePosition)) != null) {
            paddingTop = Math.max(childAt.getTop(), paddingTop);
        }
        int height = getHeight() - getPaddingBottom();
        if (lastVisiblePosition >= (getCount() - footerViewsCount) - 1) {
            height = getChildAt(((getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.R & 4) == 0 && lastVisiblePosition >= this.m) {
            height = Math.min(getChildAt(this.m - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.b.y = paddingTop;
        } else if (this.x + i3 > height) {
            this.b.y = height - this.x;
        }
        this.d = this.b.y + this.y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.a != null) {
            this.a.setVisibility(8);
            if (this.U != null) {
                this.U.a(this.a);
            }
            this.a = null;
            invalidate();
        }
    }

    public void setFloatViewManager(i iVar) {
        this.U = iVar;
    }

    public void setDragListener(b bVar) {
        this.r = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.u = z;
    }

    public boolean c() {
        return this.u;
    }

    public void setDropListener(h hVar) {
        this.s = hVar;
    }

    public void setRemoveListener(m mVar) {
        this.t = mVar;
    }

    public void setDragSortListener(e eVar) {
        setDropListener(eVar);
        setDragListener(eVar);
        setRemoveListener(eVar);
    }

    public void setDragScrollProfile(c cVar) {
        if (cVar != null) {
            this.L = cVar;
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
            if (!this.j && !DragSortListView.this.ai) {
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
            int iMin = Math.min(DragSortListView.this.N, DragSortListView.this.d + DragSortListView.this.y);
            int iMax = Math.max(DragSortListView.this.N, DragSortListView.this.d - DragSortListView.this.y);
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
                    this.i = DragSortListView.this.L.a((DragSortListView.this.H - iMax) / DragSortListView.this.I, this.c);
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
                    this.i = -DragSortListView.this.L.a((iMin - DragSortListView.this.G) / DragSortListView.this.J, this.c);
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
            DragSortListView.this.af = true;
            DragSortListView.this.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
            DragSortListView.this.layoutChildren();
            DragSortListView.this.invalidate();
            DragSortListView.this.af = false;
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
                this.a.append("    <FirstExpPos>").append(DragSortListView.this.j).append("</FirstExpPos>\n");
                this.a.append("    <FirstExpBlankHeight>").append(DragSortListView.this.c(DragSortListView.this.j) - DragSortListView.this.e(DragSortListView.this.j)).append("</FirstExpBlankHeight>\n");
                this.a.append("    <SecondExpPos>").append(DragSortListView.this.k).append("</SecondExpPos>\n");
                this.a.append("    <SecondExpBlankHeight>").append(DragSortListView.this.c(DragSortListView.this.k) - DragSortListView.this.e(DragSortListView.this.k)).append("</SecondExpBlankHeight>\n");
                this.a.append("    <SrcPos>").append(DragSortListView.this.m).append("</SrcPos>\n");
                this.a.append("    <SrcHeight>").append(DragSortListView.this.x + DragSortListView.this.getDividerHeight()).append("</SrcHeight>\n");
                this.a.append("    <ViewHeight>").append(DragSortListView.this.getHeight()).append("</ViewHeight>\n");
                this.a.append("    <LastY>").append(DragSortListView.this.P).append("</LastY>\n");
                this.a.append("    <FloatY>").append(DragSortListView.this.d).append("</FloatY>\n");
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
}
