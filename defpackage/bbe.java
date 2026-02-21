package defpackage;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.TextView;
import com.harman.hkconnect.R;

/* JADX INFO: loaded from: classes.dex */
public class bbe {
    private View a;
    private View b;
    private TextView c;
    private AbsListView d;
    private Boolean e = false;

    public bbe(View view, AbsListView absListView) {
        this.a = view.findViewById(R.id.empty_loading_view);
        this.b = view.findViewById(R.id.empty_postload_view);
        this.c = (TextView) this.b.findViewById(R.id.error_textview);
        this.d = absListView;
    }

    public void a() {
        this.a.setVisibility(0);
        this.d.setVisibility(8);
        this.b.setVisibility(8);
    }

    public void a(final boolean z) {
        if (!this.e.booleanValue()) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: bbe.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    bbe.this.a();
                    bbe.this.d.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    bbe.this.a.setVisibility(8);
                    bbe.this.e = Boolean.valueOf(!z);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            alphaAnimation.setDuration(500L);
            this.d.startAnimation(alphaAnimation);
            this.e = true;
        }
    }

    public void a(final String str, final boolean z) {
        if (!this.e.booleanValue()) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: bbe.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    bbe.this.a();
                    bbe.this.c.setText(str);
                    bbe.this.b.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    bbe.this.a.setVisibility(8);
                    bbe.this.e = Boolean.valueOf(!z);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            alphaAnimation.setDuration(500L);
            this.b.startAnimation(alphaAnimation);
            this.e = true;
        }
    }
}
