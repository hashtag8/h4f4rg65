package com.harman.hkconnect.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class AlphaOnClickImageView extends ImageView {
    float a;
    public boolean b;

    public AlphaOnClickImageView(Context context) {
        super(context);
        this.a = 0.3f;
        this.b = false;
    }

    public AlphaOnClickImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0.3f;
        this.b = false;
    }

    public AlphaOnClickImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0.3f;
        this.b = false;
    }

    public AlphaOnClickImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = 0.3f;
        this.b = false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            r0 = 1
            r2 = 1065353216(0x3f800000, float:1.0)
            int r1 = r4.getAction()
            switch(r1) {
                case 0: goto L1c;
                case 1: goto La;
                case 2: goto L26;
                default: goto La;
            }
        La:
            boolean r1 = r3.b
            if (r1 == 0) goto L17
            boolean r1 = r3.b
            if (r1 != 0) goto L30
        L12:
            r3.b = r0
            r3.setAlpha(r2)
        L17:
            boolean r0 = super.onTouchEvent(r4)
            return r0
        L1c:
            float r1 = r3.getAlpha()
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L26
            r3.b = r0
        L26:
            boolean r0 = r3.b
            if (r0 == 0) goto L17
            float r0 = r3.a
            r3.setAlpha(r0)
            goto L17
        L30:
            r0 = 0
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.harman.hkconnect.ui.custom.AlphaOnClickImageView.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
