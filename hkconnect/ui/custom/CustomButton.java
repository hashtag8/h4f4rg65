package com.harman.hkconnect.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.harman.hkconnect.R;
import defpackage.ahu;
import defpackage.aib;

/* JADX INFO: loaded from: classes.dex */
public class CustomButton extends LinearLayout {
    private String a;
    private Drawable b;
    private Context c;
    private ImageView d;
    private TextView e;
    private int f;

    public CustomButton(Context context) {
        super(context);
        this.f = getResources().getColor(R.color.white);
        this.c = context;
    }

    public CustomButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = getResources().getColor(R.color.white);
        this.c = context;
        a(context, attributeSet);
    }

    public CustomButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = getResources().getColor(R.color.white);
        this.c = context;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aib.a.CustomButton);
            this.a = typedArrayObtainStyledAttributes.getString(0);
            this.b = typedArrayObtainStyledAttributes.getDrawable(1);
        }
        a();
    }

    private void a() {
        if (getBackground() == null) {
            setBackgroundResource(R.drawable.custom_button_bg);
        }
        setGravity(17);
        if (!isInEditMode()) {
            if (this.b != null && this.a != null) {
                this.d = new ImageView(this.c);
                this.d.setImageDrawable(this.b);
                this.d.setColorFilter(this.f);
                this.e = new TextView(this.c);
                this.e.setTypeface(ahu.a(this.c));
                this.e.setTextSize(getResources().getInteger(R.integer.group_item));
                this.e.setTextColor(this.f);
                this.e.setText(this.a);
                addView(this.d);
                return;
            }
            if (this.b != null) {
                ImageView imageView = new ImageView(this.c);
                imageView.setImageDrawable(this.b);
                imageView.setColorFilter(this.f);
                addView(imageView);
            }
            if (this.a != null) {
                TextView textView = new TextView(this.c);
                textView.setTypeface(ahu.a(this.c));
                textView.setTextSize(getResources().getInteger(R.integer.group_item));
                textView.setTextColor(this.f);
                textView.setText(this.a);
                addView(textView);
            }
        }
    }

    public void setColor(int i) {
        this.f = i;
    }
}
