package com.harman.hkconnect.ui.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import defpackage.ahu;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class AnimationView extends LinearLayout {
    private Context a;
    private ImageView b;
    private Callable<Bitmap> c;

    public AnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public AnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public AnimationView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        setGravity(17);
    }

    public ImageView getImageView() {
        this.b = new ImageView(this.a);
        addView(this.b);
        return this.b;
    }

    public Bitmap getStoredBitmap() {
        try {
            if (this.c != null) {
                return this.c.call();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public void setStoredBitmap(Callable<Bitmap> callable) {
        this.c = callable;
    }

    public void setText(String str) {
        TextView textView = new TextView(this.a);
        textView.setTextSize(0, getResources().getDimension(R.dimen.font_size_18));
        textView.setTypeface(ahu.a(this.a));
        textView.setTextColor(-16777216);
        textView.setText(str);
        addView(textView);
    }
}
