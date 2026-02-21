package defpackage;

import android.content.Context;
import android.widget.AbsListView;

/* JADX INFO: loaded from: classes.dex */
public class bcz implements AbsListView.OnScrollListener {
    private Context a;

    public bcz(Context context) {
        this.a = context;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 || i == 1) {
            bif.a(this.a).b((Object) "tidal");
        } else {
            bif.a(this.a).a((Object) "tidal");
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
