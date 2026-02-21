package defpackage;

import android.content.Context;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import defpackage.hh;
import defpackage.hw;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class hk extends hh implements hw.a {
    private Context a;
    private ActionBarContextView b;
    private hh.a c;
    private WeakReference<View> d;
    private boolean e;
    private boolean f;
    private hw g;

    public hk(Context context, ActionBarContextView actionBarContextView, hh.a aVar, boolean z) {
        this.a = context;
        this.b = actionBarContextView;
        this.c = aVar;
        this.g = new hw(actionBarContextView.getContext()).a(1);
        this.g.a(this);
        this.f = z;
    }

    @Override // defpackage.hh
    public void b(CharSequence charSequence) {
        this.b.setTitle(charSequence);
    }

    @Override // defpackage.hh
    public void a(CharSequence charSequence) {
        this.b.setSubtitle(charSequence);
    }

    @Override // defpackage.hh
    public void a(int i) {
        b(this.a.getString(i));
    }

    @Override // defpackage.hh
    public void b(int i) {
        a((CharSequence) this.a.getString(i));
    }

    @Override // defpackage.hh
    public void a(boolean z) {
        super.a(z);
        this.b.setTitleOptional(z);
    }

    @Override // defpackage.hh
    public boolean h() {
        return this.b.d();
    }

    @Override // defpackage.hh
    public void a(View view) {
        this.b.setCustomView(view);
        this.d = view != null ? new WeakReference<>(view) : null;
    }

    @Override // defpackage.hh
    public void d() {
        this.c.b(this, this.g);
    }

    @Override // defpackage.hh
    public void c() {
        if (!this.e) {
            this.e = true;
            this.b.sendAccessibilityEvent(32);
            this.c.a(this);
        }
    }

    @Override // defpackage.hh
    public Menu b() {
        return this.g;
    }

    @Override // defpackage.hh
    public CharSequence f() {
        return this.b.getTitle();
    }

    @Override // defpackage.hh
    public CharSequence g() {
        return this.b.getSubtitle();
    }

    @Override // defpackage.hh
    public View i() {
        if (this.d != null) {
            return this.d.get();
        }
        return null;
    }

    @Override // defpackage.hh
    public MenuInflater a() {
        return new hm(this.b.getContext());
    }

    @Override // hw.a
    public boolean a(hw hwVar, MenuItem menuItem) {
        return this.c.a(this, menuItem);
    }

    @Override // hw.a
    public void a(hw hwVar) {
        d();
        this.b.a();
    }
}
