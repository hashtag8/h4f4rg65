package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import com.harman.hkconnect.R;
import java.lang.ref.WeakReference;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class aqw {
    private Context a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private int j;
    private int k;
    private ListView n;
    private RectF q;
    private a r;
    private int i = 0;
    private int l = -1;
    private boolean m = false;
    private SectionIndexer o = null;
    private String[] p = null;
    private final b s = new b(this);

    public interface a {
        void a(boolean z);
    }

    public aqw(Context context, ListView listView) {
        this.n = null;
        this.a = context;
        this.f = this.a.getResources().getDisplayMetrics().density;
        this.g = this.a.getResources().getDisplayMetrics().scaledDensity;
        this.n = listView;
        a(this.n.getAdapter());
        this.b = 20.0f * this.f;
        this.c = this.f * 2.0f;
        this.d = this.f * 2.0f;
        this.e = 5.0f * this.f;
    }

    public void a(Canvas canvas) {
        if (this.i != 0) {
            Paint paint = new Paint();
            paint.setColor(this.a.getResources().getColor(R.color.bg));
            paint.setAlpha((int) (64.0f * this.h));
            paint.setAntiAlias(true);
            canvas.drawRoundRect(this.q, 5.0f * this.f, 5.0f * this.f, paint);
            if (this.p != null && this.p.length > 0) {
                if (this.l >= 0) {
                    Paint paint2 = new Paint();
                    paint2.setColor(this.a.getResources().getColor(R.color.edge));
                    paint2.setAlpha(HttpStatus.SC_OK);
                    paint2.setAntiAlias(true);
                    paint2.setShadowLayer(3.0f, 0.0f, 0.0f, Color.argb(64, 0, 0, 0));
                    Paint paint3 = new Paint();
                    paint3.setColor(-1);
                    paint3.setAntiAlias(true);
                    paint3.setTextSize(50.0f * this.g);
                    float fMeasureText = paint3.measureText(this.p[this.l]);
                    float fDescent = ((2.0f * this.e) + paint3.descent()) - paint3.ascent();
                    RectF rectF = new RectF((this.j - fDescent) / 2.0f, ((this.k - fDescent) / 2.0f) - ahn.a(this.a, 100.0f), ((this.j - fDescent) / 2.0f) + fDescent, (((this.k - fDescent) / 2.0f) + fDescent) - ahn.a(this.a, 100.0f));
                    canvas.drawRoundRect(rectF, 5.0f * this.f, 5.0f * this.f, paint2);
                    canvas.drawText(this.p[this.l], (((fDescent - fMeasureText) / 2.0f) + rectF.left) - 1.0f, ((rectF.top + this.e) - paint3.ascent()) + 1.0f, paint3);
                }
                Paint paint4 = new Paint();
                paint4.setColor(this.a.getResources().getColor(R.color.edge));
                paint4.setAlpha((int) (255.0f * this.h));
                paint4.setAntiAlias(true);
                paint4.setTextSize(12.0f * this.g);
                float fHeight = (this.q.height() - (2.0f * this.c)) / this.p.length;
                float fDescent2 = (fHeight - (paint4.descent() - paint4.ascent())) / 2.0f;
                for (int i = 0; i < this.p.length; i++) {
                    canvas.drawText(this.p[i], ((this.b - paint4.measureText(this.p[i])) / 2.0f) + this.q.left, (((this.q.top + this.c) + (i * fHeight)) + fDescent2) - paint4.ascent(), paint4);
                }
            }
        }
    }

    public void a(a aVar) {
        this.r = aVar;
    }

    public boolean a(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.i != 0 && a(motionEvent.getX(), motionEvent.getY())) {
                    this.r.a(false);
                    a(2);
                    this.m = true;
                    this.l = a(motionEvent.getY());
                    this.n.setSelection(this.o.getPositionForSection(this.l));
                    return true;
                }
                break;
            case 1:
                this.r.a(true);
                if (this.m) {
                    this.m = false;
                    this.l = -1;
                }
                if (this.i == 2) {
                    a(3);
                }
                break;
            case 2:
                if (this.m) {
                    if (!a(motionEvent.getX(), motionEvent.getY())) {
                        return true;
                    }
                    this.l = a(motionEvent.getY());
                    this.n.setSelection(this.o.getPositionForSection(this.l));
                    return true;
                }
                break;
        }
        return false;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.j = i;
        this.k = i2;
        this.q = new RectF((i - this.c) - this.b, this.c, i - this.d, (i2 - this.c) - this.a.getResources().getDimensionPixelSize(R.dimen.bottom_player_height_with_padding_10));
    }

    public void a() {
        if (this.i == 0) {
            a(1);
        } else if (this.i == 3) {
            a(3);
        }
    }

    public void b() {
        if (this.i == 2) {
            a(3);
        }
    }

    public void a(Adapter adapter) {
        if (adapter instanceof SectionIndexer) {
            this.o = (SectionIndexer) adapter;
            this.p = (String[]) this.o.getSections();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i >= 0 && i <= 3) {
            this.i = i;
            switch (this.i) {
                case 0:
                    this.s.removeMessages(0);
                    break;
                case 1:
                    this.h = 0.0f;
                    a(0L);
                    break;
                case 2:
                    this.s.removeMessages(0);
                    break;
                case 3:
                    this.h = 1.0f;
                    a(3000L);
                    break;
            }
        }
    }

    public boolean a(float f, float f2) {
        return f >= this.q.left && f2 >= this.q.top && f2 <= this.q.top + this.q.height();
    }

    private int a(float f) {
        if (this.p == null || this.p.length == 0 || f < this.q.top + this.c) {
            return 0;
        }
        if (f >= (this.q.top + this.q.height()) - this.c) {
            return this.p.length - 1;
        }
        return (int) (((f - this.q.top) - this.c) / ((this.q.height() - (2.0f * this.c)) / this.p.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        this.s.removeMessages(0);
        this.s.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + j);
    }

    static class b extends Handler {
        private final WeakReference<aqw> a;

        public b(aqw aqwVar) {
            this.a = new WeakReference<>(aqwVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            aqw aqwVar = this.a.get();
            if (aqwVar != null) {
                switch (aqwVar.i) {
                    case 1:
                        aqwVar.h = (float) (((double) aqwVar.h) + (((double) (1.0f - aqwVar.h)) * 0.2d));
                        if (aqwVar.h > 0.9d) {
                            aqwVar.h = 1.0f;
                            aqwVar.a(2);
                        }
                        aqwVar.n.invalidate();
                        aqwVar.a(10L);
                        break;
                    case 2:
                        aqwVar.a(3);
                        break;
                    case 3:
                        aqwVar.h = (float) (((double) aqwVar.h) - (((double) aqwVar.h) * 0.2d));
                        if (aqwVar.h < 0.1d) {
                            aqwVar.h = 0.0f;
                            aqwVar.a(0);
                        }
                        aqwVar.n.invalidate();
                        aqwVar.a(10L);
                        break;
                }
            }
        }
    }
}
