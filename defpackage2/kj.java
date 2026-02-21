package defpackage;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class kj {
    public static int a(RecyclerView.s sVar, kf kfVar, View view, View view2, RecyclerView.h hVar, boolean z, boolean z2) {
        int iMax;
        if (hVar.u() == 0 || sVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMin = Math.min(hVar.d(view), hVar.d(view2));
        int iMax2 = Math.max(hVar.d(view), hVar.d(view2));
        if (z2) {
            iMax = Math.max(0, (sVar.e() - iMax2) - 1);
        } else {
            iMax = Math.max(0, iMin);
        }
        if (z) {
            return Math.round((iMax * (Math.abs(kfVar.b(view2) - kfVar.a(view)) / (Math.abs(hVar.d(view) - hVar.d(view2)) + 1))) + (kfVar.c() - kfVar.a(view)));
        }
        return iMax;
    }

    public static int a(RecyclerView.s sVar, kf kfVar, View view, View view2, RecyclerView.h hVar, boolean z) {
        if (hVar.u() == 0 || sVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(hVar.d(view) - hVar.d(view2)) + 1;
        }
        return Math.min(kfVar.f(), kfVar.b(view2) - kfVar.a(view));
    }

    public static int b(RecyclerView.s sVar, kf kfVar, View view, View view2, RecyclerView.h hVar, boolean z) {
        if (hVar.u() == 0 || sVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return sVar.e();
        }
        return (int) (((kfVar.b(view2) - kfVar.a(view)) / (Math.abs(hVar.d(view) - hVar.d(view2)) + 1)) * sVar.e());
    }
}
