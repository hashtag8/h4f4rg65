package defpackage;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.harman.hkconnect.R;
import defpackage.agt;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class awg {
    private Context b;
    private int c;
    private RelativeLayout d;
    private boolean e = false;
    agt.b a = new agt.b() { // from class: awg.1
        @Override // agt.b
        public void a() {
            if (awg.this.e) {
                awg.this.e();
            }
        }
    };

    public awg(Context context, View view) {
        this.b = context;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.c = displayMetrics.widthPixels;
        a(view);
        a();
    }

    public void a(View view) {
        this.d = (RelativeLayout) view.findViewById(R.id.windowsAnimationLayout);
    }

    public void a() {
        this.e = false;
    }

    public void b() {
        this.d.setVisibility(0);
        if (!this.e) {
            this.e = true;
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int iA = ahn.a(this.b, 8.0f);
        int i = agt.a;
        if (ahn.a()) {
            i = agt.b;
        }
        agt.a(this.d, iA, 5, i, R.drawable.circle_white, 2000, 0, this.c, this.a);
    }

    private ArrayList<View> b(View view) {
        if (!(view instanceof ViewGroup)) {
            ArrayList<View> arrayList = new ArrayList<>();
            arrayList.add(view);
            return arrayList;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(view);
            arrayList3.addAll(b(childAt));
            arrayList2.addAll(arrayList3);
        }
        return arrayList2;
    }

    public void c() {
        Iterator<View> it = b(this.d).iterator();
        while (it.hasNext()) {
            it.next().clearAnimation();
        }
        this.d.removeAllViewsInLayout();
        a();
        if (this.d != null) {
            this.d.setVisibility(8);
        }
    }

    public boolean d() {
        return this.d != null && this.d.getVisibility() == 0;
    }
}
