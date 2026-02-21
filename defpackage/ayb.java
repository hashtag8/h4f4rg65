package defpackage;

import android.content.Context;
import android.widget.AbsListView;

/* JADX INFO: loaded from: classes.dex */
public class ayb implements AbsListView.OnScrollListener {
    private final Context a;

    public ayb(Context context) {
        this.a = context;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 || i == 1) {
            bif.a(this.a).b((Object) "mixradio");
        } else {
            bif.a(this.a).a((Object) "mixradio");
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
