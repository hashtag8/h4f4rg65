package defpackage;

import android.graphics.Outline;
import android.support.v7.widget.ActionBarContainer;

/* JADX INFO: loaded from: classes.dex */
public class in extends im {
    public in(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.a.d) {
            if (this.a.c != null) {
                this.a.c.getOutline(outline);
            }
        } else if (this.a.a != null) {
            this.a.a.getOutline(outline);
        }
    }
}
