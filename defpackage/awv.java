package defpackage;

import android.content.Context;
import android.widget.AbsListView;

/* JADX INFO: loaded from: classes.dex */
public class awv implements AbsListView.OnScrollListener {
    private Context a;

    public awv(Context context) {
        this.a = context;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 || i == 1) {
            bif.a(this.a).b((Object) "juke");
        } else {
            bif.a(this.a).a((Object) "juke");
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
