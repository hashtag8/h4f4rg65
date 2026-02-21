package defpackage;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.view.View;
import defpackage.k;

/* JADX INFO: loaded from: classes.dex */
public class ad {
    private static final int[] a = {R.attr.stateListAnimator};

    public static void a(View view, float f) {
        int integer = view.getResources().getInteger(k.f.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(new int[]{R.attr.enabled, k.b.state_collapsible, -k.b.state_collapsed}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(integer));
        stateListAnimator.addState(new int[]{R.attr.enabled}, ObjectAnimator.ofFloat(view, "elevation", f).setDuration(integer));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }
}
