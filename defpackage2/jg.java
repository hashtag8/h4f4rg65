package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import defpackage.ha;

/* JADX INFO: loaded from: classes.dex */
public class jg extends RatingBar {
    private final je a;

    public jg(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ha.a.ratingBarStyle);
    }

    public jg(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new je(this);
        this.a.a(attributeSet, i);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap bitmapA = this.a.a();
        if (bitmapA != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmapA.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
