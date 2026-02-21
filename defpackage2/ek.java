package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public final class ek {
    private final a a;

    interface a {
        boolean a(MotionEvent motionEvent);
    }

    static class b implements a {
        private static final int j = ViewConfiguration.getLongPressTimeout();
        private static final int k = ViewConfiguration.getTapTimeout();
        private static final int l = ViewConfiguration.getDoubleTapTimeout();
        final GestureDetector.OnGestureListener a;
        GestureDetector.OnDoubleTapListener b;
        boolean c;
        boolean d;
        MotionEvent e;
        private int f;
        private int g;
        private int h;
        private int i;
        private final Handler m;
        private boolean n;
        private boolean o;
        private boolean p;
        private MotionEvent q;
        private boolean r;
        private float s;
        private float t;
        private float u;
        private float v;
        private boolean w;
        private VelocityTracker x;

        class a extends Handler {
            a() {
            }

            a(Handler handler) {
                super(handler.getLooper());
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.a.onShowPress(b.this.e);
                        return;
                    case 2:
                        b.this.a();
                        return;
                    case 3:
                        if (b.this.b != null) {
                            if (!b.this.c) {
                                b.this.b.onSingleTapConfirmed(b.this.e);
                                return;
                            } else {
                                b.this.d = true;
                                return;
                            }
                        }
                        return;
                    default:
                        throw new RuntimeException("Unknown message " + message);
                }
            }
        }

        public b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.m = new a(handler);
            } else {
                this.m = new a();
            }
            this.a = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                a((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            a(context);
        }

        private void a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            }
            if (this.a == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
            this.w = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.h = viewConfiguration.getScaledMinimumFlingVelocity();
            this.i = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f = scaledTouchSlop * scaledTouchSlop;
            this.g = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }

        public void a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.b = onDoubleTapListener;
        }

        @Override // ek.a
        public boolean a(MotionEvent motionEvent) {
            boolean zOnFling;
            boolean zOnScroll;
            boolean zOnDoubleTap;
            int action = motionEvent.getAction();
            if (this.x == null) {
                this.x = VelocityTracker.obtain();
            }
            this.x.addMovement(motionEvent);
            boolean z = (action & 255) == 6;
            int actionIndex = z ? motionEvent.getActionIndex() : -1;
            int pointerCount = motionEvent.getPointerCount();
            float y = 0.0f;
            float x = 0.0f;
            for (int i = 0; i < pointerCount; i++) {
                if (actionIndex != i) {
                    x += motionEvent.getX(i);
                    y += motionEvent.getY(i);
                }
            }
            int i2 = z ? pointerCount - 1 : pointerCount;
            float f = x / i2;
            float f2 = y / i2;
            switch (action & 255) {
                case 0:
                    if (this.b == null) {
                        zOnDoubleTap = false;
                    } else {
                        boolean zHasMessages = this.m.hasMessages(3);
                        if (zHasMessages) {
                            this.m.removeMessages(3);
                        }
                        if (this.e != null && this.q != null && zHasMessages && a(this.e, this.q, motionEvent)) {
                            this.r = true;
                            zOnDoubleTap = this.b.onDoubleTap(this.e) | false | this.b.onDoubleTapEvent(motionEvent);
                        } else {
                            this.m.sendEmptyMessageDelayed(3, l);
                            zOnDoubleTap = false;
                        }
                    }
                    this.s = f;
                    this.u = f;
                    this.t = f2;
                    this.v = f2;
                    if (this.e != null) {
                        this.e.recycle();
                    }
                    this.e = MotionEvent.obtain(motionEvent);
                    this.o = true;
                    this.p = true;
                    this.c = true;
                    this.n = false;
                    this.d = false;
                    if (this.w) {
                        this.m.removeMessages(2);
                        this.m.sendEmptyMessageAtTime(2, this.e.getDownTime() + ((long) k) + ((long) j));
                    }
                    this.m.sendEmptyMessageAtTime(1, this.e.getDownTime() + ((long) k));
                    break;
                case 1:
                    this.c = false;
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    if (this.r) {
                        zOnFling = this.b.onDoubleTapEvent(motionEvent) | false;
                    } else if (this.n) {
                        this.m.removeMessages(3);
                        this.n = false;
                        zOnFling = false;
                    } else if (this.o) {
                        zOnFling = this.a.onSingleTapUp(motionEvent);
                        if (this.d && this.b != null) {
                            this.b.onSingleTapConfirmed(motionEvent);
                        }
                    } else {
                        VelocityTracker velocityTracker = this.x;
                        int pointerId = motionEvent.getPointerId(0);
                        velocityTracker.computeCurrentVelocity(1000, this.i);
                        float yVelocity = velocityTracker.getYVelocity(pointerId);
                        float xVelocity = velocityTracker.getXVelocity(pointerId);
                        zOnFling = (Math.abs(yVelocity) > ((float) this.h) || Math.abs(xVelocity) > ((float) this.h)) ? this.a.onFling(this.e, motionEvent, xVelocity, yVelocity) : false;
                    }
                    if (this.q != null) {
                        this.q.recycle();
                    }
                    this.q = motionEventObtain;
                    if (this.x != null) {
                        this.x.recycle();
                        this.x = null;
                    }
                    this.r = false;
                    this.d = false;
                    this.m.removeMessages(1);
                    this.m.removeMessages(2);
                    break;
                case 2:
                    if (!this.n) {
                        float f3 = this.s - f;
                        float f4 = this.t - f2;
                        if (!this.r) {
                            if (this.o) {
                                int i3 = (int) (f - this.u);
                                int i4 = (int) (f2 - this.v);
                                int i5 = (i3 * i3) + (i4 * i4);
                                if (i5 > this.f) {
                                    zOnScroll = this.a.onScroll(this.e, motionEvent, f3, f4);
                                    this.s = f;
                                    this.t = f2;
                                    this.o = false;
                                    this.m.removeMessages(3);
                                    this.m.removeMessages(1);
                                    this.m.removeMessages(2);
                                } else {
                                    zOnScroll = false;
                                }
                                if (i5 > this.f) {
                                    this.p = false;
                                }
                            } else if (Math.abs(f3) >= 1.0f || Math.abs(f4) >= 1.0f) {
                                boolean zOnScroll2 = this.a.onScroll(this.e, motionEvent, f3, f4);
                                this.s = f;
                                this.t = f2;
                            }
                        }
                    }
                    break;
                case 3:
                    b();
                    break;
                case 5:
                    this.s = f;
                    this.u = f;
                    this.t = f2;
                    this.v = f2;
                    c();
                    break;
                case 6:
                    this.s = f;
                    this.u = f;
                    this.t = f2;
                    this.v = f2;
                    this.x.computeCurrentVelocity(1000, this.i);
                    int actionIndex2 = motionEvent.getActionIndex();
                    int pointerId2 = motionEvent.getPointerId(actionIndex2);
                    float xVelocity2 = this.x.getXVelocity(pointerId2);
                    float yVelocity2 = this.x.getYVelocity(pointerId2);
                    for (int i6 = 0; i6 < pointerCount; i6++) {
                        if (i6 != actionIndex2) {
                            int pointerId3 = motionEvent.getPointerId(i6);
                            if ((this.x.getYVelocity(pointerId3) * yVelocity2) + (this.x.getXVelocity(pointerId3) * xVelocity2) < 0.0f) {
                                this.x.clear();
                                break;
                            }
                        }
                    }
                    break;
            }
            return false;
        }

        private void b() {
            this.m.removeMessages(1);
            this.m.removeMessages(2);
            this.m.removeMessages(3);
            this.x.recycle();
            this.x = null;
            this.r = false;
            this.c = false;
            this.o = false;
            this.p = false;
            this.d = false;
            if (this.n) {
                this.n = false;
            }
        }

        private void c() {
            this.m.removeMessages(1);
            this.m.removeMessages(2);
            this.m.removeMessages(3);
            this.r = false;
            this.o = false;
            this.p = false;
            this.d = false;
            if (this.n) {
                this.n = false;
            }
        }

        private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.p || motionEvent3.getEventTime() - motionEvent2.getEventTime() > l) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x * x) + (y * y) < this.g;
        }

        void a() {
            this.m.removeMessages(3);
            this.d = false;
            this.n = true;
            this.a.onLongPress(this.e);
        }
    }

    static class c implements a {
        private final GestureDetector a;

        public c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // ek.a
        public boolean a(MotionEvent motionEvent) {
            return this.a.onTouchEvent(motionEvent);
        }
    }

    public ek(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public ek(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.a = new c(context, onGestureListener, handler);
        } else {
            this.a = new b(context, onGestureListener, handler);
        }
    }

    public boolean a(MotionEvent motionEvent) {
        return this.a.a(motionEvent);
    }
}
