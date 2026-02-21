package defpackage;

import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public class fz extends ft {
    private final ListView f;

    public fz(ListView listView) {
        super(listView);
        this.f = listView;
    }

    @Override // defpackage.ft
    public void a(int i, int i2) {
        ga.a(this.f, i2);
    }

    @Override // defpackage.ft
    public boolean e(int i) {
        return false;
    }

    @Override // defpackage.ft
    public boolean f(int i) {
        ListView listView = this.f;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
