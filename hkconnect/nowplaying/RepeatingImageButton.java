package com.harman.hkconnect.nowplaying;

import android.R;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes.dex */
public class RepeatingImageButton extends ImageButton {
    private long a;
    private int b;
    private a c;
    private long d;
    private Runnable e;

    public interface a {
        void a(View view, long j, int i);
    }

    public RepeatingImageButton(Context context) {
        this(context, null);
    }

    public RepeatingImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    public RepeatingImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 500L;
        this.e = new Runnable() { // from class: com.harman.hkconnect.nowplaying.RepeatingImageButton.1
            @Override // java.lang.Runnable
            public void run() {
                RepeatingImageButton.this.a(false);
                if (RepeatingImageButton.this.isPressed()) {
                    RepeatingImageButton.this.postDelayed(this, RepeatingImageButton.this.d);
                }
            }
        };
        setFocusable(true);
        setLongClickable(true);
    }

    @Override // android.view.View
    public boolean performLongClick() {
        this.a = SystemClock.elapsedRealtime();
        this.b = 0;
        post(this.e);
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            removeCallbacks(this.e);
            if (this.a != 0) {
                a(true);
                this.a = 0L;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 23:
            case 66:
                super.onKeyDown(i, keyEvent);
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        switch (i) {
            case 23:
            case 66:
                removeCallbacks(this.e);
                if (this.a != 0) {
                    a(true);
                    this.a = 0L;
                }
                break;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int i;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.c != null) {
            a aVar = this.c;
            long j = jElapsedRealtime - this.a;
            if (z) {
                i = -1;
            } else {
                i = this.b;
                this.b = i + 1;
            }
            aVar.a(this, j, i);
        }
    }
}
