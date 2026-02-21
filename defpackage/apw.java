package defpackage;

import android.content.Context;
import android.util.Pair;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.harman.hkconnect.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class apw {
    private final int a;
    private final int b;
    private final Context c;
    private Set<Pair<aoi, Boolean>> d = new HashSet();
    private HashMap<Pair<aoi, Boolean>, Animation> e = new HashMap<>();
    private boolean f = false;

    public apw(Context context, int i, int i2) {
        this.c = context;
        this.a = i;
        this.b = i2;
    }

    public void a(Animation animation, aoi aoiVar, boolean z) {
        mm.b("onAnimationStart " + aoiVar + z, new Object[0]);
        final Pair<aoi, Boolean> pairCreate = Pair.create(aoiVar, Boolean.valueOf(z));
        this.d.add(pairCreate);
        if (animation.getDuration() == 0) {
            b(animation, aoiVar, z);
        }
        mo.a.postDelayed(new Runnable() { // from class: apw.1
            @Override // java.lang.Runnable
            public void run() {
                if (apw.this.d.contains(pairCreate)) {
                    apw.this.d.remove(pairCreate);
                }
            }
        }, 500L);
    }

    public void b(Animation animation, aoi aoiVar, boolean z) {
        mm.b("onAnimationEnd " + aoiVar + z, new Object[0]);
        Pair pairCreate = Pair.create(aoiVar, Boolean.valueOf(z));
        this.d.remove(pairCreate);
        if (this.e.containsKey(pairCreate)) {
            this.e.clear();
            this.f = false;
        }
    }

    public Animation a(aoi aoiVar, boolean z) {
        Pair pairCreate = Pair.create(aoiVar, Boolean.valueOf(z));
        if (this.e.containsKey(pairCreate)) {
            return this.e.get(pairCreate);
        }
        if (this.f) {
            return new AlphaAnimation(0.0f, 0.0f);
        }
        return null;
    }

    public boolean a() {
        boolean z = !this.d.isEmpty();
        if (z) {
            mm.b("Ignoring click while animations are running %s", this.d);
        }
        return z;
    }

    public void a(aoi aoiVar, aoi aoiVar2, boolean z) {
        if (z) {
            this.e.put(Pair.create(aoiVar, false), AnimationUtils.loadAnimation(this.c, R.anim.fragment_slide_out_to_left));
            this.e.put(Pair.create(aoiVar2, true), AnimationUtils.loadAnimation(this.c, R.anim.fragment_slide_in_from_right));
        } else {
            this.e.put(Pair.create(aoiVar, false), null);
            this.e.put(Pair.create(aoiVar2, true), null);
        }
        this.f = true;
    }
}
