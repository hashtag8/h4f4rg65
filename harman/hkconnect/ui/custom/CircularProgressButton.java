package com.harman.hkconnect.ui.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.harman.hkconnect.R;
import defpackage.ark;

/* JADX INFO: loaded from: classes.dex */
public class CircularProgressButton extends ImageView {
    private ark a;
    private a b;
    private int c;
    private int d;
    private boolean e;
    private boolean f;
    private int g;
    private int h;
    private boolean i;

    enum a {
        PROGRESS,
        IDLE,
        COMPLETE,
        ERROR
    }

    public CircularProgressButton(Context context) {
        super(context);
        a(context, null);
    }

    public CircularProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public CircularProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.c = 2;
        this.g = 100;
        this.b = a.PROGRESS;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        if (this.b != a.PROGRESS) {
            super.drawableStateChanged();
        }
    }

    protected int a(int i) {
        return getResources().getColor(i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.h > 0 && this.b == a.PROGRESS) {
            a(canvas);
        }
    }

    private void a(Canvas canvas) {
        if (this.a == null) {
            int width = (getWidth() - getHeight()) / 2;
            this.a = new ark(getHeight() - (this.d * 2), this.c, a(R.color.white));
            int i = width + this.d;
            this.a.setBounds(i, this.d, i, this.d);
        }
        this.a.a((360.0f / this.g) * this.h);
        this.a.draw(canvas);
    }

    @SuppressLint({"NewApi"})
    public void setBackgroundCompat(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    public void setProgress(int i) {
        this.h = i;
        if (!this.i && getWidth() != 0 && this.h > 0) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            setProgress(this.h);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.c = this.h;
        savedState.a = this.e;
        savedState.b = true;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.h = savedState.c;
            this.e = savedState.a;
            this.f = savedState.b;
            super.onRestoreInstanceState(savedState.getSuperState());
            setProgress(this.h);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.harman.hkconnect.ui.custom.CircularProgressButton.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private boolean a;
        private boolean b;
        private int c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.c = parcel.readInt();
            this.a = parcel.readInt() == 1;
            this.b = parcel.readInt() == 1;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.c);
            parcel.writeInt(this.a ? 1 : 0);
            parcel.writeInt(this.b ? 1 : 0);
        }
    }
}
