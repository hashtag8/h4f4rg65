package com.harman.hkconnect.ui.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.TextView;
import defpackage.agu;
import defpackage.aib;
import defpackage.mm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TypefaceTextView extends TextView {
    public TypefaceTextView(Context context) {
        super(context);
    }

    public TypefaceTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public TypefaceTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aib.a.TypefaceTextView);
            b(context, attributeSet);
            if (typedArrayObtainStyledAttributes.getBoolean(0, false)) {
                a();
            }
        }
    }

    private void a() {
        getPaint().setFlags(8);
        getPaint().setAntiAlias(true);
    }

    static class a {
        public final boolean a;
        public final List<Object> b;
        public final List<Object> c;

        public static a a(List<Object> list, List<Object> list2) {
            return new a(true, list, list2);
        }

        public static a a() {
            return new a(false, null, null);
        }

        private a(boolean z, List<Object> list, List<Object> list2) {
            this.a = z;
            this.b = list;
            this.c = list2;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (IndexOutOfBoundsException e) {
            a(i, i2);
        }
    }

    private void a(int i, int i2) {
        CharSequence text = getText();
        if (text instanceof Spanned) {
            a(new SpannableStringBuilder(text), i, i2);
        } else {
            mm.b("The text isn't a Spanned", new Object[0]);
            b(i, i2);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        a aVarB = b(spannableStringBuilder, i, i2);
        if (aVarB.a) {
            a(i, i2, spannableStringBuilder, aVarB);
        } else {
            b(i, i2);
        }
        mm.b("fixSpannedWithSpaces() duration in ms: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
    }

    private a b(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), Object.class);
        ArrayList arrayList = new ArrayList(spans.length);
        ArrayList arrayList2 = new ArrayList(spans.length);
        for (Object obj : spans) {
            int spanStart = spannableStringBuilder.getSpanStart(obj);
            if (a(spannableStringBuilder, spanStart - 1)) {
                spannableStringBuilder.insert(spanStart, " ");
                arrayList.add(obj);
            }
            int spanEnd = spannableStringBuilder.getSpanEnd(obj);
            if (a(spannableStringBuilder, spanEnd)) {
                spannableStringBuilder.insert(spanEnd, " ");
                arrayList2.add(obj);
            }
            try {
                a((CharSequence) spannableStringBuilder, i, i2);
                return a.a(arrayList, arrayList2);
            } catch (IndexOutOfBoundsException e) {
            }
        }
        mm.b("Could not fix the Spanned by adding spaces around spans", new Object[0]);
        return a.a();
    }

    private boolean a(CharSequence charSequence, int i) {
        return charSequence.charAt(i) != ' ';
    }

    @SuppressLint({"WrongCall"})
    private void a(CharSequence charSequence, int i, int i2) {
        setText(charSequence);
        super.onMeasure(i, i2);
    }

    @SuppressLint({"WrongCall"})
    private void a(int i, int i2, SpannableStringBuilder spannableStringBuilder, a aVar) {
        Iterator<Object> it = aVar.c.iterator();
        while (it.hasNext()) {
            int spanEnd = spannableStringBuilder.getSpanEnd(it.next());
            spannableStringBuilder.delete(spanEnd, spanEnd + 1);
            try {
                a((CharSequence) spannableStringBuilder, i, i2);
            } catch (IndexOutOfBoundsException e) {
                spannableStringBuilder.insert(spanEnd, " ");
            }
        }
        Iterator<Object> it2 = aVar.b.iterator();
        boolean z = true;
        while (it2.hasNext()) {
            int spanStart = spannableStringBuilder.getSpanStart(it2.next());
            spannableStringBuilder.delete(spanStart - 1, spanStart);
            try {
                a((CharSequence) spannableStringBuilder, i, i2);
                z = false;
            } catch (IndexOutOfBoundsException e2) {
                spannableStringBuilder.insert(spanStart - 1, " ");
                z = true;
            }
        }
        if (z) {
            setText(spannableStringBuilder);
            super.onMeasure(i, i2);
        }
    }

    private void b(int i, int i2) {
        mm.b("Fallback to unspanned text", new Object[0]);
        a(getText().toString(), i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        try {
            super.getFocusedRect(rect);
        } catch (RuntimeException e) {
            mm.e("Could not getFocusedRect on %s, defaulting to drawing rect", this, e);
            getDrawingRect(rect);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (RuntimeException e) {
            mm.e("Could not draw %s", this, e);
        }
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aib.a.TypefaceTextView);
        setTypeface(agu.a(context, typedArrayObtainStyledAttributes.getInt(1, 0), attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "textStyle", 0)));
        typedArrayObtainStyledAttributes.recycle();
    }
}
