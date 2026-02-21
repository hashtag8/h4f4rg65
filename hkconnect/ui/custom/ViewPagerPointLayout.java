package com.harman.hkconnect.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.harman.hkconnect.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ViewPagerPointLayout extends LinearLayout {
    private int a;
    private ArrayList<ImageView> b;

    public ViewPagerPointLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new ArrayList<>();
    }

    public void setSize(int i) {
        this.a = i;
        this.b.clear();
        for (int i2 = 0; i2 < i; i2++) {
            ImageView imageViewA = a();
            addView(imageViewA);
            this.b.add(imageViewA);
        }
        this.b.get(0).setImageResource(R.drawable.icon_selected);
    }

    public void setSelectedPostion(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.a) {
                ImageView imageView = this.b.get(i3);
                if (i3 == i) {
                    imageView.setImageResource(R.drawable.icon_selected);
                } else {
                    imageView.setImageResource(R.drawable.icon_unselected);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private ImageView a() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.icon_unselected);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        layoutParams.leftMargin = (int) getContext().getResources().getDimension(R.dimen.tutorial_PagePoint_maigin);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }
}
