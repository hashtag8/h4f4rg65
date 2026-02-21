package defpackage;

import android.support.v7.view.menu.ListMenuItemView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import defpackage.ha;
import defpackage.ie;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class hv extends BaseAdapter {
    static final int a = ha.g.abc_popup_menu_item_layout;
    hw b;
    private int c = -1;
    private boolean d;
    private final boolean e;
    private final LayoutInflater f;

    public hv(hw hwVar, LayoutInflater layoutInflater, boolean z) {
        this.e = z;
        this.f = layoutInflater;
        this.b = hwVar;
        b();
    }

    public void a(boolean z) {
        this.d = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<hy> arrayListL = this.e ? this.b.l() : this.b.i();
        if (this.c < 0) {
            return arrayListL.size();
        }
        return arrayListL.size() - 1;
    }

    public hw a() {
        return this.b;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public hy getItem(int i) {
        ArrayList<hy> arrayListL = this.e ? this.b.l() : this.b.i();
        if (this.c >= 0 && i >= this.c) {
            i++;
        }
        return arrayListL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = view == null ? this.f.inflate(a, viewGroup, false) : view;
        ie.a aVar = (ie.a) viewInflate;
        if (this.d) {
            ((ListMenuItemView) viewInflate).setForceShowIcon(true);
        }
        aVar.a(getItem(i), 0);
        return viewInflate;
    }

    void b() {
        hy hyVarR = this.b.r();
        if (hyVarR != null) {
            ArrayList<hy> arrayListL = this.b.l();
            int size = arrayListL.size();
            for (int i = 0; i < size; i++) {
                if (arrayListL.get(i) == hyVarR) {
                    this.c = i;
                    return;
                }
            }
        }
        this.c = -1;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        b();
        super.notifyDataSetChanged();
    }
}
