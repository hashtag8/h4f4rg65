package defpackage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.HarmanApplication;

/* JADX INFO: loaded from: classes.dex */
public class arr {
    private Canvas a;
    private float b;

    public arr(Canvas canvas, float f) {
        this.a = canvas;
        this.b = f;
    }

    public void a(float f, float f2, float f3) {
        if (f3 != 0.0f) {
            Paint paint = new Paint();
            paint.setColor(Color.parseColor("#BBBBBB"));
            paint.setAlpha(Math.min(120, ((float) ((int) Math.abs(f3))) > this.b ? (int) (120.0f - ((Math.min(r0, 4000) / 4000.0f) * 120.0f)) : 120));
            Rect rect = new Rect();
            if (f3 < 0.0f) {
                rect.set((int) f, 0, (int) (this.b - f3), (int) f2);
                this.a.drawRect(rect, paint);
                a(HarmanApplication.a().getString(R.string.kSettings_Remove).toUpperCase(), rect, false);
            } else if (f3 > 0.0f) {
                rect.set((int) (-f3), 0, 0, (int) f2);
                this.a.drawRect(rect, paint);
                a(HarmanApplication.a().getString(R.string.kSettings_Remove).toUpperCase(), rect, true);
            }
        }
    }

    public void a(String str, Rect rect, boolean z) {
        float f;
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setTextSize(ahn.a(HarmanApplication.a(), 18.0f));
        paint.setTextAlign(Paint.Align.CENTER);
        Rect rect2 = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect2);
        float fWidth = rect2.width();
        float fHeight = rect2.height();
        if (!z) {
            f = this.b + fWidth;
            fWidth = -fWidth;
        } else {
            f = -fWidth;
        }
        float fExactCenterX = rect.exactCenterX() - (fWidth / 2.0f);
        if (z) {
            if (fExactCenterX < f) {
                fExactCenterX = f;
            }
        } else if (fExactCenterX > f) {
            fExactCenterX = f;
        }
        this.a.drawText(str, 0, str.length(), fExactCenterX, (fHeight / 2.0f) + rect.exactCenterY(), paint);
    }
}
