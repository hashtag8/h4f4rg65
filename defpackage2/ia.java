package defpackage;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import defpackage.ej;
import defpackage.hz;

/* JADX INFO: loaded from: classes.dex */
class ia extends hz {
    ia(Context context, dd ddVar) {
        super(context, ddVar);
    }

    @Override // defpackage.hz
    hz.a a(ActionProvider actionProvider) {
        return new a(this.a, actionProvider);
    }

    class a extends hz.a implements ActionProvider.VisibilityListener {
        ej.b c;

        public a(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // defpackage.ej
        public View a(MenuItem menuItem) {
            return this.a.onCreateActionView(menuItem);
        }

        @Override // defpackage.ej
        public boolean b() {
            return this.a.overridesItemVisibility();
        }

        @Override // defpackage.ej
        public boolean c() {
            return this.a.isVisible();
        }

        @Override // defpackage.ej
        public void a(ej.b bVar) {
            this.c = bVar;
            ActionProvider actionProvider = this.a;
            if (bVar == null) {
                this = null;
            }
            actionProvider.setVisibilityListener(this);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.c != null) {
                this.c.a(z);
            }
        }
    }
}
