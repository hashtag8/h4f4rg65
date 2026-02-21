package defpackage;

import android.view.animation.Animation;
import com.musicservice.dlna.customviews.SlidingPanel;

/* JADX INFO: loaded from: classes.dex */
public class awi {
    public boolean a;
    private SlidingPanel b;
    private Animation c;

    public void a() {
        this.a = false;
        if (this.b.getVisibility() != 8) {
            this.b.startAnimation(this.c);
            this.b.setVisibility(8);
        }
    }
}
