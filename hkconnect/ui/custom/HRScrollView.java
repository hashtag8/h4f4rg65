package com.harman.hkconnect.ui.custom;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public class HRScrollView extends ControlInterceptTouchScrollView {
    private a a;
    private int b;
    private Handler c;

    public interface a {
        void a(int i);
    }

    public HRScrollView(Context context) {
        this(context, null);
    }

    public HRScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HRScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new Handler() { // from class: com.harman.hkconnect.ui.custom.HRScrollView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int scrollY = HRScrollView.this.getScrollY();
                if (HRScrollView.this.b != scrollY) {
                    HRScrollView.this.b = scrollY;
                    HRScrollView.this.c.sendMessageDelayed(HRScrollView.this.c.obtainMessage(), 5L);
                }
                if (HRScrollView.this.a != null) {
                    HRScrollView.this.a.a(scrollY);
                }
            }
        };
    }

    public void setOnScrollListener(a aVar) {
        this.a = aVar;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.a != null) {
            a aVar = this.a;
            int scrollY = getScrollY();
            this.b = scrollY;
            aVar.a(scrollY);
        }
        switch (motionEvent.getAction()) {
            case 1:
                this.c.sendMessageDelayed(this.c.obtainMessage(), 5L);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
