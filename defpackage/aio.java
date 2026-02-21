package defpackage;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.harman.commom.music.playlist.MusicPlaylistManager;
import com.harman.hkconnect.dslv.DragSortListView;

/* JADX INFO: loaded from: classes.dex */
public class aio extends air implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int a;
    private boolean b;
    private int c;
    private boolean d;
    private boolean e;
    private GestureDetector f;
    private GestureDetector g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int[] l;
    private int m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private float r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private DragSortListView w;
    private int x;
    private MusicPlaylistManager y;
    private GestureDetector.OnGestureListener z;

    public aio(DragSortListView dragSortListView) {
        this(dragSortListView, 0, 0, 1);
    }

    public aio(DragSortListView dragSortListView, int i, int i2, int i3) {
        this(dragSortListView, i, i2, i3, 0);
    }

    public aio(DragSortListView dragSortListView, int i, int i2, int i3, int i4) {
        this(dragSortListView, i, i2, i3, i4, 0);
    }

    public aio(DragSortListView dragSortListView, int i, int i2, int i3, int i4, int i5) {
        super(dragSortListView);
        this.a = 0;
        this.b = true;
        this.d = false;
        this.e = false;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = new int[2];
        this.q = false;
        this.r = 4000.0f;
        this.z = new GestureDetector.SimpleOnGestureListener() { // from class: aio.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (aio.this.d && aio.this.e) {
                    int width = aio.this.w.getWidth() / 3;
                    if ((f > aio.this.r || Math.abs(motionEvent2.getX() - aio.this.o) > width || f < (-aio.this.r) || Math.abs(motionEvent2.getX() - aio.this.o) > width) && aio.this.a(motionEvent2, f)) {
                        aio.this.w.a(aio.this.g(aio.this.j), f);
                    }
                    aio.this.e = false;
                    aio.this.w.setIsRemoving(aio.this.e);
                }
                return false;
            }
        };
        this.w = dragSortListView;
        this.f = new GestureDetector(dragSortListView.getContext(), this);
        this.g = new GestureDetector(dragSortListView.getContext(), this.z);
        this.g.setIsLongpressEnabled(false);
        this.h = ViewConfiguration.get(dragSortListView.getContext()).getScaledTouchSlop() + 5;
        this.s = i;
        this.t = i4;
        this.u = i5;
        b(i3);
        a(i2);
        this.y = MusicPlaylistManager.a();
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void b(int i) {
        this.c = i;
    }

    public void b(boolean z) {
        this.d = z;
    }

    public void c(int i) {
        this.s = i;
    }

    public void d(int i) {
        this.u = i;
    }

    public boolean a(int i, int i2, int i3) {
        int i4 = 0;
        if (this.b && !this.e) {
            i4 = 12;
        }
        if (this.d && this.e) {
            i4 = i4 | 1 | 2;
        }
        this.q = this.w.a(i - this.w.getHeaderViewsCount(), i4, i2, i3);
        return this.q;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.w.c() && !this.w.b()) {
            this.f.onTouchEvent(motionEvent);
            if (this.d && this.q && this.c == 1) {
                this.g.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.o = (int) motionEvent.getX();
                    this.p = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.d && this.e) {
                        if ((this.x >= 0 ? this.x : -this.x) > this.w.getWidth() / 3) {
                            this.w.a(g(this.i), 0.0f);
                        }
                    }
                    this.e = false;
                    this.w.setIsRemoving(this.e);
                    this.q = false;
                    break;
                case 3:
                    this.e = false;
                    this.w.setIsRemoving(this.e);
                    this.q = false;
                    break;
            }
        }
        return false;
    }

    @Override // defpackage.air, com.harman.hkconnect.dslv.DragSortListView.i
    public void a(View view, Point point, Point point2) {
        if (this.d && this.e) {
            this.x = point.x;
        }
    }

    public int a(MotionEvent motionEvent) {
        return c(motionEvent);
    }

    public int b(MotionEvent motionEvent) {
        if (this.c == 1) {
            return d(motionEvent);
        }
        return -1;
    }

    public int c(MotionEvent motionEvent) {
        return a(motionEvent, this.s);
    }

    public int d(MotionEvent motionEvent) {
        return a(motionEvent, this.u);
    }

    public int a(MotionEvent motionEvent, int i) {
        int iPointToPosition = this.w.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.w.getHeaderViewsCount();
        int footerViewsCount = this.w.getFooterViewsCount();
        int count = this.w.getCount();
        if (iPointToPosition != -1 && iPointToPosition >= headerViewsCount && iPointToPosition < count - footerViewsCount) {
            View childAt = this.w.getChildAt(iPointToPosition - this.w.getFirstVisiblePosition());
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            View viewFindViewById = i == 0 ? childAt : childAt.findViewById(i);
            if (viewFindViewById != null) {
                viewFindViewById.getLocationOnScreen(this.l);
                if (rawX > this.l[0] && rawY > this.l[1] && rawX < this.l[0] + viewFindViewById.getWidth()) {
                    if (rawY < viewFindViewById.getHeight() + this.l[1]) {
                        this.m = childAt.getLeft();
                        this.n = childAt.getTop();
                        return iPointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.d && this.c == 0) {
            this.k = a(motionEvent, this.t);
        }
        this.i = a(motionEvent);
        if (this.i != -1 && this.a == 0) {
            a(this.i, ((int) motionEvent.getX()) - this.m, ((int) motionEvent.getY()) - this.n);
        }
        this.e = false;
        this.w.setIsRemoving(this.e);
        this.v = true;
        this.x = 0;
        this.j = b(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int x2 = (int) motionEvent2.getX();
        int y2 = (int) motionEvent2.getY();
        int i = x2 - this.m;
        int i2 = y2 - this.n;
        if (this.v && !this.q && (this.i != -1 || this.j != -1)) {
            if (this.i != -1) {
                if (this.a == 1 && Math.abs(y2 - y) > this.h && this.b) {
                    a(this.i, i, i2);
                } else if (this.a != 0 && Math.abs(x2 - x) > this.h && this.d) {
                    this.e = true;
                    this.w.setIsRemoving(this.e);
                    a(this.j, i, i2);
                } else {
                    this.v = false;
                }
            } else if (this.j != -1) {
                if (Math.abs(x2 - x) > this.h && this.d) {
                    this.e = true;
                    this.w.setIsRemoving(this.e);
                    a(this.j, i, i2);
                } else if (Math.abs(y2 - y) > this.h) {
                    this.v = false;
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.i != -1 && this.a == 2) {
            this.w.performHapticFeedback(0);
            a(this.i, this.o - this.m, this.p - this.n);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.d && this.c == 0 && this.k != -1) {
            this.w.a(this.k - this.w.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(MotionEvent motionEvent, float f) {
        return (motionEvent.getX() - ((float) this.o) > 0.0f && f > 0.0f) || (motionEvent.getX() - ((float) this.o) < 0.0f && f < 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(int i) {
        mm.b("Yatta Music Manager pos " + MusicPlaylistManager.a().u(), new Object[0]);
        mm.b("Yatta current Selected Position " + i, new Object[0]);
        return this.y.u() != i;
    }
}
