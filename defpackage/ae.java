package defpackage;

import android.widget.ImageButton;

/* JADX INFO: loaded from: classes.dex */
public class ae extends ImageButton {
    private int a;

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        a(i, true);
    }

    final void a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.a = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.a;
    }
}
