package defpackage;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import defpackage.hh;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class hl extends ActionMode {
    final Context a;
    final hh b;

    public hl(Context context, hh hhVar) {
        this.a = context;
        this.b = hhVar;
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.b.j();
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.b.a(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.b.b(charSequence);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.b.a(charSequence);
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.b.d();
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.b.c();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return Cif.a(this.a, (dc) this.b.b());
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.b.f();
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.b.a(i);
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.b.g();
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.b.b(i);
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.b.i();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.b.a(view);
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.b.a();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.b.k();
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.b.a(z);
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.b.h();
    }

    public static class a implements hh.a {
        final ActionMode.Callback a;
        final Context b;
        final ArrayList<hl> c = new ArrayList<>();
        final eg<Menu, Menu> d = new eg<>();

        public a(Context context, ActionMode.Callback callback) {
            this.b = context;
            this.a = callback;
        }

        @Override // hh.a
        public boolean a(hh hhVar, Menu menu) {
            return this.a.onCreateActionMode(b(hhVar), a(menu));
        }

        @Override // hh.a
        public boolean b(hh hhVar, Menu menu) {
            return this.a.onPrepareActionMode(b(hhVar), a(menu));
        }

        @Override // hh.a
        public boolean a(hh hhVar, MenuItem menuItem) {
            return this.a.onActionItemClicked(b(hhVar), Cif.a(this.b, (dd) menuItem));
        }

        @Override // hh.a
        public void a(hh hhVar) {
            this.a.onDestroyActionMode(b(hhVar));
        }

        private Menu a(Menu menu) {
            Menu menu2 = this.d.get(menu);
            if (menu2 == null) {
                Menu menuA = Cif.a(this.b, (dc) menu);
                this.d.put(menu, menuA);
                return menuA;
            }
            return menu2;
        }

        public ActionMode b(hh hhVar) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                hl hlVar = this.c.get(i);
                if (hlVar != null && hlVar.b == hhVar) {
                    return hlVar;
                }
            }
            hl hlVar2 = new hl(this.b, hhVar);
            this.c.add(hlVar2);
            return hlVar2;
        }
    }
}
