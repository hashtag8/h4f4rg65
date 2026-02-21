package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.support.v7.view.menu.ExpandedMenuView;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import defpackage.ha;
import defpackage.id;
import defpackage.ie;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class hu implements AdapterView.OnItemClickListener, id {
    Context a;
    LayoutInflater b;
    hw c;
    ExpandedMenuView d;
    int e;
    int f;
    int g;
    a h;
    private id.a i;

    public hu(Context context, int i) {
        this(i, 0);
        this.a = context;
        this.b = LayoutInflater.from(this.a);
    }

    public hu(int i, int i2) {
        this.g = i;
        this.f = i2;
    }

    @Override // defpackage.id
    public void a(Context context, hw hwVar) {
        if (this.f != 0) {
            this.a = new ContextThemeWrapper(context, this.f);
            this.b = LayoutInflater.from(this.a);
        } else if (this.a != null) {
            this.a = context;
            if (this.b == null) {
                this.b = LayoutInflater.from(this.a);
            }
        }
        this.c = hwVar;
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    public ie a(ViewGroup viewGroup) {
        if (this.d == null) {
            this.d = (ExpandedMenuView) this.b.inflate(ha.g.abc_expanded_menu_layout, viewGroup, false);
            if (this.h == null) {
                this.h = new a();
            }
            this.d.setAdapter((ListAdapter) this.h);
            this.d.setOnItemClickListener(this);
        }
        return this.d;
    }

    public ListAdapter a() {
        if (this.h == null) {
            this.h = new a();
        }
        return this.h;
    }

    @Override // defpackage.id
    public void b(boolean z) {
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    @Override // defpackage.id
    public void a(id.a aVar) {
        this.i = aVar;
    }

    @Override // defpackage.id
    public boolean a(ij ijVar) {
        if (!ijVar.hasVisibleItems()) {
            return false;
        }
        new hx(ijVar).a((IBinder) null);
        if (this.i != null) {
            this.i.a(ijVar);
        }
        return true;
    }

    @Override // defpackage.id
    public void a(hw hwVar, boolean z) {
        if (this.i != null) {
            this.i.a(hwVar, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.c.a(this.h.getItem(i), this, 0);
    }

    @Override // defpackage.id
    public boolean b() {
        return false;
    }

    @Override // defpackage.id
    public boolean a(hw hwVar, hy hyVar) {
        return false;
    }

    @Override // defpackage.id
    public boolean b(hw hwVar, hy hyVar) {
        return false;
    }

    class a extends BaseAdapter {
        private int b = -1;

        public a() {
            a();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = hu.this.c.l().size() - hu.this.e;
            return this.b < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public hy getItem(int i) {
            ArrayList<hy> arrayListL = hu.this.c.l();
            int i2 = hu.this.e + i;
            if (this.b >= 0 && i2 >= this.b) {
                i2++;
            }
            return arrayListL.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate = view == null ? hu.this.b.inflate(hu.this.g, viewGroup, false) : view;
            ((ie.a) viewInflate).a(getItem(i), 0);
            return viewInflate;
        }

        void a() {
            hy hyVarR = hu.this.c.r();
            if (hyVarR != null) {
                ArrayList<hy> arrayListL = hu.this.c.l();
                int size = arrayListL.size();
                for (int i = 0; i < size; i++) {
                    if (arrayListL.get(i) == hyVarR) {
                        this.b = i;
                        return;
                    }
                }
            }
            this.b = -1;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }
}
