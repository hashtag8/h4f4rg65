package defpackage;

import android.database.DataSetObserver;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import com.harman.hkconnect.R;
import com.harman.hkconnect.ui.custom.AnimationGridView;
import in.srain.cube.views.GridViewWithHeaderAndFooter;

/* JADX INFO: loaded from: classes.dex */
public class arp {
    private View a;
    private int b;
    private ListView c;
    private GridViewWithHeaderAndFooter d;

    public arp(ListView listView) {
        a(listView);
        this.c = listView;
        this.b = listView.getDividerHeight();
        if (listView.getFooterViewsCount() == 0) {
            listView.addFooterView(this.a, null, false);
        }
    }

    public arp(GridViewWithHeaderAndFooter gridViewWithHeaderAndFooter) {
        a(gridViewWithHeaderAndFooter);
        this.d = gridViewWithHeaderAndFooter;
        gridViewWithHeaderAndFooter.b(this.a, null, false);
    }

    public arp(AnimationGridView animationGridView) {
        a(animationGridView);
        this.d = animationGridView;
        animationGridView.b(this.a, null, false);
    }

    private void a(View view) {
        this.a = new View(view.getContext());
        this.a.setBackgroundColor(16711680);
        this.a.setLayoutParams(new AbsListView.LayoutParams(-1, view.getContext().getResources().getDimensionPixelSize(R.dimen.bottom_player_height)));
    }

    public void a() {
        final Adapter adapter = d().getAdapter();
        brw.a(adapter, "adapter", new Object[0]);
        if (adapter.getCount() - e() == 0) {
            b();
        }
        adapter.registerDataSetObserver(new DataSetObserver() { // from class: arp.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                if (adapter.getCount() - arp.this.e() == 0) {
                    arp.this.b();
                } else {
                    arp.this.c();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.c != null) {
            this.c.setDividerHeight(0);
        }
        this.a.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.c != null) {
            this.c.setDividerHeight(this.b);
        }
        this.a.setVisibility(0);
    }

    private AdapterView d() {
        return this.c != null ? this.c : this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e() {
        return this.c != null ? this.c.getFooterViewsCount() : this.d.getFooterViewCount();
    }
}
