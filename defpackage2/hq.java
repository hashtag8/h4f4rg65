package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import defpackage.id;
import defpackage.ie;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class hq implements id {
    protected Context a;
    protected Context b;
    protected hw c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    protected ie f;
    private id.a g;
    private int h;
    private int i;
    private int j;

    public abstract void a(hy hyVar, ie.a aVar);

    public hq(Context context, int i, int i2) {
        this.a = context;
        this.d = LayoutInflater.from(context);
        this.h = i;
        this.i = i2;
    }

    @Override // defpackage.id
    public void a(Context context, hw hwVar) {
        this.b = context;
        this.e = LayoutInflater.from(this.b);
        this.c = hwVar;
    }

    public ie a(ViewGroup viewGroup) {
        if (this.f == null) {
            this.f = (ie) this.d.inflate(this.h, viewGroup, false);
            this.f.a(this.c);
            b(true);
        }
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.id
    public void b(boolean z) {
        int i;
        int i2;
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup != null) {
            if (this.c != null) {
                this.c.j();
                ArrayList<hy> arrayListI = this.c.i();
                int size = arrayListI.size();
                int i3 = 0;
                i = 0;
                while (i3 < size) {
                    hy hyVar = arrayListI.get(i3);
                    if (a(i, hyVar)) {
                        View childAt = viewGroup.getChildAt(i);
                        hy itemData = childAt instanceof ie.a ? ((ie.a) childAt).getItemData() : null;
                        View viewA = a(hyVar, childAt, viewGroup);
                        if (hyVar != itemData) {
                            viewA.setPressed(false);
                            viewA.jumpDrawablesToCurrentState();
                        }
                        if (viewA != childAt) {
                            a(viewA, i);
                        }
                        i2 = i + 1;
                    } else {
                        i2 = i;
                    }
                    i3++;
                    i = i2;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    protected void a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f).addView(view, i);
    }

    protected boolean a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    @Override // defpackage.id
    public void a(id.a aVar) {
        this.g = aVar;
    }

    public id.a a() {
        return this.g;
    }

    public ie.a b(ViewGroup viewGroup) {
        return (ie.a) this.d.inflate(this.i, viewGroup, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View a(hy hyVar, View view, ViewGroup viewGroup) {
        ie.a aVarB;
        if (view instanceof ie.a) {
            aVarB = (ie.a) view;
        } else {
            aVarB = b(viewGroup);
        }
        a(hyVar, aVarB);
        return (View) aVarB;
    }

    public boolean a(int i, hy hyVar) {
        return true;
    }

    @Override // defpackage.id
    public void a(hw hwVar, boolean z) {
        if (this.g != null) {
            this.g.a(hwVar, z);
        }
    }

    @Override // defpackage.id
    public boolean a(ij ijVar) {
        if (this.g != null) {
            return this.g.a(ijVar);
        }
        return false;
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

    public void a(int i) {
        this.j = i;
    }
}
