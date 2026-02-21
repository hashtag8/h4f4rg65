package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import defpackage.hw;

/* JADX INFO: loaded from: classes.dex */
public class ij extends hw implements SubMenu {
    private hw d;
    private hy e;

    public ij(Context context, hw hwVar, hy hyVar) {
        super(context);
        this.d = hwVar;
        this.e = hyVar;
    }

    @Override // defpackage.hw, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.d.setQwertyMode(z);
    }

    @Override // defpackage.hw
    public boolean b() {
        return this.d.b();
    }

    @Override // defpackage.hw
    public boolean c() {
        return this.d.c();
    }

    public Menu s() {
        return this.d;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.e;
    }

    @Override // defpackage.hw
    public void a(hw.a aVar) {
        this.d.a(aVar);
    }

    @Override // defpackage.hw
    public hw p() {
        return this.d.p();
    }

    @Override // defpackage.hw
    boolean a(hw hwVar, MenuItem menuItem) {
        return super.a(hwVar, menuItem) || this.d.a(hwVar, menuItem);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.e.setIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.e.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.a(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.e(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.a(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.d(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.a(view);
    }

    @Override // defpackage.hw
    public boolean c(hy hyVar) {
        return this.d.c(hyVar);
    }

    @Override // defpackage.hw
    public boolean d(hy hyVar) {
        return this.d.d(hyVar);
    }

    @Override // defpackage.hw
    public String a() {
        int itemId = this.e != null ? this.e.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.a() + ":" + itemId;
    }
}
