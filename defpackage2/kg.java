package defpackage;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public class kg extends ei {
    final RecyclerView a;
    final ei c = new a(this);

    public kg(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    boolean b() {
        return this.a.w();
    }

    @Override // defpackage.ei
    public boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        if (!b() && this.a.getLayoutManager() != null) {
            return this.a.getLayoutManager().a(i, bundle);
        }
        return false;
    }

    @Override // defpackage.ei
    public void a(View view, fk fkVar) {
        super.a(view, fkVar);
        fkVar.a((CharSequence) RecyclerView.class.getName());
        if (!b() && this.a.getLayoutManager() != null) {
            this.a.getLayoutManager().a(fkVar);
        }
    }

    @Override // defpackage.ei
    public void a(View view, AccessibilityEvent accessibilityEvent) {
        super.a(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !b()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().a(accessibilityEvent);
            }
        }
    }

    public ei c() {
        return this.c;
    }

    public static class a extends ei {
        final kg a;

        public a(kg kgVar) {
            this.a = kgVar;
        }

        @Override // defpackage.ei
        public void a(View view, fk fkVar) {
            super.a(view, fkVar);
            if (!this.a.b() && this.a.a.getLayoutManager() != null) {
                this.a.a.getLayoutManager().a(view, fkVar);
            }
        }

        @Override // defpackage.ei
        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            if (!this.a.b() && this.a.a.getLayoutManager() != null) {
                return this.a.a.getLayoutManager().a(view, i, bundle);
            }
            return false;
        }
    }
}
