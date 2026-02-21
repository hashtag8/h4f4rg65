package com.harman.hkconnect.ui.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import defpackage.ahe;

/* JADX INFO: loaded from: classes.dex */
public class StoredBitmapImageView extends ImageView {
    private Bitmap a;
    private View b;

    public StoredBitmapImageView(Context context) {
        super(context);
    }

    public StoredBitmapImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StoredBitmapImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public StoredBitmapImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public Bitmap getStoredBitmap() {
        if (this.a != null) {
            return this.a;
        }
        if (this.b != null) {
            this.a = ahe.a(this.b);
            return this.a;
        }
        return null;
    }

    public void setStoredBitmap(Bitmap bitmap) {
        this.a = bitmap;
    }

    public void setStoredViewForBitmap(View view) {
        this.b = view;
    }
}
