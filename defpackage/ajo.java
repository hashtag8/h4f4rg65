package defpackage;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;
import com.harman.hkconnect.ui.custom.AnimationView;
import com.harman.hkconnect.ui.custom.ControlInterceptTouchScrollView;
import com.harman.hkconnect.ui.custom.StoredBitmapImageView;

/* JADX INFO: loaded from: classes.dex */
public class ajo implements View.OnTouchListener {
    public static boolean c = false;
    private int A;
    private ajn B;
    private Object C;
    protected GestureDetector a;
    protected DashboardActivity b;
    protected Handler d;
    protected ImageView e;
    protected View f;
    protected boolean g;
    protected a h;
    protected ControlInterceptTouchScrollView i;
    protected b j;
    protected GestureDetector.OnGestureListener k;
    private AbsListView l;
    private WindowManager m;
    private WindowManager.LayoutParams n;
    private Bitmap o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private View v;
    private FrameLayout w;
    private RelativeLayout x;
    private int y;
    private int z;

    public static abstract class b {
        public abstract View a(ViewGroup viewGroup, MotionEvent motionEvent);

        public abstract Object a(View view, ViewGroup viewGroup, MotionEvent motionEvent);
    }

    public void a() {
        this.d.removeCallbacks(this.h);
    }

    public ajo(DashboardActivity dashboardActivity, View view, ControlInterceptTouchScrollView controlInterceptTouchScrollView) {
        this.o = null;
        this.f = null;
        this.u = 0;
        this.g = true;
        this.k = new GestureDetector.OnGestureListener() { // from class: ajo.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                mm.b();
                ajo.this.d.removeCallbacks(ajo.this.h);
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                mm.a(Boolean.valueOf(ajo.this.g));
                if (ajo.this.g) {
                    ajo.this.h = ajo.this.new a(motionEvent);
                    ajo.this.d.postDelayed(ajo.this.h, 250L);
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (ajo.c && ajo.this.e != null) {
                    ajo.this.a((int) motionEvent2.getX(), (int) motionEvent2.getY(), motionEvent2);
                    return true;
                }
                ajo.this.d.removeCallbacks(ajo.this.h);
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }
        };
        this.b = dashboardActivity;
        this.v = view;
        this.d = new Handler();
        this.a = new GestureDetector(this.b, this.k);
        this.a.setIsLongpressEnabled(false);
        this.m = (WindowManager) this.b.getSystemService("window");
        this.s = ahn.c(this.b);
        this.i = controlInterceptTouchScrollView;
    }

    public ajo(DashboardActivity dashboardActivity, View view) {
        this(dashboardActivity, view, null);
    }

    public void a(b bVar) {
        this.j = bVar;
    }

    public void a(ajn ajnVar) {
        this.B = ajnVar;
    }

    public boolean b() {
        return this.b.m();
    }

    public void a(boolean z) {
        this.g = z;
    }

    protected void a(int i, int i2, MotionEvent motionEvent) {
        mm.b("moveX = %s  moveY = %s ", Integer.valueOf(i), Integer.valueOf(i2));
        int i3 = this.y + i;
        int iA = ahn.a(this.b, 27.0f);
        this.n.x = i3 - iA;
        this.n.y = (((this.r + i2) - this.s) - iA) - this.u;
        this.x.setX(this.n.x);
        this.x.setY(this.n.y);
        this.b.a(Math.round(motionEvent.getRawX()), Math.round(motionEvent.getRawY()) - this.u);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.l = (AbsListView) view;
        this.a.onTouchEvent(motionEvent);
        if (motionEvent.getAction() != 1 || !c) {
            return c;
        }
        a(view, motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, int i, int i2) {
        mm.b();
        int i3 = this.y + i;
        this.n = new WindowManager.LayoutParams();
        this.n.format = -3;
        this.n.gravity = 51;
        this.n.width = ahn.a(this.b, 55.0f);
        this.n.height = ahn.a(this.b, 55.0f);
        this.u = ahn.a(this.b, 55.0f);
        int iA = ahn.a(this.b, 27.0f);
        this.n.x = i3 - iA;
        this.n.y = (((this.r + i2) - this.s) - iA) - this.u;
        this.n.flags = 16777242;
        this.n.dimAmount = 0.0f;
        this.e = new ImageView(this.b);
        this.e.setImageBitmap(bitmap);
        this.b.a(this);
        this.e.setLayoutParams(new ViewGroup.LayoutParams(this.n.width, this.n.height));
        this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.e.setVisibility(0);
        this.w = new FrameLayout(this.b);
        this.x = new RelativeLayout(this.b);
        this.n.width = -1;
        this.n.height = -1;
        this.x.setX(this.n.x);
        this.x.setY(this.n.y);
        this.x.setLayoutParams(new RelativeLayout.LayoutParams(ahn.a(this.b, 55.0f), ahn.a(this.b, 55.0f)));
        this.m.addView(this.w, this.n);
        this.x.addView(this.e);
        this.w.addView(this.x);
    }

    public void c() {
        this.d.removeCallbacks(this.h);
        this.b.O();
        this.b.M();
        c = false;
        if (this.f != null) {
            this.f.setVisibility(0);
        }
        if (this.i != null) {
            this.i.b();
        }
        if (this.e != null) {
            this.m.removeView(this.w);
            this.e = null;
        }
        this.b.G();
    }

    protected void a(final View view, MotionEvent motionEvent) {
        int width;
        this.d.removeCallbacks(this.h);
        this.b.O();
        this.b.M();
        if (this.e == null) {
            if (this.f == null) {
                new ml().a("StartDragItemView is null!");
                return;
            } else {
                this.f.setVisibility(0);
                c = false;
                return;
            }
        }
        int iA = ahn.a(this.b, 55.0f);
        float x = (motionEvent.getX() + this.t) - iA;
        float y = (((motionEvent.getY() + this.r) - this.s) - iA) - this.u;
        mm.b("TEST_DRAG_RAW", "mStatusHeight=" + this.s + ",vChangeSize=" + iA + ",dragImageOffset=" + this.u);
        int i = (int) x;
        if (this.v.getVisibility() == 0) {
            width = i + (this.x.getWidth() / 2);
        } else {
            width = i + (this.x.getWidth() / 4);
        }
        Point point = new Point(width, ((int) y) + 170);
        if (this.b.b(Math.round(motionEvent.getRawX()), Math.round(motionEvent.getRawY())) == null || !this.b.F()) {
            c();
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, r9.x - point.x, 0, 0.0f, 0, (r9.y - point.y) + ahn.a(this.b, 25.0f));
        translateAnimation.setDuration(300L);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: ajo.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ajo.this.c();
                ajo.this.d.postDelayed(ajo.this.new c(view), 200L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.x.startAnimation(translateAnimation);
        this.e.startAnimation(scaleAnimation);
        mm.b("TEST_DRAG_RAW", "marginX=" + width + ",posY=" + y);
        long jCurrentTimeMillis = System.currentTimeMillis();
        adz adzVarR = this.b.r();
        System.currentTimeMillis();
        if (adzVarR == null) {
            this.f.setVisibility(0);
            c = false;
            return;
        }
        mm.b("Yatta Time to execute set Visbility of drag image" + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
        ain.n = true;
        aof.a().b(adzVarR);
        this.f.setVisibility(0);
        c = false;
        mm.b("V is %s ", view);
    }

    class c implements Runnable {
        private View b;

        public c(View view) {
            this.b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            mm.b("Notifying %s to play %s", ajo.this.B, ajo.this.C);
            if (ajo.this.B != null) {
                ajo.this.B.a(this.b, ajo.this.d(), ajo.this.C);
            }
        }
    }

    protected View a(MotionEvent motionEvent) {
        if (this.j == null) {
            return this.l.getChildAt(d() - this.l.getFirstVisiblePosition());
        }
        return this.j.a((ViewGroup) this.l.getChildAt(d() - this.l.getFirstVisiblePosition()), motionEvent);
    }

    protected float a(float f) {
        return ((f - ahn.a(this.b, 27.0f)) - this.f.getLeft()) / (this.f.getWidth() - ahn.a(this.b, 55.0f));
    }

    protected float b(float f) {
        return ((f - ahn.a(this.b, 27.0f)) - this.f.getTop()) / Math.abs(this.f.getHeight() - ahn.a(this.b, 55.0f));
    }

    protected int d() {
        return this.l.pointToPosition(this.z, this.A);
    }

    protected Object b(MotionEvent motionEvent) {
        return this.j != null ? this.j.a(this.f, this.l, motionEvent) : ((ListAdapter) this.l.getAdapter()).getItem(d());
    }

    protected View e() {
        return this.f.findViewById(R.id.iv);
    }

    protected int c(float f) {
        return ((int) f) - this.f.getTop();
    }

    Bitmap a(View view) {
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache(true);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return bitmapCreateBitmap;
    }

    public class a implements Runnable {
        MotionEvent a;

        public a(MotionEvent motionEvent) {
            this.a = motionEvent;
        }

        public boolean a() {
            return ajo.c;
        }

        @Override // java.lang.Runnable
        public void run() {
            float f;
            float f2;
            float f3 = 0.4f;
            if (ajo.this.b()) {
                if (ajo.this.i != null) {
                    ajo.this.i.a();
                }
                ajo.this.b.N();
                ajo.this.b.L();
                ajo.c = true;
                ajo.this.z = (int) this.a.getX();
                ajo.this.A = (int) this.a.getY();
                if (ajo.this.d() == -1) {
                    ajo.c = false;
                    return;
                }
                ajo.this.f = ajo.this.a(this.a);
                if (ajo.this.f == null) {
                    ajo.c = false;
                    return;
                }
                final View viewE = ajo.this.e();
                if (viewE != null) {
                    ajo.this.C = ajo.this.b(this.a);
                    ajo.this.q = ajo.this.c(this.a.getY());
                    ajo.this.r = (int) (this.a.getRawY() - ajo.this.A);
                    ajo.this.t = (int) (this.a.getRawX() - ajo.this.z);
                    ajo.this.p = Math.min(viewE.getHeight(), viewE.getWidth());
                    ahn.a(ajo.this.b, 27.0f);
                    float fA = ajo.this.a(this.a.getX());
                    float fB = ajo.this.b(this.a.getY()) - 0.5f;
                    float f4 = fB >= 0.0f ? fB : 0.0f;
                    if (ajo.this.p <= ahn.a(ajo.this.b, 55.0f)) {
                        f2 = 0.5f;
                        f3 = 1.0f;
                        f = 1.0f;
                    } else {
                        f = 0.4f;
                        f2 = f4;
                    }
                    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f, 1.0f, f3, 1, fA, 1, f2);
                    scaleAnimation.setDuration(100L);
                    scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: ajo.a.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            if (ajo.c) {
                                ajo.this.f.setVisibility(4);
                                ajo.this.o = null;
                                if (viewE instanceof AnimationView) {
                                    if (((AnimationView) viewE).getStoredBitmap() != null) {
                                        ajo.this.o = ((AnimationView) viewE).getStoredBitmap();
                                    }
                                } else if ((viewE instanceof StoredBitmapImageView) && ((StoredBitmapImageView) viewE).getStoredBitmap() != null) {
                                    ajo.this.o = ((StoredBitmapImageView) viewE).getStoredBitmap();
                                }
                                int[] iArr = new int[2];
                                ajo.this.v.getLocationOnScreen(iArr);
                                ajo.this.y = iArr[0];
                                if (ajo.this.o != null) {
                                    ajo.this.a(ajo.this.o, ajo.this.z, ajo.this.A);
                                    return;
                                }
                                try {
                                    ajo.this.o = ajo.this.a(viewE);
                                    ajo.this.a(ajo.this.o, ajo.this.z, ajo.this.A);
                                } catch (Throwable th) {
                                    mm.b("Could not create default image ", th);
                                    agx.a().b(R.drawable.empty_cover_art_small, new agw() { // from class: ajo.a.1.1
                                        @Override // defpackage.agw
                                        public void a(Bitmap bitmap) {
                                            ajo.this.o = bitmap;
                                            ajo.this.a(ajo.this.o, ajo.this.z, ajo.this.A);
                                        }
                                    });
                                }
                            }
                        }
                    });
                    ajo.this.f.startAnimation(scaleAnimation);
                    return;
                }
                ajo.c = false;
            }
        }
    }
}
