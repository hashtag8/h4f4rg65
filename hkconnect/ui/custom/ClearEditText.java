package com.harman.hkconnect.ui.custom;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.EditText;
import defpackage.ahf;
import defpackage.mo;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public class ClearEditText extends TypefaceEditText {
    private String a;

    class a implements TextWatcher {
        private EditText b;
        private int c;

        public a(EditText editText, int i) {
            this.b = editText;
            this.c = i <= 0 ? 0 : i;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String str;
            if (charSequence != null) {
                charSequence.toString();
                if (i3 > 0) {
                    try {
                        if (this.c > 0) {
                            int i4 = i3;
                            while (true) {
                                str = charSequence.toString().substring(0, i + i4) + charSequence.toString().substring(i + i3);
                                if (str.getBytes("utf-8").length < this.c) {
                                    break;
                                }
                                int i5 = i4 - 1;
                                if (i4 <= 0) {
                                    i4 = i5;
                                    break;
                                }
                                i4 = i5;
                            }
                            if (!str.equals(charSequence.toString())) {
                                this.b.setText(str);
                                this.b.setSelection(i4 + i);
                            }
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }
    }

    public ClearEditText(Context context) {
        super(context, null);
        setRightIcon(hasFocus());
        addTextChangedListener(new a(this, 19));
    }

    public ClearEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.editTextStyle);
        setRightIcon(hasFocus());
        addTextChangedListener(new a(this, 19));
    }

    public ClearEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setRightIcon(hasFocus());
        addTextChangedListener(new a(this, 19));
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            setText(this.a);
            clearFocus();
            setEnabled(false);
            ahf.b(getContext()).hideSoftInputFromWindow(getWindowToken(), 2);
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    protected void setRightIcon(boolean z) {
        Drawable drawable = getResources().getDrawable(com.harman.hkconnect.R.drawable.small_close_icon);
        Drawable drawable2 = z ? drawable : getResources().getDrawable(com.harman.hkconnect.R.drawable.edit_icon);
        drawable2.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], drawable2, getCompoundDrawables()[3]);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            this.a = getText().toString();
        } else {
            setEnabled(false);
        }
        setRightIcon(z);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (!isEnabled()) {
                requestFocus();
                requestFocusFromTouch();
                mo.a.post(new Runnable() { // from class: com.harman.hkconnect.ui.custom.ClearEditText.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ClearEditText.this.setSelection(ClearEditText.this.length());
                        ClearEditText.this.setEnabled(true);
                        ClearEditText.super.onTouchEvent(motionEvent);
                    }
                });
            } else if (a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                setText("");
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean a(int i, int i2) {
        Rect bounds = getCompoundDrawables()[2].getBounds();
        int width = getWidth();
        return new Rect((width - (bounds.right - bounds.left)) - getResources().getDimensionPixelSize(com.harman.hkconnect.R.dimen.clearEditText_clearPadding), 0, width, getHeight()).contains(i, i2);
    }
}
