package defpackage;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class hr<T> extends hs<T> {
    final Context a;
    private Map<dd, MenuItem> c;
    private Map<de, SubMenu> d;

    hr(Context context, T t) {
        super(t);
        this.a = context;
    }

    final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof dd)) {
            return menuItem;
        }
        dd ddVar = (dd) menuItem;
        if (this.c == null) {
            this.c = new du();
        }
        MenuItem menuItem2 = this.c.get(menuItem);
        if (menuItem2 == null) {
            MenuItem menuItemA = Cif.a(this.a, ddVar);
            this.c.put(ddVar, menuItemA);
            return menuItemA;
        }
        return menuItem2;
    }

    final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof de)) {
            return subMenu;
        }
        de deVar = (de) subMenu;
        if (this.d == null) {
            this.d = new du();
        }
        SubMenu subMenu2 = this.d.get(deVar);
        if (subMenu2 == null) {
            SubMenu subMenuA = Cif.a(this.a, deVar);
            this.d.put(deVar, subMenuA);
            return subMenuA;
        }
        return subMenu2;
    }

    final void a() {
        if (this.c != null) {
            this.c.clear();
        }
        if (this.d != null) {
            this.d.clear();
        }
    }

    final void a(int i) {
        if (this.c != null) {
            Iterator<dd> it = this.c.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    final void b(int i) {
        if (this.c != null) {
            Iterator<dd> it = this.c.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
