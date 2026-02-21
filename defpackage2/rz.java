package defpackage;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@yx
public class rz extends FrameLayout implements ry {
    private final zp a;
    private final FrameLayout b;
    private final sa c;
    private final se d;
    private TextView e;
    private long f;
    private long g;
    private String h;

    public rz(Context context, zp zpVar) {
        super(context);
        this.a = zpVar;
        this.b = new FrameLayout(context);
        addView(this.b);
        this.c = new sa(context);
        this.b.addView(this.c, new FrameLayout.LayoutParams(-1, -1, 17));
        this.e = new TextView(context);
        this.e.setBackgroundColor(-16777216);
        n();
        this.d = new se(this);
        this.d.b();
        this.c.a(this);
    }

    private void a(String str, String... strArr) {
        HashMap map = new HashMap();
        map.put("event", str);
        int length = strArr.length;
        int i = 0;
        String str2 = null;
        while (i < length) {
            String str3 = strArr[i];
            if (str2 != null) {
                map.put(str2, str3);
                str3 = null;
            }
            i++;
            str2 = str3;
        }
        this.a.a("onVideoEvent", map);
    }

    public static void a(zp zpVar) {
        HashMap map = new HashMap();
        map.put("event", "no_video_view");
        zpVar.a("onVideoEvent", map);
    }

    private void n() {
        if (p()) {
            return;
        }
        this.b.addView(this.e, new FrameLayout.LayoutParams(-1, -1));
        this.b.bringChildToFront(this.e);
    }

    private void o() {
        if (p()) {
            this.b.removeView(this.e);
        }
    }

    private boolean p() {
        return this.e.getParent() != null;
    }

    @Override // defpackage.ry
    public void a() {
    }

    public void a(float f) {
        this.c.a(f);
    }

    public void a(int i) {
        this.c.a(i);
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i3 == 0 || i4 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3 + 2, i4 + 2);
        layoutParams.setMargins(i - 1, i2 - 1, 0, 0);
        this.b.setLayoutParams(layoutParams);
        requestLayout();
    }

    @Override // defpackage.ry
    public void a(MediaPlayer mediaPlayer) {
        if (this.g == 0) {
            a("canplaythrough", "duration", String.valueOf(mediaPlayer.getDuration() / 1000.0f), "videoWidth", String.valueOf(mediaPlayer.getVideoWidth()), "videoHeight", String.valueOf(mediaPlayer.getVideoHeight()));
        }
    }

    public void a(MotionEvent motionEvent) {
        this.c.dispatchTouchEvent(motionEvent);
    }

    public void a(String str) {
        this.h = str;
    }

    @Override // defpackage.ry
    public void a(String str, String str2) {
        a("error", "what", str, "extra", str2);
    }

    @Override // defpackage.ry
    public void b() {
    }

    @Override // defpackage.ry
    public void c() {
        a("pause", new String[0]);
    }

    @Override // defpackage.ry
    public void d() {
        a("ended", new String[0]);
    }

    @Override // defpackage.ry
    public void e() {
        n();
        this.g = this.f;
    }

    public void f() {
        if (TextUtils.isEmpty(this.h)) {
            a("no_src", new String[0]);
        } else {
            this.c.setVideoPath(this.h);
        }
    }

    public void g() {
        this.c.c();
    }

    public void h() {
        this.c.b();
    }

    public void i() {
        this.c.d();
    }

    public void j() {
        this.c.e();
    }

    public void k() {
        TextView textView = new TextView(this.c.getContext());
        textView.setText("AdMob");
        textView.setTextColor(-65536);
        textView.setBackgroundColor(-256);
        this.b.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        this.b.bringChildToFront(textView);
    }

    public void l() {
        this.d.a();
        this.c.a();
    }

    void m() {
        long currentPosition = this.c.getCurrentPosition();
        if (this.f == currentPosition || currentPosition <= 0) {
            return;
        }
        o();
        a("timeupdate", "time", String.valueOf(currentPosition / 1000.0f));
        this.f = currentPosition;
    }
}
