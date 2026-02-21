package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import defpackage.cy;

/* JADX INFO: loaded from: classes.dex */
class cz extends cy {
    cz(Drawable drawable) {
        super(drawable);
    }

    cz(cy.a aVar, Resources resources) {
        super(aVar, resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.c.setAutoMirrored(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    @Override // defpackage.cy
    cy.a b() {
        return new a(this.b, null);
    }

    static class a extends cy.a {
        a(cy.a aVar, Resources resources) {
            super(aVar, resources);
        }

        @Override // cy.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new cz(this, resources);
        }
    }
}
