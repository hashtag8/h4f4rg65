package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.support.v7.view.menu.ListMenuItemView;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class kd extends ka implements kc {
    private static Method a;
    private kc b;

    static {
        try {
            a = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
        } catch (NoSuchMethodException e) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public kd(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // defpackage.ka
    jt a(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.g.setEnterTransition((Transition) obj);
        }
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.g.setExitTransition((Transition) obj);
        }
    }

    public void a(kc kcVar) {
        this.b = kcVar;
    }

    public void c(boolean z) {
        if (a != null) {
            try {
                a.invoke(this.g, Boolean.valueOf(z));
            } catch (Exception e) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    @Override // defpackage.kc
    public void b(hw hwVar, MenuItem menuItem) {
        if (this.b != null) {
            this.b.b(hwVar, menuItem);
        }
    }

    @Override // defpackage.kc
    public void a(hw hwVar, MenuItem menuItem) {
        if (this.b != null) {
            this.b.a(hwVar, menuItem);
        }
    }

    public static class a extends jt {
        final int g;
        final int h;
        private kc i;
        private MenuItem j;

        @Override // defpackage.jt
        public /* bridge */ /* synthetic */ boolean a(MotionEvent motionEvent, int i) {
            return super.a(motionEvent, i);
        }

        @Override // defpackage.jt, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // defpackage.jt, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // defpackage.jt, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // defpackage.jt, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 17 && 1 == configuration.getLayoutDirection()) {
                this.g = 21;
                this.h = 22;
            } else {
                this.g = 22;
                this.h = 21;
            }
        }

        public void setHoverListener(kc kcVar) {
            this.i = kcVar;
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.g) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView != null && i == this.h) {
                setSelection(-1);
                ((hv) getAdapter()).a().a(false);
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }

        @Override // android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int headersCount;
            hv hvVar;
            hy item;
            int iPointToPosition;
            int i;
            if (this.i != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    hvVar = (hv) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    hvVar = (hv) adapter;
                }
                if (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i = iPointToPosition - headersCount) < 0 || i >= hvVar.getCount()) {
                    item = null;
                } else {
                    item = hvVar.getItem(i);
                }
                MenuItem menuItem = this.j;
                if (menuItem != item) {
                    hw hwVarA = hvVar.a();
                    if (menuItem != null) {
                        this.i.a(hwVarA, menuItem);
                    }
                    this.j = item;
                    if (item != null) {
                        this.i.b(hwVarA, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }
    }
}
