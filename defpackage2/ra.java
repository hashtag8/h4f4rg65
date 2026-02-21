package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class ra extends ViewGroup {
    private final rr a;

    public qy getAdListener() {
        return this.a.a();
    }

    public qz getAdSize() {
        return this.a.b();
    }

    public String getAdUnitId() {
        return this.a.c();
    }

    public ta getInAppPurchaseListener() {
        return this.a.d();
    }

    public String getMediationAdapterClassName() {
        return this.a.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i5 = ((i3 - i) - measuredWidth) / 2;
        int i6 = ((i4 - i2) - measuredHeight) / 2;
        childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int iB;
        int iA = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            qz adSize = getAdSize();
            if (adSize != null) {
                Context context = getContext();
                iB = adSize.b(context);
                iA = adSize.a(context);
            } else {
                iB = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            iB = childAt.getMeasuredWidth();
            iA = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(iB, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(iA, getSuggestedMinimumHeight()), i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdListener(qy qyVar) {
        this.a.a(qyVar);
        if (qyVar != 0 && (qyVar instanceof rb)) {
            this.a.a((rb) qyVar);
        } else if (qyVar == 0) {
            this.a.a((rb) null);
        }
    }

    public void setAdSize(qz qzVar) {
        this.a.a(qzVar);
    }

    public void setAdUnitId(String str) {
        this.a.a(str);
    }

    public void setInAppPurchaseListener(ta taVar) {
        this.a.a(taVar);
    }
}
