package defpackage;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes.dex */
@yx
public class sb extends FrameLayout implements View.OnClickListener {
    private final ImageButton a;
    private final sd b;

    public sb(Context context, int i, sd sdVar) {
        super(context);
        this.b = sdVar;
        setOnClickListener(this);
        this.a = new ImageButton(context);
        this.a.setImageResource(R.drawable.btn_dialog);
        this.a.setBackgroundColor(0);
        this.a.setOnClickListener(this);
        this.a.setPadding(0, 0, 0, 0);
        this.a.setContentDescription("Interstitial close button");
        int iA = rj.a().a(context, i);
        addView(this.a, new FrameLayout.LayoutParams(iA, iA, 17));
    }

    public void a(boolean z, boolean z2) {
        if (!z2) {
            this.a.setVisibility(0);
        } else if (z) {
            this.a.setVisibility(4);
        } else {
            this.a.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b != null) {
            this.b.d();
        }
    }
}
