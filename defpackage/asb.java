package defpackage;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.DashboardActivity;

/* JADX INFO: loaded from: classes.dex */
public class asb implements AdapterView.OnItemClickListener {
    private static int c = 0;
    private static int d = 1;
    private static int e = 2;
    private static int f = 3;
    private Context a;
    private a b;

    public interface a {
        void a(int i);
    }

    public asb(Context context, a aVar) {
        this.a = context;
        this.b = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (((TextView) view).getText().equals(this.a.getString(R.string.PlayTip_PlayNow_Str).toUpperCase())) {
            a(c);
        } else if (((TextView) view).getText().equals(this.a.getString(R.string.PlayTip_PlayNext_Str).toUpperCase())) {
            a(d);
        } else if (((TextView) view).getText().equals(this.a.getString(R.string.PlayTip_AddSongToQueue_Str).toUpperCase())) {
            a(e);
        } else if (((TextView) view).getText().equals(this.a.getString(R.string.PlayTip_ClearAll_Str).toUpperCase())) {
            a(f);
        }
        this.b.a(i);
    }

    private void a(int i) {
        int i2;
        int i3;
        if (i == c) {
            i3 = R.drawable.icon_playnow;
            i2 = R.string.PlayTip_PlayNow_Str;
        } else if (i == d) {
            i3 = R.drawable.icon_playnext;
            i2 = R.string.PlayTip_PlayNext_Str;
        } else if (i == e) {
            i3 = R.drawable.icon_added;
            i2 = R.string.kPlayOptionPopupAddToQueue_Str;
        } else if (i == f) {
            i3 = R.drawable.icon_replace;
            i2 = R.string.kPlayOptionPopupReplaceQueue_Str;
        } else {
            i2 = -1;
            i3 = -1;
        }
        if (i3 != -1 && i2 != -1 && (this.a instanceof DashboardActivity)) {
            a(i3, i2);
        }
    }

    private void a(int i, int i2) {
        final LinearLayout linearLayout = (LinearLayout) ((DashboardActivity) this.a).findViewById(R.id.playmode_popup);
        ImageView imageView = (ImageView) ((DashboardActivity) this.a).findViewById(R.id.playmode_popup_icon);
        TextView textView = (TextView) ((DashboardActivity) this.a).findViewById(R.id.playmode_popup_text);
        imageView.setImageResource(i);
        textView.setText(this.a.getString(i2).toUpperCase());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setStartOffset(300L);
        alphaAnimation.setDuration(250L);
        linearLayout.setVisibility(0);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: asb.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setDuration(250L);
                alphaAnimation2.setStartOffset(500L);
                alphaAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: asb.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        linearLayout.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                linearLayout.startAnimation(alphaAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        linearLayout.startAnimation(alphaAnimation);
    }
}
