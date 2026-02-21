package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import defpackage.bej;
import defpackage.bel;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class bek extends LinearLayout implements bej.a {
    private LinearLayout a;
    private TextView b;
    private TextView c;
    private ImageView d;
    private ProgressBar e;
    private Animation f;
    private Animation g;
    private final int h;
    private int i;
    private Animation.AnimationListener j;

    public bek(Context context) {
        super(context);
        this.h = 180;
        this.i = -1;
        setWillNotDraw(false);
        a();
    }

    public void a() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.a = (LinearLayout) LayoutInflater.from(getContext()).inflate(bel.b.default_swiperefresh_head_layout, (ViewGroup) null);
        addView(this.a, layoutParams);
        setGravity(80);
        this.d = (ImageView) findViewById(bel.a.default_header_arrow);
        this.b = (TextView) findViewById(bel.a.default_header_textview);
        this.c = (TextView) findViewById(bel.a.default_header_time);
        this.e = (ProgressBar) findViewById(bel.a.default_header_progressbar);
        b();
    }

    public void b() {
        this.f = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.f.setAnimationListener(this.j);
        this.f.setDuration(180L);
        this.f.setFillAfter(true);
        this.g = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.g.setDuration(180L);
        this.g.setFillAfter(true);
    }

    @Override // bej.a
    public void setState(int i) {
        if (i != this.i) {
            if (i == 3 || i == 2) {
                this.d.clearAnimation();
                this.d.setVisibility(4);
                this.e.setVisibility(4);
            } else {
                this.d.setVisibility(0);
                this.e.setVisibility(4);
            }
            switch (i) {
                case 0:
                    if (this.i == 1) {
                        this.d.startAnimation(this.g);
                    }
                    if (this.i == 2) {
                        this.d.clearAnimation();
                    }
                    break;
                case 1:
                    if (this.i != 1) {
                        this.d.clearAnimation();
                        this.d.startAnimation(this.f);
                    }
                    break;
                case 2:
                    c();
                    break;
                case 3:
                    c();
                    break;
            }
            this.i = i;
        }
    }

    public void c() {
        if (d() != null) {
            this.c.setVisibility(4);
        } else {
            this.c.setVisibility(8);
        }
    }

    public String d() {
        return getResources().getString(bel.c.csr_text_last_refresh) + " " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
