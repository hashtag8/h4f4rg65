package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import defpackage.ha;

/* JADX INFO: loaded from: classes.dex */
public class jh extends SeekBar {
    private final ji a;

    public jh(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ha.a.seekBarStyle);
    }

    public jh(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new ji(this);
        this.a.a(attributeSet, i);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a.a(canvas);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.a.c();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.a.b();
    }
}
