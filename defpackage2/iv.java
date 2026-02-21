package defpackage;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

/* JADX INFO: loaded from: classes.dex */
public class iv extends CheckedTextView {
    private static final int[] a = {R.attr.checkMark};
    private final jk b;

    public iv(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    public iv(Context context, AttributeSet attributeSet, int i) {
        super(kp.a(context), attributeSet, i);
        this.b = jk.a(this);
        this.b.a(attributeSet, i);
        this.b.a();
        ks ksVarA = ks.a(getContext(), attributeSet, a, i, 0);
        setCheckMarkDrawable(ksVarA.a(0));
        ksVarA.a();
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(hc.b(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.b != null) {
            this.b.a(context, i);
        }
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.b != null) {
            this.b.a();
        }
    }
}
