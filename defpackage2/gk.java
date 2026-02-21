package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import defpackage.ch;
import defpackage.hh;

/* JADX INFO: loaded from: classes.dex */
public class gk extends ba implements ch.a, gl {
    private gm m;
    private int n = 0;
    private Resources o;

    @Override // defpackage.ba, defpackage.cg, android.app.Activity
    public void onCreate(Bundle bundle) {
        gm gmVarJ = j();
        gmVarJ.h();
        gmVarJ.a(bundle);
        if (gmVarJ.i() && this.n != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.n, false);
            } else {
                setTheme(this.n);
            }
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        this.n = i;
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        j().b(bundle);
    }

    public gi g() {
        return j().a();
    }

    public void a(Toolbar toolbar) {
        j().a(toolbar);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return j().b();
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        j().b(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        j().a(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        j().a(view, layoutParams);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        j().b(view, layoutParams);
    }

    @Override // defpackage.ba, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j().a(configuration);
        if (this.o != null) {
            this.o.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    @Override // defpackage.ba, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        j().e();
    }

    @Override // defpackage.ba, android.app.Activity
    protected void onStart() {
        super.onStart();
        j().c();
    }

    @Override // defpackage.ba, android.app.Activity
    protected void onStop() {
        super.onStop();
        j().d();
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        return (T) j().a(i);
    }

    @Override // defpackage.ba, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        gi giVarG = g();
        if (menuItem.getItemId() == 16908332 && giVarG != null && (giVarG.b() & 4) != 0) {
            return h();
        }
        return false;
    }

    @Override // defpackage.ba, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        j().g();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        j().a(charSequence);
    }

    @Override // defpackage.ba
    public void d() {
        j().f();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        j().f();
    }

    @Override // defpackage.gl
    public void a(hh hhVar) {
    }

    @Override // defpackage.gl
    public void b(hh hhVar) {
    }

    @Override // defpackage.gl
    public hh a(hh.a aVar) {
        return null;
    }

    public void a(ch chVar) {
        chVar.a((Activity) this);
    }

    public void b(ch chVar) {
    }

    public boolean h() {
        Intent intentA_ = a_();
        if (intentA_ != null) {
            if (a(intentA_)) {
                ch chVarA = ch.a((Context) this);
                a(chVarA);
                b(chVarA);
                chVarA.a();
                try {
                    at.a(this);
                } catch (IllegalStateException e) {
                    finish();
                }
            } else {
                b(intentA_);
            }
            return true;
        }
        return false;
    }

    @Override // ch.a
    public Intent a_() {
        return bo.a(this);
    }

    public boolean a(Intent intent) {
        return bo.a(this, intent);
    }

    public void b(Intent intent) {
        bo.b(this, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        i();
    }

    @Deprecated
    public void i() {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // defpackage.ba, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // defpackage.ba, defpackage.cg, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        j().c(bundle);
    }

    public gm j() {
        if (this.m == null) {
            this.m = gm.a(this, this);
        }
        return this.m;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        gi giVarG = g();
        if (keyCode == 82 && giVarG != null && giVarG.a(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.o == null && kx.a()) {
            this.o = new kx(this, super.getResources());
        }
        return this.o == null ? super.getResources() : this.o;
    }

    private boolean a(int i, KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        gi giVarG = g();
        if (getWindow().hasFeature(0)) {
            if (giVarG == null || !giVarG.d()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        gi giVarG = g();
        if (getWindow().hasFeature(0)) {
            if (giVarG == null || !giVarG.e()) {
                super.closeOptionsMenu();
            }
        }
    }
}
